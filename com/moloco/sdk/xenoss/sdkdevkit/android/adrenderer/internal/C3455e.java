package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal;

import android.webkit.WebView;
import com.ironsource.D5;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.e, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C3455e {

    /* renamed from: a, reason: collision with root package name */
    public static final String f5831a = "https://appassets.androidplatform.net";

    public static final void a(WebView webView, String data) {
        Intrinsics.checkNotNullParameter(webView, "<this>");
        Intrinsics.checkNotNullParameter(data, "data");
        webView.loadDataWithBaseURL("https://appassets.androidplatform.net", data, "text/html", D5.N, null);
    }
}
