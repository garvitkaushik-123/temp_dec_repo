package com.fyber.inneractive.sdk.protobuf;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

/* loaded from: classes4.dex */
public abstract class e3 extends AbstractMap {
    public static final /* synthetic */ int h = 0;

    /* renamed from: a, reason: collision with root package name */
    public final int f1668a;
    public boolean d;
    public volatile d3 e;
    public volatile x2 g;
    public List b = Collections.emptyList();
    public Map c = Collections.emptyMap();
    public Map f = Collections.emptyMap();

    public e3(int i) {
        this.f1668a = i;
    }

    public final Object a(Comparable comparable, Object obj) {
        a();
        int a2 = a(comparable);
        if (a2 >= 0) {
            return ((b3) this.b.get(a2)).setValue(obj);
        }
        a();
        if (this.b.isEmpty() && !(this.b instanceof ArrayList)) {
            this.b = new ArrayList(this.f1668a);
        }
        int i = -(a2 + 1);
        if (i >= this.f1668a) {
            return c().put(comparable, obj);
        }
        int size = this.b.size();
        int i2 = this.f1668a;
        if (size == i2) {
            b3 b3Var = (b3) this.b.remove(i2 - 1);
            c().put(b3Var.f1660a, b3Var.b);
        }
        this.b.add(i, new b3(this, comparable, obj));
        return null;
    }

    public final Iterable b() {
        return this.c.isEmpty() ? a3.b : this.c.entrySet();
    }

    public final SortedMap c() {
        a();
        if (this.c.isEmpty() && !(this.c instanceof TreeMap)) {
            TreeMap treeMap = new TreeMap();
            this.c = treeMap;
            this.f = treeMap.descendingMap();
        }
        return (SortedMap) this.c;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final void clear() {
        a();
        if (!this.b.isEmpty()) {
            this.b.clear();
        }
        if (this.c.isEmpty()) {
            return;
        }
        this.c.clear();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean containsKey(Object obj) {
        Comparable comparable = (Comparable) obj;
        return a(comparable) >= 0 || this.c.containsKey(comparable);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Set entrySet() {
        if (this.e == null) {
            this.e = new d3(this);
        }
        return this.e;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof e3)) {
            return super.equals(obj);
        }
        e3 e3Var = (e3) obj;
        int size = size();
        if (size != e3Var.size()) {
            return false;
        }
        int size2 = this.b.size();
        if (size2 != e3Var.b.size()) {
            return entrySet().equals(e3Var.entrySet());
        }
        for (int i = 0; i < size2; i++) {
            if (!((Map.Entry) this.b.get(i)).equals((Map.Entry) e3Var.b.get(i))) {
                return false;
            }
        }
        if (size2 != size) {
            return this.c.equals(e3Var.c);
        }
        return true;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Object get(Object obj) {
        Comparable comparable = (Comparable) obj;
        int a2 = a(comparable);
        return a2 >= 0 ? ((b3) this.b.get(a2)).b : this.c.get(comparable);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final int hashCode() {
        int size = this.b.size();
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            i += ((b3) this.b.get(i2)).hashCode();
        }
        return this.c.size() > 0 ? this.c.hashCode() + i : i;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Object remove(Object obj) {
        a();
        Comparable comparable = (Comparable) obj;
        int a2 = a(comparable);
        if (a2 < 0) {
            if (this.c.isEmpty()) {
                return null;
            }
            return this.c.remove(comparable);
        }
        a();
        Object obj2 = ((b3) this.b.remove(a2)).b;
        if (!this.c.isEmpty()) {
            Iterator it = c().entrySet().iterator();
            this.b.add(new b3(this, (Map.Entry) it.next()));
            it.remove();
        }
        return obj2;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final int size() {
        return this.c.size() + this.b.size();
    }

    public final int a(Comparable comparable) {
        int i;
        int size = this.b.size();
        int i2 = size - 1;
        if (i2 >= 0) {
            int compareTo = comparable.compareTo(((b3) this.b.get(i2)).f1660a);
            if (compareTo > 0) {
                i = size + 1;
                return -i;
            }
            if (compareTo == 0) {
                return i2;
            }
        }
        int i3 = 0;
        while (i3 <= i2) {
            int i4 = (i3 + i2) / 2;
            int compareTo2 = comparable.compareTo(((b3) this.b.get(i4)).f1660a);
            if (compareTo2 < 0) {
                i2 = i4 - 1;
            } else {
                if (compareTo2 <= 0) {
                    return i4;
                }
                i3 = i4 + 1;
            }
        }
        i = i3 + 1;
        return -i;
    }

    public final void a() {
        if (this.d) {
            throw new UnsupportedOperationException();
        }
    }
}
