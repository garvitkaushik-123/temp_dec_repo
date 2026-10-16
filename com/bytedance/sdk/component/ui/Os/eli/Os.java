package com.bytedance.sdk.component.ui.Os.eli;

import com.ironsource.C3040d4;
import java.lang.ref.SoftReference;
import java.util.LinkedHashMap;
import java.util.Map;

/* loaded from: classes3.dex */
public class Os<K, V> {
    private int DbA;
    private int MGA;
    private int Os;
    private int aGH;
    private final LinkedHashMap<K, SoftReference<V>> eli;
    private int kb;
    private int ui;
    private int wC;

    protected int DbA(K k, V v) {
        return 1;
    }

    protected V DbA(K k) {
        return null;
    }

    public Os(int i) {
        if (i <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        }
        this.Os = i;
        this.eli = new LinkedHashMap<>(0, 0.75f, true);
    }

    public final V eli(K k) {
        V v;
        if (k == null) {
            throw new NullPointerException("key == null");
        }
        synchronized (this) {
            SoftReference<V> softReference = this.eli.get(k);
            if (softReference != null) {
                v = softReference.get();
                if (v != null) {
                    this.kb++;
                    return v;
                }
                this.eli.remove(k);
            } else {
                v = null;
            }
            this.wC++;
            V DbA = DbA(k);
            if (DbA == null) {
                return null;
            }
            synchronized (this) {
                this.ui++;
                SoftReference<V> put = this.eli.put(k, new SoftReference<>(DbA));
                if (put != null) {
                    v = put.get();
                }
                if (v != null) {
                    this.eli.put(k, put);
                } else {
                    this.DbA += Os(k, DbA);
                }
            }
            if (v != null) {
                return v;
            }
            eli(this.Os);
            return DbA;
        }
    }

    public final V eli(K k, V v) {
        V v2;
        if (k == null || v == null) {
            throw new NullPointerException("key == null || value == null");
        }
        synchronized (this) {
            this.aGH++;
            this.DbA += Os(k, v);
            SoftReference<V> put = this.eli.put(k, new SoftReference<>(v));
            if (put != null) {
                v2 = put.get();
                if (v2 != null) {
                    this.DbA -= Os(k, v2);
                }
            } else {
                v2 = null;
            }
        }
        eli(this.Os);
        return v2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0052, code lost:
    
        android.util.Log.e("LruCache", "oom maybe occured, clear cache. size= " + r3.DbA + ", maxSize: " + r4);
        r3.DbA = 0;
        r3.eli.clear();
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x007b, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void eli(int i) {
        while (true) {
            synchronized (this) {
                if (this.DbA < 0 || (this.eli.isEmpty() && this.DbA != 0)) {
                    break;
                }
                if (this.DbA <= i) {
                    return;
                }
                Map.Entry<K, SoftReference<V>> next = this.eli.entrySet().iterator().next();
                if (next == null) {
                    return;
                }
                K key = next.getKey();
                SoftReference<V> value = next.getValue();
                this.eli.remove(key);
                if (value != null) {
                    this.DbA -= Os(key, value.get());
                }
                this.MGA++;
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
        return String.format("LruCache[maxSize=%d,hits=%d,misses=%d,hitRate=%d%%]", Integer.valueOf(this.Os), Integer.valueOf(this.kb), Integer.valueOf(this.wC), Integer.valueOf(i2 != 0 ? (i * 100) / i2 : 0));
    }
}
