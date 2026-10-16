package com.google.android.gms.nearby.messages.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

/* compiled from: com.google.android.gms:play-services-nearby@@18.5.0 */
/* loaded from: classes5.dex */
public final class zzce extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzce> CREATOR = new zzcf();
    final int zza;
    public final zzae zzb;
    public final zzr zzc;

    @Deprecated
    public final String zzd;

    @Deprecated
    public final String zze;

    @Deprecated
    public final boolean zzf;

    @Deprecated
    public final ClientAppContext zzg;

    zzce(int i, zzae zzaeVar, IBinder iBinder, String str, String str2, boolean z, ClientAppContext clientAppContext) {
        zzr zzpVar;
        this.zza = i;
        this.zzb = zzaeVar;
        if (iBinder == null) {
            zzpVar = null;
        } else {
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.nearby.messages.internal.INearbyMessagesCallback");
            zzpVar = queryLocalInterface instanceof zzr ? (zzr) queryLocalInterface : new zzp(iBinder);
        }
        this.zzc = zzpVar;
        this.zzd = str;
        this.zze = str2;
        this.zzf = z;
        this.zzg = ClientAppContext.zza(clientAppContext, str2, str, z);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.zza);
        SafeParcelWriter.writeParcelable(parcel, 2, this.zzb, i, false);
        SafeParcelWriter.writeIBinder(parcel, 3, this.zzc.asBinder(), false);
        SafeParcelWriter.writeString(parcel, 4, this.zzd, false);
        SafeParcelWriter.writeString(parcel, 5, this.zze, false);
        SafeParcelWriter.writeBoolean(parcel, 6, this.zzf);
        SafeParcelWriter.writeParcelable(parcel, 7, this.zzg, i, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
