package com.inmobi.media;

/* loaded from: classes4.dex */
public final class Ce implements InterfaceC2690i1 {
    public static final void b(boolean z) {
        if (z) {
            De.a(De.f2267a);
        } else {
            De.a();
        }
    }

    public final void a(final boolean z) {
        Uc.a(z);
        Uc.a(new Runnable() { // from class: com.inmobi.media.Ce$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                Ce.b(z);
            }
        });
    }
}
