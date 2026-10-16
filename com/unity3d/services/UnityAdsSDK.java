package com.unity3d.services;

import android.app.Activity;
import android.content.Context;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.ironsource.C3207n2;
import com.ironsource.L2;
import com.unity3d.ads.IUnityAdsLoadListener;
import com.unity3d.ads.IUnityAdsTokenListener;
import com.unity3d.ads.TokenConfiguration;
import com.unity3d.ads.UnityAdsLoadOptions;
import com.unity3d.ads.UnityAdsShowOptions;
import com.unity3d.ads.core.configuration.AlternativeFlowReader;
import com.unity3d.ads.core.data.model.InitializationState;
import com.unity3d.ads.core.data.model.Listeners;
import com.unity3d.ads.core.domain.AndroidGetAdPlayerContext;
import com.unity3d.ads.core.domain.GetAdObject;
import com.unity3d.ads.core.domain.GetAsyncHeaderBiddingToken;
import com.unity3d.ads.core.domain.GetGameId;
import com.unity3d.ads.core.domain.GetHeaderBiddingToken;
import com.unity3d.ads.core.domain.GetInitializationState;
import com.unity3d.ads.core.domain.HandleInvocationsFromAdViewer;
import com.unity3d.ads.core.domain.InitializeBoldSDK;
import com.unity3d.ads.core.domain.LegacyShowUseCase;
import com.unity3d.ads.core.domain.SendDiagnosticEvent;
import com.unity3d.ads.core.domain.ShouldAllowInitialization;
import com.unity3d.ads.core.domain.TokenNumberProvider;
import com.unity3d.ads.core.domain.om.OmFinishSession;
import com.unity3d.ads.core.extensions.ExceptionExtensionsKt;
import com.unity3d.ads.core.extensions.TimeExtensionsKt;
import com.unity3d.services.ads.gmascar.bridges.mobileads.MobileAdsBridgeBase;
import com.unity3d.services.banners.UnityBannerSize;
import com.unity3d.services.core.di.IServiceComponent;
import com.unity3d.services.core.di.IServiceProvider;
import com.unity3d.services.core.di.ServiceProvider;
import com.unity3d.services.core.domain.task.InitializeSDK;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.time.TimeSource;
import kotlinx.coroutines.BuildersKt__BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt__JobKt;

/* compiled from: UnityAdsSDK.kt */
@Metadata(d1 = {"\u0000¦\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010\bJ\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0006J\b\u0010\f\u001a\u00020\u0003H\u0016J\b\u0010\r\u001a\u0004\u0018\u00010\u0006J\u0010\u0010\r\u001a\u00020\n2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fJ\u001a\u0010\r\u001a\u00020\n2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fJ\u001a\u0010\u0012\u001a\u00020\n2\b\u0010\u0013\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u0014\u001a\u00020\u0006J.\u0010\u0015\u001a\u00020\n2\b\u0010\u0016\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0017\u001a\u00020\u00182\b\u0010\u000e\u001a\u0004\u0018\u00010\u00192\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001bJ\u0006\u0010\u001c\u001a\u00020\u001dJ*\u0010\u001e\u001a\u00020\n2\u0006\u0010\u001f\u001a\u00020 2\b\u0010\u0016\u001a\u0004\u0018\u00010\u00062\b\u0010!\u001a\u0004\u0018\u00010\"2\u0006\u0010\u000e\u001a\u00020#R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006$²\u0006\n\u0010%\u001a\u00020&X\u008a\u0084\u0002²\u0006\n\u0010'\u001a\u00020(X\u008a\u0084\u0002²\u0006\n\u0010)\u001a\u00020*X\u008a\u0084\u0002²\u0006\n\u0010+\u001a\u00020,X\u008a\u0084\u0002²\u0006\n\u0010-\u001a\u00020.X\u008a\u0084\u0002²\u0006\n\u0010/\u001a\u000200X\u008a\u0084\u0002²\u0006\n\u0010-\u001a\u00020.X\u008a\u0084\u0002²\u0006\n\u00101\u001a\u000202X\u008a\u0084\u0002²\u0006\n\u00103\u001a\u000204X\u008a\u0084\u0002²\u0006\n\u00101\u001a\u000202X\u008a\u0084\u0002²\u0006\n\u00105\u001a\u000206X\u008a\u0084\u0002²\u0006\n\u00107\u001a\u000208X\u008a\u0084\u0002²\u0006\n\u00109\u001a\u00020:X\u008a\u0084\u0002²\u0006\n\u0010'\u001a\u00020(X\u008a\u0084\u0002²\u0006\n\u0010;\u001a\u00020<X\u008a\u0084\u0002²\u0006\n\u0010=\u001a\u00020>X\u008a\u0084\u0002²\u0006\n\u0010'\u001a\u00020(X\u008a\u0084\u0002²\u0006\n\u00109\u001a\u00020:X\u008a\u0084\u0002"}, d2 = {"Lcom/unity3d/services/UnityAdsSDK;", "Lcom/unity3d/services/core/di/IServiceComponent;", "serviceProvider", "Lcom/unity3d/services/core/di/IServiceProvider;", "(Lcom/unity3d/services/core/di/IServiceProvider;)V", "fetchToken", "", "sync", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "finishOMIDSession", "Lkotlinx/coroutines/Job;", "opportunityId", "getServiceProvider", "getToken", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/unity3d/ads/IUnityAdsTokenListener;", "tokenConfiguration", "Lcom/unity3d/ads/TokenConfiguration;", MobileAdsBridgeBase.initializeMethodName, AndroidGetAdPlayerContext.KEY_GAME_ID, "source", "load", "placementId", HandleInvocationsFromAdViewer.KEY_LOAD_OPTIONS, "Lcom/unity3d/ads/UnityAdsLoadOptions;", "Lcom/unity3d/ads/IUnityAdsLoadListener;", L2.u, "Lcom/unity3d/services/banners/UnityBannerSize;", "sendBannerDestroyed", "", C3207n2.v, "activity", "Landroid/app/Activity;", "showOptions", "Lcom/unity3d/ads/UnityAdsShowOptions;", "Lcom/unity3d/ads/core/data/model/Listeners;", "unity-ads_release", "shouldAllowInitialization", "Lcom/unity3d/ads/core/domain/ShouldAllowInitialization;", "alternativeFlowReader", "Lcom/unity3d/ads/core/configuration/AlternativeFlowReader;", "initializeSDK", "Lcom/unity3d/services/core/domain/task/InitializeSDK;", "initializeBoldSDK", "Lcom/unity3d/ads/core/domain/InitializeBoldSDK;", "getGameId", "Lcom/unity3d/ads/core/domain/GetGameId;", "context", "Landroid/content/Context;", "tokenNumberProvider", "Lcom/unity3d/ads/core/domain/TokenNumberProvider;", "getAsyncHeaderBiddingToken", "Lcom/unity3d/ads/core/domain/GetAsyncHeaderBiddingToken;", "getHeaderBiddingToken", "Lcom/unity3d/ads/core/domain/GetHeaderBiddingToken;", "getInitializationState", "Lcom/unity3d/ads/core/domain/GetInitializationState;", "sendDiagnosticEvent", "Lcom/unity3d/ads/core/domain/SendDiagnosticEvent;", "getAdObject", "Lcom/unity3d/ads/core/domain/GetAdObject;", "omFinishSession", "Lcom/unity3d/ads/core/domain/om/OmFinishSession;"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes7.dex */
public final class UnityAdsSDK implements IServiceComponent {
    private final IServiceProvider serviceProvider;

    /* JADX WARN: Multi-variable type inference failed */
    public UnityAdsSDK() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public UnityAdsSDK(IServiceProvider serviceProvider) {
        Intrinsics.checkNotNullParameter(serviceProvider, "serviceProvider");
        this.serviceProvider = serviceProvider;
    }

    public /* synthetic */ UnityAdsSDK(ServiceProvider serviceProvider, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? ServiceProvider.INSTANCE : serviceProvider);
    }

    @Override // com.unity3d.services.core.di.IServiceComponent
    public IServiceProvider getServiceProvider() {
        return this.serviceProvider;
    }

    public static /* synthetic */ Job initialize$default(UnityAdsSDK unityAdsSDK, String str, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = "api";
        }
        return unityAdsSDK.initialize(str, str2);
    }

    private static final ShouldAllowInitialization initialize$lambda$0(Lazy<? extends ShouldAllowInitialization> lazy) {
        return lazy.getValue();
    }

    public final synchronized Job initialize(String gameId, String source) {
        Job launch$default;
        CompletableJob Job$default;
        Intrinsics.checkNotNullParameter(source, "source");
        final UnityAdsSDK unityAdsSDK = this;
        final String str = "";
        if (!initialize$lambda$0(LazyKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new Function0<ShouldAllowInitialization>() { // from class: com.unity3d.services.UnityAdsSDK$initialize$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v3, types: [com.unity3d.ads.core.domain.ShouldAllowInitialization, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final ShouldAllowInitialization invoke() {
                IServiceComponent iServiceComponent = IServiceComponent.this;
                return iServiceComponent.getServiceProvider().getRegistry().getService(str, Reflection.getOrCreateKotlinClass(ShouldAllowInitialization.class));
            }
        })).invoke(gameId)) {
            Job$default = JobKt__JobKt.Job$default((Job) null, 1, (Object) null);
            return Job$default;
        }
        final UnityAdsSDK unityAdsSDK2 = this;
        final String str2 = "";
        Lazy lazy = LazyKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new Function0<AlternativeFlowReader>() { // from class: com.unity3d.services.UnityAdsSDK$initialize$$inlined$inject$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v3, types: [com.unity3d.ads.core.configuration.AlternativeFlowReader, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final AlternativeFlowReader invoke() {
                IServiceComponent iServiceComponent = IServiceComponent.this;
                return iServiceComponent.getServiceProvider().getRegistry().getService(str2, Reflection.getOrCreateKotlinClass(AlternativeFlowReader.class));
            }
        });
        final UnityAdsSDK unityAdsSDK3 = this;
        final String str3 = "";
        Lazy lazy2 = LazyKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new Function0<InitializeSDK>() { // from class: com.unity3d.services.UnityAdsSDK$initialize$$inlined$inject$default$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v3, types: [com.unity3d.services.core.domain.task.InitializeSDK, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final InitializeSDK invoke() {
                IServiceComponent iServiceComponent = IServiceComponent.this;
                return iServiceComponent.getServiceProvider().getRegistry().getService(str3, Reflection.getOrCreateKotlinClass(InitializeSDK.class));
            }
        });
        final UnityAdsSDK unityAdsSDK4 = this;
        final String str4 = "";
        Lazy lazy3 = LazyKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new Function0<InitializeBoldSDK>() { // from class: com.unity3d.services.UnityAdsSDK$initialize$$inlined$inject$default$4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v3, types: [com.unity3d.ads.core.domain.InitializeBoldSDK, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final InitializeBoldSDK invoke() {
                IServiceComponent iServiceComponent = IServiceComponent.this;
                return iServiceComponent.getServiceProvider().getRegistry().getService(str4, Reflection.getOrCreateKotlinClass(InitializeBoldSDK.class));
            }
        });
        CoroutineScope coroutineScope = (CoroutineScope) getServiceProvider().getRegistry().getService(ServiceProvider.NAMED_INIT_SCOPE, Reflection.getOrCreateKotlinClass(CoroutineScope.class));
        launch$default = BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new UnityAdsSDK$initialize$1(source, coroutineScope, lazy, lazy3, lazy2, null), 3, null);
        return launch$default;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AlternativeFlowReader initialize$lambda$1(Lazy<? extends AlternativeFlowReader> lazy) {
        return lazy.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final InitializeSDK initialize$lambda$2(Lazy<InitializeSDK> lazy) {
        return lazy.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final InitializeBoldSDK initialize$lambda$3(Lazy<? extends InitializeBoldSDK> lazy) {
        return lazy.getValue();
    }

    public static /* synthetic */ Job load$default(UnityAdsSDK unityAdsSDK, String str, UnityAdsLoadOptions unityAdsLoadOptions, IUnityAdsLoadListener iUnityAdsLoadListener, UnityBannerSize unityBannerSize, int i, Object obj) {
        if ((i & 8) != 0) {
            unityBannerSize = null;
        }
        return unityAdsSDK.load(str, unityAdsLoadOptions, iUnityAdsLoadListener, unityBannerSize);
    }

    private static final GetGameId load$lambda$4(Lazy<? extends GetGameId> lazy) {
        return lazy.getValue();
    }

    public final Job load(String placementId, UnityAdsLoadOptions loadOptions, IUnityAdsLoadListener listener, UnityBannerSize bannerSize) {
        Job launch$default;
        Intrinsics.checkNotNullParameter(loadOptions, "loadOptions");
        final UnityAdsSDK unityAdsSDK = this;
        final String str = "";
        initialize(load$lambda$4(LazyKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new Function0<GetGameId>() { // from class: com.unity3d.services.UnityAdsSDK$load$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v3, types: [com.unity3d.ads.core.domain.GetGameId, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final GetGameId invoke() {
                IServiceComponent iServiceComponent = IServiceComponent.this;
                return iServiceComponent.getServiceProvider().getRegistry().getService(str, Reflection.getOrCreateKotlinClass(GetGameId.class));
            }
        })).invoke(), "load");
        CoroutineScope coroutineScope = (CoroutineScope) unityAdsSDK.getServiceProvider().getRegistry().getService(ServiceProvider.NAMED_LOAD_SCOPE, Reflection.getOrCreateKotlinClass(CoroutineScope.class));
        launch$default = BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new UnityAdsSDK$load$1(this, placementId, loadOptions, listener, bannerSize, coroutineScope, LazyKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new Function0<Context>() { // from class: com.unity3d.services.UnityAdsSDK$load$$inlined$inject$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v3, types: [android.content.Context, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final Context invoke() {
                IServiceComponent iServiceComponent = IServiceComponent.this;
                return iServiceComponent.getServiceProvider().getRegistry().getService(str, Reflection.getOrCreateKotlinClass(Context.class));
            }
        }), null), 3, null);
        return launch$default;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Context load$lambda$5(Lazy<? extends Context> lazy) {
        return lazy.getValue();
    }

    public final Job show(Activity activity, String placementId, UnityAdsShowOptions showOptions, Listeners listener) {
        Job launch$default;
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(listener, "listener");
        UnityAdsSDK unityAdsSDK = this;
        CoroutineScope coroutineScope = (CoroutineScope) unityAdsSDK.getServiceProvider().getRegistry().getService(ServiceProvider.NAMED_SHOW_SCOPE, Reflection.getOrCreateKotlinClass(CoroutineScope.class));
        launch$default = BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new UnityAdsSDK$show$1((LegacyShowUseCase) unityAdsSDK.getServiceProvider().getRegistry().getService("", Reflection.getOrCreateKotlinClass(LegacyShowUseCase.class)), activity, placementId, showOptions, listener, coroutineScope, null), 3, null);
        return launch$default;
    }

    public final String getToken() {
        Object runBlocking$default;
        runBlocking$default = BuildersKt__BuildersKt.runBlocking$default(null, new UnityAdsSDK$getToken$1(this, null), 1, null);
        return (String) runBlocking$default;
    }

    public final Job getToken(IUnityAdsTokenListener listener) {
        return getToken(null, listener);
    }

    private static final GetGameId getToken$lambda$6(Lazy<? extends GetGameId> lazy) {
        return lazy.getValue();
    }

    public final Job getToken(TokenConfiguration tokenConfiguration, IUnityAdsTokenListener listener) {
        Job launch$default;
        final UnityAdsSDK unityAdsSDK = this;
        final String str = "";
        initialize(getToken$lambda$6(LazyKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new Function0<GetGameId>() { // from class: com.unity3d.services.UnityAdsSDK$getToken$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v3, types: [com.unity3d.ads.core.domain.GetGameId, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final GetGameId invoke() {
                IServiceComponent iServiceComponent = IServiceComponent.this;
                return iServiceComponent.getServiceProvider().getRegistry().getService(str, Reflection.getOrCreateKotlinClass(GetGameId.class));
            }
        })).invoke(), "get_token");
        Lazy lazy = LazyKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new Function0<TokenNumberProvider>() { // from class: com.unity3d.services.UnityAdsSDK$getToken$$inlined$inject$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v3, types: [com.unity3d.ads.core.domain.TokenNumberProvider, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final TokenNumberProvider invoke() {
                IServiceComponent iServiceComponent = IServiceComponent.this;
                return iServiceComponent.getServiceProvider().getRegistry().getService(str, Reflection.getOrCreateKotlinClass(TokenNumberProvider.class));
            }
        });
        Lazy lazy2 = LazyKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new Function0<GetAsyncHeaderBiddingToken>() { // from class: com.unity3d.services.UnityAdsSDK$getToken$$inlined$inject$default$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v3, types: [com.unity3d.ads.core.domain.GetAsyncHeaderBiddingToken, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final GetAsyncHeaderBiddingToken invoke() {
                IServiceComponent iServiceComponent = IServiceComponent.this;
                return iServiceComponent.getServiceProvider().getRegistry().getService(str, Reflection.getOrCreateKotlinClass(GetAsyncHeaderBiddingToken.class));
            }
        });
        CoroutineScope coroutineScope = (CoroutineScope) unityAdsSDK.getServiceProvider().getRegistry().getService(ServiceProvider.NAMED_GET_TOKEN_SCOPE, Reflection.getOrCreateKotlinClass(CoroutineScope.class));
        launch$default = BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new UnityAdsSDK$getToken$2(tokenConfiguration, listener, coroutineScope, lazy2, lazy, null), 3, null);
        return launch$default;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final TokenNumberProvider getToken$lambda$7(Lazy<? extends TokenNumberProvider> lazy) {
        return lazy.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final GetAsyncHeaderBiddingToken getToken$lambda$8(Lazy<? extends GetAsyncHeaderBiddingToken> lazy) {
        return lazy.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object fetchToken(String str, Continuation<? super String> continuation) {
        String str2;
        String str3;
        String str4;
        Object runBlocking$default;
        final UnityAdsSDK unityAdsSDK = this;
        final String str5 = "";
        Lazy lazy = LazyKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new Function0<TokenNumberProvider>() { // from class: com.unity3d.services.UnityAdsSDK$fetchToken$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v3, types: [com.unity3d.ads.core.domain.TokenNumberProvider, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final TokenNumberProvider invoke() {
                IServiceComponent iServiceComponent = IServiceComponent.this;
                return iServiceComponent.getServiceProvider().getRegistry().getService(str5, Reflection.getOrCreateKotlinClass(TokenNumberProvider.class));
            }
        });
        Lazy lazy2 = LazyKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new Function0<GetHeaderBiddingToken>() { // from class: com.unity3d.services.UnityAdsSDK$fetchToken$$inlined$inject$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v3, types: [com.unity3d.ads.core.domain.GetHeaderBiddingToken, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final GetHeaderBiddingToken invoke() {
                IServiceComponent iServiceComponent = IServiceComponent.this;
                return iServiceComponent.getServiceProvider().getRegistry().getService(str5, Reflection.getOrCreateKotlinClass(GetHeaderBiddingToken.class));
            }
        });
        Lazy lazy3 = LazyKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new Function0<GetInitializationState>() { // from class: com.unity3d.services.UnityAdsSDK$fetchToken$$inlined$inject$default$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v3, types: [com.unity3d.ads.core.domain.GetInitializationState, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final GetInitializationState invoke() {
                IServiceComponent iServiceComponent = IServiceComponent.this;
                return iServiceComponent.getServiceProvider().getRegistry().getService(str5, Reflection.getOrCreateKotlinClass(GetInitializationState.class));
            }
        });
        Lazy lazy4 = LazyKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new Function0<SendDiagnosticEvent>() { // from class: com.unity3d.services.UnityAdsSDK$fetchToken$$inlined$inject$default$4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v3, types: [com.unity3d.ads.core.domain.SendDiagnosticEvent, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final SendDiagnosticEvent invoke() {
                IServiceComponent iServiceComponent = IServiceComponent.this;
                return iServiceComponent.getServiceProvider().getRegistry().getService(str5, Reflection.getOrCreateKotlinClass(SendDiagnosticEvent.class));
            }
        });
        long m11706markNowz9LOYto = TimeSource.Monotonic.INSTANCE.m11706markNowz9LOYto();
        SendDiagnosticEvent.DefaultImpls.invoke$default(fetchToken$lambda$12(lazy4), "native_gateway_token_started", null, MapsKt.mapOf(TuplesKt.to("sync", str), TuplesKt.to("state", GetInitializationState.DefaultImpls.invoke$default(fetchToken$lambda$11(lazy3), false, 1, null).toString())), null, null, null, 58, null);
        if (GetInitializationState.DefaultImpls.invoke$default(fetchToken$lambda$11(lazy3), false, 1, null) == InitializationState.INITIALIZED) {
            try {
                runBlocking$default = BuildersKt__BuildersKt.runBlocking$default(null, new UnityAdsSDK$fetchToken$token$1(lazy2, lazy, null), 1, null);
                str4 = (String) runBlocking$default;
                str2 = null;
                str3 = null;
            } catch (Exception e) {
                String shortenedStackTrace$default = ExceptionExtensionsKt.getShortenedStackTrace$default(e, 0, 1, null);
                str2 = "uncaught_exception";
                str3 = shortenedStackTrace$default;
                str4 = null;
            }
        } else {
            str2 = "not_initialized";
            str3 = null;
            str4 = null;
        }
        SendDiagnosticEvent fetchToken$lambda$12 = fetchToken$lambda$12(lazy4);
        String str6 = str4 == null ? "native_gateway_token_failure_time" : "native_gateway_token_success_time";
        Double boxDouble = Boxing.boxDouble(TimeExtensionsKt.elapsedMillis(TimeSource.Monotonic.ValueTimeMark.m11707boximpl(m11706markNowz9LOYto)));
        Map createMapBuilder = MapsKt.createMapBuilder();
        createMapBuilder.put("sync", str);
        createMapBuilder.put("state", GetInitializationState.DefaultImpls.invoke$default(fetchToken$lambda$11(lazy3), false, 1, null).toString());
        if (str2 != null) {
        }
        if (str3 != null) {
            createMapBuilder.put("reason_debug", str3);
        }
        Unit unit = Unit.INSTANCE;
        SendDiagnosticEvent.DefaultImpls.invoke$default(fetchToken$lambda$12, str6, boxDouble, MapsKt.build(createMapBuilder), null, null, Boxing.boxInt(fetchToken$lambda$9(lazy).invoke()), 24, null);
        return str4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final TokenNumberProvider fetchToken$lambda$9(Lazy<? extends TokenNumberProvider> lazy) {
        return lazy.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final GetHeaderBiddingToken fetchToken$lambda$10(Lazy<? extends GetHeaderBiddingToken> lazy) {
        return lazy.getValue();
    }

    private static final GetInitializationState fetchToken$lambda$11(Lazy<? extends GetInitializationState> lazy) {
        return lazy.getValue();
    }

    private static final SendDiagnosticEvent fetchToken$lambda$12(Lazy<? extends SendDiagnosticEvent> lazy) {
        return lazy.getValue();
    }

    private static final AlternativeFlowReader finishOMIDSession$lambda$16(Lazy<? extends AlternativeFlowReader> lazy) {
        return lazy.getValue();
    }

    public final Job finishOMIDSession(String opportunityId) {
        Job launch$default;
        CompletableJob Job$default;
        Intrinsics.checkNotNullParameter(opportunityId, "opportunityId");
        final UnityAdsSDK unityAdsSDK = this;
        final String str = "";
        if (!finishOMIDSession$lambda$16(LazyKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new Function0<AlternativeFlowReader>() { // from class: com.unity3d.services.UnityAdsSDK$finishOMIDSession$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v3, types: [com.unity3d.ads.core.configuration.AlternativeFlowReader, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final AlternativeFlowReader invoke() {
                IServiceComponent iServiceComponent = IServiceComponent.this;
                return iServiceComponent.getServiceProvider().getRegistry().getService(str, Reflection.getOrCreateKotlinClass(AlternativeFlowReader.class));
            }
        })).invoke()) {
            Job$default = JobKt__JobKt.Job$default((Job) null, 1, (Object) null);
            Job$default.complete();
            return Job$default;
        }
        Lazy lazy = LazyKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new Function0<GetAdObject>() { // from class: com.unity3d.services.UnityAdsSDK$finishOMIDSession$$inlined$inject$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v3, types: [com.unity3d.ads.core.domain.GetAdObject, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final GetAdObject invoke() {
                IServiceComponent iServiceComponent = IServiceComponent.this;
                return iServiceComponent.getServiceProvider().getRegistry().getService(str, Reflection.getOrCreateKotlinClass(GetAdObject.class));
            }
        });
        Lazy lazy2 = LazyKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new Function0<OmFinishSession>() { // from class: com.unity3d.services.UnityAdsSDK$finishOMIDSession$$inlined$inject$default$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v3, types: [com.unity3d.ads.core.domain.om.OmFinishSession, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final OmFinishSession invoke() {
                IServiceComponent iServiceComponent = IServiceComponent.this;
                return iServiceComponent.getServiceProvider().getRegistry().getService(str, Reflection.getOrCreateKotlinClass(OmFinishSession.class));
            }
        });
        CoroutineScope coroutineScope = (CoroutineScope) unityAdsSDK.getServiceProvider().getRegistry().getService(ServiceProvider.NAMED_OMID_SCOPE, Reflection.getOrCreateKotlinClass(CoroutineScope.class));
        launch$default = BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new UnityAdsSDK$finishOMIDSession$2(opportunityId, coroutineScope, lazy, lazy2, null), 3, null);
        return launch$default;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final GetAdObject finishOMIDSession$lambda$18(Lazy<? extends GetAdObject> lazy) {
        return lazy.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final OmFinishSession finishOMIDSession$lambda$19(Lazy<? extends OmFinishSession> lazy) {
        return lazy.getValue();
    }

    private static final AlternativeFlowReader sendBannerDestroyed$lambda$20(Lazy<? extends AlternativeFlowReader> lazy) {
        return lazy.getValue();
    }

    public final void sendBannerDestroyed() {
        final UnityAdsSDK unityAdsSDK = this;
        final String str = "";
        if (sendBannerDestroyed$lambda$20(LazyKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new Function0<AlternativeFlowReader>() { // from class: com.unity3d.services.UnityAdsSDK$sendBannerDestroyed$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v3, types: [com.unity3d.ads.core.configuration.AlternativeFlowReader, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final AlternativeFlowReader invoke() {
                IServiceComponent iServiceComponent = IServiceComponent.this;
                return iServiceComponent.getServiceProvider().getRegistry().getService(str, Reflection.getOrCreateKotlinClass(AlternativeFlowReader.class));
            }
        })).invoke()) {
            SendDiagnosticEvent.DefaultImpls.invoke$default(sendBannerDestroyed$lambda$21(LazyKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new Function0<SendDiagnosticEvent>() { // from class: com.unity3d.services.UnityAdsSDK$sendBannerDestroyed$$inlined$inject$default$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                /* JADX WARN: Type inference failed for: r0v3, types: [com.unity3d.ads.core.domain.SendDiagnosticEvent, java.lang.Object] */
                @Override // kotlin.jvm.functions.Function0
                public final SendDiagnosticEvent invoke() {
                    IServiceComponent iServiceComponent = IServiceComponent.this;
                    return iServiceComponent.getServiceProvider().getRegistry().getService(str, Reflection.getOrCreateKotlinClass(SendDiagnosticEvent.class));
                }
            })), "native_banner_destroyed", null, null, null, null, null, 62, null);
        }
    }

    private static final SendDiagnosticEvent sendBannerDestroyed$lambda$21(Lazy<? extends SendDiagnosticEvent> lazy) {
        return lazy.getValue();
    }
}
