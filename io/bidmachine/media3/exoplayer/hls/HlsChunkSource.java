package io.bidmachine.media3.exoplayer.hls;

import android.net.Uri;
import android.os.SystemClock;
import android.util.Pair;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;
import com.google.common.primitives.Ints;
import io.bidmachine.media3.common.Format;
import io.bidmachine.media3.common.TrackGroup;
import io.bidmachine.media3.common.util.Assertions;
import io.bidmachine.media3.common.util.UriUtil;
import io.bidmachine.media3.common.util.Util;
import io.bidmachine.media3.datasource.DataSource;
import io.bidmachine.media3.datasource.DataSpec;
import io.bidmachine.media3.datasource.TransferListener;
import io.bidmachine.media3.exoplayer.LoadingInfo;
import io.bidmachine.media3.exoplayer.SeekParameters;
import io.bidmachine.media3.exoplayer.analytics.PlayerId;
import io.bidmachine.media3.exoplayer.hls.playlist.HlsMediaPlaylist;
import io.bidmachine.media3.exoplayer.hls.playlist.HlsPlaylistTracker;
import io.bidmachine.media3.exoplayer.source.BehindLiveWindowException;
import io.bidmachine.media3.exoplayer.source.chunk.BaseMediaChunkIterator;
import io.bidmachine.media3.exoplayer.source.chunk.Chunk;
import io.bidmachine.media3.exoplayer.source.chunk.DataChunk;
import io.bidmachine.media3.exoplayer.source.chunk.MediaChunk;
import io.bidmachine.media3.exoplayer.source.chunk.MediaChunkIterator;
import io.bidmachine.media3.exoplayer.trackselection.BaseTrackSelection;
import io.bidmachine.media3.exoplayer.trackselection.ExoTrackSelection;
import io.bidmachine.media3.exoplayer.upstream.CmcdConfiguration;
import io.bidmachine.media3.exoplayer.upstream.CmcdData;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/* loaded from: classes7.dex */
class HlsChunkSource {
    public static final int CHUNK_PUBLICATION_STATE_PRELOAD = 0;
    public static final int CHUNK_PUBLICATION_STATE_PUBLISHED = 1;
    public static final int CHUNK_PUBLICATION_STATE_REMOVED = 2;
    private static final int KEY_CACHE_SIZE = 4;
    private final CmcdConfiguration cmcdConfiguration;
    private final DataSource encryptionDataSource;
    private Uri expectedPlaylistUrl;
    private final HlsExtractorFactory extractorFactory;
    private IOException fatalError;
    private boolean independentSegments;
    private boolean isPrimaryTimestampSource;
    private final DataSource mediaDataSource;
    private final List<Format> muxedCaptionFormats;
    private final PlayerId playerId;
    private final Format[] playlistFormats;
    private final HlsPlaylistTracker playlistTracker;
    private final Uri[] playlistUrls;
    private boolean seenExpectedPlaylistError;
    private final long timestampAdjusterInitializationTimeoutMs;
    private final TimestampAdjusterProvider timestampAdjusterProvider;
    private final TrackGroup trackGroup;
    private ExoTrackSelection trackSelection;
    private long lastChunkRequestRealtimeMs = -9223372036854775807L;
    private final FullSegmentEncryptionKeyCache keyCache = new FullSegmentEncryptionKeyCache(4);
    private byte[] scratchSpace = Util.EMPTY_BYTE_ARRAY;
    private long liveEdgeInPeriodTimeUs = -9223372036854775807L;

    public static final class HlsChunkHolder {
        public Chunk chunk;
        public boolean endOfStream;
        public Uri playlistUrl;

        public HlsChunkHolder() {
            clear();
        }

        public void clear() {
            this.chunk = null;
            this.endOfStream = false;
            this.playlistUrl = null;
        }
    }

    public HlsChunkSource(HlsExtractorFactory hlsExtractorFactory, HlsPlaylistTracker hlsPlaylistTracker, Uri[] uriArr, Format[] formatArr, HlsDataSourceFactory hlsDataSourceFactory, TransferListener transferListener, TimestampAdjusterProvider timestampAdjusterProvider, long j, List<Format> list, PlayerId playerId, CmcdConfiguration cmcdConfiguration) {
        this.extractorFactory = hlsExtractorFactory;
        this.playlistTracker = hlsPlaylistTracker;
        this.playlistUrls = uriArr;
        this.playlistFormats = formatArr;
        this.timestampAdjusterProvider = timestampAdjusterProvider;
        this.timestampAdjusterInitializationTimeoutMs = j;
        this.muxedCaptionFormats = list;
        this.playerId = playerId;
        this.cmcdConfiguration = cmcdConfiguration;
        DataSource createDataSource = hlsDataSourceFactory.createDataSource(1);
        this.mediaDataSource = createDataSource;
        if (transferListener != null) {
            createDataSource.addTransferListener(transferListener);
        }
        this.encryptionDataSource = hlsDataSourceFactory.createDataSource(3);
        this.trackGroup = new TrackGroup(formatArr);
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < uriArr.length; i++) {
            if ((formatArr[i].roleFlags & 16384) == 0) {
                arrayList.add(Integer.valueOf(i));
            }
        }
        this.trackSelection = new InitializationTrackSelection(this.trackGroup, Ints.toArray(arrayList));
    }

    public void maybeThrowError() throws IOException {
        IOException iOException = this.fatalError;
        if (iOException != null) {
            throw iOException;
        }
        Uri uri = this.expectedPlaylistUrl;
        if (uri == null || !this.seenExpectedPlaylistError) {
            return;
        }
        this.playlistTracker.maybeThrowPlaylistRefreshError(uri);
    }

    public TrackGroup getTrackGroup() {
        return this.trackGroup;
    }

    public boolean hasIndependentSegments() {
        return this.independentSegments;
    }

    public void setTrackSelection(ExoTrackSelection exoTrackSelection) {
        deactivatePlaylistForSelectedTrack();
        this.trackSelection = exoTrackSelection;
    }

    public ExoTrackSelection getTrackSelection() {
        return this.trackSelection;
    }

    public void reset() {
        deactivatePlaylistForSelectedTrack();
        this.fatalError = null;
    }

    public void setIsPrimaryTimestampSource(boolean z) {
        this.isPrimaryTimestampSource = z;
    }

    public long getAdjustedSeekPositionUs(long j, SeekParameters seekParameters) {
        int selectedIndex = this.trackSelection.getSelectedIndex();
        Uri[] uriArr = this.playlistUrls;
        HlsMediaPlaylist playlistSnapshot = (selectedIndex >= uriArr.length || selectedIndex == -1) ? null : this.playlistTracker.getPlaylistSnapshot(uriArr[this.trackSelection.getSelectedIndexInTrackGroup()], true);
        if (playlistSnapshot == null || playlistSnapshot.segments.isEmpty()) {
            return j;
        }
        long initialStartTimeUs = playlistSnapshot.startTimeUs - this.playlistTracker.getInitialStartTimeUs();
        long j2 = j - initialStartTimeUs;
        int binarySearchFloor = Util.binarySearchFloor((List<? extends Comparable<? super Long>>) playlistSnapshot.segments, Long.valueOf(j2), true, true);
        long j3 = playlistSnapshot.segments.get(binarySearchFloor).relativeStartTimeUs;
        return seekParameters.resolveSeekPositionUs(j2, j3, (!playlistSnapshot.hasIndependentSegments || binarySearchFloor == playlistSnapshot.segments.size() - 1) ? j3 : playlistSnapshot.segments.get(binarySearchFloor + 1).relativeStartTimeUs) + initialStartTimeUs;
    }

    public int getChunkPublicationState(HlsMediaChunk hlsMediaChunk) {
        List<HlsMediaPlaylist.Part> list;
        if (hlsMediaChunk.partIndex == -1) {
            return 1;
        }
        HlsMediaPlaylist hlsMediaPlaylist = (HlsMediaPlaylist) Assertions.checkNotNull(this.playlistTracker.getPlaylistSnapshot(this.playlistUrls[this.trackGroup.indexOf(hlsMediaChunk.trackFormat)], false));
        int i = (int) (hlsMediaChunk.chunkIndex - hlsMediaPlaylist.mediaSequence);
        if (i < 0) {
            return 1;
        }
        if (i < hlsMediaPlaylist.segments.size()) {
            list = hlsMediaPlaylist.segments.get(i).parts;
        } else {
            list = hlsMediaPlaylist.trailingParts;
        }
        if (hlsMediaChunk.partIndex >= list.size()) {
            return 2;
        }
        HlsMediaPlaylist.Part part = list.get(hlsMediaChunk.partIndex);
        if (part.isPreload) {
            return 0;
        }
        return Objects.equals(Uri.parse(UriUtil.resolve(hlsMediaPlaylist.baseUri, part.url)), hlsMediaChunk.dataSpec.uri) ? 1 : 2;
    }

    public void getNextChunk(LoadingInfo loadingInfo, long j, List<HlsMediaChunk> list, boolean z, HlsChunkHolder hlsChunkHolder) {
        HlsMediaChunk hlsMediaChunk;
        long j2;
        CmcdData.Factory factory;
        long j3;
        HlsMediaChunk hlsMediaChunk2 = list.isEmpty() ? null : (HlsMediaChunk) Iterables.getLast(list);
        int indexOf = hlsMediaChunk2 == null ? -1 : this.trackGroup.indexOf(hlsMediaChunk2.trackFormat);
        long j4 = loadingInfo.playbackPositionUs;
        long j5 = j - j4;
        long resolveTimeToLiveEdgeUs = resolveTimeToLiveEdgeUs(j4);
        if (hlsMediaChunk2 != null && !this.independentSegments) {
            long durationUs = hlsMediaChunk2.getDurationUs();
            j5 = Math.max(0L, j5 - durationUs);
            if (resolveTimeToLiveEdgeUs != -9223372036854775807L) {
                resolveTimeToLiveEdgeUs = Math.max(0L, resolveTimeToLiveEdgeUs - durationUs);
            }
        }
        long j6 = j5;
        this.trackSelection.updateSelectedTrack(j4, j6, resolveTimeToLiveEdgeUs, list, createMediaChunkIterators(hlsMediaChunk2, j));
        int selectedIndexInTrackGroup = this.trackSelection.getSelectedIndexInTrackGroup();
        boolean z2 = indexOf != selectedIndexInTrackGroup;
        Uri uri = this.playlistUrls[selectedIndexInTrackGroup];
        if (!this.playlistTracker.isSnapshotValid(uri)) {
            hlsChunkHolder.playlistUrl = uri;
            this.seenExpectedPlaylistError &= uri.equals(this.expectedPlaylistUrl);
            this.expectedPlaylistUrl = uri;
            return;
        }
        HlsMediaPlaylist playlistSnapshot = this.playlistTracker.getPlaylistSnapshot(uri, true);
        Assertions.checkNotNull(playlistSnapshot);
        this.independentSegments = playlistSnapshot.hasIndependentSegments;
        updateLiveEdgeTimeUs(playlistSnapshot);
        HlsMediaPlaylist hlsMediaPlaylist = playlistSnapshot;
        Uri uri2 = uri;
        long initialStartTimeUs = playlistSnapshot.startTimeUs - this.playlistTracker.getInitialStartTimeUs();
        Pair<Long, Integer> nextMediaSequenceAndPartIndex = getNextMediaSequenceAndPartIndex(hlsMediaChunk2, z2, hlsMediaPlaylist, initialStartTimeUs, j);
        long longValue = ((Long) nextMediaSequenceAndPartIndex.first).longValue();
        int intValue = ((Integer) nextMediaSequenceAndPartIndex.second).intValue();
        HlsMediaChunk hlsMediaChunk3 = hlsMediaChunk2;
        boolean z3 = z2;
        if (longValue >= hlsMediaPlaylist.mediaSequence || hlsMediaChunk3 == null || !z3) {
            hlsMediaChunk = hlsMediaChunk3;
        } else {
            uri2 = this.playlistUrls[indexOf];
            hlsMediaPlaylist = this.playlistTracker.getPlaylistSnapshot(uri2, true);
            Assertions.checkNotNull(hlsMediaPlaylist);
            initialStartTimeUs = hlsMediaPlaylist.startTimeUs - this.playlistTracker.getInitialStartTimeUs();
            hlsMediaChunk = hlsMediaChunk3;
            Pair<Long, Integer> nextMediaSequenceAndPartIndex2 = getNextMediaSequenceAndPartIndex(hlsMediaChunk, false, hlsMediaPlaylist, initialStartTimeUs, j);
            longValue = ((Long) nextMediaSequenceAndPartIndex2.first).longValue();
            intValue = ((Integer) nextMediaSequenceAndPartIndex2.second).intValue();
            selectedIndexInTrackGroup = indexOf;
        }
        int i = intValue;
        long j7 = initialStartTimeUs;
        HlsMediaPlaylist hlsMediaPlaylist2 = hlsMediaPlaylist;
        Uri uri3 = uri2;
        if (selectedIndexInTrackGroup != indexOf && indexOf != -1) {
            this.playlistTracker.deactivatePlaylistForPlayback(this.playlistUrls[indexOf]);
        }
        if (longValue < hlsMediaPlaylist2.mediaSequence) {
            this.fatalError = new BehindLiveWindowException();
            return;
        }
        SegmentBaseHolder nextSegmentHolder = getNextSegmentHolder(hlsMediaPlaylist2, longValue, i);
        if (nextSegmentHolder != null) {
            j2 = 1;
        } else if (!hlsMediaPlaylist2.hasEndTag) {
            hlsChunkHolder.playlistUrl = uri3;
            this.seenExpectedPlaylistError &= uri3.equals(this.expectedPlaylistUrl);
            this.expectedPlaylistUrl = uri3;
            return;
        } else if (z || hlsMediaPlaylist2.segments.isEmpty()) {
            hlsChunkHolder.endOfStream = true;
            return;
        } else {
            j2 = 1;
            nextSegmentHolder = new SegmentBaseHolder((HlsMediaPlaylist.SegmentBase) Iterables.getLast(hlsMediaPlaylist2.segments), (hlsMediaPlaylist2.mediaSequence + hlsMediaPlaylist2.segments.size()) - 1, -1);
        }
        SegmentBaseHolder segmentBaseHolder = nextSegmentHolder;
        this.seenExpectedPlaylistError = false;
        this.expectedPlaylistUrl = null;
        if (this.cmcdConfiguration != null) {
            factory = new CmcdData.Factory(this.cmcdConfiguration, "h").setTrackSelection(this.trackSelection).setBufferedDurationUs(Math.max(0L, j6)).setPlaybackRate(loadingInfo.playbackSpeed).setIsLive(!hlsMediaPlaylist2.hasEndTag).setDidRebuffer(loadingInfo.rebufferedSince(this.lastChunkRequestRealtimeMs)).setIsBufferEmpty(list.isEmpty()).setChunkDurationUs(segmentBaseHolder.segmentBase.durationUs);
            if (segmentBaseHolder.partIndex == -1) {
                j3 = segmentBaseHolder.mediaSequence + j2;
            } else {
                j3 = segmentBaseHolder.mediaSequence;
            }
            SegmentBaseHolder nextSegmentHolder2 = getNextSegmentHolder(hlsMediaPlaylist2, j3, segmentBaseHolder.partIndex == -1 ? -1 : segmentBaseHolder.partIndex + 1);
            if (nextSegmentHolder2 != null) {
                factory.setNextObjectRequest(UriUtil.getRelativePath(UriUtil.resolveToUri(hlsMediaPlaylist2.baseUri, segmentBaseHolder.segmentBase.url), UriUtil.resolveToUri(hlsMediaPlaylist2.baseUri, nextSegmentHolder2.segmentBase.url)));
                String str = nextSegmentHolder2.segmentBase.byteRangeOffset + "-";
                if (nextSegmentHolder2.segmentBase.byteRangeLength != -1) {
                    str = str + (nextSegmentHolder2.segmentBase.byteRangeOffset + nextSegmentHolder2.segmentBase.byteRangeLength);
                }
                factory.setNextRangeRequest(str);
            }
        } else {
            factory = null;
        }
        this.lastChunkRequestRealtimeMs = SystemClock.elapsedRealtime();
        Uri fullEncryptionKeyUri = getFullEncryptionKeyUri(hlsMediaPlaylist2, segmentBaseHolder.segmentBase.initializationSegment);
        hlsChunkHolder.chunk = maybeCreateEncryptionChunkFor(fullEncryptionKeyUri, selectedIndexInTrackGroup, true, factory);
        if (hlsChunkHolder.chunk != null) {
            return;
        }
        Uri fullEncryptionKeyUri2 = getFullEncryptionKeyUri(hlsMediaPlaylist2, segmentBaseHolder.segmentBase);
        hlsChunkHolder.chunk = maybeCreateEncryptionChunkFor(fullEncryptionKeyUri2, selectedIndexInTrackGroup, false, factory);
        if (hlsChunkHolder.chunk != null) {
            return;
        }
        boolean shouldSpliceIn = HlsMediaChunk.shouldSpliceIn(hlsMediaChunk, uri3, hlsMediaPlaylist2, segmentBaseHolder, j7);
        if (shouldSpliceIn && segmentBaseHolder.isPreload) {
            return;
        }
        hlsChunkHolder.chunk = HlsMediaChunk.createInstance(this.extractorFactory, this.mediaDataSource, this.playlistFormats[selectedIndexInTrackGroup], j7, hlsMediaPlaylist2, segmentBaseHolder, uri3, this.muxedCaptionFormats, this.trackSelection.getSelectionReason(), this.trackSelection.getSelectionData(), this.isPrimaryTimestampSource, this.timestampAdjusterProvider, this.timestampAdjusterInitializationTimeoutMs, hlsMediaChunk, this.keyCache.get(fullEncryptionKeyUri2), this.keyCache.get(fullEncryptionKeyUri), shouldSpliceIn, this.playerId, factory);
    }

    private static SegmentBaseHolder getNextSegmentHolder(HlsMediaPlaylist hlsMediaPlaylist, long j, int i) {
        int i2 = (int) (j - hlsMediaPlaylist.mediaSequence);
        if (i2 == hlsMediaPlaylist.segments.size()) {
            if (i == -1) {
                i = 0;
            }
            if (i < hlsMediaPlaylist.trailingParts.size()) {
                return new SegmentBaseHolder(hlsMediaPlaylist.trailingParts.get(i), j, i);
            }
            return null;
        }
        HlsMediaPlaylist.Segment segment = hlsMediaPlaylist.segments.get(i2);
        if (i == -1) {
            return new SegmentBaseHolder(segment, j, -1);
        }
        if (i < segment.parts.size()) {
            return new SegmentBaseHolder(segment.parts.get(i), j, i);
        }
        int i3 = i2 + 1;
        if (i3 < hlsMediaPlaylist.segments.size()) {
            return new SegmentBaseHolder(hlsMediaPlaylist.segments.get(i3), j + 1, -1);
        }
        if (hlsMediaPlaylist.trailingParts.isEmpty()) {
            return null;
        }
        return new SegmentBaseHolder(hlsMediaPlaylist.trailingParts.get(0), j + 1, 0);
    }

    public void onChunkLoadCompleted(Chunk chunk) {
        if (chunk instanceof EncryptionKeyChunk) {
            EncryptionKeyChunk encryptionKeyChunk = (EncryptionKeyChunk) chunk;
            this.scratchSpace = encryptionKeyChunk.getDataHolder();
            this.keyCache.put(encryptionKeyChunk.dataSpec.uri, (byte[]) Assertions.checkNotNull(encryptionKeyChunk.getResult()));
        }
    }

    public boolean maybeExcludeTrack(Chunk chunk, long j) {
        ExoTrackSelection exoTrackSelection = this.trackSelection;
        return exoTrackSelection.excludeTrack(exoTrackSelection.indexOf(this.trackGroup.indexOf(chunk.trackFormat)), j);
    }

    public boolean onPlaylistError(Uri uri, long j) {
        int indexOf;
        int i = 0;
        while (true) {
            Uri[] uriArr = this.playlistUrls;
            if (i >= uriArr.length) {
                i = -1;
                break;
            }
            if (uriArr[i].equals(uri)) {
                break;
            }
            i++;
        }
        if (i == -1 || (indexOf = this.trackSelection.indexOf(i)) == -1) {
            return true;
        }
        this.seenExpectedPlaylistError |= uri.equals(this.expectedPlaylistUrl);
        return j == -9223372036854775807L || (this.trackSelection.excludeTrack(indexOf, j) && this.playlistTracker.excludeMediaPlaylist(uri, j));
    }

    public MediaChunkIterator[] createMediaChunkIterators(HlsMediaChunk hlsMediaChunk, long j) {
        int indexOf = hlsMediaChunk == null ? -1 : this.trackGroup.indexOf(hlsMediaChunk.trackFormat);
        int length = this.trackSelection.length();
        MediaChunkIterator[] mediaChunkIteratorArr = new MediaChunkIterator[length];
        for (int i = 0; i < length; i++) {
            int indexInTrackGroup = this.trackSelection.getIndexInTrackGroup(i);
            Uri uri = this.playlistUrls[indexInTrackGroup];
            if (!this.playlistTracker.isSnapshotValid(uri)) {
                mediaChunkIteratorArr[i] = MediaChunkIterator.EMPTY;
            } else {
                HlsMediaPlaylist playlistSnapshot = this.playlistTracker.getPlaylistSnapshot(uri, false);
                Assertions.checkNotNull(playlistSnapshot);
                long initialStartTimeUs = playlistSnapshot.startTimeUs - this.playlistTracker.getInitialStartTimeUs();
                Pair<Long, Integer> nextMediaSequenceAndPartIndex = getNextMediaSequenceAndPartIndex(hlsMediaChunk, indexInTrackGroup != indexOf, playlistSnapshot, initialStartTimeUs, j);
                mediaChunkIteratorArr[i] = new HlsMediaPlaylistSegmentIterator(playlistSnapshot.baseUri, initialStartTimeUs, getSegmentBaseList(playlistSnapshot, ((Long) nextMediaSequenceAndPartIndex.first).longValue(), ((Integer) nextMediaSequenceAndPartIndex.second).intValue()));
            }
        }
        return mediaChunkIteratorArr;
    }

    public int getPreferredQueueSize(long j, List<? extends MediaChunk> list) {
        if (this.fatalError != null || this.trackSelection.length() < 2) {
            return list.size();
        }
        return this.trackSelection.evaluateQueueSize(j, list);
    }

    public boolean shouldCancelLoad(long j, Chunk chunk, List<? extends MediaChunk> list) {
        if (this.fatalError != null) {
            return false;
        }
        return this.trackSelection.shouldCancelChunkLoad(j, chunk, list);
    }

    static List<HlsMediaPlaylist.SegmentBase> getSegmentBaseList(HlsMediaPlaylist hlsMediaPlaylist, long j, int i) {
        int i2 = (int) (j - hlsMediaPlaylist.mediaSequence);
        if (i2 < 0 || hlsMediaPlaylist.segments.size() < i2) {
            return ImmutableList.of();
        }
        ArrayList arrayList = new ArrayList();
        if (i2 < hlsMediaPlaylist.segments.size()) {
            if (i != -1) {
                HlsMediaPlaylist.Segment segment = hlsMediaPlaylist.segments.get(i2);
                if (i == 0) {
                    arrayList.add(segment);
                } else if (i < segment.parts.size()) {
                    arrayList.addAll(segment.parts.subList(i, segment.parts.size()));
                }
                i2++;
            }
            arrayList.addAll(hlsMediaPlaylist.segments.subList(i2, hlsMediaPlaylist.segments.size()));
            i = 0;
        }
        if (hlsMediaPlaylist.partTargetDurationUs != -9223372036854775807L) {
            int i3 = i != -1 ? i : 0;
            if (i3 < hlsMediaPlaylist.trailingParts.size()) {
                arrayList.addAll(hlsMediaPlaylist.trailingParts.subList(i3, hlsMediaPlaylist.trailingParts.size()));
            }
        }
        return Collections.unmodifiableList(arrayList);
    }

    public boolean obtainsChunksForPlaylist(Uri uri) {
        return Util.contains(this.playlistUrls, uri);
    }

    private Pair<Long, Integer> getNextMediaSequenceAndPartIndex(HlsMediaChunk hlsMediaChunk, boolean z, HlsMediaPlaylist hlsMediaPlaylist, long j, long j2) {
        List<HlsMediaPlaylist.Part> list;
        long j3;
        if (hlsMediaChunk == null || z) {
            long j4 = hlsMediaPlaylist.durationUs + j;
            if (hlsMediaChunk != null && !this.independentSegments) {
                j2 = hlsMediaChunk.startTimeUs;
            }
            if (!hlsMediaPlaylist.hasEndTag && j2 >= j4) {
                return new Pair<>(Long.valueOf(hlsMediaPlaylist.mediaSequence + hlsMediaPlaylist.segments.size()), -1);
            }
            long j5 = j2 - j;
            int i = 0;
            int binarySearchFloor = Util.binarySearchFloor((List<? extends Comparable<? super Long>>) hlsMediaPlaylist.segments, Long.valueOf(j5), true, !this.playlistTracker.isLive() || hlsMediaChunk == null);
            long j6 = binarySearchFloor + hlsMediaPlaylist.mediaSequence;
            if (binarySearchFloor >= 0) {
                HlsMediaPlaylist.Segment segment = hlsMediaPlaylist.segments.get(binarySearchFloor);
                if (j5 < segment.relativeStartTimeUs + segment.durationUs) {
                    list = segment.parts;
                } else {
                    list = hlsMediaPlaylist.trailingParts;
                }
                while (true) {
                    if (i >= list.size()) {
                        break;
                    }
                    HlsMediaPlaylist.Part part = list.get(i);
                    if (j5 >= part.relativeStartTimeUs + part.durationUs) {
                        i++;
                    } else if (part.isIndependent) {
                        j6 += list == hlsMediaPlaylist.trailingParts ? 1L : 0L;
                        r1 = i;
                    }
                }
            }
            return new Pair<>(Long.valueOf(j6), Integer.valueOf(r1));
        }
        if (hlsMediaChunk.isLoadCompleted()) {
            if (hlsMediaChunk.partIndex == -1) {
                j3 = hlsMediaChunk.getNextChunkIndex();
            } else {
                j3 = hlsMediaChunk.chunkIndex;
            }
            return new Pair<>(Long.valueOf(j3), Integer.valueOf(hlsMediaChunk.partIndex != -1 ? hlsMediaChunk.partIndex + 1 : -1));
        }
        return new Pair<>(Long.valueOf(hlsMediaChunk.chunkIndex), Integer.valueOf(hlsMediaChunk.partIndex));
    }

    private long resolveTimeToLiveEdgeUs(long j) {
        long j2 = this.liveEdgeInPeriodTimeUs;
        if (j2 != -9223372036854775807L) {
            return j2 - j;
        }
        return -9223372036854775807L;
    }

    private void updateLiveEdgeTimeUs(HlsMediaPlaylist hlsMediaPlaylist) {
        this.liveEdgeInPeriodTimeUs = hlsMediaPlaylist.hasEndTag ? -9223372036854775807L : hlsMediaPlaylist.getEndTimeUs() - this.playlistTracker.getInitialStartTimeUs();
    }

    private Chunk maybeCreateEncryptionChunkFor(Uri uri, int i, boolean z, CmcdData.Factory factory) {
        if (uri == null) {
            return null;
        }
        byte[] remove = this.keyCache.remove(uri);
        if (remove != null) {
            this.keyCache.put(uri, remove);
            return null;
        }
        DataSpec build = new DataSpec.Builder().setUri(uri).setFlags(1).build();
        if (factory != null) {
            if (z) {
                factory.setObjectType("i");
            }
            build = factory.createCmcdData().addToDataSpec(build);
        }
        return new EncryptionKeyChunk(this.encryptionDataSource, build, this.playlistFormats[i], this.trackSelection.getSelectionReason(), this.trackSelection.getSelectionData(), this.scratchSpace);
    }

    private static Uri getFullEncryptionKeyUri(HlsMediaPlaylist hlsMediaPlaylist, HlsMediaPlaylist.SegmentBase segmentBase) {
        if (segmentBase == null || segmentBase.fullSegmentEncryptionKeyUri == null) {
            return null;
        }
        return UriUtil.resolveToUri(hlsMediaPlaylist.baseUri, segmentBase.fullSegmentEncryptionKeyUri);
    }

    private void deactivatePlaylistForSelectedTrack() {
        this.playlistTracker.deactivatePlaylistForPlayback(this.playlistUrls[this.trackSelection.getSelectedIndexInTrackGroup()]);
    }

    static final class SegmentBaseHolder {
        public final boolean isPreload;
        public final long mediaSequence;
        public final int partIndex;
        public final HlsMediaPlaylist.SegmentBase segmentBase;

        public SegmentBaseHolder(HlsMediaPlaylist.SegmentBase segmentBase, long j, int i) {
            this.segmentBase = segmentBase;
            this.mediaSequence = j;
            this.partIndex = i;
            this.isPreload = (segmentBase instanceof HlsMediaPlaylist.Part) && ((HlsMediaPlaylist.Part) segmentBase).isPreload;
        }
    }

    private static final class InitializationTrackSelection extends BaseTrackSelection {
        private int selectedIndex;

        @Override // io.bidmachine.media3.exoplayer.trackselection.ExoTrackSelection
        public Object getSelectionData() {
            return null;
        }

        @Override // io.bidmachine.media3.exoplayer.trackselection.ExoTrackSelection
        public int getSelectionReason() {
            return 0;
        }

        public InitializationTrackSelection(TrackGroup trackGroup, int[] iArr) {
            super(trackGroup, iArr);
            this.selectedIndex = indexOf(trackGroup.getFormat(iArr[0]));
        }

        @Override // io.bidmachine.media3.exoplayer.trackselection.ExoTrackSelection
        public void updateSelectedTrack(long j, long j2, long j3, List<? extends MediaChunk> list, MediaChunkIterator[] mediaChunkIteratorArr) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            if (isTrackExcluded(this.selectedIndex, elapsedRealtime)) {
                for (int i = this.length - 1; i >= 0; i--) {
                    if (!isTrackExcluded(i, elapsedRealtime)) {
                        this.selectedIndex = i;
                        return;
                    }
                }
                throw new IllegalStateException();
            }
        }

        @Override // io.bidmachine.media3.exoplayer.trackselection.ExoTrackSelection
        public int getSelectedIndex() {
            return this.selectedIndex;
        }
    }

    private static final class EncryptionKeyChunk extends DataChunk {
        private byte[] result;

        public EncryptionKeyChunk(DataSource dataSource, DataSpec dataSpec, Format format, int i, Object obj, byte[] bArr) {
            super(dataSource, dataSpec, 3, format, i, obj, bArr);
        }

        @Override // io.bidmachine.media3.exoplayer.source.chunk.DataChunk
        protected void consume(byte[] bArr, int i) {
            this.result = Arrays.copyOf(bArr, i);
        }

        public byte[] getResult() {
            return this.result;
        }
    }

    static final class HlsMediaPlaylistSegmentIterator extends BaseMediaChunkIterator {
        private final String playlistBaseUri;
        private final List<HlsMediaPlaylist.SegmentBase> segmentBases;
        private final long startOfPlaylistInPeriodUs;

        public HlsMediaPlaylistSegmentIterator(String str, long j, List<HlsMediaPlaylist.SegmentBase> list) {
            super(0L, list.size() - 1);
            this.playlistBaseUri = str;
            this.startOfPlaylistInPeriodUs = j;
            this.segmentBases = list;
        }

        @Override // io.bidmachine.media3.exoplayer.source.chunk.MediaChunkIterator
        public DataSpec getDataSpec() {
            checkInBounds();
            HlsMediaPlaylist.SegmentBase segmentBase = this.segmentBases.get((int) getCurrentIndex());
            return new DataSpec(UriUtil.resolveToUri(this.playlistBaseUri, segmentBase.url), segmentBase.byteRangeOffset, segmentBase.byteRangeLength);
        }

        @Override // io.bidmachine.media3.exoplayer.source.chunk.MediaChunkIterator
        public long getChunkStartTimeUs() {
            checkInBounds();
            return this.startOfPlaylistInPeriodUs + this.segmentBases.get((int) getCurrentIndex()).relativeStartTimeUs;
        }

        @Override // io.bidmachine.media3.exoplayer.source.chunk.MediaChunkIterator
        public long getChunkEndTimeUs() {
            checkInBounds();
            HlsMediaPlaylist.SegmentBase segmentBase = this.segmentBases.get((int) getCurrentIndex());
            return this.startOfPlaylistInPeriodUs + segmentBase.relativeStartTimeUs + segmentBase.durationUs;
        }
    }
}
