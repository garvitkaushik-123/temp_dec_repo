package com.bykv.vk.openvk.preload.a;

import java.io.IOException;

/* compiled from: TypeAdapter.java */
/* loaded from: classes3.dex */
public abstract class r<T> {
    public abstract T a(com.bykv.vk.openvk.preload.a.d.a aVar) throws IOException;

    public abstract void a(com.bykv.vk.openvk.preload.a.d.c cVar, T t) throws IOException;

    public final r<T> a() {
        return new r<T>() { // from class: com.bykv.vk.openvk.preload.a.r.1
            @Override // com.bykv.vk.openvk.preload.a.r
            public final void a(com.bykv.vk.openvk.preload.a.d.c cVar, T t) throws IOException {
                if (t == null) {
                    cVar.h();
                } else {
                    r.this.a(cVar, t);
                }
            }

            @Override // com.bykv.vk.openvk.preload.a.r
            public final T a(com.bykv.vk.openvk.preload.a.d.a aVar) throws IOException {
                if (aVar.f() == com.bykv.vk.openvk.preload.a.d.b.NULL) {
                    aVar.j();
                    return null;
                }
                return (T) r.this.a(aVar);
            }
        };
    }
}
