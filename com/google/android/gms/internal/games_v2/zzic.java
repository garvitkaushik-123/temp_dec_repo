package com.google.android.gms.internal.games_v2;

import java.util.Iterator;

/* compiled from: com.google.android.gms:play-services-games-v2@@21.0.0 */
/* loaded from: classes5.dex */
final class zzic extends zzhk {
    private final transient zzhg zza;
    private final transient zzhd zzb;

    zzic(zzhg zzhgVar, zzhd zzhdVar) {
        this.zza = zzhgVar;
        this.zzb = zzhdVar;
    }

    @Override // com.google.android.gms.internal.games_v2.zzgy, java.util.AbstractCollection, java.util.Collection
    public final boolean contains(Object obj) {
        return this.zza.get(obj) != null;
    }

    @Override // com.google.android.gms.internal.games_v2.zzhk, com.google.android.gms.internal.games_v2.zzgy, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final /* synthetic */ Iterator iterator() {
        return this.zzb.listIterator(0);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return this.zza.size();
    }

    @Override // com.google.android.gms.internal.games_v2.zzhk, com.google.android.gms.internal.games_v2.zzgy
    /* renamed from: zza */
    public final zzil iterator() {
        return this.zzb.listIterator(0);
    }

    @Override // com.google.android.gms.internal.games_v2.zzgy
    final int zze(Object[] objArr, int i) {
        return this.zzb.zze(objArr, 0);
    }
}
