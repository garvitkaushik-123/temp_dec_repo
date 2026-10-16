package com.google.android.gms.internal.ads;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public class zzdbt {
    protected final Map zza = new HashMap();

    protected zzdbt(Set set) {
        zzp(set);
    }

    public final synchronized void zzk(zzddv zzddvVar) {
        zzo(zzddvVar.zza, zzddvVar.zzb);
    }

    public final synchronized void zzo(Object obj, Executor executor) {
        this.zza.put(obj, executor);
    }

    public final synchronized void zzp(Set set) {
        Iterator it = set.iterator();
        while (it.hasNext()) {
            zzk((zzddv) it.next());
        }
    }

    protected final synchronized void zzq(final zzdbs zzdbsVar) {
        for (Map.Entry entry : this.zza.entrySet()) {
            final Object key = entry.getKey();
            ((Executor) entry.getValue()).execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzdbr
                @Override // java.lang.Runnable
                public final void run() {
                    try {
                        zzdbs.this.zza(key);
                    } catch (Throwable th) {
                        com.google.android.gms.ads.internal.zzv.zzp().zzv(th, "EventEmitter.notify");
                        com.google.android.gms.ads.internal.util.zze.zzb("Event emitter exception.", th);
                    }
                }
            });
        }
    }
}
