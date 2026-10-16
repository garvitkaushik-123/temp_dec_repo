package com.instagram.common.viewpoint.core;

import android.util.Log;
import androidx.recyclerview.widget.ItemTouchHelper;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import com.vungle.ads.internal.protos.Sdk;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Arrays;
import kotlin.io.encoding.Base64;

/* renamed from: com.facebook.ads.redexgen.X.kh, reason: case insensitive filesystem */
/* loaded from: assets/audience_network/classes2.dex */
public final class C2158kh implements InterfaceC1147Ll {
    public static String A07;
    public static byte[] A08;
    public static String[] A09 = {"76RHNajjOom", "Mjpn3pRzDJalybdRDXibpwNEIm", "yniKdbkjQS3x88FVx9CeVftqblxxQhpu", "Bjsdcl6Zd1aHs", "xxeVE5WeJXBB6h2Smwfm1cLqVC", "jWBIYbGBA8wTLtSAwtOQxldoJ8", "SNbZ6FPeFicMqudBak9DrYkQXr", "PSBHzZzFGATU6u0TdgIgliGoBbccT2bp"};
    public int A00;
    public InputStream A01;
    public HttpURLConnection A02;
    public final String A03;
    public volatile int A04;
    public volatile int A05;
    public volatile String A06;

    public static String A01(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A08, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] ^ i3) ^ 4);
        }
        return new String(copyOfRange);
    }

    public static void A04() {
        A08 = new byte[]{43, 98, 120, 43, 98, 101, Byte.MAX_VALUE, 110, 121, 121, 126, 123, Byte.MAX_VALUE, 110, 111, 33, 117, 110, 33, 102, 49, 47, 50, 46, 102, 41, 32, 32, 53, 35, 50, 102, 108, 96, 35, 47, 46, 52, 37, 46, 52, 109, 44, 37, 46, 39, 52, 40, 122, 96, 5, Ascii.DC4, Ascii.SO, 77, 65, SignedBytes.MAX_POWER_OF_TWO, SignedBytes.MAX_POWER_OF_TWO, 75, 77, 90, 71, 65, SignedBytes.MAX_POWER_OF_TWO, Ascii.SO, 71, 93, Ascii.SO, 79, 76, 93, 75, SignedBytes.MAX_POWER_OF_TWO, 90, Ascii.SI, Ascii.DC4, 56, 57, 35, 50, 57, 35, 119, 62, 57, 49, 56, 119, 49, 56, 37, 119, 55, Ascii.CAN, 47, 47, 50, 47, 125, 57, 52, 46, 62, 50, 51, 51, 56, 62, 41, 52, 51, 58, 125, Ascii.NAK, 41, 41, 45, 8, 47, 49, Ascii.RS, 50, 51, 51, 56, 62, 41, 52, 50, 51, Ascii.NAK, 34, 34, 63, 34, 112, 54, 53, 36, 51, 56, 57, 62, 55, 112, 57, 62, 54, 63, 112, 54, 34, 63, Base64.padSymbol, 112, Ascii.ESC, 44, 44, 49, 44, 126, 49, 46, 59, 48, 55, 48, 57, 126, Base64.padSymbol, 49, 48, 48, 59, Base64.padSymbol, 42, 55, 49, 48, 126, 56, 49, 44, 126, 35, Ascii.DC4, Ascii.DC4, 9, Ascii.DC4, 70, Ascii.DC4, 3, 7, 2, Ascii.SI, 8, 1, 70, 2, 7, Ascii.DC2, 7, 70, 0, Ascii.DC4, 9, Ascii.VT, 70, 92, 96, 96, 100, 65, 102, 120, 71, 123, 97, 102, 119, 113, 111, 97, 102, 120, 41, 51, 101, 70, 74, 72, 93, SignedBytes.MAX_POWER_OF_TWO, 70, 71, 0, 63, 42, 33, 111, 44, 32, 33, 33, 42, 44, 59, 38, 32, 33, 111, 85, 102, 105, 96, 98, 109, 90, 94, 91, Ascii.US, 92, 80, 81, 75, 90, 81, 75, Ascii.US, 86, 81, 89, 80, Ascii.US, 89, 77, 80, 82, Ascii.US, 106, 93, 89, 92, 81, 86, 95, Ascii.CAN, 75, 87, 77, 74, 91, 93, Ascii.CAN, 33, Ascii.SUB, Ascii.SUB, 85, Ascii.CAN, Ascii.DC4, Ascii.ESC, Ascii.FF, 85, 7, Ascii.DLE, 17, Ascii.FS, 7, Ascii.DLE, Ascii.SYN, 1, 6, 79, 85, 92, 6, Ascii.FS, 81, 85, 81, 89, 6, Ascii.FS, Ascii.RS, 5, 8, Ascii.EM, Ascii.SI, 65, 99};
    }

    static {
        A04();
        A07 = C2158kh.class.getSimpleName();
    }

    public C2158kh(String str) {
        this(str, C1145Lj.A01(str));
    }

    public C2158kh(String str, int i) {
        this(str);
        this.A00 = i;
    }

    public C2158kh(String str, String str2) {
        this.A05 = Integer.MIN_VALUE;
        this.A00 = -1;
        this.A03 = (String) AbstractC1146Lk.A00(str);
        this.A06 = str2;
    }

    private int A00(HttpURLConnection httpURLConnection, int i, int i2) throws IOException {
        int contentLength = httpURLConnection.getContentLength();
        return i2 == 200 ? contentLength : i2 == 206 ? contentLength + i : this.A05;
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x00c9, code lost:
    
        if (r6 != 302) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x00cd, code lost:
    
        if (r6 != 303) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x00eb, code lost:
    
        r6 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x00f9, code lost:
    
        if (r6 != 302) goto L20;
     */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00d2  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00e8 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0106 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private HttpURLConnection A02(int i, int i2) throws IOException, C2164kn {
        HttpURLConnection httpURLConnection;
        boolean z;
        int code = 0;
        String str = this.A03;
        do {
            String str2 = A01(234, 16, 75) + (i > 0 ? A01(19, 13, 66) + i : A01(0, 0, 127)) + A01(15, 4, 5) + str;
            httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            if (i > 0) {
                httpURLConnection.setRequestProperty(A01(ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION, 5, 3), A01(322, 6, 120) + i + A01(50, 1, 44));
            }
            if (i2 > 0) {
                httpURLConnection.setConnectTimeout(i2);
                if (A09[3].length() != 13) {
                    throw new RuntimeException();
                }
                A09[0] = "1Ss55MOjwkg";
                httpURLConnection.setReadTimeout(i2);
            }
            int responseCode = httpURLConnection.getResponseCode();
            this.A04 = responseCode;
            if (responseCode != 301) {
                String[] strArr = A09;
                String url = strArr[4];
                String str3 = strArr[6];
                int length = url.length();
                int redirectCount = str3.length();
                if (length == redirectCount) {
                    String[] strArr2 = A09;
                    strArr2[1] = "p6lJtanqIpTVtR8wvrkpKJ2zYO";
                    strArr2[5] = "gJMCNOhCywWTIArSLN7pAqKg27";
                }
                if (z) {
                    str = httpURLConnection.getHeaderField(A01(Sdk.SDKError.Reason.BIDPAYLOAD_TEMPLATE_TYPE_MISMATCH_ERROR_VALUE, 8, 45));
                    code++;
                    httpURLConnection.disconnect();
                }
                if (code <= 5) {
                    String url2 = A01(293, 20, 113) + code;
                    throw new C2164kn(url2);
                }
            }
            z = true;
            if (z) {
            }
            if (code <= 5) {
            }
        } while (z);
        return httpURLConnection;
    }

    private void A03() throws C2164kn {
        String str = A01(255, 23, 59) + this.A03;
        HttpURLConnection httpURLConnection = null;
        InputStream inputStream = null;
        try {
            try {
                httpURLConnection = A02(0, 10000);
                this.A05 = httpURLConnection.getContentLength();
                this.A06 = httpURLConnection.getContentType();
                inputStream = httpURLConnection.getInputStream();
                Log.i(A07, A01(74, 18, 83) + this.A03 + A01(Sdk.SDKError.Reason.EVALUATE_JAVASCRIPT_FAILED_VALUE, 9, 56) + this.A06 + A01(32, 18, 68) + this.A05);
                C1145Lj.A05(inputStream);
                if (httpURLConnection == null) {
                    return;
                }
            } catch (IOException e) {
                Log.e(A07, A01(129, 25, 84) + this.A03, e);
                C1145Lj.A05(inputStream);
                if (httpURLConnection == null) {
                    return;
                }
            }
            httpURLConnection.disconnect();
        } catch (Throwable th) {
            C1145Lj.A05(inputStream);
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
            throw th;
        }
    }

    private final void A05(int i, int i2) throws C2164kn {
        try {
            this.A02 = A02(i, i2);
            this.A06 = this.A02.getContentType();
            this.A01 = new BufferedInputStream(this.A02.getInputStream(), 8192);
            this.A05 = A00(this.A02, i, this.A02.getResponseCode());
        } catch (IOException e) {
            throw new C2164kn(A01(154, 29, 90) + this.A03 + A01(19, 13, 66) + i, e);
        }
    }

    public final int A06() {
        return this.A04;
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1147Ll
    public final void AGj(int i) throws C2164kn {
        A05(i, this.A00);
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1147Ll
    public final void close() throws C2164kn {
        if (this.A02 != null) {
            try {
                this.A02.disconnect();
            } catch (NullPointerException e) {
                throw new C2164kn(A01(92, 37, 89), e);
            }
        }
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1147Ll
    public final synchronized int length() throws C2164kn {
        if (this.A05 == Integer.MIN_VALUE) {
            A03();
        }
        return this.A05;
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1147Ll
    public final int read(byte[] bArr) throws C2164kn {
        InputStream inputStream = this.A01;
        String A01 = A01(183, 24, 98);
        if (inputStream != null) {
            try {
                return this.A01.read(bArr, 0, bArr.length);
            } catch (InterruptedIOException e) {
                final String str = A01(278, 15, 60) + this.A03 + A01(0, 15, 15);
                throw new C2164kn(str, e) { // from class: com.facebook.ads.redexgen.X.8K
                };
            } catch (IOException e2) {
                throw new C2164kn(A01 + this.A03, e2);
            }
        }
        throw new C2164kn(A01 + this.A03 + A01(51, 23, 42));
    }

    public final String toString() {
        return A01(207, 19, 16) + this.A03 + A01(328, 1, 26);
    }
}
