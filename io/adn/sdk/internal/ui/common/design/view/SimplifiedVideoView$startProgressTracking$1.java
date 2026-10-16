package io.adn.sdk.internal.ui.common.design.view;

import com.vungle.ads.internal.protos.Sdk;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: SimplifiedVideoView.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "io.adn.sdk.internal.ui.common.design.view.SimplifiedVideoView$startProgressTracking$1", f = "SimplifiedVideoView.kt", i = {}, l = {Sdk.SDKError.Reason.INVALID_METRICS_ENDPOINT_VALUE}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes7.dex */
final class SimplifiedVideoView$startProgressTracking$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ SimplifiedVideoView this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SimplifiedVideoView$startProgressTracking$1(SimplifiedVideoView simplifiedVideoView, Continuation<? super SimplifiedVideoView$startProgressTracking$1> continuation) {
        super(2, continuation);
        this.this$0 = simplifiedVideoView;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new SimplifiedVideoView$startProgressTracking$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((SimplifiedVideoView$startProgressTracking$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object trackPlayerProgress;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i != 0 && i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        do {
            this.label = 1;
            trackPlayerProgress = this.this$0.trackPlayerProgress(this);
        } while (trackPlayerProgress != coroutine_suspended);
        return coroutine_suspended;
    }
}
