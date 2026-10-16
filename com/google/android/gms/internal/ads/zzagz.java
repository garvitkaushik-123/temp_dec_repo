package com.google.android.gms.internal.ads;

import com.ironsource.mediationsdk.logger.IronSourceError;
import java.util.Arrays;
import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzagz extends zzahf {
    public final String zza;
    public final boolean zzb;
    public final boolean zzc;
    public final String[] zzd;
    private final zzahf[] zze;

    public zzagz(String str, boolean z, boolean z2, String[] strArr, zzahf[] zzahfVarArr) {
        super("CTOC");
        this.zza = str;
        this.zzb = z;
        this.zzc = z2;
        this.zzd = strArr;
        this.zze = zzahfVarArr;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            zzagz zzagzVar = (zzagz) obj;
            if (this.zzb == zzagzVar.zzb && this.zzc == zzagzVar.zzc && Objects.equals(this.zza, zzagzVar.zza) && Arrays.equals(this.zzd, zzagzVar.zzd) && Arrays.equals(this.zze, zzagzVar.zze)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return (((((this.zzb ? 1 : 0) + IronSourceError.ERROR_NON_EXISTENT_INSTANCE) * 31) + (this.zzc ? 1 : 0)) * 31) + this.zza.hashCode();
    }
}
