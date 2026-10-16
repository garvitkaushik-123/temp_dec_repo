package com.moloco.sdk.internal.http;

import com.moloco.sdk.internal.services.C3446j;
import com.moloco.sdk.internal.services.x;
import com.moloco.sdk.publisher.Moloco;
import com.moloco.sdk.xenoss.sdkdevkit.android.core.b;
import io.ktor.client.HttpClient;
import io.ktor.client.HttpClientConfig;
import io.ktor.client.HttpClientJvmKt;
import io.ktor.client.plugins.DefaultRequest;
import io.ktor.client.plugins.DefaultRequestKt;
import io.ktor.client.plugins.HttpRequestRetry;
import io.ktor.client.plugins.HttpTimeout;
import io.ktor.client.plugins.UserAgent;
import io.ktor.client.request.HttpRequestKt;
import io.ktor.http.HeadersBuilder;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public final class a {
    public static final HttpClient a(final C3446j appInfo, final x deviceInfo) {
        Intrinsics.checkNotNullParameter(appInfo, "appInfo");
        Intrinsics.checkNotNullParameter(deviceInfo, "deviceInfo");
        return HttpClientJvmKt.HttpClient(new Function1() { // from class: com.moloco.sdk.internal.http.a$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return a.a(C3446j.this, deviceInfo, (HttpClientConfig) obj);
            }
        });
    }

    public static final Unit a(final C3446j c3446j, final x xVar, HttpClientConfig HttpClient) {
        Intrinsics.checkNotNullParameter(HttpClient, "$this$HttpClient");
        HttpClient.install(UserAgent.INSTANCE, new Function1() { // from class: com.moloco.sdk.internal.http.a$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return a.a((UserAgent.Config) obj);
            }
        });
        HttpClientConfig.install$default(HttpClient, HttpTimeout.INSTANCE, null, 2, null);
        HttpClientConfig.install$default(HttpClient, HttpRequestRetry.INSTANCE, null, 2, null);
        DefaultRequestKt.defaultRequest(HttpClient, new Function1() { // from class: com.moloco.sdk.internal.http.a$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return a.a(C3446j.this, xVar, (DefaultRequest.DefaultRequestBuilder) obj);
            }
        });
        return Unit.INSTANCE;
    }

    public static final Unit a(UserAgent.Config install) {
        Intrinsics.checkNotNullParameter(install, "$this$install");
        install.setAgent(b.b().invoke());
        return Unit.INSTANCE;
    }

    public static final Unit a(final C3446j c3446j, final x xVar, DefaultRequest.DefaultRequestBuilder defaultRequest) {
        Intrinsics.checkNotNullParameter(defaultRequest, "$this$defaultRequest");
        HttpRequestKt.headers(defaultRequest, new Function1() { // from class: com.moloco.sdk.internal.http.a$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return a.a(C3446j.this, xVar, (HeadersBuilder) obj);
            }
        });
        return Unit.INSTANCE;
    }

    public static final Unit a(C3446j c3446j, x xVar, HeadersBuilder headers) {
        Intrinsics.checkNotNullParameter(headers, "$this$headers");
        headers.append("X-Moloco-App-Info", "AppBundle/" + c3446j.b() + "; AppVersion/" + c3446j.c() + "; AppKey/" + Moloco.INSTANCE.getAppKey$moloco_sdk_release() + ';');
        headers.append("X-Moloco-Device-Info", "make/" + xVar.t() + "; model/" + xVar.v() + "; hwv/" + xVar.r() + "; osv/" + xVar.x() + "; OS/Android;");
        headers.append("X-Moloco-SDK-Info", "SdkVersion/4.0.0");
        return Unit.INSTANCE;
    }
}
