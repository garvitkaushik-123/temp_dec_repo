package io.bidmachine.media3.exoplayer.source;

import android.util.Pair;
import io.bidmachine.media3.common.AdPlaybackState;
import io.bidmachine.media3.common.MediaItem;
import io.bidmachine.media3.common.Timeline;
import io.bidmachine.media3.common.util.Assertions;
import io.bidmachine.media3.exoplayer.source.MediaSource;
import io.bidmachine.media3.exoplayer.upstream.Allocator;
import java.util.Objects;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

/* loaded from: classes7.dex */
public final class MaskingMediaSource extends WrappingMediaSource {
    private boolean hasRealTimeline;
    private boolean hasStartedPreparing;
    private boolean isPrepared;
    private final Timeline.Period period;
    private MaskingTimeline timeline;
    private MaskingMediaPeriod unpreparedMaskingMediaPeriod;
    private final boolean useLazyPreparation;
    private final Timeline.Window window;

    @Override // io.bidmachine.media3.exoplayer.source.CompositeMediaSource, io.bidmachine.media3.exoplayer.source.MediaSource
    public void maybeThrowSourceInfoRefreshError() {
    }

    public MaskingMediaSource(MediaSource mediaSource, boolean z) {
        super(mediaSource);
        this.useLazyPreparation = z && mediaSource.isSingleWindow();
        this.window = new Timeline.Window();
        this.period = new Timeline.Period();
        Timeline initialTimeline = mediaSource.getInitialTimeline();
        if (initialTimeline != null) {
            this.timeline = MaskingTimeline.createWithRealTimeline(initialTimeline, null, null);
            this.hasRealTimeline = true;
        } else {
            this.timeline = MaskingTimeline.createWithPlaceholderTimeline(mediaSource.getMediaItem());
        }
    }

    public Timeline getTimeline() {
        return this.timeline;
    }

    @Override // io.bidmachine.media3.exoplayer.source.WrappingMediaSource, io.bidmachine.media3.exoplayer.source.MediaSource
    public boolean canUpdateMediaItem(MediaItem mediaItem) {
        return this.mediaSource.canUpdateMediaItem(mediaItem);
    }

    @Override // io.bidmachine.media3.exoplayer.source.WrappingMediaSource, io.bidmachine.media3.exoplayer.source.MediaSource
    public void updateMediaItem(MediaItem mediaItem) {
        if (this.hasRealTimeline) {
            this.timeline = this.timeline.cloneWithUpdatedTimeline(new TimelineWithUpdatedMediaItem(this.timeline.timeline, mediaItem));
        } else {
            this.timeline = MaskingTimeline.createWithPlaceholderTimeline(mediaItem);
        }
        this.mediaSource.updateMediaItem(mediaItem);
    }

    @Override // io.bidmachine.media3.exoplayer.source.WrappingMediaSource
    public void prepareSourceInternal() {
        if (this.useLazyPreparation) {
            return;
        }
        this.hasStartedPreparing = true;
        prepareChildSource();
    }

    @Override // io.bidmachine.media3.exoplayer.source.WrappingMediaSource, io.bidmachine.media3.exoplayer.source.MediaSource
    public MaskingMediaPeriod createPeriod(MediaSource.MediaPeriodId mediaPeriodId, Allocator allocator, long j) {
        MaskingMediaPeriod maskingMediaPeriod = new MaskingMediaPeriod(mediaPeriodId, allocator, j);
        maskingMediaPeriod.setMediaSource(this.mediaSource);
        if (this.isPrepared) {
            maskingMediaPeriod.createPeriod(mediaPeriodId.copyWithPeriodUid(getInternalPeriodUid(mediaPeriodId.periodUid)));
            return maskingMediaPeriod;
        }
        this.unpreparedMaskingMediaPeriod = maskingMediaPeriod;
        if (!this.hasStartedPreparing) {
            this.hasStartedPreparing = true;
            prepareChildSource();
        }
        return maskingMediaPeriod;
    }

    @Override // io.bidmachine.media3.exoplayer.source.WrappingMediaSource, io.bidmachine.media3.exoplayer.source.MediaSource
    public void releasePeriod(MediaPeriod mediaPeriod) {
        ((MaskingMediaPeriod) mediaPeriod).releasePeriod();
        if (mediaPeriod == this.unpreparedMaskingMediaPeriod) {
            this.unpreparedMaskingMediaPeriod = null;
        }
    }

    @Override // io.bidmachine.media3.exoplayer.source.CompositeMediaSource, io.bidmachine.media3.exoplayer.source.BaseMediaSource
    public void releaseSourceInternal() {
        this.isPrepared = false;
        this.hasStartedPreparing = false;
        super.releaseSourceInternal();
    }

    /* JADX WARN: Removed duplicated region for block: B:12:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x00c0  */
    @Override // io.bidmachine.media3.exoplayer.source.WrappingMediaSource
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected void onChildSourceInfoRefreshed(Timeline timeline) {
        long j;
        MaskingTimeline createWithRealTimeline;
        MaskingMediaPeriod maskingMediaPeriod;
        MediaSource.MediaPeriodId copyWithPeriodUid;
        MaskingTimeline createWithRealTimeline2;
        if (this.isPrepared) {
            this.timeline = this.timeline.cloneWithUpdatedTimeline(timeline);
            MaskingMediaPeriod maskingMediaPeriod2 = this.unpreparedMaskingMediaPeriod;
            if (maskingMediaPeriod2 != null) {
                setPreparePositionOverrideToUnpreparedMaskingPeriod(maskingMediaPeriod2.getPreparePositionOverrideUs());
            }
        } else if (timeline.isEmpty()) {
            if (this.hasRealTimeline) {
                createWithRealTimeline2 = this.timeline.cloneWithUpdatedTimeline(timeline);
            } else {
                createWithRealTimeline2 = MaskingTimeline.createWithRealTimeline(timeline, Timeline.Window.SINGLE_WINDOW_UID, MaskingTimeline.MASKING_EXTERNAL_PERIOD_UID);
            }
            this.timeline = createWithRealTimeline2;
        } else {
            timeline.getWindow(0, this.window);
            long defaultPositionUs = this.window.getDefaultPositionUs();
            Object obj = this.window.uid;
            MaskingMediaPeriod maskingMediaPeriod3 = this.unpreparedMaskingMediaPeriod;
            if (maskingMediaPeriod3 != null) {
                long preparePositionUs = maskingMediaPeriod3.getPreparePositionUs();
                this.timeline.getPeriodByUid(this.unpreparedMaskingMediaPeriod.id.periodUid, this.period);
                long positionInWindowUs = this.period.getPositionInWindowUs() + preparePositionUs;
                if (positionInWindowUs != this.timeline.getWindow(0, this.window).getDefaultPositionUs()) {
                    j = positionInWindowUs;
                    Pair<Object, Long> periodPositionUs = timeline.getPeriodPositionUs(this.window, this.period, 0, j);
                    Object obj2 = periodPositionUs.first;
                    long longValue = ((Long) periodPositionUs.second).longValue();
                    if (!this.hasRealTimeline) {
                        createWithRealTimeline = this.timeline.cloneWithUpdatedTimeline(timeline);
                    } else {
                        createWithRealTimeline = MaskingTimeline.createWithRealTimeline(timeline, obj, obj2);
                    }
                    this.timeline = createWithRealTimeline;
                    maskingMediaPeriod = this.unpreparedMaskingMediaPeriod;
                    if (maskingMediaPeriod != null && setPreparePositionOverrideToUnpreparedMaskingPeriod(longValue)) {
                        copyWithPeriodUid = maskingMediaPeriod.id.copyWithPeriodUid(getInternalPeriodUid(maskingMediaPeriod.id.periodUid));
                        this.hasRealTimeline = true;
                        this.isPrepared = true;
                        refreshSourceInfo(this.timeline);
                        if (copyWithPeriodUid != null) {
                            ((MaskingMediaPeriod) Assertions.checkNotNull(this.unpreparedMaskingMediaPeriod)).createPeriod(copyWithPeriodUid);
                            return;
                        }
                        return;
                    }
                }
            }
            j = defaultPositionUs;
            Pair<Object, Long> periodPositionUs2 = timeline.getPeriodPositionUs(this.window, this.period, 0, j);
            Object obj22 = periodPositionUs2.first;
            long longValue2 = ((Long) periodPositionUs2.second).longValue();
            if (!this.hasRealTimeline) {
            }
            this.timeline = createWithRealTimeline;
            maskingMediaPeriod = this.unpreparedMaskingMediaPeriod;
            if (maskingMediaPeriod != null) {
                copyWithPeriodUid = maskingMediaPeriod.id.copyWithPeriodUid(getInternalPeriodUid(maskingMediaPeriod.id.periodUid));
                this.hasRealTimeline = true;
                this.isPrepared = true;
                refreshSourceInfo(this.timeline);
                if (copyWithPeriodUid != null) {
                }
            }
        }
        copyWithPeriodUid = null;
        this.hasRealTimeline = true;
        this.isPrepared = true;
        refreshSourceInfo(this.timeline);
        if (copyWithPeriodUid != null) {
        }
    }

    @Override // io.bidmachine.media3.exoplayer.source.WrappingMediaSource
    protected MediaSource.MediaPeriodId getMediaPeriodIdForChildMediaPeriodId(MediaSource.MediaPeriodId mediaPeriodId) {
        return mediaPeriodId.copyWithPeriodUid(getExternalPeriodUid(mediaPeriodId.periodUid));
    }

    private Object getInternalPeriodUid(Object obj) {
        return (this.timeline.replacedInternalPeriodUid == null || !obj.equals(MaskingTimeline.MASKING_EXTERNAL_PERIOD_UID)) ? obj : this.timeline.replacedInternalPeriodUid;
    }

    private Object getExternalPeriodUid(Object obj) {
        return (this.timeline.replacedInternalPeriodUid == null || !this.timeline.replacedInternalPeriodUid.equals(obj)) ? obj : MaskingTimeline.MASKING_EXTERNAL_PERIOD_UID;
    }

    @RequiresNonNull({"unpreparedMaskingMediaPeriod"})
    private boolean setPreparePositionOverrideToUnpreparedMaskingPeriod(long j) {
        MaskingMediaPeriod maskingMediaPeriod = this.unpreparedMaskingMediaPeriod;
        int indexOfPeriod = this.timeline.getIndexOfPeriod(maskingMediaPeriod.id.periodUid);
        if (indexOfPeriod == -1) {
            return false;
        }
        long j2 = this.timeline.getPeriod(indexOfPeriod, this.period).durationUs;
        if (j2 != -9223372036854775807L && j >= j2) {
            j = Math.max(0L, j2 - 1);
        }
        maskingMediaPeriod.overridePreparePositionUs(j);
        return true;
    }

    private static final class MaskingTimeline extends ForwardingTimeline {
        public static final Object MASKING_EXTERNAL_PERIOD_UID = new Object();
        private final Object replacedInternalPeriodUid;
        private final Object replacedInternalWindowUid;

        public static MaskingTimeline createWithPlaceholderTimeline(MediaItem mediaItem) {
            return new MaskingTimeline(new PlaceholderTimeline(mediaItem), Timeline.Window.SINGLE_WINDOW_UID, MASKING_EXTERNAL_PERIOD_UID);
        }

        public static MaskingTimeline createWithRealTimeline(Timeline timeline, Object obj, Object obj2) {
            return new MaskingTimeline(timeline, obj, obj2);
        }

        private MaskingTimeline(Timeline timeline, Object obj, Object obj2) {
            super(timeline);
            this.replacedInternalWindowUid = obj;
            this.replacedInternalPeriodUid = obj2;
        }

        public MaskingTimeline cloneWithUpdatedTimeline(Timeline timeline) {
            return new MaskingTimeline(timeline, this.replacedInternalWindowUid, this.replacedInternalPeriodUid);
        }

        @Override // io.bidmachine.media3.exoplayer.source.ForwardingTimeline, io.bidmachine.media3.common.Timeline
        public Timeline.Window getWindow(int i, Timeline.Window window, long j) {
            this.timeline.getWindow(i, window, j);
            if (Objects.equals(window.uid, this.replacedInternalWindowUid)) {
                window.uid = Timeline.Window.SINGLE_WINDOW_UID;
            }
            return window;
        }

        @Override // io.bidmachine.media3.exoplayer.source.ForwardingTimeline, io.bidmachine.media3.common.Timeline
        public Timeline.Period getPeriod(int i, Timeline.Period period, boolean z) {
            this.timeline.getPeriod(i, period, z);
            if (Objects.equals(period.uid, this.replacedInternalPeriodUid) && z) {
                period.uid = MASKING_EXTERNAL_PERIOD_UID;
            }
            return period;
        }

        @Override // io.bidmachine.media3.exoplayer.source.ForwardingTimeline, io.bidmachine.media3.common.Timeline
        public int getIndexOfPeriod(Object obj) {
            Object obj2;
            Timeline timeline = this.timeline;
            if (MASKING_EXTERNAL_PERIOD_UID.equals(obj) && (obj2 = this.replacedInternalPeriodUid) != null) {
                obj = obj2;
            }
            return timeline.getIndexOfPeriod(obj);
        }

        @Override // io.bidmachine.media3.exoplayer.source.ForwardingTimeline, io.bidmachine.media3.common.Timeline
        public Object getUidOfPeriod(int i) {
            Object uidOfPeriod = this.timeline.getUidOfPeriod(i);
            return Objects.equals(uidOfPeriod, this.replacedInternalPeriodUid) ? MASKING_EXTERNAL_PERIOD_UID : uidOfPeriod;
        }
    }

    public static final class PlaceholderTimeline extends Timeline {
        private final MediaItem mediaItem;

        @Override // io.bidmachine.media3.common.Timeline
        public int getPeriodCount() {
            return 1;
        }

        @Override // io.bidmachine.media3.common.Timeline
        public int getWindowCount() {
            return 1;
        }

        public PlaceholderTimeline(MediaItem mediaItem) {
            this.mediaItem = mediaItem;
        }

        @Override // io.bidmachine.media3.common.Timeline
        public Timeline.Window getWindow(int i, Timeline.Window window, long j) {
            window.set(Timeline.Window.SINGLE_WINDOW_UID, this.mediaItem, null, -9223372036854775807L, -9223372036854775807L, -9223372036854775807L, false, true, null, 0L, -9223372036854775807L, 0, 0, 0L);
            window.isPlaceholder = true;
            return window;
        }

        @Override // io.bidmachine.media3.common.Timeline
        public Timeline.Period getPeriod(int i, Timeline.Period period, boolean z) {
            period.set(z ? 0 : null, z ? MaskingTimeline.MASKING_EXTERNAL_PERIOD_UID : null, 0, -9223372036854775807L, 0L, AdPlaybackState.NONE, true);
            return period;
        }

        @Override // io.bidmachine.media3.common.Timeline
        public int getIndexOfPeriod(Object obj) {
            return obj == MaskingTimeline.MASKING_EXTERNAL_PERIOD_UID ? 0 : -1;
        }

        @Override // io.bidmachine.media3.common.Timeline
        public Object getUidOfPeriod(int i) {
            return MaskingTimeline.MASKING_EXTERNAL_PERIOD_UID;
        }
    }
}
