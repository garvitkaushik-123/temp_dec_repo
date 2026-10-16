package com.unity3d.services.core.network.core;

import com.unity3d.ads.core.configuration.AlternativeFlowReader;
import com.unity3d.ads.core.data.model.exception.NetworkTimeoutException;
import com.unity3d.ads.core.data.model.exception.UnityAdsNetworkException;
import com.unity3d.services.core.network.core.OkHttp3Client;
import com.unity3d.services.core.network.model.HttpRequest;
import com.unity3d.services.core.network.model.HttpResponse;
import java.io.File;
import java.io.IOException;
import java.net.SocketTimeoutException;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.io.FilesKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlinx.coroutines.CoroutineScope;
import okhttp3.Response;

/* compiled from: OkHttp3Client.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "Lcom/unity3d/services/core/network/model/HttpResponse;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "com.unity3d.services.core.network.core.OkHttp3Client$execute$2", f = "OkHttp3Client.kt", i = {}, l = {74}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes7.dex */
final class OkHttp3Client$execute$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super HttpResponse>, Object> {
    final /* synthetic */ HttpRequest $request;
    int label;
    final /* synthetic */ OkHttp3Client this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    OkHttp3Client$execute$2(OkHttp3Client okHttp3Client, HttpRequest httpRequest, Continuation<? super OkHttp3Client$execute$2> continuation) {
        super(2, continuation);
        this.this$0 = okHttp3Client;
        this.$request = httpRequest;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new OkHttp3Client$execute$2(this.this$0, this.$request, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super HttpResponse> continuation) {
        return ((OkHttp3Client$execute$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object makeRequest;
        AlternativeFlowReader alternativeFlowReader;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                OkHttp3Client okHttp3Client = this.this$0;
                HttpRequest httpRequest = this.$request;
                this.label = 1;
                makeRequest = okHttp3Client.makeRequest(httpRequest, httpRequest.getConnectTimeout(), this.$request.getReadTimeout(), this.$request.getWriteTimeout(), this);
                if (makeRequest == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                makeRequest = obj;
            }
            OkHttp3Client.RequestComplete requestComplete = (OkHttp3Client.RequestComplete) makeRequest;
            Response response = requestComplete.getResponse();
            String body = requestComplete.getBody();
            alternativeFlowReader = this.this$0.isAlternativeFlowReader;
            if (!alternativeFlowReader.invoke()) {
                if (body instanceof File) {
                    body = FilesKt.readText$default((File) body, null, 1, null);
                } else {
                    body = body instanceof byte[] ? new String((byte[]) body, Charsets.UTF_8) : "";
                }
            }
            int code = response.code();
            Map<String, List<String>> multimap = response.headers().toMultimap();
            String url = response.request().url().getUrl();
            Object obj2 = body == null ? "" : body;
            String protocol = response.protocol().getProtocol();
            Intrinsics.checkNotNullExpressionValue(multimap, "toMultimap()");
            Intrinsics.checkNotNullExpressionValue(url, "toString()");
            Intrinsics.checkNotNullExpressionValue(protocol, "toString()");
            return new HttpResponse(obj2, code, multimap, url, protocol, OkHttp3Client.NETWORK_CLIENT_OKHTTP, 0L, 64, null);
        } catch (SocketTimeoutException unused) {
            throw new NetworkTimeoutException("Network request timeout", null, null, this.$request.getBaseURL(), null, null, OkHttp3Client.NETWORK_CLIENT_OKHTTP, 54, null);
        } catch (IOException unused2) {
            throw new UnityAdsNetworkException("Network request failed", null, null, this.$request.getBaseURL(), null, null, OkHttp3Client.NETWORK_CLIENT_OKHTTP, 54, null);
        }
    }
}
