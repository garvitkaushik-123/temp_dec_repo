package com.mbridge.msdk.foundation.same.report;

import android.text.TextUtils;
import com.ironsource.C3040d4;
import com.ironsource.D5;
import com.mbridge.msdk.foundation.tools.p0;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: SameCommonReporter.java */
/* loaded from: classes6.dex */
public class l {

    /* renamed from: a, reason: collision with root package name */
    private final Map<String, String> f4324a;
    private final String b;

    /* compiled from: SameCommonReporter.java */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        private final Map<String, String> f4325a = new HashMap();
        private final String b;

        public b(String str) {
            this.b = str;
        }

        public l a() {
            return new l(this);
        }
    }

    private void a(Map<String, String> map, JSONObject jSONObject) {
        if (map == null || map.isEmpty() || jSONObject == null) {
            return;
        }
        try {
            for (String str : map.keySet()) {
                jSONObject.put(str, a(map.get(str)));
            }
        } catch (Exception e) {
            p0.b("SameCommonReporter", e.getMessage());
        }
    }

    public void b(String str) {
        if (TextUtils.isEmpty(this.b)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(C3040d4.h.W, this.b);
            a(this.f4324a, jSONObject);
            com.mbridge.msdk.foundation.same.report.metrics.d.b().a(jSONObject);
        } catch (Throwable th) {
            p0.b("SameCommonReporter", th.getMessage());
        }
    }

    private l(b bVar) {
        this.b = bVar.b;
        this.f4324a = bVar.f4325a;
    }

    private String a(String str) {
        try {
            return URLEncoder.encode(str, D5.N);
        } catch (Exception unused) {
            return str;
        }
    }
}
