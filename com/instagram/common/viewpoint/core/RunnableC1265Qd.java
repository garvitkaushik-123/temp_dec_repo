package com.instagram.common.viewpoint.core;

import com.google.common.base.Ascii;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.concurrent.TimeUnit;

/* renamed from: com.facebook.ads.redexgen.X.Qd, reason: case insensitive filesystem */
/* loaded from: assets/audience_network/classes2.dex */
public final class RunnableC1265Qd implements Runnable {
    public static Comparator<C1264Qc> A04;
    public static byte[] A05;
    public static String[] A06 = {"ZWObiMwNkhaZGfEgqHenCxQvRQCezgXM", "iKaB5ntiNbaiz6tgW", "JplxjEE1IYbCInXXNCkbxZV0", "UEoPOy6vCmPnpiXEMXmcZKvRtDoHf0nN", "JvUlYJe7lgtJoJN1gtwvhyIs", "RcG3r4ysor4dcgCWVGn8CFYsdgQ7jZkt", "cxmAjzJ", "EyohaYHYoMvb6y9gFGiucolIeU60NsdM"};
    public static final ThreadLocal<RunnableC1265Qd> A07;
    public long A00;
    public long A01;
    public ArrayList<C7M> A02 = new ArrayList<>();
    public ArrayList<C1264Qc> A03 = new ArrayList<>();

    public static String A01(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A05, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] ^ i3) ^ 104);
        }
        return new String(copyOfRange);
    }

    public static void A03() {
        A05 = new byte[]{105, 109, Ascii.ESC, 117, 94, 72, 79, 94, 95, Ascii.ESC, 107, 73, 94, 93, 94, 79, 88, 83, 100, 96, Ascii.SYN, 102, 68, 83, 80, 83, 66, 85, 94};
    }

    static {
        A03();
        A07 = new ThreadLocal<>();
        A04 = new C1263Qb();
    }

    private RK A00(C7M c7m, int i, long j) {
        if (A08(c7m, i)) {
            return null;
        }
        RA ra = c7m.A0r;
        try {
            c7m.A1M();
            RK A0I = ra.A0I(i, false, j);
            if (A0I != null) {
                if (A0I.A0e() && !A0I.A0f()) {
                    ra.A0T(A0I.A0H);
                } else {
                    ra.A0Z(A0I, false);
                }
            }
            return A0I;
        } finally {
            c7m.A1o(false);
        }
    }

    /* JADX WARN: Incorrect condition in loop: B:17:0x0054 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void A02() {
        C1264Qc c1264Qc;
        int size = this.A02.size();
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            C7M c7m = this.A02.get(i2);
            int viewCount = c7m.getWindowVisibility();
            if (viewCount == 0) {
                c7m.A02.A04(c7m, false);
                int viewCount2 = c7m.A02.A00;
                i += viewCount2;
            }
        }
        this.A03.ensureCapacity(i);
        int j = 0;
        for (int i3 = 0; i3 < size; i3++) {
            C7M c7m2 = this.A02.get(i3);
            int viewCount3 = c7m2.getWindowVisibility();
            if (viewCount3 == 0) {
                C2000hs c2000hs = c7m2.A02;
                int viewCount4 = c2000hs.A01;
                int i4 = Math.abs(viewCount4);
                int viewCount5 = c2000hs.A02;
                int i5 = i4 + Math.abs(viewCount5);
                for (int i6 = 0; i6 < viewCount * 2; i6 += 2) {
                    int viewCount6 = this.A03.size();
                    if (j >= viewCount6) {
                        c1264Qc = new C1264Qc();
                        this.A03.add(c1264Qc);
                    } else {
                        c1264Qc = this.A03.get(j);
                    }
                    int totalTaskCount = i6 + 1;
                    int totalTaskIndex = c2000hs.A03[totalTaskCount];
                    c1264Qc.A04 = totalTaskIndex <= i5;
                    c1264Qc.A02 = i5;
                    c1264Qc.A00 = totalTaskIndex;
                    c1264Qc.A03 = c7m2;
                    int totalTaskCount2 = c2000hs.A03[i6];
                    c1264Qc.A01 = totalTaskCount2;
                    j++;
                }
            }
        }
        Collections.sort(this.A03, A04);
    }

    /* JADX WARN: Incorrect condition in loop: B:3:0x0007 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void A04(long j) {
        for (int i = 0; i < i; i++) {
            C1264Qc c1264Qc = this.A03.get(i);
            if (A06[7].charAt(15) != 'g') {
                throw new RuntimeException();
            }
            A06[6] = "gpZ2KV2";
            C1264Qc c1264Qc2 = c1264Qc;
            if (c1264Qc2.A03 == null) {
                return;
            }
            A06(c1264Qc2, j);
            c1264Qc2.A00();
        }
    }

    private final void A05(long j) {
        A02();
        A04(j);
    }

    private void A06(C1264Qc c1264Qc, long j) {
        RK A00 = A00(c1264Qc.A03, c1264Qc.A01, c1264Qc.A04 ? Long.MAX_VALUE : j);
        if (A00 != null && A00.A09 != null && A00.A0e() && !A00.A0f()) {
            C7M c7m = A00.A09.get();
            if (A06[3].charAt(4) != 'O') {
                throw new RuntimeException();
            }
            String[] strArr = A06;
            strArr[0] = "y01bdO2VJYUoPT1JEr7HCeGbjhjinZRt";
            strArr[5] = "ogbTL45N3M3fzw26YptkCantwmvhDLLM";
            A07(c7m, j);
        }
    }

    private void A07(C7M c7m, long j) {
        if (c7m == null) {
            return;
        }
        if (c7m.A0C && c7m.A01.A06() != 0) {
            c7m.A1P();
        }
        C2000hs c2000hs = c7m.A02;
        c2000hs.A04(c7m, true);
        if (c2000hs.A00 != 0) {
            try {
                P4.A01(A01(0, 18, 83));
                c7m.A0s.A05(c7m.A04);
                for (int i = 0; i < c2000hs.A00 * 2; i += 2) {
                    A00(c7m, c2000hs.A03[i], j);
                }
            } finally {
                P4.A00();
            }
        }
    }

    public static boolean A08(C7M c7m, int i) {
        int A062 = c7m.A01.A06();
        for (int i2 = 0; i2 < A062; i2++) {
            RK A0F = C7M.A0F(c7m.A01.A0A(i2));
            int childCount = A0F.A03;
            if (childCount == i && !A0F.A0f()) {
                return true;
            }
        }
        return false;
    }

    public final void A09(C7M c7m) {
        this.A02.add(c7m);
    }

    public final void A0A(C7M c7m) {
        this.A02.remove(c7m);
    }

    public final void A0B(C7M c7m, int i, int i2) {
        if (c7m.isAttachedToWindow()) {
            long j = this.A01;
            String[] strArr = A06;
            if (strArr[0].charAt(20) != strArr[5].charAt(20)) {
                throw new RuntimeException();
            }
            A06[6] = "T8Y6UBY";
            if (j == 0) {
                this.A01 = c7m.getNanoTime();
                c7m.post(this);
            }
        }
        c7m.A02.A03(i, i2);
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            P4.A01(A01(18, 11, 94));
            if (this.A02.isEmpty()) {
                this.A01 = 0L;
                if (A06[6].length() != 7) {
                    throw new RuntimeException();
                }
                A06[7] = "jOxF3Mzmcdx8L8GgZmI4I6pGAsyGGZV3";
                P4.A00();
                return;
            }
            int size = this.A02.size();
            long j = 0;
            for (int i = 0; i < size; i++) {
                C7M c7m = this.A02.get(i);
                if (c7m.getWindowVisibility() == 0) {
                    j = Math.max(c7m.getDrawingTime(), j);
                }
            }
            if (j == 0) {
                return;
            }
            A05(TimeUnit.MILLISECONDS.toNanos(j) + this.A00);
        } finally {
            this.A01 = 0L;
            P4.A00();
        }
    }
}
