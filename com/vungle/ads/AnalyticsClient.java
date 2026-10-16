package com.vungle.ads;

import android.os.Build;
import com.bytedance.sdk.component.pglcrypt.PglCryptUtils;
import com.vungle.ads.internal.executor.VungleThreadPoolExecutor;
import com.vungle.ads.internal.network.VungleApiClient;
import com.vungle.ads.internal.network.VungleHeader;
import com.vungle.ads.internal.protos.Sdk;
import com.vungle.ads.internal.util.ActivityManager;
import com.vungle.ads.internal.util.LogEntry;
import com.vungle.ads.internal.util.Logger;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AnalyticsClient.kt */
@Metadata(d1 = {"\u0000\u008e\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001:\u0002XYB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u00109\u001a\u00020:H\u0003J\b\u0010;\u001a\u00020:H\u0003J2\u0010<\u001a\u00020\u001e2\u0006\u0010=\u001a\u00020>2\b\b\u0002\u0010?\u001a\u00020\u00062\n\b\u0002\u0010@\u001a\u0004\u0018\u00010A2\n\b\u0002\u0010B\u001a\u0004\u0018\u00010\bH\u0002J$\u0010C\u001a\u00020\u000b2\u0006\u0010D\u001a\u00020E2\u0006\u0010F\u001a\u00020\b2\n\b\u0002\u0010G\u001a\u0004\u0018\u00010AH\u0002J-\u0010H\u001a\u00020:2\u0006\u00102\u001a\u0002032\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010I\u001a\u00020\u00042\u0006\u0010!\u001a\u00020\"H\u0000¢\u0006\u0002\bJJ)\u0010K\u001a\u00020:2\u0006\u0010D\u001a\u00020E2\u0006\u0010F\u001a\u00020\b2\n\b\u0002\u0010G\u001a\u0004\u0018\u00010AH\u0000¢\u0006\u0002\bLJ$\u0010M\u001a\u00020:2\u0006\u0010D\u001a\u00020E2\u0006\u0010F\u001a\u00020\b2\n\b\u0002\u0010G\u001a\u0004\u0018\u00010AH\u0002J-\u0010N\u001a\u00020:2\u0006\u0010O\u001a\u00020P2\n\b\u0002\u0010@\u001a\u0004\u0018\u00010A2\n\b\u0002\u0010B\u001a\u0004\u0018\u00010\bH\u0000¢\u0006\u0002\bQJ-\u0010N\u001a\u00020:2\u0006\u0010R\u001a\u00020S2\n\b\u0002\u0010@\u001a\u0004\u0018\u00010A2\n\b\u0002\u0010B\u001a\u0004\u0018\u00010\bH\u0000¢\u0006\u0002\bQJ-\u0010N\u001a\u00020:2\u0006\u0010T\u001a\u00020U2\n\b\u0002\u0010@\u001a\u0004\u0018\u00010A2\n\b\u0002\u0010B\u001a\u0004\u0018\u00010\bH\u0000¢\u0006\u0002\bQJ7\u0010N\u001a\u00020:2\u0006\u0010=\u001a\u00020>2\b\b\u0002\u0010?\u001a\u00020\u00062\n\b\u0002\u0010@\u001a\u0004\u0018\u00010A2\n\b\u0002\u0010B\u001a\u0004\u0018\u00010\bH\u0000¢\u0006\u0002\bQJ2\u0010V\u001a\u00020:2\u0006\u0010=\u001a\u00020>2\b\b\u0002\u0010?\u001a\u00020\u00062\n\b\u0002\u0010@\u001a\u0004\u0018\u00010A2\n\b\u0002\u0010B\u001a\u0004\u0018\u00010\bH\u0002J\b\u0010W\u001a\u00020:H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\"\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n8\u0000X\u0081\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\f\u0010\u0002\u001a\u0004\b\r\u0010\u000eR&\u0010\u000f\u001a\u0004\u0018\u00010\u00108\u0000@\u0000X\u0081\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0011\u0010\u0002\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0016\u001a\u00020\u00178\u0000X\u0081\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0018\u0010\u0002\u001a\u0004\b\u0019\u0010\u001aR\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001e0\n8\u0000X\u0081\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001f\u0010\u0002\u001a\u0004\b \u0010\u000eR$\u0010!\u001a\u00020\"8\u0000@\u0000X\u0081\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b#\u0010\u0002\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\"\u0010(\u001a\b\u0012\u0004\u0012\u00020\u000b0\n8\u0000X\u0081\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b)\u0010\u0002\u001a\u0004\b*\u0010\u000eR\"\u0010+\u001a\b\u0012\u0004\u0012\u00020\u001e0\n8\u0000X\u0081\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b,\u0010\u0002\u001a\u0004\b-\u0010\u000eR$\u0010.\u001a\u00020\"8\u0000@\u0000X\u0081\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b/\u0010\u0002\u001a\u0004\b0\u0010%\"\u0004\b1\u0010'R&\u00102\u001a\u0004\u0018\u0001038\u0000@\u0000X\u0081\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b4\u0010\u0002\u001a\u0004\b5\u00106\"\u0004\b7\u00108¨\u0006Z"}, d2 = {"Lcom/vungle/ads/AnalyticsClient;", "", "()V", "MAX_BATCH_SIZE", "", "REFRESH_TIME_MILLIS", "", "TAG", "", "errors", "Ljava/util/concurrent/BlockingQueue;", "Lcom/vungle/ads/internal/protos/Sdk$SDKError$Builder;", "getErrors$vungle_ads_release$annotations", "getErrors$vungle_ads_release", "()Ljava/util/concurrent/BlockingQueue;", "executor", "Lcom/vungle/ads/internal/executor/VungleThreadPoolExecutor;", "getExecutor$vungle_ads_release$annotations", "getExecutor$vungle_ads_release", "()Lcom/vungle/ads/internal/executor/VungleThreadPoolExecutor;", "setExecutor$vungle_ads_release", "(Lcom/vungle/ads/internal/executor/VungleThreadPoolExecutor;)V", "isInitialized", "Ljava/util/concurrent/atomic/AtomicBoolean;", "isInitialized$vungle_ads_release$annotations", "isInitialized$vungle_ads_release", "()Ljava/util/concurrent/atomic/AtomicBoolean;", "logLevel", "Lcom/vungle/ads/AnalyticsClient$LogLevel;", "metrics", "Lcom/vungle/ads/internal/protos/Sdk$SDKMetric$Builder;", "getMetrics$vungle_ads_release$annotations", "getMetrics$vungle_ads_release", "metricsEnabled", "", "getMetricsEnabled$vungle_ads_release$annotations", "getMetricsEnabled$vungle_ads_release", "()Z", "setMetricsEnabled$vungle_ads_release", "(Z)V", "pendingErrors", "getPendingErrors$vungle_ads_release$annotations", "getPendingErrors$vungle_ads_release", "pendingMetrics", "getPendingMetrics$vungle_ads_release$annotations", "getPendingMetrics$vungle_ads_release", "refreshEnabled", "getRefreshEnabled$vungle_ads_release$annotations", "getRefreshEnabled$vungle_ads_release", "setRefreshEnabled$vungle_ads_release", "vungleApiClient", "Lcom/vungle/ads/internal/network/VungleApiClient;", "getVungleApiClient$vungle_ads_release$annotations", "getVungleApiClient$vungle_ads_release", "()Lcom/vungle/ads/internal/network/VungleApiClient;", "setVungleApiClient$vungle_ads_release", "(Lcom/vungle/ads/internal/network/VungleApiClient;)V", "flushErrors", "", "flushMetrics", "genMetric", "metricType", "Lcom/vungle/ads/internal/protos/Sdk$SDKMetric$SDKMetricType;", "metricValue", "logEntry", "Lcom/vungle/ads/internal/util/LogEntry;", "metaData", "genSDKError", "reason", "Lcom/vungle/ads/internal/protos/Sdk$SDKError$Reason;", PglCryptUtils.KEY_MESSAGE, "entry", "initOrUpdate", "errorLogLevel", "initOrUpdate$vungle_ads_release", "logError", "logError$vungle_ads_release", "logErrorInSameThread", "logMetric", "oneShotTimeIntervalMetric", "Lcom/vungle/ads/OneShotTimeIntervalMetric;", "logMetric$vungle_ads_release", "singleValueMetric", "Lcom/vungle/ads/SingleValueMetric;", "timeIntervalMetric", "Lcom/vungle/ads/TimeIntervalMetric;", "logMetricInSameThread", "report", "LogLevel", "RequestListener", "vungle-ads_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes7.dex */
public final class AnalyticsClient {
    private static final int MAX_BATCH_SIZE = 20;
    private static final long REFRESH_TIME_MILLIS = 5000;
    private static final String TAG = "AnalyticsClient";
    private static VungleThreadPoolExecutor executor;
    private static boolean metricsEnabled;
    private static VungleApiClient vungleApiClient;
    public static final AnalyticsClient INSTANCE = new AnalyticsClient();
    private static final BlockingQueue<Sdk.SDKError.Builder> errors = new LinkedBlockingQueue();
    private static final BlockingQueue<Sdk.SDKMetric.Builder> metrics = new LinkedBlockingQueue();
    private static final BlockingQueue<Sdk.SDKError.Builder> pendingErrors = new LinkedBlockingQueue();
    private static final BlockingQueue<Sdk.SDKMetric.Builder> pendingMetrics = new LinkedBlockingQueue();
    private static LogLevel logLevel = LogLevel.ERROR_LOG_LEVEL_ERROR;
    private static boolean refreshEnabled = true;
    private static final AtomicBoolean isInitialized = new AtomicBoolean(false);

    /* compiled from: AnalyticsClient.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&¨\u0006\u0005"}, d2 = {"Lcom/vungle/ads/AnalyticsClient$RequestListener;", "", "onFailure", "", "onSuccess", "vungle-ads_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public interface RequestListener {
        void onFailure();

        void onSuccess();
    }

    public static /* synthetic */ void getErrors$vungle_ads_release$annotations() {
    }

    public static /* synthetic */ void getExecutor$vungle_ads_release$annotations() {
    }

    public static /* synthetic */ void getMetrics$vungle_ads_release$annotations() {
    }

    public static /* synthetic */ void getMetricsEnabled$vungle_ads_release$annotations() {
    }

    public static /* synthetic */ void getPendingErrors$vungle_ads_release$annotations() {
    }

    public static /* synthetic */ void getPendingMetrics$vungle_ads_release$annotations() {
    }

    public static /* synthetic */ void getRefreshEnabled$vungle_ads_release$annotations() {
    }

    public static /* synthetic */ void getVungleApiClient$vungle_ads_release$annotations() {
    }

    public static /* synthetic */ void isInitialized$vungle_ads_release$annotations() {
    }

    private AnalyticsClient() {
    }

    /* compiled from: AnalyticsClient.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0001\u0018\u0000 \n2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\nB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\u000b"}, d2 = {"Lcom/vungle/ads/AnalyticsClient$LogLevel;", "", "level", "", "(Ljava/lang/String;II)V", "getLevel", "()I", "ERROR_LOG_LEVEL_OFF", "ERROR_LOG_LEVEL_ERROR", "ERROR_LOG_LEVEL_DEBUG", "Companion", "vungle-ads_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public enum LogLevel {
        ERROR_LOG_LEVEL_OFF(0),
        ERROR_LOG_LEVEL_ERROR(1),
        ERROR_LOG_LEVEL_DEBUG(2);


        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final int level;

        LogLevel(int i) {
            this.level = i;
        }

        public final int getLevel() {
            return this.level;
        }

        /* compiled from: AnalyticsClient.kt */
        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/vungle/ads/AnalyticsClient$LogLevel$Companion;", "", "()V", "fromValue", "Lcom/vungle/ads/AnalyticsClient$LogLevel;", "logLevel", "", "vungle-ads_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final LogLevel fromValue(int logLevel) {
                if (logLevel == LogLevel.ERROR_LOG_LEVEL_DEBUG.getLevel()) {
                    return LogLevel.ERROR_LOG_LEVEL_DEBUG;
                }
                if (logLevel == LogLevel.ERROR_LOG_LEVEL_ERROR.getLevel()) {
                    return LogLevel.ERROR_LOG_LEVEL_ERROR;
                }
                if (logLevel == LogLevel.ERROR_LOG_LEVEL_OFF.getLevel()) {
                    return LogLevel.ERROR_LOG_LEVEL_OFF;
                }
                return LogLevel.ERROR_LOG_LEVEL_ERROR;
            }
        }
    }

    public final BlockingQueue<Sdk.SDKError.Builder> getErrors$vungle_ads_release() {
        return errors;
    }

    public final BlockingQueue<Sdk.SDKMetric.Builder> getMetrics$vungle_ads_release() {
        return metrics;
    }

    public final BlockingQueue<Sdk.SDKError.Builder> getPendingErrors$vungle_ads_release() {
        return pendingErrors;
    }

    public final BlockingQueue<Sdk.SDKMetric.Builder> getPendingMetrics$vungle_ads_release() {
        return pendingMetrics;
    }

    public final VungleApiClient getVungleApiClient$vungle_ads_release() {
        return vungleApiClient;
    }

    public final void setVungleApiClient$vungle_ads_release(VungleApiClient vungleApiClient2) {
        vungleApiClient = vungleApiClient2;
    }

    public final VungleThreadPoolExecutor getExecutor$vungle_ads_release() {
        return executor;
    }

    public final void setExecutor$vungle_ads_release(VungleThreadPoolExecutor vungleThreadPoolExecutor) {
        executor = vungleThreadPoolExecutor;
    }

    public final boolean getMetricsEnabled$vungle_ads_release() {
        return metricsEnabled;
    }

    public final void setMetricsEnabled$vungle_ads_release(boolean z) {
        metricsEnabled = z;
    }

    public final boolean getRefreshEnabled$vungle_ads_release() {
        return refreshEnabled;
    }

    public final void setRefreshEnabled$vungle_ads_release(boolean z) {
        refreshEnabled = z;
    }

    public final AtomicBoolean isInitialized$vungle_ads_release() {
        return isInitialized;
    }

    public final synchronized void initOrUpdate$vungle_ads_release(VungleApiClient vungleApiClient2, final VungleThreadPoolExecutor executor2, int errorLogLevel, boolean metricsEnabled2) {
        Intrinsics.checkNotNullParameter(vungleApiClient2, "vungleApiClient");
        Intrinsics.checkNotNullParameter(executor2, "executor");
        logLevel = LogLevel.INSTANCE.fromValue(errorLogLevel);
        metricsEnabled = metricsEnabled2;
        if (errorLogLevel == LogLevel.ERROR_LOG_LEVEL_DEBUG.getLevel()) {
            Logger.INSTANCE.enable(true);
        } else if (errorLogLevel == LogLevel.ERROR_LOG_LEVEL_ERROR.getLevel()) {
            Logger.INSTANCE.enable(false);
        } else if (errorLogLevel == LogLevel.ERROR_LOG_LEVEL_OFF.getLevel()) {
            Logger.INSTANCE.enable(false);
        }
        if (isInitialized.getAndSet(true)) {
            Logger.INSTANCE.d(TAG, "AnalyticsClient already initialized");
            return;
        }
        executor = executor2;
        vungleApiClient = vungleApiClient2;
        try {
            BlockingQueue<Sdk.SDKError.Builder> blockingQueue = pendingErrors;
            if (!blockingQueue.isEmpty()) {
                blockingQueue.drainTo(errors);
            }
        } catch (Exception e) {
            Logger.INSTANCE.e(TAG, "Failed to add pendingErrors to errors queue.", e);
        }
        try {
            BlockingQueue<Sdk.SDKMetric.Builder> blockingQueue2 = pendingMetrics;
            if (!blockingQueue2.isEmpty()) {
                blockingQueue2.drainTo(metrics);
            }
        } catch (Exception e2) {
            Logger.INSTANCE.e(TAG, "Failed to add pendingMetrics to metrics queue.", e2);
        }
        if (refreshEnabled) {
            Executors.newSingleThreadScheduledExecutor().scheduleWithFixedDelay(new Runnable() { // from class: com.vungle.ads.AnalyticsClient$$ExternalSyntheticLambda3
                @Override // java.lang.Runnable
                public final void run() {
                    AnalyticsClient.m9295initOrUpdate$lambda1(VungleThreadPoolExecutor.this);
                }
            }, 5000L, 5000L, TimeUnit.MILLISECONDS);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: initOrUpdate$lambda-1, reason: not valid java name */
    public static final void m9295initOrUpdate$lambda1(VungleThreadPoolExecutor executor2) {
        Intrinsics.checkNotNullParameter(executor2, "$executor");
        executor2.execute(new Runnable() { // from class: com.vungle.ads.AnalyticsClient$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                AnalyticsClient.m9296initOrUpdate$lambda1$lambda0();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: initOrUpdate$lambda-1$lambda-0, reason: not valid java name */
    public static final void m9296initOrUpdate$lambda1$lambda0() {
        INSTANCE.report();
    }

    public static /* synthetic */ void logError$vungle_ads_release$default(AnalyticsClient analyticsClient, Sdk.SDKError.Reason reason, String str, LogEntry logEntry, int i, Object obj) {
        if ((i & 4) != 0) {
            logEntry = null;
        }
        analyticsClient.logError$vungle_ads_release(reason, str, logEntry);
    }

    public final synchronized void logError$vungle_ads_release(final Sdk.SDKError.Reason reason, final String message, final LogEntry entry) {
        VungleThreadPoolExecutor vungleThreadPoolExecutor;
        Intrinsics.checkNotNullParameter(reason, "reason");
        Intrinsics.checkNotNullParameter(message, "message");
        try {
            vungleThreadPoolExecutor = executor;
        } catch (Exception e) {
            Logger.INSTANCE.e(TAG, "Cannot logError " + reason + ", " + message + ", " + entry, e);
        }
        if (vungleThreadPoolExecutor == null) {
            pendingErrors.put(genSDKError(reason, message, entry));
        } else {
            if (vungleThreadPoolExecutor != null) {
                vungleThreadPoolExecutor.execute(new Runnable() { // from class: com.vungle.ads.AnalyticsClient$$ExternalSyntheticLambda2
                    @Override // java.lang.Runnable
                    public final void run() {
                        AnalyticsClient.m9297logError$lambda2(Sdk.SDKError.Reason.this, message, entry);
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: logError$lambda-2, reason: not valid java name */
    public static final void m9297logError$lambda2(Sdk.SDKError.Reason reason, String message, LogEntry logEntry) {
        Intrinsics.checkNotNullParameter(reason, "$reason");
        Intrinsics.checkNotNullParameter(message, "$message");
        INSTANCE.logErrorInSameThread(reason, message, logEntry);
    }

    static /* synthetic */ Sdk.SDKError.Builder genSDKError$default(AnalyticsClient analyticsClient, Sdk.SDKError.Reason reason, String str, LogEntry logEntry, int i, Object obj) {
        if ((i & 4) != 0) {
            logEntry = null;
        }
        return analyticsClient.genSDKError(reason, str, logEntry);
    }

    private final Sdk.SDKError.Builder genSDKError(Sdk.SDKError.Reason reason, String message, LogEntry entry) {
        String str;
        String str2;
        String str3;
        String str4;
        String headerUa;
        String vmVersion;
        Sdk.SDKError.Builder at = Sdk.SDKError.newBuilder().setOs(Intrinsics.areEqual("Amazon", Build.MANUFACTURER) ? "amazon" : "android").setOsVersion(String.valueOf(Build.VERSION.SDK_INT)).setMake(Build.MANUFACTURER).setModel(Build.MODEL).setReason(reason).setMessage(message).setAt(System.currentTimeMillis());
        String str5 = "";
        if (entry == null || (str = entry.getPlacementRefId()) == null) {
            str = "";
        }
        Sdk.SDKError.Builder placementReferenceId = at.setPlacementReferenceId(str);
        if (entry == null || (str2 = entry.getCreativeId()) == null) {
            str2 = "";
        }
        Sdk.SDKError.Builder creativeId = placementReferenceId.setCreativeId(str2);
        if (entry == null || (str3 = entry.getEventId()) == null) {
            str3 = "";
        }
        Sdk.SDKError.Builder eventId = creativeId.setEventId(str3);
        if (entry == null || (str4 = entry.getAdSource()) == null) {
            str4 = "";
        }
        Sdk.SDKError.Builder adSource = eventId.setAdSource(str4);
        if (entry != null && (vmVersion = entry.getVmVersion()) != null) {
            str5 = vmVersion;
        }
        Sdk.SDKError.Builder vmVersion2 = adSource.setVmVersion(str5);
        if (entry == null || (headerUa = entry.getMediationName()) == null) {
            headerUa = VungleHeader.INSTANCE.getHeaderUa();
        }
        Sdk.SDKError.Builder appState = vmVersion2.setMediationName(headerUa).setAppState(ActivityManager.INSTANCE.isForeground() ? 0L : 2L);
        Intrinsics.checkNotNullExpressionValue(appState, "newBuilder()\n           …isForeground()) 0 else 2)");
        return appState;
    }

    static /* synthetic */ void logErrorInSameThread$default(AnalyticsClient analyticsClient, Sdk.SDKError.Reason reason, String str, LogEntry logEntry, int i, Object obj) {
        if ((i & 4) != 0) {
            logEntry = null;
        }
        analyticsClient.logErrorInSameThread(reason, str, logEntry);
    }

    private final synchronized void logErrorInSameThread(Sdk.SDKError.Reason reason, String message, LogEntry entry) {
        if (logLevel == LogLevel.ERROR_LOG_LEVEL_OFF) {
            return;
        }
        try {
            Sdk.SDKError.Builder genSDKError = genSDKError(reason, message, entry);
            BlockingQueue<Sdk.SDKError.Builder> blockingQueue = errors;
            blockingQueue.put(genSDKError);
            Logger.INSTANCE.w(TAG, "Logging error: " + reason + " with message: " + message + ", mediation: " + genSDKError.getMediationName());
            if (blockingQueue.size() >= 20) {
                report();
            }
        } catch (Exception e) {
            Logger.INSTANCE.e(TAG, "Cannot logError", e);
        }
    }

    public static /* synthetic */ void logMetric$vungle_ads_release$default(AnalyticsClient analyticsClient, Sdk.SDKMetric.SDKMetricType sDKMetricType, long j, LogEntry logEntry, String str, int i, Object obj) {
        if ((i & 2) != 0) {
            j = 0;
        }
        analyticsClient.logMetric$vungle_ads_release(sDKMetricType, j, (i & 4) != 0 ? null : logEntry, (i & 8) != 0 ? null : str);
    }

    public final synchronized void logMetric$vungle_ads_release(Sdk.SDKMetric.SDKMetricType metricType, final long metricValue, final LogEntry logEntry, final String metaData) {
        final Sdk.SDKMetric.SDKMetricType sDKMetricType;
        VungleThreadPoolExecutor vungleThreadPoolExecutor;
        try {
            try {
                Intrinsics.checkNotNullParameter(metricType, "metricType");
                try {
                    vungleThreadPoolExecutor = executor;
                    try {
                    } catch (Exception e) {
                        e = e;
                    }
                } catch (Exception e2) {
                    e = e2;
                    sDKMetricType = metricType;
                }
                if (vungleThreadPoolExecutor == null) {
                    pendingMetrics.put(genMetric(metricType, metricValue, logEntry, metaData));
                    return;
                }
                sDKMetricType = metricType;
                if (vungleThreadPoolExecutor != null) {
                    try {
                        vungleThreadPoolExecutor.execute(new Runnable() { // from class: com.vungle.ads.AnalyticsClient$$ExternalSyntheticLambda0
                            @Override // java.lang.Runnable
                            public final void run() {
                                AnalyticsClient.m9298logMetric$lambda3(Sdk.SDKMetric.SDKMetricType.this, metricValue, logEntry, metaData);
                            }
                        });
                    } catch (Exception e3) {
                        e = e3;
                        metricValue = metricValue;
                        logEntry = logEntry;
                        metaData = metaData;
                        Logger.INSTANCE.e(TAG, "Cannot logMetric " + sDKMetricType + ", " + metricValue + ", " + logEntry + ", " + metaData, e);
                    }
                }
            } catch (Throwable th) {
                th = th;
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: logMetric$lambda-3, reason: not valid java name */
    public static final void m9298logMetric$lambda3(Sdk.SDKMetric.SDKMetricType metricType, long j, LogEntry logEntry, String str) {
        Intrinsics.checkNotNullParameter(metricType, "$metricType");
        INSTANCE.logMetricInSameThread(metricType, j, logEntry, str);
    }

    static /* synthetic */ Sdk.SDKMetric.Builder genMetric$default(AnalyticsClient analyticsClient, Sdk.SDKMetric.SDKMetricType sDKMetricType, long j, LogEntry logEntry, String str, int i, Object obj) {
        if ((i & 2) != 0) {
            j = 0;
        }
        return analyticsClient.genMetric(sDKMetricType, j, (i & 4) != 0 ? null : logEntry, (i & 8) != 0 ? null : str);
    }

    private final Sdk.SDKMetric.Builder genMetric(Sdk.SDKMetric.SDKMetricType metricType, long metricValue, LogEntry logEntry, String metaData) {
        String str;
        String str2;
        String str3;
        String headerUa;
        String str4;
        String vmVersion;
        Sdk.SDKMetric.Builder osVersion = Sdk.SDKMetric.newBuilder().setType(metricType).setValue(metricValue).setMake(Build.MANUFACTURER).setModel(Build.MODEL).setOs(Intrinsics.areEqual("Amazon", Build.MANUFACTURER) ? "amazon" : "android").setOsVersion(String.valueOf(Build.VERSION.SDK_INT));
        String str5 = "";
        if (logEntry == null || (str = logEntry.getPlacementRefId()) == null) {
            str = "";
        }
        Sdk.SDKMetric.Builder placementReferenceId = osVersion.setPlacementReferenceId(str);
        if (logEntry == null || (str2 = logEntry.getCreativeId()) == null) {
            str2 = "";
        }
        Sdk.SDKMetric.Builder creativeId = placementReferenceId.setCreativeId(str2);
        if (logEntry == null || (str3 = logEntry.getEventId()) == null) {
            str3 = "";
        }
        Sdk.SDKMetric.Builder eventId = creativeId.setEventId(str3);
        if (metaData == null) {
            metaData = "";
        }
        Sdk.SDKMetric.Builder meta = eventId.setMeta(metaData);
        if (logEntry == null || (headerUa = logEntry.getMediationName()) == null) {
            headerUa = VungleHeader.INSTANCE.getHeaderUa();
        }
        Sdk.SDKMetric.Builder mediationName = meta.setMediationName(headerUa);
        if (logEntry == null || (str4 = logEntry.getAdSource()) == null) {
            str4 = "";
        }
        Sdk.SDKMetric.Builder adSource = mediationName.setAdSource(str4);
        if (logEntry != null && (vmVersion = logEntry.getVmVersion()) != null) {
            str5 = vmVersion;
        }
        Sdk.SDKMetric.Builder appState = adSource.setVmVersion(str5).setAppState(ActivityManager.INSTANCE.isForeground() ? 0L : 2L);
        Intrinsics.checkNotNullExpressionValue(appState, "newBuilder()\n           …isForeground()) 0 else 2)");
        return appState;
    }

    static /* synthetic */ void logMetricInSameThread$default(AnalyticsClient analyticsClient, Sdk.SDKMetric.SDKMetricType sDKMetricType, long j, LogEntry logEntry, String str, int i, Object obj) {
        if ((i & 2) != 0) {
            j = 0;
        }
        analyticsClient.logMetricInSameThread(sDKMetricType, j, (i & 4) != 0 ? null : logEntry, (i & 8) != 0 ? null : str);
    }

    private final synchronized void logMetricInSameThread(Sdk.SDKMetric.SDKMetricType metricType, long metricValue, LogEntry logEntry, String metaData) {
        try {
            try {
                if (metricsEnabled) {
                    try {
                        Sdk.SDKMetric.Builder genMetric = genMetric(metricType, metricValue, logEntry, metaData);
                        try {
                            BlockingQueue<Sdk.SDKMetric.Builder> blockingQueue = metrics;
                            blockingQueue.put(genMetric);
                            Logger.INSTANCE.w(TAG, "Logging Metric " + metricType + " with value " + metricValue + " for placement " + (logEntry != null ? logEntry.getPlacementRefId() : null) + " mediation:" + genMetric.getMediationName());
                            if (blockingQueue.size() >= 20) {
                                report();
                            }
                        } catch (Exception e) {
                            e = e;
                            Logger.INSTANCE.e(TAG, "Cannot logMetrics", e);
                        }
                    } catch (Exception e2) {
                        e = e2;
                    }
                }
            } catch (Throwable th) {
                th = th;
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static /* synthetic */ void logMetric$vungle_ads_release$default(AnalyticsClient analyticsClient, SingleValueMetric singleValueMetric, LogEntry logEntry, String str, int i, Object obj) {
        if ((i & 2) != 0) {
            logEntry = null;
        }
        if ((i & 4) != 0) {
            str = singleValueMetric.getMeta();
        }
        analyticsClient.logMetric$vungle_ads_release(singleValueMetric, logEntry, str);
    }

    public final synchronized void logMetric$vungle_ads_release(SingleValueMetric singleValueMetric, LogEntry logEntry, String metaData) {
        try {
            try {
                Intrinsics.checkNotNullParameter(singleValueMetric, "singleValueMetric");
                logMetric$vungle_ads_release(singleValueMetric.getMetricType(), singleValueMetric.getValue(), logEntry, metaData);
            } catch (Throwable th) {
                th = th;
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static /* synthetic */ void logMetric$vungle_ads_release$default(AnalyticsClient analyticsClient, TimeIntervalMetric timeIntervalMetric, LogEntry logEntry, String str, int i, Object obj) {
        if ((i & 2) != 0) {
            logEntry = null;
        }
        if ((i & 4) != 0) {
            str = timeIntervalMetric.getMeta();
        }
        analyticsClient.logMetric$vungle_ads_release(timeIntervalMetric, logEntry, str);
    }

    public final synchronized void logMetric$vungle_ads_release(TimeIntervalMetric timeIntervalMetric, LogEntry logEntry, String metaData) {
        try {
            try {
                Intrinsics.checkNotNullParameter(timeIntervalMetric, "timeIntervalMetric");
                logMetric$vungle_ads_release(timeIntervalMetric.getMetricType(), timeIntervalMetric.getValue(), logEntry, metaData);
            } catch (Throwable th) {
                th = th;
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static /* synthetic */ void logMetric$vungle_ads_release$default(AnalyticsClient analyticsClient, OneShotTimeIntervalMetric oneShotTimeIntervalMetric, LogEntry logEntry, String str, int i, Object obj) {
        if ((i & 2) != 0) {
            logEntry = null;
        }
        if ((i & 4) != 0) {
            str = oneShotTimeIntervalMetric.getMeta();
        }
        analyticsClient.logMetric$vungle_ads_release(oneShotTimeIntervalMetric, logEntry, str);
    }

    public final synchronized void logMetric$vungle_ads_release(OneShotTimeIntervalMetric oneShotTimeIntervalMetric, LogEntry logEntry, String metaData) {
        Intrinsics.checkNotNullParameter(oneShotTimeIntervalMetric, "oneShotTimeIntervalMetric");
        if (!oneShotTimeIntervalMetric.getAlreadyLogged()) {
            logMetric$vungle_ads_release((TimeIntervalMetric) oneShotTimeIntervalMetric, logEntry, metaData);
            oneShotTimeIntervalMetric.markLogged();
        }
    }

    private final synchronized void report() {
        if (logLevel != LogLevel.ERROR_LOG_LEVEL_OFF && errors.size() > 0) {
            flushErrors();
        }
        if (metricsEnabled && metrics.size() > 0) {
            flushMetrics();
        }
    }

    private final void flushMetrics() {
        VungleApiClient vungleApiClient2;
        Logger.Companion companion = Logger.INSTANCE;
        StringBuilder sb = new StringBuilder("Sending ");
        BlockingQueue<Sdk.SDKMetric.Builder> blockingQueue = metrics;
        companion.d(TAG, sb.append(blockingQueue.size()).append(" metrics").toString());
        final LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue();
        blockingQueue.drainTo(linkedBlockingQueue);
        if (linkedBlockingQueue.isEmpty() || (vungleApiClient2 = vungleApiClient) == null) {
            return;
        }
        vungleApiClient2.reportMetrics(linkedBlockingQueue, new RequestListener() { // from class: com.vungle.ads.AnalyticsClient$flushMetrics$1
            @Override // com.vungle.ads.AnalyticsClient.RequestListener
            public void onSuccess() {
                Logger.INSTANCE.d("AnalyticsClient", "Sent " + linkedBlockingQueue.size() + " metrics");
            }

            @Override // com.vungle.ads.AnalyticsClient.RequestListener
            public void onFailure() {
                Logger.INSTANCE.d("AnalyticsClient", "Failed to send " + linkedBlockingQueue.size() + " metrics");
                AnalyticsClient.INSTANCE.getMetrics$vungle_ads_release().addAll(linkedBlockingQueue);
            }
        });
    }

    private final void flushErrors() {
        VungleApiClient vungleApiClient2;
        Logger.Companion companion = Logger.INSTANCE;
        StringBuilder sb = new StringBuilder("Sending ");
        BlockingQueue<Sdk.SDKError.Builder> blockingQueue = errors;
        companion.d(TAG, sb.append(blockingQueue.size()).append(" errors").toString());
        final LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue();
        blockingQueue.drainTo(linkedBlockingQueue);
        if (linkedBlockingQueue.isEmpty() || (vungleApiClient2 = vungleApiClient) == null) {
            return;
        }
        vungleApiClient2.reportErrors(linkedBlockingQueue, new RequestListener() { // from class: com.vungle.ads.AnalyticsClient$flushErrors$1
            @Override // com.vungle.ads.AnalyticsClient.RequestListener
            public void onSuccess() {
                Logger.INSTANCE.d("AnalyticsClient", "Sent " + linkedBlockingQueue.size() + " errors");
            }

            @Override // com.vungle.ads.AnalyticsClient.RequestListener
            public void onFailure() {
                Logger.INSTANCE.d("AnalyticsClient", "Failed to send " + linkedBlockingQueue.size() + " errors");
                AnalyticsClient.INSTANCE.getErrors$vungle_ads_release().addAll(linkedBlockingQueue);
            }
        });
    }
}
