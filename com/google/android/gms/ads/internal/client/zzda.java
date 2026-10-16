package com.google.android.gms.ads.internal.client;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.ads.zzayu;
import com.google.android.gms.internal.ads.zzayv;
import com.google.android.gms.internal.ads.zzbmj;
import com.google.android.gms.internal.ads.zzbmk;
import com.google.android.gms.internal.ads.zzbpp;
import com.google.android.gms.internal.ads.zzbpq;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads-api@@24.5.0 */
/* loaded from: classes4.dex */
public abstract class zzda extends zzayu implements zzdb {
    public zzda() {
        super("com.google.android.gms.ads.internal.client.IMobileAdsSettingManager");
    }

    @Override // com.google.android.gms.internal.ads.zzayu
    protected final boolean zzde(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        zzdn zzdlVar;
        switch (i) {
            case 1:
                zzk();
                parcel2.writeNoException();
                return true;
            case 2:
                float readFloat = parcel.readFloat();
                zzayv.zzd(parcel);
                zzq(readFloat);
                parcel2.writeNoException();
                return true;
            case 3:
                String readString = parcel.readString();
                zzayv.zzd(parcel);
                zzr(readString);
                parcel2.writeNoException();
                return true;
            case 4:
                boolean zzh = zzayv.zzh(parcel);
                zzayv.zzd(parcel);
                zzp(zzh);
                parcel2.writeNoException();
                return true;
            case 5:
                IObjectWrapper asInterface = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                String readString2 = parcel.readString();
                zzayv.zzd(parcel);
                zzn(asInterface, readString2);
                parcel2.writeNoException();
                return true;
            case 6:
                String readString3 = parcel.readString();
                IObjectWrapper asInterface2 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                zzayv.zzd(parcel);
                zzl(readString3, asInterface2);
                parcel2.writeNoException();
                return true;
            case 7:
                float zze = zze();
                parcel2.writeNoException();
                parcel2.writeFloat(zze);
                return true;
            case 8:
                boolean zzv = zzv();
                parcel2.writeNoException();
                int i3 = zzayv.zza;
                parcel2.writeInt(zzv ? 1 : 0);
                return true;
            case 9:
                String zzf = zzf();
                parcel2.writeNoException();
                parcel2.writeString(zzf);
                return true;
            case 10:
                String readString4 = parcel.readString();
                zzayv.zzd(parcel);
                zzh(readString4);
                parcel2.writeNoException();
                return true;
            case 11:
                zzbpq zzf2 = zzbpp.zzf(parcel.readStrongBinder());
                zzayv.zzd(parcel);
                zzo(zzf2);
                parcel2.writeNoException();
                return true;
            case 12:
                zzbmk zzc = zzbmj.zzc(parcel.readStrongBinder());
                zzayv.zzd(parcel);
                zzs(zzc);
                parcel2.writeNoException();
                return true;
            case 13:
                List zzg = zzg();
                parcel2.writeNoException();
                parcel2.writeTypedList(zzg);
                return true;
            case 14:
                zzfx zzfxVar = (zzfx) zzayv.zza(parcel, zzfx.CREATOR);
                zzayv.zzd(parcel);
                zzu(zzfxVar);
                parcel2.writeNoException();
                return true;
            case 15:
                zzi();
                parcel2.writeNoException();
                return true;
            case 16:
                IBinder readStrongBinder = parcel.readStrongBinder();
                if (readStrongBinder == null) {
                    zzdlVar = null;
                } else {
                    IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IOnAdInspectorClosedListener");
                    zzdlVar = queryLocalInterface instanceof zzdn ? (zzdn) queryLocalInterface : new zzdl(readStrongBinder);
                }
                zzayv.zzd(parcel);
                zzm(zzdlVar);
                parcel2.writeNoException();
                return true;
            case 17:
                boolean zzh2 = zzayv.zzh(parcel);
                zzayv.zzd(parcel);
                zzj(zzh2);
                parcel2.writeNoException();
                return true;
            case 18:
                String readString5 = parcel.readString();
                zzayv.zzd(parcel);
                zzt(readString5);
                parcel2.writeNoException();
                return true;
            default:
                return false;
        }
    }
}
