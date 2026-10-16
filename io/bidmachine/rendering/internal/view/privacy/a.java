package io.bidmachine.rendering.internal.view.privacy;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.widget.Button;
import io.bidmachine.rendering.R;
import io.bidmachine.util.UtilsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\b\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\f\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lio/bidmachine/rendering/internal/view/privacy/a;", "Landroid/widget/Button;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/graphics/drawable/Drawable;", "src", "a", "(Landroid/graphics/drawable/Drawable;)Landroid/graphics/drawable/Drawable;", "icon", "", "setActionIcon", "(Landroid/graphics/drawable/Drawable;)V", "bidmachine-android-sdk_bi_3_4_0"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes8.dex */
public final class a extends Button {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        setAllCaps(false);
        setMinHeight(UtilsKt.dpToPx(context, 40.0f));
        setMinWidth(0);
        setGravity(8388627);
        setIncludeFontPadding(false);
        setElevation(0.0f);
        setStateListAnimator(null);
        int dpToPx = UtilsKt.dpToPx(context, 24.0f);
        int dpToPx2 = UtilsKt.dpToPx(context, 10.0f);
        int dpToPx3 = UtilsKt.dpToPx(context, 8.0f);
        setPadding(dpToPx, dpToPx2, dpToPx, dpToPx2);
        setCompoundDrawablePadding(dpToPx3);
        setBackgroundResource(R.drawable.bm_bg_privacy_button);
        setTextColor(UtilsKt.getColorCompat(context, R.color.bm_privacy_button_text_color));
    }

    private final Drawable a(Drawable src) {
        if (src instanceof BitmapDrawable) {
            Bitmap bitmap = ((BitmapDrawable) src).getBitmap();
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            int dpToPx = UtilsKt.dpToPx(context, 24.0f);
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            if (width != dpToPx || height != dpToPx) {
                float f = dpToPx;
                float f2 = width;
                float f3 = height;
                float min = Math.min(f / f2, f / f3);
                return new BitmapDrawable(getContext().getResources(), Bitmap.createScaledBitmap(bitmap, (int) (f2 * min), (int) (f3 * min), true));
            }
        }
        return src;
    }

    public final void setActionIcon(Drawable icon) {
        Drawable drawable;
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        int colorCompat = UtilsKt.getColorCompat(context, R.color.bm_privacy_button_icon_color);
        if (icon != null) {
            drawable = a(icon).mutate();
            drawable.setTint(colorCompat);
        } else {
            drawable = null;
        }
        setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, drawable, (Drawable) null);
    }
}
