package com.google.android.gms.internal.ads;

import com.ironsource.D5;
import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public abstract class zzgbd {
    private static final zzgbd zza;

    static {
        Character valueOf = Character.valueOf(D5.T);
        new zzgba("base64()", "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/", valueOf);
        new zzgba("base64Url()", "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-_", valueOf);
        new zzgbc("base32()", "ABCDEFGHIJKLMNOPQRSTUVWXYZ234567", valueOf);
        new zzgbc("base32Hex()", "0123456789ABCDEFGHIJKLMNOPQRSTUV", valueOf);
        zza = new zzgaz("base16()", "0123456789ABCDEF");
    }

    zzgbd() {
    }

    public static zzgbd zzi() {
        return zza;
    }

    abstract int zza(byte[] bArr, CharSequence charSequence) throws zzgbb;

    abstract void zzc(Appendable appendable, byte[] bArr, int i, int i2) throws IOException;

    abstract int zzd(int i);

    abstract int zze(int i);

    public abstract zzgbd zzf();

    CharSequence zzg(CharSequence charSequence) {
        throw null;
    }

    public final String zzj(byte[] bArr, int i, int i2) {
        zzfvp.zzk(0, i2, bArr.length);
        StringBuilder sb = new StringBuilder(zze(i2));
        try {
            zzc(sb, bArr, 0, i2);
            return sb.toString();
        } catch (IOException e) {
            throw new AssertionError(e);
        }
    }

    public final byte[] zzk(CharSequence charSequence) {
        try {
            CharSequence zzg = zzg(charSequence);
            int zzd = zzd(zzg.length());
            byte[] bArr = new byte[zzd];
            int zza2 = zza(bArr, zzg);
            if (zza2 == zzd) {
                return bArr;
            }
            byte[] bArr2 = new byte[zza2];
            System.arraycopy(bArr, 0, bArr2, 0, zza2);
            return bArr2;
        } catch (zzgbb e) {
            throw new IllegalArgumentException(e);
        }
    }
}
