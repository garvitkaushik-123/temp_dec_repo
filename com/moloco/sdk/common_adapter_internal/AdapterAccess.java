package com.moloco.sdk.common_adapter_internal;

import android.content.Context;
import com.moloco.sdk.Init;
import com.moloco.sdk.internal.android_context.b;
import com.moloco.sdk.internal.n;
import com.moloco.sdk.internal.scheduling.DispatcherProvider;
import com.moloco.sdk.publisher.MediationInfo;
import com.moloco.sdk.service_locator.a;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.s;
import com.moloco.sdk.xenoss.sdkdevkit.android.core.UserAgentService;
import io.ktor.client.HttpClient;
import io.ktor.client.request.HttpRequestBuilder;
import io.ktor.http.HeadersBuilder;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0003¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0007J\u0012\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\tJ(\u0010\u000b\u001a\u00020\f*\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u00072\b\u0010\u000f\u001a\u0004\u0018\u00010\u00072\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011J\u0012\u0010\u0012\u001a\u00020\f*\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015J\u0006\u0010\u0016\u001a\u00020\u0017J\u0006\u0010\u0018\u001a\u00020\u0019J\u0010\u0010\u001a\u001a\u00020\u001b2\b\b\u0002\u0010\n\u001a\u00020\tJ\u0006\u0010\u001c\u001a\u00020\u001d¨\u0006\u001e"}, d2 = {"Lcom/moloco/sdk/common_adapter_internal/AdapterAccess;", "", "<init>", "()V", "sessionData", "Lcom/moloco/sdk/common_adapter_internal/AdapterSessionData;", "adUnitId", "", "ApplicationContext", "Landroid/content/Context;", "context", "appendMolocoUserAgent", "", "Lio/ktor/http/HeadersBuilder;", "molocoSdkVersion", "androidOSVersion", "mediationInfo", "Lcom/moloco/sdk/publisher/MediationInfo;", "httpRequestTimeoutMillis", "Lio/ktor/client/request/HttpRequestBuilder;", "millis", "", "UserAgentService", "Lcom/moloco/sdk/xenoss/sdkdevkit/android/core/UserAgentService;", "HttpClient", "Lio/ktor/client/HttpClient;", "screenData", "Lcom/moloco/sdk/common_adapter_internal/ScreenData;", "DispatcherProvider", "Lcom/moloco/sdk/internal/scheduling/DispatcherProvider;", "moloco-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class AdapterAccess {
    public static final int $stable = 0;
    public static final AdapterAccess INSTANCE = new AdapterAccess();

    public static /* synthetic */ Context ApplicationContext$default(AdapterAccess adapterAccess, Context context, int i, Object obj) {
        if ((i & 1) != 0) {
            context = null;
        }
        return adapterAccess.ApplicationContext(context);
    }

    public static /* synthetic */ ScreenData screenData$default(AdapterAccess adapterAccess, Context context, int i, Object obj) {
        if ((i & 1) != 0) {
            context = ApplicationContext$default(adapterAccess, null, 1, null);
        }
        return adapterAccess.screenData(context);
    }

    @JvmStatic
    public static final AdapterSessionData sessionData(String adUnitId) {
        AdapterSessionData a2;
        Intrinsics.checkNotNullParameter(adUnitId, "adUnitId");
        Init.SDKInitResponse a3 = a.f.f5754a.b().a();
        if (a3 == null) {
            return null;
        }
        a2 = AdapterAccessKt.a(a3, adUnitId);
        return a2;
    }

    public final Context ApplicationContext(Context context) {
        return b.a(context);
    }

    public final DispatcherProvider DispatcherProvider() {
        return com.moloco.sdk.internal.scheduling.b.a();
    }

    public final HttpClient HttpClient() {
        return a.i.f5757a.a();
    }

    public final UserAgentService UserAgentService() {
        return com.moloco.sdk.xenoss.sdkdevkit.android.core.b.b();
    }

    public final void appendMolocoUserAgent(HeadersBuilder headersBuilder, String str, String str2, MediationInfo mediationInfo) {
        Intrinsics.checkNotNullParameter(headersBuilder, "<this>");
        n.a(headersBuilder, str, str2, mediationInfo);
    }

    public final void httpRequestTimeoutMillis(HttpRequestBuilder httpRequestBuilder, long j) {
        Intrinsics.checkNotNullParameter(httpRequestBuilder, "<this>");
        com.moloco.sdk.xenoss.sdkdevkit.android.core.a.a(httpRequestBuilder, j);
    }

    public final ScreenData screenData(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return s.a(context).invoke();
    }
}
