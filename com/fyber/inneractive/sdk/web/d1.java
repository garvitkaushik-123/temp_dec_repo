package com.fyber.inneractive.sdk.web;

import android.webkit.WebResourceRequest;
import java.util.Collections;
import java.util.HashMap;

/* loaded from: classes4.dex */
public final class d1 {

    /* renamed from: a, reason: collision with root package name */
    public final String f1795a;
    public final String b;
    public final HashMap c;

    public d1(WebResourceRequest webResourceRequest) {
        this.f1795a = webResourceRequest.getUrl().toString();
        this.b = webResourceRequest.getMethod();
        this.c = new HashMap(webResourceRequest.getRequestHeaders() == null ? Collections.emptyMap() : webResourceRequest.getRequestHeaders());
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || d1.class != obj.getClass()) {
            return false;
        }
        d1 d1Var = (d1) obj;
        if (this.f1795a.equals(d1Var.f1795a) && this.b.equals(d1Var.b)) {
            return this.c.equals(d1Var.c);
        }
        return false;
    }

    public final int hashCode() {
        return this.c.hashCode() + ((this.b.hashCode() + (this.f1795a.hashCode() * 31)) * 31);
    }
}
