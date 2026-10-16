package com.inmobi.media;

import com.ironsource.C3040d4;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes4.dex */
public final class Xc extends Lambda implements Function0 {

    /* renamed from: a, reason: collision with root package name */
    public static final Xc f2485a = new Xc();

    public Xc() {
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        Zc.f2508a.getClass();
        C6 c6 = Zc.j;
        int i = 0;
        if (c6 != null) {
            Intrinsics.checkNotNullParameter("cnt", C3040d4.h.W);
            i = c6.f2249a.getInt("cnt", 0);
        }
        return Integer.valueOf(i);
    }
}
