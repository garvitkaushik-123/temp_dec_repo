package com.google.android.gms.internal.ads;

import java.io.Serializable;
import java.util.List;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* compiled from: com.google.android.gms:play-services-ads-api@@24.5.0 */
/* loaded from: classes5.dex */
final class zzfvr implements Serializable, zzfvq {
    private final List zza;

    public final boolean equals(Object obj) {
        if (obj instanceof zzfvr) {
            return this.zza.equals(((zzfvr) obj).zza);
        }
        return false;
    }

    public final int hashCode() {
        return this.zza.hashCode() + 306654252;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("Predicates.and(");
        boolean z = true;
        for (Object obj : this.zza) {
            if (!z) {
                sb.append(AbstractJsonLexerKt.COMMA);
            }
            sb.append(obj);
            z = false;
        }
        sb.append(')');
        return sb.toString();
    }

    @Override // com.google.android.gms.internal.ads.zzfvq
    public final boolean zza(Object obj) {
        int i = 0;
        while (true) {
            List list = this.zza;
            if (i >= list.size()) {
                return true;
            }
            if (!((zzfvq) list.get(i)).zza(obj)) {
                return false;
            }
            i++;
        }
    }
}
