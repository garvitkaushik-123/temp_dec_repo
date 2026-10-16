package com.mbridge.msdk.dycreator.baseview;

import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;

/* loaded from: classes6.dex */
public class GradientOrientationUtils {
    public static GradientDrawable.Orientation getOrientation(String str) {
        try {
            return TextUtils.equals(str, GradientDrawable.Orientation.TOP_BOTTOM.name()) ? GradientDrawable.Orientation.TOP_BOTTOM : TextUtils.equals(str, GradientDrawable.Orientation.BL_TR.name()) ? GradientDrawable.Orientation.BL_TR : TextUtils.equals(str, GradientDrawable.Orientation.BOTTOM_TOP.name()) ? GradientDrawable.Orientation.BOTTOM_TOP : TextUtils.equals(str, GradientDrawable.Orientation.BR_TL.name()) ? GradientDrawable.Orientation.BR_TL : TextUtils.equals(str, GradientDrawable.Orientation.LEFT_RIGHT.name()) ? GradientDrawable.Orientation.LEFT_RIGHT : TextUtils.equals(str, GradientDrawable.Orientation.RIGHT_LEFT.name()) ? GradientDrawable.Orientation.RIGHT_LEFT : TextUtils.equals(str, GradientDrawable.Orientation.TL_BR.name()) ? GradientDrawable.Orientation.TL_BR : TextUtils.equals(str, GradientDrawable.Orientation.BR_TL.name()) ? GradientDrawable.Orientation.BR_TL : GradientDrawable.Orientation.TOP_BOTTOM;
        } catch (Exception unused) {
            return GradientDrawable.Orientation.TOP_BOTTOM;
        }
    }
}
