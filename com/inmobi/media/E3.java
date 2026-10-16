package com.inmobi.media;

import java.lang.ref.WeakReference;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes4.dex */
public final class E3 implements Ba {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ F3 f2270a;

    public E3(F3 f3) {
        this.f2270a = f3;
    }

    @Override // com.inmobi.media.Ba
    public final void a(Da result) {
        Intrinsics.checkNotNullParameter(result, "result");
        WeakReference weakReference = (WeakReference) this.f2270a.b.get(result.f2264a.h);
        La la = weakReference != null ? (La) weakReference.get() : null;
        if (Ga.a(result)) {
            this.f2270a.b(result, la);
        } else {
            this.f2270a.a(result, la);
        }
    }
}
