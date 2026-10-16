package com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes4.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    public final int f1483a;
    public final List b;

    public e(int i, List list) {
        this.f1483a = i;
        if (!a(32) && list.isEmpty()) {
            list = Collections.singletonList(com.fyber.inneractive.sdk.player.exoplayer2.o.a(null, "application/cea-608", 0, null, -1, null, Long.MAX_VALUE, Collections.emptyList()));
        }
        this.b = list;
    }

    public final f0 a(int i, d0 d0Var) {
        if (i == 2) {
            return new s(new j());
        }
        if (i == 3 || i == 4) {
            return new s(new q(d0Var.f1482a));
        }
        if (i == 15) {
            if (a(2)) {
                return null;
            }
            return new s(new d(false, d0Var.f1482a));
        }
        if (i == 21) {
            return new s(new p());
        }
        if (i == 27) {
            if (a(4)) {
                return null;
            }
            return new s(new m(a(d0Var), a(1), a(8)));
        }
        if (i == 36) {
            return new s(new o(a(d0Var)));
        }
        if (i == 89) {
            return new s(new g(d0Var.b));
        }
        if (i != 138) {
            if (i != 129) {
                if (i != 130) {
                    if (i == 134) {
                        if (a(16)) {
                            return null;
                        }
                        return new w(new y());
                    }
                    if (i != 135) {
                        return null;
                    }
                }
            }
            return new s(new b(d0Var.f1482a));
        }
        return new s(new f(d0Var.f1482a));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r15v4 */
    public final x a(d0 d0Var) {
        int i;
        String str;
        if (a(32)) {
            return new x(this.b);
        }
        com.fyber.inneractive.sdk.player.exoplayer2.util.n nVar = new com.fyber.inneractive.sdk.player.exoplayer2.util.n(d0Var.c);
        ArrayList arrayList = this.b;
        while (nVar.c - nVar.b > 0) {
            int j = nVar.j();
            int j2 = nVar.b + nVar.j();
            if (j == 134) {
                arrayList = new ArrayList();
                int j3 = nVar.j() & 31;
                for (int i2 = 0; i2 < j3; i2++) {
                    String b = nVar.b(3);
                    int j4 = nVar.j();
                    if ((j4 & 128) != 0) {
                        i = j4 & 63;
                        str = "application/cea-708";
                    } else {
                        i = 1;
                        str = "application/cea-608";
                    }
                    arrayList.add(com.fyber.inneractive.sdk.player.exoplayer2.o.a(null, str, 0, b, i, null, Long.MAX_VALUE, Collections.emptyList()));
                    nVar.e(nVar.b + 2);
                }
            }
            nVar.e(j2);
            arrayList = arrayList;
        }
        return new x(arrayList);
    }

    public final boolean a(int i) {
        return (i & this.f1483a) != 0;
    }
}
