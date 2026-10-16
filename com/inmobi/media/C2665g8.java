package com.inmobi.media;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMutableIterator;

/* renamed from: com.inmobi.media.g8, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C2665g8 implements Iterator, KMutableIterator {

    /* renamed from: a, reason: collision with root package name */
    public int f2579a;
    public final /* synthetic */ C2681h8 b;

    public C2665g8(C2681h8 c2681h8) {
        this.b = c2681h8;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f2579a < this.b.B;
    }

    @Override // java.util.Iterator
    public final Object next() {
        try {
            ArrayList arrayList = this.b.A;
            int i = this.f2579a;
            this.f2579a = i + 1;
            C2613d8 c2613d8 = (C2613d8) arrayList.get(i);
            Intrinsics.checkNotNull(c2613d8);
            return c2613d8;
        } catch (IndexOutOfBoundsException e) {
            this.f2579a--;
            throw new NoSuchElementException(e.getMessage());
        }
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
