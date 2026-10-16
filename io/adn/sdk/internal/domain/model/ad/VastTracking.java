package io.adn.sdk.internal.domain.model.ad;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: VastTracking.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0001\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lio/adn/sdk/internal/domain/model/ad/VastTracking;", "", "event", "Lio/adn/sdk/internal/domain/model/ad/VastTrackingEvent;", "url", "", "offset", "Lio/adn/sdk/internal/domain/model/ad/VastOffset;", "<init>", "(Lio/adn/sdk/internal/domain/model/ad/VastTrackingEvent;Ljava/lang/String;Lio/adn/sdk/internal/domain/model/ad/VastOffset;)V", "getEvent", "()Lio/adn/sdk/internal/domain/model/ad/VastTrackingEvent;", "getUrl", "()Ljava/lang/String;", "getOffset", "()Lio/adn/sdk/internal/domain/model/ad/VastOffset;", "adn-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes7.dex */
public final class VastTracking {
    public static final int $stable = 8;
    private final VastTrackingEvent event;
    private final VastOffset offset;
    private final String url;

    public VastTracking(VastTrackingEvent event, String url, VastOffset vastOffset) {
        Intrinsics.checkNotNullParameter(event, "event");
        Intrinsics.checkNotNullParameter(url, "url");
        this.event = event;
        this.url = url;
        this.offset = vastOffset;
    }

    public /* synthetic */ VastTracking(VastTrackingEvent vastTrackingEvent, String str, VastOffset vastOffset, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(vastTrackingEvent, str, (i & 4) != 0 ? null : vastOffset);
    }

    public final VastTrackingEvent getEvent() {
        return this.event;
    }

    public final VastOffset getOffset() {
        return this.offset;
    }

    public final String getUrl() {
        return this.url;
    }
}
