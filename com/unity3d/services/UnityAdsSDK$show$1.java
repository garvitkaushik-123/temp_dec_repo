package com.unity3d.services;

import android.app.Activity;
import com.unity3d.ads.UnityAdsShowOptions;
import com.unity3d.ads.core.data.model.Listeners;
import com.unity3d.ads.core.domain.LegacyShowUseCase;
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
@DebugMetadata(c = "com.unity3d.services.UnityAdsSDK$show$1", f = "UnityAdsSDK.kt", i = {}, l = {120}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes7.dex */
final class UnityAdsSDK$show$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Activity $activity;
    final /* synthetic */ Listeners $listener;
    final /* synthetic */ String $placementId;
    final /* synthetic */ LegacyShowUseCase $showBoldSDK;
    final /* synthetic */ UnityAdsShowOptions $showOptions;
    final /* synthetic */ CoroutineScope $showScope;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    UnityAdsSDK$show$1(LegacyShowUseCase legacyShowUseCase, Activity activity, String str, UnityAdsShowOptions unityAdsShowOptions, Listeners listeners, CoroutineScope coroutineScope, Continuation<? super UnityAdsSDK$show$1> continuation) {
        super(2, continuation);
        this.$showBoldSDK = legacyShowUseCase;
        this.$activity = activity;
        this.$placementId = str;
        this.$showOptions = unityAdsShowOptions;
        this.$listener = listeners;
        this.$showScope = coroutineScope;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new UnityAdsSDK$show$1(this.$showBoldSDK, this.$activity, this.$placementId, this.$showOptions, this.$listener, this.$showScope, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((UnityAdsSDK$show$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            if (this.$showBoldSDK.invoke(this.$activity, this.$placementId, this.$showOptions, this.$listener, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        CoroutineScopeKt.cancel$default(this.$showScope, null, 1, null);
        return Unit.INSTANCE;
    }
}
