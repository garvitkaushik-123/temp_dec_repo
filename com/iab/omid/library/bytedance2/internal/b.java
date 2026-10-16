package com.iab.omid.library.bytedance2.internal;

import android.view.View;
import java.util.Iterator;

/* loaded from: classes4.dex */
public class b extends d {
    private static b d = new b();

    private b() {
    }

    public static b g() {
        return d;
    }

    @Override // com.iab.omid.library.bytedance2.internal.d
    public void b(boolean z) {
        Iterator<com.iab.omid.library.bytedance2.adsession.a> it = c.c().b().iterator();
        while (it.hasNext()) {
            it.next().getAdSessionStatePublisher().a(z);
        }
    }

    @Override // com.iab.omid.library.bytedance2.internal.d
    public boolean d() {
        Iterator<com.iab.omid.library.bytedance2.adsession.a> it = c.c().a().iterator();
        while (it.hasNext()) {
            View c = it.next().c();
            if (c != null && c.hasWindowFocus()) {
                return true;
            }
        }
        return false;
    }
}
