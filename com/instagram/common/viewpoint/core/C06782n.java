package com.instagram.common.viewpoint.core;

import android.util.SparseBooleanArray;

/* renamed from: com.facebook.ads.redexgen.X.2n, reason: invalid class name and case insensitive filesystem */
/* loaded from: assets/audience_network/classes2.dex */
public final class C06782n {
    public static String[] A01 = {"ZtAeFZn0B1qTMkAv4TimNf", "onjqbWPlpraCurTtWuR0R", "izLFZdnLPv7lUm1GFercP1dDHTQqqlbm", "06udDjCQiMTHlo", "ThrPk51efRSGKxf", "UllMG4WENFsjBGTIREywCD", "xUDuL0NOtKss50bSSzha3FmKwjhZHM", "2ZQ9"};
    public final SparseBooleanArray A00;

    public C06782n(SparseBooleanArray sparseBooleanArray) {
        this.A00 = sparseBooleanArray;
    }

    public final int A00() {
        return this.A00.size();
    }

    public final int A01(int i) {
        AbstractC07133y.A00(i, 0, A00());
        return this.A00.keyAt(i);
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0046, code lost:
    
        if (r4 != r3) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0048, code lost:
    
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0053, code lost:
    
        r5 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0058, code lost:
    
        if (r5 >= A00()) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x005a, code lost:
    
        r4 = A01(r5);
        r3 = r9.A01(r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x006c, code lost:
    
        if (com.instagram.common.viewpoint.core.C06782n.A01[5].length() == 1) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x006e, code lost:
    
        r2 = com.instagram.common.viewpoint.core.C06782n.A01;
        r2[4] = "0EnUC3S7s3BqIyD";
        r2[7] = "m0OD";
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x007a, code lost:
    
        if (r4 == r3) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x007d, code lost:
    
        r5 = r5 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x007c, code lost:
    
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0085, code lost:
    
        throw new java.lang.RuntimeException();
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0086, code lost:
    
        return true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0050, code lost:
    
        if (r4 != r3) goto L17;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C06782n)) {
            return false;
        }
        C06782n c06782n = (C06782n) obj;
        int i = C5C.A02;
        if (A01[6].length() != 30) {
            throw new RuntimeException();
        }
        String[] strArr = A01;
        strArr[3] = "V79UaeNQVFwVWh";
        strArr[1] = "sTKtjiNlOf72YkaUZZtiJ";
        if (i < 24) {
            int A00 = A00();
            int A002 = c06782n.A00();
            if (A01[6].length() == 30) {
                A01[2] = "gWINzXnVkNSV1XpcBprNZ7cfktAxvgY6";
            }
        } else {
            return this.A00.equals(c06782n.A00);
        }
    }

    /* JADX WARN: Incorrect condition in loop: B:5:0x000f */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final int hashCode() {
        if (C5C.A02 < 24) {
            int A00 = A00();
            for (int i = 0; i < hashCode; i++) {
                int hashCode = A01(i);
                A00 = (A00 * 31) + hashCode;
                int i2 = A01[0].length();
                if (i2 == 12) {
                    throw new RuntimeException();
                }
                A01[2] = "oTlXYQnTcFkgjJigc1HTEJLN2hql86lz";
            }
            return A00;
        }
        return this.A00.hashCode();
    }
}
