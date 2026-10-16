package com.instagram.common.viewpoint.core;

import java.util.AbstractSet;
import java.util.Collection;

/* renamed from: com.facebook.ads.redexgen.X.qf, reason: case insensitive filesystem */
/* loaded from: assets/audience_network/classes2.dex */
public abstract class AbstractC2508qf<E> extends AbstractSet<E> {
    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.qf != com.google.common.collect.Sets$ImprovedAbstractSet<E> */
    @Override // java.util.AbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean removeAll(Collection<?> c) {
        return AbstractC2512qj.A0A(this, c);
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.qf != com.google.common.collect.Sets$ImprovedAbstractSet<E> */
    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean retainAll(Collection<?> c) {
        return super.retainAll((Collection) AbstractC2159ki.A04(c));
    }
}
