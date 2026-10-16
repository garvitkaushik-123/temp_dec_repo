package com.google.android.gms.internal.ads;

import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
final class zzgmd implements zzgmf {
    private final AtomicBoolean zza = new AtomicBoolean(false);

    zzgmd(boolean z) {
    }

    @Override // com.google.android.gms.internal.ads.zzgmf
    public final boolean zza() {
        return this.zza.get();
    }
}
