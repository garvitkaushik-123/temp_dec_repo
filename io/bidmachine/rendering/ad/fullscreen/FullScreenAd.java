package io.bidmachine.rendering.ad.fullscreen;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import com.fyber.inneractive.sdk.external.InneractiveMediationDefs;
import com.ironsource.C3207n2;
import com.ironsource.C3355vf;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import io.bidmachine.rendering.ad.view.AdView;
import io.bidmachine.rendering.ad.view.AdViewListener;
import io.bidmachine.rendering.internal.n;
import io.bidmachine.rendering.internal.state.d;
import io.bidmachine.rendering.model.AdParams;
import io.bidmachine.rendering.model.BrokenCreativeEvent;
import io.bidmachine.rendering.model.Error;
import io.bidmachine.rendering.model.PrivacySheetParams;
import io.bidmachine.util.UiUtils;
import io.bidmachine.util.UiUtilsKt;
import io.bidmachine.util.ViewUtils;
import io.bidmachine.util.ViewUtilsKt;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001\tB\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\bH\u0002¢\u0006\u0004\b\u000b\u0010\nJ\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\b\t\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\bH\u0002¢\u0006\u0004\b\u000f\u0010\nJ\u000f\u0010\u0010\u001a\u00020\bH\u0002¢\u0006\u0004\b\u0010\u0010\nJ\u000f\u0010\u0011\u001a\u00020\bH\u0002¢\u0006\u0004\b\u0011\u0010\nJ\u000f\u0010\u0012\u001a\u00020\bH\u0002¢\u0006\u0004\b\u0012\u0010\nJ\u000f\u0010\u0013\u001a\u00020\bH\u0002¢\u0006\u0004\b\u0013\u0010\nJ\u000f\u0010\u0014\u001a\u00020\bH\u0002¢\u0006\u0004\b\u0014\u0010\nJ\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\u0015H\u0002¢\u0006\u0004\b\t\u0010\u0017J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\u0018H\u0002¢\u0006\u0004\b\t\u0010\u001aJ\r\u0010\u001c\u001a\u00020\u001b¢\u0006\u0004\b\u001c\u0010\u001dJ\r\u0010\u001e\u001a\u00020\u001b¢\u0006\u0004\b\u001e\u0010\u001dJ\r\u0010\u001f\u001a\u00020\b¢\u0006\u0004\b\u001f\u0010\nJ\u0017\u0010\"\u001a\u00020\b2\b\u0010!\u001a\u0004\u0018\u00010 ¢\u0006\u0004\b\"\u0010#J\u0015\u0010$\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b$\u0010%J\r\u0010&\u001a\u00020\b¢\u0006\u0004\b&\u0010\nJ\u0015\u0010)\u001a\u00020\b2\u0006\u0010(\u001a\u00020'¢\u0006\u0004\b)\u0010*J\u0015\u0010+\u001a\u00020\b2\u0006\u0010(\u001a\u00020'¢\u0006\u0004\b+\u0010*J\r\u0010,\u001a\u00020\b¢\u0006\u0004\b,\u0010\nJ\u000f\u0010-\u001a\u0004\u0018\u00010'¢\u0006\u0004\b-\u0010.J\r\u0010/\u001a\u00020\b¢\u0006\u0004\b/\u0010\nJ\u0015\u00100\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b0\u0010\u000eR\u0014\u00103\u001a\u0002018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u00102R\u0014\u00106\u001a\u0002048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u00105R$\u0010=\u001a\u0004\u0018\u0001078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0010\u00108\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<R\u001e\u0010@\u001a\n\u0012\u0004\u0012\u00020'\u0018\u00010>8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010?¨\u0006A"}, d2 = {"Lio/bidmachine/rendering/ad/fullscreen/FullScreenAd;", "", "Landroid/content/Context;", "context", "Lio/bidmachine/rendering/model/AdParams;", "adParams", "<init>", "(Landroid/content/Context;Lio/bidmachine/rendering/model/AdParams;)V", "", "a", "()V", "g", "Lio/bidmachine/rendering/model/Error;", "error", "(Lio/bidmachine/rendering/model/Error;)V", "h", "c", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "d", InneractiveMediationDefs.GENDER_FEMALE, "e", "Lio/bidmachine/rendering/model/PrivacySheetParams;", "privacySheetParams", "(Lio/bidmachine/rendering/model/PrivacySheetParams;)V", "Lio/bidmachine/rendering/model/BrokenCreativeEvent;", "brokenCreativeEvent", "(Lio/bidmachine/rendering/model/BrokenCreativeEvent;)V", "", "isLoaded", "()Z", "isFinished", "load", "Landroid/graphics/drawable/Drawable;", "drawable", "setWatermark", "(Landroid/graphics/drawable/Drawable;)V", C3207n2.v, "(Landroid/content/Context;)V", "destroy", "Landroid/app/Activity;", "activity", "showInActivity", "(Landroid/app/Activity;)V", "attachActivity", "detachActivity", "getAttachedActivity", "()Landroid/app/Activity;", "processAdClosed", "notifyAdFailToShow", "Lio/bidmachine/rendering/internal/state/a;", "Lio/bidmachine/rendering/internal/state/a;", "adState", "Lio/bidmachine/rendering/ad/view/AdView;", "Lio/bidmachine/rendering/ad/view/AdView;", "adView", "Lio/bidmachine/rendering/ad/fullscreen/FullScreenAdListener;", "Lio/bidmachine/rendering/ad/fullscreen/FullScreenAdListener;", "getFullScreenAdListener", "()Lio/bidmachine/rendering/ad/fullscreen/FullScreenAdListener;", "setFullScreenAdListener", "(Lio/bidmachine/rendering/ad/fullscreen/FullScreenAdListener;)V", "fullScreenAdListener", "Ljava/lang/ref/WeakReference;", "Ljava/lang/ref/WeakReference;", "weakShowActivity", "bidmachine-android-sdk_bi_3_4_0"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes8.dex */
public final class FullScreenAd {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final io.bidmachine.rendering.internal.state.a adState;

    /* renamed from: b, reason: from kotlin metadata */
    private final AdView adView;

    /* renamed from: c, reason: from kotlin metadata */
    private FullScreenAdListener fullScreenAdListener;

    /* renamed from: d, reason: from kotlin metadata */
    private WeakReference<Activity> weakShowActivity;

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\r\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\r\u0010\bJ\u001f\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\u000e\u0010\fJ\u0017\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000f\u0010\bJ\u0017\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0010\u0010\bJ\u0017\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0011\u0010\bJ\u0017\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0012\u0010\bJ\u0017\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0013\u0010\bJ\u001f\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u001f\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u0018H\u0016¢\u0006\u0004\b\u001a\u0010\u001b¨\u0006\u001c"}, d2 = {"Lio/bidmachine/rendering/ad/fullscreen/FullScreenAd$a;", "Lio/bidmachine/rendering/ad/view/AdViewListener;", "<init>", "(Lio/bidmachine/rendering/ad/fullscreen/FullScreenAd;)V", "Lio/bidmachine/rendering/ad/view/AdView;", "adView", "", C3355vf.j, "(Lio/bidmachine/rendering/ad/view/AdView;)V", "Lio/bidmachine/rendering/model/Error;", "error", "onAdFailToLoad", "(Lio/bidmachine/rendering/ad/view/AdView;Lio/bidmachine/rendering/model/Error;)V", "onAdShown", "onAdFailToShow", C3355vf.f, "onAdFinished", "onAdAppeared", "onAdDisappeared", "onAdExpired", "Lio/bidmachine/rendering/model/PrivacySheetParams;", "privacySheetParams", "onOpenPrivacySheet", "(Lio/bidmachine/rendering/ad/view/AdView;Lio/bidmachine/rendering/model/PrivacySheetParams;)V", "Lio/bidmachine/rendering/model/BrokenCreativeEvent;", "brokenCreativeEvent", "onBrokenCreativeEvent", "(Lio/bidmachine/rendering/ad/view/AdView;Lio/bidmachine/rendering/model/BrokenCreativeEvent;)V", "bidmachine-android-sdk_bi_3_4_0"}, k = 1, mv = {1, 7, 1}, xi = 48)
    private final class a implements AdViewListener {
        public a() {
        }

        @Override // io.bidmachine.rendering.ad.AdListener
        public void onAdAppeared(AdView adView) {
            Intrinsics.checkNotNullParameter(adView, "adView");
            FullScreenAd.this.b();
        }

        @Override // io.bidmachine.rendering.ad.AdListener
        public void onAdClicked(AdView adView) {
            Intrinsics.checkNotNullParameter(adView, "adView");
            FullScreenAd.this.c();
        }

        @Override // io.bidmachine.rendering.ad.AdListener
        public void onAdDisappeared(AdView adView) {
            Intrinsics.checkNotNullParameter(adView, "adView");
            FullScreenAd.this.d();
        }

        @Override // io.bidmachine.rendering.ad.AdListener
        public void onAdExpired(AdView adView) {
            Intrinsics.checkNotNullParameter(adView, "adView");
            FullScreenAd.this.e();
        }

        @Override // io.bidmachine.rendering.ad.AdListener
        public void onAdFailToLoad(AdView adView, Error error) {
            Intrinsics.checkNotNullParameter(adView, "adView");
            Intrinsics.checkNotNullParameter(error, "error");
            FullScreenAd.this.a(error);
        }

        @Override // io.bidmachine.rendering.ad.AdListener
        public void onAdFailToShow(AdView adView, Error error) {
            Intrinsics.checkNotNullParameter(adView, "adView");
            Intrinsics.checkNotNullParameter(error, "error");
            FullScreenAd.this.notifyAdFailToShow(error);
        }

        @Override // io.bidmachine.rendering.ad.AdListener
        public void onAdFinished(AdView adView) {
            Intrinsics.checkNotNullParameter(adView, "adView");
            FullScreenAd.this.processAdClosed();
        }

        @Override // io.bidmachine.rendering.ad.AdListener
        public void onAdLoaded(AdView adView) {
            Intrinsics.checkNotNullParameter(adView, "adView");
            FullScreenAd.this.g();
        }

        @Override // io.bidmachine.rendering.ad.AdListener
        public void onAdShown(AdView adView) {
            Intrinsics.checkNotNullParameter(adView, "adView");
            FullScreenAd.this.h();
        }

        @Override // io.bidmachine.rendering.ad.AdListener
        public void onBrokenCreativeEvent(AdView adView, BrokenCreativeEvent brokenCreativeEvent) {
            Intrinsics.checkNotNullParameter(adView, "adView");
            Intrinsics.checkNotNullParameter(brokenCreativeEvent, "brokenCreativeEvent");
            FullScreenAd.this.a(brokenCreativeEvent);
        }

        @Override // io.bidmachine.rendering.ad.AdListener
        public void onOpenPrivacySheet(AdView adView, PrivacySheetParams privacySheetParams) {
            Intrinsics.checkNotNullParameter(adView, "adView");
            Intrinsics.checkNotNullParameter(privacySheetParams, "privacySheetParams");
            FullScreenAd.this.a(privacySheetParams);
        }
    }

    public FullScreenAd(Context context, AdParams adParams) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(adParams, "adParams");
        this.adState = new d("FullScreenAd");
        Context applicationContext = context.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "context.applicationContext");
        this.adView = new AdView(applicationContext, adParams);
    }

    private final void a() {
        UiUtilsKt.finishActivityWithoutAnimationSafely(getAttachedActivity());
        detachActivity();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(FullScreenAd this$0, Error error) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(error, "$error");
        FullScreenAdListener fullScreenAdListener = this$0.fullScreenAdListener;
        if (fullScreenAdListener != null) {
            fullScreenAdListener.onAdFailToShow(this$0, error);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void c() {
        this.adState.e();
        UiUtils.onUiThread(new n() { // from class: io.bidmachine.rendering.ad.fullscreen.FullScreenAd$$ExternalSyntheticLambda0
            @Override // io.bidmachine.util.SafeRunnable
            public final void onRun() {
                FullScreenAd.b(FullScreenAd.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void d() {
        if (this.adState.b(false)) {
            UiUtils.onUiThread(new n() { // from class: io.bidmachine.rendering.ad.fullscreen.FullScreenAd$$ExternalSyntheticLambda9
                @Override // io.bidmachine.util.SafeRunnable
                public final void onRun() {
                    FullScreenAd.c(FullScreenAd.this);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(FullScreenAd this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        FullScreenAdListener fullScreenAdListener = this$0.fullScreenAdListener;
        if (fullScreenAdListener != null) {
            fullScreenAdListener.onAdFinished(this$0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(FullScreenAd this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        FullScreenAdListener fullScreenAdListener = this$0.fullScreenAdListener;
        if (fullScreenAdListener != null) {
            fullScreenAdListener.onAdLoaded(this$0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void g() {
        if (this.adState.a(true)) {
            UiUtils.onUiThread(new n() { // from class: io.bidmachine.rendering.ad.fullscreen.FullScreenAd$$ExternalSyntheticLambda4
                @Override // io.bidmachine.util.SafeRunnable
                public final void onRun() {
                    FullScreenAd.f(FullScreenAd.this);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void h() {
        if (this.adState.i()) {
            UiUtils.onUiThread(new n() { // from class: io.bidmachine.rendering.ad.fullscreen.FullScreenAd$$ExternalSyntheticLambda3
                @Override // io.bidmachine.util.SafeRunnable
                public final void onRun() {
                    FullScreenAd.g(FullScreenAd.this);
                }
            });
        }
    }

    public final void attachActivity(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        this.weakShowActivity = new WeakReference<>(activity);
    }

    public final void destroy() {
        this.adState.a();
        this.adView.destroy();
        a();
    }

    public final void detachActivity() {
        WeakReference<Activity> weakReference = this.weakShowActivity;
        if (weakReference != null) {
            weakReference.clear();
        }
        this.weakShowActivity = null;
    }

    public final Activity getAttachedActivity() {
        WeakReference<Activity> weakReference = this.weakShowActivity;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    public final FullScreenAdListener getFullScreenAdListener() {
        return this.fullScreenAdListener;
    }

    public final boolean isFinished() {
        return this.adState.g();
    }

    public final boolean isLoaded() {
        return this.adState.b();
    }

    public final void load() {
        if (this.adState.c()) {
            this.adView.setAdViewListener(new a());
            this.adView.load();
        }
    }

    public final void notifyAdFailToShow(final Error error) {
        Intrinsics.checkNotNullParameter(error, "error");
        UiUtils.onUiThread(new n() { // from class: io.bidmachine.rendering.ad.fullscreen.FullScreenAd$$ExternalSyntheticLambda10
            @Override // io.bidmachine.util.SafeRunnable
            public final void onRun() {
                FullScreenAd.b(FullScreenAd.this, error);
            }
        });
    }

    public final void processAdClosed() {
        a();
        d();
        f();
    }

    public final void setFullScreenAdListener(FullScreenAdListener fullScreenAdListener) {
        this.fullScreenAdListener = fullScreenAdListener;
    }

    public final void setWatermark(Drawable drawable) {
        this.adView.setWatermark(drawable);
    }

    public final void show(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (isLoaded()) {
            FullScreenActivityKt.startActivity(this, context);
        } else {
            notifyAdFailToShow(new Error("FullScreenAd not loaded"));
        }
    }

    public final void showInActivity(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        attachActivity(activity);
        io.bidmachine.rendering.utils.UiUtils.setupActivityOrientation(activity, this.adView.getRequiredOrientation());
        UiUtilsKt.applyFullscreenActivity$default(activity, false, 1, null);
        ViewUtilsKt.removeFromParent(this.adView);
        io.bidmachine.rendering.utils.UiUtils.applyInsets(activity, this.adView, false);
        activity.setContentView(this.adView, ViewUtils.createMatchParentParams());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(FullScreenAd this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        FullScreenAdListener fullScreenAdListener = this$0.fullScreenAdListener;
        if (fullScreenAdListener != null) {
            fullScreenAdListener.onAdClicked(this$0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void e() {
        if (this.adState.k()) {
            UiUtils.onUiThread(new n() { // from class: io.bidmachine.rendering.ad.fullscreen.FullScreenAd$$ExternalSyntheticLambda6
                @Override // io.bidmachine.util.SafeRunnable
                public final void onRun() {
                    FullScreenAd.d(FullScreenAd.this);
                }
            });
        }
    }

    private final void f() {
        if (this.adState.j()) {
            UiUtils.onUiThread(new n() { // from class: io.bidmachine.rendering.ad.fullscreen.FullScreenAd$$ExternalSyntheticLambda7
                @Override // io.bidmachine.util.SafeRunnable
                public final void onRun() {
                    FullScreenAd.e(FullScreenAd.this);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(final Error error) {
        if (this.adState.a(false)) {
            UiUtils.onUiThread(new n() { // from class: io.bidmachine.rendering.ad.fullscreen.FullScreenAd$$ExternalSyntheticLambda2
                @Override // io.bidmachine.util.SafeRunnable
                public final void onRun() {
                    FullScreenAd.a(FullScreenAd.this, error);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void b() {
        if (this.adState.b(true)) {
            UiUtils.onUiThread(new n() { // from class: io.bidmachine.rendering.ad.fullscreen.FullScreenAd$$ExternalSyntheticLambda5
                @Override // io.bidmachine.util.SafeRunnable
                public final void onRun() {
                    FullScreenAd.a(FullScreenAd.this);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(FullScreenAd this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        FullScreenAdListener fullScreenAdListener = this$0.fullScreenAdListener;
        if (fullScreenAdListener != null) {
            fullScreenAdListener.onAdDisappeared(this$0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(FullScreenAd this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        FullScreenAdListener fullScreenAdListener = this$0.fullScreenAdListener;
        if (fullScreenAdListener != null) {
            fullScreenAdListener.onAdExpired(this$0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(FullScreenAd this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        FullScreenAdListener fullScreenAdListener = this$0.fullScreenAdListener;
        if (fullScreenAdListener != null) {
            fullScreenAdListener.onAdShown(this$0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(FullScreenAd this$0, Error error) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(error, "$error");
        FullScreenAdListener fullScreenAdListener = this$0.fullScreenAdListener;
        if (fullScreenAdListener != null) {
            fullScreenAdListener.onAdFailToLoad(this$0, error);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(FullScreenAd this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        FullScreenAdListener fullScreenAdListener = this$0.fullScreenAdListener;
        if (fullScreenAdListener != null) {
            fullScreenAdListener.onAdAppeared(this$0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(final PrivacySheetParams privacySheetParams) {
        UiUtils.onUiThread(new n() { // from class: io.bidmachine.rendering.ad.fullscreen.FullScreenAd$$ExternalSyntheticLambda1
            @Override // io.bidmachine.util.SafeRunnable
            public final void onRun() {
                FullScreenAd.a(FullScreenAd.this, privacySheetParams);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(FullScreenAd this$0, PrivacySheetParams privacySheetParams) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(privacySheetParams, "$privacySheetParams");
        FullScreenAdListener fullScreenAdListener = this$0.fullScreenAdListener;
        if (fullScreenAdListener != null) {
            fullScreenAdListener.onOpenPrivacySheet(this$0, privacySheetParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(final BrokenCreativeEvent brokenCreativeEvent) {
        if (this.adState.h()) {
            return;
        }
        UiUtils.onUiThread(new n() { // from class: io.bidmachine.rendering.ad.fullscreen.FullScreenAd$$ExternalSyntheticLambda8
            @Override // io.bidmachine.util.SafeRunnable
            public final void onRun() {
                FullScreenAd.a(FullScreenAd.this, brokenCreativeEvent);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(FullScreenAd this$0, BrokenCreativeEvent brokenCreativeEvent) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(brokenCreativeEvent, "$brokenCreativeEvent");
        FullScreenAdListener fullScreenAdListener = this$0.fullScreenAdListener;
        if (fullScreenAdListener != null) {
            fullScreenAdListener.onBrokenCreativeEvent(this$0, brokenCreativeEvent);
        }
    }
}
