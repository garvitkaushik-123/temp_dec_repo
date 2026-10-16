package com.unity3d.services;

import com.unity3d.ads.core.configuration.AlternativeFlowReader;
import com.unity3d.ads.core.domain.InitializeBoldSDK;
import com.unity3d.services.core.domain.task.InitializeSDK;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Result;
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
@DebugMetadata(c = "com.unity3d.services.UnityAdsSDK$initialize$1", f = "UnityAdsSDK.kt", i = {}, l = {87, 89}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes7.dex */
final class UnityAdsSDK$initialize$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Lazy<AlternativeFlowReader> $alternativeFlowReader$delegate;
    final /* synthetic */ CoroutineScope $initScope;
    final /* synthetic */ Lazy<InitializeBoldSDK> $initializeBoldSDK$delegate;
    final /* synthetic */ Lazy<InitializeSDK> $initializeSDK$delegate;
    final /* synthetic */ String $source;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    UnityAdsSDK$initialize$1(String str, CoroutineScope coroutineScope, Lazy<? extends AlternativeFlowReader> lazy, Lazy<? extends InitializeBoldSDK> lazy2, Lazy<InitializeSDK> lazy3, Continuation<? super UnityAdsSDK$initialize$1> continuation) {
        super(2, continuation);
        this.$source = str;
        this.$initScope = coroutineScope;
        this.$alternativeFlowReader$delegate = lazy;
        this.$initializeBoldSDK$delegate = lazy2;
        this.$initializeSDK$delegate = lazy3;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new UnityAdsSDK$initialize$1(this.$source, this.$initScope, this.$alternativeFlowReader$delegate, this.$initializeBoldSDK$delegate, this.$initializeSDK$delegate, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((UnityAdsSDK$initialize$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0043, code lost:
    
        if (r6.invoke(r5.$source, r5) == r0) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x005b, code lost:
    
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0059, code lost:
    
        if (r6.mo9272invokegIAlus(com.unity3d.services.core.domain.task.EmptyParams.INSTANCE, r5) == r0) goto L17;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        AlternativeFlowReader initialize$lambda$1;
        InitializeSDK initialize$lambda$2;
        InitializeBoldSDK initialize$lambda$3;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            initialize$lambda$1 = UnityAdsSDK.initialize$lambda$1(this.$alternativeFlowReader$delegate);
            if (initialize$lambda$1.invoke()) {
                initialize$lambda$3 = UnityAdsSDK.initialize$lambda$3(this.$initializeBoldSDK$delegate);
                this.label = 1;
            } else {
                initialize$lambda$2 = UnityAdsSDK.initialize$lambda$2(this.$initializeSDK$delegate);
                this.label = 2;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            if (i != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            ((Result) obj).getValue();
        }
        CoroutineScopeKt.cancel$default(this.$initScope, null, 1, null);
        return Unit.INSTANCE;
    }
}
