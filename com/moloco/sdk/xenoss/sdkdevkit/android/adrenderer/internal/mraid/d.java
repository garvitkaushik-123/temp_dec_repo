package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid;

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
public final class d {
    public static final List<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.k> a(c cVar, j mraidFullscreenContentController, int i, Context context, InterfaceC3463m externalLinkHandler, com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a customUserEventBuilderService) {
        Intrinsics.checkNotNullParameter(cVar, "<this>");
        Intrinsics.checkNotNullParameter(mraidFullscreenContentController, "mraidFullscreenContentController");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(externalLinkHandler, "externalLinkHandler");
        Intrinsics.checkNotNullParameter(customUserEventBuilderService, "customUserEventBuilderService");
        k.d dVar = new k.d(mraidFullscreenContentController);
        C3459i b = cVar.b();
        return CollectionsKt.listOfNotNull((Object[]) new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.k[]{dVar, b != null ? new k.b(new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.dec.c(b, null, UInt.m10336constructorimpl(RangesKt.coerceAtLeast(i, 0)), context, customUserEventBuilderService, externalLinkHandler, null)) : null});
    }
}
