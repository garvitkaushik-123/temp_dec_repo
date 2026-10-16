package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzeoc implements zzhgr {
    private final zzhha zza;

    private zzeoc(zzhha zzhhaVar, zzhha zzhhaVar2) {
        this.zza = zzhhaVar;
    }

    public static zzeoc zzc(zzhha zzhhaVar, zzhha zzhhaVar2) {
        return new zzeoc(zzhhaVar, zzhhaVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzhhg, com.google.android.gms.internal.ads.zzhhf
    /* renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final zzeoa zzb() {
        return new zzeoa(((zzchz) this.zza).zza(), zzffu.zzc());
    }
}
