package io.bidmachine.media3.exoplayer;

import io.bidmachine.media3.common.Format;
import io.bidmachine.media3.common.Timeline;
import io.bidmachine.media3.common.util.Clock;
import io.bidmachine.media3.exoplayer.analytics.PlayerId;
import io.bidmachine.media3.exoplayer.source.MediaSource;
import io.bidmachine.media3.exoplayer.source.SampleStream;
import java.io.IOException;

/* loaded from: classes7.dex */
public class ForwardingRenderer implements Renderer {
    private final Renderer renderer;

    public ForwardingRenderer(Renderer renderer) {
        this.renderer = renderer;
    }

    @Override // io.bidmachine.media3.exoplayer.PlayerMessage.Target
    public void handleMessage(int i, Object obj) throws ExoPlaybackException {
        this.renderer.handleMessage(i, obj);
    }

    @Override // io.bidmachine.media3.exoplayer.Renderer
    public String getName() {
        return this.renderer.getName();
    }

    @Override // io.bidmachine.media3.exoplayer.Renderer, io.bidmachine.media3.exoplayer.RendererCapabilities
    public int getTrackType() {
        return this.renderer.getTrackType();
    }

    @Override // io.bidmachine.media3.exoplayer.Renderer
    public RendererCapabilities getCapabilities() {
        return this.renderer.getCapabilities();
    }

    @Override // io.bidmachine.media3.exoplayer.Renderer
    public void init(int i, PlayerId playerId, Clock clock) {
        this.renderer.init(i, playerId, clock);
    }

    @Override // io.bidmachine.media3.exoplayer.Renderer
    public MediaClock getMediaClock() {
        return this.renderer.getMediaClock();
    }

    @Override // io.bidmachine.media3.exoplayer.Renderer
    public int getState() {
        return this.renderer.getState();
    }

    @Override // io.bidmachine.media3.exoplayer.Renderer
    public void enable(RendererConfiguration rendererConfiguration, Format[] formatArr, SampleStream sampleStream, long j, boolean z, boolean z2, long j2, long j3, MediaSource.MediaPeriodId mediaPeriodId) throws ExoPlaybackException {
        this.renderer.enable(rendererConfiguration, formatArr, sampleStream, j, z, z2, j2, j3, mediaPeriodId);
    }

    @Override // io.bidmachine.media3.exoplayer.Renderer
    public void start() throws ExoPlaybackException {
        this.renderer.start();
    }

    @Override // io.bidmachine.media3.exoplayer.Renderer
    public void replaceStream(Format[] formatArr, SampleStream sampleStream, long j, long j2, MediaSource.MediaPeriodId mediaPeriodId) throws ExoPlaybackException {
        this.renderer.replaceStream(formatArr, sampleStream, j, j2, mediaPeriodId);
    }

    @Override // io.bidmachine.media3.exoplayer.Renderer
    public SampleStream getStream() {
        return this.renderer.getStream();
    }

    @Override // io.bidmachine.media3.exoplayer.Renderer
    public boolean hasReadStreamToEnd() {
        return this.renderer.hasReadStreamToEnd();
    }

    @Override // io.bidmachine.media3.exoplayer.Renderer
    public long getReadingPositionUs() {
        return this.renderer.getReadingPositionUs();
    }

    @Override // io.bidmachine.media3.exoplayer.Renderer
    public long getDurationToProgressUs(long j, long j2) {
        return this.renderer.getDurationToProgressUs(j, j2);
    }

    @Override // io.bidmachine.media3.exoplayer.Renderer
    public void setCurrentStreamFinal() {
        this.renderer.setCurrentStreamFinal();
    }

    @Override // io.bidmachine.media3.exoplayer.Renderer
    public boolean isCurrentStreamFinal() {
        return this.renderer.isCurrentStreamFinal();
    }

    @Override // io.bidmachine.media3.exoplayer.Renderer
    public void maybeThrowStreamError() throws IOException {
        this.renderer.maybeThrowStreamError();
    }

    @Override // io.bidmachine.media3.exoplayer.Renderer
    public void resetPosition(long j) throws ExoPlaybackException {
        this.renderer.resetPosition(j);
    }

    @Override // io.bidmachine.media3.exoplayer.Renderer
    public void setPlaybackSpeed(float f, float f2) throws ExoPlaybackException {
        this.renderer.setPlaybackSpeed(f, f2);
    }

    @Override // io.bidmachine.media3.exoplayer.Renderer
    public void enableMayRenderStartOfStream() {
        this.renderer.enableMayRenderStartOfStream();
    }

    @Override // io.bidmachine.media3.exoplayer.Renderer
    public void setTimeline(Timeline timeline) {
        this.renderer.setTimeline(timeline);
    }

    @Override // io.bidmachine.media3.exoplayer.Renderer
    public void render(long j, long j2) throws ExoPlaybackException {
        this.renderer.render(j, j2);
    }

    @Override // io.bidmachine.media3.exoplayer.Renderer
    public boolean isReady() {
        return this.renderer.isReady();
    }

    @Override // io.bidmachine.media3.exoplayer.Renderer
    public boolean isEnded() {
        return this.renderer.isEnded();
    }

    @Override // io.bidmachine.media3.exoplayer.Renderer
    public void stop() {
        this.renderer.stop();
    }

    @Override // io.bidmachine.media3.exoplayer.Renderer
    public void disable() {
        this.renderer.disable();
    }

    @Override // io.bidmachine.media3.exoplayer.Renderer
    public void reset() {
        this.renderer.reset();
    }

    @Override // io.bidmachine.media3.exoplayer.Renderer
    public void release() {
        this.renderer.release();
    }
}
