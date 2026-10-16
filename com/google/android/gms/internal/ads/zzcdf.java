package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzcdf extends com.google.android.gms.ads.internal.util.zzb {
    final zzccb zza;
    final zzcdn zzb;
    private final String zzc;
    private final String[] zzd;

    zzcdf(zzccb zzccbVar, zzcdn zzcdnVar, String str, String[] strArr) {
        this.zza = zzccbVar;
        this.zzb = zzcdnVar;
        this.zzc = str;
        this.zzd = strArr;
        com.google.android.gms.ads.internal.zzv.zzA().zzb(this);
    }

    @Override // com.google.android.gms.ads.internal.util.zzb
    public final void zza() {
        try {
            this.zzb.zzu(this.zzc, this.zzd);
        } finally {
            com.google.android.gms.ads.internal.util.zzs.zza.post(new zzcde(this));
        }
    }

    @Override // com.google.android.gms.ads.internal.util.zzb
    public final ListenableFuture zzb() {
        return (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzci)).booleanValue() && (this.zzb instanceof zzcdw)) ? zzcaf.zzf.zzb(new Callable() { // from class: com.google.android.gms.internal.ads.zzcdd
            @Override // java.util.concurrent.Callable
            public final Object call() {
                Boolean valueOf;
                valueOf = Boolean.valueOf(r0.zzb.zzw(r0.zzc, r0.zzd, zzcdf.this));
                return valueOf;
            }
        }) : super.zzb();
    }

    public final String zze() {
        return this.zzc;
    }
}
