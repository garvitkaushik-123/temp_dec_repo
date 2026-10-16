package io.adn.sdk.internal.ui.fullscreen.viewmodel;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: FullscreenSceneViewModel.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "io.adn.sdk.internal.ui.fullscreen.viewmodel.FullscreenSceneViewModel", f = "FullscreenSceneViewModel.kt", i = {0}, l = {69}, m = "loadSceneAssets", n = {"this"}, s = {"L$0"})
/* loaded from: classes7.dex */
final class FullscreenSceneViewModel$loadSceneAssets$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ FullscreenSceneViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    FullscreenSceneViewModel$loadSceneAssets$1(FullscreenSceneViewModel fullscreenSceneViewModel, Continuation<? super FullscreenSceneViewModel$loadSceneAssets$1> continuation) {
        super(continuation);
        this.this$0 = fullscreenSceneViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object loadSceneAssets;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        loadSceneAssets = this.this$0.loadSceneAssets(null, this);
        return loadSceneAssets;
    }
}
