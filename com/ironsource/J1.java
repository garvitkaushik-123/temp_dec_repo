package com.ironsource;

import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public final class J1 {

    /* renamed from: a, reason: collision with root package name */
    private final Map<String, String> f2913a;

    /* JADX WARN: Multi-variable type inference failed */
    public J1() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public final Map<String, String> a() {
        return this.f2913a;
    }

    public final Map<String, String> b() {
        return this.f2913a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof J1) && Intrinsics.areEqual(this.f2913a, ((J1) obj).f2913a);
    }

    public int hashCode() {
        return this.f2913a.hashCode();
    }

    public String toString() {
        return "ApplicationExternalSettings(mediationTypes=" + this.f2913a + ")";
    }

    public J1(Map<String, String> mediationTypes) {
        Intrinsics.checkNotNullParameter(mediationTypes, "mediationTypes");
        this.f2913a = mediationTypes;
    }

    public final J1 a(Map<String, String> mediationTypes) {
        Intrinsics.checkNotNullParameter(mediationTypes, "mediationTypes");
        return new J1(mediationTypes);
    }

    public /* synthetic */ J1(Map map, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? MapsKt.emptyMap() : map);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ J1 a(J1 j1, Map map, int i, Object obj) {
        if ((i & 1) != 0) {
            map = j1.f2913a;
        }
        return j1.a(map);
    }
}
