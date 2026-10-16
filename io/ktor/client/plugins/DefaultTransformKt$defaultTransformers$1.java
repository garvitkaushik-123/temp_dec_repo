package io.ktor.client.plugins;

import io.ktor.client.request.HttpRequestBuilder;
import io.ktor.http.ContentType;
import io.ktor.http.HttpHeaders;
import io.ktor.http.HttpMessageBuilder;
import io.ktor.http.HttpMessagePropertiesKt;
import io.ktor.http.content.OutgoingContent;
import io.ktor.http.content.TextContent;
import io.ktor.util.pipeline.PipelineContext;
import io.ktor.utils.io.ByteReadChannel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Reflection;
import org.slf4j.Logger;

/* compiled from: DefaultTransform.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00022\u0006\u0010\u0005\u001a\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "", "Lio/ktor/util/pipeline/PipelineContext;", "", "Lio/ktor/client/request/HttpRequestBuilder;", "body"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.client.plugins.DefaultTransformKt$defaultTransformers$1", f = "DefaultTransform.kt", i = {}, l = {57}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes8.dex */
final class DefaultTransformKt$defaultTransformers$1 extends SuspendLambda implements Function3<PipelineContext<Object, HttpRequestBuilder>, Object, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;

    DefaultTransformKt$defaultTransformers$1(Continuation<? super DefaultTransformKt$defaultTransformers$1> continuation) {
        super(3, continuation);
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(PipelineContext<Object, HttpRequestBuilder> pipelineContext, Object obj, Continuation<? super Unit> continuation) {
        DefaultTransformKt$defaultTransformers$1 defaultTransformKt$defaultTransformers$1 = new DefaultTransformKt$defaultTransformers$1(continuation);
        defaultTransformKt$defaultTransformers$1.L$0 = pipelineContext;
        defaultTransformKt$defaultTransformers$1.L$1 = obj;
        return defaultTransformKt$defaultTransformers$1.invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        OutgoingContent.ReadChannelContent platformRequestDefaultTransform;
        Logger logger;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            final PipelineContext pipelineContext = (PipelineContext) this.L$0;
            final Object obj2 = this.L$1;
            if (((HttpRequestBuilder) pipelineContext.getContext()).getHeaders().get(HttpHeaders.INSTANCE.getAccept()) == null) {
                ((HttpRequestBuilder) pipelineContext.getContext()).getHeaders().append(HttpHeaders.INSTANCE.getAccept(), "*/*");
            }
            final ContentType contentType = HttpMessagePropertiesKt.contentType((HttpMessageBuilder) pipelineContext.getContext());
            if (obj2 instanceof String) {
                String str = (String) obj2;
                if (contentType == null) {
                    contentType = ContentType.Text.INSTANCE.getPlain();
                }
                platformRequestDefaultTransform = new TextContent(str, contentType, null, 4, null);
            } else if (obj2 instanceof byte[]) {
                platformRequestDefaultTransform = new OutgoingContent.ByteArrayContent(contentType, obj2) { // from class: io.ktor.client.plugins.DefaultTransformKt$defaultTransformers$1$content$1
                    final /* synthetic */ Object $body;
                    private final long contentLength;
                    private final ContentType contentType;

                    {
                        this.$body = obj2;
                        this.contentType = contentType == null ? ContentType.Application.INSTANCE.getOctetStream() : contentType;
                        this.contentLength = ((byte[]) obj2).length;
                    }

                    @Override // io.ktor.http.content.OutgoingContent
                    public ContentType getContentType() {
                        return this.contentType;
                    }

                    @Override // io.ktor.http.content.OutgoingContent
                    public Long getContentLength() {
                        return Long.valueOf(this.contentLength);
                    }

                    @Override // io.ktor.http.content.OutgoingContent.ByteArrayContent
                    /* renamed from: bytes */
                    public byte[] getBytes() {
                        return (byte[]) this.$body;
                    }
                };
            } else if (obj2 instanceof ByteReadChannel) {
                platformRequestDefaultTransform = new OutgoingContent.ReadChannelContent(pipelineContext, contentType, obj2) { // from class: io.ktor.client.plugins.DefaultTransformKt$defaultTransformers$1$content$2
                    final /* synthetic */ Object $body;
                    private final Long contentLength;
                    private final ContentType contentType;

                    {
                        this.$body = obj2;
                        String str2 = pipelineContext.getContext().getHeaders().get(HttpHeaders.INSTANCE.getContentLength());
                        this.contentLength = str2 != null ? Long.valueOf(Long.parseLong(str2)) : null;
                        this.contentType = contentType == null ? ContentType.Application.INSTANCE.getOctetStream() : contentType;
                    }

                    @Override // io.ktor.http.content.OutgoingContent
                    public Long getContentLength() {
                        return this.contentLength;
                    }

                    @Override // io.ktor.http.content.OutgoingContent
                    public ContentType getContentType() {
                        return this.contentType;
                    }

                    @Override // io.ktor.http.content.OutgoingContent.ReadChannelContent
                    public ByteReadChannel readFrom() {
                        return (ByteReadChannel) this.$body;
                    }
                };
            } else {
                platformRequestDefaultTransform = obj2 instanceof OutgoingContent ? (OutgoingContent) obj2 : DefaultTransformersJvmKt.platformRequestDefaultTransform(contentType, (HttpRequestBuilder) pipelineContext.getContext(), obj2);
            }
            if ((platformRequestDefaultTransform != null ? platformRequestDefaultTransform.getContentType() : null) != null) {
                ((HttpRequestBuilder) pipelineContext.getContext()).getHeaders().remove(HttpHeaders.INSTANCE.getContentType());
                logger = DefaultTransformKt.LOGGER;
                logger.trace("Transformed with default transformers request body for " + ((HttpRequestBuilder) pipelineContext.getContext()).getUrl() + " from " + Reflection.getOrCreateKotlinClass(obj2.getClass()));
                this.L$0 = null;
                this.label = 1;
                if (pipelineContext.proceedWith(platformRequestDefaultTransform, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
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
