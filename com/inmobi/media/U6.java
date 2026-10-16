package com.inmobi.media;

import com.inmobi.commons.utils.json.Constructor;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes4.dex */
public final class U6 extends Dc {
    public final Class b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public U6(Constructor<List<Object>> constructor, Class<Object> valueClass) {
        super(constructor);
        Intrinsics.checkNotNullParameter(constructor, "constructor");
        Intrinsics.checkNotNullParameter(valueClass, "valueClass");
        this.b = valueClass;
    }

    public final List<Object> b() {
        return (List) a().construct();
    }

    public final Class<Object> c() {
        return this.b;
    }
}
