package com.fyber.inneractive.sdk.protobuf;

import com.ironsource.C3040d4;
import java.util.Map;

/* loaded from: classes4.dex */
public final class b3 implements Map.Entry, Comparable {

    /* renamed from: a, reason: collision with root package name */
    public final Comparable f1660a;
    public Object b;
    public final /* synthetic */ e3 c;

    public b3(e3 e3Var, Map.Entry entry) {
        Comparable comparable = (Comparable) entry.getKey();
        Object value = entry.getValue();
        this.c = e3Var;
        this.f1660a = comparable;
        this.b = value;
    }

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        return this.f1660a.compareTo(((b3) obj).f1660a);
    }

    @Override // java.util.Map.Entry
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Map.Entry)) {
            return false;
        }
        Map.Entry entry = (Map.Entry) obj;
        Comparable comparable = this.f1660a;
        Object key = entry.getKey();
        if (comparable == null ? key == null : comparable.equals(key)) {
            Object obj2 = this.b;
            Object value = entry.getValue();
            if (obj2 == null ? value == null : obj2.equals(value)) {
                return true;
            }
        }
        return false;
    }

    @Override // java.util.Map.Entry
    public final Object getKey() {
        return this.f1660a;
    }

    @Override // java.util.Map.Entry
    public final Object getValue() {
        return this.b;
    }

    @Override // java.util.Map.Entry
    public final int hashCode() {
        Comparable comparable = this.f1660a;
        int hashCode = comparable == null ? 0 : comparable.hashCode();
        Object obj = this.b;
        return hashCode ^ (obj != null ? obj.hashCode() : 0);
    }

    @Override // java.util.Map.Entry
    public final Object setValue(Object obj) {
        this.c.a();
        Object obj2 = this.b;
        this.b = obj;
        return obj2;
    }

    public final String toString() {
        return this.f1660a + C3040d4.i.b + this.b;
    }

    public b3(e3 e3Var, Comparable comparable, Object obj) {
        this.c = e3Var;
        this.f1660a = comparable;
        this.b = obj;
    }
}
