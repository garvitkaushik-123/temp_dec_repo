package io.bidmachine.media3.exoplayer.upstream.experimental;

/* loaded from: classes7.dex */
public interface BandwidthStatistic {
    void addSample(long j, long j2);

    long getBandwidthEstimate();

    void reset();
}
