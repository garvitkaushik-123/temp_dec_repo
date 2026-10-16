package io.adn.sdk.internal.data.dto;

import io.adn.sdk.internal.domain.model.ad.VastOffset;
import io.adn.sdk.internal.domain.model.ad.VastResource;
import io.bidmachine.iab.vast.tags.VastAttributes;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: VastDto.kt */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b \n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0081\b\u0018\u00002\u00020\u0001Bc\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r\u0012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00030\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011¢\u0006\u0004\b\u0012\u0010\u0013J\u000b\u0010&\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010'\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0017J\u0010\u0010(\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0017J\u000b\u0010)\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\tHÆ\u0003J\u0010\u0010+\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u0010\u001eJ\u000b\u0010,\u001a\u0004\u0018\u00010\rHÆ\u0003J\u000f\u0010-\u001a\b\u0012\u0004\u0012\u00020\u00030\u000fHÆ\u0003J\t\u0010.\u001a\u00020\u0011HÆ\u0003J|\u0010/\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\u000e\b\u0002\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00030\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u0011HÇ\u0001¢\u0006\u0002\u00100J\u0013\u00101\u001a\u0002022\b\u00103\u001a\u0004\u0018\u00010\u0001H×\u0003J\t\u00104\u001a\u00020\u0005H×\u0001J\t\u00105\u001a\u00020\u0003H×\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u0018\u001a\u0004\b\u0016\u0010\u0017R\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u0018\u001a\u0004\b\u0019\u0010\u0017R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0015R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0015\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\n\n\u0002\u0010\u001f\u001a\u0004\b\u001d\u0010\u001eR\u0013\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0017\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00030\u000f¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0011\u0010\u0010\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%¨\u00066"}, d2 = {"Lio/adn/sdk/internal/data/dto/VastIconDto;", "", "program", "", "widthPx", "", "heightPx", VastAttributes.API_FRAMEWORK, "offset", "Lio/adn/sdk/internal/domain/model/ad/VastOffset;", "durationMillis", "", "clicks", "Lio/adn/sdk/internal/data/dto/VastIconClicksDto;", "viewTrackingUrlList", "", "resource", "Lio/adn/sdk/internal/domain/model/ad/VastResource;", "<init>", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Lio/adn/sdk/internal/domain/model/ad/VastOffset;Ljava/lang/Long;Lio/adn/sdk/internal/data/dto/VastIconClicksDto;Ljava/util/List;Lio/adn/sdk/internal/domain/model/ad/VastResource;)V", "getProgram", "()Ljava/lang/String;", "getWidthPx", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getHeightPx", "getApiFramework", "getOffset", "()Lio/adn/sdk/internal/domain/model/ad/VastOffset;", "getDurationMillis", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getClicks", "()Lio/adn/sdk/internal/data/dto/VastIconClicksDto;", "getViewTrackingUrlList", "()Ljava/util/List;", "getResource", "()Lio/adn/sdk/internal/domain/model/ad/VastResource;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Lio/adn/sdk/internal/domain/model/ad/VastOffset;Ljava/lang/Long;Lio/adn/sdk/internal/data/dto/VastIconClicksDto;Ljava/util/List;Lio/adn/sdk/internal/domain/model/ad/VastResource;)Lio/adn/sdk/internal/data/dto/VastIconDto;", "equals", "", "other", "hashCode", "toString", "adn-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes7.dex */
public final /* data */ class VastIconDto {
    public static final int $stable = 8;
    private final String apiFramework;
    private final VastIconClicksDto clicks;
    private final Long durationMillis;
    private final Integer heightPx;
    private final VastOffset offset;
    private final String program;
    private final VastResource resource;
    private final List<String> viewTrackingUrlList;
    private final Integer widthPx;

    public static /* synthetic */ VastIconDto copy$default(VastIconDto vastIconDto, String str, Integer num, Integer num2, String str2, VastOffset vastOffset, Long l, VastIconClicksDto vastIconClicksDto, List list, VastResource vastResource, int i, Object obj) {
        if ((i & 1) != 0) {
            str = vastIconDto.program;
        }
        if ((i & 2) != 0) {
            num = vastIconDto.widthPx;
        }
        if ((i & 4) != 0) {
            num2 = vastIconDto.heightPx;
        }
        if ((i & 8) != 0) {
            str2 = vastIconDto.apiFramework;
        }
        if ((i & 16) != 0) {
            vastOffset = vastIconDto.offset;
        }
        if ((i & 32) != 0) {
            l = vastIconDto.durationMillis;
        }
        if ((i & 64) != 0) {
            vastIconClicksDto = vastIconDto.clicks;
        }
        if ((i & 128) != 0) {
            list = vastIconDto.viewTrackingUrlList;
        }
        if ((i & 256) != 0) {
            vastResource = vastIconDto.resource;
        }
        List list2 = list;
        VastResource vastResource2 = vastResource;
        Long l2 = l;
        VastIconClicksDto vastIconClicksDto2 = vastIconClicksDto;
        VastOffset vastOffset2 = vastOffset;
        Integer num3 = num2;
        return vastIconDto.copy(str, num, num3, str2, vastOffset2, l2, vastIconClicksDto2, list2, vastResource2);
    }

    /* renamed from: component1, reason: from getter */
    public final String getProgram() {
        return this.program;
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
    public final String getApiFramework() {
        return this.apiFramework;
    }

    /* renamed from: component5, reason: from getter */
    public final VastOffset getOffset() {
        return this.offset;
    }

    /* renamed from: component6, reason: from getter */
    public final Long getDurationMillis() {
        return this.durationMillis;
    }

    /* renamed from: component7, reason: from getter */
    public final VastIconClicksDto getClicks() {
        return this.clicks;
    }

    public final List<String> component8() {
        return this.viewTrackingUrlList;
    }

    /* renamed from: component9, reason: from getter */
    public final VastResource getResource() {
        return this.resource;
    }

    public final VastIconDto copy(String program, Integer widthPx, Integer heightPx, String apiFramework, VastOffset offset, Long durationMillis, VastIconClicksDto clicks, List<String> viewTrackingUrlList, VastResource resource) {
        Intrinsics.checkNotNullParameter(viewTrackingUrlList, "viewTrackingUrlList");
        Intrinsics.checkNotNullParameter(resource, "resource");
        return new VastIconDto(program, widthPx, heightPx, apiFramework, offset, durationMillis, clicks, viewTrackingUrlList, resource);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof VastIconDto)) {
            return false;
        }
        VastIconDto vastIconDto = (VastIconDto) other;
        return Intrinsics.areEqual(this.program, vastIconDto.program) && Intrinsics.areEqual(this.widthPx, vastIconDto.widthPx) && Intrinsics.areEqual(this.heightPx, vastIconDto.heightPx) && Intrinsics.areEqual(this.apiFramework, vastIconDto.apiFramework) && Intrinsics.areEqual(this.offset, vastIconDto.offset) && Intrinsics.areEqual(this.durationMillis, vastIconDto.durationMillis) && Intrinsics.areEqual(this.clicks, vastIconDto.clicks) && Intrinsics.areEqual(this.viewTrackingUrlList, vastIconDto.viewTrackingUrlList) && Intrinsics.areEqual(this.resource, vastIconDto.resource);
    }

    public int hashCode() {
        String str = this.program;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        Integer num = this.widthPx;
        int hashCode2 = (hashCode + (num == null ? 0 : num.hashCode())) * 31;
        Integer num2 = this.heightPx;
        int hashCode3 = (hashCode2 + (num2 == null ? 0 : num2.hashCode())) * 31;
        String str2 = this.apiFramework;
        int hashCode4 = (hashCode3 + (str2 == null ? 0 : str2.hashCode())) * 31;
        VastOffset vastOffset = this.offset;
        int hashCode5 = (hashCode4 + (vastOffset == null ? 0 : vastOffset.hashCode())) * 31;
        Long l = this.durationMillis;
        int hashCode6 = (hashCode5 + (l == null ? 0 : l.hashCode())) * 31;
        VastIconClicksDto vastIconClicksDto = this.clicks;
        return ((((hashCode6 + (vastIconClicksDto != null ? vastIconClicksDto.hashCode() : 0)) * 31) + this.viewTrackingUrlList.hashCode()) * 31) + this.resource.hashCode();
    }

    public String toString() {
        return "VastIconDto(program=" + this.program + ", widthPx=" + this.widthPx + ", heightPx=" + this.heightPx + ", apiFramework=" + this.apiFramework + ", offset=" + this.offset + ", durationMillis=" + this.durationMillis + ", clicks=" + this.clicks + ", viewTrackingUrlList=" + this.viewTrackingUrlList + ", resource=" + this.resource + ')';
    }

    public VastIconDto(String str, Integer num, Integer num2, String str2, VastOffset vastOffset, Long l, VastIconClicksDto vastIconClicksDto, List<String> viewTrackingUrlList, VastResource resource) {
        Intrinsics.checkNotNullParameter(viewTrackingUrlList, "viewTrackingUrlList");
        Intrinsics.checkNotNullParameter(resource, "resource");
        this.program = str;
        this.widthPx = num;
        this.heightPx = num2;
        this.apiFramework = str2;
        this.offset = vastOffset;
        this.durationMillis = l;
        this.clicks = vastIconClicksDto;
        this.viewTrackingUrlList = viewTrackingUrlList;
        this.resource = resource;
    }

    public final String getProgram() {
        return this.program;
    }

    public final Integer getWidthPx() {
        return this.widthPx;
    }

    public final Integer getHeightPx() {
        return this.heightPx;
    }

    public final String getApiFramework() {
        return this.apiFramework;
    }

    public final VastOffset getOffset() {
        return this.offset;
    }

    public final Long getDurationMillis() {
        return this.durationMillis;
    }

    public final VastIconClicksDto getClicks() {
        return this.clicks;
    }

    public final List<String> getViewTrackingUrlList() {
        return this.viewTrackingUrlList;
    }

    public final VastResource getResource() {
        return this.resource;
    }
}
