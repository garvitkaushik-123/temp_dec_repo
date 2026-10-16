package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzgcb;
import java.util.Collections;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.logging.Level;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
abstract class zzgcs extends zzgcb.zzf {
    private static final zzgco zzbg;
    private static final zzgdw zzbh = new zzgdw(zzgcs.class);
    volatile int remainingField;
    volatile Set<Throwable> seenExceptionsField = null;

    static {
        Throwable th;
        zzgco zzgcqVar;
        zzgcr zzgcrVar = null;
        try {
            zzgcqVar = new zzgcp(zzgcrVar);
            th = null;
        } catch (Throwable th2) {
            th = th2;
            zzgcqVar = new zzgcq(zzgcrVar);
        }
        zzbg = zzgcqVar;
        if (th != null) {
            zzbh.zza().logp(Level.SEVERE, "com.google.common.util.concurrent.AggregateFutureState", "<clinit>", "SafeAtomicHelper is broken!", th);
        }
    }

    zzgcs(int i) {
        this.remainingField = i;
    }

    final int zzB() {
        return zzbg.zza(this);
    }

    final Set zzC() {
        Set<Throwable> set = this.seenExceptionsField;
        if (set != null) {
            return set;
        }
        Set newSetFromMap = Collections.newSetFromMap(new ConcurrentHashMap());
        zzw(newSetFromMap);
        zzbg.zzb(this, null, newSetFromMap);
        return (Set) Objects.requireNonNull(this.seenExceptionsField);
    }

    abstract void zzw(Set set);
}
