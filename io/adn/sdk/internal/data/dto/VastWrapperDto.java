package io.adn.sdk.internal.data.dto;

import io.bidmachine.iab.vast.tags.VastAttributes;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: VastDto.kt */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0010\b\n\u0002\b\u0002\b\u0081\b\u0018\u00002\u00020\u0001BM\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00030\t\u0012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\t¢\u0006\u0004\b\u000e\u0010\u000fJ\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0013J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\n0\tHÆ\u0003J\u000f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00030\tHÆ\u0003J\u000f\u0010 \u001a\b\u0012\u0004\u0012\u00020\r0\tHÆ\u0003J`\u0010!\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00030\t2\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\tHÇ\u0001¢\u0006\u0002\u0010\"J\u0013\u0010#\u001a\u00020\u00052\b\u0010$\u001a\u0004\u0018\u00010\u0001H×\u0003J\t\u0010%\u001a\u00020&H×\u0001J\t\u0010'\u001a\u00020\u0003H×\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00030\t¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0018R\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\t¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0018¨\u0006("}, d2 = {"Lio/adn/sdk/internal/data/dto/VastWrapperDto;", "", "vastAdTagUrl", "", VastAttributes.FOLLOW_ADDITIONAL_WRAPPERS, "", "adSystem", "Lio/adn/sdk/internal/data/dto/VastAdSystemDto;", "impressions", "", "Lio/adn/sdk/internal/data/dto/VastImpressionDto;", "errorUrls", "creatives", "Lio/adn/sdk/internal/data/dto/VastCreativeDto;", "<init>", "(Ljava/lang/String;Ljava/lang/Boolean;Lio/adn/sdk/internal/data/dto/VastAdSystemDto;Ljava/util/List;Ljava/util/List;Ljava/util/List;)V", "getVastAdTagUrl", "()Ljava/lang/String;", "getFollowAdditionalWrappers", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getAdSystem", "()Lio/adn/sdk/internal/data/dto/VastAdSystemDto;", "getImpressions", "()Ljava/util/List;", "getErrorUrls", "getCreatives", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(Ljava/lang/String;Ljava/lang/Boolean;Lio/adn/sdk/internal/data/dto/VastAdSystemDto;Ljava/util/List;Ljava/util/List;Ljava/util/List;)Lio/adn/sdk/internal/data/dto/VastWrapperDto;", "equals", "other", "hashCode", "", "toString", "adn-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes7.dex */
public final /* data */ class VastWrapperDto {
    public static final int $stable = 8;
    private final VastAdSystemDto adSystem;
    private final List<VastCreativeDto> creatives;
    private final List<String> errorUrls;
    private final Boolean followAdditionalWrappers;
    private final List<VastImpressionDto> impressions;
    private final String vastAdTagUrl;

    public static /* synthetic */ VastWrapperDto copy$default(VastWrapperDto vastWrapperDto, String str, Boolean bool, VastAdSystemDto vastAdSystemDto, List list, List list2, List list3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = vastWrapperDto.vastAdTagUrl;
        }
        if ((i & 2) != 0) {
            bool = vastWrapperDto.followAdditionalWrappers;
        }
        if ((i & 4) != 0) {
            vastAdSystemDto = vastWrapperDto.adSystem;
        }
        if ((i & 8) != 0) {
            list = vastWrapperDto.impressions;
        }
        if ((i & 16) != 0) {
            list2 = vastWrapperDto.errorUrls;
        }
        if ((i & 32) != 0) {
            list3 = vastWrapperDto.creatives;
        }
        List list4 = list2;
        List list5 = list3;
        return vastWrapperDto.copy(str, bool, vastAdSystemDto, list, list4, list5);
    }

    /* renamed from: component1, reason: from getter */
    public final String getVastAdTagUrl() {
        return this.vastAdTagUrl;
    }

    /* renamed from: component2, reason: from getter */
    public final Boolean getFollowAdditionalWrappers() {
        return this.followAdditionalWrappers;
    }

    /* renamed from: component3, reason: from getter */
    public final VastAdSystemDto getAdSystem() {
        return this.adSystem;
    }

    public final List<VastImpressionDto> component4() {
        return this.impressions;
    }

    public final List<String> component5() {
        return this.errorUrls;
    }

    public final List<VastCreativeDto> component6() {
        return this.creatives;
    }

    public final VastWrapperDto copy(String vastAdTagUrl, Boolean followAdditionalWrappers, VastAdSystemDto adSystem, List<VastImpressionDto> impressions, List<String> errorUrls, List<VastCreativeDto> creatives) {
        Intrinsics.checkNotNullParameter(vastAdTagUrl, "vastAdTagUrl");
        Intrinsics.checkNotNullParameter(impressions, "impressions");
        Intrinsics.checkNotNullParameter(errorUrls, "errorUrls");
        Intrinsics.checkNotNullParameter(creatives, "creatives");
        return new VastWrapperDto(vastAdTagUrl, followAdditionalWrappers, adSystem, impressions, errorUrls, creatives);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof VastWrapperDto)) {
            return false;
        }
        VastWrapperDto vastWrapperDto = (VastWrapperDto) other;
        return Intrinsics.areEqual(this.vastAdTagUrl, vastWrapperDto.vastAdTagUrl) && Intrinsics.areEqual(this.followAdditionalWrappers, vastWrapperDto.followAdditionalWrappers) && Intrinsics.areEqual(this.adSystem, vastWrapperDto.adSystem) && Intrinsics.areEqual(this.impressions, vastWrapperDto.impressions) && Intrinsics.areEqual(this.errorUrls, vastWrapperDto.errorUrls) && Intrinsics.areEqual(this.creatives, vastWrapperDto.creatives);
    }

    public int hashCode() {
        int hashCode = this.vastAdTagUrl.hashCode() * 31;
        Boolean bool = this.followAdditionalWrappers;
        int hashCode2 = (hashCode + (bool == null ? 0 : bool.hashCode())) * 31;
        VastAdSystemDto vastAdSystemDto = this.adSystem;
        return ((((((hashCode2 + (vastAdSystemDto != null ? vastAdSystemDto.hashCode() : 0)) * 31) + this.impressions.hashCode()) * 31) + this.errorUrls.hashCode()) * 31) + this.creatives.hashCode();
    }

    public String toString() {
        return "VastWrapperDto(vastAdTagUrl=" + this.vastAdTagUrl + ", followAdditionalWrappers=" + this.followAdditionalWrappers + ", adSystem=" + this.adSystem + ", impressions=" + this.impressions + ", errorUrls=" + this.errorUrls + ", creatives=" + this.creatives + ')';
    }

    public VastWrapperDto(String vastAdTagUrl, Boolean bool, VastAdSystemDto vastAdSystemDto, List<VastImpressionDto> impressions, List<String> errorUrls, List<VastCreativeDto> creatives) {
        Intrinsics.checkNotNullParameter(vastAdTagUrl, "vastAdTagUrl");
        Intrinsics.checkNotNullParameter(impressions, "impressions");
        Intrinsics.checkNotNullParameter(errorUrls, "errorUrls");
        Intrinsics.checkNotNullParameter(creatives, "creatives");
        this.vastAdTagUrl = vastAdTagUrl;
        this.followAdditionalWrappers = bool;
        this.adSystem = vastAdSystemDto;
        this.impressions = impressions;
        this.errorUrls = errorUrls;
        this.creatives = creatives;
    }

    public final String getVastAdTagUrl() {
        return this.vastAdTagUrl;
    }

    public final Boolean getFollowAdditionalWrappers() {
        return this.followAdditionalWrappers;
    }

    public final VastAdSystemDto getAdSystem() {
        return this.adSystem;
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
}
