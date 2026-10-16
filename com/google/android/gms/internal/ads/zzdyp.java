package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzdyp implements zzhgr {
    private final zzhha zza;

    private zzdyp(zzhha zzhhaVar) {
        this.zza = zzhhaVar;
    }

    public static zzdyp zzc(zzhha zzhhaVar) {
        return new zzdyp(zzhhaVar);
    }

    @Override // com.google.android.gms.internal.ads.zzhhg, com.google.android.gms.internal.ads.zzhhf
    /* renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final zzdyo zzb() {
        return new zzdyo(((zzchl) this.zza).zza());
    }
}
