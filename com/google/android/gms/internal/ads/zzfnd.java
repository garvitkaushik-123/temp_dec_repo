package com.google.android.gms.internal.ads;

import android.app.UiModeManager;
import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzfnd {
    private static UiModeManager zza;

    public static zzflr zza() {
        UiModeManager uiModeManager = zza;
        if (uiModeManager == null) {
            return zzflr.OTHER;
        }
        int currentModeType = uiModeManager.getCurrentModeType();
        return currentModeType != 1 ? currentModeType != 4 ? zzflr.OTHER : zzflr.CTV : zzflr.MOBILE;
    }

    public static void zzb(Context context) {
        if (context != null) {
            zza = (UiModeManager) context.getSystemService("uimode");
        }
    }
}
