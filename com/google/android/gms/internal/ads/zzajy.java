package com.google.android.gms.internal.ads;

import java.util.Arrays;
import org.checkerframework.checker.nullness.qual.EnsuresNonNullIf;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
final class zzajy extends zzakh {
    private zzaeg zza;
    private zzajx zzb;

    zzajy() {
    }

    private static boolean zzd(byte[] bArr) {
        return bArr[0] == -1;
    }

    @Override // com.google.android.gms.internal.ads.zzakh
    protected final long zza(zzen zzenVar) {
        if (!zzd(zzenVar.zzN())) {
            return -1L;
        }
        int i = (zzenVar.zzN()[2] & 255) >> 4;
        if (i != 6) {
            if (i == 7) {
                i = 7;
            }
            int zza = zzaec.zza(zzenVar, i);
            zzenVar.zzL(0);
            return zza;
        }
        zzenVar.zzM(4);
        zzenVar.zzx();
        int zza2 = zzaec.zza(zzenVar, i);
        zzenVar.zzL(0);
        return zza2;
    }

    @Override // com.google.android.gms.internal.ads.zzakh
    protected final void zzb(boolean z) {
        super.zzb(z);
        if (z) {
            this.zza = null;
            this.zzb = null;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzakh
    @EnsuresNonNullIf(expression = {"#3.format"}, result = false)
    protected final boolean zzc(zzen zzenVar, long j, zzake zzakeVar) {
        byte[] zzN = zzenVar.zzN();
        zzaeg zzaegVar = this.zza;
        if (zzaegVar == null) {
            zzaeg zzaegVar2 = new zzaeg(zzN, 17);
            this.zza = zzaegVar2;
            zzx zzb = zzaegVar2.zzc(Arrays.copyOfRange(zzN, 9, zzenVar.zzd()), null).zzb();
            zzb.zzG("audio/ogg");
            zzakeVar.zza = zzb.zzan();
            return true;
        }
        if ((zzN[0] & Byte.MAX_VALUE) == 3) {
            zzaef zzb2 = zzaed.zzb(zzenVar);
            zzaeg zzf = zzaegVar.zzf(zzb2);
            this.zza = zzf;
            this.zzb = new zzajx(zzf, zzb2);
            return true;
        }
        if (!zzd(zzN)) {
            return true;
        }
        zzajx zzajxVar = this.zzb;
        if (zzajxVar != null) {
            zzajxVar.zza(j);
            zzakeVar.zzb = this.zzb;
        }
        zzakeVar.zza.getClass();
        return false;
    }
}
