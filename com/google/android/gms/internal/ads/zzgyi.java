package com.google.android.gms.internal.ads;

import com.google.android.gms.nearby.uwb.RangingPosition;
import java.io.IOException;
import java.util.Locale;

/* compiled from: com.google.android.gms:play-services-ads-api@@24.5.0 */
/* loaded from: classes5.dex */
final class zzgyi extends zzgym {
    private final byte[] zza;
    private final int zzb;
    private int zzc;

    zzgyi(byte[] bArr, int i, int i2) {
        super(null);
        int length = bArr.length;
        if (((length - i2) | i2) < 0) {
            throw new IllegalArgumentException(String.format(Locale.US, "Array range is invalid. Buffer.length=%d, offset=%d, length=%d", Integer.valueOf(length), 0, Integer.valueOf(i2)));
        }
        this.zza = bArr;
        this.zzc = 0;
        this.zzb = i2;
    }

    @Override // com.google.android.gms.internal.ads.zzgym
    public final void zzK() {
    }

    @Override // com.google.android.gms.internal.ads.zzgym
    public final void zzL(byte b) throws IOException {
        IndexOutOfBoundsException indexOutOfBoundsException;
        int i = this.zzc;
        try {
            int i2 = i + 1;
            try {
                this.zza[i] = b;
                this.zzc = i2;
            } catch (IndexOutOfBoundsException e) {
                indexOutOfBoundsException = e;
                i = i2;
                throw new zzgyj(i, this.zzb, 1, indexOutOfBoundsException);
            }
        } catch (IndexOutOfBoundsException e2) {
            indexOutOfBoundsException = e2;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgym
    public final void zzM(int i, boolean z) throws IOException {
        zzu(i << 3);
        zzL(z ? (byte) 1 : (byte) 0);
    }

    @Override // com.google.android.gms.internal.ads.zzgym
    public final void zzN(int i, zzgxz zzgxzVar) throws IOException {
        zzu((i << 3) | 2);
        zzu(zzgxzVar.zzd());
        zzgxzVar.zzo(this);
    }

    @Override // com.google.android.gms.internal.ads.zzgym, com.google.android.gms.internal.ads.zzgxq
    public final void zza(byte[] bArr, int i, int i2) throws IOException {
        zze(bArr, i, i2);
    }

    @Override // com.google.android.gms.internal.ads.zzgym
    public final int zzb() {
        return this.zzb - this.zzc;
    }

    public final void zze(byte[] bArr, int i, int i2) throws IOException {
        try {
            System.arraycopy(bArr, i, this.zza, this.zzc, i2);
            this.zzc += i2;
        } catch (IndexOutOfBoundsException e) {
            throw new zzgyj(this.zzc, this.zzb, i2, e);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgym
    public final void zzh(int i, int i2) throws IOException {
        zzu((i << 3) | 5);
        zzi(i2);
    }

    @Override // com.google.android.gms.internal.ads.zzgym
    public final void zzi(int i) throws IOException {
        int i2 = this.zzc;
        try {
            byte[] bArr = this.zza;
            bArr[i2] = (byte) i;
            bArr[i2 + 1] = (byte) (i >> 8);
            bArr[i2 + 2] = (byte) (i >> 16);
            bArr[i2 + 3] = (byte) (i >> 24);
            this.zzc = i2 + 4;
        } catch (IndexOutOfBoundsException e) {
            throw new zzgyj(i2, this.zzb, 4, e);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgym
    public final void zzj(int i, long j) throws IOException {
        zzu((i << 3) | 1);
        zzk(j);
    }

    @Override // com.google.android.gms.internal.ads.zzgym
    public final void zzk(long j) throws IOException {
        int i = this.zzc;
        try {
            byte[] bArr = this.zza;
            bArr[i] = (byte) j;
            bArr[i + 1] = (byte) (j >> 8);
            bArr[i + 2] = (byte) (j >> 16);
            bArr[i + 3] = (byte) (j >> 24);
            bArr[i + 4] = (byte) (j >> 32);
            bArr[i + 5] = (byte) (j >> 40);
            bArr[i + 6] = (byte) (j >> 48);
            bArr[i + 7] = (byte) (j >> 56);
            this.zzc = i + 8;
        } catch (IndexOutOfBoundsException e) {
            throw new zzgyj(i, this.zzb, 8, e);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgym
    public final void zzl(int i, int i2) throws IOException {
        zzu(i << 3);
        zzm(i2);
    }

    @Override // com.google.android.gms.internal.ads.zzgym
    public final void zzm(int i) throws IOException {
        if (i >= 0) {
            zzu(i);
        } else {
            zzw(i);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgym
    final void zzn(int i, zzhas zzhasVar, zzhbl zzhblVar) throws IOException {
        zzu((i << 3) | 2);
        zzu(((zzgxi) zzhasVar).zzaM(zzhblVar));
        zzhblVar.zzj(zzhasVar, this.zze);
    }

    @Override // com.google.android.gms.internal.ads.zzgym
    public final void zzo(int i, zzhas zzhasVar) throws IOException {
        zzu(11);
        zzt(2, i);
        zzu(26);
        zzu(zzhasVar.zzaY());
        zzhasVar.zzcZ(this);
        zzu(12);
    }

    @Override // com.google.android.gms.internal.ads.zzgym
    public final void zzp(int i, zzgxz zzgxzVar) throws IOException {
        zzu(11);
        zzt(2, i);
        zzN(3, zzgxzVar);
        zzu(12);
    }

    @Override // com.google.android.gms.internal.ads.zzgym
    public final void zzq(int i, String str) throws IOException {
        zzu((i << 3) | 2);
        zzr(str);
    }

    public final void zzr(String str) throws IOException {
        int i = this.zzc;
        try {
            int zzD = zzD(str.length() * 3);
            int zzD2 = zzD(str.length());
            if (zzD2 != zzD) {
                zzu(zzhcj.zze(str));
                byte[] bArr = this.zza;
                int i2 = this.zzc;
                this.zzc = zzhcj.zzd(str, bArr, i2, this.zzb - i2);
                return;
            }
            int i3 = i + zzD2;
            this.zzc = i3;
            int zzd = zzhcj.zzd(str, this.zza, i3, this.zzb - i3);
            this.zzc = i;
            zzu((zzd - i) - zzD2);
            this.zzc = zzd;
        } catch (zzhci e) {
            this.zzc = i;
            zzG(str, e);
        } catch (IndexOutOfBoundsException e2) {
            throw new zzgyj(e2);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgym
    public final void zzs(int i, int i2) throws IOException {
        zzu((i << 3) | i2);
    }

    @Override // com.google.android.gms.internal.ads.zzgym
    public final void zzt(int i, int i2) throws IOException {
        zzu(i << 3);
        zzu(i2);
    }

    @Override // com.google.android.gms.internal.ads.zzgym
    public final void zzv(int i, long j) throws IOException {
        zzu(i << 3);
        zzw(j);
    }

    @Override // com.google.android.gms.internal.ads.zzgym
    public final void zzu(int i) throws IOException {
        int i2;
        IndexOutOfBoundsException indexOutOfBoundsException;
        int i3 = this.zzc;
        while ((i & RangingPosition.RSSI_UNKNOWN) != 0) {
            try {
                i2 = i3 + 1;
                try {
                    this.zza[i3] = (byte) (i | 128);
                    i >>>= 7;
                    i3 = i2;
                } catch (IndexOutOfBoundsException e) {
                    indexOutOfBoundsException = e;
                    i3 = i2;
                    throw new zzgyj(i3, this.zzb, 1, indexOutOfBoundsException);
                }
            } catch (IndexOutOfBoundsException e2) {
                indexOutOfBoundsException = e2;
                throw new zzgyj(i3, this.zzb, 1, indexOutOfBoundsException);
            }
        }
        i2 = i3 + 1;
        this.zza[i3] = (byte) i;
        this.zzc = i2;
    }

    @Override // com.google.android.gms.internal.ads.zzgym
    public final void zzw(long j) throws IOException {
        boolean z;
        int i;
        IndexOutOfBoundsException indexOutOfBoundsException;
        int i2;
        int i3 = this.zzc;
        z = zzgym.zzb;
        if (!z || this.zzb - i3 < 10) {
            int i4 = i3;
            while ((j & (-128)) != 0) {
                try {
                    i2 = i4 + 1;
                } catch (IndexOutOfBoundsException e) {
                    indexOutOfBoundsException = e;
                }
                try {
                    this.zza[i4] = (byte) (((int) j) | 128);
                    j >>>= 7;
                    i4 = i2;
                } catch (IndexOutOfBoundsException e2) {
                    indexOutOfBoundsException = e2;
                    i4 = i2;
                    throw new zzgyj(i4, this.zzb, 1, indexOutOfBoundsException);
                }
            }
            i = i4 + 1;
            try {
                this.zza[i4] = (byte) j;
            } catch (IndexOutOfBoundsException e3) {
                indexOutOfBoundsException = e3;
                i4 = i;
                throw new zzgyj(i4, this.zzb, 1, indexOutOfBoundsException);
            }
        } else {
            while ((j & (-128)) != 0) {
                zzhce.zzq(this.zza, i3, (byte) (((int) j) | 128));
                j >>>= 7;
                i3++;
            }
            i = i3 + 1;
            zzhce.zzq(this.zza, i3, (byte) j);
        }
        this.zzc = i;
    }
}
