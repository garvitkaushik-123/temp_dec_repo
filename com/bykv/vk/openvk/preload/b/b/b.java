package com.bykv.vk.openvk.preload.b.b;

import com.bykv.vk.openvk.preload.b.d;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: EventListenerWrapper.java */
/* loaded from: classes3.dex */
public final class b extends a {

    /* renamed from: a, reason: collision with root package name */
    private List<a> f922a;

    public b(a... aVarArr) {
        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
        this.f922a = copyOnWriteArrayList;
        copyOnWriteArrayList.addAll(Arrays.asList(aVarArr));
    }

    public final void a(a aVar) {
        if (aVar == null) {
            return;
        }
        this.f922a.add(aVar);
    }

    @Override // com.bykv.vk.openvk.preload.b.b.a
    public final <T> void a(com.bykv.vk.openvk.preload.b.b<T> bVar, d dVar) {
        for (a aVar : this.f922a) {
            if (aVar != null) {
                aVar.a(bVar, dVar);
            }
        }
    }

    @Override // com.bykv.vk.openvk.preload.b.b.a
    public final <T> void b(com.bykv.vk.openvk.preload.b.b<T> bVar, d dVar) {
        for (a aVar : this.f922a) {
            if (aVar != null) {
                aVar.b(bVar, dVar);
            }
        }
    }

    @Override // com.bykv.vk.openvk.preload.b.b.a
    public final <T> void c(com.bykv.vk.openvk.preload.b.b<T> bVar, d dVar) {
        for (a aVar : this.f922a) {
            if (aVar != null) {
                aVar.c(bVar, dVar);
            }
        }
    }

    @Override // com.bykv.vk.openvk.preload.b.b.a
    public final <T> void a(com.bykv.vk.openvk.preload.b.b<T> bVar, d dVar, Throwable th) {
        for (a aVar : this.f922a) {
            if (aVar != null) {
                aVar.a(bVar, dVar, th);
            }
        }
    }

    @Override // com.bykv.vk.openvk.preload.b.b.a
    public final <T> void c(com.bykv.vk.openvk.preload.b.b<T> bVar, d dVar, Throwable th) {
        for (a aVar : this.f922a) {
            if (aVar != null) {
                aVar.c(bVar, dVar, th);
            }
        }
    }

    @Override // com.bykv.vk.openvk.preload.b.b.a
    public final <T> void b(com.bykv.vk.openvk.preload.b.b<T> bVar, d dVar, Throwable th) {
        for (a aVar : this.f922a) {
            if (aVar != null) {
                aVar.b(bVar, dVar, th);
            }
        }
    }
}
