package io.ktor.utils.io.core;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.ironsource.D5;
import io.bidmachine.iab.vast.tags.VastAttributes;
import io.ktor.http.ContentDisposition;
import io.ktor.http.LinkHeader;
import io.ktor.utils.io.DeprecationKt;
import io.ktor.utils.io.bits.Memory;
import io.ktor.utils.io.core.internal.ChunkBuffer;
import io.ktor.utils.io.core.internal.MalformedUTF8InputException;
import io.ktor.utils.io.core.internal.UTF8Kt;
import io.ktor.utils.io.core.internal.UnsafeKt;
import io.ktor.utils.io.pool.ObjectPool;
import java.io.Closeable;
import java.io.EOFException;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import kotlin.Deprecated;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.DebugKt;

/* compiled from: Input.kt */
@Deprecated(message = DeprecationKt.IO_DEPRECATION_MESSAGE)
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u0001\n\u0002\b2\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0019\n\u0002\b\u0004\n\u0002\u0010\u0005\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000f\b'\u0018\u0000 \u008e\u00012\u00060\u0001j\u0002`\u0002:\u0002\u008e\u0001B)\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\b¢\u0006\u0002\u0010\tJ\u0010\u00107\u001a\u0002082\u0006\u0010\u0003\u001a\u00020\u0004H\u0002J\u0015\u00109\u001a\u0002082\u0006\u0010:\u001a\u00020\u0004H\u0000¢\u0006\u0002\b;J\u0010\u0010<\u001a\u0002082\u0006\u0010=\u001a\u00020\u0004H\u0002J\u0010\u0010>\u001a\u00020?2\u0006\u0010@\u001a\u00020\u0017H\u0002J\u0006\u0010A\u001a\u00020\u000fJ\b\u0010B\u001a\u000208H\u0016J\b\u0010C\u001a\u000208H$J\u000e\u0010D\u001a\u00020\u00172\u0006\u0010E\u001a\u00020\u0017J\u000e\u0010D\u001a\u00020\u00062\u0006\u0010E\u001a\u00020\u0006J\u0018\u0010F\u001a\u00020\u00172\u0006\u0010E\u001a\u00020\u00172\u0006\u0010G\u001a\u00020\u0017H\u0002J\u0019\u0010F\u001a\u00020\u00062\u0006\u0010E\u001a\u00020\u00062\u0006\u0010G\u001a\u00020\u0006H\u0082\u0010J\u000e\u0010H\u001a\u0002082\u0006\u0010E\u001a\u00020\u0017J\n\u0010I\u001a\u0004\u0018\u00010\u0004H\u0002J\u0010\u0010J\u001a\u00020\u000f2\u0006\u0010@\u001a\u00020\u0006H\u0002J\u0012\u0010K\u001a\u0004\u0018\u00010\u00042\u0006\u0010L\u001a\u00020\u0004H\u0001J\u001b\u0010K\u001a\u0004\u0018\u00010\u00042\u0006\u0010L\u001a\u00020\u00042\u0006\u0010M\u001a\u00020\u0004H\u0082\u0010J\u0017\u0010N\u001a\u0004\u0018\u00010\u00042\u0006\u0010L\u001a\u00020\u0004H\u0000¢\u0006\u0002\bOJ\n\u0010P\u001a\u0004\u0018\u00010\u0004H\u0014J-\u0010P\u001a\u00020\u00172\u0006\u0010Q\u001a\u00020\u001e2\u0006\u0010R\u001a\u00020\u00172\u0006\u0010S\u001a\u00020\u0017H$ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bT\u0010UJ\u0015\u0010V\u001a\u0002082\u0006\u0010L\u001a\u00020\u0004H\u0000¢\u0006\u0002\bWJ\u0010\u0010X\u001a\u0002082\u0006\u0010L\u001a\u00020\u0004H\u0002J \u0010Y\u001a\u0002082\u0006\u0010L\u001a\u00020\u00042\u0006\u0010Z\u001a\u00020\u00172\u0006\u0010[\u001a\u00020\u0017H\u0002J\u000e\u0010\\\u001a\u00020\u000f2\u0006\u0010E\u001a\u00020\u0017J\b\u0010]\u001a\u000208H\u0004J\u0018\u0010^\u001a\u00020?2\u0006\u0010@\u001a\u00020\u00172\u0006\u0010_\u001a\u00020\u0017H\u0002J\u0010\u0010`\u001a\u00020?2\u0006\u0010a\u001a\u00020\u0017H\u0002J\u0010\u0010b\u001a\u00020?2\u0006\u0010E\u001a\u00020\u0017H\u0002JA\u0010c\u001a\u00020\u00062\u0006\u0010Q\u001a\u00020\u001e2\u0006\u0010d\u001a\u00020\u00062\b\b\u0002\u0010R\u001a\u00020\u00062\b\b\u0002\u0010@\u001a\u00020\u00062\b\b\u0002\u0010_\u001a\u00020\u0006ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\be\u0010fJ\u000e\u0010c\u001a\u00020\u00172\u0006\u0010g\u001a\u00020\u0004J\u0015\u0010h\u001a\u00020\u000f2\u0006\u0010@\u001a\u00020\u0006H\u0000¢\u0006\u0002\biJ\u0018\u0010j\u001a\u00020?2\u0006\u0010@\u001a\u00020\u00172\u0006\u0010k\u001a\u00020\u0017H\u0002J\u0012\u0010l\u001a\u0004\u0018\u00010\u00042\u0006\u0010a\u001a\u00020\u0017H\u0001J\u001a\u0010l\u001a\u0004\u0018\u00010\u00042\u0006\u0010a\u001a\u00020\u00172\u0006\u0010\u0003\u001a\u00020\u0004H\u0001J\u0017\u0010m\u001a\u0004\u0018\u00010\u00042\u0006\u0010a\u001a\u00020\u0017H\u0000¢\u0006\u0002\bnJ\u001b\u0010o\u001a\u0004\u0018\u00010\u00042\u0006\u0010a\u001a\u00020\u00172\u0006\u0010\u0003\u001a\u00020\u0004H\u0082\u0010J$\u0010p\u001a\u00020\u00172\n\u0010q\u001a\u00060rj\u0002`s2\u0006\u0010@\u001a\u00020\u00172\u0006\u0010_\u001a\u00020\u0017H\u0002J)\u0010t\u001a\u00020\u00172\u0006\u0010u\u001a\u00020v2\u0006\u0010R\u001a\u00020\u00172\u0006\u0010S\u001a\u00020\u00172\u0006\u0010k\u001a\u00020\u0017H\u0082\u0010J%\u0010w\u001a\u00020\u00172\u0006\u0010Q\u001a\u00020x2\u0006\u0010y\u001a\u00020\u00172\u0006\u0010z\u001a\u00020\u0017H\u0000¢\u0006\u0002\b{J\u0006\u0010|\u001a\u00020}J\b\u0010~\u001a\u00020}H\u0002J\u001b\u0010\u007f\u001a\u00030\u0080\u00012\b\b\u0002\u0010@\u001a\u00020\u00172\b\b\u0002\u0010_\u001a\u00020\u0017J&\u0010\u007f\u001a\u00020\u00172\n\u0010q\u001a\u00060rj\u0002`s2\b\b\u0002\u0010@\u001a\u00020\u00172\b\b\u0002\u0010_\u001a\u00020\u0017J\u0011\u0010\u0081\u0001\u001a\u00030\u0080\u00012\u0007\u0010\u0082\u0001\u001a\u00020\u0017J\u001c\u0010\u0081\u0001\u001a\u0002082\n\u0010q\u001a\u00060rj\u0002`s2\u0007\u0010\u0082\u0001\u001a\u00020\u0017J%\u0010\u0083\u0001\u001a\u00020\u00172\n\u0010q\u001a\u00060rj\u0002`s2\u0006\u0010@\u001a\u00020\u00172\u0006\u0010_\u001a\u00020\u0017H\u0002J\u0007\u0010\u0084\u0001\u001a\u000208J\u0017\u0010\u0085\u0001\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0004H\u0000¢\u0006\u0003\b\u0086\u0001J\u0011\u0010\u0087\u0001\u001a\u0004\u0018\u00010\u0004H\u0000¢\u0006\u0003\b\u0088\u0001J\u0011\u0010\u0089\u0001\u001a\u0004\u0018\u00010\u0004H\u0000¢\u0006\u0003\b\u008a\u0001J\u0007\u0010\u008b\u0001\u001a\u00020\u0017J\u0017\u0010\u008c\u0001\u001a\u00020\u000f2\u0006\u0010:\u001a\u00020\u0004H\u0000¢\u0006\u0003\b\u008d\u0001R\u001e\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0004@BX\u0082\u000e¢\u0006\b\n\u0000\"\u0004\b\f\u0010\rR\u0011\u0010\u000e\u001a\u00020\u000f8F¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0003\u001a\u00020\u00048@X\u0081\u0004¢\u0006\f\u0012\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R$\u0010\u0016\u001a\u00020\u00178\u0000@\u0000X\u0081\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0018\u0010\u0013\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR/\u0010\u001d\u001a\u00020\u001e8\u0000@\u0000X\u0081\u000eø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0016\n\u0002\u0010$\u0012\u0004\b\u001f\u0010\u0013\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R$\u0010%\u001a\u00020\u00178\u0000@\u0000X\u0081\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b&\u0010\u0013\u001a\u0004\b'\u0010\u001a\"\u0004\b(\u0010\u001cR\u001b\u0010)\u001a\u00020\u00178À\u0002X\u0081\u0004¢\u0006\f\u0012\u0004\b*\u0010\u0013\u001a\u0004\b+\u0010\u001aR\u000e\u0010,\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\b¢\u0006\b\n\u0000\u001a\u0004\b-\u0010.R\u0011\u0010\u0005\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b/\u00100R,\u00102\u001a\u00020\u00062\u0006\u00101\u001a\u00020\u00068\u0000@@X\u0081\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b3\u0010\u0013\u001a\u0004\b4\u00100\"\u0004\b5\u00106\u0082\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u008f\u0001"}, d2 = {"Lio/ktor/utils/io/core/Input;", "Ljava/io/Closeable;", "Lio/ktor/utils/io/core/Closeable;", "head", "Lio/ktor/utils/io/core/internal/ChunkBuffer;", "remaining", "", "pool", "Lio/ktor/utils/io/pool/ObjectPool;", "(Lio/ktor/utils/io/core/internal/ChunkBuffer;JLio/ktor/utils/io/pool/ObjectPool;)V", "newHead", "_head", "set_head", "(Lio/ktor/utils/io/core/internal/ChunkBuffer;)V", "endOfInput", "", "getEndOfInput", "()Z", "getHead$annotations", "()V", "getHead", "()Lio/ktor/utils/io/core/internal/ChunkBuffer;", "headEndExclusive", "", "getHeadEndExclusive$annotations", "getHeadEndExclusive", "()I", "setHeadEndExclusive", "(I)V", "headMemory", "Lio/ktor/utils/io/bits/Memory;", "getHeadMemory-SK3TCg8$annotations", "getHeadMemory-SK3TCg8", "()Ljava/nio/ByteBuffer;", "setHeadMemory-3GNKZMM", "(Ljava/nio/ByteBuffer;)V", "Ljava/nio/ByteBuffer;", "headPosition", "getHeadPosition$annotations", "getHeadPosition", "setHeadPosition", "headRemaining", "getHeadRemaining$annotations", "getHeadRemaining", "noMoreChunksAvailable", "getPool", "()Lio/ktor/utils/io/pool/ObjectPool;", "getRemaining", "()J", "newValue", "tailRemaining", "getTailRemaining$annotations", "getTailRemaining", "setTailRemaining", "(J)V", "afterRead", "", "append", "chain", "append$ktor_io", "appendView", "chunk", "atLeastMinCharactersRequire", "", "min", "canRead", "close", "closeSource", "discard", D5.q, "discardAsMuchAsPossible", "skipped", "discardExact", "doFill", "doPrefetch", "ensureNext", "current", "empty", "ensureNextHead", "ensureNextHead$ktor_io", VastAttributes.FILL_COLOR, FirebaseAnalytics.Param.DESTINATION, "offset", "length", "fill-62zg_DM", "(Ljava/nio/ByteBuffer;II)I", "fixGapAfterRead", "fixGapAfterRead$ktor_io", "fixGapAfterReadFallback", "fixGapAfterReadFallbackUnreserved", ContentDisposition.Parameters.Size, "overrun", "hasBytes", "markNoMoreChunksAvailable", "minShouldBeLess", "max", "minSizeIsTooBig", "minSize", "notEnoughBytesAvailable", "peekTo", "destinationOffset", "peekTo-9zorpBc", "(Ljava/nio/ByteBuffer;JJJJ)J", "buffer", LinkHeader.Rel.Prefetch, "prefetch$ktor_io", "prematureEndOfStreamChars", "copied", "prepareRead", "prepareReadHead", "prepareReadHead$ktor_io", "prepareReadLoop", "readASCII", "out", "Ljava/lang/Appendable;", "Lkotlin/text/Appendable;", "readAsMuchAsPossible", "array", "", "readAvailableCharacters", "", DebugKt.DEBUG_PROPERTY_VALUE_OFF, "len", "readAvailableCharacters$ktor_io", "readByte", "", "readByteSlow", "readText", "", "readTextExact", "exactCharacters", "readUtf8", "release", "releaseHead", "releaseHead$ktor_io", "steal", "steal$ktor_io", "stealAll", "stealAll$ktor_io", "tryPeek", "tryWriteAppend", "tryWriteAppend$ktor_io", "Companion", "ktor-io"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes8.dex */
public abstract class Input implements Closeable {
    private ChunkBuffer _head;
    private int headEndExclusive;
    private ByteBuffer headMemory;
    private int headPosition;
    private boolean noMoreChunksAvailable;
    private final ObjectPool<ChunkBuffer> pool;
    private long tailRemaining;

    public Input() {
        this(null, 0L, null, 7, null);
    }

    public static /* synthetic */ void getHead$annotations() {
    }

    public static /* synthetic */ void getHeadEndExclusive$annotations() {
    }

    /* renamed from: getHeadMemory-SK3TCg8$annotations, reason: not valid java name */
    public static /* synthetic */ void m10147getHeadMemorySK3TCg8$annotations() {
    }

    public static /* synthetic */ void getHeadPosition$annotations() {
    }

    public static /* synthetic */ void getHeadRemaining$annotations() {
    }

    public static /* synthetic */ void getTailRemaining$annotations() {
    }

    protected abstract void closeSource();

    /* renamed from: fill-62zg_DM */
    protected abstract int mo10146fill62zg_DM(ByteBuffer destination, int offset, int length);

    public Input(ChunkBuffer head, long j, ObjectPool<ChunkBuffer> pool) {
        Intrinsics.checkNotNullParameter(head, "head");
        Intrinsics.checkNotNullParameter(pool, "pool");
        this.pool = pool;
        this._head = head;
        this.headMemory = head.getMemory();
        this.headPosition = head.getReadPosition();
        this.headEndExclusive = head.getWritePosition();
        this.tailRemaining = j - (r3 - this.headPosition);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ Input(ChunkBuffer chunkBuffer, long j, ObjectPool objectPool, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(chunkBuffer, (i & 2) != 0 ? BuffersKt.remainingAll(chunkBuffer) : j, (i & 4) != 0 ? ChunkBuffer.INSTANCE.getPool() : objectPool);
        chunkBuffer = (i & 1) != 0 ? ChunkBuffer.INSTANCE.getEmpty() : chunkBuffer;
    }

    public final ObjectPool<ChunkBuffer> getPool() {
        return this.pool;
    }

    private final void set_head(ChunkBuffer chunkBuffer) {
        this._head = chunkBuffer;
        this.headMemory = chunkBuffer.getMemory();
        this.headPosition = chunkBuffer.getReadPosition();
        this.headEndExclusive = chunkBuffer.getWritePosition();
    }

    public final ChunkBuffer getHead() {
        ChunkBuffer chunkBuffer = this._head;
        chunkBuffer.discardUntilIndex$ktor_io(this.headPosition);
        return chunkBuffer;
    }

    /* renamed from: getHeadMemory-SK3TCg8, reason: not valid java name and from getter */
    public final ByteBuffer getHeadMemory() {
        return this.headMemory;
    }

    /* renamed from: setHeadMemory-3GNKZMM, reason: not valid java name */
    public final void m10151setHeadMemory3GNKZMM(ByteBuffer byteBuffer) {
        Intrinsics.checkNotNullParameter(byteBuffer, "<set-?>");
        this.headMemory = byteBuffer;
    }

    public final int getHeadPosition() {
        return this.headPosition;
    }

    public final void setHeadPosition(int i) {
        this.headPosition = i;
    }

    public final int getHeadEndExclusive() {
        return this.headEndExclusive;
    }

    public final void setHeadEndExclusive(int i) {
        this.headEndExclusive = i;
    }

    public final long getTailRemaining() {
        return this.tailRemaining;
    }

    public final void setTailRemaining(long j) {
        if (j < 0) {
            throw new IllegalArgumentException(("tailRemaining shouldn't be negative: " + j).toString());
        }
        this.tailRemaining = j;
    }

    public final int getHeadRemaining() {
        return getHeadEndExclusive() - getHeadPosition();
    }

    /* renamed from: peekTo-9zorpBc$default, reason: not valid java name */
    public static /* synthetic */ long m10148peekTo9zorpBc$default(Input input, ByteBuffer byteBuffer, long j, long j2, long j3, long j4, int i, Object obj) {
        if (obj == null) {
            return input.m10150peekTo9zorpBc(byteBuffer, j, (i & 4) != 0 ? 0L : j2, (i & 8) != 0 ? 1L : j3, (i & 16) != 0 ? Long.MAX_VALUE : j4);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: peekTo-9zorpBc");
    }

    /* renamed from: peekTo-9zorpBc, reason: not valid java name */
    public final long m10150peekTo9zorpBc(ByteBuffer destination, long destinationOffset, long offset, long min, long max) {
        ByteBuffer destination2 = destination;
        Intrinsics.checkNotNullParameter(destination2, "destination");
        prefetch$ktor_io(min + offset);
        ChunkBuffer head = getHead();
        long min2 = Math.min(max, destination2.limit() - destinationOffset);
        long j = destinationOffset;
        ChunkBuffer chunkBuffer = head;
        long j2 = 0;
        long j3 = offset;
        while (j2 < min && j2 < min2) {
            ChunkBuffer chunkBuffer2 = chunkBuffer;
            long writePosition = chunkBuffer2.getWritePosition() - chunkBuffer2.getReadPosition();
            if (writePosition > j3) {
                long min3 = Math.min(writePosition - j3, min2 - j2);
                Memory.m9968copyToJT6ljtQ(chunkBuffer.getMemory(), destination2, chunkBuffer.getReadPosition() + j3, min3, j);
                j2 += min3;
                j += min3;
                j3 = 0;
            } else {
                j3 -= writePosition;
            }
            chunkBuffer = chunkBuffer.getNext();
            if (chunkBuffer == null) {
                return j2;
            }
            destination2 = destination;
        }
        return j2;
    }

    private final boolean doPrefetch(long min) {
        ChunkBuffer findTail = BuffersKt.findTail(this._head);
        long headEndExclusive = (getHeadEndExclusive() - getHeadPosition()) + this.tailRemaining;
        do {
            ChunkBuffer fill = fill();
            if (fill == null) {
                this.noMoreChunksAvailable = true;
                return false;
            }
            ChunkBuffer chunkBuffer = fill;
            int writePosition = chunkBuffer.getWritePosition() - chunkBuffer.getReadPosition();
            if (findTail == ChunkBuffer.INSTANCE.getEmpty()) {
                set_head(fill);
                findTail = fill;
            } else {
                findTail.setNext(fill);
                setTailRemaining(this.tailRemaining + writePosition);
            }
            headEndExclusive += writePosition;
        } while (headEndExclusive < min);
        return true;
    }

    public final boolean canRead() {
        return (this.headPosition == this.headEndExclusive && this.tailRemaining == 0) ? false : true;
    }

    public final void release() {
        ChunkBuffer head = getHead();
        ChunkBuffer empty = ChunkBuffer.INSTANCE.getEmpty();
        if (head != empty) {
            set_head(empty);
            setTailRemaining(0L);
            BuffersKt.releaseAll(head, this.pool);
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        release();
        if (!this.noMoreChunksAvailable) {
            this.noMoreChunksAvailable = true;
        }
        closeSource();
    }

    public final ChunkBuffer stealAll$ktor_io() {
        ChunkBuffer head = getHead();
        ChunkBuffer empty = ChunkBuffer.INSTANCE.getEmpty();
        if (head == empty) {
            return null;
        }
        set_head(empty);
        setTailRemaining(0L);
        return head;
    }

    public final ChunkBuffer steal$ktor_io() {
        ChunkBuffer head = getHead();
        ChunkBuffer next = head.getNext();
        ChunkBuffer empty = ChunkBuffer.INSTANCE.getEmpty();
        if (head == empty) {
            return null;
        }
        if (next == null) {
            set_head(empty);
            setTailRemaining(0L);
        } else {
            set_head(next);
            ChunkBuffer chunkBuffer = next;
            setTailRemaining(this.tailRemaining - (chunkBuffer.getWritePosition() - chunkBuffer.getReadPosition()));
        }
        head.setNext(null);
        return head;
    }

    public final void append$ktor_io(ChunkBuffer chain) {
        Intrinsics.checkNotNullParameter(chain, "chain");
        if (chain == ChunkBuffer.INSTANCE.getEmpty()) {
            return;
        }
        long remainingAll = BuffersKt.remainingAll(chain);
        if (this._head == ChunkBuffer.INSTANCE.getEmpty()) {
            set_head(chain);
            setTailRemaining(remainingAll - (getHeadEndExclusive() - getHeadPosition()));
        } else {
            BuffersKt.findTail(this._head).setNext(chain);
            setTailRemaining(this.tailRemaining + remainingAll);
        }
    }

    public final boolean tryWriteAppend$ktor_io(ChunkBuffer chain) {
        Intrinsics.checkNotNullParameter(chain, "chain");
        ChunkBuffer findTail = BuffersKt.findTail(getHead());
        ChunkBuffer chunkBuffer = chain;
        int writePosition = chunkBuffer.getWritePosition() - chunkBuffer.getReadPosition();
        if (writePosition == 0) {
            return false;
        }
        ChunkBuffer chunkBuffer2 = findTail;
        if (chunkBuffer2.getLimit() - chunkBuffer2.getWritePosition() < writePosition) {
            return false;
        }
        BufferAppendKt.writeBufferAppend(chunkBuffer2, chunkBuffer, writePosition);
        if (getHead() == findTail) {
            this.headEndExclusive = findTail.getWritePosition();
            return true;
        }
        setTailRemaining(this.tailRemaining + writePosition);
        return true;
    }

    public final byte readByte() {
        int i = this.headPosition;
        int i2 = i + 1;
        if (i2 < this.headEndExclusive) {
            this.headPosition = i2;
            return this.headMemory.get(i);
        }
        return readByteSlow();
    }

    private final byte readByteSlow() {
        int i = this.headPosition;
        if (i >= this.headEndExclusive) {
            ChunkBuffer prepareRead = prepareRead(1);
            if (prepareRead == null) {
                StringsKt.prematureEndOfStream(1);
                throw new KotlinNothingValueException();
            }
            byte readByte = prepareRead.readByte();
            UnsafeKt.completeReadHead(this, prepareRead);
            return readByte;
        }
        byte b = this.headMemory.get(i);
        this.headPosition = i;
        ChunkBuffer chunkBuffer = this._head;
        chunkBuffer.discardUntilIndex$ktor_io(i);
        ensureNext(chunkBuffer);
        return b;
    }

    public final int discard(int n) {
        if (n < 0) {
            throw new IllegalArgumentException(("Negative discard is not allowed: " + n).toString());
        }
        return discardAsMuchAsPossible(n, 0);
    }

    public final void discardExact(int n) {
        if (discard(n) != n) {
            throw new EOFException("Unable to discard " + n + " bytes due to end of packet");
        }
    }

    public final int tryPeek() {
        ChunkBuffer prepareReadLoop;
        ChunkBuffer head = getHead();
        if (getHeadEndExclusive() - getHeadPosition() > 0) {
            return head.tryPeekByte();
        }
        if ((this.tailRemaining == 0 && this.noMoreChunksAvailable) || (prepareReadLoop = prepareReadLoop(1, head)) == null) {
            return -1;
        }
        return prepareReadLoop.tryPeekByte();
    }

    public final int peekTo(ChunkBuffer buffer) {
        Intrinsics.checkNotNullParameter(buffer, "buffer");
        ChunkBuffer prepareReadHead$ktor_io = prepareReadHead$ktor_io(1);
        if (prepareReadHead$ktor_io == null) {
            return -1;
        }
        ChunkBuffer chunkBuffer = buffer;
        ChunkBuffer chunkBuffer2 = prepareReadHead$ktor_io;
        int min = Math.min(chunkBuffer.getLimit() - chunkBuffer.getWritePosition(), chunkBuffer2.getWritePosition() - chunkBuffer2.getReadPosition());
        BufferPrimitivesKt.writeFully(chunkBuffer, chunkBuffer2, min);
        return min;
    }

    public final long discard(long n) {
        if (n <= 0) {
            return 0L;
        }
        return discardAsMuchAsPossible(n, 0L);
    }

    public final int readAvailableCharacters$ktor_io(final char[] destination, final int off, int len) {
        Intrinsics.checkNotNullParameter(destination, "destination");
        if (getEndOfInput()) {
            return -1;
        }
        return readText(new Appendable(off, destination) { // from class: io.ktor.utils.io.core.Input$readAvailableCharacters$out$1
            final /* synthetic */ char[] $destination;
            private int idx;

            {
                this.$destination = destination;
                this.idx = off;
            }

            @Override // java.lang.Appendable
            public Appendable append(char value) {
                char[] cArr = this.$destination;
                int i = this.idx;
                this.idx = i + 1;
                cArr[i] = value;
                return this;
            }

            @Override // java.lang.Appendable
            public Appendable append(CharSequence value) {
                if (value instanceof String) {
                    String str = (String) value;
                    StringsJVMKt.getCharsInternal(str, this.$destination, this.idx);
                    this.idx += str.length();
                } else if (value != null) {
                    int length = value.length();
                    for (int i = 0; i < length; i++) {
                        char[] cArr = this.$destination;
                        int i2 = this.idx;
                        this.idx = i2 + 1;
                        cArr[i2] = value.charAt(i);
                    }
                }
                return this;
            }

            @Override // java.lang.Appendable
            public Appendable append(CharSequence value, int startIndex, int endIndex) {
                throw new UnsupportedOperationException();
            }
        }, 0, len);
    }

    public static /* synthetic */ int readText$default(Input input, Appendable appendable, int i, int i2, int i3, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: readText");
        }
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = Integer.MAX_VALUE;
        }
        return input.readText(appendable, i, i2);
    }

    public final int readText(Appendable out, int min, int max) {
        Intrinsics.checkNotNullParameter(out, "out");
        if (max >= getRemaining()) {
            String readTextExactBytes$default = StringsKt.readTextExactBytes$default(this, (int) getRemaining(), (Charset) null, 2, (Object) null);
            out.append(readTextExactBytes$default);
            return readTextExactBytes$default.length();
        }
        return readASCII(out, min, max);
    }

    public final void readTextExact(Appendable out, int exactCharacters) {
        Intrinsics.checkNotNullParameter(out, "out");
        readText(out, exactCharacters, exactCharacters);
    }

    public static /* synthetic */ String readText$default(Input input, int i, int i2, int i3, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: readText");
        }
        if ((i3 & 1) != 0) {
            i = 0;
        }
        if ((i3 & 2) != 0) {
            i2 = Integer.MAX_VALUE;
        }
        return input.readText(i, i2);
    }

    public final String readText(int min, int max) {
        if (min == 0 && (max == 0 || getEndOfInput())) {
            return "";
        }
        long remaining = getRemaining();
        if (remaining > 0 && max >= remaining) {
            return StringsKt.readTextExactBytes$default(this, (int) remaining, (Charset) null, 2, (Object) null);
        }
        StringBuilder sb = new StringBuilder(RangesKt.coerceAtMost(RangesKt.coerceAtLeast(min, 16), max));
        readASCII(sb, min, max);
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder(capacity).…builderAction).toString()");
        return sb2;
    }

    public final String readTextExact(int exactCharacters) {
        return readText(exactCharacters, exactCharacters);
    }

    private final int readASCII(Appendable out, int min, int max) {
        int i;
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5 = false;
        if (max == 0 && min == 0) {
            return 0;
        }
        if (getEndOfInput()) {
            if (min == 0) {
                return 0;
            }
            atLeastMinCharactersRequire(min);
            throw new KotlinNothingValueException();
        }
        if (max < min) {
            minShouldBeLess(min, max);
            throw new KotlinNothingValueException();
        }
        ChunkBuffer prepareReadFirstHead = UnsafeKt.prepareReadFirstHead(this, 1);
        if (prepareReadFirstHead == null) {
            i = 0;
        } else {
            i = 0;
            boolean z6 = false;
            while (true) {
                try {
                    ChunkBuffer chunkBuffer = prepareReadFirstHead;
                    ByteBuffer memory = chunkBuffer.getMemory();
                    int readPosition = chunkBuffer.getReadPosition();
                    int writePosition = chunkBuffer.getWritePosition();
                    for (int i2 = readPosition; i2 < writePosition; i2++) {
                        byte b = memory.get(i2);
                        int i3 = b & 255;
                        if ((b & 128) != 128) {
                            char c = (char) i3;
                            if (i == max) {
                                z4 = false;
                            } else {
                                out.append(c);
                                i++;
                                z4 = true;
                            }
                            if (z4) {
                            }
                        }
                        chunkBuffer.discardExact(i2 - readPosition);
                        z2 = false;
                        break;
                    }
                    chunkBuffer.discardExact(writePosition - readPosition);
                    z2 = true;
                    if (z2) {
                        z3 = true;
                    } else {
                        if (i != max) {
                            z6 = true;
                        }
                        z3 = false;
                    }
                    if (z3) {
                        try {
                            prepareReadFirstHead = UnsafeKt.prepareReadNextHead(this, prepareReadFirstHead);
                            if (prepareReadFirstHead == null) {
                                break;
                            }
                        } catch (Throwable th) {
                            th = th;
                            z = false;
                            if (z) {
                                UnsafeKt.completeReadHead(this, prepareReadFirstHead);
                            }
                            throw th;
                        }
                    } else {
                        UnsafeKt.completeReadHead(this, prepareReadFirstHead);
                        break;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    z = true;
                }
            }
            z5 = z6;
        }
        if (z5) {
            return i + readUtf8(out, min - i, max - i);
        }
        if (i >= min) {
            return i;
        }
        prematureEndOfStreamChars(min, i);
        throw new KotlinNothingValueException();
    }

    private final Void atLeastMinCharactersRequire(int min) {
        throw new EOFException("at least " + min + " characters required but no bytes available");
    }

    private final Void minShouldBeLess(int min, int max) {
        throw new IllegalArgumentException("min should be less or equal to max but min = " + min + ", max = " + max);
    }

    private final Void prematureEndOfStreamChars(int min, int copied) {
        throw new MalformedUTF8InputException("Premature end of stream: expected at least " + min + " chars but had only " + copied);
    }

    private final long discardAsMuchAsPossible(long n, long skipped) {
        ChunkBuffer prepareRead;
        while (n != 0 && (prepareRead = prepareRead(1)) != null) {
            ChunkBuffer chunkBuffer = prepareRead;
            int min = (int) Math.min(chunkBuffer.getWritePosition() - chunkBuffer.getReadPosition(), n);
            prepareRead.discardExact(min);
            this.headPosition += min;
            afterRead(prepareRead);
            long j = min;
            n -= j;
            skipped += j;
        }
        return skipped;
    }

    private final int discardAsMuchAsPossible(int n, int skipped) {
        while (n != 0) {
            ChunkBuffer prepareRead = prepareRead(1);
            if (prepareRead == null) {
                break;
            }
            ChunkBuffer chunkBuffer = prepareRead;
            int min = Math.min(chunkBuffer.getWritePosition() - chunkBuffer.getReadPosition(), n);
            prepareRead.discardExact(min);
            this.headPosition += min;
            afterRead(prepareRead);
            n -= min;
            skipped += min;
        }
        return skipped;
    }

    private final int readAsMuchAsPossible(byte[] array, int offset, int length, int copied) {
        while (length != 0) {
            ChunkBuffer prepareRead = prepareRead(1);
            if (prepareRead == null) {
                break;
            }
            ChunkBuffer chunkBuffer = prepareRead;
            int min = Math.min(length, chunkBuffer.getWritePosition() - chunkBuffer.getReadPosition());
            BufferPrimitivesKt.readFully((Buffer) chunkBuffer, array, offset, min);
            this.headPosition = prepareRead.getReadPosition();
            if (min == length && chunkBuffer.getWritePosition() - chunkBuffer.getReadPosition() != 0) {
                return copied + min;
            }
            afterRead(prepareRead);
            offset += min;
            length -= min;
            copied += min;
        }
        return copied;
    }

    private final Void notEnoughBytesAvailable(int n) {
        throw new EOFException("Not enough data in packet (" + getRemaining() + ") to read " + n + " byte(s)");
    }

    public final ChunkBuffer prepareReadHead$ktor_io(int minSize) {
        return prepareReadLoop(minSize, getHead());
    }

    public final ChunkBuffer ensureNextHead$ktor_io(ChunkBuffer current) {
        Intrinsics.checkNotNullParameter(current, "current");
        return ensureNext(current);
    }

    public final ChunkBuffer ensureNext(ChunkBuffer current) {
        Intrinsics.checkNotNullParameter(current, "current");
        return ensureNext(current, ChunkBuffer.INSTANCE.getEmpty());
    }

    public final void fixGapAfterRead$ktor_io(ChunkBuffer current) {
        Intrinsics.checkNotNullParameter(current, "current");
        ChunkBuffer next = current.getNext();
        if (next == null) {
            fixGapAfterReadFallback(current);
            return;
        }
        ChunkBuffer chunkBuffer = current;
        int writePosition = chunkBuffer.getWritePosition() - chunkBuffer.getReadPosition();
        int min = Math.min(writePosition, 8 - (chunkBuffer.getCapacity() - chunkBuffer.getLimit()));
        if (next.getStartGap() < min) {
            fixGapAfterReadFallback(current);
            return;
        }
        BufferKt.restoreStartGap(next, min);
        if (writePosition > min) {
            current.releaseEndGap$ktor_io();
            this.headEndExclusive = current.getWritePosition();
            setTailRemaining(this.tailRemaining + min);
        } else {
            set_head(next);
            setTailRemaining(this.tailRemaining - ((r3.getWritePosition() - r3.getReadPosition()) - min));
            current.cleanNext();
            current.release(this.pool);
        }
    }

    private final void fixGapAfterReadFallback(ChunkBuffer current) {
        if (this.noMoreChunksAvailable && current.getNext() == null) {
            this.headPosition = current.getReadPosition();
            this.headEndExclusive = current.getWritePosition();
            setTailRemaining(0L);
            return;
        }
        ChunkBuffer chunkBuffer = current;
        int writePosition = chunkBuffer.getWritePosition() - chunkBuffer.getReadPosition();
        int min = Math.min(writePosition, 8 - (chunkBuffer.getCapacity() - chunkBuffer.getLimit()));
        if (writePosition > min) {
            fixGapAfterReadFallbackUnreserved(current, writePosition, min);
        } else {
            ChunkBuffer borrow = this.pool.borrow();
            borrow.reserveEndGap(8);
            borrow.setNext(current.cleanNext());
            BufferAppendKt.writeBufferAppend(borrow, chunkBuffer, writePosition);
            set_head(borrow);
        }
        current.release(this.pool);
    }

    private final void fixGapAfterReadFallbackUnreserved(ChunkBuffer current, int size, int overrun) {
        ChunkBuffer borrow = this.pool.borrow();
        ChunkBuffer borrow2 = this.pool.borrow();
        borrow.reserveEndGap(8);
        borrow2.reserveEndGap(8);
        borrow.setNext(borrow2);
        borrow2.setNext(current.cleanNext());
        ChunkBuffer chunkBuffer = current;
        BufferAppendKt.writeBufferAppend(borrow, chunkBuffer, size - overrun);
        BufferAppendKt.writeBufferAppend(borrow2, chunkBuffer, overrun);
        set_head(borrow);
        setTailRemaining(BuffersKt.remainingAll(borrow2));
    }

    private final ChunkBuffer ensureNext(ChunkBuffer current, ChunkBuffer empty) {
        while (current != empty) {
            ChunkBuffer cleanNext = current.cleanNext();
            current.release(this.pool);
            if (cleanNext == null) {
                set_head(empty);
                setTailRemaining(0L);
                current = empty;
            } else {
                ChunkBuffer chunkBuffer = cleanNext;
                if (chunkBuffer.getWritePosition() > chunkBuffer.getReadPosition()) {
                    set_head(cleanNext);
                    setTailRemaining(this.tailRemaining - (chunkBuffer.getWritePosition() - chunkBuffer.getReadPosition()));
                    return cleanNext;
                }
                current = cleanNext;
            }
        }
        return doFill();
    }

    protected ChunkBuffer fill() {
        ChunkBuffer borrow = this.pool.borrow();
        try {
            borrow.reserveEndGap(8);
            ChunkBuffer chunkBuffer = borrow;
            int mo10146fill62zg_DM = mo10146fill62zg_DM(borrow.getMemory(), borrow.getWritePosition(), chunkBuffer.getLimit() - chunkBuffer.getWritePosition());
            if (mo10146fill62zg_DM == 0) {
                this.noMoreChunksAvailable = true;
                ChunkBuffer chunkBuffer2 = borrow;
                if (chunkBuffer2.getWritePosition() <= chunkBuffer2.getReadPosition()) {
                    borrow.release(this.pool);
                    return null;
                }
            }
            borrow.commitWritten(mo10146fill62zg_DM);
            return borrow;
        } catch (Throwable th) {
            borrow.release(this.pool);
            throw th;
        }
    }

    protected final void markNoMoreChunksAvailable() {
        if (this.noMoreChunksAvailable) {
            return;
        }
        this.noMoreChunksAvailable = true;
    }

    private final ChunkBuffer doFill() {
        if (this.noMoreChunksAvailable) {
            return null;
        }
        ChunkBuffer fill = fill();
        if (fill == null) {
            this.noMoreChunksAvailable = true;
            return null;
        }
        appendView(fill);
        return fill;
    }

    private final void appendView(ChunkBuffer chunk) {
        ChunkBuffer findTail = BuffersKt.findTail(this._head);
        if (findTail == ChunkBuffer.INSTANCE.getEmpty()) {
            set_head(chunk);
            if (this.tailRemaining != 0) {
                throw new IllegalStateException("It should be no tail remaining bytes if current tail is EmptyBuffer");
            }
            ChunkBuffer next = chunk.getNext();
            setTailRemaining(next != null ? BuffersKt.remainingAll(next) : 0L);
            return;
        }
        findTail.setNext(chunk);
        setTailRemaining(this.tailRemaining + BuffersKt.remainingAll(chunk));
    }

    public final ChunkBuffer prepareRead(int minSize) {
        ChunkBuffer head = getHead();
        return this.headEndExclusive - this.headPosition >= minSize ? head : prepareReadLoop(minSize, head);
    }

    public final ChunkBuffer prepareRead(int minSize, ChunkBuffer head) {
        Intrinsics.checkNotNullParameter(head, "head");
        return this.headEndExclusive - this.headPosition >= minSize ? head : prepareReadLoop(minSize, head);
    }

    private final Void minSizeIsTooBig(int minSize) {
        throw new IllegalStateException("minSize of " + minSize + " is too big (should be less than 8)");
    }

    private final void afterRead(ChunkBuffer head) {
        ChunkBuffer chunkBuffer = head;
        if (chunkBuffer.getWritePosition() - chunkBuffer.getReadPosition() == 0) {
            releaseHead$ktor_io(head);
        }
    }

    public final ChunkBuffer releaseHead$ktor_io(ChunkBuffer head) {
        Intrinsics.checkNotNullParameter(head, "head");
        ChunkBuffer cleanNext = head.cleanNext();
        if (cleanNext == null) {
            cleanNext = ChunkBuffer.INSTANCE.getEmpty();
        }
        set_head(cleanNext);
        ChunkBuffer chunkBuffer = cleanNext;
        setTailRemaining(this.tailRemaining - (chunkBuffer.getWritePosition() - chunkBuffer.getReadPosition()));
        head.release(this.pool);
        return cleanNext;
    }

    public final boolean getEndOfInput() {
        if (getHeadEndExclusive() - getHeadPosition() == 0 && this.tailRemaining == 0) {
            return this.noMoreChunksAvailable || doFill() == null;
        }
        return false;
    }

    public final boolean prefetch$ktor_io(long min) {
        if (min <= 0) {
            return true;
        }
        long headEndExclusive = getHeadEndExclusive() - getHeadPosition();
        if (headEndExclusive >= min || headEndExclusive + this.tailRemaining >= min) {
            return true;
        }
        return doPrefetch(min);
    }

    public final long getRemaining() {
        return (getHeadEndExclusive() - getHeadPosition()) + this.tailRemaining;
    }

    public final boolean hasBytes(int n) {
        return ((long) (getHeadEndExclusive() - getHeadPosition())) + this.tailRemaining >= ((long) n);
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x0177  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final int readUtf8(Appendable out, int min, int max) {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        ChunkBuffer prepareReadNextHead;
        int i7;
        int i8 = 1;
        ChunkBuffer prepareReadFirstHead = UnsafeKt.prepareReadFirstHead(this, 1);
        if (prepareReadFirstHead == null) {
            i7 = 0;
        } else {
            int i9 = 1;
            int i10 = 0;
            while (true) {
                try {
                    ChunkBuffer chunkBuffer = prepareReadFirstHead;
                    int writePosition = chunkBuffer.getWritePosition() - chunkBuffer.getReadPosition();
                    if (writePosition >= i9) {
                        try {
                            ChunkBuffer chunkBuffer2 = prepareReadFirstHead;
                            ByteBuffer memory = chunkBuffer2.getMemory();
                            int readPosition = chunkBuffer2.getReadPosition();
                            int writePosition2 = chunkBuffer2.getWritePosition();
                            int i11 = readPosition;
                            int i12 = 0;
                            int i13 = 0;
                            int i14 = 0;
                            while (true) {
                                if (i11 >= writePosition2) {
                                    i = i8;
                                    chunkBuffer2.discardExact(writePosition2 - readPosition);
                                    i2 = 0;
                                    break;
                                }
                                i = i8;
                                try {
                                    byte b = memory.get(i11);
                                    int i15 = b & 255;
                                    ByteBuffer byteBuffer = memory;
                                    i2 = -1;
                                    if ((b & 128) == 0) {
                                        if (i12 != 0) {
                                            UTF8Kt.malformedByteCount(i12);
                                            throw new KotlinNothingValueException();
                                        }
                                        char c = (char) i15;
                                        if (i10 == max) {
                                            i6 = 0;
                                        } else {
                                            out.append(c);
                                            i10++;
                                            i6 = i;
                                        }
                                        if (i6 == 0) {
                                            chunkBuffer2.discardExact(i11 - readPosition);
                                            break;
                                        }
                                        i11++;
                                        i8 = i;
                                        memory = byteBuffer;
                                    } else if (i12 == 0) {
                                        int i16 = 128;
                                        i13 = i15;
                                        for (int i17 = i; i17 < 7 && (i13 & i16) != 0; i17++) {
                                            i13 &= ~i16;
                                            i16 >>= 1;
                                            i12++;
                                        }
                                        int i18 = i12 - 1;
                                        if (i12 > writePosition2 - i11) {
                                            chunkBuffer2.discardExact(i11 - readPosition);
                                            i2 = i12;
                                            break;
                                        }
                                        i14 = i12;
                                        i12 = i18;
                                        i11++;
                                        i8 = i;
                                        memory = byteBuffer;
                                    } else {
                                        i13 = (i13 << 6) | (b & Byte.MAX_VALUE);
                                        i12--;
                                        if (i12 != 0) {
                                            continue;
                                        } else if (UTF8Kt.isBmpCodePoint(i13)) {
                                            char c2 = (char) i13;
                                            if (i10 == max) {
                                                i5 = 0;
                                            } else {
                                                out.append(c2);
                                                i10++;
                                                i5 = i;
                                            }
                                            if (i5 == 0) {
                                                chunkBuffer2.discardExact(((i11 - readPosition) - i14) + 1);
                                                break;
                                            }
                                            i13 = 0;
                                        } else {
                                            if (!UTF8Kt.isValidCodePoint(i13)) {
                                                UTF8Kt.malformedCodePoint(i13);
                                                throw new KotlinNothingValueException();
                                            }
                                            char highSurrogate = (char) UTF8Kt.highSurrogate(i13);
                                            if (i10 == max) {
                                                i3 = 0;
                                            } else {
                                                out.append(highSurrogate);
                                                i10++;
                                                i3 = i;
                                            }
                                            if (i3 == 0) {
                                                break;
                                            }
                                            char lowSurrogate = (char) UTF8Kt.lowSurrogate(i13);
                                            if (i10 == max) {
                                                i4 = 0;
                                            } else {
                                                out.append(lowSurrogate);
                                                i10++;
                                                i4 = i;
                                            }
                                            if (i4 == 0) {
                                                break;
                                            }
                                            i13 = 0;
                                        }
                                        i11++;
                                        i8 = i;
                                        memory = byteBuffer;
                                    }
                                } catch (Throwable th) {
                                    th = th;
                                    ChunkBuffer chunkBuffer3 = prepareReadFirstHead;
                                    chunkBuffer3.getWritePosition();
                                    chunkBuffer3.getReadPosition();
                                    throw th;
                                }
                            }
                            chunkBuffer2.discardExact(((i11 - readPosition) - i14) + 1);
                            i9 = i2 == 0 ? i : i2 > 0 ? i2 : 0;
                            try {
                                ChunkBuffer chunkBuffer4 = prepareReadFirstHead;
                                writePosition = chunkBuffer4.getWritePosition() - chunkBuffer4.getReadPosition();
                            } catch (Throwable th2) {
                                th = th2;
                                i8 = i;
                                if (i8 != 0) {
                                }
                                throw th;
                            }
                        } catch (Throwable th3) {
                            th = th3;
                            i = i8;
                        }
                    } else {
                        i = i8;
                    }
                    if (writePosition == 0) {
                        try {
                            prepareReadNextHead = UnsafeKt.prepareReadNextHead(this, prepareReadFirstHead);
                        } catch (Throwable th4) {
                            th = th4;
                            i8 = 0;
                            if (i8 != 0) {
                                UnsafeKt.completeReadHead(this, prepareReadFirstHead);
                            }
                            throw th;
                        }
                    } else {
                        if (writePosition >= i9) {
                            ChunkBuffer chunkBuffer5 = prepareReadFirstHead;
                            if (chunkBuffer5.getCapacity() - chunkBuffer5.getLimit() >= 8) {
                                prepareReadNextHead = prepareReadFirstHead;
                            }
                        }
                        UnsafeKt.completeReadHead(this, prepareReadFirstHead);
                        prepareReadNextHead = UnsafeKt.prepareReadFirstHead(this, i9);
                    }
                    if (prepareReadNextHead == null) {
                        i8 = 0;
                        break;
                    }
                    prepareReadFirstHead = prepareReadNextHead;
                    i8 = i;
                    if (i9 <= 0) {
                        break;
                    }
                } catch (Throwable th5) {
                    th = th5;
                }
            }
            if (i8 != 0) {
                UnsafeKt.completeReadHead(this, prepareReadFirstHead);
            }
            i7 = i10;
        }
        if (i7 >= min) {
            return i7;
        }
        prematureEndOfStreamChars(min, i7);
        throw new KotlinNothingValueException();
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x006a, code lost:
    
        return r11;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final ChunkBuffer prepareReadLoop(int minSize, ChunkBuffer head) {
        while (true) {
            int headEndExclusive = getHeadEndExclusive() - getHeadPosition();
            if (headEndExclusive >= minSize) {
                break;
            }
            ChunkBuffer next = head.getNext();
            if (next == null && (next = doFill()) == null) {
                return null;
            }
            if (headEndExclusive == 0) {
                if (head != ChunkBuffer.INSTANCE.getEmpty()) {
                    releaseHead$ktor_io(head);
                }
                head = next;
            } else {
                ChunkBuffer chunkBuffer = head;
                ChunkBuffer chunkBuffer2 = next;
                int writeBufferAppend = BufferAppendKt.writeBufferAppend(chunkBuffer, chunkBuffer2, minSize - headEndExclusive);
                this.headEndExclusive = head.getWritePosition();
                setTailRemaining(this.tailRemaining - writeBufferAppend);
                if (chunkBuffer2.getWritePosition() <= chunkBuffer2.getReadPosition()) {
                    head.setNext(null);
                    head.setNext(next.cleanNext());
                    next.release(this.pool);
                } else {
                    next.reserveStartGap(writeBufferAppend);
                }
                if (chunkBuffer.getWritePosition() - chunkBuffer.getReadPosition() >= minSize) {
                    break;
                }
                if (minSize > 8) {
                    minSizeIsTooBig(minSize);
                    throw new KotlinNothingValueException();
                }
            }
        }
    }
}
