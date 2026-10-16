package com.bykv.vk.openvk.preload.a;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: JsonArray.java */
/* loaded from: classes3.dex */
public final class g extends i implements Iterable<i> {

    /* renamed from: a, reason: collision with root package name */
    private final List<i> f916a = new ArrayList();

    public final void a(i iVar) {
        if (iVar == null) {
            iVar = k.f917a;
        }
        this.f916a.add(iVar);
    }

    @Override // java.lang.Iterable
    public final Iterator<i> iterator() {
        return this.f916a.iterator();
    }

    @Override // com.bykv.vk.openvk.preload.a.i
    public final Number a() {
        if (this.f916a.size() == 1) {
            return this.f916a.get(0).a();
        }
        throw new IllegalStateException();
    }

    @Override // com.bykv.vk.openvk.preload.a.i
    public final String b() {
        if (this.f916a.size() == 1) {
            return this.f916a.get(0).b();
        }
        throw new IllegalStateException();
    }

    @Override // com.bykv.vk.openvk.preload.a.i
    public final boolean c() {
        if (this.f916a.size() == 1) {
            return this.f916a.get(0).c();
        }
        throw new IllegalStateException();
    }

    public final boolean equals(Object obj) {
        if (obj != this) {
            return (obj instanceof g) && ((g) obj).f916a.equals(this.f916a);
        }
        return true;
    }

    public final int hashCode() {
        return this.f916a.hashCode();
    }
}
