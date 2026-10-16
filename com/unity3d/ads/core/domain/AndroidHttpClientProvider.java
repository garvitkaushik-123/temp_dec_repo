package com.unity3d.ads.core.domain;

import android.content.Context;
import com.google.android.gms.net.CronetProviderInstaller;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.unity3d.ads.core.configuration.AlternativeFlowReader;
import com.unity3d.ads.core.configuration.MediationTraitsMetadataReader;
import com.unity3d.ads.core.data.repository.SessionRepository;
import com.unity3d.ads.core.domain.SendDiagnosticEvent;
import com.unity3d.services.UnityAdsConstants;
import com.unity3d.services.core.configuration.Configuration;
import com.unity3d.services.core.configuration.IExperiments;
import com.unity3d.services.core.di.ServiceProvider;
import com.unity3d.services.core.domain.ISDKDispatchers;
import com.unity3d.services.core.domain.task.ConfigFileFromLocalStorage;
import com.unity3d.services.core.network.core.CronetClient;
import com.unity3d.services.core.network.core.CronetEngineBuilderFactory;
import com.unity3d.services.core.network.core.HttpClient;
import com.unity3d.services.core.network.core.LegacyHttpClient;
import com.unity3d.services.core.network.core.OkHttp3Client;
import com.unity3d.services.core.network.domain.CleanupDirectory;
import java.io.File;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.io.FilesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.time.Duration;
import kotlin.time.DurationUnit;
import kotlin.time.TimeSource;
import kotlinx.coroutines.BuildersKt__BuildersKt;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.TimeoutKt;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;
import okhttp3.OkHttpClient;
import org.chromium.net.CronetEngine;

/* compiled from: AndroidHttpClientProvider.kt */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001BM\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\u0006\u0010\u0012\u001a\u00020\u0013¢\u0006\u0002\u0010\u0014J\u0010\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\n\u001a\u00020\u000bH\u0002J!\u0010\u001d\u001a\u00020\u00182\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u0007H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010\u001eJ\u0019\u0010\u001f\u001a\u00020\u00182\u0006\u0010 \u001a\u00020\u0017H\u0096Bø\u0001\u0000¢\u0006\u0002\u0010!R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00180\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\""}, d2 = {"Lcom/unity3d/ads/core/domain/AndroidHttpClientProvider;", "Lcom/unity3d/ads/core/domain/HttpClientProvider;", "configFileFromLocalStorage", "Lcom/unity3d/services/core/domain/task/ConfigFileFromLocalStorage;", "alternativeFlowReader", "Lcom/unity3d/ads/core/configuration/AlternativeFlowReader;", "dispatchers", "Lcom/unity3d/services/core/domain/ISDKDispatchers;", "sendDiagnosticEvent", "Lcom/unity3d/ads/core/domain/SendDiagnosticEvent;", "context", "Landroid/content/Context;", "cronetEngineBuilderFactory", "Lcom/unity3d/services/core/network/core/CronetEngineBuilderFactory;", "sessionRepository", "Lcom/unity3d/ads/core/data/repository/SessionRepository;", "cleanupDirectory", "Lcom/unity3d/services/core/network/domain/CleanupDirectory;", "mediationTraitsMetadataReader", "Lcom/unity3d/ads/core/configuration/MediationTraitsMetadataReader;", "(Lcom/unity3d/services/core/domain/task/ConfigFileFromLocalStorage;Lcom/unity3d/ads/core/configuration/AlternativeFlowReader;Lcom/unity3d/services/core/domain/ISDKDispatchers;Lcom/unity3d/ads/core/domain/SendDiagnosticEvent;Landroid/content/Context;Lcom/unity3d/services/core/network/core/CronetEngineBuilderFactory;Lcom/unity3d/ads/core/data/repository/SessionRepository;Lcom/unity3d/services/core/network/domain/CleanupDirectory;Lcom/unity3d/ads/core/configuration/MediationTraitsMetadataReader;)V", "cacheHttpClientMap", "", "", "Lcom/unity3d/services/core/network/core/HttpClient;", "httpClientMutex", "Lkotlinx/coroutines/sync/Mutex;", "buildCronetCachePath", "", "buildNetworkClient", "(Landroid/content/Context;Lcom/unity3d/services/core/domain/ISDKDispatchers;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "invoke", "gatewaySpecific", "(ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "unity-ads_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes7.dex */
public final class AndroidHttpClientProvider implements HttpClientProvider {
    private final AlternativeFlowReader alternativeFlowReader;
    private final Map<Boolean, HttpClient> cacheHttpClientMap;
    private final CleanupDirectory cleanupDirectory;
    private final ConfigFileFromLocalStorage configFileFromLocalStorage;
    private final Context context;
    private final CronetEngineBuilderFactory cronetEngineBuilderFactory;
    private final ISDKDispatchers dispatchers;
    private final Mutex httpClientMutex;
    private final MediationTraitsMetadataReader mediationTraitsMetadataReader;
    private final SendDiagnosticEvent sendDiagnosticEvent;
    private final SessionRepository sessionRepository;

    public AndroidHttpClientProvider(ConfigFileFromLocalStorage configFileFromLocalStorage, AlternativeFlowReader alternativeFlowReader, ISDKDispatchers dispatchers, SendDiagnosticEvent sendDiagnosticEvent, Context context, CronetEngineBuilderFactory cronetEngineBuilderFactory, SessionRepository sessionRepository, CleanupDirectory cleanupDirectory, MediationTraitsMetadataReader mediationTraitsMetadataReader) {
        Intrinsics.checkNotNullParameter(configFileFromLocalStorage, "configFileFromLocalStorage");
        Intrinsics.checkNotNullParameter(alternativeFlowReader, "alternativeFlowReader");
        Intrinsics.checkNotNullParameter(dispatchers, "dispatchers");
        Intrinsics.checkNotNullParameter(sendDiagnosticEvent, "sendDiagnosticEvent");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(cronetEngineBuilderFactory, "cronetEngineBuilderFactory");
        Intrinsics.checkNotNullParameter(sessionRepository, "sessionRepository");
        Intrinsics.checkNotNullParameter(cleanupDirectory, "cleanupDirectory");
        Intrinsics.checkNotNullParameter(mediationTraitsMetadataReader, "mediationTraitsMetadataReader");
        this.configFileFromLocalStorage = configFileFromLocalStorage;
        this.alternativeFlowReader = alternativeFlowReader;
        this.dispatchers = dispatchers;
        this.sendDiagnosticEvent = sendDiagnosticEvent;
        this.context = context;
        this.cronetEngineBuilderFactory = cronetEngineBuilderFactory;
        this.sessionRepository = sessionRepository;
        this.cleanupDirectory = cleanupDirectory;
        this.mediationTraitsMetadataReader = mediationTraitsMetadataReader;
        this.httpClientMutex = MutexKt.Mutex$default(false, 1, null);
        this.cacheHttpClientMap = new LinkedHashMap();
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x00e7 A[Catch: all -> 0x0042, TryCatch #0 {all -> 0x0042, blocks: (B:12:0x003d, B:13:0x00e3, B:15:0x00e7, B:18:0x00f0, B:21:0x010e, B:23:0x016d), top: B:11:0x003d }] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x010e A[Catch: all -> 0x0042, TRY_LEAVE, TryCatch #0 {all -> 0x0042, blocks: (B:12:0x003d, B:13:0x00e3, B:15:0x00e7, B:18:0x00f0, B:21:0x010e, B:23:0x016d), top: B:11:0x003d }] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0128  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0083 A[Catch: all -> 0x017b, TryCatch #1 {all -> 0x017b, blocks: (B:37:0x0073, B:40:0x0083, B:42:0x009b, B:47:0x00a8, B:49:0x00b7, B:50:0x00c2, B:54:0x012b, B:56:0x013a, B:58:0x0140, B:60:0x0146, B:61:0x0163), top: B:36:0x0073 }] */
    /* JADX WARN: Removed duplicated region for block: B:65:0x005b  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002b  */
    /* JADX WARN: Type inference failed for: r6v0 */
    /* JADX WARN: Type inference failed for: r6v1, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r6v3 */
    /* JADX WARN: Type inference failed for: r6v6 */
    @Override // com.unity3d.ads.core.domain.HttpClientProvider
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object invoke(boolean z, Continuation<? super HttpClient> continuation) {
        AndroidHttpClientProvider$invoke$1 androidHttpClientProvider$invoke$1;
        int i;
        boolean z2;
        Mutex mutex;
        AndroidHttpClientProvider androidHttpClientProvider;
        Mutex mutex2;
        LegacyHttpClient legacyHttpClient;
        Object runBlocking$default;
        IExperiments experiments;
        int i2;
        AndroidHttpClientProvider androidHttpClientProvider2;
        boolean z3;
        long j;
        try {
            if (continuation instanceof AndroidHttpClientProvider$invoke$1) {
                androidHttpClientProvider$invoke$1 = (AndroidHttpClientProvider$invoke$1) continuation;
                if ((androidHttpClientProvider$invoke$1.label & Integer.MIN_VALUE) != 0) {
                    androidHttpClientProvider$invoke$1.label -= Integer.MIN_VALUE;
                    Object obj = androidHttpClientProvider$invoke$1.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i = androidHttpClientProvider$invoke$1.label;
                    ?? r6 = 0;
                    r6 = 0;
                    if (i != 0) {
                        ResultKt.throwOnFailure(obj);
                        Mutex mutex3 = this.httpClientMutex;
                        androidHttpClientProvider$invoke$1.L$0 = this;
                        androidHttpClientProvider$invoke$1.L$1 = mutex3;
                        z2 = z;
                        androidHttpClientProvider$invoke$1.Z$0 = z2;
                        androidHttpClientProvider$invoke$1.label = 1;
                        if (mutex3.lock(null, androidHttpClientProvider$invoke$1) != coroutine_suspended) {
                            mutex = mutex3;
                            androidHttpClientProvider = this;
                        }
                        return coroutine_suspended;
                    }
                    if (i != 1) {
                        if (i != 2) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        i2 = androidHttpClientProvider$invoke$1.I$0;
                        j = androidHttpClientProvider$invoke$1.J$0;
                        z3 = androidHttpClientProvider$invoke$1.Z$0;
                        mutex2 = (Mutex) androidHttpClientProvider$invoke$1.L$1;
                        androidHttpClientProvider2 = (AndroidHttpClientProvider) androidHttpClientProvider$invoke$1.L$0;
                        try {
                            ResultKt.throwOnFailure(obj);
                            legacyHttpClient = (HttpClient) obj;
                            if (i2 == 0) {
                                SendDiagnosticEvent.DefaultImpls.invoke$default(androidHttpClientProvider2.sendDiagnosticEvent, !(legacyHttpClient instanceof CronetClient) ? "native_cronet_failure_time" : "native_cronet_success_time", Boxing.boxDouble(Duration.m11610toDoubleimpl(TimeSource.Monotonic.ValueTimeMark.m11711elapsedNowUwyO8pc(j), DurationUnit.MILLISECONDS)), null, null, null, null, 60, null);
                            }
                            if (legacyHttpClient != null) {
                                androidHttpClientProvider = androidHttpClientProvider2;
                                z2 = z3;
                                legacyHttpClient = new OkHttp3Client(androidHttpClientProvider2.dispatchers, new OkHttpClient(), androidHttpClientProvider2.context, androidHttpClientProvider2.sessionRepository, androidHttpClientProvider2.cleanupDirectory, androidHttpClientProvider2.alternativeFlowReader);
                            } else {
                                androidHttpClientProvider = androidHttpClientProvider2;
                                z2 = z3;
                            }
                            androidHttpClientProvider.cacheHttpClientMap.put(Boxing.boxBoolean(z2), legacyHttpClient);
                            mutex = mutex2;
                            mutex.unlock(null);
                            return legacyHttpClient;
                        } catch (Throwable th) {
                            th = th;
                            mutex2.unlock(null);
                            throw th;
                        }
                    }
                    z2 = androidHttpClientProvider$invoke$1.Z$0;
                    mutex = (Mutex) androidHttpClientProvider$invoke$1.L$1;
                    androidHttpClientProvider = (AndroidHttpClientProvider) androidHttpClientProvider$invoke$1.L$0;
                    ResultKt.throwOnFailure(obj);
                    legacyHttpClient = androidHttpClientProvider.cacheHttpClientMap.get(Boxing.boxBoolean(z2));
                    if (legacyHttpClient != null) {
                        boolean invoke = androidHttpClientProvider.alternativeFlowReader.invoke();
                        boolean areEqual = Intrinsics.areEqual(androidHttpClientProvider.mediationTraitsMetadataReader.getBooleanTrait(MediationTraitsMetadataReader.USE_REFACTORED_HTTP_CLIENT), Boxing.boxBoolean(true));
                        if (!invoke) {
                            runBlocking$default = BuildersKt__BuildersKt.runBlocking$default(null, new AndroidHttpClientProvider$invoke$2$httpClient$config$1(androidHttpClientProvider, null), 1, null);
                            Configuration configuration = (Configuration) runBlocking$default;
                            if (configuration != null && (experiments = configuration.getExperiments()) != null && experiments.isOkHttpEnabled()) {
                                mutex2 = mutex;
                                legacyHttpClient = new OkHttp3Client(androidHttpClientProvider.dispatchers, new OkHttpClient(), androidHttpClientProvider.context, androidHttpClientProvider.sessionRepository, androidHttpClientProvider.cleanupDirectory, androidHttpClientProvider.alternativeFlowReader);
                            } else {
                                legacyHttpClient = new LegacyHttpClient(androidHttpClientProvider.dispatchers);
                                mutex2 = mutex;
                            }
                            androidHttpClientProvider.cacheHttpClientMap.put(Boxing.boxBoolean(z2), legacyHttpClient);
                            mutex = mutex2;
                        } else {
                            long m11706markNowz9LOYto = TimeSource.Monotonic.INSTANCE.m11706markNowz9LOYto();
                            if (z2 && areEqual) {
                                r6 = 1;
                            }
                            if (!areEqual && (legacyHttpClient = androidHttpClientProvider.cacheHttpClientMap.get(Boxing.boxBoolean(true ^ z2))) != null) {
                                androidHttpClientProvider.cacheHttpClientMap.put(Boxing.boxBoolean(z2), legacyHttpClient);
                            } else {
                                AndroidHttpClientProvider$invoke$2$httpClient$client$1 androidHttpClientProvider$invoke$2$httpClient$client$1 = new AndroidHttpClientProvider$invoke$2$httpClient$client$1(r6, androidHttpClientProvider, null);
                                androidHttpClientProvider$invoke$1.L$0 = androidHttpClientProvider;
                                androidHttpClientProvider$invoke$1.L$1 = mutex;
                                androidHttpClientProvider$invoke$1.Z$0 = z2;
                                androidHttpClientProvider$invoke$1.J$0 = m11706markNowz9LOYto;
                                androidHttpClientProvider$invoke$1.I$0 = r6;
                                androidHttpClientProvider$invoke$1.label = 2;
                                obj = TimeoutKt.withTimeoutOrNull(500L, androidHttpClientProvider$invoke$2$httpClient$client$1, androidHttpClientProvider$invoke$1);
                                if (obj != coroutine_suspended) {
                                    i2 = r6;
                                    mutex2 = mutex;
                                    androidHttpClientProvider2 = androidHttpClientProvider;
                                    z3 = z2;
                                    j = m11706markNowz9LOYto;
                                    legacyHttpClient = (HttpClient) obj;
                                    if (i2 == 0) {
                                    }
                                    if (legacyHttpClient != null) {
                                    }
                                    androidHttpClientProvider.cacheHttpClientMap.put(Boxing.boxBoolean(z2), legacyHttpClient);
                                    mutex = mutex2;
                                }
                                return coroutine_suspended;
                            }
                        }
                    }
                    mutex.unlock(null);
                    return legacyHttpClient;
                }
            }
            legacyHttpClient = androidHttpClientProvider.cacheHttpClientMap.get(Boxing.boxBoolean(z2));
            if (legacyHttpClient != null) {
            }
            mutex.unlock(null);
            return legacyHttpClient;
        } catch (Throwable th2) {
            th = th2;
            mutex2 = mutex;
            mutex2.unlock(null);
            throw th;
        }
        androidHttpClientProvider$invoke$1 = new AndroidHttpClientProvider$invoke$1(this, continuation);
        Object obj2 = androidHttpClientProvider$invoke$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = androidHttpClientProvider$invoke$1.label;
        ?? r62 = 0;
        r62 = 0;
        if (i != 0) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String buildCronetCachePath(Context context) {
        File filesDir = context.getFilesDir();
        Intrinsics.checkNotNullExpressionValue(filesDir, "context.filesDir");
        File resolve = FilesKt.resolve(filesDir, UnityAdsConstants.DefaultUrls.HTTP_CACHE_DIR_NAME);
        if (!resolve.exists()) {
            resolve.mkdirs();
        }
        String absolutePath = resolve.getAbsolutePath();
        Intrinsics.checkNotNullExpressionValue(absolutePath, "cacheDir.absolutePath");
        return absolutePath;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object buildNetworkClient(final Context context, final ISDKDispatchers iSDKDispatchers, Continuation<? super HttpClient> continuation) {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        final CancellableContinuationImpl cancellableContinuationImpl2 = cancellableContinuationImpl;
        CronetProviderInstaller.installProvider(context).addOnCompleteListener(new OnCompleteListener() { // from class: com.unity3d.ads.core.domain.AndroidHttpClientProvider$buildNetworkClient$2$1
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task<Void> it) {
                String str;
                SendDiagnosticEvent sendDiagnosticEvent;
                SessionRepository sessionRepository;
                CleanupDirectory cleanupDirectory;
                AlternativeFlowReader alternativeFlowReader;
                String message;
                SessionRepository sessionRepository2;
                long j;
                SendDiagnosticEvent sendDiagnosticEvent2;
                SessionRepository sessionRepository3;
                CleanupDirectory cleanupDirectory2;
                AlternativeFlowReader alternativeFlowReader2;
                CronetEngineBuilderFactory cronetEngineBuilderFactory;
                String buildCronetCachePath;
                SessionRepository sessionRepository4;
                Intrinsics.checkNotNullParameter(it, "it");
                str = "Errored without message.";
                if (it.isSuccessful()) {
                    sessionRepository2 = AndroidHttpClientProvider.this.sessionRepository;
                    if (sessionRepository2.getNativeConfiguration().hasCachedAssetsConfiguration()) {
                        sessionRepository4 = AndroidHttpClientProvider.this.sessionRepository;
                        long j2 = 1024;
                        j = sessionRepository4.getNativeConfiguration().getCachedAssetsConfiguration().getMaxCachedAssetSizeMb() * j2 * j2;
                    } else {
                        j = ServiceProvider.HTTP_CACHE_DISK_SIZE;
                    }
                    try {
                        cronetEngineBuilderFactory = AndroidHttpClientProvider.this.cronetEngineBuilderFactory;
                        CronetEngine.Builder createCronetEngineBuilder = cronetEngineBuilderFactory.createCronetEngineBuilder(context);
                        buildCronetCachePath = AndroidHttpClientProvider.this.buildCronetCachePath(context);
                        CronetEngine cronetEngine = createCronetEngineBuilder.setStoragePath(buildCronetCachePath).enableHttpCache(3, j).enableQuic(true).addQuicHint(ServiceProvider.GATEWAY_HOST, 443, 443).addQuicHint(ServiceProvider.CDN_CREATIVES_HOST, 443, 443).build();
                        CancellableContinuation<HttpClient> cancellableContinuation = cancellableContinuationImpl2;
                        Result.Companion companion = Result.INSTANCE;
                        Intrinsics.checkNotNullExpressionValue(cronetEngine, "cronetEngine");
                        cancellableContinuation.resumeWith(Result.m10241constructorimpl(new CronetClient(cronetEngine, iSDKDispatchers)));
                        return;
                    } catch (Throwable th) {
                        sendDiagnosticEvent2 = AndroidHttpClientProvider.this.sendDiagnosticEvent;
                        String message2 = th.getMessage();
                        SendDiagnosticEvent.DefaultImpls.invoke$default(sendDiagnosticEvent2, "native_cronet_engine_error", null, MapsKt.mapOf(TuplesKt.to("reason", message2 != null ? message2 : "Errored without message.")), null, null, null, 58, null);
                        CancellableContinuation<HttpClient> cancellableContinuation2 = cancellableContinuationImpl2;
                        Result.Companion companion2 = Result.INSTANCE;
                        ISDKDispatchers iSDKDispatchers2 = iSDKDispatchers;
                        OkHttpClient okHttpClient = new OkHttpClient();
                        Context context2 = context;
                        sessionRepository3 = AndroidHttpClientProvider.this.sessionRepository;
                        cleanupDirectory2 = AndroidHttpClientProvider.this.cleanupDirectory;
                        alternativeFlowReader2 = AndroidHttpClientProvider.this.alternativeFlowReader;
                        cancellableContinuation2.resumeWith(Result.m10241constructorimpl(new OkHttp3Client(iSDKDispatchers2, okHttpClient, context2, sessionRepository3, cleanupDirectory2, alternativeFlowReader2)));
                        return;
                    }
                }
                sendDiagnosticEvent = AndroidHttpClientProvider.this.sendDiagnosticEvent;
                Exception exception = it.getException();
                if (exception != null && (message = exception.getMessage()) != null) {
                    str = message;
                }
                SendDiagnosticEvent.DefaultImpls.invoke$default(sendDiagnosticEvent, "native_cronet_install_error", null, MapsKt.mapOf(TuplesKt.to("reason", str)), null, null, null, 58, null);
                CancellableContinuation<HttpClient> cancellableContinuation3 = cancellableContinuationImpl2;
                Result.Companion companion3 = Result.INSTANCE;
                ISDKDispatchers iSDKDispatchers3 = iSDKDispatchers;
                OkHttpClient okHttpClient2 = new OkHttpClient();
                Context context3 = context;
                sessionRepository = AndroidHttpClientProvider.this.sessionRepository;
                cleanupDirectory = AndroidHttpClientProvider.this.cleanupDirectory;
                alternativeFlowReader = AndroidHttpClientProvider.this.alternativeFlowReader;
                cancellableContinuation3.resumeWith(Result.m10241constructorimpl(new OkHttp3Client(iSDKDispatchers3, okHttpClient2, context3, sessionRepository, cleanupDirectory, alternativeFlowReader)));
            }
        });
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result;
    }
}
