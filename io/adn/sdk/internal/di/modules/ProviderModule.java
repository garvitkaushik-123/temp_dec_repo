package io.adn.sdk.internal.di.modules;

import android.content.Context;
import io.adn.sdk.internal.data.api.local.SharedPreferencesApi;
import kotlin.Metadata;
import kotlinx.serialization.json.Json;

/* compiled from: ProviderModule.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b`\u0018\u00002\u00020\u0001R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0012\u0010\n\u001a\u00020\u000bX¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lio/adn/sdk/internal/di/modules/ProviderModule;", "", "appContext", "Landroid/content/Context;", "getAppContext", "()Landroid/content/Context;", "json", "Lkotlinx/serialization/json/Json;", "getJson", "()Lkotlinx/serialization/json/Json;", "sharedPreferencesApi", "Lio/adn/sdk/internal/data/api/local/SharedPreferencesApi;", "getSharedPreferencesApi", "()Lio/adn/sdk/internal/data/api/local/SharedPreferencesApi;", "adn-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes7.dex */
public interface ProviderModule {
    Context getAppContext();

    Json getJson();

    SharedPreferencesApi getSharedPreferencesApi();
}
