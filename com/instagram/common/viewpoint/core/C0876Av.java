package com.instagram.common.viewpoint.core;

import java.util.Set;
import javax.annotation.CheckForNull;

/* renamed from: com.facebook.ads.redexgen.X.Av, reason: case insensitive filesystem */
/* loaded from: assets/audience_network/classes2.dex */
public class C0876Av<E> extends C2321nY<E> implements Set<E> {
    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.Av != com.google.common.collect.Sets$FilteredSet<E> */
    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.kj != com.google.common.base.Predicate<? super E> */
    public C0876Av(Set<E> unfiltered, InterfaceC2160kj<? super E> predicate) {
        super(unfiltered, predicate);
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.Av != com.google.common.collect.Sets$FilteredSet<E> */
    @Override // java.util.Collection, java.util.Set
    public final boolean equals(@CheckForNull Object object) {
        return AbstractC2512qj.A09(this, object);
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.Av != com.google.common.collect.Sets$FilteredSet<E> */
    @Override // java.util.Collection, java.util.Set
    public final int hashCode() {
        return AbstractC2512qj.A00(this);
    }
}
