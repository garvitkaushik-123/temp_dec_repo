package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media;

import com.ironsource.C3337ue;
import com.moloco.sdk.internal.MolocoLogger;
import com.moloco.sdk.internal.error.b;
import com.moloco.sdk.internal.services.u;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.i;
import io.ktor.client.HttpClient;
import io.ktor.client.plugins.HttpRequestRetry;
import io.ktor.client.plugins.HttpRequestRetryKt;
import io.ktor.client.request.HttpRequestBuilder;
import io.ktor.client.request.HttpRequestKt;
import io.ktor.client.statement.HttpResponse;
import io.ktor.client.statement.HttpResponseKt;
import io.ktor.client.statement.HttpStatement;
import io.ktor.http.HttpMessagePropertiesKt;
import io.ktor.http.HttpMethod;
import io.ktor.util.cio.FileChannelsKt;
import io.ktor.utils.io.ByteReadChannel;
import io.ktor.utils.io.ByteReadChannelKt;
import io.ktor.utils.io.ByteWriteChannel;
import java.io.File;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.TimeoutCancellationException;

/* loaded from: classes6.dex */
public final class d implements n {
    public static final int e = 8;

    /* renamed from: a, reason: collision with root package name */
    public final u f5857a;
    public final com.moloco.sdk.internal.error.b b;
    public final HttpClient c;
    public final String d;

    @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.LegacyMediaDownloader$downloadMedia$2", f = "LegacyMediaDownloader.kt", i = {0, 1, 2, 2, 3, 3}, l = {42, 52, 63, 63}, m = "invokeSuspend", n = {"httpRequestComplete", "httpRequestComplete", C3337ue.n, "httpRequestComplete", C3337ue.n, "httpRequestComplete"}, s = {"I$0", "I$0", "L$0", "I$0", "L$0", "I$0"})
    public static final class a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super i.a>, Object> {

        /* renamed from: a, reason: collision with root package name */
        public int f5858a;
        public Object b;
        public int c;
        public final /* synthetic */ String e;
        public final /* synthetic */ File f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(String str, File file, Continuation<? super a> continuation) {
            super(2, continuation);
            this.e = str;
            this.f = file;
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super i.a> continuation) {
            return ((a) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return d.this.new a(this.e, this.f, continuation);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:37:0x015e  */
        /* JADX WARN: Removed duplicated region for block: B:41:0x017a  */
        /* JADX WARN: Removed duplicated region for block: B:48:0x01fd  */
        /* JADX WARN: Removed duplicated region for block: B:51:0x0207  */
        /* JADX WARN: Removed duplicated region for block: B:54:0x022b  */
        /* JADX WARN: Type inference failed for: r14v0 */
        /* JADX WARN: Type inference failed for: r14v1 */
        /* JADX WARN: Type inference failed for: r14v12 */
        /* JADX WARN: Type inference failed for: r14v3 */
        /* JADX WARN: Type inference failed for: r14v4 */
        /* JADX WARN: Type inference failed for: r14v5 */
        /* JADX WARN: Type inference failed for: r14v7 */
        /* JADX WARN: Type inference failed for: r1v2 */
        /* JADX WARN: Type inference failed for: r1v40, types: [int] */
        /* JADX WARN: Type inference failed for: r1v43 */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            ?? r1;
            Object obj2;
            Object obj3;
            ?? r14;
            HttpResponse httpResponse;
            Object obj4;
            HttpResponse httpResponse2;
            Object obj5;
            HttpResponse httpResponse3;
            int value;
            int value2;
            String str = "Fetching asset from network: ";
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.c;
            try {
                try {
                    if (i == 0) {
                        ResultKt.throwOnFailure(obj);
                        try {
                            MolocoLogger.info$default(MolocoLogger.INSTANCE, d.this.d, "Fetching asset from network: " + this.e, null, false, 12, null);
                            u uVar = d.this.f5857a;
                            this.f5858a = 0;
                            this.c = 1;
                            obj2 = uVar.a(5000L, this);
                            if (obj2 != coroutine_suspended) {
                                r1 = 0;
                            }
                            return coroutine_suspended;
                        } catch (TimeoutCancellationException unused) {
                            str = null;
                            b.a.a(d.this.b, d.this.a(str != null), null, 2, null);
                            if (str != null) {
                            }
                            throw new p();
                        }
                    }
                    try {
                        if (i != 1) {
                            if (i != 2) {
                                if (i != 3) {
                                    if (i != 4) {
                                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                    }
                                    int i2 = this.f5858a;
                                    httpResponse2 = (HttpResponse) this.b;
                                    ResultKt.throwOnFailure(obj);
                                    r14 = i2;
                                    obj5 = obj;
                                    MolocoLogger.info$default(MolocoLogger.INSTANCE, d.this.d, "Downloaded full response: " + HttpMessagePropertiesKt.contentLength(httpResponse2) + " and saved to disk: " + ((Number) obj5).longValue() + " bytes, file size: " + this.f.length(), null, false, 12, null);
                                    return new i.a.b(this.f);
                                }
                                int i3 = this.f5858a;
                                HttpResponse httpResponse4 = (HttpResponse) this.b;
                                ResultKt.throwOnFailure(obj);
                                r14 = i3;
                                httpResponse = httpResponse4;
                                obj4 = obj;
                                try {
                                    ByteReadChannel byteReadChannel = (ByteReadChannel) obj4;
                                    ByteWriteChannel writeChannel$default = FileChannelsKt.writeChannel$default(this.f, null, 1, null);
                                    this.b = httpResponse;
                                    this.f5858a = r14 == true ? 1 : 0;
                                    this.c = 4;
                                    obj5 = ByteReadChannelKt.copyAndClose$default(byteReadChannel, writeChannel$default, 0L, this, 2, null);
                                    if (obj5 != coroutine_suspended) {
                                        httpResponse2 = httpResponse;
                                        r14 = r14;
                                        MolocoLogger.info$default(MolocoLogger.INSTANCE, d.this.d, "Downloaded full response: " + HttpMessagePropertiesKt.contentLength(httpResponse2) + " and saved to disk: " + ((Number) obj5).longValue() + " bytes, file size: " + this.f.length(), null, false, 12, null);
                                        return new i.a.b(this.f);
                                    }
                                    return coroutine_suspended;
                                } catch (TimeoutCancellationException unused2) {
                                    str = r14;
                                    b.a.a(d.this.b, d.this.a(str != null), null, 2, null);
                                    if (str != null) {
                                    }
                                    throw new p();
                                }
                            }
                            int i4 = this.f5858a;
                            ResultKt.throwOnFailure(obj);
                            obj3 = obj;
                            httpResponse3 = (HttpResponse) obj3;
                            try {
                                value = httpResponse3.getStatus().getValue();
                                if (400 > value && value < 500) {
                                    MolocoLogger.error$default(MolocoLogger.INSTANCE, d.this.d, "Failed to fetch media from url: " + this.e + ", status: " + httpResponse3.getStatus(), null, false, 12, null);
                                    return i.a.AbstractC0479a.e.c;
                                }
                                value2 = httpResponse3.getStatus().getValue();
                                if (500 > value2 && value2 < 600) {
                                    MolocoLogger.error$default(MolocoLogger.INSTANCE, d.this.d, "Failed to fetch media from url: " + this.e + ", status: " + httpResponse3.getStatus(), null, false, 12, null);
                                    return i.a.AbstractC0479a.h.c;
                                }
                                this.b = httpResponse3;
                                this.f5858a = 1;
                                this.c = 3;
                                obj4 = HttpResponseKt.bodyAsChannel(httpResponse3, this);
                                if (obj4 != coroutine_suspended) {
                                    httpResponse = httpResponse3;
                                    r14 = 1;
                                    ByteReadChannel byteReadChannel2 = (ByteReadChannel) obj4;
                                    ByteWriteChannel writeChannel$default2 = FileChannelsKt.writeChannel$default(this.f, null, 1, null);
                                    this.b = httpResponse;
                                    this.f5858a = r14 == true ? 1 : 0;
                                    this.c = 4;
                                    obj5 = ByteReadChannelKt.copyAndClose$default(byteReadChannel2, writeChannel$default2, 0L, this, 2, null);
                                    if (obj5 != coroutine_suspended) {
                                    }
                                }
                                return coroutine_suspended;
                            } catch (TimeoutCancellationException unused3) {
                                str = 1;
                                b.a.a(d.this.b, d.this.a(str != null), null, 2, null);
                                if (str != null) {
                                }
                                throw new p();
                            }
                        }
                        int i5 = this.f5858a;
                        ResultKt.throwOnFailure(obj);
                        r1 = i5;
                        obj2 = obj;
                    } catch (TimeoutCancellationException unused4) {
                        b.a.a(d.this.b, d.this.a(str != null), null, 2, null);
                        if (str != null) {
                            MolocoLogger.error$default(MolocoLogger.INSTANCE, d.this.d, "Timeout occurred after request had completed: " + this.e, null, false, 12, null);
                        } else {
                            MolocoLogger.error$default(MolocoLogger.INSTANCE, d.this.d, "Timeout occurred when still waiting for request to complete: " + this.e, null, false, 12, null);
                        }
                        throw new p();
                    }
                    if (!((Boolean) obj2).booleanValue()) {
                        return i.a.AbstractC0479a.n.c;
                    }
                    if (this.f.exists()) {
                        MolocoLogger.info$default(MolocoLogger.INSTANCE, d.this.d, "Deleting existing file and re-downloading it", null, false, 12, null);
                        this.f.delete();
                    }
                    d dVar = d.this;
                    String str2 = this.e;
                    this.f5858a = r1;
                    this.c = 2;
                    obj3 = dVar.a(str2, this);
                    if (obj3 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    httpResponse3 = (HttpResponse) obj3;
                    value = httpResponse3.getStatus().getValue();
                    if (400 > value) {
                    }
                    value2 = httpResponse3.getStatus().getValue();
                    if (500 > value2) {
                    }
                    this.b = httpResponse3;
                    this.f5858a = 1;
                    this.c = 3;
                    obj4 = HttpResponseKt.bodyAsChannel(httpResponse3, this);
                    if (obj4 != coroutine_suspended) {
                    }
                    return coroutine_suspended;
                } catch (TimeoutCancellationException unused5) {
                    str = r1;
                    b.a.a(d.this.b, d.this.a(str != null), null, 2, null);
                    if (str != null) {
                    }
                    throw new p();
                }
            } catch (Exception e) {
                MolocoLogger.error$default(MolocoLogger.INSTANCE, d.this.d, "Failed to fetch media from url: " + this.e, e, false, 8, null);
                return o.a(e);
            }
        }
    }

    public d(u connectivityService, com.moloco.sdk.internal.error.b errorReportingService, HttpClient httpClient) {
        Intrinsics.checkNotNullParameter(connectivityService, "connectivityService");
        Intrinsics.checkNotNullParameter(errorReportingService, "errorReportingService");
        Intrinsics.checkNotNullParameter(httpClient, "httpClient");
        this.f5857a = connectivityService;
        this.b = errorReportingService;
        this.c = httpClient;
        this.d = "LegacyMediaDownloader";
    }

    public static final long a(HttpRequestRetry.DelayContext delayMillis, int i) {
        Intrinsics.checkNotNullParameter(delayMillis, "$this$delayMillis");
        return 100L;
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.n
    public Object a(String str, File file, Continuation<? super i.a> continuation) {
        return BuildersKt.withContext(com.moloco.sdk.internal.scheduling.b.a().getIo(), new a(str, file, null), continuation);
    }

    public final Object a(String str, Continuation<? super HttpResponse> continuation) {
        HttpClient httpClient = this.c;
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        HttpRequestKt.url(httpRequestBuilder, str);
        HttpRequestRetryKt.retry(httpRequestBuilder, new Function1() { // from class: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.d$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return d.a(d.this, (HttpRequestRetry.Configuration) obj);
            }
        });
        httpRequestBuilder.setMethod(HttpMethod.INSTANCE.getGet());
        return new HttpStatement(httpRequestBuilder, httpClient).execute(continuation);
    }

    public static final Unit a(final d dVar, HttpRequestRetry.Configuration retry) {
        Intrinsics.checkNotNullParameter(retry, "$this$retry");
        retry.setMaxRetries(10);
        HttpRequestRetry.Configuration.delayMillis$default(retry, false, new Function2() { // from class: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.d$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return Long.valueOf(d.a((HttpRequestRetry.DelayContext) obj, ((Integer) obj2).intValue()));
            }
        }, 1, null);
        retry.retryOnException(10, true);
        retry.retryOnServerErrors(10);
        retry.modifyRequest(new Function2() { // from class: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.d$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return d.a(d.this, (HttpRequestRetry.ModifyRequestContext) obj, (HttpRequestBuilder) obj2);
            }
        });
        return Unit.INSTANCE;
    }

    public static final Unit a(d dVar, HttpRequestRetry.ModifyRequestContext modifyRequest, HttpRequestBuilder it) {
        Intrinsics.checkNotNullParameter(modifyRequest, "$this$modifyRequest");
        Intrinsics.checkNotNullParameter(it, "it");
        MolocoLogger.info$default(MolocoLogger.INSTANCE, dVar.d, "Retry attempt #" + modifyRequest.getRetryCount() + " for " + modifyRequest.getRequest().getUrl(), null, false, 12, null);
        return Unit.INSTANCE;
    }

    public final String a(boolean z) {
        if (z) {
            return e.f5859a;
        }
        return e.b;
    }
}
