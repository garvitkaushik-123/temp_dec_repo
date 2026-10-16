package com.google.android.gms.internal.ads;

import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzafa {
    public final int zza;
    public final byte[] zzb;
    public final int zzc;
    public final int zzd;

    public zzafa(int i, byte[] bArr, int i2, int i3) {
        this.zza = i;
        this.zzb = bArr;
        this.zzc = i2;
        this.zzd = i3;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            zzafa zzafaVar = (zzafa) obj;
            if (this.zza == zzafaVar.zza && this.zzc == zzafaVar.zzc && this.zzd == zzafaVar.zzd && Arrays.equals(this.zzb, zzafaVar.zzb)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return (((((this.zza * 31) + Arrays.hashCode(this.zzb)) * 31) + this.zzc) * 31) + this.zzd;
    }
}
