package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads-api@@24.5.0 */
/* loaded from: classes5.dex */
public abstract class zzbgl extends zzayu implements zzbgm {
    public zzbgl() {
        super("com.google.android.gms.ads.internal.formats.client.IMediaContent");
    }

    @Override // com.google.android.gms.internal.ads.zzayu
    protected final boolean zzde(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        zzbhx zzbhxVar;
        switch (i) {
            case 2:
                float zze = zze();
                parcel2.writeNoException();
                parcel2.writeFloat(zze);
                return true;
            case 3:
                IObjectWrapper asInterface = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                zzayv.zzd(parcel);
                zzj(asInterface);
                parcel2.writeNoException();
                return true;
            case 4:
                IObjectWrapper zzi = zzi();
                parcel2.writeNoException();
                zzayv.zzg(parcel2, zzi);
                return true;
            case 5:
                float zzg = zzg();
                parcel2.writeNoException();
                parcel2.writeFloat(zzg);
                return true;
            case 6:
                float zzf = zzf();
                parcel2.writeNoException();
                parcel2.writeFloat(zzf);
                return true;
            case 7:
                com.google.android.gms.ads.internal.client.zzed zzh = zzh();
                parcel2.writeNoException();
                zzayv.zzg(parcel2, zzh);
                return true;
            case 8:
                boolean zzl = zzl();
                parcel2.writeNoException();
                int i3 = zzayv.zza;
                parcel2.writeInt(zzl ? 1 : 0);
                return true;
            case 9:
                IBinder readStrongBinder = parcel.readStrongBinder();
                if (readStrongBinder == null) {
                    zzbhxVar = null;
                } else {
                    IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.IOnMediaContentChangedListener");
                    zzbhxVar = queryLocalInterface instanceof zzbhx ? (zzbhx) queryLocalInterface : new zzbhx(readStrongBinder);
                }
                zzayv.zzd(parcel);
                zzm(zzbhxVar);
                parcel2.writeNoException();
                return true;
            case 10:
                boolean zzk = zzk();
                parcel2.writeNoException();
                int i4 = zzayv.zza;
                parcel2.writeInt(zzk ? 1 : 0);
                return true;
            default:
                return false;
        }
    }
}
