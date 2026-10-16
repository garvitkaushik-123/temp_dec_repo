package com.fyber.inneractive.sdk.player.cache;

import java.io.BufferedWriter;
import java.io.File;

/* loaded from: classes4.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public final d f1347a;
    public final /* synthetic */ f b;

    public c(f fVar, d dVar) {
        this.b = fVar;
        this.f1347a = dVar;
        if (dVar.c) {
            return;
        }
        boolean[] zArr = new boolean[fVar.g];
    }

    public final void a() {
        int i;
        f fVar = this.b;
        synchronized (fVar) {
            d dVar = this.f1347a;
            if (dVar.d != this) {
                throw new IllegalStateException();
            }
            for (int i2 = 0; i2 < fVar.g; i2++) {
                f.a(new File(dVar.e.f1349a, dVar.f1348a + "." + i2 + ".tmp"));
            }
            fVar.k++;
            dVar.d = null;
            if (dVar.c) {
                dVar.c = true;
                BufferedWriter bufferedWriter = fVar.i;
                StringBuilder append = new StringBuilder("CLEAN ").append(dVar.f1348a);
                StringBuilder sb = new StringBuilder();
                for (long j : dVar.b) {
                    sb.append(' ').append(j);
                }
                bufferedWriter.write(append.append(sb.toString()).append('\n').toString());
            } else {
                fVar.j.remove(dVar.f1348a);
                fVar.i.write("REMOVE " + dVar.f1348a + '\n');
            }
            fVar.i.flush();
            if (fVar.h > fVar.f || ((i = fVar.k) >= 2000 && i >= fVar.j.size())) {
                fVar.m.submit(fVar.n);
            }
        }
    }
}
