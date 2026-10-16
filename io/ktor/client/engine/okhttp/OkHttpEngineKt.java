package io.ktor.client.engine.okhttp;

import com.vungle.ads.internal.ui.AdActivity;
import io.ktor.client.call.UnsupportedContentTypeException;
import io.ktor.client.engine.UtilsKt;
import io.ktor.client.plugins.HttpTimeout;
import io.ktor.client.plugins.HttpTimeoutKt;
import io.ktor.client.request.HttpRequestData;
import io.ktor.http.HttpHeaders;
import io.ktor.http.content.OutgoingContent;
import io.ktor.utils.io.ByteReadChannel;
import io.ktor.utils.io.CoroutinesKt;
import io.ktor.utils.io.WriterScope;
import java.net.SocketTimeoutException;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.GlobalScope;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.internal.http.HttpMethod;
import okio.BufferedSource;

/* compiled from: OkHttpEngine.kt */
@Metadata(d1 = {"\u0000>\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0018\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\u0002\u001a\u0014\u0010\u0005\u001a\u00020\u0006*\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0000\u001a\u0014\u0010\n\u001a\u00020\u000b*\u00020\u00042\u0006\u0010\b\u001a\u00020\tH\u0002\u001a\u0014\u0010\f\u001a\u00020\r*\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002\u001a\u001c\u0010\u0010\u001a\u00020\u0011*\u00020\u00122\u0006\u0010\u0013\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\u0004H\u0002¨\u0006\u0015"}, d2 = {"mapExceptions", "", "cause", AdActivity.REQUEST_KEY_EXTRA, "Lio/ktor/client/request/HttpRequestData;", "convertToOkHttpBody", "Lokhttp3/RequestBody;", "Lio/ktor/http/content/OutgoingContent;", "callContext", "Lkotlin/coroutines/CoroutineContext;", "convertToOkHttpRequest", "Lokhttp3/Request;", "setupTimeoutAttributes", "Lokhttp3/OkHttpClient$Builder;", "timeoutAttributes", "Lio/ktor/client/plugins/HttpTimeout$HttpTimeoutCapabilityConfiguration;", "toChannel", "Lio/ktor/utils/io/ByteReadChannel;", "Lokio/BufferedSource;", "context", "requestData", "ktor-client-okhttp"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes8.dex */
public final class OkHttpEngineKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final ByteReadChannel toChannel(BufferedSource bufferedSource, CoroutineContext coroutineContext, HttpRequestData httpRequestData) {
        return CoroutinesKt.writer$default((CoroutineScope) GlobalScope.INSTANCE, coroutineContext, false, (Function2) new OkHttpEngineKt$toChannel$1(bufferedSource, coroutineContext, httpRequestData, null), 2, (Object) null).getChannel();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Throwable mapExceptions(Throwable th, HttpRequestData httpRequestData) {
        return th instanceof SocketTimeoutException ? HttpTimeoutKt.SocketTimeoutException(httpRequestData, th) : th;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Request convertToOkHttpRequest(HttpRequestData httpRequestData, CoroutineContext coroutineContext) {
        final Request.Builder builder = new Request.Builder();
        builder.url(httpRequestData.getUrl().getUrlString());
        UtilsKt.mergeHeaders(httpRequestData.getHeaders(), httpRequestData.getBody(), new Function2<String, String, Unit>() { // from class: io.ktor.client.engine.okhttp.OkHttpEngineKt$convertToOkHttpRequest$1$1
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(String str, String str2) {
                invoke2(str, str2);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(String key, String value) {
                Intrinsics.checkNotNullParameter(key, "key");
                Intrinsics.checkNotNullParameter(value, "value");
                if (Intrinsics.areEqual(key, HttpHeaders.INSTANCE.getContentLength())) {
                    return;
                }
                Request.Builder.this.addHeader(key, value);
            }
        });
        builder.method(httpRequestData.getMethod().getValue(), HttpMethod.permitsRequestBody(httpRequestData.getMethod().getValue()) ? convertToOkHttpBody(httpRequestData.getBody(), coroutineContext) : null);
        return builder.build();
    }

    public static final RequestBody convertToOkHttpBody(final OutgoingContent outgoingContent, final CoroutineContext callContext) {
        Intrinsics.checkNotNullParameter(outgoingContent, "<this>");
        Intrinsics.checkNotNullParameter(callContext, "callContext");
        if (outgoingContent instanceof OutgoingContent.ByteArrayContent) {
            byte[] bytes = ((OutgoingContent.ByteArrayContent) outgoingContent).getBytes();
            return RequestBody.INSTANCE.create(bytes, (MediaType) null, 0, bytes.length);
        }
        if (outgoingContent instanceof OutgoingContent.ReadChannelContent) {
            return new StreamRequestBody(outgoingContent.getContentLength(), new Function0<ByteReadChannel>() { // from class: io.ktor.client.engine.okhttp.OkHttpEngineKt$convertToOkHttpBody$2
                {
                    super(0);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final ByteReadChannel invoke() {
                    return ((OutgoingContent.ReadChannelContent) OutgoingContent.this).readFrom();
                }
            });
        }
        if (outgoingContent instanceof OutgoingContent.WriteChannelContent) {
            return new StreamRequestBody(outgoingContent.getContentLength(), new Function0<ByteReadChannel>() { // from class: io.ktor.client.engine.okhttp.OkHttpEngineKt$convertToOkHttpBody$3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                /* compiled from: OkHttpEngine.kt */
                @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lio/ktor/utils/io/WriterScope;"}, k = 3, mv = {1, 7, 1}, xi = 48)
                @DebugMetadata(c = "io.ktor.client.engine.okhttp.OkHttpEngineKt$convertToOkHttpBody$3$1", f = "OkHttpEngine.kt", i = {}, l = {212}, m = "invokeSuspend", n = {}, s = {})
                /* renamed from: io.ktor.client.engine.okhttp.OkHttpEngineKt$convertToOkHttpBody$3$1, reason: invalid class name */
                static final class AnonymousClass1 extends SuspendLambda implements Function2<WriterScope, Continuation<? super Unit>, Object> {
                    final /* synthetic */ OutgoingContent $this_convertToOkHttpBody;
                    private /* synthetic */ Object L$0;
                    int label;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    AnonymousClass1(OutgoingContent outgoingContent, Continuation<? super AnonymousClass1> continuation) {
                        super(2, continuation);
                        this.$this_convertToOkHttpBody = outgoingContent;
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                        AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$this_convertToOkHttpBody, continuation);
                        anonymousClass1.L$0 = obj;
                        return anonymousClass1;
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(WriterScope writerScope, Continuation<? super Unit> continuation) {
                        return ((AnonymousClass1) create(writerScope, continuation)).invokeSuspend(Unit.INSTANCE);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        int i = this.label;
                        if (i == 0) {
                            ResultKt.throwOnFailure(obj);
                            WriterScope writerScope = (WriterScope) this.L$0;
                            this.label = 1;
                            if (((OutgoingContent.WriteChannelContent) this.$this_convertToOkHttpBody).writeTo(writerScope.getChannel(), this) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                        } else {
                            if (i != 1) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            ResultKt.throwOnFailure(obj);
                        }
                        return Unit.INSTANCE;
                    }
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final ByteReadChannel invoke() {
                    return CoroutinesKt.writer$default((CoroutineScope) GlobalScope.INSTANCE, CoroutineContext.this, false, (Function2) new AnonymousClass1(outgoingContent, null), 2, (Object) null).getChannel();
                }
            });
        }
        if (outgoingContent instanceof OutgoingContent.NoContent) {
            return RequestBody.INSTANCE.create(new byte[0], (MediaType) null, 0, 0);
        }
        throw new UnsupportedContentTypeException(outgoingContent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final OkHttpClient.Builder setupTimeoutAttributes(OkHttpClient.Builder builder, HttpTimeout.HttpTimeoutCapabilityConfiguration httpTimeoutCapabilityConfiguration) {
        Long l = httpTimeoutCapabilityConfiguration.get_connectTimeoutMillis();
        if (l != null) {
            builder.connectTimeout(HttpTimeoutKt.convertLongTimeoutToLongWithInfiniteAsZero(l.longValue()), TimeUnit.MILLISECONDS);
        }
        Long l2 = httpTimeoutCapabilityConfiguration.get_socketTimeoutMillis();
        if (l2 != null) {
            long longValue = l2.longValue();
            builder.readTimeout(HttpTimeoutKt.convertLongTimeoutToLongWithInfiniteAsZero(longValue), TimeUnit.MILLISECONDS);
            builder.writeTimeout(HttpTimeoutKt.convertLongTimeoutToLongWithInfiniteAsZero(longValue), TimeUnit.MILLISECONDS);
        }
        return builder;
    }
}
