package com.unity3d.services.core.network.core;

import com.google.common.net.HttpHeaders;
import com.google.firebase.sessions.settings.RemoteSettings;
import com.unity3d.ads.core.data.model.exception.NetworkTimeoutException;
import com.unity3d.ads.core.data.model.exception.UnityAdsNetworkException;
import com.unity3d.ads.core.domain.HandleInvocationsFromAdViewer;
import com.unity3d.services.core.domain.ISDKDispatchers;
import com.unity3d.services.core.network.model.HttpRequest;
import com.unity3d.services.core.network.model.HttpResponse;
import com.unity3d.services.core.network.model.RequestType;
import com.vungle.ads.internal.ui.AdActivity;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.ExecutorsKt;
import org.chromium.net.CronetEngine;
import org.chromium.net.CronetException;
import org.chromium.net.NetworkException;
import org.chromium.net.UploadDataProviders;
import org.chromium.net.UrlRequest;
import org.chromium.net.UrlResponseInfo;

/* compiled from: CronetClient.kt */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0002J\u0019\u0010\u000b\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\nH\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\rJ\u0010\u0010\u000e\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0014H\u0002J\u0006\u0010\u0016\u001a\u00020\u0017R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0019"}, d2 = {"Lcom/unity3d/services/core/network/core/CronetClient;", "Lcom/unity3d/services/core/network/core/HttpClient;", "engine", "Lorg/chromium/net/CronetEngine;", "dispatchers", "Lcom/unity3d/services/core/domain/ISDKDispatchers;", "(Lorg/chromium/net/CronetEngine;Lcom/unity3d/services/core/domain/ISDKDispatchers;)V", "buildUrl", "", AdActivity.REQUEST_KEY_EXTRA, "Lcom/unity3d/services/core/network/model/HttpRequest;", "execute", "Lcom/unity3d/services/core/network/model/HttpResponse;", "(Lcom/unity3d/services/core/network/model/HttpRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "executeBlocking", "getContentSize", "", "info", "Lorg/chromium/net/UrlResponseInfo;", "getPriority", "", HandleInvocationsFromAdViewer.KEY_DOWNLOAD_PRIORITY, "shutdown", "", "Companion", "unity-ads_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes7.dex */
public final class CronetClient implements HttpClient {
    private static final String MSG_CONNECTION_FAILED = "Network request failed";
    private static final String MSG_CONNECTION_TIMEOUT = "Network request timed out";
    private static final String NETWORK_CLIENT_CRONET = "cronet";
    private final ISDKDispatchers dispatchers;
    private final CronetEngine engine;

    /* JADX INFO: Access modifiers changed from: private */
    public final int getPriority(int priority) {
        if (priority == 0) {
            return 4;
        }
        if (priority != 1) {
            return priority != 2 ? 1 : 2;
        }
        return 3;
    }

    public CronetClient(CronetEngine engine, ISDKDispatchers dispatchers) {
        Intrinsics.checkNotNullParameter(engine, "engine");
        Intrinsics.checkNotNullParameter(dispatchers, "dispatchers");
        this.engine = engine;
        this.dispatchers = dispatchers;
    }

    public final void shutdown() {
        this.engine.shutdown();
    }

    @Override // com.unity3d.services.core.network.core.HttpClient
    public HttpResponse executeBlocking(HttpRequest request) {
        Intrinsics.checkNotNullParameter(request, "request");
        return (HttpResponse) BuildersKt.runBlocking(this.dispatchers.getIo(), new CronetClient$executeBlocking$1(this, request, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String buildUrl(HttpRequest request) {
        return StringsKt.removeSuffix(StringsKt.trim(request.getBaseURL(), '/') + '/' + StringsKt.trim(request.getPath(), '/'), (CharSequence) RemoteSettings.FORWARD_SLASH_STRING);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final long getContentSize(UrlResponseInfo info) {
        String str;
        Long longOrNull;
        List<String> list = info.getAllHeaders().get(HttpHeaders.CONTENT_LENGTH);
        if (list == null || (str = list.get(0)) == null || (longOrNull = StringsKt.toLongOrNull(str)) == null) {
            return -1L;
        }
        return longOrNull.longValue();
    }

    @Override // com.unity3d.services.core.network.core.HttpClient
    public Object execute(HttpRequest httpRequest, Continuation<? super HttpResponse> continuation) {
        byte[] bArr;
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        final CancellableContinuationImpl cancellableContinuationImpl2 = cancellableContinuationImpl;
        final ISDKDispatchers iSDKDispatchers = this.dispatchers;
        final long readTimeout = httpRequest.getReadTimeout();
        UnityAdsUrlRequestCallback unityAdsUrlRequestCallback = new UnityAdsUrlRequestCallback(iSDKDispatchers, readTimeout) { // from class: com.unity3d.services.core.network.core.CronetClient$execute$2$callback$1
            @Override // com.unity3d.services.core.network.core.UnityAdsUrlRequestCallback
            public void onSucceeded(UrlRequest request, UrlResponseInfo info, byte[] bodyBytes) {
                long contentSize;
                Intrinsics.checkNotNullParameter(request, "request");
                Intrinsics.checkNotNullParameter(info, "info");
                Intrinsics.checkNotNullParameter(bodyBytes, "bodyBytes");
                CancellableContinuation<HttpResponse> cancellableContinuation = cancellableContinuationImpl2;
                int httpStatusCode = info.getHttpStatusCode();
                Map<String, List<String>> allHeaders = info.getAllHeaders();
                String url = info.getUrl();
                String negotiatedProtocol = info.getNegotiatedProtocol();
                contentSize = this.getContentSize(info);
                Intrinsics.checkNotNullExpressionValue(allHeaders, "allHeaders");
                Intrinsics.checkNotNullExpressionValue(url, "url");
                Intrinsics.checkNotNullExpressionValue(negotiatedProtocol, "negotiatedProtocol");
                HttpResponse httpResponse = new HttpResponse(bodyBytes, httpStatusCode, allHeaders, url, negotiatedProtocol, "cronet", contentSize);
                Result.Companion companion = Result.INSTANCE;
                cancellableContinuation.resumeWith(Result.m10241constructorimpl(httpResponse));
            }

            @Override // com.unity3d.services.core.network.core.UnityAdsUrlRequestCallback, org.chromium.net.UrlRequest.Callback
            public void onFailed(UrlRequest request, UrlResponseInfo info, CronetException error) {
                super.onFailed(request, info, error);
                NetworkException networkException = error instanceof NetworkException ? (NetworkException) error : null;
                UnityAdsNetworkException unityAdsNetworkException = new UnityAdsNetworkException("Network request failed", null, info != null ? Integer.valueOf(info.getHttpStatusCode()) : null, info != null ? info.getUrl() : null, info != null ? info.getNegotiatedProtocol() : null, networkException != null ? Integer.valueOf(networkException.getCronetInternalErrorCode()) : null, "cronet", 2, null);
                CancellableContinuation<HttpResponse> cancellableContinuation = cancellableContinuationImpl2;
                Result.Companion companion = Result.INSTANCE;
                cancellableContinuation.resumeWith(Result.m10241constructorimpl(ResultKt.createFailure(unityAdsNetworkException)));
            }

            @Override // com.unity3d.services.core.network.core.UnityAdsUrlRequestCallback, org.chromium.net.UrlRequest.Callback
            public void onCanceled(UrlRequest request, UrlResponseInfo info) {
                super.onCanceled(request, info);
                NetworkTimeoutException networkTimeoutException = new NetworkTimeoutException("Network request timed out", null, null, info != null ? info.getUrl() : null, info != null ? info.getNegotiatedProtocol() : null, null, "cronet", 38, null);
                CancellableContinuation<HttpResponse> cancellableContinuation = cancellableContinuationImpl2;
                Result.Companion companion = Result.INSTANCE;
                cancellableContinuation.resumeWith(Result.m10241constructorimpl(ResultKt.createFailure(networkTimeoutException)));
            }
        };
        UrlRequest.Builder newUrlRequestBuilder = this.engine.newUrlRequestBuilder(buildUrl(httpRequest), unityAdsUrlRequestCallback, ExecutorsKt.asExecutor(this.dispatchers.getIo()));
        for (Map.Entry<String, List<String>> entry : httpRequest.getHeaders().entrySet()) {
            String key = entry.getKey();
            Iterator<T> it = entry.getValue().iterator();
            while (it.hasNext()) {
                newUrlRequestBuilder.addHeader(key, (String) it.next());
            }
        }
        if (httpRequest.getMethod() == RequestType.POST) {
            Object body = httpRequest.getBody();
            if (body instanceof byte[]) {
                bArr = (byte[]) httpRequest.getBody();
            } else if (body instanceof String) {
                bArr = ((String) httpRequest.getBody()).getBytes(Charsets.UTF_8);
                Intrinsics.checkNotNullExpressionValue(bArr, "this as java.lang.String).getBytes(charset)");
            } else {
                bArr = new byte[0];
            }
            newUrlRequestBuilder.setUploadDataProvider(UploadDataProviders.create(bArr), ExecutorsKt.asExecutor(this.dispatchers.getIo()));
        }
        final UrlRequest req = newUrlRequestBuilder.setHttpMethod(httpRequest.getMethod().toString()).setPriority(getPriority(httpRequest.getPriority())).build();
        cancellableContinuationImpl2.invokeOnCancellation(new Function1<Throwable, Unit>() { // from class: com.unity3d.services.core.network.core.CronetClient$execute$2$2
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
                UrlRequest.this.cancel();
            }
        });
        Intrinsics.checkNotNullExpressionValue(req, "req");
        unityAdsUrlRequestCallback.startTimer(req);
        req.start();
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result;
    }
}
