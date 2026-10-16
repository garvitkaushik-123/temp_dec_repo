package com.google.android.gms.internal.ads;

import android.util.SparseBooleanArray;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzt {
    private final SparseBooleanArray zza = new SparseBooleanArray();
    private boolean zzb;

    public final zzt zza(int i) {
        zzdd.zzf(!this.zzb);
        this.zza.append(i, true);
        return this;
    }

    public final zzv zzb() {
        zzdd.zzf(!this.zzb);
        this.zzb = true;
        return new zzv(this.zza, null);
    }
}
