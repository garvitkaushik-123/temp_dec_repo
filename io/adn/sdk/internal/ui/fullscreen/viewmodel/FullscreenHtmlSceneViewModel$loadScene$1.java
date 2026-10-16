package io.adn.sdk.internal.ui.fullscreen.viewmodel;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: FullscreenSceneHtmlViewModel.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "io.adn.sdk.internal.ui.fullscreen.viewmodel.FullscreenHtmlSceneViewModel", f = "FullscreenSceneHtmlViewModel.kt", i = {0, 0, 1, 1}, l = {36, 37, 41}, m = "loadScene", n = {"this", "activity", "this", "activity"}, s = {"L$0", "L$1", "L$0", "L$1"})
/* loaded from: classes7.dex */
final class FullscreenHtmlSceneViewModel$loadScene$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ FullscreenHtmlSceneViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    FullscreenHtmlSceneViewModel$loadScene$1(FullscreenHtmlSceneViewModel fullscreenHtmlSceneViewModel, Continuation<? super FullscreenHtmlSceneViewModel$loadScene$1> continuation) {
        super(continuation);
        this.this$0 = fullscreenHtmlSceneViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.loadScene(null, this);
    }
}
