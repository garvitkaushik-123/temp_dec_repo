package io.adn.sdk.internal.domain.repository;

import java.util.List;
import java.util.Map;
import kotlin.Metadata;

/* compiled from: AdTrackerSender.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0000\bà\u0080\u0001\u0018\u00002\u00020\u0001J*\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\bH&¨\u0006\t"}, d2 = {"Lio/adn/sdk/internal/domain/repository/AdTrackerSender;", "", "track", "", "urls", "", "", "macros", "", "adn-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes7.dex */
public interface AdTrackerSender {
    boolean track(List<String> urls, Map<String, String> macros);
}
