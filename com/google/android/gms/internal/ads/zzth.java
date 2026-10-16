package com.google.android.gms.internal.ads;

import android.media.MediaCodec;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public class zzth extends zzhq {
    public final int zza;

    public zzth(Throwable th, zzti zztiVar) {
        super("Decoder failed: ".concat(String.valueOf(zztiVar == null ? null : zztiVar.zza)), th);
        int i;
        if (th instanceof MediaCodec.CodecException) {
            MediaCodec.CodecException codecException = (MediaCodec.CodecException) th;
            codecException.getDiagnosticInfo();
            i = codecException.getErrorCode();
        } else {
            i = 0;
        }
        this.zza = i;
    }
}
