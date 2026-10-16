package com.google.android.gms.internal.ads;

import android.content.Context;
import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.os.Build;
import android.os.Trace;
import android.view.Surface;
import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzsx implements zztd {
    private final Context zza;

    @Deprecated
    public zzsx() {
        this.zza = null;
    }

    public zzsx(Context context, zzfwh zzfwhVar, zzfwh zzfwhVar2) {
        this.zza = context;
    }

    @Override // com.google.android.gms.internal.ads.zztd
    public final zztf zzd(zztc zztcVar) throws IOException {
        Context context;
        zzti zztiVar;
        MediaCodec createByCodecName;
        if (Build.VERSION.SDK_INT >= 31 || ((context = this.zza) != null && context.getPackageManager().hasSystemFeature("com.amazon.hardware.tv_screen"))) {
            int zzb = zzay.zzb(zztcVar.zzc.zzo);
            zzea.zze("DMCodecAdapterFactory", "Creating an asynchronous MediaCodec adapter for track type ".concat(zzex.zzD(zzb)));
            return new zzsn(zzb).zzc(zztcVar);
        }
        MediaCodec mediaCodec = null;
        try {
            zztiVar = zztcVar.zza;
            String str = zztiVar.zza;
            Trace.beginSection("createCodec:".concat(str));
            createByCodecName = MediaCodec.createByCodecName(str);
            Trace.endSection();
        } catch (IOException e) {
            e = e;
        } catch (RuntimeException e2) {
            e = e2;
        }
        try {
            Trace.beginSection("configureCodec");
            Surface surface = zztcVar.zzd;
            int i = 0;
            if (surface == null && zztiVar.zzh && Build.VERSION.SDK_INT >= 35) {
                i = 8;
            }
            createByCodecName.configure(zztcVar.zzb, surface, (MediaCrypto) null, i);
            Trace.endSection();
            Trace.beginSection("startCodec");
            createByCodecName.start();
            Trace.endSection();
            return new zzue(createByCodecName, zztcVar.zzf, null);
        } catch (IOException | RuntimeException e3) {
            e = e3;
            mediaCodec = createByCodecName;
            if (mediaCodec != null) {
                mediaCodec.release();
            }
            throw e;
        }
    }
}
