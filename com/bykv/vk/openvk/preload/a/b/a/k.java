package com.bykv.vk.openvk.preload.a.b.a;

import com.bykv.vk.openvk.preload.a.o;
import com.bykv.vk.openvk.preload.a.r;
import com.bykv.vk.openvk.preload.a.s;
import java.io.IOException;

/* compiled from: TreeTypeAdapter.java */
/* loaded from: classes3.dex */
public final class k<T> extends r<T> {

    /* renamed from: a, reason: collision with root package name */
    private final o<T> f874a;
    private final com.bykv.vk.openvk.preload.a.h<T> b;
    private com.bykv.vk.openvk.preload.a.d c;
    private final com.bykv.vk.openvk.preload.a.c.a<T> d;
    private final s e;
    private r<T> f;

    public k(o<T> oVar, com.bykv.vk.openvk.preload.a.h<T> hVar, com.bykv.vk.openvk.preload.a.d dVar, com.bykv.vk.openvk.preload.a.c.a<T> aVar, s sVar) {
        new a();
        this.f874a = oVar;
        this.b = hVar;
        this.c = dVar;
        this.d = aVar;
        this.e = sVar;
    }

    @Override // com.bykv.vk.openvk.preload.a.r
    public final T a(com.bykv.vk.openvk.preload.a.d.a aVar) throws IOException {
        if (this.b == null) {
            return b().a(aVar);
        }
        if (com.bykv.vk.openvk.preload.geckox.h.a.a(aVar) instanceof com.bykv.vk.openvk.preload.a.k) {
            return null;
        }
        com.bykv.vk.openvk.preload.a.h<T> hVar = this.b;
        this.d.b();
        return hVar.a();
    }

    @Override // com.bykv.vk.openvk.preload.a.r
    public final void a(com.bykv.vk.openvk.preload.a.d.c cVar, T t) throws IOException {
        o<T> oVar = this.f874a;
        if (oVar == null) {
            b().a(cVar, t);
        } else if (t == null) {
            cVar.h();
        } else {
            this.d.b();
            com.bykv.vk.openvk.preload.geckox.h.a.a(oVar.a(), cVar);
        }
    }

    private r<T> b() {
        r<T> rVar = this.f;
        if (rVar != null) {
            return rVar;
        }
        r<T> a2 = this.c.a(this.e, this.d);
        this.f = a2;
        return a2;
    }

    /* compiled from: TreeTypeAdapter.java */
    final class a {
        /* synthetic */ a() {
            this((byte) 0);
        }

        private a(byte b) {
        }
    }
}
