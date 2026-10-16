package com.instagram.common.viewpoint.core;

import com.facebook.ads.androidx.media3.common.Timeline;
import com.facebook.video.heroplayer.exocustom.MetaExoPlayerCustomization;
import com.google.common.base.Ascii;
import java.util.Arrays;

/* renamed from: com.facebook.ads.redexgen.X.7A, reason: invalid class name */
/* loaded from: assets/audience_network/classes2.dex */
public final class C7A {
    public static byte[] A0E;
    public static String[] A0F = {"qTjlphzGhjtz23pZpbkrfGV3", "gcvQ0aFRAZsVeDDMvPpq9fmBIR43z3dS", "1g2pSH5s64tGUAh3eJ0e3X43Q9jzw3mq", "lB1M4R9KcDs1NZsKBVQ3JQYLP4RbMvTH", "7AgciWFjZyCuzmH359m88XAJrahqi7eF", "Et2BwvNp", "Oz1eJxJHgMWzrYsZQ0zZlFN1YCxGY3CZ", "Iy7o67ktSbvMBIxm3lxnuK7UTKgUaVFx"};
    public C7B A00;
    public boolean A01;
    public boolean A02;
    public long A03;
    public C7A A04;
    public C2319nW A05 = C2319nW.A06;
    public C0979Ex A06;
    public final InterfaceC2338np A07;
    public final Object A08;
    public final DT[] A09;
    public final AnonymousClass79 A0A;
    public final AbstractC0978Ew A0B;
    public final InterfaceC08087p[] A0C;
    public final boolean[] A0D;

    public static String A01(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A0E, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] ^ i3) ^ 22);
        }
        return new String(copyOfRange);
    }

    public static void A04() {
        A0E = new byte[]{81, 121, 120, 117, 125, 76, 121, 110, 117, 115, 120, 84, 115, 112, 120, 121, 110, Ascii.FS, 41, 62, 37, 35, 40, 108, 62, 41, 32, 41, 45, 63, 41, 108, 42, 45, 37, 32, 41, 40, 98};
    }

    static {
        A04();
    }

    @MetaExoPlayerCustomization(type = {"TEMPORARY"}, value = "Old exoplayer method. requires deleting")
    public C7A(InterfaceC08087p[] interfaceC08087pArr, long j, AbstractC0978Ew abstractC0978Ew, F0 f0, InterfaceC0927Cx interfaceC0927Cx, C7B c7b, C0979Ex c0979Ex) {
        this.A0C = interfaceC08087pArr;
        this.A03 = j - c7b.A03;
        this.A0B = abstractC0978Ew;
        this.A08 = AbstractC07133y.A01(c7b.A04.A04);
        this.A00 = c7b;
        this.A06 = c0979Ex;
        this.A09 = new DT[interfaceC08087pArr.length];
        this.A0D = new boolean[interfaceC08087pArr.length];
        this.A0A = new C2399op(this, interfaceC0927Cx);
        this.A07 = A00(c7b.A04, this.A0A, f0, c7b.A03, c7b.A01);
    }

    @MetaExoPlayerCustomization(type = {"TEMPORARY"}, value = "MediaSourceList is temporarily changed to MediaSourceAdapter")
    public static InterfaceC2338np A00(C2337no c2337no, AnonymousClass79 anonymousClass79, F0 f0, long j, long j2) {
        InterfaceC2338np A5W = anonymousClass79.A5W(c2337no, f0, j);
        if (j2 != -9223372036854775807L) {
            return new C9v(A5W, true, 0L, j2);
        }
        return A5W;
    }

    /* JADX WARN: Incorrect condition in loop: B:7:0x000c */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void A02() {
        if (!A08()) {
            return;
        }
        for (int i = 0; i < i; i++) {
            boolean rendererEnabled = this.A06.A00(i);
            InterfaceC2301nE interfaceC2301nE = this.A06.A04[i];
            if (rendererEnabled && interfaceC2301nE != null) {
                interfaceC2301nE.A5x();
            }
        }
    }

    /* JADX WARN: Incorrect condition in loop: B:7:0x000c */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void A03() {
        if (!A08()) {
            return;
        }
        for (int i = 0; i < i; i++) {
            boolean rendererEnabled = this.A06.A00(i);
            InterfaceC2301nE interfaceC2301nE = this.A06.A04[i];
            if (rendererEnabled && interfaceC2301nE != null) {
                interfaceC2301nE.A6K();
            }
        }
    }

    @MetaExoPlayerCustomization(type = {"TEMPORARY"}, value = "Temporary bridging of MediaSourceList with MediaSourceAdapter")
    public static void A05(AnonymousClass79 anonymousClass79, InterfaceC2338np interfaceC2338np) {
        try {
            if (interfaceC2338np instanceof C9v) {
                anonymousClass79.AHk(((C9v) interfaceC2338np).A05);
            } else {
                anonymousClass79.AHk(interfaceC2338np);
            }
        } catch (RuntimeException e) {
            AbstractC07214g.A08(A01(0, 17, 10), A01(17, 22, 90), e);
        }
    }

    /* JADX WARN: Incorrect condition in loop: B:3:0x0004 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void A06(DT[] dtArr) {
        for (int i = 0; i < i; i++) {
            if (this.A0C[i].A9N() == -2 && this.A06.A00(i)) {
                dtArr[i] = new C2340nr();
            }
        }
    }

    /* JADX WARN: Incorrect condition in loop: B:3:0x0004 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void A07(DT[] dtArr) {
        for (int i = 0; i < i; i++) {
            if (this.A0C[i].A9N() == -2) {
                dtArr[i] = null;
            }
        }
    }

    private boolean A08() {
        return this.A04 == null;
    }

    public final long A09() {
        if (!this.A02) {
            return this.A00.A03;
        }
        long A78 = this.A01 ? this.A07.A78() : Long.MIN_VALUE;
        return A78 == Long.MIN_VALUE ? this.A00.A00 : A78;
    }

    public final long A0A() {
        if (this.A02) {
            return this.A07.A8b();
        }
        return 0L;
    }

    public final long A0B() {
        return this.A03;
    }

    @MetaExoPlayerCustomization(type = {"NEW_METHOD"})
    public final long A0C(long j) {
        return this.A07.A76(j);
    }

    public final long A0D(long j) {
        return j - A0B();
    }

    public final long A0E(long j) {
        return A0B() + j;
    }

    public final long A0F(C0979Ex c0979Ex, long j, boolean z) {
        return A0G(c0979Ex, j, z, new boolean[this.A0C.length]);
    }

    public final long A0G(C0979Ex c0979Ex, long j, boolean z, boolean[] zArr) {
        int i = 0;
        while (true) {
            boolean z2 = false;
            if (i < c0979Ex.A00) {
                boolean[] zArr2 = this.A0D;
                if (!z) {
                    boolean A01 = c0979Ex.A01(this.A06, i);
                    if (A0F[5].length() != 8) {
                        throw new RuntimeException();
                    }
                    String[] strArr = A0F;
                    strArr[4] = "ZW5cY05fUZ7YDJtoLiROAD1s3u7pqZaY";
                    strArr[3] = "DBvv8TdqbKzS7YgGUgxEKNMIgeBwY4FK";
                    if (A01) {
                        z2 = true;
                    }
                }
                zArr2[i] = z2;
                i++;
            } else {
                A07(this.A09);
                A02();
                this.A06 = c0979Ex;
                A03();
                long AJ9 = this.A07.AJ9(c0979Ex.A04, this.A0D, this.A09, zArr, j);
                A06(this.A09);
                this.A01 = false;
                for (int i2 = 0; i2 < this.A09.length; i2++) {
                    if (this.A09[i2] != null) {
                        AbstractC07133y.A08(c0979Ex.A00(i2));
                        if (this.A0C[i2].A9N() != -2) {
                            this.A01 = true;
                        }
                    } else {
                        AbstractC07133y.A08(c0979Ex.A04[i2] == null);
                    }
                }
                return AJ9;
            }
        }
    }

    @MetaExoPlayerCustomization(type = {"TEMPORARY"})
    public final long A0H(boolean z) {
        if (!z) {
            return this.A03;
        }
        return this.A00.A03 + this.A03;
    }

    public final C7A A0I() {
        return this.A04;
    }

    public final C2319nW A0J() {
        return this.A05;
    }

    public final C0979Ex A0K() {
        return this.A06;
    }

    public final C0979Ex A0L(float f, Timeline timeline) throws AD {
        C0979Ex A0b = this.A0B.A0b(this.A0C, A0J(), this.A00.A04, timeline);
        for (InterfaceC2301nE interfaceC2301nE : A0b.A04) {
            if (interfaceC2301nE != null) {
                interfaceC2301nE.AFJ(f);
            }
        }
        return A0b;
    }

    @MetaExoPlayerCustomization(type = {"TEMPORARY"}, value = "MediaSourceAdapter to be replaced with MediaSourceList")
    public final void A0M() {
        A02();
        A05(this.A0A, this.A07);
    }

    public final void A0N(float f, Timeline timeline) throws AD {
        this.A02 = true;
        this.A05 = this.A07.A9M();
        long A0F2 = A0F(A0L(f, timeline), this.A00.A03, false);
        this.A03 += this.A00.A03 - A0F2;
        this.A00 = this.A00.A00(A0F2);
    }

    public final void A0O(long j) {
        AbstractC07133y.A08(A08());
        this.A07.A5C(A0D(j));
    }

    public final void A0P(long j) {
        AbstractC07133y.A08(A08());
        if (this.A02) {
            this.A07.AHW(A0D(j));
        }
    }

    public final void A0Q(C7A c7a) {
        if (c7a == this.A04) {
            return;
        }
        A02();
        this.A04 = c7a;
        A03();
    }

    public final boolean A0R() {
        return this.A02 && (!this.A01 || this.A07.A78() == Long.MIN_VALUE);
    }
}
