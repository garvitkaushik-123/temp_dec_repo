package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad;

import android.content.Context;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.C3459i;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.InterfaceC3463m;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.k;
import java.util.List;
import kotlin.UInt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* loaded from: classes6.dex */
public final class j {
    public static final List<k> a(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.a aVar, InterfaceC3463m externalLinkHandler, Context context, com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a customUserEventBuilderService, boolean z, Boolean bool, int i, int i2, int i3, boolean z2, boolean z3) {
        Intrinsics.checkNotNullParameter(aVar, "<this>");
        Intrinsics.checkNotNullParameter(externalLinkHandler, "externalLinkHandler");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(customUserEventBuilderService, "customUserEventBuilderService");
        k.c cVar = new k.c(new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.linear.e(aVar.j(), 0, z, bool, i, z2, z3, context, customUserEventBuilderService, externalLinkHandler));
        com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.c f = aVar.f();
        k.a aVar2 = f != null ? new k.a(new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.companion.c(f, UInt.m10336constructorimpl(RangesKt.coerceAtLeast(i2, 0)), context, customUserEventBuilderService, externalLinkHandler, z, null)) : null;
        C3459i g = aVar.g();
        return CollectionsKt.listOfNotNull((Object[]) new k[]{cVar, aVar2, g != null ? new k.b(new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.dec.c(g, aVar.j().i(), UInt.m10336constructorimpl(RangesKt.coerceAtLeast(i3, 0)), context, customUserEventBuilderService, externalLinkHandler, null)) : null});
    }
}
