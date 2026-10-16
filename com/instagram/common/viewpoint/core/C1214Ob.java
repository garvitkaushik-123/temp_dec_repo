package com.instagram.common.viewpoint.core;

import java.lang.ref.WeakReference;

/* renamed from: com.facebook.ads.redexgen.X.Ob, reason: case insensitive filesystem */
/* loaded from: assets/audience_network/classes2.dex */
public class C1214Ob extends AbstractC1873fo {
    public static String[] A01 = {"M3Te92XvVv4q3bfKEkaCq6oPQP87x4vv", "LzmiiHhJsyKuUkJv7K1Ir2o", "KopJ75", "b4r1pmUHtrvrrbICXjY", "ceBgm8EiRhrot5ffXZtZ35omPt2ZFFf0", "0EayevzsZQe4lRY4RLfa4MEWre", "N9h8Vj", "K1Ob6mZ8MwS9WZtXZ80XEzEALvtTcRJ2"};
    public final /* synthetic */ Z2 A00;

    public C1214Ob(Z2 z2) {
        this.A00 = z2;
    }

    @Override // com.instagram.common.viewpoint.core.AbstractC1873fo
    public final void A03() {
        AbstractC1229Oq abstractC1229Oq;
        C1874fp c1874fp;
        Y2 y2;
        WeakReference weakReference;
        C1874fp c1874fp2;
        Y2 y22;
        AbstractC1229Oq abstractC1229Oq2;
        C1874fp c1874fp3;
        abstractC1229Oq = this.A00.A08;
        if (abstractC1229Oq != null) {
            abstractC1229Oq2 = this.A00.A08;
            if (!abstractC1229Oq2.A0G()) {
                c1874fp3 = this.A00.A0A;
                c1874fp3.A0T();
                return;
            }
        }
        c1874fp = this.A00.A0A;
        c1874fp.A0V();
        y2 = this.A00.A06;
        if (!y2.A07()) {
            y22 = this.A00.A06;
            y22.A05();
        }
        weakReference = this.A00.A0C;
        Z1 listener = (Z1) weakReference.get();
        if (listener != null) {
            listener.AEA();
        }
        Z2 z2 = this.A00;
        String[] strArr = A01;
        if (strArr[1].length() == strArr[3].length()) {
            throw new RuntimeException();
        }
        String[] strArr2 = A01;
        strArr2[1] = "2rS8p9kEkH8XxeBlGl7RSlB";
        strArr2[3] = "nqXy6qNf0NylKakjBUJ";
        c1874fp2 = z2.A0A;
        c1874fp2.A0V();
    }
}
