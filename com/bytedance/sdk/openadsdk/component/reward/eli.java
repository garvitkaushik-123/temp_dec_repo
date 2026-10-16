package com.bytedance.sdk.openadsdk.component.reward;

import android.content.Context;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.core.Cp;
import com.bytedance.sdk.openadsdk.core.Ue;
import com.bytedance.sdk.openadsdk.core.dV;
import com.bytedance.sdk.openadsdk.core.model.ev;

/* loaded from: classes3.dex */
public class eli {
    public static void eli(final ev evVar, final boolean z, final boolean z2) {
        com.bytedance.sdk.openadsdk.core.nn.DbA().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.component.reward.eli.1
            @Override // java.lang.Runnable
            public void run() {
                ev evVar2 = ev.this;
                if (evVar2 == null || evVar2.JF()) {
                    return;
                }
                try {
                    Context eli = dV.eli();
                    AdSlot XU = ev.this.XU();
                    if (XU != null) {
                        int DbA = ui.DbA();
                        if (DbA == 0 || DbA == 2) {
                            if (z2) {
                                NU.eli(eli).eli(XU.getCodeId(), ev.this);
                            } else {
                                ui.eli(eli).eli(XU.getCodeId(), ev.this);
                            }
                        }
                        if (z) {
                            if (z2) {
                                NU.eli(eli).eli(XU);
                            } else {
                                ui.eli(eli).eli(XU);
                            }
                        }
                    }
                } catch (Throwable unused) {
                }
            }
        });
    }

    public static boolean eli(final com.bytedance.sdk.openadsdk.component.reward.eli.eli eliVar) {
        com.bytedance.sdk.openadsdk.activity.DbA dbA;
        int i = 0;
        if (eliVar == null) {
            return false;
        }
        if (eliVar.yKf == null || eliVar.yKf.dZ() == null) {
            dbA = null;
        } else {
            dbA = eliVar.yKf.dZ();
            if (dbA != null) {
                i = dbA.gG();
            }
        }
        boolean eli = Cp.eli(eliVar.SSo, eliVar.DbA, eliVar.ui, eliVar.aGH ? 7 : 5, i);
        if (eli) {
            if (eliVar.DbA != null) {
                Ue.eli().eli(eliVar.DbA, new Ue.eli() { // from class: com.bytedance.sdk.openadsdk.component.reward.eli.2
                    @Override // com.bytedance.sdk.openadsdk.core.Ue.eli
                    public void eli() {
                        com.bytedance.sdk.openadsdk.component.reward.eli.eli eliVar2 = com.bytedance.sdk.openadsdk.component.reward.eli.eli.this;
                        if (eliVar2 == null || eliVar2.Uv == null) {
                            return;
                        }
                        com.bytedance.sdk.openadsdk.component.reward.eli.eli.this.Uv.MGA();
                    }
                });
            }
            if (dbA != null && dbA.bf()) {
                dbA.Vy();
            }
        }
        return eli;
    }
}
