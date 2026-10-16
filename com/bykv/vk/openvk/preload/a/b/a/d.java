package com.bykv.vk.openvk.preload.a.b.a;

import com.bykv.vk.openvk.preload.a.o;
import com.bykv.vk.openvk.preload.a.r;
import com.bykv.vk.openvk.preload.a.s;

/* compiled from: JsonAdapterAnnotationTypeAdapterFactory.java */
/* loaded from: classes3.dex */
public final class d implements s {

    /* renamed from: a, reason: collision with root package name */
    private final com.bykv.vk.openvk.preload.a.b.b f864a;

    public d(com.bykv.vk.openvk.preload.a.b.b bVar) {
        this.f864a = bVar;
    }

    @Override // com.bykv.vk.openvk.preload.a.s
    public final <T> r<T> a(com.bykv.vk.openvk.preload.a.d dVar, com.bykv.vk.openvk.preload.a.c.a<T> aVar) {
        com.bykv.vk.openvk.preload.a.a.a aVar2 = (com.bykv.vk.openvk.preload.a.a.a) aVar.a().getAnnotation(com.bykv.vk.openvk.preload.a.a.a.class);
        if (aVar2 == null) {
            return null;
        }
        return (r<T>) a(this.f864a, dVar, aVar, aVar2);
    }

    static r<?> a(com.bykv.vk.openvk.preload.a.b.b bVar, com.bykv.vk.openvk.preload.a.d dVar, com.bykv.vk.openvk.preload.a.c.a<?> aVar, com.bykv.vk.openvk.preload.a.a.a aVar2) {
        r<?> kVar;
        Object a2 = bVar.a(com.bykv.vk.openvk.preload.a.c.a.a((Class) aVar2.a())).a();
        if (a2 instanceof r) {
            kVar = (r) a2;
        } else if (a2 instanceof s) {
            kVar = ((s) a2).a(dVar, aVar);
        } else {
            boolean z = a2 instanceof o;
            if (z || (a2 instanceof com.bykv.vk.openvk.preload.a.h)) {
                kVar = new k(z ? (o) a2 : null, a2 instanceof com.bykv.vk.openvk.preload.a.h ? (com.bykv.vk.openvk.preload.a.h) a2 : null, dVar, aVar, null);
            } else {
                throw new IllegalArgumentException("Invalid attempt to bind an instance of " + a2.getClass().getName() + " as a @JsonAdapter for " + aVar.toString() + ". @JsonAdapter value must be a TypeAdapter, TypeAdapterFactory, JsonSerializer or JsonDeserializer.");
            }
        }
        return (kVar == null || !aVar2.b()) ? kVar : kVar.a();
    }
}
