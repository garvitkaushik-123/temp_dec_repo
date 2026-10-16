package io.adn.sdk.internal.ui.common.mraid;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* compiled from: MraidController.kt */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "adEvent", "Lio/adn/sdk/internal/ui/common/mraid/MraidWebViewEvent;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "io.adn.sdk.internal.ui.common.mraid.MraidControllerImpl$observeWebviewEvents$1", f = "MraidController.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes7.dex */
final class MraidControllerImpl$observeWebviewEvents$1 extends SuspendLambda implements Function2<MraidWebViewEvent, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ MraidControllerImpl this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    MraidControllerImpl$observeWebviewEvents$1(MraidControllerImpl mraidControllerImpl, Continuation<? super MraidControllerImpl$observeWebviewEvents$1> continuation) {
        super(2, continuation);
        this.this$0 = mraidControllerImpl;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        MraidControllerImpl$observeWebviewEvents$1 mraidControllerImpl$observeWebviewEvents$1 = new MraidControllerImpl$observeWebviewEvents$1(this.this$0, continuation);
        mraidControllerImpl$observeWebviewEvents$1.L$0 = obj;
        return mraidControllerImpl$observeWebviewEvents$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(MraidWebViewEvent mraidWebViewEvent, Continuation<? super Unit> continuation) {
        return ((MraidControllerImpl$observeWebviewEvents$1) create(mraidWebViewEvent, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            this.this$0.handleAdEvent((MraidWebViewEvent) this.L$0);
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
