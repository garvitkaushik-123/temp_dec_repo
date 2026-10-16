package io.adn.sdk.internal.data.dto;

import io.adn.sdk.internal.domain.model.ad.VastOffset;
import io.adn.sdk.internal.domain.model.ad.VastTracking;
import io.bidmachine.unified.UnifiedMediationParams;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: VastDto.kt */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0081\b\u0018\u00002\u00020\u0001BY\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\t\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\t¢\u0006\u0004\b\u0011\u0010\u0012J\u000b\u0010 \u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010\"\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0018J\u000f\u0010#\u001a\b\u0012\u0004\u0012\u00020\n0\tHÆ\u0003J\u000f\u0010$\u001a\b\u0012\u0004\u0012\u00020\f0\tHÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\u000eHÆ\u0003J\u000f\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00100\tHÆ\u0003Jn\u0010'\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\t2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\tHÇ\u0001¢\u0006\u0002\u0010(J\u0013\u0010)\u001a\u00020*2\b\u0010+\u001a\u0004\u0018\u00010\u0001H×\u0003J\t\u0010,\u001a\u00020-H×\u0001J\t\u0010.\u001a\u00020/H×\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u0019\u001a\u0004\b\u0017\u0010\u0018R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\t¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001bR\u0013\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0017\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\t¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001b¨\u00060"}, d2 = {"Lio/adn/sdk/internal/data/dto/VastLinearDto;", "", UnifiedMediationParams.KEY_SKIP_OFFSET, "Lio/adn/sdk/internal/domain/model/ad/VastOffset;", "adParameters", "Lio/adn/sdk/internal/data/dto/VastAdParametersDto;", "durationMillis", "", "mediaFiles", "", "Lio/adn/sdk/internal/data/dto/VastMediaFileDto;", "trackingList", "Lio/adn/sdk/internal/domain/model/ad/VastTracking;", "videoClicks", "Lio/adn/sdk/internal/data/dto/VastVideoClicksDto;", "icons", "Lio/adn/sdk/internal/data/dto/VastIconDto;", "<init>", "(Lio/adn/sdk/internal/domain/model/ad/VastOffset;Lio/adn/sdk/internal/data/dto/VastAdParametersDto;Ljava/lang/Long;Ljava/util/List;Ljava/util/List;Lio/adn/sdk/internal/data/dto/VastVideoClicksDto;Ljava/util/List;)V", "getSkipOffset", "()Lio/adn/sdk/internal/domain/model/ad/VastOffset;", "getAdParameters", "()Lio/adn/sdk/internal/data/dto/VastAdParametersDto;", "getDurationMillis", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getMediaFiles", "()Ljava/util/List;", "getTrackingList", "getVideoClicks", "()Lio/adn/sdk/internal/data/dto/VastVideoClicksDto;", "getIcons", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "(Lio/adn/sdk/internal/domain/model/ad/VastOffset;Lio/adn/sdk/internal/data/dto/VastAdParametersDto;Ljava/lang/Long;Ljava/util/List;Ljava/util/List;Lio/adn/sdk/internal/data/dto/VastVideoClicksDto;Ljava/util/List;)Lio/adn/sdk/internal/data/dto/VastLinearDto;", "equals", "", "other", "hashCode", "", "toString", "", "adn-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes7.dex */
public final /* data */ class VastLinearDto {
    public static final int $stable = 8;
    private final VastAdParametersDto adParameters;
    private final Long durationMillis;
    private final List<VastIconDto> icons;
    private final List<VastMediaFileDto> mediaFiles;
    private final VastOffset skipOffset;
    private final List<VastTracking> trackingList;
    private final VastVideoClicksDto videoClicks;

    public static /* synthetic */ VastLinearDto copy$default(VastLinearDto vastLinearDto, VastOffset vastOffset, VastAdParametersDto vastAdParametersDto, Long l, List list, List list2, VastVideoClicksDto vastVideoClicksDto, List list3, int i, Object obj) {
        if ((i & 1) != 0) {
            vastOffset = vastLinearDto.skipOffset;
        }
        if ((i & 2) != 0) {
            vastAdParametersDto = vastLinearDto.adParameters;
        }
        if ((i & 4) != 0) {
            l = vastLinearDto.durationMillis;
        }
        if ((i & 8) != 0) {
            list = vastLinearDto.mediaFiles;
        }
        if ((i & 16) != 0) {
            list2 = vastLinearDto.trackingList;
        }
        if ((i & 32) != 0) {
            vastVideoClicksDto = vastLinearDto.videoClicks;
        }
        if ((i & 64) != 0) {
            list3 = vastLinearDto.icons;
        }
        VastVideoClicksDto vastVideoClicksDto2 = vastVideoClicksDto;
        List list4 = list3;
        List list5 = list2;
        Long l2 = l;
        return vastLinearDto.copy(vastOffset, vastAdParametersDto, l2, list, list5, vastVideoClicksDto2, list4);
    }

    /* renamed from: component1, reason: from getter */
    public final VastOffset getSkipOffset() {
        return this.skipOffset;
    }

    /* renamed from: component2, reason: from getter */
    public final VastAdParametersDto getAdParameters() {
        return this.adParameters;
    }

    /* renamed from: component3, reason: from getter */
    public final Long getDurationMillis() {
        return this.durationMillis;
    }

    public final List<VastMediaFileDto> component4() {
        return this.mediaFiles;
    }

    public final List<VastTracking> component5() {
        return this.trackingList;
    }

    /* renamed from: component6, reason: from getter */
    public final VastVideoClicksDto getVideoClicks() {
        return this.videoClicks;
    }

    public final List<VastIconDto> component7() {
        return this.icons;
    }

    public final VastLinearDto copy(VastOffset skipOffset, VastAdParametersDto adParameters, Long durationMillis, List<VastMediaFileDto> mediaFiles, List<VastTracking> trackingList, VastVideoClicksDto videoClicks, List<VastIconDto> icons) {
        Intrinsics.checkNotNullParameter(mediaFiles, "mediaFiles");
        Intrinsics.checkNotNullParameter(trackingList, "trackingList");
        Intrinsics.checkNotNullParameter(icons, "icons");
        return new VastLinearDto(skipOffset, adParameters, durationMillis, mediaFiles, trackingList, videoClicks, icons);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof VastLinearDto)) {
            return false;
        }
        VastLinearDto vastLinearDto = (VastLinearDto) other;
        return Intrinsics.areEqual(this.skipOffset, vastLinearDto.skipOffset) && Intrinsics.areEqual(this.adParameters, vastLinearDto.adParameters) && Intrinsics.areEqual(this.durationMillis, vastLinearDto.durationMillis) && Intrinsics.areEqual(this.mediaFiles, vastLinearDto.mediaFiles) && Intrinsics.areEqual(this.trackingList, vastLinearDto.trackingList) && Intrinsics.areEqual(this.videoClicks, vastLinearDto.videoClicks) && Intrinsics.areEqual(this.icons, vastLinearDto.icons);
    }

    public int hashCode() {
        VastOffset vastOffset = this.skipOffset;
        int hashCode = (vastOffset == null ? 0 : vastOffset.hashCode()) * 31;
        VastAdParametersDto vastAdParametersDto = this.adParameters;
        int hashCode2 = (hashCode + (vastAdParametersDto == null ? 0 : vastAdParametersDto.hashCode())) * 31;
        Long l = this.durationMillis;
        int hashCode3 = (((((hashCode2 + (l == null ? 0 : l.hashCode())) * 31) + this.mediaFiles.hashCode()) * 31) + this.trackingList.hashCode()) * 31;
        VastVideoClicksDto vastVideoClicksDto = this.videoClicks;
        return ((hashCode3 + (vastVideoClicksDto != null ? vastVideoClicksDto.hashCode() : 0)) * 31) + this.icons.hashCode();
    }

    public String toString() {
        return "VastLinearDto(skipOffset=" + this.skipOffset + ", adParameters=" + this.adParameters + ", durationMillis=" + this.durationMillis + ", mediaFiles=" + this.mediaFiles + ", trackingList=" + this.trackingList + ", videoClicks=" + this.videoClicks + ", icons=" + this.icons + ')';
    }

    public VastLinearDto(VastOffset vastOffset, VastAdParametersDto vastAdParametersDto, Long l, List<VastMediaFileDto> mediaFiles, List<VastTracking> trackingList, VastVideoClicksDto vastVideoClicksDto, List<VastIconDto> icons) {
        Intrinsics.checkNotNullParameter(mediaFiles, "mediaFiles");
        Intrinsics.checkNotNullParameter(trackingList, "trackingList");
        Intrinsics.checkNotNullParameter(icons, "icons");
        this.skipOffset = vastOffset;
        this.adParameters = vastAdParametersDto;
        this.durationMillis = l;
        this.mediaFiles = mediaFiles;
        this.trackingList = trackingList;
        this.videoClicks = vastVideoClicksDto;
        this.icons = icons;
    }

    public final VastOffset getSkipOffset() {
        return this.skipOffset;
    }

    public final VastAdParametersDto getAdParameters() {
        return this.adParameters;
    }

    public final Long getDurationMillis() {
        return this.durationMillis;
    }

    public final List<VastMediaFileDto> getMediaFiles() {
        return this.mediaFiles;
    }

    public final List<VastTracking> getTrackingList() {
        return this.trackingList;
    }

    public final VastVideoClicksDto getVideoClicks() {
        return this.videoClicks;
    }

    public final List<VastIconDto> getIcons() {
        return this.icons;
    }
}
