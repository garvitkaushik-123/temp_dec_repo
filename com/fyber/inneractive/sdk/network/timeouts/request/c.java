package com.fyber.inneractive.sdk.network.timeouts.request;

import com.fyber.inneractive.sdk.config.global.features.j;
import com.fyber.inneractive.sdk.util.IAlog;

/* loaded from: classes4.dex */
public final class c extends a {
    public double m;

    public c(String str, j jVar, String str2) {
        super(str, jVar, str2);
    }

    @Override // com.fyber.inneractive.sdk.network.timeouts.request.a
    public final int a(j jVar, String str) {
        return jVar.b(str, this.l);
    }

    @Override // com.fyber.inneractive.sdk.network.timeouts.request.a
    public final int b(j jVar, String str) {
        String str2 = this.l;
        jVar.getClass();
        String a2 = j.a(str, "min", "rat", "bidding", j.e(str2));
        String a3 = j.a(str, "min", "rat", "bidding", "all_mediators");
        "read".equalsIgnoreCase(str);
        Integer a4 = jVar.a(a3);
        int intValue = a4 != null ? a4.intValue() : 5000;
        Integer a5 = jVar.a(a2);
        return a5 != null ? a5.intValue() : intValue;
    }

    @Override // com.fyber.inneractive.sdk.network.timeouts.request.a
    public final int c(j jVar, String str) {
        String str2 = this.l;
        jVar.getClass();
        String a2 = j.a(str, "rat", "bidding", "perc", j.e(str2));
        String a3 = j.a(str, "rat", "bidding", "perc", "all_mediators");
        "read".equalsIgnoreCase(str);
        Integer a4 = jVar.a(a3);
        int intValue = a4 != null ? a4.intValue() : 15;
        Integer a5 = jVar.a(a2);
        return a5 != null ? a5.intValue() : intValue;
    }

    @Override // com.fyber.inneractive.sdk.network.timeouts.request.a
    public final void d(j jVar, String str) {
        super.d(jVar, str);
        Boolean c = jVar.c("reverse_retries");
        this.g = c != null ? c.booleanValue() : true;
        String a2 = j.a("retry_interval", "rat", "bidding");
        Integer a3 = jVar.a(j.a("retry_interval", "all_mediators"));
        int intValue = a3 != null ? a3.intValue() : 100;
        Integer a4 = jVar.a(a2);
        if (a4 != null) {
            intValue = a4.intValue();
        }
        this.e = intValue;
        this.c = (this.i + this.h) - (intValue + this.f);
        String a5 = j.a("bidding", "irat", j.e(this.l));
        Integer a6 = jVar.a(j.a("bidding", "irat", "all_mediators"));
        int intValue2 = a6 != null ? a6.intValue() : 10000;
        Integer a7 = jVar.a(a5);
        if (a7 != null) {
            intValue2 = a7.intValue();
        }
        this.d = intValue2;
        this.m = Math.min(this.k, this.j) / Math.max(this.k, this.j);
        b(this.d);
        this.f1338a = Math.max(0, a());
        if (this.g) {
            IAlog.a("%s : RequestBiddingAdTimeout shouldReverseRetries - reversing timeouts", IAlog.a(this));
            a(0);
        }
        IAlog.a("%s : RequestBiddingAdTimeout init timeouts, total retries: %d", IAlog.a(this), Integer.valueOf(this.f1338a));
    }

    @Override // com.fyber.inneractive.sdk.network.timeouts.request.a
    public final int a(j jVar) {
        String str = this.l;
        jVar.getClass();
        String a2 = j.a("timeout", "threshold", "rat", "bidding", j.e(str));
        Integer a3 = jVar.a(j.a("timeout", "threshold", "rat", "bidding", "all_mediators"));
        int intValue = a3 != null ? a3.intValue() : 300;
        Integer a4 = jVar.a(a2);
        return a4 != null ? a4.intValue() : intValue;
    }

    @Override // com.fyber.inneractive.sdk.network.timeouts.request.a
    public final int c() {
        return this.e;
    }

    @Override // com.fyber.inneractive.sdk.network.timeouts.request.a
    public final int a(int i) {
        if (this.g) {
            i = this.f1338a - i;
        }
        int i2 = (this.b * i) + this.d;
        IAlog.a("%s : RequestBiddingAdTimeout resolveTimeoutForRetry, timeout: %d ms for retry: %d", IAlog.a(this), Integer.valueOf(i2), Integer.valueOf(i));
        b(i2);
        return i2;
    }

    @Override // com.fyber.inneractive.sdk.network.timeouts.request.a
    public final int b() {
        return this.f1338a;
    }

    public final void b(int i) {
        double d = this.m;
        if (d == 1.0d || d == 0.0d) {
            IAlog.a("%s : RequestBiddingAdTimeout Ratio: %f, connection and read timeouts should be divided in equal proportions", IAlog.a(this), Double.valueOf(this.m));
            this.m = 0.5d;
        }
        int i2 = (int) (i * this.m);
        this.h = i2;
        this.i = i - i2;
        IAlog.a("%s : RequestBiddingAdTimeout Update timeouts connection: %d read: %d", IAlog.a(this), Integer.valueOf(this.i), Integer.valueOf(this.h));
    }
}
