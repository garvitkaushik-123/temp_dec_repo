package io.adn.sdk.internal.domain.model.ad;

import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AdVideoTracking.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\b\u0007\u0018\u00002\u00020\u0001B]\b\u0000\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0003\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0003¢\u0006\u0004\b\f\u0010\rR\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000fR\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000fR\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000f¨\u0006\u0015"}, d2 = {"Lio/adn/sdk/internal/domain/model/ad/AdVideoTracking;", "", CampaignEx.JSON_NATIVE_VIDEO_MUTE, "", "", "unMute", CampaignEx.JSON_NATIVE_VIDEO_PAUSE, CampaignEx.JSON_NATIVE_VIDEO_RESUME, "timeProgressTrackers", "Lio/adn/sdk/internal/domain/model/ad/TimeOffsetTracker;", "percentageProgressTrackers", "Lio/adn/sdk/internal/domain/model/ad/PercentageOffsetTracker;", "<init>", "(Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;)V", "getMute", "()Ljava/util/List;", "getUnMute", "getPause", "getResume", "getTimeProgressTrackers", "getPercentageProgressTrackers", "adn-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes7.dex */
public final class AdVideoTracking {
    public static final int $stable = 8;
    private final List<String> mute;
    private final List<String> pause;
    private final List<PercentageOffsetTracker> percentageProgressTrackers;
    private final List<String> resume;
    private final List<TimeOffsetTracker> timeProgressTrackers;
    private final List<String> unMute;

    public AdVideoTracking(List<String> mute, List<String> unMute, List<String> pause, List<String> resume, List<TimeOffsetTracker> timeProgressTrackers, List<PercentageOffsetTracker> percentageProgressTrackers) {
        Intrinsics.checkNotNullParameter(mute, "mute");
        Intrinsics.checkNotNullParameter(unMute, "unMute");
        Intrinsics.checkNotNullParameter(pause, "pause");
        Intrinsics.checkNotNullParameter(resume, "resume");
        Intrinsics.checkNotNullParameter(timeProgressTrackers, "timeProgressTrackers");
        Intrinsics.checkNotNullParameter(percentageProgressTrackers, "percentageProgressTrackers");
        this.mute = mute;
        this.unMute = unMute;
        this.pause = pause;
        this.resume = resume;
        this.timeProgressTrackers = timeProgressTrackers;
        this.percentageProgressTrackers = percentageProgressTrackers;
    }

    public final List<String> getMute() {
        return this.mute;
    }

    public final List<String> getUnMute() {
        return this.unMute;
    }

    public final List<String> getPause() {
        return this.pause;
    }

    public final List<String> getResume() {
        return this.resume;
    }

    public final List<TimeOffsetTracker> getTimeProgressTrackers() {
        return this.timeProgressTrackers;
    }

    public final List<PercentageOffsetTracker> getPercentageProgressTrackers() {
        return this.percentageProgressTrackers;
    }
}
