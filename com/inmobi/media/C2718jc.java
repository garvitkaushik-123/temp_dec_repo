package com.inmobi.media;

import android.webkit.WebView;
import android.webkit.WebViewRenderProcess;
import android.webkit.WebViewRenderProcessClient;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: com.inmobi.media.jc, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C2718jc extends WebViewRenderProcessClient {

    /* renamed from: a, reason: collision with root package name */
    public final InterfaceC2971z5 f2613a;
    public final C2782nc b;

    public C2718jc(InterfaceC2971z5 interfaceC2971z5, C2782nc c2782nc) {
        this.f2613a = interfaceC2971z5;
        this.b = c2782nc;
    }

    @Override // android.webkit.WebViewRenderProcessClient
    public final void onRenderProcessResponsive(WebView view, WebViewRenderProcess webViewRenderProcess) {
        Intrinsics.checkNotNullParameter(view, "view");
        InterfaceC2971z5 interfaceC2971z5 = this.f2613a;
        if (interfaceC2971z5 != null) {
            ((A5) interfaceC2971z5).a("RenderViewRenderProcessClient", "onRenderProcessResponsive " + view + ' ' + webViewRenderProcess);
        }
        C2782nc c2782nc = this.b;
        if (c2782nc != null) {
            Map a2 = c2782nc.a();
            a2.put("creativeId", c2782nc.f2652a.f);
            int i = c2782nc.e + 1;
            c2782nc.e = i;
            a2.put("count", Integer.valueOf(i));
            String a3 = c2782nc.a("RenderProcessResponsive");
            Pd pd = Pd.f2401a;
            Pd.b(a3, a2, Td.f2443a);
        }
    }

    @Override // android.webkit.WebViewRenderProcessClient
    public final void onRenderProcessUnresponsive(WebView view, WebViewRenderProcess webViewRenderProcess) {
        Intrinsics.checkNotNullParameter(view, "view");
        InterfaceC2971z5 interfaceC2971z5 = this.f2613a;
        if (interfaceC2971z5 != null) {
            ((A5) interfaceC2971z5).a("RenderViewRenderProcessClient", "onRenderProcessUnresponsive " + view + ' ' + webViewRenderProcess);
        }
        C2782nc c2782nc = this.b;
        if (c2782nc != null) {
            Map a2 = c2782nc.a();
            a2.put("creativeId", c2782nc.f2652a.f);
            int i = c2782nc.d + 1;
            c2782nc.d = i;
            a2.put("count", Integer.valueOf(i));
            String a3 = c2782nc.a("RenderProcessUnResponsive");
            Pd pd = Pd.f2401a;
            Pd.b(a3, a2, Td.f2443a);
        }
    }
}
