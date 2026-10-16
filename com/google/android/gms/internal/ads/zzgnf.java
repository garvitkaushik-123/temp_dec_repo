package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.HashMap;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzgnf {
    private HashMap zza = new HashMap();

    public final zzgnh zza() {
        if (this.zza == null) {
            throw new IllegalStateException("cannot call build() twice");
        }
        zzgnh zzgnhVar = new zzgnh(Collections.unmodifiableMap(this.zza), null);
        this.zza = null;
        return zzgnhVar;
    }
}
