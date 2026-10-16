package com.ironsource;

import org.json.JSONObject;

/* renamed from: com.ironsource.h4, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public class C3108h4 {

    /* renamed from: a, reason: collision with root package name */
    public static final String f3330a = "SSA_CORE.SDKController.runFunction";

    public static String a(C3125i4 c3125i4) {
        return String.format("%1$s('%2$s%3$s'%4$s)", f3330a, c3125i4.b(), a(c3125i4.c()), b(c3125i4));
    }

    private static String b(C3125i4 c3125i4) {
        return (c3125i4.d() == null || c3125i4.a() == null) ? "" : String.format(", '%1$s', '%2$s'", c3125i4.d(), c3125i4.a());
    }

    private static String a(JSONObject jSONObject) {
        if (jSONObject != null && jSONObject.length() != 0) {
            return jSONObject.toString();
        }
        return "";
    }
}
