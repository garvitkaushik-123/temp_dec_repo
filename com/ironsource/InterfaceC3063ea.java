package com.ironsource;

import android.os.Build;
import android.webkit.WebView;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: com.ironsource.ea, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public interface InterfaceC3063ea {

    /* renamed from: com.ironsource.ea$a */
    public static final class a implements InterfaceC3063ea {

        /* renamed from: a, reason: collision with root package name */
        private WebView f3270a;
        private boolean b;

        public a() {
            this(0, 1, null);
        }

        private final void b(String str) {
            WebView webView = this.f3270a;
            if (webView != null) {
                webView.evaluateJavascript(str, null);
            }
        }

        private final void c(String str) {
            WebView webView = this.f3270a;
            if (webView != null) {
                webView.loadUrl("javascript:" + str);
            }
        }

        @Override // com.ironsource.InterfaceC3063ea
        public boolean a() {
            return this.f3270a != null;
        }

        public a(int i) {
            this.b = i >= 19;
        }

        @Override // com.ironsource.InterfaceC3063ea
        public void a(String script) {
            Intrinsics.checkNotNullParameter(script, "script");
            try {
                if (this.b) {
                    b(script);
                } else {
                    c(script);
                }
            } catch (Throwable th) {
                C3260q4.d().a(th);
                this.b = false;
                c(script);
            }
        }

        public /* synthetic */ a(int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this((i2 & 1) != 0 ? Build.VERSION.SDK_INT : i);
        }

        @Override // com.ironsource.InterfaceC3063ea
        public void a(WebView webView) {
            Intrinsics.checkNotNullParameter(webView, "webView");
            this.f3270a = webView;
        }
    }

    void a(WebView webView);

    void a(String str);

    boolean a();
}
