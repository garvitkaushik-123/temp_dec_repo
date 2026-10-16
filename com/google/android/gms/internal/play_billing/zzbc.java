package com.google.android.gms.internal.play_billing;

import java.util.Arrays;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* compiled from: com.android.billingclient:billing@@8.0.0 */
/* loaded from: classes5.dex */
public final class zzbc {
    private final String zza;
    private final zzbb zzb;
    private zzbb zzc;

    public final String toString() {
        StringBuilder sb = new StringBuilder(32);
        sb.append(this.zza);
        sb.append(AbstractJsonLexerKt.BEGIN_OBJ);
        zzbb zzbbVar = this.zzb.zzb;
        String str = "";
        while (zzbbVar != null) {
            Object obj = zzbbVar.zza;
            sb.append(str);
            if (obj == null || !obj.getClass().isArray()) {
                sb.append(obj);
            } else {
                sb.append((CharSequence) Arrays.deepToString(new Object[]{obj}), 1, r2.length() - 1);
            }
            zzbbVar = zzbbVar.zzb;
            str = ", ";
        }
        sb.append(AbstractJsonLexerKt.END_OBJ);
        return sb.toString();
    }

    public final zzbc zza(Object obj) {
        zzbb zzbbVar = new zzbb();
        this.zzc.zzb = zzbbVar;
        this.zzc = zzbbVar;
        zzbbVar.zza = obj;
        return this;
    }

    /* synthetic */ zzbc(String str, zzbd zzbdVar) {
        zzbb zzbbVar = new zzbb();
        this.zzb = zzbbVar;
        this.zzc = zzbbVar;
        str.getClass();
        this.zza = str;
    }
}
