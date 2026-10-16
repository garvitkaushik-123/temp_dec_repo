package com.google.android.gms.internal.ads;

import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzehw implements zzedo {
    private final Map zza = new HashMap();
    private final zzdpz zzb;

    public zzehw(zzdpz zzdpzVar) {
        this.zzb = zzdpzVar;
    }

    @Override // com.google.android.gms.internal.ads.zzedo
    public final zzedp zza(String str, JSONObject jSONObject) throws zzfdd {
        zzedp zzedpVar;
        synchronized (this) {
            Map map = this.zza;
            zzedpVar = (zzedp) map.get(str);
            if (zzedpVar == null) {
                zzedpVar = new zzedp(this.zzb.zzc(str, jSONObject), new zzefe(), str);
                map.put(str, zzedpVar);
            }
        }
        return zzedpVar;
    }
}
