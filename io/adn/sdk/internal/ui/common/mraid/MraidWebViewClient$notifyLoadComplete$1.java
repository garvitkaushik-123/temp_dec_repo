package io.adn.sdk.internal.ui.common.mraid;

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
import kotlinx.coroutines.flow.MutableSharedFlow;

/* compiled from: MraidWebViewClient.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "io.adn.sdk.internal.ui.common.mraid.MraidWebViewClient$notifyLoadComplete$1", f = "MraidWebViewClient.kt", i = {}, l = {102}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes7.dex */
final class MraidWebViewClient$notifyLoadComplete$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Object $result;
    int label;
    final /* synthetic */ MraidWebViewClient this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    MraidWebViewClient$notifyLoadComplete$1(MraidWebViewClient mraidWebViewClient, Object obj, Continuation<? super MraidWebViewClient$notifyLoadComplete$1> continuation) {
        super(2, continuation);
        this.this$0 = mraidWebViewClient;
        this.$result = obj;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new MraidWebViewClient$notifyLoadComplete$1(this.this$0, this.$result, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((MraidWebViewClient$notifyLoadComplete$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        MutableSharedFlow mutableSharedFlow;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            mutableSharedFlow = this.this$0._loadResult;
            this.label = 1;
            if (mutableSharedFlow.emit(Result.m10240boximpl(this.$result), this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        return Unit.INSTANCE;
    }
}
