package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads-api@@24.5.0 */
/* loaded from: classes5.dex */
public abstract class zzbgh extends zzayu implements zzbgi {
    public zzbgh() {
        super("com.google.android.gms.ads.internal.formats.client.IAttributionInfo");
    }

    public static zzbgi zzj(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.IAttributionInfo");
        return queryLocalInterface instanceof zzbgi ? (zzbgi) queryLocalInterface : new zzbgg(iBinder);
    }

    @Override // com.google.android.gms.internal.ads.zzayu
    protected final boolean zzde(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i == 2) {
            String zzg = zzg();
            parcel2.writeNoException();
            parcel2.writeString(zzg);
            return true;
        }
        if (i != 3) {
            return false;
        }
        List zzh = zzh();
        parcel2.writeNoException();
        parcel2.writeList(zzh);
        return true;
    }
}
