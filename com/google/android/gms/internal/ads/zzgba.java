package com.google.android.gms.internal.ads;

import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
final class zzgba extends zzgbc {
    private zzgba(zzgay zzgayVar, Character ch) {
        super(zzgayVar, ch);
        char[] cArr;
        cArr = zzgayVar.zzf;
        zzfvp.zze(cArr.length == 64);
    }

    @Override // com.google.android.gms.internal.ads.zzgbc, com.google.android.gms.internal.ads.zzgbd
    final int zza(byte[] bArr, CharSequence charSequence) throws zzgbb {
        CharSequence zzg = zzg(charSequence);
        int length = zzg.length();
        zzgay zzgayVar = this.zzb;
        if (!zzgayVar.zzd(length)) {
            throw new zzgbb("Invalid input length " + zzg.length());
        }
        int i = 0;
        int i2 = 0;
        while (i < zzg.length()) {
            int i3 = i2 + 1;
            int zzb = (zzgayVar.zzb(zzg.charAt(i + 1)) << 12) | (zzgayVar.zzb(zzg.charAt(i)) << 18);
            bArr[i2] = (byte) (zzb >>> 16);
            int i4 = i + 2;
            if (i4 < zzg.length()) {
                int i5 = i + 3;
                int zzb2 = zzb | (zzgayVar.zzb(zzg.charAt(i4)) << 6);
                int i6 = i2 + 2;
                bArr[i3] = (byte) ((zzb2 >>> 8) & 255);
                if (i5 < zzg.length()) {
                    i += 4;
                    i2 += 3;
                    bArr[i6] = (byte) ((zzb2 | zzgayVar.zzb(zzg.charAt(i5))) & 255);
                } else {
                    i2 = i6;
                    i = i5;
                }
            } else {
                i = i4;
                i2 = i3;
            }
        }
        return i2;
    }

    @Override // com.google.android.gms.internal.ads.zzgbc
    final zzgbd zzb(zzgay zzgayVar, Character ch) {
        return new zzgba(zzgayVar, ch);
    }

    @Override // com.google.android.gms.internal.ads.zzgbc, com.google.android.gms.internal.ads.zzgbd
    final void zzc(Appendable appendable, byte[] bArr, int i, int i2) throws IOException {
        int i3 = 0;
        zzfvp.zzk(0, i2, bArr.length);
        for (int i4 = i2; i4 >= 3; i4 -= 3) {
            int i5 = bArr[i3] & 255;
            int i6 = bArr[i3 + 1] & 255;
            int i7 = bArr[i3 + 2] & 255;
            zzgay zzgayVar = this.zzb;
            int i8 = (i6 << 8) | (i5 << 16) | i7;
            appendable.append(zzgayVar.zza(i8 >>> 18));
            appendable.append(zzgayVar.zza((i8 >>> 12) & 63));
            appendable.append(zzgayVar.zza((i8 >>> 6) & 63));
            appendable.append(zzgayVar.zza(i8 & 63));
            i3 += 3;
        }
        if (i3 < i2) {
            zzh(appendable, bArr, i3, i2 - i3);
        }
    }

    zzgba(String str, String str2, Character ch) {
        this(new zzgay(str, str2.toCharArray()), ch);
    }
}
