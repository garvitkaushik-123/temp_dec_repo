package com.google.android.gms.nearby.messages.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

/* compiled from: com.google.android.gms:play-services-nearby@@18.5.0 */
@Deprecated
/* loaded from: classes5.dex */
public final class zzh extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzh> CREATOR = new zzi();
    final int zza;
    public final zzr zzb;

    @Deprecated
    public final String zzc;

    @Deprecated
    public final ClientAppContext zzd;

    zzh(int i, IBinder iBinder, String str, ClientAppContext clientAppContext) {
        zzr zzpVar;
        this.zza = i;
        if (iBinder == null) {
            zzpVar = null;
        } else {
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.nearby.messages.internal.INearbyMessagesCallback");
            zzpVar = queryLocalInterface instanceof zzr ? (zzr) queryLocalInterface : new zzp(iBinder);
        }
        this.zzb = zzpVar;
        this.zzc = str;
        this.zzd = ClientAppContext.zza(clientAppContext, null, str, false);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.zza);
        SafeParcelWriter.writeIBinder(parcel, 2, this.zzb.asBinder(), false);
        SafeParcelWriter.writeString(parcel, 3, this.zzc, false);
        SafeParcelWriter.writeParcelable(parcel, 4, this.zzd, i, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
