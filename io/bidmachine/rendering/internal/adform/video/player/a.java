package io.bidmachine.rendering.internal.adform.video.player;

import android.net.Uri;
import io.bidmachine.rendering.internal.n;
import io.bidmachine.rendering.model.Error;
import io.bidmachine.rendering.utils.UiUtils;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/* loaded from: classes8.dex */
public abstract class a implements b {
    private d f;
    private Uri i;
    private long k;
    private volatile boolean g = false;
    private volatile boolean h = false;
    private long j = -1;

    /* renamed from: a, reason: collision with root package name */
    private final C0610a f6952a = new C0610a(16);
    private final AtomicBoolean b = new AtomicBoolean(false);
    private final AtomicBoolean c = new AtomicBoolean(false);
    private final AtomicBoolean d = new AtomicBoolean(false);
    private final AtomicLong e = new AtomicLong(-1);

    /* renamed from: io.bidmachine.rendering.internal.adform.video.player.a$a, reason: collision with other inner class name */
    private class C0610a implements n {

        /* renamed from: a, reason: collision with root package name */
        private final AtomicBoolean f6953a = new AtomicBoolean(false);
        private final AtomicInteger b = new AtomicInteger(0);
        private final int c;

        public C0610a(int updateTimeMs) {
            this.c = updateTimeMs;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void d() {
            this.f6953a.set(false);
            UiUtils.cancelOnUiThread(this);
        }

        @Override // io.bidmachine.util.SafeRunnable
        public void onRun() {
            if (this.f6953a.get()) {
                if (a.this.D()) {
                    a();
                }
                a aVar = a.this;
                aVar.b(aVar.p());
                UiUtils.onUiThread(this, this.c);
            }
        }

        private void a() {
            if (a.this.p() == null) {
                return;
            }
            long g = a.this.g();
            if (g <= 0) {
                return;
            }
            float longValue = (r0.longValue() * 100.0f) / g;
            int i = this.b.get();
            if (longValue > (i * 25.0f) - 1.0f) {
                if (i == 0) {
                    a.this.M();
                } else if (i == 1) {
                    a.this.K();
                } else if (i == 2) {
                    a.this.L();
                } else if (i == 3) {
                    a.this.N();
                } else if (i == 4) {
                    a.this.J();
                }
                this.b.incrementAndGet();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b() {
            this.b.set(0);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void c() {
            d();
            this.f6953a.set(true);
            UiUtils.onUiThread(this);
        }
    }

    private void P() {
        try {
            this.j = v();
        } catch (Exception unused) {
        }
    }

    private d q() {
        return this.f;
    }

    protected void A() {
        j();
    }

    protected void B() {
        l();
    }

    protected void C() {
        m();
    }

    public boolean D() {
        try {
            return x();
        } catch (Exception unused) {
            return false;
        }
    }

    public boolean E() {
        try {
            return y();
        } catch (Exception unused) {
            return false;
        }
    }

    protected void F() {
        d q;
        if (this.d.get() || (q = q()) == null) {
            return;
        }
        q.c(this);
    }

    protected void G() {
        d q;
        if (this.d.get() || (q = q()) == null) {
            return;
        }
        q.d(this);
    }

    protected void H() {
        d q;
        if (this.d.get() || (q = q()) == null) {
            return;
        }
        q.b(this);
    }

    protected void I() {
        d q;
        if (this.b.compareAndSet(false, true) && (q = q()) != null) {
            q.f(this);
        }
    }

    protected void J() {
        d q;
        if (this.d.compareAndSet(false, true) && (q = q()) != null) {
            q.i(this);
        }
    }

    protected void K() {
        d q;
        if (this.d.get() || (q = q()) == null) {
            return;
        }
        q.a(this);
    }

    protected void L() {
        d q;
        if (this.d.get() || (q = q()) == null) {
            return;
        }
        q.h(this);
    }

    protected void M() {
        d q;
        if (this.d.get() || (q = q()) == null) {
            return;
        }
        q.g(this);
    }

    protected void N() {
        d q;
        if (this.d.get() || (q = q()) == null) {
            return;
        }
        q.e(this);
    }

    protected void O() {
        if (this.d.get()) {
            return;
        }
        this.f6952a.c();
    }

    protected abstract void a(float volume);

    protected abstract void a(long positionMs);

    @Override // io.bidmachine.rendering.internal.adform.video.player.b
    public void a(d playerListener) {
        this.f = playerListener;
    }

    protected abstract long b();

    protected abstract void b(Uri videoUri);

    @Override // io.bidmachine.rendering.internal.q
    public void b(Integer senderId) {
        e(0.0f);
    }

    protected abstract long c();

    public void c(long positionMs) {
        try {
            b(positionMs);
        } catch (Exception unused) {
        }
    }

    protected abstract float d();

    protected void d(float volume) {
        d q;
        if (this.d.get() || (q = q()) == null) {
            return;
        }
        q.a(this, volume);
    }

    public void e(float volume) {
        try {
            c(volume);
        } catch (Exception unused) {
        }
    }

    protected void f(float volume) {
        if (volume == 0.0f && !this.g) {
            this.g = true;
            a(true);
        } else if (this.g) {
            this.g = false;
            a(false);
        }
    }

    protected abstract boolean f();

    @Override // io.bidmachine.rendering.internal.adform.video.player.b
    public long g() {
        return this.j;
    }

    @Override // io.bidmachine.rendering.internal.adform.video.player.b
    public float getVolume() {
        try {
            return w();
        } catch (Exception unused) {
            return 0.0f;
        }
    }

    protected abstract boolean h();

    protected abstract void i();

    protected abstract void j();

    @Override // io.bidmachine.rendering.internal.t
    public void k() {
        try {
            this.d.set(false);
            this.f6952a.b();
            a((Long) 0L);
        } catch (Exception e) {
            b(e);
        }
    }

    protected abstract void l();

    protected abstract void m();

    protected void o() {
        this.f6952a.d();
    }

    public Long p() {
        try {
            return Long.valueOf(u());
        } catch (Exception unused) {
            return null;
        }
    }

    @Override // io.bidmachine.rendering.internal.adform.video.player.b
    public void pause() {
        try {
            this.c.set(false);
            z();
            this.k = u();
        } catch (Exception unused) {
        }
    }

    @Override // io.bidmachine.rendering.internal.adform.video.player.b
    public void play() {
        try {
            this.h = true;
            a(this.d.get() ? Long.valueOf(g()) : null);
        } catch (Exception e) {
            b(e);
        }
    }

    @Override // io.bidmachine.rendering.internal.adform.video.player.b
    public void prepare() {
        try {
            B();
        } catch (Exception e) {
            c(e);
        }
    }

    protected void r() {
        F();
        o();
    }

    protected void s() {
        H();
        O();
    }

    protected void t() {
        P();
        if (this.c.compareAndSet(true, false)) {
            a(true, Long.valueOf(this.k));
        }
        I();
    }

    protected long u() {
        return b();
    }

    protected long v() {
        return c();
    }

    protected float w() {
        return d();
    }

    protected boolean x() {
        return f();
    }

    protected boolean y() {
        return h();
    }

    protected void z() {
        i();
    }

    @Override // io.bidmachine.rendering.internal.adform.video.player.b
    public void a(Uri videoUri) {
        try {
            c(videoUri);
            this.i = videoUri;
        } catch (Exception unused) {
        }
    }

    protected void b(long positionMs) {
        a(positionMs);
    }

    protected void c(Uri videoUri) {
        b(videoUri);
    }

    @Override // io.bidmachine.rendering.internal.w
    public void e() {
        if (!this.h || this.d.get()) {
            return;
        }
        pause();
        c(g());
        G();
    }

    protected void b(float volume) {
        f(volume);
        d(volume);
    }

    protected void c(float volume) {
        a(volume);
    }

    @Override // io.bidmachine.rendering.internal.q
    public void a(Integer senderId) {
        e(1.0f);
    }

    protected void c(Throwable throwable) {
        c(Error.create(throwable));
    }

    @Override // io.bidmachine.rendering.internal.adform.video.player.b
    public void a() {
        this.f = null;
        o();
    }

    protected void b(Throwable throwable) {
        b(Error.create(throwable));
    }

    protected void c(Error error) {
        d q;
        if (this.d.get() || (q = q()) == null) {
            return;
        }
        q.b(this, error);
    }

    protected void b(Error error) {
        if (this.d.get()) {
            return;
        }
        d q = q();
        if (q != null) {
            q.a(this, error);
        }
        J();
    }

    protected void a(Throwable throwable) {
        a(Error.create(throwable));
    }

    protected void a(Error error) {
        if (this.h) {
            b(error);
        } else {
            c(error);
        }
    }

    protected void a(boolean isMuted) {
        d q;
        if (this.d.get() || (q = q()) == null) {
            return;
        }
        q.a(this, isMuted);
    }

    protected void b(Long currentPositionMs) {
        d q;
        if (currentPositionMs == null || this.e.getAndSet(currentPositionMs.longValue()) == currentPositionMs.longValue() || this.d.get() || (q = q()) == null) {
            return;
        }
        q.a((b) this, currentPositionMs.longValue());
    }

    private void a(Long positionMs) {
        this.c.set(true);
        a(E(), positionMs);
    }

    private void a(boolean isReadyToPlay, Long positionMs) {
        if (positionMs != null) {
            try {
                this.k = positionMs.longValue();
            } catch (Exception e) {
                a(e);
                return;
            }
        }
        if (isReadyToPlay) {
            if (positionMs != null) {
                c(positionMs.longValue());
            }
            A();
        } else {
            C();
            Uri uri = this.i;
            if (uri != null) {
                c(uri);
            }
            B();
        }
    }
}
