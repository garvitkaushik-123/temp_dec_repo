package io.adn.sdk.internal.ui.fullscreen.viewmodel;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: FullscreenSceneHtmlViewModel.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "io.adn.sdk.internal.ui.fullscreen.viewmodel.FullscreenHtmlSceneViewModel", f = "FullscreenSceneHtmlViewModel.kt", i = {0, 0, 0, 1, 1, 1}, l = {57, 58, 70}, m = "loadSceneAsset", n = {"this", "asset", "controller", "this", "asset", "controller"}, s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$2"})
/* loaded from: classes7.dex */
final class FullscreenHtmlSceneViewModel$loadSceneAsset$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ FullscreenHtmlSceneViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    FullscreenHtmlSceneViewModel$loadSceneAsset$1(FullscreenHtmlSceneViewModel fullscreenHtmlSceneViewModel, Continuation<? super FullscreenHtmlSceneViewModel$loadSceneAsset$1> continuation) {
        super(continuation);
        this.this$0 = fullscreenHtmlSceneViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object loadSceneAsset;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        loadSceneAsset = this.this$0.loadSceneAsset(null, null, this);
        return loadSceneAsset;
    }
}
