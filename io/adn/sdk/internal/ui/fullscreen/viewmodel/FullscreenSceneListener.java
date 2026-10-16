package io.adn.sdk.internal.ui.fullscreen.viewmodel;

import io.adn.sdk.internal.domain.error.AdException;
import io.adn.sdk.internal.domain.model.ad.ClickData;
import io.adn.sdk.internal.domain.model.ad.FullscreenAdScene;
import kotlin.Metadata;

/* compiled from: FullscreenSceneViewModel.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b`\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0003H&J\u0018\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\tH&J\u0018\u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\fH&J\u0010\u0010\r\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u000e"}, d2 = {"Lio/adn/sdk/internal/ui/fullscreen/viewmodel/FullscreenSceneListener;", "", "onSceneDisplayed", "", "scene", "Lio/adn/sdk/internal/domain/model/ad/FullscreenAdScene;", "onPrivacyPolicyClicked", "onSceneClicked", "clickData", "Lio/adn/sdk/internal/domain/model/ad/ClickData;", "onSceneError", "exception", "Lio/adn/sdk/internal/domain/error/AdException;", "onSceneClose", "adn-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes7.dex */
public interface FullscreenSceneListener {
    void onPrivacyPolicyClicked();

    void onSceneClicked(FullscreenAdScene scene, ClickData clickData);

    void onSceneClose(FullscreenAdScene scene);

    void onSceneDisplayed(FullscreenAdScene scene);

    void onSceneError(FullscreenAdScene scene, AdException exception);
}
