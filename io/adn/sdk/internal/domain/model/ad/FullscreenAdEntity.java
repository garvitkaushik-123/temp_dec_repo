package io.adn.sdk.internal.domain.model.ad;

import io.adn.sdk.publisher.AdnAdPlacement;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: FullscreenAdEntity.kt */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0081\b\u0018\u00002\u00020\u0001B3\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0005\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J\u000f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\b0\u0005HÆ\u0003J\t\u0010\u0017\u001a\u00020\nHÆ\u0003J=\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u00052\b\b\u0002\u0010\t\u001a\u00020\nHÇ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001H×\u0003J\t\u0010\u001c\u001a\u00020\u001dH×\u0001J\t\u0010\u001e\u001a\u00020\bH×\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u001f"}, d2 = {"Lio/adn/sdk/internal/domain/model/ad/FullscreenAdEntity;", "", "placement", "Lio/adn/sdk/publisher/AdnAdPlacement;", "scenes", "", "Lio/adn/sdk/internal/domain/model/ad/FullscreenAdScene;", "impressionTrackers", "", "extra", "Lio/adn/sdk/internal/domain/model/ad/BidExtra;", "<init>", "(Lio/adn/sdk/publisher/AdnAdPlacement;Ljava/util/List;Ljava/util/List;Lio/adn/sdk/internal/domain/model/ad/BidExtra;)V", "getPlacement", "()Lio/adn/sdk/publisher/AdnAdPlacement;", "getScenes", "()Ljava/util/List;", "getImpressionTrackers", "getExtra", "()Lio/adn/sdk/internal/domain/model/ad/BidExtra;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "adn-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes7.dex */
public final /* data */ class FullscreenAdEntity {
    public static final int $stable = 8;
    private final BidExtra extra;
    private final List<String> impressionTrackers;
    private final AdnAdPlacement placement;
    private final List<FullscreenAdScene> scenes;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ FullscreenAdEntity copy$default(FullscreenAdEntity fullscreenAdEntity, AdnAdPlacement adnAdPlacement, List list, List list2, BidExtra bidExtra, int i, Object obj) {
        if ((i & 1) != 0) {
            adnAdPlacement = fullscreenAdEntity.placement;
        }
        if ((i & 2) != 0) {
            list = fullscreenAdEntity.scenes;
        }
        if ((i & 4) != 0) {
            list2 = fullscreenAdEntity.impressionTrackers;
        }
        if ((i & 8) != 0) {
            bidExtra = fullscreenAdEntity.extra;
        }
        return fullscreenAdEntity.copy(adnAdPlacement, list, list2, bidExtra);
    }

    /* renamed from: component1, reason: from getter */
    public final AdnAdPlacement getPlacement() {
        return this.placement;
    }

    public final List<FullscreenAdScene> component2() {
        return this.scenes;
    }

    public final List<String> component3() {
        return this.impressionTrackers;
    }

    /* renamed from: component4, reason: from getter */
    public final BidExtra getExtra() {
        return this.extra;
    }

    public final FullscreenAdEntity copy(AdnAdPlacement placement, List<? extends FullscreenAdScene> scenes, List<String> impressionTrackers, BidExtra extra) {
        Intrinsics.checkNotNullParameter(placement, "placement");
        Intrinsics.checkNotNullParameter(scenes, "scenes");
        Intrinsics.checkNotNullParameter(impressionTrackers, "impressionTrackers");
        Intrinsics.checkNotNullParameter(extra, "extra");
        return new FullscreenAdEntity(placement, scenes, impressionTrackers, extra);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FullscreenAdEntity)) {
            return false;
        }
        FullscreenAdEntity fullscreenAdEntity = (FullscreenAdEntity) other;
        return this.placement == fullscreenAdEntity.placement && Intrinsics.areEqual(this.scenes, fullscreenAdEntity.scenes) && Intrinsics.areEqual(this.impressionTrackers, fullscreenAdEntity.impressionTrackers) && Intrinsics.areEqual(this.extra, fullscreenAdEntity.extra);
    }

    public int hashCode() {
        return (((((this.placement.hashCode() * 31) + this.scenes.hashCode()) * 31) + this.impressionTrackers.hashCode()) * 31) + this.extra.hashCode();
    }

    public String toString() {
        return "FullscreenAdEntity(placement=" + this.placement + ", scenes=" + this.scenes + ", impressionTrackers=" + this.impressionTrackers + ", extra=" + this.extra + ')';
    }

    /* JADX WARN: Multi-variable type inference failed */
    public FullscreenAdEntity(AdnAdPlacement placement, List<? extends FullscreenAdScene> scenes, List<String> impressionTrackers, BidExtra extra) {
        Intrinsics.checkNotNullParameter(placement, "placement");
        Intrinsics.checkNotNullParameter(scenes, "scenes");
        Intrinsics.checkNotNullParameter(impressionTrackers, "impressionTrackers");
        Intrinsics.checkNotNullParameter(extra, "extra");
        this.placement = placement;
        this.scenes = scenes;
        this.impressionTrackers = impressionTrackers;
        this.extra = extra;
    }

    public final AdnAdPlacement getPlacement() {
        return this.placement;
    }

    public final List<FullscreenAdScene> getScenes() {
        return this.scenes;
    }

    public final List<String> getImpressionTrackers() {
        return this.impressionTrackers;
    }

    public final BidExtra getExtra() {
        return this.extra;
    }
}
