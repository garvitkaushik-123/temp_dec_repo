package io.ktor.util;

import io.ktor.utils.io.ByteReadChannel;
import io.ktor.utils.io.WriterScope;
import io.ktor.utils.io.pool.ObjectPool;
import java.nio.ByteBuffer;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* compiled from: Deflater.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lio/ktor/utils/io/WriterScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.util.DeflaterKt$deflated$1", f = "Deflater.kt", i = {}, l = {110}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes8.dex */
final class DeflaterKt$deflated$1 extends SuspendLambda implements Function2<WriterScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $gzip;
    final /* synthetic */ ObjectPool<ByteBuffer> $pool;
    final /* synthetic */ ByteReadChannel $this_deflated;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    DeflaterKt$deflated$1(ByteReadChannel byteReadChannel, boolean z, ObjectPool<ByteBuffer> objectPool, Continuation<? super DeflaterKt$deflated$1> continuation) {
        super(2, continuation);
        this.$this_deflated = byteReadChannel;
        this.$gzip = z;
        this.$pool = objectPool;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        DeflaterKt$deflated$1 deflaterKt$deflated$1 = new DeflaterKt$deflated$1(this.$this_deflated, this.$gzip, this.$pool, continuation);
        deflaterKt$deflated$1.L$0 = obj;
        return deflaterKt$deflated$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(WriterScope writerScope, Continuation<? super Unit> continuation) {
        return ((DeflaterKt$deflated$1) create(writerScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object deflateTo;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            WriterScope writerScope = (WriterScope) this.L$0;
            this.label = 1;
            deflateTo = DeflaterKt.deflateTo(this.$this_deflated, writerScope.getChannel(), this.$gzip, this.$pool, this);
            if (deflateTo == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        return Unit.INSTANCE;
    }
}
