package com.bytedance.sdk.component.DbA.eli.DbA;

import com.google.common.base.Ascii;
import com.ironsource.C3040d4;
import io.ktor.util.date.GMTDateParser;
import java.io.Serializable;
import java.nio.charset.Charset;
import java.util.Arrays;

/* loaded from: classes3.dex */
public class aGH implements Serializable, Comparable<aGH> {
    transient String MGA;
    final byte[] aGH;
    transient int ui;
    static final char[] eli = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', GMTDateParser.DAY_OF_MONTH, 'e', 'f'};
    public static final Charset DbA = Charset.forName("UTF-8");
    public static final aGH Os = eli(new byte[0]);

    aGH(byte[] bArr) {
        this.aGH = bArr;
    }

    public static aGH eli(byte... bArr) {
        if (bArr == null) {
            throw new IllegalArgumentException("data == null");
        }
        return new aGH((byte[]) bArr.clone());
    }

    public String eli() {
        String str = this.MGA;
        if (str != null) {
            return str;
        }
        String str2 = new String(this.aGH, DbA);
        this.MGA = str2;
        return str2;
    }

    public String DbA() {
        byte[] bArr = this.aGH;
        char[] cArr = new char[bArr.length * 2];
        int i = 0;
        for (byte b : bArr) {
            int i2 = i + 1;
            char[] cArr2 = eli;
            cArr[i] = cArr2[(b >> 4) & 15];
            i += 2;
            cArr[i2] = cArr2[b & Ascii.SI];
        }
        return new String(cArr);
    }

    public aGH eli(int i, int i2) {
        if (i < 0) {
            throw new IllegalArgumentException("beginIndex < 0");
        }
        byte[] bArr = this.aGH;
        if (i2 > bArr.length) {
            throw new IllegalArgumentException("endIndex > length(" + this.aGH.length + ")");
        }
        int i3 = i2 - i;
        if (i3 < 0) {
            throw new IllegalArgumentException("endIndex < beginIndex");
        }
        if (i == 0 && i2 == bArr.length) {
            return this;
        }
        byte[] bArr2 = new byte[i3];
        System.arraycopy(bArr, i, bArr2, 0, i3);
        return new aGH(bArr2);
    }

    public byte eli(int i) {
        return this.aGH[i];
    }

    public int Os() {
        return this.aGH.length;
    }

    public byte[] aGH() {
        return (byte[]) this.aGH.clone();
    }

    public boolean eli(int i, aGH agh, int i2, int i3) {
        return agh.eli(i2, this.aGH, i, i3);
    }

    public boolean eli(int i, byte[] bArr, int i2, int i3) {
        if (i < 0) {
            return false;
        }
        byte[] bArr2 = this.aGH;
        return i <= bArr2.length - i3 && i2 >= 0 && i2 <= bArr.length - i3 && FC.eli(bArr2, i, bArr, i2, i3);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof aGH) {
            aGH agh = (aGH) obj;
            int Os2 = agh.Os();
            byte[] bArr = this.aGH;
            if (Os2 == bArr.length && agh.eli(0, bArr, 0, bArr.length)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int i = this.ui;
        if (i != 0) {
            return i;
        }
        int hashCode = Arrays.hashCode(this.aGH);
        this.ui = hashCode;
        return hashCode;
    }

    @Override // java.lang.Comparable
    /* renamed from: eli, reason: merged with bridge method [inline-methods] */
    public int compareTo(aGH agh) {
        int Os2 = Os();
        int Os3 = agh.Os();
        int min = Math.min(Os2, Os3);
        for (int i = 0; i < min; i++) {
            int eli2 = eli(i) & 255;
            int eli3 = agh.eli(i) & 255;
            if (eli2 != eli3) {
                return eli2 < eli3 ? -1 : 1;
            }
        }
        if (Os2 == Os3) {
            return 0;
        }
        return Os2 < Os3 ? -1 : 1;
    }

    public String toString() {
        if (this.aGH.length == 0) {
            return "[size=0]";
        }
        String eli2 = eli();
        int eli3 = eli(eli2, 64);
        if (eli3 == -1) {
            if (this.aGH.length > 64) {
                return "[size=" + this.aGH.length + " hex=" + eli(0, 64).DbA() + "…]";
            }
            return "[hex=" + DbA() + C3040d4.i.e;
        }
        String replace = eli2.substring(0, eli3).replace("\\", "\\\\").replace("\n", "\\n").replace("\r", "\\r");
        return eli3 < eli2.length() ? "[size=" + this.aGH.length + " text=" + replace + "…]" : "[text=" + replace + C3040d4.i.e;
    }

    static int eli(String str, int i) {
        int length = str.length();
        int i2 = 0;
        int i3 = 0;
        while (i2 < length) {
            if (i3 == i) {
                return i2;
            }
            int codePointAt = str.codePointAt(i2);
            if ((Character.isISOControl(codePointAt) && codePointAt != 10 && codePointAt != 13) || codePointAt == 65533) {
                return -1;
            }
            i3++;
            i2 += Character.charCount(codePointAt);
        }
        return str.length();
    }
}
