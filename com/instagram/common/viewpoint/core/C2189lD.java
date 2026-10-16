package com.instagram.common.viewpoint.core;

import io.bidmachine.media3.exoplayer.audio.SilenceSkippingAudioProcessor;
import java.io.IOException;

/* renamed from: com.facebook.ads.redexgen.X.lD, reason: case insensitive filesystem */
/* loaded from: assets/audience_network/classes2.dex */
public final class C2189lD implements H1 {
    public static String[] A02 = {"icMuAGNUwG3qooMsLkIelsXOgqR", "wZwGdqwzUfLFhHeDnVqZXfrekI2t19Nm", "6NjHclQwJEhKen4shQzzT38fKShvFJl3", "cwvHChui6ScrilPVLNLxDwwq1RZibmTM", "KGSyfhH5I6lVnEy0NkdKQy5Ija", "JgLMaajFBM7mBqcCk", "W9ygPHkeZ", ""};
    public final C07364v A00;
    public final AnonymousClass53 A01;

    public C2189lD(AnonymousClass53 anonymousClass53) {
        this.A01 = anonymousClass53;
        this.A00 = new C07364v();
    }

    private C1032Gz A00(C07364v c07364v, long scrValue, long scrTimeUs) {
        int A00;
        int i = -1;
        int i2 = -1;
        long j = -9223372036854775807L;
        while (c07364v.A07() >= 4) {
            A00 = C2188lC.A00(c07364v.A0l(), c07364v.A09());
            if (A00 != 442) {
                c07364v.A0g(1);
            } else {
                c07364v.A0g(4);
                long A06 = L6.A06(c07364v);
                if (A06 != -9223372036854775807L) {
                    long A062 = this.A01.A06(A06);
                    if (A062 > scrValue) {
                        if (j == -9223372036854775807L) {
                            return C1032Gz.A04(A062, scrTimeUs);
                        }
                        return C1032Gz.A03(i + scrTimeUs);
                    }
                    int startOfLastPacketPosition = A02[1].charAt(26);
                    if (startOfLastPacketPosition == 113) {
                        throw new RuntimeException();
                    }
                    String[] strArr = A02;
                    strArr[3] = "JRu5yfiOOmZm3e1j9KGmxzziCqUEhgmX";
                    strArr[2] = "rPvZuTIICj36zhJU166yjphfEhohU7nm";
                    long lastScrTimeUsInRange = SilenceSkippingAudioProcessor.DEFAULT_MINIMUM_SILENCE_DURATION_US + A062;
                    if (lastScrTimeUsInRange > scrValue) {
                        return C1032Gz.A03(c07364v.A09() + scrTimeUs);
                    }
                    j = A062;
                    i = c07364v.A09();
                }
                A01(c07364v);
                i2 = c07364v.A09();
            }
        }
        if (j != -9223372036854775807L) {
            return C1032Gz.A05(j, i2 + scrTimeUs);
        }
        return C1032Gz.A03;
    }

    /* JADX WARN: Incorrect condition in loop: B:23:0x005b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void A01(C07364v c07364v) {
        int packStuffingLength;
        int packStuffingLength2;
        int systemHeaderLength = c07364v.A0A();
        if (c07364v.A07() < 10) {
            c07364v.A0f(systemHeaderLength);
            return;
        }
        c07364v.A0g(9);
        int limit = c07364v.A0I();
        int packStuffingLength3 = limit & 7;
        int limit2 = c07364v.A07();
        if (limit2 < packStuffingLength3) {
            c07364v.A0f(systemHeaderLength);
            return;
        }
        c07364v.A0g(packStuffingLength3);
        int limit3 = c07364v.A07();
        if (limit3 < 4) {
            c07364v.A0f(systemHeaderLength);
            return;
        }
        byte[] A0l = c07364v.A0l();
        int limit4 = c07364v.A09();
        packStuffingLength = C2188lC.A00(A0l, limit4);
        if (packStuffingLength == 443) {
            c07364v.A0g(4);
            int packStuffingLength4 = c07364v.A0M();
            int limit5 = c07364v.A07();
            if (limit5 < packStuffingLength4) {
                c07364v.A0f(systemHeaderLength);
                return;
            }
            c07364v.A0g(packStuffingLength4);
        }
        while (limit >= 4) {
            byte[] A0l2 = c07364v.A0l();
            int limit6 = c07364v.A09();
            packStuffingLength2 = C2188lC.A00(A0l2, limit6);
            if (packStuffingLength2 == 442 || packStuffingLength2 == 441 || (packStuffingLength2 >>> 8) != 1) {
                return;
            }
            c07364v.A0g(4);
            if (c07364v.A07() < 2) {
                c07364v.A0f(systemHeaderLength);
                return;
            }
            int nextStartCode = c07364v.A0M();
            int packStuffingLength5 = c07364v.A0A();
            int limit7 = c07364v.A09();
            c07364v.A0f(Math.min(packStuffingLength5, limit7 + nextStartCode));
        }
    }

    @Override // com.instagram.common.viewpoint.core.H1
    public final void AFs() {
        this.A00.A0i(C5C.A07);
    }

    @Override // com.instagram.common.viewpoint.core.H1
    public final C1032Gz AIw(InterfaceC2280ms interfaceC2280ms, long j) throws IOException {
        long A8n = interfaceC2280ms.A8n();
        int min = (int) Math.min(20000L, interfaceC2280ms.A8O() - A8n);
        this.A00.A0d(min);
        interfaceC2280ms.AGt(this.A00.A0l(), 0, min);
        return A00(this.A00, j, A8n);
    }
}
