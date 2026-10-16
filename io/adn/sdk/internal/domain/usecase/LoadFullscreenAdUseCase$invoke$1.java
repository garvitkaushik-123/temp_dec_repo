package io.adn.sdk.internal.domain.usecase;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: LoadFullscreenAdUseCase.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "io.adn.sdk.internal.domain.usecase.LoadFullscreenAdUseCase", f = "LoadFullscreenAdUseCase.kt", i = {0, 0, 0, 1, 1, 1, 1}, l = {31, 32}, m = "invoke", n = {"this", "activity", "bidResponse", "this", "activity", "bidResponse", "ad"}, s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$3"})
/* loaded from: classes7.dex */
final class LoadFullscreenAdUseCase$invoke$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ LoadFullscreenAdUseCase this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    LoadFullscreenAdUseCase$invoke$1(LoadFullscreenAdUseCase loadFullscreenAdUseCase, Continuation<? super LoadFullscreenAdUseCase$invoke$1> continuation) {
        super(continuation);
        this.this$0 = loadFullscreenAdUseCase;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.invoke(null, null, this);
    }
}
