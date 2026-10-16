package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads-api@@24.5.0 */
/* loaded from: classes5.dex */
public abstract class zzbpp extends zzayu implements zzbpq {
    public zzbpp() {
        super("com.google.android.gms.ads.internal.mediation.client.IAdapterCreator");
    }

    public static zzbpq zzf(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.IAdapterCreator");
        return queryLocalInterface instanceof zzbpq ? (zzbpq) queryLocalInterface : new zzbpo(iBinder);
    }

    @Override // com.google.android.gms.internal.ads.zzayu
    protected final boolean zzde(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i == 1) {
            String readString = parcel.readString();
            zzayv.zzd(parcel);
            zzbpt zzb = zzb(readString);
            parcel2.writeNoException();
            zzayv.zzg(parcel2, zzb);
        } else if (i == 2) {
            String readString2 = parcel.readString();
            zzayv.zzd(parcel);
            boolean zze = zze(readString2);
            parcel2.writeNoException();
            parcel2.writeInt(zze ? 1 : 0);
        } else if (i == 3) {
            String readString3 = parcel.readString();
            zzayv.zzd(parcel);
            zzbrp zzc = zzc(readString3);
            parcel2.writeNoException();
            zzayv.zzg(parcel2, zzc);
        } else {
            if (i != 4) {
                return false;
            }
            String readString4 = parcel.readString();
            zzayv.zzd(parcel);
            boolean zzd = zzd(readString4);
            parcel2.writeNoException();
            parcel2.writeInt(zzd ? 1 : 0);
        }
        return true;
    }
}
