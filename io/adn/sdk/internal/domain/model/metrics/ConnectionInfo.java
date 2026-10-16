package io.adn.sdk.internal.domain.model.metrics;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ConnectionInfo.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0001\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lio/adn/sdk/internal/domain/model/metrics/ConnectionInfo;", "", "isMetered", "", "type", "Lio/adn/sdk/internal/domain/model/metrics/ConnectionType;", "<init>", "(ZLio/adn/sdk/internal/domain/model/metrics/ConnectionType;)V", "()Z", "getType", "()Lio/adn/sdk/internal/domain/model/metrics/ConnectionType;", "adn-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes7.dex */
public final class ConnectionInfo {
    public static final int $stable = 0;
    private final boolean isMetered;
    private final ConnectionType type;

    public ConnectionInfo(boolean z, ConnectionType type) {
        Intrinsics.checkNotNullParameter(type, "type");
        this.isMetered = z;
        this.type = type;
    }

    public final ConnectionType getType() {
        return this.type;
    }

    /* renamed from: isMetered, reason: from getter */
    public final boolean getIsMetered() {
        return this.isMetered;
    }
}
