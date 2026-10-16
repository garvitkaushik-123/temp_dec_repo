package com.moloco.sdk.internal.services.bidtoken.providers;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public final class h {
    public static final int d = 0;

    /* renamed from: a, reason: collision with root package name */
    public final Integer f5647a;
    public final Integer b;
    public final Boolean c;

    public h() {
        this(null, null, null, 7, null);
    }

    public final Integer a() {
        return this.f5647a;
    }

    public final Integer b() {
        return this.b;
    }

    public final Boolean c() {
        return this.c;
    }

    public final Integer d() {
        return this.b;
    }

    public final Integer e() {
        return this.f5647a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof h)) {
            return false;
        }
        h hVar = (h) obj;
        return Intrinsics.areEqual(this.f5647a, hVar.f5647a) && Intrinsics.areEqual(this.b, hVar.b) && Intrinsics.areEqual(this.c, hVar.c);
    }

    public final Boolean f() {
        return this.c;
    }

    public int hashCode() {
        Integer num = this.f5647a;
        int hashCode = (num == null ? 0 : num.hashCode()) * 31;
        Integer num2 = this.b;
        int hashCode2 = (hashCode + (num2 == null ? 0 : num2.hashCode())) * 31;
        Boolean bool = this.c;
        return hashCode2 + (bool != null ? bool.hashCode() : 0);
    }

    public String toString() {
        return "BatteryInfoSignal(maxBatteryLevel=" + this.f5647a + ", batteryStatus=" + this.b + ", isPowerSaveMode=" + this.c + ')';
    }

    public h(Integer num, Integer num2, Boolean bool) {
        this.f5647a = num;
        this.b = num2;
        this.c = bool;
    }

    public final h a(Integer num, Integer num2, Boolean bool) {
        return new h(num, num2, bool);
    }

    public static /* synthetic */ h a(h hVar, Integer num, Integer num2, Boolean bool, int i, Object obj) {
        if ((i & 1) != 0) {
            num = hVar.f5647a;
        }
        if ((i & 2) != 0) {
            num2 = hVar.b;
        }
        if ((i & 4) != 0) {
            bool = hVar.c;
        }
        return hVar.a(num, num2, bool);
    }

    public /* synthetic */ h(Integer num, Integer num2, Boolean bool, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : num, (i & 2) != 0 ? null : num2, (i & 4) != 0 ? null : bool);
    }
}
