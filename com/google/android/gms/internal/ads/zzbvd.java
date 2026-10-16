package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public abstract class zzbvd extends zzayu implements zzbve {
    public zzbvd() {
        super("com.google.android.gms.ads.internal.request.IAdRequestService");
    }

    @Override // com.google.android.gms.internal.ads.zzayu
    protected final boolean zzde(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        zzbvi zzbviVar = null;
        zzbvj zzbvjVar = null;
        zzbvi zzbviVar2 = null;
        zzbvi zzbviVar3 = null;
        zzbvi zzbviVar4 = null;
        switch (i) {
            case 1:
                zzayv.zzd(parcel);
                parcel2.writeNoException();
                zzayv.zzf(parcel2, null);
                return true;
            case 2:
                IBinder readStrongBinder = parcel.readStrongBinder();
                if (readStrongBinder != null) {
                    IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.request.IAdResponseListener");
                    if (queryLocalInterface instanceof zzbvf) {
                    }
                }
                zzayv.zzd(parcel);
                parcel2.writeNoException();
                return true;
            case 3:
            default:
                return false;
            case 4:
                zzbvq zzbvqVar = (zzbvq) zzayv.zza(parcel, zzbvq.CREATOR);
                IBinder readStrongBinder2 = parcel.readStrongBinder();
                if (readStrongBinder2 != null) {
                    IInterface queryLocalInterface2 = readStrongBinder2.queryLocalInterface("com.google.android.gms.ads.internal.request.INonagonStreamingResponseListener");
                    zzbviVar = queryLocalInterface2 instanceof zzbvi ? (zzbvi) queryLocalInterface2 : new zzbvg(readStrongBinder2);
                }
                zzayv.zzd(parcel);
                zzg(zzbvqVar, zzbviVar);
                parcel2.writeNoException();
                return true;
            case 5:
                zzbvq zzbvqVar2 = (zzbvq) zzayv.zza(parcel, zzbvq.CREATOR);
                IBinder readStrongBinder3 = parcel.readStrongBinder();
                if (readStrongBinder3 != null) {
                    IInterface queryLocalInterface3 = readStrongBinder3.queryLocalInterface("com.google.android.gms.ads.internal.request.INonagonStreamingResponseListener");
                    zzbviVar4 = queryLocalInterface3 instanceof zzbvi ? (zzbvi) queryLocalInterface3 : new zzbvg(readStrongBinder3);
                }
                zzayv.zzd(parcel);
                zzf(zzbvqVar2, zzbviVar4);
                parcel2.writeNoException();
                return true;
            case 6:
                zzbvq zzbvqVar3 = (zzbvq) zzayv.zza(parcel, zzbvq.CREATOR);
                IBinder readStrongBinder4 = parcel.readStrongBinder();
                if (readStrongBinder4 != null) {
                    IInterface queryLocalInterface4 = readStrongBinder4.queryLocalInterface("com.google.android.gms.ads.internal.request.INonagonStreamingResponseListener");
                    zzbviVar3 = queryLocalInterface4 instanceof zzbvi ? (zzbvi) queryLocalInterface4 : new zzbvg(readStrongBinder4);
                }
                zzayv.zzd(parcel);
                zze(zzbvqVar3, zzbviVar3);
                parcel2.writeNoException();
                return true;
            case 7:
                String readString = parcel.readString();
                IBinder readStrongBinder5 = parcel.readStrongBinder();
                if (readStrongBinder5 != null) {
                    IInterface queryLocalInterface5 = readStrongBinder5.queryLocalInterface("com.google.android.gms.ads.internal.request.INonagonStreamingResponseListener");
                    zzbviVar2 = queryLocalInterface5 instanceof zzbvi ? (zzbvi) queryLocalInterface5 : new zzbvg(readStrongBinder5);
                }
                zzayv.zzd(parcel);
                zzh(readString, zzbviVar2);
                parcel2.writeNoException();
                return true;
            case 8:
                zzbva zzbvaVar = (zzbva) zzayv.zza(parcel, zzbva.CREATOR);
                IBinder readStrongBinder6 = parcel.readStrongBinder();
                if (readStrongBinder6 != null) {
                    IInterface queryLocalInterface6 = readStrongBinder6.queryLocalInterface("com.google.android.gms.ads.internal.request.ITrustlessTokenListener");
                    zzbvjVar = queryLocalInterface6 instanceof zzbvj ? (zzbvj) queryLocalInterface6 : new zzbvj(readStrongBinder6);
                }
                zzayv.zzd(parcel);
                zzi(zzbvaVar, zzbvjVar);
                parcel2.writeNoException();
                return true;
        }
    }
}
