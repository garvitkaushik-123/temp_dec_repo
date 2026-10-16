package io.adn.sdk.internal.domain.model.ad;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AdVideoTracking.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÇ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001H×\u0003J\t\u0010\u0012\u001a\u00020\u0005H×\u0001J\t\u0010\u0013\u001a\u00020\u0003H×\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0014"}, d2 = {"Lio/adn/sdk/internal/domain/model/ad/PercentageOffsetTracker;", "", "url", "", "percents", "", "<init>", "(Ljava/lang/String;I)V", "getUrl", "()Ljava/lang/String;", "getPercents", "()I", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "adn-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes7.dex */
public final /* data */ class PercentageOffsetTracker {
    public static final int $stable = 0;
    private final int percents;
    private final String url;

    public static /* synthetic */ PercentageOffsetTracker copy$default(PercentageOffsetTracker percentageOffsetTracker, String str, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = percentageOffsetTracker.url;
        }
        if ((i2 & 2) != 0) {
            i = percentageOffsetTracker.percents;
        }
        return percentageOffsetTracker.copy(str, i);
    }

    /* renamed from: component1, reason: from getter */
    public final String getUrl() {
        return this.url;
    }

    /* renamed from: component2, reason: from getter */
    public final int getPercents() {
        return this.percents;
    }

    public final PercentageOffsetTracker copy(String url, int percents) {
        Intrinsics.checkNotNullParameter(url, "url");
        return new PercentageOffsetTracker(url, percents);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PercentageOffsetTracker)) {
            return false;
        }
        PercentageOffsetTracker percentageOffsetTracker = (PercentageOffsetTracker) other;
        return Intrinsics.areEqual(this.url, percentageOffsetTracker.url) && this.percents == percentageOffsetTracker.percents;
    }

    public int hashCode() {
        return (this.url.hashCode() * 31) + Integer.hashCode(this.percents);
    }

    public String toString() {
        return "PercentageOffsetTracker(url=" + this.url + ", percents=" + this.percents + ')';
    }

    public PercentageOffsetTracker(String url, int i) {
        Intrinsics.checkNotNullParameter(url, "url");
        this.url = url;
        this.percents = i;
    }

    public final int getPercents() {
        return this.percents;
    }

    public final String getUrl() {
        return this.url;
    }
}
