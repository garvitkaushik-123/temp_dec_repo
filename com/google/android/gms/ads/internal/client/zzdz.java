package com.google.android.gms.ads.internal.client;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.ads.zzayu;
import com.google.android.gms.internal.ads.zzayv;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads-api@@24.5.0 */
/* loaded from: classes4.dex */
public abstract class zzdz extends zzayu implements zzea {
    public zzdz() {
        super("com.google.android.gms.ads.internal.client.IResponseInfo");
    }

    public static zzea zzb(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IResponseInfo");
        return queryLocalInterface instanceof zzea ? (zzea) queryLocalInterface : new zzdy(iBinder);
    }

    @Override // com.google.android.gms.internal.ads.zzayu
    protected final boolean zzde(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        switch (i) {
            case 1:
                String zzg = zzg();
                parcel2.writeNoException();
                parcel2.writeString(zzg);
                return true;
            case 2:
                String zzi = zzi();
                parcel2.writeNoException();
                parcel2.writeString(zzi);
                return true;
            case 3:
                List zzj = zzj();
                parcel2.writeNoException();
                parcel2.writeTypedList(zzj);
                return true;
            case 4:
                zzv zzf = zzf();
                parcel2.writeNoException();
                zzayv.zzf(parcel2, zzf);
                return true;
            case 5:
                Bundle zze = zze();
                parcel2.writeNoException();
                zzayv.zzf(parcel2, zze);
                return true;
            case 6:
                String zzh = zzh();
                parcel2.writeNoException();
                parcel2.writeString(zzh);
                return true;
            default:
                return false;
        }
    }
}
