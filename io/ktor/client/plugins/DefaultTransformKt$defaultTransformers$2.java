package io.ktor.client.plugins;

import com.fyber.inneractive.sdk.bidder.TokenParametersOuterClass$TokenParameters;
import com.ironsource.C3337ue;
import com.vungle.ads.internal.protos.Sdk;
import io.ktor.client.call.HttpClientCall;
import io.ktor.client.statement.HttpResponse;
import io.ktor.client.statement.HttpResponseContainer;
import io.ktor.http.HttpHeaders;
import io.ktor.http.HttpMessagePropertiesKt;
import io.ktor.http.HttpMethod;
import io.ktor.http.HttpStatusCode;
import io.ktor.util.ByteChannelsKt;
import io.ktor.util.PlatformUtils;
import io.ktor.util.pipeline.PipelineContext;
import io.ktor.util.reflect.TypeInfo;
import io.ktor.utils.io.ByteReadChannel;
import io.ktor.utils.io.ByteReadChannelKt;
import io.ktor.utils.io.CoroutinesKt;
import io.ktor.utils.io.WriterJob;
import io.ktor.utils.io.core.ByteReadPacket;
import io.ktor.utils.io.core.Input;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt;
import org.slf4j.Logger;

/* compiled from: DefaultTransform.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00022\u0006\u0010\u0005\u001a\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "", "Lio/ktor/util/pipeline/PipelineContext;", "Lio/ktor/client/statement/HttpResponseContainer;", "Lio/ktor/client/call/HttpClientCall;", "<name for destructuring parameter 0>"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.client.plugins.DefaultTransformKt$defaultTransformers$2", f = "DefaultTransform.kt", i = {0, 0, 1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 5, 6, 6, 7, 7, 8, 8}, l = {68, TokenParametersOuterClass$TokenParameters.MEDIAMUTED_FIELD_NUMBER, TokenParametersOuterClass$TokenParameters.MEDIAMUTED_FIELD_NUMBER, 78, 78, 82, 90, 116, Sdk.SDKError.Reason.TPAT_ERROR_VALUE}, m = "invokeSuspend", n = {"$this$intercept", "info", "$this$intercept", "info", "$this$intercept", "info", "$this$intercept", "info", "$this$intercept", "info", "$this$intercept", "info", C3337ue.n, "$this$intercept", "info", "$this$intercept", "info", "$this$intercept", "info"}, s = {"L$0", "L$1", "L$0", "L$1", "L$0", "L$1", "L$0", "L$1", "L$0", "L$1", "L$0", "L$1", "L$2", "L$0", "L$1", "L$0", "L$1", "L$0", "L$1"})
/* loaded from: classes8.dex */
final class DefaultTransformKt$defaultTransformers$2 extends SuspendLambda implements Function3<PipelineContext<HttpResponseContainer, HttpClientCall>, HttpResponseContainer, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    Object L$2;
    Object L$3;
    int label;

    DefaultTransformKt$defaultTransformers$2(Continuation<? super DefaultTransformKt$defaultTransformers$2> continuation) {
        super(3, continuation);
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(PipelineContext<HttpResponseContainer, HttpClientCall> pipelineContext, HttpResponseContainer httpResponseContainer, Continuation<? super Unit> continuation) {
        DefaultTransformKt$defaultTransformers$2 defaultTransformKt$defaultTransformers$2 = new DefaultTransformKt$defaultTransformers$2(continuation);
        defaultTransformKt$defaultTransformers$2.L$0 = pipelineContext;
        defaultTransformKt$defaultTransformers$2.L$1 = httpResponseContainer;
        return defaultTransformKt$defaultTransformers$2.invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0323  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0247  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x024b  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0288  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x01c3  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0166  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        PipelineContext pipelineContext;
        TypeInfo expectedType;
        Object proceedWith;
        TypeInfo typeInfo;
        Object proceedWith2;
        Object byteArray;
        PipelineContext pipelineContext2;
        HttpResponse httpResponse;
        Object readRemaining$default;
        PipelineContext pipelineContext3;
        TypeInfo typeInfo2;
        PipelineContext pipelineContext4;
        TypeInfo typeInfo3;
        Object readRemaining$default2;
        PipelineContext pipelineContext5;
        TypeInfo typeInfo4;
        PipelineContext pipelineContext6;
        TypeInfo typeInfo5;
        Object proceedWith3;
        Object proceedWith4;
        Object proceedWith5;
        TypeInfo typeInfo6;
        byte[] bArr;
        Long contentLength;
        boolean z;
        Object proceedWith6;
        TypeInfo typeInfo7;
        Logger logger;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        HttpResponseContainer httpResponseContainer = null;
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure(obj);
                pipelineContext = (PipelineContext) this.L$0;
                HttpResponseContainer httpResponseContainer2 = (HttpResponseContainer) this.L$1;
                expectedType = httpResponseContainer2.getExpectedType();
                Object response = httpResponseContainer2.getResponse();
                if (!(response instanceof ByteReadChannel)) {
                    return Unit.INSTANCE;
                }
                HttpResponse response2 = ((HttpClientCall) pipelineContext.getContext()).getResponse();
                KClass<?> type = expectedType.getType();
                if (Intrinsics.areEqual(type, Reflection.getOrCreateKotlinClass(Unit.class))) {
                    ByteReadChannelKt.cancel((ByteReadChannel) response);
                    this.L$0 = pipelineContext;
                    this.L$1 = expectedType;
                    this.label = 1;
                    proceedWith3 = pipelineContext.proceedWith(new HttpResponseContainer(expectedType, Unit.INSTANCE), this);
                    if (proceedWith3 != coroutine_suspended) {
                        typeInfo = expectedType;
                        httpResponseContainer = (HttpResponseContainer) proceedWith3;
                        expectedType = typeInfo;
                        if (httpResponseContainer != null) {
                            logger = DefaultTransformKt.LOGGER;
                            logger.trace("Transformed with default transformers response body for " + ((HttpClientCall) pipelineContext.getContext()).getRequest().getUrl() + " to " + expectedType.getType());
                        }
                        return Unit.INSTANCE;
                    }
                } else if (Intrinsics.areEqual(type, Reflection.getOrCreateKotlinClass(Integer.TYPE))) {
                    this.L$0 = pipelineContext;
                    this.L$1 = expectedType;
                    this.L$2 = pipelineContext;
                    this.L$3 = expectedType;
                    this.label = 2;
                    readRemaining$default2 = ByteReadChannel.DefaultImpls.readRemaining$default((ByteReadChannel) response, 0L, this, 1, null);
                    if (readRemaining$default2 != coroutine_suspended) {
                        pipelineContext5 = pipelineContext;
                        typeInfo4 = expectedType;
                        pipelineContext6 = pipelineContext5;
                        typeInfo5 = typeInfo4;
                        this.L$0 = pipelineContext6;
                        this.L$1 = typeInfo4;
                        this.L$2 = null;
                        this.L$3 = null;
                        this.label = 3;
                        proceedWith4 = pipelineContext5.proceedWith(new HttpResponseContainer(typeInfo5, Boxing.boxInt(Integer.parseInt(Input.readText$default((Input) readRemaining$default2, 0, 0, 3, null)))), this);
                        if (proceedWith4 != coroutine_suspended) {
                            typeInfo = typeInfo4;
                            httpResponseContainer = (HttpResponseContainer) proceedWith4;
                            pipelineContext = pipelineContext6;
                            expectedType = typeInfo;
                            if (httpResponseContainer != null) {
                            }
                            return Unit.INSTANCE;
                        }
                    }
                } else {
                    if (Intrinsics.areEqual(type, Reflection.getOrCreateKotlinClass(ByteReadPacket.class)) ? true : Intrinsics.areEqual(type, Reflection.getOrCreateKotlinClass(Input.class))) {
                        this.L$0 = pipelineContext;
                        this.L$1 = expectedType;
                        this.L$2 = pipelineContext;
                        this.L$3 = expectedType;
                        this.label = 4;
                        readRemaining$default = ByteReadChannel.DefaultImpls.readRemaining$default((ByteReadChannel) response, 0L, this, 1, null);
                        if (readRemaining$default != coroutine_suspended) {
                            pipelineContext3 = pipelineContext;
                            typeInfo2 = expectedType;
                            pipelineContext4 = pipelineContext3;
                            typeInfo3 = typeInfo2;
                            this.L$0 = pipelineContext3;
                            this.L$1 = typeInfo2;
                            this.L$2 = null;
                            this.L$3 = null;
                            this.label = 5;
                            proceedWith5 = pipelineContext4.proceedWith(new HttpResponseContainer(typeInfo3, readRemaining$default), this);
                            if (proceedWith5 != coroutine_suspended) {
                                typeInfo6 = typeInfo2;
                                httpResponseContainer = (HttpResponseContainer) proceedWith5;
                                expectedType = typeInfo6;
                                pipelineContext = pipelineContext3;
                                if (httpResponseContainer != null) {
                                }
                                return Unit.INSTANCE;
                            }
                        }
                    } else if (Intrinsics.areEqual(type, Reflection.getOrCreateKotlinClass(byte[].class))) {
                        this.L$0 = pipelineContext;
                        this.L$1 = expectedType;
                        this.L$2 = response2;
                        this.label = 6;
                        byteArray = ByteChannelsKt.toByteArray((ByteReadChannel) response, this);
                        if (byteArray != coroutine_suspended) {
                            pipelineContext2 = pipelineContext;
                            httpResponse = response2;
                            bArr = (byte[]) byteArray;
                            contentLength = HttpMessagePropertiesKt.contentLength(httpResponse);
                            z = PlatformUtils.INSTANCE.getIS_BROWSER() && httpResponse.getHeaders().get(HttpHeaders.INSTANCE.getContentEncoding()) == null;
                            boolean areEqual = Intrinsics.areEqual(((HttpClientCall) pipelineContext2.getContext()).getRequest().getMethod(), HttpMethod.INSTANCE.getHead());
                            if (z && !areEqual && contentLength != null && contentLength.longValue() > 0) {
                                if (!(bArr.length == ((int) contentLength.longValue()))) {
                                    throw new IllegalStateException(("Expected " + contentLength + ", actual " + bArr.length).toString());
                                }
                            }
                            this.L$0 = pipelineContext2;
                            this.L$1 = expectedType;
                            this.L$2 = null;
                            this.label = 7;
                            proceedWith6 = pipelineContext2.proceedWith(new HttpResponseContainer(expectedType, bArr), this);
                            if (proceedWith6 != coroutine_suspended) {
                                typeInfo7 = expectedType;
                                httpResponseContainer = (HttpResponseContainer) proceedWith6;
                                expectedType = typeInfo7;
                                pipelineContext = pipelineContext2;
                                if (httpResponseContainer != null) {
                                }
                                return Unit.INSTANCE;
                            }
                        }
                    } else {
                        if (!Intrinsics.areEqual(type, Reflection.getOrCreateKotlinClass(ByteReadChannel.class))) {
                            if (Intrinsics.areEqual(type, Reflection.getOrCreateKotlinClass(HttpStatusCode.class))) {
                                ByteReadChannelKt.cancel((ByteReadChannel) response);
                                this.L$0 = pipelineContext;
                                this.L$1 = expectedType;
                                this.label = 9;
                                proceedWith = pipelineContext.proceedWith(new HttpResponseContainer(expectedType, response2.getStatus()), this);
                                if (proceedWith != coroutine_suspended) {
                                    typeInfo = expectedType;
                                    httpResponseContainer = (HttpResponseContainer) proceedWith;
                                    expectedType = typeInfo;
                                }
                            }
                            if (httpResponseContainer != null) {
                            }
                            return Unit.INSTANCE;
                        }
                        final CompletableJob Job = JobKt.Job((Job) response2.getCoroutineContext().get(Job.INSTANCE));
                        WriterJob writer$default = CoroutinesKt.writer$default((CoroutineScope) pipelineContext, response2.getCoroutineContext(), false, (Function2) new DefaultTransformKt$defaultTransformers$2$result$channel$1(response, response2, null), 2, (Object) null);
                        writer$default.invokeOnCompletion(new Function1<Throwable, Unit>() { // from class: io.ktor.client.plugins.DefaultTransformKt$defaultTransformers$2$result$channel$2$1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                                invoke2(th);
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(Throwable th) {
                                CompletableJob.this.complete();
                            }
                        });
                        this.L$0 = pipelineContext;
                        this.L$1 = expectedType;
                        this.label = 8;
                        proceedWith2 = pipelineContext.proceedWith(new HttpResponseContainer(expectedType, writer$default.getChannel()), this);
                        if (proceedWith2 != coroutine_suspended) {
                            typeInfo = expectedType;
                            httpResponseContainer = (HttpResponseContainer) proceedWith2;
                            expectedType = typeInfo;
                            if (httpResponseContainer != null) {
                            }
                            return Unit.INSTANCE;
                        }
                    }
                }
                return coroutine_suspended;
            case 1:
                typeInfo = (TypeInfo) this.L$1;
                pipelineContext = (PipelineContext) this.L$0;
                ResultKt.throwOnFailure(obj);
                proceedWith3 = obj;
                httpResponseContainer = (HttpResponseContainer) proceedWith3;
                expectedType = typeInfo;
                if (httpResponseContainer != null) {
                }
                return Unit.INSTANCE;
            case 2:
                typeInfo5 = (TypeInfo) this.L$3;
                PipelineContext pipelineContext7 = (PipelineContext) this.L$2;
                typeInfo4 = (TypeInfo) this.L$1;
                pipelineContext6 = (PipelineContext) this.L$0;
                ResultKt.throwOnFailure(obj);
                pipelineContext5 = pipelineContext7;
                readRemaining$default2 = obj;
                this.L$0 = pipelineContext6;
                this.L$1 = typeInfo4;
                this.L$2 = null;
                this.L$3 = null;
                this.label = 3;
                proceedWith4 = pipelineContext5.proceedWith(new HttpResponseContainer(typeInfo5, Boxing.boxInt(Integer.parseInt(Input.readText$default((Input) readRemaining$default2, 0, 0, 3, null)))), this);
                if (proceedWith4 != coroutine_suspended) {
                }
                return coroutine_suspended;
            case 3:
                typeInfo = (TypeInfo) this.L$1;
                PipelineContext pipelineContext8 = (PipelineContext) this.L$0;
                ResultKt.throwOnFailure(obj);
                pipelineContext6 = pipelineContext8;
                proceedWith4 = obj;
                httpResponseContainer = (HttpResponseContainer) proceedWith4;
                pipelineContext = pipelineContext6;
                expectedType = typeInfo;
                if (httpResponseContainer != null) {
                }
                return Unit.INSTANCE;
            case 4:
                typeInfo3 = (TypeInfo) this.L$3;
                PipelineContext pipelineContext9 = (PipelineContext) this.L$2;
                typeInfo2 = (TypeInfo) this.L$1;
                pipelineContext3 = (PipelineContext) this.L$0;
                ResultKt.throwOnFailure(obj);
                pipelineContext4 = pipelineContext9;
                readRemaining$default = obj;
                this.L$0 = pipelineContext3;
                this.L$1 = typeInfo2;
                this.L$2 = null;
                this.L$3 = null;
                this.label = 5;
                proceedWith5 = pipelineContext4.proceedWith(new HttpResponseContainer(typeInfo3, readRemaining$default), this);
                if (proceedWith5 != coroutine_suspended) {
                }
                return coroutine_suspended;
            case 5:
                typeInfo6 = (TypeInfo) this.L$1;
                PipelineContext pipelineContext10 = (PipelineContext) this.L$0;
                ResultKt.throwOnFailure(obj);
                pipelineContext3 = pipelineContext10;
                proceedWith5 = obj;
                httpResponseContainer = (HttpResponseContainer) proceedWith5;
                expectedType = typeInfo6;
                pipelineContext = pipelineContext3;
                if (httpResponseContainer != null) {
                }
                return Unit.INSTANCE;
            case 6:
                httpResponse = (HttpResponse) this.L$2;
                TypeInfo typeInfo8 = (TypeInfo) this.L$1;
                PipelineContext pipelineContext11 = (PipelineContext) this.L$0;
                ResultKt.throwOnFailure(obj);
                pipelineContext2 = pipelineContext11;
                expectedType = typeInfo8;
                byteArray = obj;
                bArr = (byte[]) byteArray;
                contentLength = HttpMessagePropertiesKt.contentLength(httpResponse);
                if (PlatformUtils.INSTANCE.getIS_BROWSER()) {
                    break;
                }
                boolean areEqual2 = Intrinsics.areEqual(((HttpClientCall) pipelineContext2.getContext()).getRequest().getMethod(), HttpMethod.INSTANCE.getHead());
                if (z) {
                    if (!(bArr.length == ((int) contentLength.longValue()))) {
                    }
                    break;
                }
                this.L$0 = pipelineContext2;
                this.L$1 = expectedType;
                this.L$2 = null;
                this.label = 7;
                proceedWith6 = pipelineContext2.proceedWith(new HttpResponseContainer(expectedType, bArr), this);
                if (proceedWith6 != coroutine_suspended) {
                }
                return coroutine_suspended;
            case 7:
                typeInfo7 = (TypeInfo) this.L$1;
                PipelineContext pipelineContext12 = (PipelineContext) this.L$0;
                ResultKt.throwOnFailure(obj);
                pipelineContext2 = pipelineContext12;
                proceedWith6 = obj;
                httpResponseContainer = (HttpResponseContainer) proceedWith6;
                expectedType = typeInfo7;
                pipelineContext = pipelineContext2;
                if (httpResponseContainer != null) {
                }
                return Unit.INSTANCE;
            case 8:
                typeInfo = (TypeInfo) this.L$1;
                pipelineContext = (PipelineContext) this.L$0;
                ResultKt.throwOnFailure(obj);
                proceedWith2 = obj;
                httpResponseContainer = (HttpResponseContainer) proceedWith2;
                expectedType = typeInfo;
                if (httpResponseContainer != null) {
                }
                return Unit.INSTANCE;
            case 9:
                typeInfo = (TypeInfo) this.L$1;
                pipelineContext = (PipelineContext) this.L$0;
                ResultKt.throwOnFailure(obj);
                proceedWith = obj;
                httpResponseContainer = (HttpResponseContainer) proceedWith;
                expectedType = typeInfo;
                if (httpResponseContainer != null) {
                }
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}
