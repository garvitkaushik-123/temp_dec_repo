package com.bykv.vk.openvk.preload.a.b.a;

import com.bykv.vk.openvk.preload.a.p;
import com.bykv.vk.openvk.preload.a.r;
import com.bykv.vk.openvk.preload.a.s;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Map;

/* compiled from: MapTypeAdapterFactory.java */
/* loaded from: classes3.dex */
public final class f implements s {

    /* renamed from: a, reason: collision with root package name */
    private final com.bykv.vk.openvk.preload.a.b.b f865a;

    public f(com.bykv.vk.openvk.preload.a.b.b bVar) {
        this.f865a = bVar;
    }

    @Override // com.bykv.vk.openvk.preload.a.s
    public final <T> r<T> a(com.bykv.vk.openvk.preload.a.d dVar, com.bykv.vk.openvk.preload.a.c.a<T> aVar) {
        r<Boolean> rVar;
        Type b = aVar.b();
        if (!Map.class.isAssignableFrom(aVar.a())) {
            return null;
        }
        Type[] b2 = com.bykv.vk.openvk.preload.a.b.a.b(b, com.bykv.vk.openvk.preload.a.b.a.b(b));
        Type type = b2[0];
        if (type == Boolean.TYPE || type == Boolean.class) {
            rVar = m.c;
        } else {
            rVar = dVar.a((com.bykv.vk.openvk.preload.a.c.a) com.bykv.vk.openvk.preload.a.c.a.a(type));
        }
        r<T> a2 = dVar.a((com.bykv.vk.openvk.preload.a.c.a) com.bykv.vk.openvk.preload.a.c.a.a(b2[1]));
        com.bykv.vk.openvk.preload.a.b.h<T> a3 = this.f865a.a(aVar);
        return new a(this, dVar, b2[0], rVar, b2[1], a2, a3);
    }

    /* compiled from: MapTypeAdapterFactory.java */
    final class a<K, V> extends r<Map<K, V>> {

        /* renamed from: a, reason: collision with root package name */
        private final r<K> f866a;
        private final r<V> b;
        private final com.bykv.vk.openvk.preload.a.b.h<? extends Map<K, V>> c;

        @Override // com.bykv.vk.openvk.preload.a.r
        public final /* synthetic */ void a(com.bykv.vk.openvk.preload.a.d.c cVar, Object obj) throws IOException {
            Map map = (Map) obj;
            if (map == null) {
                cVar.h();
                return;
            }
            cVar.f();
            for (Map.Entry<K, V> entry : map.entrySet()) {
                cVar.a(String.valueOf(entry.getKey()));
                this.b.a(cVar, entry.getValue());
            }
            cVar.g();
        }

        public a(f fVar, com.bykv.vk.openvk.preload.a.d dVar, Type type, r<K> rVar, Type type2, r<V> rVar2, com.bykv.vk.openvk.preload.a.b.h<? extends Map<K, V>> hVar) {
            this.f866a = new l(dVar, rVar, type);
            this.b = new l(dVar, rVar2, type2);
            this.c = hVar;
        }

        @Override // com.bykv.vk.openvk.preload.a.r
        public final /* synthetic */ Object a(com.bykv.vk.openvk.preload.a.d.a aVar) throws IOException {
            com.bykv.vk.openvk.preload.a.d.b f = aVar.f();
            if (f == com.bykv.vk.openvk.preload.a.d.b.NULL) {
                aVar.j();
                return null;
            }
            Map<K, V> a2 = this.c.a();
            if (f == com.bykv.vk.openvk.preload.a.d.b.BEGIN_ARRAY) {
                aVar.a();
                while (aVar.e()) {
                    aVar.a();
                    K a3 = this.f866a.a(aVar);
                    if (a2.put(a3, this.b.a(aVar)) != null) {
                        throw new p("duplicate key: ".concat(String.valueOf(a3)));
                    }
                    aVar.b();
                }
                aVar.b();
                return a2;
            }
            aVar.c();
            while (aVar.e()) {
                com.bykv.vk.openvk.preload.a.b.e.f897a.a(aVar);
                K a4 = this.f866a.a(aVar);
                if (a2.put(a4, this.b.a(aVar)) != null) {
                    throw new p("duplicate key: ".concat(String.valueOf(a4)));
                }
            }
            aVar.d();
            return a2;
        }
    }
}
