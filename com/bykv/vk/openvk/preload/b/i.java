package com.bykv.vk.openvk.preload.b;

import java.util.List;

/* compiled from: RealInterceptorChain.java */
/* loaded from: classes3.dex */
final class i implements b {

    /* renamed from: a, reason: collision with root package name */
    protected e f927a;
    private int b;
    private List<h> c;
    private d d;

    i(List<h> list, int i, e eVar, d dVar) {
        this.c = list;
        this.b = i;
        this.f927a = eVar;
        this.d = dVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bykv.vk.openvk.preload.b.b
    public final Object a(Object obj) throws Exception {
        d dVar = this.d;
        if (dVar != null) {
            dVar.c = obj;
            this.d.e();
        }
        if (this.b >= this.c.size()) {
            return obj;
        }
        h hVar = this.c.get(this.b);
        Class<? extends d> cls = hVar.f925a;
        d dVar2 = (d) this.f927a.a(cls);
        if (dVar2 == null) {
            throw new IllegalArgumentException("interceptor == null , index = " + obj + " , class: " + cls);
        }
        com.bykv.vk.openvk.preload.b.b.a a2 = hVar.a();
        i iVar = new i(this.c, this.b + 1, this.f927a, dVar2);
        dVar2.a(iVar, this.d, obj, a2, hVar.b());
        dVar2.c();
        try {
            Object a3 = dVar2.a(iVar, obj);
            dVar2.d();
            return a3;
        } catch (a e) {
            dVar2.c(e.getCause());
            throw e;
        } catch (Throwable th) {
            dVar2.b(th);
            throw new a(th);
        }
    }

    @Override // com.bykv.vk.openvk.preload.b.b
    public final Object a(Class cls) {
        d c = c(cls);
        if (c == null) {
            throw new IllegalArgumentException("can not find pre Interceptor , class:".concat(String.valueOf(cls)));
        }
        return c.b;
    }

    @Override // com.bykv.vk.openvk.preload.b.b
    public final Object b(Class cls) {
        d c = c(cls);
        if (c == null) {
            throw new IllegalArgumentException("can not find pre Interceptor , class:".concat(String.valueOf(cls)));
        }
        return c.c;
    }

    private d c(Class cls) {
        d dVar = this.d;
        while (dVar != null && dVar.getClass() != cls) {
            dVar = dVar.f923a;
        }
        return dVar;
    }

    /* compiled from: RealInterceptorChain.java */
    static final class a extends Exception {
        a(Throwable th) {
            super(th);
        }
    }
}
