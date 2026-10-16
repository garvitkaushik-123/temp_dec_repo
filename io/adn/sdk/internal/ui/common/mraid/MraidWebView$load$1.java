package io.adn.sdk.internal.ui.common.mraid;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: MraidWebView.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "io.adn.sdk.internal.ui.common.mraid.MraidWebView", f = "MraidWebView.kt", i = {}, l = {38}, m = "load-0E7RQCE", n = {}, s = {})
/* loaded from: classes7.dex */
final class MraidWebView$load$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ MraidWebView this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    MraidWebView$load$1(MraidWebView mraidWebView, Continuation<? super MraidWebView$load$1> continuation) {
        super(continuation);
        this.this$0 = mraidWebView;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        Object m9559load0E7RQCE = this.this$0.m9559load0E7RQCE(null, false, this);
        return m9559load0E7RQCE == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? m9559load0E7RQCE : Result.m10240boximpl(m9559load0E7RQCE);
    }
}
