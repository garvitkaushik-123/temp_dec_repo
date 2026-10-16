package com.google.android.gms.internal.ads;

import java.util.Iterator;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
final class zzgaf extends zzfyv {
    private final transient zzfyt zza;
    private final transient zzfyq zzb;

    zzgaf(zzfyt zzfytVar, zzfyq zzfyqVar) {
        this.zza = zzfytVar;
        this.zzb = zzfyqVar;
    }

    @Override // com.google.android.gms.internal.ads.zzfyl, java.util.AbstractCollection, java.util.Collection
    public final boolean contains(Object obj) {
        return this.zza.get(obj) != null;
    }

    @Override // com.google.android.gms.internal.ads.zzfyv, com.google.android.gms.internal.ads.zzfyl, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final /* synthetic */ Iterator iterator() {
        return this.zzb.listIterator(0);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return this.zza.size();
    }

    @Override // com.google.android.gms.internal.ads.zzfyl
    final int zza(Object[] objArr, int i) {
        return this.zzb.zza(objArr, i);
    }

    @Override // com.google.android.gms.internal.ads.zzfyv, com.google.android.gms.internal.ads.zzfyl
    public final zzfyq zzd() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzfyv, com.google.android.gms.internal.ads.zzfyl
    /* renamed from: zze */
    public final zzgaw iterator() {
        return this.zzb.listIterator(0);
    }

    @Override // com.google.android.gms.internal.ads.zzfyl
    final boolean zzf() {
        return true;
    }
}
