package com.google.android.gms.ads.internal.util;

import android.view.View;
import android.view.ViewParent;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes4.dex */
public final class zzac {
    public static boolean zza(View view) {
        for (ViewParent parent = view.getParent(); parent != null; parent = parent.getParent()) {
            if (parent.getClass().getName().startsWith("androidx.compose.ui")) {
                return true;
            }
        }
        return false;
    }
}
