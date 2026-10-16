package io.ktor.util;

import android.support.v4.media.session.PlaybackStateCompat;
import io.ktor.utils.io.ByteReadChannel;
import io.ktor.utils.io.ByteWriteChannel;
import io.ktor.utils.io.ByteWriteChannelKt;
import io.ktor.utils.io.core.ByteReadPacket;
import java.io.Closeable;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: ByteChannels.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.util.ByteChannelsKt$copyToBoth$1", f = "ByteChannels.kt", i = {1, 1, 1, 2, 2}, l = {61, 63, 64}, m = "invokeSuspend", n = {"$this$use$iv", "it", "closed$iv", "$this$use$iv", "closed$iv"}, s = {"L$0", "L$4", "I$0", "L$0", "I$0"})
/* loaded from: classes8.dex */
final class ByteChannelsKt$copyToBoth$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ ByteWriteChannel $first;
    final /* synthetic */ ByteWriteChannel $second;
    final /* synthetic */ ByteReadChannel $this_copyToBoth;
    int I$0;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ByteChannelsKt$copyToBoth$1(ByteReadChannel byteReadChannel, ByteWriteChannel byteWriteChannel, ByteWriteChannel byteWriteChannel2, Continuation<? super ByteChannelsKt$copyToBoth$1> continuation) {
        super(2, continuation);
        this.$this_copyToBoth = byteReadChannel;
        this.$first = byteWriteChannel;
        this.$second = byteWriteChannel2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ByteChannelsKt$copyToBoth$1(this.$this_copyToBoth, this.$first, this.$second, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ByteChannelsKt$copyToBoth$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x00d2, code lost:
    
        if (r6.writePacket(r12, r11) == r0) goto L40;
     */
    /* JADX WARN: Removed duplicated region for block: B:13:0x006c A[Catch: all -> 0x005e, TryCatch #5 {all -> 0x005e, blocks: (B:10:0x00e5, B:11:0x0064, B:13:0x006c, B:15:0x0074, B:17:0x007c, B:22:0x0096, B:38:0x00f5, B:50:0x00f6, B:53:0x00ff, B:67:0x005a, B:34:0x00f3, B:40:0x00f0, B:33:0x00eb, B:24:0x009f, B:56:0x00d8), top: B:66:0x005a, inners: #1, #4 }] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00fe  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00ff A[Catch: all -> 0x005e, TRY_LEAVE, TryCatch #5 {all -> 0x005e, blocks: (B:10:0x00e5, B:11:0x0064, B:13:0x006c, B:15:0x0074, B:17:0x007c, B:22:0x0096, B:38:0x00f5, B:50:0x00f6, B:53:0x00ff, B:67:0x005a, B:34:0x00f3, B:40:0x00f0, B:33:0x00eb, B:24:0x009f, B:56:0x00d8), top: B:66:0x005a, inners: #1, #4 }] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:29:0x00d2 -> B:9:0x00d5). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        Throwable th;
        Closeable closeable;
        ByteWriteChannel byteWriteChannel;
        ByteWriteChannel byteWriteChannel2;
        ByteReadChannel byteReadChannel;
        ByteReadPacket byteReadPacket;
        int i;
        ByteReadPacket copy;
        Throwable closedCause;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = this.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            if (this.$this_copyToBoth.isClosedForRead()) {
            }
            closedCause = this.$this_copyToBoth.getClosedCause();
            if (closedCause == null) {
            }
        } else if (i2 == 1) {
            try {
                ResultKt.throwOnFailure(obj);
                closeable = (Closeable) obj;
                byteWriteChannel = this.$first;
                byteWriteChannel2 = this.$second;
                byteReadChannel = this.$this_copyToBoth;
                byteReadPacket = (ByteReadPacket) closeable;
                copy = byteReadPacket.copy();
                this.L$0 = closeable;
                this.L$1 = byteWriteChannel;
                this.L$2 = byteWriteChannel2;
                this.L$3 = byteReadChannel;
                this.L$4 = byteReadPacket;
                i = 0;
                this.I$0 = 0;
                this.label = 2;
                if (byteWriteChannel.writePacket(copy, this) == coroutine_suspended) {
                }
                ByteReadPacket copy2 = byteReadPacket.copy();
                this.L$0 = closeable;
                this.L$1 = byteWriteChannel;
                this.L$2 = byteWriteChannel2;
                this.L$3 = byteReadChannel;
                this.L$4 = null;
                this.I$0 = i;
                this.label = 3;
            } finally {
                try {
                    ByteWriteChannelKt.close(this.$first);
                    ByteWriteChannelKt.close(this.$second);
                    return Unit.INSTANCE;
                } catch (Throwable th2) {
                }
            }
        } else if (i2 == 2) {
            int i3 = this.I$0;
            ByteReadPacket byteReadPacket2 = (ByteReadPacket) this.L$4;
            ByteReadChannel byteReadChannel2 = (ByteReadChannel) this.L$3;
            ByteWriteChannel byteWriteChannel3 = (ByteWriteChannel) this.L$2;
            ByteWriteChannel byteWriteChannel4 = (ByteWriteChannel) this.L$1;
            Closeable closeable2 = (Closeable) this.L$0;
            try {
                ResultKt.throwOnFailure(obj);
                byteReadPacket = byteReadPacket2;
                byteWriteChannel2 = byteWriteChannel3;
                closeable = closeable2;
                i = i3;
                byteReadChannel = byteReadChannel2;
                byteWriteChannel = byteWriteChannel4;
            } catch (Throwable th3) {
                th = th3;
                byteReadChannel = byteReadChannel2;
                byteWriteChannel2 = byteWriteChannel3;
                byteWriteChannel = byteWriteChannel4;
                closeable = closeable2;
                byteReadChannel.cancel(th);
                byteWriteChannel.close(th);
                Boxing.boxBoolean(byteWriteChannel2.close(th));
                closeable.close();
                if (this.$this_copyToBoth.isClosedForRead()) {
                }
                closedCause = this.$this_copyToBoth.getClosedCause();
                if (closedCause == null) {
                }
            }
            ByteReadPacket copy22 = byteReadPacket.copy();
            this.L$0 = closeable;
            this.L$1 = byteWriteChannel;
            this.L$2 = byteWriteChannel2;
            this.L$3 = byteReadChannel;
            this.L$4 = null;
            this.I$0 = i;
            this.label = 3;
        } else {
            if (i2 != 3) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            byteReadChannel = (ByteReadChannel) this.L$3;
            byteWriteChannel2 = (ByteWriteChannel) this.L$2;
            byteWriteChannel = (ByteWriteChannel) this.L$1;
            closeable = (Closeable) this.L$0;
            try {
                ResultKt.throwOnFailure(obj);
            } catch (Throwable th4) {
                th = th4;
                byteReadChannel.cancel(th);
                byteWriteChannel.close(th);
                Boxing.boxBoolean(byteWriteChannel2.close(th));
                closeable.close();
                if (this.$this_copyToBoth.isClosedForRead()) {
                }
                closedCause = this.$this_copyToBoth.getClosedCause();
                if (closedCause == null) {
                }
            }
            Unit unit = Unit.INSTANCE;
            closeable.close();
            if (this.$this_copyToBoth.isClosedForRead() && (!this.$first.isClosedForWrite() || !this.$second.isClosedForWrite())) {
                try {
                    this.L$0 = null;
                    this.L$1 = null;
                    this.L$2 = null;
                    this.L$3 = null;
                    this.L$4 = null;
                    this.label = 1;
                    obj = this.$this_copyToBoth.readRemaining(PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM, this);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    byteReadPacket = (ByteReadPacket) closeable;
                    copy = byteReadPacket.copy();
                    this.L$0 = closeable;
                    this.L$1 = byteWriteChannel;
                    this.L$2 = byteWriteChannel2;
                    this.L$3 = byteReadChannel;
                    this.L$4 = byteReadPacket;
                    i = 0;
                    this.I$0 = 0;
                    this.label = 2;
                    if (byteWriteChannel.writePacket(copy, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    ByteReadPacket copy222 = byteReadPacket.copy();
                    this.L$0 = closeable;
                    this.L$1 = byteWriteChannel;
                    this.L$2 = byteWriteChannel2;
                    this.L$3 = byteReadChannel;
                    this.L$4 = null;
                    this.I$0 = i;
                    this.label = 3;
                } finally {
                }
                closeable = (Closeable) obj;
                byteWriteChannel = this.$first;
                byteWriteChannel2 = this.$second;
                byteReadChannel = this.$this_copyToBoth;
            } else {
                closedCause = this.$this_copyToBoth.getClosedCause();
                if (closedCause == null) {
                    throw closedCause;
                }
                ByteWriteChannelKt.close(this.$first);
                ByteWriteChannelKt.close(this.$second);
                return Unit.INSTANCE;
            }
        }
    }
}
