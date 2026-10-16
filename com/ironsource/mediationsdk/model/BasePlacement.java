package com.ironsource.mediationsdk.model;

import com.ironsource.Tc;
import kotlin.Deprecated;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Deprecated(message = "This class is deprecated and will be removed in version 9.0.0.")
/* loaded from: classes6.dex */
public abstract class BasePlacement {

    /* renamed from: a, reason: collision with root package name */
    private final int f3552a;
    private final String b;
    private final boolean c;
    private final Tc d;

    public BasePlacement(int i, String placementName, boolean z, Tc tc) {
        Intrinsics.checkNotNullParameter(placementName, "placementName");
        this.f3552a = i;
        this.b = placementName;
        this.c = z;
        this.d = tc;
    }

    public final Tc getPlacementAvailabilitySettings() {
        return this.d;
    }

    public final int getPlacementId() {
        return this.f3552a;
    }

    public final String getPlacementName() {
        return this.b;
    }

    public final boolean isDefault() {
        return this.c;
    }

    public final boolean isPlacementId(int i) {
        return this.f3552a == i;
    }

    public String toString() {
        return "placement name: " + this.b;
    }

    public /* synthetic */ BasePlacement(int i, String str, boolean z, Tc tc, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 0 : i, str, (i2 & 4) != 0 ? false : z, (i2 & 8) != 0 ? null : tc);
    }
}
