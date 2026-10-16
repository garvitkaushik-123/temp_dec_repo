package io.ktor.client.network.sockets;

import io.ktor.utils.io.ByteChannel;
import io.ktor.utils.io.ByteReadChannelKt;
import io.ktor.utils.io.ByteWriteChannel;
import io.ktor.utils.io.WriterScope;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* compiled from: TimeoutExceptionsCommon.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lio/ktor/utils/io/WriterScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.client.network.sockets.TimeoutExceptionsCommonKt$mapEngineExceptions$2", f = "TimeoutExceptionsCommon.kt", i = {}, l = {63}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes8.dex */
final class TimeoutExceptionsCommonKt$mapEngineExceptions$2 extends SuspendLambda implements Function2<WriterScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ ByteWriteChannel $output;
    final /* synthetic */ ByteChannel $replacementChannel;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    TimeoutExceptionsCommonKt$mapEngineExceptions$2(ByteChannel byteChannel, ByteWriteChannel byteWriteChannel, Continuation<? super TimeoutExceptionsCommonKt$mapEngineExceptions$2> continuation) {
        super(2, continuation);
        this.$replacementChannel = byteChannel;
        this.$output = byteWriteChannel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new TimeoutExceptionsCommonKt$mapEngineExceptions$2(this.$replacementChannel, this.$output, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(WriterScope writerScope, Continuation<? super Unit> continuation) {
        return ((TimeoutExceptionsCommonKt$mapEngineExceptions$2) create(writerScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (ByteReadChannelKt.copyAndClose$default(this.$replacementChannel, this.$output, 0L, this, 2, null) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
        } catch (Throwable th) {
            this.$replacementChannel.close(th);
        }
        return Unit.INSTANCE;
    }
}
