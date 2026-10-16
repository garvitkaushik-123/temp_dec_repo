package com.google.android.gms.internal.ads;

import java.util.HashMap;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzaws extends zzauk {
    public Long zza;
    public Long zzb;

    public zzaws() {
    }

    public zzaws(String str) {
        HashMap zza = zza(str);
        if (zza != null) {
            this.zza = (Long) zza.get(0);
            this.zzb = (Long) zza.get(1);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzauk
    protected final HashMap zzb() {
        HashMap hashMap = new HashMap();
        hashMap.put(0, this.zza);
        hashMap.put(1, this.zzb);
        return hashMap;
    }
}
