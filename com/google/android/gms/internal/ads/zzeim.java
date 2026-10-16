package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzeim implements zzedo {
    private final zzejq zza;
    private final zzdpz zzb;

    zzeim(zzejq zzejqVar, zzdpz zzdpzVar) {
        this.zza = zzejqVar;
        this.zzb = zzdpzVar;
    }

    @Override // com.google.android.gms.internal.ads.zzedo
    public final zzedp zza(String str, JSONObject jSONObject) throws zzfdd {
        zzbrp zzbrpVar;
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzbQ)).booleanValue()) {
            try {
                zzbrpVar = this.zzb.zzb(str);
            } catch (RemoteException e) {
                int i = com.google.android.gms.ads.internal.util.zze.zza;
                com.google.android.gms.ads.internal.util.client.zzo.zzh("Coundn't create RTB adapter: ", e);
                zzbrpVar = null;
            }
        } else {
            zzbrpVar = this.zza.zza(str);
        }
        if (zzbrpVar == null) {
            return null;
        }
        return new zzedp(zzbrpVar, new zzefd(), str);
    }
}
