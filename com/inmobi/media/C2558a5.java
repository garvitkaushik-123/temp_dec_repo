package com.inmobi.media;

import java.lang.ref.WeakReference;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: com.inmobi.media.a5, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C2558a5 implements Ba {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ C2576b5 f2515a;

    public C2558a5(C2576b5 c2576b5) {
        this.f2515a = c2576b5;
    }

    @Override // com.inmobi.media.Ba
    public final void a(Da result) {
        Intrinsics.checkNotNullParameter(result, "result");
        WeakReference weakReference = (WeakReference) this.f2515a.b.get(result.f2264a.h);
        La la = weakReference != null ? (La) weakReference.get() : null;
        if (Ga.a(result)) {
            this.f2515a.b(result, la);
        } else {
            this.f2515a.a(result, la);
        }
    }
}
