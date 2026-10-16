package com.google.android.gms.internal.ads;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzayl {
    private final Map zza = new HashMap();

    public final AtomicReference zza(String str) {
        synchronized (this) {
            Map map = this.zza;
            if (!map.containsKey(str)) {
                map.put(str, new AtomicReference());
            }
        }
        return (AtomicReference) this.zza.get(str);
    }
}
