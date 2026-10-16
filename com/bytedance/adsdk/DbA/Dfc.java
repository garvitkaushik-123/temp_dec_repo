package com.bytedance.adsdk.DbA;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

/* loaded from: classes3.dex */
abstract class Dfc<K, V> {
    Dfc<K, V>.DbA DbA;

    protected abstract Map<K, V> DbA();

    protected abstract void Os();

    protected abstract int eli();

    protected abstract int eli(Object obj);

    protected abstract Object eli(int i, int i2);

    protected abstract void eli(int i);

    Dfc() {
    }

    final class eli<T> implements Iterator<T> {
        int DbA;
        int Os;
        boolean aGH = false;
        final int eli;

        eli(int i) {
            this.eli = i;
            this.DbA = Dfc.this.eli();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.Os < this.DbA;
        }

        @Override // java.util.Iterator
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            T t = (T) Dfc.this.eli(this.Os, this.eli);
            this.Os++;
            this.aGH = true;
            return t;
        }

        @Override // java.util.Iterator
        public void remove() {
            if (!this.aGH) {
                throw new IllegalStateException();
            }
            int i = this.Os - 1;
            this.Os = i;
            this.DbA--;
            this.aGH = false;
            Dfc.this.eli(i);
        }
    }

    final class DbA implements Set<K> {
        DbA() {
        }

        @Override // java.util.Set, java.util.Collection
        public boolean add(K k) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean addAll(Collection<? extends K> collection) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public void clear() {
            Dfc.this.Os();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean contains(Object obj) {
            return Dfc.this.eli(obj) >= 0;
        }

        @Override // java.util.Set, java.util.Collection
        public boolean containsAll(Collection<?> collection) {
            return Dfc.eli(Dfc.this.DbA(), collection);
        }

        @Override // java.util.Set, java.util.Collection
        public boolean isEmpty() {
            return Dfc.this.eli() == 0;
        }

        @Override // java.util.Set, java.util.Collection, java.lang.Iterable
        public Iterator<K> iterator() {
            return new eli(0);
        }

        @Override // java.util.Set, java.util.Collection
        public boolean remove(Object obj) {
            int eli = Dfc.this.eli(obj);
            if (eli < 0) {
                return false;
            }
            Dfc.this.eli(eli);
            return true;
        }

        @Override // java.util.Set, java.util.Collection
        public boolean removeAll(Collection<?> collection) {
            return Dfc.DbA(Dfc.this.DbA(), collection);
        }

        @Override // java.util.Set, java.util.Collection
        public boolean retainAll(Collection<?> collection) {
            return Dfc.Os(Dfc.this.DbA(), collection);
        }

        @Override // java.util.Set, java.util.Collection
        public int size() {
            return Dfc.this.eli();
        }

        @Override // java.util.Set, java.util.Collection
        public Object[] toArray() {
            return Dfc.this.DbA(0);
        }

        @Override // java.util.Set, java.util.Collection
        public <T> T[] toArray(T[] tArr) {
            return (T[]) Dfc.this.eli(tArr, 0);
        }

        @Override // java.util.Set, java.util.Collection
        public boolean equals(Object obj) {
            return Dfc.eli(this, obj);
        }

        @Override // java.util.Set, java.util.Collection
        public int hashCode() {
            int i = 0;
            for (int eli = Dfc.this.eli() - 1; eli >= 0; eli--) {
                Object eli2 = Dfc.this.eli(eli, 0);
                i += eli2 == null ? 0 : eli2.hashCode();
            }
            return i;
        }
    }

    public static <K, V> boolean eli(Map<K, V> map, Collection<?> collection) {
        Iterator<?> it = collection.iterator();
        while (it.hasNext()) {
            if (!map.containsKey(it.next())) {
                return false;
            }
        }
        return true;
    }

    public static <K, V> boolean DbA(Map<K, V> map, Collection<?> collection) {
        int size = map.size();
        Iterator<?> it = collection.iterator();
        while (it.hasNext()) {
            map.remove(it.next());
        }
        return size != map.size();
    }

    public static <K, V> boolean Os(Map<K, V> map, Collection<?> collection) {
        int size = map.size();
        Iterator<K> it = map.keySet().iterator();
        while (it.hasNext()) {
            if (!collection.contains(it.next())) {
                it.remove();
            }
        }
        return size != map.size();
    }

    public Object[] DbA(int i) {
        int eli2 = eli();
        Object[] objArr = new Object[eli2];
        for (int i2 = 0; i2 < eli2; i2++) {
            objArr[i2] = eli(i2, i);
        }
        return objArr;
    }

    public <T> T[] eli(T[] tArr, int i) {
        int eli2 = eli();
        if (tArr.length < eli2) {
            tArr = (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), eli2));
        }
        for (int i2 = 0; i2 < eli2; i2++) {
            tArr[i2] = eli(i2, i);
        }
        if (tArr.length > eli2) {
            tArr[eli2] = null;
        }
        return tArr;
    }

    public static <T> boolean eli(Set<T> set, Object obj) {
        if (set == obj) {
            return true;
        }
        if (obj instanceof Set) {
            Set set2 = (Set) obj;
            try {
                if (set.size() == set2.size()) {
                    if (set.containsAll(set2)) {
                        return true;
                    }
                }
            } catch (ClassCastException | NullPointerException unused) {
            }
        }
        return false;
    }

    public Set<K> aGH() {
        if (this.DbA == null) {
            this.DbA = new DbA();
        }
        return this.DbA;
    }
}
