package com.fyber.inneractive.sdk.player.exoplayer2.upstream.cache;

import java.util.Comparator;
import java.util.TreeSet;

/* loaded from: classes4.dex */
public final class j implements Comparator {

    /* renamed from: a, reason: collision with root package name */
    public final TreeSet f1561a = new TreeSet(this);
    public long b;

    public final void a(l lVar, long j) {
        while (this.b + j > 10485760) {
            try {
                g gVar = (g) this.f1561a.first();
                synchronized (lVar) {
                    lVar.a(gVar, true);
                }
            } catch (a unused) {
            }
        }
    }

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        g gVar = (g) obj;
        g gVar2 = (g) obj2;
        long j = gVar.f;
        long j2 = gVar2.f;
        if (j - j2 != 0) {
            return j < j2 ? -1 : 1;
        }
        if (!gVar.f1558a.equals(gVar2.f1558a)) {
            return gVar.f1558a.compareTo(gVar2.f1558a);
        }
        long j3 = gVar.b - gVar2.b;
        if (j3 == 0) {
            return 0;
        }
        return j3 < 0 ? -1 : 1;
    }
}
