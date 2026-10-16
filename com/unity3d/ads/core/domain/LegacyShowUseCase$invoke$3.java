package com.unity3d.ads.core.domain;

import com.unity3d.ads.UnityAds;
import com.unity3d.ads.core.data.model.ShowEvent;
import com.unity3d.ads.core.domain.LegacyShowUseCase;
import com.unity3d.ads.core.extensions.ExceptionExtensionsKt;
import com.unity3d.services.UnityAdsConstants;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function6;
import kotlinx.coroutines.flow.FlowCollector;

/* compiled from: LegacyShowUseCase.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0004\u001a\u00020\u0005H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/unity3d/ads/core/data/model/ShowEvent;", "it", ""}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "com.unity3d.ads.core.domain.LegacyShowUseCase$invoke$3", f = "LegacyShowUseCase.kt", i = {}, l = {191}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes7.dex */
final class LegacyShowUseCase$invoke$3 extends SuspendLambda implements Function3<FlowCollector<? super ShowEvent>, Throwable, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $isBanner;
    final /* synthetic */ Function6<String, UnityAds.UnityAdsShowError, String, Integer, String, Continuation<? super Unit>, Object> $reportShowError;
    /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    LegacyShowUseCase$invoke$3(Function6<? super String, ? super UnityAds.UnityAdsShowError, ? super String, ? super Integer, ? super String, ? super Continuation<? super Unit>, ? extends Object> function6, boolean z, Continuation<? super LegacyShowUseCase$invoke$3> continuation) {
        super(3, continuation);
        this.$reportShowError = function6;
        this.$isBanner = z;
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(FlowCollector<? super ShowEvent> flowCollector, Throwable th, Continuation<? super Unit> continuation) {
        LegacyShowUseCase$invoke$3 legacyShowUseCase$invoke$3 = new LegacyShowUseCase$invoke$3(this.$reportShowError, this.$isBanner, continuation);
        legacyShowUseCase$invoke$3.L$0 = th;
        return legacyShowUseCase$invoke$3.invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        LegacyShowUseCase$invoke$3 legacyShowUseCase$invoke$3;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Throwable th = (Throwable) this.L$0;
            Function6<String, UnityAds.UnityAdsShowError, String, Integer, String, Continuation<? super Unit>, Object> function6 = this.$reportShowError;
            UnityAds.UnityAdsShowError unityAdsShowError = UnityAds.UnityAdsShowError.INTERNAL_ERROR;
            String shortenedStackTrace$default = ExceptionExtensionsKt.getShortenedStackTrace$default(th, 0, 1, null);
            this.label = 1;
            legacyShowUseCase$invoke$3 = this;
            if (function6.invoke("uncaught_exception", unityAdsShowError, UnityAdsConstants.Messages.MSG_INTERNAL_ERROR, null, shortenedStackTrace$default, legacyShowUseCase$invoke$3) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            legacyShowUseCase$invoke$3 = this;
        }
        if (!legacyShowUseCase$invoke$3.$isBanner) {
            LegacyShowUseCase.Companion companion = LegacyShowUseCase.INSTANCE;
            LegacyShowUseCase.isFullscreenAdShowing = false;
        }
        return Unit.INSTANCE;
    }
}
