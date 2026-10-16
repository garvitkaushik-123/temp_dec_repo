package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzeui implements zzeuc {
    private final Context zza;
    private final zzgdy zzb;

    zzeui(Context context, zzgdy zzgdyVar) {
        this.zza = context;
        this.zzb = zzgdyVar;
    }

    public static /* synthetic */ zzeuj zzc(zzeui zzeuiVar) {
        Context context = zzeuiVar.zza;
        return new zzeuj(zzbco.zzb(context), zzbco.zza(context));
    }

    @Override // com.google.android.gms.internal.ads.zzeuc
    public final int zza() {
        return 59;
    }

    @Override // com.google.android.gms.internal.ads.zzeuc
    public final ListenableFuture zzb() {
        return ((Boolean) zzbew.zzb.zze()).booleanValue() ? this.zzb.zzb(new Callable() { // from class: com.google.android.gms.internal.ads.zzeuh
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return zzeui.zzc(zzeui.this);
            }
        }) : zzgdn.zzh(new zzeuj(-1, -1));
    }
}
