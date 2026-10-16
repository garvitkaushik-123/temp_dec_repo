package com.inmobi.media;

import android.content.Context;
import android.webkit.WebView;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes4.dex */
public abstract class X1 extends WebView {

    /* renamed from: a, reason: collision with root package name */
    public final Lazy f2476a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public X1(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.f2476a = LazyKt.lazy(new W1(this));
    }

    public abstract M6 f();

    public final M6 getLandingPageHandler() {
        return (M6) this.f2476a.getValue();
    }
}
