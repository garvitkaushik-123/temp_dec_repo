package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.pm.PackageManager;
import com.google.android.gms.ads.AdFormat;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.mbridge.msdk.MBridgeConstans;
import java.util.Locale;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzfkl {
    private final zzdsj zza;
    private final String zzb;

    zzfkl(zzdsj zzdsjVar, Context context) {
        CharSequence charSequence;
        this.zza = zzdsjVar;
        zzfrw zzfrwVar = com.google.android.gms.ads.internal.util.zzs.zza;
        try {
            charSequence = Wrappers.packageManager(context).getApplicationLabel(context.getPackageName());
        } catch (PackageManager.NameNotFoundException e) {
            int i = com.google.android.gms.ads.internal.util.zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zzk("Failed to get application name", e);
            charSequence = "";
        }
        this.zzb = charSequence.toString();
    }

    private final void zzq(String str, String str2, long j, int i, int i2, String str3, zzfkt zzfktVar, String str4) {
        zzdsi zza = this.zza.zza();
        zza.zzb(str2, Long.toString(j));
        zza.zzb(MBridgeConstans.DYNAMIC_VIEW_WX_APP, this.zzb);
        if (zzfktVar != null) {
            zza.zzb("ad_unit_id", zzfktVar.zzb());
            zza.zzb(FirebaseAnalytics.Param.AD_FORMAT, zzfktVar.zza());
            zza.zzb("pid", zzfktVar.zzc());
        }
        zza.zzb("action", str);
        if (str3 != null) {
            zza.zzb("gqi", str3);
        }
        if (i >= 0) {
            zza.zzb("max_ads", Integer.toString(i));
        }
        if (i2 >= 0) {
            zza.zzb("cache_size", Integer.toString(i2));
        }
        zza.zzb("pv", str4);
        zza.zzj();
    }

    private final void zzr(String str, long j, String str2, String str3, AdFormat adFormat, int i, int i2, int i3, String str4) {
        zzdsi zza = this.zza.zza();
        zza.zzb("action", str);
        zza.zzb("pat", Long.toString(j));
        zza.zzb(MBridgeConstans.DYNAMIC_VIEW_WX_APP, this.zzb);
        zza.zzb(FirebaseAnalytics.Param.AD_FORMAT, adFormat.name().toLowerCase(Locale.ENGLISH));
        zza.zzb("max_ads", Integer.toString(i));
        zza.zzb("cache_size", Integer.toString(i2));
        zza.zzb("pas", Integer.toString(i3));
        zza.zzb("pv", "2");
        zza.zzb("ad_unit_id", str3);
        zza.zzb("pid", str2);
        zza.zzj();
    }

    public final void zza(int i, int i2, long j, zzfkt zzfktVar) {
        zzdsi zza = this.zza.zza();
        zza.zzb("action", "cache_resize");
        zza.zzb("cs_ts", Long.toString(j));
        zza.zzb(MBridgeConstans.DYNAMIC_VIEW_WX_APP, this.zzb);
        zza.zzb("orig_ma", Integer.toString(i));
        zza.zzb("max_ads", Integer.toString(i2));
        zza.zzb(FirebaseAnalytics.Param.AD_FORMAT, zzfktVar.zza());
        zza.zzb("ad_unit_id", zzfktVar.zzb());
        zza.zzb("pid", zzfktVar.zzc());
        zza.zzb("pv", "1");
        zza.zzj();
    }

    public final void zzb(long j, String str, String str2, AdFormat adFormat, int i, int i2) {
        zzr("pd", j, str, str2, adFormat, i, i2, 1, "2");
    }

    public final void zzc(long j, AdFormat adFormat, int i) {
        zzr("pda", j, null, null, adFormat, -1, -1, i, "2");
    }

    public final void zzd(long j, String str, String str2, AdFormat adFormat, int i, int i2) {
        zzr("pgc", j, str, str2, adFormat, i, i2, 1, "2");
    }

    public final void zze(AdFormat adFormat, long j, int i) {
        zzr("pgcs", j, null, null, adFormat, -1, -1, i, "2");
    }

    public final void zzf(int i, long j, String str, String str2, AdFormat adFormat, int i2) {
        zzr("pnav", j, str, str2, adFormat, i2, i, 1, "2");
    }

    public final void zzg(long j, String str) {
        zzq("poll_ad", "ppacwe_ts", j, -1, -1, null, null, "2");
    }

    public final void zzh(int i, int i2, long j, Long l, String str, zzfkt zzfktVar, String str2) {
        zzdsi zza = this.zza.zza();
        zza.zzb("plaac_ts", Long.toString(j));
        zza.zzb(MBridgeConstans.DYNAMIC_VIEW_WX_APP, this.zzb);
        zza.zzb("max_ads", Integer.toString(i));
        zza.zzb("cache_size", Integer.toString(i2));
        zza.zzb("action", "is_ad_available");
        if (zzfktVar != null) {
            zza.zzb("ad_unit_id", zzfktVar.zzb());
            zza.zzb("pid", zzfktVar.zzc());
            zza.zzb(FirebaseAnalytics.Param.AD_FORMAT, zzfktVar.zza());
        }
        if (l != null) {
            zza.zzb("plaay_ts", Long.toString(l.longValue()));
        }
        if (str != null) {
            zza.zzb("gqi", str);
        }
        zza.zzb("pv", str2);
        zza.zzj();
    }

    public final void zzi(long j, String str, zzfkt zzfktVar, int i, int i2, String str2) {
        zzq("paa", "pano_ts", j, i, i2, str, zzfktVar, str2);
    }

    public final void zzj(long j, zzfkt zzfktVar, int i, String str) {
        zzq("pae", "paeo_ts", j, i, 0, null, zzfktVar, str);
    }

    public final void zzk(long j, zzfkt zzfktVar, com.google.android.gms.ads.internal.client.zze zzeVar, int i, int i2, String str) {
        zzdsi zza = this.zza.zza();
        zza.zzb("action", "pftla");
        zza.zzb("pftlat_ts", Long.toString(j));
        zza.zzb("pftlaec", Integer.toString(zzeVar.zza));
        zza.zzb(MBridgeConstans.DYNAMIC_VIEW_WX_APP, this.zzb);
        zza.zzb(FirebaseAnalytics.Param.AD_FORMAT, zzfktVar.zza());
        zza.zzb("max_ads", Integer.toString(i));
        zza.zzb("cache_size", Integer.toString(i2));
        zza.zzb("ad_unit_id", zzfktVar.zzb());
        zza.zzb("pid", zzfktVar.zzc());
        zza.zzb("pv", str);
        zza.zzj();
    }

    public final void zzl(long j, zzfkt zzfktVar, int i, int i2, String str) {
        zzq("poll_ad", "ppac_ts", j, i, i2, null, zzfktVar, str);
    }

    public final void zzm(long j, int i, int i2, String str, zzfkt zzfktVar, String str2) {
        zzdsi zza = this.zza.zza();
        zza.zzb("ppla_ts", Long.toString(j));
        zza.zzb(MBridgeConstans.DYNAMIC_VIEW_WX_APP, this.zzb);
        zza.zzb(FirebaseAnalytics.Param.AD_FORMAT, zzfktVar.zza());
        zza.zzb("ad_unit_id", zzfktVar.zzb());
        zza.zzb("pid", zzfktVar.zzc());
        zza.zzb("max_ads", Integer.toString(i));
        zza.zzb("cache_size", Integer.toString(i2));
        zza.zzb("action", "poll_ad");
        if (str != null) {
            zza.zzb("gqi", str);
        }
        zza.zzb("pv", str2);
        zza.zzj();
    }

    public final void zzn(long j, int i, int i2, String str, zzfkt zzfktVar, String str2) {
        zzq("poll_ad", "psvroc_ts", j, i, i2, str, zzfktVar, str2);
    }

    public final void zzo(Map map, long j, String str) {
        zzdsi zza = this.zza.zza();
        zza.zzb("action", "start_preload");
        zza.zzb("sp_ts", Long.toString(j));
        zza.zzb(MBridgeConstans.DYNAMIC_VIEW_WX_APP, this.zzb);
        zza.zzb("pv", "1");
        for (AdFormat adFormat : map.keySet()) {
            String valueOf = String.valueOf(adFormat.name().toLowerCase(Locale.ENGLISH));
            zza.zzb(valueOf.concat("_count"), Integer.toString(((Integer) map.get(adFormat)).intValue()));
        }
        zza.zzj();
    }

    public final void zzp(int i, long j, zzfkt zzfktVar, String str) {
        zzdsi zza = this.zza.zza();
        zza.zzb("action", "start_preload");
        zza.zzb("sp_ts", Long.toString(j));
        zza.zzb(MBridgeConstans.DYNAMIC_VIEW_WX_APP, this.zzb);
        zza.zzb(FirebaseAnalytics.Param.AD_FORMAT, zzfktVar.zza());
        zza.zzb("ad_unit_id", zzfktVar.zzb());
        zza.zzb("pid", zzfktVar.zzc());
        zza.zzb("max_ads", Integer.toString(i));
        zza.zzb("pv", str);
        zza.zzj();
    }
}
