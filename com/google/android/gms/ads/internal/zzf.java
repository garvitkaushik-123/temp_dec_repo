package com.google.android.gms.ads.internal;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.client.zzbd;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.android.gms.internal.ads.zzbcv;
import com.google.android.gms.internal.ads.zzbde;
import com.google.android.gms.internal.ads.zzbom;
import com.google.android.gms.internal.ads.zzboq;
import com.google.android.gms.internal.ads.zzbot;
import com.google.android.gms.internal.ads.zzbow;
import com.google.android.gms.internal.ads.zzbzm;
import com.google.android.gms.internal.ads.zzcaf;
import com.google.android.gms.internal.ads.zzcai;
import com.google.android.gms.internal.ads.zzdsi;
import com.google.android.gms.internal.ads.zzdsj;
import com.google.android.gms.internal.ads.zzfhi;
import com.google.android.gms.internal.ads.zzfhj;
import com.google.android.gms.internal.ads.zzfhx;
import com.google.android.gms.internal.ads.zzgcu;
import com.google.android.gms.internal.ads.zzgdn;
import com.google.android.gms.internal.ads.zzgdy;
import com.google.common.util.concurrent.ListenableFuture;
import com.mbridge.msdk.MBridgeConstans;
import javax.annotation.ParametersAreNonnullByDefault;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
@ParametersAreNonnullByDefault
/* loaded from: classes4.dex */
public final class zzf {
    private Context zza;
    private long zzb = 0;

    public static /* synthetic */ ListenableFuture zza(zzf zzfVar, Long l, zzdsj zzdsjVar, zzfhj zzfhjVar, zzfhx zzfhxVar, JSONObject jSONObject) {
        boolean optBoolean = jSONObject.optBoolean("isSuccessful", false);
        if (optBoolean) {
            zzv.zzp().zzi().zzs(jSONObject.getString("appSettingsJson"));
            if (l != null) {
                zzf(zzdsjVar, "cld_s", zzv.zzD().elapsedRealtime() - l.longValue());
            }
        }
        String optString = jSONObject.optString("errorReason", "");
        if (!TextUtils.isEmpty(optString)) {
            zzfhjVar.zzc(optString);
        }
        zzfhjVar.zzg(optBoolean);
        zzfhxVar.zzc(zzfhjVar.zzm());
        return zzgdn.zzh(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void zzf(zzdsj zzdsjVar, String str, long j) {
        if (zzdsjVar != null) {
            if (((Boolean) zzbd.zzc().zzb(zzbde.zznb)).booleanValue()) {
                zzdsi zza = zzdsjVar.zza();
                zza.zzb("action", "lat_init");
                zza.zzb(str, Long.toString(j));
                zza.zzj();
            }
        }
    }

    public final void zzc(Context context, VersionInfoParcel versionInfoParcel, String str, Runnable runnable, zzfhx zzfhxVar, zzdsj zzdsjVar, Long l, boolean z) {
        zzd(context, versionInfoParcel, true, null, str, null, runnable, zzfhxVar, zzdsjVar, l, z);
    }

    final void zzd(Context context, VersionInfoParcel versionInfoParcel, boolean z, zzbzm zzbzmVar, String str, String str2, Runnable runnable, final zzfhx zzfhxVar, final zzdsj zzdsjVar, final Long l, boolean z2) {
        zzfhj zzfhjVar;
        Exception exc;
        ListenableFuture zzb;
        zzgcu zzgcuVar;
        PackageInfo packageInfo;
        if (zzv.zzD().elapsedRealtime() - this.zzb < 5000) {
            int i = com.google.android.gms.ads.internal.util.zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zzj("Not retrying to fetch app settings");
            return;
        }
        this.zzb = zzv.zzD().elapsedRealtime();
        if (zzbzmVar != null && !TextUtils.isEmpty(zzbzmVar.zzc())) {
            if (zzv.zzD().currentTimeMillis() - zzbzmVar.zza() <= ((Long) zzbd.zzc().zzb(zzbde.zzew)).longValue() && zzbzmVar.zzi()) {
                return;
            }
        }
        if (context == null) {
            int i2 = com.google.android.gms.ads.internal.util.zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zzj("Context not provided to fetch application settings");
            return;
        }
        if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) {
            int i3 = com.google.android.gms.ads.internal.util.zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zzj("App settings could not be fetched. Required parameters missing");
            return;
        }
        Context applicationContext = context.getApplicationContext();
        if (applicationContext == null) {
            applicationContext = context;
        }
        this.zza = applicationContext;
        final zzfhj zza = zzfhi.zza(context, 4);
        zza.zzi();
        zzbow zza2 = zzv.zzg().zza(this.zza, versionInfoParcel, zzfhxVar);
        zzboq zzboqVar = zzbot.zza;
        zzbom zza3 = zza2.zza("google.afma.config.fetchAppSettings", zzboqVar, zzboqVar);
        try {
            JSONObject jSONObject = new JSONObject();
            try {
                if (!TextUtils.isEmpty(str)) {
                    jSONObject.put(MBridgeConstans.APP_ID, str);
                } else if (!TextUtils.isEmpty(str2)) {
                    jSONObject.put("ad_unit_id", str2);
                }
                jSONObject.put("is_init", z);
                jSONObject.put("pn", context.getPackageName());
                zzbcv zzbcvVar = zzbde.zza;
                jSONObject.put("experiment_ids", TextUtils.join(",", zzbd.zza().zza()));
                jSONObject.put("js", versionInfoParcel.afmaVersion);
                if (((Boolean) zzbd.zzc().zzb(zzbde.zzjV)).booleanValue()) {
                    jSONObject.put("inspector_enabled", z2);
                }
                try {
                    ApplicationInfo applicationInfo = this.zza.getApplicationInfo();
                    if (applicationInfo != null && (packageInfo = Wrappers.packageManager(context).getPackageInfo(applicationInfo.packageName, 0)) != null) {
                        jSONObject.put("version", packageInfo.versionCode);
                    }
                } catch (PackageManager.NameNotFoundException unused) {
                    com.google.android.gms.ads.internal.util.zze.zza("Error fetching PackageInfo.");
                }
                zzb = zza3.zzb(jSONObject);
                try {
                    zzgcuVar = new zzgcu() { // from class: com.google.android.gms.ads.internal.zzd
                        @Override // com.google.android.gms.internal.ads.zzgcu
                        public final ListenableFuture zza(Object obj) {
                            return zzf.zza(zzf.this, l, zzdsjVar, zza, zzfhxVar, (JSONObject) obj);
                        }
                    };
                    zzfhjVar = zza;
                } catch (Exception e) {
                    e = e;
                    zzfhjVar = zza;
                }
            } catch (Exception e2) {
                exc = e2;
                zzfhjVar = zza;
                int i4 = com.google.android.gms.ads.internal.util.zze.zza;
                com.google.android.gms.ads.internal.util.client.zzo.zzh("Error requesting application settings", exc);
                zzfhjVar.zzh(exc);
                zzfhjVar.zzg(false);
                zzfhxVar.zzc(zzfhjVar.zzm());
            }
        } catch (Exception e3) {
            e = e3;
            zzfhjVar = zza;
        }
        try {
            zzgdy zzgdyVar = zzcaf.zzg;
            ListenableFuture zzn = zzgdn.zzn(zzb, zzgcuVar, zzgdyVar);
            if (runnable != null) {
                zzb.addListener(runnable, zzgdyVar);
            }
            if (l != null) {
                zzb.addListener(new Runnable() { // from class: com.google.android.gms.ads.internal.zze
                    @Override // java.lang.Runnable
                    public final void run() {
                        zzf zzfVar = zzf.this;
                        zzf.zzf(zzdsjVar, "cld_r", zzv.zzD().elapsedRealtime() - l.longValue());
                    }
                }, zzgdyVar);
            }
            if (((Boolean) zzbd.zzc().zzb(zzbde.zzia)).booleanValue()) {
                zzcai.zzb(zzn, "ConfigLoader.maybeFetchNewAppSettings");
            } else {
                zzcai.zza(zzn, "ConfigLoader.maybeFetchNewAppSettings");
            }
        } catch (Exception e4) {
            e = e4;
            exc = e;
            int i42 = com.google.android.gms.ads.internal.util.zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zzh("Error requesting application settings", exc);
            zzfhjVar.zzh(exc);
            zzfhjVar.zzg(false);
            zzfhxVar.zzc(zzfhjVar.zzm());
        }
    }

    public final void zze(Context context, VersionInfoParcel versionInfoParcel, String str, zzbzm zzbzmVar, zzfhx zzfhxVar, boolean z) {
        zzd(context, versionInfoParcel, false, zzbzmVar, zzbzmVar != null ? zzbzmVar.zzb() : null, str, null, zzfhxVar, null, null, z);
    }
}
