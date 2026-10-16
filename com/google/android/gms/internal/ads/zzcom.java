package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzcom extends zzcra {
    private final zzcfg zzc;
    private final int zzd;
    private final Context zze;
    private final zzcoa zzf;
    private final zzdgn zzg;
    private final zzddh zzh;
    private final zzcwl zzi;
    private final boolean zzj;
    private final zzbzw zzk;
    private boolean zzl;

    zzcom(zzcqz zzcqzVar, Context context, zzcfg zzcfgVar, int i, zzcoa zzcoaVar, zzdgn zzdgnVar, zzddh zzddhVar, zzcwl zzcwlVar, zzbzw zzbzwVar) {
        super(zzcqzVar);
        this.zzl = false;
        this.zzc = zzcfgVar;
        this.zze = context;
        this.zzd = i;
        this.zzf = zzcoaVar;
        this.zzg = zzdgnVar;
        this.zzh = zzddhVar;
        this.zzi = zzcwlVar;
        this.zzj = ((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzfK)).booleanValue();
        this.zzk = zzbzwVar;
    }

    public final int zza() {
        return this.zzd;
    }

    @Override // com.google.android.gms.internal.ads.zzcra
    public final void zzb() {
        super.zzb();
        zzcfg zzcfgVar = this.zzc;
        if (zzcfgVar != null) {
            zzcfgVar.destroy();
        }
    }

    public final void zzc(zzbaq zzbaqVar) {
        zzcfg zzcfgVar = this.zzc;
        if (zzcfgVar != null) {
            zzcfgVar.zzak(zzbaqVar);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v13, types: [android.content.Context] */
    public final void zzd(Activity activity, zzbbd zzbbdVar, boolean z) throws RemoteException {
        zzcfg zzcfgVar;
        zzfca zzD;
        Activity activity2 = activity;
        if (activity == null) {
            activity2 = this.zze;
        }
        boolean z2 = this.zzj;
        if (z2) {
            this.zzh.zzb();
        }
        com.google.android.gms.ads.internal.zzv.zzr();
        zzdgn zzdgnVar = this.zzg;
        if (!com.google.android.gms.ads.internal.util.zzs.zzO(zzdgnVar.zza())) {
            if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzaQ)).booleanValue()) {
                com.google.android.gms.ads.internal.zzv.zzr();
                if (com.google.android.gms.ads.internal.util.zzs.zzH(activity2)) {
                    int i = com.google.android.gms.ads.internal.util.zze.zza;
                    com.google.android.gms.ads.internal.util.client.zzo.zzj("Interstitials that show when your app is in the background are a violation of AdMob policies and may lead to blocked ad serving. To learn more, visit https://goo.gle/admob-interstitial-policies");
                    this.zzi.zzd();
                    if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzaR)).booleanValue()) {
                        new zzfot(activity2.getApplicationContext(), com.google.android.gms.ads.internal.zzv.zzv().zzb()).zza(this.zza.zzb.zzb.zzb);
                        return;
                    }
                    return;
                }
            }
        }
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzmp)).booleanValue() && (zzcfgVar = this.zzc) != null && (zzD = zzcfgVar.zzD()) != null && zzD.zzar && zzD.zzas != this.zzk.zzb()) {
            int i2 = com.google.android.gms.ads.internal.util.zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zzj("The app open consent form has been shown.");
            this.zzi.zzc(zzfdx.zzd(12, "The consent form has already been shown.", null));
            return;
        }
        if (this.zzl) {
            int i3 = com.google.android.gms.ads.internal.util.zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zzj("App open interstitial ad is already visible.");
            this.zzi.zzc(zzfdx.zzd(10, null, null));
        }
        if (this.zzl) {
            return;
        }
        try {
            zzdgnVar.zzb(z, activity2, this.zzi);
            if (z2) {
                this.zzh.zza();
            }
            this.zzl = true;
        } catch (zzdgm e) {
            this.zzi.zze(e);
        }
    }

    public final void zze(long j, int i) {
        this.zzf.zza(j, i);
    }
}
