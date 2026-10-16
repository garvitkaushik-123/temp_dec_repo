package io.ktor.utils.io.internal;

import com.ironsource.D5;
import io.bidmachine.rendering.model.EventTaskParams;
import java.nio.ByteBuffer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Utils.kt */
@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\u001a\u0018\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0001H\u0000\u001a\u0014\u0010\u0005\u001a\u00020\u0001*\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0000\u001a\f\u0010\b\u001a\u00020\t*\u00020\u0006H\u0000\u001a\u001e\u0010\n\u001a\u00020\u0001*\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u00062\b\b\u0002\u0010\f\u001a\u00020\u0001H\u0000\u001a\u001e\u0010\r\u001a\u00020\u0001*\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u00062\b\b\u0002\u0010\u000e\u001a\u00020\u0001H\u0000\u001a\u001e\u0010\u000f\u001a\u00020\t*\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u00062\b\b\u0002\u0010\u0011\u001a\u00020\u0001H\u0000¨\u0006\u0012"}, d2 = {"getIOIntProperty", "", "name", "", EventTaskParams.STATE_GROUP_DEFAULT, "indexOfPartial", "Ljava/nio/ByteBuffer;", "sub", "isEmpty", "", "putAtMost", "src", D5.q, "putLimited", "limit", "startsWith", "prefix", "prefixSkip", "ktor-io"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes8.dex */
public final class UtilsKt {
    public static final boolean isEmpty(ByteBuffer byteBuffer) {
        Intrinsics.checkNotNullParameter(byteBuffer, "<this>");
        return !byteBuffer.hasRemaining();
    }

    public static final int getIOIntProperty(String name, int i) {
        String str;
        Integer intOrNull;
        Intrinsics.checkNotNullParameter(name, "name");
        try {
            str = System.getProperty("io.ktor.utils.io." + name);
        } catch (SecurityException unused) {
            str = null;
        }
        return (str == null || (intOrNull = kotlin.text.StringsKt.toIntOrNull(str)) == null) ? i : intOrNull.intValue();
    }

    public static final int indexOfPartial(ByteBuffer byteBuffer, ByteBuffer sub) {
        int i;
        Intrinsics.checkNotNullParameter(byteBuffer, "<this>");
        Intrinsics.checkNotNullParameter(sub, "sub");
        int position = sub.position();
        int remaining = sub.remaining();
        byte b = sub.get(position);
        int limit = byteBuffer.limit();
        loop0: for (int position2 = byteBuffer.position(); position2 < limit; position2++) {
            if (byteBuffer.get(position2) == b) {
                while (i < remaining) {
                    int i2 = position2 + i;
                    if (i2 == limit) {
                        break loop0;
                    }
                    i = byteBuffer.get(i2) == sub.get(position + i) ? i + 1 : 1;
                }
                return position2 - byteBuffer.position();
            }
        }
        return -1;
    }

    public static /* synthetic */ boolean startsWith$default(ByteBuffer byteBuffer, ByteBuffer byteBuffer2, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        return startsWith(byteBuffer, byteBuffer2, i);
    }

    public static final boolean startsWith(ByteBuffer byteBuffer, ByteBuffer prefix, int i) {
        Intrinsics.checkNotNullParameter(byteBuffer, "<this>");
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        int min = Math.min(byteBuffer.remaining(), prefix.remaining() - i);
        if (min <= 0) {
            return false;
        }
        int position = byteBuffer.position();
        int position2 = prefix.position() + i;
        for (int i2 = 0; i2 < min; i2++) {
            if (byteBuffer.get(position + i2) != prefix.get(position2 + i2)) {
                return false;
            }
        }
        return true;
    }

    public static /* synthetic */ int putAtMost$default(ByteBuffer byteBuffer, ByteBuffer byteBuffer2, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = byteBuffer2.remaining();
        }
        return putAtMost(byteBuffer, byteBuffer2, i);
    }

    public static final int putAtMost(ByteBuffer byteBuffer, ByteBuffer src, int i) {
        Intrinsics.checkNotNullParameter(byteBuffer, "<this>");
        Intrinsics.checkNotNullParameter(src, "src");
        int remaining = byteBuffer.remaining();
        int remaining2 = src.remaining();
        if (remaining2 <= remaining && remaining2 <= i) {
            byteBuffer.put(src);
            return remaining2;
        }
        int min = Math.min(remaining, Math.min(remaining2, i));
        int i2 = 1;
        if (1 <= min) {
            while (true) {
                byteBuffer.put(src.get());
                if (i2 == min) {
                    break;
                }
                i2++;
            }
        }
        return min;
    }

    public static /* synthetic */ int putLimited$default(ByteBuffer byteBuffer, ByteBuffer byteBuffer2, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = byteBuffer.limit();
        }
        return putLimited(byteBuffer, byteBuffer2, i);
    }

    public static final int putLimited(ByteBuffer byteBuffer, ByteBuffer src, int i) {
        Intrinsics.checkNotNullParameter(byteBuffer, "<this>");
        Intrinsics.checkNotNullParameter(src, "src");
        return putAtMost(byteBuffer, src, i - src.position());
    }
}
