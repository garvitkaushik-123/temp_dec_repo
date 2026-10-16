package com.unity3d.services;

import com.unity3d.ads.core.data.model.AdObject;
import com.unity3d.ads.core.domain.GetAdObject;
import com.unity3d.ads.core.domain.om.OmFinishSession;
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
@DebugMetadata(c = "com.unity3d.services.UnityAdsSDK$finishOMIDSession$2", f = "UnityAdsSDK.kt", i = {}, l = {203}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes7.dex */
final class UnityAdsSDK$finishOMIDSession$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Lazy<GetAdObject> $getAdObject$delegate;
    final /* synthetic */ Lazy<OmFinishSession> $omFinishSession$delegate;
    final /* synthetic */ CoroutineScope $omidScope;
    final /* synthetic */ String $opportunityId;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    UnityAdsSDK$finishOMIDSession$2(String str, CoroutineScope coroutineScope, Lazy<? extends GetAdObject> lazy, Lazy<? extends OmFinishSession> lazy2, Continuation<? super UnityAdsSDK$finishOMIDSession$2> continuation) {
        super(2, continuation);
        this.$opportunityId = str;
        this.$omidScope = coroutineScope;
        this.$getAdObject$delegate = lazy;
        this.$omFinishSession$delegate = lazy2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new UnityAdsSDK$finishOMIDSession$2(this.$opportunityId, this.$omidScope, this.$getAdObject$delegate, this.$omFinishSession$delegate, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((UnityAdsSDK$finishOMIDSession$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        GetAdObject finishOMIDSession$lambda$18;
        OmFinishSession finishOMIDSession$lambda$19;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            finishOMIDSession$lambda$18 = UnityAdsSDK.finishOMIDSession$lambda$18(this.$getAdObject$delegate);
            AdObject invoke = finishOMIDSession$lambda$18.invoke(this.$opportunityId);
            if (invoke != null) {
                finishOMIDSession$lambda$19 = UnityAdsSDK.finishOMIDSession$lambda$19(this.$omFinishSession$delegate);
                this.label = 1;
                if (finishOMIDSession$lambda$19.invoke(invoke, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        CoroutineScopeKt.cancel$default(this.$omidScope, null, 1, null);
        return Unit.INSTANCE;
    }
}
