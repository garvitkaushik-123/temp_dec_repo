package com.google.android.gms.internal.games_v2;

import com.ironsource.C3040d4;
import java.util.Iterator;

/* compiled from: com.google.android.gms:play-services-games-v2@@21.0.0 */
/* loaded from: classes5.dex */
final class zzii extends zzhk {
    final transient Object zza;

    zzii(Object obj) {
        obj.getClass();
        this.zza = obj;
    }

    @Override // com.google.android.gms.internal.games_v2.zzgy, java.util.AbstractCollection, java.util.Collection
    public final boolean contains(Object obj) {
        return this.zza.equals(obj);
    }

    @Override // com.google.android.gms.internal.games_v2.zzhk, java.util.Collection, java.util.Set
    public final int hashCode() {
        return this.zza.hashCode();
    }

    @Override // com.google.android.gms.internal.games_v2.zzhk, com.google.android.gms.internal.games_v2.zzgy, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final /* synthetic */ Iterator iterator() {
        return new zzho(this.zza);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return 1;
    }

    @Override // java.util.AbstractCollection
    public final String toString() {
        String obj = this.zza.toString();
        StringBuilder sb = new StringBuilder(String.valueOf(obj).length() + 2);
        sb.append(C3040d4.i.d);
        sb.append(obj);
        sb.append(C3040d4.i.e);
        return sb.toString();
    }

    @Override // com.google.android.gms.internal.games_v2.zzhk, com.google.android.gms.internal.games_v2.zzgy
    /* renamed from: zza */
    public final zzil iterator() {
        return new zzho(this.zza);
    }

    @Override // com.google.android.gms.internal.games_v2.zzgy
    final int zze(Object[] objArr, int i) {
        objArr[0] = this.zza;
        return 1;
    }
}
