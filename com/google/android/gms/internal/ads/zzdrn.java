package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import android.text.TextUtils;
import androidx.browser.customtabs.CustomTabsCallback;
import androidx.core.app.NotificationCompat;
import com.google.android.gms.ads.MobileAds;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.ironsource.N6;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.regex.Pattern;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzdrn implements zzdax, com.google.android.gms.ads.internal.client.zza, zzcws, zzcwc, zzcyo {
    private final Context zzc;
    private final zzfdo zzd;
    private final zzdsj zze;
    private final zzfcn zzf;
    private final zzfca zzg;
    private final zzeca zzh;
    private final String zzi;
    private Boolean zzk;
    private long zzj = -1;
    final AtomicBoolean zza = new AtomicBoolean(false);
    final AtomicBoolean zzb = new AtomicBoolean(false);
    private final boolean zzl = ((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzgZ)).booleanValue();

    public zzdrn(Context context, zzfdo zzfdoVar, zzdsj zzdsjVar, zzfcn zzfcnVar, zzfca zzfcaVar, zzeca zzecaVar, String str) {
        this.zzc = context;
        this.zzd = zzfdoVar;
        this.zze = zzdsjVar;
        this.zzf = zzfcnVar;
        this.zzg = zzfcaVar;
        this.zzh = zzecaVar;
        this.zzi = str;
    }

    private final zzdsi zzf(String str) {
        zzfcn zzfcnVar = this.zzf;
        zzfcm zzfcmVar = zzfcnVar.zzb;
        zzdsi zza = this.zze.zza();
        zza.zzd(zzfcmVar.zzb);
        zzfca zzfcaVar = this.zzg;
        zza.zzc(zzfcaVar);
        zza.zzb("action", str);
        zza.zzb(FirebaseAnalytics.Param.AD_FORMAT, this.zzi.toUpperCase(Locale.ROOT));
        List list = zzfcaVar.zzt;
        if (!list.isEmpty()) {
            zza.zzb("ancn", (String) list.get(0));
        }
        if (zzfcaVar.zzb()) {
            zza.zzb("device_connectivity", true != com.google.android.gms.ads.internal.zzv.zzp().zzA(this.zzc) ? "offline" : CustomTabsCallback.ONLINE_EXTRAS_KEY);
            zza.zzb("event_timestamp", String.valueOf(com.google.android.gms.ads.internal.zzv.zzD().currentTimeMillis()));
            zza.zzb("offline_ad", "1");
        }
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzhg)).booleanValue()) {
            boolean zzf = com.google.android.gms.ads.nonagon.signalgeneration.zzaa.zzf(zzfcnVar);
            zza.zzb("scar", String.valueOf(zzf));
            if (zzf) {
                com.google.android.gms.ads.internal.client.zzm zzmVar = zzfcnVar.zza.zza.zzd;
                zza.zzb("ragent", zzmVar.zzp);
                zza.zzb("rtype", com.google.android.gms.ads.nonagon.signalgeneration.zzaa.zzb(com.google.android.gms.ads.nonagon.signalgeneration.zzaa.zzc(zzmVar)));
            }
        }
        return zza;
    }

    private final void zzg(zzdsi zzdsiVar) {
        if (!this.zzg.zzb()) {
            zzdsiVar.zzj();
            return;
        }
        this.zzh.zzd(new zzecc(com.google.android.gms.ads.internal.zzv.zzD().currentTimeMillis(), this.zzf.zzb.zzb.zzb, zzdsiVar.zze(), 2));
    }

    private final boolean zzh() {
        int i = this.zzg.zzb;
        return i == 2 || i == 5 || i == 6 || i == 7;
    }

    private final boolean zzi() {
        String str;
        if (this.zzk == null) {
            synchronized (this) {
                if (this.zzk == null) {
                    String str2 = (String) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzbF);
                    com.google.android.gms.ads.internal.zzv.zzr();
                    try {
                        str = com.google.android.gms.ads.internal.util.zzs.zzq(this.zzc);
                    } catch (RemoteException unused) {
                        str = null;
                    }
                    boolean z = false;
                    if (str2 != null && str != null) {
                        try {
                            z = Pattern.matches(str2, str);
                        } catch (RuntimeException e) {
                            com.google.android.gms.ads.internal.zzv.zzp().zzw(e, "CsiActionsListener.isPatternMatched");
                        }
                    }
                    this.zzk = Boolean.valueOf(z);
                }
            }
        }
        return this.zzk.booleanValue();
    }

    @Override // com.google.android.gms.ads.internal.client.zza
    public final void onAdClicked() {
        if (this.zzg.zzb()) {
            zzg(zzf("click"));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcwc
    public final void zzc(com.google.android.gms.ads.internal.client.zze zzeVar) {
        com.google.android.gms.ads.internal.client.zze zzeVar2;
        if (this.zzl) {
            zzdsi zzf = zzf("ifts");
            zzf.zzb("reason", N6.F1);
            int i = zzeVar.zza;
            String str = zzeVar.zzb;
            if (zzeVar.zzc.equals(MobileAds.ERROR_DOMAIN) && (zzeVar2 = zzeVar.zzd) != null && !zzeVar2.zzc.equals(MobileAds.ERROR_DOMAIN)) {
                com.google.android.gms.ads.internal.client.zze zzeVar3 = zzeVar.zzd;
                i = zzeVar3.zza;
                str = zzeVar3.zzb;
            }
            if (i >= 0) {
                zzf.zzb("arec", String.valueOf(i));
            }
            String zza = this.zzd.zza(str);
            if (zza != null) {
                zzf.zzb("areec", zza);
            }
            zzf.zzj();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcwc
    public final void zzd() {
        if (this.zzl) {
            zzdsi zzf = zzf("ifts");
            zzf.zzb("reason", "blocked");
            zzf.zzj();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdax
    public final void zzdp() {
        if (zzi()) {
            zzf("adapter_shown").zzj();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdax
    public final void zzdq() {
        if (zzi()) {
            zzdsi zzf = zzf("adapter_impression");
            zzf.zzb("imp_type", String.valueOf(this.zzg.zze));
            if (this.zzb.get()) {
                zzf.zzb("po", "1");
                zzf.zzb("pil", String.valueOf(com.google.android.gms.ads.internal.zzv.zzD().currentTimeMillis() - this.zzj));
            } else {
                zzf.zzb("po", "0");
            }
            if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zznL)).booleanValue() && zzh()) {
                com.google.android.gms.ads.internal.zzv.zzr();
                zzf.zzb("foreground", true != com.google.android.gms.ads.internal.util.zzs.zzH(this.zzc) ? "1" : "0");
                zzf.zzb("fg_show", true != this.zza.get() ? "0" : "1");
            }
            zzf.zzj();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcwc
    public final void zze(zzdgm zzdgmVar) {
        if (this.zzl) {
            zzdsi zzf = zzf("ifts");
            zzf.zzb("reason", "exception");
            if (!TextUtils.isEmpty(zzdgmVar.getMessage())) {
                zzf.zzb(NotificationCompat.CATEGORY_MESSAGE, zzdgmVar.getMessage());
            }
            zzf.zzj();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcws
    public final void zzt() {
        if (zzi() || this.zzg.zzb()) {
            zzdsi zzf = zzf("impression");
            zzf.zzb("imp_type", String.valueOf(this.zzg.zze));
            if (this.zzj > 0) {
                zzf.zzb("p_imp_l", String.valueOf(com.google.android.gms.ads.internal.zzv.zzD().currentTimeMillis() - this.zzj));
            }
            if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zznL)).booleanValue() && zzh()) {
                com.google.android.gms.ads.internal.zzv.zzr();
                zzf.zzb("foreground", true != com.google.android.gms.ads.internal.util.zzs.zzH(this.zzc) ? "1" : "0");
                zzf.zzb("fg_show", true != this.zza.get() ? "0" : "1");
            }
            zzg(zzf);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcyo
    public final void zzv() {
        if (zzi()) {
            this.zzb.set(true);
            this.zzj = com.google.android.gms.ads.internal.zzv.zzD().currentTimeMillis();
            zzdsi zzf = zzf("presentation");
            if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zznL)).booleanValue() && zzh()) {
                AtomicBoolean atomicBoolean = this.zza;
                com.google.android.gms.ads.internal.zzv.zzr();
                atomicBoolean.set(!com.google.android.gms.ads.internal.util.zzs.zzH(this.zzc));
                zzf.zzb("foreground", true != atomicBoolean.get() ? "0" : "1");
            }
            zzf.zzj();
        }
    }
}
