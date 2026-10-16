package com.google.android.gms.ads.internal.client;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.ads.zzayu;
import com.google.android.gms.internal.ads.zzayv;
import com.google.android.gms.internal.ads.zzbpq;

/* compiled from: com.google.android.gms:play-services-ads-api@@24.5.0 */
/* loaded from: classes4.dex */
public abstract class zzcx extends zzayu implements zzcy {
    public zzcx() {
        super("com.google.android.gms.ads.internal.client.ILiteSdkInfo");
    }

    public static zzcy asInterface(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.ILiteSdkInfo");
        return queryLocalInterface instanceof zzcy ? (zzcy) queryLocalInterface : new zzcw(iBinder);
    }

    @Override // com.google.android.gms.internal.ads.zzayu
    protected final boolean zzde(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i == 1) {
            zzfd liteSdkVersion = getLiteSdkVersion();
            parcel2.writeNoException();
            zzayv.zzf(parcel2, liteSdkVersion);
        } else {
            if (i != 2) {
                return false;
            }
            zzbpq adapterCreator = getAdapterCreator();
            parcel2.writeNoException();
            zzayv.zzg(parcel2, adapterCreator);
        }
        return true;
    }
}
