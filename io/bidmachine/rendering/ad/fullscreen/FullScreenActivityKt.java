package io.bidmachine.rendering.ad.fullscreen;

import android.content.Context;
import io.bidmachine.rendering.internal.C3589b;
import io.bidmachine.rendering.model.Error;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\u001a\u0019\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0004\u0010\u0005\"\u0018\u0010\b\u001a\u0004\u0018\u00010\u00008\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007¨\u0006\t"}, d2 = {"Lio/bidmachine/rendering/ad/fullscreen/FullScreenAd;", "Landroid/content/Context;", "context", "", "startActivity", "(Lio/bidmachine/rendering/ad/fullscreen/FullScreenAd;Landroid/content/Context;)V", "a", "Lio/bidmachine/rendering/ad/fullscreen/FullScreenAd;", "tempFullScreenAd", "bidmachine-android-sdk_bi_3_4_0"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes8.dex */
public final class FullScreenActivityKt {

    /* renamed from: a, reason: collision with root package name */
    private static FullScreenAd f6936a;

    public static final void startActivity(FullScreenAd fullScreenAd, Context context) {
        Intrinsics.checkNotNullParameter(fullScreenAd, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        try {
            f6936a = fullScreenAd;
            context.startActivity(C3589b.a(context, FullScreenActivity.class));
        } catch (Throwable unused) {
            f6936a = null;
            fullScreenAd.notifyAdFailToShow(new Error("Ad is null"));
        }
    }
}
