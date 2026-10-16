package io.ktor.utils.io;

import com.vungle.ads.internal.protos.Sdk;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: ReadSession.kt */
@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.utils.io.ReadSessionKt", f = "ReadSession.kt", i = {0}, l = {Sdk.SDKError.Reason.OMSDK_JS_WRITE_FAILED_VALUE}, m = "requestBufferFallback", n = {"chunk"}, s = {"L$0"})
/* loaded from: classes8.dex */
final class ReadSessionKt$requestBufferFallback$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;

    ReadSessionKt$requestBufferFallback$1(Continuation<? super ReadSessionKt$requestBufferFallback$1> continuation) {
        super(continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object requestBufferFallback;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        requestBufferFallback = ReadSessionKt.requestBufferFallback(null, 0, this);
        return requestBufferFallback;
    }
}
