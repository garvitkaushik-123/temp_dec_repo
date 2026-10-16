package io.ktor.websocket;

import adn.analytics.Analytics;
import io.ktor.utils.io.charsets.CharsetJVMKt;
import io.ktor.websocket.Frame;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.SendChannel;

/* compiled from: PingPong.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.websocket.PingPongKt$pinger$1$rc$1", f = "PingPong.kt", i = {}, l = {75, Analytics.AnalyticsData.EXTRA_SIGNALS_FIELD_NUMBER}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes8.dex */
final class PingPongKt$pinger$1$rc$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Channel<Frame.Pong> $channel;
    final /* synthetic */ SendChannel<Frame> $outgoing;
    final /* synthetic */ String $pingMessage;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    PingPongKt$pinger$1$rc$1(SendChannel<? super Frame> sendChannel, String str, Channel<Frame.Pong> channel, Continuation<? super PingPongKt$pinger$1$rc$1> continuation) {
        super(2, continuation);
        this.$outgoing = sendChannel;
        this.$pingMessage = str;
        this.$channel = channel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new PingPongKt$pinger$1$rc$1(this.$outgoing, this.$pingMessage, this.$channel, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((PingPongKt$pinger$1$rc$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x006e, code lost:
    
        if (r9 == r0) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0070, code lost:
    
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0060, code lost:
    
        if (r9.send(new io.ktor.websocket.Frame.Ping(r5), r8) == r0) goto L19;
     */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:13:0x006e -> B:6:0x0071). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        byte[] encodeToByteArray;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            DefaultWebSocketSessionKt.getLOGGER().trace("WebSocket Pinger: sending ping frame");
            SendChannel<Frame> sendChannel = this.$outgoing;
            String str = this.$pingMessage;
            Charset charset = Charsets.ISO_8859_1;
            if (Intrinsics.areEqual(charset, Charsets.UTF_8)) {
                encodeToByteArray = StringsKt.encodeToByteArray(str);
            } else {
                CharsetEncoder newEncoder = charset.newEncoder();
                Intrinsics.checkNotNullExpressionValue(newEncoder, "charset.newEncoder()");
                encodeToByteArray = CharsetJVMKt.encodeToByteArray(newEncoder, str, 0, str.length());
            }
            this.label = 1;
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            if (i != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            Frame.Pong pong = (Frame.Pong) obj;
            byte[] data = pong.getData();
            if (Intrinsics.areEqual(new String(data, 0, data.length, Charsets.ISO_8859_1), this.$pingMessage)) {
                DefaultWebSocketSessionKt.getLOGGER().trace("WebSocket Pinger: received valid pong frame " + pong);
                return Unit.INSTANCE;
            }
            DefaultWebSocketSessionKt.getLOGGER().trace("WebSocket Pinger: received invalid pong frame " + pong + ", continue waiting");
        }
        this.label = 2;
        obj = this.$channel.receive(this);
    }
}
