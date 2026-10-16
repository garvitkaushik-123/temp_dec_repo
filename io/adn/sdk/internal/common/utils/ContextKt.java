package io.adn.sdk.internal.common.utils;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import androidx.browser.customtabs.CustomTabsIntent;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Context.kt */
@Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0000\u001a\u0014\u0010\u0003\u001a\u00020\u0004*\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0000\u001a\u0014\u0010\u0006\u001a\u00020\u0007*\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0000¨\u0006\u000b"}, d2 = {"getDensity", "", "Landroid/content/Context;", "pixelsToDp", "", "px", "launchCustomTab", "", "Landroid/app/Activity;", "uri", "Landroid/net/Uri;", "adn-sdk_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes7.dex */
public final class ContextKt {
    public static final float getDensity(Context context) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        return context.getResources().getDisplayMetrics().density;
    }

    public static final int pixelsToDp(Context context, int i) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        return (int) (i / getDensity(context));
    }

    public static final boolean launchCustomTab(Activity activity, Uri uri) {
        Object m10241constructorimpl;
        Intrinsics.checkNotNullParameter(activity, "<this>");
        Intrinsics.checkNotNullParameter(uri, "uri");
        try {
            Result.Companion companion = Result.INSTANCE;
            new CustomTabsIntent.Builder().setUrlBarHidingEnabled(true).build().launchUrl(activity, uri);
            m10241constructorimpl = Result.m10241constructorimpl(true);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            m10241constructorimpl = Result.m10241constructorimpl(ResultKt.createFailure(th));
        }
        if (Result.m10247isFailureimpl(m10241constructorimpl)) {
            m10241constructorimpl = false;
        }
        return ((Boolean) m10241constructorimpl).booleanValue();
    }
}
