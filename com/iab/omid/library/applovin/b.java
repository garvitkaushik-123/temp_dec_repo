package com.iab.omid.library.applovin;

import android.content.Context;
import com.iab.omid.library.applovin.internal.i;
import com.iab.omid.library.applovin.internal.j;
import com.iab.omid.library.applovin.utils.e;
import com.iab.omid.library.applovin.utils.g;

/* loaded from: classes4.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private boolean f1847a;

    private void b(Context context) {
        g.a(context, "Application Context cannot be null");
    }

    String a() {
        return "1.5.3-Applovin";
    }

    void a(Context context) {
        b(context);
        if (b()) {
            return;
        }
        a(true);
        i.c().a(context);
        com.iab.omid.library.applovin.internal.b.g().a(context);
        com.iab.omid.library.applovin.utils.a.a(context);
        com.iab.omid.library.applovin.utils.c.a(context);
        e.a(context);
        com.iab.omid.library.applovin.internal.g.b().a(context);
        com.iab.omid.library.applovin.internal.a.a().a(context);
        j.b().a(context);
    }

    void a(boolean z) {
        this.f1847a = z;
    }

    boolean b() {
        return this.f1847a;
    }

    void c() {
        g.a();
        com.iab.omid.library.applovin.internal.a.a().d();
    }
}
