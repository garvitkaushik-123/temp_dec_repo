package com.inmobi.media;

import java.net.MalformedURLException;
import java.net.URL;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Interceptor;
import okhttp3.Response;

/* renamed from: com.inmobi.media.p7, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C2810p7 implements Interceptor {
    @Override // okhttp3.Interceptor
    public final Response intercept(Interceptor.Chain chain) {
        Intrinsics.checkNotNullParameter(chain, "chain");
        Response proceed = chain.proceed(chain.request());
        if (proceed.isRedirect()) {
            Intrinsics.checkNotNull(proceed);
            Intrinsics.checkNotNullParameter(proceed, "<this>");
            String header = proceed.isRedirect() ? proceed.header("Location") : null;
            if (header != null) {
                Intrinsics.checkNotNullParameter(header, "<this>");
                try {
                    new URL(header);
                } catch (MalformedURLException unused) {
                }
            }
            chain.call().cancel();
            throw new MalformedURLException(AbstractC2673h0.a("Invalid URL in Location header: ", header));
        }
        Intrinsics.checkNotNull(proceed);
        return proceed;
    }
}
