package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Binder;
import android.os.RemoteException;
import com.google.android.gms.common.internal.BaseGmsClient;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzbbk {
    private ScheduledFuture zza = null;
    private final Runnable zzb = new zzbbg(this);
    private final Object zzc = new Object();
    private zzbbn zzd;
    private Context zze;
    private zzbbq zzf;

    static /* bridge */ /* synthetic */ void zzh(zzbbk zzbbkVar) {
        synchronized (zzbbkVar.zzc) {
            zzbbn zzbbnVar = zzbbkVar.zzd;
            if (zzbbnVar == null) {
                return;
            }
            if (zzbbnVar.isConnected() || zzbbkVar.zzd.isConnecting()) {
                zzbbkVar.zzd.disconnect();
            }
            zzbbkVar.zzd = null;
            zzbbkVar.zzf = null;
            Binder.flushPendingCommands();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzl() {
        synchronized (this.zzc) {
            if (this.zze != null && this.zzd == null) {
                zzbbn zzd = zzd(new zzbbi(this), new zzbbj(this));
                this.zzd = zzd;
                zzd.checkAvailabilityAndConnect();
            }
        }
    }

    public final long zza(zzbbo zzbboVar) {
        synchronized (this.zzc) {
            if (this.zzf == null) {
                return -2L;
            }
            if (this.zzd.zzp()) {
                try {
                    return this.zzf.zze(zzbboVar);
                } catch (RemoteException e) {
                    int i = com.google.android.gms.ads.internal.util.zze.zza;
                    com.google.android.gms.ads.internal.util.client.zzo.zzh("Unable to call into cache service.", e);
                }
            }
            return -2L;
        }
    }

    public final zzbbl zzb(zzbbo zzbboVar) {
        synchronized (this.zzc) {
            if (this.zzf == null) {
                return new zzbbl();
            }
            try {
                if (this.zzd.zzp()) {
                    return this.zzf.zzg(zzbboVar);
                }
                return this.zzf.zzf(zzbboVar);
            } catch (RemoteException e) {
                int i = com.google.android.gms.ads.internal.util.zze.zza;
                com.google.android.gms.ads.internal.util.client.zzo.zzh("Unable to call into cache service.", e);
                return new zzbbl();
            }
        }
    }

    protected final synchronized zzbbn zzd(BaseGmsClient.BaseConnectionCallbacks baseConnectionCallbacks, BaseGmsClient.BaseOnConnectionFailedListener baseOnConnectionFailedListener) {
        return new zzbbn(this.zze, com.google.android.gms.ads.internal.zzv.zzv().zzb(), baseConnectionCallbacks, baseOnConnectionFailedListener);
    }

    public final void zzi(Context context) {
        if (context == null) {
            return;
        }
        synchronized (this.zzc) {
            if (this.zze != null) {
                return;
            }
            this.zze = context.getApplicationContext();
            if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzez)).booleanValue()) {
                zzl();
            } else {
                if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzey)).booleanValue()) {
                    com.google.android.gms.ads.internal.zzv.zzb().zzc(new zzbbh(this));
                }
            }
        }
    }

    public final void zzj() {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzeA)).booleanValue()) {
            synchronized (this.zzc) {
                zzl();
                ScheduledFuture scheduledFuture = this.zza;
                if (scheduledFuture != null) {
                    scheduledFuture.cancel(false);
                }
                this.zza = zzcaf.zzd.schedule(this.zzb, ((Long) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzeB)).longValue(), TimeUnit.MILLISECONDS);
            }
        }
    }
}
