package io.bidmachine.media3.exoplayer.dash.offline;

import androidx.privacysandbox.ads.adservices.adid.AdIdManagerImplCommon$$ExternalSyntheticLambda0;
import com.google.common.collect.ImmutableMap;
import io.bidmachine.media3.common.MediaItem;
import io.bidmachine.media3.common.util.RunnableFutureTask;
import io.bidmachine.media3.common.util.Util;
import io.bidmachine.media3.datasource.DataSource;
import io.bidmachine.media3.datasource.cache.CacheDataSource;
import io.bidmachine.media3.exoplayer.dash.BaseUrlExclusionList;
import io.bidmachine.media3.exoplayer.dash.DashSegmentIndex;
import io.bidmachine.media3.exoplayer.dash.DashUtil;
import io.bidmachine.media3.exoplayer.dash.DashWrappingSegmentIndex;
import io.bidmachine.media3.exoplayer.dash.manifest.AdaptationSet;
import io.bidmachine.media3.exoplayer.dash.manifest.BaseUrl;
import io.bidmachine.media3.exoplayer.dash.manifest.DashManifest;
import io.bidmachine.media3.exoplayer.dash.manifest.DashManifestParser;
import io.bidmachine.media3.exoplayer.dash.manifest.Period;
import io.bidmachine.media3.exoplayer.dash.manifest.RangedUri;
import io.bidmachine.media3.exoplayer.dash.manifest.Representation;
import io.bidmachine.media3.exoplayer.offline.DownloadException;
import io.bidmachine.media3.exoplayer.offline.SegmentDownloader;
import io.bidmachine.media3.exoplayer.upstream.ParsingLoadable;
import io.bidmachine.media3.extractor.ChunkIndex;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;

/* loaded from: classes7.dex */
public final class DashDownloader extends SegmentDownloader<DashManifest> {
    private final BaseUrlExclusionList baseUrlExclusionList;

    public DashDownloader(MediaItem mediaItem, CacheDataSource.Factory factory) {
        this(mediaItem, factory, new AdIdManagerImplCommon$$ExternalSyntheticLambda0());
    }

    public DashDownloader(MediaItem mediaItem, CacheDataSource.Factory factory, Executor executor) {
        this(mediaItem, new DashManifestParser(), factory, executor, 20000L);
    }

    @Deprecated
    public DashDownloader(MediaItem mediaItem, ParsingLoadable.Parser<DashManifest> parser, CacheDataSource.Factory factory, Executor executor) {
        this(mediaItem, parser, factory, executor, 20000L);
    }

    public DashDownloader(MediaItem mediaItem, ParsingLoadable.Parser<DashManifest> parser, CacheDataSource.Factory factory, Executor executor, long j) {
        super(mediaItem, parser, factory, executor, j);
        this.baseUrlExclusionList = new BaseUrlExclusionList();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.bidmachine.media3.exoplayer.offline.SegmentDownloader
    public List<SegmentDownloader.Segment> getSegments(DataSource dataSource, DashManifest dashManifest, boolean z) throws IOException, InterruptedException {
        ArrayList<SegmentDownloader.Segment> arrayList = new ArrayList<>();
        for (int i = 0; i < dashManifest.getPeriodCount(); i++) {
            Period period = dashManifest.getPeriod(i);
            long msToUs = Util.msToUs(period.startMs);
            long periodDurationUs = dashManifest.getPeriodDurationUs(i);
            List<AdaptationSet> list = period.adaptationSets;
            for (int i2 = 0; i2 < list.size(); i2++) {
                addSegmentsForAdaptationSet(dataSource, list.get(i2), msToUs, periodDurationUs, z, arrayList);
            }
        }
        return arrayList;
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x00ad A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00a7 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void addSegmentsForAdaptationSet(DataSource dataSource, AdaptationSet adaptationSet, long j, long j2, boolean z, ArrayList<SegmentDownloader.Segment> arrayList) throws IOException, InterruptedException {
        DashSegmentIndex segmentIndex;
        DashDownloader dashDownloader = this;
        int i = 0;
        while (i < adaptationSet.representations.size()) {
            Representation representation = adaptationSet.representations.get(i);
            try {
            } catch (IOException e) {
                e = e;
            }
            try {
                segmentIndex = dashDownloader.getSegmentIndex(dataSource, adaptationSet.type, representation, z);
            } catch (IOException e2) {
                e = e2;
                if (z) {
                    throw e;
                }
                i++;
                dashDownloader = this;
            }
            if (segmentIndex == null) {
                try {
                    throw new DownloadException("Missing segment index");
                } catch (IOException e3) {
                    e = e3;
                    if (z) {
                    }
                }
            } else {
                long segmentCount = segmentIndex.getSegmentCount(j2);
                if (segmentCount == -1) {
                    throw new DownloadException("Unbounded segment index");
                }
                String str = ((BaseUrl) Util.castNonNull(dashDownloader.baseUrlExclusionList.selectBaseUrl(representation.baseUrls))).url;
                RangedUri initializationUri = representation.getInitializationUri();
                if (initializationUri != null) {
                    arrayList.add(dashDownloader.createSegment(representation, str, j, initializationUri));
                }
                RangedUri indexUri = representation.getIndexUri();
                if (indexUri != null) {
                    arrayList.add(createSegment(representation, str, j, indexUri));
                }
                long firstSegmentNum = segmentIndex.getFirstSegmentNum();
                long j3 = (segmentCount + firstSegmentNum) - 1;
                while (firstSegmentNum <= j3) {
                    arrayList.add(createSegment(representation, str, j + segmentIndex.getTimeUs(firstSegmentNum), segmentIndex.getSegmentUrl(firstSegmentNum)));
                    firstSegmentNum++;
                }
                i++;
                dashDownloader = this;
            }
        }
    }

    private SegmentDownloader.Segment createSegment(Representation representation, String str, long j, RangedUri rangedUri) {
        return new SegmentDownloader.Segment(j, DashUtil.buildDataSpec(representation, str, rangedUri, 0, ImmutableMap.of()));
    }

    private DashSegmentIndex getSegmentIndex(final DataSource dataSource, final int i, final Representation representation, boolean z) throws IOException, InterruptedException {
        DashSegmentIndex index = representation.getIndex();
        if (index != null) {
            return index;
        }
        ChunkIndex chunkIndex = (ChunkIndex) execute(new RunnableFutureTask<ChunkIndex, IOException>() { // from class: io.bidmachine.media3.exoplayer.dash.offline.DashDownloader.1
            /* JADX INFO: Access modifiers changed from: protected */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // io.bidmachine.media3.common.util.RunnableFutureTask
            public ChunkIndex doWork() throws IOException {
                return DashUtil.loadChunkIndex(dataSource, i, representation);
            }
        }, z);
        if (chunkIndex == null) {
            return null;
        }
        return new DashWrappingSegmentIndex(chunkIndex, representation.presentationTimeOffsetUs);
    }
}
