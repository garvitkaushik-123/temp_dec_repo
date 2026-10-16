package io.ktor.client.request.forms;

import io.ktor.utils.io.ByteWriteChannel;
import io.ktor.utils.io.WriterSessionKt;
import io.ktor.utils.io.charsets.CharsetJVMKt;
import io.ktor.utils.io.core.Buffer;
import io.ktor.utils.io.core.ByteReadPacket;
import io.ktor.utils.io.core.Input;
import io.ktor.utils.io.core.InputArraysKt;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import kotlin.text.CharsKt;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;

/* compiled from: FormDataContent.kt */
@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\b\u0010\u0002\u001a\u00020\u0003H\u0002\u001a\u001d\u0010\u0004\u001a\u00020\u0005*\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0082@ø\u0001\u0000¢\u0006\u0002\u0010\t\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\n"}, d2 = {"RN_BYTES", "", "generateBoundary", "", "copyTo", "", "Lio/ktor/utils/io/core/Input;", "channel", "Lio/ktor/utils/io/ByteWriteChannel;", "(Lio/ktor/utils/io/core/Input;Lio/ktor/utils/io/ByteWriteChannel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ktor-client-core"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes8.dex */
public final class FormDataContentKt {
    private static final byte[] RN_BYTES;

    /* JADX INFO: Access modifiers changed from: private */
    public static final String generateBoundary() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 32; i++) {
            String num = Integer.toString(Random.INSTANCE.nextInt(), CharsKt.checkRadix(16));
            Intrinsics.checkNotNullExpressionValue(num, "toString(this, checkRadix(radix))");
            sb.append(num);
        }
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder().apply(builderAction).toString()");
        return StringsKt.take(sb2, 70);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Can't wrap try/catch for region: R(14:0|1|(2:3|(11:5|6|(1:(1:(1:(1:(2:12|13)(2:15|16))(3:17|18|(3:20|(1:22)|37)(2:38|39)))(1:40))(3:41|42|43))(2:44|(1:46)(3:48|18|(0)(0)))|23|(1:25)|26|27|28|29|(3:31|18|(0)(0))|37))|49|6|(0)(0)|23|(0)|26|27|28|29|(0)|37) */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x00d8, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x00d9, code lost:
    
        r2.L$0 = r0;
        r2.L$1 = null;
        r2.L$2 = null;
        r2.label = 4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x00e6, code lost:
    
        if (io.ktor.utils.io.WriterSessionKt.completeWriting(r1, r4, r15, r2) == r3) goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:?, code lost:
    
        throw r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x0081, code lost:
    
        if (r18.writePacket((io.ktor.utils.io.core.ByteReadPacket) r0, r2) == r3) goto L46;
     */
    /* JADX WARN: Removed duplicated region for block: B:20:0x008f  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00d5  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00ea  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002b  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:31:0x00d5 -> B:18:0x0089). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object copyTo(Input input, ByteWriteChannel byteWriteChannel, Continuation<? super Unit> continuation) {
        FormDataContentKt$copyTo$1 formDataContentKt$copyTo$1;
        Object coroutine_suspended;
        int i;
        ByteWriteChannel byteWriteChannel2;
        Input input2;
        Object obj;
        ByteWriteChannel byteWriteChannel3;
        Buffer buffer;
        int i2;
        Input input3 = input;
        if (continuation instanceof FormDataContentKt$copyTo$1) {
            formDataContentKt$copyTo$1 = (FormDataContentKt$copyTo$1) continuation;
            if ((formDataContentKt$copyTo$1.label & Integer.MIN_VALUE) != 0) {
                formDataContentKt$copyTo$1.label -= Integer.MIN_VALUE;
                Object obj2 = formDataContentKt$copyTo$1.result;
                coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = formDataContentKt$copyTo$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj2);
                    if (input3 instanceof ByteReadPacket) {
                        formDataContentKt$copyTo$1.label = 1;
                    } else {
                        byteWriteChannel2 = byteWriteChannel;
                        if (input3.getEndOfInput()) {
                        }
                    }
                } else {
                    if (i == 1) {
                        ResultKt.throwOnFailure(obj2);
                        return Unit.INSTANCE;
                    }
                    if (i != 2) {
                        if (i != 3) {
                            if (i != 4) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            Throwable th = (Throwable) formDataContentKt$copyTo$1.L$0;
                            ResultKt.throwOnFailure(obj2);
                            throw th;
                        }
                        ByteWriteChannel byteWriteChannel4 = (ByteWriteChannel) formDataContentKt$copyTo$1.L$1;
                        Input input4 = (Input) formDataContentKt$copyTo$1.L$0;
                        ResultKt.throwOnFailure(obj2);
                        byteWriteChannel2 = byteWriteChannel4;
                        input3 = input4;
                        if (input3.getEndOfInput()) {
                            return Unit.INSTANCE;
                        }
                        formDataContentKt$copyTo$1.L$0 = input3;
                        formDataContentKt$copyTo$1.L$1 = byteWriteChannel2;
                        formDataContentKt$copyTo$1.L$2 = byteWriteChannel2;
                        formDataContentKt$copyTo$1.label = 2;
                        obj = WriterSessionKt.requestWriteBuffer(byteWriteChannel2, 1, formDataContentKt$copyTo$1);
                        if (obj != coroutine_suspended) {
                            input2 = input3;
                            byteWriteChannel3 = byteWriteChannel2;
                        }
                        return coroutine_suspended;
                    }
                    ByteWriteChannel byteWriteChannel5 = (ByteWriteChannel) formDataContentKt$copyTo$1.L$2;
                    ByteWriteChannel byteWriteChannel6 = (ByteWriteChannel) formDataContentKt$copyTo$1.L$1;
                    input2 = (Input) formDataContentKt$copyTo$1.L$0;
                    ResultKt.throwOnFailure(obj2);
                    byteWriteChannel2 = byteWriteChannel5;
                    byteWriteChannel3 = byteWriteChannel6;
                    obj = obj2;
                }
                buffer = (Buffer) obj;
                if (buffer == null) {
                    buffer = Buffer.INSTANCE.getEmpty();
                }
                i2 = 0;
                ByteBuffer memory = buffer.getMemory();
                long writePosition = buffer.getWritePosition();
                i2 = (int) InputArraysKt.m10153readAvailableUAd2zVI(input2, memory, writePosition, buffer.getLimit() - writePosition);
                buffer.commitWritten(i2);
                Integer boxInt = Boxing.boxInt(i2);
                formDataContentKt$copyTo$1.L$0 = input2;
                formDataContentKt$copyTo$1.L$1 = byteWriteChannel3;
                formDataContentKt$copyTo$1.L$2 = boxInt;
                formDataContentKt$copyTo$1.label = 3;
                if (WriterSessionKt.completeWriting(byteWriteChannel2, buffer, i2, formDataContentKt$copyTo$1) != coroutine_suspended) {
                    byteWriteChannel2 = byteWriteChannel3;
                    input3 = input2;
                    if (input3.getEndOfInput()) {
                    }
                }
                return coroutine_suspended;
            }
        }
        formDataContentKt$copyTo$1 = new FormDataContentKt$copyTo$1(continuation);
        Object obj22 = formDataContentKt$copyTo$1.result;
        coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = formDataContentKt$copyTo$1.label;
        if (i != 0) {
        }
        buffer = (Buffer) obj;
        if (buffer == null) {
        }
        i2 = 0;
        ByteBuffer memory2 = buffer.getMemory();
        long writePosition2 = buffer.getWritePosition();
        i2 = (int) InputArraysKt.m10153readAvailableUAd2zVI(input2, memory2, writePosition2, buffer.getLimit() - writePosition2);
        buffer.commitWritten(i2);
        Integer boxInt2 = Boxing.boxInt(i2);
        formDataContentKt$copyTo$1.L$0 = input2;
        formDataContentKt$copyTo$1.L$1 = byteWriteChannel3;
        formDataContentKt$copyTo$1.L$2 = boxInt2;
        formDataContentKt$copyTo$1.label = 3;
        if (WriterSessionKt.completeWriting(byteWriteChannel2, buffer, i2, formDataContentKt$copyTo$1) != coroutine_suspended) {
        }
        return coroutine_suspended;
    }

    static {
        byte[] encodeToByteArray;
        Charset charset = Charsets.UTF_8;
        if (Intrinsics.areEqual(charset, Charsets.UTF_8)) {
            encodeToByteArray = StringsKt.encodeToByteArray("\r\n");
        } else {
            CharsetEncoder newEncoder = charset.newEncoder();
            Intrinsics.checkNotNullExpressionValue(newEncoder, "charset.newEncoder()");
            encodeToByteArray = CharsetJVMKt.encodeToByteArray(newEncoder, "\r\n", 0, "\r\n".length());
        }
        RN_BYTES = encodeToByteArray;
    }
}
