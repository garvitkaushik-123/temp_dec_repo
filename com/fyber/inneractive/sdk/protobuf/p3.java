package com.fyber.inneractive.sdk.protobuf;

import java.util.ListIterator;

/* loaded from: classes4.dex */
public final class p3 implements ListIterator {

    /* renamed from: a, reason: collision with root package name */
    public final ListIterator f1693a;

    public p3(r3 r3Var, int i) {
        this.f1693a = r3Var.f1697a.listIterator(i);
    }

    @Override // java.util.ListIterator
    public final void add(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public final boolean hasNext() {
        return this.f1693a.hasNext();
    }

    @Override // java.util.ListIterator
    public final boolean hasPrevious() {
        return this.f1693a.hasPrevious();
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public final Object next() {
        return (String) this.f1693a.next();
    }

    @Override // java.util.ListIterator
    public final int nextIndex() {
        return this.f1693a.nextIndex();
    }

    @Override // java.util.ListIterator
    public final Object previous() {
        return (String) this.f1693a.previous();
    }

    @Override // java.util.ListIterator
    public final int previousIndex() {
        return this.f1693a.previousIndex();
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.ListIterator
    public final void set(Object obj) {
        throw new UnsupportedOperationException();
    }
}
