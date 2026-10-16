package com.google.android.gms.internal.ads;

import android.content.Context;
import android.net.Uri;
import android.os.Binder;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Pair;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.common.util.concurrent.ListenableFuture;
import com.ironsource.C3040d4;
import com.ironsource.C3337ue;
import com.vungle.ads.internal.ui.AdActivity;
import java.io.StringReader;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.regex.Pattern;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzdyb {
    private static final Pattern zza = Pattern.compile("\\?");
    private final zzche zzb;
    private final Context zzc;
    private final VersionInfoParcel zzd;
    private final zzfcw zze;
    private final Executor zzf;
    private final ScheduledExecutorService zzg;
    private final String zzh;
    private final zzfhu zzi;
    private final zzdsd zzj;
    private final zzfjy zzk;
    private final zzcyy zzl;
    private final Object zzm = new Object();
    private String zzn;
    private List zzo;
    private Bundle zzp;
    private final zzbvy zzq;

    zzdyb(zzche zzcheVar, Context context, VersionInfoParcel versionInfoParcel, zzfcw zzfcwVar, Executor executor, String str, zzfhu zzfhuVar, zzdsd zzdsdVar, zzbvy zzbvyVar, zzeag zzeagVar, ScheduledExecutorService scheduledExecutorService, zzfjy zzfjyVar, zzcyy zzcyyVar) {
        this.zzb = zzcheVar;
        this.zzc = context;
        this.zzd = versionInfoParcel;
        this.zze = zzfcwVar;
        this.zzf = executor;
        this.zzh = str;
        this.zzi = zzfhuVar;
        zzcheVar.zzw();
        this.zzj = zzdsdVar;
        this.zzq = zzbvyVar;
        this.zzg = scheduledExecutorService;
        this.zzk = zzfjyVar;
        this.zzl = zzcyyVar;
    }

    public static /* synthetic */ ListenableFuture zzb(zzdyb zzdybVar, List list, Exception exc) {
        zzehf zzehfVar;
        com.google.android.gms.ads.internal.zzv.zzp().zzv(exc, "PreloadedLoader.getTypeTwoAdResponseString");
        if (exc instanceof TimeoutException) {
            zzehfVar = new zzehf(1, "Timed out waiting for ad response.");
        } else if (exc instanceof zzehf) {
            zzehfVar = (zzehf) exc;
        } else {
            zzehfVar = new zzehf(1, exc.getMessage() == null ? "Fetch failed." : exc.getMessage());
        }
        String message = zzehfVar.getMessage() == null ? "" : zzehfVar.getMessage();
        if (list != null && !list.isEmpty()) {
            String str = "0.6.0.0";
            if (!TextUtils.isEmpty(message)) {
                if (message.contains("Timed out waiting for ad response.")) {
                    message = "timeout";
                    str = "0.2.0.0";
                } else if (message.contains("Received HTTP error code from ad server:")) {
                    List zzf = zzfwe.zzb(zzfva.zzc(AbstractJsonLexerKt.COLON)).zzf(message);
                    if (zzf.size() == 2) {
                        message = (String) zzf.get(1);
                    }
                }
            }
            ArrayList arrayList = new ArrayList();
            Iterator it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(zzfju.zzc(zzfju.zzc((String) it.next(), "@gw_adnetstatus@", str), "@error_code@", message));
            }
            zzdybVar.zzk.zze(arrayList, null);
        }
        return zzgdn.zzg(zzehfVar);
    }

    public static /* synthetic */ ListenableFuture zzc(zzdyb zzdybVar, JSONObject jSONObject) {
        zzfck zzfckVar = new zzfck(zzdybVar.zze);
        String jSONObject2 = jSONObject.toString();
        return zzgdn.zzh(new zzfcn(zzfckVar, zzfcm.zza(new StringReader(jSONObject2), zzdybVar.zzp)));
    }

    public static /* synthetic */ ListenableFuture zzd(zzdyb zzdybVar, zzbom zzbomVar, JSONObject jSONObject) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzcs)).booleanValue()) {
            zzdybVar.zzj.zza().putLong(zzdrr.SCAR_PRELOADER_PROCESSING_DONE.zza(), com.google.android.gms.ads.internal.zzv.zzD().currentTimeMillis());
        }
        return zzbomVar.zzb(jSONObject);
    }

    public static /* synthetic */ String zzf(zzdyb zzdybVar, zzead zzeadVar) {
        zzdybVar.zzi(zzdrr.RENDERING_ADSTRING_TYPE2_FETCH_START);
        int i = 0;
        int i2 = -1;
        while (true) {
            try {
                if (i >= ((Integer) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzht)).intValue()) {
                    throw new zzehf(1, "Received HTTP error code from ad server:" + i2);
                }
                zzead zzeadVar2 = zzeadVar;
                zzeae zza2 = new zzeaf(zzdybVar.zzc, zzdybVar.zzd.afmaVersion, zzdybVar.zzq, Binder.getCallingUid()).zza(zzeadVar);
                zzeae zzeaeVar = zza2;
                int i3 = zza2.zza;
                if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzhu)).booleanValue()) {
                    zzdybVar.zzj.zzd("fr", String.valueOf(i));
                }
                if (i3 == 200) {
                    zzdybVar.zzi(zzdrr.RENDERING_ADSTRING_TYPE2_FETCH_END);
                    return zza2.zzc;
                }
                i++;
                i2 = i3;
            } catch (Exception e) {
                throw new zzehf(1, e.getMessage() == null ? "Fetch failed." : e.getMessage(), e);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x013e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final ListenableFuture zzg(String str, final String str2) {
        ListenableFuture zzh;
        String str3;
        String str4;
        String str5 = "";
        if (TextUtils.isEmpty(str)) {
            return zzgdn.zzg(new zzehf(15, "Invalid ad string."));
        }
        Context context = this.zzc;
        zzfhj zza2 = zzfhi.zza(context, 11);
        zza2.zzi();
        zzbow zza3 = com.google.android.gms.ads.internal.zzv.zzg().zza(context, this.zzd, this.zzb.zzy());
        zzboq zzboqVar = zzbot.zza;
        final zzbom zza4 = zza3.zza("google.afma.response.normalize", zzboqVar, zzboqVar);
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzhp)).booleanValue()) {
            try {
                str3 = str;
            } catch (JSONException unused) {
                str3 = str;
            }
            try {
                JSONObject jSONObject = new JSONObject(str3);
                this.zzn = jSONObject.optString("fetch_url", "");
                this.zzo = com.google.android.gms.ads.internal.util.zzbs.zzc(new JSONObject(jSONObject.optString("settings", "")).getJSONArray("nofill_urls"), null);
            } catch (JSONException unused2) {
                int i = com.google.android.gms.ads.internal.util.zze.zza;
                com.google.android.gms.ads.internal.util.client.zzo.zzj("Invalid ad response.");
                str4 = this.zzn;
                final List list = this.zzo;
                if (TextUtils.isEmpty(str4)) {
                }
                zzgcu zzgcuVar = new zzgcu(this) { // from class: com.google.android.gms.internal.ads.zzdxv
                    @Override // com.google.android.gms.internal.ads.zzgcu
                    public final ListenableFuture zza(Object obj) {
                        String str6 = (String) obj;
                        JSONObject jSONObject2 = new JSONObject();
                        JSONObject jSONObject3 = new JSONObject();
                        JSONObject jSONObject4 = new JSONObject();
                        String str7 = str2;
                        try {
                            jSONObject4.put("headers", new JSONObject());
                            jSONObject4.put("body", str6);
                            jSONObject3.put("base_url", "");
                            jSONObject3.put("signals", new JSONObject(str7));
                            jSONObject2.put(AdActivity.REQUEST_KEY_EXTRA, jSONObject3);
                            jSONObject2.put(C3337ue.n, jSONObject4);
                            jSONObject2.put("flags", new JSONObject());
                            return zzgdn.zzh(jSONObject2);
                        } catch (JSONException e) {
                            throw new JSONException("Preloaded loader: ".concat(String.valueOf(String.valueOf(e.getCause()))));
                        }
                    }
                };
                Executor executor = this.zzf;
                ListenableFuture zzn = zzgdn.zzn(zzgdn.zzn(zzgdn.zzn(zzh, zzgcuVar, executor), new zzgcu() { // from class: com.google.android.gms.internal.ads.zzdxw
                    @Override // com.google.android.gms.internal.ads.zzgcu
                    public final ListenableFuture zza(Object obj) {
                        return zzdyb.zzd(zzdyb.this, zza4, (JSONObject) obj);
                    }
                }, executor), new zzgcu() { // from class: com.google.android.gms.internal.ads.zzdxx
                    @Override // com.google.android.gms.internal.ads.zzgcu
                    public final ListenableFuture zza(Object obj) {
                        return zzdyb.zzc(zzdyb.this, (JSONObject) obj);
                    }
                }, executor);
                zzfht.zza(zzn, this.zzi, zza2);
                zzgdn.zzr(zzn, new zzdya(this), zzcaf.zzg);
                return zzn;
            }
            str4 = this.zzn;
            final List list2 = this.zzo;
            if (TextUtils.isEmpty(str4)) {
                this.zzj.zzd("sst", "2");
                String str6 = (String) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzhr);
                if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzhq)).booleanValue()) {
                    List zzf = zzfwe.zzc(zza).zzf(str4);
                    if (zzf.size() < 2) {
                        zzh = zzgdn.zzg(new zzehf(1, "Invalid fetch URL."));
                    } else {
                        str5 = (String) zzf.get(1);
                        com.google.android.gms.ads.internal.zzv.zzr();
                        str4 = Uri.parse(str4).buildUpon().query(null).build().toString();
                    }
                }
                final zzead zzeadVar = new zzead(str4, 60000, new HashMap(), str5.getBytes(StandardCharsets.UTF_8), str6, false);
                zzh = (zzgde) zzgdn.zzf((zzgde) zzgdn.zzo(zzgde.zzw(zzcaf.zza.zzb(new Callable() { // from class: com.google.android.gms.internal.ads.zzdxy
                    @Override // java.util.concurrent.Callable
                    public final Object call() {
                        return zzdyb.zzf(zzdyb.this, zzeadVar);
                    }
                })), ((Integer) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzhs)).intValue(), TimeUnit.MILLISECONDS, this.zzg), Exception.class, new zzgcu() { // from class: com.google.android.gms.internal.ads.zzdxz
                    @Override // com.google.android.gms.internal.ads.zzgcu
                    public final ListenableFuture zza(Object obj) {
                        return zzdyb.zzb(zzdyb.this, list2, (Exception) obj);
                    }
                }, this.zzf);
            } else {
                zzh = zzgdn.zzh(str3);
                this.zzj.zzd("sst", "1");
            }
        } else {
            zzh = zzgdn.zzh(str);
            this.zzj.zzd("sst", "1");
        }
        zzgcu zzgcuVar2 = new zzgcu(this) { // from class: com.google.android.gms.internal.ads.zzdxv
            @Override // com.google.android.gms.internal.ads.zzgcu
            public final ListenableFuture zza(Object obj) {
                String str62 = (String) obj;
                JSONObject jSONObject2 = new JSONObject();
                JSONObject jSONObject3 = new JSONObject();
                JSONObject jSONObject4 = new JSONObject();
                String str7 = str2;
                try {
                    jSONObject4.put("headers", new JSONObject());
                    jSONObject4.put("body", str62);
                    jSONObject3.put("base_url", "");
                    jSONObject3.put("signals", new JSONObject(str7));
                    jSONObject2.put(AdActivity.REQUEST_KEY_EXTRA, jSONObject3);
                    jSONObject2.put(C3337ue.n, jSONObject4);
                    jSONObject2.put("flags", new JSONObject());
                    return zzgdn.zzh(jSONObject2);
                } catch (JSONException e) {
                    throw new JSONException("Preloaded loader: ".concat(String.valueOf(String.valueOf(e.getCause()))));
                }
            }
        };
        Executor executor2 = this.zzf;
        ListenableFuture zzn2 = zzgdn.zzn(zzgdn.zzn(zzgdn.zzn(zzh, zzgcuVar2, executor2), new zzgcu() { // from class: com.google.android.gms.internal.ads.zzdxw
            @Override // com.google.android.gms.internal.ads.zzgcu
            public final ListenableFuture zza(Object obj) {
                return zzdyb.zzd(zzdyb.this, zza4, (JSONObject) obj);
            }
        }, executor2), new zzgcu() { // from class: com.google.android.gms.internal.ads.zzdxx
            @Override // com.google.android.gms.internal.ads.zzgcu
            public final ListenableFuture zza(Object obj) {
                return zzdyb.zzc(zzdyb.this, (JSONObject) obj);
            }
        }, executor2);
        zzfht.zza(zzn2, this.zzi, zza2);
        zzgdn.zzr(zzn2, new zzdya(this), zzcaf.zzg);
        return zzn2;
    }

    private final String zzh(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            JSONArray jSONArray = jSONObject.getJSONArray("ad_types");
            if (jSONArray != null && "unknown".equals(jSONArray.getString(0))) {
                jSONObject.put("ad_types", new JSONArray().put(this.zzh));
            }
            return jSONObject.toString();
        } catch (JSONException e) {
            String concat = "Failed to update the ad types for rendering. ".concat(e.toString());
            int i = com.google.android.gms.ads.internal.util.zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zzj(concat);
            return str;
        }
    }

    private final void zzi(zzdrr zzdrrVar) {
        Bundle zza2 = this.zzj.zza();
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzhu)).booleanValue()) {
            zza2.putLong(zzdrrVar.zza(), com.google.android.gms.ads.internal.zzv.zzD().currentTimeMillis());
        }
    }

    private static final String zzj(String str) {
        try {
            return new JSONObject(str).optString("request_id", "");
        } catch (JSONException unused) {
            return "";
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:80:0x022e, code lost:
    
        if (r5.zzg(r1, r2, r4) == false) goto L87;
     */
    /* JADX WARN: Removed duplicated region for block: B:70:0x01ec A[Catch: all -> 0x0244, TryCatch #1 {, blocks: (B:22:0x0080, B:24:0x009e, B:27:0x00a4, B:29:0x00b1, B:31:0x00cb, B:32:0x00f8, B:34:0x0104, B:36:0x010c, B:37:0x0112, B:41:0x011b, B:44:0x0151, B:47:0x012d, B:50:0x013a, B:52:0x0159, B:55:0x00e2, B:57:0x016f, B:60:0x0188, B:64:0x0190, B:66:0x01b4, B:68:0x01c9, B:70:0x01ec, B:71:0x0201, B:74:0x0215, B:76:0x021b, B:77:0x0228, B:79:0x022a, B:81:0x0233, B:86:0x0230, B:87:0x01f6, B:88:0x01dc, B:91:0x019e, B:94:0x0178, B:95:0x017d), top: B:21:0x0080, inners: #4 }] */
    /* JADX WARN: Removed duplicated region for block: B:76:0x021b A[Catch: all -> 0x0244, TryCatch #1 {, blocks: (B:22:0x0080, B:24:0x009e, B:27:0x00a4, B:29:0x00b1, B:31:0x00cb, B:32:0x00f8, B:34:0x0104, B:36:0x010c, B:37:0x0112, B:41:0x011b, B:44:0x0151, B:47:0x012d, B:50:0x013a, B:52:0x0159, B:55:0x00e2, B:57:0x016f, B:60:0x0188, B:64:0x0190, B:66:0x01b4, B:68:0x01c9, B:70:0x01ec, B:71:0x0201, B:74:0x0215, B:76:0x021b, B:77:0x0228, B:79:0x022a, B:81:0x0233, B:86:0x0230, B:87:0x01f6, B:88:0x01dc, B:91:0x019e, B:94:0x0178, B:95:0x017d), top: B:21:0x0080, inners: #4 }] */
    /* JADX WARN: Removed duplicated region for block: B:79:0x022a A[Catch: all -> 0x0244, TryCatch #1 {, blocks: (B:22:0x0080, B:24:0x009e, B:27:0x00a4, B:29:0x00b1, B:31:0x00cb, B:32:0x00f8, B:34:0x0104, B:36:0x010c, B:37:0x0112, B:41:0x011b, B:44:0x0151, B:47:0x012d, B:50:0x013a, B:52:0x0159, B:55:0x00e2, B:57:0x016f, B:60:0x0188, B:64:0x0190, B:66:0x01b4, B:68:0x01c9, B:70:0x01ec, B:71:0x0201, B:74:0x0215, B:76:0x021b, B:77:0x0228, B:79:0x022a, B:81:0x0233, B:86:0x0230, B:87:0x01f6, B:88:0x01dc, B:91:0x019e, B:94:0x0178, B:95:0x017d), top: B:21:0x0080, inners: #4 }] */
    /* JADX WARN: Removed duplicated region for block: B:84:0x023b  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x01f6 A[Catch: all -> 0x0244, TryCatch #1 {, blocks: (B:22:0x0080, B:24:0x009e, B:27:0x00a4, B:29:0x00b1, B:31:0x00cb, B:32:0x00f8, B:34:0x0104, B:36:0x010c, B:37:0x0112, B:41:0x011b, B:44:0x0151, B:47:0x012d, B:50:0x013a, B:52:0x0159, B:55:0x00e2, B:57:0x016f, B:60:0x0188, B:64:0x0190, B:66:0x01b4, B:68:0x01c9, B:70:0x01ec, B:71:0x0201, B:74:0x0215, B:76:0x021b, B:77:0x0228, B:79:0x022a, B:81:0x0233, B:86:0x0230, B:87:0x01f6, B:88:0x01dc, B:91:0x019e, B:94:0x0178, B:95:0x017d), top: B:21:0x0080, inners: #4 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final ListenableFuture zze() {
        String str;
        int i;
        String str2;
        String string;
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzcs)).booleanValue()) {
            this.zzp = this.zze.zzs;
            this.zzj.zza().putLong(zzdrr.SCAR_PRELOADER_READY.zza(), com.google.android.gms.ads.internal.zzv.zzD().currentTimeMillis());
        }
        String str3 = this.zze.zzd.zzx;
        if (!TextUtils.isEmpty(str3)) {
            String zzj = zzj(str3);
            zzbcv zzbcvVar = zzbde.zzhl;
            if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbcvVar)).booleanValue() && zzj.isEmpty()) {
                int lastIndexOf = str3.lastIndexOf("&request_id=");
                zzj = lastIndexOf != -1 ? str3.substring(lastIndexOf + 12) : "";
            }
            if (TextUtils.isEmpty(zzj)) {
                return zzgdn.zzg(new zzehf(15, "Invalid ad string."));
            }
            synchronized (this.zzm) {
                com.google.android.gms.ads.nonagon.signalgeneration.zzv zzn = this.zzb.zzn();
                zzdsd zzdsdVar = this.zzj;
                String zzb = zzn.zzb(zzj, zzdsdVar);
                String str4 = null;
                if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbcvVar)).booleanValue() && !TextUtils.isEmpty(zzb)) {
                    try {
                        JSONObject optJSONObject = new JSONObject(zzb).optJSONObject("extras");
                        if (optJSONObject != null) {
                            if ((((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzhn)).booleanValue() ? Arrays.asList(((String) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzho)).split(",")) : Arrays.asList(((String) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzhm)).split(","))).contains(com.google.android.gms.ads.nonagon.signalgeneration.zzaa.zzb(optJSONObject.optString("query_info_type", "")))) {
                                int lastIndexOf2 = str3.lastIndexOf(C3040d4.i.c);
                                String substring = lastIndexOf2 != -1 ? str3.substring(0, lastIndexOf2) : null;
                                if (!TextUtils.isEmpty(substring)) {
                                    try {
                                        byte[] decode = Base64.decode(substring, 11);
                                        byte[] bytes = zzj.getBytes("UTF-8");
                                        if (!TextUtils.isEmpty(zzb)) {
                                            try {
                                                string = new JSONObject(zzb).getString("arek");
                                            } catch (JSONException e) {
                                                com.google.android.gms.ads.internal.util.zze.zza("Failed to get key from QueryJSONMap".concat(e.toString()));
                                                com.google.android.gms.ads.internal.zzv.zzp().zzw(e, "CryptoUtils.getKeyFromQueryJsonMap");
                                            }
                                            str3 = zzfdl.zzb(decode, bytes, string, zzdsdVar);
                                        }
                                        string = null;
                                        str3 = zzfdl.zzb(decode, bytes, string, zzdsdVar);
                                    } catch (UnsupportedEncodingException | IllegalArgumentException e2) {
                                        com.google.android.gms.ads.internal.util.zze.zza("Failed to decode the adResponse. ".concat(e2.toString()));
                                        com.google.android.gms.ads.internal.zzv.zzp().zzw(e2, "PreloadedLoader.decryptAdResponseIfNecessary");
                                    }
                                }
                            }
                        }
                    } catch (JSONException unused) {
                    }
                }
                if (TextUtils.isEmpty(str3)) {
                    str = "";
                } else {
                    try {
                        str = new JSONObject(str3).optString("render_id", "");
                    } catch (JSONException unused2) {
                        str = "";
                    }
                }
                if (!TextUtils.isEmpty(str)) {
                    String str5 = "";
                    try {
                        str5 = new String(Base64.decode(str, 0), StandardCharsets.UTF_8);
                    } catch (IllegalArgumentException e3) {
                        com.google.android.gms.ads.internal.util.zze.zza("Ad grouping: Has render_id, but not base64 encoded: ".concat(String.valueOf(str)));
                        com.google.android.gms.ads.internal.zzv.zzp().zzw(e3, "PreloadedLoader.decodeRenderId");
                    }
                    List zzf = zzfwe.zzb(zzfva.zzc(AbstractJsonLexerKt.COLON)).zzf(str5);
                    if (zzf.size() == 2) {
                        str4 = (String) zzf.get(0);
                        i = Integer.parseInt((String) zzf.get(1));
                        Pair pair = str4 == null ? new Pair(str4, Integer.valueOf(i)) : new Pair("", 0);
                        str2 = (String) pair.first;
                        int intValue = ((Integer) pair.second).intValue();
                        if (!TextUtils.isEmpty(str2) && intValue > 0) {
                            if (!zzn.zzh(zzj, str2)) {
                                return zzgdn.zzg(new zzehf(10, "The ad has already been shown."));
                            }
                        }
                        zzn.zzf(zzj);
                        if (!TextUtils.isEmpty(zzb)) {
                            return zzg(str3, zzh(zzb));
                        }
                    } else {
                        com.google.android.gms.ads.internal.util.zze.zza("Ad grouping: Has render_id, but invalid format: ".concat(String.valueOf(str)));
                    }
                }
                i = 0;
                if (str4 == null) {
                }
                str2 = (String) pair.first;
                int intValue2 = ((Integer) pair.second).intValue();
                if (!TextUtils.isEmpty(str2)) {
                    if (!zzn.zzh(zzj, str2)) {
                    }
                }
                zzn.zzf(zzj);
                if (!TextUtils.isEmpty(zzb)) {
                }
            }
        }
        com.google.android.gms.ads.internal.client.zzc zzcVar = this.zze.zzd.zzs;
        if (zzcVar != null) {
            if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzhd)).booleanValue()) {
                String str6 = zzcVar.zza;
                String str7 = zzcVar.zzb;
                String zzj2 = zzj(str6);
                String zzj3 = zzj(str7);
                if (TextUtils.isEmpty(zzj3) || !zzj2.equals(zzj3)) {
                    this.zzj.zzb().put("ridmm", "true");
                } else {
                    this.zzb.zzn().zzf(zzj2);
                    this.zzj.zzb().put("request_id", zzj2);
                }
            }
            return zzg(zzcVar.zza, zzh(zzcVar.zzb));
        }
        return zzgdn.zzg(new zzehf(14, "Mismatch request IDs."));
    }
}
