package io.bidmachine.media3.exoplayer.video;

import io.bidmachine.media3.common.VideoSize;
import io.bidmachine.media3.common.util.Assertions;
import io.bidmachine.media3.common.util.LongArrayQueue;
import io.bidmachine.media3.common.util.TimedValueQueue;
import io.bidmachine.media3.exoplayer.ExoPlaybackException;
import io.bidmachine.media3.exoplayer.video.VideoFrameReleaseControl;

/* loaded from: classes7.dex */
final class VideoFrameRenderControl {
    private final FrameRenderer frameRenderer;
    private long outputStreamStartPositionUs;
    private final VideoFrameReleaseControl videoFrameReleaseControl;
    private final VideoFrameReleaseControl.FrameReleaseInfo videoFrameReleaseInfo = new VideoFrameReleaseControl.FrameReleaseInfo();
    private final TimedValueQueue<VideoSize> videoSizes = new TimedValueQueue<>();
    private final TimedValueQueue<Long> streamStartPositionsUs = new TimedValueQueue<>();
    private final LongArrayQueue presentationTimestampsUs = new LongArrayQueue();
    private long latestInputPresentationTimeUs = -9223372036854775807L;
    private VideoSize outputVideoSize = VideoSize.UNKNOWN;
    private long latestOutputPresentationTimeUs = -9223372036854775807L;
    private long lastPresentationTimeUs = -9223372036854775807L;

    interface FrameRenderer {
        void dropFrame();

        void onVideoSizeChanged(VideoSize videoSize);

        void renderFrame(long j, long j2, boolean z);
    }

    public VideoFrameRenderControl(FrameRenderer frameRenderer, VideoFrameReleaseControl videoFrameReleaseControl) {
        this.frameRenderer = frameRenderer;
        this.videoFrameReleaseControl = videoFrameReleaseControl;
    }

    public void flush() {
        this.presentationTimestampsUs.clear();
        this.latestInputPresentationTimeUs = -9223372036854775807L;
        this.latestOutputPresentationTimeUs = -9223372036854775807L;
        this.lastPresentationTimeUs = -9223372036854775807L;
        if (this.streamStartPositionsUs.size() > 0) {
            this.streamStartPositionsUs.add(0L, Long.valueOf(((Long) getLastAndClear(this.streamStartPositionsUs)).longValue()));
        }
        if (this.videoSizes.size() > 0) {
            this.videoSizes.add(0L, (VideoSize) getLastAndClear(this.videoSizes));
        }
    }

    public void render(long j, long j2) throws ExoPlaybackException {
        while (!this.presentationTimestampsUs.isEmpty()) {
            long element = this.presentationTimestampsUs.element();
            if (maybeUpdateOutputStreamStartPosition(element)) {
                this.videoFrameReleaseControl.onProcessedStreamChange();
            }
            int frameReleaseAction = this.videoFrameReleaseControl.getFrameReleaseAction(element, j, j2, this.outputStreamStartPositionUs, false, false, this.videoFrameReleaseInfo);
            if (frameReleaseAction == 0 || frameReleaseAction == 1) {
                this.latestOutputPresentationTimeUs = element;
                renderFrame(frameReleaseAction == 0);
            } else if (frameReleaseAction == 2 || frameReleaseAction == 3) {
                this.latestOutputPresentationTimeUs = element;
                dropFrame();
            } else {
                if (frameReleaseAction != 4) {
                    if (frameReleaseAction != 5) {
                        throw new IllegalStateException(String.valueOf(frameReleaseAction));
                    }
                    return;
                }
                this.latestOutputPresentationTimeUs = element;
            }
        }
    }

    public void onVideoSizeChanged(int i, int i2) {
        TimedValueQueue<VideoSize> timedValueQueue = this.videoSizes;
        long j = this.latestInputPresentationTimeUs;
        timedValueQueue.add(j == -9223372036854775807L ? 0L : j + 1, new VideoSize(i, i2));
    }

    public void onStreamStartPositionChanged(long j) {
        TimedValueQueue<Long> timedValueQueue = this.streamStartPositionsUs;
        long j2 = this.latestInputPresentationTimeUs;
        timedValueQueue.add(j2 == -9223372036854775807L ? 0L : j2 + 1, Long.valueOf(j));
    }

    public void onFrameAvailableForRendering(long j) {
        this.presentationTimestampsUs.add(j);
        this.latestInputPresentationTimeUs = j;
        this.lastPresentationTimeUs = -9223372036854775807L;
    }

    public void signalEndOfInput() {
        this.lastPresentationTimeUs = this.latestInputPresentationTimeUs;
    }

    public boolean isEnded() {
        long j = this.lastPresentationTimeUs;
        return j != -9223372036854775807L && this.latestOutputPresentationTimeUs == j;
    }

    private void dropFrame() {
        this.presentationTimestampsUs.remove();
        this.frameRenderer.dropFrame();
    }

    private void renderFrame(boolean z) {
        long remove = this.presentationTimestampsUs.remove();
        if (maybeUpdateOutputVideoSize(remove)) {
            this.frameRenderer.onVideoSizeChanged(this.outputVideoSize);
        }
        this.frameRenderer.renderFrame(z ? -1L : this.videoFrameReleaseInfo.getReleaseTimeNs(), remove, this.videoFrameReleaseControl.onFrameReleasedIsFirstFrame());
    }

    private boolean maybeUpdateOutputStreamStartPosition(long j) {
        Long pollFloor = this.streamStartPositionsUs.pollFloor(j);
        if (pollFloor == null || pollFloor.longValue() == this.outputStreamStartPositionUs) {
            return false;
        }
        this.outputStreamStartPositionUs = pollFloor.longValue();
        return true;
    }

    private boolean maybeUpdateOutputVideoSize(long j) {
        VideoSize pollFloor = this.videoSizes.pollFloor(j);
        if (pollFloor == null || pollFloor.equals(VideoSize.UNKNOWN) || pollFloor.equals(this.outputVideoSize)) {
            return false;
        }
        this.outputVideoSize = pollFloor;
        return true;
    }

    private static <T> T getLastAndClear(TimedValueQueue<T> timedValueQueue) {
        Assertions.checkArgument(timedValueQueue.size() > 0);
        while (timedValueQueue.size() > 1) {
            timedValueQueue.pollFirst();
        }
        return (T) Assertions.checkNotNull(timedValueQueue.pollFirst());
    }
}
