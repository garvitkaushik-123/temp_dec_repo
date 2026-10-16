package io.bidmachine.media3.common;

import android.content.Context;
import io.bidmachine.media3.common.VideoGraph;
import java.util.List;
import java.util.concurrent.Executor;

/* loaded from: classes7.dex */
public interface PreviewingVideoGraph extends VideoGraph {

    public interface Factory {
        PreviewingVideoGraph create(Context context, ColorInfo colorInfo, DebugViewProvider debugViewProvider, VideoGraph.Listener listener, Executor executor, VideoCompositorSettings videoCompositorSettings, List<Effect> list, long j) throws VideoFrameProcessingException;

        boolean supportsMultipleInputs();
    }

    void renderOutputFrame(long j);
}
