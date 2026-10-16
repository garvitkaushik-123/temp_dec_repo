package com.google.android.gms.nearby.connection;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

/* compiled from: com.google.android.gms:play-services-nearby@@18.5.0 */
@Deprecated
/* loaded from: classes5.dex */
public final class AppIdentifier extends AbstractSafeParcelable {
    public static final Parcelable.Creator<AppIdentifier> CREATOR = new zzc();
    private final String zza;

    public AppIdentifier(String str) {
        this.zza = Preconditions.checkNotEmpty(str, "Missing application identifier value");
    }

    public String getIdentifier() {
        return this.zza;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, getIdentifier(), false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
