package io.bidmachine.measurer;

import android.os.Handler;
import android.webkit.WebView;
import com.iab.omid.library.appodeal.ScriptInjector;
import com.iab.omid.library.appodeal.adsession.AdEvents;
import com.iab.omid.library.appodeal.adsession.AdSessionConfiguration;
import com.iab.omid.library.appodeal.adsession.AdSessionContext;
import com.iab.omid.library.appodeal.adsession.CreativeType;
import com.iab.omid.library.appodeal.adsession.ImpressionType;
import com.iab.omid.library.appodeal.adsession.Owner;
import com.iab.omid.library.appodeal.adsession.Partner;
import com.ironsource.C3355vf;
import io.bidmachine.core.Logger;
import io.bidmachine.core.Utils;
import io.bidmachine.iab.measurer.MraidAdMeasurer;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes7.dex */
public class MraidOMSDKAdMeasurer extends OMSDKAdMeasurer<WebView> implements MraidAdMeasurer {
    private static final long DESTROY_DELAY = 1000;
    private final AtomicBoolean isCreativePrepared;

    public MraidOMSDKAdMeasurer() {
        this(false);
    }

    public MraidOMSDKAdMeasurer(boolean isTrackShowOutside) {
        super(isTrackShowOutside);
        this.isCreativePrepared = new AtomicBoolean(false);
    }

    @Override // io.bidmachine.iab.measurer.MraidAdMeasurer
    public String prepareCreativeForMeasure(String html) {
        if (!this.isCreativePrepared.compareAndSet(false, true)) {
            return html;
        }
        try {
            return ScriptInjector.injectScriptContentIntoHtml(OMSDKSettings.OM_JS, html);
        } catch (Throwable th) {
            Logger.w(th);
            return html;
        }
    }

    @Override // io.bidmachine.measurer.OMSDKAdMeasurer, io.bidmachine.iab.measurer.AdMeasurer
    public void onAdViewReady(WebView webView) {
        startAdSession(webView);
    }

    protected void startAdSession(final WebView webView) {
        Utils.onUiThread(new Runnable() { // from class: io.bidmachine.measurer.MraidOMSDKAdMeasurer.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Partner partner = OMSDKSettings.getPartner();
                    if (partner != null && !MraidOMSDKAdMeasurer.this.isSessionPrepared()) {
                        MraidOMSDKAdMeasurer.this.prepareAdSession(AdSessionConfiguration.createAdSessionConfiguration(CreativeType.HTML_DISPLAY, ImpressionType.BEGIN_TO_RENDER, Owner.NATIVE, Owner.NATIVE, false), AdSessionContext.createHtmlAdSessionContext(partner, webView, "", ""));
                    }
                } catch (Throwable th) {
                    Logger.w(th);
                }
            }
        });
    }

    @Override // io.bidmachine.measurer.OMSDKAdMeasurer
    protected void onAdLoaded(AdEvents adEvents) throws Throwable {
        adEvents.loaded();
        log(C3355vf.j);
    }

    public void destroy(final Runnable postBack) {
        final Handler createHandlerWithMyOrMainLooper = Utils.createHandlerWithMyOrMainLooper();
        Utils.onUiThread(new Runnable() { // from class: io.bidmachine.measurer.MraidOMSDKAdMeasurer.2
            @Override // java.lang.Runnable
            public void run() {
                MraidOMSDKAdMeasurer.this.destroy();
                Runnable runnable = postBack;
                if (runnable != null) {
                    createHandlerWithMyOrMainLooper.postDelayed(runnable, 1000L);
                }
            }
        });
    }
}
