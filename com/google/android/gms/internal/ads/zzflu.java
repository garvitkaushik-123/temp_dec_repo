package com.google.android.gms.internal.ads;

import java.util.Objects;
import java.util.Timer;
import java.util.TimerTask;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
final class zzflu extends TimerTask {
    final /* synthetic */ Timer zza;
    final /* synthetic */ zzflw zzb;
    final /* synthetic */ zzcfx zzc;

    zzflu(zzflw zzflwVar, zzcfx zzcfxVar, Timer timer) {
        this.zzc = zzcfxVar;
        this.zza = timer;
        Objects.requireNonNull(zzflwVar);
        this.zzb = zzflwVar;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public final void run() {
        this.zzb.zzh();
        zzcfy.zzaI(this.zzc.zza, true);
        this.zza.cancel();
    }
}
