package com.bytedance.sdk.openadsdk.core.aAs.MGA;

import com.bytedance.adsdk.ugeno.core.nGm;
import com.bytedance.sdk.component.adexpress.DbA.NU;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class eli extends NU {
    private nGm DbA;
    private float Os;
    private float aGH;
    private JSONObject eli;

    public eli(C0181eli c0181eli) {
        super(c0181eli);
        this.eli = c0181eli.eli;
        this.DbA = c0181eli.DbA;
        this.Os = c0181eli.Os;
        this.aGH = c0181eli.aGH;
    }

    public float VM() {
        return this.Os;
    }

    public float GB() {
        return this.aGH;
    }

    public JSONObject oWW() {
        return this.eli;
    }

    public nGm qj() {
        return this.DbA;
    }

    /* renamed from: com.bytedance.sdk.openadsdk.core.aAs.MGA.eli$eli, reason: collision with other inner class name */
    public static class C0181eli extends NU.eli {
        private nGm DbA;
        private float Os;
        private float aGH;
        private JSONObject eli;

        public C0181eli eli(JSONObject jSONObject) {
            this.eli = jSONObject;
            return this;
        }

        public C0181eli eli(nGm ngm) {
            this.DbA = ngm;
            return this;
        }

        public C0181eli eli(float f) {
            this.Os = f;
            return this;
        }

        public C0181eli DbA(float f) {
            this.aGH = f;
            return this;
        }

        @Override // com.bytedance.sdk.component.adexpress.DbA.NU.eli
        /* renamed from: DbA, reason: merged with bridge method [inline-methods] */
        public eli eli() {
            return new eli(this);
        }
    }
}
