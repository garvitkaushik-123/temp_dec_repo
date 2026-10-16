package io.adn.sdk.internal.di.modules;

import io.adn.sdk.internal.domain.repository.AdFileLoader;
import io.adn.sdk.internal.domain.repository.FullscreenAdSceneLoader;
import io.adn.sdk.internal.domain.repository.VastLoader;
import kotlin.Metadata;

/* compiled from: AdLoaderModule.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b`\u0018\u00002\u00020\u0001R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0012\u0010\n\u001a\u00020\u000bX¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lio/adn/sdk/internal/di/modules/AdLoaderModule;", "", "fileLoader", "Lio/adn/sdk/internal/domain/repository/AdFileLoader;", "getFileLoader", "()Lio/adn/sdk/internal/domain/repository/AdFileLoader;", "vastAdLoader", "Lio/adn/sdk/internal/domain/repository/VastLoader;", "getVastAdLoader", "()Lio/adn/sdk/internal/domain/repository/VastLoader;", "adSceneLoader", "Lio/adn/sdk/internal/domain/repository/FullscreenAdSceneLoader;", "getAdSceneLoader", "()Lio/adn/sdk/internal/domain/repository/FullscreenAdSceneLoader;", "adn-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes7.dex */
public interface AdLoaderModule {
    FullscreenAdSceneLoader getAdSceneLoader();

    AdFileLoader getFileLoader();

    VastLoader getVastAdLoader();
}
