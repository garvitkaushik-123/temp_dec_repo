package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import javax.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzdis extends com.google.android.gms.ads.internal.client.zzec {
    private final Object zza = new Object();

    @Nullable
    private final com.google.android.gms.ads.internal.client.zzed zzb;

    @Nullable
    private final zzbqf zzc;

    public zzdis(@Nullable com.google.android.gms.ads.internal.client.zzed zzedVar, @Nullable zzbqf zzbqfVar) {
        this.zzb = zzedVar;
        this.zzc = zzbqfVar;
    }

    @Override // com.google.android.gms.ads.internal.client.zzed
    public final float zze() throws RemoteException {
        throw new RemoteException();
    }

    @Override // com.google.android.gms.ads.internal.client.zzed
    public final float zzf() throws RemoteException {
        zzbqf zzbqfVar = this.zzc;
        if (zzbqfVar != null) {
            return zzbqfVar.zzg();
        }
        return 0.0f;
    }

    @Override // com.google.android.gms.ads.internal.client.zzed
    public final float zzg() throws RemoteException {
        zzbqf zzbqfVar = this.zzc;
        if (zzbqfVar != null) {
            return zzbqfVar.zzh();
        }
        return 0.0f;
    }

    @Override // com.google.android.gms.ads.internal.client.zzed
    public final int zzh() throws RemoteException {
        throw new RemoteException();
    }

    @Override // com.google.android.gms.ads.internal.client.zzed
    @Nullable
    public final com.google.android.gms.ads.internal.client.zzeg zzi() throws RemoteException {
        synchronized (this.zza) {
            com.google.android.gms.ads.internal.client.zzed zzedVar = this.zzb;
            if (zzedVar == null) {
                return null;
            }
            return zzedVar.zzi();
        }
    }

    @Override // com.google.android.gms.ads.internal.client.zzed
    public final void zzj(boolean z) throws RemoteException {
        throw new RemoteException();
    }

    @Override // com.google.android.gms.ads.internal.client.zzed
    public final void zzk() throws RemoteException {
        throw new RemoteException();
    }

    @Override // com.google.android.gms.ads.internal.client.zzed
    public final void zzl() throws RemoteException {
        throw new RemoteException();
    }

    @Override // com.google.android.gms.ads.internal.client.zzed
    public final void zzm(@Nullable com.google.android.gms.ads.internal.client.zzeg zzegVar) throws RemoteException {
        synchronized (this.zza) {
            com.google.android.gms.ads.internal.client.zzed zzedVar = this.zzb;
            if (zzedVar != null) {
                zzedVar.zzm(zzegVar);
            }
        }
    }

    @Override // com.google.android.gms.ads.internal.client.zzed
    public final void zzn() throws RemoteException {
        throw new RemoteException();
    }

    @Override // com.google.android.gms.ads.internal.client.zzed
    public final boolean zzo() throws RemoteException {
        throw new RemoteException();
    }

    @Override // com.google.android.gms.ads.internal.client.zzed
    public final boolean zzp() throws RemoteException {
        throw new RemoteException();
    }

    @Override // com.google.android.gms.ads.internal.client.zzed
    public final boolean zzq() throws RemoteException {
        throw new RemoteException();
    }
}
