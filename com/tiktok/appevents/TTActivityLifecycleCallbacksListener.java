package com.tiktok.appevents;

import androidx.lifecycle.LifecycleOwner;
import com.tiktok.TikTokBusinessSdk;
import com.tiktok.iap.TTInAppPurchaseWrapper;
import com.tiktok.util.TTLogger;
import com.tiktok.util.TTUtil;

/* loaded from: classes6.dex */
class TTActivityLifecycleCallbacksListener extends TTLifeCycleCallbacksAdapter {
    private static final String TAG = "com.tiktok.appevents.TTActivityLifecycleCallbacksListener";
    private static final TTLogger logger = new TTLogger(TTActivityLifecycleCallbacksListener.class.getCanonicalName(), TikTokBusinessSdk.getLogLevel());
    private final TTAppEventLogger appEventLogger;
    private boolean isPaused = false;
    private long bgStart = 0;
    private long fgStart = System.currentTimeMillis();

    public TTActivityLifecycleCallbacksListener(TTAppEventLogger appEventLogger) {
        this.appEventLogger = appEventLogger;
    }

    @Override // com.tiktok.appevents.TTLifeCycleCallbacksAdapter, androidx.lifecycle.DefaultLifecycleObserver
    public void onResume(LifecycleOwner owner) {
        if (this.isPaused) {
            reportBackground(this.bgStart);
            this.fgStart = System.currentTimeMillis();
            this.appEventLogger.fetchGlobalConfig(0);
            this.appEventLogger.restartScheduler();
            this.appEventLogger.autoEventsManager.track2DayRetentionEvent();
        }
    }

    @Override // com.tiktok.appevents.TTLifeCycleCallbacksAdapter, androidx.lifecycle.DefaultLifecycleObserver
    public void onPause(LifecycleOwner owner) {
        reportForeground(this.fgStart);
        this.bgStart = System.currentTimeMillis();
        this.appEventLogger.stopScheduler();
        this.isPaused = true;
        if (TikTokBusinessSdk.enableAutoIapTrack()) {
            TTInAppPurchaseWrapper.startBillingClient();
        }
    }

    @Override // com.tiktok.appevents.TTLifeCycleCallbacksAdapter, androidx.lifecycle.DefaultLifecycleObserver
    public void onStop(LifecycleOwner owner) {
        this.appEventLogger.persistEvents();
        this.appEventLogger.persistMonitor();
    }

    @Override // com.tiktok.appevents.TTLifeCycleCallbacksAdapter, androidx.lifecycle.DefaultLifecycleObserver
    public void onDestroy(LifecycleOwner owner) {
        this.appEventLogger.stopScheduler();
    }

    private void reportForeground(long ts) {
        try {
            this.appEventLogger.monitorMetric("foreground", TTUtil.getMetaWithTS(Long.valueOf(ts)).put("latency", System.currentTimeMillis() - ts), null);
        } catch (Exception unused) {
        }
    }

    private void reportBackground(long ts) {
        try {
            this.appEventLogger.monitorMetric("background", TTUtil.getMetaWithTS(Long.valueOf(ts)).put("latency", System.currentTimeMillis() - ts), null);
        } catch (Exception unused) {
        }
    }
}
