package io.bidmachine.media3.exoplayer.source.chunk;

import io.bidmachine.media3.common.DataReader;
import io.bidmachine.media3.common.Format;
import io.bidmachine.media3.datasource.DataSource;
import io.bidmachine.media3.datasource.DataSourceUtil;
import io.bidmachine.media3.datasource.DataSpec;
import io.bidmachine.media3.extractor.DefaultExtractorInput;
import io.bidmachine.media3.extractor.TrackOutput;
import java.io.IOException;

@Deprecated
/* loaded from: classes7.dex */
public final class SingleSampleMediaChunk extends BaseMediaChunk {
    private boolean loadCompleted;
    private long nextLoadPosition;
    private final Format sampleFormat;
    private final int trackType;

    @Override // io.bidmachine.media3.exoplayer.upstream.Loader.Loadable
    public void cancelLoad() {
    }

    public SingleSampleMediaChunk(DataSource dataSource, DataSpec dataSpec, Format format, int i, Object obj, long j, long j2, long j3, int i2, Format format2) {
        super(dataSource, dataSpec, format, i, obj, j, j2, -9223372036854775807L, -9223372036854775807L, j3);
        this.trackType = i2;
        this.sampleFormat = format2;
    }

    @Override // io.bidmachine.media3.exoplayer.source.chunk.MediaChunk
    public boolean isLoadCompleted() {
        return this.loadCompleted;
    }

    @Override // io.bidmachine.media3.exoplayer.upstream.Loader.Loadable
    public void load() throws IOException {
        BaseMediaChunkOutput output = getOutput();
        output.setSampleOffsetUs(0L);
        TrackOutput track = output.track(0, this.trackType);
        track.format(this.sampleFormat);
        try {
            long open = this.dataSource.open(this.dataSpec.subrange(this.nextLoadPosition));
            if (open != -1) {
                open += this.nextLoadPosition;
            }
            DefaultExtractorInput defaultExtractorInput = new DefaultExtractorInput(this.dataSource, this.nextLoadPosition, open);
            for (int i = 0; i != -1; i = track.sampleData((DataReader) defaultExtractorInput, Integer.MAX_VALUE, true)) {
                this.nextLoadPosition += i;
            }
            track.sampleMetadata(this.startTimeUs, 1, (int) this.nextLoadPosition, 0, null);
            DataSourceUtil.closeQuietly(this.dataSource);
            this.loadCompleted = true;
        } catch (Throwable th) {
            DataSourceUtil.closeQuietly(this.dataSource);
            throw th;
        }
    }
}
