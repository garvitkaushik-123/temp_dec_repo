package com.moloco.sdk.internal.services.config.handlers;

import com.moloco.sdk.Init;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public final class b implements a {

    /* renamed from: a, reason: collision with root package name */
    public static final int f5672a = 0;

    @Override // com.moloco.sdk.internal.services.config.handlers.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public com.moloco.sdk.internal.configs.a a(Init.SDKInitResponse sdkInitResponse) {
        Intrinsics.checkNotNullParameter(sdkInitResponse, "sdkInitResponse");
        if (!sdkInitResponse.hasOperationalMetricsConfig()) {
            return com.moloco.sdk.internal.configs.b.c();
        }
        Init.SDKInitResponse.OperationalMetricsConfig operationalMetricsConfig = sdkInitResponse.getOperationalMetricsConfig();
        String url = operationalMetricsConfig.getUrl();
        Intrinsics.checkNotNullExpressionValue(url, "getUrl(...)");
        return new com.moloco.sdk.internal.configs.a(url, operationalMetricsConfig.getPollingIntervalSeconds());
    }

    @Override // com.moloco.sdk.internal.services.config.handlers.a
    public Class<com.moloco.sdk.internal.configs.a> a() {
        return com.moloco.sdk.internal.configs.a.class;
    }
}
