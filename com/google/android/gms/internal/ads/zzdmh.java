package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Executor;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzdmh {
    private final Executor zza;
    private final zzdmc zzb;
    private final zzdsd zzc;

    zzdmh(Executor executor, zzdmc zzdmcVar, zzdsd zzdsdVar) {
        this.zza = executor;
        this.zzb = zzdmcVar;
        this.zzc = zzdsdVar;
    }

    public final ListenableFuture zza(JSONObject jSONObject, String str) {
        ListenableFuture zzh;
        JSONArray optJSONArray = jSONObject.optJSONArray("custom_assets");
        if (optJSONArray == null) {
            return zzgdn.zzh(Collections.emptyList());
        }
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzcx)).booleanValue()) {
            this.zzc.zza().putLong(zzdrr.NATIVE_ASSETS_LOADING_CUSTOM_START.zza(), com.google.android.gms.ads.internal.zzv.zzD().currentTimeMillis());
        }
        ArrayList arrayList = new ArrayList();
        int length = optJSONArray.length();
        for (int i = 0; i < length; i++) {
            JSONObject optJSONObject = optJSONArray.optJSONObject(i);
            if (optJSONObject == null) {
                zzh = zzgdn.zzh(null);
            } else {
                final String optString = optJSONObject.optString("name");
                if (optString == null) {
                    zzh = zzgdn.zzh(null);
                } else {
                    String optString2 = optJSONObject.optString("type");
                    zzh = "string".equals(optString2) ? zzgdn.zzh(new zzdmg(optString, optJSONObject.optString("string_value"))) : "image".equals(optString2) ? zzgdn.zzm(this.zzb.zze(optJSONObject, "image_value", null), new zzfve() { // from class: com.google.android.gms.internal.ads.zzdme
                        @Override // com.google.android.gms.internal.ads.zzfve
                        public final Object apply(Object obj) {
                            return new zzdmg(optString, (zzbgc) obj);
                        }
                    }, this.zza) : zzgdn.zzh(null);
                }
            }
            arrayList.add(zzh);
        }
        return zzgdn.zzm(zzgdn.zzd(arrayList), new zzfve() { // from class: com.google.android.gms.internal.ads.zzdmf
            @Override // com.google.android.gms.internal.ads.zzfve
            public final Object apply(Object obj) {
                ArrayList arrayList2 = new ArrayList();
                for (zzdmg zzdmgVar : (List) obj) {
                    if (zzdmgVar != null) {
                        arrayList2.add(zzdmgVar);
                    }
                }
                return arrayList2;
            }
        }, this.zza);
    }
}
