package io.adn.sdk.internal.domain.usecase;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: LoadFullscreenAdUseCase.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "io.adn.sdk.internal.domain.usecase.LoadFullscreenAdUseCase", f = "LoadFullscreenAdUseCase.kt", i = {}, l = {50}, m = "loadPrimaryScene", n = {}, s = {})
/* loaded from: classes7.dex */
final class LoadFullscreenAdUseCase$loadPrimaryScene$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ LoadFullscreenAdUseCase this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    LoadFullscreenAdUseCase$loadPrimaryScene$1(LoadFullscreenAdUseCase loadFullscreenAdUseCase, Continuation<? super LoadFullscreenAdUseCase$loadPrimaryScene$1> continuation) {
        super(continuation);
        this.this$0 = loadFullscreenAdUseCase;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object loadPrimaryScene;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        loadPrimaryScene = this.this$0.loadPrimaryScene(null, null, this);
        return loadPrimaryScene;
    }
}
