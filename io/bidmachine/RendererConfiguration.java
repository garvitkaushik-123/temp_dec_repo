package io.bidmachine;

import android.content.Context;
import android.graphics.drawable.Drawable;
import io.bidmachine.rendering.utils.WatermarkUtils;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: RendererConfiguration.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u0019\u0012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\u0010\u0005J\b\u0010\b\u001a\u0004\u0018\u00010\u0004J\u0010\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\fR\u001d\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u000e"}, d2 = {"Lio/bidmachine/RendererConfiguration;", "", "extras", "", "", "(Ljava/util/Map;)V", "getExtras", "()Ljava/util/Map;", "getWatermark", "getWatermarkDrawable", "Landroid/graphics/drawable/Drawable;", "context", "Landroid/content/Context;", "Companion", "bidmachine-android-sdk_bh_3_4_0"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes7.dex */
public final class RendererConfiguration {
    private static final String GOOGLE_WATERMARK = "google_watermark";
    private final Map<String, Object> extras;

    public RendererConfiguration(Map<String, ? extends Object> extras) {
        Intrinsics.checkNotNullParameter(extras, "extras");
        this.extras = extras;
    }

    public final Map<String, Object> getExtras() {
        return this.extras;
    }

    public final String getWatermark() {
        Object obj = this.extras.get(GOOGLE_WATERMARK);
        if (obj instanceof String) {
            return (String) obj;
        }
        return null;
    }

    public final Drawable getWatermarkDrawable(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return WatermarkUtils.INSTANCE.convertToRepeatedDrawable(context, getWatermark());
    }
}
