package io.bidmachine.media3.exoplayer.upstream;

import io.bidmachine.media3.datasource.DataSpec;

/* loaded from: classes7.dex */
public interface TimeToFirstByteEstimator {
    long getTimeToFirstByteEstimateUs();

    void onTransferInitializing(DataSpec dataSpec);

    void onTransferStart(DataSpec dataSpec);

    void reset();
}
