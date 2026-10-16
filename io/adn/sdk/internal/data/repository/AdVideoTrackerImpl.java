package io.adn.sdk.internal.data.repository;

import androidx.core.app.NotificationCompat;
import io.adn.sdk.internal.domain.model.ad.AdVideoTracking;
import io.adn.sdk.internal.domain.model.ad.PercentageOffsetTracker;
import io.adn.sdk.internal.domain.model.ad.PlaybackProgress;
import io.adn.sdk.internal.domain.model.ad.TimeOffsetTracker;
import io.adn.sdk.internal.domain.repository.AdTrackerSender;
import io.adn.sdk.internal.domain.repository.AdVideoTracker;
import java.util.ArrayList;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AdVideoTracker.kt */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0000\b\u0001\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u0010\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u0011H\u0016J\u0010\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J$\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00182\u0006\u0010\r\u001a\u00020\u000b2\u0006\u0010\u0002\u001a\u00020\u0003H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lio/adn/sdk/internal/data/repository/AdVideoTrackerImpl;", "Lio/adn/sdk/internal/domain/repository/AdVideoTracker;", "assetUri", "", "tracking", "Lio/adn/sdk/internal/domain/model/ad/AdVideoTracking;", "tracker", "Lio/adn/sdk/internal/domain/repository/AdTrackerSender;", "<init>", "(Ljava/lang/String;Lio/adn/sdk/internal/domain/model/ad/AdVideoTracking;Lio/adn/sdk/internal/domain/repository/AdTrackerSender;)V", "timeTrackerItemsHandled", "", "percentageTrackerItemsHandled", "contentPlayHead", "trackMuteState", "", "isMuted", "", "trackPlaybackState", "isPlaying", "trackProgress", NotificationCompat.CATEGORY_PROGRESS, "Lio/adn/sdk/internal/domain/model/ad/PlaybackProgress;", "buildVideoMacros", "", "adn-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes7.dex */
public final class AdVideoTrackerImpl implements AdVideoTracker {
    public static final int $stable = 8;
    private final String assetUri;
    private int contentPlayHead;
    private int percentageTrackerItemsHandled;
    private int timeTrackerItemsHandled;
    private final AdTrackerSender tracker;
    private final AdVideoTracking tracking;

    public AdVideoTrackerImpl(String assetUri, AdVideoTracking tracking, AdTrackerSender tracker) {
        Intrinsics.checkNotNullParameter(assetUri, "assetUri");
        Intrinsics.checkNotNullParameter(tracking, "tracking");
        Intrinsics.checkNotNullParameter(tracker, "tracker");
        this.assetUri = assetUri;
        this.tracking = tracking;
        this.tracker = tracker;
    }

    @Override // io.adn.sdk.internal.domain.repository.AdVideoTracker
    public void trackMuteState(boolean isMuted) {
        try {
            Result.Companion companion = Result.INSTANCE;
            AdVideoTrackerImpl adVideoTrackerImpl = this;
            Result.m10241constructorimpl(Boolean.valueOf(this.tracker.track(isMuted ? this.tracking.getMute() : this.tracking.getUnMute(), buildVideoMacros(this.contentPlayHead, this.assetUri))));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            Result.m10241constructorimpl(ResultKt.createFailure(th));
        }
    }

    @Override // io.adn.sdk.internal.domain.repository.AdVideoTracker
    public void trackPlaybackState(boolean isPlaying) {
        try {
            Result.Companion companion = Result.INSTANCE;
            AdVideoTrackerImpl adVideoTrackerImpl = this;
            Result.m10241constructorimpl(Boolean.valueOf(this.tracker.track(isPlaying ? this.tracking.getResume() : this.tracking.getPause(), buildVideoMacros(this.contentPlayHead, this.assetUri))));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            Result.m10241constructorimpl(ResultKt.createFailure(th));
        }
    }

    @Override // io.adn.sdk.internal.domain.repository.AdVideoTracker
    public void trackProgress(PlaybackProgress progress) {
        Intrinsics.checkNotNullParameter(progress, "progress");
        this.contentPlayHead = (int) progress.getCurrentPosition();
        int percentage = (int) (progress.getPercentage() * 100);
        ArrayList arrayList = new ArrayList();
        int size = this.tracking.getPercentageProgressTrackers().size();
        for (int i = this.percentageTrackerItemsHandled; i < size; i++) {
            PercentageOffsetTracker percentageOffsetTracker = this.tracking.getPercentageProgressTrackers().get(i);
            if (percentageOffsetTracker.getPercents() > percentage) {
                break;
            }
            arrayList.add(percentageOffsetTracker.getUrl());
            this.percentageTrackerItemsHandled++;
        }
        int size2 = this.tracking.getTimeProgressTrackers().size();
        for (int i2 = this.timeTrackerItemsHandled; i2 < size2; i2++) {
            TimeOffsetTracker timeOffsetTracker = this.tracking.getTimeProgressTrackers().get(i2);
            if (timeOffsetTracker.getMillis() <= this.contentPlayHead) {
                arrayList.add(timeOffsetTracker.getUrl());
                this.timeTrackerItemsHandled++;
            }
        }
        if (arrayList.isEmpty()) {
            return;
        }
        this.tracker.track(arrayList, buildVideoMacros(this.contentPlayHead, this.assetUri));
    }

    private final Map<String, String> buildVideoMacros(int contentPlayHead, String assetUri) {
        return MapsKt.mapOf(TuplesKt.to("CONTENTPLAYHEAD", String.valueOf(contentPlayHead)), TuplesKt.to("ASSETURI", assetUri));
    }
}
