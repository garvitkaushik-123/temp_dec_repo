package com.bytedance.sdk.openadsdk.core.du.DbA;

import com.bytedance.sdk.openadsdk.core.du.DbA.Os;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class DbA extends Os implements Comparable<DbA> {
    private final float eli;

    private DbA(float f, String str, Os.EnumC0188Os enumC0188Os, Boolean bool) {
        super(str, enumC0188Os, bool);
        this.eli = f;
    }

    public boolean eli(float f) {
        return this.eli <= f && !ui();
    }

    @Override // java.lang.Comparable
    /* renamed from: eli, reason: merged with bridge method [inline-methods] */
    public int compareTo(DbA dbA) {
        if (dbA == null) {
            return 1;
        }
        float f = this.eli;
        float f2 = dbA.eli;
        if (f > f2) {
            return 1;
        }
        return f < f2 ? -1 : 0;
    }

    @Override // com.bytedance.sdk.openadsdk.core.du.DbA.Os
    public void m_() {
        super.m_();
    }

    public static class eli {
        private final float DbA;
        private Os.EnumC0188Os Os = Os.EnumC0188Os.TRACKING_URL;
        private boolean aGH = false;
        private final String eli;

        public eli(String str, float f) {
            this.eli = str;
            this.DbA = f;
        }

        public DbA eli() {
            return new DbA(this.DbA, this.eli, this.Os, Boolean.valueOf(this.aGH));
        }
    }

    public JSONObject DbA() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("content", Os());
        jSONObject.put("trackingFraction", this.eli);
        return jSONObject;
    }

    public String toString() {
        return super.toString();
    }
}
