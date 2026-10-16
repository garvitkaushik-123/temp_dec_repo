package com.iab.omid.library.unity3d;

import android.content.Context;
import com.iab.omid.library.unity3d.internal.f;
import com.iab.omid.library.unity3d.internal.h;
import com.iab.omid.library.unity3d.utils.e;
import com.iab.omid.library.unity3d.utils.g;

/* loaded from: classes4.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private boolean f2106a;

    private void b(Context context) {
        g.a(context, "Application Context cannot be null");
    }

    String a() {
        return "1.4.9-Unity3d";
    }

    void a(Context context) {
        b(context);
        if (b()) {
            return;
        }
        a(true);
        h.c().a(context);
        com.iab.omid.library.unity3d.internal.b.g().a(context);
        com.iab.omid.library.unity3d.utils.a.a(context);
        com.iab.omid.library.unity3d.utils.c.a(context);
        e.a(context);
        f.b().a(context);
        com.iab.omid.library.unity3d.internal.a.a().a(context);
    }

    void a(boolean z) {
        this.f2106a = z;
    }

    boolean b() {
        return this.f2106a;
    }

    void c() {
        g.a();
        com.iab.omid.library.unity3d.internal.a.a().d();
    }
}
