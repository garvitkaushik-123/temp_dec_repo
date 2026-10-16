package com.ironsource.unity.androidbridge;

import com.unity3d.mediation.LevelPlayAdSize;
import com.unity3d.player.UnityPlayer;

/* loaded from: classes6.dex */
public class BannerUtils {
    public static LevelPlayAdSize getAdaptiveAdSize(int i) {
        return LevelPlayAdSize.createAdaptiveAdSize(UnityPlayer.currentActivity, Integer.valueOf(i));
    }
}
