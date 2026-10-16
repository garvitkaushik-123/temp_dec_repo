package com.google.android.gms.internal.nearby;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.nearby.exposurenotification.TemporaryExposureKey;
import java.util.ArrayList;

/* compiled from: com.google.android.gms:play-services-nearby@@18.5.0 */
/* loaded from: classes5.dex */
public abstract class zzdx extends zzb implements zzdy {
    public zzdx() {
        super("com.google.android.gms.nearby.exposurenotification.internal.ITemporaryExposureKeyListCallback");
    }

    @Override // com.google.android.gms.internal.nearby.zzb
    protected final boolean zza(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i != 1) {
            return false;
        }
        Status status = (Status) zzc.zza(parcel, Status.CREATOR);
        ArrayList createTypedArrayList = parcel.createTypedArrayList(TemporaryExposureKey.CREATOR);
        zzc.zzc(parcel);
        zzb(status, createTypedArrayList);
        return true;
    }
}
