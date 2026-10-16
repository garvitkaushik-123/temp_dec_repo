package io.bidmachine.rendering.internal.adform.video.player.media;

import android.content.Context;
import android.media.AudioAttributes;
import android.media.MediaPlayer;
import android.net.Uri;
import android.view.View;
import io.bidmachine.rendering.model.Error;

/* loaded from: classes8.dex */
public class a extends io.bidmachine.rendering.internal.adform.video.player.a {
    private final Context l;
    private final MediaPlayer m;
    private final io.bidmachine.rendering.internal.adform.video.player.media.b n;
    private float o = 1.0f;

    /* renamed from: io.bidmachine.rendering.internal.adform.video.player.media.a$a, reason: collision with other inner class name */
    protected class C0612a implements io.bidmachine.rendering.internal.adform.video.player.media.c {
        protected C0612a() {
        }

        @Override // io.bidmachine.rendering.internal.adform.video.player.media.c
        public void a() {
            if (a.this.D()) {
                a.this.b(new Error("Surface Destroyed"));
            }
        }
    }

    protected class b implements MediaPlayer.OnCompletionListener {
        protected b() {
        }

        @Override // android.media.MediaPlayer.OnCompletionListener
        public void onCompletion(MediaPlayer mp) {
            a.this.J();
        }
    }

    protected class c implements MediaPlayer.OnErrorListener {
        protected c() {
        }

        @Override // android.media.MediaPlayer.OnErrorListener
        public boolean onError(MediaPlayer mp, int what, int extra) {
            a.this.a(new Error("MediaPlayer - onError (what - " + what + ", extra - " + extra + ")"));
            return true;
        }
    }

    protected class d implements MediaPlayer.OnPreparedListener {
        protected d() {
        }

        @Override // android.media.MediaPlayer.OnPreparedListener
        public void onPrepared(MediaPlayer mp) {
            mp.seekTo(1);
            a.this.t();
        }
    }

    protected class e implements MediaPlayer.OnSeekCompleteListener {
        protected e() {
        }

        @Override // android.media.MediaPlayer.OnSeekCompleteListener
        public void onSeekComplete(MediaPlayer mp) {
            a aVar = a.this;
            aVar.b(aVar.p());
        }
    }

    public a(Context context) {
        this.l = context.getApplicationContext();
        MediaPlayer mediaPlayer = new MediaPlayer();
        this.m = mediaPlayer;
        mediaPlayer.setLooping(false);
        mediaPlayer.setAudioAttributes(new AudioAttributes.Builder().setContentType(2).setUsage(1).build());
        mediaPlayer.setOnPreparedListener(new d());
        mediaPlayer.setOnErrorListener(new c());
        mediaPlayer.setOnSeekCompleteListener(new e());
        mediaPlayer.setOnCompletionListener(new b());
        io.bidmachine.rendering.internal.adform.video.player.media.b bVar = new io.bidmachine.rendering.internal.adform.video.player.media.b(context);
        this.n = bVar;
        bVar.setListener(new C0612a());
        bVar.setMediaPlayer(mediaPlayer);
    }

    @Override // io.bidmachine.rendering.internal.adform.video.player.a
    protected void A() {
        super.A();
        s();
    }

    @Override // io.bidmachine.rendering.internal.adform.video.player.a
    protected void c(float volume) {
        this.o = volume;
        super.c(volume);
        b(volume);
    }

    @Override // io.bidmachine.rendering.internal.adform.video.player.a
    public float d() {
        return this.o;
    }

    @Override // io.bidmachine.rendering.internal.adform.video.player.a
    protected boolean f() {
        return this.m.isPlaying();
    }

    @Override // io.bidmachine.rendering.internal.adform.video.player.a
    protected boolean h() {
        return false;
    }

    @Override // io.bidmachine.rendering.internal.adform.video.player.a
    protected void i() {
        this.m.pause();
    }

    @Override // io.bidmachine.rendering.internal.adform.video.player.a
    protected void j() {
        this.m.start();
    }

    @Override // io.bidmachine.rendering.internal.adform.video.player.a
    protected void l() {
        this.m.prepareAsync();
    }

    @Override // io.bidmachine.rendering.internal.adform.video.player.a
    protected void m() {
        this.m.stop();
    }

    @Override // io.bidmachine.rendering.internal.adform.video.player.b
    public View n() {
        return this.n;
    }

    @Override // io.bidmachine.rendering.internal.adform.video.player.a
    protected void z() {
        super.z();
        r();
    }

    @Override // io.bidmachine.rendering.internal.adform.video.player.a
    protected void b(Uri videoUri) {
        this.m.reset();
        this.m.setDataSource(this.l, videoUri);
    }

    @Override // io.bidmachine.rendering.internal.adform.video.player.a, io.bidmachine.rendering.internal.adform.video.player.b
    public void a() {
        super.a();
        this.n.a();
        this.m.reset();
        this.m.release();
    }

    @Override // io.bidmachine.rendering.internal.adform.video.player.a
    protected long b() {
        return this.m.getCurrentPosition();
    }

    @Override // io.bidmachine.rendering.internal.adform.video.player.a
    protected long c() {
        return this.m.getDuration();
    }

    @Override // io.bidmachine.rendering.internal.adform.video.player.a
    protected void a(float volume) {
        this.m.setVolume(volume, volume);
    }

    @Override // io.bidmachine.rendering.internal.adform.video.player.a
    protected void a(long positionMs) {
        this.m.seekTo((int) positionMs);
    }
}
