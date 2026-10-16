package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.google.common.util.concurrent.ListenableFuture;
import java.io.IOException;
import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
final class zzbbw implements BaseGmsClient.BaseConnectionCallbacks {
    public static final /* synthetic */ int zzd = 0;
    final /* synthetic */ zzbbo zza;
    final /* synthetic */ zzcak zzb;
    final /* synthetic */ zzbby zzc;

    zzbbw(zzbby zzbbyVar, zzbbo zzbboVar, zzcak zzcakVar) {
        this.zza = zzbboVar;
        this.zzb = zzcakVar;
        Objects.requireNonNull(zzbbyVar);
        this.zzc = zzbbyVar;
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks
    public final void onConnectionSuspended(int i) {
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks
    public final void onConnected(Bundle bundle) {
        Object obj;
        boolean z;
        final zzbbn zzbbnVar;
        zzbby zzbbyVar = this.zzc;
        obj = zzbbyVar.zzd;
        synchronized (obj) {
            z = zzbbyVar.zzb;
            if (z) {
                return;
            }
            zzbbyVar.zzb = true;
            zzbbnVar = zzbbyVar.zza;
            if (zzbbnVar == null) {
                return;
            }
            zzgdy zzgdyVar = zzcaf.zza;
            final zzbbo zzbboVar = this.zza;
            final zzcak zzcakVar = this.zzb;
            final ListenableFuture zza = zzgdyVar.zza(new Runnable() { // from class: com.google.android.gms.internal.ads.zzbbt
                @Override // java.lang.Runnable
                public final void run() {
                    zzbbw zzbbwVar = zzbbw.this;
                    zzbbn zzbbnVar2 = zzbbnVar;
                    zzcak zzcakVar2 = zzcakVar;
                    try {
                        zzbbq zzq = zzbbnVar2.zzq();
                        boolean zzp = zzbbnVar2.zzp();
                        zzbbo zzbboVar2 = zzbboVar;
                        zzbbl zzg = zzp ? zzq.zzg(zzbboVar2) : zzq.zzf(zzbboVar2);
                        if (!zzg.zze()) {
                            zzcakVar2.zzd(new RuntimeException("No entry contents."));
                            zzbby.zze(zzbbwVar.zzc);
                            return;
                        }
                        zzbbv zzbbvVar = new zzbbv(zzbbwVar, zzg.zzc(), 1);
                        int read = zzbbvVar.read();
                        if (read == -1) {
                            throw new IOException("Unable to read from cache.");
                        }
                        zzbbvVar.unread(read);
                        zzcakVar2.zzc(zzbca.zzb(zzbbvVar, zzg.zzd(), zzg.zzg(), zzg.zza(), zzg.zzf()));
                    } catch (RemoteException | IOException e) {
                        int i = com.google.android.gms.ads.internal.util.zze.zza;
                        com.google.android.gms.ads.internal.util.client.zzo.zzh("Unable to obtain a cache service instance.", e);
                        zzcakVar2.zzd(e);
                        zzbby.zze(zzbbwVar.zzc);
                    }
                }
            });
            zzcakVar.addListener(new Runnable() { // from class: com.google.android.gms.internal.ads.zzbbu
                @Override // java.lang.Runnable
                public final void run() {
                    int i = zzbbw.zzd;
                    if (zzcak.this.isCancelled()) {
                        zza.cancel(true);
                    }
                }
            }, zzcaf.zzg);
        }
    }
}
