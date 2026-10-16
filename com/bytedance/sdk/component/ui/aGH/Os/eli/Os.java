package com.bytedance.sdk.component.ui.aGH.Os.eli;

import java.lang.ref.SoftReference;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/* loaded from: classes3.dex */
public class Os<K, V> {
    private int DbA;
    private final LinkedHashMap<K, SoftReference<V>> eli = new LinkedHashMap<>(0, 0.75f, true);

    public Os(int i) {
        this.DbA = i;
    }

    public synchronized V eli(K k) {
        V v = null;
        if (k == null) {
            return null;
        }
        if (this.DbA <= 0) {
            return null;
        }
        SoftReference<V> softReference = this.eli.get(k);
        if (softReference != null) {
            v = softReference.get();
            if (v != null) {
                return v;
            }
            this.eli.remove(k);
        }
        return v;
    }

    public synchronized void eli(K k, V v) {
        if (this.DbA <= 0) {
            return;
        }
        if (k == null || v == null) {
            return;
        }
        this.eli.put(k, new SoftReference<>(v));
        int size = this.eli.size();
        int i = this.DbA;
        if (size > i) {
            eli((int) (i * 0.7d));
        }
    }

    public synchronized void eli(int i) {
        int size = this.eli.size() - i;
        if (size > 0) {
            Iterator<Map.Entry<K, SoftReference<V>>> it = this.eli.entrySet().iterator();
            for (int i2 = 0; i2 < size; i2++) {
                it.next();
                it.remove();
            }
        }
        if (i == 0) {
            return;
        }
        Iterator<Map.Entry<K, SoftReference<V>>> it2 = this.eli.entrySet().iterator();
        while (it2.hasNext()) {
            if (it2.next().getValue().get() == null) {
                it2.remove();
            }
        }
    }

    public final synchronized String toString() {
        return String.format("LruCache[maxCount=%d,size=%d]", Integer.valueOf(this.DbA), Integer.valueOf(this.eli.size()));
    }
}
