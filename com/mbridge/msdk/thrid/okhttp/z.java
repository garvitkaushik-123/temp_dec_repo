package com.mbridge.msdk.thrid.okhttp;

import java.io.Closeable;
import java.io.InputStream;
import javax.annotation.Nullable;

/* compiled from: ResponseBody.java */
/* loaded from: classes6.dex */
public abstract class z implements Closeable {

    /* compiled from: ResponseBody.java */
    static class a extends z {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ long f4895a;
        final /* synthetic */ com.mbridge.msdk.thrid.okio.e b;

        a(s sVar, long j, com.mbridge.msdk.thrid.okio.e eVar) {
            this.f4895a = j;
            this.b = eVar;
        }

        @Override // com.mbridge.msdk.thrid.okhttp.z
        public long h() {
            return this.f4895a;
        }

        @Override // com.mbridge.msdk.thrid.okhttp.z
        public com.mbridge.msdk.thrid.okio.e k() {
            return this.b;
        }
    }

    public static z a(@Nullable s sVar, byte[] bArr) {
        return a(sVar, bArr.length, new com.mbridge.msdk.thrid.okio.c().write(bArr));
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        com.mbridge.msdk.thrid.okhttp.internal.c.a(k());
    }

    public final InputStream d() {
        return k().j();
    }

    public abstract long h();

    public abstract com.mbridge.msdk.thrid.okio.e k();

    public static z a(@Nullable s sVar, long j, com.mbridge.msdk.thrid.okio.e eVar) {
        if (eVar != null) {
            return new a(sVar, j, eVar);
        }
        throw new NullPointerException("source == null");
    }
}
