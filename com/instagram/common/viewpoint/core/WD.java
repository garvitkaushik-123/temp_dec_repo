package com.instagram.common.viewpoint.core;

import android.text.TextUtils;
import android.util.Pair;
import com.facebook.ads.internal.protocol.AdErrorType;
import com.google.common.base.Ascii;
import java.util.Arrays;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: assets/audience_network/classes2.dex */
public final class WD {
    public static byte[] A08;
    public static String[] A09 = {"gkSyaXwR", "2VU3Nz3voiV1lmdRee4U2QJOpqB0EmXx", "l2PJ1mhNLKomP6h8XAPCJTvwOfm7DNfm", "U14uMoZpedA5MoqMp8wF", "ZGFJtzG5houIZuhA5wVIi53yZAjLLlX2", "TKuU0S0TRmpOZ7a0gUh222TH0KiJMCsX", "Ntgwe7QRVjptK5Vt0gMbvLxTukJluaCr", "4nIPbhAhAn1Dg8Q4wgXTfE5Yoh5xfpBP"};
    public static final YE A0A;
    public static final Executor A0B;
    public static final AtomicReference<WH> A0C;
    public long A00;
    public long A01;
    public WC A02;
    public Map<String, String> A03;
    public final C1219Og A04;
    public final C1929gi A05;
    public final WE A06;
    public final String A07;

    public static String A06(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A08, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] - i3) - 57);
        }
        return new String(copyOfRange);
    }

    public static void A0B() {
        A08 = new byte[]{113, 107, -97, 108, 106, 111, -96, 112, -32, -15, -17, -21, -19, -25, -16, -19, -23, -14, -8, 3, -10, -23, -11, -7, -23, -9, -8, 3, -19, -24, -126, -84, 89, -117, -121, 115, 89, -62, -61, -108, -70, -67, -64, -64, -108, -26, -39, -41, -39, -35, -22, -39, -40, -39, -6, -85, -47, -12, -9, -9, -85, -16, -3, -3, -6, -3, -85, -18, -6, -17, -16, -85, -26, -80, -2, -24, -85, -80, -2, -33, -35, -26, -35, -22, -31, -37, -57, -66, -51, -48, -56, -53, -60, 10, Ascii.VT, -30, 5, 8, 8, -28, Ascii.VT, Ascii.VT, 7, -35, -33, -36, -29, -42, -47, -46};
    }

    static {
        A0B();
        A0A = new YE();
        A0B = Executors.newCachedThreadPool(A0A);
        A0C = new AtomicReference<>();
    }

    public WD(C1929gi c1929gi) {
        this(c1929gi, AbstractC1220Oh.A00(c1929gi.A02()));
    }

    public WD(C1929gi c1929gi, C1219Og c1219Og) {
        this.A01 = -1L;
        this.A00 = -1L;
        this.A05 = c1929gi;
        this.A06 = WE.A00();
        this.A07 = WI.A01(c1929gi);
        this.A04 = c1219Og;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public C1323Sl A03(long j, WA wa) {
        return new C1323Sl(this, wa, j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A0A() {
        if (this.A05 == null || !C1898gD.A0A(this.A05)) {
            return;
        }
        C1342Te c1342Te = new C1342Te(A06(8, 5, 102));
        c1342Te.A05(1);
        this.A05.A08().ABC(A06(86, 7, 32), AbstractC1341Td.A1x, c1342Te);
    }

    private void A0C(int i, String str) {
        String A06 = A06(37, 16, 59);
        String A062 = A06(0, 8, 1);
        String A063 = A06(93, 10, 99);
        AbstractC1412Vy.A05(A063, A06, A062);
        AbstractC1412Vy.A04(A063, String.format(Locale.US, A06(53, 26, 82), Integer.valueOf(i), str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A0D(C1401Vm c1401Vm) {
        if (this.A02 != null) {
            this.A02.ADp(c1401Vm);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A0E(C1401Vm c1401Vm) {
        Y4.A00(new RO(this, c1401Vm));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A0L(RG rg) {
        if (this.A02 != null) {
            this.A02.AG7(rg);
        } else {
            if (rg.A00() == null || rg.A00().A06() == null) {
                return;
            }
            C1425Wl.A00(this.A05).A0D(rg.A00().A06().toString(), rg.A00().A0B());
        }
    }

    private void A0M(RG rg) {
        TE syncModule;
        Y4.A00(new SO(this, rg));
        if (C1379Up.A2e(this.A05) && (syncModule = this.A05.A06()) != null) {
            syncModule.A6d();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A0N(String str, long j, WA wa) {
        String clientChallenge;
        try {
        } catch (Exception e) {
            e = e;
        }
        try {
            WG A07 = this.A06.A07(this.A05, str, j);
            C1360Tw A00 = A07.A00();
            if (A00 != null) {
                C1379Up.A0V(this.A05).A36(A00.A0A());
                if (C1379Up.A0x(this.A05) && A00.A08() != null) {
                    U6.A04(this.A05.A02(), A00.A08());
                }
                if (C1379Up.A0y(this.A05) && A00.A0D() != null) {
                    U6.A05(this.A05.A02(), A00.A0D());
                }
                this.A05.A08().ACP();
                this.A04.A0N(A00.A07());
                W9.A05(A00.A05().A0B(), wa);
                YS.A01(this.A05, A0B, A00);
                C1342Te c1342Te = new C1342Te(A06(30, 7, 0) + XY.A02());
                c1342Te.A06(1);
                c1342Te.A0A(false);
                this.A05.A08().ACA(A06(79, 7, 63), AbstractC1341Td.A1W, c1342Te);
            }
            switch (A07.A01()) {
                case A02:
                    RG rg = (RG) A07;
                    if (A00 != null) {
                        if (A00.A05().A0E()) {
                            W9.A07(str, wa);
                        }
                        if (this.A03 != null) {
                            clientChallenge = this.A03.get(A06(13, 17, 107));
                        } else {
                            clientChallenge = null;
                        }
                        if (!TextUtils.isEmpty(A07.A02()) && !TextUtils.isEmpty(clientChallenge)) {
                            this.A05.A03().AIi(this.A05, clientChallenge, A07.A02());
                        }
                    }
                    this.A05.A0F().A3X(Y1.A01(this.A01), Y1.A02(this.A01, this.A00));
                    A0M(rg);
                    return;
                case A03:
                    R4 r4 = (R4) A07;
                    String A04 = r4.A04();
                    AdErrorType adErrorTypeFromCode = AdErrorType.adErrorTypeFromCode(r4.A03(), AdErrorType.ERROR_MESSAGE);
                    A0C(r4.A03(), A04);
                    if (A04 == null) {
                        A04 = str;
                    }
                    this.A05.A0F().A3W(Y1.A01(this.A01), adErrorTypeFromCode.getErrorCode(), A04, adErrorTypeFromCode.isPublicError());
                    A0E(C1401Vm.A01(adErrorTypeFromCode, A04));
                    return;
                default:
                    AdErrorType adErrorType = AdErrorType.UNKNOWN_RESPONSE;
                    this.A05.A0F().A3W(Y1.A01(this.A01), adErrorType.getErrorCode(), str, adErrorType.isPublicError());
                    A0E(C1401Vm.A01(adErrorType, str));
                    return;
            }
        } catch (Exception e2) {
            e = e2;
            String message = e.getMessage();
            AdErrorType adErrorType2 = AdErrorType.PARSER_FAILURE;
            C1929gi c1929gi = this.A05;
            if (A09[0].length() == 29) {
                throw new RuntimeException();
            }
            A09[0] = "STn1t4NLUPoQ";
            c1929gi.A0F().A3W(Y1.A01(this.A01), adErrorType2.getErrorCode(), message, adErrorType2.isPublicError());
            A0E(C1401Vm.A01(adErrorType2, message));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A0O(String str, long j, WA wa) {
        A0B.execute(new C1329Sr(this, str, j, wa));
    }

    private boolean A0P(WA wa) {
        String adPlacementType = wa.A06().toString();
        if (C1425Wl.A00(this.A05).A0F(adPlacementType)) {
            return false;
        }
        int A0A2 = C1425Wl.A00(this.A05).A0A(adPlacementType);
        int storedAdsCount = C1379Up.A0J(this.A05);
        int A092 = C1425Wl.A00(this.A05).A09(adPlacementType);
        if (A0A2 >= storedAdsCount || A0A2 > A092) {
            C1425Wl A00 = C1425Wl.A00(this.A05);
            String type = wa.A06().toString();
            Pair<String, String> A0B2 = A00.A0B(type);
            if (A0B2 != null) {
                Object obj = A0B2.second;
                String[] strArr = A09;
                String str = strArr[1];
                String str2 = strArr[4];
                int storedAdsCount2 = str.charAt(27);
                if (storedAdsCount2 == str2.charAt(27)) {
                    throw new RuntimeException();
                }
                String[] strArr2 = A09;
                strArr2[5] = "wxWvHA1chxzz72CPhzVDSI5kTKVxH7gh";
                strArr2[2] = "qa9WwGn6xu1bvFfukLGFlV7cMdAOaohF";
                if (obj != null && A0B2.first != null) {
                    A0O(A0B2.second.toString(), 0L, wa);
                    return true;
                }
            }
        }
        return false;
    }

    public final void A0Q(WA wa) {
        this.A01 = System.currentTimeMillis();
        C1351Tn.A0B(this.A05);
        A0C.get();
        if (0 != 0) {
            throw new NullPointerException(A06(103, 7, 52));
        }
        if (C1379Up.A02(this.A05) > 0 && A0P(wa)) {
            return;
        }
        if (W9.A08(wa)) {
            YG.A06.execute(new C1344Tg(this));
            String A02 = W9.A02(wa);
            if (A02 != null) {
                this.A05.A0F().AKg();
                A0O(A02, 0L, wa);
                return;
            } else {
                AdErrorType error = AdErrorType.LOAD_TOO_FREQUENTLY;
                this.A05.A0F().A3W(Y1.A01(this.A01), error.getErrorCode(), error.getDefaultErrorMessage(), error.isPublicError());
                A0E(C1401Vm.A01(error, null));
                return;
            }
        }
        A0B.execute(new TZ(this, wa));
    }

    public final void A0R(WC wc) {
        this.A02 = wc;
    }
}
