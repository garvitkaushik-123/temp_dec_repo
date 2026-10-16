package io.adn.sdk.internal.ui.fullscreen.mapper;

import io.adn.sdk.internal.common.utils.UriKt;
import io.adn.sdk.internal.domain.constants.AnalyticsConstants;
import io.adn.sdk.internal.domain.model.ad.ClickCoordinates;
import io.adn.sdk.internal.domain.model.ad.ClickData;
import io.adn.sdk.internal.domain.model.ad.PostClickData;
import io.adn.sdk.publisher.AdnClickElement;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AdTrackingMapper.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u001a\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0001*\u0004\u0018\u00010\u0003H\u0000\u001a\u0018\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0005H\u0000¨\u0006\u0006"}, d2 = {"buildClickMacros", "", "", "Lio/adn/sdk/internal/domain/model/ad/ClickData;", "buildPostClickMacros", "Lio/adn/sdk/internal/domain/model/ad/PostClickData;", "adn-sdk_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes7.dex */
public final class AdTrackingMapperKt {
    public static final Map<String, String> buildClickMacros(ClickData clickData) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (clickData != null) {
            String assetId = clickData.getAssetId();
            if (assetId != null) {
                linkedHashMap.put(AnalyticsConstants.ASSET_ID, assetId);
            }
            String assetType = clickData.getAssetType();
            if (assetType != null) {
                linkedHashMap.put("asset_type", assetType);
            }
            linkedHashMap.put("automatic_redirection", String.valueOf(clickData.isAutomatic()));
            linkedHashMap.put("external_redirection", String.valueOf(clickData.isExternalRedirection()));
            if (!clickData.isAutomatic()) {
                AdnClickElement clickedElement = clickData.getClickedElement();
                if (clickedElement != null) {
                    linkedHashMap.put("clicked_element", clickedElement.getKey());
                }
                ClickCoordinates clickCoordinates = clickData.getClickCoordinates();
                if (clickCoordinates != null) {
                    linkedHashMap.put("click_coordinate_x", String.valueOf(clickCoordinates.getX()));
                    linkedHashMap.put("click_coordinate_y", String.valueOf(clickCoordinates.getY()));
                }
            }
            Long timeSinceShow = clickData.getTimeSinceShow();
            if (timeSinceShow != null) {
                linkedHashMap.put("time_since_show", String.valueOf(timeSinceShow.longValue()));
            }
        }
        return linkedHashMap;
    }

    public static final Map<String, String> buildPostClickMacros(PostClickData postClickData) {
        Intrinsics.checkNotNullParameter(postClickData, "<this>");
        Map createMapBuilder = MapsKt.createMapBuilder();
        createMapBuilder.put("event_name", postClickData.getName());
        createMapBuilder.put("click_index", String.valueOf(postClickData.getSessionIndex()));
        createMapBuilder.put("page_index", String.valueOf(postClickData.getPageIndex()));
        String url = postClickData.getUrl();
        String urlEncode = url != null ? UriKt.urlEncode(url) : null;
        if (urlEncode == null) {
            urlEncode = "";
        }
        createMapBuilder.put("page_url", urlEncode);
        createMapBuilder.put("time_spent", String.valueOf(postClickData.getTimeSpent()));
        return MapsKt.build(createMapBuilder);
    }
}
