package com.bytedance.sdk.openadsdk.aGH.ui.DbA;

import com.bytedance.sdk.openadsdk.aGH.ui.DbA.Os;
import com.bytedance.sdk.openadsdk.core.model.ev;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class eli<T extends Os> {
    private String DbA;
    private JSONObject Os;
    private T aGH;
    private ev eli;
    private boolean ui = false;

    public eli(ev evVar, String str, JSONObject jSONObject, T t) {
        this.eli = evVar;
        this.DbA = str;
        this.Os = jSONObject;
        this.aGH = t;
    }

    public ev eli() {
        return this.eli;
    }

    public String DbA() {
        return this.DbA;
    }

    public JSONObject Os() {
        if (this.Os == null) {
            this.Os = new JSONObject();
        }
        return this.Os;
    }

    public T aGH() {
        return this.aGH;
    }

    public boolean ui() {
        return this.ui;
    }

    public void eli(boolean z) {
        this.ui = z;
    }
}
