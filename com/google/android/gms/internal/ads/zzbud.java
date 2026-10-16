package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads-api@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzbud extends zzayt implements zzbuf {
    zzbud(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.query.IUpdateUrlsCallback");
    }

    @Override // com.google.android.gms.internal.ads.zzbuf
    public final void zze(String str) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zzdb(2, zza);
    }

    @Override // com.google.android.gms.internal.ads.zzbuf
    public final void zzf(List list) throws RemoteException {
        Parcel zza = zza();
        zza.writeTypedList(list);
        zzdb(1, zza);
    }
}
