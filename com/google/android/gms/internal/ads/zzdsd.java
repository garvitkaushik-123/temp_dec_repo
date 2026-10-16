package com.google.android.gms.internal.ads;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzdsd {
    private final ConcurrentHashMap zza;
    private final zzbzw zzb;
    private final zzfcw zzc;
    private final String zzd;
    private final String zze;
    private final com.google.android.gms.ads.internal.zzk zzf;
    private final Bundle zzg = new Bundle();
    private final Context zzh;

    public zzdsd(Context context, zzdso zzdsoVar, zzbzw zzbzwVar, zzfcw zzfcwVar, String str, String str2, com.google.android.gms.ads.internal.zzk zzkVar) {
        ActivityManager.MemoryInfo zzc;
        ConcurrentHashMap zzc2 = zzdsoVar.zzc();
        this.zza = zzc2;
        this.zzb = zzbzwVar;
        this.zzc = zzfcwVar;
        this.zzd = str;
        this.zze = str2;
        this.zzf = zzkVar;
        this.zzh = context;
        zzc2.put(FirebaseAnalytics.Param.AD_FORMAT, str2.toUpperCase(Locale.ROOT));
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzjW)).booleanValue()) {
            int zzp = zzkVar.zzp();
            int i = zzp - 1;
            if (zzp == 0) {
                throw null;
            }
            zzc2.put("asv", i != 0 ? i != 1 ? "na" : "2" : "1");
        }
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzcq)).booleanValue()) {
            Runtime runtime = Runtime.getRuntime();
            zzd("rt_f", String.valueOf(runtime.freeMemory()));
            zzd("rt_m", String.valueOf(runtime.maxMemory()));
            zzd("rt_t", String.valueOf(runtime.totalMemory()));
            zzd("wv_c", String.valueOf(com.google.android.gms.ads.internal.zzv.zzp().zzb()));
            if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzcy)).booleanValue() && (zzc = com.google.android.gms.ads.internal.util.client.zzf.zzc(context)) != null) {
                zzd("mem_avl", String.valueOf(zzc.availMem));
                zzd("mem_tt", String.valueOf(zzc.totalMem));
                zzd("low_m", true != zzc.lowMemory ? "0" : "1");
            }
        }
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzhg)).booleanValue()) {
            int zzg = com.google.android.gms.ads.nonagon.signalgeneration.zzaa.zzg(zzfcwVar) - 1;
            if (zzg == 0) {
                zzc2.put("request_id", str);
                zzc2.put("scar", "false");
                return;
            }
            if (zzg == 1) {
                zzc2.put("request_id", str);
                zzc2.put("se", "query_g");
            } else if (zzg == 2) {
                zzc2.put("se", "r_adinfo");
            } else if (zzg != 3) {
                zzc2.put("se", "r_both");
            } else {
                zzc2.put("se", "r_adstring");
            }
            zzc2.put("scar", "true");
            zzd("ragent", zzfcwVar.zzd.zzp);
            zzd("rtype", com.google.android.gms.ads.nonagon.signalgeneration.zzaa.zzb(com.google.android.gms.ads.nonagon.signalgeneration.zzaa.zzc(zzfcwVar.zzd)));
        }
    }

    public final Bundle zza() {
        return this.zzg;
    }

    public final Map zzb() {
        return this.zza;
    }

    public final void zzc() {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zznG)).booleanValue()) {
            zzd("brr", true != this.zzc.zzp ? "0" : "1");
        }
    }

    public final void zzd(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        this.zza.put(str, str2);
    }

    public final void zze(zzfcn zzfcnVar) {
        zzfcm zzfcmVar = zzfcnVar.zzb;
        List list = zzfcmVar.zza;
        if (!list.isEmpty()) {
            int i = ((zzfca) list.get(0)).zzb;
            zzd(FirebaseAnalytics.Param.AD_FORMAT, zzfca.zza(i));
            if (i == 6) {
                this.zza.put("as", true != this.zzb.zzm() ? "0" : "1");
            }
        }
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzcs)).booleanValue()) {
            zzd("mwl", Integer.toString(list.size()));
        }
        zzd("gqi", zzfcmVar.zzb.zzb);
    }

    public final void zzf(Bundle bundle) {
        if (bundle == null) {
            return;
        }
        if (bundle.containsKey("cnt")) {
            zzd("network_coarse", Integer.toString(bundle.getInt("cnt")));
        }
        if (bundle.containsKey("gnt")) {
            zzd("network_fine", Integer.toString(bundle.getInt("gnt")));
        }
    }
}
