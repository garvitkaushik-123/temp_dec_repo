package com.bytedance.sdk.openadsdk.component.reward;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.RemoteException;
import android.os.SystemClock;
import com.bytedance.sdk.component.utils.DbA;
import com.bytedance.sdk.component.utils.Xb;
import com.bytedance.sdk.openadsdk.IListenerManager;
import com.bytedance.sdk.openadsdk.activity.TTAdActivity;
import com.bytedance.sdk.openadsdk.activity.TTFullScreenExpressVideoActivity;
import com.bytedance.sdk.openadsdk.activity.TTFullScreenVideoActivity;
import com.bytedance.sdk.openadsdk.activity.TTInterstitialActivity;
import com.bytedance.sdk.openadsdk.activity.TTInterstitialExpressActivity;
import com.bytedance.sdk.openadsdk.api.interstitial.PAGInterstitialAd;
import com.bytedance.sdk.openadsdk.api.interstitial.PAGInterstitialAdInteractionCallback;
import com.bytedance.sdk.openadsdk.api.interstitial.PAGInterstitialAdInteractionListener;
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
import org.json.JSONObject;

/* loaded from: classes3.dex */
class MGA extends PAGInterstitialAd {
    private final com.bytedance.sdk.openadsdk.core.model.eli DbA;
    private boolean FC;
    private com.bytedance.sdk.openadsdk.eli.Os.DbA Os;
    private final Context eli;
    private boolean wC;
    private final AtomicBoolean ui = new AtomicBoolean(false);
    private boolean MGA = false;
    private boolean aGH = false;
    private final String kb = gG.eli();

    MGA(Context context, com.bytedance.sdk.openadsdk.core.model.eli eliVar) {
        this.eli = context;
        this.DbA = eliVar;
    }

    public void eli(boolean z) {
        this.MGA = z;
    }

    public void eli() {
        if (this.ui.get()) {
            return;
        }
        this.aGH = true;
    }

    @Override // com.bytedance.sdk.openadsdk.api.interstitial.PAGInterstitialAd
    public void setAdInteractionListener(PAGInterstitialAdInteractionListener pAGInterstitialAdInteractionListener) {
        this.Os = new com.bytedance.sdk.openadsdk.component.Os.eli(pAGInterstitialAdInteractionListener);
        eli(1);
    }

    @Override // com.bytedance.sdk.openadsdk.api.interstitial.PAGInterstitialAd
    public void setAdInteractionCallback(PAGInterstitialAdInteractionCallback pAGInterstitialAdInteractionCallback) {
        this.Os = new com.bytedance.sdk.openadsdk.component.Os.eli(pAGInterstitialAdInteractionCallback);
        eli(1);
    }

    private static boolean eli(ev evVar) {
        if (evVar == null) {
            return false;
        }
        return evVar.ui();
    }

    @Override // com.bytedance.sdk.openadsdk.api.interstitial.PAGInterstitialAd
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
                throw new IllegalStateException("Cannot be called in a child thread —— TTFullScreenVideoAd.showFullScreenVideoAd");
            }
            List<ev> aGH = this.DbA.aGH();
            if (aGH != null) {
                Iterator<ev> it = aGH.iterator();
                while (it.hasNext()) {
                    IPMiBroadcastReceiver.eli(this.eli, it.next());
                }
            }
            if (!this.ui.get()) {
                this.ui.set(true);
                if (MGA == null || (MGA.nY() == null && MGA.an() == null)) {
                    com.bytedance.sdk.openadsdk.aGH.Os.eli(MGA, "fullscreen_interstitial_ad", "materialMeta error ");
                    return;
                }
                Context context = activity == null ? this.eli : activity;
                if (context == null) {
                    context = dV.eli();
                }
                if (wC.eli(this.DbA)) {
                    intent = new Intent(context, (Class<?>) TTAdActivity.class);
                } else if (eli(MGA)) {
                    if (com.bytedance.sdk.openadsdk.component.reward.DbA.wC.eli(MGA)) {
                        intent = new Intent(context, (Class<?>) TTInterstitialExpressActivity.class);
                    } else {
                        intent = new Intent(context, (Class<?>) TTFullScreenExpressVideoActivity.class);
                    }
                } else if (com.bytedance.sdk.openadsdk.component.reward.DbA.wC.eli(MGA)) {
                    intent = new Intent(context, (Class<?>) TTInterstitialActivity.class);
                } else {
                    intent = new Intent(context, (Class<?>) TTFullScreenVideoActivity.class);
                }
                Intent intent2 = intent;
                intent2.putExtra("start_show_time", SystemClock.elapsedRealtime());
                com.bytedance.sdk.openadsdk.component.reward.eli.DbA.eli(intent2, activity, this.aGH, this.DbA, this.kb);
                intent2.putExtra("is_verity_playable", this.MGA);
                if (!com.bytedance.sdk.openadsdk.multipro.DbA.Os()) {
                    Ue.eli().eli(this.Os);
                    this.Os = null;
                }
                final boolean z = com.bytedance.sdk.openadsdk.bf.eli.eli("start_activity_async", 0) == 1;
                if (z) {
                    com.bytedance.sdk.openadsdk.dV.Os.eli(new com.bytedance.sdk.openadsdk.dV.aGH() { // from class: com.bytedance.sdk.openadsdk.component.reward.MGA.1
                        @Override // com.bytedance.sdk.openadsdk.dV.aGH
                        public com.bytedance.sdk.openadsdk.dV.DbA.eli generatorModel() {
                            com.bytedance.sdk.openadsdk.dV.DbA.eli eliVar2 = new com.bytedance.sdk.openadsdk.dV.DbA.eli();
                            eliVar2.DbA("start_activity");
                            eliVar2.aGH("fullscreen_interstitial_ad");
                            return eliVar2;
                        }
                    });
                }
                final long elapsedRealtime = SystemClock.elapsedRealtime();
                com.bytedance.sdk.component.utils.DbA.eli(context, intent2, new DbA.InterfaceC0150DbA() { // from class: com.bytedance.sdk.openadsdk.component.reward.MGA.2
                    @Override // com.bytedance.sdk.component.utils.DbA.InterfaceC0150DbA
                    public void eli() {
                        if (MGA.this.MGA) {
                            try {
                                com.bytedance.sdk.openadsdk.Dfc.Os.eli().eli(MGA.nY().nlS());
                            } catch (Throwable unused) {
                            }
                        }
                        if (z) {
                            com.bytedance.sdk.openadsdk.dV.Os.DbA(new com.bytedance.sdk.openadsdk.dV.aGH() { // from class: com.bytedance.sdk.openadsdk.component.reward.MGA.2.1
                                @Override // com.bytedance.sdk.openadsdk.dV.aGH
                                public com.bytedance.sdk.openadsdk.dV.DbA.eli generatorModel() {
                                    com.bytedance.sdk.openadsdk.dV.DbA.eli eliVar2 = new com.bytedance.sdk.openadsdk.dV.DbA.eli();
                                    eliVar2.DbA("start_activity");
                                    eliVar2.aGH("fullscreen_interstitial_ad");
                                    return eliVar2;
                                }
                            });
                            final long elapsedRealtime2 = SystemClock.elapsedRealtime() - elapsedRealtime;
                            com.bytedance.sdk.openadsdk.Dfc.Os.eli("start_activity_action", false, new com.bytedance.sdk.openadsdk.Dfc.DbA() { // from class: com.bytedance.sdk.openadsdk.component.reward.MGA.2.2
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
                        if (MGA.this.MGA) {
                            try {
                                com.bytedance.sdk.openadsdk.Dfc.Os.eli().eli(MGA.nY().nlS(), -1, th != null ? th.getMessage() : "playable tool error open");
                            } catch (Throwable unused) {
                            }
                        }
                        com.bytedance.sdk.openadsdk.aGH.Os.eli(MGA, "fullscreen_interstitial_ad", "activity start  fail ");
                        if (z) {
                            com.bytedance.sdk.openadsdk.dV.Os.Os(new com.bytedance.sdk.openadsdk.dV.aGH() { // from class: com.bytedance.sdk.openadsdk.component.reward.MGA.2.3
                                @Override // com.bytedance.sdk.openadsdk.dV.aGH
                                public com.bytedance.sdk.openadsdk.dV.DbA.eli generatorModel() {
                                    com.bytedance.sdk.openadsdk.dV.DbA.eli eliVar2 = new com.bytedance.sdk.openadsdk.dV.DbA.eli();
                                    eliVar2.DbA("start_activity");
                                    eliVar2.aGH("fullscreen_interstitial_ad");
                                    return eliVar2;
                                }
                            });
                        }
                    }
                }, true);
                eli.eli(this.DbA.MGA(), this.aGH, false);
            }
        }
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
            Xb.Os("TTFullScreenVideoAdImpl", th.getMessage());
            return null;
        }
    }

    private void eli(final int i) {
        if (com.bytedance.sdk.openadsdk.multipro.DbA.Os()) {
            cyF.Os(new com.bytedance.sdk.component.wC.wC("FullScreen_registerMultiProcessListener") { // from class: com.bytedance.sdk.openadsdk.component.reward.MGA.3
                @Override // java.lang.Runnable
                public void run() {
                    com.bytedance.sdk.openadsdk.multipro.aidl.eli eli = com.bytedance.sdk.openadsdk.multipro.aidl.eli.eli();
                    if (i != 1 || MGA.this.Os == null) {
                        return;
                    }
                    com.bytedance.sdk.openadsdk.multipro.aidl.DbA.Os os = new com.bytedance.sdk.openadsdk.multipro.aidl.DbA.Os(MGA.this.Os);
                    IListenerManager asInterface = com.bytedance.sdk.openadsdk.multipro.aidl.eli.ui.asInterface(eli.eli(1));
                    if (asInterface != null) {
                        try {
                            asInterface.registerFullVideoListener(MGA.this.kb, os);
                        } catch (RemoteException e) {
                            Xb.Os("TTFullScreenVideoAdImpl", e.getMessage());
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
}
