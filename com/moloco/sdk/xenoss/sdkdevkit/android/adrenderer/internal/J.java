package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal;

import android.content.Context;
import com.moloco.sdk.service_locator.a;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public final class J {
    public static /* synthetic */ com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.l a(Context context, com.moloco.sdk.internal.ortb.model.c cVar, boolean z, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.z zVar, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.d dVar, InterfaceC3460j interfaceC3460j, int i, Object obj) {
        if ((i & 16) != 0) {
            dVar = com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.f.a(context);
        }
        com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.d dVar2 = dVar;
        if ((i & 32) != 0) {
            interfaceC3460j = a.C0463a.f5749a.a();
        }
        return a(context, cVar, z, zVar, dVar2, interfaceC3460j);
    }

    public static final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.l<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.x, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.y> a(Context context, com.moloco.sdk.internal.ortb.model.c bid, boolean z, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.z watermark, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.d loadVast, InterfaceC3460j decLoader) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(bid, "bid");
        Intrinsics.checkNotNullParameter(watermark, "watermark");
        Intrinsics.checkNotNullParameter(loadVast, "loadVast");
        Intrinsics.checkNotNullParameter(decLoader, "decLoader");
        return new I(context, bid, loadVast, decLoader, z, watermark);
    }
}
