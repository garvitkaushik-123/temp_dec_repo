package com.applovin.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.RandomAccess;
import java.util.Set;

/* loaded from: classes2.dex */
public class j4 implements Set, RandomAccess {

    /* renamed from: a, reason: collision with root package name */
    private final ArrayList f502a = new ArrayList();
    private final HashSet b = new HashSet();

    @Override // java.util.Set, java.util.Collection
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public boolean add(Comparable comparable) {
        if (contains(comparable)) {
            return false;
        }
        if (isEmpty() || comparable.compareTo(a()) > 0) {
            this.f502a.add(comparable);
        } else {
            this.f502a.add(b(comparable), comparable);
        }
        return this.b.add(comparable);
    }

    @Override // java.util.Set, java.util.Collection
    public boolean addAll(Collection collection) {
        Iterator it = collection.iterator();
        while (true) {
            boolean z = false;
            while (it.hasNext()) {
                if (add((Comparable) it.next()) || z) {
                    z = true;
                }
            }
            return z;
        }
    }

    public Comparable b(int i) {
        Comparable comparable = (Comparable) this.f502a.remove(i);
        this.b.remove(comparable);
        return comparable;
    }

    public int c(Comparable comparable) {
        int binarySearch = Collections.binarySearch(this.f502a, comparable);
        if (binarySearch < 0) {
            return ~binarySearch;
        }
        Comparable a2 = a(binarySearch);
        while (binarySearch < size() && a2 == a(binarySearch)) {
            binarySearch++;
        }
        return binarySearch;
    }

    @Override // java.util.Set, java.util.Collection
    public void clear() {
        this.f502a.clear();
        this.b.clear();
    }

    @Override // java.util.Set, java.util.Collection
    public boolean contains(Object obj) {
        return this.b.contains(obj);
    }

    @Override // java.util.Set, java.util.Collection
    public boolean containsAll(Collection collection) {
        return this.b.containsAll(collection);
    }

    public int d(Comparable comparable) {
        if (comparable == null || !contains(comparable)) {
            return -1;
        }
        return b(comparable);
    }

    @Override // java.util.Set, java.util.Collection
    public boolean isEmpty() {
        return this.f502a.isEmpty();
    }

    @Override // java.util.Set, java.util.Collection, java.lang.Iterable
    public Iterator iterator() {
        return this.f502a.iterator();
    }

    @Override // java.util.Set, java.util.Collection
    public boolean remove(Object obj) {
        int d = d((Comparable) obj);
        if (d == -1) {
            return false;
        }
        this.f502a.remove(d);
        return this.b.remove(obj);
    }

    @Override // java.util.Set, java.util.Collection
    public boolean removeAll(Collection collection) {
        Iterator it = collection.iterator();
        while (true) {
            boolean z = false;
            while (it.hasNext()) {
                if (remove(it.next()) || z) {
                    z = true;
                }
            }
            return z;
        }
    }

    @Override // java.util.Set, java.util.Collection
    public boolean retainAll(Collection collection) {
        boolean z = false;
        for (int size = size() - 1; size >= 0; size--) {
            Comparable comparable = (Comparable) this.f502a.get(size);
            if (!collection.contains(comparable)) {
                this.f502a.remove(size);
                this.b.remove(comparable);
                z = true;
            }
        }
        return z;
    }

    @Override // java.util.Set, java.util.Collection
    public int size() {
        return this.f502a.size();
    }

    @Override // java.util.Set, java.util.Collection
    public Object[] toArray() {
        return this.f502a.toArray();
    }

    @Override // java.util.Set, java.util.Collection
    public Object[] toArray(Object[] objArr) {
        return this.f502a.toArray(objArr);
    }

    public int b(Comparable comparable) {
        int binarySearch = Collections.binarySearch(this.f502a, comparable);
        if (binarySearch < 0) {
            return ~binarySearch;
        }
        Comparable a2 = a(binarySearch);
        while (binarySearch >= 0 && a2 == a(binarySearch)) {
            binarySearch--;
        }
        return binarySearch + 1;
    }

    public Comparable a(int i) {
        return (Comparable) this.f502a.get(i);
    }

    public void a(int i, Comparable comparable) {
        this.b.remove((Comparable) this.f502a.get(i));
        this.f502a.set(i, comparable);
        this.b.add(comparable);
    }

    public Comparable a() {
        return (Comparable) this.f502a.get(size() - 1);
    }
}
