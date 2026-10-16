package com.mbridge.msdk.dycreator.baseview.videoview;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.widget.FrameLayout;
import com.mbridge.msdk.dycreator.baseview.videoview.listener.VideoViewEventListener;
import com.mbridge.msdk.foundation.tools.p0;
import com.mbridge.msdk.playercommon.exoplayer2.DefaultLoadControl;
import com.mbridge.msdk.playercommon.exoplayer2.DefaultRenderersFactory;
import com.mbridge.msdk.playercommon.exoplayer2.ExoPlaybackException;
import com.mbridge.msdk.playercommon.exoplayer2.ExoPlayer;
import com.mbridge.msdk.playercommon.exoplayer2.ExoPlayerFactory;
import com.mbridge.msdk.playercommon.exoplayer2.PlaybackParameters;
import com.mbridge.msdk.playercommon.exoplayer2.Player;
import com.mbridge.msdk.playercommon.exoplayer2.Timeline;
import com.mbridge.msdk.playercommon.exoplayer2.source.ConcatenatingMediaSource;
import com.mbridge.msdk.playercommon.exoplayer2.source.ExtractorMediaSource;
import com.mbridge.msdk.playercommon.exoplayer2.source.TrackGroupArray;
import com.mbridge.msdk.playercommon.exoplayer2.trackselection.DefaultTrackSelector;
import com.mbridge.msdk.playercommon.exoplayer2.trackselection.TrackSelectionArray;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.DefaultDataSourceFactory;

/* loaded from: classes6.dex */
public class MBVideoView extends FrameLayout implements Player.EventListener {

    /* renamed from: a, reason: collision with root package name */
    private final String f4136a;
    private final int b;
    private ExoPlayer c;
    private final long d;
    private String[] e;
    private VideoViewEventListener f;
    private final SurfaceHolder.Callback g;
    private final Runnable h;
    private final Runnable i;

    /* renamed from: com.mbridge.msdk.dycreator.baseview.videoview.MBVideoView$1, reason: invalid class name */
    class AnonymousClass1 implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ MBVideoView f4137a;

        @Override // java.lang.Runnable
        public void run() {
            if (this.f4137a.f != null) {
                this.f4137a.f.onBufferingFail("Buffering timeout");
            }
        }
    }

    public MBVideoView(Context context) {
        super(context);
        this.f4136a = "MBVideoView";
        this.b = 1000;
        this.d = 5000L;
        this.g = new SurfaceHolder.Callback() { // from class: com.mbridge.msdk.dycreator.baseview.videoview.MBVideoView.2
            @Override // android.view.SurfaceHolder.Callback
            public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
            }

            @Override // android.view.SurfaceHolder.Callback
            public void surfaceCreated(SurfaceHolder surfaceHolder) {
                try {
                    Player.VideoComponent videoComponent = MBVideoView.this.c.getVideoComponent();
                    if (videoComponent != null) {
                        videoComponent.setVideoSurfaceHolder(surfaceHolder);
                    }
                } catch (Throwable th) {
                    p0.b("MBVideoView", th.getMessage());
                }
            }

            @Override // android.view.SurfaceHolder.Callback
            public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
            }
        };
        this.h = new Runnable() { // from class: com.mbridge.msdk.dycreator.baseview.videoview.MBVideoView.3
            @Override // java.lang.Runnable
            public void run() {
                if (MBVideoView.this.f != null) {
                    MBVideoView.this.f.onBufferingFail("Buffering fail.");
                }
            }
        };
        this.i = new Runnable() { // from class: com.mbridge.msdk.dycreator.baseview.videoview.MBVideoView.4
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (MBVideoView.this.c == null || !MBVideoView.this.isPlaying()) {
                        return;
                    }
                    long currentPosition = MBVideoView.this.c.getCurrentPosition();
                    long duration = MBVideoView.this.c.getDuration();
                    int round = Math.round(currentPosition / 1000.0f);
                    int round2 = Math.round(duration / 1000.0f);
                    p0.c("MBVideoView", "currentPosition:" + round + " duration:" + duration);
                    if (MBVideoView.this.f != null) {
                        MBVideoView.this.f.onPlayProgress(round, round2);
                    }
                    MBVideoView.this.getHandler().postDelayed(this, 1000L);
                } catch (Exception e) {
                    p0.b("MBVideoView", e.getMessage());
                }
            }
        };
    }

    public boolean isPlaying() {
        ExoPlayer exoPlayer = this.c;
        return exoPlayer != null && exoPlayer.getPlaybackState() == 3 && this.c.getPlayWhenReady();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    @Override // com.mbridge.msdk.playercommon.exoplayer2.Player.EventListener
    public void onLoadingChanged(boolean z) {
    }

    @Override // com.mbridge.msdk.playercommon.exoplayer2.Player.EventListener
    public void onPlaybackParametersChanged(PlaybackParameters playbackParameters) {
        p0.b("MBVideoView", "onPlaybackParametersChanged : " + playbackParameters.speed);
    }

    @Override // com.mbridge.msdk.playercommon.exoplayer2.Player.EventListener
    public void onPlayerStateChanged(boolean z, int i) {
        p0.b("MBVideoView", "onPlaybackStateChanged : " + i);
        if (i == 1) {
            p0.b("MBVideoView", "onPlaybackStateChanged : IDLE");
            return;
        }
        if (i == 2) {
            p0.b("MBVideoView", "onPlaybackStateChanged : Buffering");
        } else if (i == 3) {
            p0.b("MBVideoView", "onPlaybackStateChanged : READY");
        } else {
            if (i != 4) {
                return;
            }
            p0.b("MBVideoView", "onPlaybackStateChanged : Ended : PLAY ENDED");
        }
    }

    @Override // com.mbridge.msdk.playercommon.exoplayer2.Player.EventListener
    public void onPositionDiscontinuity(int i) {
        this.c.getCurrentWindowIndex();
    }

    @Override // com.mbridge.msdk.playercommon.exoplayer2.Player.EventListener
    public void onRepeatModeChanged(int i) {
    }

    @Override // com.mbridge.msdk.playercommon.exoplayer2.Player.EventListener
    public void onSeekProcessed() {
    }

    @Override // com.mbridge.msdk.playercommon.exoplayer2.Player.EventListener
    public void onShuffleModeEnabledChanged(boolean z) {
    }

    @Override // com.mbridge.msdk.playercommon.exoplayer2.Player.EventListener
    public void onTimelineChanged(Timeline timeline, Object obj, int i) {
    }

    @Override // com.mbridge.msdk.playercommon.exoplayer2.Player.EventListener
    public void onTracksChanged(TrackGroupArray trackGroupArray, TrackSelectionArray trackSelectionArray) {
    }

    public void pause() {
    }

    public void play() {
    }

    public void setVideoUrl(String... strArr) {
        if (strArr == null || strArr.length <= 0) {
            return;
        }
        this.e = strArr;
        a();
    }

    public void setVideoViewEventLister(VideoViewEventListener videoViewEventListener) {
        this.f = videoViewEventListener;
    }

    public void stop() {
    }

    private void a() {
        try {
            this.c = ExoPlayerFactory.newSimpleInstance(new DefaultRenderersFactory(getContext()), new DefaultTrackSelector(), new DefaultLoadControl());
            ConcatenatingMediaSource concatenatingMediaSource = new ConcatenatingMediaSource();
            for (String str : this.e) {
                concatenatingMediaSource.addMediaSource(new ExtractorMediaSource.Factory(new DefaultDataSourceFactory(getContext(), "MBridge_ExoPlayer")).createMediaSource(Uri.parse(str)));
            }
            this.c.setRepeatMode(0);
            this.c.prepare(concatenatingMediaSource);
            this.c.addListener(this);
        } catch (Throwable th) {
            p0.b("MBVideoView", th.getMessage());
            th.toString();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:19:? A[RETURN, SYNTHETIC] */
    @Override // com.mbridge.msdk.playercommon.exoplayer2.Player.EventListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onPlayerError(ExoPlaybackException exoPlaybackException) {
        String str;
        VideoViewEventListener videoViewEventListener;
        if (exoPlaybackException != null) {
            int i = exoPlaybackException.type;
            if (i == 0) {
                str = "Play error, because have a SourceException.";
            } else if (i == 1) {
                str = "Play error, because have a RendererException.";
            } else if (i == 2) {
                str = "Play error, because have a UnexpectedException.";
            }
            if (exoPlaybackException.getCause() != null && !TextUtils.isEmpty(exoPlaybackException.getCause().getMessage())) {
                str = exoPlaybackException.getCause().getMessage();
            }
            p0.b("MBVideoView", "onPlayerError : " + str);
            videoViewEventListener = this.f;
            if (videoViewEventListener == null) {
                videoViewEventListener.onPlayerError(exoPlaybackException.type, str);
                return;
            }
            return;
        }
        str = "Play error and ExoPlayer have not message.";
        if (exoPlaybackException.getCause() != null) {
            str = exoPlaybackException.getCause().getMessage();
        }
        p0.b("MBVideoView", "onPlayerError : " + str);
        videoViewEventListener = this.f;
        if (videoViewEventListener == null) {
        }
    }

    public MBVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f4136a = "MBVideoView";
        this.b = 1000;
        this.d = 5000L;
        this.g = new SurfaceHolder.Callback() { // from class: com.mbridge.msdk.dycreator.baseview.videoview.MBVideoView.2
            @Override // android.view.SurfaceHolder.Callback
            public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
            }

            @Override // android.view.SurfaceHolder.Callback
            public void surfaceCreated(SurfaceHolder surfaceHolder) {
                try {
                    Player.VideoComponent videoComponent = MBVideoView.this.c.getVideoComponent();
                    if (videoComponent != null) {
                        videoComponent.setVideoSurfaceHolder(surfaceHolder);
                    }
                } catch (Throwable th) {
                    p0.b("MBVideoView", th.getMessage());
                }
            }

            @Override // android.view.SurfaceHolder.Callback
            public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
            }
        };
        this.h = new Runnable() { // from class: com.mbridge.msdk.dycreator.baseview.videoview.MBVideoView.3
            @Override // java.lang.Runnable
            public void run() {
                if (MBVideoView.this.f != null) {
                    MBVideoView.this.f.onBufferingFail("Buffering fail.");
                }
            }
        };
        this.i = new Runnable() { // from class: com.mbridge.msdk.dycreator.baseview.videoview.MBVideoView.4
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (MBVideoView.this.c == null || !MBVideoView.this.isPlaying()) {
                        return;
                    }
                    long currentPosition = MBVideoView.this.c.getCurrentPosition();
                    long duration = MBVideoView.this.c.getDuration();
                    int round = Math.round(currentPosition / 1000.0f);
                    int round2 = Math.round(duration / 1000.0f);
                    p0.c("MBVideoView", "currentPosition:" + round + " duration:" + duration);
                    if (MBVideoView.this.f != null) {
                        MBVideoView.this.f.onPlayProgress(round, round2);
                    }
                    MBVideoView.this.getHandler().postDelayed(this, 1000L);
                } catch (Exception e) {
                    p0.b("MBVideoView", e.getMessage());
                }
            }
        };
    }

    public MBVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f4136a = "MBVideoView";
        this.b = 1000;
        this.d = 5000L;
        this.g = new SurfaceHolder.Callback() { // from class: com.mbridge.msdk.dycreator.baseview.videoview.MBVideoView.2
            @Override // android.view.SurfaceHolder.Callback
            public void surfaceChanged(SurfaceHolder surfaceHolder, int i2, int i22, int i3) {
            }

            @Override // android.view.SurfaceHolder.Callback
            public void surfaceCreated(SurfaceHolder surfaceHolder) {
                try {
                    Player.VideoComponent videoComponent = MBVideoView.this.c.getVideoComponent();
                    if (videoComponent != null) {
                        videoComponent.setVideoSurfaceHolder(surfaceHolder);
                    }
                } catch (Throwable th) {
                    p0.b("MBVideoView", th.getMessage());
                }
            }

            @Override // android.view.SurfaceHolder.Callback
            public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
            }
        };
        this.h = new Runnable() { // from class: com.mbridge.msdk.dycreator.baseview.videoview.MBVideoView.3
            @Override // java.lang.Runnable
            public void run() {
                if (MBVideoView.this.f != null) {
                    MBVideoView.this.f.onBufferingFail("Buffering fail.");
                }
            }
        };
        this.i = new Runnable() { // from class: com.mbridge.msdk.dycreator.baseview.videoview.MBVideoView.4
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (MBVideoView.this.c == null || !MBVideoView.this.isPlaying()) {
                        return;
                    }
                    long currentPosition = MBVideoView.this.c.getCurrentPosition();
                    long duration = MBVideoView.this.c.getDuration();
                    int round = Math.round(currentPosition / 1000.0f);
                    int round2 = Math.round(duration / 1000.0f);
                    p0.c("MBVideoView", "currentPosition:" + round + " duration:" + duration);
                    if (MBVideoView.this.f != null) {
                        MBVideoView.this.f.onPlayProgress(round, round2);
                    }
                    MBVideoView.this.getHandler().postDelayed(this, 1000L);
                } catch (Exception e) {
                    p0.b("MBVideoView", e.getMessage());
                }
            }
        };
    }

    public MBVideoView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.f4136a = "MBVideoView";
        this.b = 1000;
        this.d = 5000L;
        this.g = new SurfaceHolder.Callback() { // from class: com.mbridge.msdk.dycreator.baseview.videoview.MBVideoView.2
            @Override // android.view.SurfaceHolder.Callback
            public void surfaceChanged(SurfaceHolder surfaceHolder, int i22, int i222, int i3) {
            }

            @Override // android.view.SurfaceHolder.Callback
            public void surfaceCreated(SurfaceHolder surfaceHolder) {
                try {
                    Player.VideoComponent videoComponent = MBVideoView.this.c.getVideoComponent();
                    if (videoComponent != null) {
                        videoComponent.setVideoSurfaceHolder(surfaceHolder);
                    }
                } catch (Throwable th) {
                    p0.b("MBVideoView", th.getMessage());
                }
            }

            @Override // android.view.SurfaceHolder.Callback
            public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
            }
        };
        this.h = new Runnable() { // from class: com.mbridge.msdk.dycreator.baseview.videoview.MBVideoView.3
            @Override // java.lang.Runnable
            public void run() {
                if (MBVideoView.this.f != null) {
                    MBVideoView.this.f.onBufferingFail("Buffering fail.");
                }
            }
        };
        this.i = new Runnable() { // from class: com.mbridge.msdk.dycreator.baseview.videoview.MBVideoView.4
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (MBVideoView.this.c == null || !MBVideoView.this.isPlaying()) {
                        return;
                    }
                    long currentPosition = MBVideoView.this.c.getCurrentPosition();
                    long duration = MBVideoView.this.c.getDuration();
                    int round = Math.round(currentPosition / 1000.0f);
                    int round2 = Math.round(duration / 1000.0f);
                    p0.c("MBVideoView", "currentPosition:" + round + " duration:" + duration);
                    if (MBVideoView.this.f != null) {
                        MBVideoView.this.f.onPlayProgress(round, round2);
                    }
                    MBVideoView.this.getHandler().postDelayed(this, 1000L);
                } catch (Exception e) {
                    p0.b("MBVideoView", e.getMessage());
                }
            }
        };
    }
}
