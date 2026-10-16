package com.fyber.inneractive.sdk.protobuf;

import java.util.Iterator;
import java.util.Map;

/* loaded from: classes4.dex */
public final class o1 implements Iterator {

    /* renamed from: a, reason: collision with root package name */
    public final Iterator f1691a;

    public o1(Iterator it) {
        this.f1691a = it;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f1691a.hasNext();
    }

    @Override // java.util.Iterator
    public final Object next() {
        Map.Entry entry = (Map.Entry) this.f1691a.next();
        entry.getValue();
        return entry;
    }

    @Override // java.util.Iterator
    public final void remove() {
        this.f1691a.remove();
    }
}
