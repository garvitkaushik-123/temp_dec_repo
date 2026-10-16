package io.adn.sdk.internal.ui.fullscreen.viewmodel;

import io.bidmachine.iab.vast.tags.VastAttributes;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: FullscreenSceneHtmlViewModel.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "io.adn.sdk.internal.ui.fullscreen.viewmodel.FullscreenHtmlSceneViewModel", f = "FullscreenSceneHtmlViewModel.kt", i = {0, 0}, l = {75}, m = "updateLoadingCardVisibility", n = {"this", VastAttributes.VISIBLE}, s = {"L$0", "Z$0"})
/* loaded from: classes7.dex */
final class FullscreenHtmlSceneViewModel$updateLoadingCardVisibility$1 extends ContinuationImpl {
    Object L$0;
    boolean Z$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ FullscreenHtmlSceneViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    FullscreenHtmlSceneViewModel$updateLoadingCardVisibility$1(FullscreenHtmlSceneViewModel fullscreenHtmlSceneViewModel, Continuation<? super FullscreenHtmlSceneViewModel$updateLoadingCardVisibility$1> continuation) {
        super(continuation);
        this.this$0 = fullscreenHtmlSceneViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object updateLoadingCardVisibility;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        updateLoadingCardVisibility = this.this$0.updateLoadingCardVisibility(false, this);
        return updateLoadingCardVisibility;
    }
}
