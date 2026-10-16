package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads-api@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzbmi extends zzayt implements zzbmk {
    zzbmi(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.initialization.IInitializationCallback");
    }

    @Override // com.google.android.gms.internal.ads.zzbmk
    public final void zzb(List list) throws RemoteException {
        Parcel zza = zza();
        zza.writeTypedList(list);
        zzdb(1, zza);
    }
}
