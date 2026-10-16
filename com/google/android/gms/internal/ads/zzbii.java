package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads-api@@24.5.0 */
/* loaded from: classes5.dex */
public abstract class zzbii extends zzayu implements zzbij {
    public zzbii() {
        super("com.google.android.gms.ads.internal.formats.client.IUnifiedNativeAd");
    }

    @Override // com.google.android.gms.internal.ads.zzayu
    protected final boolean zzde(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        zzbig zzbieVar;
        switch (i) {
            case 2:
                String zzr = zzr();
                parcel2.writeNoException();
                parcel2.writeString(zzr);
                return true;
            case 3:
                List zzv = zzv();
                parcel2.writeNoException();
                parcel2.writeList(zzv);
                return true;
            case 4:
                String zzp = zzp();
                parcel2.writeNoException();
                parcel2.writeString(zzp);
                return true;
            case 5:
                zzbgp zzl = zzl();
                parcel2.writeNoException();
                zzayv.zzg(parcel2, zzl);
                return true;
            case 6:
                String zzq = zzq();
                parcel2.writeNoException();
                parcel2.writeString(zzq);
                return true;
            case 7:
                String zzo = zzo();
                parcel2.writeNoException();
                parcel2.writeString(zzo);
                return true;
            case 8:
                double zze = zze();
                parcel2.writeNoException();
                parcel2.writeDouble(zze);
                return true;
            case 9:
                String zzu = zzu();
                parcel2.writeNoException();
                parcel2.writeString(zzu);
                return true;
            case 10:
                String zzt = zzt();
                parcel2.writeNoException();
                parcel2.writeString(zzt);
                return true;
            case 11:
                com.google.android.gms.ads.internal.client.zzed zzi = zzi();
                parcel2.writeNoException();
                zzayv.zzg(parcel2, zzi);
                return true;
            case 12:
                String zzs = zzs();
                parcel2.writeNoException();
                parcel2.writeString(zzs);
                return true;
            case 13:
                zzy();
                parcel2.writeNoException();
                return true;
            case 14:
                zzbgi zzj = zzj();
                parcel2.writeNoException();
                zzayv.zzg(parcel2, zzj);
                return true;
            case 15:
                Bundle bundle = (Bundle) zzayv.zza(parcel, Bundle.CREATOR);
                zzayv.zzd(parcel);
                zzA(bundle);
                parcel2.writeNoException();
                return true;
            case 16:
                Bundle bundle2 = (Bundle) zzayv.zza(parcel, Bundle.CREATOR);
                zzayv.zzd(parcel);
                boolean zzL = zzL(bundle2);
                parcel2.writeNoException();
                parcel2.writeInt(zzL ? 1 : 0);
                return true;
            case 17:
                Bundle bundle3 = (Bundle) zzayv.zza(parcel, Bundle.CREATOR);
                zzayv.zzd(parcel);
                zzD(bundle3);
                parcel2.writeNoException();
                return true;
            case 18:
                IObjectWrapper zzn = zzn();
                parcel2.writeNoException();
                zzayv.zzg(parcel2, zzn);
                return true;
            case 19:
                IObjectWrapper zzm = zzm();
                parcel2.writeNoException();
                zzayv.zzg(parcel2, zzm);
                return true;
            case 20:
                Bundle zzg = zzg();
                parcel2.writeNoException();
                zzayv.zzf(parcel2, zzg);
                return true;
            case 21:
                IBinder readStrongBinder = parcel.readStrongBinder();
                if (readStrongBinder == null) {
                    zzbieVar = null;
                } else {
                    IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.IUnconfirmedClickListener");
                    zzbieVar = queryLocalInterface instanceof zzbig ? (zzbig) queryLocalInterface : new zzbie(readStrongBinder);
                }
                zzayv.zzd(parcel);
                zzI(zzbieVar);
                parcel2.writeNoException();
                return true;
            case 22:
                zzx();
                parcel2.writeNoException();
                return true;
            case 23:
                List zzw = zzw();
                parcel2.writeNoException();
                parcel2.writeList(zzw);
                return true;
            case 24:
                boolean zzK = zzK();
                parcel2.writeNoException();
                int i3 = zzayv.zza;
                parcel2.writeInt(zzK ? 1 : 0);
                return true;
            case 25:
                com.google.android.gms.ads.internal.client.zzdj zzb = com.google.android.gms.ads.internal.client.zzdi.zzb(parcel.readStrongBinder());
                zzayv.zzd(parcel);
                zzz(zzb);
                parcel2.writeNoException();
                return true;
            case 26:
                com.google.android.gms.ads.internal.client.zzdf zzb2 = com.google.android.gms.ads.internal.client.zzde.zzb(parcel.readStrongBinder());
                zzayv.zzd(parcel);
                zzF(zzb2);
                parcel2.writeNoException();
                return true;
            case 27:
                zzE();
                parcel2.writeNoException();
                return true;
            case 28:
                zzB();
                parcel2.writeNoException();
                return true;
            case 29:
                zzbgm zzk = zzk();
                parcel2.writeNoException();
                zzayv.zzg(parcel2, zzk);
                return true;
            case 30:
                boolean zzJ = zzJ();
                parcel2.writeNoException();
                int i4 = zzayv.zza;
                parcel2.writeInt(zzJ ? 1 : 0);
                return true;
            case 31:
                com.google.android.gms.ads.internal.client.zzea zzh = zzh();
                parcel2.writeNoException();
                zzayv.zzg(parcel2, zzh);
                return true;
            case 32:
                com.google.android.gms.ads.internal.client.zzdt zzb3 = com.google.android.gms.ads.internal.client.zzds.zzb(parcel.readStrongBinder());
                zzayv.zzd(parcel);
                zzG(zzb3);
                parcel2.writeNoException();
                return true;
            case 33:
                Bundle bundle4 = (Bundle) zzayv.zza(parcel, Bundle.CREATOR);
                zzayv.zzd(parcel);
                zzC(bundle4);
                parcel2.writeNoException();
                return true;
            case 34:
                long zzf = zzf();
                parcel2.writeNoException();
                parcel2.writeLong(zzf);
                return true;
            case 35:
                long readLong = parcel.readLong();
                zzayv.zzd(parcel);
                zzH(readLong);
                parcel2.writeNoException();
                return true;
            default:
                return false;
        }
    }
}
