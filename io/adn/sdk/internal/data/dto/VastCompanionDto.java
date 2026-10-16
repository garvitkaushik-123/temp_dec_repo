package io.adn.sdk.internal.data.dto;

import io.adn.sdk.internal.domain.model.ad.VastResource;
import io.adn.sdk.internal.domain.model.ad.VastTracking;
import io.bidmachine.iab.vast.tags.VastAttributes;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: VastDto.kt */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001f\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0081\b\u0018\u00002\u00020\u0001Bs\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r\u0012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f\u0012\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\u000f¢\u0006\u0004\b\u0013\u0010\u0014J\u000b\u0010%\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010&\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0018J\u0010\u0010'\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0018J\u000b\u0010(\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010+\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\rHÆ\u0003J\u000f\u0010-\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fHÆ\u0003J\u000f\u0010.\u001a\b\u0012\u0004\u0012\u00020\u00120\u000fHÆ\u0003J\u008e\u0001\u0010/\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\u000e\b\u0002\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\u000e\b\u0002\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\u000fHÇ\u0001¢\u0006\u0002\u00100J\u0013\u00101\u001a\u0002022\b\u00103\u001a\u0004\u0018\u00010\u0001H×\u0003J\t\u00104\u001a\u00020\u0005H×\u0001J\t\u00105\u001a\u00020\u0003H×\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u0019\u001a\u0004\b\u0017\u0010\u0018R\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u0019\u001a\u0004\b\u001a\u0010\u0018R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0016R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0016R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0016R\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0013\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0017\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0017\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\u000f¢\u0006\b\n\u0000\u001a\u0004\b$\u0010#¨\u00066"}, d2 = {"Lio/adn/sdk/internal/data/dto/VastCompanionDto;", "", "id", "", "widthPx", "", "heightPx", "type", "altText", VastAttributes.API_FRAMEWORK, "clicks", "Lio/adn/sdk/internal/data/dto/VastCompanionClicksDto;", "adParameters", "Lio/adn/sdk/internal/data/dto/VastAdParametersDto;", "creativeViewTrackingList", "", "Lio/adn/sdk/internal/domain/model/ad/VastTracking;", "resources", "Lio/adn/sdk/internal/domain/model/ad/VastResource;", "<init>", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lio/adn/sdk/internal/data/dto/VastCompanionClicksDto;Lio/adn/sdk/internal/data/dto/VastAdParametersDto;Ljava/util/List;Ljava/util/List;)V", "getId", "()Ljava/lang/String;", "getWidthPx", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getHeightPx", "getType", "getAltText", "getApiFramework", "getClicks", "()Lio/adn/sdk/internal/data/dto/VastCompanionClicksDto;", "getAdParameters", "()Lio/adn/sdk/internal/data/dto/VastAdParametersDto;", "getCreativeViewTrackingList", "()Ljava/util/List;", "getResources", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "copy", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lio/adn/sdk/internal/data/dto/VastCompanionClicksDto;Lio/adn/sdk/internal/data/dto/VastAdParametersDto;Ljava/util/List;Ljava/util/List;)Lio/adn/sdk/internal/data/dto/VastCompanionDto;", "equals", "", "other", "hashCode", "toString", "adn-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes7.dex */
public final /* data */ class VastCompanionDto {
    public static final int $stable = 8;
    private final VastAdParametersDto adParameters;
    private final String altText;
    private final String apiFramework;
    private final VastCompanionClicksDto clicks;
    private final List<VastTracking> creativeViewTrackingList;
    private final Integer heightPx;
    private final String id;
    private final List<VastResource> resources;
    private final String type;
    private final Integer widthPx;

    public static /* synthetic */ VastCompanionDto copy$default(VastCompanionDto vastCompanionDto, String str, Integer num, Integer num2, String str2, String str3, String str4, VastCompanionClicksDto vastCompanionClicksDto, VastAdParametersDto vastAdParametersDto, List list, List list2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = vastCompanionDto.id;
        }
        if ((i & 2) != 0) {
            num = vastCompanionDto.widthPx;
        }
        if ((i & 4) != 0) {
            num2 = vastCompanionDto.heightPx;
        }
        if ((i & 8) != 0) {
            str2 = vastCompanionDto.type;
        }
        if ((i & 16) != 0) {
            str3 = vastCompanionDto.altText;
        }
        if ((i & 32) != 0) {
            str4 = vastCompanionDto.apiFramework;
        }
        if ((i & 64) != 0) {
            vastCompanionClicksDto = vastCompanionDto.clicks;
        }
        if ((i & 128) != 0) {
            vastAdParametersDto = vastCompanionDto.adParameters;
        }
        if ((i & 256) != 0) {
            list = vastCompanionDto.creativeViewTrackingList;
        }
        if ((i & 512) != 0) {
            list2 = vastCompanionDto.resources;
        }
        List list3 = list;
        List list4 = list2;
        VastCompanionClicksDto vastCompanionClicksDto2 = vastCompanionClicksDto;
        VastAdParametersDto vastAdParametersDto2 = vastAdParametersDto;
        String str5 = str3;
        String str6 = str4;
        return vastCompanionDto.copy(str, num, num2, str2, str5, str6, vastCompanionClicksDto2, vastAdParametersDto2, list3, list4);
    }

    /* renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    public final List<VastResource> component10() {
        return this.resources;
    }

    /* renamed from: component2, reason: from getter */
    public final Integer getWidthPx() {
        return this.widthPx;
    }

    /* renamed from: component3, reason: from getter */
    public final Integer getHeightPx() {
        return this.heightPx;
    }

    /* renamed from: component4, reason: from getter */
    public final String getType() {
        return this.type;
    }

    /* renamed from: component5, reason: from getter */
    public final String getAltText() {
        return this.altText;
    }

    /* renamed from: component6, reason: from getter */
    public final String getApiFramework() {
        return this.apiFramework;
    }

    /* renamed from: component7, reason: from getter */
    public final VastCompanionClicksDto getClicks() {
        return this.clicks;
    }

    /* renamed from: component8, reason: from getter */
    public final VastAdParametersDto getAdParameters() {
        return this.adParameters;
    }

    public final List<VastTracking> component9() {
        return this.creativeViewTrackingList;
    }

    public final VastCompanionDto copy(String id, Integer widthPx, Integer heightPx, String type, String altText, String apiFramework, VastCompanionClicksDto clicks, VastAdParametersDto adParameters, List<VastTracking> creativeViewTrackingList, List<? extends VastResource> resources) {
        Intrinsics.checkNotNullParameter(creativeViewTrackingList, "creativeViewTrackingList");
        Intrinsics.checkNotNullParameter(resources, "resources");
        return new VastCompanionDto(id, widthPx, heightPx, type, altText, apiFramework, clicks, adParameters, creativeViewTrackingList, resources);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof VastCompanionDto)) {
            return false;
        }
        VastCompanionDto vastCompanionDto = (VastCompanionDto) other;
        return Intrinsics.areEqual(this.id, vastCompanionDto.id) && Intrinsics.areEqual(this.widthPx, vastCompanionDto.widthPx) && Intrinsics.areEqual(this.heightPx, vastCompanionDto.heightPx) && Intrinsics.areEqual(this.type, vastCompanionDto.type) && Intrinsics.areEqual(this.altText, vastCompanionDto.altText) && Intrinsics.areEqual(this.apiFramework, vastCompanionDto.apiFramework) && Intrinsics.areEqual(this.clicks, vastCompanionDto.clicks) && Intrinsics.areEqual(this.adParameters, vastCompanionDto.adParameters) && Intrinsics.areEqual(this.creativeViewTrackingList, vastCompanionDto.creativeViewTrackingList) && Intrinsics.areEqual(this.resources, vastCompanionDto.resources);
    }

    public int hashCode() {
        String str = this.id;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        Integer num = this.widthPx;
        int hashCode2 = (hashCode + (num == null ? 0 : num.hashCode())) * 31;
        Integer num2 = this.heightPx;
        int hashCode3 = (hashCode2 + (num2 == null ? 0 : num2.hashCode())) * 31;
        String str2 = this.type;
        int hashCode4 = (hashCode3 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.altText;
        int hashCode5 = (hashCode4 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.apiFramework;
        int hashCode6 = (hashCode5 + (str4 == null ? 0 : str4.hashCode())) * 31;
        VastCompanionClicksDto vastCompanionClicksDto = this.clicks;
        int hashCode7 = (hashCode6 + (vastCompanionClicksDto == null ? 0 : vastCompanionClicksDto.hashCode())) * 31;
        VastAdParametersDto vastAdParametersDto = this.adParameters;
        return ((((hashCode7 + (vastAdParametersDto != null ? vastAdParametersDto.hashCode() : 0)) * 31) + this.creativeViewTrackingList.hashCode()) * 31) + this.resources.hashCode();
    }

    public String toString() {
        return "VastCompanionDto(id=" + this.id + ", widthPx=" + this.widthPx + ", heightPx=" + this.heightPx + ", type=" + this.type + ", altText=" + this.altText + ", apiFramework=" + this.apiFramework + ", clicks=" + this.clicks + ", adParameters=" + this.adParameters + ", creativeViewTrackingList=" + this.creativeViewTrackingList + ", resources=" + this.resources + ')';
    }

    /* JADX WARN: Multi-variable type inference failed */
    public VastCompanionDto(String str, Integer num, Integer num2, String str2, String str3, String str4, VastCompanionClicksDto vastCompanionClicksDto, VastAdParametersDto vastAdParametersDto, List<VastTracking> creativeViewTrackingList, List<? extends VastResource> resources) {
        Intrinsics.checkNotNullParameter(creativeViewTrackingList, "creativeViewTrackingList");
        Intrinsics.checkNotNullParameter(resources, "resources");
        this.id = str;
        this.widthPx = num;
        this.heightPx = num2;
        this.type = str2;
        this.altText = str3;
        this.apiFramework = str4;
        this.clicks = vastCompanionClicksDto;
        this.adParameters = vastAdParametersDto;
        this.creativeViewTrackingList = creativeViewTrackingList;
        this.resources = resources;
    }

    public final String getId() {
        return this.id;
    }

    public final Integer getWidthPx() {
        return this.widthPx;
    }

    public final Integer getHeightPx() {
        return this.heightPx;
    }

    public final String getType() {
        return this.type;
    }

    public final String getAltText() {
        return this.altText;
    }

    public final String getApiFramework() {
        return this.apiFramework;
    }

    public final VastCompanionClicksDto getClicks() {
        return this.clicks;
    }

    public final VastAdParametersDto getAdParameters() {
        return this.adParameters;
    }

    public final List<VastTracking> getCreativeViewTrackingList() {
        return this.creativeViewTrackingList;
    }

    public final List<VastResource> getResources() {
        return this.resources;
    }
}
