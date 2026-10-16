package com.applovin.impl;

import android.content.Context;

/* loaded from: classes2.dex */
public abstract class p0 {

    /* renamed from: a, reason: collision with root package name */
    private static final a f614a = new a("Age Restricted User", x4.q);
    private static final a b = new a("Has User Consent", x4.p);
    private static final a c = new a("\"Do Not Sell\"", x4.r);

    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private final String f615a;
        private final x4 b;

        a(String str, x4 x4Var) {
            this.f615a = str;
            this.b = x4Var;
        }

        public Boolean b(Context context) {
            if (context != null) {
                return (Boolean) y4.a(this.b, (Object) null, context);
            }
            com.applovin.impl.sdk.o.h("AppLovinSdk", "Failed to get value for key: " + this.b);
            return null;
        }

        public String a() {
            return this.f615a;
        }

        public String a(Context context) {
            Boolean b = b(context);
            return b != null ? b.toString() : "No value set";
        }
    }

    public static a a() {
        return c;
    }

    public static a b() {
        return b;
    }

    public static a c() {
        return f614a;
    }

    public static boolean a(boolean z, Context context) {
        return a(x4.r, Boolean.valueOf(z), context);
    }

    public static boolean b(boolean z, Context context) {
        return a(x4.p, Boolean.valueOf(z), context);
    }

    public static String a(Context context) {
        return a(b, context) + a(c, context);
    }

    private static boolean a(x4 x4Var, Boolean bool, Context context) {
        if (context == null) {
            com.applovin.impl.sdk.o.h("AppLovinSdk", "Failed to update compliance value for key: " + x4Var);
            return false;
        }
        try {
            Boolean bool2 = (Boolean) y4.a(x4Var, (Object) null, context);
            y4.b(x4Var, bool, context);
            return bool2 == null || bool2 != bool;
        } catch (Throwable th) {
            com.applovin.impl.sdk.o.c("ComplianceManager", "Unable to update compliance", th);
            com.applovin.impl.sdk.k kVar = com.applovin.impl.sdk.k.D0;
            if (kVar != null) {
                kVar.E().a("ComplianceManager", "updateCompliance", th);
            }
            return false;
        }
    }

    private static String a(a aVar, Context context) {
        return "\n" + aVar.f615a + " - " + aVar.a(context);
    }
}
