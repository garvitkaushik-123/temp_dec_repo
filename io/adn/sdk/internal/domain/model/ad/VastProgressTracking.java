package io.adn.sdk.internal.domain.model.ad;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: VastAdEntity.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0001\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lio/adn/sdk/internal/domain/model/ad/VastProgressTracking;", "", "url", "", "offset", "Lio/adn/sdk/internal/domain/model/ad/VastOffset;", "<init>", "(Ljava/lang/String;Lio/adn/sdk/internal/domain/model/ad/VastOffset;)V", "getUrl", "()Ljava/lang/String;", "getOffset", "()Lio/adn/sdk/internal/domain/model/ad/VastOffset;", "adn-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes7.dex */
public final class VastProgressTracking {
    public static final int $stable = 8;
    private final VastOffset offset;
    private final String url;

    public VastProgressTracking(String url, VastOffset offset) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(offset, "offset");
        this.url = url;
        this.offset = offset;
    }

    public final VastOffset getOffset() {
        return this.offset;
    }

    public final String getUrl() {
        return this.url;
    }
}
