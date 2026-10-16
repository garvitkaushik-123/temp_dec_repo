package com.iab.omid.library.voodooio;

import android.content.Context;
import com.iab.omid.library.voodooio.internal.i;
import com.iab.omid.library.voodooio.internal.j;
import com.iab.omid.library.voodooio.utils.e;
import com.iab.omid.library.voodooio.utils.g;

/* loaded from: classes4.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private boolean f2140a;

    private void b(Context context) {
        g.a(context, "Application Context cannot be null");
    }

    String a() {
        return "1.5.2-Voodooio";
    }

    void a(Context context) {
        b(context);
        if (b()) {
            return;
        }
        a(true);
        i.c().a(context);
        com.iab.omid.library.voodooio.internal.b.g().a(context);
        com.iab.omid.library.voodooio.utils.a.a(context);
        com.iab.omid.library.voodooio.utils.c.a(context);
        e.a(context);
        com.iab.omid.library.voodooio.internal.g.b().a(context);
        com.iab.omid.library.voodooio.internal.a.a().a(context);
        j.b().a(context);
    }

    void a(boolean z) {
        this.f2140a = z;
    }

    boolean b() {
        return this.f2140a;
    }

    void c() {
        g.a();
        com.iab.omid.library.voodooio.internal.a.a().d();
    }
}
