package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;
import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
final class zzflc implements Runnable {
    final /* synthetic */ zzfld zza;

    zzflc(zzfld zzfldVar) {
        Objects.requireNonNull(zzfldVar);
        this.zza = zzfldVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzfkl zzfklVar;
        zzfkl zzfklVar2;
        Clock clock;
        zzfkt zzfktVar;
        String zzD;
        zzfld zzfldVar = this.zza;
        zzfklVar = zzfldVar.zzp;
        if (zzfklVar != null) {
            zzfklVar2 = zzfldVar.zzp;
            clock = zzfldVar.zzq;
            long currentTimeMillis = clock.currentTimeMillis();
            zzfktVar = zzfldVar.zzr;
            int i = zzfldVar.zze.zzd;
            zzD = zzfldVar.zzD();
            zzfklVar2.zzj(currentTimeMillis, zzfktVar, i, zzD);
        }
    }
}
