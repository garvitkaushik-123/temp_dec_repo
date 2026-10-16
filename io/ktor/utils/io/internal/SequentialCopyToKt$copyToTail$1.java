package io.ktor.utils.io.internal;

import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: SequentialCopyTo.kt */
@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.utils.io.internal.SequentialCopyToKt", f = "SequentialCopyTo.kt", i = {0, 0, 1, 1}, l = {60, 66}, m = "copyToTail", n = {"dst", "lastPiece", "lastPiece", DownloadCommon.DOWNLOAD_REPORT_RETRY_COUNT}, s = {"L$0", "L$1", "L$0", "I$0"})
/* loaded from: classes8.dex */
final class SequentialCopyToKt$copyToTail$1 extends ContinuationImpl {
    int I$0;
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;

    SequentialCopyToKt$copyToTail$1(Continuation<? super SequentialCopyToKt$copyToTail$1> continuation) {
        super(continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object copyToTail;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        copyToTail = SequentialCopyToKt.copyToTail(null, null, 0L, this);
        return copyToTail;
    }
}
