package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzdmu {
    private final zzfcw zza;
    private final Executor zzb;
    private final zzdpj zzc;
    private final zzdoe zzd;
    private final Context zze;
    private final zzdsj zzf;
    private final zzfjy zzg;
    private final zzeca zzh;
    private final zzdsd zzi;

    public zzdmu(zzfcw zzfcwVar, Executor executor, zzdpj zzdpjVar, Context context, zzdsj zzdsjVar, zzfjy zzfjyVar, zzeca zzecaVar, zzdoe zzdoeVar, zzdsd zzdsdVar) {
        this.zza = zzfcwVar;
        this.zzb = executor;
        this.zzc = zzdpjVar;
        this.zze = context;
        this.zzf = zzdsjVar;
        this.zzg = zzfjyVar;
        this.zzh = zzecaVar;
        this.zzd = zzdoeVar;
        this.zzi = zzdsdVar;
    }

    public static /* synthetic */ ListenableFuture zza(zzdmu zzdmuVar, com.google.android.gms.ads.internal.zzb zzbVar, zzbya zzbyaVar, Object obj) {
        zzcfg zza = zzdmuVar.zzc.zza(com.google.android.gms.ads.internal.client.zzr.zzc(), null, null);
        final zzcaj zza2 = zzcaj.zza(zza);
        zzdmuVar.zzh(zza, zzbVar, zzbyaVar);
        zza.zzN().zzK(new zzcgx() { // from class: com.google.android.gms.internal.ads.zzdmm
            @Override // com.google.android.gms.internal.ads.zzcgx
            public final void zza() {
                zzcaj.this.zzb();
            }
        });
        zza.loadUrl((String) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzeb));
        return zza2;
    }

    public static /* synthetic */ ListenableFuture zzb(final zzdmu zzdmuVar, JSONObject jSONObject, final zzcfg zzcfgVar) {
        zzbmp zzbmpVar = zzdmuVar.zza.zzb;
        final zzcaj zza = zzcaj.zza(zzcfgVar);
        if (zzbmpVar != null) {
            zzcfgVar.zzaj(zzchd.zzd());
        } else {
            zzcfgVar.zzaj(zzchd.zze());
        }
        zzcfgVar.zzN().zzC(new zzcgw() { // from class: com.google.android.gms.internal.ads.zzdml
            @Override // com.google.android.gms.internal.ads.zzcgw
            public final void zza(boolean z, int i, String str, String str2) {
                zzdmu.zzg(zzdmu.this, zzcfgVar, zza, z, i, str, str2);
            }
        });
        zzcfgVar.zzp("google.afma.nativeAds.renderVideo", jSONObject);
        return zza;
    }

    public static /* synthetic */ ListenableFuture zzc(final zzdmu zzdmuVar, com.google.android.gms.ads.internal.client.zzr zzrVar, zzfca zzfcaVar, zzfcd zzfcdVar, com.google.android.gms.ads.internal.zzb zzbVar, zzbya zzbyaVar, String str, String str2, Object obj) {
        final zzcfg zza = zzdmuVar.zzc.zza(zzrVar, zzfcaVar, zzfcdVar);
        final zzcaj zza2 = zzcaj.zza(zza);
        if (zzdmuVar.zza.zzb != null) {
            zzdmuVar.zzh(zza, zzbVar, zzbyaVar);
            zza.zzaj(zzchd.zzd());
        } else {
            zzdob zzb = zzdmuVar.zzd.zzb();
            zzcgy zzN = zza.zzN();
            zzbcv zzbcvVar = zzbde.zznP;
            zzN.zzX(zzb, zzb, zzb, zzb, zzb, false, null, !((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbcvVar)).booleanValue() ? new com.google.android.gms.ads.internal.zzb(zzdmuVar.zze, null, null) : zzbVar, null, true != ((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbcvVar)).booleanValue() ? null : zzbyaVar, zzdmuVar.zzh, zzdmuVar.zzg, zzdmuVar.zzf, null, zzb, null, null, null, null);
            zzj(zza);
        }
        zza.zzN().zzC(new zzcgw() { // from class: com.google.android.gms.internal.ads.zzdmj
            @Override // com.google.android.gms.internal.ads.zzcgw
            public final void zza(boolean z, int i, String str3, String str4) {
                zzdmu.zzf(zzdmu.this, zza, zza2, z, i, str3, str4);
            }
        });
        zza.zzae(str, str2, null);
        return zza2;
    }

    public static /* synthetic */ void zzf(zzdmu zzdmuVar, zzcfg zzcfgVar, zzcaj zzcajVar, boolean z, int i, String str, String str2) {
        if (z) {
            com.google.android.gms.ads.internal.client.zzgc zzgcVar = zzdmuVar.zza.zza;
            if (zzgcVar != null && zzcfgVar.zzq() != null) {
                zzcfgVar.zzq().zzs(zzgcVar);
            }
            zzcajVar.zzb();
            return;
        }
        zzcajVar.zzd(new zzehf(1, "Html video Web View failed to load. Error code: " + i + ", Description: " + str + ", Failing URL: " + str2));
    }

    public static /* synthetic */ void zzg(zzdmu zzdmuVar, zzcfg zzcfgVar, zzcaj zzcajVar, boolean z, int i, String str, String str2) {
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzej)).booleanValue()) {
            zzdmuVar.zzi(zzcfgVar, zzcajVar);
            return;
        }
        if (z) {
            zzdmuVar.zzi(zzcfgVar, zzcajVar);
            return;
        }
        zzcajVar.zzd(new zzehf(1, "Native Video WebView failed to load. Error code: " + i + ", Description: " + str + ", Failing URL: " + str2));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void zzh(zzcfg zzcfgVar, com.google.android.gms.ads.internal.zzb zzbVar, zzbya zzbyaVar) {
        zzj(zzcfgVar);
        zzcfgVar.zzag("/video", zzbke.zzl);
        zzcfgVar.zzag("/videoMeta", zzbke.zzm);
        zzcfgVar.zzag("/precache", new zzcdo());
        zzcfgVar.zzag("/delayPageLoaded", zzbke.zzp);
        zzcfgVar.zzag("/instrument", zzbke.zzn);
        zzcfgVar.zzag("/log", zzbke.zzg);
        zzcfgVar.zzag("/click", new zzbjd(null, 0 == true ? 1 : 0));
        if (this.zza.zzb != null) {
            zzcfgVar.zzN().zzH(true);
            zzcfgVar.zzag("/open", new zzbkr(true != ((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zznP)).booleanValue() ? null : zzbVar, null, null, null, null));
        } else {
            zzcfgVar.zzN().zzH(false);
        }
        if (com.google.android.gms.ads.internal.zzv.zzo().zzp(zzcfgVar.getContext())) {
            Map hashMap = new HashMap();
            if (zzcfgVar.zzD() != null) {
                hashMap = zzcfgVar.zzD().zzaw;
            }
            zzcfgVar.zzag("/logScionEvent", new zzbkl(zzcfgVar.getContext(), hashMap));
        }
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zznP)).booleanValue()) {
            zzcfgVar.zzN().zzD(zzbVar);
            zzcfgVar.zzN().zzL(zzbyaVar);
        }
    }

    private final void zzi(zzcfg zzcfgVar, zzcaj zzcajVar) {
        com.google.android.gms.ads.internal.client.zzgc zzgcVar = this.zza.zza;
        if (zzgcVar != null && zzcfgVar.zzq() != null) {
            zzcfgVar.zzq().zzs(zzgcVar);
        }
        zzcajVar.zzb();
    }

    private static final void zzj(zzcfg zzcfgVar) {
        zzcfgVar.zzag("/videoClicked", zzbke.zzh);
        zzcfgVar.zzN().zzJ(true);
        zzcfgVar.zzag("/getNativeAdViewSignals", zzbke.zzs);
        zzcfgVar.zzag("/getNativeClickMeta", zzbke.zzt);
    }

    public final ListenableFuture zzd(final JSONObject jSONObject, final com.google.android.gms.ads.internal.zzb zzbVar, final zzbya zzbyaVar) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzcx)).booleanValue()) {
            this.zzi.zza().putLong(zzdrr.NATIVE_ASSETS_LOADING_VIDEO_START.zza(), com.google.android.gms.ads.internal.zzv.zzD().currentTimeMillis());
        }
        ListenableFuture zzh = zzgdn.zzh(null);
        zzgcu zzgcuVar = new zzgcu() { // from class: com.google.android.gms.internal.ads.zzdmo
            @Override // com.google.android.gms.internal.ads.zzgcu
            public final ListenableFuture zza(Object obj) {
                return zzdmu.zza(zzdmu.this, zzbVar, zzbyaVar, obj);
            }
        };
        Executor executor = this.zzb;
        return zzgdn.zzn(zzgdn.zzn(zzh, zzgcuVar, executor), new zzgcu() { // from class: com.google.android.gms.internal.ads.zzdmn
            @Override // com.google.android.gms.internal.ads.zzgcu
            public final ListenableFuture zza(Object obj) {
                return zzdmu.zzb(zzdmu.this, jSONObject, (zzcfg) obj);
            }
        }, executor);
    }

    public final ListenableFuture zze(final String str, final String str2, final zzfca zzfcaVar, final zzfcd zzfcdVar, final com.google.android.gms.ads.internal.client.zzr zzrVar, final com.google.android.gms.ads.internal.zzb zzbVar, final zzbya zzbyaVar) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzcx)).booleanValue()) {
            this.zzi.zza().putLong(zzdrr.NATIVE_ASSETS_LOADING_VIDEO_COMPOSITION_START.zza(), com.google.android.gms.ads.internal.zzv.zzD().currentTimeMillis());
        }
        return zzgdn.zzn(zzgdn.zzh(null), new zzgcu() { // from class: com.google.android.gms.internal.ads.zzdmk
            @Override // com.google.android.gms.internal.ads.zzgcu
            public final ListenableFuture zza(Object obj) {
                return zzdmu.zzc(zzdmu.this, zzrVar, zzfcaVar, zzfcdVar, zzbVar, zzbyaVar, str, str2, obj);
            }
        }, this.zzb);
    }
}
