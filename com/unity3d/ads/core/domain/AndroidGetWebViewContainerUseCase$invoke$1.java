package com.unity3d.ads.core.domain;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: AndroidGetWebViewContainerUseCase.kt */
@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "com.unity3d.ads.core.domain.AndroidGetWebViewContainerUseCase", f = "AndroidGetWebViewContainerUseCase.kt", i = {0, 0}, l = {24}, m = "invoke", n = {"this", "adPlayerScope"}, s = {"L$0", "L$1"})
/* loaded from: classes7.dex */
final class AndroidGetWebViewContainerUseCase$invoke$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AndroidGetWebViewContainerUseCase this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    AndroidGetWebViewContainerUseCase$invoke$1(AndroidGetWebViewContainerUseCase androidGetWebViewContainerUseCase, Continuation<? super AndroidGetWebViewContainerUseCase$invoke$1> continuation) {
        super(continuation);
        this.this$0 = androidGetWebViewContainerUseCase;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.invoke(null, this);
    }
}
