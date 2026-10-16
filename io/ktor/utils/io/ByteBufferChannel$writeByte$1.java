package io.ktor.utils.io;

import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: ByteBufferChannel.kt */
@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.utils.io.ByteBufferChannel", f = "ByteBufferChannel.kt", i = {3, 3, 3, 4, 4, 4, 4, 4, 7, 7, 7}, l = {936, 936, 936, 2426, 2481, 936, 936, 2508}, m = "writeByte$suspendImpl", n = {"joined$iv$iv", "this_$iv$iv$iv", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "capacity$iv", "this_$iv$iv", "$this$writeSuspendPrimitive$iv$iv", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "size$iv", "joined$iv$iv$iv", "this_$iv$iv$iv$iv", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B}, s = {"L$0", "L$1", "B$0", "L$0", "L$1", "L$2", "B$0", "I$0", "L$0", "L$1", "B$0"})
/* loaded from: classes8.dex */
final class ByteBufferChannel$writeByte$1 extends ContinuationImpl {
    byte B$0;
    int I$0;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ByteBufferChannel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ByteBufferChannel$writeByte$1(ByteBufferChannel byteBufferChannel, Continuation<? super ByteBufferChannel$writeByte$1> continuation) {
        super(continuation);
        this.this$0 = byteBufferChannel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return ByteBufferChannel.writeByte$suspendImpl(this.this$0, (byte) 0, this);
    }
}
