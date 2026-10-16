package com.google.android.gms.internal.ads;

import androidx.concurrent.futures.AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0;
import java.util.Set;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
final class zzgcp extends zzgco {
    private static final AtomicReferenceFieldUpdater zza = AtomicReferenceFieldUpdater.newUpdater(zzgcs.class, Set.class, "seenExceptionsField");
    private static final AtomicIntegerFieldUpdater zzb = AtomicIntegerFieldUpdater.newUpdater(zzgcs.class, "remainingField");

    private zzgcp() {
        throw null;
    }

    /* synthetic */ zzgcp(zzgcr zzgcrVar) {
        super(null);
    }

    @Override // com.google.android.gms.internal.ads.zzgco
    final int zza(zzgcs zzgcsVar) {
        return zzb.decrementAndGet(zzgcsVar);
    }

    @Override // com.google.android.gms.internal.ads.zzgco
    final void zzb(zzgcs zzgcsVar, Set set, Set set2) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = zza;
        while (!AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.m(atomicReferenceFieldUpdater, zzgcsVar, null, set2) && atomicReferenceFieldUpdater.get(zzgcsVar) == null) {
        }
    }
}
