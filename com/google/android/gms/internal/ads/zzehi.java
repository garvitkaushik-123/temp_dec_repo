package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.Iterator;
import java.util.Objects;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzehi implements zzgcu {
    private final zzfha zza;
    private final zzcwa zzb;
    private final zzfju zzc;
    private final zzfjy zzd;
    private final Executor zze;
    private final ScheduledExecutorService zzf;
    private final zzcrd zzg;
    private final zzehb zzh;
    private final zzedr zzi;
    private final Context zzj;
    private final zzfhu zzk;
    private final zzegl zzl;
    private final zzdsd zzm;

    zzehi(Context context, zzfha zzfhaVar, zzehb zzehbVar, zzcwa zzcwaVar, zzfju zzfjuVar, zzfjy zzfjyVar, zzcrd zzcrdVar, Executor executor, ScheduledExecutorService scheduledExecutorService, zzedr zzedrVar, zzfhu zzfhuVar, zzegl zzeglVar, zzdsd zzdsdVar) {
        this.zzj = context;
        this.zza = zzfhaVar;
        this.zzh = zzehbVar;
        this.zzb = zzcwaVar;
        this.zzc = zzfjuVar;
        this.zzd = zzfjyVar;
        this.zzg = zzcrdVar;
        this.zze = executor;
        this.zzf = scheduledExecutorService;
        this.zzi = zzedrVar;
        this.zzk = zzfhuVar;
        this.zzl = zzeglVar;
        this.zzm = zzdsdVar;
    }

    public static /* synthetic */ ListenableFuture zzb(zzehi zzehiVar, zzfca zzfcaVar, zzfcn zzfcnVar, zzedm zzedmVar, Throwable th) {
        zzfhj zza = zzfhi.zza(zzehiVar.zzj, 12);
        zza.zzd(zzfcaVar.zzE);
        zza.zzi();
        ListenableFuture zzo = zzgdn.zzo(zzedmVar.zza(zzfcnVar, zzfcaVar), zzfcaVar.zzR, TimeUnit.MILLISECONDS, zzehiVar.zzf);
        zzehiVar.zzh.zzf(zzfcnVar, zzfcaVar, zzo, zzehiVar.zzc);
        zzfht.zza(zzo, zzehiVar.zzk, zza);
        return zzo;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0039, code lost:
    
        if (((java.lang.Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(com.google.android.gms.internal.ads.zzbde.zzfP)).booleanValue() == false) goto L20;
     */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0059  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x005e A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    static String zzc(zzfcn zzfcnVar) {
        String str = "No fill.";
        String str2 = true != ((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzfQ)).booleanValue() ? "No ad config." : "No fill.";
        zzfcd zzfcdVar = zzfcnVar.zzb.zzb;
        int i = zzfcdVar.zzf;
        if (i != 0) {
            if (i < 200 || i >= 300) {
                if (i < 300 || i >= 400) {
                    str = "Received error HTTP response code: " + i;
                } else {
                    str = "No location header to follow redirect or too many redirects.";
                }
            }
            zzfcc zzfccVar = zzfcdVar.zzj;
            return zzfccVar == null ? zzfccVar.zza() : str;
        }
        str = str2;
        zzfcc zzfccVar2 = zzfcdVar.zzj;
        if (zzfccVar2 == null) {
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgcu
    public final /* synthetic */ ListenableFuture zza(Object obj) throws Exception {
        int i;
        Bundle bundle;
        final zzfcn zzfcnVar = (zzfcn) obj;
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzcq)).booleanValue() && (bundle = zzfcnVar.zzb.zzd) != null) {
            this.zzm.zza().putAll(bundle);
        }
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzcr)).booleanValue()) {
            this.zzm.zza().putLong(zzdrr.RENDERING_START.zza(), com.google.android.gms.ads.internal.zzv.zzD().currentTimeMillis());
        }
        String zzc = zzc(zzfcnVar);
        zzedr zzedrVar = this.zzi;
        zzfcm zzfcmVar = zzfcnVar.zzb;
        zzfcd zzfcdVar = zzfcmVar.zzb;
        zzedrVar.zzi(zzfcdVar);
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zziI)).booleanValue() && (i = zzfcdVar.zzf) != 0 && (i < 200 || i >= 300)) {
            return zzgdn.zzg(new zzehf(3, zzc));
        }
        String str = zzfcdVar.zzq;
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzdR)).booleanValue() || TextUtils.isEmpty(str)) {
            for (zzfca zzfcaVar : zzfcmVar.zza) {
                zzedrVar.zzd(zzfcaVar);
                Iterator it = zzfcaVar.zza.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        zzedrVar.zzf(zzfcaVar, 0L, zzfdx.zzd(1, null, null));
                        break;
                    }
                    zzedm zza = this.zzg.zza(zzfcaVar.zzb, (String) it.next());
                    if (zza == null || !zza.zzb(zzfcnVar, zzfcaVar)) {
                    }
                }
            }
        } else {
            zzedrVar.zzh(str, zzfcmVar.zza);
        }
        zzcwa zzcwaVar = this.zzb;
        zzcmu zzcmuVar = new zzcmu(zzfcnVar, this.zzd, this.zzc);
        Executor executor = this.zze;
        zzcwaVar.zzo(zzcmuVar, executor);
        if (zzfcdVar.zzr > 1) {
            return this.zzl.zzb(zzfcnVar);
        }
        String zzc2 = zzc(zzfcnVar);
        zzfha zzfhaVar = this.zza;
        zzfgu zzfguVar = zzfgu.RENDER_CONFIG_INIT;
        Objects.requireNonNull(zzfhaVar);
        zzfgg zza2 = zzfgk.zzc(zzgdn.zzg(new zzehf(3, zzc2)), zzfguVar, zzfhaVar).zza();
        final zzehb zzehbVar = this.zzh;
        zzehbVar.zzl();
        int i2 = 0;
        for (final zzfca zzfcaVar2 : zzfcmVar.zza) {
            Iterator it2 = zzfcaVar2.zza.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                String str2 = (String) it2.next();
                final zzedm zza3 = this.zzg.zza(zzfcaVar2.zzb, str2);
                if (zza3 != null && zza3.zzb(zzfcnVar, zzfcaVar2)) {
                    zza2 = zzfhaVar.zzb(zzfgu.RENDER_CONFIG_WATERFALL, zza2).zzh("render-config-" + i2 + "-" + str2).zzc(Throwable.class, new zzgcu() { // from class: com.google.android.gms.internal.ads.zzehg
                        @Override // com.google.android.gms.internal.ads.zzgcu
                        public final ListenableFuture zza(Object obj2) {
                            return zzehi.zzb(zzehi.this, zzfcaVar2, zzfcnVar, zza3, (Throwable) obj2);
                        }
                    }).zza();
                    break;
                }
            }
            i2++;
        }
        Objects.requireNonNull(zzehbVar);
        zza2.addListener(new Runnable() { // from class: com.google.android.gms.internal.ads.zzehh
            @Override // java.lang.Runnable
            public final void run() {
                zzehb.this.zzj();
            }
        }, executor);
        return zza2;
    }
}
