package com.bykv.vk.openvk.preload.a.b.a;

import com.bykv.vk.openvk.preload.a.b.a.h;
import com.bykv.vk.openvk.preload.a.r;
import java.io.IOException;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;

/* compiled from: TypeAdapterRuntimeTypeWrapper.java */
/* loaded from: classes3.dex */
final class l<T> extends r<T> {

    /* renamed from: a, reason: collision with root package name */
    private final com.bykv.vk.openvk.preload.a.d f875a;
    private final r<T> b;
    private final Type c;

    l(com.bykv.vk.openvk.preload.a.d dVar, r<T> rVar, Type type) {
        this.f875a = dVar;
        this.b = rVar;
        this.c = type;
    }

    @Override // com.bykv.vk.openvk.preload.a.r
    public final T a(com.bykv.vk.openvk.preload.a.d.a aVar) throws IOException {
        return this.b.a(aVar);
    }

    @Override // com.bykv.vk.openvk.preload.a.r
    public final void a(com.bykv.vk.openvk.preload.a.d.c cVar, T t) throws IOException {
        r<T> rVar = this.b;
        Type type = this.c;
        if (t != null && (type == Object.class || (type instanceof TypeVariable) || (type instanceof Class))) {
            type = t.getClass();
        }
        if (type != this.c) {
            rVar = this.f875a.a((com.bykv.vk.openvk.preload.a.c.a) com.bykv.vk.openvk.preload.a.c.a.a(type));
            if (rVar instanceof h.a) {
                r<T> rVar2 = this.b;
                if (!(rVar2 instanceof h.a)) {
                    rVar = rVar2;
                }
            }
        }
        rVar.a(cVar, t);
    }
}
