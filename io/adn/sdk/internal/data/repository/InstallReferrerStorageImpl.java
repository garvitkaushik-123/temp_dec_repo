package io.adn.sdk.internal.data.repository;

import android.content.SharedPreferences;
import io.adn.sdk.internal.data.api.local.SharedPreferencesApi;
import io.adn.sdk.internal.domain.repository.InstallReferrerStorage;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: InstallReferrerStorageImpl.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\b\u0001\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\b\u0010\b\u001a\u00020\tH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lio/adn/sdk/internal/data/repository/InstallReferrerStorageImpl;", "Lio/adn/sdk/internal/domain/repository/InstallReferrerStorage;", "preferencesApi", "Lio/adn/sdk/internal/data/api/local/SharedPreferencesApi;", "<init>", "(Lio/adn/sdk/internal/data/api/local/SharedPreferencesApi;)V", "isAlreadySent", "", "markAsSent", "", "adn-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes7.dex */
public final class InstallReferrerStorageImpl implements InstallReferrerStorage {
    public static final int $stable = 8;
    private final SharedPreferencesApi preferencesApi;

    public InstallReferrerStorageImpl(SharedPreferencesApi preferencesApi) {
        Intrinsics.checkNotNullParameter(preferencesApi, "preferencesApi");
        this.preferencesApi = preferencesApi;
    }

    @Override // io.adn.sdk.internal.domain.repository.InstallReferrerStorage
    public boolean isAlreadySent() {
        return this.preferencesApi.getSharedPreferences().getBoolean("is_install_referrer_sent", false);
    }

    @Override // io.adn.sdk.internal.domain.repository.InstallReferrerStorage
    public void markAsSent() {
        SharedPreferences.Editor edit = this.preferencesApi.getSharedPreferences().edit();
        edit.putBoolean("is_install_referrer_sent", true);
        edit.apply();
    }
}
