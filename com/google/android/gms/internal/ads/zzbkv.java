package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import com.google.common.util.concurrent.ListenableFuture;
import com.ironsource.C3040d4;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import javax.annotation.ParametersAreNonnullByDefault;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
@ParametersAreNonnullByDefault
/* loaded from: classes5.dex */
public final class zzbkv implements zzbkf {
    private final Object zza = new Object();
    private final Map zzb = new HashMap();

    @Override // com.google.android.gms.internal.ads.zzbkf
    public final void zza(Object obj, Map map) {
        String str = (String) map.get("id");
        String str2 = (String) map.get(C3040d4.f.e);
        String str3 = (String) map.get("fail_reason");
        String str4 = (String) map.get("fail_stack");
        String str5 = (String) map.get("result");
        if (true == TextUtils.isEmpty(str4)) {
            str3 = "Unknown Fail Reason.";
        }
        String concat = TextUtils.isEmpty(str4) ? "" : "\n".concat(String.valueOf(str4));
        synchronized (this.zza) {
            zzbku zzbkuVar = (zzbku) this.zzb.remove(str);
            if (zzbkuVar == null) {
                int i = com.google.android.gms.ads.internal.util.zze.zza;
                com.google.android.gms.ads.internal.util.client.zzo.zzj("Received result for unexpected method invocation: " + str);
                return;
            }
            if (!TextUtils.isEmpty(str2)) {
                zzbkuVar.zza(str3 + concat);
                return;
            }
            if (str5 == null) {
                zzbkuVar.zzb(null);
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject(str5);
                if (com.google.android.gms.ads.internal.util.zze.zzc()) {
                    com.google.android.gms.ads.internal.util.zze.zza("Result GMSG: " + jSONObject.toString(2));
                }
                zzbkuVar.zzb(jSONObject);
            } catch (JSONException e) {
                zzbkuVar.zza(e.getMessage());
            }
        }
    }

    public final ListenableFuture zzb(zzbnm zzbnmVar, String str, JSONObject jSONObject) {
        zzcak zzcakVar = new zzcak();
        com.google.android.gms.ads.internal.zzv.zzr();
        String uuid = UUID.randomUUID().toString();
        zzc(uuid, new zzbkt(this, zzcakVar));
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("id", uuid);
            jSONObject2.put("args", jSONObject);
            zzbnmVar.zzp(str, jSONObject2);
            return zzcakVar;
        } catch (Exception e) {
            zzcakVar.zzd(e);
            return zzcakVar;
        }
    }

    public final void zzc(String str, zzbku zzbkuVar) {
        synchronized (this.zza) {
            this.zzb.put(str, zzbkuVar);
        }
    }
}
