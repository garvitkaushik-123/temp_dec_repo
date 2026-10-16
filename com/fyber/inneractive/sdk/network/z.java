package com.fyber.inneractive.sdk.network;

import com.fyber.inneractive.sdk.external.InneractiveAdRequest;
import com.fyber.inneractive.sdk.util.IAlog;
import java.io.PrintWriter;
import java.io.StringWriter;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public abstract class z {
    public static void a(String str, String str2, InneractiveAdRequest inneractiveAdRequest, com.fyber.inneractive.sdk.response.e eVar) {
        w wVar = new w(u.CAUGHT_EXCEPTION, inneractiveAdRequest, eVar);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("exception_name", str);
        } catch (Exception unused) {
            IAlog.f("Got exception adding param to json object: %s, %s", "exception_name", str);
        }
        try {
            jSONObject.put("description", str2);
        } catch (Exception unused2) {
            IAlog.f("Got exception adding param to json object: %s, %s", "description", str2);
        }
        wVar.f.put(jSONObject);
        wVar.a((String) null);
    }

    public static void a(Throwable th, InneractiveAdRequest inneractiveAdRequest, com.fyber.inneractive.sdk.response.e eVar) {
        StringWriter stringWriter = new StringWriter();
        th.printStackTrace(new PrintWriter(stringWriter));
        String stringBuffer = stringWriter.getBuffer().toString();
        w wVar = new w(u.CAUGHT_EXCEPTION, inneractiveAdRequest, eVar);
        JSONObject jSONObject = new JSONObject();
        String cls = th.getClass().toString();
        try {
            jSONObject.put("exception_name", cls);
        } catch (Exception unused) {
            IAlog.f("Got exception adding param to json object: %s, %s", "exception_name", cls);
        }
        String message = th.getMessage();
        try {
            jSONObject.put("description", message);
        } catch (Exception unused2) {
            IAlog.f("Got exception adding param to json object: %s, %s", "description", message);
        }
        try {
            jSONObject.put("stack_trace", stringBuffer);
        } catch (Exception unused3) {
            IAlog.f("Got exception adding param to json object: %s, %s", "stack_trace", stringBuffer);
        }
        wVar.f.put(jSONObject);
        wVar.a((String) null);
    }
}
