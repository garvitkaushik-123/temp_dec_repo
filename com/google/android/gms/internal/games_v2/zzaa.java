package com.google.android.gms.internal.games_v2;

import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-games-v2@@21.0.0 */
/* loaded from: classes5.dex */
final class zzaa implements Runnable {
    final /* synthetic */ zzab zza;

    zzaa(zzab zzabVar) {
        Objects.requireNonNull(zzabVar);
        this.zza = zzabVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zza.zzd();
    }
}
