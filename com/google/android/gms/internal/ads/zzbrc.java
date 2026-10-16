package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads-api@@24.5.0 */
/* loaded from: classes5.dex */
public abstract class zzbrc extends zzayu implements zzbrd {
    public zzbrc() {
        super("com.google.android.gms.ads.internal.mediation.client.rtb.IBannerCallback");
    }

    @Override // com.google.android.gms.internal.ads.zzayu
    protected final boolean zzde(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i == 1) {
            IObjectWrapper asInterface = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
            zzayv.zzd(parcel);
            zzg(asInterface);
        } else if (i == 2) {
            String readString = parcel.readString();
            zzayv.zzd(parcel);
            zze(readString);
        } else if (i == 3) {
            com.google.android.gms.ads.internal.client.zze zzeVar = (com.google.android.gms.ads.internal.client.zze) zzayv.zza(parcel, com.google.android.gms.ads.internal.client.zze.CREATOR);
            zzayv.zzd(parcel);
            zzf(zzeVar);
        } else {
            if (i != 4) {
                return false;
            }
            zzbpz zzb = zzbpy.zzb(parcel.readStrongBinder());
            zzayv.zzd(parcel);
            zzh(zzb);
        }
        parcel2.writeNoException();
        return true;
    }
}
