package io.ktor.utils.io.core;

import io.ktor.utils.io.bits.MemoryJvmKt;
import io.ktor.utils.io.core.internal.ChunkBuffer;
import io.ktor.utils.io.core.internal.UnsafeKt;
import java.nio.ByteBuffer;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: InputArraysJvm.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\u001a\u001c\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u0001\u001a\u001c\u0010\u0006\u001a\u00020\u0007*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u0001¨\u0006\b"}, d2 = {"readAvailable", "", "Lio/ktor/utils/io/core/Input;", "dst", "Ljava/nio/ByteBuffer;", "length", "readFully", "", "ktor-io"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes8.dex */
public final class InputArraysJvmKt {
    public static /* synthetic */ void readFully$default(Input input, ByteBuffer byteBuffer, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = byteBuffer.remaining();
        }
        readFully(input, byteBuffer, i);
    }

    public static final void readFully(Input input, ByteBuffer dst, int i) {
        Intrinsics.checkNotNullParameter(input, "<this>");
        Intrinsics.checkNotNullParameter(dst, "dst");
        if (readAvailable(input, dst, i) >= i) {
            return;
        }
        StringsKt.prematureEndOfStream(i);
        throw new KotlinNothingValueException();
    }

    public static /* synthetic */ int readAvailable$default(Input input, ByteBuffer byteBuffer, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = byteBuffer.remaining();
        }
        return readAvailable(input, byteBuffer, i);
    }

    public static final int readAvailable(Input input, ByteBuffer dst, int i) {
        Intrinsics.checkNotNullParameter(input, "<this>");
        Intrinsics.checkNotNullParameter(dst, "dst");
        boolean z = true;
        ChunkBuffer prepareReadFirstHead = UnsafeKt.prepareReadFirstHead(input, 1);
        if (prepareReadFirstHead == null) {
            return 0;
        }
        int i2 = 0;
        do {
            try {
                ChunkBuffer chunkBuffer = prepareReadFirstHead;
                int limit = dst.limit();
                dst.limit(Math.min(limit, dst.position() + (chunkBuffer.getWritePosition() - chunkBuffer.getReadPosition())));
                int remaining = dst.remaining();
                MemoryJvmKt.m9983copyTo62zg_DM(chunkBuffer.getMemory(), dst, chunkBuffer.getReadPosition());
                dst.limit(limit);
                i2 += remaining;
                if (dst.hasRemaining() && i2 < i) {
                    try {
                        prepareReadFirstHead = UnsafeKt.prepareReadNextHead(input, prepareReadFirstHead);
                    } catch (Throwable th) {
                        th = th;
                        z = false;
                        if (z) {
                            UnsafeKt.completeReadHead(input, prepareReadFirstHead);
                        }
                        throw th;
                    }
                } else {
                    UnsafeKt.completeReadHead(input, prepareReadFirstHead);
                    return i2;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } while (prepareReadFirstHead != null);
        return i2;
    }
}
