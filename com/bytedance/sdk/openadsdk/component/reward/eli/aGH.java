package com.bytedance.sdk.openadsdk.component.reward.eli;

import android.util.SparseArray;
import android.view.View;
import com.bytedance.sdk.openadsdk.core.DbA.Os;
import com.bytedance.sdk.openadsdk.core.model.ev;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class aGH {
    private final ev DbA;
    private final String Os;
    private boolean aGH;
    com.bytedance.sdk.openadsdk.QX.eli.eli.MGA eli;
    private final com.bytedance.sdk.openadsdk.component.reward.eli.eli ui;

    public interface eli {
        void eli(View view, float f, float f2, float f3, float f4, SparseArray<Os.eli> sparseArray, int i, int i2, int i3);

        void eli(String str, JSONObject jSONObject);
    }

    public aGH(com.bytedance.sdk.openadsdk.component.reward.eli.eli eliVar) {
        this.ui = eliVar;
        this.DbA = eliVar.DbA;
        this.Os = eliVar.ui;
    }

    public void eli() {
        if (this.aGH) {
            return;
        }
        this.aGH = true;
        aGH();
    }

    private void aGH() {
        if (!com.bytedance.sdk.openadsdk.multipro.DbA.Os() && this.DbA.yw() == 4) {
            this.eli = com.bytedance.sdk.openadsdk.QX.eli.eli.kb.eli(this.ui.FS, this.Os);
        }
        if (this.eli == null) {
            this.eli = com.bytedance.sdk.openadsdk.QX.eli.eli.kb.eli(this.ui.SSo, this.Os);
        }
    }

    public void DbA() {
        com.bytedance.sdk.openadsdk.QX.eli.eli.MGA mga = this.eli;
        if (mga != null) {
            mga.Os(this.DbA);
        }
    }

    public com.bytedance.sdk.openadsdk.QX.eli.eli.MGA Os() {
        return this.eli;
    }

    public void eli(View view, float f, float f2, float f3, float f4, SparseArray<Os.eli> sparseArray, int i, int i2, int i3, eli eliVar) {
        if (this.eli != null) {
            int id = view.getId();
            if (id == com.bytedance.sdk.openadsdk.utils.aqO.ui) {
                eliVar.eli("click_play_star_level", null);
                return;
            }
            if (id == com.bytedance.sdk.openadsdk.utils.aqO.aGH) {
                eliVar.eli("click_play_star_nums", null);
                return;
            } else if (id == com.bytedance.sdk.openadsdk.utils.aqO.Os) {
                eliVar.eli("click_play_source", null);
                return;
            } else {
                if (id == com.bytedance.sdk.openadsdk.utils.aqO.DbA) {
                    eliVar.eli("click_play_logo", null);
                    return;
                }
                return;
            }
        }
        eliVar.eli(view, f, f2, f3, f4, sparseArray, i, i2, i3);
    }
}
