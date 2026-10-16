package com.google.android.gms.ads.internal.client;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.ads.zzayu;
import com.google.android.gms.internal.ads.zzayv;

/* compiled from: com.google.android.gms:play-services-ads-api@@24.5.0 */
/* loaded from: classes4.dex */
public abstract class zzcn extends zzayu implements zzco {
    public zzcn() {
        super("com.google.android.gms.ads.internal.client.IAppEventListener");
    }

    public static zzco zzd(IBinder iBinder) {
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAppEventListener");
        return queryLocalInterface instanceof zzco ? (zzco) queryLocalInterface : new zzcm(iBinder);
    }

    @Override // com.google.android.gms.internal.ads.zzayu
    protected final boolean zzde(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i != 1) {
            return false;
        }
        String readString = parcel.readString();
        String readString2 = parcel.readString();
        zzayv.zzd(parcel);
        zzc(readString, readString2);
        parcel2.writeNoException();
        return true;
    }
}
