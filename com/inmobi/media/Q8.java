package com.inmobi.media;

import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes4.dex */
public final class Q8 extends C2613d8 {
    public final P8 x;
    public boolean y;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Q8(String assetId, String assetName, C2630e8 assetStyle, P8 timer) {
        super(assetId, assetName, "TIMER", assetStyle, 16);
        Intrinsics.checkNotNullParameter(assetId, "assetId");
        Intrinsics.checkNotNullParameter(assetName, "assetName");
        Intrinsics.checkNotNullParameter(assetStyle, "assetStyle");
        Intrinsics.checkNotNullParameter(timer, "timer");
        this.x = timer;
    }

    public final void a(boolean z) {
        this.y = z;
    }
}
