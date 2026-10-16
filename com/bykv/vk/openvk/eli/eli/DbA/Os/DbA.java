package com.bykv.vk.openvk.eli.eli.DbA.Os;

import android.media.MediaPlayer;
import android.media.PlaybackParams;
import android.net.Uri;
import android.text.TextUtils;
import android.view.Surface;
import android.view.SurfaceHolder;
import com.ironsource.C3040d4;
import java.io.FileDescriptor;
import java.lang.ref.WeakReference;

/* loaded from: classes3.dex */
public class DbA extends com.bykv.vk.openvk.eli.eli.DbA.Os.eli {
    private final MediaPlayer DbA;
    private final Object MGA;
    private final eli Os;
    private com.bykv.vk.openvk.eli.eli.DbA.eli.eli aGH;
    private volatile boolean kb;
    private Surface ui;

    private void eli(MediaPlayer mediaPlayer) {
    }

    public DbA() {
        MediaPlayer mediaPlayer;
        Object obj = new Object();
        this.MGA = obj;
        synchronized (obj) {
            mediaPlayer = new MediaPlayer();
            this.DbA = mediaPlayer;
        }
        eli(mediaPlayer);
        try {
            mediaPlayer.setAudioStreamType(3);
        } catch (Throwable unused) {
        }
        this.Os = new eli(this);
        dV();
    }

    @Override // com.bykv.vk.openvk.eli.eli.DbA.Os.Os
    public void eli(SurfaceHolder surfaceHolder) throws Throwable {
        synchronized (this.MGA) {
            try {
                if (!this.kb && surfaceHolder != null && surfaceHolder.getSurface() != null && this.eli) {
                    this.DbA.setDisplay(surfaceHolder);
                }
            } catch (Throwable unused) {
            }
        }
    }

    @Override // com.bykv.vk.openvk.eli.eli.DbA.Os.Os
    public void eli(Surface surface) {
        nGm();
        this.ui = surface;
        this.DbA.setSurface(surface);
    }

    @Override // com.bykv.vk.openvk.eli.eli.DbA.Os.Os
    public void eli(com.bykv.vk.openvk.eli.eli.eli.DbA dbA) throws Throwable {
        this.DbA.setPlaybackParams(this.DbA.getPlaybackParams().setSpeed(dbA.eli()));
    }

    @Override // com.bykv.vk.openvk.eli.eli.DbA.Os.Os
    public PlaybackParams ui() throws IllegalStateException {
        return this.DbA.getPlaybackParams();
    }

    @Override // com.bykv.vk.openvk.eli.eli.DbA.Os.Os
    public void eli(String str) throws Throwable {
        Uri parse = Uri.parse(str);
        String scheme = parse.getScheme();
        if (!TextUtils.isEmpty(scheme) && scheme.equalsIgnoreCase(C3040d4.h.b)) {
            this.DbA.setDataSource(parse.getPath());
        } else {
            this.DbA.setDataSource(str);
        }
    }

    @Override // com.bykv.vk.openvk.eli.eli.DbA.Os.Os
    public void eli(FileDescriptor fileDescriptor) throws Throwable {
        this.DbA.setDataSource(fileDescriptor);
    }

    @Override // com.bykv.vk.openvk.eli.eli.DbA.Os.Os
    public synchronized void eli(com.bykv.vk.openvk.eli.eli.eli.Os.Os os) {
        this.aGH = com.bykv.vk.openvk.eli.eli.DbA.eli.eli.eli(com.bykv.vk.openvk.eli.eli.eli.Os.eli(), os);
        com.bykv.vk.openvk.eli.eli.DbA.eli.DbA.Os.eli(os);
        this.DbA.setDataSource(this.aGH);
    }

    private void aqO() {
        com.bykv.vk.openvk.eli.eli.DbA.eli.eli eliVar = this.aGH;
        if (eliVar != null) {
            try {
                eliVar.close();
            } catch (Throwable unused) {
            }
            this.aGH = null;
        }
    }

    @Override // com.bykv.vk.openvk.eli.eli.DbA.Os.Os
    public void MGA() throws Throwable {
        this.DbA.start();
    }

    @Override // com.bykv.vk.openvk.eli.eli.DbA.Os.Os
    public void kb() throws Throwable {
        this.DbA.stop();
    }

    @Override // com.bykv.vk.openvk.eli.eli.DbA.Os.Os
    public void wC() throws Throwable {
        this.DbA.pause();
    }

    @Override // com.bykv.vk.openvk.eli.eli.DbA.Os.Os
    public void FC() {
        MediaPlayer mediaPlayer = this.DbA;
        if (mediaPlayer != null) {
            mediaPlayer.prepareAsync();
        }
    }

    @Override // com.bykv.vk.openvk.eli.eli.DbA.Os.Os
    public void DbA(boolean z) throws Throwable {
        this.DbA.setScreenOnWhilePlaying(z);
    }

    @Override // com.bykv.vk.openvk.eli.eli.DbA.Os.Os
    public void eli(long j, int i) throws Throwable {
        if (i == 0) {
            this.DbA.seekTo((int) j, 0);
            return;
        }
        if (i == 1) {
            this.DbA.seekTo((int) j, 1);
            return;
        }
        if (i == 2) {
            this.DbA.seekTo((int) j, 2);
        } else if (i == 3) {
            this.DbA.seekTo((int) j, 3);
        } else {
            this.DbA.seekTo((int) j);
        }
    }

    @Override // com.bykv.vk.openvk.eli.eli.DbA.Os.Os
    public long aAs() {
        try {
            return this.DbA.getCurrentPosition();
        } catch (Throwable unused) {
            return 0L;
        }
    }

    @Override // com.bykv.vk.openvk.eli.eli.DbA.Os.Os
    public long du() {
        try {
            return this.DbA.getDuration();
        } catch (Throwable unused) {
            return 0L;
        }
    }

    @Override // com.bykv.vk.openvk.eli.eli.DbA.Os.Os
    public void nlS() throws Throwable {
        synchronized (this.MGA) {
            if (!this.kb) {
                this.DbA.release();
                this.kb = true;
                nGm();
                aqO();
                eli();
                dV();
            }
        }
    }

    @Override // com.bykv.vk.openvk.eli.eli.DbA.Os.Os
    public void NU() throws Throwable {
        try {
            this.DbA.reset();
        } catch (Throwable unused) {
        }
        aqO();
        eli();
        dV();
    }

    @Override // com.bykv.vk.openvk.eli.eli.DbA.Os.Os
    public void Os(boolean z) throws Throwable {
        this.DbA.setLooping(z);
    }

    @Override // com.bykv.vk.openvk.eli.eli.DbA.Os.Os
    public void aGH(boolean z) throws Throwable {
        MediaPlayer mediaPlayer = this.DbA;
        if (mediaPlayer == null) {
            return;
        }
        if (z) {
            mediaPlayer.setVolume(0.0f, 0.0f);
        } else {
            mediaPlayer.setVolume(1.0f, 1.0f);
        }
    }

    @Override // com.bykv.vk.openvk.eli.eli.DbA.Os.Os
    public int nn() {
        MediaPlayer mediaPlayer = this.DbA;
        if (mediaPlayer != null) {
            return mediaPlayer.getVideoWidth();
        }
        return 0;
    }

    @Override // com.bykv.vk.openvk.eli.eli.DbA.Os.Os
    public int Dfc() {
        MediaPlayer mediaPlayer = this.DbA;
        if (mediaPlayer != null) {
            return mediaPlayer.getVideoHeight();
        }
        return 0;
    }

    private void dV() {
        this.DbA.setOnPreparedListener(this.Os);
        this.DbA.setOnBufferingUpdateListener(this.Os);
        this.DbA.setOnCompletionListener(this.Os);
        this.DbA.setOnSeekCompleteListener(this.Os);
        this.DbA.setOnVideoSizeChangedListener(this.Os);
        this.DbA.setOnErrorListener(this.Os);
        this.DbA.setOnInfoListener(this.Os);
    }

    private static class eli implements MediaPlayer.OnBufferingUpdateListener, MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener, MediaPlayer.OnInfoListener, MediaPlayer.OnPreparedListener, MediaPlayer.OnSeekCompleteListener, MediaPlayer.OnVideoSizeChangedListener {
        private final WeakReference<DbA> eli;

        public eli(DbA dbA) {
            this.eli = new WeakReference<>(dbA);
        }

        @Override // android.media.MediaPlayer.OnInfoListener
        public boolean onInfo(MediaPlayer mediaPlayer, int i, int i2) {
            try {
                DbA dbA = this.eli.get();
                if (dbA != null) {
                    return dbA.DbA(i, i2);
                }
                return false;
            } catch (Throwable unused) {
                return false;
            }
        }

        @Override // android.media.MediaPlayer.OnErrorListener
        public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
            try {
                new Object[]{"onError: ", Integer.valueOf(i), Integer.valueOf(i2)};
                DbA dbA = this.eli.get();
                if (dbA != null) {
                    return dbA.eli(i, i2);
                }
                return false;
            } catch (Throwable unused) {
                return false;
            }
        }

        @Override // android.media.MediaPlayer.OnVideoSizeChangedListener
        public void onVideoSizeChanged(MediaPlayer mediaPlayer, int i, int i2) {
            try {
                DbA dbA = this.eli.get();
                if (dbA != null) {
                    dbA.eli(i, i2, 1, 1);
                }
            } catch (Throwable unused) {
            }
        }

        @Override // android.media.MediaPlayer.OnSeekCompleteListener
        public void onSeekComplete(MediaPlayer mediaPlayer) {
            try {
                DbA dbA = this.eli.get();
                if (dbA != null) {
                    dbA.aGH();
                }
            } catch (Throwable unused) {
            }
        }

        @Override // android.media.MediaPlayer.OnBufferingUpdateListener
        public void onBufferingUpdate(MediaPlayer mediaPlayer, int i) {
            try {
                DbA dbA = this.eli.get();
                if (dbA != null) {
                    dbA.eli(i);
                }
            } catch (Throwable unused) {
            }
        }

        @Override // android.media.MediaPlayer.OnCompletionListener
        public void onCompletion(MediaPlayer mediaPlayer) {
            try {
                DbA dbA = this.eli.get();
                if (dbA != null) {
                    dbA.Os();
                }
            } catch (Throwable unused) {
            }
        }

        @Override // android.media.MediaPlayer.OnPreparedListener
        public void onPrepared(MediaPlayer mediaPlayer) {
            try {
                DbA dbA = this.eli.get();
                if (dbA != null) {
                    dbA.DbA();
                }
            } catch (Throwable unused) {
            }
        }
    }

    protected void finalize() throws Throwable {
        super.finalize();
        nGm();
    }

    private void nGm() {
        try {
            Surface surface = this.ui;
            if (surface != null) {
                surface.release();
                this.ui = null;
            }
        } catch (Throwable unused) {
        }
    }
}
