package com.google.android.gms.internal.ads;

import android.content.Intent;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads-api@@24.5.0 */
/* loaded from: classes5.dex */
public abstract class zzbti extends zzayu implements zzbtj {
    public zzbti() {
        super("com.google.android.gms.ads.internal.offline.IOfflineUtils");
    }

    public static zzbtj zzb(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.offline.IOfflineUtils");
        return queryLocalInterface instanceof zzbtj ? (zzbtj) queryLocalInterface : new zzbth(iBinder);
    }

    @Override // com.google.android.gms.internal.ads.zzayu
    protected final boolean zzde(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        switch (i) {
            case 1:
                Intent intent = (Intent) zzayv.zza(parcel, Intent.CREATOR);
                zzayv.zzd(parcel);
                zze(intent);
                break;
            case 2:
                IObjectWrapper asInterface = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                String readString = parcel.readString();
                String readString2 = parcel.readString();
                zzayv.zzd(parcel);
                zzi(asInterface, readString, readString2);
                break;
            case 3:
                zzh();
                break;
            case 4:
                IObjectWrapper asInterface2 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                zzayv.zzd(parcel);
                zzg(asInterface2);
                break;
            case 5:
                String[] createStringArray = parcel.createStringArray();
                int[] createIntArray = parcel.createIntArray();
                IObjectWrapper asInterface3 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                zzayv.zzd(parcel);
                zzf(createStringArray, createIntArray, asInterface3);
                break;
            case 6:
                IObjectWrapper asInterface4 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                com.google.android.gms.ads.internal.offline.buffering.zza zzaVar = (com.google.android.gms.ads.internal.offline.buffering.zza) zzayv.zza(parcel, com.google.android.gms.ads.internal.offline.buffering.zza.CREATOR);
                zzayv.zzd(parcel);
                zzj(asInterface4, zzaVar);
                break;
            default:
                return false;
        }
        parcel2.writeNoException();
        return true;
    }
}
