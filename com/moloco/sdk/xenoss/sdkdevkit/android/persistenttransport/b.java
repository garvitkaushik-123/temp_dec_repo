package com.moloco.sdk.xenoss.sdkdevkit.android.persistenttransport;

import com.moloco.sdk.xenoss.sdkdevkit.android.persistenttransport.d;
import io.ktor.http.ContentType;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public final class b implements a {
    public static final int c = 8;
    public final d b;

    public b(d delegate) {
        Intrinsics.checkNotNullParameter(delegate, "delegate");
        this.b = delegate;
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.persistenttransport.d
    public void a(String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        this.b.a(url);
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.persistenttransport.d
    public void a(String url, byte[] body, ContentType contentType, String str) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(body, "body");
        Intrinsics.checkNotNullParameter(contentType, "contentType");
        d.a.a(this.b, url, body, contentType, null, 8, null);
    }
}
