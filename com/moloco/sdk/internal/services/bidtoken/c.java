package com.moloco.sdk.internal.services.bidtoken;

import adn.analytics.Analytics;
import com.google.protobuf.InvalidProtocolBufferException;
import com.moloco.sdk.BidToken;
import com.moloco.sdk.acm.CountEvent;
import com.moloco.sdk.acm.TimerEvent;
import com.moloco.sdk.acm.recorder.MetricsRecorder;
import com.moloco.sdk.internal.MolocoLogger;
import com.moloco.sdk.internal.v;
import com.moloco.sdk.publisher.MolocoAdError;
import io.adn.sdk.internal.domain.constants.AnalyticsConstants;
import io.ktor.client.HttpClient;
import io.ktor.client.call.HttpClientCall;
import io.ktor.client.plugins.HttpRequestTimeoutException;
import io.ktor.client.request.HttpRequestBuilder;
import io.ktor.client.request.HttpRequestKt;
import io.ktor.client.statement.HttpResponse;
import io.ktor.client.statement.HttpStatement;
import io.ktor.http.ContentType;
import io.ktor.http.HeadersBuilder;
import io.ktor.http.HttpMessagePropertiesKt;
import io.ktor.http.HttpMethod;
import io.ktor.http.HttpStatusCode;
import io.ktor.http.content.NullBody;
import io.ktor.http.content.OutgoingContent;
import io.ktor.util.reflect.TypeInfo;
import io.ktor.util.reflect.TypeInfoJvmKt;
import java.net.UnknownHostException;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KType;
import kotlin.reflect.TypesJVMKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;

/* loaded from: classes6.dex */
public final class c implements InterfaceC3437a {
    public static final int f = 8;

    /* renamed from: a, reason: collision with root package name */
    public final String f5627a;
    public final HttpClient b;
    public final j c;
    public final g d;
    public final String e;

    @DebugMetadata(c = "com.moloco.sdk.internal.services.bidtoken.BidTokenApiImpl$fetchBidToken$2", f = "BidTokenApi.kt", i = {0, 0, 0, 1}, l = {Analytics.AnalyticsData.BOOT_TIME_FIELD_NUMBER, 127}, m = "invokeSuspend", n = {"lastResult", "serverBidTokenApiTimer", "attempt", "lastResult"}, s = {"L$0", "L$3", "I$2", "L$0"})
    public static final class a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super com.moloco.sdk.internal.v<k, com.moloco.sdk.internal.m>>, Object> {

        /* renamed from: a, reason: collision with root package name */
        public Object f5628a;
        public Object b;
        public Object c;
        public Object d;
        public int e;
        public int f;
        public int g;
        public int h;
        public final /* synthetic */ MetricsRecorder j;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(MetricsRecorder metricsRecorder, Continuation<? super a> continuation) {
            super(2, continuation);
            this.j = metricsRecorder;
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super com.moloco.sdk.internal.v<k, com.moloco.sdk.internal.m>> continuation) {
            return ((a) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return c.this.new a(this.j, continuation);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:13:0x00f6  */
        /* JADX WARN: Removed duplicated region for block: B:25:0x01f7  */
        /* JADX WARN: Removed duplicated region for block: B:32:0x0243  */
        /* JADX WARN: Removed duplicated region for block: B:8:0x008c  */
        /* JADX WARN: Type inference failed for: r10v1, types: [T, com.moloco.sdk.internal.v, java.lang.Object] */
        /* JADX WARN: Type inference failed for: r5v0, types: [T, com.moloco.sdk.internal.v$a] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:24:0x01ee -> B:6:0x01f0). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            Ref.ObjectRef objectRef;
            int i;
            MetricsRecorder metricsRecorder;
            c cVar;
            int i2;
            Ref.ObjectRef objectRef2;
            Object obj2;
            TimerEvent timerEvent;
            int i3;
            ?? r10;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i4 = this.h;
            int i5 = 1;
            if (i4 == 0) {
                ResultKt.throwOnFailure(obj);
                Ref.ObjectRef objectRef3 = new Ref.ObjectRef();
                objectRef3.element = new v.a(new com.moloco.sdk.internal.m("retry max parameter is 0", MolocoAdError.ErrorType.UNKNOWN.getErrorCode()));
                int e = c.this.c.e();
                c cVar2 = c.this;
                objectRef = objectRef3;
                i = 0;
                metricsRecorder = this.j;
                cVar = cVar2;
                i2 = e;
                if (i < i2) {
                }
            } else if (i4 == 1) {
                i = this.g;
                i3 = this.f;
                i2 = this.e;
                TimerEvent timerEvent2 = (TimerEvent) this.d;
                metricsRecorder = (MetricsRecorder) this.c;
                c cVar3 = (c) this.b;
                Ref.ObjectRef objectRef4 = (Ref.ObjectRef) this.f5628a;
                ResultKt.throwOnFailure(obj);
                timerEvent = timerEvent2;
                cVar = cVar3;
                objectRef2 = objectRef4;
                obj2 = obj;
                r10 = (com.moloco.sdk.internal.v) obj2;
                objectRef2.element = r10;
                MolocoLogger molocoLogger = MolocoLogger.INSTANCE;
                MolocoLogger.info$default(molocoLogger, cVar.e, "Received bidtoken fetch result: " + ((Object) r10), null, false, 12, null);
                if (r10 instanceof v.a) {
                }
            } else {
                if (i4 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                int i6 = this.f;
                int i7 = this.e;
                MetricsRecorder metricsRecorder2 = (MetricsRecorder) this.c;
                cVar = (c) this.b;
                Ref.ObjectRef objectRef5 = (Ref.ObjectRef) this.f5628a;
                ResultKt.throwOnFailure(obj);
                i2 = i7;
                objectRef = objectRef5;
                metricsRecorder = metricsRecorder2;
                int i8 = 1;
                char c = 2;
                i = i6 + 1;
                i5 = i8;
                if (i < i2) {
                    MolocoLogger.info$default(MolocoLogger.INSTANCE, cVar.e, "Fetching bidtoken, attempt #" + i, null, false, 12, null);
                    timerEvent = metricsRecorder.startTimerEvent(com.moloco.sdk.internal.client_metrics_data.d.n.c());
                    this.f5628a = objectRef;
                    this.b = cVar;
                    this.c = metricsRecorder;
                    this.d = timerEvent;
                    this.e = i2;
                    this.f = i;
                    this.g = i;
                    this.h = i5;
                    obj2 = cVar.a(d.f5630a, this);
                    if (obj2 != coroutine_suspended) {
                        objectRef2 = objectRef;
                        i3 = i;
                        r10 = (com.moloco.sdk.internal.v) obj2;
                        objectRef2.element = r10;
                        MolocoLogger molocoLogger2 = MolocoLogger.INSTANCE;
                        MolocoLogger.info$default(molocoLogger2, cVar.e, "Received bidtoken fetch result: " + ((Object) r10), null, false, 12, null);
                        if (r10 instanceof v.a) {
                            int i9 = i;
                            if (!(r10 instanceof v.b)) {
                                throw new NoWhenBranchMatchedException();
                            }
                            com.moloco.sdk.internal.client_metrics_data.c cVar4 = com.moloco.sdk.internal.client_metrics_data.c.d;
                            TimerEvent withTag = timerEvent.withTag(cVar4.c(), "success");
                            com.moloco.sdk.internal.client_metrics_data.c cVar5 = com.moloco.sdk.internal.client_metrics_data.c.f;
                            metricsRecorder.recordTimerEvent(withTag.withTag(cVar5.c(), String.valueOf(i9)));
                            metricsRecorder.recordCountEvent(new CountEvent(com.moloco.sdk.internal.client_metrics_data.a.v.c()).withTag(cVar4.c(), "success").withTag(cVar5.c(), String.valueOf(i9)));
                            return r10;
                        }
                        int b = ((com.moloco.sdk.internal.m) ((v.a) r10).a()).b();
                        com.moloco.sdk.internal.client_metrics_data.c cVar6 = com.moloco.sdk.internal.client_metrics_data.c.d;
                        i8 = i5;
                        TimerEvent withTag2 = timerEvent.withTag(cVar6.c(), AnalyticsConstants.EVENT_FAILURE);
                        com.moloco.sdk.internal.client_metrics_data.c cVar7 = com.moloco.sdk.internal.client_metrics_data.c.b;
                        int i10 = i;
                        TimerEvent withTag3 = withTag2.withTag(cVar7.c(), String.valueOf(b));
                        com.moloco.sdk.internal.client_metrics_data.c cVar8 = com.moloco.sdk.internal.client_metrics_data.c.f;
                        metricsRecorder.recordTimerEvent(withTag3.withTag(cVar8.c(), String.valueOf(i10)));
                        metricsRecorder.recordCountEvent(new CountEvent(com.moloco.sdk.internal.client_metrics_data.a.v.c()).withTag(cVar6.c(), AnalyticsConstants.EVENT_FAILURE).withTag(cVar7.c(), String.valueOf(b)).withTag(cVar8.c(), String.valueOf(i10)));
                        if (400 <= b && b < 500 && b != 429) {
                            MolocoLogger.info$default(molocoLogger2, cVar.e, "Received 4xx error: " + b, null, false, 12, null);
                            return r10;
                        }
                        MolocoLogger.info$default(molocoLogger2, cVar.e, "Received non-4xx or " + b + " error: " + b, null, false, 12, null);
                        long d = cVar.c.d() * (i10 + 1);
                        MolocoLogger.info$default(molocoLogger2, cVar.e, "Retrying after delay: " + d, null, false, 12, null);
                        this.f5628a = objectRef2;
                        this.b = cVar;
                        this.c = metricsRecorder;
                        this.d = null;
                        this.e = i2;
                        this.f = i3;
                        c = 2;
                        this.h = 2;
                        if (DelayKt.delay(d, this) != coroutine_suspended) {
                            i6 = i3;
                            objectRef = objectRef2;
                            i = i6 + 1;
                            i5 = i8;
                            if (i < i2) {
                                return objectRef.element;
                            }
                        }
                    }
                    return coroutine_suspended;
                }
            }
        }
    }

    @DebugMetadata(c = "com.moloco.sdk.internal.services.bidtoken.BidTokenApiImpl", f = "BidTokenApi.kt", i = {0}, l = {197, 198}, m = "fetchBidTokenWork", n = {"this"}, s = {"L$0"})
    public static final class b extends ContinuationImpl {

        /* renamed from: a, reason: collision with root package name */
        public Object f5629a;
        public /* synthetic */ Object b;
        public int d;

        public b(Continuation<? super b> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.b = obj;
            this.d |= Integer.MIN_VALUE;
            return c.this.a((String) null, this);
        }
    }

    public c(String sdkVersion, HttpClient httpClient, j httpRequestInfo, g deviceRequestInfo) {
        Intrinsics.checkNotNullParameter(sdkVersion, "sdkVersion");
        Intrinsics.checkNotNullParameter(httpClient, "httpClient");
        Intrinsics.checkNotNullParameter(httpRequestInfo, "httpRequestInfo");
        Intrinsics.checkNotNullParameter(deviceRequestInfo, "deviceRequestInfo");
        this.f5627a = sdkVersion;
        this.b = httpClient;
        this.c = httpRequestInfo;
        this.d = deviceRequestInfo;
        this.e = "BidTokenApi";
    }

    @Override // com.moloco.sdk.internal.services.bidtoken.InterfaceC3437a
    public Object a(MetricsRecorder metricsRecorder, Continuation<? super com.moloco.sdk.internal.v<k, com.moloco.sdk.internal.m>> continuation) {
        return BuildersKt.withContext(com.moloco.sdk.internal.scheduling.b.a().getIo(), new a(metricsRecorder, null), continuation);
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x0100, code lost:
    
        if (r11 == r1) goto L44;
     */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00e4 A[Catch: InvalidProtocolBufferException -> 0x0030, TRY_ENTER, TryCatch #3 {InvalidProtocolBufferException -> 0x0030, blocks: (B:11:0x002b, B:13:0x0105, B:16:0x012f, B:17:0x0136, B:26:0x00e4), top: B:7:0x0025 }] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x015b  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0027  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object a(String str, Continuation<? super com.moloco.sdk.internal.v<k, com.moloco.sdk.internal.m>> continuation) {
        b bVar;
        int i;
        Exception exc;
        c cVar;
        UnknownHostException unknownHostException;
        HttpRequestTimeoutException httpRequestTimeoutException;
        HttpResponse httpResponse;
        try {
            if (continuation instanceof b) {
                bVar = (b) continuation;
                int i2 = bVar.d;
                if ((i2 & Integer.MIN_VALUE) != 0) {
                    bVar.d = i2 - Integer.MIN_VALUE;
                    Object obj = bVar.b;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i = bVar.d;
                    if (i != 0) {
                        ResultKt.throwOnFailure(obj);
                        try {
                            HttpClient httpClient = this.b;
                            HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
                            HttpRequestKt.url(httpRequestBuilder, str);
                            HttpRequestKt.headers(httpRequestBuilder, new Function1() { // from class: com.moloco.sdk.internal.services.bidtoken.c$$ExternalSyntheticLambda0
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj2) {
                                    return c.a(c.this, (HeadersBuilder) obj2);
                                }
                            });
                            HttpMessagePropertiesKt.contentType(httpRequestBuilder, ContentType.Application.INSTANCE.getProtoBuf());
                            byte[] a2 = a();
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
                            com.moloco.sdk.xenoss.sdkdevkit.android.core.a.a(httpRequestBuilder, this.c.f());
                            httpRequestBuilder.setMethod(HttpMethod.INSTANCE.getPost());
                            HttpStatement httpStatement = new HttpStatement(httpRequestBuilder, httpClient);
                            bVar.f5629a = this;
                            bVar.d = 1;
                            obj = httpStatement.execute(bVar);
                            if (obj != coroutine_suspended) {
                                cVar = this;
                            }
                            return coroutine_suspended;
                        } catch (HttpRequestTimeoutException e) {
                            httpRequestTimeoutException = e;
                            cVar = this;
                            MolocoLogger.error$default(MolocoLogger.INSTANCE, cVar.e, "Request timeout exception", httpRequestTimeoutException, false, 8, null);
                            return new v.a(new com.moloco.sdk.internal.m("bidtoken request failed due to timeout", EnumC3438b.c.c()));
                        } catch (UnknownHostException e2) {
                            unknownHostException = e2;
                            cVar = this;
                            MolocoLogger.error$default(MolocoLogger.INSTANCE, cVar.e, "Unknown Host Request exception", unknownHostException, false, 8, null);
                            return new v.a(new com.moloco.sdk.internal.m("bidtoken request failed due to not being able to connect to host", EnumC3438b.d.c()));
                        } catch (Exception e3) {
                            exc = e3;
                            cVar = this;
                            MolocoLogger.error$default(MolocoLogger.INSTANCE, cVar.e, "Bid Token API Request exception", exc, false, 8, null);
                            return new v.a(new com.moloco.sdk.internal.m("bidtoken request failed due to unknown exception", EnumC3438b.b.c()));
                        }
                    }
                    if (i != 1) {
                        if (i != 2) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj);
                        if (obj != null) {
                            BidToken.BidTokenResponseV3 parseFrom = BidToken.BidTokenResponseV3.parseFrom((byte[]) obj);
                            String bidToken = parseFrom.getBidToken();
                            Intrinsics.checkNotNullExpressionValue(bidToken, "getBidToken(...)");
                            String pk = parseFrom.getPk();
                            Intrinsics.checkNotNullExpressionValue(pk, "getPk(...)");
                            Intrinsics.checkNotNull(parseFrom);
                            return new v.b(new k(bidToken, pk, e.a(parseFrom)));
                        }
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.ByteArray");
                    }
                    cVar = (c) bVar.f5629a;
                    try {
                        ResultKt.throwOnFailure(obj);
                    } catch (HttpRequestTimeoutException e4) {
                        httpRequestTimeoutException = e4;
                        MolocoLogger.error$default(MolocoLogger.INSTANCE, cVar.e, "Request timeout exception", httpRequestTimeoutException, false, 8, null);
                        return new v.a(new com.moloco.sdk.internal.m("bidtoken request failed due to timeout", EnumC3438b.c.c()));
                    } catch (UnknownHostException e5) {
                        unknownHostException = e5;
                        MolocoLogger.error$default(MolocoLogger.INSTANCE, cVar.e, "Unknown Host Request exception", unknownHostException, false, 8, null);
                        return new v.a(new com.moloco.sdk.internal.m("bidtoken request failed due to not being able to connect to host", EnumC3438b.d.c()));
                    } catch (Exception e6) {
                        exc = e6;
                        MolocoLogger.error$default(MolocoLogger.INSTANCE, cVar.e, "Bid Token API Request exception", exc, false, 8, null);
                        return new v.a(new com.moloco.sdk.internal.m("bidtoken request failed due to unknown exception", EnumC3438b.b.c()));
                    }
                    httpResponse = (HttpResponse) obj;
                    if (!Intrinsics.areEqual(httpResponse.getStatus(), HttpStatusCode.INSTANCE.getOK())) {
                        HttpClientCall call = httpResponse.getCall();
                        KType typeOf3 = Reflection.typeOf(byte[].class);
                        TypeInfo typeInfoImpl = TypeInfoJvmKt.typeInfoImpl(TypesJVMKt.getJavaType(typeOf3), Reflection.getOrCreateKotlinClass(byte[].class), typeOf3);
                        bVar.f5629a = null;
                        bVar.d = 2;
                        obj = call.bodyNullable(typeInfoImpl, bVar);
                    } else {
                        return new v.a(new com.moloco.sdk.internal.m("bidtoken request failed", httpResponse.getStatus().getValue()));
                    }
                }
            }
            if (i != 0) {
            }
            httpResponse = (HttpResponse) obj;
            if (!Intrinsics.areEqual(httpResponse.getStatus(), HttpStatusCode.INSTANCE.getOK())) {
            }
        } catch (InvalidProtocolBufferException e7) {
            return new v.a(new com.moloco.sdk.internal.m("Bidtoken parsing failed. Reason: " + e7, HttpStatusCode.INSTANCE.getBadRequest().getValue()));
        }
        bVar = new b(continuation);
        Object obj2 = bVar.b;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = bVar.d;
    }

    public static final Unit a(c cVar, HeadersBuilder headers) {
        Intrinsics.checkNotNullParameter(headers, "$this$headers");
        com.moloco.sdk.internal.n.a(headers, cVar.f5627a, cVar.d.j(), null, 4, null);
        return Unit.INSTANCE;
    }

    public final byte[] a() {
        byte[] byteArray = BidToken.BidTokenRequestV3.newBuilder().build().toByteArray();
        Intrinsics.checkNotNullExpressionValue(byteArray, "toByteArray(...)");
        return byteArray;
    }
}
