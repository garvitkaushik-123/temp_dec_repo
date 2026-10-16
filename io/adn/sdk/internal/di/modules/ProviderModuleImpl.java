package io.adn.sdk.internal.di.modules;

import android.content.Context;
import io.adn.sdk.internal.data.api.local.SharedPreferencesApi;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonBuilder;
import kotlinx.serialization.json.JsonKt;

/* compiled from: ProviderModule.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0001\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001b\u0010\b\u001a\u00020\t8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000bR\u001b\u0010\u000e\u001a\u00020\u000f8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\r\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0013"}, d2 = {"Lio/adn/sdk/internal/di/modules/ProviderModuleImpl;", "Lio/adn/sdk/internal/di/modules/ProviderModule;", "appContext", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "getAppContext", "()Landroid/content/Context;", "json", "Lkotlinx/serialization/json/Json;", "getJson", "()Lkotlinx/serialization/json/Json;", "json$delegate", "Lkotlin/Lazy;", "sharedPreferencesApi", "Lio/adn/sdk/internal/data/api/local/SharedPreferencesApi;", "getSharedPreferencesApi", "()Lio/adn/sdk/internal/data/api/local/SharedPreferencesApi;", "sharedPreferencesApi$delegate", "adn-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes7.dex */
public final class ProviderModuleImpl implements ProviderModule {
    public static final int $stable = 8;
    private final Context appContext;

    /* renamed from: json$delegate, reason: from kotlin metadata */
    private final Lazy json;

    /* renamed from: sharedPreferencesApi$delegate, reason: from kotlin metadata */
    private final Lazy sharedPreferencesApi;

    public ProviderModuleImpl(Context appContext) {
        Intrinsics.checkNotNullParameter(appContext, "appContext");
        this.appContext = appContext;
        this.json = LazyKt.lazy(new Function0() { // from class: io.adn.sdk.internal.di.modules.ProviderModuleImpl$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Json json_delegate$lambda$1;
                json_delegate$lambda$1 = ProviderModuleImpl.json_delegate$lambda$1();
                return json_delegate$lambda$1;
            }
        });
        this.sharedPreferencesApi = LazyKt.lazy(new Function0() { // from class: io.adn.sdk.internal.di.modules.ProviderModuleImpl$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                SharedPreferencesApi sharedPreferencesApi_delegate$lambda$2;
                sharedPreferencesApi_delegate$lambda$2 = ProviderModuleImpl.sharedPreferencesApi_delegate$lambda$2(ProviderModuleImpl.this);
                return sharedPreferencesApi_delegate$lambda$2;
            }
        });
    }

    @Override // io.adn.sdk.internal.di.modules.ProviderModule
    public Context getAppContext() {
        return this.appContext;
    }

    @Override // io.adn.sdk.internal.di.modules.ProviderModule
    public Json getJson() {
        return (Json) this.json.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Json json_delegate$lambda$1() {
        return JsonKt.Json$default(null, new Function1() { // from class: io.adn.sdk.internal.di.modules.ProviderModuleImpl$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit json_delegate$lambda$1$lambda$0;
                json_delegate$lambda$1$lambda$0 = ProviderModuleImpl.json_delegate$lambda$1$lambda$0((JsonBuilder) obj);
                return json_delegate$lambda$1$lambda$0;
            }
        }, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit json_delegate$lambda$1$lambda$0(JsonBuilder Json) {
        Intrinsics.checkNotNullParameter(Json, "$this$Json");
        Json.setExplicitNulls(false);
        Json.setEncodeDefaults(true);
        Json.setLenient(true);
        Json.setIgnoreUnknownKeys(true);
        Json.setAllowSpecialFloatingPointValues(true);
        Json.setAllowStructuredMapKeys(true);
        Json.setPrettyPrint(false);
        Json.setUseArrayPolymorphism(false);
        return Unit.INSTANCE;
    }

    @Override // io.adn.sdk.internal.di.modules.ProviderModule
    public SharedPreferencesApi getSharedPreferencesApi() {
        return (SharedPreferencesApi) this.sharedPreferencesApi.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SharedPreferencesApi sharedPreferencesApi_delegate$lambda$2(ProviderModuleImpl providerModuleImpl) {
        return new SharedPreferencesApi(providerModuleImpl.getAppContext());
    }
}
