package com.ironsource;

import com.ironsource.AbstractC3292s3;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public final class rg<Smash extends AbstractC3292s3<?>> {

    /* renamed from: a, reason: collision with root package name */
    private final sg<Smash> f3683a;

    public rg(sg<Smash> smashPicker) {
        Intrinsics.checkNotNullParameter(smashPicker, "smashPicker");
        this.f3683a = smashPicker;
    }

    public final List<Smash> a() {
        return this.f3683a.c();
    }

    public final boolean b() {
        return this.f3683a.c().isEmpty() && this.f3683a.a().isEmpty();
    }

    public final boolean c() {
        return this.f3683a.d() == 0;
    }
}
