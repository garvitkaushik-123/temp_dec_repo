package io.ktor.utils.io.bits;

import com.google.firebase.analytics.FirebaseAnalytics;
import io.ktor.http.ContentDisposition;
import io.ktor.utils.io.core.internal.NumbersKt;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: MemoryJvm.kt */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0005\n\u0002\b\u000e\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0087@\u0018\u0000 32\u00020\u0001:\u00013B\u0012\u0012\u0006\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005J3\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00002\u0006\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\rø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0016\u0010\u0017J3\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00002\u0006\u0010\u0013\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\tø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0016\u0010\u0018J\u001a\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u001e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u001f\u0010\u000fJ\u0018\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\rH\u0086\b¢\u0006\u0004\b#\u0010$J\u0018\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\tH\u0086\b¢\u0006\u0004\b#\u0010%J&\u0010&\u001a\u00020\u00002\u0006\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\rø\u0001\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b'\u0010(J&\u0010&\u001a\u00020\u00002\u0006\u0010\u0013\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\tø\u0001\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b'\u0010)J \u0010*\u001a\u00020\u00112\u0006\u0010\"\u001a\u00020\r2\u0006\u0010+\u001a\u00020!H\u0086\b¢\u0006\u0004\b,\u0010-J \u0010*\u001a\u00020\u00112\u0006\u0010\"\u001a\u00020\t2\u0006\u0010+\u001a\u00020!H\u0086\b¢\u0006\u0004\b,\u0010.J\u0010\u0010/\u001a\u000200HÖ\u0001¢\u0006\u0004\b1\u00102R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0012\u0010\b\u001a\u00020\t8Æ\u0002¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0012\u0010\f\u001a\u00020\r8Æ\u0002¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000f\u0088\u0001\u0002ø\u0001\u0000\u0082\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u00064"}, d2 = {"Lio/ktor/utils/io/bits/Memory;", "", "buffer", "Ljava/nio/ByteBuffer;", "constructor-impl", "(Ljava/nio/ByteBuffer;)Ljava/nio/ByteBuffer;", "getBuffer", "()Ljava/nio/ByteBuffer;", ContentDisposition.Parameters.Size, "", "getSize-impl", "(Ljava/nio/ByteBuffer;)J", "size32", "", "getSize32-impl", "(Ljava/nio/ByteBuffer;)I", "copyTo", "", FirebaseAnalytics.Param.DESTINATION, "offset", "length", "destinationOffset", "copyTo-JT6ljtQ", "(Ljava/nio/ByteBuffer;Ljava/nio/ByteBuffer;III)V", "(Ljava/nio/ByteBuffer;Ljava/nio/ByteBuffer;JJJ)V", "equals", "", "other", "equals-impl", "(Ljava/nio/ByteBuffer;Ljava/lang/Object;)Z", "hashCode", "hashCode-impl", "loadAt", "", FirebaseAnalytics.Param.INDEX, "loadAt-impl", "(Ljava/nio/ByteBuffer;I)B", "(Ljava/nio/ByteBuffer;J)B", "slice", "slice-87lwejk", "(Ljava/nio/ByteBuffer;II)Ljava/nio/ByteBuffer;", "(Ljava/nio/ByteBuffer;JJ)Ljava/nio/ByteBuffer;", "storeAt", "value", "storeAt-impl", "(Ljava/nio/ByteBuffer;IB)V", "(Ljava/nio/ByteBuffer;JB)V", "toString", "", "toString-impl", "(Ljava/nio/ByteBuffer;)Ljava/lang/String;", "Companion", "ktor-io"}, k = 1, mv = {1, 8, 0}, xi = 48)
@JvmInline
/* loaded from: classes8.dex */
public final class Memory {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final ByteBuffer Empty;
    private final ByteBuffer buffer;

    /* renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ Memory m9965boximpl(ByteBuffer byteBuffer) {
        return new Memory(byteBuffer);
    }

    /* renamed from: constructor-impl, reason: not valid java name */
    public static ByteBuffer m9966constructorimpl(ByteBuffer buffer) {
        Intrinsics.checkNotNullParameter(buffer, "buffer");
        return buffer;
    }

    /* renamed from: equals-impl, reason: not valid java name */
    public static boolean m9969equalsimpl(ByteBuffer byteBuffer, Object obj) {
        return (obj instanceof Memory) && Intrinsics.areEqual(byteBuffer, ((Memory) obj).m9981unboximpl());
    }

    /* renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m9970equalsimpl0(ByteBuffer byteBuffer, ByteBuffer byteBuffer2) {
        return Intrinsics.areEqual(byteBuffer, byteBuffer2);
    }

    /* renamed from: hashCode-impl, reason: not valid java name */
    public static int m9973hashCodeimpl(ByteBuffer byteBuffer) {
        return byteBuffer.hashCode();
    }

    /* renamed from: toString-impl, reason: not valid java name */
    public static String m9980toStringimpl(ByteBuffer byteBuffer) {
        return "Memory(buffer=" + byteBuffer + ')';
    }

    public boolean equals(Object obj) {
        return m9969equalsimpl(this.buffer, obj);
    }

    public int hashCode() {
        return m9973hashCodeimpl(this.buffer);
    }

    public String toString() {
        return m9980toStringimpl(this.buffer);
    }

    /* renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ ByteBuffer m9981unboximpl() {
        return this.buffer;
    }

    private /* synthetic */ Memory(ByteBuffer byteBuffer) {
        this.buffer = byteBuffer;
    }

    public final ByteBuffer getBuffer() {
        return this.buffer;
    }

    /* renamed from: getSize-impl, reason: not valid java name */
    public static final long m9971getSizeimpl(ByteBuffer byteBuffer) {
        return byteBuffer.limit();
    }

    /* renamed from: getSize32-impl, reason: not valid java name */
    public static final int m9972getSize32impl(ByteBuffer byteBuffer) {
        return byteBuffer.limit();
    }

    /* renamed from: loadAt-impl, reason: not valid java name */
    public static final byte m9974loadAtimpl(ByteBuffer byteBuffer, int i) {
        return byteBuffer.get(i);
    }

    /* renamed from: loadAt-impl, reason: not valid java name */
    public static final byte m9975loadAtimpl(ByteBuffer byteBuffer, long j) {
        if (j < 2147483647L) {
            return byteBuffer.get((int) j);
        }
        NumbersKt.failLongToIntConversion(j, FirebaseAnalytics.Param.INDEX);
        throw new KotlinNothingValueException();
    }

    /* renamed from: storeAt-impl, reason: not valid java name */
    public static final void m9978storeAtimpl(ByteBuffer byteBuffer, int i, byte b) {
        byteBuffer.put(i, b);
    }

    /* renamed from: storeAt-impl, reason: not valid java name */
    public static final void m9979storeAtimpl(ByteBuffer byteBuffer, long j, byte b) {
        if (j < 2147483647L) {
            byteBuffer.put((int) j, b);
        } else {
            NumbersKt.failLongToIntConversion(j, FirebaseAnalytics.Param.INDEX);
            throw new KotlinNothingValueException();
        }
    }

    /* renamed from: slice-87lwejk, reason: not valid java name */
    public static final ByteBuffer m9976slice87lwejk(ByteBuffer byteBuffer, int i, int i2) {
        return m9966constructorimpl(MemoryJvmKt.sliceSafe(byteBuffer, i, i2));
    }

    /* renamed from: slice-87lwejk, reason: not valid java name */
    public static final ByteBuffer m9977slice87lwejk(ByteBuffer byteBuffer, long j, long j2) {
        if (j >= 2147483647L) {
            NumbersKt.failLongToIntConversion(j, "offset");
            throw new KotlinNothingValueException();
        }
        int i = (int) j;
        if (j2 < 2147483647L) {
            return m9976slice87lwejk(byteBuffer, i, (int) j2);
        }
        NumbersKt.failLongToIntConversion(j2, "length");
        throw new KotlinNothingValueException();
    }

    /* renamed from: copyTo-JT6ljtQ, reason: not valid java name */
    public static final void m9967copyToJT6ljtQ(ByteBuffer byteBuffer, ByteBuffer destination, int i, int i2, int i3) {
        Intrinsics.checkNotNullParameter(destination, "destination");
        if (byteBuffer.hasArray() && destination.hasArray() && !byteBuffer.isReadOnly() && !destination.isReadOnly()) {
            System.arraycopy(byteBuffer.array(), byteBuffer.arrayOffset() + i, destination.array(), destination.arrayOffset() + i3, i2);
            return;
        }
        ByteBuffer duplicate = byteBuffer.duplicate();
        duplicate.position(i);
        duplicate.limit(i + i2);
        ByteBuffer duplicate2 = destination.duplicate();
        duplicate2.position(i3);
        duplicate2.put(duplicate);
    }

    /* renamed from: copyTo-JT6ljtQ, reason: not valid java name */
    public static final void m9968copyToJT6ljtQ(ByteBuffer byteBuffer, ByteBuffer destination, long j, long j2, long j3) {
        Intrinsics.checkNotNullParameter(destination, "destination");
        if (j >= 2147483647L) {
            NumbersKt.failLongToIntConversion(j, "offset");
            throw new KotlinNothingValueException();
        }
        int i = (int) j;
        if (j2 >= 2147483647L) {
            NumbersKt.failLongToIntConversion(j2, "length");
            throw new KotlinNothingValueException();
        }
        int i2 = (int) j2;
        if (j3 < 2147483647L) {
            m9967copyToJT6ljtQ(byteBuffer, destination, i, i2, (int) j3);
        } else {
            NumbersKt.failLongToIntConversion(j3, "destinationOffset");
            throw new KotlinNothingValueException();
        }
    }

    /* compiled from: MemoryJvm.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006\u0082\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\b"}, d2 = {"Lio/ktor/utils/io/bits/Memory$Companion;", "", "()V", "Empty", "Lio/ktor/utils/io/bits/Memory;", "getEmpty-SK3TCg8", "()Ljava/nio/ByteBuffer;", "Ljava/nio/ByteBuffer;", "ktor-io"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* renamed from: getEmpty-SK3TCg8, reason: not valid java name */
        public final ByteBuffer m9982getEmptySK3TCg8() {
            return Memory.Empty;
        }
    }

    static {
        ByteBuffer order = ByteBuffer.allocate(0).order(ByteOrder.BIG_ENDIAN);
        Intrinsics.checkNotNullExpressionValue(order, "allocate(0).order(ByteOrder.BIG_ENDIAN)");
        Empty = m9966constructorimpl(order);
    }
}
