package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzwo implements zzvg {
    private final zzgi zza;
    private int zzb;
    private final zzwn zzc;
    private final zzzq zzd;

    public zzwo(zzgi zzgiVar, zzwn zzwnVar) {
        zzzq zzzqVar = new zzzq(-1);
        this.zza = zzgiVar;
        this.zzc = zzwnVar;
        this.zzd = zzzqVar;
        this.zzb = 1048576;
    }

    public final zzwo zza(int i) {
        this.zzb = i;
        return this;
    }

    public final zzwq zzb(zzap zzapVar) {
        zzapVar.zzb.getClass();
        return new zzwq(zzapVar, this.zza, this.zzc, zzsh.zza, this.zzd, this.zzb, 0, null, null, null);
    }
}
