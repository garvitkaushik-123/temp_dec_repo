package com.mbridge.msdk.thrid.okhttp.internal.http2;

import com.ironsource.mediationsdk.logger.IronSourceError;

/* compiled from: Header.java */
/* loaded from: classes6.dex */
public final class c {
    public static final com.mbridge.msdk.thrid.okio.f d = com.mbridge.msdk.thrid.okio.f.c(":");
    public static final com.mbridge.msdk.thrid.okio.f e = com.mbridge.msdk.thrid.okio.f.c(":status");
    public static final com.mbridge.msdk.thrid.okio.f f = com.mbridge.msdk.thrid.okio.f.c(":method");
    public static final com.mbridge.msdk.thrid.okio.f g = com.mbridge.msdk.thrid.okio.f.c(":path");
    public static final com.mbridge.msdk.thrid.okio.f h = com.mbridge.msdk.thrid.okio.f.c(":scheme");
    public static final com.mbridge.msdk.thrid.okio.f i = com.mbridge.msdk.thrid.okio.f.c(":authority");

    /* renamed from: a, reason: collision with root package name */
    public final com.mbridge.msdk.thrid.okio.f f4846a;
    public final com.mbridge.msdk.thrid.okio.f b;
    final int c;

    /* compiled from: Header.java */
    interface a {
    }

    public c(String str, String str2) {
        this(com.mbridge.msdk.thrid.okio.f.c(str), com.mbridge.msdk.thrid.okio.f.c(str2));
    }

    public boolean equals(Object obj) {
        if (obj instanceof c) {
            c cVar = (c) obj;
            if (this.f4846a.equals(cVar.f4846a) && this.b.equals(cVar.b)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return ((this.f4846a.hashCode() + IronSourceError.ERROR_NON_EXISTENT_INSTANCE) * 31) + this.b.hashCode();
    }

    public String toString() {
        return com.mbridge.msdk.thrid.okhttp.internal.c.a("%s: %s", this.f4846a.h(), this.b.h());
    }

    public c(com.mbridge.msdk.thrid.okio.f fVar, String str) {
        this(fVar, com.mbridge.msdk.thrid.okio.f.c(str));
    }

    public c(com.mbridge.msdk.thrid.okio.f fVar, com.mbridge.msdk.thrid.okio.f fVar2) {
        this.f4846a = fVar;
        this.b = fVar2;
        this.c = fVar.e() + 32 + fVar2.e();
    }
}
