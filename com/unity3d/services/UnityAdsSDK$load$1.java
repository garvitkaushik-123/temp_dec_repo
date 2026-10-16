package com.unity3d.services;

import android.content.Context;
import com.unity3d.ads.IUnityAdsLoadListener;
import com.unity3d.ads.UnityAdsLoadOptions;
import com.unity3d.ads.core.domain.LegacyLoadUseCase;
import com.unity3d.services.banners.UnityBannerSize;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;

/* compiled from: UnityAdsSDK.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "com.unity3d.services.UnityAdsSDK$load$1", f = "UnityAdsSDK.kt", i = {}, l = {110}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes7.dex */
final class UnityAdsSDK$load$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ UnityBannerSize $bannerSize;
    final /* synthetic */ Lazy<Context> $context$delegate;
    final /* synthetic */ IUnityAdsLoadListener $listener;
    final /* synthetic */ UnityAdsLoadOptions $loadOptions;
    final /* synthetic */ CoroutineScope $loadScope;
    final /* synthetic */ String $placementId;
    int label;
    final /* synthetic */ UnityAdsSDK this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    UnityAdsSDK$load$1(UnityAdsSDK unityAdsSDK, String str, UnityAdsLoadOptions unityAdsLoadOptions, IUnityAdsLoadListener iUnityAdsLoadListener, UnityBannerSize unityBannerSize, CoroutineScope coroutineScope, Lazy<? extends Context> lazy, Continuation<? super UnityAdsSDK$load$1> continuation) {
        super(2, continuation);
        this.this$0 = unityAdsSDK;
        this.$placementId = str;
        this.$loadOptions = unityAdsLoadOptions;
        this.$listener = iUnityAdsLoadListener;
        this.$bannerSize = unityBannerSize;
        this.$loadScope = coroutineScope;
        this.$context$delegate = lazy;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new UnityAdsSDK$load$1(this.this$0, this.$placementId, this.$loadOptions, this.$listener, this.$bannerSize, this.$loadScope, this.$context$delegate, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((UnityAdsSDK$load$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Context load$lambda$5;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            LegacyLoadUseCase legacyLoadUseCase = (LegacyLoadUseCase) this.this$0.getServiceProvider().getRegistry().getService("", Reflection.getOrCreateKotlinClass(LegacyLoadUseCase.class));
            load$lambda$5 = UnityAdsSDK.load$lambda$5(this.$context$delegate);
            this.label = 1;
            if (legacyLoadUseCase.invoke(load$lambda$5, this.$placementId, this.$loadOptions, this.$listener, this.$bannerSize, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        CoroutineScopeKt.cancel$default(this.$loadScope, null, 1, null);
        return Unit.INSTANCE;
    }
}
