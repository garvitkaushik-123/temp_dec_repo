package com.fyber.inneractive.sdk.flow.endcard;

import android.content.Context;
import android.text.TextUtils;
import com.fyber.inneractive.sdk.flow.r0;
import com.fyber.inneractive.sdk.flow.u0;

/* loaded from: classes4.dex */
public final class k {

    /* renamed from: a, reason: collision with root package name */
    public final u0 f1189a;
    public final m b;
    public final boolean c;
    public final com.fyber.inneractive.sdk.flow.endcard.loaders.b d;
    public final h e;
    public final int f;

    public k(Context context, r0 r0Var) {
        u0 u0Var = new u0(context, r0Var);
        m mVar = new m();
        this.b = mVar;
        this.f1189a = u0Var;
        this.c = !TextUtils.equals(u0Var.d.E, "1");
        h hVar = new h();
        this.e = hVar;
        this.f = hVar.b;
        this.d = new com.fyber.inneractive.sdk.flow.endcard.loaders.b(u0Var, mVar);
    }

    public final b a() {
        b bVar;
        m mVar = this.b;
        int size = mVar.f1198a.size();
        int i = mVar.c;
        do {
            i++;
            if (i >= size) {
                return null;
            }
            bVar = (b) mVar.f1198a.get(i);
        } while (!bVar.l());
        if (bVar.i() == com.fyber.inneractive.sdk.model.vast.i.Default_End_Card) {
            for (int size2 = mVar.b.size() - 1; size2 >= 0; size2--) {
                if (((b) mVar.b.get(size2)) instanceof o) {
                    return null;
                }
            }
            if (mVar.c >= 0) {
                return null;
            }
        } else if (bVar instanceof c) {
            int i2 = i + 1;
            for (int size3 = mVar.f1198a.size() - 1; size3 >= i2; size3--) {
                b bVar2 = (b) mVar.f1198a.get(size3);
                if (bVar2 instanceof c) {
                    bVar2.destroy();
                    mVar.f1198a.remove(size3);
                }
            }
        }
        mVar.c = i;
        mVar.b.add(bVar);
        bVar.e = mVar.b.size();
        return bVar;
    }
}
