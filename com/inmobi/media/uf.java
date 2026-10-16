package com.inmobi.media;

import android.content.Context;
import android.webkit.WebView;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes4.dex */
public final class uf extends WebView {

    /* renamed from: a, reason: collision with root package name */
    public boolean f2726a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public uf(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    @Override // android.webkit.WebView
    public final void destroy() {
        this.f2726a = true;
        super.destroy();
    }
}
