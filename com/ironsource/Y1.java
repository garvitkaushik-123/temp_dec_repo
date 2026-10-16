package com.ironsource;

/* loaded from: classes6.dex */
public final class Y1 {

    /* renamed from: a, reason: collision with root package name */
    public static final Y1 f3135a = new Y1();
    public static final String b = "trials_fail";
    public static final String c = "parsing";
    public static final String d = "other";
    public static final String e = "disabled";
    public static final String f = "-1";

    private Y1() {
    }

    public final String a(boolean z) {
        if (!z) {
            return f;
        }
        return "fallback_" + System.currentTimeMillis();
    }

    public static /* synthetic */ String a(Y1 y1, boolean z, Integer num, int i, Object obj) {
        if ((i & 2) != 0) {
            num = null;
        }
        return y1.a(z, num);
    }

    public final String a(boolean z, Integer num) {
        if (z) {
            return (num != null && num.intValue() == 1003) ? c : (num != null && num.intValue() == 1008) ? c : (num != null && num.intValue() == 1002) ? c : (num != null && num.intValue() == 1006) ? b : (num != null && num.intValue() == 1001) ? b : "other";
        }
        return e;
    }
}
