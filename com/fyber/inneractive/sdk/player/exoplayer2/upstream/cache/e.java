package com.fyber.inneractive.sdk.player.exoplayer2.upstream.cache;

import android.net.Uri;
import com.fyber.inneractive.sdk.player.exoplayer2.upstream.e0;
import java.io.IOException;
import java.io.InterruptedIOException;

/* loaded from: classes4.dex */
public final class e implements com.fyber.inneractive.sdk.player.exoplayer2.upstream.h {

    /* renamed from: a, reason: collision with root package name */
    public final l f1556a;
    public final com.fyber.inneractive.sdk.player.exoplayer2.upstream.h b;
    public final e0 c;
    public final com.fyber.inneractive.sdk.player.exoplayer2.upstream.h d;
    public final boolean e = false;
    public final boolean f = true;
    public final boolean g = false;
    public com.fyber.inneractive.sdk.player.exoplayer2.upstream.h h;
    public boolean i;
    public Uri j;
    public int k;
    public String l;
    public long m;
    public long n;
    public m o;
    public boolean p;
    public boolean q;

    public e(l lVar, com.fyber.inneractive.sdk.player.exoplayer2.upstream.h hVar, com.fyber.inneractive.sdk.player.exoplayer2.upstream.h hVar2, c cVar) {
        this.f1556a = lVar;
        this.b = hVar2;
        this.d = hVar;
        if (cVar != null) {
            this.c = new e0(hVar, cVar);
        } else {
            this.c = null;
        }
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.upstream.h
    public final long a(com.fyber.inneractive.sdk.player.exoplayer2.upstream.k kVar) {
        try {
            Uri uri = kVar.f1570a;
            this.j = uri;
            this.k = kVar.f;
            String str = kVar.e;
            if (str == null) {
                str = uri.toString();
            }
            this.l = str;
            this.m = kVar.c;
            boolean z = (this.f && this.p) || (kVar.d == -1 && this.g);
            this.q = z;
            long j = kVar.d;
            if (j == -1 && !z) {
                long a2 = this.f1556a.a(str);
                this.n = a2;
                if (a2 != -1) {
                    long j2 = a2 - kVar.c;
                    this.n = j2;
                    if (j2 <= 0) {
                        throw new com.fyber.inneractive.sdk.player.exoplayer2.upstream.i();
                    }
                }
                a(true);
                return this.n;
            }
            this.n = j;
            a(true);
            return this.n;
        } catch (IOException e) {
            if (this.h == this.b || (e instanceof a)) {
                this.p = true;
            }
            throw e;
        }
    }

    public final void b() {
        com.fyber.inneractive.sdk.player.exoplayer2.upstream.h hVar = this.h;
        if (hVar == null) {
            return;
        }
        try {
            hVar.close();
            this.h = null;
            this.i = false;
            m mVar = this.o;
            if (mVar != null) {
                l lVar = this.f1556a;
                synchronized (lVar) {
                    if (mVar != lVar.c.remove(mVar.f1558a)) {
                        throw new IllegalStateException();
                    }
                    lVar.notifyAll();
                }
                this.o = null;
            }
        } catch (Throwable th) {
            m mVar2 = this.o;
            if (mVar2 != null) {
                this.f1556a.b(mVar2);
                this.o = null;
            }
            throw th;
        }
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.upstream.h
    public final void close() {
        this.j = null;
        try {
            b();
        } catch (IOException e) {
            if (this.h == this.b || (e instanceof a)) {
                this.p = true;
            }
            throw e;
        }
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.upstream.h
    public final int read(byte[] bArr, int i, int i2) {
        if (i2 == 0) {
            return 0;
        }
        if (this.n == 0) {
            return -1;
        }
        try {
            int read = this.h.read(bArr, i, i2);
            if (read >= 0) {
                long j = read;
                this.m += j;
                long j2 = this.n;
                if (j2 != -1) {
                    this.n = j2 - j;
                    return read;
                }
            } else {
                if (this.i) {
                    a(this.m);
                    this.n = 0L;
                }
                b();
                long j3 = this.n;
                if ((j3 > 0 || j3 == -1) && a(false)) {
                    return read(bArr, i, i2);
                }
            }
            return read;
        } catch (IOException e) {
            if (this.h == this.b || (e instanceof a)) {
                this.p = true;
            }
            throw e;
        }
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.upstream.h
    public final Uri a() {
        com.fyber.inneractive.sdk.player.exoplayer2.upstream.h hVar = this.h;
        return hVar == this.d ? hVar.a() : this.j;
    }

    public final boolean a(boolean z) {
        m a2;
        com.fyber.inneractive.sdk.player.exoplayer2.upstream.k kVar;
        long j;
        IOException iOException = null;
        if (this.q) {
            a2 = null;
        } else if (this.e) {
            try {
                l lVar = this.f1556a;
                String str = this.l;
                long j2 = this.m;
                synchronized (lVar) {
                    while (true) {
                        a2 = lVar.a(str, j2);
                        if (a2 != null) {
                            break;
                        }
                        lVar.wait();
                    }
                }
            } catch (InterruptedException unused) {
                throw new InterruptedIOException();
            }
        } else {
            a2 = this.f1556a.a(this.l, this.m);
        }
        if (a2 == null) {
            this.h = this.d;
            Uri uri = this.j;
            long j3 = this.m;
            kVar = new com.fyber.inneractive.sdk.player.exoplayer2.upstream.k(uri, j3, j3, this.n, this.l, this.k);
        } else if (a2.d) {
            Uri fromFile = Uri.fromFile(a2.e);
            long j4 = this.m - a2.b;
            long j5 = a2.c - j4;
            long j6 = this.n;
            if (j6 != -1) {
                j5 = Math.min(j5, j6);
            }
            com.fyber.inneractive.sdk.player.exoplayer2.upstream.k kVar2 = new com.fyber.inneractive.sdk.player.exoplayer2.upstream.k(fromFile, this.m, j4, j5, this.l, this.k);
            this.h = this.b;
            kVar = kVar2;
        } else {
            long j7 = a2.c;
            if (j7 == -1) {
                j7 = this.n;
            } else {
                long j8 = this.n;
                if (j8 != -1) {
                    j7 = Math.min(j7, j8);
                }
            }
            Uri uri2 = this.j;
            long j9 = this.m;
            com.fyber.inneractive.sdk.player.exoplayer2.upstream.k kVar3 = new com.fyber.inneractive.sdk.player.exoplayer2.upstream.k(uri2, j9, j9, j7, this.l, this.k);
            e0 e0Var = this.c;
            if (e0Var != null) {
                this.h = e0Var;
                this.o = a2;
            } else {
                this.h = this.d;
                this.f1556a.b(a2);
            }
            kVar = kVar3;
        }
        boolean z2 = true;
        this.i = kVar.d == -1;
        try {
            j = this.h.a(kVar);
        } catch (IOException e) {
            if (!z && this.i) {
                for (Throwable th = e; th != null; th = th.getCause()) {
                    if ((th instanceof com.fyber.inneractive.sdk.player.exoplayer2.upstream.i) && ((com.fyber.inneractive.sdk.player.exoplayer2.upstream.i) th).f1568a == 0) {
                        break;
                    }
                }
            }
            iOException = e;
            if (iOException != null) {
                throw iOException;
            }
            z2 = false;
            j = 0;
        }
        if (this.i && j != -1) {
            this.n = j;
            a(kVar.c + j);
        }
        return z2;
    }

    public final void a(long j) {
        if (this.h == this.c) {
            l lVar = this.f1556a;
            String str = this.l;
            synchronized (lVar) {
                i iVar = lVar.d;
                h hVar = (h) iVar.f1560a.get(str);
                if (hVar == null) {
                    iVar.a(str, j);
                } else if (hVar.d != j) {
                    hVar.d = j;
                    iVar.f = true;
                }
                lVar.d.b();
            }
        }
    }
}
