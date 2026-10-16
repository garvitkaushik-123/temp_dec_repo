package com.google.android.gms.ads.formats;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.ads.internal.client.zzcn;
import com.google.android.gms.ads.internal.client.zzco;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

/* compiled from: com.google.android.gms:play-services-ads-api@@24.5.0 */
@Deprecated
/* loaded from: classes4.dex */
public final class PublisherAdViewOptions extends AbstractSafeParcelable {
    public static final Parcelable.Creator<PublisherAdViewOptions> CREATOR = new zzh();
    private final boolean zza;
    private final zzco zzb;
    private final IBinder zzc;

    /* compiled from: com.google.android.gms:play-services-ads-api@@24.5.0 */
    @Deprecated
    public static final class Builder {
        public Builder setShouldDelayBannerRenderingListener(ShouldDelayBannerRenderingListener shouldDelayBannerRenderingListener) {
            return this;
        }
    }

    PublisherAdViewOptions(boolean z, IBinder iBinder, IBinder iBinder2) {
        this.zza = z;
        this.zzb = iBinder != null ? zzcn.zzd(iBinder) : null;
        this.zzc = iBinder2;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeBoolean(parcel, 1, this.zza);
        zzco zzcoVar = this.zzb;
        SafeParcelWriter.writeIBinder(parcel, 2, zzcoVar == null ? null : zzcoVar.asBinder(), false);
        SafeParcelWriter.writeIBinder(parcel, 3, this.zzc, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public final zzco zza() {
        return this.zzb;
    }

    public final boolean zzb() {
        return this.zza;
    }
}
