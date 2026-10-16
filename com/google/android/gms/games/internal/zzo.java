package com.google.android.gms.games.internal;

import com.google.android.gms.games.GamesStatusUtils;
import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.android.gms:play-services-games-v2@@21.0.0 */
/* loaded from: classes4.dex */
final class zzo extends zza {
    private final TaskCompletionSource zza;

    zzo(TaskCompletionSource taskCompletionSource) {
        this.zza = taskCompletionSource;
    }

    @Override // com.google.android.gms.games.internal.zza, com.google.android.gms.games.internal.zzaj
    public final void zzd(int i, String str) {
        if (i == 0 || i == 3003) {
            this.zza.setResult(null);
        } else {
            GamesStatusUtils.zzb(this.zza, i);
        }
    }
}
