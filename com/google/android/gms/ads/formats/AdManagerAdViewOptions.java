package com.google.android.gms.ads.formats;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

/* compiled from: com.google.android.gms:play-services-ads-api@@24.5.0 */
/* loaded from: classes4.dex */
public final class AdManagerAdViewOptions extends AbstractSafeParcelable {
    public static final Parcelable.Creator<AdManagerAdViewOptions> CREATOR = new zzc();
    private final boolean zza;

    /* compiled from: com.google.android.gms:play-services-ads-api@@24.5.0 */
    public static final class Builder {
        private boolean zza = false;

        public AdManagerAdViewOptions build() {
            return new AdManagerAdViewOptions(this, null);
        }

        public Builder setManualImpressionsEnabled(boolean z) {
            this.zza = z;
            return this;
        }
    }

    /* synthetic */ AdManagerAdViewOptions(Builder builder, zzb zzbVar) {
        this.zza = builder.zza;
    }

    public boolean getManualImpressionsEnabled() {
        return this.zza;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeBoolean(parcel, 1, getManualImpressionsEnabled());
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    AdManagerAdViewOptions(boolean z) {
        this.zza = z;
    }
}
