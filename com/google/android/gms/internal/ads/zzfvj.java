package com.google.android.gms.internal.ads;

import java.util.Arrays;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* compiled from: com.google.android.gms:play-services-ads-api@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzfvj {
    private final String zza;
    private final zzfvi zzb;
    private zzfvi zzc;

    public final String toString() {
        StringBuilder sb = new StringBuilder(32);
        sb.append(this.zza);
        sb.append(AbstractJsonLexerKt.BEGIN_OBJ);
        zzfvi zzfviVar = this.zzb.zzb;
        String str = "";
        while (zzfviVar != null) {
            Object obj = zzfviVar.zza;
            sb.append(str);
            if (obj == null || !obj.getClass().isArray()) {
                sb.append(obj);
            } else {
                sb.append((CharSequence) Arrays.deepToString(new Object[]{obj}), 1, r2.length() - 1);
            }
            zzfviVar = zzfviVar.zzb;
            str = ", ";
        }
        sb.append(AbstractJsonLexerKt.END_OBJ);
        return sb.toString();
    }

    public final zzfvj zza(Object obj) {
        zzfvi zzfviVar = new zzfvi();
        this.zzc.zzb = zzfviVar;
        this.zzc = zzfviVar;
        zzfviVar.zza = obj;
        return this;
    }

    /* synthetic */ zzfvj(String str, zzfvk zzfvkVar) {
        zzfvi zzfviVar = new zzfvi();
        this.zzb = zzfviVar;
        this.zzc = zzfviVar;
        str.getClass();
        this.zza = str;
    }
}
