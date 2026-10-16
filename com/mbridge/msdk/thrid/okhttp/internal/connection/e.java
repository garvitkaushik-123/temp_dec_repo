package com.mbridge.msdk.thrid.okhttp.internal.connection;

import java.io.IOException;

/* compiled from: RouteException.java */
/* loaded from: classes6.dex */
public final class e extends RuntimeException {

    /* renamed from: a, reason: collision with root package name */
    private IOException f4828a;
    private IOException b;

    public e(IOException iOException) {
        super(iOException);
        this.f4828a = iOException;
        this.b = iOException;
    }

    public IOException a() {
        return this.f4828a;
    }

    public IOException b() {
        return this.b;
    }

    public void a(IOException iOException) {
        com.mbridge.msdk.thrid.okhttp.internal.c.a((Throwable) this.f4828a, (Throwable) iOException);
        this.b = iOException;
    }
}
