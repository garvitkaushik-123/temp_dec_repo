package com.inmobi.media;

import android.content.Context;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes4.dex */
public final class vf {

    /* renamed from: a, reason: collision with root package name */
    public final N9 f2737a;
    public final C2821q2 b;
    public uf c;

    public vf(N9 mNetworkRequest, C2821q2 mWebViewClient) {
        Intrinsics.checkNotNullParameter(mNetworkRequest, "mNetworkRequest");
        Intrinsics.checkNotNullParameter(mWebViewClient, "mWebViewClient");
        this.f2737a = mNetworkRequest;
        this.b = mWebViewClient;
    }

    public final void a() {
        try {
            Context d = Uc.d();
            if (d != null) {
                uf ufVar = new uf(d);
                ufVar.setWebViewClient(this.b);
                ufVar.getSettings().setJavaScriptEnabled(true);
                ufVar.getSettings().setCacheMode(2);
                this.c = ufVar;
            }
            uf ufVar2 = this.c;
            if (ufVar2 != null) {
                String d2 = this.f2737a.d();
                N9 n9 = this.f2737a;
                boolean z = T9.f2439a;
                T9.a(n9.i);
                ufVar2.loadUrl(d2, n9.i);
            }
        } catch (Exception unused) {
            Intrinsics.checkNotNullExpressionValue("vf", "TAG");
        }
    }
}
