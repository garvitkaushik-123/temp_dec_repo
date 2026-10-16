package io.bidmachine;

import io.bidmachine.AdObjectImpl;
import io.bidmachine.FullScreenAdRequest;
import io.bidmachine.core.Logger;
import io.bidmachine.core.Utils;
import io.bidmachine.models.AdObjectParams;
import io.bidmachine.unified.UnifiedFullscreenAd;
import io.bidmachine.unified.UnifiedFullscreenAdCallback;
import io.bidmachine.unified.UnifiedFullscreenAdRequestParams;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes7.dex */
public final class FullScreenAdObject<AdRequestType extends FullScreenAdRequest<AdRequestType>> extends AdObjectImpl<AdRequestType, AdObjectParams, UnifiedFullscreenAd, UnifiedFullscreenAdCallback, UnifiedFullscreenAdRequestParams> {
    private final AtomicBoolean isShowing;
    private final ImpressionThresholdTask thresholdTask;

    public FullScreenAdObject(ContextProvider contextProvider, AdProcessCallback processCallback, AdRequestType adRequest, AdObjectParams adObjectParams, UnifiedFullscreenAd unifiedAd) {
        super(contextProvider, processCallback, adRequest, adObjectParams, unifiedAd);
        this.isShowing = new AtomicBoolean(false);
        this.thresholdTask = new ImpressionThresholdTask() { // from class: io.bidmachine.FullScreenAdObject.1
            @Override // io.bidmachine.FullScreenAdObject.ImpressionThresholdTask
            void onTracked() {
                FullScreenAdObject.this.getProcessCallback().processVisibilityTrackerImpression();
            }
        };
    }

    @Override // io.bidmachine.models.AdObject
    public UnifiedFullscreenAdCallback createUnifiedCallback(AdProcessCallback processCallback) {
        return new UnifiedFullscreenAdCallbackImpl(processCallback);
    }

    public void show(ContextProvider contextProvider, RendererConfiguration rendererConfiguration) throws Throwable {
        if (this.isShowing.get()) {
            Logger.d("Fullscreen ad already showing, please wait until the ad closes");
            return;
        }
        this.isShowing.set(true);
        getUnifiedAd().show(contextProvider, getUnifiedAdCallback(), rendererConfiguration);
        getProcessCallback().processFillAd();
    }

    @Override // io.bidmachine.AdObjectImpl, io.bidmachine.models.AdObject
    public void onShown() {
        super.onShown();
        startImpressionThresholdTask();
    }

    @Override // io.bidmachine.AdObjectImpl, io.bidmachine.models.AdObject
    public void onShowFailed() {
        this.isShowing.set(false);
        super.onShowFailed();
    }

    @Override // io.bidmachine.AdObjectImpl, io.bidmachine.models.AdObject
    public void onImpression() {
        super.onImpression();
        cancelImpressionThresholdTask();
    }

    @Override // io.bidmachine.AdObjectImpl, io.bidmachine.models.AdObject
    public void onClosed(boolean finished) {
        this.isShowing.set(false);
        super.onClosed(finished);
        cancelImpressionThresholdTask();
    }

    @Override // io.bidmachine.AdObjectImpl, io.bidmachine.models.AdObject
    public void onFinished() {
        super.onFinished();
        cancelImpressionThresholdTask();
    }

    private void startImpressionThresholdTask() {
        this.thresholdTask.start(getParams().getVisibilityParams().getTimeThresholdMs());
    }

    private void cancelImpressionThresholdTask() {
        this.thresholdTask.cancel();
    }

    private static abstract class ImpressionThresholdTask implements Runnable {
        abstract void onTracked();

        private ImpressionThresholdTask() {
        }

        void start(long threshold) {
            Utils.onBackgroundThread(this, threshold);
        }

        void cancel() {
            Utils.cancelBackgroundThreadTask(this);
        }

        @Override // java.lang.Runnable
        public void run() {
            onTracked();
        }
    }

    private static final class UnifiedFullscreenAdCallbackImpl extends AdObjectImpl.BaseUnifiedAdCallback implements UnifiedFullscreenAdCallback {
        UnifiedFullscreenAdCallbackImpl(AdProcessCallback processCallback) {
            super(processCallback);
        }

        @Override // io.bidmachine.unified.UnifiedFullscreenAdCallback
        public void onAdLoaded() {
            this.processCallback.processLoadSuccess();
        }

        @Override // io.bidmachine.unified.UnifiedFullscreenAdCallback
        public void onAdFinished() {
            this.processCallback.processFinished();
        }

        @Override // io.bidmachine.unified.UnifiedFullscreenAdCallback
        public void onAdClosed() {
            this.processCallback.processClosed();
        }
    }
}
