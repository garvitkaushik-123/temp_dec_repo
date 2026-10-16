package com.instagram.common.viewpoint.core;

import com.google.common.base.Ascii;
import com.vungle.ads.internal.protos.Sdk;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* renamed from: com.facebook.ads.redexgen.X.7g, reason: invalid class name and case insensitive filesystem */
/* loaded from: assets/audience_network/classes2.dex */
public final class C07997g extends AbstractC2064j0 {
    public static byte[] A00;
    public static String[] A01 = {"5V5lzA70kRKZvNcqBnXwT00Z041t6ONl", "kRuh8LYE7MIIox", "vbi5lrus1TtIcXopJBSqGum5Kl452Sg0", "JcNQ6WafPgnmx1aBDePIhrwzaceROyrU", "60x4BO5hhvvMWgz", "65jgyaanPJJ2TdYJaJc79ygQBnrUrWFq", "zOX7nuTxFizV3LeqTcyyEc2wd", "PvIxiwPRiyIOar7lINjn4bFuW"};

    public static String A00(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A00, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] ^ i3) ^ Sdk.SDKError.Reason.INVALID_LOG_ERROR_ENDPOINT_VALUE);
        }
        return new String(copyOfRange);
    }

    public static void A03() {
        A00 = new byte[]{42, 47, 107, 34, 56, 107, 37, 36, 63, 107, 57, 46, 42, 47, 50, 107, 36, 57, 107, 42, 39, 57, 46, 42, 47, 50, 107, 47, 34, 56, 59, 39, 42, 50, 46, 47, Ascii.DC4, Ascii.NAK, Ascii.FS, 17, 9};
    }

    static {
        A03();
    }

    public C07997g(C1929gi c1929gi, O7 o7) {
        super(c1929gi, o7);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Map<String, String> A01(long j) {
        HashMap hashMap = new HashMap();
        hashMap.put(A00(36, 5, 12), String.valueOf(System.currentTimeMillis() - j));
        return hashMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A05(List<String> trackingUrls, Map<String, String> extraData) {
        if (trackingUrls != null) {
            boolean isEmpty = trackingUrls.isEmpty();
            if (A01[3].charAt(25) != 'c') {
                throw new RuntimeException();
            }
            String[] strArr = A01;
            strArr[6] = "86KHDrV9NKgfIZAVdUdv4tP2w";
            strArr[7] = "hnWt117Y9rLxZfnYOmFuZ36IL";
            if (isEmpty) {
                return;
            }
            Iterator<String> it = trackingUrls.iterator();
            while (it.hasNext()) {
                new AsyncTaskC1900gF(this.A0B, extraData).execute(it.next());
            }
        }
    }

    @Override // com.instagram.common.viewpoint.core.AbstractC2064j0
    public final void A0P() {
        C2111ju c2111ju = (C2111ju) this.A01;
        if (c2111ju.A0R()) {
            N2 n2 = this.A07;
            if (A01[3].charAt(25) != 'c') {
                throw new RuntimeException();
            }
            A01[4] = "SmlVqZ";
            if (n2 != null) {
                this.A07.A0B(c2111ju);
                return;
            }
            return;
        }
        throw new IllegalStateException(A00(0, 36, 55));
    }

    @Override // com.instagram.common.viewpoint.core.AbstractC2064j0
    public final void A0R(N1 n1, C1360Tw c1360Tw, C1358Tu c1358Tu, O8 o8) {
        C2111ju c2111ju = (C2111ju) n1;
        long currentTimeMillis = System.currentTimeMillis();
        C2061ix c2061ix = new C2061ix(this, o8, c2111ju, currentTimeMillis, c1358Tu);
        A0H().postDelayed(c2061ix, c1360Tw.A05().A05());
        c2111ju.A0L(this.A0B, new C2060iw(this, c2061ix, currentTimeMillis, c1358Tu), this.A09, o8, UK.A0K());
    }
}
