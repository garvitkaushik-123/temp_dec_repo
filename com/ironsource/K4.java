package com.ironsource;

import java.io.InputStream;
import java.net.URL;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
final class K4 implements W3 {

    /* renamed from: a, reason: collision with root package name */
    public static final K4 f2923a = new K4();

    private K4() {
    }

    @Override // com.ironsource.W3
    public InputStream a(String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        InputStream openStream = new URL(url).openStream();
        Intrinsics.checkNotNullExpressionValue(openStream, "URL(url).openStream()");
        return openStream;
    }
}
