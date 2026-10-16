package io.ktor.utils.io;

import java.nio.ByteBuffer;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;

/* compiled from: Delimited.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lio/ktor/utils/io/LookAheadSuspendSession;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.utils.io.DelimitedKt$readUntilDelimiterSuspend$copied$1", f = "Delimited.kt", i = {0, 0, 1, 1}, l = {85, 95}, m = "invokeSuspend", n = {"$this$lookAheadSuspend", "copied", "$this$lookAheadSuspend", "copied"}, s = {"L$0", "I$0", "L$0", "I$0"})
/* loaded from: classes8.dex */
final class DelimitedKt$readUntilDelimiterSuspend$copied$1 extends SuspendLambda implements Function2<LookAheadSuspendSession, Continuation<? super Integer>, Object> {
    final /* synthetic */ int $copied0;
    final /* synthetic */ ByteBuffer $delimiter;
    final /* synthetic */ ByteBuffer $dst;
    final /* synthetic */ Ref.BooleanRef $endFound;
    final /* synthetic */ ByteReadChannel $this_readUntilDelimiterSuspend;
    int I$0;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    DelimitedKt$readUntilDelimiterSuspend$copied$1(int i, ByteBuffer byteBuffer, ByteBuffer byteBuffer2, Ref.BooleanRef booleanRef, ByteReadChannel byteReadChannel, Continuation<? super DelimitedKt$readUntilDelimiterSuspend$copied$1> continuation) {
        super(2, continuation);
        this.$copied0 = i;
        this.$delimiter = byteBuffer;
        this.$dst = byteBuffer2;
        this.$endFound = booleanRef;
        this.$this_readUntilDelimiterSuspend = byteReadChannel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        DelimitedKt$readUntilDelimiterSuspend$copied$1 delimitedKt$readUntilDelimiterSuspend$copied$1 = new DelimitedKt$readUntilDelimiterSuspend$copied$1(this.$copied0, this.$delimiter, this.$dst, this.$endFound, this.$this_readUntilDelimiterSuspend, continuation);
        delimitedKt$readUntilDelimiterSuspend$copied$1.L$0 = obj;
        return delimitedKt$readUntilDelimiterSuspend$copied$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(LookAheadSuspendSession lookAheadSuspendSession, Continuation<? super Integer> continuation) {
        return ((DelimitedKt$readUntilDelimiterSuspend$copied$1) create(lookAheadSuspendSession, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x009a, code lost:
    
        if (r7.$endFound.element == false) goto L11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0080, code lost:
    
        if (r4.awaitAtLeast(r7.$delimiter.remaining(), r7) == r0) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0083, code lost:
    
        r1 = r1 + r5;
     */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0096  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x0080 -> B:6:0x0083). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        LookAheadSuspendSession lookAheadSuspendSession;
        int i;
        LookAheadSuspendSession lookAheadSuspendSession2;
        int tryCopyUntilDelimiter;
        int startsWithDelimiter;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = this.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            lookAheadSuspendSession = (LookAheadSuspendSession) this.L$0;
            i = this.$copied0;
            this.L$0 = lookAheadSuspendSession;
            this.I$0 = i;
            this.label = 1;
            if (lookAheadSuspendSession.awaitAtLeast(1, this) != coroutine_suspended) {
                lookAheadSuspendSession2 = lookAheadSuspendSession;
                LookAheadSuspendSession lookAheadSuspendSession3 = lookAheadSuspendSession2;
                tryCopyUntilDelimiter = DelimitedKt.tryCopyUntilDelimiter(lookAheadSuspendSession3, this.$delimiter, this.$dst);
                if (tryCopyUntilDelimiter == 0) {
                }
                lookAheadSuspendSession = lookAheadSuspendSession2;
                if (this.$dst.hasRemaining()) {
                }
                return Boxing.boxInt(i);
            }
            return coroutine_suspended;
        }
        if (i2 != 1) {
            if (i2 != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            i = this.I$0;
            lookAheadSuspendSession2 = (LookAheadSuspendSession) this.L$0;
            ResultKt.throwOnFailure(obj);
            lookAheadSuspendSession = lookAheadSuspendSession2;
            if (this.$dst.hasRemaining()) {
            }
            return Boxing.boxInt(i);
        }
        i = this.I$0;
        lookAheadSuspendSession2 = (LookAheadSuspendSession) this.L$0;
        ResultKt.throwOnFailure(obj);
        LookAheadSuspendSession lookAheadSuspendSession32 = lookAheadSuspendSession2;
        tryCopyUntilDelimiter = DelimitedKt.tryCopyUntilDelimiter(lookAheadSuspendSession32, this.$delimiter, this.$dst);
        if (tryCopyUntilDelimiter == 0) {
            startsWithDelimiter = DelimitedKt.startsWithDelimiter(lookAheadSuspendSession32, this.$delimiter);
            if (startsWithDelimiter == this.$delimiter.remaining()) {
                this.$endFound.element = true;
            } else if (!this.$this_readUntilDelimiterSuspend.isClosedForWrite()) {
                this.L$0 = lookAheadSuspendSession2;
                this.I$0 = i;
                this.label = 2;
            }
            return Boxing.boxInt(i);
        }
        if (tryCopyUntilDelimiter <= 0) {
            this.$endFound.element = true;
        }
        i += -tryCopyUntilDelimiter;
        lookAheadSuspendSession = lookAheadSuspendSession2;
        if (this.$dst.hasRemaining()) {
        }
        return Boxing.boxInt(i);
    }
}
