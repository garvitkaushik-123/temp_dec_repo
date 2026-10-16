package io.adn.sdk.internal.data.utils;

import io.ktor.client.plugins.HttpTimeout;
import io.ktor.client.plugins.HttpTimeoutKt;
import io.ktor.client.request.HttpRequestBuilder;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: HttpRequestUtils.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0000¨\u0006\u0005"}, d2 = {"requestTimeoutMillis", "", "Lio/ktor/client/request/HttpRequestBuilder;", "millis", "", "adn-sdk_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes7.dex */
public final class HttpRequestUtilsKt {
    public static final void requestTimeoutMillis(HttpRequestBuilder httpRequestBuilder, final long j) {
        Intrinsics.checkNotNullParameter(httpRequestBuilder, "<this>");
        HttpTimeoutKt.timeout(httpRequestBuilder, new Function1() { // from class: io.adn.sdk.internal.data.utils.HttpRequestUtilsKt$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit requestTimeoutMillis$lambda$0;
                requestTimeoutMillis$lambda$0 = HttpRequestUtilsKt.requestTimeoutMillis$lambda$0(j, (HttpTimeout.HttpTimeoutCapabilityConfiguration) obj);
                return requestTimeoutMillis$lambda$0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit requestTimeoutMillis$lambda$0(long j, HttpTimeout.HttpTimeoutCapabilityConfiguration timeout) {
        Intrinsics.checkNotNullParameter(timeout, "$this$timeout");
        timeout.setRequestTimeoutMillis(Long.valueOf(j));
        timeout.setSocketTimeoutMillis(Long.valueOf(j));
        return Unit.INSTANCE;
    }
}
