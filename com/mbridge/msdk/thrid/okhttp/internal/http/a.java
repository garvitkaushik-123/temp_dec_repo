package com.mbridge.msdk.thrid.okhttp.internal.http;

import com.google.common.net.HttpHeaders;
import com.ironsource.D5;
import com.mbridge.msdk.thrid.okhttp.r;
import com.mbridge.msdk.thrid.okhttp.w;
import com.mbridge.msdk.thrid.okhttp.x;
import com.mbridge.msdk.thrid.okhttp.y;
import com.mbridge.msdk.thrid.okio.l;
import java.io.IOException;
import java.util.List;

/* compiled from: BridgeInterceptor.java */
/* loaded from: classes6.dex */
public final class a implements r {

    /* renamed from: a, reason: collision with root package name */
    private final com.mbridge.msdk.thrid.okhttp.k f4833a;

    public a(com.mbridge.msdk.thrid.okhttp.k kVar) {
        this.f4833a = kVar;
    }

    @Override // com.mbridge.msdk.thrid.okhttp.r
    public y a(r.a aVar) throws IOException {
        w d = aVar.d();
        w.a f = d.f();
        x a2 = d.a();
        if (a2 != null) {
            a2.b();
            long a3 = a2.a();
            if (a3 != -1) {
                f.b(HttpHeaders.CONTENT_LENGTH, Long.toString(a3));
                f.a(HttpHeaders.TRANSFER_ENCODING);
            } else {
                f.b(HttpHeaders.TRANSFER_ENCODING, "chunked");
                f.a(HttpHeaders.CONTENT_LENGTH);
            }
        }
        boolean z = false;
        if (d.a(HttpHeaders.HOST) == null) {
            f.b(HttpHeaders.HOST, com.mbridge.msdk.thrid.okhttp.internal.c.a(d.g(), false));
        }
        if (d.a(HttpHeaders.CONNECTION) == null) {
            f.b(HttpHeaders.CONNECTION, HttpHeaders.KEEP_ALIVE);
        }
        if (d.a(HttpHeaders.ACCEPT_ENCODING) == null && d.a("Range") == null) {
            f.b(HttpHeaders.ACCEPT_ENCODING, "gzip");
            z = true;
        }
        List<com.mbridge.msdk.thrid.okhttp.j> a4 = this.f4833a.a(d.g());
        if (!a4.isEmpty()) {
            f.b(HttpHeaders.COOKIE, a(a4));
        }
        if (d.a("User-Agent") == null) {
            f.b("User-Agent", com.mbridge.msdk.thrid.okhttp.internal.d.a());
        }
        y a5 = aVar.a(f.a());
        e.a(this.f4833a, d.g(), a5.m());
        y.a a6 = a5.o().a(d);
        if (z && "gzip".equalsIgnoreCase(a5.b(HttpHeaders.CONTENT_ENCODING)) && e.b(a5)) {
            com.mbridge.msdk.thrid.okio.j jVar = new com.mbridge.msdk.thrid.okio.j(a5.d().k());
            a6.a(a5.m().a().b(HttpHeaders.CONTENT_ENCODING).b(HttpHeaders.CONTENT_LENGTH).a());
            a6.a(new h(a5.b("Content-Type"), -1L, l.a(jVar)));
        }
        return a6.a();
    }

    private String a(List<com.mbridge.msdk.thrid.okhttp.j> list) {
        StringBuilder sb = new StringBuilder();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            if (i > 0) {
                sb.append("; ");
            }
            com.mbridge.msdk.thrid.okhttp.j jVar = list.get(i);
            sb.append(jVar.a()).append(D5.T).append(jVar.b());
        }
        return sb.toString();
    }
}
