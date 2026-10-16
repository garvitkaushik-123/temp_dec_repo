package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast;

import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.q;
import java.util.Comparator;
import kotlin.Pair;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public final class b implements Comparator<q> {

    /* renamed from: a, reason: collision with root package name */
    public final double f6057a;
    public final Long b;
    public final Integer c;
    public final Integer d;

    public b(double d, Long l, Integer num, Integer num2) {
        this.f6057a = d;
        this.b = l;
        this.c = num;
        this.d = num2;
    }

    @Override // java.util.Comparator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compare(q mf1, q mf2) {
        Pair b;
        Intrinsics.checkNotNullParameter(mf1, "mf1");
        Intrinsics.checkNotNullParameter(mf2, "mf2");
        b = g.b(mf1, mf2, this.f6057a, this.b, this.c, this.d);
        return Intrinsics.compare(((Number) b.component2()).intValue(), ((Number) b.component1()).intValue());
    }

    public /* synthetic */ b(double d, Long l, Integer num, Integer num2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(d, (i & 2) != 0 ? null : l, (i & 4) != 0 ? null : num, (i & 8) != 0 ? null : num2);
    }
}
