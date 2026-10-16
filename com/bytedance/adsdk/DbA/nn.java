package com.bytedance.adsdk.DbA;

import com.ironsource.C3040d4;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;

/* loaded from: classes3.dex */
public class nn<K, V> {
    private int DbA;
    private int MGA;
    private int Os;
    private int aGH;
    private final LinkedHashMap<K, V> eli;
    private int kb;
    private int ui;
    private int wC;

    protected int DbA(K k, V v) {
        return 1;
    }

    protected V DbA(K k) {
        return null;
    }

    public nn(int i) {
        if (i <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        }
        this.Os = i;
        this.eli = new LinkedHashMap<>(0, 0.75f, true);
    }

    public final V eli(K k) {
        V put;
        if (k == null) {
            throw new NullPointerException("key == null");
        }
        synchronized (this) {
            V v = this.eli.get(k);
            if (v != null) {
                this.kb++;
                return v;
            }
            this.wC++;
            V DbA = DbA(k);
            if (DbA == null) {
                return null;
            }
            synchronized (this) {
                this.ui++;
                put = this.eli.put(k, DbA);
                if (put != null) {
                    this.eli.put(k, put);
                } else {
                    this.DbA += Os(k, DbA);
                }
            }
            if (put != null) {
                return put;
            }
            eli(this.Os);
            return DbA;
        }
    }

    public final V eli(K k, V v) {
        V put;
        if (k == null || v == null) {
            throw new NullPointerException("key == null || value == null");
        }
        synchronized (this) {
            this.aGH++;
            this.DbA += Os(k, v);
            put = this.eli.put(k, v);
            if (put != null) {
                this.DbA -= Os(k, put);
            }
        }
        eli(this.Os);
        return put;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x006e, code lost:
    
        throw new java.lang.IllegalStateException(getClass().getName() + ".sizeOf() is reporting inconsistent results!");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void eli(int i) {
        while (true) {
            synchronized (this) {
                if (this.DbA >= 0 && (!this.eli.isEmpty() || this.DbA == 0)) {
                    if (this.DbA <= i || this.eli.isEmpty()) {
                        break;
                    }
                    Map.Entry<K, V> next = this.eli.entrySet().iterator().next();
                    K key = next.getKey();
                    V value = next.getValue();
                    this.eli.remove(key);
                    this.DbA -= Os(key, value);
                    this.MGA++;
                } else {
                    break;
                }
            }
        }
    }

    private int Os(K k, V v) {
        int DbA = DbA(k, v);
        if (DbA >= 0) {
            return DbA;
        }
        throw new IllegalStateException("Negative size: " + k + C3040d4.i.b + v);
    }

    public final synchronized String toString() {
        int i;
        int i2;
        i = this.kb;
        i2 = this.wC + i;
        return String.format(Locale.US, "LruCache[maxSize=%d,hits=%d,misses=%d,hitRate=%d%%]", Integer.valueOf(this.Os), Integer.valueOf(this.kb), Integer.valueOf(this.wC), Integer.valueOf(i2 != 0 ? (i * 100) / i2 : 0));
    }
}
