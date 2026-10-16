package com.mbridge.msdk.thrid.okhttp.internal.connection;

import com.mbridge.msdk.thrid.okhttp.r;
import com.mbridge.msdk.thrid.okhttp.t;
import com.mbridge.msdk.thrid.okhttp.w;
import com.mbridge.msdk.thrid.okhttp.y;
import java.io.IOException;

/* compiled from: ConnectInterceptor.java */
/* loaded from: classes6.dex */
public final class a implements r {

    /* renamed from: a, reason: collision with root package name */
    public final t f4825a;

    public a(t tVar) {
        this.f4825a = tVar;
    }

    @Override // com.mbridge.msdk.thrid.okhttp.r
    public y a(r.a aVar) throws IOException {
        com.mbridge.msdk.thrid.okhttp.internal.http.g gVar = (com.mbridge.msdk.thrid.okhttp.internal.http.g) aVar;
        w d = gVar.d();
        g i = gVar.i();
        return gVar.a(d, i, i.a(this.f4825a, aVar, !d.e().equals("GET")), i.c());
    }
}
