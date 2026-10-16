package io.bidmachine.rendering.internal.adform.video.player.exo;

import android.content.Context;
import android.net.Uri;
import android.view.View;
import io.bidmachine.media3.common.MediaItem;
import io.bidmachine.media3.common.PlaybackException;
import io.bidmachine.media3.common.Player;
import io.bidmachine.media3.exoplayer.ExoPlayer;
import io.bidmachine.media3.ui.PlayerView;

/* loaded from: classes8.dex */
public class a extends io.bidmachine.rendering.internal.adform.video.player.a {
    private final ExoPlayer l;
    private final PlayerView m;

    /* renamed from: io.bidmachine.rendering.internal.adform.video.player.exo.a$a, reason: collision with other inner class name */
    protected class C0611a implements Player.Listener {
        protected C0611a() {
        }

        @Override // io.bidmachine.media3.common.Player.Listener
        public void onIsPlayingChanged(boolean isPlaying) {
            if (isPlaying) {
                a.this.s();
            } else {
                a.this.r();
            }
        }

        @Override // io.bidmachine.media3.common.Player.Listener
        public void onPlaybackStateChanged(int playbackState) {
            if (playbackState == 3) {
                a.this.t();
            } else if (playbackState == 4) {
                a.this.J();
            }
        }

        @Override // io.bidmachine.media3.common.Player.Listener
        public void onPlayerError(PlaybackException playbackException) {
            a.this.a(playbackException);
        }

        @Override // io.bidmachine.media3.common.Player.Listener
        public void onPositionDiscontinuity(Player.PositionInfo oldPosition, Player.PositionInfo newPosition, int reason) {
            a.this.b(Long.valueOf(newPosition.positionMs));
        }

        @Override // io.bidmachine.media3.common.Player.Listener
        public void onVolumeChanged(float volume) {
            a.this.b(volume);
        }
    }

    public a(Context context) {
        ExoPlayer build = new ExoPlayer.Builder(context).build();
        this.l = build;
        build.addListener(new C0611a());
        PlayerView playerView = new PlayerView(context);
        this.m = playerView;
        playerView.setPlayer(build);
        playerView.setUseController(false);
    }

    @Override // io.bidmachine.rendering.internal.adform.video.player.a
    protected boolean f() {
        return this.l.isPlaying();
    }

    @Override // io.bidmachine.rendering.internal.adform.video.player.a
    protected boolean h() {
        return false;
    }

    @Override // io.bidmachine.rendering.internal.adform.video.player.a
    protected void i() {
        this.l.pause();
    }

    @Override // io.bidmachine.rendering.internal.adform.video.player.a
    protected void j() {
        this.l.play();
    }

    @Override // io.bidmachine.rendering.internal.adform.video.player.a
    protected void l() {
        this.l.prepare();
    }

    @Override // io.bidmachine.rendering.internal.adform.video.player.a
    protected void m() {
        this.l.stop();
    }

    @Override // io.bidmachine.rendering.internal.adform.video.player.b
    public View n() {
        return this.m;
    }

    @Override // io.bidmachine.rendering.internal.adform.video.player.a
    protected void b(Uri videoUri) {
        this.l.setMediaItem(new MediaItem.Builder().setUri(videoUri).build());
    }

    @Override // io.bidmachine.rendering.internal.adform.video.player.a
    protected long c() {
        return this.l.getDuration();
    }

    @Override // io.bidmachine.rendering.internal.adform.video.player.a
    public float d() {
        return this.l.getVolume();
    }

    @Override // io.bidmachine.rendering.internal.adform.video.player.a, io.bidmachine.rendering.internal.adform.video.player.b
    public void a() {
        super.a();
        this.l.release();
        this.m.setPlayer(null);
    }

    @Override // io.bidmachine.rendering.internal.adform.video.player.a
    protected long b() {
        return this.l.getCurrentPosition();
    }

    @Override // io.bidmachine.rendering.internal.adform.video.player.a
    protected void a(float volume) {
        this.l.setVolume(volume);
    }

    @Override // io.bidmachine.rendering.internal.adform.video.player.a
    protected void a(long positionMs) {
        this.l.seekTo(positionMs);
    }
}
