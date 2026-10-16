package io.bidmachine.rendering.internal.adform.video.player.media;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.media.MediaPlayer;
import android.view.Surface;
import android.widget.FrameLayout;
import io.bidmachine.rendering.internal.adform.video.player.e;

/* loaded from: classes8.dex */
public class b extends FrameLayout {

    /* renamed from: a, reason: collision with root package name */
    private final io.bidmachine.rendering.internal.view.a f6961a;
    private io.bidmachine.rendering.internal.adform.video.player.media.c b;
    private MediaPlayer c;
    private Surface d;

    /* renamed from: io.bidmachine.rendering.internal.adform.video.player.media.b$b, reason: collision with other inner class name */
    private class C0613b implements MediaPlayer.OnVideoSizeChangedListener {
        private C0613b() {
        }

        @Override // android.media.MediaPlayer.OnVideoSizeChangedListener
        public void onVideoSizeChanged(MediaPlayer mp, int width, int height) {
            b.this.setVideoAspectRatio(width / height);
        }
    }

    private class c implements e {
        private c() {
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int width, int height) {
            b.this.d = new Surface(surfaceTexture);
            b bVar = b.this;
            bVar.setMediaPlayerSurface(bVar.d);
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
            if (b.this.b == null) {
                return false;
            }
            b.this.b.a();
            return false;
        }
    }

    public b(Context context) {
        super(context);
        io.bidmachine.rendering.internal.view.a aVar = new io.bidmachine.rendering.internal.view.a(context);
        this.f6961a = aVar;
        aVar.setSurfaceTextureListener(new c());
        addView(aVar, new FrameLayout.LayoutParams(-1, -1, 17));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMediaPlayerSurface(Surface surface) {
        try {
            MediaPlayer mediaPlayer = this.c;
            if (mediaPlayer != null) {
                mediaPlayer.setSurface(surface);
            }
        } catch (Throwable unused) {
        }
    }

    public void setListener(io.bidmachine.rendering.internal.adform.video.player.media.c mediaPlayerViewListener) {
        this.b = mediaPlayerViewListener;
    }

    public void setMediaPlayer(MediaPlayer mediaPlayer) {
        this.c = mediaPlayer;
        if (mediaPlayer != null) {
            setVideoAspectRatio(mediaPlayer.getVideoWidth() / mediaPlayer.getVideoHeight());
            mediaPlayer.setOnVideoSizeChangedListener(new C0613b());
        }
    }

    public void setVideoAspectRatio(float videoAspectRatio) {
        this.f6961a.setVideoAspectRatio(videoAspectRatio);
    }

    private void b() {
        Surface surface = this.d;
        if (surface != null) {
            surface.release();
        }
        this.d = null;
    }

    public void a() {
        setMediaPlayerSurface(null);
        b();
        this.c = null;
        this.f6961a.setSurfaceTextureListener(null);
    }
}
