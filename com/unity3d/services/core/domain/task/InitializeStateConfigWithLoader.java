package com.unity3d.services.core.domain.task;

import com.unity3d.services.ads.token.TokenStorage;
import com.unity3d.services.core.configuration.Configuration;
import com.unity3d.services.core.di.IServiceProvider;
import com.unity3d.services.core.domain.ISDKDispatchers;
import com.unity3d.services.core.domain.task.BaseTask;
import com.unity3d.services.core.request.metrics.SDKMetricsSender;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;

/* compiled from: InitializeStateConfigWithLoader.kt */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0012B%\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ*\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00030\u000e2\u0006\u0010\u000f\u001a\u00020\u0002H\u0096@ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002ø\u0001\u0002¢\u0006\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u000f\n\u0002\b!\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\u0013"}, d2 = {"Lcom/unity3d/services/core/domain/task/InitializeStateConfigWithLoader;", "Lcom/unity3d/services/core/domain/task/BaseTask;", "Lcom/unity3d/services/core/domain/task/InitializeStateConfigWithLoader$Params;", "Lcom/unity3d/services/core/configuration/Configuration;", "dispatchers", "Lcom/unity3d/services/core/domain/ISDKDispatchers;", "initializeStateNetworkError", "Lcom/unity3d/services/core/domain/task/InitializeStateNetworkError;", "tokenStorage", "Lcom/unity3d/services/ads/token/TokenStorage;", "sdkMetricsSender", "Lcom/unity3d/services/core/request/metrics/SDKMetricsSender;", "(Lcom/unity3d/services/core/domain/ISDKDispatchers;Lcom/unity3d/services/core/domain/task/InitializeStateNetworkError;Lcom/unity3d/services/ads/token/TokenStorage;Lcom/unity3d/services/core/request/metrics/SDKMetricsSender;)V", "doWork", "Lkotlin/Result;", "params", "doWork-gIAlu-s", "(Lcom/unity3d/services/core/domain/task/InitializeStateConfigWithLoader$Params;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Params", "unity-ads_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes7.dex */
public final class InitializeStateConfigWithLoader implements BaseTask<Params, Configuration> {
    private final ISDKDispatchers dispatchers;
    private final InitializeStateNetworkError initializeStateNetworkError;
    private final SDKMetricsSender sdkMetricsSender;
    private final TokenStorage tokenStorage;

    public InitializeStateConfigWithLoader(ISDKDispatchers dispatchers, InitializeStateNetworkError initializeStateNetworkError, TokenStorage tokenStorage, SDKMetricsSender sdkMetricsSender) {
        Intrinsics.checkNotNullParameter(dispatchers, "dispatchers");
        Intrinsics.checkNotNullParameter(initializeStateNetworkError, "initializeStateNetworkError");
        Intrinsics.checkNotNullParameter(tokenStorage, "tokenStorage");
        Intrinsics.checkNotNullParameter(sdkMetricsSender, "sdkMetricsSender");
        this.dispatchers = dispatchers;
        this.initializeStateNetworkError = initializeStateNetworkError;
        this.tokenStorage = tokenStorage;
        this.sdkMetricsSender = sdkMetricsSender;
    }

    @Override // com.unity3d.services.core.di.IServiceComponent
    public IServiceProvider getServiceProvider() {
        return BaseTask.DefaultImpls.getServiceProvider(this);
    }

    @Override // com.unity3d.services.core.domain.task.BaseTask
    /* renamed from: invoke-gIAlu-s, reason: avoid collision after fix types in other method and not valid java name and merged with bridge method [inline-methods] */
    public Object mo9272invokegIAlus(Params params, Continuation<? super Result<? extends Configuration>> continuation) {
        return BaseTask.DefaultImpls.m9273invokegIAlus(this, params, continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    @Override // com.unity3d.services.core.domain.task.BaseTask
    /* renamed from: doWork-gIAlu-s, reason: avoid collision after fix types in other method and not valid java name and merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object mo9271doWorkgIAlus(Params params, Continuation<? super Result<? extends Configuration>> continuation) {
        InitializeStateConfigWithLoader$doWork$1 initializeStateConfigWithLoader$doWork$1;
        int i;
        if (continuation instanceof InitializeStateConfigWithLoader$doWork$1) {
            initializeStateConfigWithLoader$doWork$1 = (InitializeStateConfigWithLoader$doWork$1) continuation;
            if ((initializeStateConfigWithLoader$doWork$1.label & Integer.MIN_VALUE) != 0) {
                initializeStateConfigWithLoader$doWork$1.label -= Integer.MIN_VALUE;
                Object obj = initializeStateConfigWithLoader$doWork$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = initializeStateConfigWithLoader$doWork$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    CoroutineDispatcher coroutineDispatcher = this.dispatchers.getDefault();
                    InitializeStateConfigWithLoader$doWork$2 initializeStateConfigWithLoader$doWork$2 = new InitializeStateConfigWithLoader$doWork$2(this, params, null);
                    initializeStateConfigWithLoader$doWork$1.label = 1;
                    obj = BuildersKt.withContext(coroutineDispatcher, initializeStateConfigWithLoader$doWork$2, initializeStateConfigWithLoader$doWork$1);
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
        initializeStateConfigWithLoader$doWork$1 = new InitializeStateConfigWithLoader$doWork$1(this, continuation);
        Object obj2 = initializeStateConfigWithLoader$doWork$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = initializeStateConfigWithLoader$doWork$1.label;
        if (i != 0) {
        }
        return ((Result) obj2).getValue();
    }

    /* compiled from: InitializeStateConfigWithLoader.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lcom/unity3d/services/core/domain/task/InitializeStateConfigWithLoader$Params;", "Lcom/unity3d/services/core/domain/task/BaseParams;", "config", "Lcom/unity3d/services/core/configuration/Configuration;", "(Lcom/unity3d/services/core/configuration/Configuration;)V", "getConfig", "()Lcom/unity3d/services/core/configuration/Configuration;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "unity-ads_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final /* data */ class Params implements BaseParams {
        private final Configuration config;

        public static /* synthetic */ Params copy$default(Params params, Configuration configuration, int i, Object obj) {
            if ((i & 1) != 0) {
                configuration = params.config;
            }
            return params.copy(configuration);
        }

        /* renamed from: component1, reason: from getter */
        public final Configuration getConfig() {
            return this.config;
        }

        public final Params copy(Configuration config) {
            Intrinsics.checkNotNullParameter(config, "config");
            return new Params(config);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Params) && Intrinsics.areEqual(this.config, ((Params) other).config);
        }

        public int hashCode() {
            return this.config.hashCode();
        }

        public String toString() {
            return "Params(config=" + this.config + ')';
        }

        public Params(Configuration config) {
            Intrinsics.checkNotNullParameter(config, "config");
            this.config = config;
        }

        public final Configuration getConfig() {
            return this.config;
        }
    }
}
