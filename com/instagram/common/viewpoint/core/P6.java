package com.instagram.common.viewpoint.core;

import com.google.common.base.Ascii;
import com.ironsource.D5;
import java.util.Arrays;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* loaded from: assets/audience_network/classes2.dex */
public final class P6<E> implements Cloneable {
    public static byte[] A04;
    public static String[] A05 = {"3rdfmaS4Bvs6KD5DohCaazKJ5nPjrowZ", "nk5cgk6zHA99knZ4VIBWP6swe9j6XVxJ", "SR1GrmmGZb5WiV5DUpa8V4qNmvh", "hXJT0tWkN7S4w3G0a7yWDauM9ZCHUr7o", "HR23fndUBIfy3sX8NPdMDAzNZ7ikzeu", "Yza27yUTeZsQZywWns2Eqk9QSJgdTaNC", "To1PPTsvrqg0vOGGncKBfzj1ovx9xtsA", "AHHllHZ2j6xopeQt7"};
    public static final Object A06;
    public int A00;
    public boolean A01;
    public long[] A02;
    public Object[] A03;

    public static String A03(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A04, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] ^ i3) ^ 104);
        }
        return new String(copyOfRange);
    }

    public static void A05() {
        A04 = new byte[]{107, 55, 43, 42, 48, 99, Ascii.SO, 34, 51, 106, 4, 8, Ascii.EM, Ascii.US};
    }

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException: Index 6 out of bounds for length 6
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.startVar(DebugInfoParser.java:203)
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.process(DebugInfoParser.java:135)
    	at jadx.plugins.input.dex.sections.DexCodeReader.getDebugInfo(DexCodeReader.java:122)
    	at jadx.core.dex.nodes.MethodNode.getDebugInfo(MethodNode.java:636)
    	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.visit(DebugInfoAttachVisitor.java:38)
     */
    public final String toString() {
        if (A06() <= 0) {
            String A03 = A03(12, 2, 10);
            String[] strArr = A05;
            if (strArr[6].charAt(16) != strArr[5].charAt(16)) {
                throw new RuntimeException();
            }
            String[] strArr2 = A05;
            strArr2[1] = "Skpu9y55M8HCr5nD5qLEIrlUv7DMUr8f";
            strArr2[3] = "83PSjIhGPkyHWD5a17BzKCZMIovhzHLb";
            return A03;
        }
        StringBuilder sb = new StringBuilder(this.A00 * 28);
        sb.append(AbstractJsonLexerKt.BEGIN_OBJ);
        for (int i = 0; i < this.A00; i++) {
            if (i > 0) {
                sb.append(A03(10, 2, 64));
            }
            sb.append(A00(i));
            sb.append(D5.T);
            E A07 = A07(i);
            if (A07 != this) {
                sb.append(A07);
            } else {
                sb.append(A03(0, 10, 43));
            }
        }
        sb.append(AbstractJsonLexerKt.END_OBJ);
        return sb.toString();
    }

    static {
        A05();
        A06 = new Object();
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.P6 != com.facebook.ads.internal.androidx.support.v4.util.LongSparseArray<E> */
    public P6() {
        this(10);
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.P6 != com.facebook.ads.internal.androidx.support.v4.util.LongSparseArray<E> */
    public P6(int i) {
        this.A01 = false;
        if (i == 0) {
            this.A02 = P5.A02;
            this.A03 = P5.A03;
        } else {
            int A00 = P5.A00(i);
            this.A02 = new long[A00];
            this.A03 = new Object[A00];
        }
        this.A00 = 0;
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.P6 != com.facebook.ads.internal.androidx.support.v4.util.LongSparseArray<E> */
    private final long A00(int i) {
        if (this.A01) {
            A04();
        }
        return this.A02[i];
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.P6 != com.facebook.ads.internal.androidx.support.v4.util.LongSparseArray<E> */
    /* renamed from: A01, reason: merged with bridge method [inline-methods] */
    public final P6<E> clone() {
        P6<E> p6 = null;
        try {
            p6 = (P6) super.clone();
            p6.A02 = (long[]) this.A02.clone();
            p6.A03 = (Object[]) this.A03.clone();
            return p6;
        } catch (CloneNotSupportedException unused) {
            return p6;
        }
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.P6 != com.facebook.ads.internal.androidx.support.v4.util.LongSparseArray<E> */
    private final E A02(long j, E e) {
        int A03 = P5.A03(this.A02, this.A00, j);
        if (A03 >= 0) {
            Object[] objArr = this.A03;
            if (A05[7].length() != 17) {
                throw new RuntimeException();
            }
            A05[2] = "jXlMUCcAItIj0GcupoJ3Otj";
            if (objArr[A03] != A06) {
                return (E) this.A03[A03];
            }
        }
        return e;
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.P6 != com.facebook.ads.internal.androidx.support.v4.util.LongSparseArray<E> */
    private void A04() {
        int i = this.A00;
        int i2 = 0;
        long[] jArr = this.A02;
        Object[] objArr = this.A03;
        for (int i3 = 0; i3 < i; i3++) {
            Object obj = objArr[i3];
            if (obj != A06) {
                if (i3 != i2) {
                    jArr[i2] = jArr[i3];
                    objArr[i2] = obj;
                    objArr[i3] = null;
                }
                i2++;
            }
        }
        this.A01 = false;
        this.A00 = i2;
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.P6 != com.facebook.ads.internal.androidx.support.v4.util.LongSparseArray<E> */
    public final int A06() {
        if (this.A01) {
            A04();
        }
        int i = this.A00;
        String[] strArr = A05;
        if (strArr[6].charAt(16) != strArr[5].charAt(16)) {
            throw new RuntimeException();
        }
        A05[4] = "ypCZ";
        return i;
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.P6 != com.facebook.ads.internal.androidx.support.v4.util.LongSparseArray<E> */
    public final E A07(int i) {
        if (this.A01) {
            A04();
        }
        return (E) this.A03[i];
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.P6 != com.facebook.ads.internal.androidx.support.v4.util.LongSparseArray<E> */
    public final E A08(long j) {
        return A02(j, null);
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.P6 != com.facebook.ads.internal.androidx.support.v4.util.LongSparseArray<E> */
    public final void A09() {
        int i = this.A00;
        Object[] objArr = this.A03;
        for (int i2 = 0; i2 < i; i2++) {
            objArr[i2] = null;
        }
        this.A00 = 0;
        this.A01 = false;
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.P6 != com.facebook.ads.internal.androidx.support.v4.util.LongSparseArray<E> */
    public final void A0A(int i) {
        if (this.A03[i] != A06) {
            this.A03[i] = A06;
            this.A01 = true;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0056, code lost:
    
        if (r4 != false) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0058, code lost:
    
        r1 = r8.A00;
        r0 = r8.A02.length;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x005d, code lost:
    
        if (r1 < r0) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x005f, code lost:
    
        A04();
        r1 = r8.A02;
        r0 = r8.A00;
        r3 = ~com.instagram.common.viewpoint.core.P5.A03(r1, r0, r9);
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x006b, code lost:
    
        r4 = r8.A00;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0078, code lost:
    
        if (com.instagram.common.viewpoint.core.P6.A05[7].length() == 17) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x007f, code lost:
    
        throw new java.lang.RuntimeException();
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x008a, code lost:
    
        com.instagram.common.viewpoint.core.P6.A05[7] = "rLvHDd51XfoeTGgnr";
        r0 = r8.A02.length;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0094, code lost:
    
        if (r4 < r0) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0096, code lost:
    
        r0 = r8.A00;
        r0 = com.instagram.common.viewpoint.core.P5.A00(r0 + 1);
        r5 = new long[r0];
        r4 = new java.lang.Object[r0];
        r7 = r8.A02;
        r6 = r8.A02.length;
        r1 = com.instagram.common.viewpoint.core.P6.A05[7].length();
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x00b2, code lost:
    
        if (r1 == 17) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x00ba, code lost:
    
        com.instagram.common.viewpoint.core.P6.A05[2] = "L48OP70swgk";
        java.lang.System.arraycopy(r7, 0, r5, 0, r6);
        r1 = r8.A03;
        r0 = r8.A03.length;
        java.lang.System.arraycopy(r1, 0, r4, 0, r0);
        r8.A02 = r5;
        r8.A03 = r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x00d1, code lost:
    
        r0 = r8.A00;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x00d4, code lost:
    
        if ((r0 - r3) == 0) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x00d6, code lost:
    
        r0 = r8.A00;
        java.lang.System.arraycopy(r8.A02, r3, r8.A02, r3 + 1, r0 - r3);
        r0 = r8.A00;
        java.lang.System.arraycopy(r8.A03, r3, r8.A03, r3 + 1, r0 - r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x00ee, code lost:
    
        r8.A02[r3] = r9;
        r8.A03[r3] = r11;
        r0 = r8.A00;
        r8.A00 = r0 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:?, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0087, code lost:
    
        if (r4 != false) goto L18;
     */
    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.P6 != com.facebook.ads.internal.androidx.support.v4.util.LongSparseArray<E> */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void A0B(long j, E e) {
        int A03 = P5.A03(this.A02, this.A00, j);
        if (A03 >= 0) {
            Object[] objArr = this.A03;
            if (A05[4].length() != 11) {
                A05[2] = "zIN2";
                objArr[A03] = e;
                return;
            }
        } else {
            int i = ~A03;
            int i2 = this.A00;
            if (i < i2 && this.A03[i] == A06) {
                this.A02[i] = j;
                this.A03[i] = e;
                return;
            }
            boolean z = this.A01;
            String[] strArr = A05;
            String str = strArr[1];
            String str2 = strArr[3];
            int charAt = str.charAt(17);
            int i3 = str2.charAt(17);
            if (charAt != i3) {
                A05[0] = "5FIvphvUgQVU1M732kCMD6tquLVSGC6u";
            } else {
                A05[2] = "2a9UU1wdCLKEgsYJNRrqpR";
            }
        }
        throw new RuntimeException();
    }
}
