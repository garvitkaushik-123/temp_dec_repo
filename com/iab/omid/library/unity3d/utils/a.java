package com.iab.omid.library.unity3d.utils;

import android.app.UiModeManager;
import android.content.Context;
import com.iab.omid.library.unity3d.adsession.DeviceCategory;

/* loaded from: classes4.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    private static UiModeManager f2124a;

    public static DeviceCategory a() {
        UiModeManager uiModeManager = f2124a;
        if (uiModeManager == null) {
            return DeviceCategory.OTHER;
        }
        int currentModeType = uiModeManager.getCurrentModeType();
        return currentModeType != 1 ? currentModeType != 4 ? DeviceCategory.OTHER : DeviceCategory.CTV : DeviceCategory.MOBILE;
    }

    public static void a(Context context) {
        if (context != null) {
            f2124a = (UiModeManager) context.getSystemService("uimode");
        }
    }
}
