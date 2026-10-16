package com.ironsource;

import com.ironsource.mediationsdk.logger.IronLog;
import java.util.Calendar;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

/* loaded from: classes6.dex */
public class O5 {
    public static final int e = -1;

    /* renamed from: a, reason: collision with root package name */
    private Runnable f2976a = new a();
    private int b;
    private InterfaceC3221o c;
    private C3081fb d;

    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            IronLog.INTERNAL.verbose("loaded ads are expired");
            InterfaceC3221o interfaceC3221o = O5.this.c;
            if (interfaceC3221o != null) {
                interfaceC3221o.a();
            }
        }
    }

    public O5(int i, InterfaceC3221o interfaceC3221o) {
        this.c = interfaceC3221o;
        this.b = i;
    }

    public void a(long j) {
        if (b()) {
            long millis = TimeUnit.MINUTES.toMillis(this.b) - Math.max(j, 0L);
            if (millis <= 0) {
                IronLog.INTERNAL.verbose("no delay - onAdExpired called");
                this.c.a();
                return;
            }
            a();
            this.d = new C3081fb(millis, this.f2976a, true);
            Calendar calendar = Calendar.getInstance();
            calendar.add(14, (int) millis);
            IronLog.INTERNAL.verbose("loaded ads will expire on: " + calendar.getTime() + " in " + String.format(Locale.getDefault(), "%.2f", Double.valueOf((millis / 1000.0d) / 60.0d)) + " minutes");
        }
    }

    public boolean b() {
        return this.b > 0;
    }

    public void a() {
        if (!b() || this.d == null) {
            return;
        }
        IronLog.INTERNAL.verbose("canceling expiration timer");
        this.d.e();
        this.d = null;
    }
}
