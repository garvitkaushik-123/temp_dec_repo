package io.adn.sdk.internal.di.modules;

import io.adn.sdk.internal.di.SdkInjector;
import io.ktor.client.HttpClient;
import io.ktor.client.HttpClientConfig;
import io.ktor.client.HttpClientKt;
import io.ktor.client.engine.HttpClientEngine;
import io.ktor.client.plugins.HttpTimeout;
import io.ktor.client.plugins.UserAgent;
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation;
import io.ktor.serialization.kotlinx.json.JsonSupportKt;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.JsonBuilder;
import kotlinx.serialization.json.JsonKt;

/* compiled from: NetworkModule.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0001\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001b\u0010\u0004\u001a\u00020\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u001b\u0010\n\u001a\u00020\u000b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\t\u001a\u0004\b\f\u0010\rR\u001b\u0010\u000f\u001a\u00020\u00108VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\t\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0014"}, d2 = {"Lio/adn/sdk/internal/di/modules/NetworkModuleImpl;", "Lio/adn/sdk/internal/di/modules/NetworkModule;", "<init>", "()V", "userAgent", "", "getUserAgent", "()Ljava/lang/String;", "userAgent$delegate", "Lkotlin/Lazy;", "httpClientEngine", "Lio/ktor/client/engine/HttpClientEngine;", "getHttpClientEngine", "()Lio/ktor/client/engine/HttpClientEngine;", "httpClientEngine$delegate", "httpClient", "Lio/ktor/client/HttpClient;", "getHttpClient", "()Lio/ktor/client/HttpClient;", "httpClient$delegate", "adn-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes7.dex */
public final class NetworkModuleImpl implements NetworkModule {
    public static final int $stable = 8;

    /* renamed from: userAgent$delegate, reason: from kotlin metadata */
    private final Lazy userAgent = LazyKt.lazy(new Function0() { // from class: io.adn.sdk.internal.di.modules.NetworkModuleImpl$$ExternalSyntheticLambda4
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            String userAgent_delegate$lambda$1;
            userAgent_delegate$lambda$1 = NetworkModuleImpl.userAgent_delegate$lambda$1();
            return userAgent_delegate$lambda$1;
        }
    });

    /* renamed from: httpClientEngine$delegate, reason: from kotlin metadata */
    private final Lazy httpClientEngine = LazyKt.lazy(new Function0() { // from class: io.adn.sdk.internal.di.modules.NetworkModuleImpl$$ExternalSyntheticLambda5
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            HttpClientEngine access$provideHttpClientEngine;
            access$provideHttpClientEngine = NetworkModuleKt.access$provideHttpClientEngine();
            return access$provideHttpClientEngine;
        }
    });

    /* renamed from: httpClient$delegate, reason: from kotlin metadata */
    private final Lazy httpClient = LazyKt.lazy(new Function0() { // from class: io.adn.sdk.internal.di.modules.NetworkModuleImpl$$ExternalSyntheticLambda6
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            HttpClient httpClient_delegate$lambda$8;
            httpClient_delegate$lambda$8 = NetworkModuleImpl.httpClient_delegate$lambda$8(NetworkModuleImpl.this);
            return httpClient_delegate$lambda$8;
        }
    });

    private final String getUserAgent() {
        return (String) this.userAgent.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String userAgent_delegate$lambda$1() {
        String provideUserAgent;
        provideUserAgent = NetworkModuleKt.provideUserAgent(SdkInjector.INSTANCE.getSdkModule().getAppContext());
        return provideUserAgent;
    }

    private final HttpClientEngine getHttpClientEngine() {
        return (HttpClientEngine) this.httpClientEngine.getValue();
    }

    @Override // io.adn.sdk.internal.di.modules.NetworkModule
    public HttpClient getHttpClient() {
        return (HttpClient) this.httpClient.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final HttpClient httpClient_delegate$lambda$8(final NetworkModuleImpl networkModuleImpl) {
        return HttpClientKt.HttpClient(networkModuleImpl.getHttpClientEngine(), (Function1<? super HttpClientConfig<?>, Unit>) new Function1() { // from class: io.adn.sdk.internal.di.modules.NetworkModuleImpl$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit httpClient_delegate$lambda$8$lambda$7;
                httpClient_delegate$lambda$8$lambda$7 = NetworkModuleImpl.httpClient_delegate$lambda$8$lambda$7(NetworkModuleImpl.this, (HttpClientConfig) obj);
                return httpClient_delegate$lambda$8$lambda$7;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit httpClient_delegate$lambda$8$lambda$7(final NetworkModuleImpl networkModuleImpl, HttpClientConfig HttpClient) {
        Intrinsics.checkNotNullParameter(HttpClient, "$this$HttpClient");
        HttpClient.install(UserAgent.INSTANCE, new Function1() { // from class: io.adn.sdk.internal.di.modules.NetworkModuleImpl$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit httpClient_delegate$lambda$8$lambda$7$lambda$3;
                httpClient_delegate$lambda$8$lambda$7$lambda$3 = NetworkModuleImpl.httpClient_delegate$lambda$8$lambda$7$lambda$3(NetworkModuleImpl.this, (UserAgent.Config) obj);
                return httpClient_delegate$lambda$8$lambda$7$lambda$3;
            }
        });
        HttpClient.install(ContentNegotiation.INSTANCE, new Function1() { // from class: io.adn.sdk.internal.di.modules.NetworkModuleImpl$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit httpClient_delegate$lambda$8$lambda$7$lambda$5;
                httpClient_delegate$lambda$8$lambda$7$lambda$5 = NetworkModuleImpl.httpClient_delegate$lambda$8$lambda$7$lambda$5((ContentNegotiation.Config) obj);
                return httpClient_delegate$lambda$8$lambda$7$lambda$5;
            }
        });
        HttpClient.install(HttpTimeout.INSTANCE, new Function1() { // from class: io.adn.sdk.internal.di.modules.NetworkModuleImpl$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit httpClient_delegate$lambda$8$lambda$7$lambda$6;
                httpClient_delegate$lambda$8$lambda$7$lambda$6 = NetworkModuleImpl.httpClient_delegate$lambda$8$lambda$7$lambda$6((HttpTimeout.HttpTimeoutCapabilityConfiguration) obj);
                return httpClient_delegate$lambda$8$lambda$7$lambda$6;
            }
        });
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit httpClient_delegate$lambda$8$lambda$7$lambda$3(NetworkModuleImpl networkModuleImpl, UserAgent.Config install) {
        Intrinsics.checkNotNullParameter(install, "$this$install");
        install.setAgent(networkModuleImpl.getUserAgent());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit httpClient_delegate$lambda$8$lambda$7$lambda$5(ContentNegotiation.Config install) {
        Intrinsics.checkNotNullParameter(install, "$this$install");
        JsonSupportKt.json$default(install, JsonKt.Json$default(null, new Function1() { // from class: io.adn.sdk.internal.di.modules.NetworkModuleImpl$$ExternalSyntheticLambda7
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit httpClient_delegate$lambda$8$lambda$7$lambda$5$lambda$4;
                httpClient_delegate$lambda$8$lambda$7$lambda$5$lambda$4 = NetworkModuleImpl.httpClient_delegate$lambda$8$lambda$7$lambda$5$lambda$4((JsonBuilder) obj);
                return httpClient_delegate$lambda$8$lambda$7$lambda$5$lambda$4;
            }
        }, 1, null), null, 2, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit httpClient_delegate$lambda$8$lambda$7$lambda$5$lambda$4(JsonBuilder Json) {
        Intrinsics.checkNotNullParameter(Json, "$this$Json");
        Json.setIgnoreUnknownKeys(true);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit httpClient_delegate$lambda$8$lambda$7$lambda$6(HttpTimeout.HttpTimeoutCapabilityConfiguration install) {
        Intrinsics.checkNotNullParameter(install, "$this$install");
        install.setRequestTimeoutMillis(30000L);
        install.setSocketTimeoutMillis(30000L);
        return Unit.INSTANCE;
    }
}
