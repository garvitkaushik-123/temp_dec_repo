package com.unity3d.ads.core.domain;

import com.unity3d.ads.UnityAds;
import com.unity3d.ads.core.data.model.AdObject;
import gatewayprotocol.v1.OperativeEventRequestOuterClass;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function6;
import kotlinx.coroutines.flow.MutableStateFlow;

/* compiled from: LegacyShowUseCase.kt */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0003H\u008a@"}, d2 = {"<anonymous>", "", "close", "Lkotlin/Function0;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "com.unity3d.ads.core.domain.LegacyShowUseCase$invoke$2", f = "LegacyShowUseCase.kt", i = {0, 1, 2}, l = {179, 185, 186}, m = "invokeSuspend", n = {"close", "close", "close"}, s = {"L$0", "L$0", "L$0"})
/* loaded from: classes7.dex */
final class LegacyShowUseCase$invoke$2 extends SuspendLambda implements Function2<Function0<? extends Unit>, Continuation<? super Unit>, Object> {
    final /* synthetic */ AdObject $adObject;
    final /* synthetic */ boolean $isBanner;
    final /* synthetic */ String $placement;
    final /* synthetic */ Function6<String, UnityAds.UnityAdsShowError, String, Integer, String, Continuation<? super Unit>, Object> $reportShowError;
    final /* synthetic */ boolean $useTimeout;
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ LegacyShowUseCase this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    LegacyShowUseCase$invoke$2(LegacyShowUseCase legacyShowUseCase, boolean z, AdObject adObject, boolean z2, Function6<? super String, ? super UnityAds.UnityAdsShowError, ? super String, ? super Integer, ? super String, ? super Continuation<? super Unit>, ? extends Object> function6, String str, Continuation<? super LegacyShowUseCase$invoke$2> continuation) {
        super(2, continuation);
        this.this$0 = legacyShowUseCase;
        this.$isBanner = z;
        this.$adObject = adObject;
        this.$useTimeout = z2;
        this.$reportShowError = function6;
        this.$placement = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        LegacyShowUseCase$invoke$2 legacyShowUseCase$invoke$2 = new LegacyShowUseCase$invoke$2(this.this$0, this.$isBanner, this.$adObject, this.$useTimeout, this.$reportShowError, this.$placement, continuation);
        legacyShowUseCase$invoke$2.L$0 = obj;
        return legacyShowUseCase$invoke$2;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(Function0<? extends Unit> function0, Continuation<? super Unit> continuation) {
        return invoke2((Function0<Unit>) function0, continuation);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(Function0<Unit> function0, Continuation<? super Unit> continuation) {
        return ((LegacyShowUseCase$invoke$2) create(function0, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x0090, code lost:
    
        if (r11.terminate(r10.$adObject, r10) == r0) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0076, code lost:
    
        if (r11 == r0) goto L29;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        Function0 function0;
        MutableStateFlow mutableStateFlow;
        MutableStateFlow mutableStateFlow2;
        Object sendOperativeError;
        Show show;
        Function0 function02;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            function0 = (Function0) this.L$0;
            mutableStateFlow = this.this$0.hasStarted;
            if (!((Boolean) mutableStateFlow.getValue()).booleanValue()) {
                mutableStateFlow2 = this.this$0.timeoutCancellationRequested;
                if (!((Boolean) mutableStateFlow2.getValue()).booleanValue() && !this.$isBanner) {
                    this.L$0 = function0;
                    this.label = 1;
                    sendOperativeError = this.this$0.sendOperativeError(OperativeEventRequestOuterClass.OperativeEventErrorType.OPERATIVE_EVENT_ERROR_TYPE_TIMEOUT, "timeout", this.$adObject, this);
                }
            }
            return Unit.INSTANCE;
        }
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                function02 = (Function0) this.L$0;
                ResultKt.throwOnFailure(obj);
                function02.invoke();
                return Unit.INSTANCE;
            }
            function0 = (Function0) this.L$0;
            ResultKt.throwOnFailure(obj);
            Function6<String, UnityAds.UnityAdsShowError, String, Integer, String, Continuation<? super Unit>, Object> function6 = this.$reportShowError;
            UnityAds.UnityAdsShowError unityAdsShowError = UnityAds.UnityAdsShowError.TIMEOUT;
            String str = LegacyShowUseCase.MESSAGE_TIMEOUT + this.$placement;
            this.L$0 = function0;
            this.label = 3;
            if (function6.invoke("timeout", unityAdsShowError, str, null, null, this) != coroutine_suspended) {
                function02 = function0;
                function02.invoke();
                return Unit.INSTANCE;
            }
            return coroutine_suspended;
        }
        function0 = (Function0) this.L$0;
        ResultKt.throwOnFailure(obj);
        if (this.$useTimeout) {
            show = this.this$0.show;
            this.L$0 = function0;
            this.label = 2;
        }
        return Unit.INSTANCE;
    }
}
