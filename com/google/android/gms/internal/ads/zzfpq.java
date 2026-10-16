package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzfpq extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzfpq> CREATOR = new zzfpr();
    public final int zza;
    private zzatq zzb = null;
    private byte[] zzc;

    zzfpq(int i, byte[] bArr) {
        this.zza = i;
        this.zzc = bArr;
        zzb();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int i2 = this.zza;
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, i2);
        byte[] bArr = this.zzc;
        if (bArr == null) {
            bArr = this.zzb.zzaV();
        }
        SafeParcelWriter.writeByteArray(parcel, 2, bArr, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public final zzatq zza() {
        if (this.zzb == null) {
            try {
                this.zzb = zzatq.zzd(this.zzc, zzgyr.zza());
                this.zzc = null;
            } catch (zzgzw | NullPointerException e) {
                throw new IllegalStateException(e);
            }
        }
        zzb();
        return this.zzb;
    }

    private final void zzb() {
        zzatq zzatqVar = this.zzb;
        if (zzatqVar != null || this.zzc == null) {
            if (zzatqVar == null || this.zzc != null) {
                if (zzatqVar != null && this.zzc != null) {
                    throw new IllegalStateException("Invalid internal representation - full");
                }
                if (zzatqVar != null || this.zzc != null) {
                    throw new IllegalStateException("Impossible");
                }
                throw new IllegalStateException("Invalid internal representation - empty");
            }
        }
    }
}
