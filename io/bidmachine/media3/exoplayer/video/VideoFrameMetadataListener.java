package io.bidmachine.media3.exoplayer.video;

import android.media.MediaFormat;
import io.bidmachine.media3.common.Format;

/* loaded from: classes7.dex */
public interface VideoFrameMetadataListener {
    void onVideoFrameAboutToBeRendered(long j, long j2, Format format, MediaFormat mediaFormat);
}
