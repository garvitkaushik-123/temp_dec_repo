package io.bidmachine.media3.exoplayer.trackselection;

import android.os.SystemClock;
import io.bidmachine.media3.common.Timeline;
import io.bidmachine.media3.common.TrackGroup;
import io.bidmachine.media3.exoplayer.source.MediaSource;
import io.bidmachine.media3.exoplayer.source.chunk.MediaChunk;
import io.bidmachine.media3.exoplayer.source.chunk.MediaChunkIterator;
import io.bidmachine.media3.exoplayer.trackselection.ExoTrackSelection;
import io.bidmachine.media3.exoplayer.trackselection.RandomTrackSelection;
import io.bidmachine.media3.exoplayer.trackselection.TrackSelectionUtil;
import io.bidmachine.media3.exoplayer.upstream.BandwidthMeter;
import java.util.List;
import java.util.Random;

/* loaded from: classes7.dex */
public final class RandomTrackSelection extends BaseTrackSelection {
    private final Random random;
    private int selectedIndex;

    @Override // io.bidmachine.media3.exoplayer.trackselection.ExoTrackSelection
    public Object getSelectionData() {
        return null;
    }

    @Override // io.bidmachine.media3.exoplayer.trackselection.ExoTrackSelection
    public int getSelectionReason() {
        return 3;
    }

    public static final class Factory implements ExoTrackSelection.Factory {
        private final Random random;

        public Factory() {
            this.random = new Random();
        }

        public Factory(int i) {
            this.random = new Random(i);
        }

        @Override // io.bidmachine.media3.exoplayer.trackselection.ExoTrackSelection.Factory
        public ExoTrackSelection[] createTrackSelections(ExoTrackSelection.Definition[] definitionArr, BandwidthMeter bandwidthMeter, MediaSource.MediaPeriodId mediaPeriodId, Timeline timeline) {
            return TrackSelectionUtil.createTrackSelectionsForDefinitions(definitionArr, new TrackSelectionUtil.AdaptiveTrackSelectionFactory() { // from class: io.bidmachine.media3.exoplayer.trackselection.RandomTrackSelection$Factory$$ExternalSyntheticLambda0
                @Override // io.bidmachine.media3.exoplayer.trackselection.TrackSelectionUtil.AdaptiveTrackSelectionFactory
                public final ExoTrackSelection createAdaptiveTrackSelection(ExoTrackSelection.Definition definition) {
                    return RandomTrackSelection.Factory.this.m9854x15b1e7e3(definition);
                }
            });
        }

        /* renamed from: lambda$createTrackSelections$0$io-bidmachine-media3-exoplayer-trackselection-RandomTrackSelection$Factory, reason: not valid java name */
        /* synthetic */ ExoTrackSelection m9854x15b1e7e3(ExoTrackSelection.Definition definition) {
            return new RandomTrackSelection(definition.group, definition.tracks, definition.type, this.random);
        }
    }

    public RandomTrackSelection(TrackGroup trackGroup, int[] iArr, int i, Random random) {
        super(trackGroup, iArr, i);
        this.random = random;
        this.selectedIndex = random.nextInt(this.length);
    }

    @Override // io.bidmachine.media3.exoplayer.trackselection.ExoTrackSelection
    public void updateSelectedTrack(long j, long j2, long j3, List<? extends MediaChunk> list, MediaChunkIterator[] mediaChunkIteratorArr) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        int i = 0;
        for (int i2 = 0; i2 < this.length; i2++) {
            if (!isTrackExcluded(i2, elapsedRealtime)) {
                i++;
            }
        }
        this.selectedIndex = this.random.nextInt(i);
        if (i != this.length) {
            int i3 = 0;
            for (int i4 = 0; i4 < this.length; i4++) {
                if (!isTrackExcluded(i4, elapsedRealtime)) {
                    int i5 = i3 + 1;
                    if (this.selectedIndex == i3) {
                        this.selectedIndex = i4;
                        return;
                    }
                    i3 = i5;
                }
            }
        }
    }

    @Override // io.bidmachine.media3.exoplayer.trackselection.ExoTrackSelection
    public int getSelectedIndex() {
        return this.selectedIndex;
    }
}
