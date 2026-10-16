package io.adn.sdk.internal.data.mapper;

import android.graphics.Color;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.ironsource.C3040d4;
import io.adn.sdk.internal.data.dto.AdConfigDto;
import io.adn.sdk.internal.data.dto.BidResponseDto;
import io.adn.sdk.internal.data.dto.CreativeConfigDto;
import io.adn.sdk.internal.data.dto.PromotedAppDto;
import io.adn.sdk.internal.domain.constants.LayoutConfigDefaults;
import io.adn.sdk.internal.domain.model.ad.AdCloseConfig;
import io.adn.sdk.internal.domain.model.ad.AdConfig;
import io.adn.sdk.internal.domain.model.ad.AdCreativeConfig;
import io.adn.sdk.internal.domain.model.ad.AdCtaConfig;
import io.adn.sdk.internal.domain.model.ad.AdMuteConfig;
import io.adn.sdk.internal.domain.model.ad.AdPrivacyConfig;
import io.adn.sdk.internal.domain.model.ad.AdProgressConfig;
import io.adn.sdk.internal.domain.model.ad.AdPromotedApp;
import io.adn.sdk.internal.domain.model.ad.AdStoreConfig;
import io.adn.sdk.internal.domain.model.ad.BidExtra;
import io.adn.sdk.internal.domain.model.ad.BidResponse;
import io.adn.sdk.internal.domain.model.ad.DisplayMode;
import io.adn.sdk.internal.domain.model.ad.LoadingStrategy;
import io.adn.sdk.internal.domain.model.ad.RedirectionStrategy;
import io.adn.sdk.internal.domain.model.ui.CloseButtonType;
import io.adn.sdk.internal.domain.model.ui.LayoutPosition;
import io.adn.sdk.publisher.AdnAdPlacement;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: BidResponseMapper.kt */
@Metadata(d1 = {"\u0000\u0096\u0001\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\u001a\u0018\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0000\u001a\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u0005H\u0002\u001a$\u0010\b\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0002\u001a\u0018\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0002\u001a\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0010\u001a\u00020\u0011H\u0002\u001a\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0010\u001a\u00020\u0011H\u0002\u001a\u001a\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0002\u001a\u0010\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002\u001a\u0010\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002\u001a\u0014\u0010 \u001a\u0004\u0018\u00010!2\b\u0010\"\u001a\u0004\u0018\u00010\rH\u0002\u001a\u0019\u0010#\u001a\u0004\u0018\u00010\u00132\b\u0010$\u001a\u0004\u0018\u00010\u001bH\u0002¢\u0006\u0002\u0010%\u001a\u0019\u0010&\u001a\u0004\u0018\u00010\u00132\b\u0010$\u001a\u0004\u0018\u00010\u001bH\u0002¢\u0006\u0002\u0010%\u001a\u0014\u0010'\u001a\u0004\u0018\u00010(2\b\u0010$\u001a\u0004\u0018\u00010\u001bH\u0002\u001a\u001c\u0010)\u001a\u0004\u0018\u00010*2\u0006\u0010+\u001a\u00020\u00132\b\u0010$\u001a\u0004\u0018\u00010\u001bH\u0002\u001a\u0014\u0010,\u001a\u0004\u0018\u00010-2\b\u0010$\u001a\u0004\u0018\u00010\u001bH\u0002\u001a\u0014\u0010.\u001a\u0004\u0018\u00010(2\b\u0010$\u001a\u0004\u0018\u00010\u001bH\u0002\u001a\u0014\u0010/\u001a\u0004\u0018\u0001002\b\u0010$\u001a\u0004\u0018\u00010\u001bH\u0002\u001a\u0014\u00101\u001a\u0004\u0018\u0001022\b\u0010$\u001a\u0004\u0018\u00010\u001bH\u0002\u001a\u0014\u00103\u001a\u0004\u0018\u0001022\b\u0010$\u001a\u0004\u0018\u00010\u001bH\u0002\u001a\u0019\u00104\u001a\u0004\u0018\u0001052\b\u00106\u001a\u0004\u0018\u00010\u001bH\u0002¢\u0006\u0002\u00107\u001a\u0019\u00108\u001a\u0004\u0018\u00010\u00132\b\u00109\u001a\u0004\u0018\u00010\u001bH\u0002¢\u0006\u0002\u0010%¨\u0006:"}, d2 = {"mapToBidResponse", "Lio/adn/sdk/internal/domain/model/ad/BidResponse;", "placement", "Lio/adn/sdk/publisher/AdnAdPlacement;", "dto", "Lio/adn/sdk/internal/data/dto/BidResponseDto;", "mapBidExtra", "Lio/adn/sdk/internal/domain/model/ad/BidExtra;", "mapAdConfig", "Lio/adn/sdk/internal/domain/model/ad/AdConfig;", "adConfig", "Lio/adn/sdk/internal/data/dto/AdConfigDto;", "promotedApp", "Lio/adn/sdk/internal/data/dto/PromotedAppDto;", "mapCloseConfig", "Lio/adn/sdk/internal/domain/model/ad/AdCloseConfig;", "config", "Lio/adn/sdk/internal/data/dto/CreativeConfigDto;", "defaultDelay", "", "mapMuteConfig", "Lio/adn/sdk/internal/domain/model/ad/AdMuteConfig;", "mapPrivacyConfig", "Lio/adn/sdk/internal/domain/model/ad/AdPrivacyConfig;", "mapCtaConfig", "Lio/adn/sdk/internal/domain/model/ad/AdCtaConfig;", "ctaText", "", "mapMediaProgressConfig", "Lio/adn/sdk/internal/domain/model/ad/AdProgressConfig;", "mapAdStoreConfig", "Lio/adn/sdk/internal/domain/model/ad/AdStoreConfig;", "mapPromotedApp", "Lio/adn/sdk/internal/domain/model/ad/AdPromotedApp;", "info", "mapOrientation", C3040d4.h.W, "(Ljava/lang/String;)Ljava/lang/Integer;", "mapSize", "mapRedirectionStrategy", "Lio/adn/sdk/internal/domain/model/ad/RedirectionStrategy;", "mapLoadingStrategy", "Lio/adn/sdk/internal/domain/model/ad/LoadingStrategy;", FirebaseAnalytics.Param.INDEX, "mapDisplayMode", "Lio/adn/sdk/internal/domain/model/ad/DisplayMode;", "mapClickStrategy", "mapCloseType", "Lio/adn/sdk/internal/domain/model/ui/CloseButtonType;", "mapPosition", "Lio/adn/sdk/internal/domain/model/ui/LayoutPosition;", "mapProgressBarPosition", "mapBoolean", "", "intValue", "(Ljava/lang/String;)Ljava/lang/Boolean;", "mapColor", "hexColor", "adn-sdk_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes7.dex */
public final class BidResponseMapperKt {
    public static final BidResponse mapToBidResponse(AdnAdPlacement placement, BidResponseDto dto) {
        Intrinsics.checkNotNullParameter(placement, "placement");
        Intrinsics.checkNotNullParameter(dto, "dto");
        return new BidResponse(placement, dto.getAdm(), mapAdConfig(placement, dto.getAdc(), dto.getPromotedApp()), mapPromotedApp(dto.getPromotedApp()), mapOrientation(dto.getSor()), mapBidExtra(dto));
    }

    private static final BidExtra mapBidExtra(BidResponseDto bidResponseDto) {
        return new BidExtra(bidResponseDto.getId(), bidResponseDto.getBi(), bidResponseDto.getPrice(), bidResponseDto.getCrid(), bidResponseDto.getCid());
    }

    private static final AdConfig mapAdConfig(AdnAdPlacement adnAdPlacement, AdConfigDto adConfigDto, PromotedAppDto promotedAppDto) {
        List<CreativeConfigDto> s = adConfigDto != null ? adConfigDto.getS() : null;
        if (s == null) {
            s = CollectionsKt.emptyList();
        }
        List<CreativeConfigDto> list = s;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        int i = 0;
        for (Object obj : list) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            CreativeConfigDto creativeConfigDto = (CreativeConfigDto) obj;
            int closeDelay = LayoutConfigDefaults.INSTANCE.closeDelay(adnAdPlacement, i);
            Boolean mapBoolean = mapBoolean(creativeConfigDto.getAc());
            boolean booleanValue = mapBoolean != null ? mapBoolean.booleanValue() : true;
            AdCloseConfig mapCloseConfig = mapCloseConfig(creativeConfigDto, closeDelay);
            boolean z = booleanValue;
            AdMuteConfig mapMuteConfig = mapMuteConfig(creativeConfigDto);
            AdPrivacyConfig mapPrivacyConfig = mapPrivacyConfig(creativeConfigDto);
            AdCtaConfig mapCtaConfig = mapCtaConfig(creativeConfigDto, promotedAppDto != null ? promotedAppDto.getCtaText() : null);
            AdStoreConfig mapAdStoreConfig = mapAdStoreConfig(creativeConfigDto);
            AdProgressConfig mapMediaProgressConfig = mapMediaProgressConfig(creativeConfigDto);
            RedirectionStrategy mapRedirectionStrategy = mapRedirectionStrategy(creativeConfigDto.getRs());
            if (mapRedirectionStrategy == null) {
                mapRedirectionStrategy = LayoutConfigDefaults.INSTANCE.getREDIRECTION_STRATEGY();
            }
            LoadingStrategy mapLoadingStrategy = mapLoadingStrategy(i, creativeConfigDto.getAls());
            if (mapLoadingStrategy == null) {
                mapLoadingStrategy = LayoutConfigDefaults.INSTANCE.loadingStrategy(i);
            }
            Boolean mapBoolean2 = mapBoolean(creativeConfigDto.getLce());
            arrayList.add(new AdCreativeConfig(i, z, mapCloseConfig, mapMuteConfig, mapPrivacyConfig, mapCtaConfig, mapMediaProgressConfig, mapAdStoreConfig, mapRedirectionStrategy, mapLoadingStrategy, mapBoolean2 != null ? mapBoolean2.booleanValue() : false));
            i = i2;
        }
        ArrayList arrayList2 = arrayList;
        DisplayMode mapDisplayMode = mapDisplayMode(adConfigDto != null ? adConfigDto.getEcdm() : null);
        if (mapDisplayMode == null) {
            mapDisplayMode = LayoutConfigDefaults.INSTANCE.getEND_CARD_DISPLAY_MODE();
        }
        Boolean mapBoolean3 = mapBoolean(adConfigDto != null ? adConfigDto.getEce() : null);
        boolean booleanValue2 = mapBoolean3 != null ? mapBoolean3.booleanValue() : false;
        RedirectionStrategy mapClickStrategy = mapClickStrategy(adConfigDto != null ? adConfigDto.getEccs() : null);
        if (mapClickStrategy == null) {
            mapClickStrategy = LayoutConfigDefaults.INSTANCE.getPROMOTED_APP_CARD_REDIRECTION_STRATEGY();
        }
        return new AdConfig(arrayList2, mapDisplayMode, booleanValue2, mapClickStrategy);
    }

    private static final AdCloseConfig mapCloseConfig(CreativeConfigDto creativeConfigDto, int i) {
        Float floatOrNull;
        Integer intOrNull;
        CloseButtonType mapCloseType = mapCloseType(creativeConfigDto.getCbt());
        if (mapCloseType == null) {
            mapCloseType = LayoutConfigDefaults.INSTANCE.getCLOSE_TYPE();
        }
        String cbde = creativeConfigDto.getCbde();
        if (cbde != null && (intOrNull = StringsKt.toIntOrNull(cbde)) != null) {
            i = intOrNull.intValue();
        }
        int i2 = i;
        String cbcr = creativeConfigDto.getCbcr();
        float floatValue = (cbcr == null || (floatOrNull = StringsKt.toFloatOrNull(cbcr)) == null) ? 1.0f : floatOrNull.floatValue();
        LayoutPosition mapPosition = mapPosition(creativeConfigDto.getCbp());
        if (mapPosition == null) {
            mapPosition = LayoutConfigDefaults.INSTANCE.getCLOSE_POSITION();
        }
        LayoutPosition layoutPosition = mapPosition;
        Integer mapSize = mapSize(creativeConfigDto.getCbs());
        int intValue = mapSize != null ? mapSize.intValue() : 26;
        Integer mapColor = mapColor(creativeConfigDto.getCbc());
        return new AdCloseConfig(mapCloseType, i2, floatValue, layoutPosition, intValue, mapColor != null ? mapColor.intValue() : -16777216);
    }

    private static final AdMuteConfig mapMuteConfig(CreativeConfigDto creativeConfigDto) {
        LayoutPosition mapPosition = mapPosition(creativeConfigDto.getMbp());
        if (mapPosition == null) {
            mapPosition = LayoutConfigDefaults.INSTANCE.getMUTE_POSITION();
        }
        Integer mapSize = mapSize(creativeConfigDto.getMbs());
        int intValue = mapSize != null ? mapSize.intValue() : 26;
        Integer mapColor = mapColor(creativeConfigDto.getMbc());
        return new AdMuteConfig(true, mapPosition, intValue, mapColor != null ? mapColor.intValue() : -16777216);
    }

    private static final AdPrivacyConfig mapPrivacyConfig(CreativeConfigDto creativeConfigDto) {
        LayoutPosition mapPosition = mapPosition(creativeConfigDto.getPrbp());
        if (mapPosition == null) {
            mapPosition = LayoutConfigDefaults.INSTANCE.getPRIVACY_POSITION();
        }
        Integer mapSize = mapSize(creativeConfigDto.getPrbs());
        int intValue = mapSize != null ? mapSize.intValue() : 22;
        Integer mapColor = mapColor(creativeConfigDto.getPrbc());
        return new AdPrivacyConfig(true, mapPosition, intValue, mapColor != null ? mapColor.intValue() : -16777216);
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0041, code lost:
    
        if (r9 == null) goto L20;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static final AdCtaConfig mapCtaConfig(CreativeConfigDto creativeConfigDto, String str) {
        Boolean mapBoolean = mapBoolean(creativeConfigDto.getCtabe());
        boolean booleanValue = mapBoolean != null ? mapBoolean.booleanValue() : false;
        LayoutPosition mapPosition = mapPosition(creativeConfigDto.getCtabp());
        if (mapPosition == null) {
            mapPosition = LayoutConfigDefaults.INSTANCE.getCTA_POSITION();
        }
        LayoutPosition layoutPosition = mapPosition;
        Integer mapSize = mapSize(creativeConfigDto.getCtabs());
        int intValue = mapSize != null ? mapSize.intValue() : 22;
        if (str != null) {
            if (str.length() <= 0) {
                str = null;
            }
        }
        str = LayoutConfigDefaults.CTA_TEXT;
        String str2 = str;
        Integer mapColor = mapColor(creativeConfigDto.getCtabc());
        int intValue2 = mapColor != null ? mapColor.intValue() : LayoutConfigDefaults.CTA_BUTTON_COLOR;
        Integer mapColor2 = mapColor(creativeConfigDto.getCtatc());
        return new AdCtaConfig(booleanValue, str2, mapColor2 != null ? mapColor2.intValue() : -1, layoutPosition, intValue, intValue2);
    }

    private static final AdProgressConfig mapMediaProgressConfig(CreativeConfigDto creativeConfigDto) {
        Boolean mapBoolean = mapBoolean(creativeConfigDto.getPbe());
        boolean booleanValue = mapBoolean != null ? mapBoolean.booleanValue() : true;
        LayoutPosition mapProgressBarPosition = mapProgressBarPosition(creativeConfigDto.getPbp());
        if (mapProgressBarPosition == null) {
            mapProgressBarPosition = LayoutConfigDefaults.INSTANCE.getPROGRESS_BAR_POSITION();
        }
        Integer mapColor = mapColor(creativeConfigDto.getPbc());
        return new AdProgressConfig(booleanValue, mapProgressBarPosition, mapColor != null ? mapColor.intValue() : -65536);
    }

    private static final AdStoreConfig mapAdStoreConfig(CreativeConfigDto creativeConfigDto) {
        Double doubleOrNull;
        String skbdd = creativeConfigDto.getSkbdd();
        double doubleValue = (skbdd == null || (doubleOrNull = StringsKt.toDoubleOrNull(skbdd)) == null) ? -1.0d : doubleOrNull.doubleValue();
        Boolean mapBoolean = mapBoolean(creativeConfigDto.getSkbs());
        return new AdStoreConfig(doubleValue, mapBoolean != null ? mapBoolean.booleanValue() : true, doubleValue >= 0.0d);
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0023, code lost:
    
        if (r0 == null) goto L17;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static final AdPromotedApp mapPromotedApp(PromotedAppDto promotedAppDto) {
        String str;
        if (promotedAppDto != null) {
            if (promotedAppDto.getName() == null && promotedAppDto.getIcon() == null) {
                promotedAppDto = null;
            }
            if (promotedAppDto != null) {
                String description = promotedAppDto.getDescription();
                if (description != null) {
                    str = StringsKt.isBlank(description) ? null : description;
                }
                str = LayoutConfigDefaults.PROMOTED_APP_DESC;
                return new AdPromotedApp(promotedAppDto.getIcon(), promotedAppDto.getName(), str);
            }
        }
        return null;
    }

    private static final Integer mapOrientation(String str) {
        if (Intrinsics.areEqual(str, "0")) {
            return 1;
        }
        return Intrinsics.areEqual(str, "1") ? 0 : null;
    }

    private static final Integer mapSize(String str) {
        if (str == null) {
            return null;
        }
        switch (str.hashCode()) {
            case 48:
                return !str.equals("0") ? null : 22;
            case 49:
                return !str.equals("1") ? null : 26;
            case 50:
                return !str.equals("2") ? null : 29;
            default:
                return null;
        }
    }

    private static final RedirectionStrategy mapRedirectionStrategy(String str) {
        if (str == null) {
            return null;
        }
        switch (str.hashCode()) {
            case 48:
                if (str.equals("0")) {
                    return RedirectionStrategy.KeepAll;
                }
                return null;
            case 49:
                if (str.equals("1")) {
                    return RedirectionStrategy.OnlyClick;
                }
                return null;
            case 50:
                if (str.equals("2")) {
                    return RedirectionStrategy.DisableAll;
                }
                return null;
            default:
                return null;
        }
    }

    private static final LoadingStrategy mapLoadingStrategy(int i, String str) {
        if (i != 0) {
            return LoadingStrategy.DownloadOnly;
        }
        if (Intrinsics.areEqual(str, "0")) {
            return LoadingStrategy.DownloadAndPreload;
        }
        if (Intrinsics.areEqual(str, "1")) {
            return LoadingStrategy.DownloadOnly;
        }
        return null;
    }

    private static final DisplayMode mapDisplayMode(String str) {
        if (str == null) {
            return null;
        }
        switch (str.hashCode()) {
            case 48:
                if (str.equals("0")) {
                    return DisplayMode.Overlay;
                }
                return null;
            case 49:
                if (str.equals("1")) {
                    return DisplayMode.Push;
                }
                return null;
            case 50:
                if (str.equals("2")) {
                    return DisplayMode.BlurOverlay;
                }
                return null;
            default:
                return null;
        }
    }

    private static final RedirectionStrategy mapClickStrategy(String str) {
        if (Intrinsics.areEqual(str, "0")) {
            return RedirectionStrategy.DisableAll;
        }
        if (Intrinsics.areEqual(str, "1")) {
            return RedirectionStrategy.KeepAll;
        }
        return null;
    }

    private static final CloseButtonType mapCloseType(String str) {
        if (str == null) {
            return null;
        }
        switch (str.hashCode()) {
            case 48:
                if (str.equals("0")) {
                    return CloseButtonType.ProgressbarWithClose;
                }
                return null;
            case 49:
                if (str.equals("1")) {
                    return CloseButtonType.CountdownWithClose;
                }
                return null;
            case 50:
                if (str.equals("2")) {
                    return CloseButtonType.SimpleCross;
                }
                return null;
            default:
                return null;
        }
    }

    private static final LayoutPosition mapPosition(String str) {
        if (str == null) {
            return null;
        }
        switch (str.hashCode()) {
            case 48:
                if (str.equals("0")) {
                    return LayoutPosition.TopLeft;
                }
                return null;
            case 49:
                if (str.equals("1")) {
                    return LayoutPosition.TopRight;
                }
                return null;
            case 50:
                if (str.equals("2")) {
                    return LayoutPosition.BottomLeft;
                }
                return null;
            case 51:
                if (str.equals("3")) {
                    return LayoutPosition.BottomRight;
                }
                return null;
            default:
                return null;
        }
    }

    private static final LayoutPosition mapProgressBarPosition(String str) {
        if (Intrinsics.areEqual(str, "0")) {
            return LayoutPosition.TopLeft;
        }
        if (Intrinsics.areEqual(str, "1")) {
            return LayoutPosition.BottomLeft;
        }
        return null;
    }

    private static final Boolean mapBoolean(String str) {
        if (Intrinsics.areEqual(str, "0")) {
            return false;
        }
        return Intrinsics.areEqual(str, "1") ? true : null;
    }

    private static final Integer mapColor(String str) {
        Object m10241constructorimpl;
        try {
            Result.Companion companion = Result.INSTANCE;
            m10241constructorimpl = Result.m10241constructorimpl(str != null ? Integer.valueOf(Color.parseColor(str)) : null);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            m10241constructorimpl = Result.m10241constructorimpl(ResultKt.createFailure(th));
        }
        return (Integer) (Result.m10247isFailureimpl(m10241constructorimpl) ? null : m10241constructorimpl);
    }
}
