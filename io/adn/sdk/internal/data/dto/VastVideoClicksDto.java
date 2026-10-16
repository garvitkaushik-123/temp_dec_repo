package io.adn.sdk.internal.data.dto;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: VastDto.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\t\b\u0001\u0018\u00002\u00020\u0001B-\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\u0004\b\u0007\u0010\bR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\f¨\u0006\u000e"}, d2 = {"Lio/adn/sdk/internal/data/dto/VastVideoClicksDto;", "", "clickThrough", "Lio/adn/sdk/internal/data/dto/VastVideoClickDto;", "clickTrackingList", "", "customClickList", "<init>", "(Lio/adn/sdk/internal/data/dto/VastVideoClickDto;Ljava/util/List;Ljava/util/List;)V", "getClickThrough", "()Lio/adn/sdk/internal/data/dto/VastVideoClickDto;", "getClickTrackingList", "()Ljava/util/List;", "getCustomClickList", "adn-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes7.dex */
public final class VastVideoClicksDto {
    public static final int $stable = 8;
    private final VastVideoClickDto clickThrough;
    private final List<VastVideoClickDto> clickTrackingList;
    private final List<VastVideoClickDto> customClickList;

    public VastVideoClicksDto(VastVideoClickDto vastVideoClickDto, List<VastVideoClickDto> clickTrackingList, List<VastVideoClickDto> customClickList) {
        Intrinsics.checkNotNullParameter(clickTrackingList, "clickTrackingList");
        Intrinsics.checkNotNullParameter(customClickList, "customClickList");
        this.clickThrough = vastVideoClickDto;
        this.clickTrackingList = clickTrackingList;
        this.customClickList = customClickList;
    }

    public final VastVideoClickDto getClickThrough() {
        return this.clickThrough;
    }

    public final List<VastVideoClickDto> getClickTrackingList() {
        return this.clickTrackingList;
    }

    public final List<VastVideoClickDto> getCustomClickList() {
        return this.customClickList;
    }
}
