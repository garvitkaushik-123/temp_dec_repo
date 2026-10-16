package com.google.android.gms.internal.ads;

import android.media.LoudnessCodecController;
import android.media.MediaCodec;
import java.util.HashSet;
import java.util.Iterator;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zztb {
    private final HashSet zza;
    private LoudnessCodecController zzb;

    public zztb() {
        throw null;
    }

    public zztb(zzta zztaVar) {
        this.zza = new HashSet();
    }

    public final void zza(MediaCodec mediaCodec) {
        LoudnessCodecController loudnessCodecController = this.zzb;
        if (loudnessCodecController == null || loudnessCodecController.addMediaCodec(mediaCodec)) {
            zzdd.zzf(this.zza.add(mediaCodec));
        }
    }

    public final void zzb() {
        this.zza.clear();
        LoudnessCodecController loudnessCodecController = this.zzb;
        if (loudnessCodecController != null) {
            loudnessCodecController.close();
        }
    }

    public final void zzc(MediaCodec mediaCodec) {
        LoudnessCodecController loudnessCodecController;
        if (!this.zza.remove(mediaCodec) || (loudnessCodecController = this.zzb) == null) {
            return;
        }
        loudnessCodecController.removeMediaCodec(mediaCodec);
    }

    public final void zzd(int i) {
        LoudnessCodecController loudnessCodecController = this.zzb;
        if (loudnessCodecController != null) {
            loudnessCodecController.close();
            this.zzb = null;
        }
        LoudnessCodecController create = LoudnessCodecController.create(i, zzgef.zzc(), new zzsy(this));
        this.zzb = create;
        Iterator it = this.zza.iterator();
        while (it.hasNext()) {
            if (!create.addMediaCodec((MediaCodec) it.next())) {
                it.remove();
            }
        }
    }
}
