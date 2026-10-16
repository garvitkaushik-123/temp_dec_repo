package io.ktor.websocket;

import com.fyber.inneractive.sdk.bidder.TokenParametersOuterClass$TokenParameters;
import io.ktor.util.CryptoKt;
import io.ktor.util.date.DateJvmKt;
import io.ktor.websocket.CloseReason;
import io.ktor.websocket.Frame;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.random.Random;
import kotlin.random.RandomKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.TimeoutKt;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.SendChannel;

/* compiled from: PingPong.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.websocket.PingPongKt$pinger$1", f = "PingPong.kt", i = {0, 0, 1, 1}, l = {64, TokenParametersOuterClass$TokenParameters.APPSETID_FIELD_NUMBER, 95}, m = "invokeSuspend", n = {"random", "pingIdBytes", "random", "pingIdBytes"}, s = {"L$0", "L$1", "L$0", "L$1"})
/* loaded from: classes8.dex */
final class PingPongKt$pinger$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Channel<Frame.Pong> $channel;
    final /* synthetic */ Function2<CloseReason, Continuation<? super Unit>, Object> $onTimeout;
    final /* synthetic */ SendChannel<Frame> $outgoing;
    final /* synthetic */ long $periodMillis;
    final /* synthetic */ long $timeoutMillis;
    Object L$0;
    Object L$1;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    PingPongKt$pinger$1(long j, long j2, Function2<? super CloseReason, ? super Continuation<? super Unit>, ? extends Object> function2, Channel<Frame.Pong> channel, SendChannel<? super Frame> sendChannel, Continuation<? super PingPongKt$pinger$1> continuation) {
        super(2, continuation);
        this.$periodMillis = j;
        this.$timeoutMillis = j2;
        this.$onTimeout = function2;
        this.$channel = channel;
        this.$outgoing = sendChannel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new PingPongKt$pinger$1(this.$periodMillis, this.$timeoutMillis, this.$onTimeout, this.$channel, this.$outgoing, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((PingPongKt$pinger$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x00ec, code lost:
    
        if (r13.invoke(r1, r12) == r0) goto L29;
     */
    /* JADX WARN: Removed duplicated region for block: B:17:0x00ce A[Catch: CancellationException | ClosedReceiveChannelException | ClosedSendChannelException -> 0x00f1, CancellationException | ClosedReceiveChannelException | ClosedSendChannelException -> 0x00f1, CancellationException | ClosedReceiveChannelException | ClosedSendChannelException -> 0x00f1, TRY_LEAVE, TryCatch #0 {CancellationException | ClosedReceiveChannelException | ClosedSendChannelException -> 0x00f1, blocks: (B:7:0x0012, B:14:0x0027, B:14:0x0027, B:14:0x0027, B:15:0x00ca, B:15:0x00ca, B:15:0x00ca, B:17:0x00ce, B:17:0x00ce, B:17:0x00ce, B:21:0x0071, B:21:0x0071, B:21:0x0071, B:25:0x008d, B:25:0x008d, B:25:0x008d, B:29:0x0034, B:29:0x0034, B:29:0x0034), top: B:2:0x000a }] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00ef  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00c9  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:26:0x00c7 -> B:15:0x00ca). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        Random Random;
        byte[] bArr;
        Random random;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            DefaultWebSocketSessionKt.getLOGGER().trace("Starting WebSocket pinger coroutine with period " + this.$periodMillis + " ms and timeout " + this.$timeoutMillis + " ms");
            Random = RandomKt.Random(DateJvmKt.getTimeMillis());
            bArr = new byte[32];
            this.L$0 = Random;
            this.L$1 = bArr;
            this.label = 1;
            if (TimeoutKt.withTimeoutOrNull(this.$periodMillis, new AnonymousClass1(this.$channel, null), this) != coroutine_suspended) {
            }
        } else if (i == 1) {
            bArr = (byte[]) this.L$1;
            random = (Random) this.L$0;
            ResultKt.throwOnFailure(obj);
            random.nextBytes(bArr);
            String str = "[ping " + CryptoKt.hex(bArr) + " ping]";
            this.L$0 = random;
            this.L$1 = bArr;
            this.label = 2;
            obj = TimeoutKt.withTimeoutOrNull(this.$timeoutMillis, new PingPongKt$pinger$1$rc$1(this.$outgoing, str, this.$channel, null), this);
            if (obj == coroutine_suspended) {
            }
            if (((Unit) obj) != null) {
            }
        } else {
            if (i != 2) {
                if (i != 3) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                return Unit.INSTANCE;
            }
            bArr = (byte[]) this.L$1;
            random = (Random) this.L$0;
            ResultKt.throwOnFailure(obj);
            if (((Unit) obj) != null) {
                Random = random;
                this.L$0 = Random;
                this.L$1 = bArr;
                this.label = 1;
                if (TimeoutKt.withTimeoutOrNull(this.$periodMillis, new AnonymousClass1(this.$channel, null), this) != coroutine_suspended) {
                    return coroutine_suspended;
                }
                random = Random;
                random.nextBytes(bArr);
                String str2 = "[ping " + CryptoKt.hex(bArr) + " ping]";
                this.L$0 = random;
                this.L$1 = bArr;
                this.label = 2;
                obj = TimeoutKt.withTimeoutOrNull(this.$timeoutMillis, new PingPongKt$pinger$1$rc$1(this.$outgoing, str2, this.$channel, null), this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
                if (((Unit) obj) != null) {
                }
            } else {
                DefaultWebSocketSessionKt.getLOGGER().trace("WebSocket pinger has timed out");
                Function2<CloseReason, Continuation<? super Unit>, Object> function2 = this.$onTimeout;
                CloseReason closeReason = new CloseReason(CloseReason.Codes.INTERNAL_ERROR, "Ping timeout");
                this.L$0 = null;
                this.L$1 = null;
                this.label = 3;
            }
        }
    }

    /* compiled from: PingPong.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.websocket.PingPongKt$pinger$1$1", f = "PingPong.kt", i = {}, l = {66}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: io.ktor.websocket.PingPongKt$pinger$1$1, reason: invalid class name */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Channel<Frame.Pong> $channel;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(Channel<Frame.Pong> channel, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$channel = channel;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$channel, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i != 0 && i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            do {
                this.label = 1;
            } while (this.$channel.receive(this) != coroutine_suspended);
            return coroutine_suspended;
        }
    }
}
