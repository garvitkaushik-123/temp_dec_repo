package io.bidmachine.analytics.internal;

import java.net.HttpURLConnection;
import java.net.URLConnection;

/* loaded from: classes7.dex */
public enum o0 {
    Get("GET"),
    Post("POST");


    /* renamed from: a, reason: collision with root package name */
    private final String f6750a;

    o0(String str) {
        this.f6750a = str;
    }

    public final void a(URLConnection uRLConnection) {
        if (uRLConnection instanceof HttpURLConnection) {
            ((HttpURLConnection) uRLConnection).setRequestMethod(this.f6750a);
        }
    }
}
