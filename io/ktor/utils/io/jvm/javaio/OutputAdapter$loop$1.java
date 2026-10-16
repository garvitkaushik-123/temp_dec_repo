package io.ktor.utils.io.jvm.javaio;

import io.ktor.utils.io.ByteWriteChannel;
import io.ktor.utils.io.ByteWriteChannelKt;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlinx.coroutines.Job;

/* compiled from: Blocking.kt */
@Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0011\u0010\u0002\u001a\u00020\u0003H\u0094@ø\u0001\u0000¢\u0006\u0002\u0010\u0004\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0005"}, d2 = {"io/ktor/utils/io/jvm/javaio/OutputAdapter$loop$1", "Lio/ktor/utils/io/jvm/javaio/BlockingAdapter;", "loop", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ktor-io"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes8.dex */
public final class OutputAdapter$loop$1 extends BlockingAdapter {
    final /* synthetic */ OutputAdapter this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    OutputAdapter$loop$1(Job job, OutputAdapter outputAdapter) {
        super(job);
        this.this$0 = outputAdapter;
    }

    /* JADX WARN: Code restructure failed: missing block: B:39:0x00cd, code lost:
    
        if (r5.writeFully((byte[]) r10, r6, r7, r0) == r1) goto L48;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0065 A[Catch: all -> 0x0045, TryCatch #0 {all -> 0x0045, blocks: (B:12:0x002d, B:13:0x004c, B:15:0x0065, B:20:0x006e, B:29:0x0091, B:31:0x0097, B:34:0x00ad, B:36:0x00ae, B:38:0x00b2, B:43:0x0041), top: B:7:0x0023 }] */
    /* JADX WARN: Removed duplicated region for block: B:17:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0074  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0091 A[Catch: all -> 0x0045, TRY_ENTER, TryCatch #0 {all -> 0x0045, blocks: (B:12:0x002d, B:13:0x004c, B:15:0x0065, B:20:0x006e, B:29:0x0091, B:31:0x0097, B:34:0x00ad, B:36:0x00ae, B:38:0x00b2, B:43:0x0041), top: B:7:0x0023 }] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0025  */
    /* JADX WARN: Type inference failed for: r2v0, types: [int] */
    /* JADX WARN: Type inference failed for: r2v1, types: [io.ktor.utils.io.jvm.javaio.OutputAdapter$loop$1] */
    /* JADX WARN: Type inference failed for: r2v11 */
    /* JADX WARN: Type inference failed for: r2v12 */
    /* JADX WARN: Type inference failed for: r2v13 */
    /* JADX WARN: Type inference failed for: r2v14 */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v3, types: [io.ktor.utils.io.jvm.javaio.OutputAdapter$loop$1, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v4, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v8, types: [io.ktor.utils.io.jvm.javaio.OutputAdapter$loop$1] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:33:0x00ac -> B:13:0x004c). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:37:0x00b0 -> B:13:0x004c). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:39:0x00cd -> B:13:0x004c). Please report as a decompilation issue!!! */
    @Override // io.ktor.utils.io.jvm.javaio.BlockingAdapter
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected Object loop(Continuation<? super Unit> continuation) {
        OutputAdapter$loop$1$loop$1 outputAdapter$loop$1$loop$1;
        Object obj;
        Object coroutine_suspended;
        BlockingAdapter blockingAdapter;
        ByteWriteChannel byteWriteChannel;
        ByteWriteChannel byteWriteChannel2;
        ByteWriteChannel byteWriteChannel3;
        Object obj2;
        Object obj3;
        ByteWriteChannel byteWriteChannel4;
        ByteWriteChannel byteWriteChannel5;
        ByteWriteChannel byteWriteChannel6;
        ByteWriteChannel byteWriteChannel7;
        ByteWriteChannel byteWriteChannel8;
        try {
            if (continuation instanceof OutputAdapter$loop$1$loop$1) {
                outputAdapter$loop$1$loop$1 = (OutputAdapter$loop$1$loop$1) continuation;
                if ((outputAdapter$loop$1$loop$1.label & Integer.MIN_VALUE) != 0) {
                    outputAdapter$loop$1$loop$1.label -= Integer.MIN_VALUE;
                    obj = outputAdapter$loop$1$loop$1.result;
                    coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    blockingAdapter = outputAdapter$loop$1$loop$1.label;
                    if (blockingAdapter != 0) {
                        ResultKt.throwOnFailure(obj);
                        blockingAdapter = this;
                    } else if (blockingAdapter == 1) {
                        blockingAdapter = (OutputAdapter$loop$1) outputAdapter$loop$1$loop$1.L$0;
                        ResultKt.throwOnFailure(obj);
                        obj2 = BlockingKt.CloseToken;
                        if (obj != obj2) {
                            obj3 = BlockingKt.FlushToken;
                            if (obj == obj3) {
                                byteWriteChannel5 = blockingAdapter.this$0.channel;
                                byteWriteChannel5.flush();
                                byteWriteChannel6 = blockingAdapter.this$0.channel;
                                Throwable closedCause = byteWriteChannel6.getClosedCause();
                                if (closedCause != null) {
                                    throw closedCause;
                                }
                                blockingAdapter = blockingAdapter;
                            } else {
                                blockingAdapter = blockingAdapter;
                                if (obj instanceof byte[]) {
                                    byteWriteChannel4 = blockingAdapter.this$0.channel;
                                    int offset = blockingAdapter.getOffset();
                                    int length = blockingAdapter.getLength();
                                    outputAdapter$loop$1$loop$1.L$0 = blockingAdapter;
                                    outputAdapter$loop$1$loop$1.L$1 = null;
                                    outputAdapter$loop$1$loop$1.label = 2;
                                    blockingAdapter = blockingAdapter;
                                }
                            }
                        } else {
                            byteWriteChannel7 = blockingAdapter.this$0.channel;
                            if (!ByteWriteChannelKt.close(byteWriteChannel7)) {
                                byteWriteChannel8 = blockingAdapter.this$0.channel;
                                Throwable closedCause2 = byteWriteChannel8.getClosedCause();
                                if (closedCause2 != null) {
                                    throw closedCause2;
                                }
                            }
                            return Unit.INSTANCE;
                        }
                    } else {
                        if (blockingAdapter != 2) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        OutputAdapter$loop$1 outputAdapter$loop$1 = (OutputAdapter$loop$1) outputAdapter$loop$1$loop$1.L$0;
                        ResultKt.throwOnFailure(obj);
                        blockingAdapter = outputAdapter$loop$1;
                    }
                    BlockingAdapter blockingAdapter2 = blockingAdapter;
                    blockingAdapter2.result = 0;
                    outputAdapter$loop$1$loop$1.L$0 = blockingAdapter;
                    outputAdapter$loop$1$loop$1.L$1 = blockingAdapter2;
                    outputAdapter$loop$1$loop$1.label = 1;
                    obj = blockingAdapter2.rendezvousBlock(outputAdapter$loop$1$loop$1);
                    if (obj == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                        DebugProbesKt.probeCoroutineSuspended(outputAdapter$loop$1$loop$1);
                    }
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    obj2 = BlockingKt.CloseToken;
                    if (obj != obj2) {
                    }
                }
            }
            if (blockingAdapter != 0) {
            }
            BlockingAdapter blockingAdapter22 = blockingAdapter;
            blockingAdapter22.result = 0;
            outputAdapter$loop$1$loop$1.L$0 = blockingAdapter;
            outputAdapter$loop$1$loop$1.L$1 = blockingAdapter22;
            outputAdapter$loop$1$loop$1.label = 1;
            obj = blockingAdapter22.rendezvousBlock(outputAdapter$loop$1$loop$1);
            if (obj == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            }
            if (obj == coroutine_suspended) {
            }
            obj2 = BlockingKt.CloseToken;
            if (obj != obj2) {
            }
        } catch (Throwable th) {
            try {
                if (!(th instanceof CancellationException)) {
                    byteWriteChannel3 = blockingAdapter.this$0.channel;
                    byteWriteChannel3.close(th);
                }
                throw th;
            } catch (Throwable th2) {
                byteWriteChannel = blockingAdapter.this$0.channel;
                if (!ByteWriteChannelKt.close(byteWriteChannel)) {
                    byteWriteChannel2 = blockingAdapter.this$0.channel;
                    Throwable closedCause3 = byteWriteChannel2.getClosedCause();
                    if (closedCause3 != null) {
                        throw closedCause3;
                    }
                }
                throw th2;
            }
        }
        outputAdapter$loop$1$loop$1 = new OutputAdapter$loop$1$loop$1(this, continuation);
        obj = outputAdapter$loop$1$loop$1.result;
        coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        blockingAdapter = outputAdapter$loop$1$loop$1.label;
    }
}
