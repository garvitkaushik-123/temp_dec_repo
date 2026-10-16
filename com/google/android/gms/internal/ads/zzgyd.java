package com.google.android.gms.internal.ads;

import com.google.android.gms.nearby.uwb.RangingPosition;
import com.google.common.base.Ascii;
import java.io.IOException;
import java.nio.ByteBuffer;

/* compiled from: com.google.android.gms:play-services-ads-api@@24.5.0 */
/* loaded from: classes5.dex */
final class zzgyd extends zzgyf {
    public static final /* synthetic */ int zza = 0;
    private final ByteBuffer zzf;
    private final long zzg;
    private long zzh;
    private long zzi;
    private final long zzj;
    private int zzk;
    private int zzl;
    private int zzm;

    /* synthetic */ zzgyd(ByteBuffer byteBuffer, boolean z, zzgye zzgyeVar) {
        super(null);
        this.zzm = Integer.MAX_VALUE;
        this.zzf = byteBuffer.duplicate();
        long zze = zzhce.zze(byteBuffer);
        this.zzg = zze;
        this.zzh = byteBuffer.limit() + zze;
        long position = zze + byteBuffer.position();
        this.zzi = position;
        this.zzj = position;
    }

    private final int zzC() {
        return (int) (this.zzh - this.zzi);
    }

    private final void zzI() {
        long j = this.zzh + this.zzk;
        this.zzh = j;
        int i = (int) (j - this.zzj);
        int i2 = this.zzm;
        if (i <= i2) {
            this.zzk = 0;
            return;
        }
        int i3 = i - i2;
        this.zzk = i3;
        this.zzh = j - i3;
    }

    @Override // com.google.android.gms.internal.ads.zzgyf
    public final boolean zzA() throws IOException {
        return this.zzi == this.zzh;
    }

    @Override // com.google.android.gms.internal.ads.zzgyf
    public final boolean zzB() throws IOException {
        return zzq() != 0;
    }

    @Override // com.google.android.gms.internal.ads.zzgyf
    public final double zza() throws IOException {
        return Double.longBitsToDouble(zzp());
    }

    @Override // com.google.android.gms.internal.ads.zzgyf
    public final float zzb() throws IOException {
        return Float.intBitsToFloat(zzh());
    }

    @Override // com.google.android.gms.internal.ads.zzgyf
    public final int zzc() {
        return (int) (this.zzi - this.zzj);
    }

    @Override // com.google.android.gms.internal.ads.zzgyf
    public final int zze() throws IOException {
        return zzi();
    }

    @Override // com.google.android.gms.internal.ads.zzgyf
    public final int zzf() throws IOException {
        return zzh();
    }

    @Override // com.google.android.gms.internal.ads.zzgyf
    public final int zzg() throws IOException {
        return zzi();
    }

    public final int zzh() throws IOException {
        long j = this.zzi;
        if (this.zzh - j < 4) {
            throw new zzgzw("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
        }
        this.zzi = 4 + j;
        int zza2 = zzhce.zza(j) & 255;
        int zza3 = zzhce.zza(1 + j) & 255;
        int zza4 = zzhce.zza(2 + j) & 255;
        return ((zzhce.zza(j + 3) & 255) << 24) | (zza3 << 8) | zza2 | (zza4 << 16);
    }

    @Override // com.google.android.gms.internal.ads.zzgyf
    public final int zzj() throws IOException {
        return zzh();
    }

    @Override // com.google.android.gms.internal.ads.zzgyf
    public final int zzk() throws IOException {
        return zzD(zzi());
    }

    @Override // com.google.android.gms.internal.ads.zzgyf
    public final int zzl() throws IOException {
        if (zzA()) {
            this.zzl = 0;
            return 0;
        }
        int zzi = zzi();
        this.zzl = zzi;
        if ((zzi >>> 3) != 0) {
            return zzi;
        }
        throw new zzgzw("Protocol message contained an invalid tag (zero).");
    }

    @Override // com.google.android.gms.internal.ads.zzgyf
    public final int zzm() throws IOException {
        return zzi();
    }

    @Override // com.google.android.gms.internal.ads.zzgyf
    public final long zzn() throws IOException {
        return zzp();
    }

    @Override // com.google.android.gms.internal.ads.zzgyf
    public final long zzo() throws IOException {
        return zzq();
    }

    public final long zzp() throws IOException {
        long j = this.zzi;
        if (this.zzh - j < 8) {
            throw new zzgzw("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
        }
        this.zzi = 8 + j;
        long zza2 = zzhce.zza(j);
        long zza3 = zzhce.zza(1 + j);
        long zza4 = zzhce.zza(2 + j);
        long zza5 = zzhce.zza(3 + j);
        long zza6 = zzhce.zza(4 + j);
        return ((zzhce.zza(j + 7) & 255) << 56) | (zza2 & 255) | ((zza3 & 255) << 8) | ((zza4 & 255) << 16) | ((zza5 & 255) << 24) | ((zza6 & 255) << 32) | ((zzhce.zza(5 + j) & 255) << 40) | ((zzhce.zza(6 + j) & 255) << 48);
    }

    @Override // com.google.android.gms.internal.ads.zzgyf
    public final long zzs() throws IOException {
        return zzp();
    }

    @Override // com.google.android.gms.internal.ads.zzgyf
    public final long zzt() throws IOException {
        return zzF(zzq());
    }

    @Override // com.google.android.gms.internal.ads.zzgyf
    public final long zzu() throws IOException {
        return zzq();
    }

    @Override // com.google.android.gms.internal.ads.zzgyf
    public final zzgxz zzv() throws IOException {
        int zzi = zzi();
        if (zzi <= 0 || zzi > zzC()) {
            if (zzi == 0) {
                return zzgxz.zzb;
            }
            if (zzi < 0) {
                throw new zzgzw("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
            }
            throw new zzgzw("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
        }
        byte[] bArr = new byte[zzi];
        long j = zzi;
        zzhce.zzo(this.zzi, bArr, 0L, j);
        this.zzi += j;
        zzgxz zzgxzVar = zzgxz.zzb;
        return new zzgxw(bArr);
    }

    @Override // com.google.android.gms.internal.ads.zzgyf
    public final String zzw() throws IOException {
        int zzi = zzi();
        if (zzi <= 0 || zzi > zzC()) {
            if (zzi == 0) {
                return "";
            }
            if (zzi < 0) {
                throw new zzgzw("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
            }
            throw new zzgzw("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
        }
        byte[] bArr = new byte[zzi];
        long j = zzi;
        zzhce.zzo(this.zzi, bArr, 0L, j);
        String str = new String(bArr, zzgzu.zza);
        this.zzi += j;
        return str;
    }

    @Override // com.google.android.gms.internal.ads.zzgyf
    public final String zzx() throws IOException {
        int zzi = zzi();
        if (zzi > 0 && zzi <= zzC()) {
            String zzg = zzhcj.zzg(this.zzf, (int) (this.zzi - this.zzg), zzi);
            this.zzi += zzi;
            return zzg;
        }
        if (zzi == 0) {
            return "";
        }
        if (zzi <= 0) {
            throw new zzgzw("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
        }
        throw new zzgzw("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
    }

    @Override // com.google.android.gms.internal.ads.zzgyf
    public final void zzy(int i) throws zzgzw {
        if (this.zzl != i) {
            throw new zzgzw("Protocol message end-group tag did not match expected tag.");
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgyf
    public final void zzz(int i) {
        this.zzm = i;
        zzI();
    }

    @Override // com.google.android.gms.internal.ads.zzgyf
    public final int zzd(int i) throws zzgzw {
        if (i < 0) {
            throw new zzgzw("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
        }
        int zzc = i + zzc();
        int i2 = this.zzm;
        if (zzc > i2) {
            throw new zzgzw("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
        }
        this.zzm = zzc;
        zzI();
        return i2;
    }

    final long zzr() throws IOException {
        long j = 0;
        for (int i = 0; i < 64; i += 7) {
            long j2 = this.zzi;
            if (j2 == this.zzh) {
                throw new zzgzw("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
            }
            this.zzi = 1 + j2;
            j |= (r3 & Byte.MAX_VALUE) << i;
            if ((zzhce.zza(j2) & 128) == 0) {
                return j;
            }
        }
        throw new zzgzw("CodedInputStream encountered a malformed varint.");
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x0089, code lost:
    
        if (com.google.android.gms.internal.ads.zzhce.zza(r3) >= 0) goto L33;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final int zzi() throws IOException {
        int i;
        long j = this.zzi;
        if (this.zzh != j) {
            long j2 = 1 + j;
            byte zza2 = zzhce.zza(j);
            if (zza2 >= 0) {
                this.zzi = j2;
                return zza2;
            }
            if (this.zzh - j2 >= 9) {
                long j3 = 2 + j;
                int zza3 = (zzhce.zza(j2) << 7) ^ zza2;
                if (zza3 < 0) {
                    i = zza3 ^ RangingPosition.RSSI_UNKNOWN;
                } else {
                    long j4 = 3 + j;
                    int zza4 = zza3 ^ (zzhce.zza(j3) << Ascii.SO);
                    if (zza4 >= 0) {
                        i = zza4 ^ 16256;
                    } else {
                        j3 = 4 + j;
                        int zza5 = zza4 ^ (zzhce.zza(j4) << Ascii.NAK);
                        if (zza5 < 0) {
                            i = (-2080896) ^ zza5;
                        } else {
                            j4 = 5 + j;
                            byte zza6 = zzhce.zza(j3);
                            int i2 = (zza5 ^ (zza6 << Ascii.FS)) ^ 266354560;
                            if (zza6 < 0) {
                                j3 = 6 + j;
                                if (zzhce.zza(j4) < 0) {
                                    j4 = 7 + j;
                                    if (zzhce.zza(j3) < 0) {
                                        j3 = 8 + j;
                                        if (zzhce.zza(j4) < 0) {
                                            j4 = j + 9;
                                            if (zzhce.zza(j3) < 0) {
                                                j3 = 10 + j;
                                            }
                                        }
                                    }
                                }
                                i = i2;
                            }
                            i = i2;
                        }
                    }
                    j3 = j4;
                }
                this.zzi = j3;
                return i;
            }
        }
        return (int) zzr();
    }

    public final long zzq() throws IOException {
        long j;
        long j2;
        int i;
        long j3 = this.zzi;
        if (this.zzh != j3) {
            long j4 = 1 + j3;
            byte zza2 = zzhce.zza(j3);
            if (zza2 >= 0) {
                this.zzi = j4;
                return zza2;
            }
            if (this.zzh - j4 >= 9) {
                long j5 = 2 + j3;
                int zza3 = (zzhce.zza(j4) << 7) ^ zza2;
                if (zza3 >= 0) {
                    long j6 = 3 + j3;
                    int zza4 = zza3 ^ (zzhce.zza(j5) << Ascii.SO);
                    if (zza4 >= 0) {
                        j = zza4 ^ 16256;
                    } else {
                        j5 = 4 + j3;
                        int zza5 = zza4 ^ (zzhce.zza(j6) << Ascii.NAK);
                        if (zza5 < 0) {
                            i = (-2080896) ^ zza5;
                        } else {
                            j6 = 5 + j3;
                            long zza6 = (zzhce.zza(j5) << 28) ^ zza5;
                            if (zza6 < 0) {
                                long j7 = 6 + j3;
                                long zza7 = (zzhce.zza(j6) << 35) ^ zza6;
                                if (zza7 >= 0) {
                                    j5 = j3 + 7;
                                    long zza8 = zza7 ^ (zzhce.zza(j7) << 42);
                                    if (zza8 >= 0) {
                                        j = 4363953127296L ^ zza8;
                                    } else {
                                        j7 = 8 + j3;
                                        zza7 = zza8 ^ (zzhce.zza(j5) << 49);
                                        if (zza7 < 0) {
                                            j2 = -558586000294016L;
                                        } else {
                                            j5 = j3 + 9;
                                            long zza9 = (zza7 ^ (zzhce.zza(j7) << 56)) ^ 71499008037633920L;
                                            if (zza9 < 0) {
                                                long j8 = j3 + 10;
                                                if (zzhce.zza(j5) >= 0) {
                                                    j5 = j8;
                                                }
                                            }
                                            j = zza9;
                                        }
                                    }
                                    this.zzi = j5;
                                    return j;
                                }
                                j2 = -34093383808L;
                                j = j2 ^ zza7;
                                j5 = j7;
                                this.zzi = j5;
                                return j;
                            }
                            j = 266354560 ^ zza6;
                        }
                    }
                    j5 = j6;
                    this.zzi = j5;
                    return j;
                }
                i = zza3 ^ RangingPosition.RSSI_UNKNOWN;
                j = i;
                this.zzi = j5;
                return j;
            }
        }
        return zzr();
    }
}
