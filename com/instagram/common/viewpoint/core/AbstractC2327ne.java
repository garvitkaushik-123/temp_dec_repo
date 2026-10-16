package com.instagram.common.viewpoint.core;

import com.google.common.collect.ParametricNullness;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* renamed from: com.facebook.ads.redexgen.X.ne, reason: case insensitive filesystem */
/* loaded from: assets/audience_network/classes2.dex */
public abstract class AbstractC2327ne<T> implements Iterator<T> {
    public int A00;
    public int A01;
    public int A02;
    public final /* synthetic */ C2330nh A03;

    @ParametricNullness
    public abstract T A03(int entry);

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.ne != com.google.common.collect.CompactHashMap<K, V>$Itr<T> */
    public AbstractC2327ne(final C2330nh this$0) {
        int i;
        this.A03 = this$0;
        i = this.A03.A03;
        this.A01 = i;
        this.A00 = this.A03.A0a();
        this.A02 = -1;
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.ne != com.google.common.collect.CompactHashMap<K, V>$Itr<T> */
    public /* synthetic */ AbstractC2327ne(C2330nh c2330nh, C0893Bm c0893Bm) {
        this(c2330nh);
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.ne != com.google.common.collect.CompactHashMap<K, V>$Itr<T> */
    private void A01() {
        int i;
        i = this.A03.A03;
        if (i == this.A01) {
        } else {
            throw new ConcurrentModificationException();
        }
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.ne != com.google.common.collect.CompactHashMap<K, V>$Itr<T> */
    private final void A02() {
        this.A01 += 32;
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.ne != com.google.common.collect.CompactHashMap<K, V>$Itr<T> */
    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.A00 >= 0;
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.ne != com.google.common.collect.CompactHashMap<K, V>$Itr<T> */
    @Override // java.util.Iterator
    @ParametricNullness
    public final T next() {
        A01();
        if (hasNext()) {
            this.A02 = this.A00;
            T A03 = A03(this.A00);
            this.A00 = this.A03.A0b(this.A00);
            return A03;
        }
        throw new NoSuchElementException();
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.ne != com.google.common.collect.CompactHashMap<K, V>$Itr<T> */
    @Override // java.util.Iterator
    public final void remove() {
        Object A0E;
        A01();
        AbstractC2306nJ.A04(this.A02 >= 0);
        A02();
        C2330nh c2330nh = this.A03;
        A0E = this.A03.A0E(this.A02);
        c2330nh.remove(A0E);
        this.A00 = this.A03.A0c(this.A00, this.A02);
        this.A02 = -1;
    }
}
