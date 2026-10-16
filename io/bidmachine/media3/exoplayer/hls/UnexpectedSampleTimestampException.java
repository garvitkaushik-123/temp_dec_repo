package io.bidmachine.media3.exoplayer.hls;

import com.ironsource.C3040d4;
import io.bidmachine.media3.common.util.Util;
import io.bidmachine.media3.exoplayer.source.chunk.MediaChunk;
import java.io.IOException;

/* loaded from: classes7.dex */
final class UnexpectedSampleTimestampException extends IOException {
    public final long lastAcceptedSampleTimeUs;
    public final MediaChunk mediaChunk;
    public final long rejectedSampleTimeUs;

    public UnexpectedSampleTimestampException(MediaChunk mediaChunk, long j, long j2) {
        super("Unexpected sample timestamp: " + Util.usToMs(j2) + " in chunk [" + mediaChunk.startTimeUs + ", " + mediaChunk.endTimeUs + C3040d4.i.e);
        this.mediaChunk = mediaChunk;
        this.lastAcceptedSampleTimeUs = j;
        this.rejectedSampleTimeUs = j2;
    }
}
