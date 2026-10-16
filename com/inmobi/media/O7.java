package com.inmobi.media;

import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes4.dex */
public final class O7 implements ef {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ T7 f2383a;

    public O7(T7 t7) {
        this.f2383a = t7;
    }

    @Override // com.inmobi.media.ef
    public final void a(View view, boolean z) {
        C2572b1 c2572b1;
        Intrinsics.checkNotNullParameter(view, "view");
        T7 t7 = this.f2383a;
        if (z) {
            t7.p();
            return;
        }
        D8 h = t7.h();
        if (h == null || (c2572b1 = h.l) == null) {
            return;
        }
        c2572b1.a();
    }
}
