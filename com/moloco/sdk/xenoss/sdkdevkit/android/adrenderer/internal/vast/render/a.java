package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render;

import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.C3459i;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public final class a {
    public static final int f = 8;

    /* renamed from: a, reason: collision with root package name */
    public final f f6165a;
    public final c b;
    public final List<String> c;
    public final List<String> d;
    public final C3459i e;

    public a(f linear, c cVar, List<String> impressionTracking, List<String> errorTracking, C3459i c3459i) {
        Intrinsics.checkNotNullParameter(linear, "linear");
        Intrinsics.checkNotNullParameter(impressionTracking, "impressionTracking");
        Intrinsics.checkNotNullParameter(errorTracking, "errorTracking");
        this.f6165a = linear;
        this.b = cVar;
        this.c = impressionTracking;
        this.d = errorTracking;
        this.e = c3459i;
    }

    public final f a() {
        return this.f6165a;
    }

    public final c b() {
        return this.b;
    }

    public final List<String> c() {
        return this.c;
    }

    public final List<String> d() {
        return this.d;
    }

    public final C3459i e() {
        return this.e;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return Intrinsics.areEqual(this.f6165a, aVar.f6165a) && Intrinsics.areEqual(this.b, aVar.b) && Intrinsics.areEqual(this.c, aVar.c) && Intrinsics.areEqual(this.d, aVar.d) && Intrinsics.areEqual(this.e, aVar.e);
    }

    public final c f() {
        return this.b;
    }

    public final C3459i g() {
        return this.e;
    }

    public final List<String> h() {
        return this.d;
    }

    public int hashCode() {
        int hashCode = this.f6165a.hashCode() * 31;
        c cVar = this.b;
        int hashCode2 = (((((hashCode + (cVar == null ? 0 : cVar.hashCode())) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31;
        C3459i c3459i = this.e;
        return hashCode2 + (c3459i != null ? c3459i.hashCode() : 0);
    }

    public final List<String> i() {
        return this.c;
    }

    public final f j() {
        return this.f6165a;
    }

    public String toString() {
        return "Ad(linear=" + this.f6165a + ", companion=" + this.b + ", impressionTracking=" + this.c + ", errorTracking=" + this.d + ", dec=" + this.e + ')';
    }

    public final a a(f linear, c cVar, List<String> impressionTracking, List<String> errorTracking, C3459i c3459i) {
        Intrinsics.checkNotNullParameter(linear, "linear");
        Intrinsics.checkNotNullParameter(impressionTracking, "impressionTracking");
        Intrinsics.checkNotNullParameter(errorTracking, "errorTracking");
        return new a(linear, cVar, impressionTracking, errorTracking, c3459i);
    }

    public static /* synthetic */ a a(a aVar, f fVar, c cVar, List list, List list2, C3459i c3459i, int i, Object obj) {
        if ((i & 1) != 0) {
            fVar = aVar.f6165a;
        }
        if ((i & 2) != 0) {
            cVar = aVar.b;
        }
        if ((i & 4) != 0) {
            list = aVar.c;
        }
        if ((i & 8) != 0) {
            list2 = aVar.d;
        }
        if ((i & 16) != 0) {
            c3459i = aVar.e;
        }
        C3459i c3459i2 = c3459i;
        List list3 = list;
        return aVar.a(fVar, cVar, list3, list2, c3459i2);
    }

    public /* synthetic */ a(f fVar, c cVar, List list, List list2, C3459i c3459i, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(fVar, cVar, list, list2, (i & 16) != 0 ? null : c3459i);
    }
}
