package io.adn.sdk.internal.domain.model.ad;

import io.adn.sdk.internal.common.utils.ListKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: AdLink.kt */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0000¨\u0006\u0003"}, d2 = {"isValid", "", "Lio/adn/sdk/internal/domain/model/ad/AdLink;", "adn-sdk_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes7.dex */
public final class AdLinkKt {
    public static final boolean isValid(AdLink adLink) {
        Intrinsics.checkNotNullParameter(adLink, "<this>");
        String url = adLink.getUrl();
        return (url == null || StringsKt.isBlank(url) || !ListKt.isNotEmptyOrBlank(adLink.getClickTrackers())) ? false : true;
    }
}
