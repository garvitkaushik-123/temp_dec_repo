package com.google.android.gms.internal.ads;

import android.os.Bundle;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzdc {
    private static final String zzb;
    public final String zza;

    static {
        String str = zzex.zza;
        zzb = Integer.toString(0, 36);
    }

    public zzdc(String str) {
        this.zza = str;
    }

    public final Bundle zza() {
        Bundle bundle = new Bundle();
        bundle.putString(zzb, this.zza);
        return bundle;
    }
}
