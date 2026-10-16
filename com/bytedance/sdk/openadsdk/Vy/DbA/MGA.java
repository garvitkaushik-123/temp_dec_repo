package com.bytedance.sdk.openadsdk.Vy.DbA;

import android.view.View;
import com.bytedance.sdk.openadsdk.core.nro;

/* loaded from: classes3.dex */
public class MGA {
    public static boolean eli(View view, int i) {
        return eli(view, false, i);
    }

    public static boolean eli(View view, boolean z, int i) {
        if (view == null) {
            return false;
        }
        return nro.eli(view, z ? 30 : 50, i, false);
    }
}
