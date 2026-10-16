package com.bytedance.sdk.openadsdk.core.wC;

import com.bytedance.sdk.openadsdk.utils.cyF;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class NU implements com.bytedance.adsdk.ugeno.core.nGm, com.bytedance.sdk.component.adexpress.DbA.FC {
    private final String DbA;
    private final com.bytedance.sdk.openadsdk.core.model.ev Os;
    private final String aGH;
    private final com.bytedance.sdk.openadsdk.aGH.aGH.ui eli;
    private long ui;

    public NU(com.bytedance.sdk.openadsdk.aGH.aGH.ui uiVar, String str, com.bytedance.sdk.openadsdk.core.model.ev evVar, String str2) {
        this.eli = uiVar;
        this.DbA = str;
        this.aGH = str2;
        this.Os = evVar;
    }

    @Override // com.bytedance.sdk.component.adexpress.DbA.FC
    public void aGH() {
        this.eli.eli();
    }

    @Override // com.bytedance.sdk.component.adexpress.DbA.FC
    public void eli(boolean z) {
        this.eli.eli(z ? 1 : 0);
    }

    @Override // com.bytedance.sdk.component.adexpress.DbA.FC
    public void ui() {
        this.eli.DbA();
    }

    @Override // com.bytedance.sdk.component.adexpress.DbA.FC
    public void eli(int i, String str) {
        this.eli.eli(i, str);
        du.eli("Web", i, str, this.DbA, this.aGH, this.Os);
    }

    @Override // com.bytedance.sdk.component.adexpress.DbA.FC
    public void eli(int i) {
        this.ui = System.currentTimeMillis();
        if (i == 3) {
            this.eli.Os("dynamic_render2_start");
        } else {
            this.eli.Os("dynamic_render_start");
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.DbA.FC
    public void DbA(int i) {
        if (i == 3) {
            this.eli.aGH("dynamic_sub_analysis2_start");
        } else {
            this.eli.aGH("dynamic_sub_analysis_start");
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.DbA.FC
    public void Os(int i) {
        if (i == 3) {
            this.eli.aGH("dynamic_sub_analysis2_end");
        } else {
            this.eli.aGH("dynamic_sub_analysis_end");
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.DbA.FC
    public void aGH(int i) {
        if (i == 3) {
            this.eli.aGH("dynamic_sub_render2_start");
        } else {
            this.eli.aGH("dynamic_sub_render_start");
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.DbA.FC
    public void ui(int i) {
        if (i == 3) {
            this.eli.aGH("dynamic_sub_render2_end");
        } else {
            this.eli.aGH("dynamic_sub_render_end");
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.DbA.FC
    public void MGA(int i) {
        final String str;
        System.currentTimeMillis();
        if (i == 3) {
            this.eli.kb("dynamic_render2_success");
            str = "dynamic2_render";
        } else {
            this.eli.kb("dynamic_render_success");
            str = "dynamic_backup_native_render";
        }
        this.eli.eli(true);
        cyF.DbA(new com.bytedance.sdk.component.wC.wC("dynamic_success") { // from class: com.bytedance.sdk.openadsdk.core.wC.NU.1
            @Override // java.lang.Runnable
            public void run() {
                com.bytedance.sdk.openadsdk.aGH.Os.DbA(NU.this.Os, NU.this.DbA, str, (JSONObject) null);
            }
        }, 10);
    }

    @Override // com.bytedance.sdk.component.adexpress.DbA.FC
    public void eli(int i, int i2, String str, boolean z) {
        if (!z) {
            this.eli.eli(true);
        }
        if (i == 3) {
            this.eli.DbA(i2, "dynamic_render2_error");
        } else {
            this.eli.DbA(i2, "dynamic_render_error");
        }
        du.eli("NDR", i2, str, this.DbA, this.aGH, this.Os);
    }

    @Override // com.bytedance.sdk.component.adexpress.DbA.FC
    public void MGA() {
        this.eli.Os();
    }

    @Override // com.bytedance.sdk.component.adexpress.DbA.FC
    public void kb() {
        this.eli.eli(true);
        this.eli.NU();
        cyF.DbA(new com.bytedance.sdk.component.wC.wC("native_success") { // from class: com.bytedance.sdk.openadsdk.core.wC.NU.2
            @Override // java.lang.Runnable
            public void run() {
                com.bytedance.sdk.openadsdk.aGH.Os.DbA(NU.this.Os, NU.this.DbA, "dynamic_backup_render", (JSONObject) null);
            }
        }, 10);
    }

    @Override // com.bytedance.sdk.component.adexpress.DbA.FC
    public void wC() {
        this.eli.nn();
    }

    @Override // com.bytedance.sdk.component.adexpress.DbA.FC
    public void FC() {
        this.eli.Dfc();
    }

    @Override // com.bytedance.sdk.component.adexpress.DbA.FC
    public void aAs() {
        this.eli.DbA();
    }

    public void du() {
        this.eli.du();
        this.eli.nlS();
    }

    @Override // com.bytedance.adsdk.ugeno.core.nGm
    public void eli() {
        this.eli.ui("ugen_render_start");
        this.eli.ui("ugen_sub_analysis_start");
    }

    @Override // com.bytedance.adsdk.ugeno.core.nGm
    public void DbA() {
        this.eli.ui("ugen_sub_analysis_end");
    }

    @Override // com.bytedance.adsdk.ugeno.core.nGm
    public void Os() {
        this.eli.ui("ugen_sub_render_start");
    }

    @Override // com.bytedance.adsdk.ugeno.core.nGm
    public void eli(com.bytedance.adsdk.ugeno.core.dV dVVar) {
        if (dVVar.eli() == 0) {
            this.eli.ui("ugen_sub_render_end");
            this.eli.MGA("ugen_render_success");
        } else {
            this.eli.Os(dVVar.eli(), "ugen_render_error");
            du.eli("UGen", dVVar.eli(), dVVar.DbA(), this.DbA, this.aGH, this.Os);
        }
        this.eli.eli(true);
    }
}
