package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal;

import android.content.Context;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.MraidActivity;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public final class v {
    public static final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.l<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.e, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.f> a(Context context, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.z watermark, s mraidAdLoader, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.e mraidBaseAd, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.j mraidFullscreenController, MraidActivity.Companion mraidAdActivity) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(watermark, "watermark");
        Intrinsics.checkNotNullParameter(mraidAdLoader, "mraidAdLoader");
        Intrinsics.checkNotNullParameter(mraidBaseAd, "mraidBaseAd");
        Intrinsics.checkNotNullParameter(mraidFullscreenController, "mraidFullscreenController");
        Intrinsics.checkNotNullParameter(mraidAdActivity, "mraidAdActivity");
        return new u(context, watermark, mraidAdLoader, mraidBaseAd, mraidFullscreenController, mraidAdActivity);
    }
}
