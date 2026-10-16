package com.google.android.gms.ads.internal.client;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.ads.zzayu;
import com.google.android.gms.internal.ads.zzayv;
import com.google.android.gms.internal.ads.zzbay;
import com.google.android.gms.internal.ads.zzbaz;
import com.google.android.gms.internal.ads.zzbdy;
import com.google.android.gms.internal.ads.zzbdz;
import com.google.android.gms.internal.ads.zzbty;
import com.google.android.gms.internal.ads.zzbtz;
import com.google.android.gms.internal.ads.zzbub;
import com.google.android.gms.internal.ads.zzbuc;
import com.google.android.gms.internal.ads.zzbwh;
import com.google.android.gms.internal.ads.zzbwi;

/* compiled from: com.google.android.gms:play-services-ads-api@@24.5.0 */
/* loaded from: classes4.dex */
public abstract class zzbw extends zzayu implements zzbx {
    public zzbw() {
        super("com.google.android.gms.ads.internal.client.IAdManager");
    }

    public static zzbx zzaf(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdManager");
        return queryLocalInterface instanceof zzbx ? (zzbx) queryLocalInterface : new zzbv(iBinder);
    }

    @Override // com.google.android.gms.internal.ads.zzayu
    protected final boolean zzde(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        zzbk zzbkVar = null;
        zzcv zzcvVar = null;
        zzbn zzbnVar = null;
        zzdt zzdtVar = null;
        zzcb zzcbVar = null;
        zzcs zzcsVar = null;
        zzbh zzbhVar = null;
        zzco zzcoVar = null;
        switch (i) {
            case 1:
                IObjectWrapper zzo = zzo();
                parcel2.writeNoException();
                zzayv.zzg(parcel2, zzo);
                return true;
            case 2:
                zzy();
                parcel2.writeNoException();
                return true;
            case 3:
                boolean zzac = zzac();
                parcel2.writeNoException();
                int i3 = zzayv.zza;
                parcel2.writeInt(zzac ? 1 : 0);
                return true;
            case 4:
                zzm zzmVar = (zzm) zzayv.zza(parcel, zzm.CREATOR);
                zzayv.zzd(parcel);
                boolean zzad = zzad(zzmVar);
                parcel2.writeNoException();
                parcel2.writeInt(zzad ? 1 : 0);
                return true;
            case 5:
                zzA();
                parcel2.writeNoException();
                return true;
            case 6:
                zzC();
                parcel2.writeNoException();
                return true;
            case 7:
                IBinder readStrongBinder = parcel.readStrongBinder();
                if (readStrongBinder != null) {
                    IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdListener");
                    zzbkVar = queryLocalInterface instanceof zzbk ? (zzbk) queryLocalInterface : new zzbi(readStrongBinder);
                }
                zzayv.zzd(parcel);
                zzE(zzbkVar);
                parcel2.writeNoException();
                return true;
            case 8:
                IBinder readStrongBinder2 = parcel.readStrongBinder();
                if (readStrongBinder2 != null) {
                    IInterface queryLocalInterface2 = readStrongBinder2.queryLocalInterface("com.google.android.gms.ads.internal.client.IAppEventListener");
                    zzcoVar = queryLocalInterface2 instanceof zzco ? (zzco) queryLocalInterface2 : new zzcm(readStrongBinder2);
                }
                zzayv.zzd(parcel);
                zzH(zzcoVar);
                parcel2.writeNoException();
                return true;
            case 9:
                zzZ();
                parcel2.writeNoException();
                return true;
            case 10:
                parcel2.writeNoException();
                return true;
            case 11:
                zzB();
                parcel2.writeNoException();
                return true;
            case 12:
                zzr zzh = zzh();
                parcel2.writeNoException();
                zzayv.zzf(parcel2, zzh);
                return true;
            case 13:
                zzr zzrVar = (zzr) zzayv.zza(parcel, zzr.CREATOR);
                zzayv.zzd(parcel);
                zzG(zzrVar);
                parcel2.writeNoException();
                return true;
            case 14:
                zzbtz zzb = zzbty.zzb(parcel.readStrongBinder());
                zzayv.zzd(parcel);
                zzN(zzb);
                parcel2.writeNoException();
                return true;
            case 15:
                zzbuc zzb2 = zzbub.zzb(parcel.readStrongBinder());
                String readString = parcel.readString();
                zzayv.zzd(parcel);
                zzS(zzb2, readString);
                parcel2.writeNoException();
                return true;
            case 16:
            case 17:
            case 27:
            case 28:
            default:
                return false;
            case 18:
                String zzt = zzt();
                parcel2.writeNoException();
                parcel2.writeString(zzt);
                return true;
            case 19:
                zzbdz zzb3 = zzbdy.zzb(parcel.readStrongBinder());
                zzayv.zzd(parcel);
                zzP(zzb3);
                parcel2.writeNoException();
                return true;
            case 20:
                IBinder readStrongBinder3 = parcel.readStrongBinder();
                if (readStrongBinder3 != null) {
                    IInterface queryLocalInterface3 = readStrongBinder3.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdClickListener");
                    zzbhVar = queryLocalInterface3 instanceof zzbh ? (zzbh) queryLocalInterface3 : new zzbf(readStrongBinder3);
                }
                zzayv.zzd(parcel);
                zzD(zzbhVar);
                parcel2.writeNoException();
                return true;
            case 21:
                IBinder readStrongBinder4 = parcel.readStrongBinder();
                if (readStrongBinder4 != null) {
                    IInterface queryLocalInterface4 = readStrongBinder4.queryLocalInterface("com.google.android.gms.ads.internal.client.ICorrelationIdProvider");
                    zzcsVar = queryLocalInterface4 instanceof zzcs ? (zzcs) queryLocalInterface4 : new zzcs(readStrongBinder4);
                }
                zzayv.zzd(parcel);
                zzae(zzcsVar);
                parcel2.writeNoException();
                return true;
            case 22:
                boolean zzh2 = zzayv.zzh(parcel);
                zzayv.zzd(parcel);
                zzO(zzh2);
                parcel2.writeNoException();
                return true;
            case 23:
                boolean zzab = zzab();
                parcel2.writeNoException();
                int i4 = zzayv.zza;
                parcel2.writeInt(zzab ? 1 : 0);
                return true;
            case 24:
                zzbwi zzb4 = zzbwh.zzb(parcel.readStrongBinder());
                zzayv.zzd(parcel);
                zzU(zzb4);
                parcel2.writeNoException();
                return true;
            case 25:
                String readString2 = parcel.readString();
                zzayv.zzd(parcel);
                zzV(readString2);
                parcel2.writeNoException();
                return true;
            case 26:
                zzed zzm = zzm();
                parcel2.writeNoException();
                zzayv.zzg(parcel2, zzm);
                return true;
            case 29:
                zzgc zzgcVar = (zzgc) zzayv.zza(parcel, zzgc.CREATOR);
                zzayv.zzd(parcel);
                zzW(zzgcVar);
                parcel2.writeNoException();
                return true;
            case 30:
                zzeh zzehVar = (zzeh) zzayv.zza(parcel, zzeh.CREATOR);
                zzayv.zzd(parcel);
                zzL(zzehVar);
                parcel2.writeNoException();
                return true;
            case 31:
                String zzs = zzs();
                parcel2.writeNoException();
                parcel2.writeString(zzs);
                return true;
            case 32:
                zzco zzk = zzk();
                parcel2.writeNoException();
                zzayv.zzg(parcel2, zzk);
                return true;
            case 33:
                zzbk zzj = zzj();
                parcel2.writeNoException();
                zzayv.zzg(parcel2, zzj);
                return true;
            case 34:
                boolean zzh3 = zzayv.zzh(parcel);
                zzayv.zzd(parcel);
                zzM(zzh3);
                parcel2.writeNoException();
                return true;
            case 35:
                String zzu = zzu();
                parcel2.writeNoException();
                parcel2.writeString(zzu);
                return true;
            case 36:
                IBinder readStrongBinder5 = parcel.readStrongBinder();
                if (readStrongBinder5 != null) {
                    IInterface queryLocalInterface5 = readStrongBinder5.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdMetadataListener");
                    zzcbVar = queryLocalInterface5 instanceof zzcb ? (zzcb) queryLocalInterface5 : new zzbz(readStrongBinder5);
                }
                zzayv.zzd(parcel);
                zzF(zzcbVar);
                parcel2.writeNoException();
                return true;
            case 37:
                Bundle zze = zze();
                parcel2.writeNoException();
                zzayv.zzf(parcel2, zze);
                return true;
            case 38:
                String readString3 = parcel.readString();
                zzayv.zzd(parcel);
                zzT(readString3);
                parcel2.writeNoException();
                return true;
            case 39:
                zzx zzxVar = (zzx) zzayv.zza(parcel, zzx.CREATOR);
                zzayv.zzd(parcel);
                zzJ(zzxVar);
                parcel2.writeNoException();
                return true;
            case 40:
                zzbaz zze2 = zzbay.zze(parcel.readStrongBinder());
                zzayv.zzd(parcel);
                zzI(zze2);
                parcel2.writeNoException();
                return true;
            case 41:
                zzea zzl = zzl();
                parcel2.writeNoException();
                zzayv.zzg(parcel2, zzl);
                return true;
            case 42:
                IBinder readStrongBinder6 = parcel.readStrongBinder();
                if (readStrongBinder6 != null) {
                    IInterface queryLocalInterface6 = readStrongBinder6.queryLocalInterface("com.google.android.gms.ads.internal.client.IOnPaidEventListener");
                    zzdtVar = queryLocalInterface6 instanceof zzdt ? (zzdt) queryLocalInterface6 : new zzdr(readStrongBinder6);
                }
                zzayv.zzd(parcel);
                zzQ(zzdtVar);
                parcel2.writeNoException();
                return true;
            case 43:
                zzm zzmVar2 = (zzm) zzayv.zza(parcel, zzm.CREATOR);
                IBinder readStrongBinder7 = parcel.readStrongBinder();
                if (readStrongBinder7 != null) {
                    IInterface queryLocalInterface7 = readStrongBinder7.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdLoadCallback");
                    zzbnVar = queryLocalInterface7 instanceof zzbn ? (zzbn) queryLocalInterface7 : new zzbl(readStrongBinder7);
                }
                zzayv.zzd(parcel);
                zzz(zzmVar2, zzbnVar);
                parcel2.writeNoException();
                return true;
            case 44:
                IObjectWrapper asInterface = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                zzayv.zzd(parcel);
                zzY(asInterface);
                parcel2.writeNoException();
                return true;
            case 45:
                IBinder readStrongBinder8 = parcel.readStrongBinder();
                if (readStrongBinder8 != null) {
                    IInterface queryLocalInterface8 = readStrongBinder8.queryLocalInterface("com.google.android.gms.ads.internal.client.IFullScreenContentCallback");
                    zzcvVar = queryLocalInterface8 instanceof zzcv ? (zzcv) queryLocalInterface8 : new zzct(readStrongBinder8);
                }
                zzayv.zzd(parcel);
                zzK(zzcvVar);
                parcel2.writeNoException();
                return true;
            case 46:
                boolean zzaa = zzaa();
                parcel2.writeNoException();
                int i5 = zzayv.zza;
                parcel2.writeInt(zzaa ? 1 : 0);
                return true;
            case 47:
                long zzc = zzc();
                parcel2.writeNoException();
                parcel2.writeLong(zzc);
                return true;
            case 48:
                long readLong = parcel.readLong();
                zzayv.zzd(parcel);
                zzR(readLong);
                parcel2.writeNoException();
                return true;
        }
    }
}
