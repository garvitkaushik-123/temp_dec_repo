package io.adn.sdk.internal.data.mapper;

import com.google.firebase.analytics.FirebaseAnalytics;
import io.adn.sdk.internal.domain.error.AdError;
import io.adn.sdk.internal.domain.error.AdException;
import io.adn.sdk.internal.domain.model.ad.AdCloseConfig;
import io.adn.sdk.internal.domain.model.ad.AdConfig;
import io.adn.sdk.internal.domain.model.ad.AdConfigKt;
import io.adn.sdk.internal.domain.model.ad.AdCreativeConfig;
import io.adn.sdk.internal.domain.model.ad.AdCtaConfig;
import io.adn.sdk.internal.domain.model.ad.AdLink;
import io.adn.sdk.internal.domain.model.ad.AdMuteConfig;
import io.adn.sdk.internal.domain.model.ad.AdPrivacyConfig;
import io.adn.sdk.internal.domain.model.ad.AdProgressConfig;
import io.adn.sdk.internal.domain.model.ad.AdPromotedApp;
import io.adn.sdk.internal.domain.model.ad.AdStoreConfig;
import io.adn.sdk.internal.domain.model.ad.BidResponse;
import io.adn.sdk.internal.domain.model.ad.DisplayMode;
import io.adn.sdk.internal.domain.model.ad.FullscreenAdEntity;
import io.adn.sdk.internal.domain.model.ad.FullscreenAdScene;
import io.adn.sdk.internal.domain.model.ad.FullscreenAdSceneConfig;
import io.adn.sdk.internal.domain.model.ad.HtmlContent;
import io.adn.sdk.internal.domain.model.ad.RedirectionStrategy;
import io.adn.sdk.internal.domain.model.ad.VastAdEntity;
import io.adn.sdk.internal.domain.model.ad.VastCreative;
import io.adn.sdk.internal.domain.model.ad.VastExtension;
import io.adn.sdk.internal.domain.model.ad.VastResource;
import io.adn.sdk.publisher.AdnAdPlacement;
import io.bidmachine.ads.networks.vast.VastAdapter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: FullscreenAdMapper.kt */
@Metadata(d1 = {"\u0000\u0098\u0001\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0018\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0000\u001aH\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0002\u001aH\u0010\u0017\u001a\u00020\u00182\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0019\u001a\u00020\u001a2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0002\u001a8\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u000e2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#H\u0002\u001a\u0016\u0010$\u001a\u00020%2\f\u0010&\u001a\b\u0012\u0004\u0012\u00020%0\rH\u0002\u001a\u001c\u0010'\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\f\u0010(\u001a\b\u0012\u0004\u0012\u00020)0\rH\u0002\u001a\u0010\u0010*\u001a\u00020+2\u0006\u0010\u0013\u001a\u00020,H\u0002\u001a\u0010\u0010-\u001a\u00020.2\u0006\u0010\u0013\u001a\u00020,H\u0002\u001a\u0018\u0010/\u001a\u0002002\u0006\u0010\u0013\u001a\u00020,2\u0006\u0010\"\u001a\u00020#H\u0002\u001a \u00101\u001a\u0002022\u0006\u0010\u001f\u001a\u00020\u000e2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#H\u0002¨\u00063"}, d2 = {"mapToFullscreenAd", "Lio/adn/sdk/internal/domain/model/ad/FullscreenAdEntity;", VastAdapter.KEY, "Lio/adn/sdk/internal/domain/model/ad/VastAdEntity;", "bidResponse", "Lio/adn/sdk/internal/domain/model/ad/BidResponse;", "mapLinearCreative", "Lio/adn/sdk/internal/domain/model/ad/FullscreenAdScene$Video;", FirebaseAnalytics.Param.INDEX, "", "linear", "Lio/adn/sdk/internal/domain/model/ad/VastCreative$Linear;", "redirectionTracking", "", "", "placement", "Lio/adn/sdk/publisher/AdnAdPlacement;", "promotedApp", "Lio/adn/sdk/internal/domain/model/ad/AdPromotedApp;", "config", "Lio/adn/sdk/internal/domain/model/ad/AdConfig;", "isLastScene", "", "mapCompanionCreative", "Lio/adn/sdk/internal/domain/model/ad/FullscreenAdScene;", "companion", "Lio/adn/sdk/internal/domain/model/ad/VastCreative$Companion;", "mapPromotedAppCard", "Lio/adn/sdk/internal/domain/model/ad/FullscreenAdScene$PromotedAppCard;", "link", "Lio/adn/sdk/internal/domain/model/ad/AdLink$Fullscreen;", "ctaText", "redirectionStrategy", "Lio/adn/sdk/internal/domain/model/ad/RedirectionStrategy;", "displayMode", "Lio/adn/sdk/internal/domain/model/ad/DisplayMode;", "selectHighestPriorityResource", "Lio/adn/sdk/internal/domain/model/ad/VastResource;", "resources", "getRedirectionTracking", "extensions", "Lio/adn/sdk/internal/domain/model/ad/VastExtension;", "mapAdVideoConfig", "Lio/adn/sdk/internal/domain/model/ad/FullscreenAdSceneConfig$Video;", "Lio/adn/sdk/internal/domain/model/ad/AdCreativeConfig;", "mapImageConfig", "Lio/adn/sdk/internal/domain/model/ad/FullscreenAdSceneConfig$Image;", "mapHtmlConfig", "Lio/adn/sdk/internal/domain/model/ad/FullscreenAdSceneConfig$Html;", "mapPromotedAppCardConfig", "Lio/adn/sdk/internal/domain/model/ad/FullscreenAdSceneConfig$PromotedAppCard;", "adn-sdk_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes7.dex */
public final class FullscreenAdMapperKt {
    public static final FullscreenAdEntity mapToFullscreenAd(VastAdEntity vast, BidResponse bidResponse) {
        FullscreenAdScene fullscreenAdScene;
        FullscreenAdScene.Video mapCompanionCreative;
        Intrinsics.checkNotNullParameter(vast, "vast");
        Intrinsics.checkNotNullParameter(bidResponse, "bidResponse");
        AdConfig adConfig = bidResponse.getAdConfig();
        AdPromotedApp promotedApp = bidResponse.getPromotedApp();
        AdnAdPlacement placement = bidResponse.getPlacement();
        List<String> redirectionTracking = getRedirectionTracking(vast.getExtensions());
        int i = (!adConfig.getPromotedAppCardEnabled() || promotedApp == null) ? 0 : 1;
        int lastIndex = CollectionsKt.getLastIndex(vast.getCreatives()) + i;
        List<VastCreative> creatives = vast.getCreatives();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(creatives, 10));
        int i2 = 0;
        for (Object obj : creatives) {
            int i3 = i2 + 1;
            if (i2 < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            VastCreative vastCreative = (VastCreative) obj;
            boolean z = i2 == lastIndex;
            if (vastCreative instanceof VastCreative.Linear) {
                mapCompanionCreative = mapLinearCreative(i2, (VastCreative.Linear) vastCreative, redirectionTracking, placement, promotedApp, adConfig, z);
            } else {
                if (!(vastCreative instanceof VastCreative.Companion)) {
                    throw new NoWhenBranchMatchedException();
                }
                mapCompanionCreative = mapCompanionCreative(i2, (VastCreative.Companion) vastCreative, redirectionTracking, placement, promotedApp, adConfig, z);
            }
            arrayList.add(mapCompanionCreative);
            i2 = i3;
        }
        List mutableList = CollectionsKt.toMutableList((Collection) arrayList);
        if (i != 0 && (fullscreenAdScene = (FullscreenAdScene) CollectionsKt.lastOrNull(mutableList)) != null) {
            mutableList.add(mapPromotedAppCard(lastIndex, promotedApp, fullscreenAdScene.getLink(), fullscreenAdScene.getConfig().getCtaConfig().getText(), adConfig.getPromotedAppCardRedirectionStrategy(), adConfig.getEndCardDisplayMode()));
        }
        return new FullscreenAdEntity(placement, mutableList, vast.getImpressionTracking(), bidResponse.getExtras());
    }

    private static final FullscreenAdScene.Video mapLinearCreative(int i, VastCreative.Linear linear, List<String> list, AdnAdPlacement adnAdPlacement, AdPromotedApp adPromotedApp, AdConfig adConfig, boolean z) {
        return new FullscreenAdScene.Video(i, linear.getId(), null, linear.getMediaFileUrl(), false, z, new AdLink.Fullscreen(linear.getClickThroughUrl(), linear.getClickTracking(), list), adPromotedApp, mapAdVideoConfig(AdConfigKt.getCreativeConfigOrDefault(adConfig, adnAdPlacement, i)), AdVideoTrackingMapperKt.mapToAdVideoTracking(linear.getTracking()), false, 1028, null);
    }

    private static final FullscreenAdScene mapCompanionCreative(int i, VastCreative.Companion companion, List<String> list, AdnAdPlacement adnAdPlacement, AdPromotedApp adPromotedApp, AdConfig adConfig, boolean z) {
        HtmlContent.Downloadable downloadable;
        VastResource selectHighestPriorityResource = selectHighestPriorityResource(companion.getResources());
        AdCreativeConfig creativeConfigOrDefault = AdConfigKt.getCreativeConfigOrDefault(adConfig, adnAdPlacement, i);
        AdLink.Fullscreen fullscreen = new AdLink.Fullscreen(companion.getClickThroughUrl(), companion.getClickTracking(), list);
        boolean areEqual = Intrinsics.areEqual(companion.getType(), "end-card");
        DisplayMode endCardDisplayMode = areEqual ? adConfig.getEndCardDisplayMode() : DisplayMode.Push;
        if (selectHighestPriorityResource instanceof VastResource.Image) {
            return new FullscreenAdScene.Image(i, companion.getId(), null, ((VastResource.Image) selectHighestPriorityResource).getUrl(), z, fullscreen, adPromotedApp, mapImageConfig(creativeConfigOrDefault), false, 260, null);
        }
        if (selectHighestPriorityResource instanceof VastResource.IFrame) {
            String id = companion.getId();
            if (areEqual) {
                downloadable = new HtmlContent.NonDownloadable(((VastResource.IFrame) selectHighestPriorityResource).getUrl(), true);
            } else {
                downloadable = new HtmlContent.Downloadable(((VastResource.IFrame) selectHighestPriorityResource).getUrl(), false, 2, null);
            }
            return new FullscreenAdScene.Html(i, id, null, downloadable, areEqual, z, fullscreen, adPromotedApp, mapHtmlConfig(creativeConfigOrDefault, endCardDisplayMode), 4, null);
        }
        if (!(selectHighestPriorityResource instanceof VastResource.Html)) {
            throw new NoWhenBranchMatchedException();
        }
        return new FullscreenAdScene.Html(i, companion.getId(), null, new HtmlContent.Embedded(((VastResource.Html) selectHighestPriorityResource).getContent(), false, 2, null), areEqual, z, fullscreen, adPromotedApp, mapHtmlConfig(creativeConfigOrDefault, endCardDisplayMode), 4, null);
    }

    private static final FullscreenAdScene.PromotedAppCard mapPromotedAppCard(int i, AdPromotedApp adPromotedApp, AdLink.Fullscreen fullscreen, String str, RedirectionStrategy redirectionStrategy, DisplayMode displayMode) {
        return new FullscreenAdScene.PromotedAppCard(i, null, null, adPromotedApp, fullscreen, mapPromotedAppCardConfig(str, redirectionStrategy, displayMode), false, false, 198, null);
    }

    private static final VastResource selectHighestPriorityResource(List<? extends VastResource> list) {
        Object next;
        Iterator<T> it = list.iterator();
        if (it.hasNext()) {
            next = it.next();
            if (it.hasNext()) {
                int priority = ((VastResource) next).getPriority();
                do {
                    Object next2 = it.next();
                    int priority2 = ((VastResource) next2).getPriority();
                    if (priority > priority2) {
                        next = next2;
                        priority = priority2;
                    }
                } while (it.hasNext());
            }
        } else {
            next = null;
        }
        VastResource vastResource = (VastResource) next;
        if (vastResource != null) {
            return vastResource;
        }
        throw new AdException(AdError.NoCompanionCreativesError, null, 2, null);
    }

    private static final List<String> getRedirectionTracking(List<VastExtension> list) {
        Object obj;
        Iterator<T> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (Intrinsics.areEqual(((VastExtension) obj).getName(), "redirection")) {
                break;
            }
        }
        VastExtension vastExtension = (VastExtension) obj;
        List<String> customEvents = vastExtension != null ? vastExtension.getCustomEvents() : null;
        return customEvents == null ? CollectionsKt.emptyList() : customEvents;
    }

    private static final FullscreenAdSceneConfig.Video mapAdVideoConfig(AdCreativeConfig adCreativeConfig) {
        AdCloseConfig closeConfig = adCreativeConfig.getCloseConfig();
        AdPrivacyConfig privacyConfig = adCreativeConfig.getPrivacyConfig();
        AdStoreConfig storeOverlayConfig = adCreativeConfig.getStoreOverlayConfig();
        AdProgressConfig progressbarConfig = adCreativeConfig.getProgressbarConfig();
        AdMuteConfig muteConfig = adCreativeConfig.getMuteConfig();
        AdCtaConfig ctaConfig = adCreativeConfig.getCtaConfig();
        boolean autoCloseEnabled = adCreativeConfig.getAutoCloseEnabled();
        return new FullscreenAdSceneConfig.Video(closeConfig, privacyConfig, storeOverlayConfig, ctaConfig, adCreativeConfig.getRedirectionStrategy(), DisplayMode.Push, muteConfig, autoCloseEnabled, progressbarConfig);
    }

    private static final FullscreenAdSceneConfig.Image mapImageConfig(AdCreativeConfig adCreativeConfig) {
        return new FullscreenAdSceneConfig.Image(adCreativeConfig.getCloseConfig(), adCreativeConfig.getPrivacyConfig(), adCreativeConfig.getStoreOverlayConfig(), adCreativeConfig.getCtaConfig(), DisplayMode.Push, adCreativeConfig.getRedirectionStrategy());
    }

    private static final FullscreenAdSceneConfig.Html mapHtmlConfig(AdCreativeConfig adCreativeConfig, DisplayMode displayMode) {
        return new FullscreenAdSceneConfig.Html(adCreativeConfig.getCloseConfig(), adCreativeConfig.getPrivacyConfig(), adCreativeConfig.getStoreOverlayConfig(), adCreativeConfig.getCtaConfig(), adCreativeConfig.getRedirectionStrategy(), displayMode, adCreativeConfig.getLoadingStrategy(), adCreativeConfig.getLoadingCardEnabled());
    }

    private static final FullscreenAdSceneConfig.PromotedAppCard mapPromotedAppCardConfig(String str, RedirectionStrategy redirectionStrategy, DisplayMode displayMode) {
        return new FullscreenAdSceneConfig.PromotedAppCard(new AdCloseConfig(null, 2, 0.0f, null, 0, 0, 61, null), new AdCtaConfig(false, str, 0, null, 0, 0, 61, null), redirectionStrategy, new AdPrivacyConfig(false, null, 0, 0, 15, null), displayMode, new AdStoreConfig(0.0d, false, false, 7, null));
    }
}
