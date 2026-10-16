package com.instagram.common.viewpoint.core;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.util.Pair;
import com.facebook.ads.androidx.media3.common.Timeline;
import com.facebook.video.heroplayer.exocustom.MetaExoPlayerCustomization;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import com.vungle.ads.internal.protos.Sdk;
import java.util.Arrays;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.io.encoding.Base64;

/* loaded from: assets/audience_network/classes2.dex */
public final class AC extends AbstractC2494qP implements InterfaceC2402os {
    public static byte[] A0m;
    public static String[] A0n = {"elvUyEpYiUQqaqvwUQo90L33x5mfGGF5", "x3rc7jsIv6nSbJc9JPlcAze5yGxzQZsd", "UU9CG9klJf", "SZBoHO9Iw1qJ", "kHgqOkYqcJ", "2J3DKpzV", "imAdJlgwdHrtl5IWv7XQyaTS97", "KGY40HmMWVqKFUFEVN2bB10ght87eGPu"};
    public float A00;
    public int A01;
    public int A02;
    public int A03;
    public int A04;
    public int A05;
    public int A06;
    public long A07;
    public long A08;
    public C2495qQ A09;
    public C2473q2 A0A;
    public C2473q2 A0B;
    public C2473q2 A0C;
    public C2468px A0D;
    public C2466pv A0E;
    public C2442pW A0F;
    public C2437pR A0G;
    public C07404z A0H;
    public AD A0I;
    public C7Z A0J;
    public C08137u A0K;
    public InterfaceC0927Cx A0L;
    public boolean A0M;
    public boolean A0N;
    public boolean A0O;
    public boolean A0P;
    public boolean A0Q;
    public boolean A0R;
    public boolean A0S;
    public final C2466pv A0T;
    public final long A0U;
    public final long A0V;
    public final long A0W;
    public final Handler A0X;
    public final Looper A0Y;
    public final InterfaceC06923b A0Z;
    public final C2456pl A0a;
    public final AnonymousClass45 A0b;
    public final AnonymousClass48 A0c;
    public final C2400oq A0d;
    public final AB A0e;
    public final InterfaceC2393oj A0f;
    public final AbstractC0978Ew A0g;
    public final C0979Ex A0h;
    public final CopyOnWriteArraySet<C6W> A0i;
    public final CopyOnWriteArraySet<C3U> A0j;
    public final boolean A0k;
    public final InterfaceC2398oo[] A0l;

    public static String A04(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A0m, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] ^ i3) ^ 17);
        }
        return new String(copyOfRange);
    }

    public static void A06() {
        A0m = new byte[]{102, Ascii.GS, 74, 119, 96, 95, 99, 110, 118, 106, 125, 70, 98, Byte.MAX_VALUE, 99, 0, Base64.padSymbol, 42, Ascii.NAK, 41, 36, 60, 32, 55, 9, 44, 39, 106, 119, 107, 125, 107, 116, 70, 97, 102, 123, 47, 71, 123, 118, 110, 114, 101, 55, 126, 100, 55, 118, 116, 116, 114, 100, 100, 114, 115, 55, 120, 121, 55, 99, Byte.MAX_VALUE, 114, 55, 96, 101, 120, 121, 112, 55, 99, Byte.MAX_VALUE, 101, 114, 118, 115, 57, Ascii.GS, 84, 98, 101, 101, 114, 121, 99, 55, 99, Byte.MAX_VALUE, 101, 114, 118, 115, 45, 55, 48, 50, 100, 48, Ascii.GS, 82, 111, 103, 114, 116, 99, 114, 115, 55, 99, Byte.MAX_VALUE, 101, 114, 118, 115, 45, 55, 48, 50, 100, 48, Ascii.GS, 68, 114, 114, 55, Byte.MAX_VALUE, 99, 99, 103, 100, 45, 56, 56, 114, 111, 120, 103, 123, 118, 110, 114, 101, 57, 115, 114, 97, 56, 126, 100, 100, 98, 114, 100, 56, 103, 123, 118, 110, 114, 101, 58, 118, 116, 116, 114, 100, 100, 114, 115, 58, 120, 121, 58, 96, 101, 120, 121, 112, 58, 99, Byte.MAX_VALUE, 101, 114, 118, 115, Ascii.DC4, 35, 42, 35, 39, 53, 35, 102, 122, 86, 43, 80, 99, 98, 92, 96, 109, 117, 105, 126, 95, 120, 109, 120, 105, 79, 100, 109, 98, 107, 105, 104, 93, 75, 75, 69, 122, 65, Ascii.SO, 71, 73, SignedBytes.MAX_POWER_OF_TWO, 65, 92, 75, 74, Ascii.SO, 76, 75, 77, 79, 91, 93, 75, Ascii.SO, 79, SignedBytes.MAX_POWER_OF_TWO, Ascii.SO, 79, 74, Ascii.SO, 71, 93, Ascii.SO, 94, 66, 79, 87, 71, SignedBytes.MAX_POWER_OF_TWO, 73};
    }

    static {
        A06();
    }

    public AC(InterfaceC2398oo[] interfaceC2398ooArr, AbstractC0978Ew abstractC0978Ew, AnonymousClass74 anonymousClass74, F6 f6, AnonymousClass45 anonymousClass45) {
        this(interfaceC2398ooArr, abstractC0978Ew, anonymousClass74, f6, anonymousClass45, false, false, false, false, false, false, 0L, false, 0, false, false, false, false, false, false, false, null);
    }

    public AC(@MetaExoPlayerCustomization("qe_android_video_exoplayer2.update_loading_priority_exo2 is consistently false. We do not need to port this in the upgrade") InterfaceC2398oo[] interfaceC2398ooArr, @MetaExoPlayerCustomization("Introduced in D13513334 and also used in loop playing for IG: D38285740") AbstractC0978Ew abstractC0978Ew, @MetaExoPlayerCustomization("Currently used to load chunks while seeking on pause D13827150") AnonymousClass74 anonymousClass74, @MetaExoPlayerCustomization("D40987428 Brought in for clippingmediasource") F6 f6, @MetaExoPlayerCustomization("D45597293 for Oculus - allowing the start renderer offset to not be 0; Eventually changed in Exo: https://github.com/google/ExoPlayer/commit/9f352434c72da527d1fa7963447c3cf680db884f") AnonymousClass45 anonymousClass45, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, long j, boolean z7, int i, boolean z8, boolean z9, boolean z10, boolean z11, boolean z12, boolean z13, boolean z14, InterfaceC06923b interfaceC06923b) {
        InterfaceC06923b interfaceC06923b2 = interfaceC06923b;
        Log.i(A04(2, 13, 30), A04(33, 5, 30) + Integer.toHexString(System.identityHashCode(this)) + A04(0, 2, 87) + A04(15, 18, 84) + A04(194, 3, 26) + C5C.A04 + A04(193, 1, 54));
        this.A0c = new AnonymousClass48();
        try {
            this.A0M = z13;
            AbstractC07133y.A08(interfaceC2398ooArr.length > 0);
            this.A0l = (InterfaceC2398oo[]) AbstractC07133y.A01(interfaceC2398ooArr);
            this.A0g = (AbstractC0978Ew) AbstractC07133y.A01(abstractC0978Ew);
            this.A0Q = false;
            this.A00 = 1.0f;
            this.A05 = 0;
            this.A0A = C2473q2.A0Z;
            this.A0B = C2473q2.A0Z;
            this.A0C = C2473q2.A0Z;
            this.A0S = false;
            this.A0V = 0L;
            this.A09 = C2495qQ.A07;
            this.A0W = 0L;
            this.A0j = new CopyOnWriteArraySet<>();
            this.A0U = 0L;
            InterfaceC2393oj analyticsCollector = InterfaceC2393oj.A00;
            this.A0f = analyticsCollector;
            this.A0K = C08137u.A03;
            this.A06 = 1;
            this.A0d = new C2400oq();
            this.A0h = new C0979Ex(new C08117s[interfaceC2398ooArr.length], new InterfaceC2301nE[interfaceC2398ooArr.length], C2444pY.A03, null);
            this.A0a = new C2456pl();
            this.A0T = new C3P().A03(1, 2, 3, 13, 14, 15, 16, 17, 18, 19, 31, 20, 30, 21, 22, 23, 24, 25, 26, 27, 28).A01(29, abstractC0978Ew.A0Y()).A04();
            this.A0E = new C3P().A02(this.A0T).A00(4).A00(10).A04();
            this.A0G = C2437pR.A03;
            this.A0D = C2468px.A06;
            this.A0Y = Looper.myLooper();
            final Looper myLooper = Looper.myLooper() != null ? Looper.myLooper() : Looper.getMainLooper();
            this.A0X = new Handler(myLooper) { // from class: com.facebook.ads.redexgen.X.6c
                @Override // android.os.Handler
                public final void handleMessage(Message msg) {
                    if (WU.A02(this)) {
                        return;
                    }
                    try {
                        AC.this.A0N(msg);
                    } catch (Throwable th) {
                        WU.A00(th, this);
                    }
                }
            };
            this.A0b = anonymousClass45;
            this.A0Z = interfaceC06923b2 == null ? this : interfaceC06923b2;
            this.A0J = new C7Z(Timeline.A02, 0L, C2319nW.A06, this.A0h);
            this.A0e = new AB(interfaceC2398ooArr, abstractC0978Ew, this.A0h, anonymousClass74, f6, this.A0Q, this.A05, this.A0S, this.A0X, anonymousClass45, z, z2, z3, z4, z5, z6, j, z7, i, z8, z9, z10, z11, z12, z14, C8O.A03);
            this.A0F = C2442pW.A06;
            this.A0H = C07404z.A03;
            this.A0i = new CopyOnWriteArraySet<>();
        } finally {
            this.A0c.A04();
        }
    }

    private long A00(long j) {
        long A01 = C2Y.A01(j);
        if (!this.A0J.A05.A00()) {
            this.A0J.A03.A0J(this.A0J.A05.A04, this.A0a);
            long positionMs = this.A0a.A0B();
            return A01 + positionMs;
        }
        return A01;
    }

    private long A01(Timeline timeline, C2337no c2337no, long j) {
        timeline.A0J(c2337no.A04, this.A0a);
        return j + this.A0a.A0C();
    }

    private C7Z A02(boolean z, boolean z2, int i) {
        C0979Ex c0979Ex;
        if (z) {
            this.A02 = 0;
            this.A01 = 0;
            this.A08 = 0L;
            this.A07 = 0L;
        } else {
            this.A02 = A7h();
            this.A01 = A7c();
            this.A08 = A7e();
            this.A07 = A0J();
        }
        Timeline timeline = z2 ? Timeline.A02 : this.A0J.A03;
        C2337no c2337no = this.A0J.A05;
        long j = this.A0J.A02;
        long j2 = this.A0J.A01;
        C2319nW c2319nW = z2 ? C2319nW.A06 : this.A0J.A06;
        if (z2) {
            c0979Ex = this.A0h;
        } else {
            C7Z c7z = this.A0J;
            String[] strArr = A0n;
            if (strArr[7].charAt(29) != strArr[0].charAt(29)) {
                throw new RuntimeException();
            }
            String[] strArr2 = A0n;
            strArr2[3] = "Omd19LzmWdt3";
            strArr2[5] = "slTdP4Xe";
            c0979Ex = c7z.A07;
        }
        return new C7Z(timeline, c2337no, j, j2, i, false, c2319nW, c0979Ex, this.A0J.A05, this.A0J.A02, 0L, this.A0J.A02);
    }

    private C07967d A03(InterfaceC07957c interfaceC07957c) {
        int A7h = A7h();
        AB ab = this.A0e;
        Timeline timeline = this.A0J.A03;
        if (A7h == -1) {
            A7h = 0;
        }
        return new C07967d(ab, interfaceC07957c, timeline, A7h, this.A0b, this.A0e.A1B());
    }

    private void A05() {
        if (!this.A0M) {
            return;
        }
        this.A0c.A01();
        if (Thread.currentThread() != A0K().getThread()) {
            String A0n2 = C5C.A0n(A04(38, 147, 6), Thread.currentThread().getName(), A0K().getThread().getName());
            if (!this.A0k) {
                Log.w(A04(2, 13, 30), A0n2, this.A0N ? null : new IllegalStateException());
                if (A0n[6].length() == 12) {
                    throw new RuntimeException();
                }
                A0n[6] = "OHv4LuNWT";
                this.A0N = true;
                return;
            }
            throw new IllegalStateException(A0n2);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x004b, code lost:
    
        if (r5 != false) goto L13;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void A07(C7Z c7z, int i, boolean z, int i2) {
        int i3;
        C7Z c7z2 = c7z;
        this.A03 -= i;
        if (this.A03 == 0) {
            if (c7z2.A02 == -9223372036854775807L) {
                c7z2 = c7z2.A06(c7z2.A05, 0L, c7z2.A01, c7z2.A0D);
            }
            C7Z playbackInfo = this.A0J;
            if (playbackInfo.A03.A0N()) {
                boolean z2 = this.A0O;
                String[] strArr = A0n;
                if (strArr[3].length() == strArr[5].length()) {
                    throw new RuntimeException();
                }
                A0n[6] = "E7I7Mej0S3DTzUCwep";
            }
            if (c7z2.A03.A0N()) {
                this.A01 = 0;
                this.A02 = 0;
                this.A08 = 0L;
                this.A07 = 0L;
            }
            if (this.A0O) {
                i3 = 0;
            } else {
                i3 = 2;
            }
            boolean z3 = this.A0P;
            this.A0O = false;
            this.A0P = false;
            A08(c7z2, z, i2, i3, z3);
        }
    }

    /* JADX WARN: Incorrect condition in loop: B:23:0x009b */
    /* JADX WARN: Incorrect condition in loop: B:29:0x00b8 */
    /* JADX WARN: Incorrect condition in loop: B:47:0x0121 */
    /* JADX WARN: Incorrect condition in loop: B:54:0x0144 */
    /* JADX WARN: Incorrect condition in loop: B:61:0x0058 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void A08(C7Z c7z, boolean z, int i, int i2, boolean z2) {
        Iterator<C3U> it;
        boolean isLoadingChanged = this.A0J.A03 != c7z.A03;
        int i3 = this.A0J.A00;
        String[] strArr = A0n;
        if (strArr[2].length() == strArr[4].length()) {
            String[] strArr2 = A0n;
            strArr2[7] = "RJsywmu9iXbSHAOSoooup4iB6ctJ9GEd";
            strArr2[0] = "je0JKUsqzBp1pj8TVGEWBsFZVePcLGnq";
            boolean z3 = i3 != c7z.A00;
            boolean playbackStateChanged = this.A0J.A0A;
            boolean timelineChanged = c7z.A0A;
            boolean z4 = playbackStateChanged != timelineChanged;
            boolean z5 = this.A0J.A07 != c7z.A07;
            this.A0J = c7z;
            if (isLoadingChanged || i2 == 0) {
                Iterator<C3U> it2 = this.A0j.iterator();
                while (timelineChanged) {
                    C3U next = it2.next();
                    Timeline timeline = this.A0J.A03;
                    String[] strArr3 = A0n;
                    if (strArr3[7].charAt(29) != strArr3[0].charAt(29)) {
                        throw new RuntimeException();
                    }
                    A0n[6] = "RAQE2IWZazAhX";
                    next.AGA(timeline, i2);
                }
            }
            if (z) {
                Iterator<C3U> it3 = this.A0j.iterator();
                while (timelineChanged) {
                    it3.next();
                }
            }
            if (z5) {
                this.A0g.A0c(this.A0J.A07.A02);
                Iterator<C3U> it4 = this.A0j.iterator();
                while (timelineChanged) {
                    it4.next().AGE(this.A0J.A07.A01);
                }
            }
            if (z4) {
                Iterator<C3U> it5 = this.A0j.iterator();
                while (true) {
                    boolean hasNext = it5.hasNext();
                    String[] strArr4 = A0n;
                    if (strArr4[2].length() == strArr4[4].length()) {
                        A0n[6] = "XRa";
                        if (!hasNext) {
                            break;
                        } else {
                            it5.next();
                        }
                    } else {
                        break;
                    }
                }
            }
            if (z3) {
                CopyOnWriteArraySet<C3U> copyOnWriteArraySet = this.A0j;
                if (A0n[1].charAt(28) != 'y') {
                    String[] strArr5 = A0n;
                    strArr5[3] = "HK22odgNy2pi";
                    strArr5[5] = "HFqBrVui";
                    it = copyOnWriteArraySet.iterator();
                } else {
                    it = copyOnWriteArraySet.iterator();
                }
                while (playbackStateChanged) {
                    C3U next2 = it.next();
                    boolean trackSelectorResultChanged = this.A0R;
                    next2.AFM(trackSelectorResultChanged, this.A0J.A00);
                }
            }
            if (z2) {
                Iterator<C3U> it6 = this.A0j.iterator();
                while (timelineChanged) {
                    it6.next().AFt();
                }
                return;
            }
            return;
        }
        throw new RuntimeException();
    }

    @MetaExoPlayerCustomization("D31846300; Custom MediaSessionEventListener")
    private final void A09(boolean z, boolean z2) {
        if (this.A0Q != z) {
            this.A0Q = z;
            this.A04++;
            this.A0e.A1G(z);
            C7Z c7z = this.A0J;
            if (!z) {
                this.A0R = z;
                Iterator<C3U> it = this.A0j.iterator();
                while (it.hasNext()) {
                    C3U next = it.next();
                    if (0 != 0) {
                        throw new NullPointerException(A04(197, 20, 29));
                    }
                    next.AFM(z, c7z.A00);
                }
            }
        }
    }

    private boolean A0A() {
        return this.A0J.A03.A0N() || this.A03 > 0;
    }

    @Override // com.instagram.common.viewpoint.core.AbstractC2494qP
    public final void A0H(int i, long j) {
        long A00;
        Timeline timeline = this.A0J.A03;
        if (i >= 0) {
            boolean A0N = timeline.A0N();
            if (A0n[6].length() == 12) {
                throw new RuntimeException();
            }
            String[] strArr = A0n;
            strArr[3] = "u5DgO7GwYyET";
            strArr[5] = "hfn3fs8A";
            if (A0N || i < timeline.A07()) {
                this.A0P = true;
                this.A03++;
                if (AAd()) {
                    Log.w(A04(2, 13, 30), A04(Sdk.SDKError.Reason.AD_RESPONSE_TIMED_OUT_VALUE, 39, 63));
                    this.A0X.obtainMessage(0, 1, -1, this.A0J).sendToTarget();
                    return;
                }
                this.A02 = i;
                if (timeline.A0N()) {
                    this.A08 = j == -9223372036854775807L ? 0L : j;
                    this.A01 = 0;
                } else {
                    if (j == -9223372036854775807L) {
                        A00 = timeline.A0K(i, super.A00).A05();
                    } else {
                        A00 = C2Y.A00(j);
                    }
                    Pair<Object, Long> A0D = timeline.A0D(super.A00, this.A0a, i, A00);
                    this.A08 = C2Y.A01(A00);
                    this.A01 = timeline.A0A(A0D.first);
                }
                this.A0e.A1D(timeline, i, C2Y.A00(j));
                Iterator<C3U> it = this.A0j.iterator();
                while (it.hasNext()) {
                    it.next();
                }
                return;
            }
        }
        throw new C06812q(timeline, i, j);
    }

    public final long A0I() {
        if (A0A()) {
            return this.A08;
        }
        if (this.A0J.A04.A03 != this.A0J.A05.A03) {
            return this.A0J.A03.A0K(A7h(), super.A00).A06();
        }
        long j = this.A0J.A0B;
        if (this.A0J.A04.A00()) {
            C2456pl A0J = this.A0J.A03.A0J(this.A0J.A04.A04, this.A0a);
            j = A0J.A0D(this.A0J.A04.A00);
            if (j == Long.MIN_VALUE) {
                j = A0J.A01;
            }
        }
        long contentBufferedPositionUs = A01(this.A0J.A03, this.A0J.A04, j);
        return C5C.A0P(contentBufferedPositionUs);
    }

    public final long A0J() {
        if (A0A()) {
            long j = this.A07;
            String[] strArr = A0n;
            if (strArr[7].charAt(29) != strArr[0].charAt(29)) {
                throw new RuntimeException();
            }
            A0n[1] = "SWSNQbytnn5JxmoGO3rxXNMtbmar9O4q";
            return j;
        }
        C7Z c7z = this.A0J;
        if (A0n[1].charAt(28) == 'y') {
            throw new RuntimeException();
        }
        A0n[1] = "VYQpOR71WpATH6H66c6IUhHHWo1qZbHI";
        return C2Y.A01(c7z.A0C);
    }

    public final Looper A0K() {
        return this.A0Y;
    }

    public final C07967d A0L(InterfaceC07957c interfaceC07957c) {
        A05();
        return A03(interfaceC07957c);
    }

    public final void A0M() {
        StringBuilder append = new StringBuilder().append(A04(185, 8, 87)).append(Integer.toHexString(System.identityHashCode(this))).append(A04(0, 2, 87)).append(A04(15, 18, 84));
        String A04 = A04(194, 3, 26);
        Log.i(A04(2, 13, 30), append.append(A04).append(C5C.A04).append(A04).append(AnonymousClass35.A00()).append(A04(193, 1, 54)).toString());
        this.A0L = null;
        this.A0e.A1C();
        this.A0X.removeCallbacksAndMessages(null);
        this.A0J = A02(false, false, 1);
        this.A0G = C2437pR.A03;
    }

    public final void A0N(Message message) {
        switch (message.what) {
            case 0:
                A07((C7Z) message.obj, message.arg1, message.arg2 != -1, message.arg2);
                return;
            case 1:
                C2468px c2468px = (C2468px) message.obj;
                C2468px c2468px2 = this.A0D;
                String[] strArr = A0n;
                if (strArr[2].length() == strArr[4].length()) {
                    String[] strArr2 = A0n;
                    strArr2[2] = "M5Fz4bo4aU";
                    strArr2[4] = "jAP48pK2xI";
                    if (!c2468px2.equals(c2468px)) {
                        this.A0D = c2468px;
                        Iterator<C3U> it = this.A0j.iterator();
                        while (it.hasNext()) {
                            it.next().AFI(c2468px);
                        }
                        return;
                    }
                    return;
                }
                break;
            case 2:
                AD ad = (AD) message.obj;
                this.A0I = ad;
                CopyOnWriteArraySet<C3U> copyOnWriteArraySet = this.A0j;
                String[] strArr3 = A0n;
                if (strArr3[7].charAt(29) != strArr3[0].charAt(29)) {
                    throw new RuntimeException();
                }
                String[] strArr4 = A0n;
                strArr4[3] = "qauhWK691fBn";
                strArr4[5] = "FsOQ1ovS";
                Iterator<C3U> it2 = copyOnWriteArraySet.iterator();
                while (true) {
                    boolean hasNext = it2.hasNext();
                    String[] strArr5 = A0n;
                    if (strArr5[3].length() != strArr5[5].length()) {
                        A0n[6] = "DbAY1NxOkLRBmNTAZlCZyxXxDbYRxJk";
                        if (!hasNext) {
                            return;
                        }
                    } else if (!hasNext) {
                        return;
                    }
                    it2.next().AFK(ad);
                }
            case 3:
                this.A04--;
                if (this.A04 == 0) {
                    this.A0R = ((Boolean) message.obj).booleanValue();
                    CopyOnWriteArraySet<C3U> copyOnWriteArraySet2 = this.A0j;
                    if (A0n[1].charAt(28) == 'y') {
                        throw new RuntimeException();
                    }
                    String[] strArr6 = A0n;
                    strArr6[3] = "yizDUJeCRugc";
                    strArr6[5] = "UffiDbl9";
                    Iterator<C3U> it3 = copyOnWriteArraySet2.iterator();
                    while (it3.hasNext()) {
                        C3U next = it3.next();
                        if (this.A0R) {
                            next.AFM(this.A0R, this.A0J.A00);
                        }
                    }
                    return;
                }
                return;
            case 4:
                Iterator<C3U> it4 = this.A0j.iterator();
                while (it4.hasNext()) {
                    it4.next();
                }
                return;
            case 5:
                CopyOnWriteArraySet<C3U> copyOnWriteArraySet3 = this.A0j;
                String[] strArr7 = A0n;
                if (strArr7[7].charAt(29) == strArr7[0].charAt(29)) {
                    String[] strArr8 = A0n;
                    strArr8[3] = "QQxFLYRHq8rv";
                    strArr8[5] = "zDzShVZM";
                    Iterator<C3U> it5 = copyOnWriteArraySet3.iterator();
                    while (it5.hasNext()) {
                        it5.next();
                    }
                    return;
                }
                break;
            default:
                throw new IllegalStateException();
        }
        throw new RuntimeException();
    }

    public final void A0O(C3U c3u) {
        this.A0j.add(c3u);
    }

    public final void A0P(InterfaceC0927Cx interfaceC0927Cx, boolean z, boolean z2) {
        this.A0I = null;
        this.A0L = interfaceC0927Cx;
        C7Z A02 = A02(z, z2, 2);
        this.A0O = true;
        this.A03++;
        this.A0e.A1F(interfaceC0927Cx, z, z2);
        A08(A02, false, 4, 1, false);
    }

    public final void A0Q(boolean z) {
        A09(z, false);
    }

    public final boolean A0R() {
        return this.A0Q;
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC06923b
    public final long A77() {
        if (AAd()) {
            if (this.A0J.A04.equals(this.A0J.A05)) {
                return C2Y.A01(this.A0J.A0B);
            }
            return A7s();
        }
        return A0I();
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC06923b
    public final long A7T() {
        if (AAd()) {
            this.A0J.A03.A0J(this.A0J.A05.A04, this.A0a);
            return this.A0a.A0B() + C2Y.A01(this.A0J.A01);
        }
        return A7e();
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC06923b
    public final int A7Y() {
        if (AAd()) {
            return this.A0J.A05.A00;
        }
        return -1;
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC06923b
    public final int A7Z() {
        if (AAd()) {
            return this.A0J.A05.A01;
        }
        return -1;
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC06923b
    @MetaExoPlayerCustomization("getCurrentWindowIndex needs to be upgraded to getCurrentWindowIndexInternal")
    public final int A7b() {
        A05();
        int A7h = A7h();
        if (A7h == -1) {
            return 0;
        }
        return A7h;
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC06923b
    public final int A7c() {
        if (A0A()) {
            return this.A01;
        }
        Timeline timeline = this.A0J.A03;
        C2337no c2337no = this.A0J.A05;
        String[] strArr = A0n;
        if (strArr[3].length() == strArr[5].length()) {
            throw new RuntimeException();
        }
        A0n[1] = "6o1scJ9TwXJl7WSt7vZ9WMBcl2tfzHGN";
        return timeline.A0A(c2337no.A04);
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC06923b
    public final long A7e() {
        if (A0A()) {
            return this.A08;
        }
        if (this.A0J.A05.A00()) {
            return C2Y.A01(this.A0J.A0C);
        }
        return A00(this.A0J.A0C);
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC06923b
    public final Timeline A7g() {
        return this.A0J.A03;
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC06923b
    public final int A7h() {
        if (A0A()) {
            int i = this.A02;
            String[] strArr = A0n;
            if (strArr[7].charAt(29) != strArr[0].charAt(29)) {
                throw new RuntimeException();
            }
            String[] strArr2 = A0n;
            strArr2[3] = "0i1iYNlUg7j9";
            strArr2[5] = "Koyujpdg";
            return i;
        }
        return this.A0J.A03.A0J(this.A0J.A05.A04, this.A0a).A00;
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC06923b
    public final long A7s() {
        Timeline timeline = this.A0J.A03;
        if (timeline.A0N()) {
            return -9223372036854775807L;
        }
        if (AAd()) {
            C2337no c2337no = this.A0J.A05;
            timeline.A0J(c2337no.A04, this.A0a);
            return C2Y.A01(this.A0a.A0E(c2337no.A00, c2337no.A01));
        }
        return timeline.A0K(A7h(), super.A00).A06();
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC06923b
    public final long A9J() {
        return Math.max(0L, C2Y.A01(this.A0J.A0D));
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC06923b
    public final boolean AAd() {
        return !A0A() && this.A0J.A05.A00();
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC06923b
    public final void AKG(boolean z) {
        if (z) {
            this.A0I = null;
            this.A0L = null;
        }
        C7Z A02 = A02(z, z, 1);
        this.A03++;
        this.A0e.A1H(z);
        A08(A02, false, 4, 1, false);
        this.A0G = new C2437pR(MetaExoPlayerCustomizedCollections.A01(), A02.A0C);
    }
}
