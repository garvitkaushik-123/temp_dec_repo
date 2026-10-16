package com.bykv.vk.openvk.preload.a.b.a;

import com.bykv.vk.openvk.preload.a.r;
import com.bykv.vk.openvk.preload.a.s;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;
import java.util.ArrayList;

/* compiled from: ArrayTypeAdapter.java */
/* loaded from: classes3.dex */
public final class a<E> extends r<Object> {

    /* renamed from: a, reason: collision with root package name */
    public static final s f856a = new s() { // from class: com.bykv.vk.openvk.preload.a.b.a.a.1
        @Override // com.bykv.vk.openvk.preload.a.s
        public final <T> r<T> a(com.bykv.vk.openvk.preload.a.d dVar, com.bykv.vk.openvk.preload.a.c.a<T> aVar) {
            Type b = aVar.b();
            if (!(b instanceof GenericArrayType) && (!(b instanceof Class) || !((Class) b).isArray())) {
                return null;
            }
            Type d = com.bykv.vk.openvk.preload.a.b.a.d(b);
            return new a(dVar, dVar.a((com.bykv.vk.openvk.preload.a.c.a) com.bykv.vk.openvk.preload.a.c.a.a(d)), com.bykv.vk.openvk.preload.a.b.a.b(d));
        }
    };
    private final Class<E> b;
    private final r<E> c;

    public a(com.bykv.vk.openvk.preload.a.d dVar, r<E> rVar, Class<E> cls) {
        this.c = new l(dVar, rVar, cls);
        this.b = cls;
    }

    @Override // com.bykv.vk.openvk.preload.a.r
    public final Object a(com.bykv.vk.openvk.preload.a.d.a aVar) throws IOException {
        if (aVar.f() == com.bykv.vk.openvk.preload.a.d.b.NULL) {
            aVar.j();
            return null;
        }
        ArrayList arrayList = new ArrayList();
        aVar.a();
        while (aVar.e()) {
            arrayList.add(this.c.a(aVar));
        }
        aVar.b();
        int size = arrayList.size();
        Object newInstance = Array.newInstance((Class<?>) this.b, size);
        for (int i = 0; i < size; i++) {
            Array.set(newInstance, i, arrayList.get(i));
        }
        return newInstance;
    }

    @Override // com.bykv.vk.openvk.preload.a.r
    public final void a(com.bykv.vk.openvk.preload.a.d.c cVar, Object obj) throws IOException {
        if (obj == null) {
            cVar.h();
            return;
        }
        cVar.d();
        int length = Array.getLength(obj);
        for (int i = 0; i < length; i++) {
            this.c.a(cVar, Array.get(obj, i));
        }
        cVar.e();
    }
}
