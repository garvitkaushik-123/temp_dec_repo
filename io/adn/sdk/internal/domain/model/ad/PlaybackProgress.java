package io.adn.sdk.internal.domain.model.ad;

import kotlin.Metadata;
import kotlin.ranges.RangesKt;

/* compiled from: PlaybackProgress.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0081\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÇ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001H×\u0003J\t\u0010\u0018\u001a\u00020\u000fH×\u0001J\t\u0010\u0019\u001a\u00020\u001aH×\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0011\u0010\n\u001a\u00020\u000b8F¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0011\u0010\u000e\u001a\u00020\u000f8F¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001b"}, d2 = {"Lio/adn/sdk/internal/domain/model/ad/PlaybackProgress;", "", "currentPosition", "", "totalDuration", "<init>", "(JJ)V", "getCurrentPosition", "()J", "getTotalDuration", "percentage", "", "getPercentage", "()F", "remainingMillis", "", "getRemainingMillis", "()I", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "adn-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes7.dex */
public final /* data */ class PlaybackProgress {
    public static final int $stable = 0;
    private final long currentPosition;
    private final long totalDuration;

    public static /* synthetic */ PlaybackProgress copy$default(PlaybackProgress playbackProgress, long j, long j2, int i, Object obj) {
        if ((i & 1) != 0) {
            j = playbackProgress.currentPosition;
        }
        if ((i & 2) != 0) {
            j2 = playbackProgress.totalDuration;
        }
        return playbackProgress.copy(j, j2);
    }

    /* renamed from: component1, reason: from getter */
    public final long getCurrentPosition() {
        return this.currentPosition;
    }

    /* renamed from: component2, reason: from getter */
    public final long getTotalDuration() {
        return this.totalDuration;
    }

    public final PlaybackProgress copy(long currentPosition, long totalDuration) {
        return new PlaybackProgress(currentPosition, totalDuration);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PlaybackProgress)) {
            return false;
        }
        PlaybackProgress playbackProgress = (PlaybackProgress) other;
        return this.currentPosition == playbackProgress.currentPosition && this.totalDuration == playbackProgress.totalDuration;
    }

    public int hashCode() {
        return (Long.hashCode(this.currentPosition) * 31) + Long.hashCode(this.totalDuration);
    }

    public String toString() {
        return "PlaybackProgress(currentPosition=" + this.currentPosition + ", totalDuration=" + this.totalDuration + ')';
    }

    public PlaybackProgress(long j, long j2) {
        this.currentPosition = j;
        this.totalDuration = j2;
    }

    public final long getCurrentPosition() {
        return this.currentPosition;
    }

    public final long getTotalDuration() {
        return this.totalDuration;
    }

    public final float getPercentage() {
        long j = this.totalDuration;
        if (j == 0) {
            return 0.0f;
        }
        return (float) (this.currentPosition / j);
    }

    public final int getRemainingMillis() {
        return (int) RangesKt.coerceAtLeast(this.totalDuration - this.currentPosition, 0L);
    }
}
