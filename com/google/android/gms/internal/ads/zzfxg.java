package com.google.android.gms.internal.ads;

import java.util.List;
import java.util.ListIterator;
import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
final class zzfxg extends zzfxe implements ListIterator {
    final /* synthetic */ zzfxh zzd;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzfxg(zzfxh zzfxhVar) {
        super(zzfxhVar);
        Objects.requireNonNull(zzfxhVar);
        this.zzd = zzfxhVar;
    }

    @Override // java.util.ListIterator
    public final void add(Object obj) {
        int i;
        zzfxh zzfxhVar = this.zzd;
        boolean isEmpty = zzfxhVar.isEmpty();
        zza();
        ((ListIterator) this.zza).add(obj);
        zzfxi zzfxiVar = zzfxhVar.zzf;
        i = zzfxiVar.zzb;
        zzfxiVar.zzb = i + 1;
        if (isEmpty) {
            zzfxhVar.zza();
        }
    }

    @Override // java.util.ListIterator
    public final boolean hasPrevious() {
        zza();
        return ((ListIterator) this.zza).hasPrevious();
    }

    @Override // java.util.ListIterator
    public final int nextIndex() {
        zza();
        return ((ListIterator) this.zza).nextIndex();
    }

    @Override // java.util.ListIterator
    public final Object previous() {
        zza();
        return ((ListIterator) this.zza).previous();
    }

    @Override // java.util.ListIterator
    public final int previousIndex() {
        zza();
        return ((ListIterator) this.zza).previousIndex();
    }

    @Override // java.util.ListIterator
    public final void set(Object obj) {
        zza();
        ((ListIterator) this.zza).set(obj);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzfxg(zzfxh zzfxhVar, int i) {
        super(zzfxhVar, ((List) zzfxhVar.zzb).listIterator(i));
        Objects.requireNonNull(zzfxhVar);
        this.zzd = zzfxhVar;
    }
}
