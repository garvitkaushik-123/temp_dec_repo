package com.inmobi.media;

import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes4.dex */
public final class Ec {

    /* renamed from: a, reason: collision with root package name */
    public final String f2275a;
    public final Class b;

    public Ec(String fieldName, Class<?> originClass) {
        Intrinsics.checkNotNullParameter(fieldName, "fieldName");
        Intrinsics.checkNotNullParameter(originClass, "originClass");
        this.f2275a = fieldName;
        this.b = originClass;
    }

    public final Ec a(String fieldName, Class<?> originClass) {
        Intrinsics.checkNotNullParameter(fieldName, "fieldName");
        Intrinsics.checkNotNullParameter(originClass, "originClass");
        return new Ec(fieldName, originClass);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Ec)) {
            return false;
        }
        Ec ec = (Ec) obj;
        return Intrinsics.areEqual(this.f2275a, ec.f2275a) && Intrinsics.areEqual(this.b, ec.b);
    }

    public int hashCode() {
        return this.b.hashCode() + (this.f2275a.hashCode() * 31);
    }

    public String toString() {
        return "RuleKey(fieldName=" + this.f2275a + ", originClass=" + this.b + ')';
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Ec a(Ec ec, String str, Class cls, int i, Object obj) {
        if ((i & 1) != 0) {
            str = ec.f2275a;
        }
        if ((i & 2) != 0) {
            cls = ec.b;
        }
        return ec.a(str, cls);
    }
}
