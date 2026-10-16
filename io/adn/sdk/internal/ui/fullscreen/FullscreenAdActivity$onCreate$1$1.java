package io.adn.sdk.internal.ui.fullscreen;

import io.adn.sdk.internal.domain.model.ad.FullscreenAdEvent;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* compiled from: FullscreenAdActivity.kt */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "event", "Lio/adn/sdk/internal/domain/model/ad/FullscreenAdEvent;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "io.adn.sdk.internal.ui.fullscreen.FullscreenAdActivity$onCreate$1$1", f = "FullscreenAdActivity.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes7.dex */
final class FullscreenAdActivity$onCreate$1$1 extends SuspendLambda implements Function2<FullscreenAdEvent, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ FullscreenAdActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    FullscreenAdActivity$onCreate$1$1(FullscreenAdActivity fullscreenAdActivity, Continuation<? super FullscreenAdActivity$onCreate$1$1> continuation) {
        super(2, continuation);
        this.this$0 = fullscreenAdActivity;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        FullscreenAdActivity$onCreate$1$1 fullscreenAdActivity$onCreate$1$1 = new FullscreenAdActivity$onCreate$1$1(this.this$0, continuation);
        fullscreenAdActivity$onCreate$1$1.L$0 = obj;
        return fullscreenAdActivity$onCreate$1$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(FullscreenAdEvent fullscreenAdEvent, Continuation<? super Unit> continuation) {
        return ((FullscreenAdActivity$onCreate$1$1) create(fullscreenAdEvent, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        boolean isAdClosed;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        isAdClosed = this.this$0.isAdClosed((FullscreenAdEvent) this.L$0);
        if (isAdClosed) {
            this.this$0.finish();
        }
        return Unit.INSTANCE;
    }
}
