package com.bytedance.sdk.openadsdk.component.reward.eli;

import android.R;
import android.os.SystemClock;
import android.util.SparseArray;
import android.view.View;
import com.bytedance.sdk.component.utils.Xb;
import com.bytedance.sdk.openadsdk.Vy.DbA.ui;
import com.bytedance.sdk.openadsdk.component.reward.eli.aGH;
import com.bytedance.sdk.openadsdk.core.DbA.Os;
import com.bytedance.sdk.openadsdk.core.DbA.eli;
import com.bytedance.sdk.openadsdk.core.model.KM;
import com.bytedance.sdk.openadsdk.core.model.ev;
import com.bytedance.sdk.openadsdk.core.model.nlS;
import com.bytedance.sdk.openadsdk.utils.SSo;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class du {
    private final com.bytedance.sdk.openadsdk.core.DbA.DbA DbA;
    private final com.bytedance.sdk.openadsdk.core.DbA.ui Os;
    private final eli eli;

    public du(eli eliVar) {
        this.eli = eliVar;
        this.Os = eli(eliVar, eliVar.DbA);
        this.DbA = new com.bytedance.sdk.openadsdk.core.DbA.DbA(eliVar.SSo, eliVar.DbA, eliVar.ui, eliVar.aGH ? 7 : 5) { // from class: com.bytedance.sdk.openadsdk.component.reward.eli.du.1
            @Override // com.bytedance.sdk.openadsdk.core.DbA.DbA, com.bytedance.sdk.openadsdk.core.DbA.Os
            public void eli(View view, float f, float f2, float f3, float f4, SparseArray<Os.eli> sparseArray, boolean z) {
                try {
                    du.this.eli(view, f, f2, f3, f4, sparseArray, this.VM, this.Ue, this.KM);
                } catch (Exception e) {
                    Xb.Os("TTAD.RFReportManager", "onClickReport error :" + e.getMessage());
                }
                com.bytedance.sdk.openadsdk.Vy.DbA.ui.eli(du.this.eli.DbA, 9);
                du.this.eli.ev.Uv();
            }
        };
    }

    public void eli() {
        com.bytedance.sdk.openadsdk.core.du.aGH eli;
        if (this.eli.NU.get()) {
            return;
        }
        if (this.eli.yKf == null || !this.eli.yKf.dZ().bf() || this.eli.WfR || this.eli.yKf.ow()) {
            JSONObject jSONObject = new JSONObject();
            ev evVar = this.eli.DbA;
            eli(jSONObject);
            if (this.eli.NU.compareAndSet(false, true)) {
                com.bytedance.sdk.openadsdk.aGH.Os.eli(evVar, this.eli.ui, jSONObject);
                this.eli.Uv.FC();
                ui.eli eliVar = new ui.eli(-1);
                eli(eliVar);
                com.bytedance.sdk.openadsdk.Vy.DbA.ui.eli(this.eli.SSo.findViewById(R.id.content), evVar, eliVar);
                com.bytedance.sdk.openadsdk.Vy.eli.Os.eli(evVar);
                com.bytedance.sdk.openadsdk.core.model.aGH UCq = evVar.UCq();
                if (UCq == null || (eli = UCq.eli()) == null) {
                    return;
                }
                eli.eli(0L);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eli(JSONObject jSONObject) {
        if (!this.eli.rH || this.eli.yKf == null) {
            return;
        }
        try {
            com.bytedance.sdk.openadsdk.aGH.Os.eli(this.eli.yKf.nlS + 1, jSONObject);
        } catch (Throwable unused) {
        }
    }

    public void DbA() {
        boolean z;
        if (this.eli.NU.get()) {
            return;
        }
        if (this.eli.yKf == null || !this.eli.yKf.dZ().bf() || this.eli.WfR || this.eli.yKf.ow()) {
            try {
                JSONObject jSONObject = new JSONObject();
                if (!this.eli.DbA.ui() || this.eli.ujq == null) {
                    z = false;
                } else {
                    jSONObject.put("dynamic_show_type", this.eli.ujq.aAs());
                    this.eli.ujq.eli(jSONObject);
                    z = true;
                }
                ev evVar = this.eli.DbA;
                eli(jSONObject);
                View findViewById = this.eli.SSo.findViewById(R.id.content);
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject2.put("width", findViewById.getWidth());
                    jSONObject2.put("height", findViewById.getHeight());
                    jSONObject2.put("alpha", findViewById.getAlpha());
                } catch (Throwable unused) {
                }
                jSONObject.put("root_view", jSONObject2.toString());
                if (this.eli.NU.compareAndSet(false, true)) {
                    com.bytedance.sdk.openadsdk.aGH.Os.eli(evVar, this.eli.ui, jSONObject);
                    this.eli.Uv.FC();
                    ui.eli eliVar = new ui.eli(z ? this.eli.ujq.aAs() : -1);
                    eli(eliVar);
                    com.bytedance.sdk.openadsdk.Vy.DbA.ui.eli(this.eli.SSo.findViewById(R.id.content), evVar, eliVar);
                    com.bytedance.sdk.openadsdk.Vy.eli.Os.eli(evVar);
                }
            } catch (JSONException e) {
                Xb.eli("TTAD.RFReportManager", "reportShowWhenBindVideoAd error", e);
            }
        }
    }

    public void eli(final Map<String, Object> map) {
        if (this.eli.NU.get()) {
            return;
        }
        if (this.eli.yKf == null || !this.eli.yKf.dZ().bf() || this.eli.WfR || this.eli.yKf.ow()) {
            this.eli.NU.set(true);
            final View findViewById = this.eli.SSo.findViewById(R.id.content);
            if (findViewById == null) {
                findViewById = this.eli.SSo.getWindow().getDecorView();
            }
            findViewById.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.component.reward.eli.du.2
                @Override // java.lang.Runnable
                public void run() {
                    Map map2;
                    JSONObject jSONObject;
                    ev evVar = du.this.eli.DbA;
                    JSONObject jSONObject2 = null;
                    try {
                        if (map != null) {
                            jSONObject = new JSONObject(map);
                        } else {
                            jSONObject = new JSONObject();
                        }
                        jSONObject2 = jSONObject;
                        JSONObject jSONObject3 = new JSONObject();
                        jSONObject3.put("width", findViewById.getWidth());
                        jSONObject3.put("height", findViewById.getHeight());
                        jSONObject3.put("alpha", findViewById.getAlpha());
                        jSONObject2.put("root_view", jSONObject3.toString());
                        du.this.eli(jSONObject2);
                    } catch (Throwable th) {
                        Xb.eli("TTAD.RFReportManager", "run: ", th);
                    }
                    com.bytedance.sdk.openadsdk.aGH.Os.eli(evVar, du.this.eli.ui, jSONObject2);
                    du.this.eli.Uv.FC();
                    ui.eli eliVar = new ui.eli(du.this.eli.ujq != null && (map2 = map) != null && map2.containsKey("dynamic_show_type") ? du.this.eli.ujq.aAs() : -1);
                    du.this.eli(eliVar);
                    com.bytedance.sdk.openadsdk.Vy.DbA.ui.eli(du.this.eli.SSo.findViewById(R.id.content), evVar, eliVar);
                    com.bytedance.sdk.openadsdk.Vy.eli.Os.eli(evVar);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eli(ui.eli eliVar) {
        if (!this.eli.rH || this.eli.yKf == null) {
            return;
        }
        eliVar.DbA = this.eli.yKf.nlS;
    }

    public void eli(boolean z) {
        if (this.eli.DbA == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.Dfc.eli.aGH ui = com.bytedance.sdk.openadsdk.Dfc.eli.aGH.DbA().eli(z ? 7 : 8).Os(String.valueOf(this.eli.DbA.RTg())).ui(this.eli.DbA.fO());
        ui.DbA(this.eli.qj.ev()).MGA(this.eli.qj.Vy());
        ui.kb(this.eli.DbA.eu()).aGH(this.eli.DbA.umh());
        com.bytedance.sdk.openadsdk.Dfc.Os.eli().DbA(ui);
    }

    public com.bytedance.sdk.openadsdk.core.DbA.ui Os() {
        this.Os.eli(this.eli.SSo.findViewById(R.id.content));
        this.Os.DbA(this.eli.dZ.findViewById(520093713));
        if (this.eli.Vy.Os() != null) {
            this.Os.eli(this.eli.Vy.Os());
        }
        this.eli.gG.eli(this.Os);
        this.Os.eli(new eli.InterfaceC0172eli() { // from class: com.bytedance.sdk.openadsdk.component.reward.eli.du.3
            @Override // com.bytedance.sdk.openadsdk.core.DbA.eli.InterfaceC0172eli
            public long getVideoProgress() {
                return du.this.eli.ev.nlS();
            }
        });
        com.bytedance.sdk.openadsdk.component.reward.view.nlS nls = this.eli.eU;
        com.bytedance.sdk.openadsdk.core.DbA.ui uiVar = this.Os;
        nls.eli(uiVar, uiVar, this.DbA);
        this.eli.cyF.eli(this.Os);
        return this.Os;
    }

    public com.bytedance.sdk.openadsdk.core.DbA.DbA aGH() {
        return this.DbA;
    }

    public com.bytedance.sdk.openadsdk.core.DbA.ui ui() {
        return this.Os;
    }

    public void DbA(boolean z) {
        eli eliVar = this.eli;
        if (eliVar == null) {
            return;
        }
        if (!z && eliVar.NU.get() && this.eli.BDs > 0) {
            com.bytedance.sdk.openadsdk.aGH.Os.eli(String.valueOf(SystemClock.elapsedRealtime() - this.eli.BDs), this.eli.DbA, this.eli.ui, this.eli.ev.ui());
            this.eli.BDs = 0L;
        } else {
            this.eli.BDs = SystemClock.elapsedRealtime();
        }
        com.bytedance.sdk.openadsdk.Vy.DbA.ui.eli(this.eli.DbA, z ? 4 : 8);
        com.bytedance.sdk.openadsdk.Vy.eli.Os.eli(this.eli.DbA, z ? 4 : 8);
    }

    public void MGA() {
        JSONObject jSONObject = new JSONObject();
        if (KM.dV(this.eli.DbA)) {
            this.eli.gG.eli(jSONObject);
        }
        int i = 1;
        try {
            if (this.eli.aAs.get()) {
                if (!this.eli.qj.Os()) {
                    if (this.eli.nro.aGH()) {
                        i = 3;
                    } else {
                        i = this.eli.qj.aGH() ? 2 : 0;
                    }
                }
                jSONObject.put("endcard_content", i);
            } else {
                jSONObject.put("endCardNotShow", 1);
            }
        } catch (JSONException unused) {
        }
        com.bytedance.sdk.openadsdk.aGH.Os.DbA(this.eli.DbA, this.eli.ui, "click_close", jSONObject);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eli(View view, float f, float f2, float f3, float f4, SparseArray<Os.eli> sparseArray, int i, int i2, int i3) {
        if (view == null) {
            return;
        }
        if (view.getId() == com.bytedance.sdk.openadsdk.utils.aqO.ui) {
            eli("click_play_star_level", (JSONObject) null);
        } else if (view.getId() == com.bytedance.sdk.openadsdk.utils.aqO.aGH || view.getId() == com.bytedance.sdk.openadsdk.utils.aqO.kb) {
            eli("click_play_star_nums", (JSONObject) null);
        } else if (view.getId() == com.bytedance.sdk.openadsdk.utils.aqO.Os) {
            eli("click_play_source", (JSONObject) null);
        } else if (view.getId() == com.bytedance.sdk.openadsdk.utils.aqO.DbA) {
            eli("click_play_logo", (JSONObject) null);
        } else if (view.getId() == com.bytedance.sdk.openadsdk.utils.aqO.nlS || view.getId() == com.bytedance.sdk.openadsdk.utils.aqO.iuv || view.getId() == com.bytedance.sdk.openadsdk.utils.aqO.dV) {
            eli("click_start_play_bar", FC());
        } else if (view.getId() == 520093705) {
            eli("click_start_play", FC());
        } else if (view.getId() == com.bytedance.sdk.openadsdk.utils.aqO.du) {
            eli("click_video", FC());
        } else if (view.getId() == 520093707 || view.getId() == com.bytedance.sdk.openadsdk.utils.aqO.wC) {
            eli("fallback_endcard_click", FC());
        }
        DbA(view, f, f2, f3, f4, sparseArray, i, i2, i3);
    }

    private void DbA(View view, float f, float f2, float f3, float f4, SparseArray<Os.eli> sparseArray, int i, int i2, int i3) {
        if (!wC() || this.eli.DbA == null || view == null) {
            return;
        }
        int id = view.getId();
        if (id == com.bytedance.sdk.openadsdk.utils.aqO.ui || id == com.bytedance.sdk.openadsdk.utils.aqO.aGH || id == com.bytedance.sdk.openadsdk.utils.aqO.Os || id == com.bytedance.sdk.openadsdk.utils.aqO.DbA || id == com.bytedance.sdk.openadsdk.utils.aqO.nlS || id == com.bytedance.sdk.openadsdk.utils.aqO.iuv || id == com.bytedance.sdk.openadsdk.utils.aqO.dV || id == 520093705 || id == com.bytedance.sdk.openadsdk.utils.aqO.du || id == 520093707 || id == com.bytedance.sdk.openadsdk.utils.aqO.kb) {
            int aAs = SSo.aAs(com.bytedance.sdk.openadsdk.core.dV.eli());
            com.bytedance.sdk.openadsdk.core.model.nlS eli = new nlS.eli().MGA(f).ui(f2).aGH(f3).Os(f4).DbA(System.currentTimeMillis()).eli(0L).DbA(SSo.eli(this.eli.eU.du())).eli(SSo.eli((View) null)).Os(SSo.Os(this.eli.eU.du())).aGH(SSo.Os((View) null)).aGH(i2).ui(i3).MGA(i).eli(sparseArray).DbA(com.bytedance.sdk.openadsdk.core.FC.DbA().eli() ? 1 : 2).Os(aAs).eli(SSo.wC(com.bytedance.sdk.openadsdk.core.dV.eli())).DbA(SSo.FC(com.bytedance.sdk.openadsdk.core.dV.eli())).eli();
            HashMap hashMap = new HashMap();
            hashMap.put("duration", Long.valueOf(this.eli.ev.nlS()));
            com.bytedance.sdk.openadsdk.aGH.Os.eli("click_other", this.eli.DbA, eli, this.eli.ui, true, (Map<String, Object>) hashMap, -1);
        }
    }

    private boolean wC() {
        return this.eli.DbA != null && this.eli.DbA.QW() == 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eli(String str, JSONObject jSONObject) {
        ev evVar = this.eli.DbA;
        String str2 = this.eli.ui;
        if (!this.eli.aGH) {
            jSONObject = null;
        }
        com.bytedance.sdk.openadsdk.aGH.Os.eli(evVar, str2, str, jSONObject);
    }

    private JSONObject FC() {
        try {
            long CMM = this.eli.ev.CMM();
            int ev = this.eli.ev.ev();
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("duration", CMM);
                jSONObject.put("percent", ev);
                return jSONObject;
            } catch (Throwable unused) {
                return jSONObject;
            }
        } catch (Throwable unused2) {
            return null;
        }
    }

    public void Os(boolean z) {
        eli eliVar = this.eli;
        if (eliVar != null && z && eliVar.DbA.ip() && !this.eli.DbA.CMM()) {
            this.eli.DbA.MGA(true);
            com.bytedance.sdk.openadsdk.aGH.Os.eli(this.eli.DbA, this.eli.ui, this.eli.DbA.nU());
        }
    }

    public void kb() {
        JSONObject jSONObject = new JSONObject();
        eli(jSONObject);
        com.bytedance.sdk.openadsdk.aGH.Os.ui(this.eli.DbA, this.eli.ui, jSONObject);
    }

    public com.bytedance.sdk.openadsdk.core.DbA.ui eli(final eli eliVar, final ev evVar) {
        return new com.bytedance.sdk.openadsdk.core.DbA.ui(eliVar.SSo, evVar, eliVar.ui, eliVar.aGH ? 7 : 5) { // from class: com.bytedance.sdk.openadsdk.component.reward.eli.du.4
            @Override // com.bytedance.sdk.openadsdk.core.DbA.ui
            public void eli(View view, float f, float f2, float f3, float f4, SparseArray<Os.eli> sparseArray, int i, int i2, int i3, boolean z) {
                if (evVar.Kv() && view != null) {
                    Object tag = view.getTag(570425345);
                    if (tag instanceof String) {
                        eli((String) tag);
                    }
                }
                HashMap hashMap = new HashMap();
                hashMap.put("duration", Long.valueOf(eliVar.ev.nlS()));
                if (eliVar.aAs.get()) {
                    hashMap.put("click_scence", 2);
                } else if (KM.dV(evVar)) {
                    hashMap.put("click_scence", 3);
                } else {
                    hashMap.put("click_scence", 1);
                }
                if (eliVar.yKf != null) {
                    eliVar.yKf.eli(hashMap, f, f2);
                }
                eli(hashMap);
                eliVar.Uv.e_();
                if (view.getId() == com.bytedance.sdk.openadsdk.utils.aqO.ILu && KM.dV(evVar)) {
                    JSONObject jSONObject = new JSONObject();
                    if (evVar.nY() != null) {
                        try {
                            jSONObject.put("playable_url", evVar.nY().nlS());
                        } catch (JSONException e) {
                            Xb.eli("TTAD.RFReportManager", "onRewardBarClick json error", e);
                        }
                    }
                    com.bytedance.sdk.openadsdk.aGH.Os.DbA(evVar, eliVar.ui, "click_playable_download_button_loading", jSONObject);
                }
                eliVar.Vy.eli(view, f, f2, f3, f4, sparseArray, i, i2, i3, new aGH.eli() { // from class: com.bytedance.sdk.openadsdk.component.reward.eli.du.4.1
                    @Override // com.bytedance.sdk.openadsdk.component.reward.eli.aGH.eli
                    public void eli(String str, JSONObject jSONObject2) {
                        du.this.eli(str, jSONObject2);
                    }

                    @Override // com.bytedance.sdk.openadsdk.component.reward.eli.aGH.eli
                    public void eli(View view2, float f5, float f6, float f7, float f8, SparseArray<Os.eli> sparseArray2, int i4, int i5, int i6) {
                        du.this.eli(view2, f5, f6, f7, f8, sparseArray2, i4, i5, i6);
                    }
                });
                com.bytedance.sdk.openadsdk.Vy.DbA.ui.eli(evVar, 9);
                eliVar.ev.Uv();
            }
        };
    }
}
