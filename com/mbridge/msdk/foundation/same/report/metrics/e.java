package com.mbridge.msdk.foundation.same.report.metrics;

import android.text.TextUtils;
import com.mbridge.msdk.MBridgeConstans;
import java.util.HashMap;
import java.util.Map;

/* compiled from: ParameterWrapper.java */
/* loaded from: classes6.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    private Map<String, String> f4331a = new HashMap();

    public void a(String str, Object obj) {
        if (TextUtils.isEmpty(str) || obj == null) {
            return;
        }
        try {
            if (!(obj instanceof String)) {
                this.f4331a.put(str, obj + "");
            } else {
                if (TextUtils.isEmpty((String) obj)) {
                    return;
                }
                this.f4331a.put(str, (String) obj);
            }
        } catch (Exception e) {
            if (MBridgeConstans.DEBUG) {
                e.printStackTrace();
            }
        }
    }

    public Object b(String str) {
        return this.f4331a.get(str);
    }

    public void c(String str) {
        if (this.f4331a == null || TextUtils.isEmpty(str)) {
            return;
        }
        this.f4331a.remove(str);
    }

    public boolean a(String str) {
        return this.f4331a.containsKey(str);
    }

    public Map<String, String> a() {
        return this.f4331a;
    }

    public void a(e eVar) {
        Map<String, String> map;
        Map<String, String> map2;
        if (eVar == null || (map = eVar.f4331a) == null || (map2 = this.f4331a) == null) {
            return;
        }
        map2.putAll(map);
    }
}
