package com.fyber.inneractive.sdk.protobuf;

import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/* loaded from: classes4.dex */
public final class y1 extends LinkedHashMap {
    public static final y1 b;

    /* renamed from: a, reason: collision with root package name */
    public boolean f1712a;

    static {
        y1 y1Var = new y1();
        b = y1Var;
        y1Var.f1712a = false;
    }

    public y1() {
        this.f1712a = true;
    }

    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final void clear() {
        if (!this.f1712a) {
            throw new UnsupportedOperationException();
        }
        super.clear();
    }

    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final Set entrySet() {
        return isEmpty() ? Collections.emptySet() : super.entrySet();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean equals(Object obj) {
        if (!(obj instanceof Map)) {
            return false;
        }
        Map map = (Map) obj;
        if (this == map) {
            return true;
        }
        if (size() != map.size()) {
            return false;
        }
        for (Map.Entry entry : entrySet()) {
            if (!map.containsKey(entry.getKey())) {
                return false;
            }
            Object value = entry.getValue();
            Object obj2 = map.get(entry.getKey());
            if (!(((value instanceof byte[]) && (obj2 instanceof byte[])) ? Arrays.equals((byte[]) value, (byte[]) obj2) : value.equals(obj2))) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final int hashCode() {
        int hashCode;
        int i = 0;
        for (Map.Entry entry : entrySet()) {
            Object key = entry.getKey();
            int i2 = 1;
            if (key instanceof byte[]) {
                byte[] bArr = (byte[]) key;
                Charset charset = l1.f1684a;
                hashCode = bArr.length;
                for (byte b2 : bArr) {
                    hashCode = (hashCode * 31) + b2;
                }
                if (hashCode == 0) {
                    hashCode = 1;
                }
            } else {
                if (key instanceof d1) {
                    throw new UnsupportedOperationException();
                }
                hashCode = key.hashCode();
            }
            Object value = entry.getValue();
            if (value instanceof byte[]) {
                byte[] bArr2 = (byte[]) value;
                Charset charset2 = l1.f1684a;
                int length = bArr2.length;
                for (byte b3 : bArr2) {
                    length = (length * 31) + b3;
                }
                if (length != 0) {
                    i2 = length;
                }
            } else {
                if (value instanceof d1) {
                    throw new UnsupportedOperationException();
                }
                i2 = value.hashCode();
            }
            i += hashCode ^ i2;
        }
        return i;
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final Object put(Object obj, Object obj2) {
        if (!this.f1712a) {
            throw new UnsupportedOperationException();
        }
        Charset charset = l1.f1684a;
        obj.getClass();
        obj2.getClass();
        return super.put(obj, obj2);
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final void putAll(Map map) {
        if (!this.f1712a) {
            throw new UnsupportedOperationException();
        }
        for (Object obj : map.keySet()) {
            Charset charset = l1.f1684a;
            obj.getClass();
            map.get(obj).getClass();
        }
        super.putAll(map);
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final Object remove(Object obj) {
        if (this.f1712a) {
            return super.remove(obj);
        }
        throw new UnsupportedOperationException();
    }

    public y1(Map map) {
        super(map);
        this.f1712a = true;
    }
}
