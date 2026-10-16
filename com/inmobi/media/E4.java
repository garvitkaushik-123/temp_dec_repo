package com.inmobi.media;

import java.util.BitSet;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes4.dex */
public abstract class E4 {

    /* renamed from: a, reason: collision with root package name */
    public final C2555a2 f2271a;

    public E4(String b64feature) {
        Intrinsics.checkNotNullParameter(b64feature, "b64feature");
        C2555a2 c2555a2 = new C2555a2();
        this.f2271a = c2555a2;
        c2555a2.a(b64feature);
    }

    public final boolean a(boolean z) {
        BitSet bitSet = this.f2271a.f2513a;
        return bitSet != null ? bitSet.get(0) : z;
    }
}
