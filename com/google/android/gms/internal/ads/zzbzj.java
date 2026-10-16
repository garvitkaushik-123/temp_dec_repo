package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.common.util.concurrent.ListenableFuture;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzbzj {
    public final ListenableFuture zza(Context context, int i) {
        zzcak zzcakVar = new zzcak();
        com.google.android.gms.ads.internal.client.zzbb.zzb();
        if (com.google.android.gms.ads.internal.util.client.zzf.zzy(context)) {
            zzcaf.zza.execute(new zzbzi(this, context, zzcakVar));
        }
        return zzcakVar;
    }
}
