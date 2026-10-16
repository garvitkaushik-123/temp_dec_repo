package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public abstract class zzzd {
    private zzzc zza;
    private zzzl zzb;

    public zzmc zze() {
        throw null;
    }

    public void zzj() {
        this.zza = null;
        this.zzb = null;
    }

    public void zzk(zze zzeVar) {
        throw null;
    }

    public boolean zzn() {
        throw null;
    }

    public abstract zzze zzo(zzmd[] zzmdVarArr, zzxk zzxkVar, zzvh zzvhVar, zzbl zzblVar) throws zzin;

    public abstract void zzp(Object obj);

    protected final zzzl zzq() {
        zzzl zzzlVar = this.zzb;
        zzdd.zzb(zzzlVar);
        return zzzlVar;
    }

    public final void zzr(zzzc zzzcVar, zzzl zzzlVar) {
        zzdd.zzf(this.zza == null);
        this.zza = zzzcVar;
        this.zzb = zzzlVar;
    }

    protected final void zzs() {
        zzzc zzzcVar = this.zza;
        if (zzzcVar != null) {
            zzzcVar.zzm();
        }
    }
}
