package com.tiktok.appevents;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.ProcessLifecycleOwner;
import com.adjust.sdk.Constants;
import com.ironsource.C3040d4;
import com.tiktok.TikTokBusinessSdk;
import com.tiktok.appevents.TTAppEvent;
import com.tiktok.appevents.contents.TTContentsEventConstants;
import com.tiktok.util.SystemInfoUtil;
import com.tiktok.util.TTConst;
import com.tiktok.util.TTLogger;
import com.tiktok.util.TTUtil;
import io.ktor.http.ContentDisposition;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes6.dex */
public class TTAppEventLogger {
    public static final String NETWORK_IS_TURNED_OFF = "SDK can't send tracking events to server, it will be cached locally, and will be sent in batches only after startTracking";
    static final String SKIP_FLUSHING_BECAUSE_GLOBAL_CONFIG_IS_NOT_FETCHED = "Skip flushing because global config is not fetched";
    static final String SKIP_FLUSHING_BECAUSE_GLOBAL_SWITCH_IS_TURNED_OFF = "Skip flushing because global switch is turned off";
    static final String TAG = "com.tiktok.appevents.TTAppEventLogger";
    static final int THRESHOLD = 100;
    private static int TIME_BUFFER = 0;
    public static boolean autoTrackPaymentEnable = true;
    public static boolean autoTrackRetentionEnable = true;
    static int totalDumped;
    final TTAutoEventsManager autoEventsManager;
    int counter;
    final List<TTConst.AutoEvents> disabledEvents;
    Lifecycle lifecycle;
    final boolean lifecycleTrackEnable;
    static ScheduledExecutorService eventLoop = Executors.newSingleThreadScheduledExecutor(new TTThreadFactory());
    static ScheduledExecutorService timerService = Executors.newSingleThreadScheduledExecutor(new TTThreadFactory());
    static boolean metricsEnabled = true;
    int flushId = 0;
    ScheduledFuture<?> future = null;
    ScheduledFuture<?> timeFuture = null;
    private final Runnable batchFlush = new Runnable() { // from class: com.tiktok.appevents.TTAppEventLogger$$ExternalSyntheticLambda8
        @Override // java.lang.Runnable
        public final void run() {
            TTAppEventLogger.this.m9164lambda$new$0$comtiktokappeventsTTAppEventLogger();
        }
    };
    TTLogger logger = new TTLogger(TAG, TikTokBusinessSdk.getLogLevel());

    public enum FlushReason {
        THRESHOLD,
        TIMER,
        START_UP,
        FORCE_FLUSH,
        IDENTIFY,
        LOGOUT
    }

    /* renamed from: lambda$new$0$com-tiktok-appevents-TTAppEventLogger, reason: not valid java name */
    /* synthetic */ void m9164lambda$new$0$comtiktokappeventsTTAppEventLogger() {
        m9163lambda$flushWithReason$6$comtiktokappeventsTTAppEventLogger(FlushReason.TIMER);
    }

    public static List<TTAppEvent> getSuccessfulEvents() {
        return TTRequest.getSuccessfullySentRequests();
    }

    public TTAppEventLogger(boolean lifecycleTrackEnable, List<TTConst.AutoEvents> disabledEvents, int flushTime, boolean monitorDisable) {
        this.lifecycleTrackEnable = lifecycleTrackEnable;
        this.disabledEvents = disabledEvents;
        TIME_BUFFER = flushTime;
        this.counter = flushTime;
        this.lifecycle = ProcessLifecycleOwner.get().getLifecycle();
        if (monitorDisable) {
            metricsEnabled = false;
        }
        final TTActivityLifecycleCallbacksListener tTActivityLifecycleCallbacksListener = new TTActivityLifecycleCallbacksListener(this);
        try {
            if (Looper.myLooper() == Looper.getMainLooper()) {
                this.lifecycle.addObserver(tTActivityLifecycleCallbacksListener);
            } else {
                new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.tiktok.appevents.TTAppEventLogger.1
                    @Override // java.lang.Runnable
                    public void run() {
                        TTAppEventLogger.this.lifecycle.addObserver(tTActivityLifecycleCallbacksListener);
                    }
                });
            }
        } catch (Throwable unused) {
        }
        this.autoEventsManager = new TTAutoEventsManager(this);
    }

    public void initConfig(long initTimeMS, final TikTokBusinessSdk.TTInitCallback callback, final AtomicBoolean sdkInitialized) {
        addToQ(new Runnable() { // from class: com.tiktok.appevents.TTAppEventLogger$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                SystemInfoUtil.initUserAgent();
            }
        });
        addToQ(new Runnable() { // from class: com.tiktok.appevents.TTAppEventLogger$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() {
                TTAppEventsQueue.clearAll();
            }
        });
        addToQ(new Runnable() { // from class: com.tiktok.appevents.TTAppEventLogger$$ExternalSyntheticLambda4
            @Override // java.lang.Runnable
            public final void run() {
                TTAppEventLogger.lambda$initConfig$1(TikTokBusinessSdk.TTInitCallback.this, sdkInitialized);
            }
        });
        addToQ(new TTAppEventLogger$$ExternalSyntheticLambda1());
        fetchGlobalConfig(0);
        monitorMetric("init_start", TTUtil.getMetaWithTS(Long.valueOf(initTimeMS)), null);
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0021, code lost:
    
        r1.fail(-2, com.tiktok.util.TTConst.ERROR_MESSAGE_INVALID_ID);
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0027, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    static /* synthetic */ void lambda$initConfig$1(final TikTokBusinessSdk.TTInitCallback callback, final AtomicBoolean sdkInitialized) {
        try {
            if (!TextUtils.isEmpty(TikTokBusinessSdk.getTTAppId()) && !TextUtils.isEmpty(TikTokBusinessSdk.getAppId())) {
                sdkInitialized.set(true);
                if (callback != null) {
                    callback.success();
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    void persistEvents() {
        addToQ(new Runnable() { // from class: com.tiktok.appevents.TTAppEventLogger$$ExternalSyntheticLambda13
            @Override // java.lang.Runnable
            public final void run() {
                TTAppEventStorage.persist(null);
            }
        });
    }

    public void trackPurchase(final List<TTPurchaseInfo> purchaseInfos) {
        if (!TikTokBusinessSdk.isSystemActivated()) {
            this.logger.info("Global switch is off, ignore track purchase", new Object[0]);
        } else {
            addToQ(new Runnable() { // from class: com.tiktok.appevents.TTAppEventLogger$$ExternalSyntheticLambda5
                @Override // java.lang.Runnable
                public final void run() {
                    TTAppEventLogger.this.m9166lambda$trackPurchase$3$comtiktokappeventsTTAppEventLogger(purchaseInfos);
                }
            });
        }
    }

    /* renamed from: lambda$trackPurchase$3$com-tiktok-appevents-TTAppEventLogger, reason: not valid java name */
    /* synthetic */ void m9166lambda$trackPurchase$3$comtiktokappeventsTTAppEventLogger(final List purchaseInfos) {
        if (purchaseInfos.isEmpty()) {
            return;
        }
        Iterator it = purchaseInfos.iterator();
        while (it.hasNext()) {
            TTPurchaseInfo tTPurchaseInfo = (TTPurchaseInfo) it.next();
            JSONObject purchaseProps = TTInAppPurchaseManager.getPurchaseProps(tTPurchaseInfo);
            if (purchaseProps != null) {
                track(TTContentsEventConstants.ContentsEventName.EVENT_NAME_PURCHASE, purchaseProps, tTPurchaseInfo.getEventId());
            }
        }
    }

    void startScheduler() {
        int i = TIME_BUFFER;
        if (i != 0) {
            doStartScheduler(i, false);
        }
    }

    void restartScheduler() {
        int i = TIME_BUFFER;
        if (i != 0) {
            doStartScheduler(i, true);
        }
    }

    private void doStartScheduler(final int interval, boolean immediate) {
        if (this.future == null) {
            this.future = eventLoop.scheduleAtFixedRate(this.batchFlush, immediate ? 0L : interval, interval, TimeUnit.SECONDS);
        }
        if (this.timeFuture != null || TikTokBusinessSdk.nextTimeFlushListener == null) {
            return;
        }
        this.counter = interval;
        this.timeFuture = timerService.scheduleAtFixedRate(new Runnable() { // from class: com.tiktok.appevents.TTAppEventLogger$$ExternalSyntheticLambda7
            @Override // java.lang.Runnable
            public final void run() {
                TTAppEventLogger.this.m9161lambda$doStartScheduler$4$comtiktokappeventsTTAppEventLogger(interval);
            }
        }, 0L, 1L, TimeUnit.SECONDS);
    }

    /* renamed from: lambda$doStartScheduler$4$com-tiktok-appevents-TTAppEventLogger, reason: not valid java name */
    /* synthetic */ void m9161lambda$doStartScheduler$4$comtiktokappeventsTTAppEventLogger(final int interval) {
        TikTokBusinessSdk.nextTimeFlushListener.timeLeft(this.counter);
        if (this.counter == 0) {
            this.counter = interval;
        }
        this.counter--;
    }

    void stopScheduler() {
        ScheduledFuture<?> scheduledFuture = this.future;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(false);
            this.future = null;
        }
        ScheduledFuture<?> scheduledFuture2 = this.timeFuture;
        if (scheduledFuture2 != null) {
            scheduledFuture2.cancel(false);
            this.timeFuture = null;
        }
    }

    public boolean identify(String externalId, String externalUserName, String phoneNumber, String email) {
        TTUserInfo tTUserInfo = TTUserInfo.sharedInstance;
        if (tTUserInfo.isIdentified()) {
            this.logger.warn("SDK is already identified, if you want to switch to anotheruser account, plz call TiktokBusinessSDK.logout() first and then identify", new Object[0]);
            return false;
        }
        tTUserInfo.setIdentified();
        if (!TextUtils.isEmpty(externalId)) {
            tTUserInfo.setExternalId(externalId);
        }
        if (!TextUtils.isEmpty(externalUserName)) {
            tTUserInfo.setExternalUserName(externalUserName);
        }
        if (!TextUtils.isEmpty(phoneNumber)) {
            tTUserInfo.setPhoneNumber(phoneNumber);
        }
        if (!TextUtils.isEmpty(email)) {
            tTUserInfo.setEmail(email);
        }
        trackEvent(TTAppEvent.TTAppEventType.identify, null, null, null);
        flushWithReason(FlushReason.IDENTIFY);
        return true;
    }

    public void logout() {
        TTUserInfo.reset(TikTokBusinessSdk.getApplicationContext(), true);
        flushWithReason(FlushReason.LOGOUT);
    }

    public void track(String event, JSONObject props) {
        trackEvent(TTAppEvent.TTAppEventType.track, event, props, null);
    }

    public void track(String event, JSONObject props, String eventId) {
        trackEvent(TTAppEvent.TTAppEventType.track, event, props, eventId);
    }

    private void trackEvent(final TTAppEvent.TTAppEventType type, final String event, JSONObject props, final String eventId) {
        if (!TikTokBusinessSdk.isSystemActivated() || TextUtils.isEmpty(TikTokBusinessSdk.getAppId())) {
            return;
        }
        if (props == null) {
            props = new JSONObject();
        }
        final JSONObject jSONObject = props;
        addToQ(new Runnable() { // from class: com.tiktok.appevents.TTAppEventLogger$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                TTAppEventLogger.this.m9165lambda$trackEvent$5$comtiktokappeventsTTAppEventLogger(event, jSONObject, type, eventId);
            }
        });
    }

    /* renamed from: lambda$trackEvent$5$com-tiktok-appevents-TTAppEventLogger, reason: not valid java name */
    /* synthetic */ void m9165lambda$trackEvent$5$comtiktokappeventsTTAppEventLogger(final String event, final JSONObject finalProps, final TTAppEvent.TTAppEventType type, final String eventId) {
        try {
            this.logger.debug("track " + event + " : " + finalProps.toString(4), new Object[0]);
        } catch (JSONException unused) {
        }
        TTAppEventsQueue.addEvent(new TTAppEvent(type, event, finalProps.toString(), eventId, TikTokBusinessSdk.getTTAppIds()));
        if (TTAppEventsQueue.size() > 100) {
            m9163lambda$flushWithReason$6$comtiktokappeventsTTAppEventLogger(FlushReason.THRESHOLD);
        }
    }

    public void forceFlush() {
        flushWithReason(FlushReason.FORCE_FLUSH);
    }

    public void flushWithReason(final FlushReason reason) {
        this.logger.debug(reason.name() + " triggered flush", new Object[0]);
        addToQ(new Runnable() { // from class: com.tiktok.appevents.TTAppEventLogger$$ExternalSyntheticLambda11
            @Override // java.lang.Runnable
            public final void run() {
                TTAppEventLogger.this.m9163lambda$flushWithReason$6$comtiktokappeventsTTAppEventLogger(reason);
            }
        });
    }

    private void activateSdk() {
        this.autoEventsManager.trackOnAppOpenEvents();
        startScheduler();
        m9163lambda$flushWithReason$6$comtiktokappeventsTTAppEventLogger(FlushReason.START_UP);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: flush, reason: merged with bridge method [inline-methods] */
    public void m9163lambda$flushWithReason$6$comtiktokappeventsTTAppEventLogger(FlushReason reason) {
        long currentTimeMillis = System.currentTimeMillis();
        TTUtil.checkThread(TAG);
        int i = 0;
        if (!TikTokBusinessSdk.isGlobalConfigFetched().booleanValue()) {
            this.logger.info(SKIP_FLUSHING_BECAUSE_GLOBAL_CONFIG_IS_NOT_FETCHED, new Object[0]);
            return;
        }
        if (!TikTokBusinessSdk.isSystemActivated()) {
            this.logger.info(SKIP_FLUSHING_BECAUSE_GLOBAL_SWITCH_IS_TURNED_OFF, new Object[0]);
            return;
        }
        try {
            if (TikTokBusinessSdk.getNetworkSwitch()) {
                this.logger.debug("Start flush, version %d reason is %s", Integer.valueOf(this.flushId), reason.name());
                TTAppEventPersist readFromDisk = TTAppEventStorage.readFromDisk();
                readFromDisk.addEvents(TTAppEventsQueue.exportAllEvents());
                i = readFromDisk.getAppEvents().size();
                List<TTAppEvent> reportAppEvent = TTRequest.reportAppEvent(TTRequestBuilder.getBasePayload(), readFromDisk.getAppEvents());
                if (!reportAppEvent.isEmpty()) {
                    this.logger.debug("Failed to send %d events, will save to disk", Integer.valueOf(reportAppEvent.size()));
                    TTAppEventStorage.persist(reportAppEvent);
                }
                this.logger.debug("END flush, version %d reason is %s", Integer.valueOf(this.flushId), reason.name());
                this.flushId++;
            } else {
                this.logger.info(NETWORK_IS_TURNED_OFF, new Object[0]);
                TTAppEventStorage.persist(null);
            }
        } catch (Exception e) {
            TTCrashHandler.handleCrash(TAG, e, 2);
        }
        if (i != 0) {
            try {
                monitorMetric("flush", TTUtil.getMetaWithTS(Long.valueOf(currentTimeMillis)).put("latency", System.currentTimeMillis() - currentTimeMillis).put("type", reason.name()).put("interval", TIME_BUFFER).put(ContentDisposition.Parameters.Size, i), null);
            } catch (Exception unused) {
            }
        }
        addToQ(new TTAppEventLogger$$ExternalSyntheticLambda1());
    }

    public void destroy() {
        TTAppEventsQueue.clearAll();
        stopScheduler();
    }

    private void addToQ(Runnable task) {
        try {
            eventLoop.execute(task);
        } catch (Exception e) {
            TTCrashHandler.handleCrash(TAG, e, 2);
        }
    }

    private void addToLater(Runnable task, int seconds) {
        try {
            eventLoop.schedule(task, seconds, TimeUnit.SECONDS);
        } catch (Exception e) {
            TTCrashHandler.handleCrash(TAG, e, 2);
        }
    }

    public void clearAll() {
        addToQ(new Runnable() { // from class: com.tiktok.appevents.TTAppEventLogger$$ExternalSyntheticLambda6
            @Override // java.lang.Runnable
            public final void run() {
                TTAppEventLogger.this.clearAllImmediately();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearAllImmediately() {
        TTAppEventsQueue.clearAll();
        TTAppEventStorage.clearAll();
    }

    public void fetchGlobalConfig(int delaySeconds) {
        addToLater(new Runnable() { // from class: com.tiktok.appevents.TTAppEventLogger$$ExternalSyntheticLambda10
            @Override // java.lang.Runnable
            public final void run() {
                TTAppEventLogger.this.m9162lambda$fetchGlobalConfig$7$comtiktokappeventsTTAppEventLogger();
            }
        }, delaySeconds);
    }

    /* renamed from: lambda$fetchGlobalConfig$7$com-tiktok-appevents-TTAppEventLogger, reason: not valid java name */
    /* synthetic */ void m9162lambda$fetchGlobalConfig$7$comtiktokappeventsTTAppEventLogger() {
        try {
            try {
                try {
                    this.logger.info("Fetching global config....", new Object[0]);
                    HashMap hashMap = new HashMap();
                    hashMap.put("disable" + TTConst.AutoEvents.InstallApp.name, Boolean.valueOf(!this.autoEventsManager.shouldTrackAppLifecycleEvents(TTConst.AutoEvents.InstallApp).booleanValue()));
                    hashMap.put("disable" + TTConst.AutoEvents.LaunchAPP.name, Boolean.valueOf(!this.autoEventsManager.shouldTrackAppLifecycleEvents(TTConst.AutoEvents.LaunchAPP).booleanValue()));
                    hashMap.put("disable" + TTConst.AutoEvents.SecondDayRetention.name, Boolean.valueOf(!this.autoEventsManager.shouldTrackAppLifecycleEvents(TTConst.AutoEvents.SecondDayRetention).booleanValue()));
                    JSONObject businessSDKConfig = TTRequest.getBusinessSDKConfig(hashMap);
                    if (businessSDKConfig == null) {
                        this.logger.info("Opt out of initGlobalConfig because global config is null, api returns error", new Object[0]);
                        if (!TikTokBusinessSdk.isSystemActivated() || TikTokBusinessSdk.isActivatedLogicRun) {
                            return;
                        }
                    } else {
                        JSONObject jSONObject = (JSONObject) businessSDKConfig.get("business_sdk_config");
                        Boolean valueOf = Boolean.valueOf(jSONObject.getBoolean("enable_sdk"));
                        String string = jSONObject.getString("available_version");
                        String string2 = jSONObject.getString(C3040d4.i.D);
                        TikTokBusinessSdk.setSdkGlobalSwitch(valueOf);
                        this.logger.debug("enable_sdk=" + valueOf, new Object[0]);
                        if (!valueOf.booleanValue()) {
                            this.logger.info("Clear all events and stop timers because global switch is not turned on", new Object[0]);
                            clearAllImmediately();
                        }
                        TikTokBusinessSdk.setApiAvailableVersion(string);
                        TikTokBusinessSdk.setApiTrackDomain(string2);
                        this.logger.debug("available_version=" + string, new Object[0]);
                        TikTokBusinessSdk.setGlobalConfigFetched();
                        autoTrackRetentionEnable = jSONObject.optBoolean("auto_track_Retention_enable");
                        autoTrackPaymentEnable = jSONObject.optBoolean("auto_track_Payment_enable");
                        if (!TikTokBusinessSdk.isSystemActivated() || TikTokBusinessSdk.isActivatedLogicRun) {
                            return;
                        }
                    }
                    TikTokBusinessSdk.isActivatedLogicRun = true;
                    activateSdk();
                } catch (Exception e) {
                    this.logger.warn("Errors occurred during initGlobalConfig because of " + e.getMessage(), new Object[0]);
                    e.printStackTrace();
                    if (!TikTokBusinessSdk.isSystemActivated() || TikTokBusinessSdk.isActivatedLogicRun) {
                        return;
                    }
                    TikTokBusinessSdk.isActivatedLogicRun = true;
                    activateSdk();
                }
            } catch (JSONException e2) {
                e2.printStackTrace();
                this.logger.warn("Errors happened during initGlobalConfig because the structure of api result is not correct", new Object[0]);
                if (!TikTokBusinessSdk.isSystemActivated() || TikTokBusinessSdk.isActivatedLogicRun) {
                    return;
                }
                TikTokBusinessSdk.isActivatedLogicRun = true;
                activateSdk();
            }
        } catch (Throwable th) {
            if (TikTokBusinessSdk.isSystemActivated() && !TikTokBusinessSdk.isActivatedLogicRun) {
                TikTokBusinessSdk.isActivatedLogicRun = true;
                activateSdk();
            }
            throw th;
        }
    }

    public void monitorMetric(final String name, final JSONObject meta, final JSONObject extra) {
        if (metricsEnabled) {
            addToQ(new Runnable() { // from class: com.tiktok.appevents.TTAppEventLogger$$ExternalSyntheticLambda9
                @Override // java.lang.Runnable
                public final void run() {
                    TTAppEventLogger.lambda$monitorMetric$8(name, meta, extra);
                }
            });
        }
    }

    static /* synthetic */ void lambda$monitorMetric$8(final String name, final JSONObject meta, final JSONObject extra) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject = TTRequestBuilder.getHealthMonitorBase();
        } catch (Exception unused) {
        }
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("type", "metric");
            jSONObject2.put("name", name);
            if (meta != null) {
                jSONObject2.put(Constants.REFERRER_API_META, meta);
            }
            if (extra != null) {
                jSONObject2.put("extra", extra);
            }
            jSONObject.put("monitor", jSONObject2);
        } catch (Exception unused2) {
        }
        TTCrashHandler.retryLater(jSONObject);
    }

    void persistMonitor() {
        addToQ(new Runnable() { // from class: com.tiktok.appevents.TTAppEventLogger$$ExternalSyntheticLambda12
            @Override // java.lang.Runnable
            public final void run() {
                TTCrashHandler.persistToFile();
            }
        });
    }
}
