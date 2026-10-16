package com.mbridge.msdk.advanced.common;

import java.util.HashMap;
import java.util.Map;

/* compiled from: MBNativeAdvancedWebViewCache.java */
/* loaded from: classes6.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private static Map<String, Boolean> f3979a = new HashMap();

    public static void a(String str, boolean z) {
        f3979a.put(str, Boolean.valueOf(z));
    }

    public static void b(String str) {
        f3979a.remove(str);
    }

    public static boolean a(String str) {
        if (f3979a.containsKey(str)) {
            return f3979a.get(str).booleanValue();
        }
        return false;
    }
}
