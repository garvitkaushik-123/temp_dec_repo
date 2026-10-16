package com.fyber.inneractive.sdk.protobuf;

import java.util.Collections;
import java.util.Map;

/* loaded from: classes4.dex */
public final class h0 {
    public static volatile h0 b;
    public static final h0 c = new h0();

    /* renamed from: a, reason: collision with root package name */
    public final Map f1675a = Collections.emptyMap();

    public static h0 a() {
        h0 h0Var;
        h0 h0Var2 = b;
        if (h0Var2 != null) {
            return h0Var2;
        }
        synchronized (h0.class) {
            h0Var = b;
            if (h0Var == null) {
                Class cls = f0.f1671a;
                h0 h0Var3 = null;
                if (cls != null) {
                    try {
                        h0Var3 = (h0) cls.getDeclaredMethod("getEmptyRegistry", null).invoke(null, null);
                    } catch (Exception unused) {
                    }
                }
                h0Var = h0Var3 != null ? h0Var3 : c;
                b = h0Var;
            }
        }
        return h0Var;
    }

    public final x0 a(int i, d2 d2Var) {
        return (x0) this.f1675a.get(new g0(i, d2Var));
    }
}
