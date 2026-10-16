package com.google.android.gms.internal.ads;

import android.media.MediaCodec;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zztl extends Exception {
    public final String zza;
    public final boolean zzb;
    public final zzti zzc;
    public final String zzd;

    public zztl(zzz zzzVar, Throwable th, boolean z, int i) {
        this("Decoder init failed: [" + i + "], " + zzzVar.toString(), th, zzzVar.zzo, false, null, "androidx.media3.exoplayer.mediacodec.MediaCodecRenderer_neg_" + Math.abs(i), null);
    }

    static /* bridge */ /* synthetic */ zztl zza(zztl zztlVar, zztl zztlVar2) {
        return new zztl(zztlVar.getMessage(), zztlVar.getCause(), zztlVar.zza, false, zztlVar.zzc, zztlVar.zzd, zztlVar2);
    }

    public zztl(zzz zzzVar, Throwable th, boolean z, zzti zztiVar) {
        this("Decoder init failed: " + zztiVar.zza + ", " + zzzVar.toString(), th, zzzVar.zzo, false, zztiVar, th instanceof MediaCodec.CodecException ? ((MediaCodec.CodecException) th).getDiagnosticInfo() : null, null);
    }

    private zztl(String str, Throwable th, String str2, boolean z, zzti zztiVar, String str3, zztl zztlVar) {
        super(str, th);
        this.zza = str2;
        this.zzb = false;
        this.zzc = zztiVar;
        this.zzd = str3;
    }
}
