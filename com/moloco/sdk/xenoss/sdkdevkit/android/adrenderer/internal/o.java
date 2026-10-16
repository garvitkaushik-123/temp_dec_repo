package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal;

import android.content.Context;
import android.net.Uri;
import androidx.browser.customtabs.CustomTabsIntent;
import com.moloco.sdk.internal.MolocoLogger;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public final class o {
    public static final boolean b(Context context, String str) {
        try {
            CustomTabsIntent build = new CustomTabsIntent.Builder().setUrlBarHidingEnabled(true).build();
            Intrinsics.checkNotNullExpressionValue(build, "build(...)");
            build.intent.addFlags(268435456);
            build.launchUrl(context, Uri.parse(str));
            return true;
        } catch (Exception e) {
            MolocoLogger.error$default(MolocoLogger.INSTANCE, "Xenoss", "tryStartCustomTabs exception", e, false, 8, null);
            return false;
        }
    }
}
