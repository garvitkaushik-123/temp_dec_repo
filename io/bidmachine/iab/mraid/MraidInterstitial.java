package io.bidmachine.iab.mraid;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.view.ViewGroup;
import io.bidmachine.iab.CacheControl;
import io.bidmachine.iab.IabError;
import io.bidmachine.iab.measurer.MraidAdMeasurer;
import io.bidmachine.iab.mraid.MraidView;
import io.bidmachine.iab.utils.IabClickCallback;
import io.bidmachine.iab.utils.IabElementStyle;
import io.bidmachine.iab.utils.Utils;
import io.bidmachine.rendering.model.PrivacySheetParams;
import io.bidmachine.util.UiUtils;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes7.dex */
public class MraidInterstitial {
    private static final AtomicInteger j = new AtomicInteger(0);
    static final /* synthetic */ boolean k = true;
    MraidView c;
    private MraidInterstitialListener d;
    public final int id = j.getAndIncrement();
    private boolean e = false;
    private boolean f = false;
    private boolean g = false;
    private boolean h = true;
    private boolean i = false;

    /* renamed from: a, reason: collision with root package name */
    private final AtomicBoolean f6809a = new AtomicBoolean(false);
    final MraidViewListener b = new b();

    public class Builder {

        /* renamed from: a, reason: collision with root package name */
        private final MraidView.Builder f6810a = new MraidView.Builder(MraidPlacementType.INTERSTITIAL);

        public Builder() {
        }

        public MraidInterstitial build(Context context) {
            this.f6810a.setListener(MraidInterstitial.this.b);
            MraidInterstitial.this.c = this.f6810a.build(context);
            return MraidInterstitial.this;
        }

        public Builder forceUseNativeCloseButton(boolean forceUseNativeCloseButton) {
            this.f6810a.forceUseNativeCloseButton(forceUseNativeCloseButton);
            return this;
        }

        public Builder setAdMeasurer(MraidAdMeasurer mraidAdMeasurer) {
            this.f6810a.setAdMeasurer(mraidAdMeasurer);
            return this;
        }

        public Builder setAllowedNativeFeatures(String[] allowedNativeFeatures) {
            this.f6810a.setAllowedNativeFeatures(allowedNativeFeatures);
            return this;
        }

        public Builder setBaseUrl(String baseUrl) {
            this.f6810a.setBaseUrl(baseUrl);
            return this;
        }

        public Builder setCacheControl(CacheControl cacheControl) {
            this.f6810a.setCacheControl(cacheControl);
            return this;
        }

        public Builder setCloseStyle(IabElementStyle closeStyle) {
            this.f6810a.setCloseStyle(closeStyle);
            return this;
        }

        public Builder setCloseTime(float closeTime) {
            this.f6810a.setCloseTimeSec(closeTime);
            return this;
        }

        public Builder setCountDownStyle(IabElementStyle countDownStyle) {
            this.f6810a.setCountDownStyle(countDownStyle);
            return this;
        }

        public Builder setDurationSec(float durationSec) {
            this.f6810a.setDurationSec(durationSec);
            return this;
        }

        public Builder setIsTag(boolean isTag) {
            this.f6810a.setIsTag(isTag);
            return this;
        }

        public Builder setListener(MraidInterstitialListener listener) {
            MraidInterstitial.this.d = listener;
            return this;
        }

        public Builder setLoadingStyle(IabElementStyle loadingStyle) {
            this.f6810a.setLoadingStyle(loadingStyle);
            return this;
        }

        public Builder setPageFinishedScript(String pageFinishedScript) {
            this.f6810a.setPageFinishedScript(pageFinishedScript);
            return this;
        }

        public Builder setPlaceholderTimeoutSec(float placeholderTimeoutSec) {
            this.f6810a.setPlaceholderTimeoutSec(placeholderTimeoutSec);
            return this;
        }

        public Builder setProductLink(String productLink) {
            this.f6810a.setProductLink(productLink);
            return this;
        }

        public Builder setProgressStyle(IabElementStyle progressStyle) {
            this.f6810a.setProgressStyle(progressStyle);
            return this;
        }

        public Builder setR1(boolean r1) {
            this.f6810a.setR1(r1);
            return this;
        }

        public Builder setR2(boolean r2) {
            this.f6810a.setR2(r2);
            return this;
        }
    }

    private class b implements MraidViewListener {
        private b() {
        }

        @Override // io.bidmachine.iab.mraid.MraidViewListener
        public void onCalendarEvent(MraidView mraidView, String url, IabClickCallback iabClickCallback) {
            MraidLog.d("MraidInterstitial", "ViewListener - onCalendarEvent (%s)", url);
            if (MraidInterstitial.this.d != null) {
                MraidInterstitial.this.d.onCalendarEvent(MraidInterstitial.this, url, iabClickCallback);
            }
        }

        @Override // io.bidmachine.iab.mraid.MraidViewListener
        public void onClose(MraidView mraidView) {
            MraidLog.d("MraidInterstitial", "ViewListener - onClose", new Object[0]);
            MraidInterstitial.this.a();
            MraidInterstitial.this.b();
        }

        @Override // io.bidmachine.iab.mraid.MraidViewListener
        public void onExpand(MraidView mraidView) {
        }

        @Override // io.bidmachine.iab.mraid.MraidViewListener
        public void onExpired(MraidView mraidView, IabError iabError) {
            MraidLog.d("MraidInterstitial", "ViewListener - onExpired (%s)", iabError);
            if (MraidInterstitial.this.d != null) {
                MraidInterstitial.this.d.onExpired(MraidInterstitial.this, iabError);
            }
        }

        @Override // io.bidmachine.iab.mraid.MraidViewListener
        public void onLoadFailed(MraidView mraidView, IabError iabError) {
            MraidLog.d("MraidInterstitial", "ViewListener - onLoadFailed (%s)", iabError);
            MraidInterstitial.this.a();
            MraidInterstitial.this.a(iabError);
        }

        @Override // io.bidmachine.iab.mraid.MraidViewListener
        public void onLoaded(MraidView mraidView) {
            MraidLog.d("MraidInterstitial", "ViewListener - onLoaded", new Object[0]);
            MraidInterstitial.this.c();
        }

        @Override // io.bidmachine.iab.mraid.MraidViewListener
        public void onOpenPrivacySheet(MraidView mraidView, PrivacySheetParams privacySheetParams) {
            MraidLog.d("MraidInterstitial", "ViewListener - onOpenPrivacySheet (%s)", privacySheetParams.toString());
            if (MraidInterstitial.this.d != null) {
                MraidInterstitial.this.d.onOpenPrivacySheet(MraidInterstitial.this, privacySheetParams);
            }
        }

        @Override // io.bidmachine.iab.mraid.MraidViewListener
        public void onOpenUrl(MraidView mraidView, String url, IabClickCallback iabClickCallback) {
            MraidLog.d("MraidInterstitial", "ViewListener - onOpenBrowser (%s)", url);
            if (MraidInterstitial.this.d != null) {
                MraidInterstitial.this.d.onOpenUrl(MraidInterstitial.this, url, iabClickCallback);
            }
        }

        @Override // io.bidmachine.iab.mraid.MraidViewListener
        public void onPlayVideo(MraidView mraidView, String url) {
            MraidLog.d("MraidInterstitial", "ViewListener - onPlayVideo (%s)", url);
            if (MraidInterstitial.this.d != null) {
                MraidInterstitial.this.d.onPlayVideo(MraidInterstitial.this, url);
            }
        }

        @Override // io.bidmachine.iab.mraid.MraidViewListener
        public void onShowFailed(MraidView mraidView, IabError iabError) {
            MraidLog.d("MraidInterstitial", "ViewListener - onShowFailed (%s)", iabError);
            MraidInterstitial.this.a();
            MraidInterstitial.this.b(iabError);
        }

        @Override // io.bidmachine.iab.mraid.MraidViewListener
        public void onShown(MraidView mraidView) {
            MraidLog.d("MraidInterstitial", "ViewListener - onShown", new Object[0]);
            MraidInterstitial.this.d();
        }

        @Override // io.bidmachine.iab.mraid.MraidViewListener
        public void onStorePicture(MraidView mraidView, String url, IabClickCallback iabClickCallback) {
            MraidLog.d("MraidInterstitial", "ViewListener - onCalendarEvent (%s)", url);
            if (MraidInterstitial.this.d != null) {
                MraidInterstitial.this.d.onStorePicture(MraidInterstitial.this, url, iabClickCallback);
            }
        }
    }

    private MraidInterstitial() {
    }

    public static Builder newBuilder() {
        return new MraidInterstitial().new Builder();
    }

    void c() {
        this.e = true;
        MraidInterstitialListener mraidInterstitialListener = this.d;
        if (mraidInterstitialListener != null) {
            mraidInterstitialListener.onLoaded(this);
        }
    }

    public boolean canBeClosed() {
        MraidView mraidView = this.c;
        return mraidView == null || mraidView.canBeClosed() || isReceivedError();
    }

    void d() {
        this.f6809a.set(true);
        MraidInterstitialListener mraidInterstitialListener = this.d;
        if (mraidInterstitialListener != null) {
            mraidInterstitialListener.onShown(this);
        }
    }

    public void destroy() {
        MraidLog.d("MraidInterstitial", "destroy", new Object[0]);
        this.e = false;
        this.d = null;
        MraidView mraidView = this.c;
        if (mraidView != null) {
            mraidView.destroy();
            this.c = null;
        }
    }

    public void dispatchClose() {
        if (this.c == null || !canBeClosed()) {
            return;
        }
        this.c.f();
    }

    public boolean isClosed() {
        return this.f;
    }

    public boolean isReady() {
        return this.e && this.c != null;
    }

    public boolean isReceivedError() {
        return this.g;
    }

    public boolean isShown() {
        return this.f6809a.get();
    }

    public void load(String data) {
        MraidView mraidView = this.c;
        if (mraidView == null) {
            throw new IllegalStateException("MraidView not created (mraidView == null)");
        }
        mraidView.load(data);
    }

    public Context peekContext() {
        MraidView mraidView = this.c;
        if (mraidView == null) {
            return null;
        }
        return mraidView.peekContext();
    }

    public void show(Context context, MraidType mraidType) {
        MraidActivity.show(context, this, mraidType);
    }

    public void showInView(ViewGroup parent, boolean destroyOnClose) {
        a(null, parent, false, destroyOnClose);
    }

    void b(IabError iabError) {
        this.e = false;
        this.g = true;
        c(iabError);
    }

    void a(Activity activity, boolean destroyOnClose) {
        a(activity, (ViewGroup) activity.findViewById(R.id.content), true, destroyOnClose);
    }

    void a(Activity activity, ViewGroup parent, boolean finishActivityDuringClose, boolean destroyOnClose) {
        if (!isReady()) {
            if (activity != null && finishActivityDuringClose) {
                UiUtils.finishActivityWithoutAnimation(activity);
            }
            c(IabError.incorrectState("Interstitial is not ready"));
            MraidLog.w("MraidInterstitial", "Show failed: interstitial is not ready", new Object[0]);
            return;
        }
        if (!k && this.c == null) {
            throw new AssertionError();
        }
        this.h = destroyOnClose;
        this.i = finishActivityDuringClose;
        Utils.removeFromParent(this.c);
        parent.addView(this.c, new ViewGroup.LayoutParams(-1, -1));
        this.c.show(activity);
    }

    void c(IabError iabError) {
        MraidInterstitialListener mraidInterstitialListener = this.d;
        if (mraidInterstitialListener != null) {
            mraidInterstitialListener.onShowFailed(this, iabError);
        }
    }

    void b() {
        if (isClosed()) {
            return;
        }
        this.f = true;
        MraidInterstitialListener mraidInterstitialListener = this.d;
        if (mraidInterstitialListener != null) {
            mraidInterstitialListener.onClose(this);
        }
        if (this.h) {
            destroy();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        MraidView mraidView;
        Activity peekActivity;
        if (!this.i || (mraidView = this.c) == null || (peekActivity = mraidView.peekActivity()) == null) {
            return;
        }
        UiUtils.finishActivityWithoutAnimation(peekActivity);
    }

    void a(IabError iabError) {
        this.e = false;
        this.g = true;
        MraidInterstitialListener mraidInterstitialListener = this.d;
        if (mraidInterstitialListener != null) {
            mraidInterstitialListener.onLoadFailed(this, iabError);
        }
    }
}
