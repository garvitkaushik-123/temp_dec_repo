package io.adn.sdk.internal.di.modules;

import android.content.Context;
import android.webkit.WebSettings;
import io.ktor.client.engine.HttpClientEngine;
import io.ktor.client.engine.okhttp.OkHttp;
import io.ktor.client.engine.okhttp.OkHttpConfig;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: NetworkModule.kt */
@Metadata(d1 = {"\u0000&\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\u001a\b\u0010\u0000\u001a\u00020\u0001H\u0002\u001a\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0002\u001a\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0001H\u0000\"\u000e\u0010\u0006\u001a\u00020\u0003X\u0082T¢\u0006\u0002\n\u0000\"\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000\"\u000e\u0010\u000b\u001a\u00020\fX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\r\u001a\u00020\fX\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"provideHttpClientEngine", "Lio/ktor/client/engine/HttpClientEngine;", "provideUserAgent", "", "context", "Landroid/content/Context;", "DEFAULT_USER_AGENT", "customHttpClientEngine", "injectCustomHttpClient", "", "engine", "DEFAULT_REQUEST_TIMEOUT", "", "DEFAULT_SOCKET_TIMEOUT", "adn-sdk_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes7.dex */
public final class NetworkModuleKt {
    private static final long DEFAULT_REQUEST_TIMEOUT = 30000;
    private static final long DEFAULT_SOCKET_TIMEOUT = 30000;
    private static final String DEFAULT_USER_AGENT = "Mozilla/5.0 (Linux; Android 12; Pixel 6 Build/SD1A.210817.023; wv) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/94.0.4606.71 Mobile Safari/537.36";
    private static HttpClientEngine customHttpClientEngine;

    /* JADX INFO: Access modifiers changed from: private */
    public static final HttpClientEngine provideHttpClientEngine() {
        HttpClientEngine httpClientEngine = customHttpClientEngine;
        return httpClientEngine == null ? OkHttp.INSTANCE.create(new Function1() { // from class: io.adn.sdk.internal.di.modules.NetworkModuleKt$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit provideHttpClientEngine$lambda$0;
                provideHttpClientEngine$lambda$0 = NetworkModuleKt.provideHttpClientEngine$lambda$0((OkHttpConfig) obj);
                return provideHttpClientEngine$lambda$0;
            }
        }) : httpClientEngine;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit provideHttpClientEngine$lambda$0(OkHttpConfig create) {
        Intrinsics.checkNotNullParameter(create, "$this$create");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String provideUserAgent(Context context) {
        Object m10241constructorimpl;
        try {
            Result.Companion companion = Result.INSTANCE;
            m10241constructorimpl = Result.m10241constructorimpl(WebSettings.getDefaultUserAgent(context));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            m10241constructorimpl = Result.m10241constructorimpl(ResultKt.createFailure(th));
        }
        if (Result.m10247isFailureimpl(m10241constructorimpl)) {
            m10241constructorimpl = DEFAULT_USER_AGENT;
        }
        return (String) m10241constructorimpl;
    }

    public static final void injectCustomHttpClient(HttpClientEngine engine) {
        Intrinsics.checkNotNullParameter(engine, "engine");
        customHttpClientEngine = engine;
    }
}
