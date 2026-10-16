package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.ArrayList;

/* compiled from: com.google.android.gms:play-services-ads-api@@24.5.0 */
/* loaded from: classes5.dex */
public abstract class zzbps extends zzayu implements zzbpt {
    public zzbps() {
        super("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
    }

    @Override // com.google.android.gms.internal.ads.zzayu
    protected final boolean zzde(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        zzbpw zzbpuVar;
        zzbpw zzbpuVar2;
        zzbpw zzbpuVar3;
        zzbpw zzbpuVar4;
        zzbpw zzbpuVar5;
        zzbpw zzbpuVar6;
        zzbpw zzbpuVar7;
        zzbpw zzbpuVar8;
        zzbpw zzbpwVar = null;
        switch (i) {
            case 1:
                IObjectWrapper asInterface = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                com.google.android.gms.ads.internal.client.zzr zzrVar = (com.google.android.gms.ads.internal.client.zzr) zzayv.zza(parcel, com.google.android.gms.ads.internal.client.zzr.CREATOR);
                com.google.android.gms.ads.internal.client.zzm zzmVar = (com.google.android.gms.ads.internal.client.zzm) zzayv.zza(parcel, com.google.android.gms.ads.internal.client.zzm.CREATOR);
                String readString = parcel.readString();
                IBinder readStrongBinder = parcel.readStrongBinder();
                if (readStrongBinder == null) {
                    zzbpuVar = null;
                } else {
                    IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapterListener");
                    zzbpuVar = queryLocalInterface instanceof zzbpw ? (zzbpw) queryLocalInterface : new zzbpu(readStrongBinder);
                }
                zzayv.zzd(parcel);
                zzu(asInterface, zzrVar, zzmVar, readString, zzbpuVar);
                parcel2.writeNoException();
                return true;
            case 2:
                IObjectWrapper zzn = zzn();
                parcel2.writeNoException();
                zzayv.zzg(parcel2, zzn);
                return true;
            case 3:
                IObjectWrapper asInterface2 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                com.google.android.gms.ads.internal.client.zzm zzmVar2 = (com.google.android.gms.ads.internal.client.zzm) zzayv.zza(parcel, com.google.android.gms.ads.internal.client.zzm.CREATOR);
                String readString2 = parcel.readString();
                IBinder readStrongBinder2 = parcel.readStrongBinder();
                if (readStrongBinder2 == null) {
                    zzbpuVar2 = null;
                } else {
                    IInterface queryLocalInterface2 = readStrongBinder2.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapterListener");
                    zzbpuVar2 = queryLocalInterface2 instanceof zzbpw ? (zzbpw) queryLocalInterface2 : new zzbpu(readStrongBinder2);
                }
                zzayv.zzd(parcel);
                zzx(asInterface2, zzmVar2, readString2, zzbpuVar2);
                parcel2.writeNoException();
                return true;
            case 4:
                zzI();
                parcel2.writeNoException();
                return true;
            case 5:
                zzo();
                parcel2.writeNoException();
                return true;
            case 6:
                IObjectWrapper asInterface3 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                com.google.android.gms.ads.internal.client.zzr zzrVar2 = (com.google.android.gms.ads.internal.client.zzr) zzayv.zza(parcel, com.google.android.gms.ads.internal.client.zzr.CREATOR);
                com.google.android.gms.ads.internal.client.zzm zzmVar3 = (com.google.android.gms.ads.internal.client.zzm) zzayv.zza(parcel, com.google.android.gms.ads.internal.client.zzm.CREATOR);
                String readString3 = parcel.readString();
                String readString4 = parcel.readString();
                IBinder readStrongBinder3 = parcel.readStrongBinder();
                if (readStrongBinder3 == null) {
                    zzbpuVar3 = null;
                } else {
                    IInterface queryLocalInterface3 = readStrongBinder3.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapterListener");
                    zzbpuVar3 = queryLocalInterface3 instanceof zzbpw ? (zzbpw) queryLocalInterface3 : new zzbpu(readStrongBinder3);
                }
                zzayv.zzd(parcel);
                zzv(asInterface3, zzrVar2, zzmVar3, readString3, readString4, zzbpuVar3);
                parcel2.writeNoException();
                return true;
            case 7:
                IObjectWrapper asInterface4 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                com.google.android.gms.ads.internal.client.zzm zzmVar4 = (com.google.android.gms.ads.internal.client.zzm) zzayv.zza(parcel, com.google.android.gms.ads.internal.client.zzm.CREATOR);
                String readString5 = parcel.readString();
                String readString6 = parcel.readString();
                IBinder readStrongBinder4 = parcel.readStrongBinder();
                if (readStrongBinder4 == null) {
                    zzbpuVar4 = null;
                } else {
                    IInterface queryLocalInterface4 = readStrongBinder4.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapterListener");
                    zzbpuVar4 = queryLocalInterface4 instanceof zzbpw ? (zzbpw) queryLocalInterface4 : new zzbpu(readStrongBinder4);
                }
                zzayv.zzd(parcel);
                zzy(asInterface4, zzmVar4, readString5, readString6, zzbpuVar4);
                parcel2.writeNoException();
                return true;
            case 8:
                zzE();
                parcel2.writeNoException();
                return true;
            case 9:
                zzF();
                parcel2.writeNoException();
                return true;
            case 10:
                IObjectWrapper asInterface5 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                com.google.android.gms.ads.internal.client.zzm zzmVar5 = (com.google.android.gms.ads.internal.client.zzm) zzayv.zza(parcel, com.google.android.gms.ads.internal.client.zzm.CREATOR);
                String readString7 = parcel.readString();
                zzbwn zzb = zzbwm.zzb(parcel.readStrongBinder());
                String readString8 = parcel.readString();
                zzayv.zzd(parcel);
                zzp(asInterface5, zzmVar5, readString7, zzb, readString8);
                parcel2.writeNoException();
                return true;
            case 11:
                com.google.android.gms.ads.internal.client.zzm zzmVar6 = (com.google.android.gms.ads.internal.client.zzm) zzayv.zza(parcel, com.google.android.gms.ads.internal.client.zzm.CREATOR);
                String readString9 = parcel.readString();
                zzayv.zzd(parcel);
                zzs(zzmVar6, readString9);
                parcel2.writeNoException();
                return true;
            case 12:
                zzL();
                parcel2.writeNoException();
                return true;
            case 13:
                boolean zzN = zzN();
                parcel2.writeNoException();
                int i3 = zzayv.zza;
                parcel2.writeInt(zzN ? 1 : 0);
                return true;
            case 14:
                IObjectWrapper asInterface6 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                com.google.android.gms.ads.internal.client.zzm zzmVar7 = (com.google.android.gms.ads.internal.client.zzm) zzayv.zza(parcel, com.google.android.gms.ads.internal.client.zzm.CREATOR);
                String readString10 = parcel.readString();
                String readString11 = parcel.readString();
                IBinder readStrongBinder5 = parcel.readStrongBinder();
                if (readStrongBinder5 == null) {
                    zzbpuVar5 = null;
                } else {
                    IInterface queryLocalInterface5 = readStrongBinder5.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapterListener");
                    zzbpuVar5 = queryLocalInterface5 instanceof zzbpw ? (zzbpw) queryLocalInterface5 : new zzbpu(readStrongBinder5);
                }
                zzbge zzbgeVar = (zzbge) zzayv.zza(parcel, zzbge.CREATOR);
                ArrayList<String> createStringArrayList = parcel.createStringArrayList();
                zzayv.zzd(parcel);
                zzz(asInterface6, zzmVar7, readString10, readString11, zzbpuVar5, zzbgeVar, createStringArrayList);
                parcel2.writeNoException();
                return true;
            case 15:
                parcel2.writeNoException();
                zzayv.zzg(parcel2, null);
                return true;
            case 16:
                parcel2.writeNoException();
                zzayv.zzg(parcel2, null);
                return true;
            case 17:
                Bundle zze = zze();
                parcel2.writeNoException();
                zzayv.zzf(parcel2, zze);
                return true;
            case 18:
                Bundle zzf = zzf();
                parcel2.writeNoException();
                zzayv.zzf(parcel2, zzf);
                return true;
            case 19:
                Bundle zzg = zzg();
                parcel2.writeNoException();
                zzayv.zzf(parcel2, zzg);
                return true;
            case 20:
                com.google.android.gms.ads.internal.client.zzm zzmVar8 = (com.google.android.gms.ads.internal.client.zzm) zzayv.zza(parcel, com.google.android.gms.ads.internal.client.zzm.CREATOR);
                String readString12 = parcel.readString();
                String readString13 = parcel.readString();
                zzayv.zzd(parcel);
                zzB(zzmVar8, readString12, readString13);
                parcel2.writeNoException();
                return true;
            case 21:
                IObjectWrapper asInterface7 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                zzayv.zzd(parcel);
                zzD(asInterface7);
                parcel2.writeNoException();
                return true;
            case 22:
                parcel2.writeNoException();
                int i4 = zzayv.zza;
                parcel2.writeInt(0);
                return true;
            case 23:
                IObjectWrapper asInterface8 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                zzbwn zzb2 = zzbwm.zzb(parcel.readStrongBinder());
                ArrayList<String> createStringArrayList2 = parcel.createStringArrayList();
                zzayv.zzd(parcel);
                zzr(asInterface8, zzb2, createStringArrayList2);
                parcel2.writeNoException();
                return true;
            case 24:
                zzbhj zzi = zzi();
                parcel2.writeNoException();
                zzayv.zzg(parcel2, zzi);
                return true;
            case 25:
                boolean zzh = zzayv.zzh(parcel);
                zzayv.zzd(parcel);
                zzG(zzh);
                parcel2.writeNoException();
                return true;
            case 26:
                com.google.android.gms.ads.internal.client.zzed zzh2 = zzh();
                parcel2.writeNoException();
                zzayv.zzg(parcel2, zzh2);
                return true;
            case 27:
                zzbqf zzk = zzk();
                parcel2.writeNoException();
                zzayv.zzg(parcel2, zzk);
                return true;
            case 28:
                IObjectWrapper asInterface9 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                com.google.android.gms.ads.internal.client.zzm zzmVar9 = (com.google.android.gms.ads.internal.client.zzm) zzayv.zza(parcel, com.google.android.gms.ads.internal.client.zzm.CREATOR);
                String readString14 = parcel.readString();
                IBinder readStrongBinder6 = parcel.readStrongBinder();
                if (readStrongBinder6 == null) {
                    zzbpuVar6 = null;
                } else {
                    IInterface queryLocalInterface6 = readStrongBinder6.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapterListener");
                    zzbpuVar6 = queryLocalInterface6 instanceof zzbpw ? (zzbpw) queryLocalInterface6 : new zzbpu(readStrongBinder6);
                }
                zzayv.zzd(parcel);
                zzA(asInterface9, zzmVar9, readString14, zzbpuVar6);
                parcel2.writeNoException();
                return true;
            case 29:
            default:
                return false;
            case 30:
                IObjectWrapper asInterface10 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                zzayv.zzd(parcel);
                zzK(asInterface10);
                parcel2.writeNoException();
                return true;
            case 31:
                IObjectWrapper asInterface11 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                zzbmh zzb3 = zzbmg.zzb(parcel.readStrongBinder());
                ArrayList createTypedArrayList = parcel.createTypedArrayList(zzbmn.CREATOR);
                zzayv.zzd(parcel);
                zzq(asInterface11, zzb3, createTypedArrayList);
                parcel2.writeNoException();
                return true;
            case 32:
                IObjectWrapper asInterface12 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                com.google.android.gms.ads.internal.client.zzm zzmVar10 = (com.google.android.gms.ads.internal.client.zzm) zzayv.zza(parcel, com.google.android.gms.ads.internal.client.zzm.CREATOR);
                String readString15 = parcel.readString();
                IBinder readStrongBinder7 = parcel.readStrongBinder();
                if (readStrongBinder7 == null) {
                    zzbpuVar7 = null;
                } else {
                    IInterface queryLocalInterface7 = readStrongBinder7.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapterListener");
                    zzbpuVar7 = queryLocalInterface7 instanceof zzbpw ? (zzbpw) queryLocalInterface7 : new zzbpu(readStrongBinder7);
                }
                zzayv.zzd(parcel);
                zzC(asInterface12, zzmVar10, readString15, zzbpuVar7);
                parcel2.writeNoException();
                return true;
            case 33:
                zzbse zzl = zzl();
                parcel2.writeNoException();
                zzayv.zzf(parcel2, zzl);
                return true;
            case 34:
                zzbse zzm = zzm();
                parcel2.writeNoException();
                zzayv.zzf(parcel2, zzm);
                return true;
            case 35:
                IObjectWrapper asInterface13 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                com.google.android.gms.ads.internal.client.zzr zzrVar3 = (com.google.android.gms.ads.internal.client.zzr) zzayv.zza(parcel, com.google.android.gms.ads.internal.client.zzr.CREATOR);
                com.google.android.gms.ads.internal.client.zzm zzmVar11 = (com.google.android.gms.ads.internal.client.zzm) zzayv.zza(parcel, com.google.android.gms.ads.internal.client.zzm.CREATOR);
                String readString16 = parcel.readString();
                String readString17 = parcel.readString();
                IBinder readStrongBinder8 = parcel.readStrongBinder();
                if (readStrongBinder8 == null) {
                    zzbpuVar8 = null;
                } else {
                    IInterface queryLocalInterface8 = readStrongBinder8.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapterListener");
                    zzbpuVar8 = queryLocalInterface8 instanceof zzbpw ? (zzbpw) queryLocalInterface8 : new zzbpu(readStrongBinder8);
                }
                zzayv.zzd(parcel);
                zzw(asInterface13, zzrVar3, zzmVar11, readString16, readString17, zzbpuVar8);
                parcel2.writeNoException();
                return true;
            case 36:
                zzbpz zzj = zzj();
                parcel2.writeNoException();
                zzayv.zzg(parcel2, zzj);
                return true;
            case 37:
                IObjectWrapper asInterface14 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                zzayv.zzd(parcel);
                zzJ(asInterface14);
                parcel2.writeNoException();
                return true;
            case 38:
                IObjectWrapper asInterface15 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                com.google.android.gms.ads.internal.client.zzm zzmVar12 = (com.google.android.gms.ads.internal.client.zzm) zzayv.zza(parcel, com.google.android.gms.ads.internal.client.zzm.CREATOR);
                String readString18 = parcel.readString();
                IBinder readStrongBinder9 = parcel.readStrongBinder();
                if (readStrongBinder9 != null) {
                    IInterface queryLocalInterface9 = readStrongBinder9.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapterListener");
                    zzbpwVar = queryLocalInterface9 instanceof zzbpw ? (zzbpw) queryLocalInterface9 : new zzbpu(readStrongBinder9);
                }
                zzayv.zzd(parcel);
                zzt(asInterface15, zzmVar12, readString18, zzbpwVar);
                parcel2.writeNoException();
                return true;
            case 39:
                IObjectWrapper asInterface16 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                zzayv.zzd(parcel);
                zzH(asInterface16);
                parcel2.writeNoException();
                return true;
        }
    }
}
