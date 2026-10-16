package io.adn.sdk.internal.domain.model.ad;

import io.adn.sdk.internal.domain.model.ad.FullscreenAdEvent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: FullscreenAdEvent.kt */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0000¨\u0006\u0003"}, d2 = {"isClosedByUser", "", "Lio/adn/sdk/internal/domain/model/ad/FullscreenAdEvent$Dismiss;", "adn-sdk_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes7.dex */
public final class FullscreenAdEventKt {
    public static final boolean isClosedByUser(FullscreenAdEvent.Dismiss dismiss) {
        Intrinsics.checkNotNullParameter(dismiss, "<this>");
        return dismiss.getOrigin() == DismissOrigin.User;
    }
}
