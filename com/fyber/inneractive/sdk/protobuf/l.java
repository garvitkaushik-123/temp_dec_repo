package com.fyber.inneractive.sdk.protobuf;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* loaded from: classes4.dex */
public final class l implements Iterator {

    /* renamed from: a, reason: collision with root package name */
    public int f1683a = 0;
    public final int b;
    public final /* synthetic */ s c;

    public l(s sVar) {
        this.c = sVar;
        this.b = sVar.size();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f1683a < this.b;
    }

    @Override // java.util.Iterator
    public final Object next() {
        int i = this.f1683a;
        if (i >= this.b) {
            throw new NoSuchElementException();
        }
        this.f1683a = i + 1;
        return Byte.valueOf(this.c.d(i));
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
