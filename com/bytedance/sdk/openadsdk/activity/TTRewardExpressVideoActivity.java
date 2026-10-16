package com.bytedance.sdk.openadsdk.activity;

import android.os.Bundle;
import com.bykv.vk.openvk.eli.eli.eli.aGH.Os;
import com.bytedance.sdk.openadsdk.common.TTAdDislikeToast;
import com.bytedance.sdk.openadsdk.core.model.ev;
import com.bytedance.sdk.openadsdk.utils.Dfc;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class TTRewardExpressVideoActivity extends TTRewardVideoActivity {
    @Override // com.bytedance.sdk.openadsdk.activity.TTBaseVideoActivity
    public boolean Vy() {
        return true;
    }

    @Override // com.bytedance.sdk.openadsdk.activity.TTBaseVideoActivity
    protected void ui() {
    }

    @Override // com.bytedance.sdk.openadsdk.activity.TTRewardVideoActivity, com.bytedance.sdk.openadsdk.activity.TTBaseVideoActivity, com.bytedance.sdk.openadsdk.activity.TTBaseActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        gG();
    }

    @Override // com.bytedance.sdk.openadsdk.activity.TTRewardVideoActivity, com.bytedance.sdk.openadsdk.core.nlS.aGH.DbA
    public boolean eli(long j, boolean z) {
        com.bytedance.sdk.openadsdk.aGH.kb kbVar;
        if (this.DbA.ujq != null && this.DbA.ujq.eli() != null) {
            kbVar = this.DbA.ujq.eli().getAdShowTime();
        } else {
            kbVar = new com.bytedance.sdk.openadsdk.aGH.kb();
        }
        this.DbA.ev.eli(this.DbA.ujq.DbA(), kbVar);
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
        this.DbA.ev.eli(new Os.eli() { // from class: com.bytedance.sdk.openadsdk.activity.TTRewardExpressVideoActivity.1
            boolean eli;

            @Override // com.bykv.vk.openvk.eli.eli.eli.aGH.Os.eli
            public void eli(long j2, int i) {
                if (this.eli) {
                    return;
                }
                this.eli = true;
                TTRewardExpressVideoActivity.this.aGH.removeMessages(300);
                TTRewardExpressVideoActivity.this.bf();
                TTRewardExpressVideoActivity.this.DbA.ev.eli(j2, j2);
                TTRewardExpressVideoActivity.this.DbA.ujq.DbA(true);
                TTRewardExpressVideoActivity.this.nn = (int) (System.currentTimeMillis() / 1000);
                TTRewardExpressVideoActivity.this.ujq();
                if (TTRewardExpressVideoActivity.this.DbA.DbA.mm() == 36 && TTRewardExpressVideoActivity.this.DbA.Os) {
                    TTRewardExpressVideoActivity.this.DbA.Vy.Os().Os(TTRewardExpressVideoActivity.this.DbA.DbA);
                    Dfc.DbA();
                }
                if (TTRewardExpressVideoActivity.this.DbA.DbA.mm() == 21 && !TTRewardExpressVideoActivity.this.DbA.DbA.nn()) {
                    TTRewardExpressVideoActivity.this.DbA.DbA.aGH(true);
                    TTRewardExpressVideoActivity.this.DbA.eU.dV();
                }
                if (TTRewardExpressVideoActivity.this.du && TTRewardExpressVideoActivity.this.DbA.ujq.du()) {
                    return;
                }
                if (TTRewardExpressVideoActivity.this.DbA.Os) {
                    if (TTRewardExpressVideoActivity.this.DbA.DbA.Za()) {
                        if (TTRewardExpressVideoActivity.this.DbA.ujq.aAs() == 1) {
                            TTRewardExpressVideoActivity.this.DbA.Cp.Os();
                            return;
                        }
                        return;
                    } else {
                        TTRewardExpressVideoActivity.this.eli(false, 5);
                        if (ev.ui(TTRewardExpressVideoActivity.this.DbA.DbA)) {
                            return;
                        }
                        TTRewardExpressVideoActivity.this.DbA.ev.eli("skip", true);
                        return;
                    }
                }
                if (TTRewardExpressVideoActivity.this.DbA.DbA.Za()) {
                    if (TTRewardExpressVideoActivity.this.DbA.ujq.aAs() == 1) {
                        TTRewardExpressVideoActivity.this.DbA.Cp.Os();
                    }
                } else {
                    if (!ev.ui(TTRewardExpressVideoActivity.this.DbA.DbA)) {
                        TTRewardExpressVideoActivity.this.DbA.ev.eli("skip", true);
                    }
                    TTRewardExpressVideoActivity.this.finish();
                }
            }

            @Override // com.bykv.vk.openvk.eli.eli.eli.aGH.Os.eli
            public void DbA(long j2, int i) {
                TTRewardExpressVideoActivity.this.aGH.removeMessages(300);
                if (TTRewardExpressVideoActivity.this.DbA.eU.Dfc != null) {
                    TTRewardExpressVideoActivity.this.DbA.eU.Dfc.aAs();
                }
                if (TTRewardExpressVideoActivity.this.DbA.ev.MGA()) {
                    TTRewardExpressVideoActivity.this.Xb();
                    return;
                }
                TTRewardExpressVideoActivity.this.ujq();
                TTRewardExpressVideoActivity.this.DbA.ev.QX();
                if (TTRewardExpressVideoActivity.this.DbA.Os) {
                    TTRewardExpressVideoActivity.this.DbA.ev.eli(!TTRewardExpressVideoActivity.this.DbA.ev.Cp() ? 1 : 0, 2);
                    TTRewardExpressVideoActivity.this.eli(false, 3);
                } else {
                    TTRewardExpressVideoActivity.this.finish();
                }
                TTRewardExpressVideoActivity.this.DbA.ujq.eli(true);
            }

            @Override // com.bykv.vk.openvk.eli.eli.eli.aGH.Os.eli
            public void eli() {
                TTRewardExpressVideoActivity.this.aGH.removeMessages(300);
                TTRewardExpressVideoActivity.this.bf();
                TTRewardExpressVideoActivity.this.ujq();
                if (TTRewardExpressVideoActivity.this.DbA.Os) {
                    TTRewardExpressVideoActivity.this.DbA.ev.eli(!TTRewardExpressVideoActivity.this.DbA.ev.Cp() ? 1 : 0, !TTRewardExpressVideoActivity.this.DbA.ev.Cp() ? 1 : 0);
                    TTRewardExpressVideoActivity.this.eli(false, 6);
                } else {
                    TTRewardExpressVideoActivity.this.finish();
                }
                TTRewardExpressVideoActivity.this.DbA.ev.QX();
            }

            @Override // com.bykv.vk.openvk.eli.eli.eli.aGH.Os.eli
            public void eli(long j2, long j3) {
                if (!TTRewardExpressVideoActivity.this.DbA.WfR && TTRewardExpressVideoActivity.this.DbA.ev.MGA()) {
                    TTRewardExpressVideoActivity.this.DbA.ev.bf();
                }
                if (TTRewardExpressVideoActivity.this.DbA.aAs.get()) {
                    return;
                }
                TTRewardExpressVideoActivity.this.aGH.removeMessages(300);
                if (j2 != TTRewardExpressVideoActivity.this.DbA.ev.NU()) {
                    TTRewardExpressVideoActivity.this.bf();
                }
                if (TTRewardExpressVideoActivity.this.DbA.ev.MGA()) {
                    TTRewardExpressVideoActivity.this.DbA.ev.eli(j2, j3);
                    int YO = TTRewardExpressVideoActivity.this.DbA.DbA.YO();
                    boolean z2 = TTRewardExpressVideoActivity.this.DbA.ujq.FC() && YO >= 0;
                    TTRewardExpressVideoActivity tTRewardExpressVideoActivity = TTRewardExpressVideoActivity.this;
                    long j4 = j2 / 1000;
                    tTRewardExpressVideoActivity.MGA = (int) (tTRewardExpressVideoActivity.DbA.ev.cyF() - j4);
                    int i = (int) j4;
                    if ((TTRewardExpressVideoActivity.this.DbA.Xb.get() || TTRewardExpressVideoActivity.this.DbA.du.get()) && TTRewardExpressVideoActivity.this.DbA.ev.MGA()) {
                        TTRewardExpressVideoActivity.this.DbA.ev.bf();
                    }
                    TTRewardExpressVideoActivity.this.DbA.eU.ui(i);
                    if (TTRewardExpressVideoActivity.this.DbA.ev.aGH()) {
                        if (TTRewardExpressVideoActivity.this.FC != null) {
                            TTRewardExpressVideoActivity.this.FC.eli(j2);
                            return;
                        }
                        return;
                    }
                    if (TTRewardExpressVideoActivity.this.FC == null || !TTRewardExpressVideoActivity.this.FC.eli()) {
                        TTRewardExpressVideoActivity.this.DbA(j2, j3);
                        if (TTRewardExpressVideoActivity.this.DbA.ujq != null && TTRewardExpressVideoActivity.this.DbA.ujq.eli() != null) {
                            TTRewardExpressVideoActivity.this.DbA.ujq.eli().setTime(String.valueOf(TTRewardExpressVideoActivity.this.MGA), i, 0, false);
                            TTRewardExpressVideoActivity.this.DbA.ujq.eli().eli(j2, j3);
                        }
                        if (TTRewardExpressVideoActivity.this.MGA > 0) {
                            if (!z2) {
                                TTRewardExpressVideoActivity.this.DbA.Cp.eli(String.valueOf(TTRewardExpressVideoActivity.this.MGA), null);
                                return;
                            }
                            if (i < YO) {
                                TTRewardExpressVideoActivity.this.DbA.Cp.eli(String.valueOf(TTRewardExpressVideoActivity.this.MGA), null);
                                return;
                            }
                            if (TTRewardExpressVideoActivity.this.DbA.DbA.mm() == 5 || TTRewardExpressVideoActivity.this.DbA.DbA.mm() == 33) {
                                TTRewardExpressVideoActivity.this.DbA.Cp.eli(String.valueOf(TTRewardExpressVideoActivity.this.MGA), null);
                                return;
                            }
                            TTRewardExpressVideoActivity.this.DbA.eli(true);
                            TTRewardExpressVideoActivity.this.DbA.Cp.eli(String.valueOf(TTRewardExpressVideoActivity.this.MGA), TTAdDislikeToast.getSkipText());
                            TTRewardExpressVideoActivity.this.DbA.Cp.ui(true);
                        }
                    }
                }
            }
        });
        boolean eli2 = this.DbA.ev.eli(j, z, hashMap, this.Os);
        if (eli2 && !z) {
            this.NU = (int) (System.currentTimeMillis() / 1000);
        }
        return eli2;
    }
}
