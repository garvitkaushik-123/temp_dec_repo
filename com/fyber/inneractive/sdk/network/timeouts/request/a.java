package com.fyber.inneractive.sdk.network.timeouts.request;

import com.fyber.inneractive.sdk.config.global.features.j;

/* loaded from: classes4.dex */
public abstract class a extends com.fyber.inneractive.sdk.network.timeouts.a {
    public int h;
    public int i;
    public int j;
    public int k;
    public final String l;

    public a(String str, j jVar, String str2) {
        this.l = str2;
        d(jVar, str);
    }

    public int a(int i) {
        return 0;
    }

    public abstract int a(j jVar);

    public abstract int a(j jVar, String str);

    public int b() {
        return 0;
    }

    public abstract int b(j jVar, String str);

    public int c() {
        return 0;
    }

    public abstract int c(j jVar, String str);

    public void d(j jVar, String str) {
        int b = b(jVar, "read");
        int b2 = b(jVar, "conn");
        int a2 = a(jVar, str);
        this.f = a(jVar);
        this.j = c(jVar, "read");
        int c = c(jVar, "conn");
        this.k = c;
        int i = (this.j * a2) / 100;
        this.h = i;
        this.i = (a2 * c) / 100;
        this.h = Math.max(b, i);
        this.i = Math.max(b2, this.i);
    }
}
