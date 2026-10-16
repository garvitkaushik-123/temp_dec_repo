package com.google.android.gms.ads.internal.client;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.ads.zzayu;
import com.google.android.gms.internal.ads.zzayv;

/* compiled from: com.google.android.gms:play-services-ads-api@@24.5.0 */
/* loaded from: classes4.dex */
public abstract class zzec extends zzayu implements zzed {
    public zzec() {
        super("com.google.android.gms.ads.internal.client.IVideoController");
    }

    public static zzed zzb(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IVideoController");
        return queryLocalInterface instanceof zzed ? (zzed) queryLocalInterface : new zzeb(iBinder);
    }

    @Override // com.google.android.gms.internal.ads.zzayu
    protected final boolean zzde(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        zzeg zzeeVar;
        switch (i) {
            case 1:
                zzl();
                parcel2.writeNoException();
                return true;
            case 2:
                zzk();
                parcel2.writeNoException();
                return true;
            case 3:
                boolean zzh = zzayv.zzh(parcel);
                zzayv.zzd(parcel);
                zzj(zzh);
                parcel2.writeNoException();
                return true;
            case 4:
                boolean zzq = zzq();
                parcel2.writeNoException();
                int i3 = zzayv.zza;
                parcel2.writeInt(zzq ? 1 : 0);
                return true;
            case 5:
                int zzh2 = zzh();
                parcel2.writeNoException();
                parcel2.writeInt(zzh2);
                return true;
            case 6:
                float zzg = zzg();
                parcel2.writeNoException();
                parcel2.writeFloat(zzg);
                return true;
            case 7:
                float zzf = zzf();
                parcel2.writeNoException();
                parcel2.writeFloat(zzf);
                return true;
            case 8:
                IBinder readStrongBinder = parcel.readStrongBinder();
                if (readStrongBinder == null) {
                    zzeeVar = null;
                } else {
                    IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IVideoLifecycleCallbacks");
                    zzeeVar = queryLocalInterface instanceof zzeg ? (zzeg) queryLocalInterface : new zzee(readStrongBinder);
                }
                zzayv.zzd(parcel);
                zzm(zzeeVar);
                parcel2.writeNoException();
                return true;
            case 9:
                float zze = zze();
                parcel2.writeNoException();
                parcel2.writeFloat(zze);
                return true;
            case 10:
                boolean zzp = zzp();
                parcel2.writeNoException();
                int i4 = zzayv.zza;
                parcel2.writeInt(zzp ? 1 : 0);
                return true;
            case 11:
                zzeg zzi = zzi();
                parcel2.writeNoException();
                zzayv.zzg(parcel2, zzi);
                return true;
            case 12:
                boolean zzo = zzo();
                parcel2.writeNoException();
                int i5 = zzayv.zza;
                parcel2.writeInt(zzo ? 1 : 0);
                return true;
            case 13:
                zzn();
                parcel2.writeNoException();
                return true;
            default:
                return false;
        }
    }
}
