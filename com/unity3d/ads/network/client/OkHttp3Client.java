package com.unity3d.ads.network.client;

import com.unity3d.ads.network.HttpClient;
import com.unity3d.ads.network.model.HttpRequest;
import com.unity3d.ads.network.model.HttpResponse;
import com.unity3d.services.core.domain.ISDKDispatchers;
import com.vungle.ads.internal.ui.AdActivity;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/* compiled from: OkHttp3Client.kt */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0019\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u000bJ)\u0010\f\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0010H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010\u0012R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0013"}, d2 = {"Lcom/unity3d/ads/network/client/OkHttp3Client;", "Lcom/unity3d/ads/network/HttpClient;", "dispatchers", "Lcom/unity3d/services/core/domain/ISDKDispatchers;", "client", "Lokhttp3/OkHttpClient;", "(Lcom/unity3d/services/core/domain/ISDKDispatchers;Lokhttp3/OkHttpClient;)V", "execute", "Lcom/unity3d/ads/network/model/HttpResponse;", AdActivity.REQUEST_KEY_EXTRA, "Lcom/unity3d/ads/network/model/HttpRequest;", "(Lcom/unity3d/ads/network/model/HttpRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "makeRequest", "Lokhttp3/Response;", "Lokhttp3/Request;", "connectTimeout", "", "readTimeout", "(Lokhttp3/Request;JJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "unity-ads_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes7.dex */
public final class OkHttp3Client implements HttpClient {
    private final OkHttpClient client;
    private final ISDKDispatchers dispatchers;

    public OkHttp3Client(ISDKDispatchers dispatchers, OkHttpClient client) {
        Intrinsics.checkNotNullParameter(dispatchers, "dispatchers");
        Intrinsics.checkNotNullParameter(client, "client");
        this.dispatchers = dispatchers;
        this.client = client;
    }

    @Override // com.unity3d.ads.network.HttpClient
    public Object execute(HttpRequest httpRequest, Continuation<? super HttpResponse> continuation) {
        return BuildersKt.withContext(this.dispatchers.getIo(), new OkHttp3Client$execute$2(httpRequest, this, null), continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object makeRequest(Request request, long j, long j2, Continuation<? super Response> continuation) {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        final CancellableContinuationImpl cancellableContinuationImpl2 = cancellableContinuationImpl;
        this.client.newBuilder().connectTimeout(j, TimeUnit.MILLISECONDS).readTimeout(j2, TimeUnit.MILLISECONDS).build().newCall(request).enqueue(new Callback() { // from class: com.unity3d.ads.network.client.OkHttp3Client$makeRequest$2$1
            @Override // okhttp3.Callback
            public void onResponse(Call call, Response response) {
                Intrinsics.checkNotNullParameter(call, "call");
                Intrinsics.checkNotNullParameter(response, "response");
                CancellableContinuation<Response> cancellableContinuation = cancellableContinuationImpl2;
                Result.Companion companion = Result.INSTANCE;
                cancellableContinuation.resumeWith(Result.m10241constructorimpl(response));
            }

            @Override // okhttp3.Callback
            public void onFailure(Call call, IOException e) {
                Intrinsics.checkNotNullParameter(call, "call");
                Intrinsics.checkNotNullParameter(e, "e");
                CancellableContinuation<Response> cancellableContinuation = cancellableContinuationImpl2;
                Result.Companion companion = Result.INSTANCE;
                cancellableContinuation.resumeWith(Result.m10241constructorimpl(ResultKt.createFailure(e)));
            }
        });
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result;
    }
}
