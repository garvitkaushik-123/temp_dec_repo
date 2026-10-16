package com.inmobi.media;

import android.view.View;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: com.inmobi.media.y8, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class ViewOnAttachStateChangeListenerC2958y8 implements View.OnAttachStateChangeListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ D8 f2763a;
    public final /* synthetic */ ArrayList b;
    public final /* synthetic */ C2613d8 c;

    public ViewOnAttachStateChangeListenerC2958y8(D8 d8, ArrayList arrayList, C2613d8 c2613d8) {
        this.f2763a = d8;
        this.b = arrayList;
        this.c = c2613d8;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View v) {
        Intrinsics.checkNotNullParameter(v, "v");
        this.f2763a.l.a(this.b);
        T7 t7 = this.f2763a.b;
        C2613d8 a2 = t7.a(t7.b, this.c);
        C2613d8 c2613d8 = this.c;
        T7 t72 = this.f2763a.b;
        if (a2 == null) {
            a2 = c2613d8;
        }
        c2613d8.a("creativeView", t72.a(a2), (L7) null, this.f2763a.f);
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View v) {
        Intrinsics.checkNotNullParameter(v, "v");
        v.removeOnAttachStateChangeListener(this);
        C2572b1 c2572b1 = this.f2763a.l;
        ArrayList arrayList = this.b;
        c2572b1.getClass();
        if (arrayList == null) {
            return;
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((C2554a1) it.next()).f2512a.cancel();
        }
        c2572b1.b.removeAll(arrayList);
    }
}
