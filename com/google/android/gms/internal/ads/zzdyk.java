package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzdyk extends zzdyi {
    private final Context zzg;
    private final Executor zzh;

    zzdyk(Context context, Executor executor) {
        this.zzg = context;
        this.zzh = executor;
        this.zzf = new zzbuv(context, com.google.android.gms.ads.internal.zzv.zzv().zzb(), this, this);
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks
    public final void onConnected(Bundle bundle) {
        synchronized (this.zzb) {
            if (!this.zzd) {
                this.zzd = true;
                try {
                    this.zzf.zzp().zzf(this.zze, ((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zznp)).booleanValue() ? new zzdyh(this.zza, this.zze) : new zzdyg(this));
                } catch (RemoteException | IllegalArgumentException unused) {
                    this.zza.zzd(new zzdyx(1));
                } catch (Throwable th) {
                    com.google.android.gms.ads.internal.zzv.zzp().zzw(th, "RemoteSignalsClientTask.onConnected");
                    this.zza.zzd(new zzdyx(1));
                }
            }
        }
    }

    public final ListenableFuture zza(zzbvq zzbvqVar) {
        synchronized (this.zzb) {
            if (this.zzc) {
                return this.zza;
            }
            this.zzc = true;
            this.zze = zzbvqVar;
            this.zzf.checkAvailabilityAndConnect();
            zzcak zzcakVar = this.zza;
            zzcakVar.addListener(new Runnable() { // from class: com.google.android.gms.internal.ads.zzdyj
                @Override // java.lang.Runnable
                public final void run() {
                    zzdyk.this.zzb();
                }
            }, zzcaf.zzg);
            zzc(this.zzg, zzcakVar, this.zzh);
            return zzcakVar;
        }
    }
}
