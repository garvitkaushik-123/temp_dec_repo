package io.bidmachine.rendering.measurer;

import android.content.Context;
import java.util.Map;

/* loaded from: classes8.dex */
public interface MeasurerFactory {
    HtmlMeasurer createHtmlMeasurer(Context context, String name, Map<String, String> parameters);

    VideoMeasurer createVideoMeasurer(Context context, String name, Map<String, String> parameters);
}
