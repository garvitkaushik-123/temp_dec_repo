package io.adn.sdk.internal.ui.common.mraid;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: MraidLayoutMetrics.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0081\b\u0018\u00002\u00020\u0001B/\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J1\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÇ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001H×\u0003J\t\u0010\u0016\u001a\u00020\u0017H×\u0001J\t\u0010\u0018\u001a\u00020\u0019H×\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006\u001a"}, d2 = {"Lio/adn/sdk/internal/ui/common/mraid/MraidLayoutMetrics;", "", "screenDpRect", "Lio/adn/sdk/internal/ui/common/mraid/RectValues;", "rootViewDpRect", "currentAdDpRect", "defaultAdDpRect", "<init>", "(Lio/adn/sdk/internal/ui/common/mraid/RectValues;Lio/adn/sdk/internal/ui/common/mraid/RectValues;Lio/adn/sdk/internal/ui/common/mraid/RectValues;Lio/adn/sdk/internal/ui/common/mraid/RectValues;)V", "getScreenDpRect", "()Lio/adn/sdk/internal/ui/common/mraid/RectValues;", "getRootViewDpRect", "getCurrentAdDpRect", "getDefaultAdDpRect", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "", "adn-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes7.dex */
public final /* data */ class MraidLayoutMetrics {
    public static final int $stable = 0;
    private final RectValues currentAdDpRect;
    private final RectValues defaultAdDpRect;
    private final RectValues rootViewDpRect;
    private final RectValues screenDpRect;

    public MraidLayoutMetrics() {
        this(null, null, null, null, 15, null);
    }

    public static /* synthetic */ MraidLayoutMetrics copy$default(MraidLayoutMetrics mraidLayoutMetrics, RectValues rectValues, RectValues rectValues2, RectValues rectValues3, RectValues rectValues4, int i, Object obj) {
        if ((i & 1) != 0) {
            rectValues = mraidLayoutMetrics.screenDpRect;
        }
        if ((i & 2) != 0) {
            rectValues2 = mraidLayoutMetrics.rootViewDpRect;
        }
        if ((i & 4) != 0) {
            rectValues3 = mraidLayoutMetrics.currentAdDpRect;
        }
        if ((i & 8) != 0) {
            rectValues4 = mraidLayoutMetrics.defaultAdDpRect;
        }
        return mraidLayoutMetrics.copy(rectValues, rectValues2, rectValues3, rectValues4);
    }

    /* renamed from: component1, reason: from getter */
    public final RectValues getScreenDpRect() {
        return this.screenDpRect;
    }

    /* renamed from: component2, reason: from getter */
    public final RectValues getRootViewDpRect() {
        return this.rootViewDpRect;
    }

    /* renamed from: component3, reason: from getter */
    public final RectValues getCurrentAdDpRect() {
        return this.currentAdDpRect;
    }

    /* renamed from: component4, reason: from getter */
    public final RectValues getDefaultAdDpRect() {
        return this.defaultAdDpRect;
    }

    public final MraidLayoutMetrics copy(RectValues screenDpRect, RectValues rootViewDpRect, RectValues currentAdDpRect, RectValues defaultAdDpRect) {
        Intrinsics.checkNotNullParameter(screenDpRect, "screenDpRect");
        Intrinsics.checkNotNullParameter(rootViewDpRect, "rootViewDpRect");
        Intrinsics.checkNotNullParameter(currentAdDpRect, "currentAdDpRect");
        Intrinsics.checkNotNullParameter(defaultAdDpRect, "defaultAdDpRect");
        return new MraidLayoutMetrics(screenDpRect, rootViewDpRect, currentAdDpRect, defaultAdDpRect);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MraidLayoutMetrics)) {
            return false;
        }
        MraidLayoutMetrics mraidLayoutMetrics = (MraidLayoutMetrics) other;
        return Intrinsics.areEqual(this.screenDpRect, mraidLayoutMetrics.screenDpRect) && Intrinsics.areEqual(this.rootViewDpRect, mraidLayoutMetrics.rootViewDpRect) && Intrinsics.areEqual(this.currentAdDpRect, mraidLayoutMetrics.currentAdDpRect) && Intrinsics.areEqual(this.defaultAdDpRect, mraidLayoutMetrics.defaultAdDpRect);
    }

    public int hashCode() {
        return (((((this.screenDpRect.hashCode() * 31) + this.rootViewDpRect.hashCode()) * 31) + this.currentAdDpRect.hashCode()) * 31) + this.defaultAdDpRect.hashCode();
    }

    public String toString() {
        return "MraidLayoutMetrics(screenDpRect=" + this.screenDpRect + ", rootViewDpRect=" + this.rootViewDpRect + ", currentAdDpRect=" + this.currentAdDpRect + ", defaultAdDpRect=" + this.defaultAdDpRect + ')';
    }

    public MraidLayoutMetrics(RectValues screenDpRect, RectValues rootViewDpRect, RectValues currentAdDpRect, RectValues defaultAdDpRect) {
        Intrinsics.checkNotNullParameter(screenDpRect, "screenDpRect");
        Intrinsics.checkNotNullParameter(rootViewDpRect, "rootViewDpRect");
        Intrinsics.checkNotNullParameter(currentAdDpRect, "currentAdDpRect");
        Intrinsics.checkNotNullParameter(defaultAdDpRect, "defaultAdDpRect");
        this.screenDpRect = screenDpRect;
        this.rootViewDpRect = rootViewDpRect;
        this.currentAdDpRect = currentAdDpRect;
        this.defaultAdDpRect = defaultAdDpRect;
    }

    public /* synthetic */ MraidLayoutMetrics(RectValues rectValues, RectValues rectValues2, RectValues rectValues3, RectValues rectValues4, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new RectValues(0, 0, 0, 0, 15, null) : rectValues, (i & 2) != 0 ? new RectValues(0, 0, 0, 0, 15, null) : rectValues2, (i & 4) != 0 ? new RectValues(0, 0, 0, 0, 15, null) : rectValues3, (i & 8) != 0 ? new RectValues(0, 0, 0, 0, 15, null) : rectValues4);
    }

    public final RectValues getScreenDpRect() {
        return this.screenDpRect;
    }

    public final RectValues getRootViewDpRect() {
        return this.rootViewDpRect;
    }

    public final RectValues getCurrentAdDpRect() {
        return this.currentAdDpRect;
    }

    public final RectValues getDefaultAdDpRect() {
        return this.defaultAdDpRect;
    }
}
