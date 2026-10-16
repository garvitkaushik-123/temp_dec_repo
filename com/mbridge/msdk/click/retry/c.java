package com.mbridge.msdk.click.retry;

import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;

/* compiled from: WaitRetryLruMemoryCache.java */
/* loaded from: classes6.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private final LinkedHashMap<String, b> f4061a;
    private final int b;
    private int c;

    public c(int i) {
        if (i <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        }
        this.b = i;
        this.f4061a = new LinkedHashMap<>(0, 0.75f, true);
    }

    private int b(String str, b bVar) {
        return 1;
    }

    public final b a(String str) {
        if (str == null) {
            throw new NullPointerException("key == null");
        }
        synchronized (this) {
            b bVar = this.f4061a.get(str);
            if (bVar != null) {
                return bVar;
            }
            return null;
        }
    }

    public final void b(String str) {
        if (str == null) {
            throw new NullPointerException("key == null");
        }
        synchronized (this) {
            b remove = this.f4061a.remove(str);
            if (remove != null) {
                this.c -= b(str, remove);
            }
        }
    }

    public final synchronized String toString() {
        return String.format("LruCache[maxSize=%d]", Integer.valueOf(this.b));
    }

    public final boolean a(String str, b bVar) {
        if (str != null && bVar != null) {
            synchronized (this) {
                this.c += b(str, bVar);
                b put = this.f4061a.put(str, bVar);
                if (put != null) {
                    this.c -= b(str, put);
                }
            }
            a(this.b);
            return true;
        }
        throw new NullPointerException("key == null || value == null");
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0070, code lost:
    
        throw new java.lang.IllegalStateException(getClass().getName() + ".sizeOf() is reporting inconsistent results!");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void a(int i) {
        while (true) {
            synchronized (this) {
                if (this.c >= 0 && (!this.f4061a.isEmpty() || this.c == 0)) {
                    if (this.c <= i || this.f4061a.isEmpty()) {
                        break;
                    }
                    Map.Entry<String, b> next = this.f4061a.entrySet().iterator().next();
                    if (next == null) {
                        return;
                    }
                    String key = next.getKey();
                    try {
                        int b = b(key, next.getValue());
                        this.f4061a.remove(key);
                        this.c -= b;
                    } catch (Throwable unused) {
                    }
                } else {
                    break;
                }
            }
        }
    }

    public Collection<String> a() {
        HashSet hashSet;
        synchronized (this) {
            hashSet = new HashSet(this.f4061a.keySet());
        }
        return hashSet;
    }
}
