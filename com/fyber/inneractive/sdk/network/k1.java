package com.fyber.inneractive.sdk.network;

import com.fyber.inneractive.sdk.external.InneractiveAdRequest;
import com.fyber.inneractive.sdk.util.IAlog;
import java.io.PrintWriter;
import java.io.StringWriter;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public final class k1 implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ l1 f1327a;

    public k1(l1 l1Var) {
        this.f1327a = l1Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        String str;
        l1 l1Var = this.f1327a;
        s0 s0Var = (s0) com.fyber.inneractive.sdk.util.t.a(l1Var.b);
        Thread thread = (Thread) com.fyber.inneractive.sdk.util.t.a(this.f1327a.f1329a);
        if (s0Var == null || s0Var.f == g1.DONE || s0Var.f == g1.RESOLVED) {
            return;
        }
        boolean t = s0Var.t();
        IAlog.a("%s : NetworkWatchdogHolder : should report: %s", IAlog.a(l1.class), Boolean.valueOf(t));
        if (t) {
            if (thread != null) {
                StackTraceElement[] stackTrace = thread.getStackTrace();
                Exception exc = new Exception();
                exc.setStackTrace(stackTrace);
                StringWriter stringWriter = new StringWriter();
                exc.printStackTrace(new PrintWriter(stringWriter));
                str = stringWriter.getBuffer().toString();
            } else {
                str = "";
            }
            String p = s0Var.p();
            InneractiveAdRequest inneractiveAdRequest = s0Var instanceof p0 ? ((p0) s0Var).p : null;
            com.fyber.inneractive.sdk.response.e eVar = s0Var instanceof d1 ? ((d1) s0Var).s : null;
            u uVar = u.NETWORK_REQUEST_PASSED_ALLOWED_TIME;
            JSONArray b = s0Var.i() != null ? s0Var.i().b() : null;
            w wVar = new w(eVar);
            wVar.c = uVar;
            wVar.f1340a = inneractiveAdRequest;
            wVar.d = b;
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("url", p);
            } catch (Exception unused) {
                IAlog.f("Got exception adding param to json object: %s, %s", "url", p);
            }
            try {
                jSONObject.put("stack_trace", str);
            } catch (Exception unused2) {
                IAlog.f("Got exception adding param to json object: %s, %s", "stack_trace", str);
            }
            Integer valueOf = Integer.valueOf(l1Var.c);
            try {
                jSONObject.put("total_time", valueOf);
            } catch (Exception unused3) {
                IAlog.f("Got exception adding param to json object: %s, %s", "total_time", valueOf);
            }
            wVar.f.put(jSONObject);
            wVar.a((String) null);
        }
        IAlog.a("%s : NetworkWatchdogHolder should cancel by timeout: %d", IAlog.a(l1Var), Integer.valueOf(l1Var.c));
        s0Var.c();
    }
}
