package com.google.android.gms.internal.ads;

import android.os.HandlerThread;
import android.os.Looper;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzlt {
    private final Object zza;
    private Looper zzb;
    private HandlerThread zzc;
    private int zzd;

    public zzlt() {
        throw null;
    }

    public zzlt(Looper looper) {
        this.zza = new Object();
        this.zzb = null;
        this.zzc = null;
        this.zzd = 0;
    }

    public final Looper zza() {
        Looper looper;
        synchronized (this.zza) {
            if (this.zzb == null) {
                boolean z = false;
                if (this.zzd == 0 && this.zzc == null) {
                    z = true;
                }
                zzdd.zzf(z);
                HandlerThread handlerThread = new HandlerThread("ExoPlayer:Playback", -16);
                this.zzc = handlerThread;
                handlerThread.start();
                this.zzb = this.zzc.getLooper();
            }
            this.zzd++;
            looper = this.zzb;
        }
        return looper;
    }

    public final void zzb() {
        HandlerThread handlerThread;
        synchronized (this.zza) {
            zzdd.zzf(this.zzd > 0);
            int i = this.zzd - 1;
            this.zzd = i;
            if (i == 0 && (handlerThread = this.zzc) != null) {
                handlerThread.quit();
                this.zzc = null;
                this.zzb = null;
            }
        }
    }
}
