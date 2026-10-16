package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import java.lang.ref.WeakReference;
import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzdon extends zzcra {
    private final Context zzc;
    private final WeakReference zzd;
    private final zzdgn zze;
    private final zzddh zzf;
    private final zzcwl zzg;
    private final zzcxs zzh;
    private final zzcrv zzi;
    private final zzbws zzj;
    private final zzfot zzk;
    private final zzfcp zzl;
    private boolean zzm;

    zzdon(zzcqz zzcqzVar, Context context, zzcfg zzcfgVar, zzdgn zzdgnVar, zzddh zzddhVar, zzcwl zzcwlVar, zzcxs zzcxsVar, zzcrv zzcrvVar, zzfca zzfcaVar, zzfot zzfotVar, zzfcp zzfcpVar) {
        super(zzcqzVar);
        this.zzm = false;
        this.zzc = context;
        this.zze = zzdgnVar;
        this.zzd = new WeakReference(zzcfgVar);
        this.zzf = zzddhVar;
        this.zzg = zzcwlVar;
        this.zzh = zzcxsVar;
        this.zzi = zzcrvVar;
        this.zzk = zzfotVar;
        zzbwo zzbwoVar = zzfcaVar.zzl;
        this.zzj = new zzbxm(zzbwoVar != null ? zzbwoVar.zza : "", zzbwoVar != null ? zzbwoVar.zzb : 1);
        this.zzl = zzfcpVar;
    }

    public final void finalize() throws Throwable {
        try {
            final zzcfg zzcfgVar = (zzcfg) this.zzd.get();
            if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzgU)).booleanValue()) {
                if (!this.zzm && zzcfgVar != null) {
                    zzgdy zzgdyVar = zzcaf.zzf;
                    Objects.requireNonNull(zzcfgVar);
                    zzgdyVar.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzdom
                        @Override // java.lang.Runnable
                        public final void run() {
                            zzcfg.this.destroy();
                        }
                    });
                }
            } else if (zzcfgVar != null) {
                zzcfgVar.destroy();
            }
        } finally {
            super.finalize();
        }
    }

    public final Bundle zza() {
        return this.zzh.zzb();
    }

    public final zzbws zzc() {
        return this.zzj;
    }

    public final zzfcp zzd() {
        return this.zzl;
    }

    public final boolean zze() {
        return this.zzi.zzg();
    }

    public final boolean zzf() {
        return this.zzm;
    }

    public final boolean zzg() {
        zzcfg zzcfgVar = (zzcfg) this.zzd.get();
        return (zzcfgVar == null || zzcfgVar.zzaG()) ? false : true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v3, types: [android.content.Context] */
    public final boolean zzh(boolean z, Activity activity) {
        com.google.android.gms.ads.internal.zzv.zzr();
        zzdgn zzdgnVar = this.zze;
        if (!com.google.android.gms.ads.internal.util.zzs.zzO(zzdgnVar.zza())) {
            if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzaQ)).booleanValue()) {
                com.google.android.gms.ads.internal.zzv.zzr();
                if (com.google.android.gms.ads.internal.util.zzs.zzH(this.zzc)) {
                    int i = com.google.android.gms.ads.internal.util.zze.zza;
                    com.google.android.gms.ads.internal.util.client.zzo.zzj("Rewarded ads that show when your app is in the background are a violation of AdMob policies and may lead to blocked ad serving. To learn more, visit https://goo.gle/admob-interstitial-policies");
                    this.zzg.zzd();
                    if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzaR)).booleanValue()) {
                        this.zzk.zza(this.zza.zzb.zzb.zzb);
                    }
                    return false;
                }
            }
        }
        if (this.zzm) {
            int i2 = com.google.android.gms.ads.internal.util.zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zzj("The rewarded ad have been showed.");
            this.zzg.zzc(zzfdx.zzd(10, null, null));
            return false;
        }
        this.zzm = true;
        zzddh zzddhVar = this.zzf;
        zzddhVar.zzb();
        Activity activity2 = activity;
        if (activity == null) {
            activity2 = this.zzc;
        }
        try {
            zzdgnVar.zzb(z, activity2, this.zzg);
            zzddhVar.zza();
            return true;
        } catch (zzdgm e) {
            this.zzg.zze(e);
            return false;
        }
    }
}
