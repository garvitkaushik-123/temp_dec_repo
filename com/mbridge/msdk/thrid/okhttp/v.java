package com.mbridge.msdk.thrid.okhttp;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;

/* compiled from: RealCall.java */
/* loaded from: classes6.dex */
final class v implements d {

    /* renamed from: a, reason: collision with root package name */
    final t f4889a;
    final com.mbridge.msdk.thrid.okhttp.internal.http.j b;
    final com.mbridge.msdk.thrid.okio.a c;

    @Nullable
    private n d;
    final w e;
    final boolean f;
    private boolean g;

    /* compiled from: RealCall.java */
    class a extends com.mbridge.msdk.thrid.okio.a {
        a() {
        }

        @Override // com.mbridge.msdk.thrid.okio.a
        protected void j() {
            v.this.cancel();
        }
    }

    /* compiled from: RealCall.java */
    final class b extends com.mbridge.msdk.thrid.okhttp.internal.b {
        static final /* synthetic */ boolean c = true;
        final /* synthetic */ v b;

        void a(ExecutorService executorService) {
            if (!c && Thread.holdsLock(this.b.f4889a.j())) {
                throw new AssertionError();
            }
            try {
                try {
                    executorService.execute(this);
                } catch (RejectedExecutionException e) {
                    InterruptedIOException interruptedIOException = new InterruptedIOException("executor rejected");
                    interruptedIOException.initCause(e);
                    this.b.d.callFailed(this.b, interruptedIOException);
                    throw null;
                }
            } catch (Throwable th) {
                this.b.f4889a.j().a(this);
                throw th;
            }
        }

        @Override // com.mbridge.msdk.thrid.okhttp.internal.b
        protected void b() {
            boolean z;
            Throwable th;
            this.b.c.h();
            try {
                try {
                    this.b.c();
                    try {
                        throw null;
                    } catch (Throwable th2) {
                        th = th2;
                        z = true;
                        this.b.cancel();
                        if (z) {
                            throw th;
                        }
                        new IOException("canceled due to " + th);
                        throw null;
                    }
                } catch (IOException e) {
                    this.b.d.callFailed(this.b, this.b.a(e));
                    throw null;
                } catch (Throwable th3) {
                    z = false;
                    th = th3;
                }
            } catch (Throwable th4) {
                this.b.f4889a.j().a(this);
                throw th4;
            }
        }

        v c() {
            return this.b;
        }

        String d() {
            return this.b.e.g().g();
        }
    }

    private v(t tVar, w wVar, boolean z) {
        this.f4889a = tVar;
        this.e = wVar;
        this.f = z;
        this.b = new com.mbridge.msdk.thrid.okhttp.internal.http.j(tVar, z);
        a aVar = new a();
        this.c = aVar;
        aVar.a(tVar.b(), TimeUnit.MILLISECONDS);
    }

    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public v clone() {
        return a(this.f4889a, this.e, this.f);
    }

    y c() throws IOException {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.f4889a.p());
        arrayList.add(this.b);
        arrayList.add(new com.mbridge.msdk.thrid.okhttp.internal.http.a(this.f4889a.i()));
        this.f4889a.q();
        arrayList.add(new com.mbridge.msdk.thrid.okhttp.internal.cache.a(null));
        arrayList.add(new com.mbridge.msdk.thrid.okhttp.internal.connection.a(this.f4889a));
        if (!this.f) {
            arrayList.addAll(this.f4889a.r());
        }
        arrayList.add(new com.mbridge.msdk.thrid.okhttp.internal.http.b(this.f));
        y a2 = new com.mbridge.msdk.thrid.okhttp.internal.http.g(arrayList, null, null, null, 0, this.e, this, this.d, this.f4889a.e(), this.f4889a.y(), this.f4889a.C()).a(this.e);
        if (!this.b.b()) {
            return a2;
        }
        com.mbridge.msdk.thrid.okhttp.internal.c.a(a2);
        throw new IOException("Canceled");
    }

    @Override // com.mbridge.msdk.thrid.okhttp.d
    public void cancel() {
        this.b.a();
    }

    @Override // com.mbridge.msdk.thrid.okhttp.d
    public y d() throws IOException {
        synchronized (this) {
            if (this.g) {
                throw new IllegalStateException("Already Executed");
            }
            this.g = true;
        }
        a();
        this.c.h();
        this.d.callStart(this);
        try {
            try {
                this.f4889a.j().a(this);
                y c = c();
                if (c != null) {
                    return c;
                }
                throw new IOException("Canceled");
            } catch (IOException e) {
                IOException a2 = a(e);
                this.d.callFailed(this, a2);
                throw a2;
            }
        } finally {
            this.f4889a.j().b(this);
        }
    }

    @Override // com.mbridge.msdk.thrid.okhttp.d
    public boolean h() {
        return this.b.b();
    }

    static v a(t tVar, w wVar, boolean z) {
        v vVar = new v(tVar, wVar, z);
        vVar.d = tVar.l().a(vVar);
        return vVar;
    }

    @Nullable
    IOException a(@Nullable IOException iOException) {
        if (!this.c.i()) {
            return iOException;
        }
        InterruptedIOException interruptedIOException = new InterruptedIOException("timeout");
        if (iOException != null) {
            interruptedIOException.initCause(iOException);
        }
        return interruptedIOException;
    }

    private void a() {
        this.b.a(com.mbridge.msdk.thrid.okhttp.internal.platform.g.d().a("response.body().close()"));
    }
}
