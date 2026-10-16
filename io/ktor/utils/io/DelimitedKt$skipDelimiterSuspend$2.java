package io.ktor.utils.io;

import java.io.IOException;
import java.nio.ByteBuffer;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* compiled from: Delimited.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lio/ktor/utils/io/LookAheadSuspendSession;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.utils.io.DelimitedKt$skipDelimiterSuspend$2", f = "Delimited.kt", i = {0}, l = {66}, m = "invokeSuspend", n = {"$this$lookAheadSuspend"}, s = {"L$0"})
/* loaded from: classes8.dex */
final class DelimitedKt$skipDelimiterSuspend$2 extends SuspendLambda implements Function2<LookAheadSuspendSession, Continuation<? super Unit>, Object> {
    final /* synthetic */ ByteBuffer $delimiter;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    DelimitedKt$skipDelimiterSuspend$2(ByteBuffer byteBuffer, Continuation<? super DelimitedKt$skipDelimiterSuspend$2> continuation) {
        super(2, continuation);
        this.$delimiter = byteBuffer;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        DelimitedKt$skipDelimiterSuspend$2 delimitedKt$skipDelimiterSuspend$2 = new DelimitedKt$skipDelimiterSuspend$2(this.$delimiter, continuation);
        delimitedKt$skipDelimiterSuspend$2.L$0 = obj;
        return delimitedKt$skipDelimiterSuspend$2;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(LookAheadSuspendSession lookAheadSuspendSession, Continuation<? super Unit> continuation) {
        return ((DelimitedKt$skipDelimiterSuspend$2) create(lookAheadSuspendSession, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        LookAheadSuspendSession lookAheadSuspendSession;
        int tryEnsureDelimiter;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            LookAheadSuspendSession lookAheadSuspendSession2 = (LookAheadSuspendSession) this.L$0;
            this.L$0 = lookAheadSuspendSession2;
            this.label = 1;
            if (lookAheadSuspendSession2.awaitAtLeast(this.$delimiter.remaining(), this) == coroutine_suspended) {
                return coroutine_suspended;
            }
            lookAheadSuspendSession = lookAheadSuspendSession2;
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            lookAheadSuspendSession = (LookAheadSuspendSession) this.L$0;
            ResultKt.throwOnFailure(obj);
        }
        tryEnsureDelimiter = DelimitedKt.tryEnsureDelimiter(lookAheadSuspendSession, this.$delimiter);
        if (tryEnsureDelimiter != this.$delimiter.remaining()) {
            throw new IOException("Broken delimiter occurred");
        }
        return Unit.INSTANCE;
    }
}
