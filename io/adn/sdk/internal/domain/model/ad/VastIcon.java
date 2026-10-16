package io.adn.sdk.internal.domain.model.ad;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: VastAdEntity.kt */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001c\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0081\b\u0018\u00002\u00020\u0001BY\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\n\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\b0\n\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b\u0010\u0010\u0011J\t\u0010!\u001a\u00020\u0003HÆ\u0003J\t\u0010\"\u001a\u00020\u0005HÆ\u0003J\t\u0010#\u001a\u00020\u0005HÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000f\u0010%\u001a\b\u0012\u0004\u0012\u00020\b0\nHÆ\u0003J\u000f\u0010&\u001a\b\u0012\u0004\u0012\u00020\b0\nHÆ\u0003J\u0010\u0010'\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0002\u0010\u001dJ\u000b\u0010(\u001a\u0004\u0018\u00010\u000fHÆ\u0003Jp\u0010)\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\n2\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\b0\n2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÇ\u0001¢\u0006\u0002\u0010*J\u0013\u0010+\u001a\u00020,2\b\u0010-\u001a\u0004\u0018\u00010\u0001H×\u0003J\t\u0010.\u001a\u00020\u0005H×\u0001J\t\u0010/\u001a\u00020\bH×\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0015R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\n¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\b0\n¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001aR\u0015\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\n\n\u0002\u0010\u001e\u001a\u0004\b\u001c\u0010\u001dR\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 ¨\u00060"}, d2 = {"Lio/adn/sdk/internal/domain/model/ad/VastIcon;", "", "resource", "Lio/adn/sdk/internal/domain/model/ad/VastResource;", "widthPx", "", "heightPx", "clickThroughUrl", "", "clickTracking", "", "viewTracking", "durationMillis", "", "offset", "Lio/adn/sdk/internal/domain/model/ad/VastOffset;", "<init>", "(Lio/adn/sdk/internal/domain/model/ad/VastResource;IILjava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/lang/Long;Lio/adn/sdk/internal/domain/model/ad/VastOffset;)V", "getResource", "()Lio/adn/sdk/internal/domain/model/ad/VastResource;", "getWidthPx", "()I", "getHeightPx", "getClickThroughUrl", "()Ljava/lang/String;", "getClickTracking", "()Ljava/util/List;", "getViewTracking", "getDurationMillis", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getOffset", "()Lio/adn/sdk/internal/domain/model/ad/VastOffset;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "(Lio/adn/sdk/internal/domain/model/ad/VastResource;IILjava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/lang/Long;Lio/adn/sdk/internal/domain/model/ad/VastOffset;)Lio/adn/sdk/internal/domain/model/ad/VastIcon;", "equals", "", "other", "hashCode", "toString", "adn-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes7.dex */
public final /* data */ class VastIcon {
    public static final int $stable = 8;
    private final String clickThroughUrl;
    private final List<String> clickTracking;
    private final Long durationMillis;
    private final int heightPx;
    private final VastOffset offset;
    private final VastResource resource;
    private final List<String> viewTracking;
    private final int widthPx;

    public static /* synthetic */ VastIcon copy$default(VastIcon vastIcon, VastResource vastResource, int i, int i2, String str, List list, List list2, Long l, VastOffset vastOffset, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            vastResource = vastIcon.resource;
        }
        if ((i3 & 2) != 0) {
            i = vastIcon.widthPx;
        }
        if ((i3 & 4) != 0) {
            i2 = vastIcon.heightPx;
        }
        if ((i3 & 8) != 0) {
            str = vastIcon.clickThroughUrl;
        }
        if ((i3 & 16) != 0) {
            list = vastIcon.clickTracking;
        }
        if ((i3 & 32) != 0) {
            list2 = vastIcon.viewTracking;
        }
        if ((i3 & 64) != 0) {
            l = vastIcon.durationMillis;
        }
        if ((i3 & 128) != 0) {
            vastOffset = vastIcon.offset;
        }
        Long l2 = l;
        VastOffset vastOffset2 = vastOffset;
        List list3 = list;
        List list4 = list2;
        return vastIcon.copy(vastResource, i, i2, str, list3, list4, l2, vastOffset2);
    }

    /* renamed from: component1, reason: from getter */
    public final VastResource getResource() {
        return this.resource;
    }

    /* renamed from: component2, reason: from getter */
    public final int getWidthPx() {
        return this.widthPx;
    }

    /* renamed from: component3, reason: from getter */
    public final int getHeightPx() {
        return this.heightPx;
    }

    /* renamed from: component4, reason: from getter */
    public final String getClickThroughUrl() {
        return this.clickThroughUrl;
    }

    public final List<String> component5() {
        return this.clickTracking;
    }

    public final List<String> component6() {
        return this.viewTracking;
    }

    /* renamed from: component7, reason: from getter */
    public final Long getDurationMillis() {
        return this.durationMillis;
    }

    /* renamed from: component8, reason: from getter */
    public final VastOffset getOffset() {
        return this.offset;
    }

    public final VastIcon copy(VastResource resource, int widthPx, int heightPx, String clickThroughUrl, List<String> clickTracking, List<String> viewTracking, Long durationMillis, VastOffset offset) {
        Intrinsics.checkNotNullParameter(resource, "resource");
        Intrinsics.checkNotNullParameter(clickTracking, "clickTracking");
        Intrinsics.checkNotNullParameter(viewTracking, "viewTracking");
        return new VastIcon(resource, widthPx, heightPx, clickThroughUrl, clickTracking, viewTracking, durationMillis, offset);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof VastIcon)) {
            return false;
        }
        VastIcon vastIcon = (VastIcon) other;
        return Intrinsics.areEqual(this.resource, vastIcon.resource) && this.widthPx == vastIcon.widthPx && this.heightPx == vastIcon.heightPx && Intrinsics.areEqual(this.clickThroughUrl, vastIcon.clickThroughUrl) && Intrinsics.areEqual(this.clickTracking, vastIcon.clickTracking) && Intrinsics.areEqual(this.viewTracking, vastIcon.viewTracking) && Intrinsics.areEqual(this.durationMillis, vastIcon.durationMillis) && Intrinsics.areEqual(this.offset, vastIcon.offset);
    }

    public int hashCode() {
        int hashCode = ((((this.resource.hashCode() * 31) + Integer.hashCode(this.widthPx)) * 31) + Integer.hashCode(this.heightPx)) * 31;
        String str = this.clickThroughUrl;
        int hashCode2 = (((((hashCode + (str == null ? 0 : str.hashCode())) * 31) + this.clickTracking.hashCode()) * 31) + this.viewTracking.hashCode()) * 31;
        Long l = this.durationMillis;
        int hashCode3 = (hashCode2 + (l == null ? 0 : l.hashCode())) * 31;
        VastOffset vastOffset = this.offset;
        return hashCode3 + (vastOffset != null ? vastOffset.hashCode() : 0);
    }

    public String toString() {
        return "VastIcon(resource=" + this.resource + ", widthPx=" + this.widthPx + ", heightPx=" + this.heightPx + ", clickThroughUrl=" + this.clickThroughUrl + ", clickTracking=" + this.clickTracking + ", viewTracking=" + this.viewTracking + ", durationMillis=" + this.durationMillis + ", offset=" + this.offset + ')';
    }

    public VastIcon(VastResource resource, int i, int i2, String str, List<String> clickTracking, List<String> viewTracking, Long l, VastOffset vastOffset) {
        Intrinsics.checkNotNullParameter(resource, "resource");
        Intrinsics.checkNotNullParameter(clickTracking, "clickTracking");
        Intrinsics.checkNotNullParameter(viewTracking, "viewTracking");
        this.resource = resource;
        this.widthPx = i;
        this.heightPx = i2;
        this.clickThroughUrl = str;
        this.clickTracking = clickTracking;
        this.viewTracking = viewTracking;
        this.durationMillis = l;
        this.offset = vastOffset;
    }

    public final VastResource getResource() {
        return this.resource;
    }

    public final int getWidthPx() {
        return this.widthPx;
    }

    public final int getHeightPx() {
        return this.heightPx;
    }

    public final String getClickThroughUrl() {
        return this.clickThroughUrl;
    }

    public final List<String> getClickTracking() {
        return this.clickTracking;
    }

    public final List<String> getViewTracking() {
        return this.viewTracking;
    }

    public final Long getDurationMillis() {
        return this.durationMillis;
    }

    public final VastOffset getOffset() {
        return this.offset;
    }
}
