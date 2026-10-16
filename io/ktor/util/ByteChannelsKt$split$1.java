package io.ktor.util;

import io.ktor.utils.io.ByteChannel;
import io.ktor.utils.io.ByteReadChannel;
import io.ktor.utils.io.ByteReadChannelKt;
import io.ktor.utils.io.ByteWriteChannelKt;
import io.ktor.utils.io.pool.ByteArrayPoolKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Deferred;

/* compiled from: ByteChannels.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.util.ByteChannelsKt$split$1", f = "ByteChannels.kt", i = {0, 0, 1, 1}, l = {27, 31}, m = "invokeSuspend", n = {"$this$launch", "buffer", "$this$launch", "buffer"}, s = {"L$0", "L$1", "L$0", "L$1"})
/* loaded from: classes8.dex */
final class ByteChannelsKt$split$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ ByteChannel $first;
    final /* synthetic */ ByteChannel $second;
    final /* synthetic */ ByteReadChannel $this_split;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ByteChannelsKt$split$1(ByteReadChannel byteReadChannel, ByteChannel byteChannel, ByteChannel byteChannel2, Continuation<? super ByteChannelsKt$split$1> continuation) {
        super(2, continuation);
        this.$this_split = byteReadChannel;
        this.$first = byteChannel;
        this.$second = byteChannel2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        ByteChannelsKt$split$1 byteChannelsKt$split$1 = new ByteChannelsKt$split$1(this.$this_split, this.$first, this.$second, continuation);
        byteChannelsKt$split$1.L$0 = obj;
        return byteChannelsKt$split$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ByteChannelsKt$split$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x00a3, code lost:
    
        if (kotlinx.coroutines.AwaitKt.awaitAll(kotlin.collections.CollectionsKt.listOf((java.lang.Object[]) r10), r12) != r0) goto L17;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [int] */
    /* JADX WARN: Type inference failed for: r1v1, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v11 */
    /* JADX WARN: Type inference failed for: r1v12 */
    /* JADX WARN: Type inference failed for: r1v13 */
    /* JADX WARN: Type inference failed for: r1v6, types: [byte[], java.lang.Object] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:16:0x00a3 -> B:8:0x0044). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        CoroutineScope coroutineScope;
        byte[] bArr;
        Deferred async$default;
        Deferred async$default2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        ?? r1 = this.label;
        try {
            if (r1 == 0) {
                ResultKt.throwOnFailure(obj);
                coroutineScope = (CoroutineScope) this.L$0;
                r1 = ByteArrayPoolKt.getByteArrayPool().borrow();
            } else if (r1 == 1) {
                byte[] bArr2 = (byte[]) this.L$1;
                coroutineScope = (CoroutineScope) this.L$0;
                ResultKt.throwOnFailure(obj);
                bArr = bArr2;
                int intValue = ((Number) obj).intValue();
                async$default = BuildersKt__Builders_commonKt.async$default(coroutineScope, null, null, new AnonymousClass1(this.$first, bArr, intValue, null), 3, null);
                async$default2 = BuildersKt__Builders_commonKt.async$default(coroutineScope, null, null, new AnonymousClass2(this.$second, bArr, intValue, null), 3, null);
                Deferred[] deferredArr = {async$default, async$default2};
                this.L$0 = coroutineScope;
                this.L$1 = bArr;
                this.label = 2;
                r1 = bArr;
            } else {
                if (r1 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                byte[] bArr3 = (byte[]) this.L$1;
                coroutineScope = (CoroutineScope) this.L$0;
                ResultKt.throwOnFailure(obj);
                r1 = bArr3;
            }
        } catch (Throwable th) {
            try {
                this.$this_split.cancel(th);
                this.$first.cancel(th);
                this.$second.cancel(th);
                ByteArrayPoolKt.getByteArrayPool().recycle(r1);
            } catch (Throwable th2) {
                ByteArrayPoolKt.getByteArrayPool().recycle(r1);
                ByteWriteChannelKt.close(this.$first);
                ByteWriteChannelKt.close(this.$second);
                throw th2;
            }
        }
        if (!this.$this_split.isClosedForRead()) {
            this.L$0 = coroutineScope;
            this.L$1 = r1;
            this.label = 1;
            obj = ByteReadChannelKt.readAvailable(this.$this_split, r1, this);
            bArr = r1;
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
            int intValue2 = ((Number) obj).intValue();
            async$default = BuildersKt__Builders_commonKt.async$default(coroutineScope, null, null, new AnonymousClass1(this.$first, bArr, intValue2, null), 3, null);
            async$default2 = BuildersKt__Builders_commonKt.async$default(coroutineScope, null, null, new AnonymousClass2(this.$second, bArr, intValue2, null), 3, null);
            Deferred[] deferredArr2 = {async$default, async$default2};
            this.L$0 = coroutineScope;
            this.L$1 = bArr;
            this.label = 2;
            r1 = bArr;
        } else {
            Throwable closedCause = this.$this_split.getClosedCause();
            if (closedCause != null) {
                throw closedCause;
            }
            ByteArrayPoolKt.getByteArrayPool().recycle(r1);
            ByteWriteChannelKt.close(this.$first);
            ByteWriteChannelKt.close(this.$second);
            return Unit.INSTANCE;
        }
    }

    /* compiled from: ByteChannels.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.util.ByteChannelsKt$split$1$1", f = "ByteChannels.kt", i = {}, l = {29}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: io.ktor.util.ByteChannelsKt$split$1$1, reason: invalid class name */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ byte[] $buffer;
        final /* synthetic */ ByteChannel $first;
        final /* synthetic */ int $read;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(ByteChannel byteChannel, byte[] bArr, int i, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$first = byteChannel;
            this.$buffer = bArr;
            this.$read = i;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$first, this.$buffer, this.$read, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (this.$first.writeFully(this.$buffer, 0, this.$read, this) == coroutine_suspended) {
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

    /* compiled from: ByteChannels.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.util.ByteChannelsKt$split$1$2", f = "ByteChannels.kt", i = {}, l = {30}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: io.ktor.util.ByteChannelsKt$split$1$2, reason: invalid class name */
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ byte[] $buffer;
        final /* synthetic */ int $read;
        final /* synthetic */ ByteChannel $second;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(ByteChannel byteChannel, byte[] bArr, int i, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$second = byteChannel;
            this.$buffer = bArr;
            this.$read = i;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass2(this.$second, this.$buffer, this.$read, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (this.$second.writeFully(this.$buffer, 0, this.$read, this) == coroutine_suspended) {
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
}
