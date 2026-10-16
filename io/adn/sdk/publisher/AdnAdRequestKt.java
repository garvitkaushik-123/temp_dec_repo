package io.adn.sdk.publisher;

import io.adn.sdk.publisher.AdnAdRequest;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AdnAdRequest.kt */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0000¨\u0006\u0003"}, d2 = {"getTimeoutMs", "", "Lio/adn/sdk/publisher/AdnAdRequest;", "adn-sdk_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes7.dex */
public final class AdnAdRequestKt {
    public static final long getTimeoutMs(AdnAdRequest adnAdRequest) {
        Intrinsics.checkNotNullParameter(adnAdRequest, "<this>");
        if (adnAdRequest instanceof AdnAdRequest.AdBidRequest) {
            return ((AdnAdRequest.AdBidRequest) adnAdRequest).getTimeout().getDurationMs();
        }
        if (adnAdRequest instanceof AdnAdRequest.AdBidFetchRequest) {
            return ((AdnAdRequest.AdBidFetchRequest) adnAdRequest).getTimeout().getDurationMs();
        }
        throw new NoWhenBranchMatchedException();
    }
}
