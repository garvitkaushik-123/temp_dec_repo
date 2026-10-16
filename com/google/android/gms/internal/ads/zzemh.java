package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzemh implements zzeuc {
    private final zzgdy zza;
    private final zzfcw zzb;
    private final int zzc;

    zzemh(zzgdy zzgdyVar, zzfcw zzfcwVar, zzfdl zzfdlVar, int i) {
        this.zza = zzgdyVar;
        this.zzb = zzfcwVar;
        this.zzc = i;
    }

    public static /* synthetic */ zzemi zzc(zzemh zzemhVar) {
        List asList;
        String str = null;
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzhl)).booleanValue()) {
            zzfcw zzfcwVar = zzemhVar.zzb;
            if (zzemhVar.zzc != 2) {
                String zzc = com.google.android.gms.ads.nonagon.signalgeneration.zzaa.zzc(zzfcwVar.zzd);
                if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzhn)).booleanValue()) {
                    asList = Arrays.asList(((String) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzho)).split(","));
                } else {
                    asList = Arrays.asList(((String) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzhm)).split(","));
                }
                if (asList.contains(com.google.android.gms.ads.nonagon.signalgeneration.zzaa.zzb(zzc))) {
                    str = zzfdl.zza();
                }
            }
        }
        return new zzemi(str);
    }

    @Override // com.google.android.gms.internal.ads.zzeuc
    public final int zza() {
        return 5;
    }

    @Override // com.google.android.gms.internal.ads.zzeuc
    public final ListenableFuture zzb() {
        return this.zza.zzb(new Callable() { // from class: com.google.android.gms.internal.ads.zzemg
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return zzemh.zzc(zzemh.this);
            }
        });
    }
}
