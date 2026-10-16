package com.ironsource;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: com.ironsource.xf, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C3389xf {

    /* renamed from: a, reason: collision with root package name */
    private String f3941a;

    /* JADX WARN: Multi-variable type inference failed */
    public C3389xf() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public final String a() {
        return this.f3941a;
    }

    public final String b() {
        return this.f3941a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof C3389xf) && Intrinsics.areEqual(this.f3941a, ((C3389xf) obj).f3941a);
    }

    public int hashCode() {
        String str = this.f3941a;
        if (str == null) {
            return 0;
        }
        return str.hashCode();
    }

    public String toString() {
        return "TestSuiteSettings(controllerUrl=" + this.f3941a + ")";
    }

    public C3389xf(String str) {
        this.f3941a = str;
    }

    public final C3389xf a(String str) {
        return new C3389xf(str);
    }

    public final void b(String str) {
        this.f3941a = str;
    }

    public /* synthetic */ C3389xf(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str);
    }

    public static /* synthetic */ C3389xf a(C3389xf c3389xf, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = c3389xf.f3941a;
        }
        return c3389xf.a(str);
    }
}
