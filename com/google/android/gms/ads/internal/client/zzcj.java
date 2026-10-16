package com.google.android.gms.ads.internal.client;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.ads.zzayu;
import com.google.android.gms.internal.ads.zzayv;
import com.google.android.gms.internal.ads.zzbaw;
import com.google.android.gms.internal.ads.zzbpp;
import com.google.android.gms.internal.ads.zzbpq;
import com.google.android.gms.internal.ads.zzbwv;
import java.util.ArrayList;

/* compiled from: com.google.android.gms:play-services-ads-api@@24.5.0 */
/* loaded from: classes4.dex */
public abstract class zzcj extends zzayu implements zzck {
    public zzcj() {
        super("com.google.android.gms.ads.internal.client.IAdPreloader");
    }

    @Override // com.google.android.gms.internal.ads.zzayu
    protected final boolean zzde(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        zzce zzceVar = null;
        zzch zzchVar = null;
        switch (i) {
            case 1:
                ArrayList createTypedArrayList = parcel.createTypedArrayList(zzfv.CREATOR);
                IBinder readStrongBinder = parcel.readStrongBinder();
                if (readStrongBinder != null) {
                    IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdPreloadCallback");
                    zzceVar = queryLocalInterface instanceof zzce ? (zzce) queryLocalInterface : new zzcc(readStrongBinder);
                }
                zzayv.zzd(parcel);
                zzp(createTypedArrayList, zzceVar);
                parcel2.writeNoException();
                return true;
            case 2:
                String readString = parcel.readString();
                zzayv.zzd(parcel);
                boolean zzu = zzu(readString);
                parcel2.writeNoException();
                parcel2.writeInt(zzu ? 1 : 0);
                return true;
            case 3:
                String readString2 = parcel.readString();
                zzayv.zzd(parcel);
                zzbwv zzm = zzm(readString2);
                parcel2.writeNoException();
                zzayv.zzg(parcel2, zzm);
                return true;
            case 4:
                String readString3 = parcel.readString();
                zzayv.zzd(parcel);
                boolean zzs = zzs(readString3);
                parcel2.writeNoException();
                parcel2.writeInt(zzs ? 1 : 0);
                return true;
            case 5:
                String readString4 = parcel.readString();
                zzayv.zzd(parcel);
                zzbaw zzh = zzh(readString4);
                parcel2.writeNoException();
                zzayv.zzg(parcel2, zzh);
                return true;
            case 6:
                String readString5 = parcel.readString();
                zzayv.zzd(parcel);
                boolean zzt = zzt(readString5);
                parcel2.writeNoException();
                parcel2.writeInt(zzt ? 1 : 0);
                return true;
            case 7:
                String readString6 = parcel.readString();
                zzayv.zzd(parcel);
                zzbx zzj = zzj(readString6);
                parcel2.writeNoException();
                zzayv.zzg(parcel2, zzj);
                return true;
            case 8:
                zzbpq zzf = zzbpp.zzf(parcel.readStrongBinder());
                zzayv.zzd(parcel);
                zzo(zzf);
                parcel2.writeNoException();
                return true;
            case 9:
                String readString7 = parcel.readString();
                zzfv zzfvVar = (zzfv) zzayv.zza(parcel, zzfv.CREATOR);
                IBinder readStrongBinder2 = parcel.readStrongBinder();
                if (readStrongBinder2 != null) {
                    IInterface queryLocalInterface2 = readStrongBinder2.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdPreloadCallbackV2");
                    zzchVar = queryLocalInterface2 instanceof zzch ? (zzch) queryLocalInterface2 : new zzcf(readStrongBinder2);
                }
                zzayv.zzd(parcel);
                boolean zzv = zzv(readString7, zzfvVar, zzchVar);
                parcel2.writeNoException();
                parcel2.writeInt(zzv ? 1 : 0);
                return true;
            case 10:
                int readInt = parcel.readInt();
                String readString8 = parcel.readString();
                zzayv.zzd(parcel);
                boolean zzr = zzr(readInt, readString8);
                parcel2.writeNoException();
                parcel2.writeInt(zzr ? 1 : 0);
                return true;
            case 11:
                String readString9 = parcel.readString();
                zzayv.zzd(parcel);
                zzbx zzi = zzi(readString9);
                parcel2.writeNoException();
                zzayv.zzg(parcel2, zzi);
                return true;
            case 12:
                String readString10 = parcel.readString();
                zzayv.zzd(parcel);
                zzbaw zzg = zzg(readString10);
                parcel2.writeNoException();
                zzayv.zzg(parcel2, zzg);
                return true;
            case 13:
                String readString11 = parcel.readString();
                zzayv.zzd(parcel);
                zzbwv zzl = zzl(readString11);
                parcel2.writeNoException();
                zzayv.zzg(parcel2, zzl);
                return true;
            case 14:
                int readInt2 = parcel.readInt();
                String readString12 = parcel.readString();
                zzayv.zzd(parcel);
                zzfv zzk = zzk(readInt2, readString12);
                parcel2.writeNoException();
                zzayv.zzf(parcel2, zzk);
                return true;
            case 15:
                int readInt3 = parcel.readInt();
                zzayv.zzd(parcel);
                Bundle zzf2 = zzf(readInt3);
                parcel2.writeNoException();
                zzayv.zzf(parcel2, zzf2);
                return true;
            case 16:
                int readInt4 = parcel.readInt();
                String readString13 = parcel.readString();
                zzayv.zzd(parcel);
                int zze = zze(readInt4, readString13);
                parcel2.writeNoException();
                parcel2.writeInt(zze);
                return true;
            case 17:
                int readInt5 = parcel.readInt();
                String readString14 = parcel.readString();
                zzayv.zzd(parcel);
                boolean zzq = zzq(readInt5, readString14);
                parcel2.writeNoException();
                parcel2.writeInt(zzq ? 1 : 0);
                return true;
            case 18:
                int readInt6 = parcel.readInt();
                zzayv.zzd(parcel);
                zzn(readInt6);
                parcel2.writeNoException();
                return true;
            default:
                return false;
        }
    }
}
