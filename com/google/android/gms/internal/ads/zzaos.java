package com.google.android.gms.internal.ads;

import androidx.compose.ui.layout.LayoutKt;
import com.google.common.base.Ascii;
import com.vungle.ads.internal.protos.Sdk;
import java.io.IOException;
import java.math.RoundingMode;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
final class zzaos implements zzaot {
    private static final int[] zza = {-1, -1, -1, -1, 2, 4, 6, 8, -1, -1, -1, -1, 2, 4, 6, 8};
    private static final int[] zzb = {7, 8, 9, 10, 11, 12, 13, 14, 16, 17, 19, 21, 23, 25, 28, 31, 34, 37, 41, 45, 50, 55, 60, 66, 73, 80, 88, 97, 107, Sdk.SDKError.Reason.PROTOBUF_SERIALIZATION_ERROR_VALUE, 130, 143, 157, 173, 190, 209, 230, 253, 279, 307, 337, 371, 408, 449, 494, 544, 598, 658, 724, 796, 876, 963, 1060, 1166, 1282, 1411, 1552, 1707, 1878, 2066, 2272, 2499, 2749, 3024, 3327, 3660, 4026, 4428, 4871, 5358, 5894, 6484, 7132, 7845, 8630, 9493, 10442, 11487, 12635, 13899, 15289, 16818, 18500, 20350, 22385, 24623, 27086, 29794, LayoutKt.LargeDimension};
    private final zzady zzc;
    private final zzafb zzd;
    private final zzaow zze;
    private final int zzf;
    private final byte[] zzg;
    private final zzen zzh;
    private final int zzi;
    private final zzz zzj;
    private int zzk;
    private long zzl;
    private int zzm;
    private long zzn;

    public zzaos(zzady zzadyVar, zzafb zzafbVar, zzaow zzaowVar) throws zzaz {
        this.zzc = zzadyVar;
        this.zzd = zzafbVar;
        this.zze = zzaowVar;
        int max = Math.max(1, zzaowVar.zzc / 10);
        this.zzi = max;
        zzen zzenVar = new zzen(zzaowVar.zzf);
        zzenVar.zzk();
        int zzk = zzenVar.zzk();
        this.zzf = zzk;
        int i = zzaowVar.zzb;
        int i2 = (((zzaowVar.zzd - (i * 4)) * 8) / (zzaowVar.zze * i)) + 1;
        if (zzk != i2) {
            throw zzaz.zza("Expected frames per block: " + i2 + "; got: " + zzk, null);
        }
        String str = zzex.zza;
        int i3 = ((max + zzk) - 1) / zzk;
        this.zzg = new byte[zzaowVar.zzd * i3];
        this.zzh = new zzen(i3 * (zzk + zzk) * i);
        int i4 = ((zzaowVar.zzc * zzaowVar.zzd) * 8) / zzk;
        zzx zzxVar = new zzx();
        zzxVar.zzah("audio/raw");
        zzxVar.zzC(i4);
        zzxVar.zzac(i4);
        zzxVar.zzX((max + max) * i);
        zzxVar.zzD(zzaowVar.zzb);
        zzxVar.zzai(zzaowVar.zzc);
        zzxVar.zzab(2);
        this.zzj = zzxVar.zzan();
    }

    private final int zzd(int i) {
        int i2 = this.zze.zzb;
        return i / (i2 + i2);
    }

    private final int zze(int i) {
        return (i + i) * this.zze.zzb;
    }

    private final void zzf(int i) {
        long zzu = this.zzl + zzex.zzu(this.zzn, 1000000L, this.zze.zzc, RoundingMode.DOWN);
        int zze = zze(i);
        this.zzd.zzt(zzu, 1, zze, this.zzm - zze, null);
        this.zzn += i;
        this.zzm -= zze;
    }

    @Override // com.google.android.gms.internal.ads.zzaot
    public final void zza(int i, long j) {
        zzaoz zzaozVar = new zzaoz(this.zze, this.zzf, i, j);
        this.zzc.zzP(zzaozVar);
        zzafb zzafbVar = this.zzd;
        zzafbVar.zzm(this.zzj);
        zzafbVar.zzl(zzaozVar.zza());
    }

    @Override // com.google.android.gms.internal.ads.zzaot
    public final void zzb(long j) {
        this.zzk = 0;
        this.zzl = j;
        this.zzm = 0;
        this.zzn = 0L;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:6:0x0026  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:8:0x003c -> B:3:0x0021). Please report as a decompilation issue!!! */
    @Override // com.google.android.gms.internal.ads.zzaot
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean zzc(zzadw zzadwVar, long j) throws IOException {
        boolean z;
        int i;
        int zzd;
        int zzd2 = zzd(this.zzm);
        int i2 = this.zzi;
        String str = zzex.zza;
        int i3 = this.zzf;
        zzaow zzaowVar = this.zze;
        int i4 = zzaowVar.zzd;
        int i5 = ((((i2 - zzd2) + i3) - 1) / i3) * i4;
        if (j != 0) {
            z = false;
            while (!z) {
                if (this.zzk >= i5) {
                    break;
                }
                int zza2 = zzadwVar.zza(this.zzg, this.zzk, (int) Math.min(i5 - r12, j));
                if (zza2 != -1) {
                    this.zzk += zza2;
                }
            }
            i = this.zzk / i4;
            if (i > 0) {
                byte[] bArr = this.zzg;
                zzen zzenVar = this.zzh;
                for (int i6 = 0; i6 < i; i6++) {
                    int i7 = 0;
                    while (true) {
                        int i8 = zzaowVar.zzb;
                        if (i7 < i8) {
                            byte[] zzN = zzenVar.zzN();
                            int i9 = (i4 / i8) - 4;
                            int i10 = (i6 * i4) + (i7 * 4);
                            int i11 = bArr[i10 + 1] & 255;
                            int i12 = bArr[i10] & 255;
                            int i13 = i;
                            byte[] bArr2 = bArr;
                            int min = Math.min(bArr[i10 + 2] & 255, 88);
                            int[] iArr = zzb;
                            int i14 = iArr[min];
                            int i15 = (i6 * i3 * i8) + i7;
                            int i16 = (short) (i12 | (i11 << 8));
                            int i17 = i15 + i15;
                            zzN[i17] = (byte) (i16 & 255);
                            zzN[i17 + 1] = (byte) (i16 >> 8);
                            for (int i18 = 0; i18 < i9 + i9; i18++) {
                                byte b = bArr2[(i8 * 4) + i10 + ((i18 / 8) * i8 * 4) + ((i18 / 2) % 4)];
                                int i19 = min;
                                int i20 = i18 % 2 == 0 ? b & Ascii.SI : (b & 255) >> 4;
                                int i21 = i20 & 7;
                                int i22 = (((i21 + i21) + 1) * i14) >> 3;
                                if ((i20 & 8) != 0) {
                                    i22 = -i22;
                                }
                                i16 = Math.max(-32768, Math.min(i16 + i22, LayoutKt.LargeDimension));
                                i17 += i8 + i8;
                                zzN[i17] = (byte) (i16 & 255);
                                zzN[i17 + 1] = (byte) (i16 >> 8);
                                min = Math.max(0, Math.min(i19 + zza[i20], 88));
                                i14 = iArr[min];
                            }
                            i7++;
                            i = i13;
                            bArr = bArr2;
                        }
                    }
                }
                int i23 = i;
                int zze = zze(i3 * i23);
                zzenVar.zzL(0);
                zzenVar.zzK(zze);
                this.zzk -= i23 * i4;
                int zzd3 = zzenVar.zzd();
                this.zzd.zzr(zzenVar, zzd3);
                int i24 = this.zzm + zzd3;
                this.zzm = i24;
                if (zzd(i24) >= i2) {
                    zzf(i2);
                }
            }
            if (z && (zzd = zzd(this.zzm)) > 0) {
                zzf(zzd);
            }
            return z;
        }
        z = true;
        while (!z) {
        }
        i = this.zzk / i4;
        if (i > 0) {
        }
        if (z) {
            zzf(zzd);
        }
        return z;
    }
}
