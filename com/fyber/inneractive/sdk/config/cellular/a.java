package com.fyber.inneractive.sdk.config.cellular;

import android.content.Context;
import com.fyber.inneractive.sdk.util.x0;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes4.dex */
public final class a implements h {

    /* renamed from: a, reason: collision with root package name */
    public final d f1074a;
    public final CopyOnWriteArrayList c = new CopyOnWriteArrayList();
    public x0 b = x0.UNKNOWN;

    public a(Context context) {
        this.f1074a = e.a(context);
    }

    @Override // com.fyber.inneractive.sdk.config.cellular.h
    public final void a(x0 x0Var) {
        this.b = x0Var;
        Iterator it = this.c.iterator();
        while (it.hasNext()) {
            h hVar = (h) it.next();
            if (hVar != null) {
                hVar.a(this.b);
            }
        }
    }
}
