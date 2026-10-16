package com.inmobi.media;

import java.lang.ref.WeakReference;
import java.util.Iterator;

/* loaded from: classes4.dex */
public final class C5 {
    public static void a() {
        try {
            Iterator it = D5.f2259a.iterator();
            while (it.hasNext()) {
                C2645f7 c2645f7 = (C2645f7) ((WeakReference) it.next()).get();
                if (c2645f7 != null) {
                    c2645f7.a();
                }
            }
        } catch (Exception e) {
            S5 s5 = S5.f2425a;
            S5.d.a(AbstractC2920w5.a(e, "event"));
        }
    }
}
