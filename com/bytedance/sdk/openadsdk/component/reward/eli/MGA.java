package com.bytedance.sdk.openadsdk.component.reward.eli;

import android.util.SparseArray;
import android.view.View;
import android.widget.FrameLayout;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.api.PAGExpressAdWrapperListener;
import com.bytedance.sdk.openadsdk.core.DbA.DbA;
import com.bytedance.sdk.openadsdk.core.DbA.Os;
import com.bytedance.sdk.openadsdk.core.model.KM;
import com.bytedance.sdk.openadsdk.core.model.Xb;
import com.bytedance.sdk.openadsdk.utils.dZ;
import java.util.Arrays;
import java.util.HashMap;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class MGA {
    private final eli eli;

    public MGA(eli eliVar) {
        this.eli = eliVar;
    }

    public void eli(float[] fArr, final com.bytedance.sdk.openadsdk.core.nlS.aGH.DbA dbA, final com.bytedance.sdk.openadsdk.component.reward.DbA.DbA dbA2) {
        FrameLayout.LayoutParams layoutParams;
        Arrays.toString(fArr);
        this.eli.ujq.eli(new AdSlot.Builder().setCodeId(String.valueOf(this.eli.DbA.RTg())).setExpressViewAcceptedSize(fArr[0], fArr[1]).build(), this.eli.eU.Dfc);
        if (this.eli.Cp != null && this.eli.ujq != null) {
            this.eli.Cp.eli(this.eli.ujq.eli());
        }
        this.eli.ujq.eli(new com.bytedance.sdk.openadsdk.core.wC.Dfc() { // from class: com.bytedance.sdk.openadsdk.component.reward.eli.MGA.1
            @Override // com.bytedance.sdk.openadsdk.core.wC.Dfc
            public void eli(boolean z, String str) {
                if (MGA.this.eli.tGZ != z) {
                    MGA.this.eli.Cp.eli(str);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.wC.Dfc
            public void eli() {
                MGA.this.eli.Cp.aGH();
            }

            @Override // com.bytedance.sdk.openadsdk.core.wC.Dfc
            public void eli(String str, JSONObject jSONObject) {
                if (MGA.this.eli == null || MGA.this.eli.Uv == null) {
                    return;
                }
                MGA.this.eli.Uv.eli(str, jSONObject);
            }

            @Override // com.bytedance.sdk.openadsdk.core.wC.Dfc
            public boolean eli(JSONObject jSONObject) {
                if (MGA.this.eli == null || MGA.this.eli.ev == null) {
                    return false;
                }
                return MGA.this.eli.ev.eli(jSONObject);
            }

            @Override // com.bytedance.sdk.openadsdk.core.wC.Dfc
            public boolean DbA(JSONObject jSONObject) {
                return com.bytedance.sdk.openadsdk.component.reward.eli.eli(MGA.this.eli);
            }

            @Override // com.bytedance.sdk.openadsdk.core.wC.Dfc
            public void DbA() {
                if (MGA.this.eli.eU == null || MGA.this.eli.eU.aAs() == null) {
                    return;
                }
                MGA.this.eli.eU.aAs().performClick();
            }

            @Override // com.bytedance.sdk.openadsdk.core.wC.Dfc
            public void eli(int i) {
                if (i != 1) {
                    if (i == 2) {
                        MGA.this.eli.ev.nro();
                        return;
                    }
                    if (i == 3) {
                        MGA.this.eli.ev.eli(dbA);
                        return;
                    } else if (i == 4) {
                        MGA.this.eli.ev.nGm();
                        return;
                    } else if (i != 5) {
                        return;
                    }
                }
                if (MGA.this.eli.ev.MGA() || MGA.this.eli.ev.FC()) {
                    return;
                }
                dbA.eli(0L, false);
            }

            @Override // com.bytedance.sdk.openadsdk.core.wC.Dfc
            public long Os() {
                return MGA.this.eli.ev.NU();
            }

            @Override // com.bytedance.sdk.openadsdk.core.wC.Dfc
            public long aGH() {
                return MGA.this.eli.ev.eli();
            }

            @Override // com.bytedance.sdk.openadsdk.core.wC.Dfc
            public int ui() {
                if (MGA.this.eli.ujq.Os()) {
                    return 4;
                }
                if (MGA.this.eli.ujq.aGH()) {
                    return 5;
                }
                if (MGA.this.eli.ev.aAs()) {
                    return 1;
                }
                if (MGA.this.eli.ev.MGA()) {
                    return 2;
                }
                MGA.this.eli.ev.FC();
                return 3;
            }

            @Override // com.bytedance.sdk.openadsdk.core.wC.Dfc
            public void MGA() {
                MGA.this.eli.GB.eli(dbA2);
            }

            @Override // com.bytedance.sdk.openadsdk.core.wC.Dfc
            public void DbA(int i) {
                MGA.this.eli.ow = i;
            }

            @Override // com.bytedance.sdk.openadsdk.core.wC.Dfc
            public void eli(int i, String str) {
                MGA.this.eli.ev.eli(i, str);
            }

            @Override // com.bytedance.sdk.openadsdk.core.wC.Dfc
            public void eli(int i, com.bytedance.sdk.component.adexpress.DbA.nn nnVar) {
                MGA.this.eli.eU.eli(i, nnVar);
            }
        });
        this.eli.ujq.eli(new PAGExpressAdWrapperListener() { // from class: com.bytedance.sdk.openadsdk.component.reward.eli.MGA.2
            @Override // com.bytedance.sdk.openadsdk.api.PAGExpressAdWrapperListener
            public void onAdDismissed() {
            }

            @Override // com.bytedance.sdk.openadsdk.api.PAGExpressAdWrapperListener
            public void onAdShow(View view, int i) {
            }

            @Override // com.bytedance.sdk.openadsdk.api.PAGAdWrapperListener
            public void onAdClicked() {
                if (MGA.this.eli == null || MGA.this.eli.DbA == null || !MGA.this.eli.DbA.Jt()) {
                    return;
                }
                dbA.e_();
            }

            @Override // com.bytedance.sdk.openadsdk.api.PAGExpressAdWrapperListener
            public void onRenderFail(View view, String str, int i) {
                if (!MGA.this.eli.DbA.nie()) {
                    MGA.this.eli.qj.eli(true);
                    MGA.this.eli.qj.ui();
                }
                MGA.this.eli.ujq.ui().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.component.reward.eli.MGA.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        dbA2.eli(false, false, false, 90);
                    }
                });
                MGA.this.eli.eU.NU();
            }

            @Override // com.bytedance.sdk.openadsdk.api.PAGExpressAdWrapperListener
            public void onRenderSuccess(View view, float f, float f2) {
                Xb xb;
                if (KM.dV(MGA.this.eli.DbA)) {
                    return;
                }
                if (!MGA.this.eli.DbA.nie()) {
                    if (!MGA.this.eli.ujq.FC()) {
                        MGA.this.eli.ev.aGH(true);
                    } else {
                        dbA2.eli(true);
                        MGA.this.eli.ev.aGH(false);
                    }
                    MGA.this.eli.eU.eli(8);
                    MGA.this.eli.qj.eli(true);
                    MGA.this.eli.qj.ui();
                    if (MGA.this.eli.ujq.FC()) {
                        MGA.this.eli.ujq.DbA().setBackgroundColor(-16777216);
                        dbA2.eli(MGA.this.eli.eU.MGA());
                    } else if (MGA.this.eli.DbA.nY() != null && dbA2.eli()) {
                        MGA.this.eli.TfR = true;
                    }
                }
                dbA2.ujq();
                if (Xb.Os(MGA.this.eli.DbA) && (xb = MGA.this.eli.eU.Dfc) != null) {
                    xb.Os();
                }
                MGA.this.eli.eU.NU();
            }
        });
        com.bytedance.sdk.openadsdk.core.wC.FC fc = new com.bytedance.sdk.openadsdk.core.wC.FC(this.eli.SSo, this.eli.DbA, this.eli.ui, dZ.eli(this.eli.ui)) { // from class: com.bytedance.sdk.openadsdk.component.reward.eli.MGA.3
            @Override // com.bytedance.sdk.openadsdk.core.DbA.DbA, com.bytedance.sdk.openadsdk.core.DbA.Os
            public void eli(View view, float f, float f2, float f3, float f4, SparseArray<Os.eli> sparseArray, boolean z) {
                super.eli(view, f, f2, f3, f4, sparseArray, z);
            }
        };
        fc.eli(new DbA.eli() { // from class: com.bytedance.sdk.openadsdk.component.reward.eli.MGA.4
            @Override // com.bytedance.sdk.openadsdk.core.DbA.DbA.eli
            public void eli(View view, int i) {
                dbA.e_();
            }
        });
        HashMap hashMap = new HashMap();
        if (KM.dV(this.eli.DbA)) {
            hashMap.put("click_scence", 3);
        } else {
            hashMap.put("click_scence", 1);
        }
        if (this.eli.rH && this.eli.yKf != null) {
            int i = this.eli.yKf.nlS + 1;
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("ad_show_order", i);
                hashMap.put("pag_json_data", jSONObject.toString());
            } catch (Throwable unused) {
            }
        }
        fc.eli(hashMap);
        com.bytedance.sdk.openadsdk.core.wC.wC wCVar = new com.bytedance.sdk.openadsdk.core.wC.wC(this.eli.SSo, this.eli.DbA, this.eli.ui, dZ.eli(this.eli.ui)) { // from class: com.bytedance.sdk.openadsdk.component.reward.eli.MGA.5
            @Override // com.bytedance.sdk.openadsdk.core.DbA.eli, com.bytedance.sdk.openadsdk.core.DbA.DbA, com.bytedance.sdk.openadsdk.core.DbA.Os
            public void eli(View view, float f, float f2, float f3, float f4, SparseArray<Os.eli> sparseArray, boolean z) {
                HashMap hashMap2 = new HashMap();
                hashMap2.put("duration", Long.valueOf(MGA.this.eli.ev.nlS()));
                if (MGA.this.eli.yKf != null) {
                    MGA.this.eli.yKf.eli(hashMap2, f, f2);
                }
                eli(hashMap2);
                super.eli(view, f, f2, f3, f4, sparseArray, z);
            }
        };
        wCVar.eli(new DbA.eli() { // from class: com.bytedance.sdk.openadsdk.component.reward.eli.MGA.6
            @Override // com.bytedance.sdk.openadsdk.core.DbA.DbA.eli
            public void eli(View view, int i2) {
                dbA.e_();
            }
        });
        HashMap hashMap2 = new HashMap();
        if (KM.dV(this.eli.DbA)) {
            hashMap2.put("click_scence", 3);
        } else {
            hashMap2.put("click_scence", 1);
        }
        wCVar.eli(hashMap2);
        this.eli.ujq.eli(fc, wCVar);
        if (this.eli.DbA.nie()) {
            layoutParams = new FrameLayout.LayoutParams(-1, -1);
        } else if (com.bytedance.sdk.openadsdk.core.aAs.aGH.eli(this.eli.DbA.rH())) {
            layoutParams = new FrameLayout.LayoutParams(-1, -1);
        } else if (Xb.Os(this.eli.DbA)) {
            layoutParams = new FrameLayout.LayoutParams(-1, -1);
        } else {
            layoutParams = new FrameLayout.LayoutParams(-2, -2);
        }
        layoutParams.gravity = 17;
        this.eli.eU.MGA().addView(this.eli.ujq.eli(), layoutParams);
        if (!this.eli.ujq.FC()) {
            dbA2.eli(false);
        }
        this.eli.ujq.NU();
    }
}
