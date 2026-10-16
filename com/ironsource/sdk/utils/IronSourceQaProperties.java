package com.ironsource.sdk.utils;

import java.util.HashMap;
import java.util.Map;

/* loaded from: classes6.dex */
public class IronSourceQaProperties {

    /* renamed from: a, reason: collision with root package name */
    private static IronSourceQaProperties f3826a;
    private static Map<String, String> b = new HashMap();

    private IronSourceQaProperties() {
    }

    public static IronSourceQaProperties getInstance() {
        if (f3826a == null) {
            f3826a = new IronSourceQaProperties();
        }
        return f3826a;
    }

    public static boolean isInitialized() {
        return f3826a != null;
    }

    public Map<String, String> getParameters() {
        return b;
    }

    public void setQaParameter(String str, String str2) {
        if (str == null || str2 == null) {
            return;
        }
        b.put(str, str2);
    }
}
