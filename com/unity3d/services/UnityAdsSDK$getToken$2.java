package com.unity3d.services;

import com.unity3d.ads.IUnityAdsTokenListener;
import com.unity3d.ads.TokenConfiguration;
import com.unity3d.ads.core.domain.GetAsyncHeaderBiddingToken;
import com.unity3d.ads.core.domain.TokenNumberProvider;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;

/* compiled from: UnityAdsSDK.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "com.unity3d.services.UnityAdsSDK$getToken$2", f = "UnityAdsSDK.kt", i = {}, l = {147}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes7.dex */
final class UnityAdsSDK$getToken$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Lazy<GetAsyncHeaderBiddingToken> $getAsyncHeaderBiddingToken$delegate;
    final /* synthetic */ CoroutineScope $getTokenScope;
    final /* synthetic */ IUnityAdsTokenListener $listener;
    final /* synthetic */ TokenConfiguration $tokenConfiguration;
    final /* synthetic */ Lazy<TokenNumberProvider> $tokenNumberProvider$delegate;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    UnityAdsSDK$getToken$2(TokenConfiguration tokenConfiguration, IUnityAdsTokenListener iUnityAdsTokenListener, CoroutineScope coroutineScope, Lazy<? extends GetAsyncHeaderBiddingToken> lazy, Lazy<? extends TokenNumberProvider> lazy2, Continuation<? super UnityAdsSDK$getToken$2> continuation) {
        super(2, continuation);
        this.$tokenConfiguration = tokenConfiguration;
        this.$listener = iUnityAdsTokenListener;
        this.$getTokenScope = coroutineScope;
        this.$getAsyncHeaderBiddingToken$delegate = lazy;
        this.$tokenNumberProvider$delegate = lazy2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new UnityAdsSDK$getToken$2(this.$tokenConfiguration, this.$listener, this.$getTokenScope, this.$getAsyncHeaderBiddingToken$delegate, this.$tokenNumberProvider$delegate, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((UnityAdsSDK$getToken$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        GetAsyncHeaderBiddingToken token$lambda$8;
        TokenNumberProvider token$lambda$7;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            token$lambda$8 = UnityAdsSDK.getToken$lambda$8(this.$getAsyncHeaderBiddingToken$delegate);
            token$lambda$7 = UnityAdsSDK.getToken$lambda$7(this.$tokenNumberProvider$delegate);
            this.label = 1;
            if (token$lambda$8.invoke(token$lambda$7.invoke(), this.$tokenConfiguration, this.$listener, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        CoroutineScopeKt.cancel$default(this.$getTokenScope, null, 1, null);
        return Unit.INSTANCE;
    }
}
