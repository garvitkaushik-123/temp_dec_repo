package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads-api@@24.5.0 */
/* loaded from: classes5.dex */
public abstract class zzbwe extends zzayu implements zzbwf {
    public zzbwe() {
        super("com.google.android.gms.ads.internal.reward.client.IRewardedVideoAd");
    }

    @Override // com.google.android.gms.internal.ads.zzayu
    protected final boolean zzde(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i == 1) {
            zzbwj zzbwjVar = (zzbwj) zzayv.zza(parcel, zzbwj.CREATOR);
            zzayv.zzd(parcel);
            zzg(zzbwjVar);
            parcel2.writeNoException();
        } else if (i != 2) {
            zzbwi zzbwiVar = null;
            zzbwd zzbwdVar = null;
            if (i == 3) {
                IBinder readStrongBinder = parcel.readStrongBinder();
                if (readStrongBinder != null) {
                    IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.reward.client.IRewardedVideoAdListener");
                    zzbwiVar = queryLocalInterface instanceof zzbwi ? (zzbwi) queryLocalInterface : new zzbwg(readStrongBinder);
                }
                zzayv.zzd(parcel);
                zzo(zzbwiVar);
                parcel2.writeNoException();
            } else if (i != 34) {
                switch (i) {
                    case 5:
                        boolean zzs = zzs();
                        parcel2.writeNoException();
                        int i3 = zzayv.zza;
                        parcel2.writeInt(zzs ? 1 : 0);
                        break;
                    case 6:
                        zzh();
                        parcel2.writeNoException();
                        break;
                    case 7:
                        zzj();
                        parcel2.writeNoException();
                        break;
                    case 8:
                        zze();
                        parcel2.writeNoException();
                        break;
                    case 9:
                        IObjectWrapper asInterface = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                        zzayv.zzd(parcel);
                        zzi(asInterface);
                        parcel2.writeNoException();
                        break;
                    case 10:
                        IObjectWrapper asInterface2 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                        zzayv.zzd(parcel);
                        zzk(asInterface2);
                        parcel2.writeNoException();
                        break;
                    case 11:
                        IObjectWrapper asInterface3 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                        zzayv.zzd(parcel);
                        zzf(asInterface3);
                        parcel2.writeNoException();
                        break;
                    case 12:
                        String zzd = zzd();
                        parcel2.writeNoException();
                        parcel2.writeString(zzd);
                        break;
                    case 13:
                        String readString = parcel.readString();
                        zzayv.zzd(parcel);
                        zzp(readString);
                        parcel2.writeNoException();
                        break;
                    case 14:
                        com.google.android.gms.ads.internal.client.zzcb zzb = com.google.android.gms.ads.internal.client.zzca.zzb(parcel.readStrongBinder());
                        zzayv.zzd(parcel);
                        zzl(zzb);
                        parcel2.writeNoException();
                        break;
                    case 15:
                        Bundle zzb2 = zzb();
                        parcel2.writeNoException();
                        zzayv.zzf(parcel2, zzb2);
                        break;
                    case 16:
                        IBinder readStrongBinder2 = parcel.readStrongBinder();
                        if (readStrongBinder2 != null) {
                            IInterface queryLocalInterface2 = readStrongBinder2.queryLocalInterface("com.google.android.gms.ads.internal.reward.client.IRewardedAdSkuListener");
                            zzbwdVar = queryLocalInterface2 instanceof zzbwd ? (zzbwd) queryLocalInterface2 : new zzbwd(readStrongBinder2);
                        }
                        zzayv.zzd(parcel);
                        zzu(zzbwdVar);
                        parcel2.writeNoException();
                        break;
                    case 17:
                        parcel.readString();
                        zzayv.zzd(parcel);
                        parcel2.writeNoException();
                        break;
                    case 18:
                        IObjectWrapper asInterface4 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                        zzayv.zzd(parcel);
                        zzr(asInterface4);
                        parcel2.writeNoException();
                        break;
                    case 19:
                        String readString2 = parcel.readString();
                        zzayv.zzd(parcel);
                        zzm(readString2);
                        parcel2.writeNoException();
                        break;
                    case 20:
                        boolean zzt = zzt();
                        parcel2.writeNoException();
                        int i4 = zzayv.zza;
                        parcel2.writeInt(zzt ? 1 : 0);
                        break;
                    case 21:
                        com.google.android.gms.ads.internal.client.zzea zzc = zzc();
                        parcel2.writeNoException();
                        zzayv.zzg(parcel2, zzc);
                        break;
                    default:
                        return false;
                }
            } else {
                boolean zzh = zzayv.zzh(parcel);
                zzayv.zzd(parcel);
                zzn(zzh);
                parcel2.writeNoException();
            }
        } else {
            zzq();
            parcel2.writeNoException();
        }
        return true;
    }
}
