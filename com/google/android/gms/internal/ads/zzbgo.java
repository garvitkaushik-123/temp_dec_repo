package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads-api@@24.5.0 */
/* loaded from: classes5.dex */
public abstract class zzbgo extends zzayu implements zzbgp {
    public zzbgo() {
        super("com.google.android.gms.ads.internal.formats.client.INativeAdImage");
    }

    public static zzbgp zzh(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.INativeAdImage");
        return queryLocalInterface instanceof zzbgp ? (zzbgp) queryLocalInterface : new zzbgn(iBinder);
    }

    @Override // com.google.android.gms.internal.ads.zzayu
    protected final boolean zzde(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        switch (i) {
            case 1:
                IObjectWrapper zzf = zzf();
                parcel2.writeNoException();
                zzayv.zzg(parcel2, zzf);
                return true;
            case 2:
                Uri zze = zze();
                parcel2.writeNoException();
                zzayv.zzf(parcel2, zze);
                return true;
            case 3:
                double zzb = zzb();
                parcel2.writeNoException();
                parcel2.writeDouble(zzb);
                return true;
            case 4:
                int zzd = zzd();
                parcel2.writeNoException();
                parcel2.writeInt(zzd);
                return true;
            case 5:
                int zzc = zzc();
                parcel2.writeNoException();
                parcel2.writeInt(zzc);
                return true;
            case 6:
                Map zzg = zzg();
                parcel2.writeNoException();
                parcel2.writeMap(zzg);
                return true;
            default:
                return false;
        }
    }
}
