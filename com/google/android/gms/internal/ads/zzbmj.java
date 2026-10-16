package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import java.util.ArrayList;

/* compiled from: com.google.android.gms:play-services-ads-api@@24.5.0 */
/* loaded from: classes5.dex */
public abstract class zzbmj extends zzayu implements zzbmk {
    public zzbmj() {
        super("com.google.android.gms.ads.internal.initialization.IInitializationCallback");
    }

    public static zzbmk zzc(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.initialization.IInitializationCallback");
        return queryLocalInterface instanceof zzbmk ? (zzbmk) queryLocalInterface : new zzbmi(iBinder);
    }

    @Override // com.google.android.gms.internal.ads.zzayu
    protected final boolean zzde(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i != 1) {
            return false;
        }
        ArrayList createTypedArrayList = parcel.createTypedArrayList(zzbmd.CREATOR);
        zzayv.zzd(parcel);
        zzb(createTypedArrayList);
        parcel2.writeNoException();
        return true;
    }
}
