package com.instagram.common.viewpoint.core;

import com.google.common.base.Ascii;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* renamed from: com.facebook.ads.redexgen.X.mc, reason: case insensitive filesystem */
/* loaded from: assets/audience_network/classes2.dex */
public final class C2264mc extends AbstractC1053Hu {
    public static byte[] A03;
    public static String[] A04 = {"hpDJt5h1KEOoxvwsMFQNYPr", "VSvt5SXm5usvlgrWoNvpXkXh8Dq", "BGFNPpHl8d5ErpIW7AfimlhS91R1U6wd", "7dPt9qHZlpxHIlw3mPQ6xbLk1XOmee", "0b", "V5zubMgZbVWtRFu8X", "n5IVAqV2SnF", "Sg4r6ty2QhZ"};
    public long A00;
    public long[] A01;
    public long[] A02;

    public static String A04(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A03, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] - i3) - 92);
        }
        return new String(copyOfRange);
    }

    public static void A0A() {
        A03 = new byte[]{-39, -22, -25, -42, -23, -34, -28, -29, -43, -40, -37, -44, -33, -34, -30, -40, -29, -40, -34, -35, -30, -32, -38, -18, -37, -25, -42, -30, -38, -24, -25, -26, -59, -35, -20, -39, -68, -39, -20, -39, 35, Ascii.CAN, Ascii.FS, Ascii.DC4, 34};
    }

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    @Override // com.instagram.common.viewpoint.core.AbstractC1053Hu
    public final boolean A0C(C07364v c07364v, long j) {
        int i;
        if (A00(c07364v) != 2) {
            return false;
        }
        String A05 = A05(c07364v);
        if (A04[2].charAt(14) == 'f') {
            throw new RuntimeException();
        }
        A04[2] = "yhTvZHDsLiRhvHdxFLG6a7MHjxNmCRFd";
        if (!A04(30, 10, 28).equals(A05) || c07364v.A07() == 0 || A00(c07364v) != 8) {
            return false;
        }
        HashMap<String, Object> A08 = A08(c07364v);
        Object obj = A08.get(A04(0, 8, 25));
        if (obj instanceof Double) {
            double doubleValue = ((Double) obj).doubleValue();
            if (doubleValue > 0.0d) {
                this.A00 = (long) (doubleValue * 1000000.0d);
            }
        }
        Object obj2 = A08.get(A04(21, 9, 25));
        if (!(obj2 instanceof Map)) {
            return false;
        }
        Map map = (Map) obj2;
        Object obj3 = map.get(A04(8, 13, 19));
        Object obj4 = map.get(A04(40, 5, 83));
        if (!(obj3 instanceof List) || !(obj4 instanceof List)) {
            return false;
        }
        List list = (List) obj3;
        List list2 = (List) obj4;
        int size = list2.size();
        long[] jArr = new long[size];
        if (A04[3].length() != 20) {
            A04[1] = "ycK0oDKd1FWGh";
            this.A02 = jArr;
            this.A01 = new long[size];
            i = 0;
        } else {
            A04[3] = "l8UzOy1g7iACMRm";
            this.A02 = jArr;
            this.A01 = new long[size];
            i = 0;
        }
        while (i < size) {
            Object obj5 = list.get(i);
            Object obj6 = list2.get(i);
            if (!(obj6 instanceof Double) || !(obj5 instanceof Double)) {
                this.A02 = new long[0];
                this.A01 = new long[0];
                return false;
            }
            this.A02[i] = (long) (((Double) obj6).doubleValue() * 1000000.0d);
            this.A01[i] = ((Double) obj5).longValue();
            i++;
        }
        return false;
    }

    static {
        A0A();
    }

    public C2264mc() {
        super(new C2281mt());
        this.A00 = -9223372036854775807L;
        this.A02 = new long[0];
        this.A01 = new long[0];
    }

    public static int A00(C07364v c07364v) {
        return c07364v.A0I();
    }

    public static Boolean A01(C07364v c07364v) {
        return Boolean.valueOf(c07364v.A0I() == 1);
    }

    public static Double A02(C07364v c07364v) {
        return Double.valueOf(Double.longBitsToDouble(c07364v.A0P()));
    }

    public static Object A03(C07364v c07364v, int i) {
        switch (i) {
            case 0:
                return A02(c07364v);
            case 1:
                return A01(c07364v);
            case 2:
                return A05(c07364v);
            case 3:
                return A09(c07364v);
            case 4:
            case 5:
            case 6:
            case 7:
            case 9:
            default:
                return null;
            case 8:
                return A08(c07364v);
            case 10:
                return A06(c07364v);
            case 11:
                return A07(c07364v);
        }
    }

    public static String A05(C07364v c07364v) {
        int A0M = c07364v.A0M();
        int A09 = c07364v.A09();
        c07364v.A0g(A0M);
        return new String(c07364v.A0l(), A09, A0M);
    }

    public static ArrayList<Object> A06(C07364v c07364v) {
        int A0L = c07364v.A0L();
        ArrayList<Object> arrayList = new ArrayList<>(A0L);
        for (int i = 0; i < A0L; i++) {
            int count = A00(c07364v);
            Object A032 = A03(c07364v, count);
            if (A032 != null) {
                arrayList.add(A032);
            }
        }
        return arrayList;
    }

    public static Date A07(C07364v c07364v) {
        Date date = new Date((long) A02(c07364v).doubleValue());
        c07364v.A0g(2);
        return date;
    }

    public static HashMap<String, Object> A08(C07364v c07364v) {
        int A0L = c07364v.A0L();
        HashMap<String, Object> hashMap = new HashMap<>(A0L);
        for (int i = 0; i < A0L; i++) {
            String A05 = A05(c07364v);
            int count = A00(c07364v);
            Object A032 = A03(c07364v, count);
            if (A032 != null) {
                hashMap.put(A05, A032);
            }
        }
        return hashMap;
    }

    public static HashMap<String, Object> A09(C07364v c07364v) {
        HashMap<String, Object> hashMap = new HashMap<>();
        while (true) {
            String A05 = A05(c07364v);
            int A00 = A00(c07364v);
            if (A00 == 9) {
                return hashMap;
            }
            Object A032 = A03(c07364v, A00);
            if (A032 != null) {
                hashMap.put(A05, A032);
            }
        }
    }

    @Override // com.instagram.common.viewpoint.core.AbstractC1053Hu
    public final boolean A0B(C07364v c07364v) {
        return true;
    }

    public final long A0D() {
        return this.A00;
    }

    public final long[] A0E() {
        return this.A01;
    }

    public final long[] A0F() {
        return this.A02;
    }
}
