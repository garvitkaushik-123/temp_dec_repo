package com.inmobi.media;

import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public final class Gb {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ KProperty[] f2296a = {Reflection.property1(new PropertyReference1Impl(Gb.class, "areImraidLogsEnabled", "getAreImraidLogsEnabled()Z", 0))};

    public static JSONObject a(String browser, String event) {
        Intrinsics.checkNotNullParameter(browser, "browser");
        Intrinsics.checkNotNullParameter(event, "event");
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("browser", browser);
        jSONObject.put("event", event);
        return jSONObject;
    }
}
