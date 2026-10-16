package com.fyber.inneractive.sdk.player.mediaplayer;

import android.content.Context;
import android.media.MediaPlayer;
import android.os.Handler;
import android.os.HandlerThread;
import android.view.Surface;
import android.view.SurfaceHolder;
import com.fyber.inneractive.sdk.util.IAlog;
import com.fyber.inneractive.sdk.util.r;

/* loaded from: classes4.dex */
public final class p extends MediaPlayer implements MediaPlayer.OnPreparedListener, MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener, MediaPlayer.OnSeekCompleteListener, MediaPlayer.OnVideoSizeChangedListener {

    /* renamed from: a, reason: collision with root package name */
    public final Context f1634a;
    public final Handler h;
    public n i;
    public Surface j;
    public SurfaceHolder k;
    public long l;
    public HandlerThread n;
    public Handler o;
    public c p;
    public b q;
    public volatile com.fyber.inneractive.sdk.player.enums.b b = com.fyber.inneractive.sdk.player.enums.b.Idle;
    public boolean c = false;
    public boolean d = false;
    public boolean e = false;
    public boolean f = false;
    public boolean g = false;
    public int m = 0;
    public int r = 0;
    public int s = 0;
    public int t = 0;

    public p(Context context, n nVar, Handler handler) {
        this.f1634a = context;
        this.i = nVar;
        this.h = handler;
        setOnPreparedListener(this);
        setOnErrorListener(this);
        setOnSeekCompleteListener(this);
        setOnVideoSizeChangedListener(this);
        super.setOnCompletionListener(this);
        HandlerThread handlerThread = new HandlerThread("MP-Worker");
        this.n = handlerThread;
        handlerThread.start();
        this.o = new Handler(this.n.getLooper());
        this.q = new b(this);
    }

    public static void b(p pVar) {
        String b = pVar.b();
        long currentTimeMillis = System.currentTimeMillis();
        super.release();
        IAlog.e(b + "timelog: release took " + (System.currentTimeMillis() - currentTimeMillis) + " msec", new Object[0]);
    }

    public static void c(p pVar) {
        String b = pVar.b();
        long currentTimeMillis = System.currentTimeMillis();
        com.fyber.inneractive.sdk.player.enums.b bVar = pVar.b;
        if (bVar == com.fyber.inneractive.sdk.player.enums.b.Paused || bVar == com.fyber.inneractive.sdk.player.enums.b.Prepared || bVar == com.fyber.inneractive.sdk.player.enums.b.Completed || bVar == com.fyber.inneractive.sdk.player.enums.b.Start_in_progress) {
            super.start();
            pVar.a(com.fyber.inneractive.sdk.player.enums.b.Playing);
        } else {
            IAlog.a("%s Start called in wrong mState! %s", pVar.b(), bVar);
            if (pVar.b == com.fyber.inneractive.sdk.player.enums.b.Seeking) {
                pVar.c = true;
            }
        }
        IAlog.e(b + "timelog: start took " + (System.currentTimeMillis() - currentTimeMillis) + " msec", new Object[0]);
    }

    public final boolean a() {
        return (this.b == com.fyber.inneractive.sdk.player.enums.b.Idle || this.b == com.fyber.inneractive.sdk.player.enums.b.Preparing) ? false : true;
    }

    public final void d() {
        this.d = true;
        if (a()) {
            a(new l(this));
        } else {
            IAlog.a("%s mute called when player is not ready!", b());
        }
        IAlog.a("%s mute", b());
    }

    public final void e() {
        String b = b();
        long currentTimeMillis = System.currentTimeMillis();
        com.fyber.inneractive.sdk.player.enums.b bVar = this.b;
        com.fyber.inneractive.sdk.player.enums.b bVar2 = com.fyber.inneractive.sdk.player.enums.b.Idle;
        if (bVar == bVar2) {
            IAlog.a("%s reset called, but player is already resetted. Do nothing", b());
            return;
        }
        a(bVar2);
        try {
            super.reset();
        } catch (Exception unused) {
        }
        IAlog.e(b + "timelog: reset took " + (System.currentTimeMillis() - currentTimeMillis) + " msec", new Object[0]);
    }

    @Override // android.media.MediaPlayer
    public final int getCurrentPosition() {
        if (a()) {
            return super.getCurrentPosition();
        }
        return 0;
    }

    @Override // android.media.MediaPlayer
    public final int getDuration() {
        return this.r;
    }

    @Override // android.media.MediaPlayer
    public final int getVideoHeight() {
        return this.t;
    }

    @Override // android.media.MediaPlayer
    public final int getVideoWidth() {
        return this.s;
    }

    @Override // android.media.MediaPlayer
    public final boolean isPlaying() {
        return a() && this.b != com.fyber.inneractive.sdk.player.enums.b.Paused && super.isPlaying();
    }

    @Override // android.media.MediaPlayer.OnCompletionListener
    public final void onCompletion(MediaPlayer mediaPlayer) {
        a(com.fyber.inneractive.sdk.player.enums.b.Completed);
    }

    @Override // android.media.MediaPlayer.OnErrorListener
    public final boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
        IAlog.f("%s onError code = %d code2 = %d", b(), Integer.valueOf(i), Integer.valueOf(i2));
        e();
        this.h.post(new a(this, i, i2));
        return true;
    }

    @Override // android.media.MediaPlayer.OnPreparedListener
    public final void onPrepared(MediaPlayer mediaPlayer) {
        IAlog.a("%s onPrepared %s gotPrepared = %s", b(), this, Boolean.valueOf(this.g));
        IAlog.a("%sMedia prepare time took %d msec", b(), Long.valueOf(System.currentTimeMillis() - this.l));
        if (this.b != com.fyber.inneractive.sdk.player.enums.b.Preparing && this.b != com.fyber.inneractive.sdk.player.enums.b.Seeking) {
            IAlog.f("%s onPrepared: previous error encountered. Aborting", b());
        } else if (this.g) {
            IAlog.a("%s onPrepared called again??? We are already prepared", b());
        } else {
            this.g = true;
            c();
        }
    }

    @Override // android.media.MediaPlayer.OnSeekCompleteListener
    public final void onSeekComplete(MediaPlayer mediaPlayer) {
        IAlog.a("%s onSeekComplete called current position = %d", b(), Integer.valueOf(mediaPlayer.getCurrentPosition()));
        if (this.b != com.fyber.inneractive.sdk.player.enums.b.Seeking) {
            IAlog.a("%s onSeekComplete called when Story is not seeking", b());
            return;
        }
        if (this.d) {
            d();
        }
        if (!this.c) {
            IAlog.a("%s onSeekComplete mPlayAfterSeek = false", b());
            a(com.fyber.inneractive.sdk.player.enums.b.Paused);
        } else {
            IAlog.a("%s onSeekComplete mPlayAfterSeek = true", b());
            this.b = com.fyber.inneractive.sdk.player.enums.b.Paused;
            start();
        }
    }

    @Override // android.media.MediaPlayer.OnVideoSizeChangedListener
    public final void onVideoSizeChanged(MediaPlayer mediaPlayer, int i, int i2) {
        IAlog.a("%s onVideoSizeChanged %d, %d", b(), Integer.valueOf(i), Integer.valueOf(i2));
        if (this.f) {
            return;
        }
        c cVar = this.p;
        if (cVar != null) {
            r.b.removeCallbacks(cVar);
            IAlog.a("%s onVideoSizeChanged cancelling prepared runnable", b());
        }
        this.f = true;
        if (i == 0 || i2 == 0) {
            IAlog.f("%s onVideoSizeChanged - Invalid video size!", b());
            onError(this, 0, 0);
        } else {
            IAlog.a("%sMedia got video size time took %d msec", b(), Long.valueOf(System.currentTimeMillis() - this.l));
            this.s = i;
            this.t = i2;
            c();
        }
    }

    @Override // android.media.MediaPlayer
    public final void pause() {
        if (this.b != com.fyber.inneractive.sdk.player.enums.b.Idle && this.b != com.fyber.inneractive.sdk.player.enums.b.Completed) {
            com.fyber.inneractive.sdk.player.enums.b bVar = this.b;
            com.fyber.inneractive.sdk.player.enums.b bVar2 = com.fyber.inneractive.sdk.player.enums.b.Paused;
            if (bVar != bVar2 && this.b != com.fyber.inneractive.sdk.player.enums.b.Prepared) {
                a(bVar2);
                if (a()) {
                    a(new k(this));
                } else {
                    IAlog.a("%s paused called when player is not ready!", b());
                }
                IAlog.a("%s pause", b());
                return;
            }
        }
        IAlog.a("%s paused called when player is in mState: %s ignoring", b(), this.b);
    }

    @Override // android.media.MediaPlayer
    public final void release() {
        if (!this.e) {
            a(new g(this));
        }
        this.i = null;
        this.q = null;
        this.e = true;
        IAlog.a("%s release called", b());
    }

    @Override // android.media.MediaPlayer
    public final void reset() {
        IAlog.a("%s reset called", b());
        c cVar = this.p;
        if (cVar != null) {
            r.b.removeCallbacks(cVar);
        }
        a(new h(this));
    }

    @Override // android.media.MediaPlayer
    public final void setDisplay(SurfaceHolder surfaceHolder) {
        IAlog.a("%s setDisplay called", b());
        if (!a()) {
            IAlog.a("%s setDisplay called when player is not ready!", b());
            return;
        }
        SurfaceHolder surfaceHolder2 = this.k;
        if (surfaceHolder2 != null && surfaceHolder2.equals(surfaceHolder)) {
            IAlog.a("%s setDisplay called with existing surface. ignoring!", b());
        } else {
            this.k = surfaceHolder;
            a(new e(this, surfaceHolder));
        }
    }

    @Override // android.media.MediaPlayer
    public final void setOnCompletionListener(MediaPlayer.OnCompletionListener onCompletionListener) {
        throw new IllegalAccessError("Please use IAplayerCallbacks to receive completion events");
    }

    @Override // android.media.MediaPlayer
    public final void setSurface(Surface surface) {
        IAlog.a("%s setSurface called", b());
        Surface surface2 = this.j;
        if (surface2 != null && surface2.equals(surface)) {
            IAlog.a("%s setSurface called with existing surface. ignoring!", b());
        } else {
            this.j = surface;
            a(new f(this, surface));
        }
    }

    @Override // android.media.MediaPlayer
    public final void start() {
        IAlog.a("%s Start called", b());
        if (!a()) {
            IAlog.a("%s MediaPlayer: Start called when player is not ready! - mState = %s", b(), this.b);
            return;
        }
        if (this.b == com.fyber.inneractive.sdk.player.enums.b.Seeking) {
            this.c = true;
        } else if (isPlaying()) {
            IAlog.a("%s MediaPlayer: Start called when player is already playing. do nothing", b());
        } else {
            a(com.fyber.inneractive.sdk.player.enums.b.Start_in_progress);
            a(new i(this));
        }
    }

    @Override // android.media.MediaPlayer
    public final void stop() {
        String b = b();
        long currentTimeMillis = System.currentTimeMillis();
        if (a()) {
            super.stop();
        }
        IAlog.a("%s stop called", b());
        IAlog.e(b + "timelog: stop took " + (System.currentTimeMillis() - currentTimeMillis) + " msec", new Object[0]);
    }

    public final void a(String str) {
        String b = b();
        long currentTimeMillis = System.currentTimeMillis();
        this.f = false;
        this.g = false;
        if (isPlaying()) {
            IAlog.a("%s loadUri stopping play before refresh", b());
            stop();
        }
        this.l = System.currentTimeMillis();
        e();
        IAlog.a("%s calling setDataSource with %s", b(), str);
        try {
            setDataSource(str);
            IAlog.a("%s setDataSource succeeded, calling prepareAsync", b());
            a(com.fyber.inneractive.sdk.player.enums.b.Preparing);
            try {
                prepareAsync();
            } catch (IllegalStateException e) {
                IAlog.b("%s prepareAsync failed with illegal mState exception: %s", b(), e.getMessage());
                this.m++;
                if (this.m < 5) {
                    a(str);
                }
                this.m = 0;
            }
            IAlog.e(b + "timelog: loadUri took " + (System.currentTimeMillis() - currentTimeMillis) + " msec", new Object[0]);
        } catch (Exception e2) {
            IAlog.b("%s error setting data source %s", b(), str);
            IAlog.b("%s exception message: %s", b(), e2.getMessage());
        }
    }

    public final String b() {
        return "mp(" + this + "): T:" + Thread.currentThread().getId() + "-" + Thread.currentThread().getName() + ": ";
    }

    public static void d(p pVar) {
        String b = pVar.b();
        long currentTimeMillis = System.currentTimeMillis();
        if (super.isPlaying()) {
            super.pause();
        } else {
            IAlog.a("%s paused called cannot set to pause, canceled", pVar.b());
        }
        IAlog.e(b + "timelog: delayed pause took " + (System.currentTimeMillis() - currentTimeMillis) + " msec", new Object[0]);
    }

    public final void c() {
        if (this.g) {
            if (this.f) {
                IAlog.a("%sMedia load time took %d msec", b(), Long.valueOf(System.currentTimeMillis() - this.l));
                this.r = super.getDuration();
                a(com.fyber.inneractive.sdk.player.enums.b.Prepared);
                if (this.d) {
                    d();
                    return;
                }
                return;
            }
            IAlog.a("%sGot prepared only, waiting for video size", b());
            if (this.p == null) {
                this.p = new c(this);
            }
            r.b.postDelayed(this.p, 2000L);
        }
    }

    public final void a(com.fyber.inneractive.sdk.player.enums.b bVar) {
        IAlog.a("%s updatePlayerState - %s", b(), bVar);
        if (this.b == bVar) {
            IAlog.a("%s updatePlayerState - mState didn't change!", b());
            return;
        }
        IAlog.a("%s updatePlayerState - changing from %s to %s", b(), this.b, bVar);
        this.b = bVar;
        this.h.post(new d(this, bVar));
    }

    public static void a(p pVar, Surface surface) {
        String b = pVar.b();
        long currentTimeMillis = System.currentTimeMillis();
        IAlog.a("%s setSurface called with %s", pVar.b(), surface);
        try {
            super.setSurface(surface);
            if (surface == null) {
                IAlog.a("%s setSurface with null! current surface cleared", pVar.b());
            } else {
                IAlog.a("%s setSurface - replacing surface!", pVar.b());
            }
            IAlog.e(b + "timelog: setSurface took " + (System.currentTimeMillis() - currentTimeMillis) + " msec", new Object[0]);
        } catch (Exception unused) {
            IAlog.a("%s super.setSurface threw exception!", pVar.b());
        }
    }

    public static void a(p pVar, SurfaceHolder surfaceHolder) {
        String b = pVar.b();
        long currentTimeMillis = System.currentTimeMillis();
        IAlog.a("%s setDisplay called with %s", pVar.b(), surfaceHolder);
        try {
            super.setDisplay(surfaceHolder);
            if (surfaceHolder == null) {
                IAlog.a("%s setDisplay with null! current display cleared", pVar.b());
            } else {
                IAlog.a("%s setDisplay - replacing surface holder!", pVar.b());
            }
            IAlog.e(b + "timelog: setDisplayInternal took " + (System.currentTimeMillis() - currentTimeMillis) + " msec", new Object[0]);
        } catch (Exception unused) {
            IAlog.a("%s super.setDisplay threw exception!", pVar.b());
        }
    }

    public final void a(Runnable runnable) {
        Handler handler;
        Handler handler2;
        HandlerThread handlerThread = this.n;
        if (handlerThread != null && handlerThread.isAlive() && !this.n.isInterrupted() && (handler2 = this.o) != null) {
            handler2.post(runnable);
        }
        if ((this.s == 0 || this.t == 0 || this.r == 0) && (handler = this.o) != null) {
            handler.post(this.q);
        }
    }

    public static void a(p pVar) {
        if (pVar.a()) {
            pVar.s = super.getVideoWidth();
            pVar.t = super.getVideoHeight();
            pVar.r = super.getDuration();
        }
    }
}
