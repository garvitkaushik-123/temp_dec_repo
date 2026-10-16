package com.google.android.gms.internal.ads;

import android.media.MediaPlayer;
import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
final class zzcax implements Runnable {
    final /* synthetic */ MediaPlayer zza;
    final /* synthetic */ zzcbf zzb;

    zzcax(zzcbf zzcbfVar, MediaPlayer mediaPlayer) {
        this.zza = mediaPlayer;
        Objects.requireNonNull(zzcbfVar);
        this.zzb = zzcbfVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzcbg zzcbgVar;
        zzcbg zzcbgVar2;
        zzcbf zzcbfVar = this.zzb;
        zzcbf.zzm(zzcbfVar, this.zza);
        zzcbgVar = zzcbfVar.zzr;
        if (zzcbgVar != null) {
            zzcbgVar2 = zzcbfVar.zzr;
            zzcbgVar2.zzf();
        }
    }
}
