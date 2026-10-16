package io.adn.sdk.internal.ui.fullscreen.mapper;

import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import io.adn.sdk.R;
import io.adn.sdk.internal.domain.model.ad.AdPromotedApp;
import io.adn.sdk.internal.domain.model.ad.ClickCoordinates;
import io.adn.sdk.internal.domain.model.ad.ClickData;
import io.adn.sdk.internal.domain.model.ad.DisplayMode;
import io.adn.sdk.internal.domain.model.ad.FullscreenAdScene;
import io.adn.sdk.internal.domain.model.ad.RedirectionStrategy;
import io.adn.sdk.internal.ui.common.model.ClickPosition;
import io.adn.sdk.internal.ui.fullscreen.model.FullscreenAdSceneUiState;
import io.adn.sdk.internal.ui.fullscreen.model.PromotedAppUiState;
import io.adn.sdk.publisher.AdnClickElement;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: FullscreenAdUiMapper.kt */
@Metadata(d1 = {"\u0000p\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0000\u001a\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0002\u001a\u00020\u0006H\u0000\u001a\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0002\u001a\u00020\tH\u0000\u001a\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0002\u001a\u00020\fH\u0000\u001a\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0000\u001aQ\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u001b2\b\b\u0002\u0010\u001c\u001a\u00020\u001b2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0000¢\u0006\u0002\u0010\u001f\u001a\u0010\u0010 \u001a\u00020\u001b2\u0006\u0010!\u001a\u00020\"H\u0002\u001a\u0010\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\u001bH\u0002¨\u0006&"}, d2 = {"mapToFullscreenHtmlSceneUiState", "Lio/adn/sdk/internal/ui/fullscreen/model/FullscreenAdSceneUiState$Html;", "scene", "Lio/adn/sdk/internal/domain/model/ad/FullscreenAdScene$Html;", "mapToFullscreenImageSceneUiState", "Lio/adn/sdk/internal/ui/fullscreen/model/FullscreenAdSceneUiState$Image;", "Lio/adn/sdk/internal/domain/model/ad/FullscreenAdScene$Image;", "mapToFullscreenPromotedAppCardUiState", "Lio/adn/sdk/internal/ui/fullscreen/model/FullscreenAdSceneUiState$PromotedAppCard;", "Lio/adn/sdk/internal/domain/model/ad/FullscreenAdScene$PromotedAppCard;", "mapToFullscreenVideoSceneUiState", "Lio/adn/sdk/internal/ui/fullscreen/model/FullscreenAdSceneUiState$Video;", "Lio/adn/sdk/internal/domain/model/ad/FullscreenAdScene$Video;", "mapToPromotedAppUiState", "Lio/adn/sdk/internal/ui/fullscreen/model/PromotedAppUiState;", "promotedApp", "Lio/adn/sdk/internal/domain/model/ad/AdPromotedApp;", "mapToClickData", "Lio/adn/sdk/internal/domain/model/ad/ClickData;", "assetId", "", "assetType", "element", "Lio/adn/sdk/publisher/AdnClickElement;", "clickPosition", "Lio/adn/sdk/internal/ui/common/model/ClickPosition;", "isAutomatic", "", "isExternalRedirection", "showTime", "", "(Ljava/lang/String;Ljava/lang/String;Lio/adn/sdk/publisher/AdnClickElement;Lio/adn/sdk/internal/ui/common/model/ClickPosition;ZZLjava/lang/Long;)Lio/adn/sdk/internal/domain/model/ad/ClickData;", "mapRedirectionStrategy", "redirectionStrategy", "Lio/adn/sdk/internal/domain/model/ad/RedirectionStrategy;", "mapCloseIcon", "", "isLastScene", "adn-sdk_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes7.dex */
public final class FullscreenAdUiMapperKt {
    public static final FullscreenAdSceneUiState.Html mapToFullscreenHtmlSceneUiState(FullscreenAdScene.Html scene) {
        Intrinsics.checkNotNullParameter(scene, "scene");
        AdPromotedApp promotedApp = scene.getPromotedApp();
        return new FullscreenAdSceneUiState.Html(promotedApp != null ? mapToPromotedAppUiState(promotedApp) : null, scene.getConfig().getCloseConfig(), mapCloseIcon(scene.isLastScene()), null, false, scene.getConfig(), 8, null);
    }

    public static final FullscreenAdSceneUiState.Image mapToFullscreenImageSceneUiState(FullscreenAdScene.Image scene) {
        Intrinsics.checkNotNullParameter(scene, "scene");
        AdPromotedApp promotedApp = scene.getPromotedApp();
        return new FullscreenAdSceneUiState.Image(promotedApp != null ? mapToPromotedAppUiState(promotedApp) : null, scene.getConfig().getCloseConfig(), mapCloseIcon(scene.isLastScene()), mapRedirectionStrategy(scene.getConfig().getRedirectionStrategy()), null, scene.getConfig(), 16, null);
    }

    public static final FullscreenAdSceneUiState.PromotedAppCard mapToFullscreenPromotedAppCardUiState(FullscreenAdScene.PromotedAppCard scene) {
        Intrinsics.checkNotNullParameter(scene, "scene");
        return new FullscreenAdSceneUiState.PromotedAppCard(mapToPromotedAppUiState(scene.getPromotedApp()), scene.getConfig().getCloseConfig(), mapCloseIcon(scene.isLastScene()), scene.getConfig().getDisplayMode() == DisplayMode.BlurOverlay ? Color.m4062copywmQWz5c$default(Color.INSTANCE.m4089getBlack0d7_KjU(), 0.7f, 0.0f, 0.0f, 0.0f, 14, null) : ColorKt.Color(4063574325L), mapRedirectionStrategy(scene.getConfig().getRedirectionStrategy()), scene.getConfig(), null);
    }

    public static final FullscreenAdSceneUiState.Video mapToFullscreenVideoSceneUiState(FullscreenAdScene.Video scene) {
        Intrinsics.checkNotNullParameter(scene, "scene");
        AdPromotedApp promotedApp = scene.getPromotedApp();
        return new FullscreenAdSceneUiState.Video(promotedApp != null ? mapToPromotedAppUiState(promotedApp) : null, scene.getConfig().getCloseConfig(), mapCloseIcon(scene.isLastScene()), mapRedirectionStrategy(scene.getConfig().getRedirectionStrategy()), null, scene.isMute(), scene.getConfig(), 16, null);
    }

    public static final PromotedAppUiState mapToPromotedAppUiState(AdPromotedApp promotedApp) {
        Intrinsics.checkNotNullParameter(promotedApp, "promotedApp");
        return new PromotedAppUiState(null, promotedApp.getIconUrl(), promotedApp.getName(), promotedApp.getDescription());
    }

    public static /* synthetic */ ClickData mapToClickData$default(String str, String str2, AdnClickElement adnClickElement, ClickPosition clickPosition, boolean z, boolean z2, Long l, int i, Object obj) {
        if ((i & 16) != 0) {
            z = false;
        }
        boolean z3 = z;
        if ((i & 32) != 0) {
            z2 = true;
        }
        return mapToClickData(str, str2, adnClickElement, clickPosition, z3, z2, l);
    }

    public static final ClickData mapToClickData(String str, String str2, AdnClickElement element, ClickPosition clickPosition, boolean z, boolean z2, Long l) {
        Intrinsics.checkNotNullParameter(element, "element");
        return new ClickData(str, str2, z, element, clickPosition != null ? new ClickCoordinates(clickPosition.getX(), clickPosition.getY()) : null, z2, l != null ? Long.valueOf(System.currentTimeMillis() - l.longValue()) : null);
    }

    private static final boolean mapRedirectionStrategy(RedirectionStrategy redirectionStrategy) {
        return redirectionStrategy != RedirectionStrategy.DisableAll;
    }

    private static final int mapCloseIcon(boolean z) {
        return z ? R.drawable.adn_ic_close : R.drawable.adn_ic_skip;
    }
}
