package com.bytedance.sdk.openadsdk.component.reward;

import android.os.SystemClock;
import com.bytedance.sdk.openadsdk.core.model.ev;
import com.bytedance.sdk.openadsdk.utils.dZ;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class du {
    private long DbA;
    private boolean MGA;
    private long Os;
    private long aGH;
    private final eli eli;
    private boolean ui;

    public interface eli {
        void eli();
    }

    public du(eli eliVar) {
        this.ui = true;
        this.eli = eliVar;
        int eli2 = com.bytedance.sdk.openadsdk.bf.eli.eli("reward_callback_fallback", 0);
        if (eli2 != 0) {
            this.ui = false;
            if (eli2 == 2) {
                this.MGA = true;
            }
        }
    }

    public static void eli(ev evVar, boolean z, final int i) {
        com.bytedance.sdk.openadsdk.aGH.Os.eli(System.currentTimeMillis(), evVar, dZ.eli(evVar), z ? "reward_callback" : "reward_fail_callback", new com.bytedance.sdk.openadsdk.Dfc.Os.eli() { // from class: com.bytedance.sdk.openadsdk.component.reward.du.1
            @Override // com.bytedance.sdk.openadsdk.Dfc.Os.eli
            public JSONObject eli() {
                JSONObject jSONObject = new JSONObject();
                try {
                    JSONObject jSONObject2 = new JSONObject();
                    JSONObject jSONObject3 = new JSONObject();
                    jSONObject3.put("reason", i);
                    jSONObject2.put("pag_json_data", jSONObject3);
                    jSONObject.put("ad_extra_data", jSONObject2.toString());
                } catch (Exception unused) {
                }
                return jSONObject;
            }
        });
    }

    public void eli(long j) {
        if (j <= this.DbA) {
            return;
        }
        this.DbA = j;
    }

    public void eli() {
        if (!this.ui && this.Os > 0) {
            this.aGH += SystemClock.elapsedRealtime() - this.Os;
            this.Os = 0L;
        }
    }

    public void DbA() {
        if (this.ui) {
            return;
        }
        this.Os = SystemClock.elapsedRealtime();
    }

    public void Os() {
        this.ui = true;
    }

    public void aGH() {
        if (this.eli != null) {
            long elapsedRealtime = (this.aGH + (this.Os > 0 ? SystemClock.elapsedRealtime() - this.Os : 0L)) / 1000;
            if (this.ui) {
                return;
            }
            if (this.MGA || elapsedRealtime >= this.DbA) {
                this.eli.eli();
            }
        }
    }
}
