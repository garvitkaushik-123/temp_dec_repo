package com.instagram.common.viewpoint.core;

import android.os.Bundle;
import java.util.ArrayList;

/* renamed from: com.facebook.ads.redexgen.X.pv, reason: case insensitive filesystem */
/* loaded from: assets/audience_network/classes2.dex */
public final class C2466pv implements AnonymousClass24 {
    public final C06782n A00;
    public static String[] A01 = {"mula3CidaM", "QXZvrsMqvoQg77WBvlve", "clHaL9AVxqL", "4", "dTVzaj3Js", "vbPIPyw6rptXOUyrUErD6RaDDuBNyqsV", "dqUk2BmO1rRhKnsvPvl2vnYni3", "mE8b9jVFwC8HjBTnnlrMONG37KhdcP6J"};
    public static final C2466pv A03 = new C3P().A04();
    public static final String A04 = C5C.A0h(0);
    public static final AnonymousClass23<C2466pv> A02 = new AnonymousClass23() { // from class: com.facebook.ads.redexgen.X.pw
        @Override // com.instagram.common.viewpoint.core.AnonymousClass23
        public final AnonymousClass24 A6f(Bundle bundle) {
            C2466pv A012;
            A012 = C2466pv.A01(bundle);
            return A012;
        }
    };

    public C2466pv(C06782n c06782n) {
        this.A00 = c06782n;
    }

    public static C2466pv A01(Bundle bundle) {
        ArrayList<Integer> integerArrayList = bundle.getIntegerArrayList(A04);
        if (integerArrayList == null) {
            return A03;
        }
        C3P c3p = new C3P();
        int i = 0;
        while (true) {
            int size = integerArrayList.size();
            if (A01[7].charAt(28) != 'c') {
                throw new RuntimeException();
            }
            A01[7] = "mp2TMNIiilctnlK0CRpdI2bFoWxScr6M";
            if (i < size) {
                c3p.A00(integerArrayList.get(i).intValue());
                i++;
            } else {
                return c3p.A04();
            }
        }
    }

    public final boolean equals(Object obj) {
        if (this != obj) {
            if (!(obj instanceof C2466pv)) {
                return false;
            }
            return this.A00.equals(((C2466pv) obj).A00);
        }
        if (A01[5].charAt(22) == 'S') {
            throw new RuntimeException();
        }
        String[] strArr = A01;
        strArr[2] = "64Urjp6xISM";
        strArr[0] = "9byEEtKTR1";
        return true;
    }

    public final int hashCode() {
        return this.A00.hashCode();
    }
}
