package com.google.android.gms.internal.ads;

import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.view.Surface;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zztc {
    public final zzti zza;
    public final MediaFormat zzb;
    public final zzz zzc;
    public final Surface zzd;
    public final MediaCrypto zze = null;
    public final zztb zzf;

    private zztc(zzti zztiVar, MediaFormat mediaFormat, zzz zzzVar, Surface surface, MediaCrypto mediaCrypto, zztb zztbVar) {
        this.zza = zztiVar;
        this.zzb = mediaFormat;
        this.zzc = zzzVar;
        this.zzd = surface;
        this.zzf = zztbVar;
    }

    public static zztc zza(zzti zztiVar, MediaFormat mediaFormat, zzz zzzVar, MediaCrypto mediaCrypto, zztb zztbVar) {
        return new zztc(zztiVar, mediaFormat, zzzVar, null, null, zztbVar);
    }

    public static zztc zzb(zzti zztiVar, MediaFormat mediaFormat, zzz zzzVar, Surface surface, MediaCrypto mediaCrypto) {
        return new zztc(zztiVar, mediaFormat, zzzVar, surface, null, null);
    }
}
