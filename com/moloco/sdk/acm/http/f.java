package com.moloco.sdk.acm.http;

import com.moloco.sdk.MetricsRequest;
import com.vungle.ads.internal.protos.Sdk;
import io.ktor.client.HttpClient;
import io.ktor.client.plugins.HttpTimeout;
import io.ktor.client.plugins.HttpTimeoutKt;
import io.ktor.client.request.HttpRequestBuilder;
import io.ktor.client.request.HttpRequestKt;
import io.ktor.client.statement.HttpResponse;
import io.ktor.client.statement.HttpResponseKt;
import io.ktor.client.statement.HttpStatement;
import io.ktor.http.ContentType;
import io.ktor.http.HeadersBuilder;
import io.ktor.http.HttpMessagePropertiesKt;
import io.ktor.http.HttpMethod;
import io.ktor.http.HttpStatusCode;
import io.ktor.http.content.NullBody;
import io.ktor.http.content.OutgoingContent;
import io.ktor.util.reflect.TypeInfoJvmKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KType;
import kotlin.reflect.TypesJVMKt;

/* loaded from: classes6.dex */
public final class f implements e {

    /* renamed from: a, reason: collision with root package name */
    public final HttpClient f5348a;
    public final String b;
    public final String c;

    @DebugMetadata(c = "com.moloco.sdk.acm.http.PostMetricsRequestImpl", f = "PostMetricsRequest.kt", i = {}, l = {54}, m = "execute-0E7RQCE", n = {}, s = {})
    public static final class a extends ContinuationImpl {

        /* renamed from: a, reason: collision with root package name */
        public /* synthetic */ Object f5349a;
        public int c;

        public a(Continuation<? super a> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.f5349a = obj;
            this.c |= Integer.MIN_VALUE;
            Object a2 = f.this.a(null, null, this);
            return a2 == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? a2 : Result.m10240boximpl(a2);
        }
    }

    @DebugMetadata(c = "com.moloco.sdk.acm.http.PostMetricsRequestImpl", f = "PostMetricsRequest.kt", i = {0, 1, 1}, l = {Sdk.SDKError.Reason.OMSDK_JS_WRITE_FAILED_VALUE, 82}, m = "makeMetricsRequest-BWLJW6A", n = {"this", "this", "responseStatus"}, s = {"L$0", "L$0", "L$1"})
    public static final class b extends ContinuationImpl {

        /* renamed from: a, reason: collision with root package name */
        public Object f5350a;
        public Object b;
        public /* synthetic */ Object c;
        public int e;

        public b(Continuation<? super b> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.c = obj;
            this.e |= Integer.MIN_VALUE;
            Object a2 = f.this.a(0L, null, null, this);
            return a2 == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? a2 : Result.m10240boximpl(a2);
        }
    }

    public f(HttpClient httpClient, String apiUrl) {
        Intrinsics.checkNotNullParameter(httpClient, "httpClient");
        Intrinsics.checkNotNullParameter(apiUrl, "apiUrl");
        this.f5348a = httpClient;
        this.b = apiUrl;
        this.c = "PostMetricsRequest";
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0038  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    @Override // com.moloco.sdk.acm.http.e
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object a(d dVar, Function1<? super HeadersBuilder, Unit> function1, Continuation<? super Result<String>> continuation) {
        a aVar;
        int i;
        if (continuation instanceof a) {
            aVar = (a) continuation;
            int i2 = aVar.c;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                aVar.c = i2 - Integer.MIN_VALUE;
                a aVar2 = aVar;
                Object obj = aVar2.f5349a;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = aVar2.c;
                if (i == 0) {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                    return ((Result) obj).getValue();
                }
                ResultKt.throwOnFailure(obj);
                aVar2.c = 1;
                Object a2 = a(5000L, dVar, function1, aVar2);
                return a2 == coroutine_suspended ? coroutine_suspended : a2;
            }
        }
        aVar = new a(continuation);
        a aVar22 = aVar;
        Object obj2 = aVar22.f5349a;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = aVar22.c;
        if (i == 0) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x00fc A[Catch: Exception -> 0x003e, TryCatch #1 {Exception -> 0x003e, blocks: (B:12:0x0039, B:13:0x00ee, B:15:0x00fc, B:18:0x011a), top: B:11:0x0039 }] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x011a A[Catch: Exception -> 0x003e, TRY_LEAVE, TryCatch #1 {Exception -> 0x003e, blocks: (B:12:0x0039, B:13:0x00ee, B:15:0x00fc, B:18:0x011a), top: B:11:0x0039 }] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00ec  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object a(final long j, d dVar, Function1<? super HeadersBuilder, Unit> function1, Continuation<? super Result<String>> continuation) {
        b bVar;
        Object obj;
        Object coroutine_suspended;
        int i;
        f fVar;
        f fVar2;
        HttpStatusCode httpStatusCode;
        if (continuation instanceof b) {
            bVar = (b) continuation;
            int i2 = bVar.e;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                bVar.e = i2 - Integer.MIN_VALUE;
                obj = bVar.c;
                coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = bVar.e;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    try {
                        HttpClient httpClient = this.f5348a;
                        String str = this.b;
                        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
                        HttpRequestKt.url(httpRequestBuilder, str);
                        HttpTimeoutKt.timeout(httpRequestBuilder, new Function1() { // from class: com.moloco.sdk.acm.http.f$$ExternalSyntheticLambda0
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj2) {
                                return f.a(j, (HttpTimeout.HttpTimeoutCapabilityConfiguration) obj2);
                            }
                        });
                        HttpMessagePropertiesKt.contentType(httpRequestBuilder, ContentType.Application.INSTANCE.getProtoBuf());
                        HttpRequestKt.headers(httpRequestBuilder, function1);
                        byte[] a2 = a(dVar);
                        if (a2 == null) {
                            httpRequestBuilder.setBody(NullBody.INSTANCE);
                            KType typeOf = Reflection.typeOf(byte[].class);
                            httpRequestBuilder.setBodyType(TypeInfoJvmKt.typeInfoImpl(TypesJVMKt.getJavaType(typeOf), Reflection.getOrCreateKotlinClass(byte[].class), typeOf));
                        } else if (a2 instanceof OutgoingContent) {
                            httpRequestBuilder.setBody(a2);
                            httpRequestBuilder.setBodyType(null);
                        } else {
                            httpRequestBuilder.setBody(a2);
                            KType typeOf2 = Reflection.typeOf(byte[].class);
                            httpRequestBuilder.setBodyType(TypeInfoJvmKt.typeInfoImpl(TypesJVMKt.getJavaType(typeOf2), Reflection.getOrCreateKotlinClass(byte[].class), typeOf2));
                        }
                        httpRequestBuilder.setMethod(HttpMethod.INSTANCE.getPost());
                        HttpStatement httpStatement = new HttpStatement(httpRequestBuilder, httpClient);
                        bVar.f5350a = this;
                        bVar.e = 1;
                        obj = httpStatement.execute(bVar);
                        if (obj != coroutine_suspended) {
                            fVar = this;
                        }
                        return coroutine_suspended;
                    } catch (Exception e) {
                        e = e;
                        fVar = this;
                        fVar2 = fVar;
                        Exception exc = e;
                        com.moloco.sdk.acm.services.e.a(com.moloco.sdk.acm.services.e.f5359a, fVar2.c, "Post Metrics Request Exception", exc, false, 8, null);
                        Result.Companion companion = Result.INSTANCE;
                        return Result.m10241constructorimpl(ResultKt.createFailure(exc));
                    }
                }
                if (i != 1) {
                    if (i != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    httpStatusCode = (HttpStatusCode) bVar.b;
                    fVar2 = (f) bVar.f5350a;
                    try {
                        ResultKt.throwOnFailure(obj);
                        String str2 = (String) obj;
                        if (!Intrinsics.areEqual(httpStatusCode, HttpStatusCode.INSTANCE.getOK())) {
                            com.moloco.sdk.acm.services.e.b(com.moloco.sdk.acm.services.e.f5359a, fVar2.c, "Post Metrics Request Success: " + str2, false, 4, null);
                            Result.Companion companion2 = Result.INSTANCE;
                            return Result.m10241constructorimpl(str2);
                        }
                        com.moloco.sdk.acm.services.e.a(com.moloco.sdk.acm.services.e.f5359a, fVar2.c, "Post Metrics Request Error: " + str2, null, false, 12, null);
                        Result.Companion companion3 = Result.INSTANCE;
                        return Result.m10241constructorimpl(ResultKt.createFailure(new Exception("PostMetricsRequest Error: " + httpStatusCode)));
                    } catch (Exception e2) {
                        e = e2;
                        Exception exc2 = e;
                        com.moloco.sdk.acm.services.e.a(com.moloco.sdk.acm.services.e.f5359a, fVar2.c, "Post Metrics Request Exception", exc2, false, 8, null);
                        Result.Companion companion4 = Result.INSTANCE;
                        return Result.m10241constructorimpl(ResultKt.createFailure(exc2));
                    }
                }
                fVar = (f) bVar.f5350a;
                try {
                    ResultKt.throwOnFailure(obj);
                } catch (Exception e3) {
                    e = e3;
                    fVar2 = fVar;
                    Exception exc22 = e;
                    com.moloco.sdk.acm.services.e.a(com.moloco.sdk.acm.services.e.f5359a, fVar2.c, "Post Metrics Request Exception", exc22, false, 8, null);
                    Result.Companion companion42 = Result.INSTANCE;
                    return Result.m10241constructorimpl(ResultKt.createFailure(exc22));
                }
                HttpResponse httpResponse = (HttpResponse) obj;
                HttpStatusCode status = httpResponse.getStatus();
                bVar.f5350a = fVar;
                bVar.b = status;
                bVar.e = 2;
                obj = HttpResponseKt.bodyAsText$default(httpResponse, null, bVar, 1, null);
                if (obj != coroutine_suspended) {
                    fVar2 = fVar;
                    httpStatusCode = status;
                    String str22 = (String) obj;
                    if (!Intrinsics.areEqual(httpStatusCode, HttpStatusCode.INSTANCE.getOK())) {
                    }
                }
                return coroutine_suspended;
            }
        }
        bVar = new b(continuation);
        obj = bVar.c;
        coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = bVar.e;
        if (i != 0) {
        }
        HttpResponse httpResponse2 = (HttpResponse) obj;
        HttpStatusCode status2 = httpResponse2.getStatus();
        bVar.f5350a = fVar;
        bVar.b = status2;
        bVar.e = 2;
        obj = HttpResponseKt.bodyAsText$default(httpResponse2, null, bVar, 1, null);
        if (obj != coroutine_suspended) {
        }
        return coroutine_suspended;
    }

    public static final Unit a(long j, HttpTimeout.HttpTimeoutCapabilityConfiguration timeout) {
        Intrinsics.checkNotNullParameter(timeout, "$this$timeout");
        timeout.setRequestTimeoutMillis(Long.valueOf(j));
        return Unit.INSTANCE;
    }

    public final byte[] a(d dVar) {
        MetricsRequest.PostMetricsRequest build = MetricsRequest.PostMetricsRequest.newBuilder().addAllCounts(dVar.a()).addAllDurations(dVar.b()).build();
        Intrinsics.checkNotNullExpressionValue(build, "build(...)");
        byte[] byteArray = build.toByteArray();
        Intrinsics.checkNotNullExpressionValue(byteArray, "toByteArray(...)");
        return byteArray;
    }
}
