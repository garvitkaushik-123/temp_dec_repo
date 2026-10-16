package com.unity3d.player;

import android.app.Activity;
import android.content.pm.ApplicationInfo;
import io.bidmachine.Framework;

/* loaded from: classes7.dex */
class DisplayCutoutSupport {
    private static final String CMD_ARG_FORCE_RENDER_OUTSIDE_SAFEAREA = "-force-render-outside-safearea=";
    private static final String RENDER_OUTSIDE_SAFEAREA = "unity.render-outside-safearea";
    private static int s_DisplayCutoutSupport = -1;

    DisplayCutoutSupport() {
    }

    static boolean getDisplayCutoutSupport(Activity activity) {
        ApplicationInfo applicationInfo;
        int i = s_DisplayCutoutSupport;
        if (i != -1) {
            return i == 1;
        }
        try {
            String stringExtra = activity.getIntent().getStringExtra(Framework.UNITY);
            if (stringExtra != null) {
                if (stringExtra.contains("-force-render-outside-safearea=true")) {
                    s_DisplayCutoutSupport = 1;
                } else if (stringExtra.contains("-force-render-outside-safearea=false")) {
                    s_DisplayCutoutSupport = 0;
                }
            }
            if (s_DisplayCutoutSupport == -1 && (applicationInfo = activity.getPackageManager().getApplicationInfo(activity.getPackageName(), 128)) != null) {
                s_DisplayCutoutSupport = applicationInfo.metaData.getBoolean(RENDER_OUTSIDE_SAFEAREA) ? 1 : 0;
            }
        } catch (Exception unused) {
            s_DisplayCutoutSupport = 0;
        }
        return s_DisplayCutoutSupport == 1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void setLayoutCutoutMode(Activity activity) {
        int i;
        if (activity == null || activity.getWindow() == null || !PlatformSupport.PIE_SUPPORT) {
            return;
        }
        if (!PlatformSupport.VANILLA_ICE_CREAM_SUPPORT) {
            if (PlatformSupport.RED_VELVET_CAKE_SUPPORT) {
                if (!getDisplayCutoutSupport(activity)) {
                    i = 0;
                }
            } else {
                i = getDisplayCutoutSupport(activity);
            }
            activity.getWindow().getAttributes().layoutInDisplayCutoutMode = i;
        }
        i = 3;
        activity.getWindow().getAttributes().layoutInDisplayCutoutMode = i;
    }
}
