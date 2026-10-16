package com.fyber.inneractive.sdk.protobuf;

import java.util.Iterator;

/* loaded from: classes4.dex */
public final class x2 extends d3 {
    public final /* synthetic */ e3 b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public x2(e3 e3Var) {
        super(e3Var);
        this.b = e3Var;
    }

    @Override // com.fyber.inneractive.sdk.protobuf.d3, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public final Iterator iterator() {
        return new w2(this.b);
    }
}
