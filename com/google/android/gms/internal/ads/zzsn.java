package com.google.android.gms.internal.ads;

import android.media.MediaCodec;
import android.os.Build;
import android.os.HandlerThread;
import android.os.Trace;
import android.view.Surface;
import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzsn implements zztd {
    private final zzfwh zza;
    private final zzfwh zzb;

    public zzsn(int i) {
        zzsl zzslVar = new zzsl(i);
        zzsm zzsmVar = new zzsm(i);
        this.zza = zzslVar;
        this.zzb = zzsmVar;
    }

    static /* synthetic */ HandlerThread zza(int i) {
        String zzt;
        zzt = zzsp.zzt(i, "ExoPlayer:MediaCodecAsyncAdapter:");
        return new HandlerThread(zzt);
    }

    static /* synthetic */ HandlerThread zzb(int i) {
        String zzt;
        zzt = zzsp.zzt(i, "ExoPlayer:MediaCodecQueueingThread:");
        return new HandlerThread(zzt);
    }

    public final zzsp zzc(zztc zztcVar) throws IOException {
        Exception exc;
        MediaCodec mediaCodec;
        zzsp zzspVar;
        zzti zztiVar = zztcVar.zza;
        String str = zztiVar.zza;
        zzsp zzspVar2 = null;
        try {
            Trace.beginSection("createCodec:" + str);
            mediaCodec = MediaCodec.createByCodecName(str);
            try {
                HandlerThread zzb = zzb(((zzsm) this.zzb).zza);
                HandlerThread handlerThread = zzb;
                zzst zzstVar = new zzst(mediaCodec, zzb);
                HandlerThread zza = zza(((zzsl) this.zza).zza);
                HandlerThread handlerThread2 = zza;
                zzspVar = new zzsp(mediaCodec, zza, zzstVar, zztcVar.zzf, null);
            } catch (Exception e) {
                exc = e;
            }
            try {
                Trace.endSection();
                Surface surface = zztcVar.zzd;
                int i = 0;
                if (surface == null && zztiVar.zzh && Build.VERSION.SDK_INT >= 35) {
                    i = 8;
                }
                zzsp.zzh(zzspVar, zztcVar.zzb, surface, null, i);
                return zzspVar;
            } catch (Exception e2) {
                exc = e2;
                zzspVar2 = zzspVar;
                if (zzspVar2 != null) {
                    zzspVar2.zzm();
                    throw exc;
                }
                if (mediaCodec == null) {
                    throw exc;
                }
                mediaCodec.release();
                throw exc;
            }
        } catch (Exception e3) {
            exc = e3;
            mediaCodec = null;
        }
    }

    @Override // com.google.android.gms.internal.ads.zztd
    public final /* bridge */ /* synthetic */ zztf zzd(zztc zztcVar) throws IOException {
        throw null;
    }
}
