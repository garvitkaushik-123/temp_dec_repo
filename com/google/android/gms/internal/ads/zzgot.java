package com.google.android.gms.internal.ads;

import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
final class zzgot {
    private final Class zza;
    private final Class zzb;

    /* synthetic */ zzgot(Class cls, Class cls2, zzgou zzgouVar) {
        this.zza = cls;
        this.zzb = cls2;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzgot)) {
            return false;
        }
        zzgot zzgotVar = (zzgot) obj;
        return zzgotVar.zza.equals(this.zza) && zzgotVar.zzb.equals(this.zzb);
    }

    public final int hashCode() {
        return Objects.hash(this.zza, this.zzb);
    }

    public final String toString() {
        Class cls = this.zzb;
        return this.zza.getSimpleName() + " with primitive type: " + cls.getSimpleName();
    }
}
