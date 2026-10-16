package com.mbridge.msdk.thrid.okhttp.internal.http2;

import java.io.IOException;

/* compiled from: StreamResetException.java */
/* loaded from: classes6.dex */
public final class n extends IOException {

    /* renamed from: a, reason: collision with root package name */
    public final b f4865a;

    public n(b bVar) {
        super("stream was reset: " + bVar);
        this.f4865a = bVar;
    }
}
