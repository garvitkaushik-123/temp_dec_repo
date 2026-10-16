package com.unity3d.services.core.domain.task;

import com.unity3d.services.ads.gmascar.bridges.mobileads.MobileAdsBridgeBase;
import com.unity3d.services.core.configuration.Configuration;
import com.unity3d.services.core.configuration.ErrorState;
import com.unity3d.services.core.domain.ISDKDispatchers;
import com.unity3d.services.core.domain.task.InitializeStateError;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;

/* compiled from: InitializeSDK.kt */
@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001BM\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\u0006\u0010\u0014\u001a\u00020\u0015¢\u0006\u0002\u0010\u0016J*\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00030\u00182\u0006\u0010\u0019\u001a\u00020\u0002H\u0096@ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002ø\u0001\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ<\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00030\u00182\u0006\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u0010!\u001a\u00020\"H\u0082@ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002ø\u0001\u0002¢\u0006\u0004\b#\u0010$J\b\u0010%\u001a\u00020&H\u0016J\u0019\u0010'\u001a\u00020\u00032\u0006\u0010(\u001a\u00020)H\u0082@ø\u0001\u0002¢\u0006\u0002\u0010*R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u000f\n\u0002\b!\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006+"}, d2 = {"Lcom/unity3d/services/core/domain/task/InitializeSDK;", "Lcom/unity3d/services/core/domain/task/MetricTask;", "Lcom/unity3d/services/core/domain/task/EmptyParams;", "", "dispatchers", "Lcom/unity3d/services/core/domain/ISDKDispatchers;", "configFileFromLocalStorage", "Lcom/unity3d/services/core/domain/task/ConfigFileFromLocalStorage;", "initializeStateReset", "Lcom/unity3d/services/core/domain/task/InitializeStateReset;", "initializeStateError", "Lcom/unity3d/services/core/domain/task/InitializeStateError;", "initializeStateConfig", "Lcom/unity3d/services/core/domain/task/InitializeStateConfig;", "initializeStateCreate", "Lcom/unity3d/services/core/domain/task/InitializeStateCreate;", "initializeStateLoadCache", "Lcom/unity3d/services/core/domain/task/InitializeStateLoadCache;", "initializeStateLoadWeb", "Lcom/unity3d/services/core/domain/task/InitializeStateLoadWeb;", "initializeStateComplete", "Lcom/unity3d/services/core/domain/task/InitializeStateComplete;", "(Lcom/unity3d/services/core/domain/ISDKDispatchers;Lcom/unity3d/services/core/domain/task/ConfigFileFromLocalStorage;Lcom/unity3d/services/core/domain/task/InitializeStateReset;Lcom/unity3d/services/core/domain/task/InitializeStateError;Lcom/unity3d/services/core/domain/task/InitializeStateConfig;Lcom/unity3d/services/core/domain/task/InitializeStateCreate;Lcom/unity3d/services/core/domain/task/InitializeStateLoadCache;Lcom/unity3d/services/core/domain/task/InitializeStateLoadWeb;Lcom/unity3d/services/core/domain/task/InitializeStateComplete;)V", "doWork", "Lkotlin/Result;", "params", "doWork-gIAlu-s", "(Lcom/unity3d/services/core/domain/task/EmptyParams;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "executeErrorState", "errorState", "Lcom/unity3d/services/core/configuration/ErrorState;", "taskException", "", "configuration", "Lcom/unity3d/services/core/configuration/Configuration;", "executeErrorState-BWLJW6A", "(Lcom/unity3d/services/core/configuration/ErrorState;Ljava/lang/Throwable;Lcom/unity3d/services/core/configuration/Configuration;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getMetricName", "", "handleInitializationException", "exception", "Lcom/unity3d/services/core/domain/task/InitializationException;", "(Lcom/unity3d/services/core/domain/task/InitializationException;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "unity-ads_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes7.dex */
public final class InitializeSDK extends MetricTask<EmptyParams, Unit> {
    private final ConfigFileFromLocalStorage configFileFromLocalStorage;
    private final ISDKDispatchers dispatchers;
    private final InitializeStateComplete initializeStateComplete;
    private final InitializeStateConfig initializeStateConfig;
    private final InitializeStateCreate initializeStateCreate;
    private final InitializeStateError initializeStateError;
    private final InitializeStateLoadCache initializeStateLoadCache;
    private final InitializeStateLoadWeb initializeStateLoadWeb;
    private final InitializeStateReset initializeStateReset;

    @Override // com.unity3d.services.core.domain.task.BaseTask
    /* renamed from: doWork-gIAlu-s */
    public /* bridge */ /* synthetic */ Object mo9271doWorkgIAlus(BaseParams baseParams, Continuation continuation) {
        return m9277doWorkgIAlus((EmptyParams) baseParams, (Continuation<? super Result<Unit>>) continuation);
    }

    public InitializeSDK(ISDKDispatchers dispatchers, ConfigFileFromLocalStorage configFileFromLocalStorage, InitializeStateReset initializeStateReset, InitializeStateError initializeStateError, InitializeStateConfig initializeStateConfig, InitializeStateCreate initializeStateCreate, InitializeStateLoadCache initializeStateLoadCache, InitializeStateLoadWeb initializeStateLoadWeb, InitializeStateComplete initializeStateComplete) {
        Intrinsics.checkNotNullParameter(dispatchers, "dispatchers");
        Intrinsics.checkNotNullParameter(configFileFromLocalStorage, "configFileFromLocalStorage");
        Intrinsics.checkNotNullParameter(initializeStateReset, "initializeStateReset");
        Intrinsics.checkNotNullParameter(initializeStateError, "initializeStateError");
        Intrinsics.checkNotNullParameter(initializeStateConfig, "initializeStateConfig");
        Intrinsics.checkNotNullParameter(initializeStateCreate, "initializeStateCreate");
        Intrinsics.checkNotNullParameter(initializeStateLoadCache, "initializeStateLoadCache");
        Intrinsics.checkNotNullParameter(initializeStateLoadWeb, "initializeStateLoadWeb");
        Intrinsics.checkNotNullParameter(initializeStateComplete, "initializeStateComplete");
        this.dispatchers = dispatchers;
        this.configFileFromLocalStorage = configFileFromLocalStorage;
        this.initializeStateReset = initializeStateReset;
        this.initializeStateError = initializeStateError;
        this.initializeStateConfig = initializeStateConfig;
        this.initializeStateCreate = initializeStateCreate;
        this.initializeStateLoadCache = initializeStateLoadCache;
        this.initializeStateLoadWeb = initializeStateLoadWeb;
        this.initializeStateComplete = initializeStateComplete;
    }

    @Override // com.unity3d.services.core.domain.task.MetricTask
    public String getMetricName() {
        return getMetricNameForInitializeTask(MobileAdsBridgeBase.initializeMethodName);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /* renamed from: doWork-gIAlu-s, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object m9277doWorkgIAlus(EmptyParams emptyParams, Continuation<? super Result<Unit>> continuation) {
        InitializeSDK$doWork$1 initializeSDK$doWork$1;
        int i;
        if (continuation instanceof InitializeSDK$doWork$1) {
            initializeSDK$doWork$1 = (InitializeSDK$doWork$1) continuation;
            if ((initializeSDK$doWork$1.label & Integer.MIN_VALUE) != 0) {
                initializeSDK$doWork$1.label -= Integer.MIN_VALUE;
                Object obj = initializeSDK$doWork$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = initializeSDK$doWork$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    CoroutineDispatcher coroutineDispatcher = this.dispatchers.getDefault();
                    InitializeSDK$doWork$2 initializeSDK$doWork$2 = new InitializeSDK$doWork$2(this, null);
                    initializeSDK$doWork$1.label = 1;
                    obj = BuildersKt.withContext(coroutineDispatcher, initializeSDK$doWork$2, initializeSDK$doWork$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                return ((Result) obj).getValue();
            }
        }
        initializeSDK$doWork$1 = new InitializeSDK$doWork$1(this, continuation);
        Object obj2 = initializeSDK$doWork$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = initializeSDK$doWork$1.label;
        if (i != 0) {
        }
        return ((Result) obj2).getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:14:0x003b  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object handleInitializationException(InitializationException initializationException, Continuation<? super Unit> continuation) {
        InitializeSDK$handleInitializationException$1 initializeSDK$handleInitializationException$1;
        int i;
        if (continuation instanceof InitializeSDK$handleInitializationException$1) {
            initializeSDK$handleInitializationException$1 = (InitializeSDK$handleInitializationException$1) continuation;
            if ((initializeSDK$handleInitializationException$1.label & Integer.MIN_VALUE) != 0) {
                initializeSDK$handleInitializationException$1.label -= Integer.MIN_VALUE;
                Object obj = initializeSDK$handleInitializationException$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = initializeSDK$handleInitializationException$1.label;
                if (i == 0) {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    InitializationException initializationException2 = (InitializationException) initializeSDK$handleInitializationException$1.L$0;
                    ResultKt.throwOnFailure(obj);
                    ((Result) obj).getValue();
                    throw initializationException2;
                }
                ResultKt.throwOnFailure(obj);
                ErrorState errorState = initializationException.getErrorState();
                Throwable originalException = initializationException.getOriginalException();
                Configuration config = initializationException.getConfig();
                initializeSDK$handleInitializationException$1.L$0 = initializationException;
                initializeSDK$handleInitializationException$1.label = 1;
                if (m9276executeErrorStateBWLJW6A(errorState, originalException, config, initializeSDK$handleInitializationException$1) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                throw initializationException;
            }
        }
        initializeSDK$handleInitializationException$1 = new InitializeSDK$handleInitializationException$1(this, continuation);
        Object obj2 = initializeSDK$handleInitializationException$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = initializeSDK$handleInitializationException$1.label;
        if (i == 0) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0038  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /* renamed from: executeErrorState-BWLJW6A, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object m9276executeErrorStateBWLJW6A(ErrorState errorState, Throwable th, Configuration configuration, Continuation<? super Result<Unit>> continuation) {
        InitializeSDK$executeErrorState$1 initializeSDK$executeErrorState$1;
        int i;
        if (continuation instanceof InitializeSDK$executeErrorState$1) {
            initializeSDK$executeErrorState$1 = (InitializeSDK$executeErrorState$1) continuation;
            if ((initializeSDK$executeErrorState$1.label & Integer.MIN_VALUE) != 0) {
                initializeSDK$executeErrorState$1.label -= Integer.MIN_VALUE;
                Object obj = initializeSDK$executeErrorState$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = initializeSDK$executeErrorState$1.label;
                if (i == 0) {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                    return ((Result) obj).getValue();
                }
                ResultKt.throwOnFailure(obj);
                InitializeStateError initializeStateError = this.initializeStateError;
                InitializeStateError.Params params = new InitializeStateError.Params(errorState, new Exception(th != null ? th.getMessage() : null), configuration);
                initializeSDK$executeErrorState$1.label = 1;
                Object obj2 = initializeStateError.mo9272invokegIAlus(params, initializeSDK$executeErrorState$1);
                return obj2 == coroutine_suspended ? coroutine_suspended : obj2;
            }
        }
        initializeSDK$executeErrorState$1 = new InitializeSDK$executeErrorState$1(this, continuation);
        Object obj3 = initializeSDK$executeErrorState$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = initializeSDK$executeErrorState$1.label;
        if (i == 0) {
        }
    }
}
