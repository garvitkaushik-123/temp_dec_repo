package io.bidmachine.rendering.internal;

import io.bidmachine.rendering.utils.UiUtils;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes8.dex */
public abstract class y implements v, q, t, s, x, w, g {

    /* renamed from: a, reason: collision with root package name */
    private final io.bidmachine.rendering.internal.event.b f7121a;
    private final List<b> b = new CopyOnWriteArrayList();

    class a extends b {
        a() {
            super(null);
        }

        @Override // io.bidmachine.util.SafeRunnable
        public void onRun() {
            y.this.o().h();
            y.this.b.remove(this);
        }
    }

    private static abstract class b implements n {

        /* renamed from: a, reason: collision with root package name */
        private long f7122a;
        private long b;

        private b() {
        }

        private long c() {
            return Math.max(this.b - System.currentTimeMillis(), 0L);
        }

        public void a(long timeMs) {
            this.f7122a = timeMs;
            this.b = System.currentTimeMillis() + timeMs;
            b();
        }

        public void b() {
            long j = this.f7122a;
            if (j > 0) {
                UiUtils.onUiThread(this, j);
            } else {
                UiUtils.onUiThread(this);
            }
        }

        /* synthetic */ b(a aVar) {
            this();
        }

        public void a() {
            this.f7122a = c();
            UiUtils.cancelOnUiThread(this);
        }
    }

    public y(io.bidmachine.rendering.internal.event.b eventCallback) {
        this.f7121a = eventCallback;
    }

    public void a(long maxProgressMs, long currentProgressMs, float percent) {
    }

    public void a(Integer senderId) {
    }

    public void a(String value) {
    }

    public void b() {
    }

    public void b(Integer senderId) {
    }

    public void e() {
    }

    public void k() {
    }

    @Override // io.bidmachine.rendering.internal.v
    public void l() {
        Iterator<b> it = this.b.iterator();
        while (it.hasNext()) {
            it.next().b();
        }
    }

    public io.bidmachine.rendering.internal.event.b o() {
        return this.f7121a;
    }

    public abstract String p();

    @Override // io.bidmachine.rendering.internal.v
    public void pause() {
        Iterator<b> it = this.b.iterator();
        while (it.hasNext()) {
            it.next().a();
        }
    }

    @Override // io.bidmachine.rendering.internal.v
    public void a(long timeMs) {
        a aVar = new a();
        this.b.add(aVar);
        aVar.a(timeMs);
    }

    public void a() {
        Iterator<b> it = this.b.iterator();
        while (it.hasNext()) {
            it.next().a();
        }
        this.b.clear();
    }
}
