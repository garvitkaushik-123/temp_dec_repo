package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public abstract class zzfqk extends zzayu implements zzfql {
    public zzfqk() {
        super("com.google.android.gms.gass.internal.clearcut.IGassClearcut");
    }

    @Override // com.google.android.gms.internal.ads.zzayu
    protected final boolean zzde(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        switch (i) {
            case 2:
                IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                parcel.readString();
                zzayv.zzd(parcel);
                break;
            case 3:
                break;
            case 4:
                parcel.createIntArray();
                zzayv.zzd(parcel);
                break;
            case 5:
                parcel.createByteArray();
                zzayv.zzd(parcel);
                break;
            case 6:
                parcel.readInt();
                zzayv.zzd(parcel);
                break;
            case 7:
                parcel.readInt();
                zzayv.zzd(parcel);
                break;
            case 8:
                IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                parcel.readString();
                parcel.readString();
                zzayv.zzd(parcel);
                break;
            default:
                return false;
        }
        parcel2.writeNoException();
        return true;
    }
}
