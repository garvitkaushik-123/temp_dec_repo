package com.google.android.gms.internal.ads;

import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzcrc implements zzcrd {
    private final Map zza;

    zzcrc(Map map) {
        this.zza = map;
    }

    @Override // com.google.android.gms.internal.ads.zzcrd
    public final zzedm zza(int i, String str) {
        return (zzedm) this.zza.get(str);
    }
}
