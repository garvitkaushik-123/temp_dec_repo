package io.bidmachine.media3.exoplayer.video;

import android.view.Surface;
import io.bidmachine.media3.common.util.Size;

/* loaded from: classes7.dex */
interface VideoSinkProvider {
    void clearOutputSurfaceInfo();

    VideoSink getSink(int i);

    void release();

    void setOutputSurfaceInfo(Surface surface, Size size);
}
