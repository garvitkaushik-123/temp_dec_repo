package com.google.android.gms.internal.ads;

import android.util.SparseBooleanArray;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzv {
    private final SparseBooleanArray zza;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzv) {
            return this.zza.equals(((zzv) obj).zza);
        }
        return false;
    }

    public final int zza(int i) {
        SparseBooleanArray sparseBooleanArray = this.zza;
        zzdd.zza(i, 0, sparseBooleanArray.size());
        return sparseBooleanArray.keyAt(i);
    }

    public final int zzb() {
        return this.zza.size();
    }

    public final boolean zzc(int i) {
        return this.zza.get(i);
    }

    public final int hashCode() {
        return this.zza.hashCode();
    }
}
