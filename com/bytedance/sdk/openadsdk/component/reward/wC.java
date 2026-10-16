package com.bytedance.sdk.openadsdk.component.reward;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.RemoteException;
import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.sdk.component.utils.DbA;
import com.bytedance.sdk.component.utils.Xb;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.IListenerManager;
import com.bytedance.sdk.openadsdk.activity.TTAdActivity;
import com.bytedance.sdk.openadsdk.activity.TTRewardExpressVideoActivity;
import com.bytedance.sdk.openadsdk.activity.TTRewardVideoActivity;
import com.bytedance.sdk.openadsdk.api.reward.PAGRewardedAd;
import com.bytedance.sdk.openadsdk.api.reward.PAGRewardedAdInteractionCallback;
import com.bytedance.sdk.openadsdk.api.reward.PAGRewardedAdInteractionListener;
import com.bytedance.sdk.openadsdk.core.Ue;
import com.bytedance.sdk.openadsdk.core.dV;
import com.bytedance.sdk.openadsdk.core.model.ev;
import com.bytedance.sdk.openadsdk.oem.IPMiBroadcastReceiver;
import com.bytedance.sdk.openadsdk.utils.GB;
import com.bytedance.sdk.openadsdk.utils.cyF;
import com.bytedance.sdk.openadsdk.utils.gG;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes3.dex */
class wC extends PAGRewardedAd {
    private final com.bytedance.sdk.openadsdk.core.model.eli DbA;
    private boolean FC;
    private final AdSlot Os;
    private com.bytedance.sdk.openadsdk.eli.ui.eli aGH;
    private final Context eli;
    private boolean ui;
    private boolean wC;
    private final AtomicBoolean MGA = new AtomicBoolean(false);
    private final String kb = gG.eli();

    wC(Context context, com.bytedance.sdk.openadsdk.core.model.eli eliVar, AdSlot adSlot) {
        this.eli = context;
        this.DbA = eliVar;
        this.Os = adSlot;
    }

    public void eli() {
        if (this.MGA.get()) {
            return;
        }
        this.ui = true;
    }

    @Override // com.bytedance.sdk.openadsdk.api.reward.PAGRewardedAd
    public void setAdInteractionListener(PAGRewardedAdInteractionListener pAGRewardedAdInteractionListener) {
        this.aGH = new FC(pAGRewardedAdInteractionListener);
        eli(0);
    }

    @Override // com.bytedance.sdk.openadsdk.api.reward.PAGRewardedAd
    public void setAdInteractionCallback(PAGRewardedAdInteractionCallback pAGRewardedAdInteractionCallback) {
        this.aGH = new FC(pAGRewardedAdInteractionCallback);
        eli(0);
    }

    @Override // com.bytedance.sdk.openadsdk.api.reward.PAGRewardedAd
    public void show(Activity activity) {
        Intent intent;
        if (activity != null && activity.isFinishing()) {
            activity = null;
        }
        com.bytedance.sdk.openadsdk.core.model.eli eliVar = this.DbA;
        if (eliVar != null && eliVar.ui()) {
            final ev MGA = this.DbA.MGA();
            if (!com.bykv.vk.openvk.eli.eli.DbA.DbA.eli.eli()) {
                com.bytedance.sdk.openadsdk.aGH.Os.eli(MGA, "fullscreen_interstitial_ad", "showFullScreenVideoAd error2: not main looper");
                throw new IllegalStateException("Cannot be called in a child thread —— TTRewardVideoAd.showRewardVideoAd");
            }
            List<ev> aGH = this.DbA.aGH();
            if (aGH != null) {
                Iterator<ev> it = aGH.iterator();
                while (it.hasNext()) {
                    IPMiBroadcastReceiver.eli(this.eli, it.next());
                }
            }
            if (this.MGA.compareAndSet(false, true)) {
                if (MGA == null || MGA.nY() == null) {
                    com.bytedance.sdk.openadsdk.aGH.Os.eli(MGA, "fullscreen_interstitial_ad", "materialMeta error ");
                    return;
                }
                Context context = activity == null ? this.eli : activity;
                if (context == null) {
                    context = dV.eli();
                }
                if (eli(this.DbA)) {
                    intent = new Intent(context, (Class<?>) TTAdActivity.class);
                } else if (eli(MGA)) {
                    intent = new Intent(context, (Class<?>) TTRewardExpressVideoActivity.class);
                } else {
                    intent = new Intent(context, (Class<?>) TTRewardVideoActivity.class);
                }
                Intent intent2 = intent;
                com.bytedance.sdk.openadsdk.component.reward.eli.DbA.eli(intent2, activity, this.ui, this.DbA, this.kb);
                intent2.putExtra("media_extra", this.Os.getMediaExtra());
                intent2.putExtra("user_id", this.Os.getUserID());
                intent2.putExtra("start_show_time", SystemClock.elapsedRealtime());
                if (!com.bytedance.sdk.openadsdk.multipro.DbA.Os()) {
                    Ue.eli().eli(this.aGH);
                    this.aGH = null;
                }
                final boolean z = com.bytedance.sdk.openadsdk.bf.eli.eli("start_activity_async", 0) == 1;
                if (z) {
                    com.bytedance.sdk.openadsdk.dV.Os.eli(new com.bytedance.sdk.openadsdk.dV.aGH() { // from class: com.bytedance.sdk.openadsdk.component.reward.wC.1
                        @Override // com.bytedance.sdk.openadsdk.dV.aGH
                        public com.bytedance.sdk.openadsdk.dV.DbA.eli generatorModel() {
                            com.bytedance.sdk.openadsdk.dV.DbA.eli eliVar2 = new com.bytedance.sdk.openadsdk.dV.DbA.eli();
                            eliVar2.DbA("start_activity");
                            eliVar2.aGH("rewarded_video");
                            return eliVar2;
                        }
                    });
                }
                final long elapsedRealtime = SystemClock.elapsedRealtime();
                com.bytedance.sdk.component.utils.DbA.eli(context, intent2, new DbA.InterfaceC0150DbA() { // from class: com.bytedance.sdk.openadsdk.component.reward.wC.2
                    @Override // com.bytedance.sdk.component.utils.DbA.InterfaceC0150DbA
                    public void eli() {
                        if (z) {
                            com.bytedance.sdk.openadsdk.dV.Os.DbA(new com.bytedance.sdk.openadsdk.dV.aGH() { // from class: com.bytedance.sdk.openadsdk.component.reward.wC.2.1
                                @Override // com.bytedance.sdk.openadsdk.dV.aGH
                                public com.bytedance.sdk.openadsdk.dV.DbA.eli generatorModel() {
                                    com.bytedance.sdk.openadsdk.dV.DbA.eli eliVar2 = new com.bytedance.sdk.openadsdk.dV.DbA.eli();
                                    eliVar2.DbA("start_activity");
                                    eliVar2.aGH("rewarded_video");
                                    return eliVar2;
                                }
                            });
                            final long elapsedRealtime2 = SystemClock.elapsedRealtime() - elapsedRealtime;
                            com.bytedance.sdk.openadsdk.Dfc.Os.eli("start_activity_action", false, new com.bytedance.sdk.openadsdk.Dfc.DbA() { // from class: com.bytedance.sdk.openadsdk.component.reward.wC.2.2
                                @Override // com.bytedance.sdk.openadsdk.Dfc.DbA
                                public com.bytedance.sdk.openadsdk.Dfc.eli.Os getLogStats() throws Exception {
                                    JSONObject jSONObject = new JSONObject();
                                    jSONObject.put("duration", elapsedRealtime2);
                                    return com.bytedance.sdk.openadsdk.Dfc.eli.aGH.DbA().eli("start_activity_action").DbA(jSONObject.toString());
                                }
                            });
                        }
                    }

                    @Override // com.bytedance.sdk.component.utils.DbA.InterfaceC0150DbA
                    public void eli(Throwable th) {
                        com.bytedance.sdk.openadsdk.aGH.Os.eli(MGA, "fullscreen_interstitial_ad", "activity start  fail ");
                        if (z) {
                            com.bytedance.sdk.openadsdk.dV.Os.Os(new com.bytedance.sdk.openadsdk.dV.aGH() { // from class: com.bytedance.sdk.openadsdk.component.reward.wC.2.3
                                @Override // com.bytedance.sdk.openadsdk.dV.aGH
                                public com.bytedance.sdk.openadsdk.dV.DbA.eli generatorModel() {
                                    com.bytedance.sdk.openadsdk.dV.DbA.eli eliVar2 = new com.bytedance.sdk.openadsdk.dV.DbA.eli();
                                    eliVar2.DbA("start_activity");
                                    eliVar2.aGH("rewarded_video");
                                    return eliVar2;
                                }
                            });
                        }
                    }
                }, true);
                eli.eli(this.DbA.MGA(), this.ui, true);
            }
        }
    }

    private static boolean eli(ev evVar) {
        if (evVar == null) {
            return false;
        }
        return evVar.ui();
    }

    @Override // com.bytedance.sdk.openadsdk.api.PangleAd
    public Map<String, Object> getMediaExtraInfo() {
        com.bytedance.sdk.openadsdk.core.model.eli eliVar = this.DbA;
        if (eliVar == null || eliVar.MGA() == null) {
            return null;
        }
        return this.DbA.MGA().FYe();
    }

    @Override // com.bytedance.sdk.openadsdk.api.PangleAd
    public Object getExtraInfo(String str) {
        com.bytedance.sdk.openadsdk.core.model.eli eliVar = this.DbA;
        if (eliVar == null || eliVar.MGA() == null || this.DbA.MGA().FYe() == null) {
            return null;
        }
        try {
            return this.DbA.MGA().FYe().get(str);
        } catch (Throwable th) {
            Xb.Os("TTRewardVideoAdImpl", th.getMessage());
            return null;
        }
    }

    private void eli(final int i) {
        if (com.bytedance.sdk.openadsdk.multipro.DbA.Os()) {
            cyF.Os(new com.bytedance.sdk.component.wC.wC("Reward_registerMultiProcessListener") { // from class: com.bytedance.sdk.openadsdk.component.reward.wC.3
                @Override // java.lang.Runnable
                public void run() {
                    com.bytedance.sdk.openadsdk.multipro.aidl.eli eli = com.bytedance.sdk.openadsdk.multipro.aidl.eli.eli();
                    if (i != 0 || wC.this.aGH == null) {
                        return;
                    }
                    com.bytedance.sdk.openadsdk.multipro.aidl.DbA.aGH agh = new com.bytedance.sdk.openadsdk.multipro.aidl.DbA.aGH(wC.this.aGH);
                    IListenerManager asInterface = com.bytedance.sdk.openadsdk.multipro.aidl.eli.kb.asInterface(eli.eli(0));
                    if (asInterface != null) {
                        try {
                            asInterface.registerRewardVideoListener(wC.this.kb, agh);
                        } catch (RemoteException e) {
                            Xb.Os("TTRewardVideoAdImpl", e.getMessage());
                        }
                    }
                }
            }, 5);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.api.PAGClientBidding
    public void win(Double d) {
        if (this.wC) {
            return;
        }
        GB.eli(this.DbA.MGA(), d);
        this.wC = true;
    }

    @Override // com.bytedance.sdk.openadsdk.api.PAGClientBidding
    public void loss(Double d, String str, String str2) {
        if (this.FC) {
            return;
        }
        GB.eli(this.DbA.MGA(), d, str, str2);
        this.FC = true;
    }

    public static boolean eli(com.bytedance.sdk.openadsdk.core.model.eli eliVar) {
        ev MGA;
        String eli;
        if (eliVar == null || (MGA = eliVar.MGA()) == null || com.bytedance.sdk.openadsdk.core.model.Xb.Os(MGA)) {
            return false;
        }
        if (MGA.dZ()) {
            return true;
        }
        try {
            eli = com.bytedance.sdk.openadsdk.bf.eli.eli("rviv_new_arch", (String) null);
        } catch (Throwable unused) {
        }
        if (TextUtils.isEmpty(eli)) {
            return false;
        }
        JSONArray jSONArray = new JSONArray(eli);
        for (int i = 0; i < jSONArray.length(); i++) {
            int i2 = jSONArray.getInt(i);
            if (ev.mm(MGA.mm())) {
                if (MGA.dZ() && MGA.mm() == i2) {
                    return true;
                }
            } else if (MGA.mm() == i2) {
                return true;
            }
        }
        return false;
    }
}
