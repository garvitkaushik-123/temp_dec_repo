package com.instagram.common.viewpoint.core;

import android.text.TextUtils;
import java.util.Locale;

/* renamed from: com.facebook.ads.redexgen.X.aL, reason: case insensitive filesystem */
/* loaded from: assets/audience_network/classes2.dex */
public abstract class AbstractC1536aL {
    public static String[] A00 = {"JDSePW2HSG4YeS6gtlV", "82T2GFaLeV3aTbLMJos0KxEKOb8V", "eQCDfbwHDs1I63LCwtRfVvk7aOq68Yi1", "mKAtiPzaErPw2g5AsekgNJUywNJKgzbn", "W6CrCk7jl5WmpSSnHELA9a4ylCy3ZwGN", "yC8I8b2mmbmFe3RpkHIpYdmwx30s8PcH", "t7vLS6XVWI7z", "7V80TKFhnzYK6cwmq9Eavbn4uXT7"};

    public static EnumC1540aP A00(AbstractC2094jd abstractC2094jd) {
        if (abstractC2094jd.A2U()) {
            EnumC1540aP enumC1540aP = EnumC1540aP.A02;
            if (A00[3].charAt(31) != 'n') {
                throw new RuntimeException();
            }
            A00[0] = "myUXVCGo2IYKrTscb4wiG";
            return enumC1540aP;
        }
        return EnumC1540aP.A03;
    }

    public static void A01(C1929gi c1929gi, EnumC1537aM enumC1537aM) {
        c1929gi.A0F().AAz(enumC1537aM.name().toLowerCase(Locale.US));
    }

    public static void A02(C1929gi c1929gi, EnumC1537aM enumC1537aM) {
        c1929gi.A0F().AB9(enumC1537aM.name().toLowerCase(Locale.US));
    }

    public static void A03(C1929gi c1929gi, EnumC1537aM enumC1537aM) {
        c1929gi.A0F().AC7(enumC1537aM.name().toLowerCase(Locale.US));
    }

    public static void A04(C1929gi c1929gi, EnumC1537aM enumC1537aM) {
        A01(c1929gi, enumC1537aM);
    }

    public static void A05(C1929gi c1929gi, EnumC1537aM enumC1537aM) {
        A02(c1929gi, enumC1537aM);
    }

    public static void A06(C1929gi c1929gi, EnumC1537aM enumC1537aM) {
        A03(c1929gi, enumC1537aM);
    }

    public static void A07(VI vi, C1929gi c1929gi, InterfaceC1470Yh interfaceC1470Yh, AbstractC2094jd abstractC2094jd, EnumC1537aM enumC1537aM) {
        if (vi != null) {
            vi.A04(VH.A0A, null);
        }
        if (abstractC2094jd.A2Q()) {
            c1929gi.A0F().AB8(enumC1537aM.name().toLowerCase(Locale.US));
        }
        if (abstractC2094jd.A2U()) {
            c1929gi.A0F().AAy(enumC1537aM.name().toLowerCase(Locale.US));
        }
        C1219Og A002 = AbstractC1220Oh.A00(c1929gi.A02());
        C1925ge A02 = c1929gi.A02();
        if (A00[6].length() != 12) {
            throw new RuntimeException();
        }
        A00[0] = "Fh7";
        if (A002.A0O(A02, true)) {
            if (interfaceC1470Yh != null) {
                interfaceC1470Yh.AAo(abstractC2094jd.A2E(), abstractC2094jd.A2C());
            }
        } else {
            if (TextUtils.isEmpty(abstractC2094jd.A2C().A00())) {
                return;
            }
            X6.A0O(new X6(), c1929gi, XB.A00(abstractC2094jd.A2C().A00()), abstractC2094jd.A2E());
        }
    }
}
