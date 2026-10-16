package com.google.android.gms.internal.ads;

import android.media.MediaCodec;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
final class zzhn {
    private final MediaCodec.CryptoInfo zza;
    private final MediaCodec.CryptoInfo.Pattern zzb = new MediaCodec.CryptoInfo.Pattern(0, 0);

    static /* bridge */ /* synthetic */ void zza(zzhn zzhnVar, int i, int i2) {
        MediaCodec.CryptoInfo.Pattern pattern = zzhnVar.zzb;
        pattern.set(i, i2);
        zzhnVar.zza.setPattern(pattern);
    }
}
