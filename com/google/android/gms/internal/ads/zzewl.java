package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzewl implements zzhgr {
    private final zzewi zza;

    private zzewl(zzewi zzewiVar) {
        this.zza = zzewiVar;
    }

    public static zzewl zza(zzewi zzewiVar) {
        return new zzewl(zzewiVar);
    }

    public static boolean zzd(zzewi zzewiVar) {
        return zzewiVar.zzi();
    }

    @Override // com.google.android.gms.internal.ads.zzhhg, com.google.android.gms.internal.ads.zzhhf
    /* renamed from: zzc, reason: merged with bridge method [inline-methods] */
    public final Boolean zzb() {
        return Boolean.valueOf(this.zza.zzi());
    }
}
