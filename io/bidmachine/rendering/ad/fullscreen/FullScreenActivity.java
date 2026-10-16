package io.bidmachine.rendering.ad.fullscreen;

import android.os.Bundle;
import io.bidmachine.rendering.internal.ActivityC3588a;
import io.bidmachine.util.UiUtilsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0003J\u0019\u0010\b\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0014¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0004H\u0014¢\u0006\u0004\b\n\u0010\u0003R\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\f\u0010\r¨\u0006\u000f"}, d2 = {"Lio/bidmachine/rendering/ad/fullscreen/FullScreenActivity;", "Lio/bidmachine/rendering/internal/a;", "<init>", "()V", "", "c", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "onDestroy", "Lio/bidmachine/rendering/ad/fullscreen/FullScreenAd;", "a", "Lio/bidmachine/rendering/ad/fullscreen/FullScreenAd;", "fullScreenAd", "bidmachine-android-sdk_bi_3_4_0"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes8.dex */
public final class FullScreenActivity extends ActivityC3588a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private FullScreenAd fullScreenAd;

    private final void c() {
        UiUtilsKt.finishActivityWithoutAnimationSafely(this);
        FullScreenAd fullScreenAd = this.fullScreenAd;
        if (fullScreenAd != null) {
            fullScreenAd.processAdClosed();
        }
        this.fullScreenAd = null;
    }

    @Override // io.bidmachine.rendering.internal.ActivityC3588a, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        FullScreenAd fullScreenAd;
        super.onCreate(savedInstanceState);
        fullScreenAd = FullScreenActivityKt.f6936a;
        this.fullScreenAd = fullScreenAd;
        if (fullScreenAd == null) {
            c();
        } else if (fullScreenAd != null) {
            fullScreenAd.showInActivity(this);
        }
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        FullScreenAd fullScreenAd;
        super.onDestroy();
        if (isChangingConfigurations()) {
            return;
        }
        fullScreenAd = FullScreenActivityKt.f6936a;
        if (Intrinsics.areEqual(fullScreenAd, this.fullScreenAd)) {
            FullScreenActivityKt.f6936a = null;
        }
        c();
    }
}
