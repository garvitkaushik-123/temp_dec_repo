package com.instagram.common.viewpoint.core;

import android.util.Log;
import com.vungle.ads.internal.protos.Sdk;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/* renamed from: com.facebook.ads.redexgen.X.Cm, reason: case insensitive filesystem */
/* loaded from: assets/audience_network/classes2.dex */
public final class C0917Cm implements InterfaceC1879fu {
    public static byte[] A04;
    public int A00;
    public String A01;
    public Map<String, List<String>> A02;
    public byte[] A03;

    static {
        A01();
    }

    public static String A00(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A04, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] ^ i3) ^ Sdk.SDKError.Reason.INVALID_LOG_ERROR_ENDPOINT_VALUE);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A04 = new byte[]{72, 99, 114, 113, 105, 116, 109, 38, 99, 116, 116, 105, 116};
    }

    public C0917Cm(HttpURLConnection httpURLConnection, byte[] bArr) {
        try {
            this.A00 = httpURLConnection.getResponseCode();
            this.A01 = httpURLConnection.getURL().toString();
        } catch (IOException e) {
            Log.e(getClass().getSimpleName(), A00(0, 13, Sdk.SDKError.Reason.INVALID_ADS_ENDPOINT_VALUE), e);
        }
        this.A02 = httpURLConnection.getHeaderFields();
        this.A03 = bArr;
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1879fu
    public final byte[] A72() {
        return this.A03;
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1879fu
    public final String A73() {
        if (this.A03 != null) {
            return new String(this.A03);
        }
        return null;
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1879fu
    public final Map<String, List<String>> A8E() {
        return this.A02;
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1879fu
    public final int A9C() {
        return this.A00;
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1879fu
    public final String getUrl() {
        return this.A01;
    }
}
