package io.adn.sdk.internal.ui.common.mraid;

import android.app.Activity;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: MraidController.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "io.adn.sdk.internal.ui.common.mraid.MraidControllerImpl", f = "MraidController.kt", i = {}, l = {63}, m = "load-0E7RQCE", n = {}, s = {})
/* loaded from: classes7.dex */
final class MraidControllerImpl$load$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ MraidControllerImpl this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    MraidControllerImpl$load$1(MraidControllerImpl mraidControllerImpl, Continuation<? super MraidControllerImpl$load$1> continuation) {
        super(continuation);
        this.this$0 = mraidControllerImpl;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        Object mo9558load0E7RQCE = this.this$0.mo9558load0E7RQCE((Activity) null, (String) null, this);
        return mo9558load0E7RQCE == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? mo9558load0E7RQCE : Result.m10240boximpl(mo9558load0E7RQCE);
    }
}
