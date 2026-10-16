package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzesk implements zzeuc {
    private static String zza;
    private final zzgdy zzb;
    private final Context zzc;

    public zzesk(zzgdy zzgdyVar, Context context) {
        this.zzb = zzgdyVar;
        this.zzc = context;
    }

    public static /* synthetic */ zzesl zzc(zzesk zzeskVar) {
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzfz)).booleanValue()) {
            return new zzesl(null);
        }
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzfI)).booleanValue()) {
            return new zzesl(com.google.android.gms.ads.internal.zzv.zzC().zzf(zzeskVar.zzc));
        }
        if (zza == null) {
            zza = com.google.android.gms.ads.internal.zzv.zzC().zzf(zzeskVar.zzc);
        }
        return new zzesl(zza);
    }

    @Override // com.google.android.gms.internal.ads.zzeuc
    public final int zza() {
        return 27;
    }

    @Override // com.google.android.gms.internal.ads.zzeuc
    public final ListenableFuture zzb() {
        return this.zzb.zzb(new Callable() { // from class: com.google.android.gms.internal.ads.zzesj
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return zzesk.zzc(zzesk.this);
            }
        });
    }
}
