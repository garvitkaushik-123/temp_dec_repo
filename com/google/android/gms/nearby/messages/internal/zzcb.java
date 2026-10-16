package com.google.android.gms.nearby.messages.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

/* compiled from: com.google.android.gms:play-services-nearby@@18.5.0 */
/* loaded from: classes5.dex */
public final class zzcb extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzcb> CREATOR = new zzcc();
    final int zza;
    public final zzr zzb;
    public final zzy zzc;
    public boolean zzd;

    @Deprecated
    public String zze;

    @Deprecated
    public final ClientAppContext zzf;

    zzcb(int i, IBinder iBinder, IBinder iBinder2, boolean z, String str, ClientAppContext clientAppContext) {
        zzr zzpVar;
        zzy zzwVar;
        this.zza = i;
        if (iBinder == null) {
            zzpVar = null;
        } else {
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.nearby.messages.internal.INearbyMessagesCallback");
            zzpVar = queryLocalInterface instanceof zzr ? (zzr) queryLocalInterface : new zzp(iBinder);
        }
        this.zzb = zzpVar;
        if (iBinder2 == null) {
            zzwVar = null;
        } else {
            IInterface queryLocalInterface2 = iBinder2.queryLocalInterface("com.google.android.gms.nearby.messages.internal.IStatusCallback");
            zzwVar = queryLocalInterface2 instanceof zzy ? (zzy) queryLocalInterface2 : new zzw(iBinder2);
        }
        this.zzc = zzwVar;
        this.zzd = z;
        this.zze = str;
        this.zzf = ClientAppContext.zza(clientAppContext, null, str, false);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.zza);
        SafeParcelWriter.writeIBinder(parcel, 2, this.zzb.asBinder(), false);
        SafeParcelWriter.writeIBinder(parcel, 3, this.zzc.asBinder(), false);
        SafeParcelWriter.writeBoolean(parcel, 4, this.zzd);
        SafeParcelWriter.writeString(parcel, 5, this.zze, false);
        SafeParcelWriter.writeParcelable(parcel, 6, this.zzf, i, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public zzcb(IBinder iBinder, IBinder iBinder2) {
        this(1, iBinder, iBinder2, false, null, null);
    }
}
