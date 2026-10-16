package com.google.android.gms.internal.nearby;

import com.ironsource.C3040d4;
import java.util.Iterator;
import javax.annotation.CheckForNull;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* compiled from: com.google.android.gms:play-services-nearby@@18.5.0 */
/* loaded from: classes5.dex */
final class zzsx extends zzss {
    final transient Object zza;

    zzsx(Object obj) {
        obj.getClass();
        this.zza = obj;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean contains(@CheckForNull Object obj) {
        return this.zza.equals(obj);
    }

    @Override // com.google.android.gms.internal.nearby.zzss, java.util.Collection, java.util.Set
    public final int hashCode() {
        return this.zza.hashCode();
    }

    @Override // com.google.android.gms.internal.nearby.zzss, com.google.android.gms.internal.nearby.zzsn, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final /* synthetic */ Iterator iterator() {
        return new zzst(this.zza);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return 1;
    }

    @Override // java.util.AbstractCollection
    public final String toString() {
        return C3040d4.i.d + this.zza.toString() + AbstractJsonLexerKt.END_LIST;
    }

    @Override // com.google.android.gms.internal.nearby.zzsn
    final int zza(Object[] objArr, int i) {
        objArr[0] = this.zza;
        return 1;
    }

    @Override // com.google.android.gms.internal.nearby.zzss, com.google.android.gms.internal.nearby.zzsn
    public final zzsq zzd() {
        return zzsq.zzm(this.zza);
    }

    @Override // com.google.android.gms.internal.nearby.zzss, com.google.android.gms.internal.nearby.zzsn
    /* renamed from: zze */
    public final zzsy iterator() {
        return new zzst(this.zza);
    }

    @Override // com.google.android.gms.internal.nearby.zzsn
    final boolean zzf() {
        throw null;
    }
}
