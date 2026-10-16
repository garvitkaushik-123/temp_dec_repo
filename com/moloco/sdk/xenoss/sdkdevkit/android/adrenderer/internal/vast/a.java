package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast;

import java.util.Comparator;
import kotlin.Pair;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public final class a implements Comparator<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.e> {

    /* renamed from: a, reason: collision with root package name */
    public final Integer f6056a;
    public final Integer b;

    /* JADX WARN: Multi-variable type inference failed */
    public a() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    @Override // java.util.Comparator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compare(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.e c1, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.e c2) {
        Pair d;
        Intrinsics.checkNotNullParameter(c1, "c1");
        Intrinsics.checkNotNullParameter(c2, "c2");
        d = g.d(c1, c2, this.f6056a, this.b);
        return Intrinsics.compare(((Number) d.component2()).intValue(), ((Number) d.component1()).intValue());
    }

    public a(Integer num, Integer num2) {
        this.f6056a = num;
        this.b = num2;
    }

    public /* synthetic */ a(Integer num, Integer num2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : num, (i & 2) != 0 ? null : num2);
    }
}
