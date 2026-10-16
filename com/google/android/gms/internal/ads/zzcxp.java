package com.google.android.gms.internal.ads;

import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzcxp implements zzhgr {
    private final zzhha zza;

    private zzcxp(zzhha zzhhaVar) {
        this.zza = zzhhaVar;
    }

    public static zzcxo zzc(Set set) {
        return new zzcxo(set);
    }

    public static zzcxp zzd(zzhha zzhhaVar) {
        return new zzcxp(zzhhaVar);
    }

    @Override // com.google.android.gms.internal.ads.zzhhg, com.google.android.gms.internal.ads.zzhhf
    /* renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final zzcxo zzb() {
        return new zzcxo(((zzhhd) this.zza).zzb());
    }
}
