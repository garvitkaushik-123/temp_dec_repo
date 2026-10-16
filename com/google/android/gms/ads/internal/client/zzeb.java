package com.google.android.gms.ads.internal.client;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.ads.zzayt;
import com.google.android.gms.internal.ads.zzayv;

/* compiled from: com.google.android.gms:play-services-ads-api@@24.5.0 */
/* loaded from: classes4.dex */
public final class zzeb extends zzayt implements zzed {
    zzeb(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.IVideoController");
    }

    @Override // com.google.android.gms.ads.internal.client.zzed
    public final float zze() throws RemoteException {
        throw null;
    }

    @Override // com.google.android.gms.ads.internal.client.zzed
    public final float zzf() throws RemoteException {
        throw null;
    }

    @Override // com.google.android.gms.ads.internal.client.zzed
    public final float zzg() throws RemoteException {
        throw null;
    }

    @Override // com.google.android.gms.ads.internal.client.zzed
    public final int zzh() throws RemoteException {
        Parcel zzda = zzda(5, zza());
        int readInt = zzda.readInt();
        zzda.recycle();
        return readInt;
    }

    @Override // com.google.android.gms.ads.internal.client.zzed
    public final zzeg zzi() throws RemoteException {
        zzeg zzeeVar;
        Parcel zzda = zzda(11, zza());
        IBinder readStrongBinder = zzda.readStrongBinder();
        if (readStrongBinder == null) {
            zzeeVar = null;
        } else {
            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IVideoLifecycleCallbacks");
            zzeeVar = queryLocalInterface instanceof zzeg ? (zzeg) queryLocalInterface : new zzee(readStrongBinder);
        }
        zzda.recycle();
        return zzeeVar;
    }

    @Override // com.google.android.gms.ads.internal.client.zzed
    public final void zzj(boolean z) throws RemoteException {
        Parcel zza = zza();
        int i = zzayv.zza;
        zza.writeInt(z ? 1 : 0);
        zzdb(3, zza);
    }

    @Override // com.google.android.gms.ads.internal.client.zzed
    public final void zzk() throws RemoteException {
        zzdb(2, zza());
    }

    @Override // com.google.android.gms.ads.internal.client.zzed
    public final void zzl() throws RemoteException {
        zzdb(1, zza());
    }

    @Override // com.google.android.gms.ads.internal.client.zzed
    public final void zzm(zzeg zzegVar) throws RemoteException {
        Parcel zza = zza();
        zzayv.zzg(zza, zzegVar);
        zzdb(8, zza);
    }

    @Override // com.google.android.gms.ads.internal.client.zzed
    public final void zzn() throws RemoteException {
        zzdb(13, zza());
    }

    @Override // com.google.android.gms.ads.internal.client.zzed
    public final boolean zzo() throws RemoteException {
        Parcel zzda = zzda(12, zza());
        boolean zzh = zzayv.zzh(zzda);
        zzda.recycle();
        return zzh;
    }

    @Override // com.google.android.gms.ads.internal.client.zzed
    public final boolean zzp() throws RemoteException {
        Parcel zzda = zzda(10, zza());
        boolean zzh = zzayv.zzh(zzda);
        zzda.recycle();
        return zzh;
    }

    @Override // com.google.android.gms.ads.internal.client.zzed
    public final boolean zzq() throws RemoteException {
        Parcel zzda = zzda(4, zza());
        boolean zzh = zzayv.zzh(zzda);
        zzda.recycle();
        return zzh;
    }
}
