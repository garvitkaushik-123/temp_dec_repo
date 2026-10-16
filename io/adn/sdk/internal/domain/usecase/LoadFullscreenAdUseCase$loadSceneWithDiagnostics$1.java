package io.adn.sdk.internal.domain.usecase;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: LoadFullscreenAdUseCase.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "io.adn.sdk.internal.domain.usecase.LoadFullscreenAdUseCase", f = "LoadFullscreenAdUseCase.kt", i = {0, 0}, l = {70}, m = "loadSceneWithDiagnostics-0E7RQCE", n = {"this", "diagnosticScene"}, s = {"L$0", "L$1"})
/* loaded from: classes7.dex */
final class LoadFullscreenAdUseCase$loadSceneWithDiagnostics$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ LoadFullscreenAdUseCase this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    LoadFullscreenAdUseCase$loadSceneWithDiagnostics$1(LoadFullscreenAdUseCase loadFullscreenAdUseCase, Continuation<? super LoadFullscreenAdUseCase$loadSceneWithDiagnostics$1> continuation) {
        super(continuation);
        this.this$0 = loadFullscreenAdUseCase;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object m9508loadSceneWithDiagnostics0E7RQCE;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        m9508loadSceneWithDiagnostics0E7RQCE = this.this$0.m9508loadSceneWithDiagnostics0E7RQCE(null, null, this);
        return m9508loadSceneWithDiagnostics0E7RQCE == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? m9508loadSceneWithDiagnostics0E7RQCE : Result.m10240boximpl(m9508loadSceneWithDiagnostics0E7RQCE);
    }
}
