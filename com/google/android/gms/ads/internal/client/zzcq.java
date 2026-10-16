package com.google.android.gms.ads.internal.client;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.ads.zzayu;
import com.google.android.gms.internal.ads.zzayv;
import com.google.android.gms.internal.ads.zzbgt;
import com.google.android.gms.internal.ads.zzbgz;
import com.google.android.gms.internal.ads.zzbld;
import com.google.android.gms.internal.ads.zzble;
import com.google.android.gms.internal.ads.zzblh;
import com.google.android.gms.internal.ads.zzbpp;
import com.google.android.gms.internal.ads.zzbpq;
import com.google.android.gms.internal.ads.zzbtj;
import com.google.android.gms.internal.ads.zzbtq;
import com.google.android.gms.internal.ads.zzbwf;
import com.google.android.gms.internal.ads.zzbwv;
import com.google.android.gms.internal.ads.zzbza;

/* compiled from: com.google.android.gms:play-services-ads-api@@24.5.0 */
/* loaded from: classes4.dex */
public abstract class zzcq extends zzayu implements zzcr {
    public zzcq() {
        super("com.google.android.gms.ads.internal.client.IClientApi");
    }

    @Override // com.google.android.gms.internal.ads.zzayu
    protected final boolean zzde(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        switch (i) {
            case 1:
                IObjectWrapper asInterface = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                zzr zzrVar = (zzr) zzayv.zza(parcel, zzr.CREATOR);
                String readString = parcel.readString();
                zzbpq zzf = zzbpp.zzf(parcel.readStrongBinder());
                int readInt = parcel.readInt();
                zzayv.zzd(parcel);
                zzbx zzd = zzd(asInterface, zzrVar, readString, zzf, readInt);
                parcel2.writeNoException();
                zzayv.zzg(parcel2, zzd);
                return true;
            case 2:
                IObjectWrapper asInterface2 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                zzr zzrVar2 = (zzr) zzayv.zza(parcel, zzr.CREATOR);
                String readString2 = parcel.readString();
                zzbpq zzf2 = zzbpp.zzf(parcel.readStrongBinder());
                int readInt2 = parcel.readInt();
                zzayv.zzd(parcel);
                zzbx zze = zze(asInterface2, zzrVar2, readString2, zzf2, readInt2);
                parcel2.writeNoException();
                zzayv.zzg(parcel2, zze);
                return true;
            case 3:
                IObjectWrapper asInterface3 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                String readString3 = parcel.readString();
                zzbpq zzf3 = zzbpp.zzf(parcel.readStrongBinder());
                int readInt3 = parcel.readInt();
                zzayv.zzd(parcel);
                zzbt zzb = zzb(asInterface3, readString3, zzf3, readInt3);
                parcel2.writeNoException();
                zzayv.zzg(parcel2, zzb);
                return true;
            case 4:
                IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                zzayv.zzd(parcel);
                parcel2.writeNoException();
                zzayv.zzg(parcel2, null);
                return true;
            case 5:
                IObjectWrapper asInterface4 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                IObjectWrapper asInterface5 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                zzayv.zzd(parcel);
                zzbgt zzj = zzj(asInterface4, asInterface5);
                parcel2.writeNoException();
                zzayv.zzg(parcel2, zzj);
                return true;
            case 6:
                IObjectWrapper asInterface6 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                zzbpq zzf4 = zzbpp.zzf(parcel.readStrongBinder());
                int readInt4 = parcel.readInt();
                zzayv.zzd(parcel);
                zzbwf zzo = zzo(asInterface6, zzf4, readInt4);
                parcel2.writeNoException();
                zzayv.zzg(parcel2, zzo);
                return true;
            case 7:
                IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                zzayv.zzd(parcel);
                parcel2.writeNoException();
                zzayv.zzg(parcel2, null);
                return true;
            case 8:
                IObjectWrapper asInterface7 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                zzayv.zzd(parcel);
                zzbtq zzn = zzn(asInterface7);
                parcel2.writeNoException();
                zzayv.zzg(parcel2, zzn);
                return true;
            case 9:
                IObjectWrapper asInterface8 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                int readInt5 = parcel.readInt();
                zzayv.zzd(parcel);
                zzdb zzh = zzh(asInterface8, readInt5);
                parcel2.writeNoException();
                zzayv.zzg(parcel2, zzh);
                return true;
            case 10:
                IObjectWrapper asInterface9 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                zzr zzrVar3 = (zzr) zzayv.zza(parcel, zzr.CREATOR);
                String readString4 = parcel.readString();
                int readInt6 = parcel.readInt();
                zzayv.zzd(parcel);
                zzbx zzf5 = zzf(asInterface9, zzrVar3, readString4, readInt6);
                parcel2.writeNoException();
                zzayv.zzg(parcel2, zzf5);
                return true;
            case 11:
                IObjectWrapper asInterface10 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                IObjectWrapper asInterface11 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                IObjectWrapper asInterface12 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                zzayv.zzd(parcel);
                zzbgz zzk = zzk(asInterface10, asInterface11, asInterface12);
                parcel2.writeNoException();
                zzayv.zzg(parcel2, zzk);
                return true;
            case 12:
                IObjectWrapper asInterface13 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                String readString5 = parcel.readString();
                zzbpq zzf6 = zzbpp.zzf(parcel.readStrongBinder());
                int readInt7 = parcel.readInt();
                zzayv.zzd(parcel);
                zzbwv zzp = zzp(asInterface13, readString5, zzf6, readInt7);
                parcel2.writeNoException();
                zzayv.zzg(parcel2, zzp);
                return true;
            case 13:
                IObjectWrapper asInterface14 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                zzr zzrVar4 = (zzr) zzayv.zza(parcel, zzr.CREATOR);
                String readString6 = parcel.readString();
                zzbpq zzf7 = zzbpp.zzf(parcel.readStrongBinder());
                int readInt8 = parcel.readInt();
                zzayv.zzd(parcel);
                zzbx zzc = zzc(asInterface14, zzrVar4, readString6, zzf7, readInt8);
                parcel2.writeNoException();
                zzayv.zzg(parcel2, zzc);
                return true;
            case 14:
                IObjectWrapper asInterface15 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                zzbpq zzf8 = zzbpp.zzf(parcel.readStrongBinder());
                int readInt9 = parcel.readInt();
                zzayv.zzd(parcel);
                zzbza zzq = zzq(asInterface15, zzf8, readInt9);
                parcel2.writeNoException();
                zzayv.zzg(parcel2, zzq);
                return true;
            case 15:
                IObjectWrapper asInterface16 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                zzbpq zzf9 = zzbpp.zzf(parcel.readStrongBinder());
                int readInt10 = parcel.readInt();
                zzayv.zzd(parcel);
                zzbtj zzm = zzm(asInterface16, zzf9, readInt10);
                parcel2.writeNoException();
                zzayv.zzg(parcel2, zzm);
                return true;
            case 16:
                IObjectWrapper asInterface17 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                zzbpq zzf10 = zzbpp.zzf(parcel.readStrongBinder());
                int readInt11 = parcel.readInt();
                zzble zzc2 = zzbld.zzc(parcel.readStrongBinder());
                zzayv.zzd(parcel);
                zzblh zzl = zzl(asInterface17, zzf10, readInt11, zzc2);
                parcel2.writeNoException();
                zzayv.zzg(parcel2, zzl);
                return true;
            case 17:
                IObjectWrapper asInterface18 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                zzbpq zzf11 = zzbpp.zzf(parcel.readStrongBinder());
                int readInt12 = parcel.readInt();
                zzayv.zzd(parcel);
                zzdw zzi = zzi(asInterface18, zzf11, readInt12);
                parcel2.writeNoException();
                zzayv.zzg(parcel2, zzi);
                return true;
            case 18:
                IObjectWrapper asInterface19 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                zzbpq zzf12 = zzbpp.zzf(parcel.readStrongBinder());
                int readInt13 = parcel.readInt();
                zzayv.zzd(parcel);
                zzck zzg = zzg(asInterface19, zzf12, readInt13);
                parcel2.writeNoException();
                zzayv.zzg(parcel2, zzg);
                return true;
            default:
                return false;
        }
    }
}
