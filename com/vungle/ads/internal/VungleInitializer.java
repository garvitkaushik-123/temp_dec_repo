package com.vungle.ads.internal;

import android.content.Context;
import androidx.core.content.ContextCompat;
import com.google.firebase.sessions.settings.RemoteSettings;
import com.ironsource.C3040d4;
import com.vungle.ads.AnalyticsClient;
import com.vungle.ads.InitializationListener;
import com.vungle.ads.InvalidAppId;
import com.vungle.ads.OutOfMemory;
import com.vungle.ads.SdkNotInitialized;
import com.vungle.ads.SdkVersionTooLow;
import com.vungle.ads.ServiceLocator;
import com.vungle.ads.SingleValueMetric;
import com.vungle.ads.TimeIntervalMetric;
import com.vungle.ads.VungleError;
import com.vungle.ads.VungleWrapperFramework;
import com.vungle.ads.internal.downloader.Downloader;
import com.vungle.ads.internal.executor.Executors;
import com.vungle.ads.internal.load.MraidJsLoader;
import com.vungle.ads.internal.model.ConfigPayload;
import com.vungle.ads.internal.network.VungleApiClient;
import com.vungle.ads.internal.network.VungleHeader;
import com.vungle.ads.internal.persistence.FilePreferences;
import com.vungle.ads.internal.privacy.PrivacyManager;
import com.vungle.ads.internal.protos.Sdk;
import com.vungle.ads.internal.task.CleanupJob;
import com.vungle.ads.internal.task.JobRunner;
import com.vungle.ads.internal.util.LogEntry;
import com.vungle.ads.internal.util.Logger;
import com.vungle.ads.internal.util.PathProvider;
import com.vungle.ads.internal.util.ThreadUtil;
import com.vungle.ads.internal.util.Utils;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: VungleInitializer.kt */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\b\u0000\u0018\u0000 *2\u00020\u0001:\u0001*B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J\r\u0010\u0019\u001a\u00020\u0014H\u0000¢\u0006\u0002\b\u001aJ\u0010\u0010\u001b\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\u0010\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u0018H\u0002J\u001e\u0010\u001f\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010 \u001a\u00020\u0007J\u0010\u0010!\u001a\u00020\u001d2\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J\u0006\u0010\b\u001a\u00020\u001dJ\u0010\u0010\"\u001a\u00020\u00142\u0006\u0010#\u001a\u00020$H\u0002J\b\u0010%\u001a\u00020\u0014H\u0002J\u0016\u0010&\u001a\u00020\u00142\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020\u0018R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010\b\u001a\u00020\t8\u0000@\u0000X\u0081\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\n\u0010\u0002\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR$\u0010\u000f\u001a\u00020\t8\u0000@\u0000X\u0081\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0010\u0010\u0002\u001a\u0004\b\u0011\u0010\f\"\u0004\b\u0012\u0010\u000e¨\u0006+²\u0006\n\u0010,\u001a\u00020-X\u008a\u0084\u0002²\u0006\n\u0010.\u001a\u00020/X\u008a\u0084\u0002²\u0006\n\u00100\u001a\u000201X\u008a\u0084\u0002²\u0006\n\u00102\u001a\u000203X\u008a\u0084\u0002²\u0006\n\u00104\u001a\u000205X\u008a\u0084\u0002²\u0006\n\u00106\u001a\u000207X\u008a\u0084\u0002²\u0006\n\u0010,\u001a\u00020-X\u008a\u0084\u0002"}, d2 = {"Lcom/vungle/ads/internal/VungleInitializer;", "", "()V", "initDurationMetric", "Lcom/vungle/ads/TimeIntervalMetric;", "initializationCallbackArray", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Lcom/vungle/ads/InitializationListener;", "isInitialized", "Ljava/util/concurrent/atomic/AtomicBoolean;", "isInitialized$vungle_ads_release$annotations", "isInitialized$vungle_ads_release", "()Ljava/util/concurrent/atomic/AtomicBoolean;", "setInitialized$vungle_ads_release", "(Ljava/util/concurrent/atomic/AtomicBoolean;)V", "isInitializing", "isInitializing$vungle_ads_release$annotations", "isInitializing$vungle_ads_release", "setInitializing$vungle_ads_release", "configure", "", "context", "Landroid/content/Context;", "appId", "", "deInit", "deInit$vungle_ads_release", "downloadMraidJs", "hasInvalidChar", "", "value", C3040d4.a.f, "initializationCallback", "isAppIdInvalid", "onInitError", "exception", "Lcom/vungle/ads/VungleError;", "onInitSuccess", "setIntegrationName", "wrapperFramework", "Lcom/vungle/ads/VungleWrapperFramework;", "wrapperFrameworkVersion", "Companion", "vungle-ads_release", "sdkExecutors", "Lcom/vungle/ads/internal/executor/Executors;", "vungleApiClient", "Lcom/vungle/ads/internal/network/VungleApiClient;", "filePreferences", "Lcom/vungle/ads/internal/persistence/FilePreferences;", "jobRunner", "Lcom/vungle/ads/internal/task/JobRunner;", "pathProvider", "Lcom/vungle/ads/internal/util/PathProvider;", "downloader", "Lcom/vungle/ads/internal/downloader/Downloader;"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes7.dex */
public final class VungleInitializer {
    private static final String TAG = "VungleInitializer";
    private AtomicBoolean isInitialized = new AtomicBoolean(false);
    private AtomicBoolean isInitializing = new AtomicBoolean(false);
    private final CopyOnWriteArrayList<InitializationListener> initializationCallbackArray = new CopyOnWriteArrayList<>();
    private final TimeIntervalMetric initDurationMetric = new TimeIntervalMetric(Sdk.SDKMetric.SDKMetricType.INIT_TO_SUCCESS_CALLBACK_DURATION_MS);

    public static /* synthetic */ void isInitialized$vungle_ads_release$annotations() {
    }

    public static /* synthetic */ void isInitializing$vungle_ads_release$annotations() {
    }

    /* renamed from: isInitialized$vungle_ads_release, reason: from getter */
    public final AtomicBoolean getIsInitialized() {
        return this.isInitialized;
    }

    public final void setInitialized$vungle_ads_release(AtomicBoolean atomicBoolean) {
        Intrinsics.checkNotNullParameter(atomicBoolean, "<set-?>");
        this.isInitialized = atomicBoolean;
    }

    /* renamed from: isInitializing$vungle_ads_release, reason: from getter */
    public final AtomicBoolean getIsInitializing() {
        return this.isInitializing;
    }

    public final void setInitializing$vungle_ads_release(AtomicBoolean atomicBoolean) {
        Intrinsics.checkNotNullParameter(atomicBoolean, "<set-?>");
        this.isInitializing = atomicBoolean;
    }

    public final void init(final String appId, final Context context, InitializationListener initializationCallback) {
        Intrinsics.checkNotNullParameter(appId, "appId");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(initializationCallback, "initializationCallback");
        AnalyticsClient.logMetric$vungle_ads_release$default(AnalyticsClient.INSTANCE, new SingleValueMetric(Sdk.SDKMetric.SDKMetricType.SDK_INIT_API), (LogEntry) null, (String) null, 6, (Object) null);
        this.initDurationMetric.markStart();
        this.initializationCallbackArray.add(initializationCallback);
        if (isAppIdInvalid(appId)) {
            onInitError(new InvalidAppId("App id invalid: " + appId + ", package name: " + context.getPackageName()).logError$vungle_ads_release());
            return;
        }
        if (Utils.INSTANCE.isOSVersionInvalid()) {
            Logger.INSTANCE.e(TAG, "Init: SDK is supported only for API versions 25 and above.");
            onInitError(new SdkVersionTooLow("Init: SDK is supported only for API versions 25 and above.").logError$vungle_ads_release());
            return;
        }
        ConfigManager.INSTANCE.setAppId$vungle_ads_release(appId);
        if (this.isInitialized.get()) {
            Logger.INSTANCE.d(TAG, "init already complete");
            onInitSuccess();
            return;
        }
        if (this.isInitializing.getAndSet(true)) {
            Logger.INSTANCE.d(TAG, "init already in progress");
            return;
        }
        if (ContextCompat.checkSelfPermission(context, "android.permission.ACCESS_NETWORK_STATE") != 0 || ContextCompat.checkSelfPermission(context, "android.permission.INTERNET") != 0) {
            Logger.INSTANCE.e(TAG, "Network permissions not granted");
            onInitError(new SdkNotInitialized("Network permissions not granted").logError$vungle_ads_release());
            return;
        }
        ServiceLocator.Companion companion = ServiceLocator.INSTANCE;
        Lazy lazy = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, (Function0) new Function0<Executors>() { // from class: com.vungle.ads.internal.VungleInitializer$init$$inlined$inject$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [com.vungle.ads.internal.executor.Executors, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final Executors invoke() {
                return ServiceLocator.INSTANCE.getInstance(context).getService(Executors.class);
            }
        });
        ServiceLocator.Companion companion2 = ServiceLocator.INSTANCE;
        final Lazy lazy2 = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, (Function0) new Function0<VungleApiClient>() { // from class: com.vungle.ads.internal.VungleInitializer$init$$inlined$inject$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [com.vungle.ads.internal.network.VungleApiClient, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final VungleApiClient invoke() {
                return ServiceLocator.INSTANCE.getInstance(context).getService(VungleApiClient.class);
            }
        });
        m9327init$lambda0(lazy).getBACKGROUND_EXECUTOR().execute(new Runnable() { // from class: com.vungle.ads.internal.VungleInitializer$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                VungleInitializer.m9329init$lambda2(context, appId, this, lazy2);
            }
        }, new Runnable() { // from class: com.vungle.ads.internal.VungleInitializer$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                VungleInitializer.m9330init$lambda3(VungleInitializer.this);
            }
        });
    }

    /* renamed from: init$lambda-0, reason: not valid java name */
    private static final Executors m9327init$lambda0(Lazy<? extends Executors> lazy) {
        return lazy.getValue();
    }

    /* renamed from: init$lambda-1, reason: not valid java name */
    private static final VungleApiClient m9328init$lambda1(Lazy<VungleApiClient> lazy) {
        return lazy.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: init$lambda-2, reason: not valid java name */
    public static final void m9329init$lambda2(Context context, String appId, VungleInitializer this$0, Lazy vungleApiClient$delegate) {
        Intrinsics.checkNotNullParameter(context, "$context");
        Intrinsics.checkNotNullParameter(appId, "$appId");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(vungleApiClient$delegate, "$vungleApiClient$delegate");
        PrivacyManager.INSTANCE.init(context);
        m9328init$lambda1(vungleApiClient$delegate).initialize(appId);
        this$0.configure(context, appId);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: init$lambda-3, reason: not valid java name */
    public static final void m9330init$lambda3(VungleInitializer this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.onInitError(new OutOfMemory("Config: Out of Memory").logError$vungle_ads_release());
    }

    private final boolean isAppIdInvalid(String appId) {
        return StringsKt.isBlank(appId) || hasInvalidChar(appId);
    }

    private final void configure(final Context context, String appId) {
        final Context context2;
        boolean z;
        try {
            ServiceLocator.Companion companion = ServiceLocator.INSTANCE;
            ConfigPayload cachedConfig = ConfigManager.INSTANCE.getCachedConfig(m9322configure$lambda4(LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, (Function0) new Function0<FilePreferences>() { // from class: com.vungle.ads.internal.VungleInitializer$configure$$inlined$inject$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                /* JADX WARN: Type inference failed for: r0v2, types: [com.vungle.ads.internal.persistence.FilePreferences, java.lang.Object] */
                @Override // kotlin.jvm.functions.Function0
                public final FilePreferences invoke() {
                    return ServiceLocator.INSTANCE.getInstance(context).getService(FilePreferences.class);
                }
            })), appId);
            if (cachedConfig != null) {
                context2 = context;
                ConfigManager.initWithConfig$vungle_ads_release$default(ConfigManager.INSTANCE, context2, cachedConfig, true, null, 8, null);
                z = true;
            } else {
                context2 = context;
                z = false;
            }
            this.isInitialized.set(true);
            onInitSuccess();
            Logger.INSTANCE.d(TAG, "Running cleanup and resend tpat jobs. " + Thread.currentThread().getId());
            ServiceLocator.Companion companion2 = ServiceLocator.INSTANCE;
            m9323configure$lambda5(LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, (Function0) new Function0<JobRunner>() { // from class: com.vungle.ads.internal.VungleInitializer$configure$$inlined$inject$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                /* JADX WARN: Type inference failed for: r0v2, types: [com.vungle.ads.internal.task.JobRunner, java.lang.Object] */
                @Override // kotlin.jvm.functions.Function0
                public final JobRunner invoke() {
                    return ServiceLocator.INSTANCE.getInstance(context2).getService(JobRunner.class);
                }
            })).execute(CleanupJob.Companion.makeJobInfo$default(CleanupJob.INSTANCE, null, 1, null));
            if (z) {
                downloadMraidJs(context2);
            } else {
                ConfigManager.INSTANCE.fetchConfigAsync$vungle_ads_release(context2, new Function1<Boolean, Unit>() { // from class: com.vungle.ads.internal.VungleInitializer$configure$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                        invoke(bool.booleanValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(boolean z2) {
                        if (z2) {
                            VungleInitializer.this.downloadMraidJs(context2);
                        }
                    }
                });
            }
        } catch (Throwable th) {
            Logger.INSTANCE.e(TAG, "Cannot get config", th);
        }
    }

    /* renamed from: configure$lambda-4, reason: not valid java name */
    private static final FilePreferences m9322configure$lambda4(Lazy<FilePreferences> lazy) {
        return lazy.getValue();
    }

    /* renamed from: configure$lambda-5, reason: not valid java name */
    private static final JobRunner m9323configure$lambda5(Lazy<? extends JobRunner> lazy) {
        return lazy.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void downloadMraidJs(final Context context) {
        ServiceLocator.Companion companion = ServiceLocator.INSTANCE;
        Lazy lazy = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, (Function0) new Function0<PathProvider>() { // from class: com.vungle.ads.internal.VungleInitializer$downloadMraidJs$$inlined$inject$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [com.vungle.ads.internal.util.PathProvider, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final PathProvider invoke() {
                return ServiceLocator.INSTANCE.getInstance(context).getService(PathProvider.class);
            }
        });
        ServiceLocator.Companion companion2 = ServiceLocator.INSTANCE;
        Lazy lazy2 = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, (Function0) new Function0<Downloader>() { // from class: com.vungle.ads.internal.VungleInitializer$downloadMraidJs$$inlined$inject$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [com.vungle.ads.internal.downloader.Downloader, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final Downloader invoke() {
                return ServiceLocator.INSTANCE.getInstance(context).getService(Downloader.class);
            }
        });
        ServiceLocator.Companion companion3 = ServiceLocator.INSTANCE;
        MraidJsLoader.downloadJs$default(MraidJsLoader.INSTANCE, m9324downloadMraidJs$lambda6(lazy), m9325downloadMraidJs$lambda7(lazy2), m9326downloadMraidJs$lambda8(LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, (Function0) new Function0<Executors>() { // from class: com.vungle.ads.internal.VungleInitializer$downloadMraidJs$$inlined$inject$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [com.vungle.ads.internal.executor.Executors, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final Executors invoke() {
                return ServiceLocator.INSTANCE.getInstance(context).getService(Executors.class);
            }
        })).getBACKGROUND_EXECUTOR(), null, null, 24, null);
    }

    /* renamed from: downloadMraidJs$lambda-6, reason: not valid java name */
    private static final PathProvider m9324downloadMraidJs$lambda6(Lazy<PathProvider> lazy) {
        return lazy.getValue();
    }

    /* renamed from: downloadMraidJs$lambda-7, reason: not valid java name */
    private static final Downloader m9325downloadMraidJs$lambda7(Lazy<? extends Downloader> lazy) {
        return lazy.getValue();
    }

    /* renamed from: downloadMraidJs$lambda-8, reason: not valid java name */
    private static final Executors m9326downloadMraidJs$lambda8(Lazy<? extends Executors> lazy) {
        return lazy.getValue();
    }

    private final void onInitError(final VungleError exception) {
        this.isInitializing.set(false);
        String localizedMessage = exception.getLocalizedMessage();
        if (localizedMessage == null) {
            localizedMessage = "Exception code is " + exception.getCode();
        }
        this.initDurationMetric.setMetricType(Sdk.SDKMetric.SDKMetricType.INIT_TO_FAIL_CALLBACK_DURATION_MS);
        this.initDurationMetric.markEnd();
        AnalyticsClient.INSTANCE.logMetric$vungle_ads_release(this.initDurationMetric, (LogEntry) null, localizedMessage);
        ThreadUtil.INSTANCE.runOnUiThread(new Function0<Unit>() { // from class: com.vungle.ads.internal.VungleInitializer$onInitError$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                CopyOnWriteArrayList copyOnWriteArrayList;
                CopyOnWriteArrayList copyOnWriteArrayList2;
                Logger.INSTANCE.e("VungleInitializer", "onError");
                copyOnWriteArrayList = VungleInitializer.this.initializationCallbackArray;
                VungleError vungleError = exception;
                Iterator it = copyOnWriteArrayList.iterator();
                while (it.hasNext()) {
                    ((InitializationListener) it.next()).onError(vungleError);
                }
                copyOnWriteArrayList2 = VungleInitializer.this.initializationCallbackArray;
                copyOnWriteArrayList2.clear();
            }
        });
        Logger.INSTANCE.e(TAG, localizedMessage);
    }

    private final void onInitSuccess() {
        this.isInitializing.set(false);
        this.initDurationMetric.setMetricType(Sdk.SDKMetric.SDKMetricType.INIT_TO_SUCCESS_CALLBACK_DURATION_MS);
        this.initDurationMetric.markEnd();
        AnalyticsClient.logMetric$vungle_ads_release$default(AnalyticsClient.INSTANCE, this.initDurationMetric, (LogEntry) null, (String) null, 6, (Object) null);
        Logger.INSTANCE.d(TAG, "onSuccess " + Thread.currentThread().getId());
        ThreadUtil.INSTANCE.runOnUiThread(new Function0<Unit>() { // from class: com.vungle.ads.internal.VungleInitializer$onInitSuccess$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                CopyOnWriteArrayList copyOnWriteArrayList;
                CopyOnWriteArrayList copyOnWriteArrayList2;
                copyOnWriteArrayList = VungleInitializer.this.initializationCallbackArray;
                Iterator it = copyOnWriteArrayList.iterator();
                while (it.hasNext()) {
                    ((InitializationListener) it.next()).onSuccess();
                }
                copyOnWriteArrayList2 = VungleInitializer.this.initializationCallbackArray;
                copyOnWriteArrayList2.clear();
            }
        });
    }

    private final boolean hasInvalidChar(String value) {
        String str = value;
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            if (!Character.isLetterOrDigit(charAt) && charAt != '.') {
                return true;
            }
        }
        return false;
    }

    public final boolean isInitialized() {
        return this.isInitialized.get();
    }

    public final void deInit$vungle_ads_release() {
        ServiceLocator.INSTANCE.deInit();
        VungleApiClient.INSTANCE.reset$vungle_ads_release();
        this.isInitialized.set(false);
        this.isInitializing.set(false);
        this.initializationCallbackArray.clear();
    }

    public final void setIntegrationName(VungleWrapperFramework wrapperFramework, String wrapperFrameworkVersion) {
        Intrinsics.checkNotNullParameter(wrapperFramework, "wrapperFramework");
        Intrinsics.checkNotNullParameter(wrapperFrameworkVersion, "wrapperFrameworkVersion");
        if (wrapperFramework == VungleWrapperFramework.none) {
            Logger.INSTANCE.e(TAG, "Wrapper is null or is none");
            return;
        }
        String headerUa = VungleHeader.INSTANCE.getHeaderUa();
        String str = wrapperFramework.name() + (wrapperFrameworkVersion.length() > 0 ? RemoteSettings.FORWARD_SLASH_STRING + wrapperFrameworkVersion : "");
        if (StringsKt.contains$default((CharSequence) headerUa, (CharSequence) str, false, 2, (Object) null)) {
            Logger.INSTANCE.w(TAG, "Wrapper info already set");
            return;
        }
        VungleHeader.INSTANCE.setHeaderUa(headerUa + ';' + str);
        if (isInitialized()) {
            Logger.INSTANCE.w(TAG, "VUNGLE WARNING: SDK already initialized, you should've set wrapper info before");
        }
    }
}
