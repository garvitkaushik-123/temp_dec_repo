package com.google.android.gms.ads.internal.client;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.ads.formats.AdManagerAdViewOptions;
import com.google.android.gms.ads.formats.PublisherAdViewOptions;
import com.google.android.gms.internal.ads.zzayu;
import com.google.android.gms.internal.ads.zzayv;
import com.google.android.gms.internal.ads.zzbge;
import com.google.android.gms.internal.ads.zzbhm;
import com.google.android.gms.internal.ads.zzbhn;
import com.google.android.gms.internal.ads.zzbhp;
import com.google.android.gms.internal.ads.zzbhq;
import com.google.android.gms.internal.ads.zzbhs;
import com.google.android.gms.internal.ads.zzbht;
import com.google.android.gms.internal.ads.zzbhv;
import com.google.android.gms.internal.ads.zzbhw;
import com.google.android.gms.internal.ads.zzbhz;
import com.google.android.gms.internal.ads.zzbia;
import com.google.android.gms.internal.ads.zzbic;
import com.google.android.gms.internal.ads.zzbid;
import com.google.android.gms.internal.ads.zzbmp;
import com.google.android.gms.internal.ads.zzbmx;
import com.google.android.gms.internal.ads.zzbmy;

/* compiled from: com.google.android.gms:play-services-ads-api@@24.5.0 */
/* loaded from: classes4.dex */
public abstract class zzbs extends zzayu implements zzbt {
    public zzbs() {
        super("com.google.android.gms.ads.internal.client.IAdLoaderBuilder");
    }

    @Override // com.google.android.gms.internal.ads.zzayu
    protected final boolean zzde(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        zzbk zzbkVar = null;
        zzcs zzcsVar = null;
        switch (i) {
            case 1:
                zzbq zze = zze();
                parcel2.writeNoException();
                zzayv.zzg(parcel2, zze);
                return true;
            case 2:
                IBinder readStrongBinder = parcel.readStrongBinder();
                if (readStrongBinder != null) {
                    IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdListener");
                    zzbkVar = queryLocalInterface instanceof zzbk ? (zzbk) queryLocalInterface : new zzbi(readStrongBinder);
                }
                zzayv.zzd(parcel);
                zzl(zzbkVar);
                parcel2.writeNoException();
                return true;
            case 3:
                zzbhn zzb = zzbhm.zzb(parcel.readStrongBinder());
                zzayv.zzd(parcel);
                zzf(zzb);
                parcel2.writeNoException();
                return true;
            case 4:
                zzbhq zzb2 = zzbhp.zzb(parcel.readStrongBinder());
                zzayv.zzd(parcel);
                zzg(zzb2);
                parcel2.writeNoException();
                return true;
            case 5:
                String readString = parcel.readString();
                zzbhw zzb3 = zzbhv.zzb(parcel.readStrongBinder());
                zzbht zzb4 = zzbhs.zzb(parcel.readStrongBinder());
                zzayv.zzd(parcel);
                zzh(readString, zzb3, zzb4);
                parcel2.writeNoException();
                return true;
            case 6:
                zzbge zzbgeVar = (zzbge) zzayv.zza(parcel, zzbge.CREATOR);
                zzayv.zzd(parcel);
                zzo(zzbgeVar);
                parcel2.writeNoException();
                return true;
            case 7:
                IBinder readStrongBinder2 = parcel.readStrongBinder();
                if (readStrongBinder2 != null) {
                    IInterface queryLocalInterface2 = readStrongBinder2.queryLocalInterface("com.google.android.gms.ads.internal.client.ICorrelationIdProvider");
                    zzcsVar = queryLocalInterface2 instanceof zzcs ? (zzcs) queryLocalInterface2 : new zzcs(readStrongBinder2);
                }
                zzayv.zzd(parcel);
                zzq(zzcsVar);
                parcel2.writeNoException();
                return true;
            case 8:
                zzbia zzb5 = zzbhz.zzb(parcel.readStrongBinder());
                zzr zzrVar = (zzr) zzayv.zza(parcel, zzr.CREATOR);
                zzayv.zzd(parcel);
                zzj(zzb5, zzrVar);
                parcel2.writeNoException();
                return true;
            case 9:
                PublisherAdViewOptions publisherAdViewOptions = (PublisherAdViewOptions) zzayv.zza(parcel, PublisherAdViewOptions.CREATOR);
                zzayv.zzd(parcel);
                zzp(publisherAdViewOptions);
                parcel2.writeNoException();
                return true;
            case 10:
                zzbid zzb6 = zzbic.zzb(parcel.readStrongBinder());
                zzayv.zzd(parcel);
                zzk(zzb6);
                parcel2.writeNoException();
                return true;
            case 11:
            case 12:
            default:
                return false;
            case 13:
                zzbmp zzbmpVar = (zzbmp) zzayv.zza(parcel, zzbmp.CREATOR);
                zzayv.zzd(parcel);
                zzn(zzbmpVar);
                parcel2.writeNoException();
                return true;
            case 14:
                zzbmy zzb7 = zzbmx.zzb(parcel.readStrongBinder());
                zzayv.zzd(parcel);
                zzi(zzb7);
                parcel2.writeNoException();
                return true;
            case 15:
                AdManagerAdViewOptions adManagerAdViewOptions = (AdManagerAdViewOptions) zzayv.zza(parcel, AdManagerAdViewOptions.CREATOR);
                zzayv.zzd(parcel);
                zzm(adManagerAdViewOptions);
                parcel2.writeNoException();
                return true;
        }
    }
}
