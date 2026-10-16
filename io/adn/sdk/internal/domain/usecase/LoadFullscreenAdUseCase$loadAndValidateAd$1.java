package io.adn.sdk.internal.domain.usecase;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: LoadFullscreenAdUseCase.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "io.adn.sdk.internal.domain.usecase.LoadFullscreenAdUseCase", f = "LoadFullscreenAdUseCase.kt", i = {0}, l = {39}, m = "loadAndValidateAd", n = {"this"}, s = {"L$0"})
/* loaded from: classes7.dex */
final class LoadFullscreenAdUseCase$loadAndValidateAd$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ LoadFullscreenAdUseCase this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    LoadFullscreenAdUseCase$loadAndValidateAd$1(LoadFullscreenAdUseCase loadFullscreenAdUseCase, Continuation<? super LoadFullscreenAdUseCase$loadAndValidateAd$1> continuation) {
        super(continuation);
        this.this$0 = loadFullscreenAdUseCase;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object loadAndValidateAd;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        loadAndValidateAd = this.this$0.loadAndValidateAd(null, this);
        return loadAndValidateAd;
    }
}
