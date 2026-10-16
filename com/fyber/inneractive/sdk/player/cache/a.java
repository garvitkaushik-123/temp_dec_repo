package com.fyber.inneractive.sdk.player.cache;

import java.util.concurrent.Callable;

/* loaded from: classes4.dex */
public final class a implements Callable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ f f1346a;

    public a(f fVar) {
        this.f1346a = fVar;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        synchronized (this.f1346a) {
            f fVar = this.f1346a;
            if (fVar.i == null) {
                return null;
            }
            fVar.d();
            f fVar2 = this.f1346a;
            int i = fVar2.k;
            if (i >= 2000 && i >= fVar2.j.size()) {
                this.f1346a.c();
                this.f1346a.k = 0;
            }
            return null;
        }
    }
}
