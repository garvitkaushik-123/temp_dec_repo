package com.sourcepoint.cmplibrary.data.network;

import com.sourcepoint.cmplibrary.data.network.util.HttpUrlManager;
import com.sourcepoint.cmplibrary.data.network.util.ResponseManager;
import com.sourcepoint.cmplibrary.exception.Logger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.OkHttpClient;

/* compiled from: NetworkClientImpl.kt */
@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a(\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0000¨\u0006\n"}, d2 = {"createNetworkClient", "Lcom/sourcepoint/cmplibrary/data/network/NetworkClient;", "httpClient", "Lokhttp3/OkHttpClient;", "urlManager", "Lcom/sourcepoint/cmplibrary/data/network/util/HttpUrlManager;", "logger", "Lcom/sourcepoint/cmplibrary/exception/Logger;", "responseManager", "Lcom/sourcepoint/cmplibrary/data/network/util/ResponseManager;", "cmplibrary_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class NetworkClientImplKt {
    public static final NetworkClient createNetworkClient(OkHttpClient httpClient, HttpUrlManager urlManager, Logger logger, ResponseManager responseManager) {
        Intrinsics.checkNotNullParameter(httpClient, "httpClient");
        Intrinsics.checkNotNullParameter(urlManager, "urlManager");
        Intrinsics.checkNotNullParameter(logger, "logger");
        Intrinsics.checkNotNullParameter(responseManager, "responseManager");
        return new NetworkClientImpl(httpClient, urlManager, logger, responseManager);
    }
}
