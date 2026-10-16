package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzefe extends zzbwm implements zzcxi {
    private zzbwn zza;
    private zzcxh zzb;
    private zzdeo zzc;

    @Override // com.google.android.gms.internal.ads.zzcxi
    public final synchronized void zza(zzcxh zzcxhVar) {
        this.zzb = zzcxhVar;
    }

    public final synchronized void zzc(zzbwn zzbwnVar) {
        this.zza = zzbwnVar;
    }

    public final synchronized void zzd(zzdeo zzdeoVar) {
        this.zzc = zzdeoVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbwn
    public final synchronized void zze(IObjectWrapper iObjectWrapper) throws RemoteException {
        zzbwn zzbwnVar = this.zza;
        if (zzbwnVar != null) {
            ((zzeij) zzbwnVar).zzb.onAdClicked();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbwn
    public final synchronized void zzf(IObjectWrapper iObjectWrapper) throws RemoteException {
        zzbwn zzbwnVar = this.zza;
        if (zzbwnVar != null) {
            zzbwnVar.zzf(iObjectWrapper);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbwn
    public final synchronized void zzg(IObjectWrapper iObjectWrapper, int i) throws RemoteException {
        zzcxh zzcxhVar = this.zzb;
        if (zzcxhVar != null) {
            zzcxhVar.zza(i);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbwn
    public final synchronized void zzh(IObjectWrapper iObjectWrapper) throws RemoteException {
        zzbwn zzbwnVar = this.zza;
        if (zzbwnVar != null) {
            ((zzeij) zzbwnVar).zzc.zzb();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbwn
    public final synchronized void zzi(IObjectWrapper iObjectWrapper) throws RemoteException {
        zzcxh zzcxhVar = this.zzb;
        if (zzcxhVar != null) {
            zzcxhVar.zzd();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbwn
    public final synchronized void zzj(IObjectWrapper iObjectWrapper) throws RemoteException {
        zzbwn zzbwnVar = this.zza;
        if (zzbwnVar != null) {
            ((zzeij) zzbwnVar).zza.zzdt();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbwn
    public final synchronized void zzk(IObjectWrapper iObjectWrapper, int i) throws RemoteException {
        zzdeo zzdeoVar = this.zzc;
        if (zzdeoVar != null) {
            zzedp zzedpVar = ((zzeih) zzdeoVar).zzc;
            int i2 = com.google.android.gms.ads.internal.util.zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zzj("Fail to initialize adapter ".concat(String.valueOf(zzedpVar.zza)));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbwn
    public final synchronized void zzl(IObjectWrapper iObjectWrapper) throws RemoteException {
        Executor executor;
        zzdeo zzdeoVar = this.zzc;
        if (zzdeoVar != null) {
            executor = ((zzeih) zzdeoVar).zzd.zzb;
            final zzedp zzedpVar = ((zzeih) zzdeoVar).zzc;
            final zzfca zzfcaVar = ((zzeih) zzdeoVar).zzb;
            final zzfcn zzfcnVar = ((zzeih) zzdeoVar).zza;
            final zzeih zzeihVar = (zzeih) zzdeoVar;
            executor.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzeig
                @Override // java.lang.Runnable
                public final void run() {
                    zzeik zzeikVar = zzeih.this.zzd;
                    zzeik.zze(zzfcnVar, zzfcaVar, zzedpVar);
                }
            });
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbwn
    public final synchronized void zzm(IObjectWrapper iObjectWrapper, zzbwo zzbwoVar) throws RemoteException {
        zzbwn zzbwnVar = this.zza;
        if (zzbwnVar != null) {
            ((zzeij) zzbwnVar).zzd.zza(zzbwoVar);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbwn
    public final synchronized void zzn(IObjectWrapper iObjectWrapper) throws RemoteException {
        zzbwn zzbwnVar = this.zza;
        if (zzbwnVar != null) {
            ((zzeij) zzbwnVar).zzd.zza(null);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbwn
    public final synchronized void zzo(IObjectWrapper iObjectWrapper) throws RemoteException {
        zzbwn zzbwnVar = this.zza;
        if (zzbwnVar != null) {
            ((zzeij) zzbwnVar).zzc.zze();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbwn
    public final synchronized void zzp(IObjectWrapper iObjectWrapper) throws RemoteException {
        zzbwn zzbwnVar = this.zza;
        if (zzbwnVar != null) {
            ((zzeij) zzbwnVar).zzd.zzc();
        }
    }
}
