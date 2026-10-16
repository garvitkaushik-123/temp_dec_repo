package com.google.android.gms.internal.ads;

import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
final class zzgcq extends zzgco {
    private zzgcq() {
        throw null;
    }

    /* synthetic */ zzgcq(zzgcr zzgcrVar) {
        super(null);
    }

    @Override // com.google.android.gms.internal.ads.zzgco
    final int zza(zzgcs zzgcsVar) {
        int i;
        synchronized (zzgcsVar) {
            i = zzgcsVar.remainingField - 1;
            zzgcsVar.remainingField = i;
        }
        return i;
    }

    @Override // com.google.android.gms.internal.ads.zzgco
    final void zzb(zzgcs zzgcsVar, Set set, Set set2) {
        synchronized (zzgcsVar) {
            if (zzgcsVar.seenExceptionsField == null) {
                zzgcsVar.seenExceptionsField = set2;
            }
        }
    }
}
