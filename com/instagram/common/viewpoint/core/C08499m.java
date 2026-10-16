package com.instagram.common.viewpoint.core;

import android.net.Uri;
import com.facebook.ads.androidx.media3.common.Timeline;
import java.util.Arrays;

/* renamed from: com.facebook.ads.redexgen.X.9m, reason: invalid class name and case insensitive filesystem */
/* loaded from: assets/audience_network/classes2.dex */
public final class C08499m extends Timeline {
    public static byte[] A0D;
    public static final C2478q7 A0E;
    public static final Object A0F;
    public final long A00;
    public final long A01;
    public final long A02;
    public final long A03;
    public final long A04;
    public final long A05;
    public final long A06;
    public final C2481qA A07;
    public final C2478q7 A08;
    public final Object A09;
    public final boolean A0A;
    public final boolean A0B;
    public final boolean A0C;

    public static String A00(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A0D, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] - i3) - 50);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A0D = new byte[]{-79, -57, -52, -59, -54, -61, -82, -61, -48, -57, -51, -62, -78, -57, -53, -61, -54, -57, -52, -61};
    }

    static {
        A01();
        A0F = new Object();
        A0E = new C06852u().A03(A00(0, 20, 44)).A00(Uri.EMPTY).A05();
    }

    public C08499m(long j, long j2, long j3, long j4, long j5, long j6, long j7, boolean z, boolean z2, boolean z3, Object obj, C2478q7 c2478q7, C2481qA c2481qA) {
        this.A02 = j;
        this.A06 = j2;
        this.A00 = j3;
        this.A01 = j4;
        this.A04 = j5;
        this.A05 = j6;
        this.A03 = j7;
        this.A0B = z;
        this.A0A = z2;
        this.A0C = z3;
        this.A09 = obj;
        this.A08 = (C2478q7) AbstractC07133y.A01(c2478q7);
        this.A07 = c2481qA;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public C08499m(long j, long j2, long j3, long j4, boolean z, boolean z2, boolean z3, Object obj, C2478q7 c2478q7) {
        this(-9223372036854775807L, -9223372036854775807L, -9223372036854775807L, j, j2, j3, j4, z, z2, false, obj, c2478q7, r0);
        C2481qA c2481qA;
        if (z3) {
            c2481qA = c2478q7.A02;
        } else {
            c2481qA = null;
        }
    }

    public C08499m(long j, boolean z, boolean z2, boolean z3, Object obj, C2478q7 c2478q7) {
        this(j, j, 0L, 0L, z, z2, z3, obj, c2478q7);
    }

    @Override // com.facebook.ads.androidx.media3.common.Timeline
    public final int A06() {
        return 1;
    }

    @Override // com.facebook.ads.androidx.media3.common.Timeline
    public final int A07() {
        return 1;
    }

    @Override // com.facebook.ads.androidx.media3.common.Timeline
    public final int A0A(Object obj) {
        return A0F.equals(obj) ? 0 : -1;
    }

    @Override // com.facebook.ads.androidx.media3.common.Timeline
    public final C2456pl A0I(int i, C2456pl c2456pl, boolean z) {
        AbstractC07133y.A00(i, 0, 1);
        return c2456pl.A0F(null, z ? A0F : null, 0, this.A01, -this.A05);
    }

    @Override // com.facebook.ads.androidx.media3.common.Timeline
    public final C2454pj A0L(int i, C2454pj c2454pj, long j) {
        AbstractC07133y.A00(i, 0, 1);
        long j2 = this.A03;
        if (this.A0A && !this.A0C && j != 0) {
            if (this.A04 == -9223372036854775807L) {
                j2 = -9223372036854775807L;
            } else {
                j2 += j;
                if (j2 > this.A04) {
                    j2 = -9223372036854775807L;
                }
            }
        }
        return c2454pj.A07(C2454pj.A0K, this.A08, this.A09, this.A02, this.A06, -9223372036854775807L, this.A0B, this.A0A, null, j2, this.A04, 0, 0, this.A05);
    }

    @Override // com.facebook.ads.androidx.media3.common.Timeline
    public final Object A0M(int i) {
        AbstractC07133y.A00(i, 0, 1);
        return A0F;
    }
}
