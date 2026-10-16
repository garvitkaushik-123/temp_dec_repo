package com.fyber.inneractive.sdk.player.exoplayer2.video;

import android.graphics.Point;
import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Handler;
import android.os.SystemClock;
import android.util.Log;
import android.view.Surface;
import com.fyber.inneractive.sdk.player.exoplayer2.decoder.DecoderCounters;
import com.fyber.inneractive.sdk.player.exoplayer2.util.w;
import com.fyber.inneractive.sdk.player.exoplayer2.util.z;
import com.fyber.inneractive.sdk.player.exoplayer2.video.VideoRendererEventListener;
import com.ironsource.C3040d4;
import com.unity3d.services.core.di.ServiceProvider;
import io.bidmachine.iab.vast.tags.VastAttributes;
import java.nio.ByteBuffer;

/* loaded from: classes4.dex */
public class MediaCodecVideoRenderer extends com.fyber.inneractive.sdk.player.exoplayer2.mediacodec.c {
    public static final int[] q0 = {1920, 1600, 1440, 1280, 960, 854, 640, 540, 480};
    public final h P;
    public final VideoRendererEventListener.EventDispatcher Q;
    public final long R;
    public final int S;
    public final boolean T;
    public com.fyber.inneractive.sdk.player.exoplayer2.o[] U;
    public e V;
    public Surface W;
    public int X;
    public boolean Y;
    public long Z;
    public long a0;
    public int b0;
    public int c0;
    public int d0;
    public float e0;
    public int f0;
    public int g0;
    public int h0;
    public float i0;
    public int j0;
    public int k0;
    public int l0;
    public float m0;
    public boolean n0;
    public int o0;
    public f p0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MediaCodecVideoRenderer(Handler handler, VideoRendererEventListener videoRendererEventListener) {
        super(2, false);
        boolean z = false;
        this.R = 5000L;
        this.S = -1;
        this.P = new h();
        this.Q = new VideoRendererEventListener.EventDispatcher(handler, videoRendererEventListener);
        if (z.f1599a <= 22 && "foster".equals(z.b) && "NVIDIA".equals(z.c)) {
            z = true;
        }
        this.T = z;
        this.Z = -9223372036854775807L;
        this.f0 = -1;
        this.g0 = -1;
        this.i0 = -1.0f;
        this.e0 = -1.0f;
        this.X = 1;
        this.j0 = -1;
        this.k0 = -1;
        this.m0 = -1.0f;
        this.l0 = -1;
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.a
    public final void a(com.fyber.inneractive.sdk.player.exoplayer2.o[] oVarArr) {
        this.U = oVarArr;
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.mediacodec.c
    public final int b(com.fyber.inneractive.sdk.player.exoplayer2.mediacodec.d dVar, com.fyber.inneractive.sdk.player.exoplayer2.o oVar) {
        boolean z;
        int i;
        int i2;
        String str = oVar.f;
        if (!"video".equals(com.fyber.inneractive.sdk.player.exoplayer2.util.i.b(str))) {
            return 0;
        }
        com.fyber.inneractive.sdk.player.exoplayer2.drm.d dVar2 = oVar.i;
        if (dVar2 != null) {
            z = false;
            for (int i3 = 0; i3 < dVar2.c; i3++) {
                z |= dVar2.f1402a[i3].e;
            }
        } else {
            z = false;
        }
        dVar.getClass();
        com.fyber.inneractive.sdk.player.exoplayer2.mediacodec.a a2 = com.fyber.inneractive.sdk.player.exoplayer2.mediacodec.j.a(z, str);
        if (a2 == null) {
            return 1;
        }
        boolean a3 = a2.a(oVar.c);
        if (a3 && (i = oVar.j) > 0 && (i2 = oVar.k) > 0) {
            if (z.f1599a >= 21) {
                a3 = a2.a(i, i2, oVar.l);
            } else {
                boolean z2 = i * i2 <= com.fyber.inneractive.sdk.player.exoplayer2.mediacodec.j.a();
                if (!z2) {
                    Log.d("MediaCodecVideoRenderer", "FalseCheck [legacyFrameSize, " + oVar.j + VastAttributes.HORIZONTAL_POSITION + oVar.k + "] [" + z.e + C3040d4.i.e);
                }
                a3 = z2;
            }
        }
        return (a3 ? 3 : 2) | (a2.b ? 8 : 4) | (a2.c ? 16 : 0);
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.mediacodec.c, com.fyber.inneractive.sdk.player.exoplayer2.a
    public final boolean f() {
        if ((this.Y || super.q()) && super.f()) {
            this.Z = -9223372036854775807L;
            return true;
        }
        if (this.Z == -9223372036854775807L) {
            return false;
        }
        if (SystemClock.elapsedRealtime() < this.Z) {
            return true;
        }
        this.Z = -9223372036854775807L;
        return false;
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.a
    public final void g() {
        this.f0 = -1;
        this.g0 = -1;
        this.i0 = -1.0f;
        this.e0 = -1.0f;
        this.j0 = -1;
        this.k0 = -1;
        this.m0 = -1.0f;
        this.l0 = -1;
        r();
        h hVar = this.P;
        if (hVar.b) {
            hVar.f1607a.b.sendEmptyMessage(2);
        }
        this.p0 = null;
        try {
            this.n = null;
            o();
        } finally {
            this.N.ensureUpdated();
            this.Q.disabled(this.N);
        }
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.a
    public final void h() {
        DecoderCounters decoderCounters = new DecoderCounters();
        this.N = decoderCounters;
        int i = this.b.f1545a;
        this.o0 = i;
        this.n0 = i != 0;
        this.Q.enabled(decoderCounters);
        h hVar = this.P;
        hVar.h = false;
        if (hVar.b) {
            hVar.f1607a.b.sendEmptyMessage(1);
        }
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.a
    public final void i() {
        this.b0 = 0;
        this.a0 = SystemClock.elapsedRealtime();
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.a
    public final void j() {
        this.Z = -9223372036854775807L;
        if (this.b0 > 0) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            this.Q.droppedFrames(this.b0, elapsedRealtime - this.a0);
            this.b0 = 0;
            this.a0 = elapsedRealtime;
        }
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.mediacodec.c
    public final void m() {
        if (z.f1599a >= 23 || !this.n0 || this.Y) {
            return;
        }
        this.Y = true;
        this.Q.renderedFirstFrame(this.W);
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.mediacodec.c
    public final boolean q() {
        Surface surface;
        return super.q() && (surface = this.W) != null && surface.isValid();
    }

    public final void r() {
        MediaCodec mediaCodec;
        this.Y = false;
        if (z.f1599a < 23 || !this.n0 || (mediaCodec = this.o) == null) {
            return;
        }
        this.p0 = new f(this, mediaCodec);
    }

    public final void s() {
        int i = this.f0;
        if (i == -1 && this.g0 == -1) {
            return;
        }
        if (this.j0 == i && this.k0 == this.g0 && this.l0 == this.h0 && this.m0 == this.i0) {
            return;
        }
        this.Q.videoSizeChanged(i, this.g0, this.h0, this.i0);
        this.j0 = this.f0;
        this.k0 = this.g0;
        this.l0 = this.h0;
        this.m0 = this.i0;
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.mediacodec.c, com.fyber.inneractive.sdk.player.exoplayer2.a
    public final void a(boolean z, long j) {
        super.a(z, j);
        r();
        this.c0 = 0;
        if (z) {
            this.Z = this.R > 0 ? SystemClock.elapsedRealtime() + this.R : -9223372036854775807L;
        } else {
            this.Z = -9223372036854775807L;
        }
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.a
    public final void a(int i, Object obj) {
        if (i != 1) {
            if (i == 4) {
                int intValue = ((Integer) obj).intValue();
                this.X = intValue;
                MediaCodec mediaCodec = this.o;
                if (mediaCodec != null) {
                    mediaCodec.setVideoScalingMode(intValue);
                    return;
                }
                return;
            }
            return;
        }
        Surface surface = (Surface) obj;
        if (this.W == surface) {
            if (surface != null) {
                int i2 = this.j0;
                if (i2 != -1 || this.k0 != -1) {
                    this.Q.videoSizeChanged(i2, this.k0, this.l0, this.m0);
                }
                if (this.Y) {
                    this.Q.renderedFirstFrame(this.W);
                    return;
                }
                return;
            }
            return;
        }
        this.W = surface;
        int i3 = this.c;
        if (i3 == 1 || i3 == 2) {
            MediaCodec mediaCodec2 = this.o;
            if (z.f1599a >= 23 && mediaCodec2 != null && surface != null) {
                mediaCodec2.setOutputSurface(surface);
            } else {
                o();
                l();
            }
        }
        if (surface != null) {
            int i4 = this.j0;
            if (i4 != -1 || this.k0 != -1) {
                this.Q.videoSizeChanged(i4, this.k0, this.l0, this.m0);
            }
            r();
            if (i3 == 2) {
                this.Z = this.R > 0 ? SystemClock.elapsedRealtime() + this.R : -9223372036854775807L;
                return;
            }
            return;
        }
        this.j0 = -1;
        this.k0 = -1;
        this.m0 = -1.0f;
        this.l0 = -1;
        r();
    }

    public static boolean b(boolean z, com.fyber.inneractive.sdk.player.exoplayer2.o oVar, com.fyber.inneractive.sdk.player.exoplayer2.o oVar2) {
        if (oVar.f.equals(oVar2.f)) {
            int i = oVar.m;
            if (i == -1) {
                i = 0;
            }
            int i2 = oVar2.m;
            if (i2 == -1) {
                i2 = 0;
            }
            if (i == i2) {
                if (z) {
                    return true;
                }
                if (oVar.j == oVar2.j && oVar.k == oVar2.k) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.mediacodec.c
    public final void a(com.fyber.inneractive.sdk.player.exoplayer2.mediacodec.a aVar, MediaCodec mediaCodec, com.fyber.inneractive.sdk.player.exoplayer2.o oVar) {
        e eVar;
        Point point;
        float f;
        boolean z;
        int i;
        int i2;
        com.fyber.inneractive.sdk.player.exoplayer2.o[] oVarArr = this.U;
        int i3 = oVar.j;
        int i4 = oVar.k;
        int i5 = oVar.g;
        if (i5 == -1) {
            i5 = a(oVar.f, i3, i4);
        }
        if (oVarArr.length == 1) {
            eVar = new e(i3, i4, i5);
        } else {
            boolean z2 = false;
            for (com.fyber.inneractive.sdk.player.exoplayer2.o oVar2 : oVarArr) {
                if (b(aVar.b, oVar, oVar2)) {
                    int i6 = oVar2.j;
                    z2 |= i6 == -1 || oVar2.k == -1;
                    i3 = Math.max(i3, i6);
                    i4 = Math.max(i4, oVar2.k);
                    int i7 = oVar2.g;
                    if (i7 == -1) {
                        i7 = a(oVar2.f, oVar2.j, oVar2.k);
                    }
                    i5 = Math.max(i5, i7);
                }
            }
            if (z2) {
                Log.w("MediaCodecVideoRenderer", "Resolutions unknown. Codec max resolution: " + i3 + VastAttributes.HORIZONTAL_POSITION + i4);
                int i8 = oVar.k;
                int i9 = oVar.j;
                boolean z3 = i8 > i9;
                int i10 = z3 ? i8 : i9;
                if (z3) {
                    i8 = i9;
                }
                float f2 = i8 / i10;
                int[] iArr = q0;
                int i11 = 0;
                while (i11 < 9) {
                    int i12 = iArr[i11];
                    int i13 = i11;
                    int i14 = (int) (i12 * f2);
                    if (i12 <= i10 || i14 <= i8) {
                        break;
                    }
                    int i15 = i8;
                    if (z.f1599a >= 21) {
                        point = aVar.a(z3 ? i14 : i12, z3 ? i12 : i14);
                        f = f2;
                        z = z3;
                        i = i10;
                        if (aVar.a(point.x, point.y, oVar.l)) {
                            break;
                        }
                        i11 = i13 + 1;
                        i8 = i15;
                        f2 = f;
                        z3 = z;
                        i10 = i;
                    } else {
                        f = f2;
                        z = z3;
                        i = i10;
                        int i16 = ((i12 + 15) / 16) * 16;
                        int i17 = ((i14 + 15) / 16) * 16;
                        if (i16 * i17 <= com.fyber.inneractive.sdk.player.exoplayer2.mediacodec.j.a()) {
                            int i18 = z ? i17 : i16;
                            if (!z) {
                                i16 = i17;
                            }
                            point = new Point(i18, i16);
                        } else {
                            i11 = i13 + 1;
                            i8 = i15;
                            f2 = f;
                            z3 = z;
                            i10 = i;
                        }
                    }
                }
                point = null;
                if (point != null) {
                    i3 = Math.max(i3, point.x);
                    i4 = Math.max(i4, point.y);
                    i5 = Math.max(i5, a(oVar.f, i3, i4));
                    Log.w("MediaCodecVideoRenderer", "Codec max resolution adjusted to: " + i3 + VastAttributes.HORIZONTAL_POSITION + i4);
                }
            }
            eVar = new e(i3, i4, i5);
        }
        this.V = eVar;
        boolean z4 = this.T;
        int i19 = this.o0;
        MediaFormat a2 = oVar.a();
        a2.setInteger("max-width", eVar.f1604a);
        a2.setInteger("max-height", eVar.b);
        int i20 = eVar.c;
        if (i20 != -1) {
            a2.setInteger("max-input-size", i20);
        }
        if (z4) {
            i2 = 0;
            a2.setInteger("auto-frc", 0);
        } else {
            i2 = 0;
        }
        if (i19 != 0) {
            a2.setFeatureEnabled("tunneled-playback", true);
            a2.setInteger("audio-session-id", i19);
        }
        mediaCodec.configure(a2, this.W, (MediaCrypto) null, i2);
        if (z.f1599a < 23 || !this.n0) {
            return;
        }
        this.p0 = new f(this, mediaCodec);
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.mediacodec.c
    public final void a(String str, long j, long j2) {
        this.Q.decoderInitialized(str, j, j2);
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.mediacodec.c
    public final void a(com.fyber.inneractive.sdk.player.exoplayer2.o oVar) {
        super.a(oVar);
        this.Q.inputFormatChanged(oVar);
        float f = oVar.n;
        if (f == -1.0f) {
            f = 1.0f;
        }
        this.e0 = f;
        int i = oVar.m;
        if (i == -1) {
            i = 0;
        }
        this.d0 = i;
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.mediacodec.c
    public final void a(MediaCodec mediaCodec, MediaFormat mediaFormat) {
        int integer;
        int integer2;
        boolean z = mediaFormat.containsKey("crop-right") && mediaFormat.containsKey("crop-left") && mediaFormat.containsKey("crop-bottom") && mediaFormat.containsKey("crop-top");
        if (z) {
            integer = (mediaFormat.getInteger("crop-right") - mediaFormat.getInteger("crop-left")) + 1;
        } else {
            integer = mediaFormat.getInteger("width");
        }
        this.f0 = integer;
        if (z) {
            integer2 = (mediaFormat.getInteger("crop-bottom") - mediaFormat.getInteger("crop-top")) + 1;
        } else {
            integer2 = mediaFormat.getInteger("height");
        }
        this.g0 = integer2;
        float f = this.e0;
        this.i0 = f;
        if (z.f1599a >= 21) {
            int i = this.d0;
            if (i == 90 || i == 270) {
                int i2 = this.f0;
                this.f0 = integer2;
                this.g0 = i2;
                this.i0 = 1.0f / f;
            }
        } else {
            this.h0 = this.d0;
        }
        mediaCodec.setVideoScalingMode(this.X);
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.mediacodec.c
    public final boolean a(boolean z, com.fyber.inneractive.sdk.player.exoplayer2.o oVar, com.fyber.inneractive.sdk.player.exoplayer2.o oVar2) {
        if (!b(z, oVar, oVar2)) {
            return false;
        }
        int i = oVar2.j;
        e eVar = this.V;
        return i <= eVar.f1604a && oVar2.k <= eVar.b && oVar2.g <= eVar.c;
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x0105  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x012c  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x013b  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x012f  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x014c  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0190  */
    @Override // com.fyber.inneractive.sdk.player.exoplayer2.mediacodec.c
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean a(long j, long j2, MediaCodec mediaCodec, ByteBuffer byteBuffer, int i, long j3, boolean z) {
        String str;
        long j4;
        long j5;
        g gVar;
        long j6;
        long j7;
        long j8;
        if (z) {
            w.a("skipVideoBuffer");
            mediaCodec.releaseOutputBuffer(i, false);
            w.a();
            this.N.skippedOutputBufferCount++;
            return true;
        }
        if (!this.Y) {
            if (z.f1599a >= 21) {
                long nanoTime = System.nanoTime();
                s();
                w.a("releaseOutputBuffer");
                mediaCodec.releaseOutputBuffer(i, nanoTime);
                w.a();
                this.N.renderedOutputBufferCount++;
                this.c0 = 0;
                if (!this.Y) {
                    this.Y = true;
                    this.Q.renderedFirstFrame(this.W);
                }
            } else {
                s();
                w.a("releaseOutputBuffer");
                mediaCodec.releaseOutputBuffer(i, true);
                w.a();
                this.N.renderedOutputBufferCount++;
                this.c0 = 0;
                if (!this.Y) {
                    this.Y = true;
                    this.Q.renderedFirstFrame(this.W);
                }
            }
            return true;
        }
        if (this.c != 2) {
            return false;
        }
        long elapsedRealtime = (j3 - j) - ((SystemClock.elapsedRealtime() * 1000) - j2);
        long nanoTime2 = System.nanoTime();
        long j9 = (elapsedRealtime * 1000) + nanoTime2;
        h hVar = this.P;
        long j10 = j3 * 1000;
        if (hVar.h) {
            if (j3 != hVar.e) {
                hVar.k++;
                hVar.f = hVar.g;
            }
            long j11 = hVar.k;
            if (j11 >= 6) {
                str = "releaseOutputBuffer";
                long j12 = hVar.j;
                long j13 = hVar.f + ((j10 - j12) / j11);
                if (Math.abs((j9 - hVar.i) - (j13 - j12)) > 20000000) {
                    hVar.h = false;
                } else {
                    j4 = (hVar.i + j13) - hVar.j;
                    j5 = j13;
                    if (!hVar.h) {
                        hVar.j = j10;
                        hVar.i = j9;
                        hVar.k = 0L;
                        hVar.h = true;
                    }
                    hVar.e = j3;
                    hVar.g = j5;
                    gVar = hVar.f1607a;
                    if (gVar != null && gVar.f1606a != 0) {
                        long j14 = hVar.f1607a.f1606a;
                        long j15 = hVar.c;
                        j7 = (((j4 - j14) / j15) * j15) + j14;
                        if (j4 > j7) {
                            j8 = j7 - j15;
                        } else {
                            j8 = j7;
                            j7 = j15 + j7;
                        }
                        if (j7 - j4 >= j4 - j8) {
                            j7 = j8;
                        }
                        j4 = j7 - hVar.d;
                    }
                    long j16 = j4;
                    j6 = (j16 - nanoTime2) / 1000;
                    if (j6 >= -30000) {
                        w.a("dropVideoBuffer");
                        mediaCodec.releaseOutputBuffer(i, false);
                        w.a();
                        DecoderCounters decoderCounters = this.N;
                        decoderCounters.droppedOutputBufferCount++;
                        this.b0++;
                        int i2 = this.c0 + 1;
                        this.c0 = i2;
                        decoderCounters.maxConsecutiveDroppedOutputBufferCount = Math.max(i2, decoderCounters.maxConsecutiveDroppedOutputBufferCount);
                        int i3 = this.b0;
                        if (i3 != this.S || i3 <= 0) {
                            return true;
                        }
                        long elapsedRealtime2 = SystemClock.elapsedRealtime();
                        this.Q.droppedFrames(this.b0, elapsedRealtime2 - this.a0);
                        this.b0 = 0;
                        this.a0 = elapsedRealtime2;
                        return true;
                    }
                    if (z.f1599a >= 21) {
                        if (j6 >= ServiceProvider.SCAR_SIGNALS_FETCH_TIMEOUT) {
                            return false;
                        }
                        s();
                        w.a(str);
                        mediaCodec.releaseOutputBuffer(i, j16);
                        w.a();
                        this.N.renderedOutputBufferCount++;
                        this.c0 = 0;
                        if (!this.Y) {
                            this.Y = true;
                            this.Q.renderedFirstFrame(this.W);
                        }
                        return true;
                    }
                    if (j6 >= 30000) {
                        return false;
                    }
                    if (j6 > 11000) {
                        try {
                            Thread.sleep((j6 - 10000) / 1000);
                        } catch (InterruptedException unused) {
                            Thread.currentThread().interrupt();
                        }
                    }
                    s();
                    w.a(str);
                    mediaCodec.releaseOutputBuffer(i, true);
                    w.a();
                    this.N.renderedOutputBufferCount++;
                    this.c0 = 0;
                    if (!this.Y) {
                        this.Y = true;
                        this.Q.renderedFirstFrame(this.W);
                    }
                    return true;
                }
            } else {
                str = "releaseOutputBuffer";
                if (Math.abs((j9 - hVar.i) - (j10 - hVar.j)) > 20000000) {
                    hVar.h = false;
                }
            }
        } else {
            str = "releaseOutputBuffer";
        }
        j5 = j10;
        j4 = j9;
        if (!hVar.h) {
        }
        hVar.e = j3;
        hVar.g = j5;
        gVar = hVar.f1607a;
        if (gVar != null) {
            long j142 = hVar.f1607a.f1606a;
            long j152 = hVar.c;
            j7 = (((j4 - j142) / j152) * j152) + j142;
            if (j4 > j7) {
            }
            if (j7 - j4 >= j4 - j8) {
            }
            j4 = j7 - hVar.d;
        }
        long j162 = j4;
        j6 = (j162 - nanoTime2) / 1000;
        if (j6 >= -30000) {
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static int a(String str, int i, int i2) {
        char c;
        int i3;
        if (i == -1 || i2 == -1) {
            return -1;
        }
        str.getClass();
        str.hashCode();
        int i4 = 4;
        switch (str.hashCode()) {
            case -1664118616:
                if (str.equals("video/3gpp")) {
                    c = 0;
                    break;
                }
                c = 65535;
                break;
            case -1662541442:
                if (str.equals("video/hevc")) {
                    c = 1;
                    break;
                }
                c = 65535;
                break;
            case 1187890754:
                if (str.equals("video/mp4v-es")) {
                    c = 2;
                    break;
                }
                c = 65535;
                break;
            case 1331836730:
                if (str.equals("video/avc")) {
                    c = 3;
                    break;
                }
                c = 65535;
                break;
            case 1599127256:
                if (str.equals("video/x-vnd.on2.vp8")) {
                    c = 4;
                    break;
                }
                c = 65535;
                break;
            case 1599127257:
                if (str.equals("video/x-vnd.on2.vp9")) {
                    c = 5;
                    break;
                }
                c = 65535;
                break;
            default:
                c = 65535;
                break;
        }
        switch (c) {
            case 0:
            case 2:
            case 4:
                i3 = i2 * i;
                i4 = 2;
                break;
            case 1:
            case 5:
                i3 = i2 * i;
                break;
            case 3:
                if (!"BRAVIA 4K 2015".equals(z.d)) {
                    i3 = ((i2 + 15) / 16) * ((i + 15) / 16) * 256;
                    i4 = 2;
                    break;
                }
                break;
        }
        return -1;
    }
}
