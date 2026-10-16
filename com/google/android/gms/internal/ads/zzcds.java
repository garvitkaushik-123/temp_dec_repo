package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
final class zzcds {
    private final ArrayList zza = new ArrayList();
    private long zzb;

    zzcds() {
    }

    final long zza() {
        Iterator it = this.zza.iterator();
        while (it.hasNext()) {
            for (Map.Entry entry : ((zzgw) it.next()).zze().entrySet()) {
                try {
                    if ("content-length".equalsIgnoreCase((String) entry.getKey())) {
                        this.zzb = Math.max(this.zzb, Long.parseLong((String) ((List) entry.getValue()).get(0)));
                    }
                } catch (RuntimeException unused) {
                }
            }
            it.remove();
        }
        return this.zzb;
    }

    final void zzb(zzgw zzgwVar) {
        this.zza.add(zzgwVar);
    }
}
