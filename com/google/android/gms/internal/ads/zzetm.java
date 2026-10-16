package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzetm implements zzeuc {
    private final zzbyo zza;
    private final zzgdy zzb;
    private final Context zzc;

    public zzetm(zzbyo zzbyoVar, zzgdy zzgdyVar, Context context) {
        this.zza = zzbyoVar;
        this.zzb = zzgdyVar;
        this.zzc = context;
    }

    public static /* synthetic */ zzetn zzc(zzetm zzetmVar) {
        zzbyo zzbyoVar = zzetmVar.zza;
        Context context = zzetmVar.zzc;
        if (!zzbyoVar.zzp(context)) {
            return new zzetn(null, null, null, null, null);
        }
        String zze = zzbyoVar.zze(context);
        String str = zze == null ? "" : zze;
        String zzc = zzbyoVar.zzc(context);
        String str2 = zzc == null ? "" : zzc;
        String zzb = zzbyoVar.zzb(context);
        String str3 = zzb == null ? "" : zzb;
        String str4 = true != zzbyoVar.zzp(context) ? null : "fa";
        return new zzetn(str, str2, str3, str4 == null ? "" : str4, "TIME_OUT".equals(str2) ? (Long) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzaz) : null);
    }

    @Override // com.google.android.gms.internal.ads.zzeuc
    public final int zza() {
        return 34;
    }

    @Override // com.google.android.gms.internal.ads.zzeuc
    public final ListenableFuture zzb() {
        return this.zzb.zzb(new Callable() { // from class: com.google.android.gms.internal.ads.zzetl
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return zzetm.zzc(zzetm.this);
            }
        });
    }
}
