package io.bidmachine;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import io.bidmachine.AdObjectImpl;
import io.bidmachine.AdRequest;
import io.bidmachine.core.Logger;
import io.bidmachine.core.Utils;
import io.bidmachine.internal.utils.visibility.VisibilityTrackerHolder;
import io.bidmachine.internal.utils.visibility.VisibilityTrackerListener;
import io.bidmachine.models.AdObjectParams;
import io.bidmachine.unified.UnifiedAdRequestParams;
import io.bidmachine.unified.UnifiedBannerAdCallback;
import io.bidmachine.unified.UnifiedViewAd;
import io.bidmachine.utils.BMError;
import io.bidmachine.utils.ViewHelper;
import java.lang.ref.WeakReference;

/* loaded from: classes7.dex */
public final class ViewAdObject<AdRequestType extends AdRequest<AdRequestType, ?, UnifiedAdRequestParamsType>, UnifiedAdType extends UnifiedViewAd<UnifiedBannerAdCallback, UnifiedAdRequestParamsType>, UnifiedAdRequestParamsType extends UnifiedAdRequestParams> extends AdObjectImpl<AdRequestType, AdObjectParams, UnifiedAdType, UnifiedBannerAdCallback, UnifiedAdRequestParamsType> {
    private View adView;
    private int height;
    private MeasureMode heightMeasureMode;
    private final VisibilityTrackerHolder visibilityTrackerHolder;
    private int width;
    private MeasureMode widthMeasureMode;

    public ViewAdObject(ContextProvider contextProvider, AdProcessCallback processCallback, AdRequestType adRequest, AdObjectParams adObjectParams, UnifiedAdType unifiedAd) {
        super(contextProvider, processCallback, adRequest, adObjectParams, unifiedAd);
        this.widthMeasureMode = MeasureMode.Direct;
        this.heightMeasureMode = MeasureMode.Direct;
        this.visibilityTrackerHolder = new VisibilityTrackerHolder();
    }

    @Override // io.bidmachine.models.AdObject
    public UnifiedBannerAdCallback createUnifiedCallback(final AdProcessCallback processCallback) {
        return new UnifiedViewAdCallbackImpl(this, processCallback);
    }

    /* JADX WARN: Multi-variable type inference failed */
    void show(ViewGroup container, RendererConfiguration rendererConfiguration) {
        ViewGroup.LayoutParams layoutParams;
        if (container == null) {
            getUnifiedAdCallback().onAdShowFailed(BMError.notFound("Target container"));
            return;
        }
        View view = this.adView;
        if (view == null) {
            getUnifiedAdCallback().onAdShowFailed(BMError.internal("Ad view is null"));
            return;
        }
        if ((getWidthMeasureMode() == MeasureMode.Direct && getWidth() == 0) || (getHeightMeasureMode() == MeasureMode.Direct && getHeight() == 0)) {
            getUnifiedAdCallback().onAdShowFailed(BMError.incorrectContent("Width or height are not provided"));
            return;
        }
        Context context = container.getContext();
        if (container instanceof FrameLayout) {
            layoutParams = new FrameLayout.LayoutParams(getScaledWidth(context), getScaledHeight(context), 17);
        } else {
            layoutParams = new ViewGroup.LayoutParams(getScaledWidth(context), getScaledHeight(context));
        }
        getProcessCallback().processStartVisibilityTracker();
        this.visibilityTrackerHolder.startTracking(view, getParams().getVisibilityParams(), new VisibilityTrackerListener() { // from class: io.bidmachine.ViewAdObject.1
            @Override // io.bidmachine.internal.utils.visibility.VisibilityTrackerListener
            public boolean onViewShown() {
                return ViewAdObject.this.getProcessCallback().processVisibilityTrackerShown();
            }

            @Override // io.bidmachine.internal.utils.visibility.VisibilityTrackerListener
            public void onViewTrackingFinished() {
                ViewAdObject.this.getProcessCallback().processVisibilityTrackerImpression();
            }
        });
        ViewHelper.safeAddSingleView(container, view, layoutParams);
        getProcessCallback().processFillAd();
        try {
            ((UnifiedViewAd) getUnifiedAd()).prepareToShow(rendererConfiguration);
        } catch (Throwable th) {
            Logger.w(th);
        }
    }

    @Override // io.bidmachine.AdObjectImpl, io.bidmachine.models.AdObject
    public void onImpression() {
        super.onImpression();
        this.visibilityTrackerHolder.stopTracking();
    }

    @Override // io.bidmachine.AdObjectImpl, io.bidmachine.models.AdObject
    public void hide() {
        super.hide();
        this.visibilityTrackerHolder.stopTracking();
        View view = this.adView;
        if (view != null) {
            ViewHelper.removeViewFromParent(view);
        }
    }

    @Override // io.bidmachine.AdObjectImpl, io.bidmachine.models.AdObject
    public void onDestroy() {
        hide();
        super.onDestroy();
    }

    public MeasureMode getWidthMeasureMode() {
        return this.widthMeasureMode;
    }

    public void setWidthMeasureMode(MeasureMode widthMeasureMode) {
        this.widthMeasureMode = widthMeasureMode;
    }

    public MeasureMode getHeightMeasureMode() {
        return this.heightMeasureMode;
    }

    public void setHeightMeasureMode(MeasureMode heightMeasureMode) {
        this.heightMeasureMode = heightMeasureMode;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    private int getWidth() {
        return this.width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    private int getHeight() {
        return this.height;
    }

    private int getScaledWidth(Context context) {
        return this.widthMeasureMode.getSize(context, getWidth());
    }

    private int getScaledHeight(Context context) {
        return this.heightMeasureMode.getSize(context, getHeight());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAdView(View adView) {
        hide();
        this.adView = adView;
    }

    /* renamed from: io.bidmachine.ViewAdObject$2, reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$io$bidmachine$ViewAdObject$MeasureMode;

        static {
            int[] iArr = new int[MeasureMode.values().length];
            $SwitchMap$io$bidmachine$ViewAdObject$MeasureMode = iArr;
            try {
                iArr[MeasureMode.Direct.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$io$bidmachine$ViewAdObject$MeasureMode[MeasureMode.Wrap.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public enum MeasureMode {
        Match,
        Wrap,
        Direct;

        int getSize(Context context, int directSize) {
            int i = AnonymousClass2.$SwitchMap$io$bidmachine$ViewAdObject$MeasureMode[ordinal()];
            if (i != 1) {
                return i != 2 ? -1 : -2;
            }
            return Math.round(directSize * Utils.getScreenDensity(context));
        }
    }

    private static final class UnifiedViewAdCallbackImpl extends AdObjectImpl.BaseUnifiedAdCallback implements UnifiedBannerAdCallback {
        private final WeakReference<ViewAdObject<?, ?, ?>> weakAdObject;

        UnifiedViewAdCallbackImpl(ViewAdObject<?, ?, ?> viewAdObject, AdProcessCallback processCallback) {
            super(processCallback);
            this.weakAdObject = new WeakReference<>(viewAdObject);
        }

        @Override // io.bidmachine.unified.UnifiedBannerAdCallback
        public void onAdLoaded(View adView) {
            ViewAdObject<?, ?, ?> viewAdObject = this.weakAdObject.get();
            if (viewAdObject != null) {
                viewAdObject.setAdView(adView);
                this.processCallback.processLoadSuccess();
            } else {
                this.processCallback.processLoadFail(BMError.internal("ViewAdObject is null"));
            }
        }
    }
}
