package com.bytedance.sdk.openadsdk.aGH;

import org.json.JSONObject;

/* loaded from: classes3.dex */
public class kb {
    private long DbA;
    private long Os;
    private long aGH;
    private long eli;
    private long ui;

    public void eli(long j) {
        if (this.eli <= 0) {
            this.eli = j;
        }
    }

    public void DbA(long j) {
        if (this.DbA <= 0) {
            this.DbA = j;
        }
    }

    public void Os(long j) {
        if (this.Os <= 0) {
            this.Os = j;
        }
    }

    public void aGH(long j) {
        if (this.aGH <= 0) {
            this.aGH = j;
        }
    }

    public void ui(long j) {
        if (this.ui <= 0) {
            this.ui = j;
        }
    }

    public boolean eli() {
        return this.eli > 0;
    }

    public void eli(long j, float f) {
        if (f > 0.0f) {
            eli(j);
        }
        double d = f;
        if (d >= 0.25d) {
            eli(j);
            DbA(j);
        }
        if (d >= 0.5d) {
            eli(j);
            DbA(j);
            Os(j);
        }
        if (d >= 0.75d) {
            eli(j);
            DbA(j);
            Os(j);
            aGH(j);
        }
        if (f >= 1.0f) {
            eli(j);
            DbA(j);
            Os(j);
            aGH(j);
            ui(j);
        }
    }

    public JSONObject DbA() {
        return eli((JSONObject) null);
    }

    public JSONObject eli(JSONObject jSONObject) {
        if (jSONObject == null) {
            try {
                jSONObject = new JSONObject();
            } catch (Exception unused) {
            }
        }
        long j = this.eli;
        if (j > 0) {
            jSONObject.put("show_start", j);
            long j2 = this.DbA;
            if (j2 > 0) {
                jSONObject.put("show_firstQuartile", j2);
                long j3 = this.Os;
                if (j3 > 0) {
                    jSONObject.put("show_mid", j3);
                    long j4 = this.aGH;
                    if (j4 > 0) {
                        jSONObject.put("show_thirdQuartile", j4);
                        long j5 = this.ui;
                        if (j5 > 0) {
                            jSONObject.put("show_full", j5);
                        }
                    }
                }
            }
        }
        return jSONObject;
    }
}
