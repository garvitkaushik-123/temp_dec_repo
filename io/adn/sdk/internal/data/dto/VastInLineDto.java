package io.adn.sdk.internal.data.dto;

import com.ironsource.C3040d4;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: VastDto.kt */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0081\b\u0018\u00002\u00020\u0001Bq\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b\u0012\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00050\u000b\u0012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000b\u0012\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\u000b¢\u0006\u0004\b\u0012\u0010\u0013J\u000b\u0010!\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000f\u0010&\u001a\b\u0012\u0004\u0012\u00020\f0\u000bHÆ\u0003J\u000f\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00050\u000bHÆ\u0003J\u000f\u0010(\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000bHÆ\u0003J\u000f\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00110\u000bHÆ\u0003J\u0085\u0001\u0010*\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00050\u000b2\u000e\b\u0002\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000b2\u000e\b\u0002\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\u000bHÇ\u0001J\u0013\u0010+\u001a\u00020,2\b\u0010-\u001a\u0004\u0018\u00010\u0001H×\u0003J\t\u0010.\u001a\u00020/H×\u0001J\t\u00100\u001a\u00020\u0005H×\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0017R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0017R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0017\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00050\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001dR\u0017\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001dR\u0017\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\u000b¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001d¨\u00061"}, d2 = {"Lio/adn/sdk/internal/data/dto/VastInLineDto;", "", "adSystem", "Lio/adn/sdk/internal/data/dto/VastAdSystemDto;", "adTitle", "", "description", C3040d4.h.F0, "pricing", "Lio/adn/sdk/internal/data/dto/VastPricingDto;", "impressions", "", "Lio/adn/sdk/internal/data/dto/VastImpressionDto;", "errorUrls", "creatives", "Lio/adn/sdk/internal/data/dto/VastCreativeDto;", "extensions", "Lio/adn/sdk/internal/data/dto/VastExtensionDto;", "<init>", "(Lio/adn/sdk/internal/data/dto/VastAdSystemDto;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lio/adn/sdk/internal/data/dto/VastPricingDto;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;)V", "getAdSystem", "()Lio/adn/sdk/internal/data/dto/VastAdSystemDto;", "getAdTitle", "()Ljava/lang/String;", "getDescription", "getAdvertiser", "getPricing", "()Lio/adn/sdk/internal/data/dto/VastPricingDto;", "getImpressions", "()Ljava/util/List;", "getErrorUrls", "getCreatives", "getExtensions", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "", "toString", "adn-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes7.dex */
public final /* data */ class VastInLineDto {
    public static final int $stable = 8;
    private final VastAdSystemDto adSystem;
    private final String adTitle;
    private final String advertiser;
    private final List<VastCreativeDto> creatives;
    private final String description;
    private final List<String> errorUrls;
    private final List<VastExtensionDto> extensions;
    private final List<VastImpressionDto> impressions;
    private final VastPricingDto pricing;

    public static /* synthetic */ VastInLineDto copy$default(VastInLineDto vastInLineDto, VastAdSystemDto vastAdSystemDto, String str, String str2, String str3, VastPricingDto vastPricingDto, List list, List list2, List list3, List list4, int i, Object obj) {
        if ((i & 1) != 0) {
            vastAdSystemDto = vastInLineDto.adSystem;
        }
        if ((i & 2) != 0) {
            str = vastInLineDto.adTitle;
        }
        if ((i & 4) != 0) {
            str2 = vastInLineDto.description;
        }
        if ((i & 8) != 0) {
            str3 = vastInLineDto.advertiser;
        }
        if ((i & 16) != 0) {
            vastPricingDto = vastInLineDto.pricing;
        }
        if ((i & 32) != 0) {
            list = vastInLineDto.impressions;
        }
        if ((i & 64) != 0) {
            list2 = vastInLineDto.errorUrls;
        }
        if ((i & 128) != 0) {
            list3 = vastInLineDto.creatives;
        }
        if ((i & 256) != 0) {
            list4 = vastInLineDto.extensions;
        }
        List list5 = list3;
        List list6 = list4;
        List list7 = list;
        List list8 = list2;
        VastPricingDto vastPricingDto2 = vastPricingDto;
        String str4 = str2;
        return vastInLineDto.copy(vastAdSystemDto, str, str4, str3, vastPricingDto2, list7, list8, list5, list6);
    }

    /* renamed from: component1, reason: from getter */
    public final VastAdSystemDto getAdSystem() {
        return this.adSystem;
    }

    /* renamed from: component2, reason: from getter */
    public final String getAdTitle() {
        return this.adTitle;
    }

    /* renamed from: component3, reason: from getter */
    public final String getDescription() {
        return this.description;
    }

    /* renamed from: component4, reason: from getter */
    public final String getAdvertiser() {
        return this.advertiser;
    }

    /* renamed from: component5, reason: from getter */
    public final VastPricingDto getPricing() {
        return this.pricing;
    }

    public final List<VastImpressionDto> component6() {
        return this.impressions;
    }

    public final List<String> component7() {
        return this.errorUrls;
    }

    public final List<VastCreativeDto> component8() {
        return this.creatives;
    }

    public final List<VastExtensionDto> component9() {
        return this.extensions;
    }

    public final VastInLineDto copy(VastAdSystemDto adSystem, String adTitle, String description, String advertiser, VastPricingDto pricing, List<VastImpressionDto> impressions, List<String> errorUrls, List<VastCreativeDto> creatives, List<VastExtensionDto> extensions) {
        Intrinsics.checkNotNullParameter(impressions, "impressions");
        Intrinsics.checkNotNullParameter(errorUrls, "errorUrls");
        Intrinsics.checkNotNullParameter(creatives, "creatives");
        Intrinsics.checkNotNullParameter(extensions, "extensions");
        return new VastInLineDto(adSystem, adTitle, description, advertiser, pricing, impressions, errorUrls, creatives, extensions);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof VastInLineDto)) {
            return false;
        }
        VastInLineDto vastInLineDto = (VastInLineDto) other;
        return Intrinsics.areEqual(this.adSystem, vastInLineDto.adSystem) && Intrinsics.areEqual(this.adTitle, vastInLineDto.adTitle) && Intrinsics.areEqual(this.description, vastInLineDto.description) && Intrinsics.areEqual(this.advertiser, vastInLineDto.advertiser) && Intrinsics.areEqual(this.pricing, vastInLineDto.pricing) && Intrinsics.areEqual(this.impressions, vastInLineDto.impressions) && Intrinsics.areEqual(this.errorUrls, vastInLineDto.errorUrls) && Intrinsics.areEqual(this.creatives, vastInLineDto.creatives) && Intrinsics.areEqual(this.extensions, vastInLineDto.extensions);
    }

    public int hashCode() {
        VastAdSystemDto vastAdSystemDto = this.adSystem;
        int hashCode = (vastAdSystemDto == null ? 0 : vastAdSystemDto.hashCode()) * 31;
        String str = this.adTitle;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.description;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.advertiser;
        int hashCode4 = (hashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        VastPricingDto vastPricingDto = this.pricing;
        return ((((((((hashCode4 + (vastPricingDto != null ? vastPricingDto.hashCode() : 0)) * 31) + this.impressions.hashCode()) * 31) + this.errorUrls.hashCode()) * 31) + this.creatives.hashCode()) * 31) + this.extensions.hashCode();
    }

    public String toString() {
        return "VastInLineDto(adSystem=" + this.adSystem + ", adTitle=" + this.adTitle + ", description=" + this.description + ", advertiser=" + this.advertiser + ", pricing=" + this.pricing + ", impressions=" + this.impressions + ", errorUrls=" + this.errorUrls + ", creatives=" + this.creatives + ", extensions=" + this.extensions + ')';
    }

    public VastInLineDto(VastAdSystemDto vastAdSystemDto, String str, String str2, String str3, VastPricingDto vastPricingDto, List<VastImpressionDto> impressions, List<String> errorUrls, List<VastCreativeDto> creatives, List<VastExtensionDto> extensions) {
        Intrinsics.checkNotNullParameter(impressions, "impressions");
        Intrinsics.checkNotNullParameter(errorUrls, "errorUrls");
        Intrinsics.checkNotNullParameter(creatives, "creatives");
        Intrinsics.checkNotNullParameter(extensions, "extensions");
        this.adSystem = vastAdSystemDto;
        this.adTitle = str;
        this.description = str2;
        this.advertiser = str3;
        this.pricing = vastPricingDto;
        this.impressions = impressions;
        this.errorUrls = errorUrls;
        this.creatives = creatives;
        this.extensions = extensions;
    }

    public final VastAdSystemDto getAdSystem() {
        return this.adSystem;
    }

    public final String getAdTitle() {
        return this.adTitle;
    }

    public final String getDescription() {
        return this.description;
    }

    public final String getAdvertiser() {
        return this.advertiser;
    }

    public final VastPricingDto getPricing() {
        return this.pricing;
    }

    public final List<VastImpressionDto> getImpressions() {
        return this.impressions;
    }

    public final List<String> getErrorUrls() {
        return this.errorUrls;
    }

    public final List<VastCreativeDto> getCreatives() {
        return this.creatives;
    }

    public final List<VastExtensionDto> getExtensions() {
        return this.extensions;
    }
}
