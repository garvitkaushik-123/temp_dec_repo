package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal;

import android.content.Context;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.webkit.WebView;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.d, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public class C3454d extends WebView {
    public static final int b = 0;

    /* renamed from: a, reason: collision with root package name */
    public final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.webview.g f5830a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C3454d(Context context) {
        super(context.getApplicationContext());
        Intrinsics.checkNotNullParameter(context, "context");
        this.f5830a = new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.webview.g();
    }

    @Override // android.webkit.WebView
    public void destroy() {
        ViewParent parent = getParent();
        ViewGroup viewGroup = parent instanceof ViewGroup ? (ViewGroup) parent : null;
        if (viewGroup != null) {
            viewGroup.removeView(this);
        }
        removeAllViews();
        super.destroy();
    }

    public final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.webview.g getHtmlCssFixer() {
        return this.f5830a;
    }
}
