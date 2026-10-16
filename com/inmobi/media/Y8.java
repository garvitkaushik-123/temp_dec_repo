package com.inmobi.media;

import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes4.dex */
public final class Y8 implements ef {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ C2562a9 f2494a;

    public Y8(C2562a9 c2562a9) {
        this.f2494a = c2562a9;
    }

    @Override // com.inmobi.media.ef
    public final void a(View view, boolean z) {
        C2572b1 c2572b1;
        Intrinsics.checkNotNullParameter(view, "view");
        C2562a9 c2562a9 = this.f2494a;
        if (z) {
            c2562a9.p();
        } else {
            D8 h = c2562a9.h();
            if (h != null && (c2572b1 = h.l) != null) {
                c2572b1.a();
            }
        }
        this.f2494a.a(view, z);
    }
}
