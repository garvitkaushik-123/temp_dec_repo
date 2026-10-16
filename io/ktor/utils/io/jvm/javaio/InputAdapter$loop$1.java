package io.ktor.utils.io.jvm.javaio;

import io.ktor.utils.io.ByteReadChannel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.Job;

/* compiled from: Blocking.kt */
@Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0011\u0010\u0002\u001a\u00020\u0003H\u0094@ø\u0001\u0000¢\u0006\u0002\u0010\u0004\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0005"}, d2 = {"io/ktor/utils/io/jvm/javaio/InputAdapter$loop$1", "Lio/ktor/utils/io/jvm/javaio/BlockingAdapter;", "loop", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ktor-io"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes8.dex */
public final class InputAdapter$loop$1 extends BlockingAdapter {
    final /* synthetic */ InputAdapter this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    InputAdapter$loop$1(Job job, InputAdapter inputAdapter) {
        super(job);
        this.this$0 = inputAdapter;
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0089, code lost:
    
        if (r10 != r1) goto L26;
     */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0045  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x0089 -> B:11:0x008c). Please report as a decompilation issue!!! */
    @Override // io.ktor.utils.io.jvm.javaio.BlockingAdapter
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected Object loop(Continuation<? super Unit> continuation) {
        InputAdapter$loop$1$loop$1 inputAdapter$loop$1$loop$1;
        int i;
        int i2;
        InputAdapter$loop$1 inputAdapter$loop$1;
        ByteReadChannel byteReadChannel;
        Object rendezvousBlock;
        CompletableJob completableJob;
        if (continuation instanceof InputAdapter$loop$1$loop$1) {
            inputAdapter$loop$1$loop$1 = (InputAdapter$loop$1$loop$1) continuation;
            if ((inputAdapter$loop$1$loop$1.label & Integer.MIN_VALUE) != 0) {
                inputAdapter$loop$1$loop$1.label -= Integer.MIN_VALUE;
                Object obj = inputAdapter$loop$1$loop$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = inputAdapter$loop$1$loop$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    i2 = 0;
                    inputAdapter$loop$1 = this;
                    InputAdapter$loop$1 inputAdapter$loop$12 = inputAdapter$loop$1;
                    inputAdapter$loop$12.result = i2;
                    inputAdapter$loop$1$loop$1.L$0 = inputAdapter$loop$1;
                    inputAdapter$loop$1$loop$1.L$1 = inputAdapter$loop$12;
                    inputAdapter$loop$1$loop$1.label = 1;
                    InputAdapter$loop$1$loop$1 inputAdapter$loop$1$loop$12 = inputAdapter$loop$1$loop$1;
                    rendezvousBlock = inputAdapter$loop$12.rendezvousBlock(inputAdapter$loop$1$loop$12);
                    if (rendezvousBlock == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                    }
                    if (rendezvousBlock != coroutine_suspended) {
                    }
                    return coroutine_suspended;
                }
                if (i != 1) {
                    if (i != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    inputAdapter$loop$1 = (InputAdapter$loop$1) inputAdapter$loop$1$loop$1.L$0;
                    ResultKt.throwOnFailure(obj);
                    i2 = ((Number) obj).intValue();
                    if (i2 == -1) {
                        completableJob = inputAdapter$loop$1.this$0.context;
                        completableJob.complete();
                        inputAdapter$loop$1.finish(i2);
                        return Unit.INSTANCE;
                    }
                    InputAdapter$loop$1 inputAdapter$loop$122 = inputAdapter$loop$1;
                    inputAdapter$loop$122.result = i2;
                    inputAdapter$loop$1$loop$1.L$0 = inputAdapter$loop$1;
                    inputAdapter$loop$1$loop$1.L$1 = inputAdapter$loop$122;
                    inputAdapter$loop$1$loop$1.label = 1;
                    InputAdapter$loop$1$loop$1 inputAdapter$loop$1$loop$122 = inputAdapter$loop$1$loop$1;
                    rendezvousBlock = inputAdapter$loop$122.rendezvousBlock(inputAdapter$loop$1$loop$122);
                    if (rendezvousBlock == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                        DebugProbesKt.probeCoroutineSuspended(inputAdapter$loop$1$loop$122);
                    }
                    if (rendezvousBlock != coroutine_suspended) {
                        obj = rendezvousBlock;
                        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.ByteArray");
                        byteReadChannel = inputAdapter$loop$1.this$0.channel;
                        int offset = inputAdapter$loop$1.getOffset();
                        int length = inputAdapter$loop$1.getLength();
                        inputAdapter$loop$1$loop$1.L$0 = inputAdapter$loop$1;
                        inputAdapter$loop$1$loop$1.L$1 = null;
                        inputAdapter$loop$1$loop$1.label = 2;
                        obj = byteReadChannel.readAvailable((byte[]) obj, offset, length, inputAdapter$loop$1$loop$1);
                    }
                    return coroutine_suspended;
                }
                inputAdapter$loop$1 = (InputAdapter$loop$1) inputAdapter$loop$1$loop$1.L$0;
                ResultKt.throwOnFailure(obj);
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.ByteArray");
                byteReadChannel = inputAdapter$loop$1.this$0.channel;
                int offset2 = inputAdapter$loop$1.getOffset();
                int length2 = inputAdapter$loop$1.getLength();
                inputAdapter$loop$1$loop$1.L$0 = inputAdapter$loop$1;
                inputAdapter$loop$1$loop$1.L$1 = null;
                inputAdapter$loop$1$loop$1.label = 2;
                obj = byteReadChannel.readAvailable((byte[]) obj, offset2, length2, inputAdapter$loop$1$loop$1);
            }
        }
        inputAdapter$loop$1$loop$1 = new InputAdapter$loop$1$loop$1(this, continuation);
        Object obj2 = inputAdapter$loop$1$loop$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = inputAdapter$loop$1$loop$1.label;
        if (i != 0) {
        }
    }
}
