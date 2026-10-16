package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzans implements zzaoa {
    private zzz zza;
    private zzeu zzb;
    private zzafb zzc;

    public zzans(String str, String str2) {
        zzx zzxVar = new zzx();
        zzxVar.zzG("video/mp2t");
        zzxVar.zzah(str);
        this.zza = zzxVar.zzan();
    }

    @Override // com.google.android.gms.internal.ads.zzaoa
    public final void zza(zzen zzenVar) {
        zzdd.zzb(this.zzb);
        String str = zzex.zza;
        long zze = this.zzb.zze();
        long zzf = this.zzb.zzf();
        if (zze == -9223372036854775807L || zzf == -9223372036854775807L) {
            return;
        }
        zzz zzzVar = this.zza;
        if (zzf != zzzVar.zzt) {
            zzx zzb = zzzVar.zzb();
            zzb.zzal(zzf);
            zzz zzan = zzb.zzan();
            this.zza = zzan;
            this.zzc.zzm(zzan);
        }
        int zza = zzenVar.zza();
        this.zzc.zzr(zzenVar, zza);
        this.zzc.zzt(zze, 1, zza, 0, null);
    }

    @Override // com.google.android.gms.internal.ads.zzaoa
    public final void zzb(zzeu zzeuVar, zzady zzadyVar, zzaon zzaonVar) {
        this.zzb = zzeuVar;
        zzaonVar.zzc();
        zzafb zzw = zzadyVar.zzw(zzaonVar.zza(), 5);
        this.zzc = zzw;
        zzw.zzm(this.zza);
    }
}
