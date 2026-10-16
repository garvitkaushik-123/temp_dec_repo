package io.ktor.websocket;

import io.ktor.util.NIOKt;
import java.nio.ByteBuffer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SimpleFrameCollector.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0004J\u0016\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u0004J\u0015\u0010\u0012\u001a\u00020\u00042\b\u0010\u0013\u001a\u0004\u0018\u00010\f¢\u0006\u0002\u0010\u0014R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0005\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\t\u001a\n \n*\u0004\u0018\u00010\u00040\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lio/ktor/websocket/SimpleFrameCollector;", "", "()V", "buffer", "Ljava/nio/ByteBuffer;", "hasRemaining", "", "getHasRemaining", "()Z", "maskBuffer", "kotlin.jvm.PlatformType", "remaining", "", "handle", "", "bb", "start", "length", "take", "maskKey", "(Ljava/lang/Integer;)Ljava/nio/ByteBuffer;", "ktor-websockets"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes8.dex */
public final class SimpleFrameCollector {
    private ByteBuffer buffer;
    private final ByteBuffer maskBuffer = ByteBuffer.allocate(4);
    private int remaining;

    public final boolean getHasRemaining() {
        return this.remaining > 0;
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x0016, code lost:
    
        if (r0.capacity() < r2) goto L8;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void start(int length, ByteBuffer bb) {
        Intrinsics.checkNotNullParameter(bb, "bb");
        if (this.remaining != 0) {
            throw new IllegalStateException("remaining should be 0");
        }
        this.remaining = length;
        ByteBuffer byteBuffer = this.buffer;
        if (byteBuffer != null) {
            Intrinsics.checkNotNull(byteBuffer);
        }
        this.buffer = ByteBuffer.allocate(length);
        ByteBuffer byteBuffer2 = this.buffer;
        Intrinsics.checkNotNull(byteBuffer2);
        byteBuffer2.clear();
        handle(bb);
    }

    public final void handle(ByteBuffer bb) {
        Intrinsics.checkNotNullParameter(bb, "bb");
        int i = this.remaining;
        ByteBuffer byteBuffer = this.buffer;
        Intrinsics.checkNotNull(byteBuffer);
        this.remaining = i - NIOKt.moveTo(bb, byteBuffer, this.remaining);
    }

    public final ByteBuffer take(Integer maskKey) {
        ByteBuffer byteBuffer = this.buffer;
        Intrinsics.checkNotNull(byteBuffer);
        byteBuffer.flip();
        ByteBuffer view = byteBuffer.slice();
        if (maskKey != null) {
            this.maskBuffer.clear();
            this.maskBuffer.asIntBuffer().put(maskKey.intValue());
            this.maskBuffer.clear();
            Intrinsics.checkNotNullExpressionValue(view, "view");
            ByteBuffer maskBuffer = this.maskBuffer;
            Intrinsics.checkNotNullExpressionValue(maskBuffer, "maskBuffer");
            UtilsKt.xor(view, maskBuffer);
        }
        this.buffer = null;
        ByteBuffer asReadOnlyBuffer = view.asReadOnlyBuffer();
        Intrinsics.checkNotNullExpressionValue(asReadOnlyBuffer, "buffer!!.run {\n        f….asReadOnlyBuffer()\n    }");
        return asReadOnlyBuffer;
    }
}
