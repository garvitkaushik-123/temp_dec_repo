package com.bytedance.sdk.openadsdk.activity;

import android.os.Bundle;
import com.bykv.vk.openvk.eli.eli.eli.aGH.Os;
import com.bytedance.sdk.openadsdk.core.model.ev;
import com.bytedance.sdk.openadsdk.utils.Dfc;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class TTFullScreenExpressVideoActivity extends TTFullScreenVideoActivity {
    @Override // com.bytedance.sdk.openadsdk.activity.TTBaseVideoActivity
    public boolean Vy() {
        return true;
    }

    @Override // com.bytedance.sdk.openadsdk.activity.TTBaseVideoActivity
    protected void ui() {
    }

    @Override // com.bytedance.sdk.openadsdk.activity.TTFullScreenVideoActivity, com.bytedance.sdk.openadsdk.activity.TTBaseVideoActivity, com.bytedance.sdk.openadsdk.activity.TTBaseActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        gG();
    }

    @Override // com.bytedance.sdk.openadsdk.activity.TTFullScreenVideoActivity, com.bytedance.sdk.openadsdk.core.nlS.aGH.DbA
    public boolean eli(long j, boolean z) {
        com.bytedance.sdk.openadsdk.aGH.kb kbVar;
        if (this.DbA.ujq != null && this.DbA.ujq.eli() != null) {
            kbVar = this.DbA.ujq.eli().getAdShowTime();
        } else {
            kbVar = new com.bytedance.sdk.openadsdk.aGH.kb();
        }
        if (this.Os != null && (this.Os instanceof com.bytedance.sdk.openadsdk.component.reward.DbA.wC) && !this.DbA.TfR) {
            this.DbA.ev.eli(((com.bytedance.sdk.openadsdk.component.reward.DbA.wC) this.Os).VM(), kbVar);
        } else {
            this.DbA.ev.eli(this.DbA.ujq.DbA(), kbVar);
        }
        HashMap hashMap = new HashMap();
        if (this.DbA.ujq != null) {
            hashMap.put("dynamic_show_type", Integer.valueOf(this.DbA.ujq.aAs()));
            JSONObject eli = this.DbA.ujq.eli((JSONObject) null);
            if (eli != null) {
                Iterator<String> keys = eli.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    try {
                        hashMap.put(next, eli.get(next));
                    } catch (JSONException unused) {
                    }
                }
            }
        }
        this.DbA.ev.eli(new Os.eli() { // from class: com.bytedance.sdk.openadsdk.activity.TTFullScreenExpressVideoActivity.1
            boolean eli;

            @Override // com.bykv.vk.openvk.eli.eli.eli.aGH.Os.eli
            public void eli(long j2, int i) {
                if (this.eli) {
                    return;
                }
                this.eli = true;
                TTFullScreenExpressVideoActivity.this.aGH.removeMessages(300);
                TTFullScreenExpressVideoActivity.this.bf();
                TTFullScreenExpressVideoActivity.this.DbA.ev.eli(j2, j2);
                TTFullScreenExpressVideoActivity.this.DbA.ujq.DbA(true);
                if (TTFullScreenExpressVideoActivity.this.DbA.DbA.mm() == 36 && TTFullScreenExpressVideoActivity.this.DbA.Os) {
                    TTFullScreenExpressVideoActivity.this.DbA.Vy.Os().Os(TTFullScreenExpressVideoActivity.this.DbA.DbA);
                    Dfc.DbA();
                }
                if (TTFullScreenExpressVideoActivity.this.DbA.DbA.mm() == 21 && !TTFullScreenExpressVideoActivity.this.DbA.DbA.nn()) {
                    TTFullScreenExpressVideoActivity.this.DbA.DbA.aGH(true);
                    TTFullScreenExpressVideoActivity.this.DbA.eU.dV();
                }
                if (TTFullScreenExpressVideoActivity.this.du && TTFullScreenExpressVideoActivity.this.DbA.ujq.du()) {
                    return;
                }
                if (TTFullScreenExpressVideoActivity.this.DbA.Os) {
                    if (TTFullScreenExpressVideoActivity.this.DbA.DbA.Za()) {
                        if (TTFullScreenExpressVideoActivity.this.DbA.ujq.aAs() == 1) {
                            TTFullScreenExpressVideoActivity.this.DbA.Cp.Os();
                            return;
                        }
                        return;
                    } else {
                        TTFullScreenExpressVideoActivity.this.eli(false, 5);
                        if (ev.ui(TTFullScreenExpressVideoActivity.this.DbA.DbA)) {
                            return;
                        }
                        TTFullScreenExpressVideoActivity.this.DbA.ev.eli("skip", true);
                        return;
                    }
                }
                if (ev.ui(TTFullScreenExpressVideoActivity.this.DbA.DbA)) {
                    TTFullScreenExpressVideoActivity.this.finish();
                    return;
                }
                if (TTFullScreenExpressVideoActivity.this.DbA.ujq == null || TTFullScreenExpressVideoActivity.this.DbA.ujq.eli() == null) {
                    return;
                }
                TTFullScreenExpressVideoActivity.this.DbA.ujq.eli().setTime("0", 0, 0, false);
                if (TTFullScreenExpressVideoActivity.this.DbA.ujq.FC()) {
                    TTFullScreenExpressVideoActivity.this.DbA.Cp.eli("0", "X");
                    TTFullScreenExpressVideoActivity.this.DbA.Cp.ui(true);
                    TTFullScreenExpressVideoActivity.this.DbA.Cp.Os();
                }
            }

            @Override // com.bykv.vk.openvk.eli.eli.eli.aGH.Os.eli
            public void DbA(long j2, int i) {
                TTFullScreenExpressVideoActivity.this.aGH.removeMessages(300);
                if (TTFullScreenExpressVideoActivity.this.DbA.eU.Dfc != null) {
                    TTFullScreenExpressVideoActivity.this.DbA.eU.Dfc.aAs();
                }
                if (TTFullScreenExpressVideoActivity.this.DbA.ev.MGA()) {
                    TTFullScreenExpressVideoActivity.this.Xb();
                    return;
                }
                TTFullScreenExpressVideoActivity.this.DbA.ev.QX();
                new Object[]{"fullscreen_interstitial_ad", "onError、、、、、、、、"};
                TTFullScreenExpressVideoActivity.this.DbA.ujq.eli(true);
                if (TTFullScreenExpressVideoActivity.this.DbA.Os) {
                    TTFullScreenExpressVideoActivity.this.eli(false, 3);
                    TTFullScreenExpressVideoActivity.this.DbA.ev.eli(1 ^ (TTFullScreenExpressVideoActivity.this.DbA.ev.Cp() ? 1 : 0), 2);
                } else {
                    TTFullScreenExpressVideoActivity.this.finish();
                }
            }

            @Override // com.bykv.vk.openvk.eli.eli.eli.aGH.Os.eli
            public void eli() {
                TTFullScreenExpressVideoActivity.this.aGH.removeMessages(300);
                TTFullScreenExpressVideoActivity.this.bf();
                new Object[]{"fullscreen_interstitial_ad", "onTimeOut、、、、、、、、"};
                if (TTFullScreenExpressVideoActivity.this.DbA.Os) {
                    TTFullScreenExpressVideoActivity.this.DbA.ev.eli(!TTFullScreenExpressVideoActivity.this.DbA.ev.Cp() ? 1 : 0, !TTFullScreenExpressVideoActivity.this.DbA.ev.Cp() ? 1 : 0);
                    TTFullScreenExpressVideoActivity.this.eli(false, 6);
                } else {
                    TTFullScreenExpressVideoActivity.this.finish();
                }
                TTFullScreenExpressVideoActivity.this.DbA.ev.QX();
            }

            @Override // com.bykv.vk.openvk.eli.eli.eli.aGH.Os.eli
            public void eli(long j2, long j3) {
                if (!TTFullScreenExpressVideoActivity.this.DbA.WfR && TTFullScreenExpressVideoActivity.this.DbA.ev.MGA()) {
                    TTFullScreenExpressVideoActivity.this.DbA.ev.bf();
                }
                if (TTFullScreenExpressVideoActivity.this.DbA.aAs.get()) {
                    return;
                }
                TTFullScreenExpressVideoActivity.this.aGH.removeMessages(300);
                if (j2 != TTFullScreenExpressVideoActivity.this.DbA.ev.NU()) {
                    TTFullScreenExpressVideoActivity.this.bf();
                }
                if (TTFullScreenExpressVideoActivity.this.DbA.ev.MGA()) {
                    TTFullScreenExpressVideoActivity.this.DbA.ev.eli(j2, j3);
                    TTFullScreenExpressVideoActivity tTFullScreenExpressVideoActivity = TTFullScreenExpressVideoActivity.this;
                    long j4 = j2 / 1000;
                    tTFullScreenExpressVideoActivity.MGA = (int) (tTFullScreenExpressVideoActivity.DbA.ev.cyF() - j4);
                    int i = (int) j4;
                    if ((TTFullScreenExpressVideoActivity.this.DbA.Xb.get() || TTFullScreenExpressVideoActivity.this.DbA.du.get()) && TTFullScreenExpressVideoActivity.this.DbA.ev.MGA()) {
                        TTFullScreenExpressVideoActivity.this.DbA.ev.bf();
                    }
                    if (TTFullScreenExpressVideoActivity.this.DbA.ev.aGH()) {
                        if (TTFullScreenExpressVideoActivity.this.FC != null) {
                            TTFullScreenExpressVideoActivity.this.FC.eli(j2);
                            return;
                        }
                        return;
                    }
                    if (TTFullScreenExpressVideoActivity.this.FC == null || !TTFullScreenExpressVideoActivity.this.FC.eli()) {
                        if (TTFullScreenExpressVideoActivity.this.DbA.ujq != null && TTFullScreenExpressVideoActivity.this.DbA.ujq.eli() != null) {
                            TTFullScreenExpressVideoActivity.this.DbA.ujq.eli().setTime(String.valueOf(TTFullScreenExpressVideoActivity.this.MGA), i, 0, false);
                            TTFullScreenExpressVideoActivity.this.DbA.ujq.eli().eli(j2, j3);
                        }
                        if (TTFullScreenExpressVideoActivity.this.DbA.ujq.FC() || TTFullScreenExpressVideoActivity.this.DbA.DbA.nie()) {
                            TTFullScreenExpressVideoActivity.this.Os(i);
                            if (TTFullScreenExpressVideoActivity.this.MGA >= 0) {
                                TTFullScreenExpressVideoActivity.this.DbA.Cp.aGH(true);
                                TTFullScreenExpressVideoActivity.this.DbA.Cp.eli(String.valueOf(TTFullScreenExpressVideoActivity.this.MGA), null);
                            }
                        }
                    }
                }
            }
        });
        return this.DbA.ev.eli(j, z, hashMap, this.Os);
    }
}
