package io.adn.sdk.internal.domain.repository;

import androidx.core.app.NotificationCompat;
import io.adn.sdk.internal.domain.model.ad.PlaybackProgress;
import kotlin.Metadata;

/* compiled from: AdVideoTracker.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b`\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0005H&J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\nH&¨\u0006\u000b"}, d2 = {"Lio/adn/sdk/internal/domain/repository/AdVideoTracker;", "", "trackMuteState", "", "isMuted", "", "trackPlaybackState", "isPlaying", "trackProgress", NotificationCompat.CATEGORY_PROGRESS, "Lio/adn/sdk/internal/domain/model/ad/PlaybackProgress;", "adn-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes7.dex */
public interface AdVideoTracker {
    void trackMuteState(boolean isMuted);

    void trackPlaybackState(boolean isPlaying);

    void trackProgress(PlaybackProgress progress);
}
