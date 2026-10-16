package com.fyber.inneractive.sdk.flow.endcard;

import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes4.dex */
public final class m {

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList f1198a = new ArrayList();
    public final ArrayList b = new ArrayList();
    public int c = -1;
    public final g d = new g();

    public final b a() {
        int i = this.c;
        if (i >= 0) {
            return (b) this.f1198a.get(i);
        }
        return null;
    }

    public final b a(com.fyber.inneractive.sdk.model.vast.i iVar) {
        Iterator it = this.b.iterator();
        while (it.hasNext()) {
            b bVar = (b) it.next();
            if (bVar.i() == iVar) {
                return bVar;
            }
        }
        return null;
    }

    public final void a(b bVar) {
        if (((bVar instanceof o) || (bVar instanceof d)) && this.f1198a.contains(bVar)) {
            return;
        }
        this.f1198a.add(bVar);
        this.f1198a.sort(this.d);
    }
}
