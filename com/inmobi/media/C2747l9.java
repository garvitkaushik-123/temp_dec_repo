package com.inmobi.media;

import android.app.KeyguardManager;
import android.content.Context;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.PowerManager;
import android.view.Surface;
import android.view.TextureView;
import android.view.View;
import android.view.ViewParent;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.ProgressBar;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: com.inmobi.media.l9, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C2747l9 extends TextureView implements MediaController.MediaPlayerControl {
    public static final String C = "l9";
    public final MediaPlayer.OnErrorListener A;
    public final TextureViewSurfaceTextureListenerC2731k9 B;

    /* renamed from: a, reason: collision with root package name */
    public Uri f2632a;
    public Surface b;
    public G8 c;
    public int d;
    public int e;
    public int f;
    public int g;
    public int h;
    public InterfaceC2682h9 i;
    public InterfaceC2666g9 j;
    public InterfaceC2649f9 k;
    public boolean l;
    public HandlerC2698i9 m;
    public C2631e9 n;
    public int o;
    public boolean p;
    public boolean q;
    public boolean r;
    public Handler s;
    public boolean t;
    public final C2648f8 u;
    public MediaPlayer.OnVideoSizeChangedListener v;
    public final C2715j9 w;
    public final MediaPlayer.OnCompletionListener x;
    public final MediaPlayer.OnInfoListener y;
    public final MediaPlayer.OnBufferingUpdateListener z;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2747l9(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.h = Integer.MIN_VALUE;
        Context context2 = getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "getContext(...)");
        this.u = new C2648f8(context2, this);
        requestLayout();
        invalidate();
        this.v = new MediaPlayer.OnVideoSizeChangedListener() { // from class: com.inmobi.media.l9$$ExternalSyntheticLambda2
            @Override // android.media.MediaPlayer.OnVideoSizeChangedListener
            public final void onVideoSizeChanged(MediaPlayer mediaPlayer, int i, int i2) {
                C2747l9.c(C2747l9.this, mediaPlayer, i, i2);
            }
        };
        this.w = new C2715j9(this);
        this.x = new MediaPlayer.OnCompletionListener() { // from class: com.inmobi.media.l9$$ExternalSyntheticLambda3
            @Override // android.media.MediaPlayer.OnCompletionListener
            public final void onCompletion(MediaPlayer mediaPlayer) {
                C2747l9.a(C2747l9.this, mediaPlayer);
            }
        };
        this.y = new MediaPlayer.OnInfoListener() { // from class: com.inmobi.media.l9$$ExternalSyntheticLambda4
            @Override // android.media.MediaPlayer.OnInfoListener
            public final boolean onInfo(MediaPlayer mediaPlayer, int i, int i2) {
                return C2747l9.b(C2747l9.this, mediaPlayer, i, i2);
            }
        };
        this.z = new MediaPlayer.OnBufferingUpdateListener() { // from class: com.inmobi.media.l9$$ExternalSyntheticLambda5
            @Override // android.media.MediaPlayer.OnBufferingUpdateListener
            public final void onBufferingUpdate(MediaPlayer mediaPlayer, int i) {
                C2747l9.a(C2747l9.this, mediaPlayer, i);
            }
        };
        this.A = new MediaPlayer.OnErrorListener() { // from class: com.inmobi.media.l9$$ExternalSyntheticLambda6
            @Override // android.media.MediaPlayer.OnErrorListener
            public final boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                return C2747l9.a(C2747l9.this, mediaPlayer, i, i2);
            }
        };
        this.B = new TextureViewSurfaceTextureListenerC2731k9(this);
    }

    public static final void a(C2747l9 this$0, MediaPlayer mediaPlayer) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        try {
            this$0.d();
        } catch (Exception e) {
            String TAG = C;
            Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
            S5 s5 = S5.f2425a;
            S5.d.a(AbstractC2920w5.a(e, "event"));
        }
    }

    public static final void c(C2747l9 this$0, MediaPlayer mediaPlayer, int i, int i2) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.e = mediaPlayer.getVideoWidth();
        int videoHeight = mediaPlayer.getVideoHeight();
        this$0.f = videoHeight;
        if (this$0.e == 0 || videoHeight == 0) {
            return;
        }
        this$0.requestLayout();
    }

    public static final void e(C2747l9 this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.pause();
    }

    private final void setVideoPath(String str) {
        setVideoURI(Uri.parse(str));
    }

    private final void setVideoURI(Uri uri) {
        this.f2632a = uri;
        e();
        requestLayout();
        invalidate();
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public final boolean canPause() {
        return this.p;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public final boolean canSeekBackward() {
        return this.q;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public final boolean canSeekForward() {
        return this.r;
    }

    public final void d() {
        G8 g8 = this.c;
        if (g8 != null) {
            g8.f2294a = 5;
        }
        if (g8 != null) {
            g8.b = 5;
        }
        C2631e9 c2631e9 = this.n;
        if (c2631e9 != null) {
            c2631e9.c();
        }
        HandlerC2698i9 handlerC2698i9 = this.m;
        if (handlerC2698i9 != null) {
            handlerC2698i9.removeMessages(1);
        }
        Object tag = getTag();
        if (tag instanceof C2597c9) {
            C2597c9 c2597c9 = (C2597c9) tag;
            Object obj = c2597c9.t.get("didCompleteQ4");
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Boolean");
            if (!((Boolean) obj).booleanValue()) {
                c2597c9.t.put("didCompleteQ4", Boolean.TRUE);
                InterfaceC2682h9 interfaceC2682h9 = this.i;
                if (interfaceC2682h9 != null) {
                    ((C2974z8) interfaceC2682h9).a((byte) 3);
                }
            }
            c2597c9.t.put("didSignalVideoCompleted", Boolean.TRUE);
            HashMap hashMap = c2597c9.t;
            if (hashMap != null) {
                Boolean bool = Boolean.FALSE;
                hashMap.put("didCompleteQ1", bool);
                hashMap.put("didCompleteQ2", bool);
                hashMap.put("didCompleteQ3", bool);
                hashMap.put("didPause", bool);
                hashMap.put("didStartPlaying", bool);
                hashMap.put("didQ4Fire", bool);
            }
            if (c2597c9.B) {
                start();
                return;
            }
            this.u.a();
            Object obj2 = c2597c9.t.get("isFullScreen");
            Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.Boolean");
            if (((Boolean) obj2).booleanValue()) {
                a(8, 0);
            }
        }
    }

    public final void f() {
        Surface surface = this.b;
        if (surface != null) {
            surface.release();
        }
        this.b = null;
        g();
    }

    public final void g() {
        G8 g8;
        HandlerC2698i9 handlerC2698i9 = this.m;
        if (handlerC2698i9 != null) {
            handlerC2698i9.removeMessages(1);
        }
        C2648f8 c2648f8 = this.u;
        c2648f8.a();
        c2648f8.f = null;
        c2648f8.g = null;
        Object tag = getTag();
        boolean z = tag instanceof C2597c9;
        if (z) {
            ((C2597c9) tag).t.put("seekPosition", Integer.valueOf(getCurrentPosition()));
        }
        G8 g82 = this.c;
        if (g82 != null) {
            g82.f2294a = 0;
        }
        if (g82 != null) {
            g82.b = 0;
        }
        if (g82 != null) {
            try {
                g82.reset();
            } catch (Exception e) {
                S5 s5 = S5.f2425a;
                S5.d.a(AbstractC2920w5.a(e, "event"));
            }
        }
        G8 g83 = this.c;
        if (g83 != null) {
            g83.setOnPreparedListener(null);
            g83.setOnVideoSizeChangedListener(null);
            g83.setOnCompletionListener(null);
            g83.setOnErrorListener(null);
            g83.setOnInfoListener(null);
            g83.setOnBufferingUpdateListener(null);
        }
        if (z) {
            Object obj = ((C2597c9) tag).t.get("placementType");
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Byte");
            if (((Byte) obj).byteValue() == 0 && (g8 = this.c) != null) {
                g8.a();
            }
        } else {
            G8 g84 = this.c;
            if (g84 != null) {
                g84.a();
            }
        }
        String TAG = C;
        Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
        this.c = null;
    }

    public final C2648f8 getAudioFocusManager$media_release() {
        return this.u;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public int getAudioSessionId() {
        if (this.d == 0) {
            MediaPlayer mediaPlayer = new MediaPlayer();
            this.d = mediaPlayer.getAudioSessionId();
            mediaPlayer.release();
        }
        return this.d;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public int getBufferPercentage() {
        if (this.c != null) {
            return this.o;
        }
        return 0;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public int getCurrentPosition() {
        G8 g8 = this.c;
        if (g8 == null || !a()) {
            return 0;
        }
        return g8.getCurrentPosition();
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public int getDuration() {
        G8 g8 = this.c;
        if (g8 == null || !a()) {
            return -1;
        }
        return g8.getDuration();
    }

    public final int getLastVolume() {
        return this.h;
    }

    public final MediaPlayer.OnVideoSizeChangedListener getMSizeChangedListener() {
        return this.v;
    }

    public final C2631e9 getMediaController() {
        return this.n;
    }

    public final G8 getMediaPlayer() {
        return this.c;
    }

    public final boolean getPauseScheduled() {
        return this.t;
    }

    public final InterfaceC2666g9 getPlaybackEventListener() {
        return this.j;
    }

    public final InterfaceC2682h9 getQuartileCompletedListener() {
        return this.i;
    }

    public final int getState() {
        G8 g8 = this.c;
        if (g8 != null) {
            return g8.f2294a;
        }
        return 0;
    }

    public final int getVideoVolume() {
        if (isPlaying()) {
            return this.g;
        }
        return -1;
    }

    public final int getVolume() {
        if (a()) {
            return this.g;
        }
        return -1;
    }

    public final void h() {
        G8 g8 = this.c;
        if (g8 != null) {
            this.g = 0;
            if (g8 != null) {
                g8.setVolume(0.0f, 0.0f);
            }
            Object tag = getTag();
            if (tag instanceof C2597c9) {
                ((C2597c9) tag).t.put("currentMediaVolume", 0);
            }
        }
    }

    public final void i() {
        G8 g8 = this.c;
        if (g8 != null) {
            this.g = 1;
            if (g8 != null) {
                g8.setVolume(1.0f, 1.0f);
            }
            Object tag = getTag();
            if (tag instanceof C2597c9) {
                ((C2597c9) tag).t.put("currentMediaVolume", 15);
            }
        }
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public final boolean isPlaying() {
        G8 g8;
        return a() && (g8 = this.c) != null && g8.isPlaying();
    }

    public final void j() {
        G8 g8;
        if (a() && (g8 = this.c) != null && g8.isPlaying()) {
            G8 g82 = this.c;
            if (g82 != null) {
                g82.pause();
            }
            G8 g83 = this.c;
            if (g83 != null) {
                g83.seekTo(0);
            }
            this.u.a();
            Object tag = getTag();
            if (tag instanceof C2597c9) {
                C2597c9 c2597c9 = (C2597c9) tag;
                HashMap hashMap = c2597c9.t;
                Boolean bool = Boolean.TRUE;
                hashMap.put("didPause", bool);
                c2597c9.t.put("seekPosition", 0);
                c2597c9.t.put("didCompleteQ4", bool);
            }
            G8 g84 = this.c;
            if (g84 != null) {
                g84.f2294a = 4;
            }
            InterfaceC2666g9 interfaceC2666g9 = this.j;
            if (interfaceC2666g9 != null) {
                ((A8) interfaceC2666g9).a((byte) 4);
            }
        }
        G8 g85 = this.c;
        if (g85 == null) {
            return;
        }
        g85.b = 4;
    }

    public final void k() {
        if (this.c != null) {
            if (isPlaying()) {
                this.u.c();
            } else {
                i();
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x0057, code lost:
    
        if (r1 > r6) goto L26;
     */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void onMeasure(int i, int i2) {
        int defaultSize;
        int defaultSize2;
        int i3;
        int i4;
        try {
            defaultSize = TextureView.getDefaultSize(this.e, i);
            defaultSize2 = TextureView.getDefaultSize(this.f, i2);
        } catch (Exception unused) {
            String TAG = C;
            Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
            return;
        }
        if (this.e > 0 && this.f > 0) {
            int mode = View.MeasureSpec.getMode(i);
            int size = View.MeasureSpec.getSize(i);
            int mode2 = View.MeasureSpec.getMode(i2);
            int size2 = View.MeasureSpec.getSize(i2);
            if (mode == 1073741824 && mode2 == 1073741824) {
                int i5 = this.e;
                int i6 = i5 * size2;
                int i7 = this.f;
                int i8 = size * i7;
                if (i6 < i8) {
                    i4 = i8 / i5;
                    defaultSize2 = i4;
                    defaultSize = size;
                } else {
                    if (i6 > i8) {
                        defaultSize = i6 / i7;
                        defaultSize2 = size2;
                    }
                    defaultSize2 = size2;
                    defaultSize = size;
                }
            } else {
                if (mode == 1073741824) {
                    int i9 = (this.f * size) / this.e;
                    if (mode2 != Integer.MIN_VALUE || i9 <= size2) {
                        defaultSize2 = i9;
                        defaultSize = size;
                    }
                } else {
                    if (mode2 == 1073741824) {
                        i3 = (this.e * size2) / this.f;
                        if (mode == Integer.MIN_VALUE) {
                        }
                    } else {
                        int i10 = this.e;
                        int i11 = this.f;
                        if (mode2 != Integer.MIN_VALUE || i11 <= size2) {
                            i3 = i10;
                            size2 = i11;
                        } else {
                            i3 = (size2 * i10) / i11;
                        }
                        if (mode == Integer.MIN_VALUE && i3 > size) {
                            i4 = (i11 * size) / i10;
                            defaultSize2 = i4;
                            defaultSize = size;
                        }
                    }
                    defaultSize = i3;
                    defaultSize2 = size2;
                }
                defaultSize2 = size2;
                defaultSize = size;
            }
            String TAG2 = C;
            Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
            return;
        }
        setMeasuredDimension(defaultSize, defaultSize2);
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public final void pause() {
        G8 g8;
        if (a() && (g8 = this.c) != null && g8.isPlaying()) {
            G8 g82 = this.c;
            if (g82 != null) {
                g82.pause();
            }
            G8 g83 = this.c;
            if (g83 != null) {
                g83.f2294a = 4;
            }
            this.u.a();
            Object tag = getTag();
            if (tag instanceof C2597c9) {
                C2597c9 c2597c9 = (C2597c9) tag;
                c2597c9.t.put("didPause", Boolean.TRUE);
                c2597c9.t.put("seekPosition", Integer.valueOf(getCurrentPosition()));
            }
            InterfaceC2666g9 interfaceC2666g9 = this.j;
            if (interfaceC2666g9 != null) {
                ((A8) interfaceC2666g9).a((byte) 2);
            }
        }
        G8 g84 = this.c;
        if (g84 != null) {
            g84.b = 4;
        }
        this.t = false;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public final void seekTo(int i) {
    }

    public final void setIsLockScreen(boolean z) {
        this.l = z;
    }

    public final void setLastVolume(int i) {
        this.h = i;
    }

    public final void setMSizeChangedListener(MediaPlayer.OnVideoSizeChangedListener onVideoSizeChangedListener) {
        Intrinsics.checkNotNullParameter(onVideoSizeChangedListener, "<set-?>");
        this.v = onVideoSizeChangedListener;
    }

    public final void setMediaController(C2631e9 c2631e9) {
        C2631e9 mediaController;
        if (c2631e9 != null) {
            this.n = c2631e9;
            if (this.c == null || (mediaController = getMediaController()) == null) {
                return;
            }
            mediaController.setMediaPlayer(this);
            mediaController.setEnabled(a());
            mediaController.d();
        }
    }

    public final void setMediaErrorListener(InterfaceC2649f9 interfaceC2649f9) {
        this.k = interfaceC2649f9;
    }

    public final void setPlaybackEventListener(InterfaceC2666g9 interfaceC2666g9) {
        this.j = interfaceC2666g9;
    }

    public final void setQuartileCompletedListener(InterfaceC2682h9 interfaceC2682h9) {
        this.i = interfaceC2682h9;
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00ab  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00c5  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00cd  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00d4  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x011e  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00b1  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00a8  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0125 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0126  */
    @Override // android.widget.MediaController.MediaPlayerControl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void start() {
        boolean z;
        G8 g8;
        G8 g82;
        int i;
        G8 g83;
        G8 g84;
        C2631e9 c2631e9;
        HandlerC2698i9 handlerC2698i9;
        G8 g85;
        Object systemService = getContext().getSystemService("power");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.os.PowerManager");
        Object systemService2 = getContext().getSystemService("keyguard");
        Intrinsics.checkNotNull(systemService2, "null cannot be cast to non-null type android.app.KeyguardManager");
        boolean isKeyguardLocked = ((KeyguardManager) systemService2).isKeyguardLocked();
        boolean isInteractive = ((PowerManager) systemService).isInteractive();
        boolean a2 = a();
        Object tag = getTag();
        C2597c9 c2597c9 = tag instanceof C2597c9 ? (C2597c9) tag : null;
        boolean z2 = false;
        if (c2597c9 != null) {
            Object obj = c2597c9.t.get("shouldAutoPlay");
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Boolean");
            if (!((Boolean) obj).booleanValue()) {
                z = false;
                if (a2 && !z) {
                    a(8, 0);
                }
                if (a2 && isInteractive && (g82 = this.c) != null && !g82.isPlaying() && z && (this.l || !isKeyguardLocked)) {
                    if (c2597c9 != null) {
                        Object obj2 = c2597c9.t.get("didCompleteQ4");
                        Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.Boolean");
                        if (!((Boolean) obj2).booleanValue()) {
                            Object obj3 = c2597c9.t.get("seekPosition");
                            Intrinsics.checkNotNull(obj3, "null cannot be cast to non-null type kotlin.Int");
                            i = ((Integer) obj3).intValue();
                            if (c2597c9 != null ? c2597c9.c() : false) {
                                this.u.c();
                            } else {
                                c();
                            }
                            if (a() && (g85 = this.c) != null) {
                                g85.seekTo(i);
                            }
                            g83 = this.c;
                            if (g83 != null) {
                                g83.start();
                            }
                            g84 = this.c;
                            if (g84 != null) {
                                g84.f2294a = 3;
                            }
                            a(8, 8);
                            if (c2597c9 != null) {
                                HashMap hashMap = c2597c9.t;
                                Boolean bool = Boolean.FALSE;
                                hashMap.put("didCompleteQ4", bool);
                                Object obj4 = c2597c9.t.get("didPause");
                                Intrinsics.checkNotNull(obj4, "null cannot be cast to non-null type kotlin.Boolean");
                                if (((Boolean) obj4).booleanValue()) {
                                    InterfaceC2666g9 interfaceC2666g9 = this.j;
                                    if (interfaceC2666g9 != null) {
                                        ((A8) interfaceC2666g9).a((byte) 3);
                                    }
                                    c2597c9.t.put("didPause", bool);
                                } else {
                                    InterfaceC2666g9 interfaceC2666g92 = this.j;
                                    if (interfaceC2666g92 != null) {
                                        ((A8) interfaceC2666g92).a((byte) 1);
                                    }
                                }
                                HandlerC2698i9 handlerC2698i92 = this.m;
                                if (handlerC2698i92 != null && !handlerC2698i92.hasMessages(1)) {
                                    z2 = true;
                                }
                                if (z2 && (handlerC2698i9 = this.m) != null) {
                                    handlerC2698i9.sendEmptyMessage(1);
                                }
                            }
                            c2631e9 = this.n;
                            if (c2631e9 != null) {
                                c2631e9.d();
                            }
                        }
                    }
                    i = 0;
                    if (c2597c9 != null ? c2597c9.c() : false) {
                    }
                    if (a()) {
                        g85.seekTo(i);
                    }
                    g83 = this.c;
                    if (g83 != null) {
                    }
                    g84 = this.c;
                    if (g84 != null) {
                    }
                    a(8, 8);
                    if (c2597c9 != null) {
                    }
                    c2631e9 = this.n;
                    if (c2631e9 != null) {
                    }
                }
                g8 = this.c;
                if (g8 != null) {
                    return;
                }
                g8.b = 3;
                return;
            }
        }
        z = true;
        if (a2) {
            a(8, 0);
        }
        if (a2) {
            if (c2597c9 != null) {
            }
            i = 0;
            if (c2597c9 != null ? c2597c9.c() : false) {
            }
            if (a()) {
            }
            g83 = this.c;
            if (g83 != null) {
            }
            g84 = this.c;
            if (g84 != null) {
            }
            a(8, 8);
            if (c2597c9 != null) {
            }
            c2631e9 = this.n;
            if (c2631e9 != null) {
            }
        }
        g8 = this.c;
        if (g8 != null) {
        }
    }

    public final void e() {
        byte b;
        G8 a2;
        if (this.f2632a == null || this.b == null) {
            return;
        }
        if (this.c != null) {
            d(this);
            return;
        }
        Object tag = getTag();
        C2597c9 c2597c9 = tag instanceof C2597c9 ? (C2597c9) tag : null;
        if (c2597c9 != null) {
            Object obj = c2597c9.t.get("placementType");
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Byte");
            b = ((Byte) obj).byteValue();
        } else {
            b = 1;
        }
        if (1 == b) {
            a2 = new G8();
        } else {
            Object obj2 = G8.d;
            a2 = F8.a();
        }
        this.c = a2;
        int i = this.d;
        if (i != 0) {
            a2.setAudioSessionId(i);
        } else {
            this.d = a2.getAudioSessionId();
        }
        ((ScheduledThreadPoolExecutor) AbstractC2970z4.c.getValue()).execute(new Runnable() { // from class: com.inmobi.media.l9$$ExternalSyntheticLambda7
            @Override // java.lang.Runnable
            public final void run() {
                C2747l9.b(C2747l9.this);
            }
        });
    }

    public static final boolean b(C2747l9 this$0, MediaPlayer mediaPlayer, int i, int i2) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (3 != i) {
            return true;
        }
        this$0.a(8, 8);
        return true;
    }

    public final void b() {
        try {
            if (this.f2632a != null) {
                Uc.a(new Runnable() { // from class: com.inmobi.media.l9$$ExternalSyntheticLambda8
                    @Override // java.lang.Runnable
                    public final void run() {
                        C2747l9.a(C2747l9.this);
                    }
                });
            }
        } catch (Exception unused) {
            String TAG = C;
            Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
        }
    }

    public static final void c(C2747l9 this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        d(this$0);
    }

    public final void c() {
        if (this.c != null) {
            this.u.a();
            h();
        }
    }

    public static final void a(C2747l9 this$0, MediaPlayer mediaPlayer, int i) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.o = i;
    }

    public static final boolean a(C2747l9 this$0, MediaPlayer mediaPlayer, int i, int i2) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        String TAG = C;
        Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
        InterfaceC2649f9 interfaceC2649f9 = this$0.k;
        if (interfaceC2649f9 != null) {
            B8 b8 = (B8) interfaceC2649f9;
            T7 t7 = b8.f2244a.b;
            if (!t7.t && (t7 instanceof C2562a9)) {
                try {
                    ((C2562a9) t7).a(b8.b, i);
                } catch (Exception e) {
                    D8 d8 = b8.f2244a;
                    InterfaceC2971z5 interfaceC2971z5 = d8.f;
                    if (interfaceC2971z5 != null) {
                        String str = d8.g;
                        ((A5) interfaceC2971z5).b(str, rf.a(e, H6.a(str, "access$getTAG$p(...)", "SDK encountered unexpected error in handling the onVideoError event; ")));
                    }
                }
            }
        }
        G8 g8 = this$0.c;
        if (g8 != null) {
            g8.f2294a = -1;
        }
        if (g8 != null) {
            g8.b = -1;
        }
        C2631e9 c2631e9 = this$0.n;
        if (c2631e9 != null) {
            c2631e9.c();
        }
        this$0.b();
        return true;
    }

    public static final void b(final C2747l9 this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        try {
            G8 g8 = this$0.c;
            if (g8 != null) {
                Context applicationContext = this$0.getContext().getApplicationContext();
                Uri uri = this$0.f2632a;
                Intrinsics.checkNotNull(uri);
                g8.setDataSource(applicationContext, uri, (Map<String, String>) null);
            }
            ExecutorC2793o7 executorC2793o7 = (ExecutorC2793o7) AbstractC2970z4.d.getValue();
            Runnable runnable = new Runnable() { // from class: com.inmobi.media.l9$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    C2747l9.c(C2747l9.this);
                }
            };
            executorC2793o7.getClass();
            Intrinsics.checkNotNullParameter(runnable, "runnable");
            executorC2793o7.f2659a.post(runnable);
        } catch (IOException unused) {
            G8 g82 = this$0.c;
            if (g82 != null) {
                g82.f2294a = -1;
            }
            if (g82 == null) {
                return;
            }
            g82.b = -1;
        }
    }

    public static final void d(C2747l9 c2747l9) {
        G8 g8;
        C2631e9 mediaController;
        try {
            G8 g82 = c2747l9.c;
            if (g82 != null) {
                g82.setOnPreparedListener(c2747l9.w);
                g82.setOnVideoSizeChangedListener(c2747l9.v);
                g82.setOnCompletionListener(c2747l9.x);
                g82.setOnErrorListener(c2747l9.A);
                g82.setOnInfoListener(c2747l9.y);
                g82.setOnBufferingUpdateListener(c2747l9.z);
                g82.setSurface(c2747l9.b);
            }
            if (L3.f2348a.J()) {
                G8 g83 = c2747l9.c;
                if (g83 != null) {
                    g83.setAudioAttributes(c2747l9.u.e);
                }
            } else {
                G8 g84 = c2747l9.c;
                if (g84 != null) {
                    g84.setAudioStreamType(3);
                }
            }
            G8 g85 = c2747l9.c;
            if (g85 != null) {
                g85.prepareAsync();
            }
            c2747l9.o = 0;
            G8 g86 = c2747l9.c;
            if (g86 != null) {
                g86.f2294a = 1;
            }
            if (g86 != null && (mediaController = c2747l9.getMediaController()) != null) {
                mediaController.setMediaPlayer(c2747l9);
                mediaController.setEnabled(c2747l9.a());
                mediaController.d();
            }
            Object tag = c2747l9.getTag();
            if (tag instanceof C2597c9) {
                Object obj = ((C2597c9) tag).t.get("shouldAutoPlay");
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Boolean");
                if (((Boolean) obj).booleanValue() && (g8 = c2747l9.c) != null) {
                    g8.b = 3;
                }
                Object obj2 = ((C2597c9) tag).t.get("didCompleteQ4");
                Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.Boolean");
                if (((Boolean) obj2).booleanValue()) {
                    c2747l9.a(8, 0);
                    return;
                }
            }
            c2747l9.a(0, 0);
        } catch (Exception e) {
            G8 g87 = c2747l9.c;
            if (g87 != null) {
                g87.f2294a = -1;
            }
            if (g87 != null) {
                g87.b = -1;
            }
            c2747l9.A.onError(g87, 1, 0);
            S5 s5 = S5.f2425a;
            S5.d.a(AbstractC2920w5.a(e, "event"));
        }
    }

    public static final void a(C2747l9 this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        String diskUrl = String.valueOf(this$0.f2632a);
        C2755m1 a2 = Nc.a();
        a2.getClass();
        Intrinsics.checkNotNullParameter(diskUrl, "diskUrl");
        ArrayList a3 = T1.a(a2, "disk_uri=? ", new String[]{diskUrl}, null, null, "created_ts DESC ", 1, 12);
        C2705j c2705j = a3.isEmpty() ? null : (C2705j) a3.get(0);
        int nextInt = new Random().nextInt() & Integer.MAX_VALUE;
        long currentTimeMillis = System.currentTimeMillis();
        long currentTimeMillis2 = System.currentTimeMillis();
        if (c2705j != null) {
            String url = c2705j.b;
            Intrinsics.checkNotNullParameter(url, "url");
            long currentTimeMillis3 = System.currentTimeMillis();
            if (url == null) {
                url = "";
            }
            Nc.a().a(new C2705j(nextInt, url, null, 0, currentTimeMillis, currentTimeMillis2, currentTimeMillis3, 0L));
        }
    }

    public final void a(C2597c9 videoAsset) {
        String str;
        G8 a2;
        Intrinsics.checkNotNullParameter(videoAsset, "videoAsset");
        this.e = 0;
        this.f = 0;
        Object obj = videoAsset.e;
        Ve ve = obj instanceof Ve ? (Ve) obj : null;
        if (ve == null || (str = ((Ue) ve).b()) == null) {
            str = "";
        }
        final Uri parse = Uri.parse(str);
        this.f2632a = parse;
        Object obj2 = videoAsset.t.get("placementType");
        Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.Byte");
        if (1 == ((Byte) obj2).byteValue()) {
            a2 = new G8();
        } else {
            Object obj3 = G8.d;
            a2 = F8.a();
        }
        this.c = a2;
        int i = this.d;
        if (i != 0) {
            a2.setAudioSessionId(i);
        } else {
            this.d = a2.getAudioSessionId();
        }
        setTag(videoAsset);
        this.m = new HandlerC2698i9(this);
        setSurfaceTextureListener(this.B);
        setFocusable(true);
        setFocusableInTouchMode(true);
        requestFocus();
        ((ScheduledThreadPoolExecutor) AbstractC2970z4.c.getValue()).execute(new Runnable() { // from class: com.inmobi.media.l9$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                C2747l9.a(C2747l9.this, parse);
            }
        });
    }

    public static final void a(C2747l9 this$0, Uri uri) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        try {
            G8 g8 = this$0.c;
            if (g8 != null) {
                g8.setDataSource(this$0.getContext().getApplicationContext(), uri, (Map<String, String>) null);
            }
        } catch (IOException unused) {
            G8 g82 = this$0.c;
            if (g82 != null) {
                g82.f2294a = -1;
            }
            if (g82 == null) {
                return;
            }
            g82.b = -1;
        }
    }

    public final boolean a() {
        int i;
        G8 g8 = this.c;
        return g8 == null || !((i = g8.f2294a) == -1 || i == 0 || i == 1);
    }

    public final void a(int i) {
        if (this.t || 4 == getState()) {
            return;
        }
        if (this.s == null) {
            this.s = new Handler(Looper.getMainLooper());
        }
        if (i > 0) {
            this.t = true;
            c();
            Handler handler = this.s;
            if (handler != null) {
                handler.postDelayed(new Runnable() { // from class: com.inmobi.media.l9$$ExternalSyntheticLambda9
                    @Override // java.lang.Runnable
                    public final void run() {
                        C2747l9.e(C2747l9.this);
                    }
                }, i * 1000);
                return;
            }
            return;
        }
        pause();
    }

    public final void a(int i, int i2) {
        if (this.c != null) {
            ViewParent parent = getParent();
            C2763m9 c2763m9 = parent instanceof C2763m9 ? (C2763m9) parent : null;
            ProgressBar progressBar = c2763m9 != null ? c2763m9.getProgressBar() : null;
            if (progressBar != null) {
                progressBar.setVisibility(i);
            }
            ViewParent parent2 = getParent();
            C2763m9 c2763m92 = parent2 instanceof C2763m9 ? (C2763m9) parent2 : null;
            ImageView posterImage = c2763m92 != null ? c2763m92.getPosterImage() : null;
            if (posterImage == null) {
                return;
            }
            posterImage.setVisibility(i2);
        }
    }
}
