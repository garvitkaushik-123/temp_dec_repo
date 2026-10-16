package io.adn.sdk.internal.data.repository;

import com.ironsource.mediationsdk.utils.IronSourceConstants;
import io.adn.sdk.internal.domain.repository.AdTrackerSender;
import io.adn.sdk.internal.domain.repository.VastTracker;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: VastTrackerImpl.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010$\n\u0000\b\u0001\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001e\u0010\u0006\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u001c\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\u000e2\u0006\u0010\u000b\u001a\u00020\fH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lio/adn/sdk/internal/data/repository/VastTrackerImpl;", "Lio/adn/sdk/internal/domain/repository/VastTracker;", "adTrackerSender", "Lio/adn/sdk/internal/domain/repository/AdTrackerSender;", "<init>", "(Lio/adn/sdk/internal/domain/repository/AdTrackerSender;)V", "trackError", "", "errorUrls", "", "", IronSourceConstants.EVENTS_ERROR_CODE, "", "buildVastErrorMacros", "", "adn-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes7.dex */
public final class VastTrackerImpl implements VastTracker {
    public static final int $stable = 8;
    private final AdTrackerSender adTrackerSender;

    public VastTrackerImpl(AdTrackerSender adTrackerSender) {
        Intrinsics.checkNotNullParameter(adTrackerSender, "adTrackerSender");
        this.adTrackerSender = adTrackerSender;
    }

    @Override // io.adn.sdk.internal.domain.repository.VastTracker
    public boolean trackError(List<String> errorUrls, int errorCode) {
        Intrinsics.checkNotNullParameter(errorUrls, "errorUrls");
        if (errorUrls.isEmpty()) {
            return false;
        }
        return this.adTrackerSender.track(errorUrls, buildVastErrorMacros(errorCode));
    }

    private final Map<String, String> buildVastErrorMacros(int errorCode) {
        return MapsKt.mapOf(TuplesKt.to("ERRORCODE", String.valueOf(errorCode)));
    }
}
