package com.mbridge.msdk.foundation.same.buffer;

import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: LruReplaceTempCache.java */
/* loaded from: classes6.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private final LinkedHashMap<String, JSONObject> f4265a;
    private final int b;
    private int c;

    public a(int i) {
        if (i <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        }
        this.b = i;
        this.f4265a = new LinkedHashMap<>(0, 0.75f, true);
    }

    private int b(String str, JSONObject jSONObject) {
        return 1;
    }

    public final boolean a(String str, JSONObject jSONObject) {
        if (str == null || jSONObject == null) {
            throw new NullPointerException("key == null || value == null");
        }
        synchronized (this) {
            this.c += b(str, jSONObject);
            JSONObject put = this.f4265a.put(str, jSONObject);
            if (put != null) {
                this.c -= b(str, put);
            }
        }
        a(this.b);
        return true;
    }

    public final synchronized String toString() {
        return String.format("LruCache[maxSize=%d]", Integer.valueOf(this.b));
    }

    public final JSONObject a(String str) {
        JSONObject jSONObject;
        if (str != null) {
            synchronized (this) {
                jSONObject = this.f4265a.get(str);
            }
            return jSONObject;
        }
        throw new NullPointerException("key == null");
    }

    public Collection<String> a() {
        HashSet hashSet;
        synchronized (this) {
            hashSet = new HashSet(this.f4265a.keySet());
        }
        return hashSet;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0073, code lost:
    
        throw new java.lang.IllegalStateException(getClass().getName() + ".sizeOf() is reporting inconsistent results!");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void a(int i) {
        while (true) {
            synchronized (this) {
                if (this.c >= 0 && (!this.f4265a.isEmpty() || this.c == 0)) {
                    if (this.c <= i || this.f4265a.isEmpty()) {
                        break;
                    }
                    Map.Entry<String, JSONObject> next = this.f4265a.entrySet().iterator().next();
                    if (next == null) {
                        return;
                    }
                    String key = next.getKey();
                    try {
                        int b = b(key, next.getValue());
                        this.f4265a.remove(key);
                        this.c -= b;
                    } catch (Throwable unused) {
                    }
                } else {
                    break;
                }
            }
        }
    }
}
