package com.instagram.common.viewpoint.core;

import android.content.Intent;
import android.text.TextUtils;
import com.facebook.ads.AdError;
import com.facebook.ads.CacheFlag;
import com.facebook.ads.RewardData;
import com.google.common.base.Ascii;
import com.vungle.ads.internal.protos.Sdk;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.EnumSet;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.facebook.ads.redexgen.X.Nu, reason: case insensitive filesystem */
/* loaded from: assets/audience_network/classes2.dex */
public final class C1207Nu {
    public static byte[] A05;
    public static String[] A06 = {"SwW", "nKJOmWTx3LjNZvOp7YbBROgXIyGkfXUh", "cNvS8LZQYgXEdOP85dYAvAy4C3J", "ICxq6EmLG0dgZi7UJ5PBV2wBsvrmCfpb", "tKedy3gZYTLe", "bmz0vq", "hvIAQTYE0cdtFIL2", "tj9oqRvQS19ndgZTuA"};
    public C1335Sx A00;
    public EnumC1590bD A01 = EnumC1590bD.A05;
    public ArrayList<C1713dC> A02 = new ArrayList<>();
    public final NQ A03;
    public final InterfaceC1206Nt A04;

    public static String A04(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A05, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] - i3) - 97);
        }
        return new String(copyOfRange);
    }

    public static void A06() {
        A05 = new byte[]{-35, Ascii.ETB, 35, Ascii.FS, Ascii.ESC, -66, -29, -23, -38, -25, -29, -42, -31, -107, -70, -25, -25, -28, -25, -107, -89, -91, -91, -85, -107, -20, -34, -23, -35, -28, -22, -23, -107, -42, -107, -21, -42, -31, -34, -39, -107, -74, -39, -66, -29, -37, -28, -93, Ascii.NAK, Ascii.CAN, 19, Ascii.CAN, Ascii.NAK, 40, Ascii.NAK, 19, Ascii.SYN, 41, 34, Ascii.CAN, 32, Ascii.EM, -29, -14, -21, -36, -31, -38, -30, -25, -40, -23, -38, -21, -38, -26, -20, Ascii.DC2, Ascii.ETB, Ascii.DLE, Ascii.CAN, Ascii.GS, Ascii.DC4, 19, -16, 19, -13, Ascii.DLE, 35, Ascii.DLE, -15, 36, Ascii.GS, 19, Ascii.ESC, Ascii.DC4, 63, 68, 74, 59, 72, 73, 74, 63, 74, 63, 55, 66};
    }

    static {
        A06();
    }

    public C1207Nu(C1929gi c1929gi, O8 o8, InterfaceC1206Nt interfaceC1206Nt, String str) {
        JSONObject dataObject = o8.A03();
        this.A03 = A01(c1929gi, o8, str, dataObject);
        this.A04 = interfaceC1206Nt;
    }

    private AdError A00(C1929gi c1929gi, AbstractC2094jd abstractC2094jd) {
        if (abstractC2094jd == null || abstractC2094jd.A2G().isEmpty()) {
            c1929gi.A08().ABC(A04(62, 3, 33), AbstractC1341Td.A0Z, new C1342Te(A04(5, 43, 20)));
            return AdError.internalError(2006);
        }
        return null;
    }

    public static NQ A01(C1929gi c1929gi, O8 o8, String str, JSONObject jSONObject) {
        NQ nq = null;
        if (jSONObject.has(A04(65, 12, 24))) {
            try {
                nq = C2088jT.A01(jSONObject, c1929gi, true);
                nq.A1Q(true);
                nq.A1N(A04(96, 12, Sdk.SDKError.Reason.ASSET_FAILED_STATUS_CODE_VALUE));
            } catch (JSONException unused) {
            }
        }
        if (nq == null) {
            nq = C08067n.A00(jSONObject, c1929gi);
        }
        nq.A1M(str);
        C1361Tx A01 = o8.A01();
        if (A01 != null) {
            nq.A1I(A01.A06());
        }
        return nq;
    }

    private C1335Sx A03(C1929gi c1929gi) {
        return this.A00 != null ? this.A00 : new C1335Sx(c1929gi);
    }

    private void A08(C1929gi c1929gi, C08067n c08067n) {
        C1201No playableData = c08067n.A29().A0H().A07();
        A0B(playableData != null ? playableData.A0H() : EnumC1590bD.A05);
        C2074jC c2074jC = new C2074jC(this);
        C1335Sx c1335Sx = new C1335Sx(c1929gi);
        boolean z = C1379Up.A2H(c1929gi) && SN.A0A(c08067n.A1H());
        if (z) {
            SN unifiedAssetsLoader = new SN(c1335Sx, c08067n.A1H(), c08067n.A10(), c08067n.A1D(), z, new C2073jB(this));
            c1335Sx.A0e(new VI(c08067n.A2E(), c1929gi.A0A()));
            unifiedAssetsLoader.A0B();
            return;
        }
        O5.A02(c1929gi, c08067n, true, c2074jC);
    }

    private void A09(C1929gi c1929gi, EnumSet<CacheFlag> enumSet, AbstractC2094jd abstractC2094jd, int i, InterfaceC1206Nt interfaceC1206Nt) {
        boolean isDSL = abstractC2094jd.A1g();
        C1335Sx A03 = A03(c1929gi);
        A03.A0e(new VI(abstractC2094jd.A2E(), c1929gi.A0A()));
        boolean z = C1379Up.A2H(c1929gi) && SN.A0A(abstractC2094jd.A1H());
        if (z) {
            new SN(A03, abstractC2094jd.A1H(), abstractC2094jd.A10(), abstractC2094jd.A1D(), z, new C2077jF(this, c1929gi, isDSL, abstractC2094jd, interfaceC1206Nt)).A0B();
            return;
        }
        String A04 = A04(96, 12, Sdk.SDKError.Reason.ASSET_FAILED_STATUS_CODE_VALUE);
        if (isDSL) {
            C1331St c1331St = new C1331St(abstractC2094jd.A0x(), abstractC2094jd.A1D(), A04);
            c1331St.A04 = true;
            c1331St.A03 = A04(0, 5, 78);
            A03.A0Y(c1331St);
        }
        A03.A0d(new C1333Sv(abstractC2094jd.A2C().A01(), C1766e4.A04, C1766e4.A04, abstractC2094jd.A1D(), A04(96, 12, Sdk.SDKError.Reason.ASSET_FAILED_STATUS_CODE_VALUE)));
        boolean isUnifiedAssetsLoaderEnabled = enumSet.contains(CacheFlag.VIDEO);
        int i2 = 0;
        boolean A30 = C1379Up.A30(c1929gi, C1856fX.A03());
        for (NR nr : abstractC2094jd.A2G()) {
            C1333Sv c1333Sv = new C1333Sv(nr.A0H().A08(), O1.A00(nr.A0H()), O1.A01(nr.A0H()), abstractC2094jd.A1D(), A04(96, 12, Sdk.SDKError.Reason.ASSET_FAILED_STATUS_CODE_VALUE));
            if (i2 == 0) {
                A03.A0c(c1333Sv);
            } else {
                A03.A0d(c1333Sv);
            }
            Iterator<String> it = nr.A0K().A02().iterator();
            while (it.hasNext()) {
                A03.A0d(new C1333Sv(it.next(), -1, -1, abstractC2094jd.A1D(), A04(96, 12, Sdk.SDKError.Reason.ASSET_FAILED_STATUS_CODE_VALUE)));
            }
            if (isUnifiedAssetsLoaderEnabled && !TextUtils.isEmpty(nr.A0H().A09())) {
                C1331St c1331St2 = new C1331St(nr.A0H().A09(), abstractC2094jd.A1D(), A04(96, 12, Sdk.SDKError.Reason.ASSET_FAILED_STATUS_CODE_VALUE), nr.A0H().A06());
                c1331St2.A04 = false;
                if (i2 == 0) {
                    if (isDSL && !A30) {
                        A03.A0Y(c1331St2);
                    } else {
                        A03.A0b(c1331St2);
                    }
                } else if (isDSL && !A30) {
                    A03.A0Z(c1331St2);
                } else {
                    A03.A0a(c1331St2);
                }
            }
            i2++;
        }
        if (abstractC2094jd.A1W() && !TextUtils.isEmpty(abstractC2094jd.A11())) {
            A03.A0d(new C1333Sv(abstractC2094jd.A11(), C1243Pe.A0A, C1243Pe.A0A, abstractC2094jd.A1D(), A04(96, 12, Sdk.SDKError.Reason.ASSET_FAILED_STATUS_CODE_VALUE)));
        }
        O0.A00(abstractC2094jd, A03, A04);
        A03.A0X(new C2075jD(this, c1929gi, isDSL, abstractC2094jd, interfaceC1206Nt), new C1328Sq(abstractC2094jd.A1D(), A04, i));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A0A(C1929gi c1929gi, EnumSet<CacheFlag> enumSet, C2088jT c2088jT, AbstractC2094jd abstractC2094jd, int i, InterfaceC1206Nt interfaceC1206Nt) {
        A09(c1929gi, enumSet, abstractC2094jd, i, new C2079jH(this, c1929gi, abstractC2094jd, c2088jT, i, interfaceC1206Nt, enumSet));
    }

    private void A0B(EnumC1590bD enumC1590bD) {
        this.A01 = enumC1590bD;
    }

    private boolean A0C(C1929gi c1929gi, AbstractC2094jd abstractC2094jd) {
        AdError A00 = A00(c1929gi, abstractC2094jd);
        if (A00 != null) {
            this.A04.ACo(A00);
            return true;
        }
        return false;
    }

    public final NQ A0D() {
        return this.A03;
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x006f, code lost:
    
        if (r3 != false) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0079, code lost:
    
        return com.instagram.common.viewpoint.core.WK.A0C;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0074, code lost:
    
        if (r3 != false) goto L24;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final WK A0E() {
        if (this.A03.A1b()) {
            return WK.A04;
        }
        AbstractC2094jd abstractC2094jd = (AbstractC2094jd) this.A03;
        if (abstractC2094jd.A1g()) {
            return WK.A06;
        }
        if (abstractC2094jd.A2G().size() > 1) {
            return WK.A0A;
        }
        C1201No A07 = abstractC2094jd.A29().A0H().A07();
        if (A06[4].length() == 14) {
            throw new RuntimeException();
        }
        String[] strArr = A06;
        strArr[1] = "HO5lN2vl3hawZ3xdOTbB4PXxItmZOFKM";
        strArr[3] = "QabHGQsenJFHZf5mHftqzVXi6FXcwsQx";
        if (A07 != null) {
            if (!abstractC2094jd.A1n()) {
                boolean A1u = abstractC2094jd.A1u();
                if (A06[0].length() != 2) {
                    String[] strArr2 = A06;
                    strArr2[1] = "iV2CDA2M2IfUZLXvhnmiNr1pV0Sur2CQ";
                    strArr2[3] = "GDT4frbvCKvkZrCQcOaJTMqN9T6RIdn0";
                }
            }
            return WK.A0E;
        }
        boolean A0L = A0L(abstractC2094jd);
        if (A06[0].length() == 2) {
            throw new RuntimeException();
        }
        A06[0] = "iDu";
        if (A0L) {
            return WK.A0D;
        }
        return WK.A0B;
    }

    public final EnumC1590bD A0F() {
        return this.A01;
    }

    public final String A0G() {
        if (this.A03.A1b()) {
            return ((C2088jT) this.A03).A2A();
        }
        return ((AbstractC2094jd) this.A03).A2E();
    }

    public final void A0H() {
        this.A04.AKX();
    }

    public final void A0I(Intent intent, RewardData rewardData, String str) {
        this.A03.A1K(rewardData);
        this.A03.A1O(str);
        if (A0D().A1b()) {
            intent.putExtra(A04(77, 19, 78), this.A03);
        }
        intent.putExtra(A04(48, 14, 83), this.A03);
    }

    public final void A0J(C1929gi c1929gi, EnumSet<CacheFlag> enumSet) {
        if (A0E() == WK.A04) {
            C2088jT c2088jT = (C2088jT) this.A03;
            AbstractC2094jd A26 = c2088jT.A26();
            if (A0C(c1929gi, A26) || A26 == null) {
                return;
            }
            this.A04.AHY();
            A0A(c1929gi, enumSet, c2088jT, A26, 0, this.A04);
            return;
        }
        AbstractC2094jd abstractC2094jd = (AbstractC2094jd) this.A03;
        if (A06[5].length() == 0) {
            throw new RuntimeException();
        }
        String[] strArr = A06;
        strArr[1] = "h3j4XQE4N9RDZ4AU6tvjsFYKX3e30HKG";
        strArr[3] = "lDhcJ7lgFtqhZjTb781X3zaoWDc2BWUc";
        if (A0C(c1929gi, abstractC2094jd)) {
            return;
        }
        this.A04.AHY();
        if (A0E() == WK.A0C) {
            C08067n c08067n = (C08067n) this.A03;
            String[] strArr2 = A06;
            if (strArr2[2].length() != strArr2[6].length()) {
                A06[7] = "0uVLF1bkkTEn2WeYm46QMmOd1A6";
                A08(c1929gi, c08067n);
                return;
            } else {
                A08(c1929gi, c08067n);
                return;
            }
        }
        A09(c1929gi, enumSet, (C08067n) this.A03, -1, this.A04);
    }

    public final boolean A0K() {
        return this.A03.A1U();
    }

    public final boolean A0L(AbstractC2094jd abstractC2094jd) {
        return !TextUtils.isEmpty(abstractC2094jd.A29().A0H().A09());
    }
}
