package com.unity3d.player;

import android.os.Build;

/* loaded from: classes7.dex */
public class PlatformSupport {
    static final boolean OREO_SUPPORT;
    static final boolean PIE_SUPPORT;
    static final boolean QUINCE_TART_SUPPORT;
    static final boolean RED_VELVET_CAKE_SUPPORT;
    static final boolean SNOW_CONE_SUPPORT;
    static final boolean TIRAMISU_SUPPORT;
    static final boolean UPSIDE_DOWN_CAKE_SUPPORT;
    static final boolean VANILLA_ICE_CREAM_SUPPORT;

    static {
        int i = Build.VERSION.SDK_INT;
        OREO_SUPPORT = true;
        PIE_SUPPORT = true;
        QUINCE_TART_SUPPORT = i >= 29;
        RED_VELVET_CAKE_SUPPORT = i >= 30;
        SNOW_CONE_SUPPORT = i >= 31;
        TIRAMISU_SUPPORT = i >= 33;
        UPSIDE_DOWN_CAKE_SUPPORT = i >= 34;
        VANILLA_ICE_CREAM_SUPPORT = i >= 35;
    }
}
