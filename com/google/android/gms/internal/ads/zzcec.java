package com.google.android.gms.internal.ads;

import android.net.Uri;
import java.io.IOException;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
final class zzcec implements zzgj {
    private final zzgj zza;
    private final long zzb;
    private final zzgj zzc;
    private long zzd;
    private Uri zze;

    zzcec(zzgj zzgjVar, int i, zzgj zzgjVar2) {
        this.zza = zzgjVar;
        this.zzb = i;
        this.zzc = zzgjVar2;
    }

    @Override // com.google.android.gms.internal.ads.zzl
    public final int zza(byte[] bArr, int i, int i2) throws IOException {
        int i3;
        long j = this.zzd;
        long j2 = this.zzb;
        if (j < j2) {
            int zza = this.zza.zza(bArr, i, (int) Math.min(i2, j2 - j));
            long j3 = this.zzd + zza;
            this.zzd = j3;
            i3 = zza;
            j = j3;
        } else {
            i3 = 0;
        }
        if (j < j2) {
            return i3;
        }
        int zza2 = this.zzc.zza(bArr, i + i3, i2 - i3);
        int i4 = i3 + zza2;
        this.zzd += zza2;
        return i4;
    }

    @Override // com.google.android.gms.internal.ads.zzgj
    public final long zzb(zzgo zzgoVar) throws IOException {
        Uri uri;
        zzgo zzgoVar2;
        Uri uri2 = zzgoVar.zza;
        this.zze = uri2;
        long j = zzgoVar.zze;
        long j2 = this.zzb;
        zzgo zzgoVar3 = null;
        if (j >= j2) {
            uri = uri2;
            zzgoVar2 = null;
        } else {
            long j3 = zzgoVar.zzf;
            long j4 = j2 - j;
            if (j3 != -1) {
                j4 = Math.min(j3, j4);
            }
            uri = uri2;
            zzgoVar2 = new zzgo(uri, j, j4, null);
        }
        long j5 = zzgoVar.zzf;
        if (j5 == -1 || j + j5 > j2) {
            zzgoVar3 = new zzgo(uri, Math.max(j2, j), j5 != -1 ? Math.min(j5, (j + j5) - j2) : -1L, null);
        }
        long zzb = zzgoVar2 != null ? this.zza.zzb(zzgoVar2) : 0L;
        long zzb2 = zzgoVar3 != null ? this.zzc.zzb(zzgoVar3) : 0L;
        this.zzd = j;
        if (zzb == -1 || zzb2 == -1) {
            return -1L;
        }
        return zzb + zzb2;
    }

    @Override // com.google.android.gms.internal.ads.zzgj
    public final Uri zzc() {
        return this.zze;
    }

    @Override // com.google.android.gms.internal.ads.zzgj
    public final void zzd() throws IOException {
        this.zza.zzd();
        this.zzc.zzd();
    }

    @Override // com.google.android.gms.internal.ads.zzgj
    public final Map zze() {
        return zzfyt.zzd();
    }

    @Override // com.google.android.gms.internal.ads.zzgj
    public final void zzf(zzhj zzhjVar) {
    }
}
