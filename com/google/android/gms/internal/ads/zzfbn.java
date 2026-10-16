package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import android.util.Pair;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzfbn implements zzelo {
    private final Context zza;
    private final Executor zzb;
    private final zzche zzc;
    private final zzfbd zzd;
    private final zzezr zze;
    private final zzfco zzf;
    private final zzfhx zzg;
    private final zzfcu zzh;
    private ListenableFuture zzi;

    public zzfbn(Context context, Executor executor, zzche zzcheVar, zzezr zzezrVar, zzfbd zzfbdVar, zzfcu zzfcuVar, zzfco zzfcoVar) {
        this.zza = context;
        this.zzb = executor;
        this.zzc = zzcheVar;
        this.zze = zzezrVar;
        this.zzd = zzfbdVar;
        this.zzh = zzfcuVar;
        this.zzf = zzfcoVar;
        this.zzg = zzcheVar.zzy();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final zzdor zzk(zzezp zzezpVar) {
        zzdor zzh = this.zzc.zzh();
        zzcvf zzcvfVar = new zzcvf();
        zzcvfVar.zzf(this.zza);
        zzcvfVar.zzk(((zzfbl) zzezpVar).zza);
        zzcvfVar.zzj(this.zzf);
        zzh.zzd(zzcvfVar.zzl());
        zzh.zzc(new zzdbu().zzn());
        return zzh;
    }

    @Override // com.google.android.gms.internal.ads.zzelo
    public final boolean zza() {
        throw null;
    }

    @Override // com.google.android.gms.internal.ads.zzelo
    public final boolean zzb(com.google.android.gms.ads.internal.client.zzm zzmVar, String str, zzelm zzelmVar, zzeln zzelnVar) throws RemoteException {
        zzfhu zzfhuVar;
        zzbwj zzbwjVar = new zzbwj(zzmVar, str);
        String str2 = zzbwjVar.zzb;
        if (str2 == null) {
            int i = com.google.android.gms.ads.internal.util.zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zzg("Ad unit ID should not be null for rewarded video ad.");
            this.zzb.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzfbg
                @Override // java.lang.Runnable
                public final void run() {
                    zzfbn.this.zzd.zzdD(zzfdx.zzd(6, null, null));
                }
            });
            return false;
        }
        ListenableFuture listenableFuture = this.zzi;
        if (listenableFuture != null && !listenableFuture.isDone()) {
            return false;
        }
        if (((Boolean) zzbex.zzc.zze()).booleanValue()) {
            zzezr zzezrVar = this.zze;
            if (zzezrVar.zzd() != null) {
                zzfhu zzg = ((zzdos) zzezrVar.zzd()).zzg();
                zzg.zzi(5);
                com.google.android.gms.ads.internal.client.zzm zzmVar2 = zzbwjVar.zza;
                zzg.zzb(zzmVar2.zzp);
                zzg.zzf(zzmVar2.zzm);
                zzfhuVar = zzg;
                Context context = this.zza;
                com.google.android.gms.ads.internal.client.zzm zzmVar3 = zzbwjVar.zza;
                boolean z = zzmVar3.zzf;
                zzfdt.zza(context, z);
                if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzjp)).booleanValue() && z) {
                    this.zzc.zzk().zzo(true);
                }
                Bundle zza = zzdrt.zza(new Pair(zzdrr.PUBLIC_API_CALL.zza(), Long.valueOf(zzmVar3.zzz)), new Pair(zzdrr.DYNAMITE_ENTER.zza(), Long.valueOf(com.google.android.gms.ads.internal.zzv.zzD().currentTimeMillis())));
                zzfcu zzfcuVar = this.zzh;
                zzfcuVar.zzu(str2);
                zzfcuVar.zzt(com.google.android.gms.ads.internal.client.zzr.zzd());
                zzfcuVar.zzJ(zzmVar3);
                zzfcuVar.zzB(zza);
                zzfcw zzL = zzfcuVar.zzL();
                zzfhj zzb = zzfhi.zzb(context, zzfht.zzf(zzL), 5, zzmVar3);
                zzfbl zzfblVar = new zzfbl(null);
                zzfblVar.zza = zzL;
                ListenableFuture zzc = this.zze.zzc(new zzezs(zzfblVar, null), new zzezq() { // from class: com.google.android.gms.internal.ads.zzfbh
                    @Override // com.google.android.gms.internal.ads.zzezq
                    public final zzcvd zza(zzezp zzezpVar) {
                        zzdor zzk;
                        zzk = zzfbn.this.zzk(zzezpVar);
                        return zzk;
                    }
                }, null);
                this.zzi = zzc;
                zzgdn.zzr(zzc, new zzfbk(this, zzelnVar, zzfhuVar, zzb, zzfblVar), this.zzb);
                return true;
            }
        }
        zzfhuVar = null;
        Context context2 = this.zza;
        com.google.android.gms.ads.internal.client.zzm zzmVar32 = zzbwjVar.zza;
        boolean z2 = zzmVar32.zzf;
        zzfdt.zza(context2, z2);
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzjp)).booleanValue()) {
            this.zzc.zzk().zzo(true);
        }
        Bundle zza2 = zzdrt.zza(new Pair(zzdrr.PUBLIC_API_CALL.zza(), Long.valueOf(zzmVar32.zzz)), new Pair(zzdrr.DYNAMITE_ENTER.zza(), Long.valueOf(com.google.android.gms.ads.internal.zzv.zzD().currentTimeMillis())));
        zzfcu zzfcuVar2 = this.zzh;
        zzfcuVar2.zzu(str2);
        zzfcuVar2.zzt(com.google.android.gms.ads.internal.client.zzr.zzd());
        zzfcuVar2.zzJ(zzmVar32);
        zzfcuVar2.zzB(zza2);
        zzfcw zzL2 = zzfcuVar2.zzL();
        zzfhj zzb2 = zzfhi.zzb(context2, zzfht.zzf(zzL2), 5, zzmVar32);
        zzfbl zzfblVar2 = new zzfbl(null);
        zzfblVar2.zza = zzL2;
        ListenableFuture zzc2 = this.zze.zzc(new zzezs(zzfblVar2, null), new zzezq() { // from class: com.google.android.gms.internal.ads.zzfbh
            @Override // com.google.android.gms.internal.ads.zzezq
            public final zzcvd zza(zzezp zzezpVar) {
                zzdor zzk;
                zzk = zzfbn.this.zzk(zzezpVar);
                return zzk;
            }
        }, null);
        this.zzi = zzc2;
        zzgdn.zzr(zzc2, new zzfbk(this, zzelnVar, zzfhuVar, zzb2, zzfblVar2), this.zzb);
        return true;
    }

    final void zzj(int i) {
        this.zzh.zzq().zza(i);
    }
}
