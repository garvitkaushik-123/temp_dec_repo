package com.fyber.inneractive.sdk.player.exoplayer2.upstream.cache;

import com.fyber.inneractive.sdk.player.exoplayer2.util.p;
import com.fyber.inneractive.sdk.player.exoplayer2.util.z;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.regex.Pattern;

/* loaded from: classes4.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public final l f1554a;
    public final long b = 10485760;
    public final int c = 20480;
    public com.fyber.inneractive.sdk.player.exoplayer2.upstream.k d;
    public File e;
    public OutputStream f;
    public FileOutputStream g;
    public long h;
    public long i;
    public p j;

    public c(l lVar) {
        this.f1554a = lVar;
    }

    public final void a() {
        OutputStream outputStream = this.f;
        if (outputStream == null) {
            return;
        }
        try {
            outputStream.flush();
            this.g.getFD().sync();
            z.a(this.f);
            this.f = null;
            File file = this.e;
            this.e = null;
            l lVar = this.f1554a;
            synchronized (lVar) {
                m a2 = m.a(file, lVar.d);
                if (a2 == null) {
                    throw new IllegalStateException();
                }
                if (!lVar.c.containsKey(a2.f1558a)) {
                    throw new IllegalStateException();
                }
                if (file.exists()) {
                    if (file.length() == 0) {
                        file.delete();
                        return;
                    }
                    long a3 = lVar.a(a2.f1558a);
                    if (a3 != -1 && a2.b + a2.c > a3) {
                        throw new IllegalStateException();
                    }
                    lVar.a(a2);
                    lVar.d.b();
                    lVar.notifyAll();
                }
            }
        } catch (Throwable th) {
            z.a(this.f);
            this.f = null;
            File file2 = this.e;
            this.e = null;
            file2.delete();
            throw th;
        }
    }

    public final void b() {
        File file;
        long j = this.d.d;
        long min = j == -1 ? this.b : Math.min(j - this.i, this.b);
        l lVar = this.f1554a;
        com.fyber.inneractive.sdk.player.exoplayer2.upstream.k kVar = this.d;
        String str = kVar.e;
        long j2 = kVar.b + this.i;
        synchronized (lVar) {
            if (!lVar.c.containsKey(str)) {
                throw new IllegalStateException();
            }
            if (!lVar.f1563a.exists()) {
                lVar.a();
                lVar.f1563a.mkdirs();
            }
            lVar.b.a(lVar, min);
            File file2 = lVar.f1563a;
            i iVar = lVar.d;
            h hVar = (h) iVar.f1560a.get(str);
            if (hVar == null) {
                hVar = iVar.a(str, -1L);
            }
            int i = hVar.f1559a;
            long currentTimeMillis = System.currentTimeMillis();
            Pattern pattern = m.g;
            file = new File(file2, i + "." + j2 + "." + currentTimeMillis + ".v3.exo");
        }
        this.e = file;
        FileOutputStream fileOutputStream = new FileOutputStream(this.e);
        this.g = fileOutputStream;
        if (this.c > 0) {
            p pVar = this.j;
            if (pVar == null) {
                this.j = new p(this.g, this.c);
            } else {
                pVar.a(fileOutputStream);
            }
            this.f = this.j;
        } else {
            this.f = fileOutputStream;
        }
        this.h = 0L;
    }
}
