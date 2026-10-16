package com.unity3d.ads.core.domain;

import com.unity3d.ads.core.extensions.JSONArrayExtensionsKt;
import com.unity3d.services.core.network.core.HttpClient;
import com.unity3d.services.core.network.model.HttpRequest;
import com.unity3d.services.core.network.model.HttpResponse;
import com.unity3d.services.core.network.model.RequestType;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.ArraysKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import org.json.JSONArray;

/* compiled from: AndroidExecuteAdViewerRequest.kt */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ#\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eH\u0002¢\u0006\u0002\u0010\u0010J'\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u000b\u001a\u00020\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eH\u0096Bø\u0001\u0000¢\u0006\u0002\u0010\u0013R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0014"}, d2 = {"Lcom/unity3d/ads/core/domain/AndroidExecuteAdViewerRequest;", "Lcom/unity3d/ads/core/domain/ExecuteAdViewerRequest;", "ioDispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "httpClient", "Lcom/unity3d/services/core/network/core/HttpClient;", "getCachedAsset", "Lcom/unity3d/ads/core/domain/GetCachedAsset;", "(Lkotlinx/coroutines/CoroutineDispatcher;Lcom/unity3d/services/core/network/core/HttpClient;Lcom/unity3d/ads/core/domain/GetCachedAsset;)V", "createRequest", "Lcom/unity3d/services/core/network/model/HttpRequest;", "type", "Lcom/unity3d/services/core/network/model/RequestType;", "parameters", "", "", "(Lcom/unity3d/services/core/network/model/RequestType;[Ljava/lang/Object;)Lcom/unity3d/services/core/network/model/HttpRequest;", "invoke", "Lcom/unity3d/services/core/network/model/HttpResponse;", "(Lcom/unity3d/services/core/network/model/RequestType;[Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "unity-ads_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes7.dex */
public final class AndroidExecuteAdViewerRequest implements ExecuteAdViewerRequest {
    private final GetCachedAsset getCachedAsset;
    private final HttpClient httpClient;
    private final CoroutineDispatcher ioDispatcher;

    /* compiled from: AndroidExecuteAdViewerRequest.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[RequestType.values().length];
            try {
                iArr[RequestType.GET.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[RequestType.HEAD.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[RequestType.POST.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public AndroidExecuteAdViewerRequest(CoroutineDispatcher ioDispatcher, HttpClient httpClient, GetCachedAsset getCachedAsset) {
        Intrinsics.checkNotNullParameter(ioDispatcher, "ioDispatcher");
        Intrinsics.checkNotNullParameter(httpClient, "httpClient");
        Intrinsics.checkNotNullParameter(getCachedAsset, "getCachedAsset");
        this.ioDispatcher = ioDispatcher;
        this.httpClient = httpClient;
        this.getCachedAsset = getCachedAsset;
    }

    @Override // com.unity3d.ads.core.domain.ExecuteAdViewerRequest
    public Object invoke(RequestType requestType, Object[] objArr, Continuation<? super HttpResponse> continuation) {
        return BuildersKt.withContext(this.ioDispatcher, new AndroidExecuteAdViewerRequest$invoke$2(objArr, this, requestType, null), continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final HttpRequest createRequest(RequestType type, Object[] parameters) {
        Map<String, List<String>> emptyMap;
        Map<String, List<String>> emptyMap2;
        String str = (String) ArraysKt.getOrNull(parameters, 1);
        String str2 = str;
        if (str2 == null || str2.length() == 0) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        int i = WhenMappings.$EnumSwitchMapping$0[type.ordinal()];
        if (i == 1 || i == 2) {
            JSONArray jSONArray = (JSONArray) ArraysKt.getOrNull(parameters, 2);
            Integer num = (Integer) ArraysKt.getOrNull(parameters, 3);
            Integer num2 = (Integer) ArraysKt.getOrNull(parameters, 4);
            if (jSONArray == null || (emptyMap = JSONArrayExtensionsKt.getHeadersMap(jSONArray)) == null) {
                emptyMap = MapsKt.emptyMap();
            }
            return new HttpRequest(str, null, type, null, emptyMap, null, null, null, null, num != null ? num.intValue() : 30000, num2 != null ? num2.intValue() : 30000, 0, 0, false, null, null, 0, 129514, null);
        }
        if (i != 3) {
            throw new NoWhenBranchMatchedException();
        }
        String str3 = (String) ArraysKt.getOrNull(parameters, 2);
        JSONArray jSONArray2 = (JSONArray) ArraysKt.getOrNull(parameters, 3);
        Integer num3 = (Integer) ArraysKt.getOrNull(parameters, 4);
        Integer num4 = (Integer) ArraysKt.getOrNull(parameters, 5);
        if (jSONArray2 == null || (emptyMap2 = JSONArrayExtensionsKt.getHeadersMap(jSONArray2)) == null) {
            emptyMap2 = MapsKt.emptyMap();
        }
        return new HttpRequest(str, null, type, str3, emptyMap2, null, null, null, null, num3 != null ? num3.intValue() : 30000, num4 != null ? num4.intValue() : 30000, 0, 0, false, null, null, 0, 129506, null);
    }
}
