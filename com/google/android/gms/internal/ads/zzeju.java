package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.text.TextUtils;
import com.ironsource.N6;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzeju {
    private final Map zza = new HashMap();
    private final Map zzb = new HashMap();
    private final Map zzc = new HashMap();
    private final Map zzd = new HashMap();
    private final Map zze = new HashMap();
    private final Executor zzf;
    private JSONObject zzg;

    zzeju(Executor executor) {
        this.zzf = executor;
    }

    private final synchronized zzfyt zzh(String str) {
        HashMap hashMap;
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(com.google.android.gms.ads.internal.zzv.zzp().zzi().zzg().zzc())) {
            boolean matches = Pattern.matches((String) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzdx), str);
            boolean matches2 = Pattern.matches((String) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzdy), str);
            if (matches) {
                hashMap = new HashMap(this.zze);
            } else if (matches2) {
                hashMap = new HashMap(this.zzd);
            }
            return zzfyt.zzc(hashMap);
        }
        return zzfyt.zzd();
    }

    private final synchronized List zzi(JSONObject jSONObject, String str) {
        ArrayList arrayList;
        arrayList = new ArrayList();
        if (jSONObject != null) {
            Bundle zzo = zzo(jSONObject.optJSONObject("data"));
            JSONArray optJSONArray = jSONObject.optJSONArray("rtb_adapters");
            if (optJSONArray != null) {
                ArrayList arrayList2 = new ArrayList();
                for (int i = 0; i < optJSONArray.length(); i++) {
                    String optString = optJSONArray.optString(i, "");
                    if (!TextUtils.isEmpty(optString)) {
                        arrayList2.add(optString);
                    }
                }
                int size = arrayList2.size();
                for (int i2 = 0; i2 < size; i2++) {
                    String str2 = (String) arrayList2.get(i2);
                    zzg(str2);
                    if (((zzejw) this.zza.get(str2)) != null) {
                        arrayList.add(new zzejw(str2, str, zzo));
                    }
                }
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final synchronized void zzj() {
        this.zzb.clear();
        this.zza.clear();
        this.zze.clear();
        this.zzd.clear();
        zzm();
        zzn();
        zzk();
    }

    private final synchronized void zzk() {
        JSONObject zzf;
        if (!((Boolean) zzbfk.zzb.zze()).booleanValue()) {
            if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzbY)).booleanValue() && (zzf = com.google.android.gms.ads.internal.zzv.zzp().zzi().zzg().zzf()) != null) {
                try {
                    JSONArray jSONArray = zzf.getJSONArray("adapter_settings");
                    for (int i = 0; i < jSONArray.length(); i++) {
                        JSONObject jSONObject = jSONArray.getJSONObject(i);
                        String optString = jSONObject.optString("adapter_class_name");
                        JSONArray optJSONArray = jSONObject.optJSONArray("permission_set");
                        if (!TextUtils.isEmpty(optString) && optJSONArray != null) {
                            for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                                JSONObject jSONObject2 = optJSONArray.getJSONObject(i2);
                                boolean optBoolean = jSONObject2.optBoolean("enable_rendering", false);
                                boolean optBoolean2 = jSONObject2.optBoolean("collect_secure_signals", false);
                                boolean optBoolean3 = jSONObject2.optBoolean("collect_secure_signals_on_full_app", false);
                                String optString2 = jSONObject2.optString(N6.H);
                                zzejy zzejyVar = new zzejy(optString, optBoolean2, optBoolean, optBoolean3, new Bundle());
                                if (optString2.equals("ADMOB")) {
                                    this.zzd.put(optString, zzejyVar);
                                } else if (optString2.equals("AD_MANAGER")) {
                                    this.zze.put(optString, zzejyVar);
                                }
                            }
                        }
                    }
                } catch (JSONException e) {
                    com.google.android.gms.ads.internal.util.zze.zzb("Malformed config loading JSON.", e);
                }
            }
        }
    }

    private final synchronized void zzl(String str, String str2, List list) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        Map map = this.zzc;
        Map map2 = (Map) map.get(str);
        if (map2 == null) {
            map2 = new HashMap();
        }
        map.put(str, map2);
        List list2 = (List) map2.get(str2);
        if (list2 == null) {
            list2 = new ArrayList();
        }
        list2.addAll(list);
        map2.put(str2, list2);
    }

    private final synchronized void zzm() {
        JSONArray optJSONArray;
        JSONObject zzf = com.google.android.gms.ads.internal.zzv.zzp().zzi().zzg().zzf();
        if (zzf != null) {
            try {
                JSONArray optJSONArray2 = zzf.optJSONArray("ad_unit_id_settings");
                this.zzg = zzf.optJSONObject("ad_unit_patterns");
                if (optJSONArray2 != null) {
                    for (int i = 0; i < optJSONArray2.length(); i++) {
                        JSONObject jSONObject = optJSONArray2.getJSONObject(i);
                        String lowerCase = ((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzlq)).booleanValue() ? jSONObject.optString("ad_unit_id", "").toLowerCase(Locale.ROOT) : jSONObject.optString("ad_unit_id", "");
                        String optString = jSONObject.optString("format", "");
                        ArrayList arrayList = new ArrayList();
                        JSONObject optJSONObject = jSONObject.optJSONObject("mediation_config");
                        if (optJSONObject != null && (optJSONArray = optJSONObject.optJSONArray("ad_networks")) != null) {
                            for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                                arrayList.addAll(zzi(optJSONArray.getJSONObject(i2), optString));
                            }
                        }
                        zzl(optString, lowerCase, arrayList);
                    }
                }
            } catch (JSONException e) {
                com.google.android.gms.ads.internal.util.zze.zzb("Malformed config loading JSON.", e);
            }
        }
    }

    private final synchronized void zzn() {
        JSONObject zzf;
        if (!((Boolean) zzbfk.zze.zze()).booleanValue()) {
            if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzbX)).booleanValue() && (zzf = com.google.android.gms.ads.internal.zzv.zzp().zzi().zzg().zzf()) != null) {
                try {
                    JSONArray jSONArray = zzf.getJSONArray("signal_adapters");
                    for (int i = 0; i < jSONArray.length(); i++) {
                        JSONObject jSONObject = jSONArray.getJSONObject(i);
                        Bundle zzo = zzo(jSONObject.optJSONObject("data"));
                        String optString = jSONObject.optString("adapter_class_name");
                        boolean optBoolean = jSONObject.optBoolean("render", false);
                        boolean optBoolean2 = jSONObject.optBoolean("collect_signals", false);
                        if (!TextUtils.isEmpty(optString)) {
                            this.zzb.put(optString, new zzejy(optString, optBoolean2, optBoolean, true, zzo));
                        }
                    }
                } catch (JSONException e) {
                    com.google.android.gms.ads.internal.util.zze.zzb("Malformed config loading JSON.", e);
                }
            }
        }
    }

    private static final Bundle zzo(JSONObject jSONObject) {
        Bundle bundle = new Bundle();
        if (jSONObject != null) {
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                bundle.putString(next, jSONObject.optString(next, ""));
            }
        }
        return bundle;
    }

    public final synchronized Map zza(String str, String str2) {
        HashMap hashMap;
        Map zzb = zzb(str, str2);
        zzfyt zzh = zzh(str2);
        hashMap = new HashMap();
        for (Map.Entry entry : ((zzfyt) zzb).entrySet()) {
            String str3 = (String) entry.getKey();
            if (zzh.containsKey(str3)) {
                zzejy zzejyVar = (zzejy) zzh.get(str3);
                List list = (List) entry.getValue();
                hashMap.put(str3, new zzejy(str3, zzejyVar.zzb, zzejyVar.zzc, zzejyVar.zzd, (list == null || list.isEmpty()) ? new Bundle() : (Bundle) list.get(0)));
            }
        }
        zzgaw it = zzh.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry2 = (Map.Entry) it.next();
            String str4 = (String) entry2.getKey();
            if (!hashMap.containsKey(str4) && ((zzejy) entry2.getValue()).zzd) {
                hashMap.put(str4, (zzejy) entry2.getValue());
            }
        }
        return hashMap;
    }

    public final synchronized Map zzb(String str, String str2) {
        Map map;
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && !TextUtils.isEmpty(com.google.android.gms.ads.internal.zzv.zzp().zzi().zzg().zzc()) && (map = (Map) this.zzc.get(str)) != null) {
            List<zzejw> list = (List) map.get(str2);
            if (list == null) {
                String zza = zzdqg.zza(this.zzg, str2, str);
                if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzlq)).booleanValue()) {
                    zza = zza.toLowerCase(Locale.ROOT);
                }
                list = (List) map.get(zza);
            }
            if (list != null) {
                HashMap hashMap = new HashMap();
                for (zzejw zzejwVar : list) {
                    String str3 = zzejwVar.zza;
                    if (!hashMap.containsKey(str3)) {
                        hashMap.put(str3, new ArrayList());
                    }
                    ((List) hashMap.get(str3)).add(zzejwVar.zzb);
                }
                return zzfyt.zzc(hashMap);
            }
        }
        return zzfyt.zzd();
    }

    public final synchronized Map zzc() {
        if (TextUtils.isEmpty(com.google.android.gms.ads.internal.zzv.zzp().zzi().zzg().zzc())) {
            return zzfyt.zzd();
        }
        return zzfyt.zzc(this.zzb);
    }

    public final void zzf() {
        com.google.android.gms.ads.internal.zzv.zzp().zzi().zzo(new Runnable() { // from class: com.google.android.gms.internal.ads.zzejt
            @Override // java.lang.Runnable
            public final void run() {
                r0.zzf.execute(new zzejs(zzeju.this));
            }
        });
        this.zzf.execute(new zzejs(this));
    }

    public final synchronized void zzg(String str) {
        if (!TextUtils.isEmpty(str)) {
            Map map = this.zza;
            if (!map.containsKey(str)) {
                map.put(str, new zzejw(str, "", new Bundle()));
            }
        }
    }
}
