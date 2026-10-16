package com.tiktok;

import android.app.Application;
import android.content.Context;
import android.text.TextUtils;
import androidx.autofill.HintConstants;
import com.tiktok.appevents.TTAppEventLogger;
import com.tiktok.appevents.TTCrashHandler;
import com.tiktok.appevents.TTPurchaseInfo;
import com.tiktok.appevents.TTUserInfo;
import com.tiktok.appevents.base.EventName;
import com.tiktok.appevents.base.TTBaseEvent;
import com.tiktok.iap.TTInAppPurchaseWrapper;
import com.tiktok.util.RegexUtil;
import com.tiktok.util.TTConst;
import com.tiktok.util.TTLogger;
import com.tiktok.util.TTUtil;
import java.lang.Thread;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* loaded from: classes6.dex */
public class TikTokBusinessSdk {
    public static final int INVALID_ID = -2;
    static final String TAG = "com.tiktok.TikTokBusinessSdk";
    static TTAppEventLogger appEventLogger = null;
    private static TTConfig config = null;
    public static DiskStatusListener diskListener = null;
    public static volatile boolean isActivatedLogicRun = false;
    private static TTLogger logger;
    public static MemoryListener memoryListener;
    public static NetworkListener networkListener;
    private static AtomicBoolean networkSwitch;
    public static NextTimeFlushListener nextTimeFlushListener;
    private static CrashListener onCrashListener;
    static volatile TikTokBusinessSdk ttSdk;
    private static final AtomicBoolean globalConfigFetched = new AtomicBoolean(false);
    private static Boolean sdkGlobalSwitch = true;
    private static String apiAvailableVersion = "v1.2";
    private static String apiTrackDomain = "analytics.us.tiktok.com";
    private static LogLevel logLevel = LogLevel.INFO;
    private static AtomicBoolean sdkDebugModeSwitch = new AtomicBoolean(false);
    private static AtomicBoolean sdkLDUModeSwitch = new AtomicBoolean(false);
    private static AtomicBoolean sdkInitialized = new AtomicBoolean(false);
    private static String testEventCode = "";
    private static final String sessionID = UUID.randomUUID().toString();

    public interface CrashListener {
        void onCrash(Thread thread, Throwable ex);
    }

    public interface DiskStatusListener {
        void onDiskChange(int diskSize, boolean read);

        void onDumped(int dumped);
    }

    public interface MemoryListener {
        void onMemoryChange(int size);
    }

    public interface NetworkListener {
        void onNetworkChange(int toBeSentRequests, int successfulRequest, int failedRequests, int totalRequests, int totalSuccessRequests);
    }

    public interface NextTimeFlushListener {
        void thresholdLeft(int threshold, int left);

        void timeLeft(int timeLeft);
    }

    public interface TTInitCallback {
        void fail(int code, String msg);

        void success();
    }

    private TikTokBusinessSdk(TTConfig ttConfig) {
        logLevel = ttConfig.logLevel;
        logger = new TTLogger(TAG, logLevel);
        if (TextUtils.isEmpty(ttConfig.appId) || !RegexUtil.validateAppId(ttConfig.appId)) {
            ttConfig.appId = "";
            logger.warn("Invalid App Id!", new Object[0]);
        }
        if (ttConfig.ttAppId == null || !RegexUtil.validateTTAppId(ttConfig.ttAppId)) {
            ttConfig.ttAppId = "";
            ttConfig.ttAppIds = new String[]{""};
            ttConfig.ttFirstAppId = new BigInteger("0");
            logger.warn("Invalid TikTok App Id!", new Object[0]);
        }
        logger.info("appId: %s, TTAppId: %s, autoIapTrack: %s", ttConfig.appId, ttConfig.ttAppId, Boolean.valueOf(ttConfig.autoIapTrack));
        config = ttConfig;
        networkSwitch = new AtomicBoolean(ttConfig.autoStart);
        sdkDebugModeSwitch.set(ttConfig.debugModeSwitch);
        if (sdkDebugModeSwitch.get()) {
            testEventCode = createTestEventCode(ttConfig);
        }
        sdkLDUModeSwitch.set(ttConfig.lduModeSwitch);
    }

    private String createTestEventCode(TTConfig ttConfig) {
        if (ttConfig == null || ttConfig.ttAppId == null) {
            return "";
        }
        return ttConfig.ttAppId.toString();
    }

    public static boolean isInitialized() {
        return ttSdk != null && sdkInitialized.get();
    }

    public static void initializeSdk(TTConfig ttConfig) {
        initializeSdk(ttConfig, null);
    }

    public static void initializeSdk(TTConfig ttConfig, final TTInitCallback callback) {
        if (ttSdk != null || ttConfig == null) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        try {
            final Thread.UncaughtExceptionHandler defaultUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
            Thread.setDefaultUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() { // from class: com.tiktok.TikTokBusinessSdk.1
                @Override // java.lang.Thread.UncaughtExceptionHandler
                public void uncaughtException(Thread thread, Throwable throwable) {
                    if (TTCrashHandler.isTTSDKRelatedException(throwable)) {
                        TTCrashHandler.handleCrash(TikTokBusinessSdk.TAG, throwable, 3);
                    }
                    if (TikTokBusinessSdk.getCrashListener() != null) {
                        TikTokBusinessSdk.getCrashListener().onCrash(thread, throwable);
                    }
                    Thread.UncaughtExceptionHandler uncaughtExceptionHandler = defaultUncaughtExceptionHandler;
                    if (uncaughtExceptionHandler != null) {
                        uncaughtExceptionHandler.uncaughtException(thread, throwable);
                    }
                }
            });
        } catch (Exception unused) {
        }
        ttSdk = new TikTokBusinessSdk(ttConfig);
        TTUserInfo.reset(getApplicationContext(), false);
        TTAppEventLogger tTAppEventLogger = new TTAppEventLogger(ttConfig.autoEvent, ttConfig.disabledEvents, ttConfig.flushTime, ttConfig.disableMetrics);
        appEventLogger = tTAppEventLogger;
        tTAppEventLogger.initConfig(currentTimeMillis, callback, sdkInitialized);
        if (ttConfig.autoIapTrack) {
            TTInAppPurchaseWrapper.registerIapTrack();
        }
        try {
            appEventLogger.monitorMetric("init_end", TTUtil.getMetaWithTS(null).put("latency", System.currentTimeMillis() - currentTimeMillis), null);
        } catch (Exception unused2) {
        }
    }

    public static void startTrack() {
        if (appEventLogger == null || networkSwitch.get()) {
            return;
        }
        networkSwitch.set(true);
        appEventLogger.forceFlush();
    }

    public static void destroy() {
        ttSdk = null;
        memoryListener = null;
        diskListener = null;
        networkListener = null;
        nextTimeFlushListener = null;
        TTAppEventLogger tTAppEventLogger = appEventLogger;
        if (tTAppEventLogger != null) {
            tTAppEventLogger.destroy();
        }
    }

    public static void setUpSdkListeners(MemoryListener ml, DiskStatusListener dl, NetworkListener nl, NextTimeFlushListener nfl) {
        if (ml != null) {
            memoryListener = ml;
        }
        if (dl != null) {
            diskListener = dl;
        }
        if (nl != null) {
            networkListener = nl;
        }
        if (nfl != null) {
            nextTimeFlushListener = nfl;
        }
        flush();
    }

    @Deprecated
    public static void trackEvent(String event) {
        TTAppEventLogger tTAppEventLogger = appEventLogger;
        if (tTAppEventLogger == null) {
            return;
        }
        tTAppEventLogger.track(event, null);
    }

    @Deprecated
    public static void trackEvent(String event, String eventId) {
        TTAppEventLogger tTAppEventLogger = appEventLogger;
        if (tTAppEventLogger == null) {
            return;
        }
        tTAppEventLogger.track(event, null, eventId);
    }

    public static void trackTTEvent(TTBaseEvent event) {
        TTAppEventLogger tTAppEventLogger = appEventLogger;
        if (tTAppEventLogger == null) {
            return;
        }
        tTAppEventLogger.track(event.eventName, event.properties, event.eventId);
    }

    public static void trackTTEvent(EventName event) {
        TTAppEventLogger tTAppEventLogger = appEventLogger;
        if (tTAppEventLogger == null) {
            return;
        }
        tTAppEventLogger.track(event.toString(), null);
    }

    public static void trackTTEvent(EventName event, String eventId) {
        TTAppEventLogger tTAppEventLogger = appEventLogger;
        if (tTAppEventLogger == null) {
            return;
        }
        tTAppEventLogger.track(event.toString(), null, eventId);
    }

    @Deprecated
    public static void trackEvent(String event, JSONObject props) {
        TTAppEventLogger tTAppEventLogger = appEventLogger;
        if (tTAppEventLogger == null) {
            return;
        }
        tTAppEventLogger.track(event, props, "");
    }

    @Deprecated
    public static void trackEvent(String event, JSONObject props, String eventId) {
        TTAppEventLogger tTAppEventLogger = appEventLogger;
        if (tTAppEventLogger == null) {
            return;
        }
        tTAppEventLogger.track(event, props, eventId);
    }

    public static void trackGooglePlayPurchase(List<TTPurchaseInfo> purchaseInfos) {
        TTAppEventLogger tTAppEventLogger = appEventLogger;
        if (tTAppEventLogger == null) {
            return;
        }
        tTAppEventLogger.trackPurchase(purchaseInfos);
    }

    public static void trackGooglePlayPurchase(TTPurchaseInfo info) {
        trackGooglePlayPurchase((List<TTPurchaseInfo>) Collections.singletonList(info));
    }

    public static void flush() {
        TTAppEventLogger tTAppEventLogger = appEventLogger;
        if (tTAppEventLogger == null) {
            return;
        }
        tTAppEventLogger.forceFlush();
    }

    public static void clearAll() {
        TTAppEventLogger tTAppEventLogger = appEventLogger;
        if (tTAppEventLogger == null) {
            return;
        }
        tTAppEventLogger.clearAll();
    }

    public static Application getApplicationContext() {
        if (ttSdk == null) {
            return null;
        }
        return config.application;
    }

    public static boolean getNetworkSwitch() {
        return networkSwitch.get();
    }

    public static boolean isGaidCollectionEnabled() {
        TTConfig tTConfig = config;
        if (tTConfig == null) {
            return false;
        }
        return tTConfig.advertiserIDCollectionEnable;
    }

    public static LogLevel getLogLevel() {
        return logLevel;
    }

    public static String getAppId() {
        TTConfig tTConfig = config;
        if (tTConfig == null) {
            return "";
        }
        return tTConfig.appId;
    }

    public static String getTTAppId() {
        TTConfig tTConfig = config;
        if (tTConfig == null) {
            return "";
        }
        return tTConfig.ttAppId;
    }

    public static String[] getTTAppIds() {
        TTConfig tTConfig = config;
        if (tTConfig == null) {
            return new String[0];
        }
        return tTConfig.ttAppIds;
    }

    public static BigInteger getFirstTTAppIds() {
        TTConfig tTConfig = config;
        if (tTConfig == null) {
            return new BigInteger("0");
        }
        return tTConfig.ttFirstAppId;
    }

    public static boolean onlyAppIdProvided() {
        TTConfig tTConfig = config;
        return tTConfig == null || tTConfig.ttAppId == null;
    }

    public static boolean bothIdsProvided() {
        return !onlyAppIdProvided();
    }

    public static Boolean getSdkGlobalSwitch() {
        return sdkGlobalSwitch;
    }

    public static boolean isSystemActivated() {
        if (logger == null) {
            return false;
        }
        Boolean sdkGlobalSwitch2 = getSdkGlobalSwitch();
        if (!sdkGlobalSwitch2.booleanValue()) {
            logger.info("Global switch is off, ignore all operations", new Object[0]);
        }
        return sdkGlobalSwitch2.booleanValue();
    }

    public static Boolean isGlobalConfigFetched() {
        return Boolean.valueOf(globalConfigFetched.get());
    }

    public static void setGlobalConfigFetched() {
        globalConfigFetched.set(true);
    }

    public static Boolean isInSdkDebugMode() {
        return Boolean.valueOf(sdkDebugModeSwitch.get());
    }

    public static Boolean isInSdkLDUMode() {
        return Boolean.valueOf(sdkLDUModeSwitch.get());
    }

    public static String getTestEventCode() {
        return testEventCode;
    }

    public static void setSdkGlobalSwitch(Boolean sdkGlobalSwitch2) {
        sdkGlobalSwitch = sdkGlobalSwitch2;
    }

    public static String getApiAvailableVersion() {
        return apiAvailableVersion;
    }

    public static void setApiAvailableVersion(String apiAvailableVersion2) {
        apiAvailableVersion = apiAvailableVersion2;
    }

    public static String getApiTrackDomain() {
        return apiTrackDomain;
    }

    public static void setApiTrackDomain(String apiTrackDomain2) {
        apiTrackDomain = apiTrackDomain2;
    }

    public static void identify(String externalId, String externalUserName, String phoneNumber, String email) {
        try {
            long currentTimeMillis = System.currentTimeMillis();
            if (appEventLogger.identify(externalId, externalUserName, phoneNumber, email)) {
                boolean z = true;
                JSONObject put = TTUtil.getMetaWithTS(Long.valueOf(currentTimeMillis)).put("latency", System.currentTimeMillis() - currentTimeMillis).put("extid", externalId != null).put("username", externalUserName != null).put(HintConstants.AUTOFILL_HINT_PHONE, phoneNumber != null);
                if (email == null) {
                    z = false;
                }
                appEventLogger.monitorMetric("identify", put.put("email", z), null);
            }
        } catch (Exception unused) {
        }
    }

    public static void logout() {
        try {
            long currentTimeMillis = System.currentTimeMillis();
            appEventLogger.logout();
            appEventLogger.monitorMetric("logout", TTUtil.getMetaWithTS(Long.valueOf(currentTimeMillis)).put("latency", System.currentTimeMillis() - currentTimeMillis), null);
        } catch (Exception unused) {
        }
    }

    public static String getSessionID() {
        return sessionID;
    }

    public static TTAppEventLogger getAppEventLogger() {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        if (TTCrashHandler.isTTSDKRelatedException((StackTraceElement[]) Arrays.copyOfRange(stackTrace, 3, stackTrace.length))) {
            return appEventLogger;
        }
        return null;
    }

    public static void crashSDK() {
        throw new RuntimeException("force crash from sdk");
    }

    public static class TTConfig {
        private final Application application;
        private final List<TTConst.AutoEvents> disabledEvents;
        private String appId = "";
        private String ttAppId = "";
        private String[] ttAppIds = {""};
        private BigInteger ttFirstAppId = new BigInteger("0");
        private int flushTime = 15;
        private LogLevel logLevel = LogLevel.NONE;
        private boolean autoEvent = true;
        private boolean advertiserIDCollectionEnable = true;
        private boolean autoStart = true;
        private boolean disableMetrics = false;
        private boolean debugModeSwitch = false;
        private boolean lduModeSwitch = false;
        private boolean autoIapTrack = false;

        public TTConfig(Context context) {
            if (context == null) {
                throw new IllegalArgumentException("Context must not be null");
            }
            this.application = (Application) context.getApplicationContext();
            this.disabledEvents = new ArrayList();
        }

        public TTConfig setLogLevel(LogLevel ll) {
            this.logLevel = ll;
            return this;
        }

        public TTConfig setTTAppId(String ttAppId) {
            this.ttAppId = ttAppId;
            try {
                this.ttAppIds = ttAppId.replace(" ", "").split(",");
                this.ttFirstAppId = new BigInteger(this.ttAppIds[0]);
            } catch (Throwable unused) {
            }
            return this;
        }

        public TTConfig setAppId(String apiId) {
            if (!TextUtils.isEmpty(apiId)) {
                this.appId = apiId;
            }
            return this;
        }

        public TTConfig disableAutoStart() {
            this.autoStart = false;
            return this;
        }

        public TTConfig disableAutoEvents() {
            this.autoEvent = false;
            return this;
        }

        public TTConfig disableInstallLogging() {
            this.disabledEvents.add(TTConst.AutoEvents.InstallApp);
            return this;
        }

        public TTConfig disableLaunchLogging() {
            this.disabledEvents.add(TTConst.AutoEvents.LaunchAPP);
            return this;
        }

        public TTConfig disableRetentionLogging() {
            this.disabledEvents.add(TTConst.AutoEvents.SecondDayRetention);
            return this;
        }

        public TTConfig disableAdvertiserIDCollection() {
            this.advertiserIDCollectionEnable = false;
            return this;
        }

        public TTConfig setFlushTimeInterval(int seconds) {
            if (seconds < 0) {
                throw new RuntimeException("Invalid Flush interval");
            }
            this.flushTime = seconds;
            return this;
        }

        public TTConfig disableMonitor() {
            this.disableMetrics = true;
            return this;
        }

        public TTConfig openDebugMode() {
            this.debugModeSwitch = true;
            return this;
        }

        public TTConfig enableLimitedDataUse() {
            this.lduModeSwitch = true;
            return this;
        }

        public TTConfig enableAutoIapTrack() {
            this.autoIapTrack = true;
            return this;
        }

        public boolean isAutoIapTrack() {
            return this.autoIapTrack;
        }
    }

    public enum LogLevel {
        NONE,
        INFO,
        WARN,
        DEBUG;

        public boolean log() {
            return this != NONE;
        }
    }

    public static boolean enableAutoIapTrack() {
        TTConfig tTConfig = config;
        return tTConfig != null && tTConfig.isAutoIapTrack();
    }

    public static void setOnCrashListener(CrashListener crashListener) {
        onCrashListener = crashListener;
    }

    public static CrashListener getCrashListener() {
        return onCrashListener;
    }
}
