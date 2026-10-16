package com.iab.omid.library.fyber;

import android.content.Context;
import com.iab.omid.library.fyber.internal.i;
import com.iab.omid.library.fyber.internal.j;
import com.iab.omid.library.fyber.utils.e;
import com.iab.omid.library.fyber.utils.g;

/* loaded from: classes4.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private boolean f1957a;

    private void b(Context context) {
        g.a(context, "Application Context cannot be null");
    }

    String a() {
        return "1.5.4-Fyber";
    }

    void a(Context context) {
        b(context);
        if (b()) {
            return;
        }
        a(true);
        i.c().a(context);
        com.iab.omid.library.fyber.internal.b.g().a(context);
        com.iab.omid.library.fyber.utils.a.a(context);
        com.iab.omid.library.fyber.utils.c.a(context);
        e.a(context);
        com.iab.omid.library.fyber.internal.g.b().a(context);
        com.iab.omid.library.fyber.internal.a.a().a(context);
        j.b().a(context);
    }

    void a(boolean z) {
        this.f1957a = z;
    }

    boolean b() {
        return this.f1957a;
    }

    void c() {
        g.a();
        com.iab.omid.library.fyber.internal.a.a().d();
    }
}
