package com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls;

import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import com.fyber.inneractive.sdk.player.controller.b0;
import com.fyber.inneractive.sdk.player.exoplayer2.source.s;
import com.fyber.inneractive.sdk.player.exoplayer2.source.t;
import com.fyber.inneractive.sdk.player.exoplayer2.source.u;
import com.fyber.inneractive.sdk.player.exoplayer2.upstream.d0;
import com.fyber.inneractive.sdk.player.exoplayer2.upstream.y;
import java.io.IOException;
import java.util.Iterator;

/* loaded from: classes4.dex */
public final class j implements u {

    /* renamed from: a, reason: collision with root package name */
    public final Uri f1417a;
    public final b b;
    public final com.fyber.inneractive.sdk.player.exoplayer2.source.f c;
    public com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.playlist.k d;
    public t e;

    public j(Uri uri, com.fyber.inneractive.sdk.player.exoplayer2.upstream.g gVar, Handler handler, b0 b0Var) {
        b bVar = new b(gVar);
        this.f1417a = uri;
        this.b = bVar;
        this.c = new com.fyber.inneractive.sdk.player.exoplayer2.source.f(handler, b0Var);
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.source.u
    public final void a(t tVar) {
        if (this.d != null) {
            throw new IllegalStateException();
        }
        Uri uri = this.f1417a;
        b bVar = this.b;
        com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.playlist.k kVar = new com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.playlist.k(uri, bVar, this.c, this);
        this.d = kVar;
        this.e = tVar;
        d0 d0Var = new d0(bVar.f1413a.a(), uri, kVar.b);
        com.fyber.inneractive.sdk.player.exoplayer2.upstream.b0 b0Var = kVar.h;
        b0Var.getClass();
        Looper myLooper = Looper.myLooper();
        if (myLooper == null) {
            throw new IllegalStateException();
        }
        y yVar = new y(b0Var, myLooper, d0Var, kVar, 3, SystemClock.elapsedRealtime());
        if (b0Var.b != null) {
            throw new IllegalStateException();
        }
        b0Var.b = yVar;
        yVar.e = null;
        b0Var.f1553a.execute(yVar);
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.source.u
    public final void b() {
        com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.playlist.k kVar = this.d;
        if (kVar != null) {
            kVar.h.a(null);
            Iterator it = kVar.d.values().iterator();
            while (it.hasNext()) {
                ((com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.playlist.h) it.next()).b.a(null);
            }
            kVar.e.removeCallbacksAndMessages(null);
            kVar.d.clear();
            this.d = null;
        }
        this.e = null;
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.source.u
    public final void a() {
        com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.playlist.k kVar = this.d;
        kVar.h.b();
        com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.playlist.a aVar = kVar.k;
        if (aVar != null) {
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.playlist.h hVar = (com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.playlist.h) kVar.d.get(aVar);
            hVar.b.b();
            IOException iOException = hVar.j;
            if (iOException != null) {
                throw iOException;
            }
        }
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.source.u
    public final s a(int i, com.fyber.inneractive.sdk.player.exoplayer2.upstream.b bVar, long j) {
        if (i == 0) {
            return new i(this.d, this.b, this.c, bVar, j);
        }
        throw new IllegalArgumentException();
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.source.u
    public final void a(s sVar) {
        i iVar = (i) sVar;
        iVar.f1416a.g.remove(iVar);
        iVar.h.removeCallbacksAndMessages(null);
        n[] nVarArr = iVar.n;
        if (nVarArr != null) {
            for (n nVar : nVarArr) {
                int size = nVar.j.size();
                for (int i = 0; i < size; i++) {
                    ((com.fyber.inneractive.sdk.player.exoplayer2.extractor.g) nVar.j.valueAt(i)).b();
                }
                nVar.g.a(null);
                nVar.m.removeCallbacksAndMessages(null);
                nVar.s = true;
            }
        }
    }
}
