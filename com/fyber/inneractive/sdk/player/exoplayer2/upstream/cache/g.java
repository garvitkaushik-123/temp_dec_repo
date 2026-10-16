package com.fyber.inneractive.sdk.player.exoplayer2.upstream.cache;

import java.io.File;

/* loaded from: classes4.dex */
public abstract class g implements Comparable {

    /* renamed from: a, reason: collision with root package name */
    public final String f1558a;
    public final long b;
    public final long c;
    public final boolean d;
    public final File e;
    public final long f;

    public g(String str, long j, long j2, long j3, File file) {
        this.f1558a = str;
        this.b = j;
        this.c = j2;
        this.d = file != null;
        this.e = file;
        this.f = j3;
    }

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        g gVar = (g) obj;
        if (!this.f1558a.equals(gVar.f1558a)) {
            return this.f1558a.compareTo(gVar.f1558a);
        }
        long j = this.b - gVar.b;
        if (j == 0) {
            return 0;
        }
        return j < 0 ? -1 : 1;
    }
}
