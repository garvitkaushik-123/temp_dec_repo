package com.google.android.gms.internal.ads;

import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
final class zzaox {
    public final int zza;
    public final long zzb;

    private zzaox(int i, long j) {
        this.zza = i;
        this.zzb = j;
    }

    public static zzaox zza(zzadw zzadwVar, zzen zzenVar) throws IOException {
        zzadwVar.zzh(zzenVar.zzN(), 0, 8);
        zzenVar.zzL(0);
        return new zzaox(zzenVar.zzg(), zzenVar.zzs());
    }
}
