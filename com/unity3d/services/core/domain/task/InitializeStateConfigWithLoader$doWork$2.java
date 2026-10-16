package com.unity3d.services.core.domain.task;

import com.unity3d.services.core.configuration.Configuration;
import com.unity3d.services.core.configuration.ConfigurationLoader;
import com.unity3d.services.core.configuration.ConfigurationRequestFactory;
import com.unity3d.services.core.configuration.ErrorState;
import com.unity3d.services.core.configuration.IConfigurationLoader;
import com.unity3d.services.core.configuration.InitRequestType;
import com.unity3d.services.core.configuration.InitializeEventsMetricSender;
import com.unity3d.services.core.configuration.PrivacyConfigStorage;
import com.unity3d.services.core.configuration.PrivacyConfigurationLoader;
import com.unity3d.services.core.device.reader.DeviceInfoDataFactory;
import com.unity3d.services.core.domain.ISDKDispatchers;
import com.unity3d.services.core.domain.task.InitializeStateConfigWithLoader;
import com.unity3d.services.core.domain.task.InitializeStateNetworkError;
import com.unity3d.services.core.extensions.AbortRetryException;
import com.unity3d.services.core.extensions.TaskExtensionsKt;
import com.unity3d.services.core.network.core.HttpClient;
import com.unity3d.services.core.request.metrics.SDKMetricsSender;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: InitializeStateConfigWithLoader.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "Lkotlin/Result;", "Lcom/unity3d/services/core/configuration/Configuration;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "com.unity3d.services.core.domain.task.InitializeStateConfigWithLoader$doWork$2", f = "InitializeStateConfigWithLoader.kt", i = {0, 0, 0, 1, 1, 2}, l = {58, 101, 109}, m = "invokeSuspend", n = {"$this$withContext", "configurationLoader", "config", "configurationLoader", "config", "config"}, s = {"L$0", "L$3", "L$4", "L$2", "L$3", "L$0"})
/* loaded from: classes7.dex */
final class InitializeStateConfigWithLoader$doWork$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Result<? extends Configuration>>, Object> {
    final /* synthetic */ InitializeStateConfigWithLoader.Params $params;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;
    final /* synthetic */ InitializeStateConfigWithLoader this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    InitializeStateConfigWithLoader$doWork$2(InitializeStateConfigWithLoader initializeStateConfigWithLoader, InitializeStateConfigWithLoader.Params params, Continuation<? super InitializeStateConfigWithLoader$doWork$2> continuation) {
        super(2, continuation);
        this.this$0 = initializeStateConfigWithLoader;
        this.$params = params;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        InitializeStateConfigWithLoader$doWork$2 initializeStateConfigWithLoader$doWork$2 = new InitializeStateConfigWithLoader$doWork$2(this.this$0, this.$params, continuation);
        initializeStateConfigWithLoader$doWork$2.L$0 = obj;
        return initializeStateConfigWithLoader$doWork$2;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Result<? extends Configuration>> continuation) {
        return ((InitializeStateConfigWithLoader$doWork$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:13:0x023d  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0244  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x01c0 A[Catch: all -> 0x022c, CancellationException -> 0x0259, TryCatch #6 {CancellationException -> 0x0259, all -> 0x022c, blocks: (B:8:0x001d, B:9:0x01f0, B:10:0x0221, B:26:0x01b6, B:28:0x01c0, B:32:0x01fa, B:33:0x020c, B:36:0x01ac, B:41:0x016a, B:43:0x0173, B:45:0x020d, B:46:0x021a, B:54:0x021b, B:57:0x0160, B:59:0x007e), top: B:2:0x000d }] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x01fa A[Catch: all -> 0x022c, CancellationException -> 0x0259, TryCatch #6 {CancellationException -> 0x0259, all -> 0x022c, blocks: (B:8:0x001d, B:9:0x01f0, B:10:0x0221, B:26:0x01b6, B:28:0x01c0, B:32:0x01fa, B:33:0x020c, B:36:0x01ac, B:41:0x016a, B:43:0x0173, B:45:0x020d, B:46:0x021a, B:54:0x021b, B:57:0x0160, B:59:0x007e), top: B:2:0x000d }] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0173 A[Catch: all -> 0x022c, CancellationException -> 0x0259, TRY_LEAVE, TryCatch #6 {CancellationException -> 0x0259, all -> 0x022c, blocks: (B:8:0x001d, B:9:0x01f0, B:10:0x0221, B:26:0x01b6, B:28:0x01c0, B:32:0x01fa, B:33:0x020c, B:36:0x01ac, B:41:0x016a, B:43:0x0173, B:45:0x020d, B:46:0x021a, B:54:0x021b, B:57:0x0160, B:59:0x007e), top: B:2:0x000d }] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x021b A[Catch: all -> 0x022c, CancellationException -> 0x0259, TryCatch #6 {CancellationException -> 0x0259, all -> 0x022c, blocks: (B:8:0x001d, B:9:0x01f0, B:10:0x0221, B:26:0x01b6, B:28:0x01c0, B:32:0x01fa, B:33:0x020c, B:36:0x01ac, B:41:0x016a, B:43:0x0173, B:45:0x020d, B:46:0x021a, B:54:0x021b, B:57:0x0160, B:59:0x007e), top: B:2:0x000d }] */
    /* JADX WARN: Type inference failed for: r0v14, types: [T, com.unity3d.services.core.configuration.Configuration] */
    /* JADX WARN: Type inference failed for: r5v1, types: [T, com.unity3d.services.core.configuration.ConfigurationLoader] */
    /* JADX WARN: Type inference failed for: r5v2, types: [T, com.unity3d.services.core.configuration.PrivacyConfigurationLoader] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        Object m10241constructorimpl;
        SDKMetricsSender sDKMetricsSender;
        SDKMetricsSender sDKMetricsSender2;
        Ref.ObjectRef objectRef;
        InitializeStateConfigWithLoader initializeStateConfigWithLoader;
        InitializeStateConfigWithLoader.Params params;
        Ref.ObjectRef objectRef2;
        Object m10241constructorimpl2;
        InitializeStateConfigWithLoader initializeStateConfigWithLoader2;
        InitializeStateConfigWithLoader.Params params2;
        Ref.ObjectRef objectRef3;
        Ref.ObjectRef objectRef4;
        Ref.ObjectRef objectRef5;
        InitializeStateNetworkError initializeStateNetworkError;
        Object obj2;
        Object m10241constructorimpl3;
        ISDKDispatchers iSDKDispatchers;
        Ref.ObjectRef objectRef6;
        Ref.ObjectRef objectRef7;
        T t;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        try {
        } catch (CancellationException e) {
            throw e;
        } catch (Throwable th) {
            Result.Companion companion = Result.INSTANCE;
            m10241constructorimpl = Result.m10241constructorimpl(ResultKt.createFailure(th));
        }
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            InitializeStateConfigWithLoader initializeStateConfigWithLoader3 = this.this$0;
            InitializeStateConfigWithLoader.Params params3 = this.$params;
            Result.Companion companion2 = Result.INSTANCE;
            PrivacyConfigStorage privacyConfigStorage = PrivacyConfigStorage.getInstance();
            sDKMetricsSender = initializeStateConfigWithLoader3.sdkMetricsSender;
            DeviceInfoDataFactory deviceInfoDataFactory = new DeviceInfoDataFactory(sDKMetricsSender);
            Ref.ObjectRef objectRef8 = new Ref.ObjectRef();
            ConfigurationRequestFactory configurationRequestFactory = new ConfigurationRequestFactory(params3.getConfig(), deviceInfoDataFactory.getDeviceInfoData(InitRequestType.TOKEN));
            sDKMetricsSender2 = initializeStateConfigWithLoader3.sdkMetricsSender;
            objectRef8.element = new ConfigurationLoader(configurationRequestFactory, sDKMetricsSender2, (HttpClient) initializeStateConfigWithLoader3.getServiceProvider().getRegistry().getService("", Reflection.getOrCreateKotlinClass(HttpClient.class)));
            objectRef8.element = new PrivacyConfigurationLoader((IConfigurationLoader) objectRef8.element, new ConfigurationRequestFactory(params3.getConfig(), deviceInfoDataFactory.getDeviceInfoData(InitRequestType.PRIVACY)), privacyConfigStorage, (HttpClient) initializeStateConfigWithLoader3.getServiceProvider().getRegistry().getService("", Reflection.getOrCreateKotlinClass(HttpClient.class)));
            Ref.ObjectRef objectRef9 = new Ref.ObjectRef();
            objectRef9.element = new Configuration();
            try {
                Result.Companion companion3 = Result.INSTANCE;
                int maxRetries = params3.getConfig().getMaxRetries();
                double retryScalingFactor = params3.getConfig().getRetryScalingFactor();
                long retryDelay = params3.getConfig().getRetryDelay();
                InitializationException initializationException = new InitializationException(ErrorState.NetworkConfigRequest, new Exception(), params3.getConfig());
                InitializeStateConfigWithLoader$doWork$2$1$configResult$1$1 initializeStateConfigWithLoader$doWork$2$1$configResult$1$1 = new InitializeStateConfigWithLoader$doWork$2$1$configResult$1$1(initializeStateConfigWithLoader3, objectRef8, objectRef9, null);
                this.L$0 = coroutineScope;
                this.L$1 = initializeStateConfigWithLoader3;
                this.L$2 = params3;
                this.L$3 = objectRef8;
                this.L$4 = objectRef9;
                this.label = 1;
                if (TaskExtensionsKt.withRetry(retryDelay, maxRetries, retryScalingFactor, initializationException, initializeStateConfigWithLoader$doWork$2$1$configResult$1$1, this) != coroutine_suspended) {
                    objectRef = objectRef9;
                    initializeStateConfigWithLoader = initializeStateConfigWithLoader3;
                    params = params3;
                    objectRef2 = objectRef8;
                }
            } catch (Throwable th2) {
                th = th2;
                objectRef = objectRef9;
                initializeStateConfigWithLoader = initializeStateConfigWithLoader3;
                params = params3;
                objectRef2 = objectRef8;
                Result.Companion companion4 = Result.INSTANCE;
                m10241constructorimpl2 = Result.m10241constructorimpl(ResultKt.createFailure(th));
                initializeStateConfigWithLoader2 = initializeStateConfigWithLoader;
                params2 = params;
                objectRef3 = objectRef2;
                if (Result.m10247isFailureimpl(m10241constructorimpl2)) {
                }
            }
            return coroutine_suspended;
        }
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                objectRef6 = (Ref.ObjectRef) this.L$1;
                objectRef7 = (Ref.ObjectRef) this.L$0;
                ResultKt.throwOnFailure(obj);
                Configuration configuration = (Configuration) objectRef7.element;
                Ref.ObjectRef objectRef10 = objectRef7;
                objectRef = objectRef6;
                objectRef4 = objectRef10;
                t = configuration;
                objectRef.element = t;
                m10241constructorimpl = Result.m10241constructorimpl((Configuration) objectRef4.element);
                if (Result.m10248isSuccessimpl(m10241constructorimpl)) {
                    Result.Companion companion5 = Result.INSTANCE;
                    m10241constructorimpl = Result.m10241constructorimpl(m10241constructorimpl);
                } else {
                    Throwable m10244exceptionOrNullimpl = Result.m10244exceptionOrNullimpl(m10241constructorimpl);
                    if (m10244exceptionOrNullimpl != null) {
                        Result.Companion companion6 = Result.INSTANCE;
                        m10241constructorimpl = Result.m10241constructorimpl(ResultKt.createFailure(m10244exceptionOrNullimpl));
                    }
                }
                return Result.m10240boximpl(m10241constructorimpl);
            }
            objectRef = (Ref.ObjectRef) this.L$4;
            objectRef5 = (Ref.ObjectRef) this.L$3;
            objectRef3 = (Ref.ObjectRef) this.L$2;
            params2 = (InitializeStateConfigWithLoader.Params) this.L$1;
            initializeStateConfigWithLoader2 = (InitializeStateConfigWithLoader) this.L$0;
            try {
                ResultKt.throwOnFailure(obj);
                obj2 = ((Result) obj).getValue();
                m10241constructorimpl3 = Result.m10241constructorimpl(Result.m10240boximpl(obj2));
            } catch (Throwable th3) {
                th = th3;
                Result.Companion companion7 = Result.INSTANCE;
                m10241constructorimpl3 = Result.m10241constructorimpl(ResultKt.createFailure(th));
                Ref.ObjectRef objectRef11 = objectRef5;
                Ref.ObjectRef objectRef12 = objectRef3;
                InitializeStateConfigWithLoader.Params params4 = params2;
                InitializeStateConfigWithLoader initializeStateConfigWithLoader4 = initializeStateConfigWithLoader2;
                if (!Result.m10248isSuccessimpl(m10241constructorimpl3)) {
                }
            }
            Ref.ObjectRef objectRef112 = objectRef5;
            Ref.ObjectRef objectRef122 = objectRef3;
            InitializeStateConfigWithLoader.Params params42 = params2;
            InitializeStateConfigWithLoader initializeStateConfigWithLoader42 = initializeStateConfigWithLoader2;
            if (!Result.m10248isSuccessimpl(m10241constructorimpl3)) {
                InitializeEventsMetricSender.getInstance().onRetryConfig();
                iSDKDispatchers = initializeStateConfigWithLoader42.dispatchers;
                CoroutineDispatcher io2 = iSDKDispatchers.getIo();
                InitializeStateConfigWithLoader$doWork$2$1$1 initializeStateConfigWithLoader$doWork$2$1$1 = new InitializeStateConfigWithLoader$doWork$2$1$1(objectRef122, objectRef112, initializeStateConfigWithLoader42, params42, null);
                this.L$0 = objectRef112;
                this.L$1 = objectRef;
                this.L$2 = null;
                this.L$3 = null;
                this.L$4 = null;
                this.label = 3;
                if (BuildersKt.withContext(io2, initializeStateConfigWithLoader$doWork$2$1$1, this) != coroutine_suspended) {
                    objectRef6 = objectRef;
                    objectRef7 = objectRef112;
                    Configuration configuration2 = (Configuration) objectRef7.element;
                    Ref.ObjectRef objectRef102 = objectRef7;
                    objectRef = objectRef6;
                    objectRef4 = objectRef102;
                    t = configuration2;
                    objectRef.element = t;
                    m10241constructorimpl = Result.m10241constructorimpl((Configuration) objectRef4.element);
                    if (Result.m10248isSuccessimpl(m10241constructorimpl)) {
                    }
                    return Result.m10240boximpl(m10241constructorimpl);
                }
                return coroutine_suspended;
            }
            throw new InitializationException(ErrorState.NetworkConfigRequest, new Exception("No connected events within the timeout!"), params42.getConfig());
        }
        objectRef = (Ref.ObjectRef) this.L$4;
        objectRef2 = (Ref.ObjectRef) this.L$3;
        params = (InitializeStateConfigWithLoader.Params) this.L$2;
        initializeStateConfigWithLoader = (InitializeStateConfigWithLoader) this.L$1;
        try {
            ResultKt.throwOnFailure(obj);
        } catch (Throwable th4) {
            th = th4;
            Result.Companion companion42 = Result.INSTANCE;
            m10241constructorimpl2 = Result.m10241constructorimpl(ResultKt.createFailure(th));
            initializeStateConfigWithLoader2 = initializeStateConfigWithLoader;
            params2 = params;
            objectRef3 = objectRef2;
            if (Result.m10247isFailureimpl(m10241constructorimpl2)) {
            }
        }
        m10241constructorimpl2 = Result.m10241constructorimpl(Unit.INSTANCE);
        initializeStateConfigWithLoader2 = initializeStateConfigWithLoader;
        params2 = params;
        objectRef3 = objectRef2;
        if (Result.m10247isFailureimpl(m10241constructorimpl2)) {
            Throwable m10244exceptionOrNullimpl2 = Result.m10244exceptionOrNullimpl(m10241constructorimpl2);
            if (m10244exceptionOrNullimpl2 instanceof AbortRetryException) {
                throw new InitializationException(ErrorState.NetworkConfigRequest, (Exception) m10244exceptionOrNullimpl2, params2.getConfig());
            }
            try {
                Result.Companion companion8 = Result.INSTANCE;
                initializeStateNetworkError = initializeStateConfigWithLoader2.initializeStateNetworkError;
                InitializeStateNetworkError.Params params5 = new InitializeStateNetworkError.Params(params2.getConfig());
                this.L$0 = initializeStateConfigWithLoader2;
                this.L$1 = params2;
                this.L$2 = objectRef3;
                this.L$3 = objectRef;
                this.L$4 = objectRef;
                this.label = 2;
                obj2 = initializeStateNetworkError.mo9272invokegIAlus(params5, this);
            } catch (Throwable th5) {
                th = th5;
                objectRef5 = objectRef;
                Result.Companion companion72 = Result.INSTANCE;
                m10241constructorimpl3 = Result.m10241constructorimpl(ResultKt.createFailure(th));
                Ref.ObjectRef objectRef1122 = objectRef5;
                Ref.ObjectRef objectRef1222 = objectRef3;
                InitializeStateConfigWithLoader.Params params422 = params2;
                InitializeStateConfigWithLoader initializeStateConfigWithLoader422 = initializeStateConfigWithLoader2;
                if (!Result.m10248isSuccessimpl(m10241constructorimpl3)) {
                }
            }
            if (obj2 != coroutine_suspended) {
                objectRef5 = objectRef;
                m10241constructorimpl3 = Result.m10241constructorimpl(Result.m10240boximpl(obj2));
                Ref.ObjectRef objectRef11222 = objectRef5;
                Ref.ObjectRef objectRef12222 = objectRef3;
                InitializeStateConfigWithLoader.Params params4222 = params2;
                InitializeStateConfigWithLoader initializeStateConfigWithLoader4222 = initializeStateConfigWithLoader2;
                if (!Result.m10248isSuccessimpl(m10241constructorimpl3)) {
                }
            }
            return coroutine_suspended;
        }
        objectRef4 = objectRef;
        t = (Configuration) objectRef.element;
        objectRef.element = t;
        m10241constructorimpl = Result.m10241constructorimpl((Configuration) objectRef4.element);
        if (Result.m10248isSuccessimpl(m10241constructorimpl)) {
        }
        return Result.m10240boximpl(m10241constructorimpl);
    }
}
