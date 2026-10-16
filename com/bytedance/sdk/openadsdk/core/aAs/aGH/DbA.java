package com.bytedance.sdk.openadsdk.core.aAs.aGH;

import android.R;
import android.app.Activity;
import android.content.ComponentCallbacks2;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import com.bytedance.adsdk.ugeno.DbA.Os;
import com.bytedance.adsdk.ugeno.core.NU;
import com.bytedance.adsdk.ugeno.core.aqO;
import com.bytedance.sdk.openadsdk.QX.eli.eli.kb;
import com.bytedance.sdk.openadsdk.activity.TTWebsiteActivity;
import com.bytedance.sdk.openadsdk.core.Cp;
import com.bytedance.sdk.openadsdk.core.aAs.aGH.eli;
import com.bytedance.sdk.openadsdk.core.aAs.eli.DbA;
import com.bytedance.sdk.openadsdk.core.aAs.kb.aGH;
import com.bytedance.sdk.openadsdk.core.dV;
import com.bytedance.sdk.openadsdk.core.model.ev;
import com.bytedance.sdk.openadsdk.utils.dZ;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class DbA implements aqO, eli.InterfaceC0182eli {
    protected static int eli = 8;
    private eli DbA;
    private float Dfc;
    private JSONObject FC;
    private String MGA;
    private View NU;
    private final Activity Os;
    private long QX;
    private boolean Xb = true;
    private final com.bytedance.sdk.openadsdk.core.aAs.kb.DbA aAs;
    private final ev aGH;
    private float aqO;
    private float dV;
    private com.bytedance.sdk.openadsdk.core.aAs.kb.eli du;
    private String kb;
    private long nGm;
    private String nlS;
    private float nn;
    private final com.bytedance.sdk.openadsdk.core.aAs.wC.eli ui;
    private String wC;

    public DbA(Activity activity, ev evVar, com.bytedance.sdk.openadsdk.core.aAs.wC.eli eliVar, String str, com.bytedance.sdk.openadsdk.core.aAs.kb.DbA dbA) {
        this.Os = activity;
        this.nlS = str;
        this.aGH = evVar;
        this.aAs = dbA;
        this.ui = eliVar;
    }

    public void eli() {
        if (this.aGH == null) {
            this.aAs.eli(1, "material is null", "net");
            return;
        }
        if (this.ui == null) {
            this.aAs.eli(1, "material ugen template is null", "net");
            return;
        }
        this.DbA = new eli(this.Os);
        this.wC = this.ui.Os();
        this.MGA = this.ui.eli();
        this.kb = this.ui.DbA();
        this.FC = this.aGH.iOb();
        this.aAs.eli("endcard");
        com.bytedance.sdk.openadsdk.core.aAs.eli.DbA.eli().eli("endcard", this.wC, this.MGA, this.kb, "", new DbA.eli() { // from class: com.bytedance.sdk.openadsdk.core.aAs.aGH.DbA.1
            @Override // com.bytedance.sdk.openadsdk.core.aAs.eli.DbA.eli
            public void eli(JSONObject jSONObject, String str) {
                DbA dbA = DbA.this;
                dbA.eli(jSONObject, dbA.FC);
                DbA.this.aAs.DbA(str);
            }

            @Override // com.bytedance.sdk.openadsdk.core.aAs.eli.DbA.eli
            public void eli(int i, String str, String str2) {
                DbA.this.aAs.eli(i, str, str2);
            }
        });
    }

    public void eli(View view) {
        this.NU = view;
    }

    public void eli(com.bytedance.sdk.openadsdk.core.aAs.kb.eli eliVar) {
        this.du = eliVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eli(JSONObject jSONObject, JSONObject jSONObject2) {
        this.DbA.eli((eli.InterfaceC0182eli) this);
        this.DbA.eli((aqO) this);
        this.aAs.eli();
        this.DbA.eli(jSONObject, jSONObject2, new aGH() { // from class: com.bytedance.sdk.openadsdk.core.aAs.aGH.DbA.2
            @Override // com.bytedance.sdk.openadsdk.core.aAs.kb.aGH
            public void eli(int i, String str) {
                if (DbA.this.aAs != null) {
                    DbA.this.aAs.eli(i, str);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.aAs.kb.aGH
            public void eli(Os<View> os) {
                if (DbA.this.aAs != null) {
                    DbA.this.aAs.eli(os);
                }
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.core.aAs.aGH.eli.InterfaceC0182eli
    public void eli(NU nu) {
        String optString = nu.Os().optString("type");
        optString.hashCode();
        switch (optString) {
            case "privacy":
                if (this.Os != null && !TextUtils.isEmpty(dV.aGH().oWW())) {
                    TTWebsiteActivity.eli(this.Os, this.aGH, this.nlS);
                    break;
                }
                break;
            case "close":
                com.bytedance.sdk.openadsdk.core.aAs.kb.eli eliVar = this.du;
                if (eliVar != null) {
                    eliVar.DbA();
                    break;
                }
                break;
            case "creative":
                if (this.Os != null && this.aGH != null) {
                    DbA();
                    ComponentCallbacks2 componentCallbacks2 = this.Os;
                    if (componentCallbacks2 instanceof com.bytedance.sdk.openadsdk.core.nlS.aGH.DbA) {
                        ((com.bytedance.sdk.openadsdk.core.nlS.aGH.DbA) componentCallbacks2).MGA();
                    }
                    eli(nu, this.aGH);
                    break;
                }
                break;
        }
    }

    private void DbA() {
        int yw = this.aGH.yw();
        if (yw != 2 && yw != 3) {
            if (yw == 4) {
                kb.eli(this.Os, this.nlS).Os(this.aGH);
                return;
            } else {
                if (yw != 5) {
                    return;
                }
                dZ.DbA(this.Os, this.aGH.lYL());
                return;
            }
        }
        if (yw == 3) {
            String dM = this.aGH.dM();
            if (!TextUtils.isEmpty(dM) && dM.contains("play.google.com/store")) {
                if (com.bytedance.sdk.openadsdk.QX.eli.eli.aGH.eli(this.Os, dM, dM.substring(dM.indexOf("?id=") + 4), this.nlS, this.aGH)) {
                    return;
                }
            }
        }
        Activity activity = this.Os;
        ev evVar = this.aGH;
        int eli2 = dZ.eli(this.nlS);
        String str = this.nlS;
        Cp.eli(activity, evVar, eli2, null, null, str, kb.eli(this.Os, str), true, 0);
    }

    private void eli(NU nu, ev evVar) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("down_x", this.nn);
            jSONObject.put("down_y", this.Dfc);
            jSONObject.put("down_time", this.nGm);
            jSONObject.put("up_x", this.aqO);
            jSONObject.put("up_y", this.dV);
            jSONObject.put("up_time", this.QX);
            View du = nu.eli().du();
            int i = 1;
            if (du != null) {
                JSONObject jSONObject2 = new JSONObject();
                int[] iArr = new int[2];
                float width = du.getWidth();
                float height = du.getHeight();
                du.getLocationOnScreen(iArr);
                float f = iArr[0];
                float f2 = iArr[1];
                jSONObject2.put("width", width);
                jSONObject2.put("height", height);
                jSONObject2.put("left", f);
                jSONObject2.put("top", f2);
                jSONObject.put("rectInfo", jSONObject2);
            }
            View view = this.NU;
            if (view != null) {
                int[] iArr2 = new int[2];
                view.getLocationOnScreen(iArr2);
                jSONObject.put("button_x", iArr2[0]);
                jSONObject.put("button_y", iArr2[1]);
                jSONObject.put("button_width", this.NU.getWidth());
                jSONObject.put("button_height", this.NU.getHeight());
            }
            View findViewById = this.Os.findViewById(R.id.content);
            if (findViewById != null) {
                int[] iArr3 = new int[2];
                findViewById.getLocationOnScreen(iArr3);
                jSONObject.put("ad_x", iArr3[0]);
                jSONObject.put("ad_y", iArr3[1]);
                jSONObject.put("width", findViewById.getWidth());
                jSONObject.put("height", findViewById.getHeight());
            }
            jSONObject.put("click_area_type", nu.eli().Cp());
            jSONObject.put("brick_id", nu.eli().nro());
            jSONObject.put("endcard_id", this.MGA);
            jSONObject.put("click_scence", 2);
            if (!this.Xb) {
                i = 2;
            }
            jSONObject.put("user_behavior_type", i);
            com.bytedance.sdk.openadsdk.core.aAs.kb.eli eliVar = this.du;
            if (eliVar != null) {
                jSONObject.put("endcard_type", eliVar.eli());
            }
            com.bytedance.sdk.openadsdk.aGH.Os.eli(evVar, this.nlS, "click", jSONObject);
        } catch (JSONException unused) {
        }
    }

    @Override // com.bytedance.adsdk.ugeno.core.aqO
    public void eli(Os os, MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            this.nGm = System.currentTimeMillis();
            this.nn = motionEvent.getRawX();
            this.Dfc = motionEvent.getRawY();
            this.Xb = true;
            return;
        }
        if (action != 1) {
            if (action != 2) {
                return;
            }
            if (Math.abs(motionEvent.getRawX() - this.nn) >= eli || Math.abs(motionEvent.getRawY() - this.Dfc) >= eli) {
                this.Xb = false;
                return;
            }
            return;
        }
        this.aqO = motionEvent.getRawX();
        this.dV = motionEvent.getRawY();
        if (Math.abs(this.aqO - this.nn) >= eli || Math.abs(this.dV - this.Dfc) >= eli) {
            this.Xb = false;
        }
        this.QX = System.currentTimeMillis();
    }
}
