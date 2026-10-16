package com.google.android.gms.internal.ads;

import java.io.EOFException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
final class zzws {
    private final zzen zza = new zzen(32);
    private zzwr zzb;
    private zzwr zzc;
    private zzwr zzd;
    private long zze;
    private final zzzm zzf;

    public zzws(zzzm zzzmVar) {
        this.zzf = zzzmVar;
        zzwr zzwrVar = new zzwr(0L, 65536);
        this.zzb = zzwrVar;
        this.zzc = zzwrVar;
        this.zzd = zzwrVar;
    }

    private final int zzi(int i) {
        zzwr zzwrVar = this.zzd;
        if (zzwrVar.zzc == null) {
            zzzf zzb = this.zzf.zzb();
            zzwr zzwrVar2 = new zzwr(this.zzd.zzb, 65536);
            zzwrVar.zzc = zzb;
            zzwrVar.zzd = zzwrVar2;
        }
        return Math.min(i, (int) (this.zzd.zzb - this.zze));
    }

    private static zzwr zzj(zzwr zzwrVar, long j) {
        while (j >= zzwrVar.zzb) {
            zzwrVar = zzwrVar.zzd;
        }
        return zzwrVar;
    }

    private static zzwr zzk(zzwr zzwrVar, long j, ByteBuffer byteBuffer, int i) {
        zzwr zzj = zzj(zzwrVar, j);
        while (i > 0) {
            int min = Math.min(i, (int) (zzj.zzb - j));
            byteBuffer.put(zzj.zzc.zza, zzj.zza(j), min);
            i -= min;
            j += min;
            if (j == zzj.zzb) {
                zzj = zzj.zzd;
            }
        }
        return zzj;
    }

    private static zzwr zzl(zzwr zzwrVar, long j, byte[] bArr, int i) {
        zzwr zzj = zzj(zzwrVar, j);
        int i2 = i;
        while (i2 > 0) {
            int min = Math.min(i2, (int) (zzj.zzb - j));
            System.arraycopy(zzj.zzc.zza, zzj.zza(j), bArr, i - i2, min);
            i2 -= min;
            j += min;
            if (j == zzj.zzb) {
                zzj = zzj.zzd;
            }
        }
        return zzj;
    }

    private static zzwr zzm(zzwr zzwrVar, zzhs zzhsVar, zzwu zzwuVar, zzen zzenVar) {
        zzwr zzwrVar2;
        if (zzhsVar.zzl()) {
            long j = zzwuVar.zzb;
            int i = 1;
            zzenVar.zzI(1);
            zzwr zzl = zzl(zzwrVar, j, zzenVar.zzN(), 1);
            long j2 = j + 1;
            byte b = zzenVar.zzN()[0];
            int i2 = b & 128;
            int i3 = b & Byte.MAX_VALUE;
            zzhp zzhpVar = zzhsVar.zzb;
            byte[] bArr = zzhpVar.zza;
            if (bArr == null) {
                zzhpVar.zza = new byte[16];
            } else {
                Arrays.fill(bArr, (byte) 0);
            }
            boolean z = i2 != 0;
            zzwrVar2 = zzl(zzl, j2, zzhpVar.zza, i3);
            long j3 = j2 + i3;
            if (z) {
                zzenVar.zzI(2);
                zzwrVar2 = zzl(zzwrVar2, j3, zzenVar.zzN(), 2);
                j3 += 2;
                i = zzenVar.zzq();
            }
            int i4 = i;
            int[] iArr = zzhpVar.zzd;
            if (iArr == null || iArr.length < i4) {
                iArr = new int[i4];
            }
            int[] iArr2 = iArr;
            int[] iArr3 = zzhpVar.zze;
            if (iArr3 == null || iArr3.length < i4) {
                iArr3 = new int[i4];
            }
            int[] iArr4 = iArr3;
            if (z) {
                int i5 = i4 * 6;
                zzenVar.zzI(i5);
                zzwrVar2 = zzl(zzwrVar2, j3, zzenVar.zzN(), i5);
                j3 += i5;
                zzenVar.zzL(0);
                for (int i6 = 0; i6 < i4; i6++) {
                    iArr2[i6] = zzenVar.zzq();
                    iArr4[i6] = zzenVar.zzp();
                }
            } else {
                iArr2[0] = 0;
                iArr4[0] = zzwuVar.zza - ((int) (j3 - zzwuVar.zzb));
            }
            zzafa zzafaVar = zzwuVar.zzc;
            String str = zzex.zza;
            zzhpVar.zzc(i4, iArr2, iArr4, zzafaVar.zzb, zzhpVar.zza, zzafaVar.zza, zzafaVar.zzc, zzafaVar.zzd);
            long j4 = zzwuVar.zzb;
            int i7 = (int) (j3 - j4);
            zzwuVar.zzb = j4 + i7;
            zzwuVar.zza -= i7;
        } else {
            zzwrVar2 = zzwrVar;
        }
        if (!zzhsVar.zze()) {
            zzhsVar.zzj(zzwuVar.zza);
            return zzk(zzwrVar2, zzwuVar.zzb, zzhsVar.zzc, zzwuVar.zza);
        }
        zzenVar.zzI(4);
        zzwr zzl2 = zzl(zzwrVar2, zzwuVar.zzb, zzenVar.zzN(), 4);
        int zzp = zzenVar.zzp();
        zzwuVar.zzb += 4;
        zzwuVar.zza -= 4;
        zzhsVar.zzj(zzp);
        zzwr zzk = zzk(zzl2, zzwuVar.zzb, zzhsVar.zzc, zzp);
        zzwuVar.zzb += zzp;
        int i8 = zzwuVar.zza - zzp;
        zzwuVar.zza = i8;
        ByteBuffer byteBuffer = zzhsVar.zzf;
        if (byteBuffer == null || byteBuffer.capacity() < i8) {
            zzhsVar.zzf = ByteBuffer.allocate(i8);
        } else {
            zzhsVar.zzf.clear();
        }
        return zzk(zzk, zzwuVar.zzb, zzhsVar.zzf, zzwuVar.zza);
    }

    private final void zzn(int i) {
        long j = this.zze + i;
        this.zze = j;
        zzwr zzwrVar = this.zzd;
        if (j == zzwrVar.zzb) {
            this.zzd = zzwrVar.zzd;
        }
    }

    public final int zza(zzl zzlVar, int i, boolean z) throws IOException {
        int zzi = zzi(i);
        zzwr zzwrVar = this.zzd;
        int zza = zzlVar.zza(zzwrVar.zzc.zza, zzwrVar.zza(this.zze), zzi);
        if (zza != -1) {
            zzn(zza);
            return zza;
        }
        if (z) {
            return -1;
        }
        throw new EOFException();
    }

    public final long zzb() {
        return this.zze;
    }

    public final void zzc(long j) {
        zzwr zzwrVar;
        if (j != -1) {
            while (true) {
                zzwrVar = this.zzb;
                if (j < zzwrVar.zzb) {
                    break;
                }
                this.zzf.zzc(zzwrVar.zzc);
                this.zzb = this.zzb.zzb();
            }
            if (this.zzc.zza < zzwrVar.zza) {
                this.zzc = zzwrVar;
            }
        }
    }

    public final void zzd(zzhs zzhsVar, zzwu zzwuVar) {
        zzm(this.zzc, zzhsVar, zzwuVar, this.zza);
    }

    public final void zze(zzhs zzhsVar, zzwu zzwuVar) {
        this.zzc = zzm(this.zzc, zzhsVar, zzwuVar, this.zza);
    }

    public final void zzf() {
        zzwr zzwrVar = this.zzb;
        if (zzwrVar.zzc != null) {
            this.zzf.zzd(zzwrVar);
            zzwrVar.zzb();
        }
        this.zzb.zze(0L, 65536);
        zzwr zzwrVar2 = this.zzb;
        this.zzc = zzwrVar2;
        this.zzd = zzwrVar2;
        this.zze = 0L;
        this.zzf.zzg();
    }

    public final void zzg() {
        this.zzc = this.zzb;
    }

    public final void zzh(zzen zzenVar, int i) {
        while (i > 0) {
            int zzi = zzi(i);
            zzwr zzwrVar = this.zzd;
            zzenVar.zzH(zzwrVar.zzc.zza, zzwrVar.zza(this.zze), zzi);
            i -= zzi;
            zzn(zzi);
        }
    }
}
