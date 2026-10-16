package com.mbridge.msdk.playercommon.exoplayer2.source.chunk;

import com.mbridge.msdk.playercommon.exoplayer2.Format;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.DefaultExtractorInput;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.TrackOutput;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.DataSource;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.DataSpec;
import com.mbridge.msdk.playercommon.exoplayer2.util.Util;
import java.io.IOException;

/* loaded from: classes6.dex */
public final class SingleSampleMediaChunk extends BaseMediaChunk {
    private volatile int bytesLoaded;
    private volatile boolean loadCompleted;
    private final Format sampleFormat;
    private final int trackType;

    public SingleSampleMediaChunk(DataSource dataSource, DataSpec dataSpec, Format format, int i, Object obj, long j, long j2, long j3, int i2, Format format2) {
        super(dataSource, dataSpec, format, i, obj, j, j2, -9223372036854775807L, j3);
        this.trackType = i2;
        this.sampleFormat = format2;
    }

    @Override // com.mbridge.msdk.playercommon.exoplayer2.source.chunk.Chunk
    public long bytesLoaded() {
        return this.bytesLoaded;
    }

    @Override // com.mbridge.msdk.playercommon.exoplayer2.upstream.Loader.Loadable
    public void cancelLoad() {
    }

    @Override // com.mbridge.msdk.playercommon.exoplayer2.source.chunk.MediaChunk
    public boolean isLoadCompleted() {
        return this.loadCompleted;
    }

    @Override // com.mbridge.msdk.playercommon.exoplayer2.upstream.Loader.Loadable
    public void load() throws IOException, InterruptedException {
        try {
            long open = this.dataSource.open(this.dataSpec.subrange(this.bytesLoaded));
            if (open != -1) {
                open += this.bytesLoaded;
            }
            DefaultExtractorInput defaultExtractorInput = new DefaultExtractorInput(this.dataSource, this.bytesLoaded, open);
            BaseMediaChunkOutput output = getOutput();
            output.setSampleOffsetUs(0L);
            TrackOutput track = output.track(0, this.trackType);
            track.format(this.sampleFormat);
            for (int i = 0; i != -1; i = track.sampleData(defaultExtractorInput, Integer.MAX_VALUE, true)) {
                this.bytesLoaded += i;
            }
            track.sampleMetadata(this.startTimeUs, 1, this.bytesLoaded, 0, null);
            Util.closeQuietly(this.dataSource);
            this.loadCompleted = true;
        } catch (Throwable th) {
            Util.closeQuietly(this.dataSource);
            throw th;
        }
    }
}
