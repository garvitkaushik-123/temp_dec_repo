package com.google.android.gms.internal.ads;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.annotation.CheckForNull;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzdqe {
    private JSONObject zzb;
    private final Executor zzc;
    private boolean zzd;
    private JSONObject zze;
    private final Map zza = new ConcurrentHashMap();
    private final AtomicBoolean zzf = new AtomicBoolean(false);

    public zzdqe(Executor executor) {
        this.zzc = executor;
    }

    private final void zzg() {
        if (this.zzf.getAndSet(true)) {
            return;
        }
        com.google.android.gms.ads.internal.zzv.zzp().zzi().zzo(new Runnable() { // from class: com.google.android.gms.internal.ads.zzdqc
            @Override // java.lang.Runnable
            public final void run() {
                r0.zzc.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzdqd
                    @Override // java.lang.Runnable
                    public final void run() {
                        zzdqe.this.zzh();
                    }
                });
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final synchronized void zzh() {
        JSONObject zzf;
        Map map;
        this.zzd = true;
        zzbzm zzg = com.google.android.gms.ads.internal.zzv.zzp().zzi().zzg();
        if (zzg != null && (zzf = zzg.zzf()) != null) {
            this.zzb = ((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzes)).booleanValue() ? zzf.optJSONObject("common_settings") : null;
            this.zze = zzf.optJSONObject("ad_unit_patterns");
            JSONArray optJSONArray = zzf.optJSONArray("ad_unit_id_settings");
            if (optJSONArray != null) {
                for (int i = 0; i < optJSONArray.length(); i++) {
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                    if (optJSONObject != null) {
                        String optString = optJSONObject.optString("ad_unit_id");
                        String optString2 = optJSONObject.optString("format");
                        JSONObject optJSONObject2 = optJSONObject.optJSONObject("request_signals");
                        if (optString != null && optJSONObject2 != null && optString2 != null) {
                            Map map2 = this.zza;
                            if (map2.containsKey(optString2)) {
                                map = (Map) map2.get(optString2);
                            } else {
                                ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
                                map2.put(optString2, concurrentHashMap);
                                map = concurrentHashMap;
                            }
                            map.put(optString, optJSONObject2);
                        }
                    }
                }
            }
        }
    }

    @CheckForNull
    public final JSONObject zza() {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzes)).booleanValue()) {
            return this.zzb;
        }
        return null;
    }

    @CheckForNull
    public final JSONObject zzb(String str, String str2) {
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzeq)).booleanValue() || str == null || str2 == null) {
            return null;
        }
        if (!this.zzd) {
            zzh();
            if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzer)).booleanValue()) {
                zzg();
            }
        }
        Map map = (Map) this.zza.get(str2);
        if (map == null) {
            return null;
        }
        JSONObject jSONObject = (JSONObject) map.get(str);
        if (jSONObject != null) {
            return jSONObject;
        }
        String zza = zzdqg.zza(this.zze, str, str2);
        if (zza != null) {
            return (JSONObject) map.get(zza);
        }
        return null;
    }

    public final void zzf() {
        zzg();
        this.zzc.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzdqb
            @Override // java.lang.Runnable
            public final void run() {
                zzdqe.this.zzh();
            }
        });
    }
}
