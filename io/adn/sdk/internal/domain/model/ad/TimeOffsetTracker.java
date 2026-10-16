package io.adn.sdk.internal.domain.model.ad;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AdVideoTracking.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÇ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001H×\u0003J\t\u0010\u0012\u001a\u00020\u0013H×\u0001J\t\u0010\u0014\u001a\u00020\u0003H×\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lio/adn/sdk/internal/domain/model/ad/TimeOffsetTracker;", "", "url", "", "millis", "", "<init>", "(Ljava/lang/String;J)V", "getUrl", "()Ljava/lang/String;", "getMillis", "()J", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "adn-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes7.dex */
public final /* data */ class TimeOffsetTracker {
    public static final int $stable = 0;
    private final long millis;
    private final String url;

    public static /* synthetic */ TimeOffsetTracker copy$default(TimeOffsetTracker timeOffsetTracker, String str, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            str = timeOffsetTracker.url;
        }
        if ((i & 2) != 0) {
            j = timeOffsetTracker.millis;
        }
        return timeOffsetTracker.copy(str, j);
    }

    /* renamed from: component1, reason: from getter */
    public final String getUrl() {
        return this.url;
    }

    /* renamed from: component2, reason: from getter */
    public final long getMillis() {
        return this.millis;
    }

    public final TimeOffsetTracker copy(String url, long millis) {
        Intrinsics.checkNotNullParameter(url, "url");
        return new TimeOffsetTracker(url, millis);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TimeOffsetTracker)) {
            return false;
        }
        TimeOffsetTracker timeOffsetTracker = (TimeOffsetTracker) other;
        return Intrinsics.areEqual(this.url, timeOffsetTracker.url) && this.millis == timeOffsetTracker.millis;
    }

    public int hashCode() {
        return (this.url.hashCode() * 31) + Long.hashCode(this.millis);
    }

    public String toString() {
        return "TimeOffsetTracker(url=" + this.url + ", millis=" + this.millis + ')';
    }

    public TimeOffsetTracker(String url, long j) {
        Intrinsics.checkNotNullParameter(url, "url");
        this.url = url;
        this.millis = j;
    }

    public final long getMillis() {
        return this.millis;
    }

    public final String getUrl() {
        return this.url;
    }
}
