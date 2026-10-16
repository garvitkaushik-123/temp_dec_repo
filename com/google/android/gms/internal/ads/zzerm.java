package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzerm implements zzhgr {
    private final zzhha zza;

    private zzerm(zzhha zzhhaVar, zzhha zzhhaVar2) {
        this.zza = zzhhaVar2;
    }

    public static zzerm zzc(zzhha zzhhaVar, zzhha zzhhaVar2) {
        return new zzerm(zzhhaVar, zzhhaVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzhhg, com.google.android.gms.internal.ads.zzhhf
    /* renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final zzerk zzb() {
        return new zzerk(zzffu.zzc(), ((zzcvp) this.zza).zzc());
    }
}
