package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzcju implements zzhgr {
    private final zzcjt zza;

    private zzcju(zzcjt zzcjtVar) {
        this.zza = zzcjtVar;
    }

    public static com.google.android.gms.ads.internal.zza zzc(zzcjt zzcjtVar) {
        return new com.google.android.gms.ads.internal.zza(new zzccy(), new zzcbt());
    }

    public static zzcju zzd(zzcjt zzcjtVar) {
        return new zzcju(zzcjtVar);
    }

    public final com.google.android.gms.ads.internal.zza zza() {
        return zzc(this.zza);
    }

    @Override // com.google.android.gms.internal.ads.zzhhg, com.google.android.gms.internal.ads.zzhhf
    public final /* synthetic */ Object zzb() {
        return zzc(this.zza);
    }
}
