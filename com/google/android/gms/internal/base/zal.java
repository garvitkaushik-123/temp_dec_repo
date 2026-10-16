package com.google.android.gms.internal.base;

import android.os.Build;

/* compiled from: com.google.android.gms:play-services-base@@18.6.0 */
/* loaded from: classes5.dex */
public final class zal {
    public static final int zaa;

    static {
        zaa = Build.VERSION.SDK_INT >= 31 ? 33554432 : 0;
    }
}
