package com.inmobi.media;

import kotlin.jvm.internal.Intrinsics;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/* renamed from: com.inmobi.media.zc, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C2978zc implements Interceptor {
    @Override // okhttp3.Interceptor
    public final Response intercept(Interceptor.Chain chain) {
        Intrinsics.checkNotNullParameter(chain, "chain");
        Request request = chain.request();
        request.tag();
        Response proceed = chain.proceed(request);
        Intrinsics.checkNotNullExpressionValue(proceed, "proceed(...)");
        return proceed;
    }
}
