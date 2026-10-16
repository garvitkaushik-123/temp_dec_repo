package com.google.android.gms.internal.ads;

import android.content.Context;
import android.media.AudioFormat;
import android.media.AudioManager;
import android.media.Spatializer;
import android.os.Handler;
import android.os.Looper;
import io.bidmachine.media3.common.MimeTypes;
import java.util.Objects;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
final class zzym {
    private final Spatializer zza;
    private final boolean zzb;
    private final Handler zzc;
    private final Spatializer.OnSpatializerStateChangedListener zzd;

    public final void zza() {
        Spatializer.OnSpatializerStateChangedListener onSpatializerStateChangedListener;
        Handler handler;
        Spatializer spatializer = this.zza;
        if (spatializer == null || (onSpatializerStateChangedListener = this.zzd) == null || (handler = this.zzc) == null) {
            return;
        }
        spatializer.removeOnSpatializerStateChangedListener(onSpatializerStateChangedListener);
        handler.removeCallbacksAndMessages(null);
    }

    public final boolean zzb(zze zzeVar, zzz zzzVar) {
        int i;
        String str = zzzVar.zzo;
        if (Objects.equals(str, "audio/eac3-joc")) {
            i = zzzVar.zzG;
            if (i == 16) {
                i = 12;
            }
        } else if (Objects.equals(str, MimeTypes.AUDIO_IAMF)) {
            i = zzzVar.zzG;
            if (i == -1) {
                i = 6;
            }
        } else if (Objects.equals(str, "audio/ac4")) {
            i = zzzVar.zzG;
            if (i == 18 || i == 21) {
                i = 24;
            }
        } else {
            i = zzzVar.zzG;
        }
        int zzi = zzex.zzi(i);
        if (zzi == 0) {
            return false;
        }
        AudioFormat.Builder channelMask = new AudioFormat.Builder().setEncoding(2).setChannelMask(zzi);
        int i2 = zzzVar.zzH;
        if (i2 != -1) {
            channelMask.setSampleRate(i2);
        }
        Spatializer spatializer = this.zza;
        spatializer.getClass();
        return spatializer.canBeSpatialized(zzeVar.zza().zza, channelMask.build());
    }

    public final boolean zze() {
        return this.zzb;
    }

    public zzym(Context context, zzyu zzyuVar) {
        AudioManager zzc = context == null ? null : zzcj.zzc(context);
        if (zzc == null || zzex.zzN(context)) {
            this.zza = null;
            this.zzb = false;
            this.zzc = null;
            this.zzd = null;
            return;
        }
        Spatializer spatializer = zzc.getSpatializer();
        this.zza = spatializer;
        this.zzb = spatializer.getImmersiveAudioLevel() != 0;
        zzyl zzylVar = new zzyl(this, zzyuVar);
        this.zzd = zzylVar;
        Looper myLooper = Looper.myLooper();
        zzdd.zzb(myLooper);
        final Handler handler = new Handler(myLooper);
        this.zzc = handler;
        Objects.requireNonNull(handler);
        spatializer.addOnSpatializerStateChangedListener(new Executor() { // from class: com.google.android.gms.internal.ads.zzyk
            @Override // java.util.concurrent.Executor
            public final void execute(Runnable runnable) {
                handler.post(runnable);
            }
        }, zzylVar);
    }

    public final boolean zzc() {
        Spatializer spatializer = this.zza;
        spatializer.getClass();
        return spatializer.isAvailable();
    }

    public final boolean zzd() {
        Spatializer spatializer = this.zza;
        spatializer.getClass();
        return spatializer.isEnabled();
    }
}
