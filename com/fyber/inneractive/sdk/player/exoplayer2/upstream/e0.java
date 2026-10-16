package com.fyber.inneractive.sdk.player.exoplayer2.upstream;

import android.net.Uri;
import java.io.IOException;

/* loaded from: classes4.dex */
public final class e0 implements h {

    /* renamed from: a, reason: collision with root package name */
    public final h f1566a;
    public final com.fyber.inneractive.sdk.player.exoplayer2.upstream.cache.c b;

    public e0(h hVar, com.fyber.inneractive.sdk.player.exoplayer2.upstream.cache.c cVar) {
        hVar.getClass();
        this.f1566a = hVar;
        cVar.getClass();
        this.b = cVar;
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.upstream.h
    public final long a(k kVar) {
        long a2 = this.f1566a.a(kVar);
        if (kVar.d == -1 && a2 != -1) {
            kVar = new k(kVar.f1570a, kVar.b, kVar.c, a2, kVar.e, kVar.f);
        }
        com.fyber.inneractive.sdk.player.exoplayer2.upstream.cache.c cVar = this.b;
        cVar.getClass();
        if (kVar.d == -1 && (kVar.f & 2) != 2) {
            cVar.d = null;
            return a2;
        }
        cVar.d = kVar;
        cVar.i = 0L;
        try {
            cVar.b();
            return a2;
        } catch (IOException e) {
            throw new com.fyber.inneractive.sdk.player.exoplayer2.upstream.cache.b(e);
        }
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.upstream.h
    public final void close() {
        try {
            this.f1566a.close();
            com.fyber.inneractive.sdk.player.exoplayer2.upstream.cache.c cVar = this.b;
            if (cVar.d == null) {
                return;
            }
            try {
                cVar.a();
            } catch (IOException e) {
                throw new com.fyber.inneractive.sdk.player.exoplayer2.upstream.cache.b(e);
            }
        } catch (Throwable th) {
            com.fyber.inneractive.sdk.player.exoplayer2.upstream.cache.c cVar2 = this.b;
            if (cVar2.d != null) {
                try {
                    cVar2.a();
                } catch (IOException e2) {
                    throw new com.fyber.inneractive.sdk.player.exoplayer2.upstream.cache.b(e2);
                }
            }
            throw th;
        }
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.upstream.h
    public final int read(byte[] bArr, int i, int i2) {
        int read = this.f1566a.read(bArr, i, i2);
        if (read > 0) {
            com.fyber.inneractive.sdk.player.exoplayer2.upstream.cache.c cVar = this.b;
            if (cVar.d != null) {
                int i3 = 0;
                while (i3 < read) {
                    try {
                        if (cVar.h == cVar.b) {
                            cVar.a();
                            cVar.b();
                        }
                        int min = (int) Math.min(read - i3, cVar.b - cVar.h);
                        cVar.f.write(bArr, i + i3, min);
                        i3 += min;
                        long j = min;
                        cVar.h += j;
                        cVar.i += j;
                    } catch (IOException e) {
                        throw new com.fyber.inneractive.sdk.player.exoplayer2.upstream.cache.b(e);
                    }
                }
            }
        }
        return read;
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.upstream.h
    public final Uri a() {
        return this.f1566a.a();
    }
}
