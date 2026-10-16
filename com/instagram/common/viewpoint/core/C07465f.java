package com.instagram.common.viewpoint.core;

import android.net.Uri;
import com.facebook.video.heroplayer.exocustom.MetaExoPlayerCustomization;
import com.vungle.ads.internal.protos.Sdk;
import java.util.Arrays;
import java.util.Collections;
import java.util.Map;

@MetaExoPlayerCustomization("Using fbDataSpecExtension instead of Object")
/* renamed from: com.facebook.ads.redexgen.X.5f, reason: invalid class name and case insensitive filesystem */
/* loaded from: assets/audience_network/classes2.dex */
public final class C07465f {
    public static byte[] A0A;
    public int A00;
    public int A01;
    public long A02;
    public long A03;
    public long A04;
    public Uri A05;
    public ML A06;
    public String A07;
    public Map<String, String> A08;
    public byte[] A09;

    static {
        A01();
    }

    public static String A00(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A0A, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] - i3) - 15);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A0A = new byte[]{-35, -15, -18, -87, -2, -5, -14, -87, -10, -2, -4, -3, -87, -21, -18, -87, -4, -18, -3, -73};
    }

    public C07465f() {
        this.A01 = 1;
        this.A08 = Collections.emptyMap();
        this.A02 = -1L;
    }

    @MetaExoPlayerCustomization("Using fbDataSpecExtension instead of Object")
    public C07465f(C07495i c07495i) {
        this.A05 = c07495i.A06;
        this.A04 = c07495i.A05;
        this.A01 = c07495i.A01;
        this.A09 = c07495i.A0A;
        this.A08 = c07495i.A09;
        this.A03 = c07495i.A04;
        this.A02 = c07495i.A03;
        this.A07 = c07495i.A08;
        this.A00 = c07495i.A00;
        this.A06 = c07495i.A07;
    }

    public final C07465f A02(int i) {
        this.A00 = i;
        return this;
    }

    public final C07465f A03(long j) {
        this.A02 = j;
        return this;
    }

    public final C07465f A04(long j) {
        this.A03 = j;
        return this;
    }

    public final C07465f A05(long j) {
        this.A04 = j;
        return this;
    }

    public final C07465f A06(Uri uri) {
        this.A05 = uri;
        return this;
    }

    @MetaExoPlayerCustomization("Using fbDataSpecExtension instead of Object")
    public final C07465f A07(ML ml) {
        this.A06 = ml;
        return this;
    }

    public final C07465f A08(String str) {
        this.A07 = str;
        return this;
    }

    @MetaExoPlayerCustomization("D50990955; Ensure that fbDataSpecExtension is not null")
    public final C07495i A09() {
        ML ml;
        AbstractC07133y.A03(this.A05, A00(0, 20, Sdk.SDKError.Reason.INVALID_ADS_ENDPOINT_VALUE));
        Uri uri = this.A05;
        long j = this.A04;
        int i = this.A01;
        byte[] bArr = this.A09;
        Map<String, String> map = this.A08;
        long j2 = this.A03;
        long j3 = this.A02;
        String str = this.A07;
        int i2 = this.A00;
        if (this.A06 != null) {
            ml = this.A06;
        } else {
            ml = new ML();
        }
        return new C07495i(uri, j, i, bArr, map, j2, j3, str, i2, ml);
    }
}
