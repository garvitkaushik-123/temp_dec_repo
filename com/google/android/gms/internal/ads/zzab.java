package com.google.android.gms.internal.ads;

import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzab {
    public final String zza;
    public final String zzb;

    static {
        String str = zzex.zza;
        Integer.toString(0, 36);
        Integer.toString(1, 36);
    }

    public zzab(String str, String str2) {
        this.zza = zzex.zzE(str);
        this.zzb = str2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            zzab zzabVar = (zzab) obj;
            if (Objects.equals(this.zza, zzabVar.zza) && Objects.equals(this.zzb, zzabVar.zzb)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int hashCode = this.zzb.hashCode() * 31;
        String str = this.zza;
        return hashCode + (str != null ? str.hashCode() : 0);
    }
}
