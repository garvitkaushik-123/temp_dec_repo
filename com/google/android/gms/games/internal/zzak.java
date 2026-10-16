package com.google.android.gms.games.internal;

import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-games-v2@@21.0.0 */
/* loaded from: classes4.dex */
public abstract class zzak extends com.google.android.gms.internal.games_v2.zzb implements zzal {
    public zzak() {
        super("com.google.android.gms.games.internal.IGamesClient");
    }

    @Override // com.google.android.gms.internal.games_v2.zzb
    protected final boolean zza(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i != 1001) {
            return false;
        }
        com.google.android.gms.internal.games_v2.zzaf zzb = zzb();
        parcel2.writeNoException();
        int i3 = com.google.android.gms.internal.games_v2.zzc.zza;
        parcel2.writeInt(1);
        zzb.writeToParcel(parcel2, 1);
        return true;
    }
}
