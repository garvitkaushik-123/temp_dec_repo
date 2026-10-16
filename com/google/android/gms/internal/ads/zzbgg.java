package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads-api@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzbgg extends zzayt implements zzbgi {
    zzbgg(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.formats.client.IAttributionInfo");
    }

    @Override // com.google.android.gms.internal.ads.zzbgi
    public final String zzg() throws RemoteException {
        Parcel zzda = zzda(2, zza());
        String readString = zzda.readString();
        zzda.recycle();
        return readString;
    }

    @Override // com.google.android.gms.internal.ads.zzbgi
    public final List zzh() throws RemoteException {
        Parcel zzda = zzda(3, zza());
        ArrayList zzb = zzayv.zzb(zzda);
        zzda.recycle();
        return zzb;
    }
}
