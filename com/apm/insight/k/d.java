package com.apm.insight.k;

import android.content.Context;
import com.apm.insight.CrashType;
import com.apm.insight.Npth;
import com.apm.insight.runtime.m;
import com.apm.insight.runtime.n;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: CrashUploadManager.java */
/* loaded from: classes2.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    private static volatile d f275a;
    private volatile Context b;

    public static d a() {
        if (f275a == null) {
            f275a = new d(com.apm.insight.e.g());
        }
        return f275a;
    }

    private d(Context context) {
        this.b = context;
    }

    public static boolean a(JSONObject jSONObject, File file, File file2) {
        try {
            return e.a(e.g(), jSONObject.toString(), file, file2, n.a(System.currentTimeMillis()), new File(com.apm.insight.h.b.a())).a();
        } catch (Throwable th) {
            com.apm.insight.a.b(th);
            return false;
        }
    }

    public final void a(JSONObject jSONObject, long j, boolean z) {
        File[] fileArr;
        if (jSONObject == null || jSONObject.length() <= 0) {
            return;
        }
        try {
            String c = e.c();
            int i = 0;
            File file = new File(com.apm.insight.l.j.a(this.b), com.apm.insight.e.a(j, CrashType.ANR, false, false));
            com.apm.insight.l.f.a(file, file.getName(), c, jSONObject, e.b());
            if (z && !Npth.isStopUpload()) {
                jSONObject.put("upload_scene", "direct");
                jSONObject.put("crash_uuid", file.getName());
                if (com.apm.insight.runtime.a.h()) {
                    HashMap<String, n.a> a2 = n.a(j, "anr_trace");
                    fileArr = new File[a2.size() + 2];
                    for (Map.Entry<String, n.a> entry : a2.entrySet()) {
                        if (!entry.getKey().equals(com.apm.insight.l.a.b())) {
                            fileArr[i] = com.apm.insight.l.j.a(this.b, entry.getValue().f340a);
                            i++;
                        }
                    }
                } else {
                    fileArr = new File[2];
                }
                fileArr[fileArr.length - 1] = com.apm.insight.l.j.a(this.b, com.apm.insight.e.f());
                fileArr[fileArr.length - 2] = n.a(j);
                if (e.a(c, jSONObject.toString(), fileArr).a()) {
                    com.apm.insight.l.f.a(file);
                    if (Npth.hasCrash()) {
                        return;
                    }
                    com.apm.insight.l.f.a(com.apm.insight.l.j.e(com.apm.insight.e.g()));
                }
            }
        } catch (Throwable unused) {
        }
    }

    public final boolean a(JSONObject jSONObject) {
        if (jSONObject != null && jSONObject.length() > 0) {
            try {
                String c = e.c();
                File file = new File(com.apm.insight.l.j.a(this.b), com.apm.insight.l.j.a(com.apm.insight.e.e()));
                com.apm.insight.l.f.a(file, file.getName(), c, jSONObject, e.a());
                jSONObject.put("upload_scene", "direct");
                if (!e.b(c, jSONObject.toString()).a()) {
                    return false;
                }
                com.apm.insight.l.f.a(file);
                return true;
            } catch (Throwable th) {
                com.apm.insight.a.b(th);
            }
        }
        return false;
    }

    public final void b(JSONObject jSONObject) {
        if (jSONObject == null || jSONObject.length() <= 0) {
            return;
        }
        try {
            String f = e.f();
            File file = new File(com.apm.insight.l.j.a(this.b), com.apm.insight.l.j.c());
            com.apm.insight.l.f.a(file, file.getName(), f, jSONObject, e.b());
            if (e.a(f, jSONObject.toString()).a()) {
                com.apm.insight.l.f.a(file);
            }
        } catch (Throwable th) {
            com.apm.insight.a.b(th);
        }
    }

    public final void c(final JSONObject jSONObject) {
        if (jSONObject == null || jSONObject.length() == 0) {
            return;
        }
        m.a().a(new Runnable() { // from class: com.apm.insight.k.d.1
            @Override // java.lang.Runnable
            public final void run() {
                String c = e.c();
                try {
                    jSONObject.put("upload_scene", "direct");
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                e.b(c, jSONObject.toString());
            }
        });
    }
}
