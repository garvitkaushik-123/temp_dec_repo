package io.adn.sdk.internal.domain.repository;

import com.ironsource.mediationsdk.utils.IronSourceConstants;
import java.util.List;
import kotlin.Metadata;

/* compiled from: VastTracker.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\b`\u0018\u00002\u00020\u0001J\u001e\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0007\u001a\u00020\bH&¨\u0006\t"}, d2 = {"Lio/adn/sdk/internal/domain/repository/VastTracker;", "", "trackError", "", "errorUrls", "", "", IronSourceConstants.EVENTS_ERROR_CODE, "", "adn-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes7.dex */
public interface VastTracker {
    boolean trackError(List<String> errorUrls, int errorCode);
}
