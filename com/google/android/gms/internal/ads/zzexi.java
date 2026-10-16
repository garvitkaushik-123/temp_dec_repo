package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import android.util.Pair;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.common.internal.Preconditions;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public abstract class zzexi implements zzelo {
    protected final zzche zza;
    private final Context zzb;
    private final Executor zzc;
    private final zzexy zzd;
    private final zzezr zze;
    private final VersionInfoParcel zzf;
    private final ViewGroup zzg;
    private final zzfhx zzh;
    private final zzfcu zzi;

    @Nullable
    private ListenableFuture zzj;

    protected zzexi(Context context, Executor executor, zzche zzcheVar, zzezr zzezrVar, zzexy zzexyVar, zzfcu zzfcuVar, VersionInfoParcel versionInfoParcel) {
        this.zzb = context;
        this.zzc = executor;
        this.zza = zzcheVar;
        this.zze = zzezrVar;
        this.zzd = zzexyVar;
        this.zzi = zzfcuVar;
        this.zzf = versionInfoParcel;
        this.zzg = new FrameLayout(context);
        this.zzh = zzcheVar.zzy();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final synchronized zzcvd zzm(zzezp zzezpVar) {
        zzexg zzexgVar = (zzexg) zzezpVar;
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zziB)).booleanValue()) {
            zzcop zzcopVar = new zzcop(this.zzg);
            zzcvf zzcvfVar = new zzcvf();
            zzcvfVar.zzf(this.zzb);
            zzcvfVar.zzk(zzexgVar.zza);
            zzcvh zzl = zzcvfVar.zzl();
            zzdbu zzdbuVar = new zzdbu();
            zzexy zzexyVar = this.zzd;
            Executor executor = this.zzc;
            zzdbuVar.zzc(zzexyVar, executor);
            zzdbuVar.zzl(zzexyVar, executor);
            return zze(zzcopVar, zzl, zzdbuVar.zzn());
        }
        zzexy zzi = zzexy.zzi(this.zzd);
        zzdbu zzdbuVar2 = new zzdbu();
        Executor executor2 = this.zzc;
        zzdbuVar2.zzb(zzi, executor2);
        zzdbuVar2.zzg(zzi, executor2);
        zzdbuVar2.zzh(zzi, executor2);
        zzdbuVar2.zzi(zzi, executor2);
        zzdbuVar2.zzc(zzi, executor2);
        zzdbuVar2.zzl(zzi, executor2);
        zzdbuVar2.zzm(zzi);
        zzcop zzcopVar2 = new zzcop(this.zzg);
        zzcvf zzcvfVar2 = new zzcvf();
        zzcvfVar2.zzf(this.zzb);
        zzcvfVar2.zzk(zzexgVar.zza);
        return zze(zzcopVar2, zzcvfVar2.zzl(), zzdbuVar2.zzn());
    }

    @Override // com.google.android.gms.internal.ads.zzelo
    public final boolean zza() {
        ListenableFuture listenableFuture = this.zzj;
        return (listenableFuture == null || listenableFuture.isDone()) ? false : true;
    }

    @Override // com.google.android.gms.internal.ads.zzelo
    public final synchronized boolean zzb(com.google.android.gms.ads.internal.client.zzm zzmVar, String str, zzelm zzelmVar, zzeln zzelnVar) throws RemoteException {
        Throwable th;
        boolean z;
        zzfhu zzfhuVar;
        zzcoc zzcocVar;
        try {
            try {
                if (!zzmVar.zzb()) {
                    if (((Boolean) zzbfc.zzd.zze()).booleanValue()) {
                        try {
                            if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzlE)).booleanValue()) {
                                z = true;
                                if (this.zzf.clientJarVersion >= ((Integer) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzlF)).intValue() || !z) {
                                    Preconditions.checkMainThread("loadAd must be called on the main UI thread.");
                                }
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            throw th;
                        }
                    }
                    z = false;
                    if (this.zzf.clientJarVersion >= ((Integer) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzlF)).intValue()) {
                    }
                    Preconditions.checkMainThread("loadAd must be called on the main UI thread.");
                }
                if (str == null) {
                    int i = com.google.android.gms.ads.internal.util.zze.zza;
                    com.google.android.gms.ads.internal.util.client.zzo.zzg("Ad unit ID should not be null for app open ad.");
                    this.zzc.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzexc
                        @Override // java.lang.Runnable
                        public final void run() {
                            zzexi.this.zzd.zzdD(zzfdx.zzd(6, null, null));
                        }
                    });
                    return false;
                }
                if (this.zzj != null) {
                    return false;
                }
                if (!((Boolean) zzbex.zzc.zze()).booleanValue() || (zzcocVar = (zzcoc) this.zze.zzd()) == null) {
                    zzfhuVar = null;
                } else {
                    zzfhu zzg = zzcocVar.zzg();
                    zzg.zzi(7);
                    zzg.zzb(zzmVar.zzp);
                    zzg.zzf(zzmVar.zzm);
                    zzfhuVar = zzg;
                }
                Context context = this.zzb;
                boolean z2 = zzmVar.zzf;
                zzfdt.zza(context, z2);
                if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzjp)).booleanValue() && z2) {
                    this.zza.zzk().zzo(true);
                }
                Bundle zza = zzdrt.zza(new Pair(zzdrr.PUBLIC_API_CALL.zza(), Long.valueOf(zzmVar.zzz)), new Pair(zzdrr.DYNAMITE_ENTER.zza(), Long.valueOf(com.google.android.gms.ads.internal.zzv.zzD().currentTimeMillis())));
                zzfcu zzfcuVar = this.zzi;
                zzfcuVar.zzu(str);
                zzfcuVar.zzt(com.google.android.gms.ads.internal.client.zzr.zzb());
                zzfcuVar.zzJ(zzmVar);
                zzfcuVar.zzB(zza);
                zzfcw zzL = zzfcuVar.zzL();
                zzfhj zzb = zzfhi.zzb(context, zzfht.zzf(zzL), 7, zzmVar);
                zzexg zzexgVar = new zzexg(null);
                zzexgVar.zza = zzL;
                ListenableFuture zzc = this.zze.zzc(new zzezs(zzexgVar, null), new zzezq() { // from class: com.google.android.gms.internal.ads.zzexd
                    @Override // com.google.android.gms.internal.ads.zzezq
                    public final zzcvd zza(zzezp zzezpVar) {
                        zzcvd zzm;
                        zzm = zzexi.this.zzm(zzezpVar);
                        return zzm;
                    }
                }, null);
                this.zzj = zzc;
                zzgdn.zzr(zzc, new zzexf(this, zzelnVar, zzfhuVar, zzb, zzexgVar), this.zzc);
                return true;
            } catch (Throwable th3) {
                th = th3;
                th = th;
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
        }
    }

    protected abstract zzcvd zze(zzcop zzcopVar, zzcvh zzcvhVar, zzdbw zzdbwVar);

    public final void zzl(com.google.android.gms.ads.internal.client.zzx zzxVar) {
        this.zzi.zzv(zzxVar);
    }
}
