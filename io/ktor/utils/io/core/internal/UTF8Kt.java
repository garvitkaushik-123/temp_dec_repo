package io.ktor.utils.io.core.internal;

import com.adjust.sdk.Constants;
import com.google.firebase.messaging.Constants;
import io.ktor.http.ContentDisposition;
import io.ktor.utils.io.charsets.TooLongLineException;
import io.ktor.utils.io.core.Buffer;
import io.ktor.utils.io.core.Input;
import java.io.EOFException;
import java.nio.ByteBuffer;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.UShort;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.CharCompanionObject;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.RangesKt;

/* compiled from: UTF8.kt */
@Metadata(d1 = {"\u0000d\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\f\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u0001\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0014\u001a\u0010\u0010\u0006\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\u0001H\u0000\u001a\u0011\u0010\b\u001a\u00020\u00012\u0006\u0010\t\u001a\u00020\u0001H\u0082\b\u001a\u0018\u0010\n\u001a\u00020\u00012\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fH\u0000\u001a_\u0010\u000e\u001a\u00020\u000f2\n\u0010\u0010\u001a\u00060\u0011j\u0002`\u00122\u0006\u0010\u0013\u001a\u00020\u00012$\u0010\u0014\u001a \b\u0001\u0012\u0004\u0012\u00020\u0001\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00170\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u00180\u00152\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u001b0\u001aH\u0080@ø\u0001\u0000¢\u0006\u0002\u0010\u001c\u001a\u0010\u0010\u001d\u001a\u00020\u00012\u0006\u0010\u001e\u001a\u00020\u0001H\u0001\u001a\u0010\u0010\u001f\u001a\u00020\u000f2\u0006\u0010\u001e\u001a\u00020\u0001H\u0001\u001a\u0010\u0010 \u001a\u00020\u000f2\u0006\u0010\n\u001a\u00020\u0001H\u0001\u001a\u0010\u0010!\u001a\u00020\u00012\u0006\u0010\u001e\u001a\u00020\u0001H\u0001\u001a\u0010\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u0001H\u0001\u001a\u0010\u0010%\u001a\u00020#2\u0006\u0010&\u001a\u00020\u0001H\u0001\u001a\u0010\u0010'\u001a\u00020#2\u0006\u0010(\u001a\u00020\u0001H\u0002\u001a$\u0010)\u001a\u00020\u000f*\u00020*2\u0012\u0010+\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u000f0\u001aH\u0080\bø\u0001\u0001\u001a$\u0010,\u001a\u00020\u0001*\u00020*2\u0012\u0010+\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u000f0\u001aH\u0080\bø\u0001\u0001\u001aA\u0010-\u001a\u00020.*\u00020/2\u0006\u00100\u001a\u0002012\u0006\u00102\u001a\u00020\u00012\u0006\u00103\u001a\u00020\u00012\u0006\u00104\u001a\u00020\u00012\u0006\u00105\u001a\u00020\u0001H\u0000ø\u0001\u0002ø\u0001\u0000¢\u0006\u0004\b6\u00107\u001aQ\u00108\u001a\u00020.*\u00020/2\u0006\u00100\u001a\u0002012\u0006\u00109\u001a\u00020\u00012\u0006\u0010:\u001a\u00020\u00012\u0006\u00102\u001a\u00020\u00012\u0006\u0010;\u001a\u00020\u00012\u0006\u0010<\u001a\u00020\u00012\u0006\u00104\u001a\u00020\u0001H\u0002ø\u0001\u0002ø\u0001\u0000¢\u0006\u0004\b=\u0010>\u001aQ\u0010?\u001a\u00020.*\u00020/2\u0006\u00100\u001a\u0002012\u0006\u00109\u001a\u00020\u00012\u0006\u0010:\u001a\u00020\u00012\u0006\u00102\u001a\u00020\u00012\u0006\u0010;\u001a\u00020\u00012\u0006\u0010<\u001a\u00020\u00012\u0006\u00104\u001a\u00020\u0001H\u0002ø\u0001\u0002ø\u0001\u0000¢\u0006\u0004\b@\u0010>\u001a*\u0010A\u001a\u00020\u0001*\u00020/2\u0006\u0010B\u001a\u00020\u00012\u0006\u0010\t\u001a\u00020\u0001H\u0080\bø\u0001\u0002ø\u0001\u0000¢\u0006\u0004\bC\u0010D\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\u0082\u0002\u0012\n\u0002\b\u0019\n\u0005\b\u009920\u0001\n\u0005\b¡\u001e0\u0001¨\u0006E"}, d2 = {"HighSurrogateMagic", "", "MaxCodePoint", "MinHighSurrogate", "MinLowSurrogate", "MinSupplementary", "byteCountUtf8", "firstByte", "charactersSize", "v", "codePoint", Constants.HIGH, "", Constants.LOW, "decodeUTF8LineLoopSuspend", "", "out", "Ljava/lang/Appendable;", "Lkotlin/text/Appendable;", "limit", "nextChunk", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "Lio/ktor/utils/io/core/Input;", "", "afterRead", "Lkotlin/Function1;", "", "(Ljava/lang/Appendable;ILkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "highSurrogate", "cp", "isBmpCodePoint", "isValidCodePoint", "lowSurrogate", "malformedByteCount", "", "byteCount", "malformedCodePoint", "value", "prematureEndOfStreamUtf", ContentDisposition.Parameters.Size, "decodeASCII", "Lio/ktor/utils/io/core/Buffer;", "consumer", "decodeUTF8", "encodeUTF8", "Lio/ktor/utils/io/core/internal/EncodeResult;", "Lio/ktor/utils/io/bits/Memory;", "text", "", Constants.MessagePayloadKeys.FROM, "to", "dstOffset", "dstLimit", "encodeUTF8-lBXzO7A", "(Ljava/nio/ByteBuffer;Ljava/lang/CharSequence;IIII)I", "encodeUTF8Stage1", "index1", "lastCharIndex", "resultPosition1", "resultLimit", "encodeUTF8Stage1-Vm9B2pQ", "(Ljava/nio/ByteBuffer;Ljava/lang/CharSequence;IIIIII)I", "encodeUTF8Stage2", "encodeUTF8Stage2-Vm9B2pQ", "putUtf8Char", "offset", "putUtf8Char-62zg_DM", "(Ljava/nio/ByteBuffer;II)I", "ktor-io"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes8.dex */
public final class UTF8Kt {
    private static final int HighSurrogateMagic = 55232;
    private static final int MaxCodePoint = 1114111;
    private static final int MinHighSurrogate = 55296;
    private static final int MinLowSurrogate = 56320;
    private static final int MinSupplementary = 65536;

    public static final int byteCountUtf8(int i) {
        int i2 = 0;
        int i3 = 128;
        for (int i4 = 1; i4 < 7 && (i & i3) != 0; i4++) {
            i &= ~i3;
            i3 >>= 1;
            i2++;
        }
        return i2;
    }

    public static final int codePoint(char c, char c2) {
        return ((c - 55232) << 10) | (c2 - CharCompanionObject.MIN_LOW_SURROGATE);
    }

    public static final int highSurrogate(int i) {
        return (i >>> 10) + 55232;
    }

    public static final boolean isBmpCodePoint(int i) {
        return (i >>> 16) == 0;
    }

    public static final boolean isValidCodePoint(int i) {
        return i <= MaxCodePoint;
    }

    public static final int lowSurrogate(int i) {
        return (i & 1023) + 56320;
    }

    /* JADX WARN: Code restructure failed: missing block: B:137:0x0228, code lost:
    
        r8.element = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:141:0x021f, code lost:
    
        r8.element = true;
        r5.element = 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:147:0x020e, code lost:
    
        r6 = 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:148:0x020f, code lost:
    
        r8.element = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:166:0x027a, code lost:
    
        r6 = 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:167:0x027b, code lost:
    
        r8.element = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:168:0x02bd, code lost:
    
        r0.discardExact(((r21 - r15) - r7.element) + r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:181:0x0290, code lost:
    
        r8.element = r6;
        r6 = r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:183:0x02b5, code lost:
    
        r8.element = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:184:0x0289, code lost:
    
        r5.element = r6 == true ? 1 : 0;
        r6 = r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:198:0x0287, code lost:
    
        r8.element = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:218:0x0161, code lost:
    
        r8.element = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:221:0x0158, code lost:
    
        r8.element = true;
        r5.element = 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:229:0x0141, code lost:
    
        r8.element = true;
        r27 = r13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x03bd, code lost:
    
        if (r6 == 0) goto L190;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x03bf, code lost:
    
        io.ktor.utils.io.core.internal.UnsafeKt.completeReadHead(r2, r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:93:0x01e0, code lost:
    
        r0.discardExact(r21 - r15);
        r2 = r7.element;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:106:0x0345 A[Catch: all -> 0x035f, TryCatch #7 {all -> 0x035f, blocks: (B:219:0x0163, B:95:0x0334, B:108:0x033a, B:97:0x033f, B:100:0x034c, B:106:0x0345, B:91:0x031b, B:221:0x0158, B:209:0x015d, B:218:0x0161, B:211:0x016d, B:213:0x0171, B:215:0x017f, B:216:0x0199, B:235:0x019a, B:236:0x01a6, B:78:0x01aa, B:80:0x01b0, B:83:0x01b8, B:85:0x01bd, B:87:0x01d0, B:93:0x01e0, B:115:0x01e8, B:117:0x01fb, B:119:0x0203, B:148:0x020f, B:138:0x022a, B:145:0x0212, B:131:0x02d6, B:141:0x021f, B:124:0x0224, B:137:0x0228, B:126:0x0235, B:128:0x0239, B:129:0x0241, B:134:0x0248, B:135:0x0262, B:152:0x0263, B:154:0x026b, B:167:0x027b, B:168:0x02bd, B:159:0x027e, B:160:0x02a0, B:183:0x02b5, B:184:0x0289, B:171:0x02b8, B:181:0x0290, B:173:0x02c8, B:175:0x02cc, B:177:0x02d9, B:178:0x02f3, B:198:0x0287, B:188:0x028c, B:190:0x0293, B:192:0x0297, B:194:0x02f4, B:195:0x030e, B:200:0x030f, B:201:0x0319, B:241:0x0327), top: B:107:0x033a }] */
    /* JADX WARN: Removed duplicated region for block: B:107:0x033a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:15:0x03fa  */
    /* JADX WARN: Removed duplicated region for block: B:250:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x040e  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00ac A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00ad  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x03f1  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0026  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0343  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:39:0x00ad -> B:10:0x00b2). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object decodeUTF8LineLoopSuspend(Appendable appendable, int i, Function2<? super Integer, ? super Continuation<? super Input>, ? extends Object> function2, Function1<? super Integer, Unit> function1, Continuation<? super Boolean> continuation) {
        UTF8Kt$decodeUTF8LineLoopSuspend$1 uTF8Kt$decodeUTF8LineLoopSuspend$1;
        int i2;
        Ref.IntRef intRef;
        Ref.IntRef intRef2;
        Ref.BooleanRef booleanRef;
        Ref.BooleanRef booleanRef2;
        Appendable appendable2;
        Function2<? super Integer, ? super Continuation<? super Input>, ? extends Object> function22;
        Function1<? super Integer, Unit> function12;
        UTF8Kt$decodeUTF8LineLoopSuspend$1 uTF8Kt$decodeUTF8LineLoopSuspend$12;
        int i3;
        Object invoke;
        ChunkBuffer chunkBuffer;
        Input input;
        int i4;
        ChunkBuffer chunkBuffer2;
        Input input2;
        Object obj;
        Function2<? super Integer, ? super Continuation<? super Input>, ? extends Object> function23;
        UTF8Kt$decodeUTF8LineLoopSuspend$1 uTF8Kt$decodeUTF8LineLoopSuspend$13;
        long j;
        Function1<? super Integer, Unit> function13;
        int i5;
        int i6;
        boolean z;
        char lowSurrogate;
        int i7;
        ChunkBuffer prepareReadFirstHead;
        int i8;
        if (continuation instanceof UTF8Kt$decodeUTF8LineLoopSuspend$1) {
            uTF8Kt$decodeUTF8LineLoopSuspend$1 = (UTF8Kt$decodeUTF8LineLoopSuspend$1) continuation;
            if ((uTF8Kt$decodeUTF8LineLoopSuspend$1.label & Integer.MIN_VALUE) != 0) {
                uTF8Kt$decodeUTF8LineLoopSuspend$1.label -= Integer.MIN_VALUE;
                Object obj2 = uTF8Kt$decodeUTF8LineLoopSuspend$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i2 = uTF8Kt$decodeUTF8LineLoopSuspend$1.label;
                int i9 = 1;
                if (i2 == 0) {
                    if (i2 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    int i10 = uTF8Kt$decodeUTF8LineLoopSuspend$1.I$0;
                    Ref.BooleanRef booleanRef3 = (Ref.BooleanRef) uTF8Kt$decodeUTF8LineLoopSuspend$1.L$6;
                    Ref.BooleanRef booleanRef4 = (Ref.BooleanRef) uTF8Kt$decodeUTF8LineLoopSuspend$1.L$5;
                    Ref.IntRef intRef3 = (Ref.IntRef) uTF8Kt$decodeUTF8LineLoopSuspend$1.L$4;
                    Ref.IntRef intRef4 = (Ref.IntRef) uTF8Kt$decodeUTF8LineLoopSuspend$1.L$3;
                    Function1<? super Integer, Unit> function14 = (Function1) uTF8Kt$decodeUTF8LineLoopSuspend$1.L$2;
                    Function2<? super Integer, ? super Continuation<? super Input>, ? extends Object> function24 = (Function2) uTF8Kt$decodeUTF8LineLoopSuspend$1.L$1;
                    Appendable appendable3 = (Appendable) uTF8Kt$decodeUTF8LineLoopSuspend$1.L$0;
                    ResultKt.throwOnFailure(obj2);
                    uTF8Kt$decodeUTF8LineLoopSuspend$12 = uTF8Kt$decodeUTF8LineLoopSuspend$1;
                    i3 = i10;
                    function22 = function24;
                    intRef = intRef4;
                    booleanRef = booleanRef4;
                    booleanRef2 = booleanRef3;
                    function12 = function14;
                    intRef2 = intRef3;
                    Input input3 = (Input) obj2;
                    if (input3 != null) {
                        long remaining = input3.getRemaining();
                        ChunkBuffer prepareReadFirstHead2 = UnsafeKt.prepareReadFirstHead(input3, i9);
                        if (prepareReadFirstHead2 == null) {
                            obj = coroutine_suspended;
                            function23 = function22;
                            function13 = function12;
                            uTF8Kt$decodeUTF8LineLoopSuspend$13 = uTF8Kt$decodeUTF8LineLoopSuspend$12;
                            input = input3;
                            j = remaining;
                        } else {
                            ChunkBuffer chunkBuffer3 = prepareReadFirstHead2;
                            int i11 = i9;
                            while (true) {
                                try {
                                    ChunkBuffer chunkBuffer4 = chunkBuffer3;
                                    int writePosition = chunkBuffer4.getWritePosition() - chunkBuffer4.getReadPosition();
                                    if (writePosition >= i11) {
                                        try {
                                            try {
                                                ChunkBuffer chunkBuffer5 = chunkBuffer3;
                                                Ref.IntRef intRef5 = new Ref.IntRef();
                                                obj = coroutine_suspended;
                                                Ref.IntRef intRef6 = new Ref.IntRef();
                                                function23 = function22;
                                                Ref.IntRef intRef7 = new Ref.IntRef();
                                                uTF8Kt$decodeUTF8LineLoopSuspend$13 = uTF8Kt$decodeUTF8LineLoopSuspend$12;
                                                Ref.IntRef intRef8 = new Ref.IntRef();
                                                j = remaining;
                                                ByteBuffer memory = chunkBuffer5.getMemory();
                                                int readPosition = chunkBuffer5.getReadPosition();
                                                int writePosition2 = chunkBuffer5.getWritePosition();
                                                function13 = function12;
                                                int i12 = readPosition;
                                                while (i12 < writePosition2) {
                                                    int i13 = writePosition2;
                                                    byte b = memory.get(i12);
                                                    int i14 = i12;
                                                    int i15 = b & 255;
                                                    ByteBuffer byteBuffer = memory;
                                                    chunkBuffer2 = chunkBuffer3;
                                                    if ((b & 128) == 0) {
                                                        try {
                                                            if (intRef6.element != 0) {
                                                                malformedByteCount(intRef6.element);
                                                                throw new KotlinNothingValueException();
                                                            }
                                                            char c = (char) i15;
                                                            if (c == '\r') {
                                                                try {
                                                                    if (booleanRef.element) {
                                                                        break;
                                                                    }
                                                                    booleanRef.element = true;
                                                                    input2 = input3;
                                                                    i12 = i14 + 1;
                                                                    writePosition2 = i13;
                                                                    memory = byteBuffer;
                                                                    chunkBuffer3 = chunkBuffer2;
                                                                    input3 = input2;
                                                                } catch (Throwable th) {
                                                                    th = th;
                                                                    input2 = input3;
                                                                    ChunkBuffer chunkBuffer6 = chunkBuffer2;
                                                                    chunkBuffer6.getWritePosition();
                                                                    chunkBuffer6.getReadPosition();
                                                                    throw th;
                                                                }
                                                            } else {
                                                                input2 = input3;
                                                                if (c == '\n') {
                                                                    break;
                                                                }
                                                                if (booleanRef.element) {
                                                                    break;
                                                                }
                                                                if (intRef.element == i3) {
                                                                    throw new TooLongLineException("Too many characters in line: limit " + i3 + " exceeded");
                                                                }
                                                                intRef.element++;
                                                                appendable3.append(c);
                                                                i12 = i14 + 1;
                                                                writePosition2 = i13;
                                                                memory = byteBuffer;
                                                                chunkBuffer3 = chunkBuffer2;
                                                                input3 = input2;
                                                                chunkBuffer5.discardExact(i14 - readPosition);
                                                                i5 = -1;
                                                            }
                                                            i4 = 0;
                                                        } catch (Throwable th2) {
                                                            th = th2;
                                                        }
                                                    } else {
                                                        input2 = input3;
                                                        if (intRef6.element == 0) {
                                                            intRef7.element = i15;
                                                            int i16 = 128;
                                                            for (int i17 = 1; i17 < 7 && (intRef7.element & i16) != 0; i17++) {
                                                                intRef7.element &= ~i16;
                                                                i16 >>= 1;
                                                                intRef6.element++;
                                                            }
                                                            intRef8.element = intRef6.element;
                                                            intRef6.element--;
                                                            if (intRef8.element > i13 - i14) {
                                                                break;
                                                            }
                                                        } else {
                                                            intRef7.element = (intRef7.element << 6) | (b & Byte.MAX_VALUE);
                                                            intRef6.element--;
                                                            if (intRef6.element == 0) {
                                                                if (isBmpCodePoint(intRef7.element)) {
                                                                    lowSurrogate = (char) intRef7.element;
                                                                    if (lowSurrogate != '\r') {
                                                                        i7 = 1;
                                                                        if (lowSurrogate == '\n') {
                                                                            break;
                                                                        }
                                                                        if (booleanRef.element) {
                                                                            break;
                                                                        }
                                                                        if (intRef.element == i3) {
                                                                            throw new TooLongLineException("Too many characters in line: limit " + i3 + " exceeded");
                                                                        }
                                                                        intRef.element++;
                                                                        appendable3.append(lowSurrogate);
                                                                        intRef7.element = 0;
                                                                        i12 = i14 + 1;
                                                                        writePosition2 = i13;
                                                                        memory = byteBuffer;
                                                                        chunkBuffer3 = chunkBuffer2;
                                                                        input3 = input2;
                                                                    } else {
                                                                        try {
                                                                            if (booleanRef.element) {
                                                                                break;
                                                                            }
                                                                            booleanRef.element = true;
                                                                            intRef7.element = 0;
                                                                            i12 = i14 + 1;
                                                                            writePosition2 = i13;
                                                                            memory = byteBuffer;
                                                                            chunkBuffer3 = chunkBuffer2;
                                                                            input3 = input2;
                                                                        } catch (Throwable th3) {
                                                                            th = th3;
                                                                            ChunkBuffer chunkBuffer62 = chunkBuffer2;
                                                                            chunkBuffer62.getWritePosition();
                                                                            chunkBuffer62.getReadPosition();
                                                                            throw th;
                                                                        }
                                                                    }
                                                                    chunkBuffer5.discardExact(((i14 - readPosition) - intRef8.element) + i7);
                                                                    i5 = -1;
                                                                    i4 = 0;
                                                                } else {
                                                                    if (!isValidCodePoint(intRef7.element)) {
                                                                        malformedCodePoint(intRef7.element);
                                                                        throw new KotlinNothingValueException();
                                                                    }
                                                                    char highSurrogate = (char) highSurrogate(intRef7.element);
                                                                    if (highSurrogate != '\r') {
                                                                        i6 = 1;
                                                                        z = 1;
                                                                        if (highSurrogate == '\n') {
                                                                            break;
                                                                        }
                                                                        if (booleanRef.element) {
                                                                            break;
                                                                        }
                                                                        if (intRef.element == i3) {
                                                                            throw new TooLongLineException("Too many characters in line: limit " + i3 + " exceeded");
                                                                        }
                                                                        intRef.element++;
                                                                        appendable3.append(highSurrogate);
                                                                    } else {
                                                                        if (booleanRef.element) {
                                                                            break;
                                                                        }
                                                                        booleanRef.element = true;
                                                                    }
                                                                    lowSurrogate = (char) lowSurrogate(intRef7.element);
                                                                    if (lowSurrogate != '\r') {
                                                                        i6 = 1;
                                                                        z = 1;
                                                                        if (lowSurrogate == '\n') {
                                                                            break;
                                                                        }
                                                                        if (booleanRef.element) {
                                                                            break;
                                                                        }
                                                                        if (intRef.element == i3) {
                                                                            throw new TooLongLineException("Too many characters in line: limit " + i3 + " exceeded");
                                                                        }
                                                                        intRef.element++;
                                                                        appendable3.append(lowSurrogate);
                                                                        intRef7.element = 0;
                                                                        i12 = i14 + 1;
                                                                        writePosition2 = i13;
                                                                        memory = byteBuffer;
                                                                        chunkBuffer3 = chunkBuffer2;
                                                                        input3 = input2;
                                                                    } else {
                                                                        if (booleanRef.element) {
                                                                            break;
                                                                        }
                                                                        booleanRef.element = true;
                                                                        intRef7.element = 0;
                                                                        i12 = i14 + 1;
                                                                        writePosition2 = i13;
                                                                        memory = byteBuffer;
                                                                        chunkBuffer3 = chunkBuffer2;
                                                                        input3 = input2;
                                                                    }
                                                                }
                                                            }
                                                        }
                                                        i12 = i14 + 1;
                                                        writePosition2 = i13;
                                                        memory = byteBuffer;
                                                        chunkBuffer3 = chunkBuffer2;
                                                        input3 = input2;
                                                    }
                                                    intRef2.element = i5;
                                                    if (intRef5.element > 0) {
                                                        try {
                                                            chunkBuffer5.discardExact(intRef5.element);
                                                        } catch (Throwable th4) {
                                                            th = th4;
                                                            ChunkBuffer chunkBuffer622 = chunkBuffer2;
                                                            chunkBuffer622.getWritePosition();
                                                            chunkBuffer622.getReadPosition();
                                                            throw th;
                                                        }
                                                    }
                                                    intRef2.element = !booleanRef2.element ? i4 : RangesKt.coerceAtLeast(intRef2.element, 1);
                                                    i11 = intRef2.element;
                                                    ChunkBuffer chunkBuffer7 = chunkBuffer2;
                                                    writePosition = chunkBuffer7.getWritePosition() - chunkBuffer7.getReadPosition();
                                                }
                                                chunkBuffer2 = chunkBuffer3;
                                                input2 = input3;
                                                i4 = 0;
                                                chunkBuffer5.discardExact(writePosition2 - readPosition);
                                                i5 = 0;
                                                intRef2.element = i5;
                                                if (intRef5.element > 0) {
                                                }
                                                ChunkBuffer chunkBuffer72 = chunkBuffer2;
                                                writePosition = chunkBuffer72.getWritePosition() - chunkBuffer72.getReadPosition();
                                            } catch (Throwable th5) {
                                                th = th5;
                                                chunkBuffer = chunkBuffer2;
                                                input = input2;
                                                i4 = 1;
                                                if (i4 != 0) {
                                                    UnsafeKt.completeReadHead(input, chunkBuffer);
                                                }
                                                throw th;
                                            }
                                            intRef2.element = !booleanRef2.element ? i4 : RangesKt.coerceAtLeast(intRef2.element, 1);
                                            i11 = intRef2.element;
                                        } catch (Throwable th6) {
                                            th = th6;
                                            chunkBuffer2 = chunkBuffer3;
                                        }
                                    } else {
                                        obj = coroutine_suspended;
                                        function23 = function22;
                                        chunkBuffer2 = chunkBuffer3;
                                        function13 = function12;
                                        uTF8Kt$decodeUTF8LineLoopSuspend$13 = uTF8Kt$decodeUTF8LineLoopSuspend$12;
                                        input2 = input3;
                                        j = remaining;
                                        i4 = 0;
                                    }
                                    if (writePosition == 0) {
                                        chunkBuffer = chunkBuffer2;
                                        input = input2;
                                        try {
                                            prepareReadFirstHead = UnsafeKt.prepareReadNextHead(input, chunkBuffer);
                                        } catch (Throwable th7) {
                                            th = th7;
                                            if (i4 != 0) {
                                            }
                                            throw th;
                                        }
                                    } else {
                                        chunkBuffer = chunkBuffer2;
                                        input = input2;
                                        if (writePosition >= i11) {
                                            ChunkBuffer chunkBuffer8 = chunkBuffer;
                                            if (chunkBuffer8.getCapacity() - chunkBuffer8.getLimit() >= 8) {
                                                prepareReadFirstHead = chunkBuffer;
                                            }
                                        }
                                        UnsafeKt.completeReadHead(input, chunkBuffer);
                                        prepareReadFirstHead = UnsafeKt.prepareReadFirstHead(input, i11);
                                    }
                                    if (prepareReadFirstHead == null) {
                                        i8 = i4;
                                        break;
                                    }
                                    if (i11 <= 0) {
                                        chunkBuffer = prepareReadFirstHead;
                                        i8 = 1;
                                        break;
                                    }
                                    function22 = function23;
                                    uTF8Kt$decodeUTF8LineLoopSuspend$12 = uTF8Kt$decodeUTF8LineLoopSuspend$13;
                                    remaining = j;
                                    input3 = input;
                                    chunkBuffer3 = prepareReadFirstHead;
                                    coroutine_suspended = obj;
                                    function12 = function13;
                                } catch (Throwable th8) {
                                    th = th8;
                                    chunkBuffer = chunkBuffer3;
                                    input = input3;
                                }
                            }
                        }
                        function12 = function13;
                        function12.invoke(Boxing.boxInt((int) (j - input.getRemaining())));
                        function22 = function23;
                        uTF8Kt$decodeUTF8LineLoopSuspend$12 = uTF8Kt$decodeUTF8LineLoopSuspend$13;
                        appendable2 = appendable3;
                        coroutine_suspended = obj;
                        i9 = 1;
                        if (!booleanRef2.element && intRef2.element != 0) {
                            Integer boxInt = Boxing.boxInt(intRef2.element);
                            uTF8Kt$decodeUTF8LineLoopSuspend$12.L$0 = appendable2;
                            uTF8Kt$decodeUTF8LineLoopSuspend$12.L$1 = function22;
                            uTF8Kt$decodeUTF8LineLoopSuspend$12.L$2 = function12;
                            uTF8Kt$decodeUTF8LineLoopSuspend$12.L$3 = intRef;
                            uTF8Kt$decodeUTF8LineLoopSuspend$12.L$4 = intRef2;
                            uTF8Kt$decodeUTF8LineLoopSuspend$12.L$5 = booleanRef;
                            uTF8Kt$decodeUTF8LineLoopSuspend$12.L$6 = booleanRef2;
                            uTF8Kt$decodeUTF8LineLoopSuspend$12.I$0 = i3;
                            uTF8Kt$decodeUTF8LineLoopSuspend$12.label = i9;
                            invoke = function22.invoke(boxInt, uTF8Kt$decodeUTF8LineLoopSuspend$12);
                            if (invoke != coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            appendable3 = appendable2;
                            obj2 = invoke;
                            Input input32 = (Input) obj2;
                            if (input32 != null) {
                            }
                        }
                    }
                    if (intRef2.element <= 1) {
                        prematureEndOfStreamUtf(intRef2.element);
                        throw new KotlinNothingValueException();
                    }
                    if (booleanRef.element) {
                        booleanRef2.element = true;
                    }
                    return Boxing.boxBoolean(intRef.element > 0 || booleanRef2.element);
                }
                ResultKt.throwOnFailure(obj2);
                Ref.IntRef intRef9 = new Ref.IntRef();
                Ref.IntRef intRef10 = new Ref.IntRef();
                intRef10.element = 1;
                intRef = intRef9;
                intRef2 = intRef10;
                booleanRef = new Ref.BooleanRef();
                booleanRef2 = new Ref.BooleanRef();
                appendable2 = appendable;
                function22 = function2;
                function12 = function1;
                uTF8Kt$decodeUTF8LineLoopSuspend$12 = uTF8Kt$decodeUTF8LineLoopSuspend$1;
                i3 = i;
                if (!booleanRef2.element) {
                    Integer boxInt2 = Boxing.boxInt(intRef2.element);
                    uTF8Kt$decodeUTF8LineLoopSuspend$12.L$0 = appendable2;
                    uTF8Kt$decodeUTF8LineLoopSuspend$12.L$1 = function22;
                    uTF8Kt$decodeUTF8LineLoopSuspend$12.L$2 = function12;
                    uTF8Kt$decodeUTF8LineLoopSuspend$12.L$3 = intRef;
                    uTF8Kt$decodeUTF8LineLoopSuspend$12.L$4 = intRef2;
                    uTF8Kt$decodeUTF8LineLoopSuspend$12.L$5 = booleanRef;
                    uTF8Kt$decodeUTF8LineLoopSuspend$12.L$6 = booleanRef2;
                    uTF8Kt$decodeUTF8LineLoopSuspend$12.I$0 = i3;
                    uTF8Kt$decodeUTF8LineLoopSuspend$12.label = i9;
                    invoke = function22.invoke(boxInt2, uTF8Kt$decodeUTF8LineLoopSuspend$12);
                    if (invoke != coroutine_suspended) {
                    }
                }
                if (intRef2.element <= 1) {
                }
            }
        }
        uTF8Kt$decodeUTF8LineLoopSuspend$1 = new UTF8Kt$decodeUTF8LineLoopSuspend$1(continuation);
        Object obj22 = uTF8Kt$decodeUTF8LineLoopSuspend$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i2 = uTF8Kt$decodeUTF8LineLoopSuspend$1.label;
        int i92 = 1;
        if (i2 == 0) {
        }
    }

    private static final Void prematureEndOfStreamUtf(int i) {
        throw new EOFException("Premature end of stream: expected " + i + " bytes to decode UTF-8 char");
    }

    /* renamed from: encodeUTF8-lBXzO7A, reason: not valid java name */
    public static final int m10228encodeUTF8lBXzO7A(ByteBuffer encodeUTF8, CharSequence text, int i, int i2, int i3, int i4) {
        Intrinsics.checkNotNullParameter(encodeUTF8, "$this$encodeUTF8");
        Intrinsics.checkNotNullParameter(text, "text");
        int min = Math.min(i2, i + 65535);
        int coerceAtMost = RangesKt.coerceAtMost(i4, 65535);
        int i5 = i;
        int i6 = i3;
        while (i6 < coerceAtMost && i5 < min) {
            int i7 = i5 + 1;
            char charAt = text.charAt(i5);
            int i8 = charAt & CharCompanionObject.MAX_VALUE;
            if ((charAt & 65408) != 0) {
                return m10229encodeUTF8Stage1Vm9B2pQ(encodeUTF8, text, i5, min, i, i6, coerceAtMost, i3);
            }
            encodeUTF8.put(i6, (byte) i8);
            i5 = i7;
            i6++;
        }
        return EncodeResult.m10220constructorimpl(UShort.m10522constructorimpl((short) (i5 - i)), UShort.m10522constructorimpl((short) (i6 - i3)));
    }

    /* renamed from: encodeUTF8Stage1-Vm9B2pQ, reason: not valid java name */
    private static final int m10229encodeUTF8Stage1Vm9B2pQ(ByteBuffer byteBuffer, CharSequence charSequence, int i, int i2, int i3, int i4, int i5, int i6) {
        int i7;
        int i8;
        int i9 = i5 - 3;
        while (i9 - i4 > 0 && i < i2) {
            int i10 = i + 1;
            char charAt = charSequence.charAt(i);
            if (!Character.isHighSurrogate(charAt)) {
                i = i10;
                i7 = charAt;
            } else if (i10 == i2 || !Character.isLowSurrogate(charSequence.charAt(i10))) {
                i = i10;
                i7 = 63;
            } else {
                i += 2;
                i7 = codePoint(charAt, charSequence.charAt(i10));
            }
            if (i7 >= 0 && i7 < 128) {
                byteBuffer.put(i4, (byte) i7);
                i8 = 1;
            } else if (128 <= i7 && i7 < 2048) {
                byteBuffer.put(i4, (byte) (((i7 >> 6) & 31) | 192));
                byteBuffer.put(i4 + 1, (byte) (128 | (i7 & 63)));
                i8 = 2;
            } else if (2048 <= i7 && i7 < 65536) {
                byteBuffer.put(i4, (byte) (((i7 >> 12) & 15) | 224));
                byteBuffer.put(i4 + 1, (byte) ((63 & (i7 >> 6)) | 128));
                byteBuffer.put(i4 + 2, (byte) (128 | (i7 & 63)));
                i8 = 3;
            } else {
                if (65536 > i7 || i7 >= 1114112) {
                    malformedCodePoint(i7);
                    throw new KotlinNothingValueException();
                }
                byteBuffer.put(i4, (byte) (((i7 >> 18) & 7) | 240));
                byteBuffer.put(i4 + 1, (byte) (((i7 >> 12) & 63) | 128));
                byteBuffer.put(i4 + 2, (byte) ((63 & (i7 >> 6)) | 128));
                byteBuffer.put(i4 + 3, (byte) (128 | (i7 & 63)));
                i8 = 4;
            }
            i4 += i8;
        }
        if (i4 == i9) {
            return m10230encodeUTF8Stage2Vm9B2pQ(byteBuffer, charSequence, i, i2, i3, i4, i5, i6);
        }
        return EncodeResult.m10220constructorimpl(UShort.m10522constructorimpl((short) (i - i3)), UShort.m10522constructorimpl((short) (i4 - i6)));
    }

    /* JADX WARN: Code restructure failed: missing block: B:38:0x00fd, code lost:
    
        return io.ktor.utils.io.core.internal.EncodeResult.m10220constructorimpl(kotlin.UShort.m10522constructorimpl((short) (r3 - r20)), kotlin.UShort.m10522constructorimpl((short) (r4 - r23)));
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x00e2, code lost:
    
        malformedCodePoint(r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x00ea, code lost:
    
        throw new kotlin.KotlinNothingValueException();
     */
    /* renamed from: encodeUTF8Stage2-Vm9B2pQ, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static final int m10230encodeUTF8Stage2Vm9B2pQ(ByteBuffer byteBuffer, CharSequence charSequence, int i, int i2, int i3, int i4, int i5, int i6) {
        int i7;
        int i8;
        int i9;
        int i10 = i;
        int i11 = i4;
        while (true) {
            int i12 = i5 - i11;
            if (i12 <= 0 || i10 >= i2) {
                break;
            }
            int i13 = i10 + 1;
            char charAt = charSequence.charAt(i10);
            if (!Character.isHighSurrogate(charAt)) {
                i10 = i13;
                i7 = charAt;
            } else if (i13 == i2 || !Character.isLowSurrogate(charSequence.charAt(i13))) {
                i10 = i13;
                i7 = 63;
            } else {
                i10 += 2;
                i7 = codePoint(charAt, charSequence.charAt(i13));
            }
            if (1 <= i7 && i7 < 128) {
                i8 = 1;
            } else if (128 <= i7 && i7 < 2048) {
                i8 = 2;
            } else if (2048 <= i7 && i7 < 65536) {
                i8 = 3;
            } else {
                if (65536 > i7 || i7 >= 1114112) {
                    break;
                }
                i8 = 4;
            }
            if (i8 > i12) {
                i10--;
                break;
            }
            if (i7 >= 0 && i7 < 128) {
                byteBuffer.put(i11, (byte) i7);
                i9 = 1;
            } else if (128 <= i7 && i7 < 2048) {
                byteBuffer.put(i11, (byte) (((i7 >> 6) & 31) | 192));
                byteBuffer.put(i11 + 1, (byte) ((i7 & 63) | 128));
                i9 = 2;
            } else if (2048 <= i7 && i7 < 65536) {
                byteBuffer.put(i11, (byte) (((i7 >> 12) & 15) | 224));
                byteBuffer.put(i11 + 1, (byte) (((i7 >> 6) & 63) | 128));
                byteBuffer.put(i11 + 2, (byte) ((i7 & 63) | 128));
                i9 = 3;
            } else {
                if (65536 > i7 || i7 >= 1114112) {
                    break;
                }
                byteBuffer.put(i11, (byte) (((i7 >> 18) & 7) | 240));
                byteBuffer.put(i11 + 1, (byte) (((i7 >> 12) & 63) | 128));
                byteBuffer.put(i11 + 2, (byte) (((i7 >> 6) & 63) | 128));
                byteBuffer.put(i11 + 3, (byte) ((i7 & 63) | 128));
                i9 = 4;
            }
            i11 += i9;
        }
        malformedCodePoint(i7);
        throw new KotlinNothingValueException();
    }

    private static final int charactersSize(int i) {
        if (1 <= i && i < 128) {
            return 1;
        }
        if (128 <= i && i < 2048) {
            return 2;
        }
        if (2048 <= i && i < 65536) {
            return 3;
        }
        if (65536 <= i && i < 1114112) {
            return 4;
        }
        malformedCodePoint(i);
        throw new KotlinNothingValueException();
    }

    public static final Void malformedByteCount(int i) {
        throw new MalformedUTF8InputException("Expected " + i + " more character bytes");
    }

    public static final Void malformedCodePoint(int i) {
        throw new IllegalArgumentException("Malformed code-point " + i + " found");
    }

    public static final boolean decodeASCII(Buffer buffer, Function1<? super Character, Boolean> consumer) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        Intrinsics.checkNotNullParameter(consumer, "consumer");
        ByteBuffer memory = buffer.getMemory();
        int readPosition = buffer.getReadPosition();
        int writePosition = buffer.getWritePosition();
        for (int i = readPosition; i < writePosition; i++) {
            byte b = memory.get(i);
            int i2 = b & 255;
            if ((b & 128) == 128 || !consumer.invoke(Character.valueOf((char) i2)).booleanValue()) {
                buffer.discardExact(i - readPosition);
                return false;
            }
        }
        buffer.discardExact(writePosition - readPosition);
        return true;
    }

    public static final int decodeUTF8(Buffer buffer, Function1<? super Character, Boolean> consumer) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        Intrinsics.checkNotNullParameter(consumer, "consumer");
        ByteBuffer memory = buffer.getMemory();
        int readPosition = buffer.getReadPosition();
        int writePosition = buffer.getWritePosition();
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        for (int i4 = readPosition; i4 < writePosition; i4++) {
            byte b = memory.get(i4);
            int i5 = b & 255;
            if ((b & 128) != 0) {
                if (i == 0) {
                    int i6 = 128;
                    i2 = i5;
                    for (int i7 = 1; i7 < 7 && (i2 & i6) != 0; i7++) {
                        i2 &= ~i6;
                        i6 >>= 1;
                        i++;
                    }
                    int i8 = i - 1;
                    if (i > writePosition - i4) {
                        buffer.discardExact(i4 - readPosition);
                        return i;
                    }
                    i3 = i;
                    i = i8;
                } else {
                    i2 = (i2 << 6) | (b & Byte.MAX_VALUE);
                    i--;
                    if (i != 0) {
                        continue;
                    } else {
                        if (isBmpCodePoint(i2)) {
                            if (!consumer.invoke(Character.valueOf((char) i2)).booleanValue()) {
                                buffer.discardExact(((i4 - readPosition) - i3) + 1);
                                return -1;
                            }
                        } else {
                            if (!isValidCodePoint(i2)) {
                                malformedCodePoint(i2);
                                throw new KotlinNothingValueException();
                            }
                            if (!consumer.invoke(Character.valueOf((char) highSurrogate(i2))).booleanValue() || !consumer.invoke(Character.valueOf((char) lowSurrogate(i2))).booleanValue()) {
                                buffer.discardExact(((i4 - readPosition) - i3) + 1);
                                return -1;
                            }
                        }
                        i2 = 0;
                    }
                }
            } else {
                if (i != 0) {
                    malformedByteCount(i);
                    throw new KotlinNothingValueException();
                }
                if (!consumer.invoke(Character.valueOf((char) i5)).booleanValue()) {
                    buffer.discardExact(i4 - readPosition);
                    return -1;
                }
            }
        }
        buffer.discardExact(writePosition - readPosition);
        return 0;
    }

    /* renamed from: putUtf8Char-62zg_DM, reason: not valid java name */
    public static final int m10231putUtf8Char62zg_DM(ByteBuffer putUtf8Char, int i, int i2) {
        Intrinsics.checkNotNullParameter(putUtf8Char, "$this$putUtf8Char");
        if (i2 >= 0 && i2 < 128) {
            putUtf8Char.put(i, (byte) i2);
            return 1;
        }
        if (128 <= i2 && i2 < 2048) {
            putUtf8Char.put(i, (byte) (((i2 >> 6) & 31) | 192));
            putUtf8Char.put(i + 1, (byte) ((i2 & 63) | 128));
            return 2;
        }
        if (2048 <= i2 && i2 < 65536) {
            putUtf8Char.put(i, (byte) (((i2 >> 12) & 15) | 224));
            putUtf8Char.put(i + 1, (byte) (((i2 >> 6) & 63) | 128));
            putUtf8Char.put(i + 2, (byte) ((i2 & 63) | 128));
            return 3;
        }
        if (65536 > i2 || i2 >= 1114112) {
            malformedCodePoint(i2);
            throw new KotlinNothingValueException();
        }
        putUtf8Char.put(i, (byte) (((i2 >> 18) & 7) | 240));
        putUtf8Char.put(i + 1, (byte) (((i2 >> 12) & 63) | 128));
        putUtf8Char.put(i + 2, (byte) (((i2 >> 6) & 63) | 128));
        putUtf8Char.put(i + 3, (byte) ((i2 & 63) | 128));
        return 4;
    }
}
