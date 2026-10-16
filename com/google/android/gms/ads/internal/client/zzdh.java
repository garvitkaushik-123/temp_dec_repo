package com.google.android.gms.ads.internal.client;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.ads.zzayt;

/* compiled from: com.google.android.gms:play-services-ads-api@@24.5.0 */
/* loaded from: classes4.dex */
public final class zzdh extends zzayt implements zzdj {
    zzdh(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.IMuteThisAdReason");
    }

    @Override // com.google.android.gms.ads.internal.client.zzdj
    public final String zze() throws RemoteException {
        Parcel zzda = zzda(1, zza());
        String readString = zzda.readString();
        zzda.recycle();
        return readString;
    }

    @Override // com.google.android.gms.ads.internal.client.zzdj
    public final String zzf() throws RemoteException {
        Parcel zzda = zzda(2, zza());
        String readString = zzda.readString();
        zzda.recycle();
        return readString;
    }
}
