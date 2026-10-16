package com.ironsource;

import com.unity3d.mediation.LevelPlayAdInfo;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: com.ironsource.s0, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C3289s0 {

    /* renamed from: a, reason: collision with root package name */
    private final AbstractC3222o0 f3688a;
    private final LevelPlayAdInfo b;

    public C3289s0(AbstractC3222o0 adUnit, LevelPlayAdInfo levelPlayAdInfo) {
        Intrinsics.checkNotNullParameter(adUnit, "adUnit");
        this.f3688a = adUnit;
        this.b = levelPlayAdInfo;
    }

    public final AbstractC3222o0 a() {
        return this.f3688a;
    }

    public final LevelPlayAdInfo b() {
        return this.b;
    }

    public final LevelPlayAdInfo c() {
        return this.b;
    }

    public final AbstractC3222o0 d() {
        return this.f3688a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C3289s0)) {
            return false;
        }
        C3289s0 c3289s0 = (C3289s0) obj;
        return Intrinsics.areEqual(this.f3688a, c3289s0.f3688a) && Intrinsics.areEqual(this.b, c3289s0.b);
    }

    public int hashCode() {
        int hashCode = this.f3688a.hashCode() * 31;
        LevelPlayAdInfo levelPlayAdInfo = this.b;
        return hashCode + (levelPlayAdInfo == null ? 0 : levelPlayAdInfo.hashCode());
    }

    public String toString() {
        return "AdUnitCallback(adUnit=" + this.f3688a + ", adInfo=" + this.b + ")";
    }

    public /* synthetic */ C3289s0(AbstractC3222o0 abstractC3222o0, LevelPlayAdInfo levelPlayAdInfo, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(abstractC3222o0, (i & 2) != 0 ? null : levelPlayAdInfo);
    }

    public final C3289s0 a(AbstractC3222o0 adUnit, LevelPlayAdInfo levelPlayAdInfo) {
        Intrinsics.checkNotNullParameter(adUnit, "adUnit");
        return new C3289s0(adUnit, levelPlayAdInfo);
    }

    public static /* synthetic */ C3289s0 a(C3289s0 c3289s0, AbstractC3222o0 abstractC3222o0, LevelPlayAdInfo levelPlayAdInfo, int i, Object obj) {
        if ((i & 1) != 0) {
            abstractC3222o0 = c3289s0.f3688a;
        }
        if ((i & 2) != 0) {
            levelPlayAdInfo = c3289s0.b;
        }
        return c3289s0.a(abstractC3222o0, levelPlayAdInfo);
    }
}
