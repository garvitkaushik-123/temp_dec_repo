package io.ktor.utils.io.core;

import java.nio.ByteBuffer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ByteReadPacket.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u001a%\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005H\u0086\b¨\u0006\u0007"}, d2 = {"ByteReadPacket", "Lio/ktor/utils/io/core/ByteReadPacket;", "array", "", "offset", "", "length", "ktor-io"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes8.dex */
public final class ByteReadPacketKt {
    public static /* synthetic */ ByteReadPacket ByteReadPacket$default(byte[] array, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = array.length;
        }
        Intrinsics.checkNotNullParameter(array, "array");
        ByteBuffer wrap = ByteBuffer.wrap(array, i, i2);
        Intrinsics.checkNotNullExpressionValue(wrap, "wrap(array, offset, length)");
        return ByteReadPacketExtensionsKt.ByteReadPacket(wrap, new ByteReadPacketKt$ByteReadPacket$$inlined$ByteReadPacket$1(array));
    }

    public static final ByteReadPacket ByteReadPacket(byte[] array, int i, int i2) {
        Intrinsics.checkNotNullParameter(array, "array");
        ByteBuffer wrap = ByteBuffer.wrap(array, i, i2);
        Intrinsics.checkNotNullExpressionValue(wrap, "wrap(array, offset, length)");
        return ByteReadPacketExtensionsKt.ByteReadPacket(wrap, new ByteReadPacketKt$ByteReadPacket$$inlined$ByteReadPacket$1(array));
    }
}
