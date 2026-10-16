package com.fyber.inneractive.sdk.util;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewTreeObserver;
import java.util.HashSet;
import java.util.Iterator;
import java.util.WeakHashMap;

/* loaded from: classes4.dex */
public final class i0 implements ViewTreeObserver.OnPreDrawListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Context f1760a;
    public final /* synthetic */ l0 b;

    public i0(l0 l0Var, Context context) {
        this.b = l0Var;
        this.f1760a = context;
    }

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public final boolean onPreDraw() {
        float f;
        l0 l0Var = this.b;
        Context context = this.f1760a;
        if (context == null) {
            l0Var.getClass();
            return true;
        }
        WeakHashMap weakHashMap = (WeakHashMap) l0Var.b.get(context);
        if (weakHashMap == null) {
            return true;
        }
        j jVar = l0Var.d;
        Object poll = jVar.f1761a.poll();
        if (poll == null) {
            poll = jVar.b.a();
        }
        HashSet hashSet = (HashSet) poll;
        hashSet.addAll(weakHashMap.keySet());
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            View view = (View) it.next();
            k0 k0Var = (k0) weakHashMap.get(view);
            if (k0Var != null) {
                j jVar2 = l0Var.c;
                Object poll2 = jVar2.f1761a.poll();
                if (poll2 == null) {
                    poll2 = jVar2.b.a();
                }
                Rect rect = (Rect) poll2;
                if (view == null || view.getParent() == null || !view.isShown() || !view.getGlobalVisibleRect(rect)) {
                    f = 0.0f;
                } else {
                    f = (rect.width() * rect.height()) / (view.getWidth() * view.getHeight());
                }
                k0Var.a(f, rect);
                l0Var.c.f1761a.offer(rect);
            }
        }
        hashSet.clear();
        l0Var.d.f1761a.offer(hashSet);
        return true;
    }
}
