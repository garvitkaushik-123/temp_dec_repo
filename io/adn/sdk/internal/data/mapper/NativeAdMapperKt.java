package io.adn.sdk.internal.data.mapper;

import io.adn.sdk.internal.data.dto.AdMeasurementVerificationResourceDto;
import io.adn.sdk.internal.data.dto.EventTrackerDto;
import io.adn.sdk.internal.data.dto.NativeAdDataDto;
import io.adn.sdk.internal.data.dto.NativeAdExtDto;
import io.adn.sdk.internal.data.dto.NativeAdLinkDto;
import io.adn.sdk.internal.data.dto.NativeAdTitleDto;
import io.adn.sdk.internal.domain.model.ad.AdLink;
import io.adn.sdk.internal.domain.model.ad.LoadedFile;
import io.adn.sdk.internal.domain.model.ad.NativeAdAsset;
import io.adn.sdk.internal.domain.model.ad.NativeAdAssetMetadata;
import io.adn.sdk.internal.domain.model.ad.VastCreative;
import io.adn.sdk.internal.thirdparty.omsdk.model.AdMeasurementVerificationResource;
import io.bidmachine.unified.UnifiedMediationParams;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: NativeAdMapper.kt */
@Metadata(d1 = {"\u0000|\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u0018\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0000\u001a\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\bH\u0000\u001a*\u0010\t\u001a\u00020\n2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\u000e\u001a\u00020\u000fH\u0000\u001a*\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0012\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u000e\u001a\u00020\u000fH\u0000\u001a\u0012\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\fH\u0000\u001a\u0018\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\fH\u0000\u001a\u0018\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u001d\u001a\u00020\bH\u0000\u001a\u0018\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\fH\u0000\u001a\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\fH\u0000\u001a*\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010#2\u000e\u0010$\u001a\n\u0012\u0004\u0012\u00020&\u0018\u00010%H\u0000\u001a\u001e\u0010'\u001a\b\u0012\u0004\u0012\u00020(0%2\u000e\u0010$\u001a\n\u0012\u0004\u0012\u00020&\u0018\u00010%H\u0000\u001a\u001e\u0010)\u001a\b\u0012\u0004\u0012\u00020\f0%2\u000e\u0010$\u001a\n\u0012\u0004\u0012\u00020&\u0018\u00010%H\u0000\"\u000e\u0010*\u001a\u00020\u0003X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010+\u001a\u00020\u0003X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010,\u001a\u00020\u0003X\u0082T¢\u0006\u0002\n\u0000¨\u0006-"}, d2 = {"mapToNativeAdTitle", "Lio/adn/sdk/internal/domain/model/ad/NativeAdAsset$Title;", "id", "", "dto", "Lio/adn/sdk/internal/data/dto/NativeAdTitleDto;", "mapToNativeAdData", "Lio/adn/sdk/internal/domain/model/ad/NativeAdAsset$Data;", "Lio/adn/sdk/internal/data/dto/NativeAdDataDto;", "mapToNativeAdImage", "Lio/adn/sdk/internal/domain/model/ad/NativeAdAsset$Media$Image;", UnifiedMediationParams.KEY_IMAGE_URL, "", "imageAspectRatio", "resource", "Lio/adn/sdk/internal/domain/model/ad/LoadedFile;", "mapToNativeAdVideo", "Lio/adn/sdk/internal/domain/model/ad/NativeAdAsset$Media$Video;", "aspectRatio", "vastCreative", "Lio/adn/sdk/internal/domain/model/ad/VastCreative$Linear;", "mapAspectRatio", "", "value", "mapToNativeAdTitleMetadata", "Lio/adn/sdk/internal/domain/model/ad/NativeAdAssetMetadata$TitleMetadata;", "title", "mapToNativeAdDataMetadata", "Lio/adn/sdk/internal/domain/model/ad/NativeAdAssetMetadata$DataMetadata;", "data", "mapToNativeAdLink", "Lio/adn/sdk/internal/domain/model/ad/AdLink$Native;", "link", "Lio/adn/sdk/internal/data/dto/NativeAdLinkDto;", "ext", "Lio/adn/sdk/internal/data/dto/NativeAdExtDto;", "eventTrackers", "", "Lio/adn/sdk/internal/data/dto/EventTrackerDto;", "mapAdMeasurementVerificationResources", "Lio/adn/sdk/internal/thirdparty/omsdk/model/AdMeasurementVerificationResource;", "mapPostClickTrackers", "OMID_METHOD_JAVASCRIPT", "OMID_EVENT_ID", "POST_CLICKS_EVENT_ID", "adn-sdk_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes7.dex */
public final class NativeAdMapperKt {
    private static final int OMID_EVENT_ID = 555;
    private static final int OMID_METHOD_JAVASCRIPT = 2;
    private static final int POST_CLICKS_EVENT_ID = 500;

    public static final NativeAdAsset.Title mapToNativeAdTitle(int i, NativeAdTitleDto dto) {
        Intrinsics.checkNotNullParameter(dto, "dto");
        return new NativeAdAsset.Title(i, dto.getText());
    }

    public static final NativeAdAsset.Data mapToNativeAdData(int i, NativeAdDataDto dto) {
        Intrinsics.checkNotNullParameter(dto, "dto");
        return new NativeAdAsset.Data(i, dto.getValue());
    }

    public static final NativeAdAsset.Media.Image mapToNativeAdImage(int i, String imageUrl, String str, LoadedFile resource) {
        Intrinsics.checkNotNullParameter(imageUrl, "imageUrl");
        Intrinsics.checkNotNullParameter(resource, "resource");
        return new NativeAdAsset.Media.Image(i, imageUrl, resource, mapAspectRatio(str), null, 16, null);
    }

    public static final NativeAdAsset.Media.Video mapToNativeAdVideo(int i, String str, VastCreative.Linear vastCreative, LoadedFile resource) {
        Intrinsics.checkNotNullParameter(vastCreative, "vastCreative");
        Intrinsics.checkNotNullParameter(resource, "resource");
        return new NativeAdAsset.Media.Video(i, vastCreative.getMediaFileUrl(), resource, mapAspectRatio(str), AdVideoTrackingMapperKt.mapToAdVideoTracking(vastCreative.getTracking()), null, 32, null);
    }

    public static final float mapAspectRatio(String str) {
        Object m10241constructorimpl;
        try {
            Result.Companion companion = Result.INSTANCE;
            m10241constructorimpl = Result.m10241constructorimpl(Float.valueOf(str != null ? Float.parseFloat(str) : 0.0f));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            m10241constructorimpl = Result.m10241constructorimpl(ResultKt.createFailure(th));
        }
        Float valueOf = Float.valueOf(0.0f);
        if (Result.m10247isFailureimpl(m10241constructorimpl)) {
            m10241constructorimpl = valueOf;
        }
        return ((Number) m10241constructorimpl).floatValue();
    }

    public static final NativeAdAssetMetadata.TitleMetadata mapToNativeAdTitleMetadata(int i, String title) {
        Intrinsics.checkNotNullParameter(title, "title");
        return new NativeAdAssetMetadata.TitleMetadata(i, title);
    }

    public static final NativeAdAssetMetadata.DataMetadata mapToNativeAdDataMetadata(int i, NativeAdDataDto data) {
        Intrinsics.checkNotNullParameter(data, "data");
        return new NativeAdAssetMetadata.DataMetadata(i, data.getValue());
    }

    public static final NativeAdAsset.Title mapToNativeAdTitle(int i, String title) {
        Intrinsics.checkNotNullParameter(title, "title");
        return new NativeAdAsset.Title(i, title);
    }

    public static final NativeAdAsset.Data mapToNativeAdData(int i, String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        return new NativeAdAsset.Data(i, value);
    }

    public static final AdLink.Native mapToNativeAdLink(NativeAdLinkDto link, NativeAdExtDto nativeAdExtDto, List<EventTrackerDto> list) {
        Boolean openinappbrowser;
        Intrinsics.checkNotNullParameter(link, "link");
        List<String> clicktrackers = link.getClicktrackers();
        if (clicktrackers == null) {
            clicktrackers = CollectionsKt.emptyList();
        }
        return new AdLink.Native(link.getUrl(), CollectionsKt.toMutableList((Collection) clicktrackers), (nativeAdExtDto == null || (openinappbrowser = nativeAdExtDto.getOpeninappbrowser()) == null) ? true : openinappbrowser.booleanValue(), mapPostClickTrackers(list));
    }

    public static final List<AdMeasurementVerificationResource> mapAdMeasurementVerificationResources(List<EventTrackerDto> list) {
        Integer event;
        if (list == null) {
            list = CollectionsKt.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            EventTrackerDto eventTrackerDto = (EventTrackerDto) obj;
            Integer method = eventTrackerDto.getMethod();
            if (method != null && method.intValue() == 2 && (event = eventTrackerDto.getEvent()) != null && event.intValue() == OMID_EVENT_ID) {
                arrayList.add(obj);
            }
        }
        ArrayList<EventTrackerDto> arrayList2 = arrayList;
        ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList2, 10));
        for (EventTrackerDto eventTrackerDto2 : arrayList2) {
            AdMeasurementVerificationResourceDto ext = eventTrackerDto2.getExt();
            String vendorKey = ext != null ? ext.getVendorKey() : null;
            String str = "";
            if (vendorKey == null) {
                vendorKey = "";
            }
            String url = eventTrackerDto2.getUrl();
            if (url == null) {
                url = "";
            }
            AdMeasurementVerificationResourceDto ext2 = eventTrackerDto2.getExt();
            String verificationParameters = ext2 != null ? ext2.getVerificationParameters() : null;
            if (verificationParameters != null) {
                str = verificationParameters;
            }
            arrayList3.add(new AdMeasurementVerificationResource(vendorKey, url, str));
        }
        return arrayList3;
    }

    public static final List<String> mapPostClickTrackers(List<EventTrackerDto> list) {
        if (list == null) {
            list = CollectionsKt.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        for (EventTrackerDto eventTrackerDto : list) {
            String url = eventTrackerDto.getUrl();
            Integer event = eventTrackerDto.getEvent();
            if (event == null || event.intValue() != 500) {
                url = null;
            }
            if (url != null) {
                arrayList.add(url);
            }
        }
        return arrayList;
    }
}
