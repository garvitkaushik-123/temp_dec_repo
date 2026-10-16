package io.ktor.client.request.forms;

import io.ktor.client.request.forms.PreparedPart;
import io.ktor.http.ContentType;
import io.ktor.http.HttpHeaders;
import io.ktor.http.content.OutgoingContent;
import io.ktor.http.content.PartData;
import io.ktor.utils.io.ByteReadChannel;
import io.ktor.utils.io.ByteReadChannelKt;
import io.ktor.utils.io.ByteWriteChannel;
import io.ktor.utils.io.ByteWriteChannelKt;
import io.ktor.utils.io.charsets.CharsetJVMKt;
import io.ktor.utils.io.core.BytePacketBuilder;
import io.ktor.utils.io.core.ByteReadPacket;
import io.ktor.utils.io.core.Input;
import io.ktor.utils.io.core.Output;
import io.ktor.utils.io.core.OutputKt;
import java.io.Closeable;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;

/* compiled from: FormDataContent.kt */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B'\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u0019\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH\u0096@ø\u0001\u0000¢\u0006\u0002\u0010 R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R$\u0010\u0014\u001a\u0004\u0018\u00010\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013@RX\u0096\u000e¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0007\u001a\u00020\bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001b0\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006!"}, d2 = {"Lio/ktor/client/request/forms/MultiPartFormDataContent;", "Lio/ktor/http/content/OutgoingContent$WriteChannelContent;", "parts", "", "Lio/ktor/http/content/PartData;", "boundary", "", "contentType", "Lio/ktor/http/ContentType;", "(Ljava/util/List;Ljava/lang/String;Lio/ktor/http/ContentType;)V", "BODY_OVERHEAD_SIZE", "", "BOUNDARY_BYTES", "", "LAST_BOUNDARY_BYTES", "PART_OVERHEAD_SIZE", "getBoundary", "()Ljava/lang/String;", "<set-?>", "", "contentLength", "getContentLength", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getContentType", "()Lio/ktor/http/ContentType;", "rawParts", "Lio/ktor/client/request/forms/PreparedPart;", "writeTo", "", "channel", "Lio/ktor/utils/io/ByteWriteChannel;", "(Lio/ktor/utils/io/ByteWriteChannel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ktor-client-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes8.dex */
public final class MultiPartFormDataContent extends OutgoingContent.WriteChannelContent {
    private final int BODY_OVERHEAD_SIZE;
    private final byte[] BOUNDARY_BYTES;
    private final byte[] LAST_BOUNDARY_BYTES;
    private final int PART_OVERHEAD_SIZE;
    private final String boundary;
    private Long contentLength;
    private final ContentType contentType;
    private final List<PreparedPart> rawParts;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ MultiPartFormDataContent(List list, String str, ContentType contentType, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(list, str, (i & 4) != 0 ? ContentType.MultiPart.INSTANCE.getFormData().withParameter("boundary", str) : contentType);
        str = (i & 2) != 0 ? FormDataContentKt.generateBoundary() : str;
    }

    public final String getBoundary() {
        return this.boundary;
    }

    @Override // io.ktor.http.content.OutgoingContent
    public ContentType getContentType() {
        return this.contentType;
    }

    public MultiPartFormDataContent(List<? extends PartData> parts, String boundary, ContentType contentType) {
        byte[] encodeToByteArray;
        byte[] encodeToByteArray2;
        byte[] bArr;
        PreparedPart channelPart;
        byte[] bArr2;
        byte[] bArr3;
        Intrinsics.checkNotNullParameter(parts, "parts");
        Intrinsics.checkNotNullParameter(boundary, "boundary");
        Intrinsics.checkNotNullParameter(contentType, "contentType");
        this.boundary = boundary;
        this.contentType = contentType;
        String str = "--" + boundary + "\r\n";
        Charset charset = Charsets.UTF_8;
        if (Intrinsics.areEqual(charset, Charsets.UTF_8)) {
            encodeToByteArray = StringsKt.encodeToByteArray(str);
        } else {
            CharsetEncoder newEncoder = charset.newEncoder();
            Intrinsics.checkNotNullExpressionValue(newEncoder, "charset.newEncoder()");
            encodeToByteArray = CharsetJVMKt.encodeToByteArray(newEncoder, str, 0, str.length());
        }
        this.BOUNDARY_BYTES = encodeToByteArray;
        String str2 = "--" + boundary + "--\r\n";
        Charset charset2 = Charsets.UTF_8;
        if (Intrinsics.areEqual(charset2, Charsets.UTF_8)) {
            encodeToByteArray2 = StringsKt.encodeToByteArray(str2);
        } else {
            CharsetEncoder newEncoder2 = charset2.newEncoder();
            Intrinsics.checkNotNullExpressionValue(newEncoder2, "charset.newEncoder()");
            encodeToByteArray2 = CharsetJVMKt.encodeToByteArray(newEncoder2, str2, 0, str2.length());
        }
        this.LAST_BOUNDARY_BYTES = encodeToByteArray2;
        this.BODY_OVERHEAD_SIZE = encodeToByteArray2.length;
        bArr = FormDataContentKt.RN_BYTES;
        this.PART_OVERHEAD_SIZE = (bArr.length * 2) + encodeToByteArray.length;
        List<? extends PartData> list = parts;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        while (true) {
            if (it.hasNext()) {
                PartData partData = (PartData) it.next();
                BytePacketBuilder bytePacketBuilder = new BytePacketBuilder(null, 1, null);
                for (Map.Entry<String, List<String>> entry : partData.getHeaders().entries()) {
                    BytePacketBuilder bytePacketBuilder2 = bytePacketBuilder;
                    io.ktor.utils.io.core.StringsKt.writeText$default(bytePacketBuilder2, entry.getKey() + ": " + CollectionsKt.joinToString$default(entry.getValue(), "; ", null, null, 0, null, null, 62, null), 0, 0, (Charset) null, 14, (Object) null);
                    bArr3 = FormDataContentKt.RN_BYTES;
                    OutputKt.writeFully$default((Output) bytePacketBuilder2, bArr3, 0, 0, 6, (Object) null);
                }
                String str3 = partData.getHeaders().get(HttpHeaders.INSTANCE.getContentLength());
                Long valueOf = str3 != null ? Long.valueOf(Long.parseLong(str3)) : null;
                if (partData instanceof PartData.FileItem) {
                    channelPart = new PreparedPart.InputPart(io.ktor.utils.io.core.StringsKt.readBytes$default(bytePacketBuilder.build(), 0, 1, null), ((PartData.FileItem) partData).getProvider(), valueOf != null ? Long.valueOf(valueOf.longValue() + this.PART_OVERHEAD_SIZE + r5.length) : null);
                } else if (partData instanceof PartData.BinaryItem) {
                    channelPart = new PreparedPart.InputPart(io.ktor.utils.io.core.StringsKt.readBytes$default(bytePacketBuilder.build(), 0, 1, null), ((PartData.BinaryItem) partData).getProvider(), valueOf != null ? Long.valueOf(valueOf.longValue() + this.PART_OVERHEAD_SIZE + r5.length) : null);
                } else if (!(partData instanceof PartData.FormItem)) {
                    if (partData instanceof PartData.BinaryChannelItem) {
                        channelPart = new PreparedPart.ChannelPart(io.ktor.utils.io.core.StringsKt.readBytes$default(bytePacketBuilder.build(), 0, 1, null), ((PartData.BinaryChannelItem) partData).getProvider(), valueOf != null ? Long.valueOf(valueOf.longValue() + this.PART_OVERHEAD_SIZE + r5.length) : null);
                    } else {
                        throw new NoWhenBranchMatchedException();
                    }
                } else {
                    BytePacketBuilder bytePacketBuilder3 = new BytePacketBuilder(null, 1, null);
                    try {
                        io.ktor.utils.io.core.StringsKt.writeText$default(bytePacketBuilder3, ((PartData.FormItem) partData).getValue(), 0, 0, (Charset) null, 14, (Object) null);
                        final byte[] readBytes$default = io.ktor.utils.io.core.StringsKt.readBytes$default(bytePacketBuilder3.build(), 0, 1, null);
                        Function0<ByteReadPacket> function0 = new Function0<ByteReadPacket>() { // from class: io.ktor.client.request.forms.MultiPartFormDataContent$rawParts$1$provider$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(0);
                            }

                            /* JADX WARN: Can't rename method to resolve collision */
                            @Override // kotlin.jvm.functions.Function0
                            public final ByteReadPacket invoke() {
                                byte[] bArr4 = readBytes$default;
                                BytePacketBuilder bytePacketBuilder4 = new BytePacketBuilder(null, 1, null);
                                try {
                                    OutputKt.writeFully$default((Output) bytePacketBuilder4, bArr4, 0, 0, 6, (Object) null);
                                    return bytePacketBuilder4.build();
                                } catch (Throwable th) {
                                    bytePacketBuilder4.release();
                                    throw th;
                                }
                            }
                        };
                        if (valueOf == null) {
                            BytePacketBuilder bytePacketBuilder4 = bytePacketBuilder;
                            io.ktor.utils.io.core.StringsKt.writeText$default(bytePacketBuilder4, HttpHeaders.INSTANCE.getContentLength() + ": " + readBytes$default.length, 0, 0, (Charset) null, 14, (Object) null);
                            bArr2 = FormDataContentKt.RN_BYTES;
                            OutputKt.writeFully$default((Output) bytePacketBuilder4, bArr2, 0, 0, 6, (Object) null);
                        }
                        channelPart = new PreparedPart.InputPart(io.ktor.utils.io.core.StringsKt.readBytes$default(bytePacketBuilder.build(), 0, 1, null), function0, Long.valueOf(readBytes$default.length + this.PART_OVERHEAD_SIZE + r4.length));
                    } catch (Throwable th) {
                        bytePacketBuilder3.release();
                        throw th;
                    }
                }
                arrayList.add(channelPart);
            } else {
                ArrayList arrayList2 = arrayList;
                this.rawParts = arrayList2;
                Long l = 0L;
                Iterator it2 = arrayList2.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        r4 = l;
                        break;
                    }
                    Long size = ((PreparedPart) it2.next()).getSize();
                    if (size == null) {
                        break;
                    } else {
                        l = l != null ? Long.valueOf(l.longValue() + size.longValue()) : null;
                    }
                }
                this.contentLength = r4 != null ? Long.valueOf(r4.longValue() + this.BODY_OVERHEAD_SIZE) : r4;
                return;
            }
        }
    }

    @Override // io.ktor.http.content.OutgoingContent
    public Long getContentLength() {
        return this.contentLength;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(8:0|1|(2:3|(4:5|6|7|8))|93|6|7|8|(2:(0)|(1:52))) */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x01ab, code lost:
    
        if (io.ktor.utils.io.ByteWriteChannelKt.writeFully(r9, r10, r0) == r1) goto L85;
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x01b2, code lost:
    
        r10 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x01b3, code lost:
    
        r9.close(r10);
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x01ba, code lost:
    
        r10 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x01bb, code lost:
    
        io.ktor.utils.io.ByteWriteChannelKt.close(r9);
     */
    /* JADX WARN: Code restructure failed: missing block: B:88:0x01be, code lost:
    
        throw r10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:89:0x005b, code lost:
    
        r10 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x005c, code lost:
    
        r9 = r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:91:0x00bc, code lost:
    
        r10 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:92:0x00bd, code lost:
    
        r9 = r4;
     */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002d  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00d0 A[Catch: all -> 0x01b2, TryCatch #1 {all -> 0x01b2, blocks: (B:13:0x0031, B:21:0x00ca, B:23:0x00d0, B:28:0x00ed, B:31:0x0104, B:43:0x0183, B:65:0x019c, B:81:0x00c3), top: B:7:0x0022 }] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0102  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x011b  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0122 A[Catch: all -> 0x00bc, TRY_LEAVE, TryCatch #6 {all -> 0x00bc, blocks: (B:34:0x011e, B:36:0x0122, B:41:0x0149, B:59:0x0158, B:61:0x015c, B:57:0x0157, B:73:0x0089, B:75:0x009e, B:78:0x00b5, B:51:0x0155, B:55:0x0152, B:50:0x014d, B:37:0x012e, B:40:0x0147, B:71:0x0071), top: B:7:0x0022, inners: #2, #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0198  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0199  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0158 A[Catch: all -> 0x00bc, TryCatch #6 {all -> 0x00bc, blocks: (B:34:0x011e, B:36:0x0122, B:41:0x0149, B:59:0x0158, B:61:0x015c, B:57:0x0157, B:73:0x0089, B:75:0x009e, B:78:0x00b5, B:51:0x0155, B:55:0x0152, B:50:0x014d, B:37:0x012e, B:40:0x0147, B:71:0x0071), top: B:7:0x0022, inners: #2, #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:65:0x019c A[Catch: all -> 0x01b2, TRY_LEAVE, TryCatch #1 {all -> 0x01b2, blocks: (B:13:0x0031, B:21:0x00ca, B:23:0x00d0, B:28:0x00ed, B:31:0x0104, B:43:0x0183, B:65:0x019c, B:81:0x00c3), top: B:7:0x0022 }] */
    /* JADX WARN: Removed duplicated region for block: B:67:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x008e  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0025  */
    /* JADX WARN: Type inference failed for: r2v0, types: [int] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:46:0x0199 -> B:20:0x0047). Please report as a decompilation issue!!! */
    @Override // io.ktor.http.content.OutgoingContent.WriteChannelContent
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object writeTo(ByteWriteChannel byteWriteChannel, Continuation<? super Unit> continuation) {
        MultiPartFormDataContent$writeTo$1 multiPartFormDataContent$writeTo$1;
        ?? r2;
        ByteWriteChannel byteWriteChannel2;
        Iterator<PreparedPart> it;
        MultiPartFormDataContent multiPartFormDataContent;
        Iterator<PreparedPart> it2;
        MultiPartFormDataContent multiPartFormDataContent2;
        PreparedPart preparedPart;
        PreparedPart preparedPart2;
        Input input;
        Iterator<PreparedPart> it3;
        ByteWriteChannel byteWriteChannel3;
        MultiPartFormDataContent multiPartFormDataContent3;
        byte[] bArr;
        Object copyTo;
        byte[] bArr2;
        byte[] headers;
        if (continuation instanceof MultiPartFormDataContent$writeTo$1) {
            multiPartFormDataContent$writeTo$1 = (MultiPartFormDataContent$writeTo$1) continuation;
            if ((multiPartFormDataContent$writeTo$1.label & Integer.MIN_VALUE) != 0) {
                multiPartFormDataContent$writeTo$1.label -= Integer.MIN_VALUE;
                Object obj = multiPartFormDataContent$writeTo$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                r2 = multiPartFormDataContent$writeTo$1.label;
                switch (r2) {
                    case 0:
                        ResultKt.throwOnFailure(obj);
                        it = this.rawParts.iterator();
                        multiPartFormDataContent = this;
                        if (it.hasNext()) {
                            preparedPart = it.next();
                            byte[] bArr3 = multiPartFormDataContent.BOUNDARY_BYTES;
                            multiPartFormDataContent$writeTo$1.L$0 = multiPartFormDataContent;
                            multiPartFormDataContent$writeTo$1.L$1 = byteWriteChannel;
                            multiPartFormDataContent$writeTo$1.L$2 = it;
                            multiPartFormDataContent$writeTo$1.L$3 = preparedPart;
                            multiPartFormDataContent$writeTo$1.label = 1;
                            if (ByteWriteChannelKt.writeFully(byteWriteChannel, bArr3, multiPartFormDataContent$writeTo$1) != coroutine_suspended) {
                                multiPartFormDataContent2 = multiPartFormDataContent;
                                it2 = it;
                                headers = preparedPart.getHeaders();
                                multiPartFormDataContent$writeTo$1.L$0 = multiPartFormDataContent2;
                                multiPartFormDataContent$writeTo$1.L$1 = byteWriteChannel;
                                multiPartFormDataContent$writeTo$1.L$2 = it2;
                                multiPartFormDataContent$writeTo$1.L$3 = preparedPart;
                                multiPartFormDataContent$writeTo$1.label = 2;
                                if (ByteWriteChannelKt.writeFully(byteWriteChannel, headers, multiPartFormDataContent$writeTo$1) == coroutine_suspended) {
                                }
                                bArr2 = FormDataContentKt.RN_BYTES;
                                multiPartFormDataContent$writeTo$1.L$0 = multiPartFormDataContent2;
                                multiPartFormDataContent$writeTo$1.L$1 = byteWriteChannel;
                                multiPartFormDataContent$writeTo$1.L$2 = it2;
                                multiPartFormDataContent$writeTo$1.L$3 = preparedPart;
                                multiPartFormDataContent$writeTo$1.label = 3;
                                if (ByteWriteChannelKt.writeFully(byteWriteChannel, bArr2, multiPartFormDataContent$writeTo$1) != coroutine_suspended) {
                                    PreparedPart preparedPart3 = preparedPart;
                                    byteWriteChannel2 = byteWriteChannel;
                                    preparedPart2 = preparedPart3;
                                    if (preparedPart2 instanceof PreparedPart.InputPart) {
                                        input = ((PreparedPart.InputPart) preparedPart2).getProvider().invoke();
                                        multiPartFormDataContent$writeTo$1.L$0 = multiPartFormDataContent2;
                                        multiPartFormDataContent$writeTo$1.L$1 = byteWriteChannel2;
                                        multiPartFormDataContent$writeTo$1.L$2 = it2;
                                        multiPartFormDataContent$writeTo$1.L$3 = input;
                                        multiPartFormDataContent$writeTo$1.I$0 = 0;
                                        multiPartFormDataContent$writeTo$1.label = 4;
                                        copyTo = FormDataContentKt.copyTo(input, byteWriteChannel2, multiPartFormDataContent$writeTo$1);
                                        if (copyTo == coroutine_suspended) {
                                        }
                                        Unit unit = Unit.INSTANCE;
                                        input.close();
                                        byteWriteChannel = byteWriteChannel2;
                                        multiPartFormDataContent3 = multiPartFormDataContent2;
                                        bArr = FormDataContentKt.RN_BYTES;
                                        multiPartFormDataContent$writeTo$1.L$0 = multiPartFormDataContent3;
                                        multiPartFormDataContent$writeTo$1.L$1 = byteWriteChannel;
                                        multiPartFormDataContent$writeTo$1.L$2 = it2;
                                        multiPartFormDataContent$writeTo$1.L$3 = null;
                                        multiPartFormDataContent$writeTo$1.label = 6;
                                        if (ByteWriteChannelKt.writeFully(byteWriteChannel, bArr, multiPartFormDataContent$writeTo$1) != coroutine_suspended) {
                                        }
                                    } else {
                                        if (preparedPart2 instanceof PreparedPart.ChannelPart) {
                                            ByteReadChannel invoke = ((PreparedPart.ChannelPart) preparedPart2).getProvider().invoke();
                                            multiPartFormDataContent$writeTo$1.L$0 = multiPartFormDataContent2;
                                            multiPartFormDataContent$writeTo$1.L$1 = byteWriteChannel2;
                                            multiPartFormDataContent$writeTo$1.L$2 = it2;
                                            multiPartFormDataContent$writeTo$1.L$3 = null;
                                            multiPartFormDataContent$writeTo$1.label = 5;
                                            if (ByteReadChannelKt.copyTo(invoke, byteWriteChannel2, multiPartFormDataContent$writeTo$1) != coroutine_suspended) {
                                                it3 = it2;
                                                byteWriteChannel3 = byteWriteChannel2;
                                                multiPartFormDataContent3 = multiPartFormDataContent2;
                                                ByteWriteChannel byteWriteChannel4 = byteWriteChannel3;
                                                it2 = it3;
                                                byteWriteChannel = byteWriteChannel4;
                                                bArr = FormDataContentKt.RN_BYTES;
                                                multiPartFormDataContent$writeTo$1.L$0 = multiPartFormDataContent3;
                                                multiPartFormDataContent$writeTo$1.L$1 = byteWriteChannel;
                                                multiPartFormDataContent$writeTo$1.L$2 = it2;
                                                multiPartFormDataContent$writeTo$1.L$3 = null;
                                                multiPartFormDataContent$writeTo$1.label = 6;
                                                if (ByteWriteChannelKt.writeFully(byteWriteChannel, bArr, multiPartFormDataContent$writeTo$1) != coroutine_suspended) {
                                                    it = it2;
                                                    multiPartFormDataContent = multiPartFormDataContent3;
                                                    if (it.hasNext()) {
                                                        byte[] bArr4 = multiPartFormDataContent.LAST_BOUNDARY_BYTES;
                                                        multiPartFormDataContent$writeTo$1.L$0 = byteWriteChannel;
                                                        multiPartFormDataContent$writeTo$1.L$1 = null;
                                                        multiPartFormDataContent$writeTo$1.L$2 = null;
                                                        multiPartFormDataContent$writeTo$1.label = 7;
                                                        break;
                                                    }
                                                }
                                            }
                                        }
                                        byteWriteChannel = byteWriteChannel2;
                                        multiPartFormDataContent3 = multiPartFormDataContent2;
                                        bArr = FormDataContentKt.RN_BYTES;
                                        multiPartFormDataContent$writeTo$1.L$0 = multiPartFormDataContent3;
                                        multiPartFormDataContent$writeTo$1.L$1 = byteWriteChannel;
                                        multiPartFormDataContent$writeTo$1.L$2 = it2;
                                        multiPartFormDataContent$writeTo$1.L$3 = null;
                                        multiPartFormDataContent$writeTo$1.label = 6;
                                        if (ByteWriteChannelKt.writeFully(byteWriteChannel, bArr, multiPartFormDataContent$writeTo$1) != coroutine_suspended) {
                                        }
                                    }
                                }
                            }
                        }
                        return coroutine_suspended;
                    case 1:
                        PreparedPart preparedPart4 = (PreparedPart) multiPartFormDataContent$writeTo$1.L$3;
                        it2 = (Iterator) multiPartFormDataContent$writeTo$1.L$2;
                        ByteWriteChannel byteWriteChannel5 = (ByteWriteChannel) multiPartFormDataContent$writeTo$1.L$1;
                        multiPartFormDataContent2 = (MultiPartFormDataContent) multiPartFormDataContent$writeTo$1.L$0;
                        ResultKt.throwOnFailure(obj);
                        preparedPart = preparedPart4;
                        byteWriteChannel = byteWriteChannel5;
                        headers = preparedPart.getHeaders();
                        multiPartFormDataContent$writeTo$1.L$0 = multiPartFormDataContent2;
                        multiPartFormDataContent$writeTo$1.L$1 = byteWriteChannel;
                        multiPartFormDataContent$writeTo$1.L$2 = it2;
                        multiPartFormDataContent$writeTo$1.L$3 = preparedPart;
                        multiPartFormDataContent$writeTo$1.label = 2;
                        if (ByteWriteChannelKt.writeFully(byteWriteChannel, headers, multiPartFormDataContent$writeTo$1) == coroutine_suspended) {
                        }
                        bArr2 = FormDataContentKt.RN_BYTES;
                        multiPartFormDataContent$writeTo$1.L$0 = multiPartFormDataContent2;
                        multiPartFormDataContent$writeTo$1.L$1 = byteWriteChannel;
                        multiPartFormDataContent$writeTo$1.L$2 = it2;
                        multiPartFormDataContent$writeTo$1.L$3 = preparedPart;
                        multiPartFormDataContent$writeTo$1.label = 3;
                        if (ByteWriteChannelKt.writeFully(byteWriteChannel, bArr2, multiPartFormDataContent$writeTo$1) != coroutine_suspended) {
                        }
                        return coroutine_suspended;
                    case 2:
                        PreparedPart preparedPart5 = (PreparedPart) multiPartFormDataContent$writeTo$1.L$3;
                        it2 = (Iterator) multiPartFormDataContent$writeTo$1.L$2;
                        ByteWriteChannel byteWriteChannel6 = (ByteWriteChannel) multiPartFormDataContent$writeTo$1.L$1;
                        multiPartFormDataContent2 = (MultiPartFormDataContent) multiPartFormDataContent$writeTo$1.L$0;
                        ResultKt.throwOnFailure(obj);
                        preparedPart = preparedPart5;
                        byteWriteChannel = byteWriteChannel6;
                        bArr2 = FormDataContentKt.RN_BYTES;
                        multiPartFormDataContent$writeTo$1.L$0 = multiPartFormDataContent2;
                        multiPartFormDataContent$writeTo$1.L$1 = byteWriteChannel;
                        multiPartFormDataContent$writeTo$1.L$2 = it2;
                        multiPartFormDataContent$writeTo$1.L$3 = preparedPart;
                        multiPartFormDataContent$writeTo$1.label = 3;
                        if (ByteWriteChannelKt.writeFully(byteWriteChannel, bArr2, multiPartFormDataContent$writeTo$1) != coroutine_suspended) {
                        }
                        return coroutine_suspended;
                    case 3:
                        preparedPart2 = (PreparedPart) multiPartFormDataContent$writeTo$1.L$3;
                        it2 = (Iterator) multiPartFormDataContent$writeTo$1.L$2;
                        byteWriteChannel2 = (ByteWriteChannel) multiPartFormDataContent$writeTo$1.L$1;
                        multiPartFormDataContent2 = (MultiPartFormDataContent) multiPartFormDataContent$writeTo$1.L$0;
                        ResultKt.throwOnFailure(obj);
                        if (preparedPart2 instanceof PreparedPart.InputPart) {
                        }
                        return coroutine_suspended;
                    case 4:
                        int i = multiPartFormDataContent$writeTo$1.I$0;
                        input = (Closeable) multiPartFormDataContent$writeTo$1.L$3;
                        it2 = (Iterator) multiPartFormDataContent$writeTo$1.L$2;
                        byteWriteChannel2 = (ByteWriteChannel) multiPartFormDataContent$writeTo$1.L$1;
                        multiPartFormDataContent2 = (MultiPartFormDataContent) multiPartFormDataContent$writeTo$1.L$0;
                        try {
                            ResultKt.throwOnFailure(obj);
                            Unit unit2 = Unit.INSTANCE;
                            input.close();
                            byteWriteChannel = byteWriteChannel2;
                            multiPartFormDataContent3 = multiPartFormDataContent2;
                            bArr = FormDataContentKt.RN_BYTES;
                            multiPartFormDataContent$writeTo$1.L$0 = multiPartFormDataContent3;
                            multiPartFormDataContent$writeTo$1.L$1 = byteWriteChannel;
                            multiPartFormDataContent$writeTo$1.L$2 = it2;
                            multiPartFormDataContent$writeTo$1.L$3 = null;
                            multiPartFormDataContent$writeTo$1.label = 6;
                            if (ByteWriteChannelKt.writeFully(byteWriteChannel, bArr, multiPartFormDataContent$writeTo$1) != coroutine_suspended) {
                            }
                        } finally {
                        }
                        break;
                    case 5:
                        it3 = (Iterator) multiPartFormDataContent$writeTo$1.L$2;
                        byteWriteChannel3 = (ByteWriteChannel) multiPartFormDataContent$writeTo$1.L$1;
                        multiPartFormDataContent3 = (MultiPartFormDataContent) multiPartFormDataContent$writeTo$1.L$0;
                        ResultKt.throwOnFailure(obj);
                        ByteWriteChannel byteWriteChannel42 = byteWriteChannel3;
                        it2 = it3;
                        byteWriteChannel = byteWriteChannel42;
                        bArr = FormDataContentKt.RN_BYTES;
                        multiPartFormDataContent$writeTo$1.L$0 = multiPartFormDataContent3;
                        multiPartFormDataContent$writeTo$1.L$1 = byteWriteChannel;
                        multiPartFormDataContent$writeTo$1.L$2 = it2;
                        multiPartFormDataContent$writeTo$1.L$3 = null;
                        multiPartFormDataContent$writeTo$1.label = 6;
                        if (ByteWriteChannelKt.writeFully(byteWriteChannel, bArr, multiPartFormDataContent$writeTo$1) != coroutine_suspended) {
                        }
                        break;
                    case 6:
                        Iterator<PreparedPart> it4 = (Iterator) multiPartFormDataContent$writeTo$1.L$2;
                        ByteWriteChannel byteWriteChannel7 = (ByteWriteChannel) multiPartFormDataContent$writeTo$1.L$1;
                        multiPartFormDataContent3 = (MultiPartFormDataContent) multiPartFormDataContent$writeTo$1.L$0;
                        ResultKt.throwOnFailure(obj);
                        it = it4;
                        byteWriteChannel = byteWriteChannel7;
                        multiPartFormDataContent = multiPartFormDataContent3;
                        if (it.hasNext()) {
                        }
                        return coroutine_suspended;
                    case 7:
                        byteWriteChannel = (ByteWriteChannel) multiPartFormDataContent$writeTo$1.L$0;
                        ResultKt.throwOnFailure(obj);
                        return Unit.INSTANCE;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
        multiPartFormDataContent$writeTo$1 = new MultiPartFormDataContent$writeTo$1(this, continuation);
        Object obj2 = multiPartFormDataContent$writeTo$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        r2 = multiPartFormDataContent$writeTo$1.label;
        switch (r2) {
        }
    }
}
