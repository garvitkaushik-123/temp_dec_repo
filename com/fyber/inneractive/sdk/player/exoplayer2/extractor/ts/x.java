package com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts;

import java.util.Collections;
import java.util.List;

/* loaded from: classes4.dex */
public final class x {

    /* renamed from: a, reason: collision with root package name */
    public final List f1501a;
    public final com.fyber.inneractive.sdk.player.exoplayer2.extractor.r[] b;

    public x(List list) {
        this.f1501a = list;
        this.b = new com.fyber.inneractive.sdk.player.exoplayer2.extractor.r[list.size()];
    }

    public final void a(com.fyber.inneractive.sdk.player.exoplayer2.extractor.j jVar, e0 e0Var) {
        for (int i = 0; i < this.b.length; i++) {
            e0Var.a();
            e0Var.b();
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.g a2 = jVar.a(e0Var.d, 3);
            com.fyber.inneractive.sdk.player.exoplayer2.o oVar = (com.fyber.inneractive.sdk.player.exoplayer2.o) this.f1501a.get(i);
            String str = oVar.f;
            com.fyber.inneractive.sdk.player.exoplayer2.util.a.a("application/cea-608".equals(str) || "application/cea-708".equals(str), "Invalid closed caption mime type provided: " + str);
            String str2 = oVar.f1523a;
            if (str2 == null) {
                e0Var.b();
                str2 = e0Var.e;
            }
            a2.a(com.fyber.inneractive.sdk.player.exoplayer2.o.a(str2, str, oVar.x, oVar.y, oVar.z, null, Long.MAX_VALUE, Collections.emptyList()));
            this.b[i] = a2;
        }
    }
}
