package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzdxd implements zzhgr {
    private final zzhha zza;
    private final zzhha zzb;
    private final zzhha zzc;
    private final zzhha zzd;

    private zzdxd(zzhha zzhhaVar, zzhha zzhhaVar2, zzhha zzhhaVar3, zzhha zzhhaVar4, zzhha zzhhaVar5) {
        this.zza = zzhhaVar;
        this.zzb = zzhhaVar2;
        this.zzc = zzhhaVar3;
        this.zzd = zzhhaVar4;
    }

    public static zzdxd zza(zzhha zzhhaVar, zzhha zzhhaVar2, zzhha zzhhaVar3, zzhha zzhhaVar4, zzhha zzhhaVar5) {
        return new zzdxd(zzhhaVar, zzhhaVar2, zzhhaVar3, zzhhaVar4, zzhhaVar5);
    }

    /* JADX WARN: Code restructure failed: missing block: B:4:0x0056, code lost:
    
        if (java.lang.Integer.toString(r6).equals(com.google.android.gms.ads.nonagon.signalgeneration.zzaa.zzb(com.google.android.gms.ads.nonagon.signalgeneration.zzaa.zzc(r2.zzd))) != false) goto L6;
     */
    @Override // com.google.android.gms.internal.ads.zzhhg, com.google.android.gms.internal.ads.zzhhf
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final /* synthetic */ Object zzb() {
        ListenableFuture zzb;
        final zzavu zzavuVar = (zzavu) this.zza.zzb();
        final Context zza = ((zzchl) this.zzb).zza();
        zzfcw zzc = ((zzcvp) this.zzc).zzc();
        long longValue = ((Long) this.zzd.zzb()).longValue();
        zzgdy zzc2 = zzffu.zzc();
        int intValue = ((Integer) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzcX)).intValue();
        if (intValue != -1) {
        }
        if (com.google.android.gms.ads.internal.zzv.zzD().currentTimeMillis() - longValue < ((Integer) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzcZ)).intValue()) {
            zzb = zzc2.zzb(new Callable() { // from class: com.google.android.gms.internal.ads.zzdww
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return zzavu.this.zzc().zzg(zza);
                }
            });
            zzhgz.zzb(zzb);
            return zzb;
        }
        zzb = zzc2.zzb(new Callable() { // from class: com.google.android.gms.internal.ads.zzdwx
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return zzavu.this.zzc().zzf(zza);
            }
        });
        zzhgz.zzb(zzb);
        return zzb;
    }
}
