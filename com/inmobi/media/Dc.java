package com.inmobi.media;

import com.inmobi.commons.utils.json.Constructor;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes4.dex */
public abstract class Dc {

    /* renamed from: a, reason: collision with root package name */
    public Constructor f2265a;

    public Dc(Constructor constructor) {
        Intrinsics.checkNotNullParameter(constructor, "constructor");
        this.f2265a = constructor;
    }

    public final Constructor<Object> a() {
        return this.f2265a;
    }

    public final void a(Constructor<Object> constructor) {
        Intrinsics.checkNotNullParameter(constructor, "<set-?>");
        this.f2265a = constructor;
    }
}
