package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads-api@@24.5.0 */
/* loaded from: classes5.dex */
public abstract class zzbpv extends zzayu implements zzbpw {
    public zzbpv() {
        super("com.google.android.gms.ads.internal.mediation.client.IMediationAdapterListener");
    }

    public static zzbpw zzb(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapterListener");
        return queryLocalInterface instanceof zzbpw ? (zzbpw) queryLocalInterface : new zzbpu(iBinder);
    }

    @Override // com.google.android.gms.internal.ads.zzayu
    protected final boolean zzde(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        switch (i) {
            case 1:
                zze();
                break;
            case 2:
                zzf();
                break;
            case 3:
                int readInt = parcel.readInt();
                zzayv.zzd(parcel);
                zzg(readInt);
                break;
            case 4:
                zzn();
                break;
            case 5:
                zzp();
                break;
            case 6:
                zzo();
                break;
            case 7:
                IBinder readStrongBinder = parcel.readStrongBinder();
                if (readStrongBinder != null) {
                    IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.IMediationResponseMetadata");
                    if (queryLocalInterface instanceof zzbqa) {
                    }
                }
                zzayv.zzd(parcel);
                break;
            case 8:
                zzm();
                break;
            case 9:
                String readString = parcel.readString();
                String readString2 = parcel.readString();
                zzayv.zzd(parcel);
                zzq(readString, readString2);
                break;
            case 10:
                zzbhi.zzb(parcel.readStrongBinder());
                parcel.readString();
                zzayv.zzd(parcel);
                break;
            case 11:
                zzw();
                break;
            case 12:
                parcel.readString();
                zzayv.zzd(parcel);
                break;
            case 13:
                zzz();
                break;
            case 14:
                zzbwo zzbwoVar = (zzbwo) zzayv.zza(parcel, zzbwo.CREATOR);
                zzayv.zzd(parcel);
                zzs(zzbwoVar);
                break;
            case 15:
                zzx();
                break;
            case 16:
                zzbws zzb = zzbwr.zzb(parcel.readStrongBinder());
                zzayv.zzd(parcel);
                zzt(zzb);
                break;
            case 17:
                int readInt2 = parcel.readInt();
                zzayv.zzd(parcel);
                zzj(readInt2);
                break;
            case 18:
                zzv();
                break;
            case 19:
                zzayv.zzd(parcel);
                break;
            case 20:
                zzy();
                break;
            case 21:
                String readString3 = parcel.readString();
                zzayv.zzd(parcel);
                zzl(readString3);
                break;
            case 22:
                int readInt3 = parcel.readInt();
                String readString4 = parcel.readString();
                zzayv.zzd(parcel);
                zzi(readInt3, readString4);
                break;
            case 23:
                com.google.android.gms.ads.internal.client.zze zzeVar = (com.google.android.gms.ads.internal.client.zze) zzayv.zza(parcel, com.google.android.gms.ads.internal.client.zze.CREATOR);
                zzayv.zzd(parcel);
                zzh(zzeVar);
                break;
            case 24:
                com.google.android.gms.ads.internal.client.zze zzeVar2 = (com.google.android.gms.ads.internal.client.zze) zzayv.zza(parcel, com.google.android.gms.ads.internal.client.zze.CREATOR);
                zzayv.zzd(parcel);
                zzk(zzeVar2);
                break;
            case 25:
                zzu();
                break;
            default:
                return false;
        }
        parcel2.writeNoException();
        return true;
    }
}
