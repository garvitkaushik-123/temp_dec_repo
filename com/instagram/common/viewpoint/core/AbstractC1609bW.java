package com.instagram.common.viewpoint.core;

import android.widget.RelativeLayout;
import androidx.exifinterface.media.ExifInterface;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.util.HashMap;

/* renamed from: com.facebook.ads.redexgen.X.bW, reason: case insensitive filesystem */
/* loaded from: assets/audience_network/classes2.dex */
public abstract class AbstractC1609bW {
    /* JADX WARN: Type inference failed for: r0v0, types: [com.facebook.ads.redexgen.X.1I] */
    public static C1I A00(final C1646c7 c1646c7, final UK uk, final String str, final C6X c6x) {
        final boolean z = true;
        return new C6M(c1646c7, uk, z, str, c6x) { // from class: com.facebook.ads.redexgen.X.1I
            public ViewOnClickListenerC1127Kr A00;
            public C1767e5 A01;
            public final VA A02 = this.A0I.A06().A02().A0A();
            public final UK A03;
            public final C6X A04;
            public final String A05;
            public static String[] A06 = {CampaignEx.JSON_KEY_AD_Q, "A73Xi2G3GXsP7eqOYxzIEC2a49UqAHwv", "tzkKnItTrh", "5yGem34VUXIU78ICazF0QaKYuuceWMlm", "d26mhKEOwDnFCjn", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "vFFUszWLQFPwstqQ2PhnuKwIvdRc", "cQLhl1S6XoLnT945hQssVDVRJiee0FVC"};
            public static final int A08 = (int) (XX.A02 * (-4.0f));
            public static final int A07 = (int) (XX.A02 * 6.0f);

            {
                this.A03 = uk;
                this.A05 = str;
                this.A04 = c6x;
                this.A03.A1Q(this);
            }

            @Override // com.instagram.common.viewpoint.core.AbstractC1090Jg
            public void setupNativeCtaExtension(C1767e5 c1767e5) {
                C1193Ng A2A;
                this.A01 = c1767e5;
                int A0Q = C1379Up.A0Q(this.A0I.A06());
                C1187Na A01 = this.A03.A13().A28().A01();
                C1929gi A062 = this.A0I.A06();
                String A0w = this.A03.A13().A0w();
                VA va = this.A02;
                InterfaceC1470Yh dummyListener = C1573aw.getDummyListener();
                C1874fp A0b = this.A04.A0b();
                Y2 A1E = this.A03.A1E();
                if (this.A03.A13() == null) {
                    A2A = null;
                } else {
                    A2A = this.A03.A13().A2A();
                }
                this.A00 = new ViewOnClickListenerC1127Kr(A062, A0w, A01, va, dummyListener, A0b, A1E, A2A);
                this.A00.setCta(c1767e5.A03().A0J(), this.A05, new HashMap());
                this.A03.A1Q(this.A00);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
                if (A0Q == 1) {
                    layoutParams.addRule(12);
                    String[] strArr = A06;
                    String str2 = strArr[5];
                    String str3 = strArr[0];
                    int length = str2.length();
                    int extensionVariant = str3.length();
                    if (length != extensionVariant) {
                        throw new RuntimeException();
                    }
                    A06[4] = "cEnNLXyXCc05OsZ";
                    YB.A0R(this.A00, A07, 5, A01.A0A(false));
                    ((C6M) this).A06.addView(this.A00, layoutParams);
                    return;
                }
                if (A0Q == 2) {
                    layoutParams.addRule(3, ((C6M) this).A06.getId());
                    int extensionVariant2 = A08;
                    layoutParams.setMargins(0, extensionVariant2, 0, 0);
                    addView(this.A00, 0, layoutParams);
                    ((C6M) this).A06.bringToFront();
                }
            }
        };
    }
}
