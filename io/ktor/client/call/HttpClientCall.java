package io.ktor.client.call;

import com.ironsource.C3337ue;
import com.vungle.ads.internal.ui.AdActivity;
import io.ktor.client.HttpClient;
import io.ktor.client.request.DefaultHttpRequest;
import io.ktor.client.request.HttpRequest;
import io.ktor.client.request.HttpRequestData;
import io.ktor.client.request.HttpResponseData;
import io.ktor.client.statement.DefaultHttpResponse;
import io.ktor.client.statement.HttpResponse;
import io.ktor.client.statement.HttpResponseContainer;
import io.ktor.client.statement.HttpResponseKt;
import io.ktor.client.statement.HttpResponsePipeline;
import io.ktor.http.content.NullBody;
import io.ktor.util.AttributeKey;
import io.ktor.util.Attributes;
import io.ktor.util.InternalAPI;
import io.ktor.util.reflect.TypeInfo;
import io.ktor.util.reflect.TypeInfoJvmKt;
import io.ktor.utils.io.ByteReadChannel;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* compiled from: HttpClientCall.kt */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\b\u0016\u0018\u0000 82\u00020::\u00018B!\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0007\u0010\tJ\u001b\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nH\u0086@ø\u0001\u0000¢\u0006\u0004\b\r\u0010\u000eJ\u001d\u0010\u000f\u001a\u0004\u0018\u00010\f2\u0006\u0010\u000b\u001a\u00020\nH\u0086@ø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\u000eJ\u0013\u0010\u0011\u001a\u00020\u0010H\u0094@ø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0018\u001a\u00020\u00152\u0006\u0010\u0014\u001a\u00020\u0013H\u0000¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u001d\u001a\u00020\u00152\u0006\u0010\u001a\u001a\u00020\u0019H\u0000¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u001f\u001a\u00020\u001eH\u0016¢\u0006\u0004\b\u001f\u0010 R\u001a\u0010\"\u001a\u00020!8\u0014X\u0094D¢\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%R\u0011\u0010)\u001a\u00020&8F¢\u0006\u0006\u001a\u0004\b'\u0010(R\u0017\u0010\u0002\u001a\u00020\u00018\u0006¢\u0006\f\n\u0004\b\u0002\u0010*\u001a\u0004\b+\u0010,R\u0014\u00100\u001a\u00020-8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b.\u0010/R*\u0010\u0014\u001a\u00020\u00132\u0006\u00101\u001a\u00020\u00138\u0006@DX\u0086.¢\u0006\u0012\n\u0004\b\u0014\u00102\u001a\u0004\b3\u00104\"\u0004\b\u0018\u0010\u0017R*\u0010\u001a\u001a\u00020\u00192\u0006\u00101\u001a\u00020\u00198\u0006@DX\u0086.¢\u0006\u0012\n\u0004\b\u001a\u00105\u001a\u0004\b6\u00107\"\u0004\b\u001d\u0010\u001c\u0082\u0002\u0004\n\u0002\b\u0019¨\u00069"}, d2 = {"Lio/ktor/client/call/HttpClientCall;", "Lio/ktor/client/HttpClient;", "client", "Lio/ktor/client/request/HttpRequestData;", "requestData", "Lio/ktor/client/request/HttpResponseData;", "responseData", "<init>", "(Lio/ktor/client/HttpClient;Lio/ktor/client/request/HttpRequestData;Lio/ktor/client/request/HttpResponseData;)V", "(Lio/ktor/client/HttpClient;)V", "Lio/ktor/util/reflect/TypeInfo;", "info", "", "body", "(Lio/ktor/util/reflect/TypeInfo;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "bodyNullable", "Lio/ktor/utils/io/ByteReadChannel;", "getResponseContent", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lio/ktor/client/request/HttpRequest;", AdActivity.REQUEST_KEY_EXTRA, "", "setRequest$ktor_client_core", "(Lio/ktor/client/request/HttpRequest;)V", "setRequest", "Lio/ktor/client/statement/HttpResponse;", C3337ue.n, "setResponse$ktor_client_core", "(Lio/ktor/client/statement/HttpResponse;)V", "setResponse", "", "toString", "()Ljava/lang/String;", "", "allowDoubleReceive", "Z", "getAllowDoubleReceive", "()Z", "Lio/ktor/util/Attributes;", "getAttributes", "()Lio/ktor/util/Attributes;", "attributes", "Lio/ktor/client/HttpClient;", "getClient", "()Lio/ktor/client/HttpClient;", "Lkotlin/coroutines/CoroutineContext;", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "coroutineContext", "<set-?>", "Lio/ktor/client/request/HttpRequest;", "getRequest", "()Lio/ktor/client/request/HttpRequest;", "Lio/ktor/client/statement/HttpResponse;", "getResponse", "()Lio/ktor/client/statement/HttpResponse;", "Companion", "ktor-client-core", "Lkotlinx/coroutines/CoroutineScope;"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes8.dex */
public class HttpClientCall implements CoroutineScope {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final AttributeKey<Object> CustomResponse = new AttributeKey<>("CustomResponse");
    private static final /* synthetic */ AtomicIntegerFieldUpdater received$FU = AtomicIntegerFieldUpdater.newUpdater(HttpClientCall.class, "received");
    private final boolean allowDoubleReceive;
    private final HttpClient client;
    private volatile /* synthetic */ int received;
    protected HttpRequest request;
    protected HttpResponse response;

    protected Object getResponseContent(Continuation<? super ByteReadChannel> continuation) {
        return getResponseContent$suspendImpl(this, continuation);
    }

    public HttpClientCall(HttpClient client) {
        Intrinsics.checkNotNullParameter(client, "client");
        this.client = client;
        this.received = 0;
    }

    public final HttpClient getClient() {
        return this.client;
    }

    @Override // kotlinx.coroutines.CoroutineScope
    public CoroutineContext getCoroutineContext() {
        return getResponse().getCoroutineContext();
    }

    public final Attributes getAttributes() {
        return getRequest().getAttributes();
    }

    public final HttpRequest getRequest() {
        HttpRequest httpRequest = this.request;
        if (httpRequest != null) {
            return httpRequest;
        }
        Intrinsics.throwUninitializedPropertyAccessException(AdActivity.REQUEST_KEY_EXTRA);
        return null;
    }

    protected final void setRequest(HttpRequest httpRequest) {
        Intrinsics.checkNotNullParameter(httpRequest, "<set-?>");
        this.request = httpRequest;
    }

    public final HttpResponse getResponse() {
        HttpResponse httpResponse = this.response;
        if (httpResponse != null) {
            return httpResponse;
        }
        Intrinsics.throwUninitializedPropertyAccessException(C3337ue.n);
        return null;
    }

    protected final void setResponse(HttpResponse httpResponse) {
        Intrinsics.checkNotNullParameter(httpResponse, "<set-?>");
        this.response = httpResponse;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @InternalAPI
    public HttpClientCall(HttpClient client, HttpRequestData requestData, HttpResponseData responseData) {
        this(client);
        Intrinsics.checkNotNullParameter(client, "client");
        Intrinsics.checkNotNullParameter(requestData, "requestData");
        Intrinsics.checkNotNullParameter(responseData, "responseData");
        setRequest(new DefaultHttpRequest(this, requestData));
        setResponse(new DefaultHttpResponse(this, responseData));
        if (responseData.getBody() instanceof ByteReadChannel) {
            return;
        }
        getAttributes().put(CustomResponse, responseData.getBody());
    }

    protected boolean getAllowDoubleReceive() {
        return this.allowDoubleReceive;
    }

    static /* synthetic */ Object getResponseContent$suspendImpl(HttpClientCall httpClientCall, Continuation<? super ByteReadChannel> continuation) {
        return httpClientCall.getResponse().getContent();
    }

    /* JADX WARN: Code restructure failed: missing block: B:64:0x009a, code lost:
    
        if (r7 == r1) goto L45;
     */
    /* JADX WARN: Removed duplicated region for block: B:15:0x00c5  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00c6  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object bodyNullable(TypeInfo typeInfo, Continuation<Object> continuation) {
        HttpClientCall$bodyNullable$1 httpClientCall$bodyNullable$1;
        Object obj;
        Object coroutine_suspended;
        int i;
        HttpClientCall httpClientCall;
        HttpClientCall httpClientCall2;
        Object response;
        if (continuation instanceof HttpClientCall$bodyNullable$1) {
            httpClientCall$bodyNullable$1 = (HttpClientCall$bodyNullable$1) continuation;
            if ((httpClientCall$bodyNullable$1.label & Integer.MIN_VALUE) != 0) {
                httpClientCall$bodyNullable$1.label -= Integer.MIN_VALUE;
                obj = httpClientCall$bodyNullable$1.result;
                coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = httpClientCall$bodyNullable$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    try {
                        if (!TypeInfoJvmKt.instanceOf(getResponse(), typeInfo.getType())) {
                            if (!getAllowDoubleReceive() && !received$FU.compareAndSet(this, 0, 1)) {
                                throw new DoubleReceiveException(this);
                            }
                            obj = getAttributes().getOrNull(CustomResponse);
                            if (obj == null) {
                                httpClientCall$bodyNullable$1.L$0 = this;
                                httpClientCall$bodyNullable$1.L$1 = typeInfo;
                                httpClientCall$bodyNullable$1.label = 1;
                                obj = getResponseContent(httpClientCall$bodyNullable$1);
                            }
                            httpClientCall2 = this;
                        } else {
                            HttpResponse response2 = getResponse();
                            HttpResponseKt.complete(getResponse());
                            return response2;
                        }
                    } catch (Throwable th) {
                        th = th;
                        httpClientCall = this;
                        CoroutineScopeKt.cancel(httpClientCall.getResponse(), "Receive failed", th);
                        throw th;
                    }
                } else {
                    if (i != 1) {
                        if (i != 2) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        typeInfo = (TypeInfo) httpClientCall$bodyNullable$1.L$1;
                        httpClientCall = (HttpClientCall) httpClientCall$bodyNullable$1.L$0;
                        try {
                            ResultKt.throwOnFailure(obj);
                            response = ((HttpResponseContainer) obj).getResponse();
                            if (!Intrinsics.areEqual(response, NullBody.INSTANCE)) {
                                response = null;
                            }
                            if (response != null && !TypeInfoJvmKt.instanceOf(response, typeInfo.getType())) {
                                throw new NoTransformationFoundException(httpClientCall.getResponse(), Reflection.getOrCreateKotlinClass(response.getClass()), typeInfo.getType());
                            }
                            return response;
                        } catch (Throwable th2) {
                            th = th2;
                            try {
                                CoroutineScopeKt.cancel(httpClientCall.getResponse(), "Receive failed", th);
                                throw th;
                            } finally {
                                HttpResponseKt.complete(httpClientCall.getResponse());
                            }
                        }
                    }
                    typeInfo = (TypeInfo) httpClientCall$bodyNullable$1.L$1;
                    httpClientCall2 = (HttpClientCall) httpClientCall$bodyNullable$1.L$0;
                    try {
                        ResultKt.throwOnFailure(obj);
                    } catch (Throwable th3) {
                        th = th3;
                        httpClientCall = httpClientCall2;
                        CoroutineScopeKt.cancel(httpClientCall.getResponse(), "Receive failed", th);
                        throw th;
                    }
                }
                HttpResponseContainer httpResponseContainer = new HttpResponseContainer(typeInfo, obj);
                HttpResponsePipeline responsePipeline = httpClientCall2.client.getResponsePipeline();
                httpClientCall$bodyNullable$1.L$0 = httpClientCall2;
                httpClientCall$bodyNullable$1.L$1 = typeInfo;
                httpClientCall$bodyNullable$1.label = 2;
                obj = responsePipeline.execute(httpClientCall2, httpResponseContainer, httpClientCall$bodyNullable$1);
                if (obj != coroutine_suspended) {
                    httpClientCall = httpClientCall2;
                    response = ((HttpResponseContainer) obj).getResponse();
                    if (!Intrinsics.areEqual(response, NullBody.INSTANCE)) {
                    }
                    if (response != null) {
                        throw new NoTransformationFoundException(httpClientCall.getResponse(), Reflection.getOrCreateKotlinClass(response.getClass()), typeInfo.getType());
                    }
                    return response;
                }
                return coroutine_suspended;
            }
        }
        httpClientCall$bodyNullable$1 = new HttpClientCall$bodyNullable$1(this, continuation);
        obj = httpClientCall$bodyNullable$1.result;
        coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = httpClientCall$bodyNullable$1.label;
        if (i != 0) {
        }
        HttpResponseContainer httpResponseContainer2 = new HttpResponseContainer(typeInfo, obj);
        HttpResponsePipeline responsePipeline2 = httpClientCall2.client.getResponsePipeline();
        httpClientCall$bodyNullable$1.L$0 = httpClientCall2;
        httpClientCall$bodyNullable$1.L$1 = typeInfo;
        httpClientCall$bodyNullable$1.label = 2;
        obj = responsePipeline2.execute(httpClientCall2, httpResponseContainer2, httpClientCall$bodyNullable$1);
        if (obj != coroutine_suspended) {
        }
        return coroutine_suspended;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object body(TypeInfo typeInfo, Continuation<Object> continuation) {
        HttpClientCall$body$1 httpClientCall$body$1;
        int i;
        if (continuation instanceof HttpClientCall$body$1) {
            httpClientCall$body$1 = (HttpClientCall$body$1) continuation;
            if ((httpClientCall$body$1.label & Integer.MIN_VALUE) != 0) {
                httpClientCall$body$1.label -= Integer.MIN_VALUE;
                Object obj = httpClientCall$body$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = httpClientCall$body$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    httpClientCall$body$1.label = 1;
                    obj = bodyNullable(typeInfo, httpClientCall$body$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                Intrinsics.checkNotNull(obj);
                return obj;
            }
        }
        httpClientCall$body$1 = new HttpClientCall$body$1(this, continuation);
        Object obj2 = httpClientCall$body$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = httpClientCall$body$1.label;
        if (i != 0) {
        }
        Intrinsics.checkNotNull(obj2);
        return obj2;
    }

    public String toString() {
        return "HttpClientCall[" + getRequest().getUrl() + ", " + getResponse().getStatus() + AbstractJsonLexerKt.END_LIST;
    }

    public final void setResponse$ktor_client_core(HttpResponse response) {
        Intrinsics.checkNotNullParameter(response, "response");
        setResponse(response);
    }

    public final void setRequest$ktor_client_core(HttpRequest request) {
        Intrinsics.checkNotNullParameter(request, "request");
        setRequest(request);
    }

    /* compiled from: HttpClientCall.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\"\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00010\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0005\u0010\u0002\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lio/ktor/client/call/HttpClientCall$Companion;", "", "()V", "CustomResponse", "Lio/ktor/util/AttributeKey;", "getCustomResponse$annotations", "getCustomResponse", "()Lio/ktor/util/AttributeKey;", "ktor-client-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Deprecated(level = DeprecationLevel.ERROR, message = "This is going to be removed. Please file a ticket with clarification why and what for do you need it.")
        public static /* synthetic */ void getCustomResponse$annotations() {
        }

        private Companion() {
        }

        public final AttributeKey<Object> getCustomResponse() {
            return HttpClientCall.CustomResponse;
        }
    }
}
