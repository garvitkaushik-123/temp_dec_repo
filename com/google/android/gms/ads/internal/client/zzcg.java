package com.google.android.gms.ads.internal.client;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.ads.zzayu;
import com.google.android.gms.internal.ads.zzayv;

/* compiled from: com.google.android.gms:play-services-ads-api@@24.5.0 */
/* loaded from: classes4.dex */
public abstract class zzcg extends zzayu implements zzch {
    public zzcg() {
        super("com.google.android.gms.ads.internal.client.IAdPreloadCallbackV2");
    }

    @Override // com.google.android.gms.internal.ads.zzayu
    protected final boolean zzde(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        zzea zzdyVar;
        if (i == 1) {
            String readString = parcel.readString();
            IBinder readStrongBinder = parcel.readStrongBinder();
            if (readStrongBinder == null) {
                zzdyVar = null;
            } else {
                IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IResponseInfo");
                zzdyVar = queryLocalInterface instanceof zzea ? (zzea) queryLocalInterface : new zzdy(readStrongBinder);
            }
            zzayv.zzd(parcel);
            zzf(readString, zzdyVar);
        } else if (i == 2) {
            String readString2 = parcel.readString();
            zzayv.zzd(parcel);
            zzg(readString2);
        } else {
            if (i != 3) {
                return false;
            }
            String readString3 = parcel.readString();
            zze zzeVar = (zze) zzayv.zza(parcel, zze.CREATOR);
            zzayv.zzd(parcel);
            zze(readString3, zzeVar);
        }
        parcel2.writeNoException();
        return true;
    }
}
