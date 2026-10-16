package io.adn.sdk.internal.domain.model.ad;

import io.adn.sdk.internal.domain.model.ad.NativeAdAsset;
import io.adn.sdk.publisher.AdnAdInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: NativeAdEntity.kt */
@Metadata(d1 = {"\u0000(\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a(\u0010\u0000\u001a\u0004\u0018\u0001H\u0001\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0002*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0080\b¢\u0006\u0002\u0010\u0006\u001a\u000e\u0010\u0007\u001a\u0004\u0018\u00010\b*\u00020\u0003H\u0000\u001a\f\u0010\t\u001a\u00020\n*\u00020\u0003H\u0000\u001a\f\u0010\u000b\u001a\u00020\b*\u00020\fH\u0000¨\u0006\r"}, d2 = {"getTypedAssetById", "T", "Lio/adn/sdk/internal/domain/model/ad/NativeAdAsset;", "Lio/adn/sdk/internal/domain/model/ad/NativeAdEntity;", "id", "", "(Lio/adn/sdk/internal/domain/model/ad/NativeAdEntity;I)Lio/adn/sdk/internal/domain/model/ad/NativeAdAsset;", "mainCreativeAnalyticsType", "", "toPublicAdInfo", "Lio/adn/sdk/publisher/AdnAdInfo;", "toAnalyticsType", "Lio/adn/sdk/internal/domain/model/ad/NativeAdAsset$Media;", "adn-sdk_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes7.dex */
public final class NativeAdEntityKt {
    public static final /* synthetic */ <T extends NativeAdAsset> T getTypedAssetById(NativeAdEntity nativeAdEntity, int i) {
        Object obj;
        Intrinsics.checkNotNullParameter(nativeAdEntity, "<this>");
        List<NativeAdAsset> assets = nativeAdEntity.getAssets();
        ArrayList arrayList = new ArrayList();
        for (Object obj2 : assets) {
            Intrinsics.reifiedOperationMarker(3, "T");
            if (obj2 instanceof Object) {
                arrayList.add(obj2);
            }
        }
        Iterator it = arrayList.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (((NativeAdAsset) obj).getId() == i) {
                break;
            }
        }
        return (T) obj;
    }

    public static final String mainCreativeAnalyticsType(NativeAdEntity nativeAdEntity) {
        Intrinsics.checkNotNullParameter(nativeAdEntity, "<this>");
        NativeAdAsset.Media mainMedia = nativeAdEntity.getMainMedia();
        if (mainMedia instanceof NativeAdAsset.Media.Image) {
            return "image";
        }
        if (mainMedia instanceof NativeAdAsset.Media.Video) {
            return "video";
        }
        return null;
    }

    public static final AdnAdInfo toPublicAdInfo(NativeAdEntity nativeAdEntity) {
        Intrinsics.checkNotNullParameter(nativeAdEntity, "<this>");
        return new AdnAdInfo(nativeAdEntity.getExtra().getCreativeId(), mainCreativeAnalyticsType(nativeAdEntity), nativeAdEntity.getExtra().getCampaignId(), nativeAdEntity.getExtra().getPrice(), nativeAdEntity.getExtra().getId());
    }

    public static final String toAnalyticsType(NativeAdAsset.Media media) {
        Intrinsics.checkNotNullParameter(media, "<this>");
        if (media instanceof NativeAdAsset.Media.Video) {
            return "video";
        }
        if (media instanceof NativeAdAsset.Media.Image) {
            return "image";
        }
        throw new NoWhenBranchMatchedException();
    }
}
