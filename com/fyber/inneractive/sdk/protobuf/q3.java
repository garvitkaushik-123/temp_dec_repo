package com.fyber.inneractive.sdk.protobuf;

import java.util.Iterator;

/* loaded from: classes4.dex */
public final class q3 implements Iterator {

    /* renamed from: a, reason: collision with root package name */
    public final Iterator f1694a;

    public q3(r3 r3Var) {
        this.f1694a = r3Var.f1697a.iterator();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f1694a.hasNext();
    }

    @Override // java.util.Iterator
    public final Object next() {
        return (String) this.f1694a.next();
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
