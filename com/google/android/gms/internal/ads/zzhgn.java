package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
abstract class zzhgn implements zzhgr {
    private final Map zza;

    zzhgn(Map map) {
        this.zza = Collections.unmodifiableMap(map);
    }

    final Map zza() {
        return this.zza;
    }
}
