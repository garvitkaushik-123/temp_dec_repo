package com.instagram.common.viewpoint.core;

import android.content.Context;
import android.media.MediaFormat;
import android.os.Handler;
import android.os.SystemClock;
import android.util.Pair;
import android.view.Surface;
import com.facebook.video.heroplayer.exocustom.MetaExoPlayerCustomization;
import com.google.common.base.Ascii;
import com.unity3d.services.core.di.ServiceProvider;
import com.vungle.ads.internal.protos.Sdk;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.io.encoding.Base64;

/* renamed from: com.facebook.ads.redexgen.X.Fo, reason: case insensitive filesystem */
/* loaded from: assets/audience_network/classes2.dex */
public final class C0995Fo {
    public static byte[] A0H;
    public static String[] A0I = {"rW72zgk", "C1hEbBxBlhumPMJNbyjIrBXoyDOZyeey", "ZkENgJUqZtwNap1lTYBK5Tw9wBrPiUY", "8fmzsEm", "wrUw6R", "UNvp", "7vU7fZKotBGMTNV66wYbOo96IVt1XuHJ", "PSHPw"};
    public Handler A04;
    public Pair<Long, C2489qI> A05;
    public Pair<Surface, C07404z> A06;
    public CopyOnWriteArrayList<C4H> A08;
    public boolean A0A;
    public boolean A0B;
    public final AnonymousClass10 A0C;
    public final G7 A0D;
    public final boolean A0G;
    public final ArrayDeque<Long> A0F = new ArrayDeque<>();
    public final ArrayDeque<Pair<Long, C2489qI>> A0E = new ArrayDeque<>();
    public int A00 = -1;
    public boolean A09 = true;
    public long A02 = -9223372036854775807L;
    public C2442pW A07 = C2442pW.A06;
    public long A03 = -9223372036854775807L;
    public long A01 = -9223372036854775807L;

    public static String A01(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A0H, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] ^ i3) ^ 45);
        }
        return new String(copyOfRange);
    }

    public static void A02() {
        A0H = new byte[]{48, Base64.padSymbol, Base64.padSymbol, 62, 38, 124, 55, 35, 48, 60, 52, 124, 53, 35, 62, 33, 106, 123, 108, 104, 125, 108, 46, 36, Base64.padSymbol, 59, 32, 44, 46, 63, 2, 37, 59, 62, 63, Ascii.CAN, 62, 57, 45, 42, 40, 46, 43, 41, 56, Ascii.FS, 41, 34, 40, 37, 34, 43, 5, 34, 60, 57, 56, 10, 62, 45, 33, 41, Ascii.SI, 35, 57, 34, 56, 95, 72, 65, 72, 76, 94, 72, 107, 124, 119, 125, 124, 107, 86, 108, 109, 105, 108, 109, 95, 107, 120, 116, 124, 123, 109, 124, 65, 102, 120, 125, 124, 78, 122, 105, 101, 109, 65, 102, 110, 103, 89, 79, 94, 101, 95, 94, 90, 95, 94, 121, 95, 88, 76, 75, 73, 79, 99, 68, 76, 69};
    }

    static {
        A02();
    }

    public C0995Fo(G7 g7, AnonymousClass10 anonymousClass10, boolean z) {
        this.A0D = g7;
        this.A0C = anonymousClass10;
        this.A0G = z;
    }

    private void A03(long j, boolean z) {
        AbstractC07133y.A02(null);
        throw new NullPointerException(A01(74, 17, 52));
    }

    @MetaExoPlayerCustomization("The threshold here is non configurable and too low. Our renderer stalls and gets stuck if this is too strict")
    public static boolean A04(long j) {
        if (MetaExoPlayerUpgradeConfig.A03(EnumC2089jX.A1w)) {
            return j > ServiceProvider.SCAR_SIGNALS_FETCH_TIMEOUT;
        }
        int releaseLowerThresholdUs = MetaExoPlayerUpgradeConfig.A00(EnumC2090jY.A08);
        int releaseUpperThresholdUs = MetaExoPlayerUpgradeConfig.A00(EnumC2090jY.A07);
        return releaseLowerThresholdUs > 0 && releaseUpperThresholdUs > 0 && j > ((long) releaseUpperThresholdUs) && j < ((long) releaseLowerThresholdUs);
    }

    public final MediaFormat A06(MediaFormat mediaFormat) {
        Context context;
        if (C5C.A02 >= 29) {
            context = this.A0C.A0q;
            if (context.getApplicationContext().getApplicationInfo().targetSdkVersion >= 29) {
                mediaFormat.setInteger(A01(0, 16, Sdk.SDKError.Reason.INVALID_LOG_ERROR_ENDPOINT_VALUE), 0);
            }
        }
        return mediaFormat;
    }

    public final Surface A07() {
        AbstractC07133y.A01(null);
        throw new NullPointerException(A01(27, 15, 102));
    }

    public final void A08() {
        AbstractC07133y.A01(null);
        throw new NullPointerException(A01(108, 20, 7));
    }

    public final void A09() {
        AbstractC07133y.A02(null);
        throw new NullPointerException(A01(22, 5, 101));
    }

    public final void A0A() {
        AbstractC07133y.A01(null);
        throw new NullPointerException(A01(67, 7, 0));
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0091, code lost:
    
        if (r11 != false) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0093, code lost:
    
        A03(-1, r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0099, code lost:
    
        throw null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x00a9, code lost:
    
        if (r23 == false) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x00ab, code lost:
    
        r9 = r30.A0C.A0L;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x00b3, code lost:
    
        if (r31 != r9) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x00ba, code lost:
    
        if (A04(r2) == false) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x00bd, code lost:
    
        r30.A0D.A0G(r0);
        r2 = r30.A0D.A0B(java.lang.System.nanoTime() + (r2 * 1000));
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x00df, code lost:
    
        if (r30.A0C.A28((r2 - java.lang.System.nanoTime()) / 1000, r33, r7) == false) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x00e1, code lost:
    
        A03(-2, r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x00e7, code lost:
    
        throw null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x00ee, code lost:
    
        if (r30.A0E.isEmpty() != false) goto L42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0102, code lost:
    
        if (r0 <= ((java.lang.Long) r30.A0E.peek().first).longValue()) goto L42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0104, code lost:
    
        r30.A05 = r30.A0E.remove();
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x010e, code lost:
    
        r30.A0C.A0S(r24, r2, (com.instagram.common.viewpoint.core.C2489qI) r30.A05.second, null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0125, code lost:
    
        if (r30.A03 < r0) goto L45;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0127, code lost:
    
        r30.A03 = -9223372036854775807L;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x012e, code lost:
    
        A03(r2, r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x0132, code lost:
    
        throw null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:?, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:?, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x00b5, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x00a6, code lost:
    
        if (r11 != false) goto L21;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void A0B(long j, long j2) {
        long A03;
        boolean A0m;
        AbstractC07133y.A02(null);
        if (!this.A0F.isEmpty()) {
            boolean z = false;
            boolean z2 = this.A0C.A9A() == 2;
            long longValue = ((Long) AbstractC07133y.A01(this.A0F.peek())).longValue();
            long j3 = longValue + this.A01;
            A03 = this.A0C.A03(j, j2, SystemClock.elapsedRealtime() * 1000, j3, z2);
            String[] strArr = A0I;
            if (strArr[3].length() != strArr[0].length()) {
                throw new RuntimeException();
            }
            A0I[5] = "zEUSzuL7Up6U8aHJ";
            if (this.A0A && this.A0F.size() == 1) {
                z = true;
            }
            A0m = this.A0C.A0m(j, A03);
            if (A0I[6].charAt(14) != 'V') {
                A0I[6] = "eRnKdqaDWBmFpsVDZSVpTPvjw20fr8gH";
            } else {
                String[] strArr2 = A0I;
                strArr2[3] = "KJC5Qjc";
                strArr2[0] = "siyL2Ka";
            }
        }
    }

    public final void A0C(Surface surface, C07404z c07404z) {
        if (this.A06 != null && ((Surface) this.A06.first).equals(surface) && ((C07404z) this.A06.second).equals(c07404z)) {
            return;
        }
        this.A06 = Pair.create(surface, c07404z);
        if (A0G()) {
            AbstractC07133y.A01(null);
            new AnonymousClass50(surface, c07404z.A03(), c07404z.A02());
            throw new NullPointerException(A01(108, 20, 7));
        }
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [com.facebook.ads.redexgen.X.4I] */
    public final void A0D(C2489qI c2489qI) {
        AbstractC07133y.A01(null);
        final int i = c2489qI.A0L;
        final int i2 = c2489qI.A0A;
        new Object(i, i2) { // from class: com.facebook.ads.redexgen.X.4I
            public float A00 = 1.0f;
            public int A01;
            public int A02;
            public long A03;

            {
                this.A02 = i;
                this.A01 = i2;
            }

            public final C4I A00(float f) {
                this.A00 = f;
                return this;
            }

            /* JADX WARN: Type inference failed for: r0v0, types: [com.facebook.ads.redexgen.X.4J] */
            public final C4J A01() {
                return new Object(this.A02, this.A01, this.A00, this.A03) { // from class: com.facebook.ads.redexgen.X.4J
                    public static byte[] A04;
                    public final float A00;
                    public final int A01;
                    public final int A02;
                    public final long A03;

                    static {
                        A01();
                    }

                    public static String A00(int i3, int i4, int i5) {
                        byte[] copyOfRange = Arrays.copyOfRange(A04, i3, i3 + i4);
                        for (int i6 = 0; i6 < copyOfRange.length; i6++) {
                            copyOfRange[i6] = (byte) ((copyOfRange[i6] - i5) - 118);
                        }
                        return new String(copyOfRange);
                    }

                    public static void A01() {
                        A04 = new byte[]{75, 72, 76, 74, 75, 87, 3, 80, 88, 86, 87, 3, 69, 72, 3, 83, 82, 86, 76, 87, 76, 89, 72, Ascii.SI, 3, 69, 88, 87, 3, 76, 86, Ascii.GS, 3, -1, -15, -20, -4, -16, -88, -11, -3, -5, -4, -88, -22, -19, -88, -8, -9, -5, -15, -4, -15, -2, -19, -76, -88, -22, -3, -4, -88, -15, -5, -62, -88};
                    }

                    {
                        AbstractC07133y.A09(r7 > 0, A00(33, 32, 18) + r7);
                        AbstractC07133y.A09(r8 > 0, A00(0, 33, 109) + r8);
                        this.A02 = r7;
                        this.A01 = r8;
                        this.A00 = r9;
                        this.A03 = r10;
                    }
                };
            }
        }.A00(c2489qI.A02).A01();
        throw new NullPointerException(A01(91, 17, 37));
    }

    public final void A0E(String str) {
        Context context;
        context = this.A0C.A0q;
        this.A00 = C5C.A09(context, str, false);
    }

    public final void A0F(List<C4H> list) {
        if (this.A08 == null) {
            this.A08 = new CopyOnWriteArrayList<>(list);
        } else {
            this.A08.clear();
            this.A08.addAll(list);
        }
    }

    @MetaExoPlayerCustomization("SR video effects for AV1")
    public final boolean A0G() {
        boolean A21;
        if (this.A0G && 0 != 0) {
            A21 = this.A0C.A21();
            if (!A21) {
                return true;
            }
        }
        return false;
    }

    public final boolean A0H() {
        return this.A06 == null || !((C07404z) this.A06.second).equals(C07404z.A03);
    }

    public final boolean A0I() {
        return this.A0B;
    }

    public final boolean A0J(C2489qI c2489qI, long j) throws AD {
        AD A1S;
        boolean A0h;
        Context unused;
        AbstractC07133y.A08(!A0G());
        if (!this.A09) {
            return false;
        }
        if (this.A08 == null) {
            this.A09 = false;
            return false;
        }
        this.A04 = C5C.A0Y();
        this.A0C.A26(c2489qI.A0N);
        try {
            A0h = AnonymousClass10.A0h();
            if (!A0h && c2489qI.A0F != 0) {
                CopyOnWriteArrayList<C4H> copyOnWriteArrayList = this.A08;
                C0994Fn.A00(c2489qI.A0F);
                copyOnWriteArrayList.add(0, null);
            }
            C0994Fn.A01();
            unused = this.A0C.A0q;
            AbstractC07133y.A01(this.A08);
            Handler handler = this.A04;
            Objects.requireNonNull(handler);
            new C9N(handler);
            new C2291n4(this);
            throw new NullPointerException(A01(16, 6, 36));
        } catch (Exception e) {
            A1S = this.A0C.A1S(e, c2489qI, 7000);
            throw A1S;
        }
    }

    public final boolean A0K(C2489qI c2489qI, long j, boolean z) {
        AbstractC07133y.A02(null);
        AbstractC07133y.A08(this.A00 != -1);
        throw new NullPointerException(A01(42, 25, 97));
    }
}
