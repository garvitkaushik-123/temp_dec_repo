package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Build;
import android.os.RemoteException;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.common.util.concurrent.ListenableFuture;
import com.ironsource.C3207n2;
import com.ironsource.N6;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.annotation.Nullable;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzdvi implements zzdwk, zzdut {
    private final zzdvt zza;
    private final zzdwl zzb;
    private final zzduu zzc;
    private final zzdvd zzd;
    private final zzdus zze;
    private final zzdwf zzf;
    private final zzdvp zzg;
    private final zzdvp zzh;
    private final String zzi;
    private final Context zzj;

    @Nullable
    private final String zzk;
    private JSONObject zzp;
    private boolean zzs;
    private int zzt;
    private boolean zzu;
    private final Map zzl = new HashMap();
    private final Map zzm = new HashMap();
    private final Map zzn = new HashMap();
    private String zzo = "{}";
    private long zzq = Long.MAX_VALUE;
    private zzdve zzr = zzdve.NONE;
    private zzdvh zzv = zzdvh.UNKNOWN;
    private long zzw = 0;
    private String zzx = "";

    zzdvi(zzdvt zzdvtVar, zzdwl zzdwlVar, zzduu zzduuVar, Context context, VersionInfoParcel versionInfoParcel, zzdvd zzdvdVar, zzdwf zzdwfVar, zzdvp zzdvpVar, zzdvp zzdvpVar2, @Nullable String str) {
        this.zza = zzdvtVar;
        this.zzb = zzdwlVar;
        this.zzc = zzduuVar;
        this.zze = new zzdus(context);
        this.zzi = versionInfoParcel.afmaVersion;
        this.zzk = str;
        this.zzd = zzdvdVar;
        this.zzf = zzdwfVar;
        this.zzg = zzdvpVar;
        this.zzh = zzdvpVar2;
        this.zzj = context;
        com.google.android.gms.ads.internal.zzv.zzu().zzg(this);
    }

    private final synchronized void zzA(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            zzx(jSONObject.optBoolean("isTestMode", false), false);
            zzw((zzdve) Enum.valueOf(zzdve.class, jSONObject.optString("gesture", "NONE")), false);
            this.zzo = jSONObject.optString("networkExtras", "{}");
            this.zzq = jSONObject.optLong("networkExtrasExpirationSecs", Long.MAX_VALUE);
        } catch (JSONException unused) {
        }
    }

    private final synchronized JSONObject zzt() throws JSONException {
        JSONObject jSONObject;
        jSONObject = new JSONObject();
        for (Map.Entry entry : this.zzl.entrySet()) {
            JSONArray jSONArray = new JSONArray();
            for (zzduw zzduwVar : (List) entry.getValue()) {
                if (zzduwVar.zzg()) {
                    jSONArray.put(zzduwVar.zzd());
                }
            }
            if (jSONArray.length() > 0) {
                jSONObject.put((String) entry.getKey(), jSONArray);
            }
        }
        return jSONObject;
    }

    private final void zzu() {
        this.zzu = true;
        this.zzd.zzc();
        this.zza.zzi(this);
        this.zzb.zzd(this);
        this.zzc.zzd(this);
        this.zzf.zzf(this);
        zzbcv zzbcvVar = zzbde.zzjT;
        if (!TextUtils.isEmpty((CharSequence) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbcvVar))) {
            this.zzg.zzb(PreferenceManager.getDefaultSharedPreferences(this.zzj), Arrays.asList(((String) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbcvVar)).split(",")));
        }
        zzbcv zzbcvVar2 = zzbde.zzjU;
        if (!TextUtils.isEmpty((CharSequence) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbcvVar2))) {
            this.zzh.zzb(this.zzj.getSharedPreferences("admob", 0), Arrays.asList(((String) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbcvVar2)).split(",")));
        }
        zzA(com.google.android.gms.ads.internal.zzv.zzp().zzi().zzk());
        this.zzx = com.google.android.gms.ads.internal.zzv.zzp().zzi().zzl();
    }

    private final void zzv() {
        com.google.android.gms.ads.internal.zzv.zzp().zzi().zzB(zzd());
    }

    private final synchronized void zzw(zzdve zzdveVar, boolean z) {
        if (this.zzr != zzdveVar) {
            if (zzq()) {
                zzy();
            }
            this.zzr = zzdveVar;
            if (zzq()) {
                zzz();
            }
            if (z) {
                zzv();
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0035 A[Catch: all -> 0x003c, TRY_LEAVE, TryCatch #0 {, blocks: (B:3:0x0001, B:9:0x0006, B:11:0x000a, B:13:0x001c, B:15:0x0026, B:17:0x0035, B:21:0x002a, B:23:0x0030), top: B:2:0x0001 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final synchronized void zzx(boolean z, boolean z2) {
        if (this.zzs != z) {
            this.zzs = z;
            if (z) {
                if (!((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzjE)).booleanValue() || !com.google.android.gms.ads.internal.zzv.zzu().zzl()) {
                    zzz();
                    if (z2) {
                        zzv();
                        return;
                    }
                }
            }
            if (!zzq()) {
                zzy();
            }
            if (z2) {
            }
        }
    }

    private final synchronized void zzy() {
        int ordinal = this.zzr.ordinal();
        if (ordinal == 1) {
            this.zzb.zzb();
        } else {
            if (ordinal != 2) {
                return;
            }
            this.zzc.zzb();
        }
    }

    private final synchronized void zzz() {
        int ordinal = this.zzr.ordinal();
        if (ordinal == 1) {
            this.zzb.zzc();
        } else {
            if (ordinal != 2) {
                return;
            }
            this.zzc.zzc();
        }
    }

    public final zzdve zza() {
        return this.zzr;
    }

    public final synchronized ListenableFuture zzb(String str) {
        zzcak zzcakVar;
        zzcakVar = new zzcak();
        Map map = this.zzm;
        if (map.containsKey(str)) {
            zzcakVar.zzc((zzduw) map.get(str));
        } else {
            Map map2 = this.zzn;
            if (!map2.containsKey(str)) {
                map2.put(str, new ArrayList());
            }
            ((List) map2.get(str)).add(zzcakVar);
        }
        return zzcakVar;
    }

    public final synchronized String zzc() {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzjp)).booleanValue() && zzq()) {
            if (this.zzq < com.google.android.gms.ads.internal.zzv.zzD().currentTimeMillis() / 1000) {
                this.zzo = "{}";
                this.zzq = Long.MAX_VALUE;
                return "";
            }
            if (!this.zzo.equals("{}")) {
                return this.zzo;
            }
        }
        return "";
    }

    public final synchronized String zzd() {
        JSONObject jSONObject;
        jSONObject = new JSONObject();
        try {
            jSONObject.put("isTestMode", this.zzs);
            jSONObject.put("gesture", this.zzr);
            if (this.zzq > com.google.android.gms.ads.internal.zzv.zzD().currentTimeMillis() / 1000) {
                jSONObject.put("networkExtras", this.zzo);
                jSONObject.put("networkExtrasExpirationSecs", this.zzq);
            }
        } catch (JSONException unused) {
        }
        return jSONObject.toString();
    }

    public final synchronized JSONObject zze() {
        JSONObject jSONObject;
        JSONObject jSONObject2;
        jSONObject = new JSONObject();
        try {
            jSONObject.put(N6.H, "ANDROID");
            String str = this.zzk;
            if (!TextUtils.isEmpty(str)) {
                jSONObject.put("sdkVersion", "afma-sdk-a-v" + str);
            }
            jSONObject.put("internalSdkVersion", this.zzi);
            jSONObject.put("osVersion", Build.VERSION.RELEASE);
            jSONObject.put("adapters", this.zzd.zza());
            if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzjQ)).booleanValue()) {
                String zzn = com.google.android.gms.ads.internal.zzv.zzp().zzn();
                if (!TextUtils.isEmpty(zzn)) {
                    jSONObject.put(N6.L, zzn);
                }
            }
            if (this.zzq < com.google.android.gms.ads.internal.zzv.zzD().currentTimeMillis() / 1000) {
                this.zzo = "{}";
            }
            jSONObject.put("networkExtras", this.zzo);
            jSONObject.put("adSlots", zzt());
            jSONObject.put("appInfo", this.zze.zza());
            String zzc = com.google.android.gms.ads.internal.zzv.zzp().zzi().zzg().zzc();
            if (!TextUtils.isEmpty(zzc)) {
                jSONObject.put("cld", new JSONObject(zzc));
            }
            if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzjF)).booleanValue() && (jSONObject2 = this.zzp) != null) {
                String str2 = "Server data: " + jSONObject2.toString();
                int i = com.google.android.gms.ads.internal.util.zze.zza;
                com.google.android.gms.ads.internal.util.client.zzo.zze(str2);
                jSONObject.put(C3207n2.s, this.zzp);
            }
            if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzjE)).booleanValue()) {
                jSONObject.put("openAction", this.zzv);
                jSONObject.put("gesture", this.zzr);
            }
            jSONObject.put("isGamRegisteredTestDevice", com.google.android.gms.ads.internal.zzv.zzu().zzl());
            com.google.android.gms.ads.internal.zzv.zzr();
            com.google.android.gms.ads.internal.client.zzbb.zzb();
            jSONObject.put("isSimulator", com.google.android.gms.ads.internal.util.client.zzf.zzw());
            if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzjS)).booleanValue()) {
                jSONObject.put("uiStorage", new JSONObject(this.zzx));
            }
            if (!TextUtils.isEmpty((CharSequence) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzjU))) {
                jSONObject.put("gmaDisk", this.zzh.zza());
            }
            if (!TextUtils.isEmpty((CharSequence) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzjT))) {
                jSONObject.put("userDisk", this.zzg.zza());
            }
        } catch (JSONException e) {
            com.google.android.gms.ads.internal.zzv.zzp().zzv(e, "Inspector.toJson");
            int i2 = com.google.android.gms.ads.internal.util.zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zzk("Ad inspector encountered an error", e);
        }
        return jSONObject;
    }

    public final synchronized void zzf(String str, zzduw zzduwVar) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzjp)).booleanValue() && zzq()) {
            if (this.zzt >= ((Integer) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzjr)).intValue()) {
                int i = com.google.android.gms.ads.internal.util.zze.zza;
                com.google.android.gms.ads.internal.util.client.zzo.zzj("Maximum number of ad requests stored reached. Dropping the current request.");
                return;
            }
            Map map = this.zzl;
            if (!map.containsKey(str)) {
                map.put(str, new ArrayList());
            }
            this.zzt++;
            ((List) map.get(str)).add(zzduwVar);
            if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzjN)).booleanValue()) {
                String zzc = zzduwVar.zzc();
                this.zzm.put(zzc, zzduwVar);
                Map map2 = this.zzn;
                if (map2.containsKey(zzc)) {
                    List list = (List) map2.get(zzc);
                    Iterator it = list.iterator();
                    while (it.hasNext()) {
                        ((zzcak) it.next()).zzc(zzduwVar);
                    }
                    list.clear();
                }
            }
        }
    }

    public final void zzg() {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzjp)).booleanValue()) {
            if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzjE)).booleanValue() && com.google.android.gms.ads.internal.zzv.zzp().zzi().zzM()) {
                zzu();
                return;
            }
            String zzk = com.google.android.gms.ads.internal.zzv.zzp().zzi().zzk();
            if (TextUtils.isEmpty(zzk)) {
                return;
            }
            try {
                if (new JSONObject(zzk).optBoolean("isTestMode", false)) {
                    zzu();
                }
            } catch (JSONException unused) {
            }
        }
    }

    public final synchronized void zzh(com.google.android.gms.ads.internal.client.zzdn zzdnVar, zzdvh zzdvhVar) {
        if (!zzq()) {
            try {
                zzdnVar.zze(zzfdx.zzd(18, null, null));
                return;
            } catch (RemoteException unused) {
                int i = com.google.android.gms.ads.internal.util.zze.zza;
                com.google.android.gms.ads.internal.util.client.zzo.zzj("Ad inspector cannot be opened because the device is not in test mode. See https://developers.google.com/admob/android/test-ads#enable_test_devices for more information.");
                return;
            }
        }
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzjp)).booleanValue()) {
            this.zzv = zzdvhVar;
            this.zza.zzj(zzdnVar, new zzbkz(this), new zzbks(this.zzf), new zzbkg(this));
            return;
        } else {
            try {
                zzdnVar.zze(zzfdx.zzd(1, null, null));
                return;
            } catch (RemoteException unused2) {
                int i2 = com.google.android.gms.ads.internal.util.zze.zza;
                com.google.android.gms.ads.internal.util.client.zzo.zzj("Ad inspector had an internal error.");
                return;
            }
        }
    }

    public final synchronized void zzi(String str, long j) {
        this.zzo = str;
        this.zzq = j;
        zzv();
    }

    public final synchronized void zzj(String str) {
        this.zzx = str;
        com.google.android.gms.ads.internal.zzv.zzp().zzi().zzC(this.zzx);
    }

    public final synchronized void zzk(long j) {
        this.zzw += j;
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x000a, code lost:
    
        if (r2 != false) goto L7;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void zzl(boolean z) {
        if (!this.zzu) {
            if (z) {
                zzu();
                if (!this.zzs) {
                    zzz();
                    return;
                }
            }
            if (zzq()) {
                return;
            }
            zzy();
        }
    }

    public final void zzm(zzdve zzdveVar) {
        zzw(zzdveVar, true);
    }

    public final synchronized void zzn(JSONObject jSONObject) {
        this.zzp = jSONObject;
    }

    public final void zzo(boolean z) {
        if (!this.zzu && z) {
            zzu();
        }
        zzx(z, true);
    }

    public final boolean zzp() {
        return this.zzp != null;
    }

    public final synchronized boolean zzq() {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzjE)).booleanValue()) {
            return this.zzs || com.google.android.gms.ads.internal.zzv.zzu().zzl();
        }
        return this.zzs;
    }

    public final synchronized boolean zzr() {
        return this.zzs;
    }

    public final boolean zzs() {
        return this.zzw < ((Long) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzjK)).longValue();
    }
}
