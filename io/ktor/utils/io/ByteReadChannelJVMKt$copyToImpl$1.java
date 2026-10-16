package io.ktor.utils.io;

import com.vungle.ads.internal.protos.Sdk;
import io.ktor.http.ContentDisposition;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: ByteReadChannelJVM.kt */
@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.utils.io.ByteReadChannelJVMKt", f = "ByteReadChannelJVM.kt", i = {0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1}, l = {Sdk.SDKError.Reason.ASSET_FAILED_TO_DELETE_VALUE, Sdk.SDKError.Reason.DEEPLINK_OPEN_FAILED_VALUE}, m = "copyToImpl", n = {"$this$copyToImpl", "dst", "buffer", "limit", "dstNeedsFlush", "copied", "$this$copyToImpl", "dst", "buffer", "limit", "dstNeedsFlush", "copied", ContentDisposition.Parameters.Size}, s = {"L$0", "L$1", "L$2", "J$0", "I$0", "J$1", "L$0", "L$1", "L$2", "J$0", "I$0", "J$1", "I$1"})
/* loaded from: classes8.dex */
final class ByteReadChannelJVMKt$copyToImpl$1 extends ContinuationImpl {
    int I$0;
    int I$1;
    long J$0;
    long J$1;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;

    ByteReadChannelJVMKt$copyToImpl$1(Continuation<? super ByteReadChannelJVMKt$copyToImpl$1> continuation) {
        super(continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object copyToImpl;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        copyToImpl = ByteReadChannelJVMKt.copyToImpl(null, null, 0L, this);
        return copyToImpl;
    }
}
