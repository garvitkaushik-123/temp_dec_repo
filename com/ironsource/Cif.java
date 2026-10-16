package com.ironsource;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import com.ironsource.C3040d4;
import com.ironsource.mediationsdk.testSuite.TestSuiteActivity;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.ironsource.if, reason: invalid class name */
/* loaded from: classes6.dex */
public final class Cif {
    public final void a(Context context, String appKey, JSONObject initResponse, String sdkVersion, String testSuiteControllerUrl, Boolean bool, boolean z) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(appKey, "appKey");
        Intrinsics.checkNotNullParameter(initResponse, "initResponse");
        Intrinsics.checkNotNullParameter(sdkVersion, "sdkVersion");
        Intrinsics.checkNotNullParameter(testSuiteControllerUrl, "testSuiteControllerUrl");
        C3321tf c3321tf = C3321tf.f3849a;
        a(context, a(appKey, sdkVersion, c3321tf.c(context), c3321tf.a(context), c3321tf.b(context), bool, initResponse, z, c3321tf.b(), c3321tf.c(), a()));
        Intent intent = new Intent(context, (Class<?>) TestSuiteActivity.class);
        intent.setFlags(com.google.android.exoplayer2.C.ENCODING_PCM_32BIT);
        intent.putExtra("controllerUrl", testSuiteControllerUrl);
        context.startActivity(intent);
    }

    public final String b(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return a(context).getString("dataString", "");
    }

    private final JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        for (Map.Entry<String, List<String>> entry : C3321tf.f3849a.d().entrySet()) {
            jSONObject.putOpt(entry.getKey(), new JSONArray((Collection) entry.getValue()));
        }
        return jSONObject;
    }

    private final String a(String str, String str2, String str3, String str4, String str5, Boolean bool, JSONObject jSONObject, boolean z, JSONObject jSONObject2, JSONObject jSONObject3, JSONObject jSONObject4) {
        String jSONObject5 = new JSONObject(MapsKt.mapOf(TuplesKt.to(Ma.o, C3040d4.d), TuplesKt.to("appKey", str), TuplesKt.to("sdkVersion", str2), TuplesKt.to("bundleId", str3), TuplesKt.to("appName", str4), TuplesKt.to(C3040d4.i.W, str5), TuplesKt.to("initResponse", jSONObject), TuplesKt.to("isRvManual", Boolean.valueOf(z)), TuplesKt.to("generalProperties", jSONObject2), TuplesKt.to("adaptersVersion", jSONObject3), TuplesKt.to("metaData", jSONObject4), TuplesKt.to("gdprConsent", bool))).toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject5, "JSONObject(\n            …ent))\n        .toString()");
        return jSONObject5;
    }

    private final SharedPreferences a(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("com.unity3d.ad-mediation.testSuite", 0);
        Intrinsics.checkNotNullExpressionValue(sharedPreferences, "context.getSharedPrefere…EY, Context.MODE_PRIVATE)");
        return sharedPreferences;
    }

    private final void a(Context context, String str) {
        SharedPreferences.Editor edit = a(context).edit();
        Intrinsics.checkNotNullExpressionValue(edit, "getTestSuitePrefs(context).edit()");
        edit.putString("dataString", str);
        edit.apply();
    }
}
