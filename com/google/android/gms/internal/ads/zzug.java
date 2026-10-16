package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.os.Looper;
import java.util.ArrayList;
import java.util.HashSet;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public abstract class zzug implements zzvj {
    private final ArrayList zza = new ArrayList(1);
    private final HashSet zzb = new HashSet(1);
    private final zzvr zzc = new zzvr();
    private final zzsc zzd = new zzsc();
    private Looper zze;
    private zzbl zzf;
    private zzph zzg;

    @Override // com.google.android.gms.internal.ads.zzvj
    public /* synthetic */ zzbl zzM() {
        return null;
    }

    protected final zzph zzb() {
        zzph zzphVar = this.zzg;
        zzdd.zzb(zzphVar);
        return zzphVar;
    }

    protected final zzsc zzc(zzvh zzvhVar) {
        return this.zzd.zza(0, zzvhVar);
    }

    protected final zzsc zzd(int i, zzvh zzvhVar) {
        return this.zzd.zza(0, zzvhVar);
    }

    protected final zzvr zze(zzvh zzvhVar) {
        return this.zzc.zza(0, zzvhVar);
    }

    protected final zzvr zzf(int i, zzvh zzvhVar) {
        return this.zzc.zza(0, zzvhVar);
    }

    @Override // com.google.android.gms.internal.ads.zzvj
    public final void zzg(Handler handler, zzsd zzsdVar) {
        this.zzd.zzb(handler, zzsdVar);
    }

    @Override // com.google.android.gms.internal.ads.zzvj
    public final void zzh(Handler handler, zzvs zzvsVar) {
        this.zzc.zzb(handler, zzvsVar);
    }

    @Override // com.google.android.gms.internal.ads.zzvj
    public final void zzi(zzvi zzviVar) {
        HashSet hashSet = this.zzb;
        boolean isEmpty = hashSet.isEmpty();
        hashSet.remove(zzviVar);
        if (isEmpty || !hashSet.isEmpty()) {
            return;
        }
        zzj();
    }

    protected void zzj() {
    }

    @Override // com.google.android.gms.internal.ads.zzvj
    public final void zzk(zzvi zzviVar) {
        this.zze.getClass();
        HashSet hashSet = this.zzb;
        boolean isEmpty = hashSet.isEmpty();
        hashSet.add(zzviVar);
        if (isEmpty) {
            zzl();
        }
    }

    protected void zzl() {
    }

    @Override // com.google.android.gms.internal.ads.zzvj
    public final void zzm(zzvi zzviVar, zzhj zzhjVar, zzph zzphVar) {
        Looper myLooper = Looper.myLooper();
        Looper looper = this.zze;
        boolean z = true;
        if (looper != null && looper != myLooper) {
            z = false;
        }
        zzdd.zzd(z);
        this.zzg = zzphVar;
        zzbl zzblVar = this.zzf;
        this.zza.add(zzviVar);
        if (this.zze == null) {
            this.zze = myLooper;
            this.zzb.add(zzviVar);
            zzn(zzhjVar);
        } else if (zzblVar != null) {
            zzk(zzviVar);
            zzviVar.zza(this, zzblVar);
        }
    }

    protected abstract void zzn(zzhj zzhjVar);

    protected final void zzo(zzbl zzblVar) {
        this.zzf = zzblVar;
        ArrayList arrayList = this.zza;
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            ((zzvi) arrayList.get(i)).zza(this, zzblVar);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzvj
    public final void zzp(zzvi zzviVar) {
        ArrayList arrayList = this.zza;
        arrayList.remove(zzviVar);
        if (!arrayList.isEmpty()) {
            zzi(zzviVar);
            return;
        }
        this.zze = null;
        this.zzf = null;
        this.zzg = null;
        this.zzb.clear();
        zzq();
    }

    protected abstract void zzq();

    @Override // com.google.android.gms.internal.ads.zzvj
    public final void zzr(zzsd zzsdVar) {
        this.zzd.zzc(zzsdVar);
    }

    @Override // com.google.android.gms.internal.ads.zzvj
    public final void zzs(zzvs zzvsVar) {
        this.zzc.zzi(zzvsVar);
    }

    @Override // com.google.android.gms.internal.ads.zzvj
    public /* synthetic */ void zzt(zzap zzapVar) {
        throw null;
    }

    protected final boolean zzu() {
        return !this.zzb.isEmpty();
    }

    @Override // com.google.android.gms.internal.ads.zzvj
    public /* synthetic */ boolean zzv() {
        return true;
    }
}
