package com.google.android.gms.internal.ads;

import java.util.Map;
import java.util.Objects;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
final class zzcnh implements zzbkf {
    final /* synthetic */ zzcni zza;

    zzcnh(zzcni zzcniVar) {
        Objects.requireNonNull(zzcniVar);
        this.zza = zzcniVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbkf
    public final void zza(Object obj, Map map) {
        Executor executor;
        zzcni zzcniVar = this.zza;
        if (zzcni.zzg(zzcniVar, map)) {
            executor = zzcniVar.zzc;
            executor.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcng
                @Override // java.lang.Runnable
                public final void run() {
                    zzcnn zzcnnVar;
                    zzcnnVar = zzcnh.this.zza.zzd;
                    zzcnnVar.zzj();
                }
            });
        }
    }
}
