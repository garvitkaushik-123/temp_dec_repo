package com.fyber.inneractive.sdk.protobuf;

import java.util.AbstractList;
import java.util.List;

/* loaded from: classes4.dex */
public final class i1 extends AbstractList {

    /* renamed from: a, reason: collision with root package name */
    public final List f1677a;
    public final h1 b;

    public i1(List list, h1 h1Var) {
        this.f1677a = list;
        this.b = h1Var;
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object get(int i) {
        h1 h1Var = this.b;
        Object obj = this.f1677a.get(i);
        ((com.fyber.inneractive.sdk.bidder.j) h1Var).getClass();
        com.fyber.inneractive.sdk.bidder.l0 a2 = com.fyber.inneractive.sdk.bidder.l0.a(((Integer) obj).intValue());
        return a2 == null ? com.fyber.inneractive.sdk.bidder.l0.UNRECOGNIZED : a2;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f1677a.size();
    }
}
