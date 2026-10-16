package com.instagram.common.viewpoint.core;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Build;
import android.text.TextUtils;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.google.common.base.Ascii;
import com.vungle.ads.internal.protos.Sdk;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.Set;
import kotlin.io.encoding.Base64;

/* renamed from: com.facebook.ads.redexgen.X.at, reason: case insensitive filesystem */
/* loaded from: assets/audience_network/classes2.dex */
public class C1570at extends WebViewClient {
    public static byte[] A05;
    public final WeakReference<C1929gi> A02;
    public final WeakReference<InterfaceC1567aq> A03;
    public final WeakReference<C1562al> A04;
    public final InterfaceC1566ap A01 = new InterfaceC1566ap() { // from class: com.facebook.ads.redexgen.X.M4
        @Override // com.instagram.common.viewpoint.core.InterfaceC1566ap
        public final boolean AAf(String str) {
            return C1570at.A04(str);
        }
    };
    public WeakReference<InterfaceC1568ar> A00 = new WeakReference<>(null);

    static {
        A01();
    }

    public static String A00(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A05, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] ^ i3) ^ 44);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A05 = new byte[]{Ascii.FS, Ascii.US, Ascii.DC2, 8, 9, 71, Ascii.US, 17, Ascii.FS, 19, Ascii.SYN, 37, 42, Ascii.ESC, 37, 39, 48, 45, 50, 45, 48, Base64.padSymbol, Ascii.FF, 3, 9, Ascii.US, 2, 4, 9, 67, 4, 3, Ascii.EM, 8, 3, Ascii.EM, 67, Ascii.FF, Ascii.SO, Ascii.EM, 4, 2, 3, 67, 59, 36, 40, 58, 119, 120, 114, 100, 121, Byte.MAX_VALUE, 114, 56, Byte.MAX_VALUE, 120, 98, 115, 120, 98, 56, 117, 119, 98, 115, 113, 121, 100, 111, 56, 84, 68, 89, 65, 69, 87, 84, 90, 83, 117, 101, 120, 96, 100, 114, 101, 72, 113, 118, 123, 123, 117, 118, 116, 124, 72, 98, 101, 123, 51, 54, 35, 54, 97, 102, 124, 109, 102, 124, 2, 5, Ascii.ESC, 77, 87, Ascii.US, Ascii.CR, 10, 55, Ascii.RS, 1, Ascii.CR, Ascii.US};
    }

    public C1570at(WeakReference<C1929gi> weakReference, WeakReference<InterfaceC1567aq> weakReference2, WeakReference<C1562al> weakReference3) {
        this.A02 = weakReference;
        this.A03 = weakReference2;
        this.A04 = weakReference3;
    }

    private void A02(String str, C1929gi c1929gi) {
        c1929gi.A08().ABC(A00(11, 11, 104), AbstractC1341Td.A09, new C1342Te(A00(111, 5, 91) + str));
    }

    /* JADX WARN: Code restructure failed: missing block: B:70:0x015f, code lost:
    
        if (r0.contains(r2) == false) goto L64;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean A03(WebView webView, String str) {
        boolean z;
        boolean A14;
        String A00;
        String A002;
        String A003;
        boolean z2;
        boolean z3;
        Set set;
        Set set2;
        Intent intent;
        String A004 = A00(116, 8, 68);
        C1929gi c1929gi = this.A02.get();
        if (c1929gi != null) {
            z = M3.A0A;
            if ((z && (TextUtils.isEmpty(str) || A00(0, 11, 81).equals(str))) || !this.A01.AAf(str)) {
                return true;
            }
            try {
                Uri uri = XB.A00(str);
                String scheme = uri.getScheme();
                try {
                    A14 = C1379Up.A14(c1929gi);
                    A00 = A00(48, 33, 58);
                    A002 = A00(22, 26, 65);
                    A003 = A00(105, 6, 36);
                } catch (Exception e) {
                    c1929gi.A08().ABD(A004, AbstractC1341Td.A2d, new C1342Te(e));
                    c1929gi.A0F().AA2(e.toString());
                }
                if (A14) {
                    set2 = M3.A0D;
                    if (!set2.contains(scheme) && !A00(101, 4, Sdk.SDKError.Reason.INVALID_RI_ENDPOINT_VALUE).equals(scheme)) {
                        if (A003.equalsIgnoreCase(scheme)) {
                            intent = Intent.parseUri(str, 1);
                            intent.setComponent(null);
                            intent.setSelector(null);
                        } else {
                            intent = new Intent(A002, uri);
                        }
                        intent.addCategory(A00);
                        if (Build.VERSION.SDK_INT >= 30) {
                            intent.setFlags(268436480);
                        } else {
                            intent.setFlags(268435456);
                        }
                        try {
                            if (!C1433Wu.A0D(c1929gi, intent)) {
                                A02(str, c1929gi);
                            }
                            return true;
                        } catch (C1431Ws unused) {
                            if (A003.equals(scheme)) {
                                String stringExtra = intent.getStringExtra(A00(81, 20, 59));
                                if (!TextUtils.isEmpty(stringExtra)) {
                                    if (!C1433Wu.A0D(c1929gi, new Intent(A002, XB.A00(stringExtra)))) {
                                        A02(str, c1929gi);
                                    }
                                    return true;
                                }
                            }
                            C1342Te c1342Te = new C1342Te(A00(111, 5, 91) + str);
                            c1342Te.A05(1);
                            c1929gi.A08().ABD(A00(11, 11, 104), AbstractC1341Td.A06, c1342Te);
                            return true;
                        }
                    }
                    return false;
                }
                z2 = M3.A0A;
                if (!z2 || !A003.equalsIgnoreCase(scheme)) {
                    z3 = M3.A0A;
                    if (!z3 || !AbstractC1438Xb.A04(str)) {
                        set = M3.A0D;
                    }
                    return C1433Wu.A0D(c1929gi, new Intent(A002, uri));
                }
                Intent parseUri = Intent.parseUri(str, 1);
                parseUri.addCategory(A00);
                parseUri.setComponent(null);
                parseUri.setSelector(null);
                if (c1929gi.getPackageManager().resolveActivity(parseUri, 65536) != null && C1433Wu.A0D(c1929gi, parseUri)) {
                    webView.goBack();
                    return true;
                }
                return false;
            } catch (SecurityException e2) {
                c1929gi.A08().ABD(A004, AbstractC1341Td.A2d, new C1342Te(e2));
                return true;
            }
        }
        return false;
    }

    public static /* synthetic */ boolean A04(String str) {
        return true;
    }

    public final void A05(WeakReference<InterfaceC1568ar> weakReference) {
        this.A00 = weakReference;
    }

    @Override // android.webkit.WebViewClient
    public final void onPageFinished(WebView webView, String str) {
        super.onPageFinished(webView, str);
        C1562al timingLogger = this.A04.get();
        if (timingLogger != null) {
            timingLogger.A03();
        }
        InterfaceC1567aq interfaceC1567aq = this.A03.get();
        if (interfaceC1567aq != null) {
            interfaceC1567aq.AF7(str);
        }
        InterfaceC1568ar interfaceC1568ar = this.A00.get();
        if (interfaceC1568ar != null) {
            interfaceC1568ar.ADB(webView.canGoBack());
            interfaceC1568ar.ADx(webView.canGoForward());
        }
    }

    @Override // android.webkit.WebViewClient
    public final void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        super.onPageStarted(webView, str, bitmap);
        InterfaceC1567aq listener = this.A03.get();
        if (listener != null) {
            listener.AF9(str);
        }
    }

    @Override // android.webkit.WebViewClient
    public final void onReceivedError(WebView webView, int i, String str, String str2) {
        super.onReceivedError(webView, i, str, str2);
        C1929gi c1929gi = this.A02.get();
        if (c1929gi != null) {
            StringBuilder sb = new StringBuilder();
            String A00 = A00(0, 0, 109);
            String errorMessage = AbstractC1438Xb.A01(i, sb.append(A00).append(str).toString(), A00 + str2);
            c1929gi.A0F().A9z(errorMessage);
        }
    }

    @Override // android.webkit.WebViewClient
    public final void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
        super.onReceivedError(webView, webResourceRequest, webResourceError);
        C1929gi c1929gi = this.A02.get();
        if (c1929gi != null) {
            int errorCode = webResourceError.getErrorCode();
            StringBuilder sb = new StringBuilder();
            String A00 = A00(0, 0, 109);
            String errorMessage = AbstractC1438Xb.A01(errorCode, sb.append(A00).append((Object) webResourceError.getDescription()).toString(), A00 + webResourceRequest.getUrl());
            c1929gi.A0F().A9z(errorMessage);
        }
    }

    @Override // android.webkit.WebViewClient
    public final void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
        super.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
        C1929gi context = this.A02.get();
        if (context != null) {
            context.A0F().AA0();
        }
    }

    @Override // android.webkit.WebViewClient
    public final void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
        super.onReceivedSslError(webView, sslErrorHandler, sslError);
        C1929gi context = this.A02.get();
        if (context != null) {
            context.A0F().AA1();
        }
    }

    @Override // android.webkit.WebViewClient
    public final boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
        AbstractC1575ay.A0D(AbstractC1341Td.A2e);
        InterfaceC1567aq listener = this.A03.get();
        if (listener != null) {
            listener.AFe();
            return true;
        }
        return true;
    }

    @Override // android.webkit.WebViewClient
    public final boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
        return A03(webView, webResourceRequest.getUrl().toString());
    }

    @Override // android.webkit.WebViewClient
    public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
        return A03(webView, str);
    }
}
