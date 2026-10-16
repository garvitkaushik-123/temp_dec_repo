package com.google.android.gms.internal.ads;

import java.io.EOFException;
import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzadr implements zzafb {
    private final byte[] zza = new byte[4096];

    @Override // com.google.android.gms.internal.ads.zzafb
    public final /* synthetic */ int zzf(zzl zzlVar, int i, boolean z) {
        return zzaez.zza(this, zzlVar, i, z);
    }

    @Override // com.google.android.gms.internal.ads.zzafb
    public final int zzg(zzl zzlVar, int i, boolean z, int i2) throws IOException {
        int zza = zzlVar.zza(this.zza, 0, Math.min(4096, i));
        if (zza != -1) {
            return zza;
        }
        if (z) {
            return -1;
        }
        throw new EOFException();
    }

    @Override // com.google.android.gms.internal.ads.zzafb
    public final /* synthetic */ void zzl(long j) {
    }

    @Override // com.google.android.gms.internal.ads.zzafb
    public final void zzm(zzz zzzVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzafb
    public final /* synthetic */ void zzr(zzen zzenVar, int i) {
        zzaez.zzb(this, zzenVar, i);
    }

    @Override // com.google.android.gms.internal.ads.zzafb
    public final void zzs(zzen zzenVar, int i, int i2) {
        zzenVar.zzM(i);
    }

    @Override // com.google.android.gms.internal.ads.zzafb
    public final void zzt(long j, int i, int i2, int i3, zzafa zzafaVar) {
    }
}
