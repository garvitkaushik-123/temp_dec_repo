package com.unity3d.player;

import android.app.Activity;

/* loaded from: classes7.dex */
public class MultiWindowSupport {
    private static boolean s_LastMultiWindowMode = false;

    public static boolean isInMultiWindowMode(Activity activity) {
        if (activity == null) {
            return false;
        }
        return activity.isInMultiWindowMode();
    }

    public static void saveMultiWindowMode(Activity activity) {
        s_LastMultiWindowMode = isInMultiWindowMode(activity);
    }

    public static boolean isMultiWindowModeChangedToTrue(Activity activity) {
        return !s_LastMultiWindowMode && isInMultiWindowMode(activity);
    }
}
