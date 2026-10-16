package com.google.android.gms.internal.ads;

import com.ironsource.D5;
import java.io.IOException;
import java.math.RoundingMode;
import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
class zzgbc extends zzgbd {
    private volatile zzgbd zza;
    final zzgay zzb;
    final Character zzc;

    zzgbc(zzgay zzgayVar, Character ch) {
        this.zzb = zzgayVar;
        boolean z = true;
        if (ch != null) {
            ch.charValue();
            if (zzgayVar.zze(D5.T)) {
                z = false;
            }
        }
        zzfvp.zzi(z, "Padding character %s was already in alphabet", ch);
        this.zzc = ch;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof zzgbc) {
            zzgbc zzgbcVar = (zzgbc) obj;
            if (this.zzb.equals(zzgbcVar.zzb) && Objects.equals(this.zzc, zzgbcVar.zzc)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        Character ch = this.zzc;
        return Objects.hashCode(ch) ^ this.zzb.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("BaseEncoding.");
        zzgay zzgayVar = this.zzb;
        sb.append(zzgayVar);
        if (8 % zzgayVar.zzb != 0) {
            Character ch = this.zzc;
            if (ch == null) {
                sb.append(".omitPadding()");
            } else {
                sb.append(".withPadChar('");
                sb.append(ch);
                sb.append("')");
            }
        }
        return sb.toString();
    }

    @Override // com.google.android.gms.internal.ads.zzgbd
    int zza(byte[] bArr, CharSequence charSequence) throws zzgbb {
        int i;
        CharSequence zzg = zzg(charSequence);
        int length = zzg.length();
        zzgay zzgayVar = this.zzb;
        if (!zzgayVar.zzd(length)) {
            throw new zzgbb("Invalid input length " + zzg.length());
        }
        int i2 = 0;
        int i3 = 0;
        while (i2 < zzg.length()) {
            long j = 0;
            int i4 = 0;
            int i5 = 0;
            while (true) {
                i = zzgayVar.zzc;
                if (i4 >= i) {
                    break;
                }
                j <<= zzgayVar.zzb;
                if (i2 + i4 < zzg.length()) {
                    j |= zzgayVar.zzb(zzg.charAt(i5 + i2));
                    i5++;
                }
                i4++;
            }
            int i6 = zzgayVar.zzd;
            int i7 = i5 * zzgayVar.zzb;
            int i8 = (i6 - 1) * 8;
            while (i8 >= (i6 * 8) - i7) {
                bArr[i3] = (byte) ((j >>> i8) & 255);
                i8 -= 8;
                i3++;
            }
            i2 += i;
        }
        return i3;
    }

    zzgbd zzb(zzgay zzgayVar, Character ch) {
        return new zzgbc(zzgayVar, ch);
    }

    @Override // com.google.android.gms.internal.ads.zzgbd
    void zzc(Appendable appendable, byte[] bArr, int i, int i2) throws IOException {
        int i3 = 0;
        zzfvp.zzk(0, i2, bArr.length);
        while (i3 < i2) {
            int i4 = this.zzb.zzd;
            zzh(appendable, bArr, i3, Math.min(i4, i2 - i3));
            i3 += i4;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgbd
    final int zzd(int i) {
        return (int) (((this.zzb.zzb * i) + 7) / 8);
    }

    @Override // com.google.android.gms.internal.ads.zzgbd
    final int zze(int i) {
        zzgay zzgayVar = this.zzb;
        return zzgayVar.zzc * zzgbm.zzb(i, zzgayVar.zzd, RoundingMode.CEILING);
    }

    @Override // com.google.android.gms.internal.ads.zzgbd
    public final zzgbd zzf() {
        zzgbd zzgbdVar = this.zza;
        if (zzgbdVar == null) {
            zzgay zzgayVar = this.zzb;
            zzgay zzc = zzgayVar.zzc();
            zzgbdVar = zzc == zzgayVar ? this : zzb(zzc, this.zzc);
            this.zza = zzgbdVar;
        }
        return zzgbdVar;
    }

    final void zzh(Appendable appendable, byte[] bArr, int i, int i2) throws IOException {
        zzfvp.zzk(i, i + i2, bArr.length);
        zzgay zzgayVar = this.zzb;
        int i3 = zzgayVar.zzd;
        int i4 = 0;
        zzfvp.zze(i2 <= i3);
        long j = 0;
        for (int i5 = 0; i5 < i2; i5++) {
            j = (j | (bArr[i + i5] & 255)) << 8;
        }
        int i6 = (i2 + 1) * 8;
        int i7 = zzgayVar.zzb;
        while (i4 < i2 * 8) {
            appendable.append(zzgayVar.zza(zzgayVar.zza & ((int) (j >>> ((i6 - i7) - i4)))));
            i4 += i7;
        }
        Character ch = this.zzc;
        if (ch != null) {
            while (i4 < i3 * 8) {
                ch.charValue();
                appendable.append(D5.T);
                i4 += i7;
            }
        }
    }

    zzgbc(String str, String str2, Character ch) {
        this(new zzgay(str, str2.toCharArray()), ch);
    }

    @Override // com.google.android.gms.internal.ads.zzgbd
    final CharSequence zzg(CharSequence charSequence) {
        charSequence.getClass();
        Character ch = this.zzc;
        if (ch == null) {
            return charSequence;
        }
        ch.charValue();
        int length = charSequence.length();
        do {
            length--;
            if (length < 0) {
                break;
            }
        } while (charSequence.charAt(length) == '=');
        return charSequence.subSequence(0, length + 1);
    }
}
