package com.google.android.gms.internal.ads;

import android.graphics.drawable.Drawable;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzdib extends zzbgl {
    private final zzdit zza;
    private IObjectWrapper zzb;

    public zzdib(zzdit zzditVar) {
        this.zza = zzditVar;
    }

    private static float zzb(IObjectWrapper iObjectWrapper) {
        Drawable drawable;
        if (iObjectWrapper == null || (drawable = (Drawable) ObjectWrapper.unwrap(iObjectWrapper)) == null || drawable.getIntrinsicWidth() == -1 || drawable.getIntrinsicHeight() == -1) {
            return 0.0f;
        }
        return drawable.getIntrinsicWidth() / drawable.getIntrinsicHeight();
    }

    @Override // com.google.android.gms.internal.ads.zzbgm
    public final float zze() throws RemoteException {
        zzdit zzditVar = this.zza;
        if (zzditVar.zzb() != 0.0f) {
            return zzditVar.zzb();
        }
        if (zzditVar.zzj() != null) {
            try {
                return zzditVar.zzj().zze();
            } catch (RemoteException e) {
                int i = com.google.android.gms.ads.internal.util.zze.zza;
                com.google.android.gms.ads.internal.util.client.zzo.zzh("Remote exception getting video controller aspect ratio.", e);
                return 0.0f;
            }
        }
        IObjectWrapper iObjectWrapper = this.zzb;
        if (iObjectWrapper != null) {
            return zzb(iObjectWrapper);
        }
        zzbgp zzm = zzditVar.zzm();
        if (zzm == null) {
            return 0.0f;
        }
        float zzd = (zzm.zzd() == -1 || zzm.zzc() == -1) ? 0.0f : zzm.zzd() / zzm.zzc();
        return zzd == 0.0f ? zzb(zzm.zzf()) : zzd;
    }

    @Override // com.google.android.gms.internal.ads.zzbgm
    public final float zzf() throws RemoteException {
        zzdit zzditVar = this.zza;
        if (zzditVar.zzj() != null) {
            return zzditVar.zzj().zzf();
        }
        return 0.0f;
    }

    @Override // com.google.android.gms.internal.ads.zzbgm
    public final float zzg() throws RemoteException {
        zzdit zzditVar = this.zza;
        if (zzditVar.zzj() != null) {
            return zzditVar.zzj().zzg();
        }
        return 0.0f;
    }

    @Override // com.google.android.gms.internal.ads.zzbgm
    public final com.google.android.gms.ads.internal.client.zzed zzh() throws RemoteException {
        return this.zza.zzj();
    }

    @Override // com.google.android.gms.internal.ads.zzbgm
    public final IObjectWrapper zzi() throws RemoteException {
        IObjectWrapper iObjectWrapper = this.zzb;
        if (iObjectWrapper != null) {
            return iObjectWrapper;
        }
        zzbgp zzm = this.zza.zzm();
        if (zzm == null) {
            return null;
        }
        return zzm.zzf();
    }

    @Override // com.google.android.gms.internal.ads.zzbgm
    public final void zzj(IObjectWrapper iObjectWrapper) {
        this.zzb = iObjectWrapper;
    }

    @Override // com.google.android.gms.internal.ads.zzbgm
    public final boolean zzk() throws RemoteException {
        return this.zza.zzaf();
    }

    @Override // com.google.android.gms.internal.ads.zzbgm
    public final boolean zzl() throws RemoteException {
        return this.zza.zzj() != null;
    }

    @Override // com.google.android.gms.internal.ads.zzbgm
    public final void zzm(zzbhx zzbhxVar) {
        zzdit zzditVar = this.zza;
        if (zzditVar.zzj() instanceof zzcgi) {
            ((zzcgi) zzditVar.zzj()).zzv(zzbhxVar);
        }
    }
}
