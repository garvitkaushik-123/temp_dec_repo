package com.mbridge.msdk.playercommon.exoplayer2;

import android.util.Log;
import com.mbridge.msdk.playercommon.exoplayer2.source.ClippingMediaPeriod;
import com.mbridge.msdk.playercommon.exoplayer2.source.EmptySampleStream;
import com.mbridge.msdk.playercommon.exoplayer2.source.MediaPeriod;
import com.mbridge.msdk.playercommon.exoplayer2.source.MediaSource;
import com.mbridge.msdk.playercommon.exoplayer2.source.SampleStream;
import com.mbridge.msdk.playercommon.exoplayer2.source.TrackGroupArray;
import com.mbridge.msdk.playercommon.exoplayer2.trackselection.TrackSelection;
import com.mbridge.msdk.playercommon.exoplayer2.trackselection.TrackSelectionArray;
import com.mbridge.msdk.playercommon.exoplayer2.trackselection.TrackSelector;
import com.mbridge.msdk.playercommon.exoplayer2.trackselection.TrackSelectorResult;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.Allocator;
import com.mbridge.msdk.playercommon.exoplayer2.util.Assertions;

/* loaded from: classes6.dex */
final class MediaPeriodHolder {
    private static final String TAG = "MediaPeriodHolder";
    public boolean hasEnabledTracks;
    public MediaPeriodInfo info;
    public final boolean[] mayRetainStreamFlags;
    public final MediaPeriod mediaPeriod;
    private final MediaSource mediaSource;
    public MediaPeriodHolder next;
    private TrackSelectorResult periodTrackSelectorResult;
    public boolean prepared;
    private final RendererCapabilities[] rendererCapabilities;
    public long rendererPositionOffsetUs;
    public final SampleStream[] sampleStreams;
    public TrackGroupArray trackGroups;
    private final TrackSelector trackSelector;
    public TrackSelectorResult trackSelectorResult;
    public final Object uid;

    public MediaPeriodHolder(RendererCapabilities[] rendererCapabilitiesArr, long j, TrackSelector trackSelector, Allocator allocator, MediaSource mediaSource, Object obj, MediaPeriodInfo mediaPeriodInfo) {
        this.rendererCapabilities = rendererCapabilitiesArr;
        this.rendererPositionOffsetUs = j - mediaPeriodInfo.startPositionUs;
        this.trackSelector = trackSelector;
        this.mediaSource = mediaSource;
        this.uid = Assertions.checkNotNull(obj);
        this.info = mediaPeriodInfo;
        this.sampleStreams = new SampleStream[rendererCapabilitiesArr.length];
        this.mayRetainStreamFlags = new boolean[rendererCapabilitiesArr.length];
        MediaPeriod createPeriod = mediaSource.createPeriod(mediaPeriodInfo.id, allocator);
        long j2 = mediaPeriodInfo.endPositionUs;
        this.mediaPeriod = j2 != Long.MIN_VALUE ? new ClippingMediaPeriod(createPeriod, true, 0L, j2) : createPeriod;
    }

    private void associateNoSampleRenderersWithEmptySampleStream(SampleStream[] sampleStreamArr) {
        int i = 0;
        while (true) {
            RendererCapabilities[] rendererCapabilitiesArr = this.rendererCapabilities;
            if (i >= rendererCapabilitiesArr.length) {
                return;
            }
            if (rendererCapabilitiesArr[i].getTrackType() == 5 && this.trackSelectorResult.isRendererEnabled(i)) {
                sampleStreamArr[i] = new EmptySampleStream();
            }
            i++;
        }
    }

    private void disableTrackSelectionsInResult(TrackSelectorResult trackSelectorResult) {
        for (int i = 0; i < trackSelectorResult.length; i++) {
            boolean isRendererEnabled = trackSelectorResult.isRendererEnabled(i);
            TrackSelection trackSelection = trackSelectorResult.selections.get(i);
            if (isRendererEnabled && trackSelection != null) {
                trackSelection.disable();
            }
        }
    }

    private void disassociateNoSampleRenderersWithEmptySampleStream(SampleStream[] sampleStreamArr) {
        int i = 0;
        while (true) {
            RendererCapabilities[] rendererCapabilitiesArr = this.rendererCapabilities;
            if (i >= rendererCapabilitiesArr.length) {
                return;
            }
            if (rendererCapabilitiesArr[i].getTrackType() == 5) {
                sampleStreamArr[i] = null;
            }
            i++;
        }
    }

    private void enableTrackSelectionsInResult(TrackSelectorResult trackSelectorResult) {
        for (int i = 0; i < trackSelectorResult.length; i++) {
            boolean isRendererEnabled = trackSelectorResult.isRendererEnabled(i);
            TrackSelection trackSelection = trackSelectorResult.selections.get(i);
            if (isRendererEnabled && trackSelection != null) {
                trackSelection.enable();
            }
        }
    }

    private void updatePeriodTrackSelectorResult(TrackSelectorResult trackSelectorResult) {
        TrackSelectorResult trackSelectorResult2 = this.periodTrackSelectorResult;
        if (trackSelectorResult2 != null) {
            disableTrackSelectionsInResult(trackSelectorResult2);
        }
        this.periodTrackSelectorResult = trackSelectorResult;
        if (trackSelectorResult != null) {
            enableTrackSelectionsInResult(trackSelectorResult);
        }
    }

    public long applyTrackSelection(long j, boolean z) {
        return applyTrackSelection(j, z, new boolean[this.rendererCapabilities.length]);
    }

    public void continueLoading(long j) {
        this.mediaPeriod.continueLoading(toPeriodTime(j));
    }

    public long getBufferedPositionUs(boolean z) {
        if (!this.prepared) {
            return this.info.startPositionUs;
        }
        long bufferedPositionUs = this.mediaPeriod.getBufferedPositionUs();
        return (bufferedPositionUs == Long.MIN_VALUE && z) ? this.info.durationUs : bufferedPositionUs;
    }

    public long getDurationUs() {
        return this.info.durationUs;
    }

    public long getNextLoadPositionUs() {
        if (this.prepared) {
            return this.mediaPeriod.getNextLoadPositionUs();
        }
        return 0L;
    }

    public long getRendererOffset() {
        return this.rendererPositionOffsetUs;
    }

    public void handlePrepared(float f) throws ExoPlaybackException {
        this.prepared = true;
        this.trackGroups = this.mediaPeriod.getTrackGroups();
        selectTracks(f);
        long applyTrackSelection = applyTrackSelection(this.info.startPositionUs, false);
        long j = this.rendererPositionOffsetUs;
        MediaPeriodInfo mediaPeriodInfo = this.info;
        this.rendererPositionOffsetUs = j + (mediaPeriodInfo.startPositionUs - applyTrackSelection);
        this.info = mediaPeriodInfo.copyWithStartPositionUs(applyTrackSelection);
    }

    public boolean isFullyBuffered() {
        if (this.prepared) {
            return !this.hasEnabledTracks || this.mediaPeriod.getBufferedPositionUs() == Long.MIN_VALUE;
        }
        return false;
    }

    public void reevaluateBuffer(long j) {
        if (this.prepared) {
            this.mediaPeriod.reevaluateBuffer(toPeriodTime(j));
        }
    }

    public void release() {
        updatePeriodTrackSelectorResult(null);
        try {
            if (this.info.endPositionUs != Long.MIN_VALUE) {
                this.mediaSource.releasePeriod(((ClippingMediaPeriod) this.mediaPeriod).mediaPeriod);
            } else {
                this.mediaSource.releasePeriod(this.mediaPeriod);
            }
        } catch (RuntimeException e) {
            Log.e(TAG, "Period release failed.", e);
        }
    }

    public boolean selectTracks(float f) throws ExoPlaybackException {
        TrackSelectorResult selectTracks = this.trackSelector.selectTracks(this.rendererCapabilities, this.trackGroups);
        if (selectTracks.isEquivalent(this.periodTrackSelectorResult)) {
            return false;
        }
        this.trackSelectorResult = selectTracks;
        for (TrackSelection trackSelection : selectTracks.selections.getAll()) {
            if (trackSelection != null) {
                trackSelection.onPlaybackSpeed(f);
            }
        }
        return true;
    }

    public long toPeriodTime(long j) {
        return j - getRendererOffset();
    }

    public long toRendererTime(long j) {
        return j + getRendererOffset();
    }

    public long applyTrackSelection(long j, boolean z, boolean[] zArr) {
        int i = 0;
        while (true) {
            TrackSelectorResult trackSelectorResult = this.trackSelectorResult;
            boolean z2 = true;
            if (i >= trackSelectorResult.length) {
                break;
            }
            boolean[] zArr2 = this.mayRetainStreamFlags;
            if (z || !trackSelectorResult.isEquivalent(this.periodTrackSelectorResult, i)) {
                z2 = false;
            }
            zArr2[i] = z2;
            i++;
        }
        disassociateNoSampleRenderersWithEmptySampleStream(this.sampleStreams);
        updatePeriodTrackSelectorResult(this.trackSelectorResult);
        TrackSelectionArray trackSelectionArray = this.trackSelectorResult.selections;
        long selectTracks = this.mediaPeriod.selectTracks(trackSelectionArray.getAll(), this.mayRetainStreamFlags, this.sampleStreams, zArr, j);
        associateNoSampleRenderersWithEmptySampleStream(this.sampleStreams);
        this.hasEnabledTracks = false;
        int i2 = 0;
        while (true) {
            SampleStream[] sampleStreamArr = this.sampleStreams;
            if (i2 >= sampleStreamArr.length) {
                return selectTracks;
            }
            if (sampleStreamArr[i2] != null) {
                Assertions.checkState(this.trackSelectorResult.isRendererEnabled(i2));
                if (this.rendererCapabilities[i2].getTrackType() != 5) {
                    this.hasEnabledTracks = true;
                }
            } else {
                Assertions.checkState(trackSelectionArray.get(i2) == null);
            }
            i2++;
        }
    }
}
