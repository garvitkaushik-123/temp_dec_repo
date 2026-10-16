package com.iab.omid.library.mmadbridge;

import android.content.Context;
import com.iab.omid.library.mmadbridge.internal.i;
import com.iab.omid.library.mmadbridge.internal.j;
import com.iab.omid.library.mmadbridge.utils.e;
import com.iab.omid.library.mmadbridge.utils.g;

/* loaded from: classes4.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private boolean f2069a;

    private void b(Context context) {
        g.a(context, "Application Context cannot be null");
    }

    String a() {
        return "1.4.13-Mmadbridge";
    }

    void a(Context context) {
        b(context);
        if (b()) {
            return;
        }
        a(true);
        i.c().a(context);
        com.iab.omid.library.mmadbridge.internal.b.g().a(context);
        com.iab.omid.library.mmadbridge.utils.a.a(context);
        com.iab.omid.library.mmadbridge.utils.c.a(context);
        e.a(context);
        com.iab.omid.library.mmadbridge.internal.g.b().a(context);
        com.iab.omid.library.mmadbridge.internal.a.a().a(context);
        j.b().a(context);
    }

    void a(boolean z) {
        this.f2069a = z;
    }

    boolean b() {
        return this.f2069a;
    }

    void c() {
        g.a();
        com.iab.omid.library.mmadbridge.internal.a.a().d();
    }
}
