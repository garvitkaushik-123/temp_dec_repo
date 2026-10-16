package com.bytedance.sdk.openadsdk.aGH.eli;

import com.ironsource.C3040d4;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class DbA {
    public int aGH;
    public AtomicInteger eli = new AtomicInteger(0);
    public AtomicInteger DbA = new AtomicInteger(0);
    public AtomicLong Os = new AtomicLong(0);
    public AtomicInteger ui = new AtomicInteger(0);
    public Map<Integer, Integer> MGA = new HashMap();
    public AtomicBoolean kb = new AtomicBoolean(false);

    public DbA(int i) {
        this.aGH = i;
    }

    JSONObject eli() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("success", this.eli.get());
            jSONObject.put(C3040d4.f.e, this.DbA.get());
            jSONObject.put("type", this.aGH);
            jSONObject.put("duration", this.Os.get() / this.eli.get());
            JSONObject jSONObject2 = new JSONObject();
            if (this.MGA.size() > 0) {
                for (Map.Entry<Integer, Integer> entry : this.MGA.entrySet()) {
                    jSONObject2.put(String.valueOf(entry.getKey()), entry.getValue());
                }
            }
            jSONObject.put("fail_error_code", jSONObject2);
            return jSONObject;
        } catch (Exception unused) {
            return null;
        }
    }

    JSONObject DbA() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("success", this.eli.get());
            jSONObject.put(C3040d4.f.e, this.DbA.get());
            jSONObject.put("type", this.aGH);
            jSONObject.put("time", this.ui.get());
            return jSONObject;
        } catch (Exception unused) {
            return null;
        }
    }
}
