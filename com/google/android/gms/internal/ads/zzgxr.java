package com.google.android.gms.internal.ads;

import java.util.NoSuchElementException;
import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-ads-api@@24.5.0 */
/* loaded from: classes5.dex */
final class zzgxr extends zzgxs {
    final /* synthetic */ zzgxz zza;
    private int zzb;
    private final int zzc;

    zzgxr(zzgxz zzgxzVar) {
        Objects.requireNonNull(zzgxzVar);
        this.zza = zzgxzVar;
        this.zzb = 0;
        this.zzc = zzgxzVar.zzd();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.zzb < this.zzc;
    }

    @Override // com.google.android.gms.internal.ads.zzgxu
    public final byte zza() {
        int i = this.zzb;
        if (i >= this.zzc) {
            throw new NoSuchElementException();
        }
        this.zzb = i + 1;
        return this.zza.zzb(i);
    }
}
