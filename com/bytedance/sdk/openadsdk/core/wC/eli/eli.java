package com.bytedance.sdk.openadsdk.core.wC.eli;

import android.content.Context;
import android.util.Pair;
import android.view.View;
import android.view.Window;
import com.bytedance.sdk.openadsdk.utils.SSo;

/* loaded from: classes3.dex */
public class eli {
    public static Pair<Float, Float> eli(Window window, int i) {
        View decorView = window.getDecorView();
        float[] fArr = {decorView.getWidth() - (decorView.getPaddingLeft() * 2), decorView.getHeight() - (decorView.getPaddingTop() * 2)};
        fArr[0] = SSo.Os(window.getContext(), fArr[0]);
        float Os = SSo.Os(window.getContext(), fArr[1]);
        fArr[1] = Os;
        if (fArr[0] < 10.0f || Os < 10.0f) {
            fArr = eli(window.getContext(), SSo.Os(window.getContext(), SSo.eli()), i);
        }
        float max = Math.max(fArr[0], fArr[1]);
        float min = Math.min(fArr[0], fArr[1]);
        if (i == 1) {
            fArr[0] = min;
            fArr[1] = max;
        } else {
            fArr[0] = max;
            fArr[1] = min;
        }
        return new Pair<>(Float.valueOf(fArr[0]), Float.valueOf(fArr[1]));
    }

    private static float[] eli(Context context, int i, int i2) {
        float eli = eli(context);
        float DbA = DbA(context);
        if ((i2 == 1) != (eli > DbA)) {
            float f = eli + DbA;
            DbA = f - DbA;
            eli = f - DbA;
        }
        if (i2 == 1) {
            eli -= i;
        } else {
            DbA -= i;
        }
        return new float[]{DbA, eli};
    }

    public static float eli(Context context) {
        return SSo.Os(context, SSo.nlS(context));
    }

    public static float DbA(Context context) {
        return SSo.Os(context, SSo.NU(context));
    }
}
