package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Base64;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.common.util.concurrent.ListenableFuture;
import com.ironsource.C3057e4;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import io.adn.sdk.internal.domain.constants.AnalyticsConstants;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzdmc {
    private final Context zza;
    private final zzdli zzb;
    private final zzavu zzc;
    private final VersionInfoParcel zzd;
    private final com.google.android.gms.ads.internal.zza zze;
    private final zzbcc zzf;
    private final Executor zzg;
    private final zzbge zzh;
    private final zzdmu zzi;
    private final zzdpj zzj;
    private final ScheduledExecutorService zzk;
    private final zzdoe zzl;
    private final zzdsj zzm;
    private final zzfjy zzn;
    private final zzeca zzo;
    private final zzecl zzp;
    private final zzfda zzq;
    private final zzdsd zzr;

    public zzdmc(Context context, zzdli zzdliVar, zzavu zzavuVar, VersionInfoParcel versionInfoParcel, com.google.android.gms.ads.internal.zza zzaVar, zzbcc zzbccVar, Executor executor, zzfcw zzfcwVar, zzdmu zzdmuVar, zzdpj zzdpjVar, ScheduledExecutorService scheduledExecutorService, zzdsj zzdsjVar, zzfjy zzfjyVar, zzeca zzecaVar, zzdoe zzdoeVar, zzecl zzeclVar, zzfda zzfdaVar, zzdsd zzdsdVar) {
        this.zza = context;
        this.zzb = zzdliVar;
        this.zzc = zzavuVar;
        this.zzd = versionInfoParcel;
        this.zze = zzaVar;
        this.zzf = zzbccVar;
        this.zzg = executor;
        this.zzh = zzfcwVar.zzi;
        this.zzi = zzdmuVar;
        this.zzj = zzdpjVar;
        this.zzk = scheduledExecutorService;
        this.zzm = zzdsjVar;
        this.zzn = zzfjyVar;
        this.zzo = zzecaVar;
        this.zzl = zzdoeVar;
        this.zzp = zzeclVar;
        this.zzq = zzfdaVar;
        this.zzr = zzdsdVar;
    }

    public static /* synthetic */ zzbfz zza(zzdmc zzdmcVar, JSONObject jSONObject, List list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        String optString = jSONObject.optString("text");
        Integer zzs = zzs(jSONObject, "bg_color");
        Integer zzs2 = zzs(jSONObject, "text_color");
        int optInt = jSONObject.optInt("text_size", -1);
        boolean optBoolean = jSONObject.optBoolean("allow_pub_rendering");
        int optInt2 = jSONObject.optInt("animation_ms", 1000);
        return new zzbfz(optString, list, zzs, zzs2, optInt > 0 ? Integer.valueOf(optInt) : null, jSONObject.optInt("presentation_ms", 4000) + optInt2, zzdmcVar.zzh.zze, optBoolean);
    }

    public static /* synthetic */ ListenableFuture zzb(zzdmc zzdmcVar, String str, zzbya zzbyaVar, com.google.android.gms.ads.internal.zzb zzbVar, Object obj) {
        com.google.android.gms.ads.internal.zzv.zzB();
        Context context = zzdmcVar.zza;
        zzecl zzeclVar = zzdmcVar.zzp;
        zzcfg zza = zzcft.zza(context, zzchd.zza(), "native-omid", false, false, zzdmcVar.zzc, null, zzdmcVar.zzd, null, null, zzdmcVar.zze, zzdmcVar.zzf, null, null, zzeclVar, zzdmcVar.zzq, zzdmcVar.zzm);
        final zzcaj zza2 = zzcaj.zza(zza);
        zza.zzN().zzC(new zzcgw() { // from class: com.google.android.gms.internal.ads.zzdlt
            @Override // com.google.android.gms.internal.ads.zzcgw
            public final void zza(boolean z, int i, String str2, String str3) {
                zzcaj.this.zzb();
            }
        });
        zza.loadData(Base64.encodeToString(str.getBytes(), 1), "text/html", "base64");
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zznP)).booleanValue()) {
            if (zzbyaVar != null) {
                zza.zzN().zzL(zzbyaVar);
            }
            zza.zzN().zzD(zzbVar);
        }
        return zza2;
    }

    public static /* synthetic */ ListenableFuture zzc(zzdmc zzdmcVar, com.google.android.gms.ads.internal.client.zzr zzrVar, zzfca zzfcaVar, zzfcd zzfcdVar, com.google.android.gms.ads.internal.zzb zzbVar, zzbya zzbyaVar, String str, String str2, Object obj) {
        zzcfg zza = zzdmcVar.zzj.zza(zzrVar, zzfcaVar, zzfcdVar);
        final zzcaj zza2 = zzcaj.zza(zza);
        zzdob zzb = zzdmcVar.zzl.zzb();
        zzcgy zzN = zza.zzN();
        zzbcv zzbcvVar = zzbde.zznP;
        zzN.zzX(zzb, zzb, zzb, zzb, zzb, false, null, !((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbcvVar)).booleanValue() ? new com.google.android.gms.ads.internal.zzb(zzdmcVar.zza, null, null) : zzbVar, null, true != ((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbcvVar)).booleanValue() ? null : zzbyaVar, zzdmcVar.zzo, zzdmcVar.zzn, zzdmcVar.zzm, null, zzb, null, null, null, null);
        zza.zzag("/getNativeAdViewSignals", zzbke.zzs);
        zza.zzag("/getNativeClickMeta", zzbke.zzt);
        zza.zzN().zzG(true);
        zza.zzN().zzC(new zzcgw() { // from class: com.google.android.gms.internal.ads.zzdly
            @Override // com.google.android.gms.internal.ads.zzcgw
            public final void zza(boolean z, int i, String str3, String str4) {
                zzcaj zzcajVar = zzcaj.this;
                if (z) {
                    zzcajVar.zzb();
                    return;
                }
                zzcajVar.zzd(new zzehf(1, "Image Web View failed to load. Error code: " + i + ", Description: " + str3 + ", Failing URL: " + str4));
            }
        });
        zza.zzae(str, str2, null);
        return zza2;
    }

    public static final com.google.android.gms.ads.internal.client.zzfa zzk(JSONObject jSONObject) {
        JSONObject optJSONObject;
        JSONObject optJSONObject2 = jSONObject.optJSONObject(CampaignEx.JSON_NATIVE_VIDEO_MUTE);
        if (optJSONObject2 == null || (optJSONObject = optJSONObject2.optJSONObject("default_reason")) == null) {
            return null;
        }
        return zzt(optJSONObject);
    }

    public static final List zzl(JSONObject jSONObject) {
        JSONObject optJSONObject = jSONObject.optJSONObject(CampaignEx.JSON_NATIVE_VIDEO_MUTE);
        if (optJSONObject == null) {
            return zzfyq.zzn();
        }
        JSONArray optJSONArray = optJSONObject.optJSONArray("reasons");
        if (optJSONArray == null || optJSONArray.length() <= 0) {
            return zzfyq.zzn();
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < optJSONArray.length(); i++) {
            com.google.android.gms.ads.internal.client.zzfa zzt = zzt(optJSONArray.optJSONObject(i));
            if (zzt != null) {
                arrayList.add(zzt);
            }
        }
        return zzfyq.zzl(arrayList);
    }

    private static ListenableFuture zzn(ListenableFuture listenableFuture, Object obj) {
        final Object obj2 = null;
        return zzgdn.zzf(listenableFuture, Exception.class, new zzgcu(obj2) { // from class: com.google.android.gms.internal.ads.zzdlu
            @Override // com.google.android.gms.internal.ads.zzgcu
            public final ListenableFuture zza(Object obj3) {
                com.google.android.gms.ads.internal.util.zze.zzb("Error during loading assets.", (Exception) obj3);
                return zzgdn.zzh(null);
            }
        }, zzcaf.zzg);
    }

    private static ListenableFuture zzo(boolean z, final ListenableFuture listenableFuture, Object obj) {
        return z ? zzgdn.zzn(listenableFuture, new zzgcu() { // from class: com.google.android.gms.internal.ads.zzdlw
            @Override // com.google.android.gms.internal.ads.zzgcu
            public final ListenableFuture zza(Object obj2) {
                return obj2 != null ? ListenableFuture.this : zzgdn.zzg(new zzehf(1, "Retrieve required value in native ad response failed."));
            }
        }, zzcaf.zzg) : zzn(listenableFuture, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x00b1  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00d3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final ListenableFuture zzp(JSONObject jSONObject, boolean z, zzdrr zzdrrVar) {
        HashMap hashMap;
        final String optString;
        int i;
        double d;
        if (jSONObject == null) {
            return zzgdn.zzh(null);
        }
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzek)).booleanValue()) {
            if (jSONObject.has((String) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzel))) {
                HashMap hashMap2 = new HashMap();
                for (String str : ((String) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzem)).split(",")) {
                    try {
                        hashMap2.put(str, jSONObject.getString(str));
                    } catch (JSONException unused) {
                    }
                }
                hashMap = hashMap2;
                optString = jSONObject.optString("url");
                if (!TextUtils.isEmpty(optString) && hashMap == null) {
                    return zzgdn.zzh(null);
                }
                if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzcx)).booleanValue() && zzdrrVar != null) {
                    this.zzr.zza().putLong(zzdrrVar.zza(), com.google.android.gms.ads.internal.zzv.zzD().currentTimeMillis());
                }
                final double optDouble = jSONObject.optDouble("scale", 1.0d);
                boolean optBoolean = jSONObject.optBoolean("is_transparent", true);
                final int optInt = jSONObject.optInt("width", -1);
                final int optInt2 = jSONObject.optInt("height", -1);
                if (!z) {
                    i = optInt;
                    d = optDouble;
                } else {
                    if (hashMap == null) {
                        return zzo(jSONObject.optBoolean("require"), zzgdn.zzm(this.zzb.zzb(optString, optDouble, optBoolean), new zzfve() { // from class: com.google.android.gms.internal.ads.zzdls
                            @Override // com.google.android.gms.internal.ads.zzfve
                            public final Object apply(Object obj) {
                                return new zzbgc(new BitmapDrawable(Resources.getSystem(), (Bitmap) obj), Uri.parse(optString), optDouble, optInt, optInt2, null);
                            }
                        }, this.zzg), null);
                    }
                    d = optDouble;
                    i = optInt;
                }
                return zzgdn.zzh(new zzbgc(null, Uri.parse(optString), d, i, optInt2, hashMap));
            }
        }
        hashMap = null;
        optString = jSONObject.optString("url");
        if (!TextUtils.isEmpty(optString)) {
        }
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzcx)).booleanValue()) {
            this.zzr.zza().putLong(zzdrrVar.zza(), com.google.android.gms.ads.internal.zzv.zzD().currentTimeMillis());
        }
        final double optDouble2 = jSONObject.optDouble("scale", 1.0d);
        boolean optBoolean2 = jSONObject.optBoolean("is_transparent", true);
        final int optInt3 = jSONObject.optInt("width", -1);
        final int optInt22 = jSONObject.optInt("height", -1);
        if (!z) {
        }
        return zzgdn.zzh(new zzbgc(null, Uri.parse(optString), d, i, optInt22, hashMap));
    }

    private final ListenableFuture zzq(JSONArray jSONArray, boolean z, boolean z2, zzdrr zzdrrVar) {
        if (jSONArray == null || jSONArray.length() <= 0) {
            return zzgdn.zzh(Collections.emptyList());
        }
        ArrayList arrayList = new ArrayList();
        int length = z2 ? jSONArray.length() : 1;
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzcx)).booleanValue()) {
            this.zzr.zza().putLong(zzdrrVar.zza(), com.google.android.gms.ads.internal.zzv.zzD().currentTimeMillis());
        }
        for (int i = 0; i < length; i++) {
            arrayList.add(zzp(jSONArray.optJSONObject(i), z, null));
        }
        return zzgdn.zzm(zzgdn.zzd(arrayList), new zzfve() { // from class: com.google.android.gms.internal.ads.zzdlp
            @Override // com.google.android.gms.internal.ads.zzfve
            public final Object apply(Object obj) {
                ArrayList arrayList2 = new ArrayList();
                for (zzbgc zzbgcVar : (List) obj) {
                    if (zzbgcVar != null) {
                        arrayList2.add(zzbgcVar);
                    }
                }
                return arrayList2;
            }
        }, this.zzg);
    }

    private final ListenableFuture zzr(JSONObject jSONObject, zzfca zzfcaVar, zzfcd zzfcdVar, com.google.android.gms.ads.internal.zzb zzbVar, zzbya zzbyaVar) {
        final ListenableFuture zze = this.zzi.zze(jSONObject.optString("base_url"), jSONObject.optString(AnalyticsConstants.CREATIVE_TYPE_HTML), zzfcaVar, zzfcdVar, zzm(jSONObject.optInt("width", 0), jSONObject.optInt("height", 0)), zzbVar, zzbyaVar);
        return zzgdn.zzn(zze, new zzgcu() { // from class: com.google.android.gms.internal.ads.zzdlv
            @Override // com.google.android.gms.internal.ads.zzgcu
            public final ListenableFuture zza(Object obj) {
                zzcfg zzcfgVar = (zzcfg) obj;
                if (zzcfgVar == null || zzcfgVar.zzq() == null) {
                    throw new zzehf(1, "Retrieve video view in html5 ad response failed.");
                }
                return ListenableFuture.this;
            }
        }, zzcaf.zzg);
    }

    private static Integer zzs(JSONObject jSONObject, String str) {
        try {
            JSONObject jSONObject2 = jSONObject.getJSONObject(str);
            return Integer.valueOf(Color.rgb(jSONObject2.getInt("r"), jSONObject2.getInt("g"), jSONObject2.getInt(DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B)));
        } catch (JSONException unused) {
            return null;
        }
    }

    private static final com.google.android.gms.ads.internal.client.zzfa zzt(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        String optString = jSONObject.optString("reason");
        String optString2 = jSONObject.optString("ping_url");
        if (TextUtils.isEmpty(optString) || TextUtils.isEmpty(optString2)) {
            return null;
        }
        return new com.google.android.gms.ads.internal.client.zzfa(optString, optString2);
    }

    public final ListenableFuture zzd(JSONObject jSONObject, String str, zzdrr zzdrrVar) {
        final JSONObject optJSONObject = jSONObject.optJSONObject(C3057e4.c);
        if (optJSONObject == null) {
            return zzgdn.zzh(null);
        }
        JSONArray optJSONArray = optJSONObject.optJSONArray("images");
        JSONObject optJSONObject2 = optJSONObject.optJSONObject("image");
        if (optJSONArray == null && optJSONObject2 != null) {
            optJSONArray = new JSONArray();
            optJSONArray.put(optJSONObject2);
        }
        return zzo(optJSONObject.optBoolean("require"), zzgdn.zzm(zzq(optJSONArray, false, true, zzdrrVar), new zzfve() { // from class: com.google.android.gms.internal.ads.zzdlx
            @Override // com.google.android.gms.internal.ads.zzfve
            public final Object apply(Object obj) {
                return zzdmc.zza(zzdmc.this, optJSONObject, (List) obj);
            }
        }, this.zzg), null);
    }

    public final ListenableFuture zze(JSONObject jSONObject, String str, zzdrr zzdrrVar) {
        return zzp(jSONObject.optJSONObject(str), this.zzh.zzb, zzdrrVar);
    }

    public final ListenableFuture zzf(JSONObject jSONObject, String str, zzdrr zzdrrVar) {
        zzbge zzbgeVar = this.zzh;
        return zzq(jSONObject.optJSONArray("images"), zzbgeVar.zzb, zzbgeVar.zzd, zzdrrVar);
    }

    public final ListenableFuture zzg(JSONObject jSONObject, String str, final zzfca zzfcaVar, final zzfcd zzfcdVar, final com.google.android.gms.ads.internal.zzb zzbVar, final zzbya zzbyaVar) {
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzkw)).booleanValue()) {
            return zzgdn.zzh(null);
        }
        JSONArray optJSONArray = jSONObject.optJSONArray("images");
        if (optJSONArray == null || optJSONArray.length() <= 0) {
            return zzgdn.zzh(null);
        }
        JSONObject optJSONObject = optJSONArray.optJSONObject(0);
        if (optJSONObject == null) {
            return zzgdn.zzh(null);
        }
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzek)).booleanValue()) {
            if (optJSONObject.has((String) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzel))) {
                return zzgdn.zzh(null);
            }
        }
        final String optString = optJSONObject.optString("base_url");
        final String optString2 = optJSONObject.optString(AnalyticsConstants.CREATIVE_TYPE_HTML);
        final com.google.android.gms.ads.internal.client.zzr zzm = zzm(optJSONObject.optInt("width", 0), optJSONObject.optInt("height", 0));
        if (TextUtils.isEmpty(optString2)) {
            return zzgdn.zzh(null);
        }
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzcx)).booleanValue()) {
            this.zzr.zza().putLong(zzdrr.NATIVE_ASSETS_LOADING_IMAGE_COMPOSITION_START.zza(), com.google.android.gms.ads.internal.zzv.zzD().currentTimeMillis());
        }
        final ListenableFuture zzn = zzgdn.zzn(zzgdn.zzh(null), new zzgcu() { // from class: com.google.android.gms.internal.ads.zzdlz
            @Override // com.google.android.gms.internal.ads.zzgcu
            public final ListenableFuture zza(Object obj) {
                return zzdmc.zzc(zzdmc.this, zzm, zzfcaVar, zzfcdVar, zzbVar, zzbyaVar, optString, optString2, obj);
            }
        }, zzcaf.zzf);
        return zzgdn.zzn(zzn, new zzgcu() { // from class: com.google.android.gms.internal.ads.zzdlq
            @Override // com.google.android.gms.internal.ads.zzgcu
            public final ListenableFuture zza(Object obj) {
                if (((zzcfg) obj) != null) {
                    return ListenableFuture.this;
                }
                throw new zzehf(1, "Retrieve Web View from image ad response failed.");
            }
        }, zzcaf.zzg);
    }

    public final ListenableFuture zzh(ListenableFuture listenableFuture) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzcx)).booleanValue()) {
            this.zzr.zza().putLong(zzdrr.NATIVE_ASSETS_LOADING_MEDIA_START.zza(), com.google.android.gms.ads.internal.zzv.zzD().currentTimeMillis());
        }
        zzcak zzcakVar = new zzcak();
        zzgdn.zzr(listenableFuture, new zzdmb(this, zzcakVar), zzcaf.zzf);
        return zzcakVar;
    }

    public final ListenableFuture zzi(JSONObject jSONObject, final com.google.android.gms.ads.internal.zzb zzbVar, final zzbya zzbyaVar) {
        if (!jSONObject.optBoolean("enable_omid")) {
            return zzgdn.zzh(null);
        }
        JSONObject optJSONObject = jSONObject.optJSONObject("omid_settings");
        if (optJSONObject == null) {
            return zzgdn.zzh(null);
        }
        final String optString = optJSONObject.optString("omid_html");
        if (TextUtils.isEmpty(optString)) {
            return zzgdn.zzh(null);
        }
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzcx)).booleanValue()) {
            this.zzr.zza().putLong(zzdrr.NATIVE_ASSETS_LOADING_OMID_START.zza(), com.google.android.gms.ads.internal.zzv.zzD().currentTimeMillis());
        }
        return zzgdn.zzn(zzgdn.zzh(null), new zzgcu() { // from class: com.google.android.gms.internal.ads.zzdlr
            @Override // com.google.android.gms.internal.ads.zzgcu
            public final ListenableFuture zza(Object obj) {
                return zzdmc.zzb(zzdmc.this, optString, zzbyaVar, zzbVar, obj);
            }
        }, zzcaf.zzf);
    }

    public final ListenableFuture zzj(JSONObject jSONObject, zzfca zzfcaVar, zzfcd zzfcdVar, com.google.android.gms.ads.internal.zzb zzbVar, zzbya zzbyaVar) {
        ListenableFuture zzd;
        zzdmc zzdmcVar;
        boolean z = false;
        JSONObject zzh = com.google.android.gms.ads.internal.util.zzbs.zzh(jSONObject, "html_containers", "instream");
        if (zzh != null) {
            return zzr(zzh, zzfcaVar, zzfcdVar, zzbVar, zzbyaVar);
        }
        JSONObject optJSONObject = jSONObject.optJSONObject("video");
        if (optJSONObject == null) {
            return zzgdn.zzh(null);
        }
        String optString = optJSONObject.optString("vast_xml");
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzkv)).booleanValue() && optJSONObject.has(AnalyticsConstants.CREATIVE_TYPE_HTML)) {
            z = true;
        }
        if (TextUtils.isEmpty(optString)) {
            if (!z) {
                int i = com.google.android.gms.ads.internal.util.zze.zza;
                com.google.android.gms.ads.internal.util.client.zzo.zzj("Required field 'vast_xml' or 'html' is missing");
                return zzgdn.zzh(null);
            }
        } else if (!z) {
            zzd = this.zzi.zzd(optJSONObject, zzbVar, zzbyaVar);
            zzdmcVar = this;
            return zzn(zzgdn.zzo(zzd, ((Integer) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzec)).intValue(), TimeUnit.SECONDS, zzdmcVar.zzk), null);
        }
        zzdmcVar = this;
        zzd = zzdmcVar.zzr(optJSONObject, zzfcaVar, zzfcdVar, zzbVar, zzbyaVar);
        return zzn(zzgdn.zzo(zzd, ((Integer) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzec)).intValue(), TimeUnit.SECONDS, zzdmcVar.zzk), null);
    }

    private final com.google.android.gms.ads.internal.client.zzr zzm(int i, int i2) {
        if (i == 0) {
            if (i2 == 0) {
                return com.google.android.gms.ads.internal.client.zzr.zzc();
            }
            i = 0;
        }
        return new com.google.android.gms.ads.internal.client.zzr(this.zza, new AdSize(i, i2));
    }
}
