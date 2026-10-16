package com.google.android.gms.ads.nonagon.signalgeneration;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import android.util.JsonReader;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzbde;
import com.google.android.gms.internal.ads.zzbze;
import com.google.android.gms.internal.ads.zzdrr;
import com.google.android.gms.internal.ads.zzfsa;
import com.google.android.gms.internal.ads.zzfse;
import com.google.android.gms.internal.ads.zzfsf;
import java.io.IOException;
import java.io.StringReader;
import java.nio.charset.StandardCharsets;
import java.util.Map;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes4.dex */
public final class zzb {
    private final Context zza;
    private final zzd zzb;
    private final long zzc;
    private final ScheduledExecutorService zzd;
    private final PackageInfo zze;

    zzb(Context context, long j, PackageInfo packageInfo, zzd zzdVar, ScheduledExecutorService scheduledExecutorService) {
        this.zza = context;
        this.zzc = j;
        this.zze = packageInfo;
        this.zzb = zzdVar;
        this.zzd = scheduledExecutorService;
    }

    public static String zzb(String str) {
        if (str == null) {
            return "";
        }
        char[] charArray = str.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            charArray[i] = (char) (charArray[i] ^ "f8L7o2HxjA4p9Z1nQw3E5r6T8yU2iCv0B9kM4sD1f7G3hJ5lK2z0X9cW8vQ6b5N3m1Rg8F2o0Lp7A1e9I4u3Y2t0H8x6W5v4Z1n9Q2w7E3r5T8y6U1i0C9vB8k7M4s3D1f2G0h9J5l8K4z7X3cW2v1Q0b9N8m6A5r4F3o2Lp1E0u9I8y7Y6t5H4x3W2v1Z0n9Q8w7E6r5T4y3U2i1C0v9B8k7M6s5D4f3G2h1J0l9K8z7X6cW5v4Q3b2N1m0Rg9F8o7Lp6A5e4I3u2Y1t0H8x7W6v5Z4n3Q2w1E0r9T8y7U6i5C4v3B2k1M0s9D8f7G6h5J4l3K2z1X0cW9v8Q7b6N5m4A3r2F1o0Lp9E8u7I6y5T4h3W2v1Z0n0Q9w8E7r6T5y4U3i2C1v0B9k8M7s6D5f4G3h2J1l0K9z8X7cW6v5Q4b3N2m1R0g9F8o7L6p5A4e3I2u1Y0t9H8x7W6v5Z4n3Q2w1E0r9T8y7U6i5C4v3B2k1M0s9D8f7G6h5J4l3K2z1X0cW9v8Q7b6N5m4A3r2F1o0Lp9E8u7I6y5T4h3W2".charAt(i % 555));
        }
        return new String(charArray);
    }

    public static /* synthetic */ void zzc(zzb zzbVar, String str, zzau zzauVar, zzbze zzbzeVar) {
        if (zzbVar.zzb.zzj(str) || zzbVar.zze()) {
            return;
        }
        zzauVar.zzf(ObjectWrapper.wrap(zzbVar.zza), zzbzeVar, null);
    }

    private final boolean zze() {
        return this.zzb.zzf().size() >= ((Integer) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzhS)).intValue();
    }

    private static final void zzf(Bundle bundle, zzdrr zzdrrVar) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzhT)).booleanValue()) {
            bundle.putLong(zzdrrVar.zza(), com.google.android.gms.ads.internal.zzv.zzD().currentTimeMillis());
        }
    }

    private static final void zzg(Bundle bundle, int i) {
        bundle.putBoolean("sod_h", false);
        bundle.putInt("cmr", i - 1);
    }

    /* JADX WARN: Can't wrap try/catch for region: R(9:20|21|22|(1:24)(7:31|32|33|(1:35)|37|(1:42)(2:39|(1:41))|29)|25|26|28|29|18) */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x010a, code lost:
    
        if (r12.zza() > r10) goto L80;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final zzbk zza(zzbze zzbzeVar, final zzau zzauVar, Bundle bundle) {
        zzbk zzbkVar;
        zzbk zzbkVar2;
        long j;
        zzf(bundle, zzdrr.SIGNAL_ON_DISK_VALIDATION_START);
        zzbk zzbkVar3 = null;
        if (com.google.android.gms.ads.internal.zzv.zzp().zzi().zzN()) {
            this.zzb.zzg();
            zzg(bundle, 7);
        } else {
            PackageInfo packageInfo = this.zze;
            if (packageInfo != null) {
                zzd zzdVar = this.zzb;
                Context context = this.zza;
                String zze = zzdVar.zze();
                int zzb = zzdVar.zzb();
                String zzd = zzdVar.zzd();
                int zza = zzdVar.zza();
                if (TextUtils.equals(context.getApplicationInfo().packageName, zze) && zzb == packageInfo.versionCode && TextUtils.equals(Build.MODEL, zzd) && zza == Build.VERSION.SDK_INT) {
                    for (Map.Entry entry : zzdVar.zzf().entrySet()) {
                        try {
                            j = new JSONObject((String) entry.getValue()).getLong("ts_ms");
                        } catch (IOException | JSONException unused) {
                            zzbkVar2 = zzbkVar3;
                        }
                        if (com.google.android.gms.ads.internal.zzv.zzD().currentTimeMillis() - j > ((Long) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzhR)).longValue()) {
                            zzbkVar2 = zzbkVar3;
                        } else {
                            zzfsa zzh = zzfse.zzj(context).zzh(((Long) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzdz)).longValue(), com.google.android.gms.ads.internal.zzv.zzp().zzi().zzN());
                            zzbkVar2 = zzbkVar3;
                            zzfsa zzh2 = zzfsf.zzi(context).zzh(((Long) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzdA)).longValue(), com.google.android.gms.ads.internal.zzv.zzp().zzi().zzN());
                            if (zzh.zza() != -1) {
                            }
                            if (zzh2.zza() != -1) {
                                if (zzh2.zza() <= j) {
                                }
                            }
                            zzbkVar3 = zzbkVar2;
                        }
                        zzdVar.zzc((String) entry.getKey());
                        zzbkVar3 = zzbkVar2;
                    }
                    zzbkVar = zzbkVar3;
                } else {
                    zzbkVar = null;
                    zzdVar.zzg();
                    zzdVar.zzi(context.getApplicationInfo().packageName, packageInfo.versionCode, Build.MODEL, Build.VERSION.SDK_INT);
                }
                zzf(bundle, zzdrr.SIGNAL_ON_DISK_VALIDATION_END);
                if (com.google.android.gms.ads.internal.zzv.zzD().currentTimeMillis() - this.zzc > ((Long) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzhO)).longValue()) {
                    zzg(bundle, 2);
                    return zzbkVar;
                }
                zzf(bundle, zzdrr.SIGNAL_ON_DISK_CACHE_KEY_START);
                String str = zzbzeVar.zza;
                String str2 = zzbzeVar.zzb;
                com.google.android.gms.ads.internal.client.zzm zzmVar = zzbzeVar.zzd;
                final String zzl = com.google.android.gms.ads.internal.util.client.zzf.zzl(str + str2 + zzmVar.zzn.toString() + zzmVar.zzc.toString() + zzmVar.zzi + zzmVar.zzp + String.valueOf(zzmVar.zzo));
                if (TextUtils.isEmpty(zzl)) {
                    zzg(bundle, 3);
                    return zzbkVar;
                }
                zzf(bundle, zzdrr.SIGNAL_ON_DISK_CACHE_KEY_END);
                zzf(bundle, zzdrr.SIGNAL_ON_DISK_READ_AND_REMOVE_START);
                String zzc = this.zzb.zzc(zzl);
                zzf(bundle, zzdrr.SIGNAL_ON_DISK_READ_AND_REMOVE_END);
                if (!zze()) {
                    final zzbze zzbzeVar2 = new zzbze(str, str2, zzbzeVar.zzc, zzmVar, 2, zzl);
                    this.zzd.schedule(new Runnable() { // from class: com.google.android.gms.ads.nonagon.signalgeneration.zza
                        @Override // java.lang.Runnable
                        public final void run() {
                            zzb.zzc(zzb.this, zzl, zzauVar, zzbzeVar2);
                        }
                    }, ((Long) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzhQ)).longValue(), TimeUnit.MILLISECONDS);
                }
                if (TextUtils.isEmpty(zzc)) {
                    zzg(bundle, 4);
                    return zzbkVar;
                }
                zzf(bundle, zzdrr.SIGNAL_ON_DISK_DECODE_START);
                try {
                    JSONObject jSONObject = new JSONObject(zzc);
                    String string = jSONObject.getString("sr");
                    if (TextUtils.isEmpty(string)) {
                        zzg(bundle, 8);
                        return zzbkVar;
                    }
                    String string2 = jSONObject.getString("rs");
                    if (TextUtils.isEmpty(string2)) {
                        zzg(bundle, 9);
                        return zzbkVar;
                    }
                    String zzb2 = zzb(new String(Base64.decode(string2, 10), StandardCharsets.UTF_8));
                    zzf(bundle, zzdrr.SIGNAL_ON_DISK_DECODE_END);
                    try {
                        zzbk zzbkVar4 = new zzbk(new JsonReader(new StringReader(string)), zzbkVar);
                        zzbkVar4.zzc = zzb2;
                        zzbkVar4.zze = bundle;
                        bundle.putBoolean("sod_h", true);
                        return zzbkVar4;
                    } catch (IOException e) {
                        zzg(bundle, 6);
                        com.google.android.gms.ads.internal.zzv.zzp().zzw(e, "DiskCachingManager.getSignalResponse");
                        return null;
                    }
                } catch (JSONException e2) {
                    zzg(bundle, 5);
                    com.google.android.gms.ads.internal.zzv.zzp().zzw(e2, "DiskCachingManager.getSignalResponse");
                    return null;
                }
            }
            this.zzb.zzg();
            zzg(bundle, 10);
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0074  */
    /* JADX WARN: Removed duplicated region for block: B:15:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void zzd(String str, zzbk zzbkVar) {
        String jSONObject;
        String str2;
        if (TextUtils.isEmpty(str) || zze()) {
            return;
        }
        JSONObject jSONObject2 = new JSONObject();
        try {
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("params", zzbkVar.zza);
            jSONObject3.put("signal_dictionary", com.google.android.gms.ads.internal.client.zzbb.zzb().zzn(zzbkVar.zzf));
            jSONObject2.put("sr", jSONObject3);
            str2 = zzbkVar.zzc;
        } catch (JSONException e) {
            com.google.android.gms.ads.internal.zzv.zzp().zzw(e, "DiskCachingManager.createStringToWrite");
        }
        if (TextUtils.isEmpty(str2)) {
            jSONObject = "";
            if (TextUtils.isEmpty(jSONObject)) {
                this.zzb.zzh(str, jSONObject);
                return;
            }
            return;
        }
        jSONObject2.put("rs", Base64.encodeToString(zzb(str2).getBytes(StandardCharsets.UTF_8), 10));
        jSONObject2.put("ts_ms", com.google.android.gms.ads.internal.zzv.zzD().currentTimeMillis());
        jSONObject = jSONObject2.toString();
        if (TextUtils.isEmpty(jSONObject)) {
        }
    }
}
