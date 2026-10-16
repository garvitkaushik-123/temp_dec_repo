package com.instagram.common.viewpoint.core;

import java.util.Collection;
import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

/* JADX INFO: Add missing generic type declarations: [K0] */
/* loaded from: assets/audience_network/classes2.dex */
public class BF<K0> extends AbstractC2475q4<K0> {
    public final /* synthetic */ Comparator A00;

    public BF(final Comparator val$comparator) {
        this.A00 = val$comparator;
    }

    @Override // com.instagram.common.viewpoint.core.AbstractC2475q4
    public final <K extends K0, V> Map<K, Collection<V>> A04() {
        return new TreeMap(this.A00);
    }
}
