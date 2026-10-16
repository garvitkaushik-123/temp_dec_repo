package com.google.android.gms.ads.nonagon.signalgeneration;

import android.os.Bundle;
import android.util.JsonReader;
import com.google.android.gms.internal.ads.zzbvq;
import com.google.android.gms.internal.ads.zzdxo;
import com.google.android.gms.internal.ads.zzdyy;
import com.google.android.gms.internal.ads.zzgcu;
import com.google.android.gms.internal.ads.zzgdn;
import com.google.common.util.concurrent.ListenableFuture;
import java.io.InputStreamReader;
import java.util.concurrent.Executor;
import org.json.JSONException;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes4.dex */
public final class zzbi implements zzgcu {
    private final Executor zza;
    private final zzdxo zzb;

    public zzbi(Executor executor, zzdxo zzdxoVar) {
        this.zza = executor;
        this.zzb = zzdxoVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgcu
    public final /* bridge */ /* synthetic */ ListenableFuture zza(Object obj) throws Exception {
        final zzbvq zzbvqVar = (zzbvq) obj;
        return zzgdn.zzn(this.zzb.zzc(zzbvqVar), new zzgcu() { // from class: com.google.android.gms.ads.nonagon.signalgeneration.zzbh
            @Override // com.google.android.gms.internal.ads.zzgcu
            public final ListenableFuture zza(Object obj2) {
                zzdyy zzdyyVar = (zzdyy) obj2;
                zzbk zzbkVar = new zzbk(new JsonReader(new InputStreamReader(zzdyyVar.zzb())), zzdyyVar.zza());
                zzbvq zzbvqVar2 = zzbvq.this;
                try {
                    zzbkVar.zzb = com.google.android.gms.ads.internal.client.zzbb.zzb().zzn(zzbvqVar2.zza).toString();
                } catch (JSONException unused) {
                    zzbkVar.zzb = "{}";
                }
                Bundle bundle = zzbvqVar2.zzn;
                if (!bundle.isEmpty()) {
                    try {
                        zzbkVar.zzc = com.google.android.gms.ads.internal.client.zzbb.zzb().zzn(bundle).toString();
                    } catch (JSONException unused2) {
                    }
                }
                return zzgdn.zzh(zzbkVar);
            }
        }, this.zza);
    }
}
