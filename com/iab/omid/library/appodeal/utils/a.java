package com.iab.omid.library.appodeal.utils;

import android.app.UiModeManager;
import android.content.Context;
import com.iab.omid.library.appodeal.adsession.DeviceCategory;

/* loaded from: classes4.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    private static UiModeManager f1906a;

    public static DeviceCategory a() {
        UiModeManager uiModeManager = f1906a;
        if (uiModeManager == null) {
            return DeviceCategory.OTHER;
        }
        int currentModeType = uiModeManager.getCurrentModeType();
        return currentModeType != 1 ? currentModeType != 4 ? DeviceCategory.OTHER : DeviceCategory.CTV : DeviceCategory.MOBILE;
    }

    public static void a(Context context) {
        if (context != null) {
            f1906a = (UiModeManager) context.getSystemService("uimode");
        }
    }
}
