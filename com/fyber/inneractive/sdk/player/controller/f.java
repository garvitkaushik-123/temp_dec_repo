package com.fyber.inneractive.sdk.player.controller;

import android.content.Context;
import android.media.AudioManager;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.view.Surface;
import com.fyber.inneractive.sdk.config.IAConfigManager;
import com.fyber.inneractive.sdk.player.exoplayer2.audio.MediaCodecAudioRenderer;
import com.fyber.inneractive.sdk.player.exoplayer2.video.MediaCodecVideoRenderer;
import com.fyber.inneractive.sdk.util.IAlog;
import java.io.File;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes4.dex */
public final class f extends q {
    public final boolean A;
    public final CopyOnWriteArrayList B;
    public com.fyber.inneractive.sdk.player.exoplayer2.source.u C;
    public boolean D;
    public int E;
    public final int p;
    public final com.fyber.inneractive.sdk.config.global.r q;
    public final int r;
    public com.fyber.inneractive.sdk.player.exoplayer2.g s;
    public int t;
    public int u;
    public boolean v;
    public com.fyber.inneractive.sdk.player.exoplayer2.a[] w;
    public Handler x;
    public b0 y;
    public boolean z;

    public f(Context context, boolean z, com.fyber.inneractive.sdk.config.global.r rVar) {
        super(context);
        Integer a2;
        this.t = 0;
        this.u = 0;
        this.v = false;
        this.z = false;
        this.B = new CopyOnWriteArrayList();
        this.C = null;
        this.E = 0;
        this.A = z;
        this.q = rVar;
        this.r = IAConfigManager.O.u.b.a("extractor_source_retry_count", 6, 3);
        com.fyber.inneractive.sdk.config.global.features.u uVar = rVar != null ? (com.fyber.inneractive.sdk.config.global.features.u) rVar.a(com.fyber.inneractive.sdk.config.global.features.u.class) : null;
        this.p = (uVar == null || (a2 = uVar.a("max_tries")) == null) ? 0 : a2.intValue();
        IAlog.a("Creating IAExoPlayer2Controller", new Object[0]);
    }

    @Override // com.fyber.inneractive.sdk.player.controller.q
    public final void a() {
        if (this.s != null) {
            if (!this.z) {
                this.z = true;
                com.fyber.inneractive.sdk.util.r.f1777a.execute(new e(this));
            }
            b0 b0Var = this.y;
            if (b0Var != null) {
                b0Var.f1356a.clear();
            }
            this.y = null;
        }
        Iterator it = this.B.iterator();
        if (it.hasNext()) {
            it.next().getClass();
            throw new ClassCastException();
        }
        this.B.clear();
        super.a();
    }

    @Override // com.fyber.inneractive.sdk.player.controller.q
    public final void b(boolean z) {
        com.fyber.inneractive.sdk.player.exoplayer2.g gVar;
        this.n = z;
        com.fyber.inneractive.sdk.player.exoplayer2.a[] aVarArr = this.w;
        if (aVarArr == null || (gVar = this.s) == null || this.z || aVarArr.length < 2) {
            return;
        }
        gVar.a(new com.fyber.inneractive.sdk.player.exoplayer2.e(aVarArr[1], 2, Float.valueOf(0.0f)));
        this.v = true;
        c(true);
    }

    @Override // com.fyber.inneractive.sdk.player.controller.q
    public final int c() {
        com.fyber.inneractive.sdk.player.exoplayer2.g gVar = this.s;
        if (gVar == null || this.z) {
            return 0;
        }
        return (int) (gVar.m.c() ? -9223372036854775807L : com.fyber.inneractive.sdk.player.exoplayer2.b.a(gVar.m.a(gVar.a(), gVar.f).f));
    }

    @Override // com.fyber.inneractive.sdk.player.controller.q
    public final void d(boolean z) {
        this.n = z;
        if (this.s == null || this.z) {
            return;
        }
        AudioManager audioManager = (AudioManager) this.f1370a.getSystemService("audio");
        int streamVolume = audioManager.getStreamVolume(3);
        int streamMaxVolume = audioManager.getStreamMaxVolume(3);
        float f = streamVolume / streamMaxVolume;
        IAlog.a(" unmute maxVolume = %d currentVolume = %d targetVolume = %s", Integer.valueOf(streamMaxVolume), Integer.valueOf(streamVolume), Float.valueOf(f));
        if (streamVolume == 0) {
            IAlog.a("Avoided unmute - Device is muted", new Object[0]);
            return;
        }
        com.fyber.inneractive.sdk.player.exoplayer2.a[] aVarArr = this.w;
        if (aVarArr != null && aVarArr.length >= 2) {
            this.s.a(new com.fyber.inneractive.sdk.player.exoplayer2.e(aVarArr[1], 2, Float.valueOf(f)));
        }
        this.v = false;
        c(false);
    }

    @Override // com.fyber.inneractive.sdk.player.controller.q
    public final int e() {
        return this.u;
    }

    @Override // com.fyber.inneractive.sdk.player.controller.q
    public final int f() {
        return this.t;
    }

    @Override // com.fyber.inneractive.sdk.player.controller.q
    public final boolean g() {
        return this.v;
    }

    @Override // com.fyber.inneractive.sdk.player.controller.q
    public final boolean h() {
        return (this.s == null || this.z || this.e != com.fyber.inneractive.sdk.player.enums.b.Playing) ? false : true;
    }

    @Override // com.fyber.inneractive.sdk.player.controller.q
    public final void i() {
        com.fyber.inneractive.sdk.player.enums.b bVar;
        com.fyber.inneractive.sdk.player.enums.b bVar2 = this.e;
        if (bVar2 == com.fyber.inneractive.sdk.player.enums.b.Idle || bVar2 == com.fyber.inneractive.sdk.player.enums.b.Completed || bVar2 == (bVar = com.fyber.inneractive.sdk.player.enums.b.Paused) || bVar2 == com.fyber.inneractive.sdk.player.enums.b.Prepared) {
            IAlog.a("%s paused called when player is in mState: %s ignoring", IAlog.a(this), bVar2);
            return;
        }
        com.fyber.inneractive.sdk.player.exoplayer2.g gVar = this.s;
        if (gVar != null && !this.z) {
            gVar.a(false);
        }
        k();
        a(bVar);
    }

    @Override // com.fyber.inneractive.sdk.player.controller.q
    public final void j() {
        IAlog.a("%sstart called", IAlog.a(this));
        if (h()) {
            return;
        }
        a(com.fyber.inneractive.sdk.player.enums.b.Start_in_progress);
        this.s.a(true);
    }

    @Override // com.fyber.inneractive.sdk.player.controller.q
    public final int b() {
        long j;
        com.fyber.inneractive.sdk.player.exoplayer2.g gVar = this.s;
        if (gVar == null || this.z) {
            return 0;
        }
        if (!gVar.m.c() && gVar.k <= 0) {
            gVar.m.a(gVar.q.f1510a, gVar.g, false);
            j = com.fyber.inneractive.sdk.player.exoplayer2.b.a(gVar.q.c) + com.fyber.inneractive.sdk.player.exoplayer2.b.a(gVar.g.e);
        } else {
            j = gVar.s;
        }
        return (int) j;
    }

    @Override // com.fyber.inneractive.sdk.player.controller.q
    public final void a(int i, boolean z) {
        IAlog.a("%sseekTo called with %d playAfterSeek = %s", IAlog.a(this), Integer.valueOf(i), Boolean.valueOf(z));
        com.fyber.inneractive.sdk.player.exoplayer2.g gVar = this.s;
        if (gVar == null || this.z) {
            return;
        }
        gVar.a(z);
        com.fyber.inneractive.sdk.player.exoplayer2.g gVar2 = this.s;
        gVar2.a(gVar2.a(), i);
    }

    @Override // com.fyber.inneractive.sdk.player.controller.q
    public final String d() {
        return this.A ? "exo_c" : "exo";
    }

    @Override // com.fyber.inneractive.sdk.player.controller.q
    public final void a(Surface surface) {
        com.fyber.inneractive.sdk.player.exoplayer2.g gVar;
        IAlog.a("%ssetSurface called with %s", IAlog.a(this), surface);
        com.fyber.inneractive.sdk.player.exoplayer2.a[] aVarArr = this.w;
        if (aVarArr == null || (gVar = this.s) == null || this.z) {
            return;
        }
        gVar.a(new com.fyber.inneractive.sdk.player.exoplayer2.e(aVarArr[0], 1, surface));
    }

    @Override // com.fyber.inneractive.sdk.player.controller.q
    public final void a(boolean z) {
        if (this.s != null || this.z) {
            return;
        }
        this.D = z;
        IAlog.a("%sMediaPlayerController: creating media player", IAlog.a(this));
        b0 b0Var = this.y;
        if (b0Var != null) {
            b0Var.f1356a.clear();
        }
        this.y = new b0(this);
        this.x = new Handler(Looper.getMainLooper());
        com.fyber.inneractive.sdk.player.exoplayer2.a[] aVarArr = new com.fyber.inneractive.sdk.player.exoplayer2.a[z ? 2 : 1];
        this.w = aVarArr;
        aVarArr[0] = new MediaCodecVideoRenderer(this.x, this.y);
        if (z) {
            this.w[1] = new MediaCodecAudioRenderer();
        }
        com.fyber.inneractive.sdk.player.exoplayer2.g gVar = new com.fyber.inneractive.sdk.player.exoplayer2.g(this.w, new com.fyber.inneractive.sdk.player.exoplayer2.trackselection.d(), new com.fyber.inneractive.sdk.player.exoplayer2.c());
        this.s = gVar;
        gVar.e.add(this.y);
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x00b0  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00ad  */
    @Override // com.fyber.inneractive.sdk.player.controller.q
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void a(String str, int i) {
        char c;
        File a2;
        com.fyber.inneractive.sdk.player.exoplayer2.upstream.g gVar;
        com.fyber.inneractive.sdk.player.exoplayer2.upstream.g fVar;
        com.fyber.inneractive.sdk.player.exoplayer2.source.u jVar;
        if (this.s == null || this.z) {
            return;
        }
        IAlog.a("%sloadMediaPlayerUri called with %s", IAlog.a(this), str);
        Uri parse = Uri.parse(str);
        int i2 = com.fyber.inneractive.sdk.player.exoplayer2.util.z.f1599a;
        String path = parse.getPath();
        if (path != null) {
            String lowerCase = path.toLowerCase();
            if (lowerCase.endsWith(".mpd")) {
                c = 0;
            } else if (lowerCase.endsWith(".m3u8")) {
                c = 2;
            } else if (lowerCase.endsWith(".ism") || lowerCase.endsWith(".isml") || lowerCase.endsWith(".ism/manifest") || lowerCase.endsWith(".isml/manifest")) {
                c = 1;
            }
            if (!this.A && com.fyber.inneractive.sdk.player.cache.m.f.c && com.fyber.inneractive.sdk.util.s.a() && c != 2) {
                fVar = new com.fyber.inneractive.sdk.player.cache.h(this, i, this.q);
            } else {
                com.fyber.inneractive.sdk.player.exoplayer2.upstream.m mVar = new com.fyber.inneractive.sdk.player.exoplayer2.upstream.m();
                com.fyber.inneractive.sdk.player.exoplayer2.upstream.o oVar = new com.fyber.inneractive.sdk.player.exoplayer2.upstream.o(this.f1370a, mVar, new com.fyber.inneractive.sdk.player.exoplayer2.upstream.q(IAConfigManager.O.y.a(), mVar));
                a2 = com.fyber.inneractive.sdk.player.cache.m.a(this.f1370a, "ia-vid-cache-ex2");
                if (a2 == null) {
                    fVar = new com.fyber.inneractive.sdk.player.exoplayer2.upstream.cache.f(new com.fyber.inneractive.sdk.player.exoplayer2.upstream.cache.l(a2, new com.fyber.inneractive.sdk.player.exoplayer2.upstream.cache.j()), oVar);
                } else {
                    gVar = oVar;
                    if (c == 2) {
                        jVar = new com.fyber.inneractive.sdk.player.exoplayer2.source.q(parse, gVar, new com.fyber.inneractive.sdk.player.exoplayer2.extractor.c(), this.r, this.x, this.y);
                    } else {
                        jVar = new com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.j(parse, gVar, this.x, this.y);
                    }
                    this.C = jVar;
                    a(jVar);
                    return;
                }
            }
            gVar = fVar;
            if (c == 2) {
            }
            this.C = jVar;
            a(jVar);
            return;
        }
        c = 3;
        if (!this.A) {
        }
        com.fyber.inneractive.sdk.player.exoplayer2.upstream.m mVar2 = new com.fyber.inneractive.sdk.player.exoplayer2.upstream.m();
        com.fyber.inneractive.sdk.player.exoplayer2.upstream.o oVar2 = new com.fyber.inneractive.sdk.player.exoplayer2.upstream.o(this.f1370a, mVar2, new com.fyber.inneractive.sdk.player.exoplayer2.upstream.q(IAConfigManager.O.y.a(), mVar2));
        a2 = com.fyber.inneractive.sdk.player.cache.m.a(this.f1370a, "ia-vid-cache-ex2");
        if (a2 == null) {
        }
    }

    public final void a(com.fyber.inneractive.sdk.player.exoplayer2.source.u uVar) {
        com.fyber.inneractive.sdk.player.exoplayer2.g gVar = this.s;
        if (gVar == null || uVar == null) {
            return;
        }
        if (!gVar.m.c() || gVar.n != null) {
            gVar.m = com.fyber.inneractive.sdk.player.exoplayer2.x.f1616a;
            gVar.n = null;
            Iterator it = gVar.e.iterator();
            while (it.hasNext()) {
                ((b0) it.next()).getClass();
            }
        }
        if (gVar.h) {
            gVar.h = false;
            int i = com.fyber.inneractive.sdk.player.exoplayer2.source.z.d;
            gVar.o = gVar.b;
            ((com.fyber.inneractive.sdk.player.exoplayer2.trackselection.g) gVar.f1508a).getClass();
            Iterator it2 = gVar.e.iterator();
            while (it2.hasNext()) {
                ((b0) it2.next()).getClass();
            }
        }
        gVar.l++;
        gVar.d.f.obtainMessage(0, 1, 0, uVar).sendToTarget();
        a(com.fyber.inneractive.sdk.player.enums.b.Preparing);
    }
}
