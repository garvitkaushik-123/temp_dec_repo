package com.google.android.gms.ads.internal.client;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.ads.zzayu;

/* compiled from: com.google.android.gms:play-services-ads-api@@24.5.0 */
/* loaded from: classes4.dex */
public abstract class zzdi extends zzayu implements zzdj {
    public zzdi() {
        super("com.google.android.gms.ads.internal.client.IMuteThisAdReason");
    }

    public static zzdj zzb(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IMuteThisAdReason");
        return queryLocalInterface instanceof zzdj ? (zzdj) queryLocalInterface : new zzdh(iBinder);
    }

    @Override // com.google.android.gms.internal.ads.zzayu
    protected final boolean zzde(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i == 1) {
            String zze = zze();
            parcel2.writeNoException();
            parcel2.writeString(zze);
        } else {
            if (i != 2) {
                return false;
            }
            String zzf = zzf();
            parcel2.writeNoException();
            parcel2.writeString(zzf);
        }
        return true;
    }
}
