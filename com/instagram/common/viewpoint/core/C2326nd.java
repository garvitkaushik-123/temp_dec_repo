package com.instagram.common.viewpoint.core;

import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map;
import javax.annotation.CheckForNull;

/* JADX INFO: Add missing generic type declarations: [V, K] */
/* renamed from: com.facebook.ads.redexgen.X.nd, reason: case insensitive filesystem */
/* loaded from: assets/audience_network/classes2.dex */
public class C2326nd<K, V> extends AbstractSet<Map.Entry<K, V>> {
    public static String[] A01 = {"ttZbCw840LiCmMMagoH7x1ccnhXQbEM1", "MpxecthRuEJqGUuoNQ5A37YBhHZeOVcm", "F5DHcgT", "zg8RxjbDPuahNU47bDpYXJZcrKLRzeUW", "lK8l2vp", "Hs2vTdzQZwjFS6KGav0LYTLDhx5JGetB", "dmVTdLfQWkJOIA8zEGmBV6szkdy3co89", "IVYzXJf67D23TQo71K1DHnZqVzwcGU9Z"};
    public final /* synthetic */ C2330nh A00;

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.nd != com.google.common.collect.CompactHashMap<K, V>$EntrySetView */
    public C2326nd(final C2330nh this$0) {
        this.A00 = this$0;
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.nd != com.google.common.collect.CompactHashMap<K, V>$EntrySetView */
    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final void clear() {
        this.A00.clear();
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.nd != com.google.common.collect.CompactHashMap<K, V>$EntrySetView */
    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean contains(@CheckForNull Object o) {
        int A07;
        Object A0F;
        Map<K, V> delegate = this.A00.A0h();
        if (delegate != null) {
            return delegate.entrySet().contains(o);
        }
        boolean z = o instanceof Map.Entry;
        if (A01[5].charAt(2) != '2') {
            throw new RuntimeException();
        }
        A01[3] = "ECwcYxYjSLCNiUqu2ExsZmnTntzmdq50";
        if (!z) {
            return false;
        }
        Map.Entry entry = (Map.Entry) o;
        A07 = this.A00.A07(entry.getKey());
        if (A07 == -1) {
            return false;
        }
        A0F = this.A00.A0F(A07);
        return CB.A01(A0F, entry.getValue());
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.nd != com.google.common.collect.CompactHashMap<K, V>$EntrySetView */
    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public final Iterator<Map.Entry<K, V>> iterator() {
        return this.A00.A0d();
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.nd != com.google.common.collect.CompactHashMap<K, V>$EntrySetView */
    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean remove(@CheckForNull Object o) {
        int A00;
        Object A0C;
        int[] A0T;
        Object[] A0V;
        Object[] A0W;
        Map<K, V> delegate = this.A00.A0h();
        if (delegate != null) {
            return delegate.entrySet().remove(o);
        }
        if (!(o instanceof Map.Entry)) {
            return false;
        }
        Map.Entry entry = (Map.Entry) o;
        if (this.A00.A0p()) {
            return false;
        }
        A00 = this.A00.A00();
        Object key = entry.getKey();
        Object value = entry.getValue();
        A0C = this.A00.A0C();
        A0T = this.A00.A0T();
        A0V = this.A00.A0V();
        A0W = this.A00.A0W();
        int A06 = AbstractC2333nk.A06(key, value, A00, A0C, A0T, A0V, A0W);
        if (A06 == -1) {
            return false;
        }
        this.A00.A0n(A06, A00);
        if (A01[7].charAt(30) == 'S') {
            throw new RuntimeException();
        }
        A01[7] = "padFRdr7QgkeMqaUt5IwgmGjkWqeexUC";
        C2330nh.A04(this.A00);
        this.A00.A0j();
        return true;
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.nd != com.google.common.collect.CompactHashMap<K, V>$EntrySetView */
    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return this.A00.size();
    }
}
