package io.bidmachine.media3.exoplayer;

import io.bidmachine.media3.common.PlaybackParameters;
import io.bidmachine.media3.common.util.Clock;
import io.bidmachine.media3.common.util.Util;

/* loaded from: classes7.dex */
public final class StandaloneMediaClock implements MediaClock {
    private long baseElapsedMs;
    private long baseUs;
    private final Clock clock;
    private PlaybackParameters playbackParameters = PlaybackParameters.DEFAULT;
    private boolean started;

    public StandaloneMediaClock(Clock clock) {
        this.clock = clock;
    }

    public void start() {
        if (this.started) {
            return;
        }
        this.baseElapsedMs = this.clock.elapsedRealtime();
        this.started = true;
    }

    public void stop() {
        if (this.started) {
            resetPosition(getPositionUs());
            this.started = false;
        }
    }

    public void resetPosition(long j) {
        this.baseUs = j;
        if (this.started) {
            this.baseElapsedMs = this.clock.elapsedRealtime();
        }
    }

    @Override // io.bidmachine.media3.exoplayer.MediaClock
    public long getPositionUs() {
        long mediaTimeUsForPlayoutTimeMs;
        long j = this.baseUs;
        if (!this.started) {
            return j;
        }
        long elapsedRealtime = this.clock.elapsedRealtime() - this.baseElapsedMs;
        if (this.playbackParameters.speed == 1.0f) {
            mediaTimeUsForPlayoutTimeMs = Util.msToUs(elapsedRealtime);
        } else {
            mediaTimeUsForPlayoutTimeMs = this.playbackParameters.getMediaTimeUsForPlayoutTimeMs(elapsedRealtime);
        }
        return j + mediaTimeUsForPlayoutTimeMs;
    }

    @Override // io.bidmachine.media3.exoplayer.MediaClock
    public void setPlaybackParameters(PlaybackParameters playbackParameters) {
        if (this.started) {
            resetPosition(getPositionUs());
        }
        this.playbackParameters = playbackParameters;
    }

    @Override // io.bidmachine.media3.exoplayer.MediaClock
    public PlaybackParameters getPlaybackParameters() {
        return this.playbackParameters;
    }
}
