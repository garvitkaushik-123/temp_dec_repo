package com.bykv.vk.openvk.preload.a.b.a;

import com.bykv.vk.openvk.preload.a.r;
import com.bykv.vk.openvk.preload.a.s;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.Iterator;

/* compiled from: CollectionTypeAdapterFactory.java */
/* loaded from: classes3.dex */
public final class b implements s {

    /* renamed from: a, reason: collision with root package name */
    private final com.bykv.vk.openvk.preload.a.b.b f859a;

    public b(com.bykv.vk.openvk.preload.a.b.b bVar) {
        this.f859a = bVar;
    }

    @Override // com.bykv.vk.openvk.preload.a.s
    public final <T> r<T> a(com.bykv.vk.openvk.preload.a.d dVar, com.bykv.vk.openvk.preload.a.c.a<T> aVar) {
        Type b = aVar.b();
        Class<? super T> a2 = aVar.a();
        if (!Collection.class.isAssignableFrom(a2)) {
            return null;
        }
        Type a3 = com.bykv.vk.openvk.preload.a.b.a.a(b, (Class<?>) a2);
        return new a(dVar, a3, dVar.a((com.bykv.vk.openvk.preload.a.c.a) com.bykv.vk.openvk.preload.a.c.a.a(a3)), this.f859a.a(aVar));
    }

    /* compiled from: CollectionTypeAdapterFactory.java */
    static final class a<E> extends r<Collection<E>> {

        /* renamed from: a, reason: collision with root package name */
        private final r<E> f861a;
        private final com.bykv.vk.openvk.preload.a.b.h<? extends Collection<E>> b;

        @Override // com.bykv.vk.openvk.preload.a.r
        public final /* synthetic */ void a(com.bykv.vk.openvk.preload.a.d.c cVar, Object obj) throws IOException {
            Collection collection = (Collection) obj;
            if (collection == null) {
                cVar.h();
                return;
            }
            cVar.d();
            Iterator<E> it = collection.iterator();
            while (it.hasNext()) {
                this.f861a.a(cVar, it.next());
            }
            cVar.e();
        }

        public a(com.bykv.vk.openvk.preload.a.d dVar, Type type, r<E> rVar, com.bykv.vk.openvk.preload.a.b.h<? extends Collection<E>> hVar) {
            this.f861a = new l(dVar, rVar, type);
            this.b = hVar;
        }

        @Override // com.bykv.vk.openvk.preload.a.r
        public final /* synthetic */ Object a(com.bykv.vk.openvk.preload.a.d.a aVar) throws IOException {
            if (aVar.f() == com.bykv.vk.openvk.preload.a.d.b.NULL) {
                aVar.j();
                return null;
            }
            Collection<E> a2 = this.b.a();
            aVar.a();
            while (aVar.e()) {
                a2.add(this.f861a.a(aVar));
            }
            aVar.b();
            return a2;
        }
    }
}
