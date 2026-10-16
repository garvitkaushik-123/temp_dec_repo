package com.instagram.common.viewpoint.core;

import android.os.Bundle;
import android.text.TextUtils;
import java.util.HashMap;

/* renamed from: com.facebook.ads.redexgen.X.c4, reason: case insensitive filesystem */
/* loaded from: assets/audience_network/classes2.dex */
public abstract class AbstractC1643c4 {
    public static String[] A00 = {"e7juOHCMVCS96MucXvvyM5upzpE0CxcL", "6Axk6XM18YFtFlcC0tEdKqjogVlmemrm", "CHYE97fUe", "94l1C", "pvrd7E3JtMrEOvPAC3lcGaqqDdvc2Rnk", "mswd2ljSuB4EOxjza27Iz7krcpdQKmDN", "x2gmwPWroRNX0socjzMaFBH0Y3mBhUE3", "1dJrelJWCcDuEHtNsp3IaM8Oqex3ZZ7a"};

    public static AbstractC1642c3 A00(C1646c7 c1646c7, Bundle bundle, boolean z) {
        AbstractC1642c3 ku;
        c1646c7.A06().A0H().A00(false);
        NR A29 = c1646c7.A05().A29();
        double A002 = AbstractC1633bu.A00(A29);
        boolean isWatchAndBrowse = c1646c7.A05().A29().A0T();
        boolean A06 = AbstractC1633bu.A06(c1646c7.A00(), c1646c7.A01(), A002);
        AbstractC1181Mt A003 = C1182Mu.A00(c1646c7.A06(), c1646c7.A07(), "", XB.A00(c1646c7.A05().A29().A0J().A05()), new HashMap(), c1646c7.A05().A2A());
        boolean z2 = !TextUtils.isEmpty(A29.A0H().A09());
        if (C1379Up.A1z(c1646c7.A06())) {
            C1929gi A062 = c1646c7.A06();
            String[] strArr = A00;
            if (strArr[4].charAt(27) == strArr[6].charAt(27)) {
                throw new RuntimeException();
            }
            String[] strArr2 = A00;
            strArr2[5] = "oHCvC4ERmXYMU8sW9KKIPv7pnY2wXb01";
            strArr2[7] = "G3HUaMks2xBdg2z9mSbIts1gYwx1OgmU";
            A062.A0B().AKn(c1646c7.A02(), c1646c7.A05().A2E(), z2);
        }
        if (isWatchAndBrowse && (A003 instanceof AnonymousClass84)) {
            ku = A01(c1646c7) ? new C1092Ji(c1646c7) : new KE(c1646c7);
        } else if (z2) {
            ku = new C6H(c1646c7);
        } else {
            if (c1646c7.A05().A1c()) {
                return new C1112Kc(c1646c7);
            }
            if (c1646c7.A05().A1j()) {
                ku = new C6K(c1646c7);
            } else if (C1379Up.A2i(c1646c7.A06())) {
                ku = new C6J(c1646c7, A06);
            } else if (A06) {
                ku = new KZ(c1646c7, c1646c7.A00() == 2);
            } else {
                ku = new KU(c1646c7, AbstractC1633bu.A04(A002));
            }
        }
        if (z) {
            ku.A1H(A29, c1646c7.A05().A2E(), A002, bundle);
        }
        return ku;
    }

    public static boolean A01(C1646c7 c1646c7) {
        if (!c1646c7.A05().A1y()) {
            boolean A1c = c1646c7.A05().A1c();
            String[] strArr = A00;
            if (strArr[4].charAt(27) == strArr[6].charAt(27)) {
                throw new RuntimeException();
            }
            String[] strArr2 = A00;
            strArr2[5] = "BfXu055milBajq8QiXDIPY7ZZDWb7rZy";
            strArr2[7] = "zfsTxDhfKJjHYbZVz1DIv6IoDbSXcVhK";
            if (!A1c) {
                return false;
            }
        }
        return true;
    }
}
