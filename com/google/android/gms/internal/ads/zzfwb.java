package com.google.android.gms.internal.ads;

import java.util.Iterator;
import java.util.Objects;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* compiled from: com.google.android.gms:play-services-ads-api@@24.5.0 */
/* loaded from: classes5.dex */
final class zzfwb implements Iterable {
    final /* synthetic */ CharSequence zza;
    final /* synthetic */ zzfwe zzb;

    zzfwb(zzfwe zzfweVar, CharSequence charSequence) {
        this.zza = charSequence;
        Objects.requireNonNull(zzfweVar);
        this.zzb = zzfweVar;
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        Iterator zzg;
        zzg = this.zzb.zzg(this.zza);
        return zzg;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(AbstractJsonLexerKt.BEGIN_LIST);
        zzfvh.zzb(sb, this, ", ");
        sb.append(AbstractJsonLexerKt.END_LIST);
        return sb.toString();
    }
}
