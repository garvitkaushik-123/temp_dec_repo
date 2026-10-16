package com.instagram.common.viewpoint.core;

import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map;
import javax.annotation.CheckForNull;

/* JADX INFO: Add missing generic type declarations: [K] */
/* renamed from: com.facebook.ads.redexgen.X.nf, reason: case insensitive filesystem */
/* loaded from: assets/audience_network/classes2.dex */
public class C2328nf<K> extends AbstractSet<K> {
    public final /* synthetic */ C2330nh A00;

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.nf != com.google.common.collect.CompactHashMap<K, V>$KeySetView */
    public C2328nf(final C2330nh this$0) {
        this.A00 = this$0;
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.nf != com.google.common.collect.CompactHashMap<K, V>$KeySetView */
    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final void clear() {
        this.A00.clear();
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.nf != com.google.common.collect.CompactHashMap<K, V>$KeySetView */
    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean contains(@CheckForNull Object o) {
        return this.A00.containsKey(o);
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.nf != com.google.common.collect.CompactHashMap<K, V>$KeySetView */
    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public final Iterator<K> iterator() {
        return this.A00.A0e();
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.nf != com.google.common.collect.CompactHashMap<K, V>$KeySetView */
    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean remove(@CheckForNull Object o) {
        Object A0K;
        Object obj;
        Map A0h = this.A00.A0h();
        if (A0h != null) {
            return A0h.keySet().remove(o);
        }
        A0K = this.A00.A0K(o);
        obj = C2330nh.A0B;
        return A0K != obj;
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.nf != com.google.common.collect.CompactHashMap<K, V>$KeySetView */
    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return this.A00.size();
    }
}
