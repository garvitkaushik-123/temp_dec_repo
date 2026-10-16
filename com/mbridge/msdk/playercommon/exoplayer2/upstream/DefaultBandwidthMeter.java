package com.mbridge.msdk.playercommon.exoplayer2.upstream;

import android.os.Handler;
import android.support.v4.media.session.PlaybackStateCompat;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.BandwidthMeter;
import com.mbridge.msdk.playercommon.exoplayer2.util.Assertions;
import com.mbridge.msdk.playercommon.exoplayer2.util.Clock;
import com.mbridge.msdk.playercommon.exoplayer2.util.SlidingPercentile;

/* loaded from: classes6.dex */
public final class DefaultBandwidthMeter implements BandwidthMeter, TransferListener<Object> {
    private static final int BYTES_TRANSFERRED_FOR_ESTIMATE = 524288;
    public static final long DEFAULT_INITIAL_BITRATE_ESTIMATE = 1000000;
    public static final int DEFAULT_SLIDING_WINDOW_MAX_WEIGHT = 2000;
    private static final int ELAPSED_MILLIS_FOR_ESTIMATE = 2000;
    private long bitrateEstimate;
    private final Clock clock;
    private final Handler eventHandler;
    private final BandwidthMeter.EventListener eventListener;
    private long sampleBytesTransferred;
    private long sampleStartTimeMs;
    private final SlidingPercentile slidingPercentile;
    private int streamCount;
    private long totalBytesTransferred;
    private long totalElapsedTimeMs;

    public static final class Builder {
        private Handler eventHandler;
        private BandwidthMeter.EventListener eventListener;
        private long initialBitrateEstimate = 1000000;
        private int slidingWindowMaxWeight = 2000;
        private Clock clock = Clock.DEFAULT;

        public DefaultBandwidthMeter build() {
            return new DefaultBandwidthMeter(this.eventHandler, this.eventListener, this.initialBitrateEstimate, this.slidingWindowMaxWeight, this.clock);
        }

        public Builder setClock(Clock clock) {
            this.clock = clock;
            return this;
        }

        public Builder setEventListener(Handler handler, BandwidthMeter.EventListener eventListener) {
            Assertions.checkArgument((handler == null || eventListener == null) ? false : true);
            this.eventHandler = handler;
            this.eventListener = eventListener;
            return this;
        }

        public Builder setInitialBitrateEstimate(long j) {
            this.initialBitrateEstimate = j;
            return this;
        }

        public Builder setSlidingWindowMaxWeight(int i) {
            this.slidingWindowMaxWeight = i;
            return this;
        }
    }

    private void notifyBandwidthSample(final int i, final long j, final long j2) {
        Handler handler = this.eventHandler;
        if (handler == null || this.eventListener == null) {
            return;
        }
        handler.post(new Runnable() { // from class: com.mbridge.msdk.playercommon.exoplayer2.upstream.DefaultBandwidthMeter.1
            @Override // java.lang.Runnable
            public void run() {
                DefaultBandwidthMeter.this.eventListener.onBandwidthSample(i, j, j2);
            }
        });
    }

    @Override // com.mbridge.msdk.playercommon.exoplayer2.upstream.BandwidthMeter
    public synchronized long getBitrateEstimate() {
        return this.bitrateEstimate;
    }

    @Override // com.mbridge.msdk.playercommon.exoplayer2.upstream.TransferListener
    public synchronized void onBytesTransferred(Object obj, int i) {
        this.sampleBytesTransferred += i;
    }

    @Override // com.mbridge.msdk.playercommon.exoplayer2.upstream.TransferListener
    public synchronized void onTransferEnd(Object obj) {
        Throwable th;
        try {
            try {
                Assertions.checkState(this.streamCount > 0);
                long elapsedRealtime = this.clock.elapsedRealtime();
                int i = (int) (elapsedRealtime - this.sampleStartTimeMs);
                this.totalElapsedTimeMs += i;
                long j = this.totalBytesTransferred;
                long j2 = this.sampleBytesTransferred;
                this.totalBytesTransferred = j + j2;
                if (i > 0) {
                    try {
                        this.slidingPercentile.addSample((int) Math.sqrt(j2), (8000 * j2) / r7);
                        if (this.totalElapsedTimeMs >= 2000 || this.totalBytesTransferred >= PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE_ENABLED) {
                            this.bitrateEstimate = (long) this.slidingPercentile.getPercentile(0.5f);
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        throw th;
                    }
                }
                notifyBandwidthSample(i, this.sampleBytesTransferred, this.bitrateEstimate);
                int i2 = this.streamCount - 1;
                this.streamCount = i2;
                if (i2 > 0) {
                    this.sampleStartTimeMs = elapsedRealtime;
                }
                this.sampleBytesTransferred = 0L;
            } catch (Throwable th3) {
                th = th3;
                th = th;
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            th = th;
            throw th;
        }
    }

    @Override // com.mbridge.msdk.playercommon.exoplayer2.upstream.TransferListener
    public synchronized void onTransferStart(Object obj, DataSpec dataSpec) {
        if (this.streamCount == 0) {
            this.sampleStartTimeMs = this.clock.elapsedRealtime();
        }
        this.streamCount++;
    }

    public DefaultBandwidthMeter() {
        this(null, null, 1000000L, 2000, Clock.DEFAULT);
    }

    @Deprecated
    public DefaultBandwidthMeter(Handler handler, BandwidthMeter.EventListener eventListener) {
        this(handler, eventListener, 1000000L, 2000, Clock.DEFAULT);
    }

    @Deprecated
    public DefaultBandwidthMeter(Handler handler, BandwidthMeter.EventListener eventListener, int i) {
        this(handler, eventListener, 1000000L, i, Clock.DEFAULT);
    }

    private DefaultBandwidthMeter(Handler handler, BandwidthMeter.EventListener eventListener, long j, int i, Clock clock) {
        this.eventHandler = handler;
        this.eventListener = eventListener;
        this.slidingPercentile = new SlidingPercentile(i);
        this.clock = clock;
        this.bitrateEstimate = j;
    }
}
