package com.google.android.gms.internal.ads;

import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
final class zztz implements zztx {
    private final int zza;
    private MediaCodecInfo[] zzb;

    public zztz(boolean z, boolean z2, boolean z3) {
        int i = 1;
        if (!z && !z2 && !z3) {
            i = 0;
        }
        this.zza = i;
    }

    @EnsuresNonNull({"mediaCodecInfos"})
    private final void zzf() {
        if (this.zzb == null) {
            this.zzb = new MediaCodecList(this.zza).getCodecInfos();
        }
    }

    @Override // com.google.android.gms.internal.ads.zztx
    public final int zza() {
        zzf();
        return this.zzb.length;
    }

    @Override // com.google.android.gms.internal.ads.zztx
    public final MediaCodecInfo zzb(int i) {
        zzf();
        return this.zzb[i];
    }

    @Override // com.google.android.gms.internal.ads.zztx
    public final boolean zzc(String str, String str2, MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return codecCapabilities.isFeatureRequired(str);
    }

    @Override // com.google.android.gms.internal.ads.zztx
    public final boolean zzd(String str, String str2, MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return codecCapabilities.isFeatureSupported(str);
    }

    @Override // com.google.android.gms.internal.ads.zztx
    public final boolean zze() {
        return true;
    }
}
