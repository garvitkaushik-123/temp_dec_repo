package com.unity3d.services.core.network.core;

import com.unity3d.ads.core.data.model.exception.NetworkTimeoutException;
import com.unity3d.ads.core.data.model.exception.UnityAdsNetworkException;
import com.unity3d.services.core.domain.ISDKDispatchers;
import com.unity3d.services.core.network.mapper.HttpRequestToOkHttpRequestKt;
import com.unity3d.services.core.network.model.HttpRequest;
import com.unity3d.services.core.network.model.HttpResponse;
import com.vungle.ads.internal.ui.AdActivity;
import java.io.IOException;
import java.net.SocketTimeoutException;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

/* compiled from: RefactoredOkHttp3Client.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0019\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u000bJ\u0010\u0010\f\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u000e"}, d2 = {"Lcom/unity3d/services/core/network/core/RefactoredOkHttp3Client;", "Lcom/unity3d/services/core/network/core/HttpClient;", "dispatchers", "Lcom/unity3d/services/core/domain/ISDKDispatchers;", "client", "Lokhttp3/OkHttpClient;", "(Lcom/unity3d/services/core/domain/ISDKDispatchers;Lokhttp3/OkHttpClient;)V", "execute", "Lcom/unity3d/services/core/network/model/HttpResponse;", AdActivity.REQUEST_KEY_EXTRA, "Lcom/unity3d/services/core/network/model/HttpRequest;", "(Lcom/unity3d/services/core/network/model/HttpRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "executeBlocking", "Companion", "unity-ads_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes7.dex */
public final class RefactoredOkHttp3Client implements HttpClient {
    public static final String MSG_CONNECTION_FAILED = "Network request failed";
    public static final String MSG_CONNECTION_TIMEOUT = "Network request timeout";
    public static final String NETWORK_CLIENT_OKHTTP = "refactored-okhttp";
    private final OkHttpClient client;
    private final ISDKDispatchers dispatchers;

    public RefactoredOkHttp3Client(ISDKDispatchers dispatchers, OkHttpClient client) {
        Intrinsics.checkNotNullParameter(dispatchers, "dispatchers");
        Intrinsics.checkNotNullParameter(client, "client");
        this.dispatchers = dispatchers;
        this.client = client;
    }

    @Override // com.unity3d.services.core.network.core.HttpClient
    public HttpResponse executeBlocking(HttpRequest request) {
        Intrinsics.checkNotNullParameter(request, "request");
        return (HttpResponse) BuildersKt.runBlocking(this.dispatchers.getIo(), new RefactoredOkHttp3Client$executeBlocking$1(this, request, null));
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x003e  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0024  */
    @Override // com.unity3d.services.core.network.core.HttpClient
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object execute(HttpRequest httpRequest, Continuation<? super HttpResponse> continuation) {
        RefactoredOkHttp3Client$execute$1 refactoredOkHttp3Client$execute$1;
        int i;
        try {
            if (continuation instanceof RefactoredOkHttp3Client$execute$1) {
                refactoredOkHttp3Client$execute$1 = (RefactoredOkHttp3Client$execute$1) continuation;
                if ((refactoredOkHttp3Client$execute$1.label & Integer.MIN_VALUE) != 0) {
                    refactoredOkHttp3Client$execute$1.label -= Integer.MIN_VALUE;
                    Object obj = refactoredOkHttp3Client$execute$1.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i = refactoredOkHttp3Client$execute$1.label;
                    if (i == 0) {
                        if (i != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj);
                        return obj;
                    }
                    ResultKt.throwOnFailure(obj);
                    Request okHttpProtoRequest = HttpRequestToOkHttpRequestKt.toOkHttpProtoRequest(httpRequest);
                    OkHttpClient build = this.client.newBuilder().connectTimeout(httpRequest.getConnectTimeout(), TimeUnit.MILLISECONDS).readTimeout(httpRequest.getReadTimeout(), TimeUnit.MILLISECONDS).writeTimeout(httpRequest.getWriteTimeout(), TimeUnit.MILLISECONDS).build();
                    refactoredOkHttp3Client$execute$1.L$0 = httpRequest;
                    refactoredOkHttp3Client$execute$1.L$1 = okHttpProtoRequest;
                    refactoredOkHttp3Client$execute$1.L$2 = build;
                    refactoredOkHttp3Client$execute$1.label = 1;
                    CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(refactoredOkHttp3Client$execute$1), 1);
                    cancellableContinuationImpl.initCancellability();
                    final CancellableContinuationImpl cancellableContinuationImpl2 = cancellableContinuationImpl;
                    final Call newCall = build.newCall(okHttpProtoRequest);
                    cancellableContinuationImpl2.invokeOnCancellation(new Function1<Throwable, Unit>() { // from class: com.unity3d.services.core.network.core.RefactoredOkHttp3Client$execute$2$1
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
                            Call.this.cancel();
                        }
                    });
                    newCall.enqueue(new Callback() { // from class: com.unity3d.services.core.network.core.RefactoredOkHttp3Client$execute$2$2
                        @Override // okhttp3.Callback
                        public void onResponse(Call call, Response response) {
                            Intrinsics.checkNotNullParameter(call, "call");
                            Intrinsics.checkNotNullParameter(response, "response");
                            if (!response.isSuccessful()) {
                                CancellableContinuation<HttpResponse> cancellableContinuation = cancellableContinuationImpl2;
                                Result.Companion companion = Result.INSTANCE;
                                cancellableContinuation.resumeWith(Result.m10241constructorimpl(ResultKt.createFailure(new UnityAdsNetworkException("Network request failed with code " + response.code(), null, Integer.valueOf(response.code()), null, null, null, RefactoredOkHttp3Client.NETWORK_CLIENT_OKHTTP, 58, null))));
                                return;
                            }
                            try {
                                ResponseBody body = response.body();
                                if (body == null) {
                                    CancellableContinuation<HttpResponse> cancellableContinuation2 = cancellableContinuationImpl2;
                                    Result.Companion companion2 = Result.INSTANCE;
                                    cancellableContinuation2.resumeWith(Result.m10241constructorimpl(ResultKt.createFailure(new UnityAdsNetworkException("Empty response", null, Integer.valueOf(response.code()), null, null, null, RefactoredOkHttp3Client.NETWORK_CLIENT_OKHTTP, 58, null))));
                                    return;
                                }
                                CancellableContinuation<HttpResponse> cancellableContinuation3 = cancellableContinuationImpl2;
                                int code = response.code();
                                Map<String, List<String>> multimap = response.headers().toMultimap();
                                String url = response.request().url().getUrl();
                                byte[] readByteArray = body.getSource().readByteArray();
                                String protocol = response.protocol().getProtocol();
                                Intrinsics.checkNotNullExpressionValue(readByteArray, "readByteArray()");
                                Intrinsics.checkNotNullExpressionValue(multimap, "toMultimap()");
                                Intrinsics.checkNotNullExpressionValue(url, "toString()");
                                Intrinsics.checkNotNullExpressionValue(protocol, "toString()");
                                HttpResponse httpResponse = new HttpResponse(readByteArray, code, multimap, url, protocol, RefactoredOkHttp3Client.NETWORK_CLIENT_OKHTTP, 0L, 64, null);
                                Result.Companion companion3 = Result.INSTANCE;
                                cancellableContinuation3.resumeWith(Result.m10241constructorimpl(httpResponse));
                            } catch (Exception e) {
                                CancellableContinuation<HttpResponse> cancellableContinuation4 = cancellableContinuationImpl2;
                                Result.Companion companion4 = Result.INSTANCE;
                                cancellableContinuation4.resumeWith(Result.m10241constructorimpl(ResultKt.createFailure(e)));
                            }
                        }

                        @Override // okhttp3.Callback
                        public void onFailure(Call call, IOException e) {
                            Intrinsics.checkNotNullParameter(call, "call");
                            Intrinsics.checkNotNullParameter(e, "e");
                            CancellableContinuation<HttpResponse> cancellableContinuation = cancellableContinuationImpl2;
                            Result.Companion companion = Result.INSTANCE;
                            cancellableContinuation.resumeWith(Result.m10241constructorimpl(ResultKt.createFailure(e)));
                        }
                    });
                    Object result = cancellableContinuationImpl.getResult();
                    if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                        DebugProbesKt.probeCoroutineSuspended(refactoredOkHttp3Client$execute$1);
                    }
                    return result == coroutine_suspended ? coroutine_suspended : result;
                }
            }
            if (i == 0) {
            }
        } catch (SocketTimeoutException unused) {
            throw new NetworkTimeoutException("Network request timeout", null, null, httpRequest.getBaseURL(), null, null, NETWORK_CLIENT_OKHTTP, 54, null);
        } catch (IOException unused2) {
            throw new UnityAdsNetworkException("Network request failed", null, null, httpRequest.getBaseURL(), null, null, NETWORK_CLIENT_OKHTTP, 54, null);
        }
        refactoredOkHttp3Client$execute$1 = new RefactoredOkHttp3Client$execute$1(this, continuation);
        Object obj2 = refactoredOkHttp3Client$execute$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = refactoredOkHttp3Client$execute$1.label;
    }
}
