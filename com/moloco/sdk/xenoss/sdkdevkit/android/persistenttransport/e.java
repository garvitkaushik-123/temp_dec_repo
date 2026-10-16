package com.moloco.sdk.xenoss.sdkdevkit.android.persistenttransport;

import android.util.Patterns;
import com.fyber.inneractive.sdk.bidder.TokenParametersOuterClass$TokenParameters;
import com.moloco.sdk.internal.MolocoLogger;
import com.moloco.sdk.xenoss.sdkdevkit.android.persistenttransport.e;
import io.ktor.client.HttpClient;
import io.ktor.client.request.HttpRequestBuilder;
import io.ktor.client.request.HttpRequestKt;
import io.ktor.client.statement.HttpResponse;
import io.ktor.client.statement.HttpStatement;
import io.ktor.http.ContentType;
import io.ktor.http.HeadersBuilder;
import io.ktor.http.HttpHeaders;
import io.ktor.http.HttpMessagePropertiesKt;
import io.ktor.http.HttpMethod;
import io.ktor.http.HttpStatusCode;
import io.ktor.http.content.NullBody;
import io.ktor.http.content.OutgoingContent;
import io.ktor.util.reflect.TypeInfoJvmKt;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KType;
import kotlin.reflect.TypesJVMKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;

/* loaded from: classes6.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    public static final String f6364a = "HttpRequestClient";
    public static final long b = 5000;
    public static final int c = 5;

    @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.persistenttransport.HttpRequestClientKt", f = "HttpRequestClient.kt", i = {}, l = {36}, m = "sendGetRequest", n = {}, s = {})
    public static final class a extends ContinuationImpl {

        /* renamed from: a, reason: collision with root package name */
        public /* synthetic */ Object f6365a;
        public int b;

        public a(Continuation<? super a> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.f6365a = obj;
            this.b |= Integer.MIN_VALUE;
            return e.a(null, null, this);
        }
    }

    @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.persistenttransport.HttpRequestClientKt$sendGetRequest$2", f = "HttpRequestClient.kt", i = {}, l = {TokenParametersOuterClass$TokenParameters.MEDIAMUTED_FIELD_NUMBER}, m = "invokeSuspend", n = {}, s = {})
    public static final class b extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {

        /* renamed from: a, reason: collision with root package name */
        public int f6366a;
        public final /* synthetic */ HttpClient b;
        public final /* synthetic */ String c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(HttpClient httpClient, String str, Continuation<? super b> continuation) {
            super(2, continuation);
            this.b = httpClient;
            this.c = str;
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Boolean> continuation) {
            return ((b) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new b(this.b, this.c, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.f6366a;
            boolean z = true;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                HttpClient httpClient = this.b;
                String str = this.c;
                HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
                HttpRequestKt.url(httpRequestBuilder, str);
                com.moloco.sdk.xenoss.sdkdevkit.android.core.a.a(httpRequestBuilder, 5000L);
                httpRequestBuilder.setMethod(HttpMethod.INSTANCE.getGet());
                HttpStatement httpStatement = new HttpStatement(httpRequestBuilder, httpClient);
                this.f6366a = 1;
                obj = httpStatement.execute(this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            HttpStatusCode status = ((HttpResponse) obj).getStatus();
            HttpStatusCode.Companion companion = HttpStatusCode.INSTANCE;
            if (!Intrinsics.areEqual(status, companion.getOK()) && !Intrinsics.areEqual(status, companion.getNoContent())) {
                z = false;
            }
            return Boxing.boxBoolean(z);
        }
    }

    @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.persistenttransport.HttpRequestClientKt", f = "HttpRequestClient.kt", i = {}, l = {48}, m = "sendPostRequest", n = {}, s = {})
    public static final class c extends ContinuationImpl {

        /* renamed from: a, reason: collision with root package name */
        public /* synthetic */ Object f6367a;
        public int b;

        public c(Continuation<? super c> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.f6367a = obj;
            this.b |= Integer.MIN_VALUE;
            return e.a(null, null, null, null, null, this);
        }
    }

    @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.persistenttransport.HttpRequestClientKt$sendPostRequest$2", f = "HttpRequestClient.kt", i = {}, l = {89}, m = "invokeSuspend", n = {}, s = {})
    public static final class d extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {

        /* renamed from: a, reason: collision with root package name */
        public int f6368a;
        public final /* synthetic */ HttpClient b;
        public final /* synthetic */ String c;
        public final /* synthetic */ String d;
        public final /* synthetic */ byte[] e;
        public final /* synthetic */ ContentType f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(HttpClient httpClient, String str, String str2, byte[] bArr, ContentType contentType, Continuation<? super d> continuation) {
            super(2, continuation);
            this.b = httpClient;
            this.c = str;
            this.d = str2;
            this.e = bArr;
            this.f = contentType;
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Boolean> continuation) {
            return ((d) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new d(this.b, this.c, this.d, this.e, this.f, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.f6368a;
            boolean z = true;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                HttpClient httpClient = this.b;
                String str = this.c;
                final String str2 = this.d;
                byte[] bArr = this.e;
                ContentType contentType = this.f;
                HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
                HttpRequestKt.url(httpRequestBuilder, str);
                if (str2 != null && (!StringsKt.isBlank(str2))) {
                    HttpRequestKt.headers(httpRequestBuilder, new Function1() { // from class: com.moloco.sdk.xenoss.sdkdevkit.android.persistenttransport.e$d$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj2) {
                            return e.d.a(str2, (HeadersBuilder) obj2);
                        }
                    });
                }
                if (bArr == null) {
                    httpRequestBuilder.setBody(NullBody.INSTANCE);
                    KType typeOf = Reflection.typeOf(byte[].class);
                    httpRequestBuilder.setBodyType(TypeInfoJvmKt.typeInfoImpl(TypesJVMKt.getJavaType(typeOf), Reflection.getOrCreateKotlinClass(byte[].class), typeOf));
                } else if (bArr instanceof OutgoingContent) {
                    httpRequestBuilder.setBody(bArr);
                    httpRequestBuilder.setBodyType(null);
                } else {
                    httpRequestBuilder.setBody(bArr);
                    KType typeOf2 = Reflection.typeOf(byte[].class);
                    httpRequestBuilder.setBodyType(TypeInfoJvmKt.typeInfoImpl(TypesJVMKt.getJavaType(typeOf2), Reflection.getOrCreateKotlinClass(byte[].class), typeOf2));
                }
                HttpMessagePropertiesKt.contentType(httpRequestBuilder, contentType);
                com.moloco.sdk.xenoss.sdkdevkit.android.core.a.a(httpRequestBuilder, 5000L);
                httpRequestBuilder.setMethod(HttpMethod.INSTANCE.getPost());
                HttpStatement httpStatement = new HttpStatement(httpRequestBuilder, httpClient);
                this.f6368a = 1;
                obj = httpStatement.execute(this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            HttpStatusCode status = ((HttpResponse) obj).getStatus();
            MolocoLogger.debugBuildLog$default(MolocoLogger.INSTANCE, "HttpClient", "Response status: " + status + " for url: " + this.c, false, 4, null);
            HttpStatusCode.Companion companion = HttpStatusCode.INSTANCE;
            if (!Intrinsics.areEqual(status, companion.getOK()) && !Intrinsics.areEqual(status, companion.getNoContent())) {
                z = false;
            }
            return Boxing.boxBoolean(z);
        }

        public static final Unit a(String str, HeadersBuilder headersBuilder) {
            headersBuilder.append(HttpHeaders.INSTANCE.getContentEncoding(), str);
            return Unit.INSTANCE;
        }
    }

    public static final boolean a(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        boolean matches = Patterns.WEB_URL.matcher(str).matches();
        if (!matches) {
            MolocoLogger.error$default(MolocoLogger.INSTANCE, f6364a, "URL is invalid. " + str, null, false, 12, null);
        }
        return matches;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(10:0|1|(2:3|(7:5|6|7|(1:(1:10)(2:16|17))(3:18|19|(1:21))|11|12|13))|23|6|7|(0)(0)|11|12|13) */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0052, code lost:
    
        r5 = false;
     */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object a(HttpClient httpClient, String str, Continuation<? super Boolean> continuation) {
        a aVar;
        int i;
        if (continuation instanceof a) {
            aVar = (a) continuation;
            int i2 = aVar.b;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                aVar.b = i2 - Integer.MIN_VALUE;
                Object obj = aVar.f6365a;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = aVar.b;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    CoroutineContext io2 = com.moloco.sdk.internal.scheduling.b.a().getIo();
                    b bVar = new b(httpClient, str, null);
                    aVar.b = 1;
                    obj = BuildersKt.withContext(io2, bVar, aVar);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                boolean z = ((Boolean) obj).booleanValue();
                return Boxing.boxBoolean(z);
            }
        }
        aVar = new a(continuation);
        Object obj2 = aVar.f6365a;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = aVar.b;
        if (i != 0) {
        }
        boolean z2 = ((Boolean) obj2).booleanValue();
        return Boxing.boxBoolean(z2);
    }

    /* JADX WARN: Can't wrap try/catch for region: R(10:0|1|(2:3|(7:5|6|7|(1:(1:10)(2:16|17))(3:18|19|(1:21))|11|12|13))|23|6|7|(0)(0)|11|12|13) */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x005a, code lost:
    
        r12 = false;
     */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0025  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object a(HttpClient httpClient, String str, byte[] bArr, ContentType contentType, String str2, Continuation<? super Boolean> continuation) {
        c cVar;
        int i;
        if (continuation instanceof c) {
            cVar = (c) continuation;
            int i2 = cVar.b;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                cVar.b = i2 - Integer.MIN_VALUE;
                Object obj = cVar.f6367a;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = cVar.b;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    CoroutineContext io2 = com.moloco.sdk.internal.scheduling.b.a().getIo();
                    d dVar = new d(httpClient, str, str2, bArr, contentType, null);
                    cVar.b = 1;
                    obj = BuildersKt.withContext(io2, dVar, cVar);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                boolean z = ((Boolean) obj).booleanValue();
                return Boxing.boxBoolean(z);
            }
        }
        cVar = new c(continuation);
        Object obj2 = cVar.f6367a;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = cVar.b;
        if (i != 0) {
        }
        boolean z2 = ((Boolean) obj2).booleanValue();
        return Boxing.boxBoolean(z2);
    }

    public static /* synthetic */ Object a(HttpClient httpClient, String str, byte[] bArr, ContentType contentType, String str2, Continuation continuation, int i, Object obj) {
        if ((i & 8) != 0) {
            str2 = null;
        }
        return a(httpClient, str, bArr, contentType, str2, continuation);
    }
}
