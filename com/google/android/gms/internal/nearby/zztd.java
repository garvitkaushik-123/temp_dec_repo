package com.google.android.gms.internal.nearby;

import java.io.IOException;
import javax.annotation.CheckForNull;

/* compiled from: com.google.android.gms:play-services-nearby@@18.5.0 */
/* loaded from: classes5.dex */
final class zztd extends zztg {
    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    zztd(String str, String str2, @CheckForNull Character ch) {
        super(r0, ch);
        char[] cArr;
        zztb zztbVar = new zztb(str, str2.toCharArray());
        cArr = zztbVar.zzf;
        zzsg.zzd(cArr.length == 64);
    }

    @Override // com.google.android.gms.internal.nearby.zztg, com.google.android.gms.internal.nearby.zzth
    final void zzb(Appendable appendable, byte[] bArr, int i, int i2) throws IOException {
        appendable.getClass();
        int i3 = 0;
        zzsg.zzg(0, i2, bArr.length);
        for (int i4 = i2; i4 >= 3; i4 -= 3) {
            int i5 = bArr[i3] & 255;
            int i6 = ((bArr[i3 + 1] & 255) << 8) | (i5 << 16) | (bArr[i3 + 2] & 255);
            appendable.append(this.zzb.zza(i6 >>> 18));
            appendable.append(this.zzb.zza((i6 >>> 12) & 63));
            appendable.append(this.zzb.zza((i6 >>> 6) & 63));
            appendable.append(this.zzb.zza(i6 & 63));
            i3 += 3;
        }
        if (i3 < i2) {
            zzg(appendable, bArr, i3, i2 - i3);
        }
    }

    @Override // com.google.android.gms.internal.nearby.zztg, com.google.android.gms.internal.nearby.zzth
    final int zza(byte[] bArr, CharSequence charSequence) throws zzte {
        bArr.getClass();
        CharSequence zzf = zzf(charSequence);
        if (!this.zzb.zzc(zzf.length())) {
            throw new zzte("Invalid input length " + zzf.length());
        }
        int i = 0;
        int i2 = 0;
        while (i < zzf.length()) {
            int i3 = i2 + 1;
            int zzb = (this.zzb.zzb(zzf.charAt(i)) << 18) | (this.zzb.zzb(zzf.charAt(i + 1)) << 12);
            bArr[i2] = (byte) (zzb >>> 16);
            int i4 = i + 2;
            if (i4 < zzf.length()) {
                int i5 = i + 3;
                int zzb2 = zzb | (this.zzb.zzb(zzf.charAt(i4)) << 6);
                int i6 = i2 + 2;
                bArr[i3] = (byte) ((zzb2 >>> 8) & 255);
                if (i5 < zzf.length()) {
                    i += 4;
                    i2 += 3;
                    bArr[i6] = (byte) ((zzb2 | this.zzb.zzb(zzf.charAt(i5))) & 255);
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
}
