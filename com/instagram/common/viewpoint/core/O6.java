package com.instagram.common.viewpoint.core;

import android.text.TextUtils;
import com.vungle.ads.internal.protos.Sdk;
import java.util.Arrays;
import java.util.Iterator;

/* loaded from: assets/audience_network/classes2.dex */
public abstract class O6 {
    public static byte[] A00;

    static {
        A01();
    }

    public static String A00(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A00, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] ^ i3) ^ 102);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A00 = new byte[]{10, 76, 80, 73, 72, 121, 126, 100, 117, 98, 99, 100, 121, 100, 121, 113, 124, 101, 114, 96, 118, 101, 115, 114, 115, 72, 97, 126, 115, 114, 120};
    }

    /* JADX WARN: Incorrect condition in loop: B:10:0x00da */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void A02(C1929gi c1929gi, C1335Sx c1335Sx, C08047l c08047l) {
        c1335Sx.A0d(new C1333Sv(c08047l.A2C().A01(), C1766e4.A04, C1766e4.A04, c08047l.A1D(), A00(17, 14, 113)));
        boolean A1g = c08047l.A1g();
        String A002 = A00(17, 14, 113);
        if (A1g) {
            C1331St c1331St = new C1331St(c08047l.A0x(), c08047l.A1D(), A002);
            c1331St.A04 = true;
            c1331St.A03 = A00(0, 5, 66);
            c1335Sx.A0Y(c1331St);
        }
        boolean A30 = C1379Up.A30(c1929gi, C1856fX.A03());
        C1331St c1331St2 = new C1331St(c08047l.A29().A0H().A09(), c08047l.A1D(), A00(17, 14, 113), c08047l.A29().A0H().A06());
        if (A1g && !A30) {
            c1335Sx.A0Y(c1331St2);
        } else {
            c1335Sx.A0b(c1331St2);
        }
        c1335Sx.A0d(new C1333Sv(c08047l.A29().A0H().A08(), O1.A00(c08047l.A29().A0H()), O1.A01(c08047l.A29().A0H()), c08047l.A1D(), A00(17, 14, 113)));
        O0.A00(c08047l, c1335Sx, A002);
        Iterator<String> it = c08047l.A29().A0K().A02().iterator();
        while (isDSL) {
            String url = it.next();
            c1335Sx.A0d(new C1333Sv(url, -1, -1, c08047l.A1D(), A00(17, 14, 113)));
        }
    }

    public static void A03(C1929gi c1929gi, C1335Sx c1335Sx, C08047l c08047l) {
        int i = 0;
        for (NR nr : c08047l.A2G()) {
            C1333Sv c1333Sv = new C1333Sv(nr.A0H().A08(), O1.A00(nr.A0H()), O1.A01(nr.A0H()), c08047l.A1D(), A00(5, 12, Sdk.SDKError.Reason.PROTOBUF_SERIALIZATION_ERROR_VALUE));
            if (i == 0) {
                c1335Sx.A0c(c1333Sv);
            } else {
                c1335Sx.A0d(c1333Sv);
            }
            O0.A00(c08047l, c1335Sx, A00(17, 14, 113));
            Iterator<String> it = nr.A0K().A02().iterator();
            while (it.hasNext()) {
                c1335Sx.A0d(new C1333Sv(it.next(), -1, -1, c08047l.A1D(), A00(5, 12, Sdk.SDKError.Reason.PROTOBUF_SERIALIZATION_ERROR_VALUE)));
            }
            if (!TextUtils.isEmpty(nr.A0H().A09())) {
                new C1331St(nr.A0H().A09(), c08047l.A1D(), A00(5, 12, Sdk.SDKError.Reason.PROTOBUF_SERIALIZATION_ERROR_VALUE), nr.A0H().A06()).A04 = false;
            }
            i++;
        }
    }
}
