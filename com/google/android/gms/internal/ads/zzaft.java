package com.google.android.gms.internal.ads;

import java.nio.charset.StandardCharsets;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
final class zzaft implements zzafj {
    public final String zza;

    private zzaft(String str) {
        this.zza = str;
    }

    public static zzaft zzb(zzen zzenVar) {
        return new zzaft(zzenVar.zzB(zzenVar.zza(), StandardCharsets.UTF_8));
    }

    @Override // com.google.android.gms.internal.ads.zzafj
    public final int zza() {
        return 1852994675;
    }
}
