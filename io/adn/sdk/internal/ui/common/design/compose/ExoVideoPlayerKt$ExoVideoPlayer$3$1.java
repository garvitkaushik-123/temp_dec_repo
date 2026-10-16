package io.adn.sdk.internal.ui.common.design.compose;

import io.adn.sdk.internal.ui.common.design.view.SimplifiedExoPlayer;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: ExoVideoPlayer.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "io.adn.sdk.internal.ui.common.design.compose.ExoVideoPlayerKt$ExoVideoPlayer$3$1", f = "ExoVideoPlayer.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes7.dex */
final class ExoVideoPlayerKt$ExoVideoPlayer$3$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ SimplifiedExoPlayer $exoPlayer;
    final /* synthetic */ boolean $playAutomatically;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ExoVideoPlayerKt$ExoVideoPlayer$3$1(boolean z, SimplifiedExoPlayer simplifiedExoPlayer, Continuation<? super ExoVideoPlayerKt$ExoVideoPlayer$3$1> continuation) {
        super(2, continuation);
        this.$playAutomatically = z;
        this.$exoPlayer = simplifiedExoPlayer;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ExoVideoPlayerKt$ExoVideoPlayer$3$1(this.$playAutomatically, this.$exoPlayer, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ExoVideoPlayerKt$ExoVideoPlayer$3$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        if (this.$playAutomatically) {
            this.$exoPlayer.play();
        } else {
            this.$exoPlayer.pause();
        }
        return Unit.INSTANCE;
    }
}
