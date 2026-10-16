package io.bidmachine.media3.exoplayer.upstream.experimental;

import android.os.Handler;
import io.bidmachine.media3.datasource.DataSource;
import io.bidmachine.media3.exoplayer.upstream.BandwidthMeter;

/* loaded from: classes7.dex */
public interface BandwidthEstimator {
    public static final long ESTIMATE_NOT_AVAILABLE = Long.MIN_VALUE;

    void addEventListener(Handler handler, BandwidthMeter.EventListener eventListener);

    long getBandwidthEstimate();

    void onBytesTransferred(DataSource dataSource, int i);

    void onNetworkTypeChange(long j);

    void onTransferEnd(DataSource dataSource);

    void onTransferInitializing(DataSource dataSource);

    void onTransferStart(DataSource dataSource);

    void removeEventListener(BandwidthMeter.EventListener eventListener);
}
