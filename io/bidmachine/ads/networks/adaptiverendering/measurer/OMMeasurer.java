package io.bidmachine.ads.networks.adaptiverendering.measurer;

import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import com.iab.omid.library.appodeal.adsession.AdEvents;
import com.iab.omid.library.appodeal.adsession.AdSession;
import com.iab.omid.library.appodeal.adsession.AdSessionConfiguration;
import com.iab.omid.library.appodeal.adsession.AdSessionContext;
import com.iab.omid.library.appodeal.adsession.ErrorType;
import com.iab.omid.library.appodeal.adsession.media.InteractionType;
import com.iab.omid.library.appodeal.adsession.media.MediaEvents;
import com.ironsource.C3355vf;
import io.bidmachine.core.Logger;
import io.bidmachine.core.Utils;
import io.bidmachine.rendering.measurer.Measurer;
import io.bidmachine.rendering.model.Error;
import io.bidmachine.utils.Tag;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes7.dex */
public abstract class OMMeasurer<AdView extends View> implements Measurer<AdView> {
    private AdEvents adEvents;
    private AdSession adSession;
    protected MediaEvents mediaEvents;
    private final Tag tag = new Tag("OMMeasurer");
    private final AtomicBoolean isLoadedTracked = new AtomicBoolean(false);
    private final AtomicBoolean isShownTracked = new AtomicBoolean(false);

    protected long getDestroyDelayMs() {
        return 0L;
    }

    protected abstract void onAdLoaded(AdEvents adEvents) throws Throwable;

    @Override // io.bidmachine.rendering.measurer.Measurer
    public void onViewAddedToContainer(AdView adView, ViewGroup viewGroup) {
    }

    @Override // io.bidmachine.rendering.measurer.Measurer
    public void onViewCreated(AdView adView) {
    }

    @Override // io.bidmachine.rendering.measurer.Measurer
    public void onViewReady(AdView adView) {
    }

    @Override // io.bidmachine.rendering.measurer.Measurer
    public void onShown() {
        if (this.isShownTracked.compareAndSet(false, true)) {
            Utils.onUiThread(new Runnable() { // from class: io.bidmachine.ads.networks.adaptiverendering.measurer.OMMeasurer.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        if (!OMMeasurer.this.isSessionPrepared() || OMMeasurer.this.adEvents == null) {
                            return;
                        }
                        OMMeasurer.this.adEvents.impressionOccurred();
                        OMMeasurer.this.log("onAdShown");
                    } catch (Throwable th) {
                        Logger.w(th);
                    }
                }
            });
        }
    }

    @Override // io.bidmachine.rendering.measurer.Measurer
    public void onClicked() {
        Utils.onUiThread(new Runnable() { // from class: io.bidmachine.ads.networks.adaptiverendering.measurer.OMMeasurer.2
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (OMMeasurer.this.mediaEvents != null) {
                        OMMeasurer.this.mediaEvents.adUserInteraction(InteractionType.CLICK);
                        OMMeasurer.this.log(C3355vf.f);
                    }
                } catch (Throwable th) {
                    Logger.w(th);
                }
            }
        });
    }

    @Override // io.bidmachine.rendering.measurer.Measurer
    public void onError(Error error) {
        trackError(error.getCom.bytedance.sdk.component.pglcrypt.PglCryptUtils.KEY_MESSAGE java.lang.String());
    }

    @Override // io.bidmachine.rendering.measurer.Measurer
    public void destroy(final Runnable postback) {
        final Handler createHandlerWithMyOrMainLooper = Utils.createHandlerWithMyOrMainLooper();
        Utils.onUiThread(new Runnable() { // from class: io.bidmachine.ads.networks.adaptiverendering.measurer.OMMeasurer.3
            @Override // java.lang.Runnable
            public void run() {
                try {
                    OMMeasurer.this.mediaEvents = null;
                    OMMeasurer.this.adEvents = null;
                    if (OMMeasurer.this.adSession != null) {
                        OMMeasurer.this.adSession.finish();
                    }
                    OMMeasurer.this.log("destroy");
                    Runnable runnable = postback;
                    if (runnable != null) {
                        createHandlerWithMyOrMainLooper.postDelayed(runnable, OMMeasurer.this.getDestroyDelayMs());
                    }
                } catch (Throwable th) {
                    Logger.w(th);
                }
            }
        });
    }

    protected void trackLoaded() {
        if (this.isLoadedTracked.compareAndSet(false, true)) {
            Utils.onUiThread(new Runnable() { // from class: io.bidmachine.ads.networks.adaptiverendering.measurer.OMMeasurer.4
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        if (!OMMeasurer.this.isSessionPrepared() || OMMeasurer.this.adEvents == null) {
                            return;
                        }
                        OMMeasurer oMMeasurer = OMMeasurer.this;
                        oMMeasurer.onAdLoaded(oMMeasurer.adEvents);
                        OMMeasurer.this.log(C3355vf.j);
                    } catch (Throwable th) {
                        Logger.w(th);
                    }
                }
            });
        }
    }

    public void trackError(String errorMessage) {
        trackError(ErrorType.GENERIC, errorMessage);
    }

    public void trackVideoError(String errorMessage) {
        trackError(ErrorType.VIDEO, errorMessage);
    }

    private void trackError(final ErrorType errorType, final String errorMessage) {
        Utils.onUiThread(new Runnable() { // from class: io.bidmachine.ads.networks.adaptiverendering.measurer.OMMeasurer.5
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (OMMeasurer.this.adSession != null) {
                        OMMeasurer.this.adSession.error(errorType, errorMessage);
                        OMMeasurer.this.log("error");
                    }
                } catch (Throwable th) {
                    Logger.w(th);
                }
            }
        });
    }

    protected boolean isSessionPrepared() {
        return this.adSession != null;
    }

    protected void log(String message) {
        Logger.d(this.tag, message);
    }

    protected void prepareAdSession(AdSessionConfiguration adSessionConfiguration, AdSessionContext adSessionContext) {
        try {
            AdSession createAdSession = AdSession.createAdSession(adSessionConfiguration, adSessionContext);
            this.adSession = createAdSession;
            this.adEvents = AdEvents.createAdEvents(createAdSession);
            if (adSessionConfiguration.isNativeMediaEventsOwner()) {
                this.mediaEvents = MediaEvents.createMediaEvents(this.adSession);
            }
            this.adSession.start();
            log("prepareAdSession");
        } catch (Throwable th) {
            Logger.w(th);
        }
    }

    protected void registerView(final View view) {
        Utils.onUiThread(new Runnable() { // from class: io.bidmachine.ads.networks.adaptiverendering.measurer.OMMeasurer.6
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (OMMeasurer.this.adSession != null) {
                        OMMeasurer.this.adSession.registerAdView(view);
                        OMMeasurer.this.log("registerView");
                    }
                } catch (Throwable th) {
                    Logger.w(th);
                }
            }
        });
    }
}
