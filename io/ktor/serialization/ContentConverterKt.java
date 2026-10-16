package io.ktor.serialization;

import com.vungle.ads.internal.protos.Sdk;
import io.ktor.http.HeaderValue;
import io.ktor.http.Headers;
import io.ktor.http.HttpHeaderValueParserKt;
import io.ktor.http.HttpHeaders;
import io.ktor.http.content.NullBody;
import io.ktor.util.InternalAPI;
import io.ktor.util.reflect.TypeInfo;
import io.ktor.utils.io.ByteReadChannel;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KType;
import kotlin.text.Charsets;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;

/* compiled from: ContentConverter.kt */
@Metadata(d1 = {"\u00000\n\u0000\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a7\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\n\u0010\b\u001a\u00060\tj\u0002`\nH\u0087@ø\u0001\u0000¢\u0006\u0002\u0010\u000b\u001a\u001c\u0010\f\u001a\u00060\tj\u0002`\n*\u00020\r2\f\b\u0002\u0010\u000e\u001a\u00060\tj\u0002`\n\u001a \u0010\u000f\u001a\n\u0018\u00010\tj\u0004\u0018\u0001`\n*\u00020\r2\f\b\u0002\u0010\u000e\u001a\u00060\tj\u0002`\n\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0010"}, d2 = {"deserialize", "", "", "Lio/ktor/serialization/ContentConverter;", "body", "Lio/ktor/utils/io/ByteReadChannel;", "typeInfo", "Lio/ktor/util/reflect/TypeInfo;", "charset", "Ljava/nio/charset/Charset;", "Lio/ktor/utils/io/charsets/Charset;", "(Ljava/util/List;Lio/ktor/utils/io/ByteReadChannel;Lio/ktor/util/reflect/TypeInfo;Ljava/nio/charset/Charset;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "suitableCharset", "Lio/ktor/http/Headers;", "defaultCharset", "suitableCharsetOrNull", "ktor-serialization"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes8.dex */
public final class ContentConverterKt {
    public static /* synthetic */ Charset suitableCharset$default(Headers headers, Charset charset, int i, Object obj) {
        if ((i & 1) != 0) {
            charset = Charsets.UTF_8;
        }
        return suitableCharset(headers, charset);
    }

    public static final Charset suitableCharset(Headers headers, Charset defaultCharset) {
        Intrinsics.checkNotNullParameter(headers, "<this>");
        Intrinsics.checkNotNullParameter(defaultCharset, "defaultCharset");
        Charset suitableCharsetOrNull = suitableCharsetOrNull(headers, defaultCharset);
        return suitableCharsetOrNull == null ? defaultCharset : suitableCharsetOrNull;
    }

    public static /* synthetic */ Charset suitableCharsetOrNull$default(Headers headers, Charset charset, int i, Object obj) {
        if ((i & 1) != 0) {
            charset = Charsets.UTF_8;
        }
        return suitableCharsetOrNull(headers, charset);
    }

    public static final Charset suitableCharsetOrNull(Headers headers, Charset defaultCharset) {
        Intrinsics.checkNotNullParameter(headers, "<this>");
        Intrinsics.checkNotNullParameter(defaultCharset, "defaultCharset");
        Iterator<HeaderValue> it = HttpHeaderValueParserKt.parseAndSortHeader(headers.get(HttpHeaders.INSTANCE.getAcceptCharset())).iterator();
        while (it.hasNext()) {
            String value = it.next().getValue();
            if (Intrinsics.areEqual(value, "*")) {
                return defaultCharset;
            }
            if (Charset.isSupported(value)) {
                return Charset.forName(value);
            }
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x008f A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x003d  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    @InternalAPI
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object deserialize(List<? extends ContentConverter> list, final ByteReadChannel byteReadChannel, final TypeInfo typeInfo, final Charset charset, Continuation<Object> continuation) {
        ContentConverterKt$deserialize$1 contentConverterKt$deserialize$1;
        Object obj;
        int i;
        if (continuation instanceof ContentConverterKt$deserialize$1) {
            contentConverterKt$deserialize$1 = (ContentConverterKt$deserialize$1) continuation;
            if ((contentConverterKt$deserialize$1.label & Integer.MIN_VALUE) != 0) {
                contentConverterKt$deserialize$1.label -= Integer.MIN_VALUE;
                obj = contentConverterKt$deserialize$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = contentConverterKt$deserialize$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    final Flow asFlow = FlowKt.asFlow(list);
                    Flow<Object> flow = new Flow<Object>() { // from class: io.ktor.serialization.ContentConverterKt$deserialize$$inlined$map$1

                        /* compiled from: Emitters.kt */
                        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"<anonymous>", "", "T", "R", "value", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$map$$inlined$unsafeTransform$1$2"}, k = 3, mv = {1, 8, 0}, xi = 48)
                        /* renamed from: io.ktor.serialization.ContentConverterKt$deserialize$$inlined$map$1$2, reason: invalid class name */
                        public static final class AnonymousClass2<T> implements FlowCollector {
                            final /* synthetic */ ByteReadChannel $body$inlined;
                            final /* synthetic */ Charset $charset$inlined;
                            final /* synthetic */ FlowCollector $this_unsafeFlow;
                            final /* synthetic */ TypeInfo $typeInfo$inlined;

                            /* compiled from: Emitters.kt */
                            @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
                            @DebugMetadata(c = "io.ktor.serialization.ContentConverterKt$deserialize$$inlined$map$1$2", f = "ContentConverter.kt", i = {}, l = {224, Sdk.SDKError.Reason.STALE_CACHED_RESPONSE_VALUE}, m = "emit", n = {}, s = {})
                            /* renamed from: io.ktor.serialization.ContentConverterKt$deserialize$$inlined$map$1$2$1, reason: invalid class name */
                            public static final class AnonymousClass1 extends ContinuationImpl {
                                Object L$0;
                                int label;
                                /* synthetic */ Object result;

                                public AnonymousClass1(Continuation continuation) {
                                    super(continuation);
                                }

                                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                public final Object invokeSuspend(Object obj) {
                                    this.result = obj;
                                    this.label |= Integer.MIN_VALUE;
                                    return AnonymousClass2.this.emit(null, this);
                                }
                            }

                            public AnonymousClass2(FlowCollector flowCollector, Charset charset, TypeInfo typeInfo, ByteReadChannel byteReadChannel) {
                                this.$this_unsafeFlow = flowCollector;
                                this.$charset$inlined = charset;
                                this.$typeInfo$inlined = typeInfo;
                                this.$body$inlined = byteReadChannel;
                            }

                            /* JADX WARN: Code restructure failed: missing block: B:18:0x0064, code lost:
                            
                                if (r9.emit(r10, r0) != r1) goto L23;
                             */
                            /* JADX WARN: Removed duplicated region for block: B:20:0x003d  */
                            /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
                            @Override // kotlinx.coroutines.flow.FlowCollector
                            /*
                                Code decompiled incorrectly, please refer to instructions dump.
                            */
                            public final Object emit(Object obj, Continuation continuation) {
                                AnonymousClass1 anonymousClass1;
                                int i;
                                FlowCollector flowCollector;
                                if (continuation instanceof AnonymousClass1) {
                                    anonymousClass1 = (AnonymousClass1) continuation;
                                    if ((anonymousClass1.label & Integer.MIN_VALUE) != 0) {
                                        anonymousClass1.label -= Integer.MIN_VALUE;
                                        Object obj2 = anonymousClass1.result;
                                        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                        i = anonymousClass1.label;
                                        if (i != 0) {
                                            ResultKt.throwOnFailure(obj2);
                                            FlowCollector flowCollector2 = this.$this_unsafeFlow;
                                            Charset charset = this.$charset$inlined;
                                            TypeInfo typeInfo = this.$typeInfo$inlined;
                                            ByteReadChannel byteReadChannel = this.$body$inlined;
                                            anonymousClass1.L$0 = flowCollector2;
                                            anonymousClass1.label = 1;
                                            Object deserialize = ((ContentConverter) obj).deserialize(charset, typeInfo, byteReadChannel, anonymousClass1);
                                            if (deserialize != coroutine_suspended) {
                                                obj2 = deserialize;
                                                flowCollector = flowCollector2;
                                            }
                                            return coroutine_suspended;
                                        }
                                        if (i != 1) {
                                            if (i != 2) {
                                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                            }
                                            ResultKt.throwOnFailure(obj2);
                                            return Unit.INSTANCE;
                                        }
                                        FlowCollector flowCollector3 = (FlowCollector) anonymousClass1.L$0;
                                        ResultKt.throwOnFailure(obj2);
                                        flowCollector = flowCollector3;
                                        anonymousClass1.L$0 = null;
                                        anonymousClass1.label = 2;
                                    }
                                }
                                anonymousClass1 = new AnonymousClass1(continuation);
                                Object obj22 = anonymousClass1.result;
                                Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                i = anonymousClass1.label;
                                if (i != 0) {
                                }
                                anonymousClass1.L$0 = null;
                                anonymousClass1.label = 2;
                            }
                        }

                        @Override // kotlinx.coroutines.flow.Flow
                        public Object collect(FlowCollector<? super Object> flowCollector, Continuation continuation2) {
                            Object collect = Flow.this.collect(new AnonymousClass2(flowCollector, charset, typeInfo, byteReadChannel), continuation2);
                            return collect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? collect : Unit.INSTANCE;
                        }
                    };
                    ContentConverterKt$deserialize$result$2 contentConverterKt$deserialize$result$2 = new ContentConverterKt$deserialize$result$2(byteReadChannel, null);
                    contentConverterKt$deserialize$1.L$0 = byteReadChannel;
                    contentConverterKt$deserialize$1.L$1 = typeInfo;
                    contentConverterKt$deserialize$1.label = 1;
                    obj = FlowKt.firstOrNull(flow, contentConverterKt$deserialize$result$2, contentConverterKt$deserialize$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    typeInfo = (TypeInfo) contentConverterKt$deserialize$1.L$1;
                    byteReadChannel = (ByteReadChannel) contentConverterKt$deserialize$1.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                if (obj == null) {
                    return obj;
                }
                if (!byteReadChannel.isClosedForRead()) {
                    return byteReadChannel;
                }
                KType kotlinType = typeInfo.getKotlinType();
                if (kotlinType == null || !kotlinType.isMarkedNullable()) {
                    throw new ContentConvertException("No suitable converter found for " + typeInfo, null, 2, null);
                }
                return NullBody.INSTANCE;
            }
        }
        contentConverterKt$deserialize$1 = new ContentConverterKt$deserialize$1(continuation);
        obj = contentConverterKt$deserialize$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = contentConverterKt$deserialize$1.label;
        if (i != 0) {
        }
        if (obj == null) {
        }
    }
}
