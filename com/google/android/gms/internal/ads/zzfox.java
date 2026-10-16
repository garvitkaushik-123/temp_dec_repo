package com.google.android.gms.internal.ads;

import androidx.exifinterface.media.ExifInterface;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
final class zzfox implements zzfoy {
    private static final zzatq zza;

    static {
        zzast zza2 = zzatq.zza();
        zza2.zzv(ExifInterface.LONGITUDE_EAST);
        zza = (zzatq) zza2.zzbr();
    }

    zzfox() {
    }

    @Override // com.google.android.gms.internal.ads.zzfoy
    public final zzatq zza() {
        return zza;
    }
}
