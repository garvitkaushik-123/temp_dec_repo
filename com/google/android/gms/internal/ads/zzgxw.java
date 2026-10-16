package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;

/* compiled from: com.google.android.gms:play-services-ads-api@@24.5.0 */
/* loaded from: classes5.dex */
class zzgxw extends zzgxv {
    protected final byte[] zza;

    zzgxw(byte[] bArr) {
        super(null);
        bArr.getClass();
        this.zza = bArr;
    }

    @Override // com.google.android.gms.internal.ads.zzgxz
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzgxz) || zzd() != ((zzgxz) obj).zzd()) {
            return false;
        }
        if (zzd() == 0) {
            return true;
        }
        if (!(obj instanceof zzgxw)) {
            return obj.equals(this);
        }
        zzgxw zzgxwVar = (zzgxw) obj;
        int zzr = zzr();
        int zzr2 = zzgxwVar.zzr();
        if (zzr == 0 || zzr2 == 0 || zzr == zzr2) {
            return zzg(zzgxwVar, 0, zzd());
        }
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzgxz
    public byte zza(int i) {
        return this.zza[i];
    }

    @Override // com.google.android.gms.internal.ads.zzgxz
    byte zzb(int i) {
        return this.zza[i];
    }

    protected int zzc() {
        return 0;
    }

    @Override // com.google.android.gms.internal.ads.zzgxz
    public int zzd() {
        return this.zza.length;
    }

    @Override // com.google.android.gms.internal.ads.zzgxz
    protected void zze(byte[] bArr, int i, int i2, int i3) {
        System.arraycopy(this.zza, i, bArr, i2, i3);
    }

    @Override // com.google.android.gms.internal.ads.zzgxv
    final boolean zzg(zzgxz zzgxzVar, int i, int i2) {
        if (i2 > zzgxzVar.zzd()) {
            throw new IllegalArgumentException("Length too large: " + i2 + zzd());
        }
        int i3 = i + i2;
        if (i3 > zzgxzVar.zzd()) {
            throw new IllegalArgumentException("Ran off end of other: " + i + ", " + i2 + ", " + zzgxzVar.zzd());
        }
        if (!(zzgxzVar instanceof zzgxw)) {
            return zzgxzVar.zzk(i, i3).equals(zzk(0, i2));
        }
        zzgxw zzgxwVar = (zzgxw) zzgxzVar;
        byte[] bArr = this.zza;
        byte[] bArr2 = zzgxwVar.zza;
        int zzc = zzc() + i2;
        int zzc2 = zzc();
        int zzc3 = zzgxwVar.zzc() + i;
        while (zzc2 < zzc) {
            if (bArr[zzc2] != bArr2[zzc3]) {
                return false;
            }
            zzc2++;
            zzc3++;
        }
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzgxz
    protected final int zzi(int i, int i2, int i3) {
        return zzgzu.zzb(i, this.zza, zzc() + i2, i3);
    }

    @Override // com.google.android.gms.internal.ads.zzgxz
    protected final int zzj(int i, int i2, int i3) {
        int zzc = zzc() + i2;
        return zzhcj.zzf(i, this.zza, zzc, i3 + zzc);
    }

    @Override // com.google.android.gms.internal.ads.zzgxz
    public final zzgxz zzk(int i, int i2) {
        int zzq = zzq(i, i2, zzd());
        return zzq == 0 ? zzgxz.zzb : new zzgxt(this.zza, zzc() + i, zzq);
    }

    @Override // com.google.android.gms.internal.ads.zzgxz
    public final zzgyf zzl() {
        return zzgyf.zzH(this.zza, zzc(), zzd(), true);
    }

    @Override // com.google.android.gms.internal.ads.zzgxz
    protected final String zzm(Charset charset) {
        return new String(this.zza, zzc(), zzd(), charset);
    }

    @Override // com.google.android.gms.internal.ads.zzgxz
    public final ByteBuffer zzn() {
        return ByteBuffer.wrap(this.zza, zzc(), zzd()).asReadOnlyBuffer();
    }

    @Override // com.google.android.gms.internal.ads.zzgxz
    final void zzo(zzgxq zzgxqVar) throws IOException {
        zzgxqVar.zza(this.zza, zzc(), zzd());
    }

    @Override // com.google.android.gms.internal.ads.zzgxz
    public final boolean zzp() {
        int zzc = zzc();
        return zzhcj.zzi(this.zza, zzc, zzd() + zzc);
    }
}
