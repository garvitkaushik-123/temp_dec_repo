package io.adn.sdk.internal.data.dto;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: VastDto.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0081\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005HÆ\u0003J#\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005HÇ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001H×\u0003J\t\u0010\u0012\u001a\u00020\u0013H×\u0001J\t\u0010\u0014\u001a\u00020\u0003H×\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lio/adn/sdk/internal/data/dto/VastIconClicksDto;", "", "clickThroughUrl", "", "clickTrackingUrlList", "", "<init>", "(Ljava/lang/String;Ljava/util/List;)V", "getClickThroughUrl", "()Ljava/lang/String;", "getClickTrackingUrlList", "()Ljava/util/List;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "adn-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes7.dex */
public final /* data */ class VastIconClicksDto {
    public static final int $stable = 8;
    private final String clickThroughUrl;
    private final List<String> clickTrackingUrlList;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ VastIconClicksDto copy$default(VastIconClicksDto vastIconClicksDto, String str, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            str = vastIconClicksDto.clickThroughUrl;
        }
        if ((i & 2) != 0) {
            list = vastIconClicksDto.clickTrackingUrlList;
        }
        return vastIconClicksDto.copy(str, list);
    }

    /* renamed from: component1, reason: from getter */
    public final String getClickThroughUrl() {
        return this.clickThroughUrl;
    }

    public final List<String> component2() {
        return this.clickTrackingUrlList;
    }

    public final VastIconClicksDto copy(String clickThroughUrl, List<String> clickTrackingUrlList) {
        Intrinsics.checkNotNullParameter(clickThroughUrl, "clickThroughUrl");
        Intrinsics.checkNotNullParameter(clickTrackingUrlList, "clickTrackingUrlList");
        return new VastIconClicksDto(clickThroughUrl, clickTrackingUrlList);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof VastIconClicksDto)) {
            return false;
        }
        VastIconClicksDto vastIconClicksDto = (VastIconClicksDto) other;
        return Intrinsics.areEqual(this.clickThroughUrl, vastIconClicksDto.clickThroughUrl) && Intrinsics.areEqual(this.clickTrackingUrlList, vastIconClicksDto.clickTrackingUrlList);
    }

    public int hashCode() {
        return (this.clickThroughUrl.hashCode() * 31) + this.clickTrackingUrlList.hashCode();
    }

    public String toString() {
        return "VastIconClicksDto(clickThroughUrl=" + this.clickThroughUrl + ", clickTrackingUrlList=" + this.clickTrackingUrlList + ')';
    }

    public VastIconClicksDto(String clickThroughUrl, List<String> clickTrackingUrlList) {
        Intrinsics.checkNotNullParameter(clickThroughUrl, "clickThroughUrl");
        Intrinsics.checkNotNullParameter(clickTrackingUrlList, "clickTrackingUrlList");
        this.clickThroughUrl = clickThroughUrl;
        this.clickTrackingUrlList = clickTrackingUrlList;
    }

    public final String getClickThroughUrl() {
        return this.clickThroughUrl;
    }

    public final List<String> getClickTrackingUrlList() {
        return this.clickTrackingUrlList;
    }
}
