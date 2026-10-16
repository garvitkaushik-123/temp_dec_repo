package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.UUID;
import javax.annotation.ParametersAreNonnullByDefault;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
@ParametersAreNonnullByDefault
/* loaded from: classes5.dex */
public final class zzbpa implements zzbom {
    private final zzboo zza;
    private final zzbop zzb;
    private final zzboi zzc;
    private final String zzd;

    zzbpa(zzboi zzboiVar, String str, zzbop zzbopVar, zzboo zzbooVar) {
        this.zzc = zzboiVar;
        this.zzd = str;
        this.zzb = zzbopVar;
        this.zza = zzbooVar;
    }

    static /* bridge */ /* synthetic */ void zzd(zzbpa zzbpaVar, zzboc zzbocVar, zzboj zzbojVar, Object obj, zzcak zzcakVar) {
        try {
            com.google.android.gms.ads.internal.zzv.zzr();
            String uuid = UUID.randomUUID().toString();
            zzbke.zzo.zzc(uuid, new zzboz(zzbpaVar, zzbocVar, zzcakVar));
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("id", uuid);
            jSONObject.put("args", zzbpaVar.zzb.zzb(obj));
            zzbojVar.zzp(zzbpaVar.zzd, jSONObject);
        } catch (Exception e) {
            try {
                zzcakVar.zzd(e);
                int i = com.google.android.gms.ads.internal.util.zze.zza;
                com.google.android.gms.ads.internal.util.client.zzo.zzh("Unable to invokeJavascript", e);
            } finally {
                zzbocVar.zzb();
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgcu
    public final ListenableFuture zza(Object obj) throws Exception {
        return zzb(obj);
    }

    @Override // com.google.android.gms.internal.ads.zzbom
    public final ListenableFuture zzb(Object obj) {
        zzcak zzcakVar = new zzcak();
        zzboc zzb = this.zzc.zzb(null);
        com.google.android.gms.ads.internal.util.zze.zza("callJs > getEngine: Promise created");
        zzb.zzj(new zzbox(this, zzb, obj, zzcakVar), new zzboy(this, zzcakVar, zzb));
        return zzcakVar;
    }
}
