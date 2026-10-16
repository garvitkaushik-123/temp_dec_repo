package io.adn.sdk.internal.ui.nativead.mapper;

import io.adn.sdk.internal.common.utils.FileKt;
import io.adn.sdk.internal.domain.model.ad.ClickCoordinates;
import io.adn.sdk.internal.domain.model.ad.ClickData;
import io.adn.sdk.internal.domain.model.ad.NativeAdAsset;
import io.adn.sdk.internal.ui.common.model.ClickPosition;
import io.adn.sdk.internal.ui.nativead.state.NativeAdImageUiState;
import io.adn.sdk.internal.ui.nativead.state.NativeAdVideoUiState;
import io.adn.sdk.publisher.AdnClickElement;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: NativeAdUiMapper.kt */
@Metadata(d1 = {"\u00002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0000\u001a\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0002\u001a\u00020\u0006H\u0000\u001a0\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u000eH\u0000¨\u0006\u0010"}, d2 = {"mapToNativeAdVideoUiState", "Lio/adn/sdk/internal/ui/nativead/state/NativeAdVideoUiState;", "asset", "Lio/adn/sdk/internal/domain/model/ad/NativeAdAsset$Media$Video;", "mapToNativeAdImageUiState", "Lio/adn/sdk/internal/ui/nativead/state/NativeAdImageUiState;", "Lio/adn/sdk/internal/domain/model/ad/NativeAdAsset$Media$Image;", "mapToClickTrackingData", "Lio/adn/sdk/internal/domain/model/ad/ClickData;", "element", "Lio/adn/sdk/publisher/AdnClickElement;", "clickPosition", "Lio/adn/sdk/internal/ui/common/model/ClickPosition;", "isAutomatic", "", "isExternalRedirection", "adn-sdk_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes7.dex */
public final class NativeAdUiMapperKt {
    public static final NativeAdVideoUiState mapToNativeAdVideoUiState(NativeAdAsset.Media.Video asset) {
        Intrinsics.checkNotNullParameter(asset, "asset");
        return new NativeAdVideoUiState(asset.getUuid(), asset.getResource().getFile(), true, true, false, false, 0L, 112, null);
    }

    public static final NativeAdImageUiState mapToNativeAdImageUiState(NativeAdAsset.Media.Image asset) {
        Intrinsics.checkNotNullParameter(asset, "asset");
        String uuid = asset.getUuid();
        File file = asset.getResource().getFile();
        boolean existsAndNotEmpty = FileKt.existsAndNotEmpty(file);
        String str = file;
        if (!existsAndNotEmpty) {
            str = null;
        }
        if (str == null) {
            str = asset.getUrl();
        }
        return new NativeAdImageUiState(uuid, str);
    }

    public static /* synthetic */ ClickData mapToClickTrackingData$default(AdnClickElement adnClickElement, ClickPosition clickPosition, boolean z, boolean z2, int i, Object obj) {
        if ((i & 2) != 0) {
            clickPosition = null;
        }
        if ((i & 4) != 0) {
            z = false;
        }
        if ((i & 8) != 0) {
            z2 = false;
        }
        return mapToClickTrackingData(adnClickElement, clickPosition, z, z2);
    }

    public static final ClickData mapToClickTrackingData(AdnClickElement element, ClickPosition clickPosition, boolean z, boolean z2) {
        Intrinsics.checkNotNullParameter(element, "element");
        return new ClickData(null, null, z, element, clickPosition != null ? new ClickCoordinates(clickPosition.getX(), clickPosition.getY()) : null, z2, null);
    }
}
