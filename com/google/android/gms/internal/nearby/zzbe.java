package com.google.android.gms.internal.nearby;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.nearby.exposurenotification.DailySummariesConfig;

/* compiled from: com.google.android.gms:play-services-nearby@@18.5.0 */
/* loaded from: classes5.dex */
public final class zzbe extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzbe> CREATOR = new zzbf();
    private zzcs zza;
    private DailySummariesConfig zzb;

    private zzbe() {
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzbe) {
            zzbe zzbeVar = (zzbe) obj;
            if (Objects.equal(this.zza, zzbeVar.zza) && Objects.equal(this.zzb, zzbeVar.zzb)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hashCode(this.zza, this.zzb);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeIBinder(parcel, 1, this.zza.asBinder(), false);
        SafeParcelWriter.writeParcelable(parcel, 2, this.zzb, i, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    zzbe(IBinder iBinder, DailySummariesConfig dailySummariesConfig) {
        zzcs zzcqVar;
        if (iBinder == null) {
            zzcqVar = null;
        } else {
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.nearby.exposurenotification.internal.IDailySummaryListCallback");
            zzcqVar = queryLocalInterface instanceof zzcs ? (zzcs) queryLocalInterface : new zzcq(iBinder);
        }
        this.zza = zzcqVar;
        this.zzb = dailySummariesConfig;
    }

    /* synthetic */ zzbe(zzbd zzbdVar) {
    }
}
