package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads-api@@24.5.0 */
/* loaded from: classes5.dex */
public abstract class zzbwu extends zzayu implements zzbwv {
    public zzbwu() {
        super("com.google.android.gms.ads.internal.rewarded.client.IRewardedAd");
    }

    public static zzbwv zzt(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.rewarded.client.IRewardedAd");
        return queryLocalInterface instanceof zzbwv ? (zzbwv) queryLocalInterface : new zzbwt(iBinder);
    }

    @Override // com.google.android.gms.internal.ads.zzayu
    protected final boolean zzde(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        zzbxc zzbxcVar = null;
        zzbxc zzbxcVar2 = null;
        zzbxd zzbxdVar = null;
        zzbwy zzbwyVar = null;
        switch (i) {
            case 1:
                com.google.android.gms.ads.internal.client.zzm zzmVar = (com.google.android.gms.ads.internal.client.zzm) zzayv.zza(parcel, com.google.android.gms.ads.internal.client.zzm.CREATOR);
                IBinder readStrongBinder = parcel.readStrongBinder();
                if (readStrongBinder != null) {
                    IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.rewarded.client.IRewardedAdLoadCallback");
                    zzbxcVar = queryLocalInterface instanceof zzbxc ? (zzbxc) queryLocalInterface : new zzbxa(readStrongBinder);
                }
                zzayv.zzd(parcel);
                zzh(zzmVar, zzbxcVar);
                parcel2.writeNoException();
                return true;
            case 2:
                IBinder readStrongBinder2 = parcel.readStrongBinder();
                if (readStrongBinder2 != null) {
                    IInterface queryLocalInterface2 = readStrongBinder2.queryLocalInterface("com.google.android.gms.ads.internal.rewarded.client.IRewardedAdCallback");
                    zzbwyVar = queryLocalInterface2 instanceof zzbwy ? (zzbwy) queryLocalInterface2 : new zzbww(readStrongBinder2);
                }
                zzayv.zzd(parcel);
                zzn(zzbwyVar);
                parcel2.writeNoException();
                return true;
            case 3:
                boolean zzr = zzr();
                parcel2.writeNoException();
                int i3 = zzayv.zza;
                parcel2.writeInt(zzr ? 1 : 0);
                return true;
            case 4:
                String zzg = zzg();
                parcel2.writeNoException();
                parcel2.writeString(zzg);
                return true;
            case 5:
                IObjectWrapper asInterface = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                zzayv.zzd(parcel);
                zzp(asInterface);
                parcel2.writeNoException();
                return true;
            case 6:
                IBinder readStrongBinder3 = parcel.readStrongBinder();
                if (readStrongBinder3 != null) {
                    IInterface queryLocalInterface3 = readStrongBinder3.queryLocalInterface("com.google.android.gms.ads.internal.rewarded.client.IRewardedAdSkuListener");
                    zzbxdVar = queryLocalInterface3 instanceof zzbxd ? (zzbxd) queryLocalInterface3 : new zzbxd(readStrongBinder3);
                }
                zzayv.zzd(parcel);
                zzs(zzbxdVar);
                parcel2.writeNoException();
                return true;
            case 7:
                zzbxj zzbxjVar = (zzbxj) zzayv.zza(parcel, zzbxj.CREATOR);
                zzayv.zzd(parcel);
                zzo(zzbxjVar);
                parcel2.writeNoException();
                return true;
            case 8:
                com.google.android.gms.ads.internal.client.zzdq zzb = com.google.android.gms.ads.internal.client.zzdp.zzb(parcel.readStrongBinder());
                zzayv.zzd(parcel);
                zzk(zzb);
                parcel2.writeNoException();
                return true;
            case 9:
                Bundle zzc = zzc();
                parcel2.writeNoException();
                zzayv.zzf(parcel2, zzc);
                return true;
            case 10:
                IObjectWrapper asInterface2 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                boolean zzh = zzayv.zzh(parcel);
                zzayv.zzd(parcel);
                zzq(asInterface2, zzh);
                parcel2.writeNoException();
                return true;
            case 11:
                zzbws zze = zze();
                parcel2.writeNoException();
                zzayv.zzg(parcel2, zze);
                return true;
            case 12:
                com.google.android.gms.ads.internal.client.zzea zzd = zzd();
                parcel2.writeNoException();
                zzayv.zzg(parcel2, zzd);
                return true;
            case 13:
                com.google.android.gms.ads.internal.client.zzdt zzb2 = com.google.android.gms.ads.internal.client.zzds.zzb(parcel.readStrongBinder());
                zzayv.zzd(parcel);
                zzl(zzb2);
                parcel2.writeNoException();
                return true;
            case 14:
                com.google.android.gms.ads.internal.client.zzm zzmVar2 = (com.google.android.gms.ads.internal.client.zzm) zzayv.zza(parcel, com.google.android.gms.ads.internal.client.zzm.CREATOR);
                IBinder readStrongBinder4 = parcel.readStrongBinder();
                if (readStrongBinder4 != null) {
                    IInterface queryLocalInterface4 = readStrongBinder4.queryLocalInterface("com.google.android.gms.ads.internal.rewarded.client.IRewardedAdLoadCallback");
                    zzbxcVar2 = queryLocalInterface4 instanceof zzbxc ? (zzbxc) queryLocalInterface4 : new zzbxa(readStrongBinder4);
                }
                zzayv.zzd(parcel);
                zzi(zzmVar2, zzbxcVar2);
                parcel2.writeNoException();
                return true;
            case 15:
                boolean zzh2 = zzayv.zzh(parcel);
                zzayv.zzd(parcel);
                zzj(zzh2);
                parcel2.writeNoException();
                return true;
            case 16:
                String zzf = zzf();
                parcel2.writeNoException();
                parcel2.writeString(zzf);
                return true;
            case 17:
                long zzb3 = zzb();
                parcel2.writeNoException();
                parcel2.writeLong(zzb3);
                return true;
            case 18:
                long readLong = parcel.readLong();
                zzayv.zzd(parcel);
                zzm(readLong);
                parcel2.writeNoException();
                return true;
            default:
                return false;
        }
    }
}
