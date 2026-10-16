package com.inmobi.media;

/* loaded from: classes4.dex */
public abstract class F8 {
    public static G8 a() {
        synchronized (G8.d) {
            G8 g8 = G8.e;
            if (g8 == null) {
                return new G8();
            }
            G8.e = g8.c;
            g8.c = null;
            G8.f--;
            return g8;
        }
    }
}
