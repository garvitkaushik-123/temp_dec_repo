package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads-api@@24.5.0 */
/* loaded from: classes5.dex */
public abstract class zzbro extends zzayu implements zzbrp {
    public zzbro() {
        super("com.google.android.gms.ads.internal.mediation.client.rtb.IRtbAdapter");
    }

    public static zzbrp zzb(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.rtb.IRtbAdapter");
        return queryLocalInterface instanceof zzbrp ? (zzbrp) queryLocalInterface : new zzbrn(iBinder);
    }

    @Override // com.google.android.gms.internal.ads.zzayu
    protected final boolean zzde(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        zzbrs zzbrsVar = null;
        zzbra zzbraVar = null;
        zzbrj zzbrjVar = null;
        zzbrd zzbrdVar = null;
        zzbrm zzbrkVar = null;
        zzbrj zzbrjVar2 = null;
        zzbrm zzbrkVar2 = null;
        zzbrg zzbrgVar = null;
        zzbrd zzbrdVar2 = null;
        if (i == 1) {
            IObjectWrapper asInterface = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
            String readString = parcel.readString();
            Bundle bundle = (Bundle) zzayv.zza(parcel, Bundle.CREATOR);
            Bundle bundle2 = (Bundle) zzayv.zza(parcel, Bundle.CREATOR);
            com.google.android.gms.ads.internal.client.zzr zzrVar = (com.google.android.gms.ads.internal.client.zzr) zzayv.zza(parcel, com.google.android.gms.ads.internal.client.zzr.CREATOR);
            IBinder readStrongBinder = parcel.readStrongBinder();
            if (readStrongBinder != null) {
                IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.rtb.ISignalsCallback");
                zzbrsVar = queryLocalInterface instanceof zzbrs ? (zzbrs) queryLocalInterface : new zzbrq(readStrongBinder);
            }
            zzayv.zzd(parcel);
            zzh(asInterface, readString, bundle, bundle2, zzrVar, zzbrsVar);
            parcel2.writeNoException();
        } else if (i == 2) {
            zzbse zzf = zzf();
            parcel2.writeNoException();
            zzayv.zzf(parcel2, zzf);
        } else if (i == 3) {
            zzbse zzg = zzg();
            parcel2.writeNoException();
            zzayv.zzf(parcel2, zzg);
        } else if (i == 5) {
            com.google.android.gms.ads.internal.client.zzed zze = zze();
            parcel2.writeNoException();
            zzayv.zzg(parcel2, zze);
        } else if (i == 10) {
            IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
            zzayv.zzd(parcel);
            parcel2.writeNoException();
        } else if (i != 11) {
            switch (i) {
                case 13:
                    String readString2 = parcel.readString();
                    String readString3 = parcel.readString();
                    com.google.android.gms.ads.internal.client.zzm zzmVar = (com.google.android.gms.ads.internal.client.zzm) zzayv.zza(parcel, com.google.android.gms.ads.internal.client.zzm.CREATOR);
                    IObjectWrapper asInterface2 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                    IBinder readStrongBinder2 = parcel.readStrongBinder();
                    if (readStrongBinder2 != null) {
                        IInterface queryLocalInterface2 = readStrongBinder2.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.rtb.IBannerCallback");
                        zzbrdVar2 = queryLocalInterface2 instanceof zzbrd ? (zzbrd) queryLocalInterface2 : new zzbrb(readStrongBinder2);
                    }
                    zzbpw zzb = zzbpv.zzb(parcel.readStrongBinder());
                    com.google.android.gms.ads.internal.client.zzr zzrVar2 = (com.google.android.gms.ads.internal.client.zzr) zzayv.zza(parcel, com.google.android.gms.ads.internal.client.zzr.CREATOR);
                    zzayv.zzd(parcel);
                    zzj(readString2, readString3, zzmVar, asInterface2, zzbrdVar2, zzb, zzrVar2);
                    parcel2.writeNoException();
                    break;
                case 14:
                    String readString4 = parcel.readString();
                    String readString5 = parcel.readString();
                    com.google.android.gms.ads.internal.client.zzm zzmVar2 = (com.google.android.gms.ads.internal.client.zzm) zzayv.zza(parcel, com.google.android.gms.ads.internal.client.zzm.CREATOR);
                    IObjectWrapper asInterface3 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                    IBinder readStrongBinder3 = parcel.readStrongBinder();
                    if (readStrongBinder3 != null) {
                        IInterface queryLocalInterface3 = readStrongBinder3.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.rtb.IInterstitialCallback");
                        zzbrgVar = queryLocalInterface3 instanceof zzbrg ? (zzbrg) queryLocalInterface3 : new zzbre(readStrongBinder3);
                    }
                    zzbpw zzb2 = zzbpv.zzb(parcel.readStrongBinder());
                    zzayv.zzd(parcel);
                    zzl(readString4, readString5, zzmVar2, asInterface3, zzbrgVar, zzb2);
                    parcel2.writeNoException();
                    break;
                case 15:
                    IObjectWrapper asInterface4 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                    zzayv.zzd(parcel);
                    boolean zzs = zzs(asInterface4);
                    parcel2.writeNoException();
                    parcel2.writeInt(zzs ? 1 : 0);
                    break;
                case 16:
                    String readString6 = parcel.readString();
                    String readString7 = parcel.readString();
                    com.google.android.gms.ads.internal.client.zzm zzmVar3 = (com.google.android.gms.ads.internal.client.zzm) zzayv.zza(parcel, com.google.android.gms.ads.internal.client.zzm.CREATOR);
                    IObjectWrapper asInterface5 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                    IBinder readStrongBinder4 = parcel.readStrongBinder();
                    if (readStrongBinder4 != null) {
                        IInterface queryLocalInterface4 = readStrongBinder4.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.rtb.IRewardedCallback");
                        zzbrkVar2 = queryLocalInterface4 instanceof zzbrm ? (zzbrm) queryLocalInterface4 : new zzbrk(readStrongBinder4);
                    }
                    zzbrm zzbrmVar = zzbrkVar2;
                    zzbpw zzb3 = zzbpv.zzb(parcel.readStrongBinder());
                    zzayv.zzd(parcel);
                    zzp(readString6, readString7, zzmVar3, asInterface5, zzbrmVar, zzb3);
                    parcel2.writeNoException();
                    break;
                case 17:
                    IObjectWrapper asInterface6 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                    zzayv.zzd(parcel);
                    boolean zzt = zzt(asInterface6);
                    parcel2.writeNoException();
                    parcel2.writeInt(zzt ? 1 : 0);
                    break;
                case 18:
                    String readString8 = parcel.readString();
                    String readString9 = parcel.readString();
                    com.google.android.gms.ads.internal.client.zzm zzmVar4 = (com.google.android.gms.ads.internal.client.zzm) zzayv.zza(parcel, com.google.android.gms.ads.internal.client.zzm.CREATOR);
                    IObjectWrapper asInterface7 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                    IBinder readStrongBinder5 = parcel.readStrongBinder();
                    if (readStrongBinder5 != null) {
                        IInterface queryLocalInterface5 = readStrongBinder5.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.rtb.INativeCallback");
                        zzbrjVar2 = queryLocalInterface5 instanceof zzbrj ? (zzbrj) queryLocalInterface5 : new zzbrh(readStrongBinder5);
                    }
                    zzbpw zzb4 = zzbpv.zzb(parcel.readStrongBinder());
                    zzayv.zzd(parcel);
                    zzm(readString8, readString9, zzmVar4, asInterface7, zzbrjVar2, zzb4);
                    parcel2.writeNoException();
                    break;
                case 19:
                    String readString10 = parcel.readString();
                    zzayv.zzd(parcel);
                    zzq(readString10);
                    parcel2.writeNoException();
                    break;
                case 20:
                    String readString11 = parcel.readString();
                    String readString12 = parcel.readString();
                    com.google.android.gms.ads.internal.client.zzm zzmVar5 = (com.google.android.gms.ads.internal.client.zzm) zzayv.zza(parcel, com.google.android.gms.ads.internal.client.zzm.CREATOR);
                    IObjectWrapper asInterface8 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                    IBinder readStrongBinder6 = parcel.readStrongBinder();
                    if (readStrongBinder6 != null) {
                        IInterface queryLocalInterface6 = readStrongBinder6.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.rtb.IRewardedCallback");
                        zzbrkVar = queryLocalInterface6 instanceof zzbrm ? (zzbrm) queryLocalInterface6 : new zzbrk(readStrongBinder6);
                    }
                    zzbrm zzbrmVar2 = zzbrkVar;
                    zzbpw zzb5 = zzbpv.zzb(parcel.readStrongBinder());
                    zzayv.zzd(parcel);
                    zzo(readString11, readString12, zzmVar5, asInterface8, zzbrmVar2, zzb5);
                    parcel2.writeNoException();
                    break;
                case 21:
                    String readString13 = parcel.readString();
                    String readString14 = parcel.readString();
                    com.google.android.gms.ads.internal.client.zzm zzmVar6 = (com.google.android.gms.ads.internal.client.zzm) zzayv.zza(parcel, com.google.android.gms.ads.internal.client.zzm.CREATOR);
                    IObjectWrapper asInterface9 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                    IBinder readStrongBinder7 = parcel.readStrongBinder();
                    if (readStrongBinder7 != null) {
                        IInterface queryLocalInterface7 = readStrongBinder7.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.rtb.IBannerCallback");
                        zzbrdVar = queryLocalInterface7 instanceof zzbrd ? (zzbrd) queryLocalInterface7 : new zzbrb(readStrongBinder7);
                    }
                    zzbpw zzb6 = zzbpv.zzb(parcel.readStrongBinder());
                    com.google.android.gms.ads.internal.client.zzr zzrVar3 = (com.google.android.gms.ads.internal.client.zzr) zzayv.zza(parcel, com.google.android.gms.ads.internal.client.zzr.CREATOR);
                    zzayv.zzd(parcel);
                    zzk(readString13, readString14, zzmVar6, asInterface9, zzbrdVar, zzb6, zzrVar3);
                    parcel2.writeNoException();
                    break;
                case 22:
                    String readString15 = parcel.readString();
                    String readString16 = parcel.readString();
                    com.google.android.gms.ads.internal.client.zzm zzmVar7 = (com.google.android.gms.ads.internal.client.zzm) zzayv.zza(parcel, com.google.android.gms.ads.internal.client.zzm.CREATOR);
                    IObjectWrapper asInterface10 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                    IBinder readStrongBinder8 = parcel.readStrongBinder();
                    if (readStrongBinder8 != null) {
                        IInterface queryLocalInterface8 = readStrongBinder8.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.rtb.INativeCallback");
                        zzbrjVar = queryLocalInterface8 instanceof zzbrj ? (zzbrj) queryLocalInterface8 : new zzbrh(readStrongBinder8);
                    }
                    zzbpw zzb7 = zzbpv.zzb(parcel.readStrongBinder());
                    zzbge zzbgeVar = (zzbge) zzayv.zza(parcel, zzbge.CREATOR);
                    zzayv.zzd(parcel);
                    zzn(readString15, readString16, zzmVar7, asInterface10, zzbrjVar, zzb7, zzbgeVar);
                    parcel2.writeNoException();
                    break;
                case 23:
                    String readString17 = parcel.readString();
                    String readString18 = parcel.readString();
                    com.google.android.gms.ads.internal.client.zzm zzmVar8 = (com.google.android.gms.ads.internal.client.zzm) zzayv.zza(parcel, com.google.android.gms.ads.internal.client.zzm.CREATOR);
                    IObjectWrapper asInterface11 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                    IBinder readStrongBinder9 = parcel.readStrongBinder();
                    if (readStrongBinder9 != null) {
                        IInterface queryLocalInterface9 = readStrongBinder9.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.rtb.IAppOpenCallback");
                        zzbraVar = queryLocalInterface9 instanceof zzbra ? (zzbra) queryLocalInterface9 : new zzbqy(readStrongBinder9);
                    }
                    zzbpw zzb8 = zzbpv.zzb(parcel.readStrongBinder());
                    zzayv.zzd(parcel);
                    zzi(readString17, readString18, zzmVar8, asInterface11, zzbraVar, zzb8);
                    parcel2.writeNoException();
                    break;
                case 24:
                    IObjectWrapper asInterface12 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                    zzayv.zzd(parcel);
                    boolean zzr = zzr(asInterface12);
                    parcel2.writeNoException();
                    parcel2.writeInt(zzr ? 1 : 0);
                    break;
                default:
                    return false;
            }
        } else {
            parcel.createStringArray();
            zzayv.zzd(parcel);
            parcel2.writeNoException();
        }
        return true;
    }
}
