package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import java.util.Objects;
import java.util.concurrent.ExecutorService;

/* compiled from: com.google.android.gms:play-services-ads-api@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzbcg {
    final /* synthetic */ zzbci zza;
    private final byte[] zzb;
    private int zzc;

    /* synthetic */ zzbcg(zzbci zzbciVar, byte[] bArr, zzbch zzbchVar) {
        Objects.requireNonNull(zzbciVar);
        this.zza = zzbciVar;
        this.zzb = bArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final synchronized void zzd() {
        try {
            zzbci zzbciVar = this.zza;
            if (zzbciVar.zzb) {
                zzbciVar.zza.zzj(this.zzb);
                zzbciVar.zza.zzi(0);
                zzbciVar.zza.zzg(this.zzc);
                zzbciVar.zza.zzh(null);
                zzbciVar.zza.zzf();
            }
        } catch (RemoteException e) {
            com.google.android.gms.ads.internal.util.client.zzo.zzf("Clearcut log failed", e);
        }
    }

    public final zzbcg zza(int i) {
        this.zzc = i;
        return this;
    }

    public final synchronized void zzc() {
        ExecutorService executorService;
        executorService = this.zza.zzc;
        executorService.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzbcf
            @Override // java.lang.Runnable
            public final void run() {
                zzbcg.this.zzd();
            }
        });
    }
}
