package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzenn implements zzeuc {
    private final Executor zza;
    private final zzbzs zzb;

    zzenn(Executor executor, zzbzs zzbzsVar) {
        this.zza = executor;
        this.zzb = zzbzsVar;
    }

    @Override // com.google.android.gms.internal.ads.zzeuc
    public final int zza() {
        return 10;
    }

    @Override // com.google.android.gms.internal.ads.zzeuc
    public final ListenableFuture zzb() {
        return ((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzdg)).booleanValue() ? zzgdn.zzh(new zzeno(null)) : zzgdn.zzm(this.zzb.zzk(), new zzfve() { // from class: com.google.android.gms.internal.ads.zzenm
            @Override // com.google.android.gms.internal.ads.zzfve
            public final Object apply(Object obj) {
                ArrayList arrayList = (ArrayList) obj;
                if (true == arrayList.isEmpty()) {
                    arrayList = null;
                }
                return new zzeno(arrayList);
            }
        }, this.zza);
    }
}
