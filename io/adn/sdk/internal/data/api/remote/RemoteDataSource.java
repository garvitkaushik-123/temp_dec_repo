package io.adn.sdk.internal.data.api.remote;

import io.adn.sdk.BuildConfig;
import io.adn.sdk.internal.data.dto.AdRequestBody;
import io.adn.sdk.internal.data.dto.AdResponseDto;
import io.adn.sdk.internal.data.dto.DiagnosticEventBody;
import io.adn.sdk.internal.data.utils.HttpRequestUtilsKt;
import io.adn.sdk.internal.domain.error.AdError;
import io.adn.sdk.internal.domain.error.AdException;
import io.ktor.client.HttpClient;
import io.ktor.client.call.HttpClientCall;
import io.ktor.client.request.HttpRequestBuilder;
import io.ktor.client.request.HttpRequestKt;
import io.ktor.client.statement.HttpResponse;
import io.ktor.client.statement.HttpResponseKt;
import io.ktor.client.statement.HttpStatement;
import io.ktor.http.ContentType;
import io.ktor.http.HttpMessagePropertiesKt;
import io.ktor.http.HttpMethod;
import io.ktor.http.HttpStatusCode;
import io.ktor.http.HttpStatusCodeKt;
import io.ktor.http.content.NullBody;
import io.ktor.http.content.OutgoingContent;
import io.ktor.util.reflect.TypeInfo;
import io.ktor.util.reflect.TypeInfoJvmKt;
import io.ktor.utils.io.ByteReadChannel;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KType;
import kotlin.reflect.KTypeProjection;
import kotlin.reflect.TypesJVMKt;

/* compiled from: RemoteDataSource.kt */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0001\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001c\u0010\u0006\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0086@¢\u0006\u0002\u0010\u000bJ\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\rH\u0086@¢\u0006\u0002\u0010\u000fJ\u0016\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\rH\u0086@¢\u0006\u0002\u0010\u000fJ\u0016\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\rH\u0086@¢\u0006\u0002\u0010\u000fJ\u0016\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0086@¢\u0006\u0002\u0010\u0017J\u0016\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\rH\u0086@¢\u0006\u0002\u0010\u000fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lio/adn/sdk/internal/data/api/remote/RemoteDataSource;", "", "httpClient", "Lio/ktor/client/HttpClient;", "<init>", "(Lio/ktor/client/HttpClient;)V", "sendDiagnosticEvents", "", "eventsBody", "", "Lio/adn/sdk/internal/data/dto/DiagnosticEventBody;", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "loadAdContent", "", "url", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "loadAdFile", "Lio/ktor/utils/io/ByteReadChannel;", "sendAdTracker", "fetchAd", "Lio/adn/sdk/internal/data/dto/AdResponseDto;", "adRequestBody", "Lio/adn/sdk/internal/data/dto/AdRequestBody;", "(Lio/adn/sdk/internal/data/dto/AdRequestBody;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "triggerAdnInstallAttributionCallback", "adn-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes7.dex */
public final class RemoteDataSource {
    public static final int $stable = 8;
    private final HttpClient httpClient;

    public RemoteDataSource(HttpClient httpClient) {
        Intrinsics.checkNotNullParameter(httpClient, "httpClient");
        this.httpClient = httpClient;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x00d3  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x00d6  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object sendDiagnosticEvents(List<DiagnosticEventBody> list, Continuation<? super Unit> continuation) {
        RemoteDataSource$sendDiagnosticEvents$1 remoteDataSource$sendDiagnosticEvents$1;
        Object obj;
        int i;
        if (continuation instanceof RemoteDataSource$sendDiagnosticEvents$1) {
            remoteDataSource$sendDiagnosticEvents$1 = (RemoteDataSource$sendDiagnosticEvents$1) continuation;
            if ((remoteDataSource$sendDiagnosticEvents$1.label & Integer.MIN_VALUE) != 0) {
                remoteDataSource$sendDiagnosticEvents$1.label -= Integer.MIN_VALUE;
                obj = remoteDataSource$sendDiagnosticEvents$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = remoteDataSource$sendDiagnosticEvents$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    HttpClient httpClient = this.httpClient;
                    HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
                    HttpRequestUtilsKt.requestTimeoutMillis(httpRequestBuilder, 12000L);
                    HttpRequestKt.url(httpRequestBuilder, "https://collector.voodoo-adn.com/sdk");
                    HttpMessagePropertiesKt.contentType(httpRequestBuilder, ContentType.Application.INSTANCE.getJson());
                    if (list == null) {
                        httpRequestBuilder.setBody(NullBody.INSTANCE);
                        KType typeOf = Reflection.typeOf(List.class, KTypeProjection.INSTANCE.invariant(Reflection.typeOf(DiagnosticEventBody.class)));
                        httpRequestBuilder.setBodyType(TypeInfoJvmKt.typeInfoImpl(TypesJVMKt.getJavaType(typeOf), Reflection.getOrCreateKotlinClass(List.class), typeOf));
                    } else if (list instanceof OutgoingContent) {
                        httpRequestBuilder.setBody(list);
                        httpRequestBuilder.setBodyType(null);
                    } else {
                        httpRequestBuilder.setBody(list);
                        KType typeOf2 = Reflection.typeOf(List.class, KTypeProjection.INSTANCE.invariant(Reflection.typeOf(DiagnosticEventBody.class)));
                        httpRequestBuilder.setBodyType(TypeInfoJvmKt.typeInfoImpl(TypesJVMKt.getJavaType(typeOf2), Reflection.getOrCreateKotlinClass(List.class), typeOf2));
                    }
                    httpRequestBuilder.setMethod(HttpMethod.INSTANCE.getPost());
                    HttpStatement httpStatement = new HttpStatement(httpRequestBuilder, httpClient);
                    remoteDataSource$sendDiagnosticEvents$1.label = 1;
                    obj = httpStatement.execute(remoteDataSource$sendDiagnosticEvents$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                if (HttpStatusCodeKt.isSuccess(((HttpResponse) obj).getStatus())) {
                    throw new HttpRequestException();
                }
                return Unit.INSTANCE;
            }
        }
        remoteDataSource$sendDiagnosticEvents$1 = new RemoteDataSource$sendDiagnosticEvents$1(this, continuation);
        obj = remoteDataSource$sendDiagnosticEvents$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = remoteDataSource$sendDiagnosticEvents$1.label;
        if (i != 0) {
        }
        if (HttpStatusCodeKt.isSuccess(((HttpResponse) obj).getStatus())) {
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x005a, code lost:
    
        if (r7 == r1) goto L24;
     */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0074  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0039  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object loadAdContent(String str, Continuation<? super String> continuation) {
        RemoteDataSource$loadAdContent$1 remoteDataSource$loadAdContent$1;
        int i;
        HttpResponse httpResponse;
        if (continuation instanceof RemoteDataSource$loadAdContent$1) {
            remoteDataSource$loadAdContent$1 = (RemoteDataSource$loadAdContent$1) continuation;
            if ((remoteDataSource$loadAdContent$1.label & Integer.MIN_VALUE) != 0) {
                remoteDataSource$loadAdContent$1.label -= Integer.MIN_VALUE;
                Object obj = remoteDataSource$loadAdContent$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = remoteDataSource$loadAdContent$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    HttpClient httpClient = this.httpClient;
                    HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
                    HttpRequestKt.url(httpRequestBuilder, str);
                    httpRequestBuilder.setMethod(HttpMethod.INSTANCE.getGet());
                    HttpStatement httpStatement = new HttpStatement(httpRequestBuilder, httpClient);
                    remoteDataSource$loadAdContent$1.label = 1;
                    obj = httpStatement.execute(remoteDataSource$loadAdContent$1);
                } else {
                    if (i != 1) {
                        if (i != 2) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj);
                        return obj;
                    }
                    ResultKt.throwOnFailure(obj);
                }
                httpResponse = (HttpResponse) obj;
                if (HttpStatusCodeKt.isSuccess(httpResponse.getStatus())) {
                    throw new HttpRequestException();
                }
                remoteDataSource$loadAdContent$1.label = 2;
                Object bodyAsText$default = HttpResponseKt.bodyAsText$default(httpResponse, null, remoteDataSource$loadAdContent$1, 1, null);
                return bodyAsText$default == coroutine_suspended ? coroutine_suspended : bodyAsText$default;
            }
        }
        remoteDataSource$loadAdContent$1 = new RemoteDataSource$loadAdContent$1(this, continuation);
        Object obj2 = remoteDataSource$loadAdContent$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = remoteDataSource$loadAdContent$1.label;
        if (i != 0) {
        }
        httpResponse = (HttpResponse) obj2;
        if (HttpStatusCodeKt.isSuccess(httpResponse.getStatus())) {
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x005a, code lost:
    
        if (r7 == r1) goto L24;
     */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0039  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object loadAdFile(String str, Continuation<? super ByteReadChannel> continuation) {
        RemoteDataSource$loadAdFile$1 remoteDataSource$loadAdFile$1;
        int i;
        HttpResponse httpResponse;
        if (continuation instanceof RemoteDataSource$loadAdFile$1) {
            remoteDataSource$loadAdFile$1 = (RemoteDataSource$loadAdFile$1) continuation;
            if ((remoteDataSource$loadAdFile$1.label & Integer.MIN_VALUE) != 0) {
                remoteDataSource$loadAdFile$1.label -= Integer.MIN_VALUE;
                Object obj = remoteDataSource$loadAdFile$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = remoteDataSource$loadAdFile$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    HttpClient httpClient = this.httpClient;
                    HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
                    HttpRequestKt.url(httpRequestBuilder, str);
                    httpRequestBuilder.setMethod(HttpMethod.INSTANCE.getGet());
                    HttpStatement httpStatement = new HttpStatement(httpRequestBuilder, httpClient);
                    remoteDataSource$loadAdFile$1.label = 1;
                    obj = httpStatement.execute(remoteDataSource$loadAdFile$1);
                } else {
                    if (i != 1) {
                        if (i != 2) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj);
                        return obj;
                    }
                    ResultKt.throwOnFailure(obj);
                }
                httpResponse = (HttpResponse) obj;
                if (HttpStatusCodeKt.isSuccess(httpResponse.getStatus())) {
                    throw new HttpRequestException();
                }
                remoteDataSource$loadAdFile$1.label = 2;
                Object bodyAsChannel = HttpResponseKt.bodyAsChannel(httpResponse, remoteDataSource$loadAdFile$1);
                return bodyAsChannel == coroutine_suspended ? coroutine_suspended : bodyAsChannel;
            }
        }
        remoteDataSource$loadAdFile$1 = new RemoteDataSource$loadAdFile$1(this, continuation);
        Object obj2 = remoteDataSource$loadAdFile$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = remoteDataSource$loadAdFile$1.label;
        if (i != 0) {
        }
        httpResponse = (HttpResponse) obj2;
        if (HttpStatusCodeKt.isSuccess(httpResponse.getStatus())) {
        }
    }

    public final Object sendAdTracker(String str, Continuation<? super Unit> continuation) {
        HttpClient httpClient = this.httpClient;
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        HttpRequestKt.url(httpRequestBuilder, str);
        httpRequestBuilder.setMethod(HttpMethod.INSTANCE.getGet());
        Object execute = new HttpStatement(httpRequestBuilder, httpClient).execute(continuation);
        return execute == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? execute : Unit.INSTANCE;
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x00f2, code lost:
    
        if (r10 == r1) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x00f4, code lost:
    
        return r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x00b5, code lost:
    
        if (r10 == r1) goto L32;
     */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00c4  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x010a  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x003c  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0026  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object fetchAd(AdRequestBody adRequestBody, Continuation<? super AdResponseDto> continuation) {
        RemoteDataSource$fetchAd$1 remoteDataSource$fetchAd$1;
        int i;
        HttpResponse httpResponse;
        if (continuation instanceof RemoteDataSource$fetchAd$1) {
            remoteDataSource$fetchAd$1 = (RemoteDataSource$fetchAd$1) continuation;
            if ((remoteDataSource$fetchAd$1.label & Integer.MIN_VALUE) != 0) {
                remoteDataSource$fetchAd$1.label -= Integer.MIN_VALUE;
                Object obj = remoteDataSource$fetchAd$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = remoteDataSource$fetchAd$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    HttpClient httpClient = this.httpClient;
                    HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
                    HttpRequestUtilsKt.requestTimeoutMillis(httpRequestBuilder, 60000L);
                    HttpRequestKt.url(httpRequestBuilder, BuildConfig.REQUEST_AD_BASE_URL);
                    HttpMessagePropertiesKt.contentType(httpRequestBuilder, ContentType.Application.INSTANCE.getJson());
                    if (adRequestBody == null) {
                        httpRequestBuilder.setBody(NullBody.INSTANCE);
                        KType typeOf = Reflection.typeOf(AdRequestBody.class);
                        httpRequestBuilder.setBodyType(TypeInfoJvmKt.typeInfoImpl(TypesJVMKt.getJavaType(typeOf), Reflection.getOrCreateKotlinClass(AdRequestBody.class), typeOf));
                    } else if (adRequestBody instanceof OutgoingContent) {
                        httpRequestBuilder.setBody(adRequestBody);
                        httpRequestBuilder.setBodyType(null);
                    } else {
                        httpRequestBuilder.setBody(adRequestBody);
                        KType typeOf2 = Reflection.typeOf(AdRequestBody.class);
                        httpRequestBuilder.setBodyType(TypeInfoJvmKt.typeInfoImpl(TypesJVMKt.getJavaType(typeOf2), Reflection.getOrCreateKotlinClass(AdRequestBody.class), typeOf2));
                    }
                    httpRequestBuilder.setMethod(HttpMethod.INSTANCE.getPost());
                    HttpStatement httpStatement = new HttpStatement(httpRequestBuilder, httpClient);
                    remoteDataSource$fetchAd$1.label = 1;
                    obj = httpStatement.execute(remoteDataSource$fetchAd$1);
                } else {
                    if (i != 1) {
                        if (i != 2) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj);
                        if (obj != null) {
                            return (AdResponseDto) obj;
                        }
                        throw new NullPointerException("null cannot be cast to non-null type io.adn.sdk.internal.data.dto.AdResponseDto");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                httpResponse = (HttpResponse) obj;
                if (HttpStatusCodeKt.isSuccess(httpResponse.getStatus())) {
                    throw new HttpRequestException();
                }
                if (Intrinsics.areEqual(httpResponse.getStatus(), HttpStatusCode.INSTANCE.getNoContent())) {
                    throw new AdException(AdError.NoFillError, null, 2, null);
                }
                HttpClientCall call = httpResponse.getCall();
                KType typeOf3 = Reflection.typeOf(AdResponseDto.class);
                TypeInfo typeInfoImpl = TypeInfoJvmKt.typeInfoImpl(TypesJVMKt.getJavaType(typeOf3), Reflection.getOrCreateKotlinClass(AdResponseDto.class), typeOf3);
                remoteDataSource$fetchAd$1.label = 2;
                obj = call.bodyNullable(typeInfoImpl, remoteDataSource$fetchAd$1);
            }
        }
        remoteDataSource$fetchAd$1 = new RemoteDataSource$fetchAd$1(this, continuation);
        Object obj2 = remoteDataSource$fetchAd$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = remoteDataSource$fetchAd$1.label;
        if (i != 0) {
        }
        httpResponse = (HttpResponse) obj2;
        if (HttpStatusCodeKt.isSuccess(httpResponse.getStatus())) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object triggerAdnInstallAttributionCallback(String str, Continuation<? super Unit> continuation) {
        RemoteDataSource$triggerAdnInstallAttributionCallback$1 remoteDataSource$triggerAdnInstallAttributionCallback$1;
        Object obj;
        int i;
        if (continuation instanceof RemoteDataSource$triggerAdnInstallAttributionCallback$1) {
            remoteDataSource$triggerAdnInstallAttributionCallback$1 = (RemoteDataSource$triggerAdnInstallAttributionCallback$1) continuation;
            if ((remoteDataSource$triggerAdnInstallAttributionCallback$1.label & Integer.MIN_VALUE) != 0) {
                remoteDataSource$triggerAdnInstallAttributionCallback$1.label -= Integer.MIN_VALUE;
                obj = remoteDataSource$triggerAdnInstallAttributionCallback$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = remoteDataSource$triggerAdnInstallAttributionCallback$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    HttpClient httpClient = this.httpClient;
                    HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
                    HttpRequestKt.url(httpRequestBuilder, str);
                    httpRequestBuilder.setMethod(HttpMethod.INSTANCE.getGet());
                    HttpStatement httpStatement = new HttpStatement(httpRequestBuilder, httpClient);
                    remoteDataSource$triggerAdnInstallAttributionCallback$1.label = 1;
                    obj = httpStatement.execute(remoteDataSource$triggerAdnInstallAttributionCallback$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                if (HttpStatusCodeKt.isSuccess(((HttpResponse) obj).getStatus())) {
                    throw new HttpRequestException();
                }
                return Unit.INSTANCE;
            }
        }
        remoteDataSource$triggerAdnInstallAttributionCallback$1 = new RemoteDataSource$triggerAdnInstallAttributionCallback$1(this, continuation);
        obj = remoteDataSource$triggerAdnInstallAttributionCallback$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = remoteDataSource$triggerAdnInstallAttributionCallback$1.label;
        if (i != 0) {
        }
        if (HttpStatusCodeKt.isSuccess(((HttpResponse) obj).getStatus())) {
        }
    }
}
