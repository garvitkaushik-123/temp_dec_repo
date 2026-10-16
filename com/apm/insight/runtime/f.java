package com.apm.insight.runtime;

import android.content.Context;
import com.apm.insight.l.c;
import io.bidmachine.rendering.model.EventTaskParams;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;

/* compiled from: CrashTimes.java */
/* loaded from: classes2.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    private Context f328a;
    private HashMap<String, Long> b;
    private int c;
    private int d;

    public f(Context context) {
        this.b = null;
        this.c = 50;
        this.d = 100;
        this.f328a = context;
        this.b = b();
        this.c = a.a(this.c, "custom_event_settings", "npth_simple_setting", "crash_limit_issue");
        this.d = a.a(this.d, "custom_event_settings", "npth_simple_setting", "crash_limit_all");
    }

    private HashMap<String, Long> b() {
        File h = com.apm.insight.l.j.h(this.f328a);
        HashMap<String, Long> hashMap = new HashMap<>();
        hashMap.put("time", Long.valueOf(System.currentTimeMillis()));
        try {
            JSONArray a2 = com.apm.insight.l.f.a(h.getAbsolutePath());
            if (!com.apm.insight.a.a(a2)) {
                Long decode = Long.decode(a2.optString(0, null));
                if (System.currentTimeMillis() - decode.longValue() <= 86400000) {
                    hashMap.put("time", decode);
                    for (int i = 1; i < a2.length(); i++) {
                        String[] split = a2.optString(i, "").split(" ");
                        if (split.length == 2) {
                            hashMap.put(split[0], Long.decode(split[1]));
                        }
                    }
                } else {
                    File g = com.apm.insight.l.j.g(this.f328a);
                    h.renameTo(new File(g, String.valueOf(System.currentTimeMillis())));
                    String[] list = g.list();
                    if (list != null && list.length > 5) {
                        Arrays.sort(list);
                        new File(g, list[0]).delete();
                        return hashMap;
                    }
                }
            }
        } catch (IOException unused) {
        } catch (Throwable th) {
            com.apm.insight.c.a();
            j.a(th, "NPTH_CATCH");
        }
        return hashMap;
    }

    public final void a() {
        HashMap<String, Long> hashMap = this.b;
        Long remove = hashMap.remove("time");
        if (remove == null) {
            com.apm.insight.c.a();
            j.a(new RuntimeException("err times, no time"), "NPTH_CATCH");
            return;
        }
        StringBuilder append = new StringBuilder().append(remove).append('\n');
        for (Map.Entry<String, Long> entry : hashMap.entrySet()) {
            append.append(entry.getKey()).append(' ').append(entry.getValue()).append('\n');
        }
        try {
            com.apm.insight.l.f.a(com.apm.insight.l.j.h(this.f328a), append.toString(), false);
        } catch (IOException unused) {
        }
    }

    public final boolean a(String str) {
        if (str == null) {
            str = EventTaskParams.STATE_GROUP_DEFAULT;
        }
        return c.AnonymousClass1.a(this.b, str, 1L).longValue() < ((long) this.c) && c.AnonymousClass1.a(this.b, "all", 1L).longValue() < ((long) this.d);
    }
}
