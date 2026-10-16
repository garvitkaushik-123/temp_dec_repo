package com.fyber.inneractive.sdk.player.exoplayer2.upstream;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.util.Log;
import java.io.IOException;

/* loaded from: classes4.dex */
public final class y extends Handler implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final z f1580a;
    public final x b;
    public final int c;
    public final long d;
    public IOException e;
    public int f;
    public volatile Thread g;
    public volatile boolean h;
    public final /* synthetic */ b0 i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public y(b0 b0Var, Looper looper, z zVar, x xVar, int i, long j) {
        super(looper);
        this.i = b0Var;
        this.f1580a = zVar;
        this.b = xVar;
        this.c = i;
        this.d = j;
    }

    public final void a(boolean z) {
        this.h = z;
        this.e = null;
        if (hasMessages(0)) {
            removeMessages(0);
            if (!z) {
                sendEmptyMessage(1);
            }
        } else {
            this.f1580a.b();
            if (this.g != null) {
                this.g.interrupt();
            }
        }
        if (z) {
            this.i.b = null;
            long elapsedRealtime = SystemClock.elapsedRealtime();
            this.b.a(this.f1580a, elapsedRealtime, elapsedRealtime - this.d, true);
        }
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        if (this.h) {
            return;
        }
        int i = message.what;
        if (i == 0) {
            this.e = null;
            b0 b0Var = this.i;
            b0Var.f1553a.execute(b0Var.b);
            return;
        }
        if (i == 4) {
            throw ((Error) message.obj);
        }
        this.i.b = null;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        long j = elapsedRealtime - this.d;
        if (this.f1580a.a()) {
            this.b.a(this.f1580a, elapsedRealtime, j, false);
            return;
        }
        int i2 = message.what;
        if (i2 == 1) {
            this.b.a(this.f1580a, elapsedRealtime, j, false);
            return;
        }
        if (i2 == 2) {
            this.b.a(this.f1580a, elapsedRealtime, j);
            return;
        }
        if (i2 != 3) {
            return;
        }
        IOException iOException = (IOException) message.obj;
        this.e = iOException;
        int a2 = this.b.a(this.f1580a, elapsedRealtime, j, iOException);
        if (a2 == 3) {
            this.i.c = this.e;
            return;
        }
        if (a2 != 2) {
            int i3 = a2 == 1 ? 1 : this.f + 1;
            this.f = i3;
            long min = Math.min((i3 - 1) * 1000, 5000);
            b0 b0Var2 = this.i;
            if (b0Var2.b != null) {
                throw new IllegalStateException();
            }
            b0Var2.b = this;
            if (min > 0) {
                sendEmptyMessageDelayed(0, min);
            } else {
                this.e = null;
                b0Var2.f1553a.execute(this);
            }
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            this.g = Thread.currentThread();
            if (!this.f1580a.a()) {
                com.fyber.inneractive.sdk.player.exoplayer2.util.w.a("load:".concat(this.f1580a.getClass().getSimpleName()));
                try {
                    this.f1580a.load();
                    com.fyber.inneractive.sdk.player.exoplayer2.util.w.a();
                } catch (Throwable th) {
                    com.fyber.inneractive.sdk.player.exoplayer2.util.w.a();
                    throw th;
                }
            }
            if (this.h) {
                return;
            }
            sendEmptyMessage(2);
        } catch (IOException e) {
            if (this.h) {
                return;
            }
            obtainMessage(3, e).sendToTarget();
        } catch (Error e2) {
            Log.e("LoadTask", "Unexpected error loading stream", e2);
            if (!this.h) {
                obtainMessage(4, e2).sendToTarget();
            }
            throw e2;
        } catch (InterruptedException unused) {
            if (!this.f1580a.a()) {
                throw new IllegalStateException();
            }
            if (this.h) {
                return;
            }
            sendEmptyMessage(2);
        } catch (Exception e3) {
            Log.e("LoadTask", "Unexpected exception loading stream", e3);
            if (this.h) {
                return;
            }
            obtainMessage(3, new a0(e3)).sendToTarget();
        } catch (OutOfMemoryError e4) {
            Log.e("LoadTask", "OutOfMemory error loading stream", e4);
            if (this.h) {
                return;
            }
            obtainMessage(3, new a0(e4)).sendToTarget();
        }
    }
}
