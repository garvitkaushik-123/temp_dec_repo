package io.adn.sdk.internal.ui.common.mraid;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: MraidBridge.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "io.adn.sdk.internal.ui.common.mraid.MraidBridgeImpl", f = "MraidBridge.kt", i = {}, l = {49}, m = "load-gIAlu-s", n = {}, s = {})
/* loaded from: classes7.dex */
final class MraidBridgeImpl$load$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ MraidBridgeImpl this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    MraidBridgeImpl$load$1(MraidBridgeImpl mraidBridgeImpl, Continuation<? super MraidBridgeImpl$load$1> continuation) {
        super(continuation);
        this.this$0 = mraidBridgeImpl;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        Object mo9556loadgIAlus = this.this$0.mo9556loadgIAlus(null, this);
        return mo9556loadgIAlus == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? mo9556loadgIAlus : Result.m10240boximpl(mo9556loadgIAlus);
    }
}
