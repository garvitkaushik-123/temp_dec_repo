package io.bidmachine.rendering.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import io.bidmachine.util.ImageUtilsKt;
import io.bidmachine.util.UtilsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b¨\u0006\t"}, d2 = {"Lio/bidmachine/rendering/utils/WatermarkUtils;", "", "()V", "convertToRepeatedDrawable", "Landroid/graphics/drawable/Drawable;", "context", "Landroid/content/Context;", "watermarkBase64", "", "bidmachine-android-sdk_bi_3_4_0"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes8.dex */
public final class WatermarkUtils {
    public static final WatermarkUtils INSTANCE = new WatermarkUtils();

    private WatermarkUtils() {
    }

    public final Drawable convertToRepeatedDrawable(Context context, String watermarkBase64) {
        byte[] decodeBase64;
        Bitmap decodeBytesToBitmapSafely$default;
        BitmapDrawable bitmapDrawable;
        Intrinsics.checkNotNullParameter(context, "context");
        if (watermarkBase64 != null) {
            try {
                String notEmptyOrNull = UtilsKt.notEmptyOrNull(watermarkBase64);
                if (notEmptyOrNull != null && (decodeBase64 = UtilsKt.decodeBase64(notEmptyOrNull, 0)) != null && (decodeBytesToBitmapSafely$default = ImageUtilsKt.decodeBytesToBitmapSafely$default(decodeBase64, null, 1, null)) != null && (bitmapDrawable = ImageUtilsKt.toBitmapDrawable(decodeBytesToBitmapSafely$default, context)) != null) {
                    Shader.TileMode tileMode = Shader.TileMode.REPEAT;
                    bitmapDrawable.setTileModeXY(tileMode, tileMode);
                    return bitmapDrawable;
                }
            } catch (Throwable unused) {
            }
        }
        return null;
    }
}
