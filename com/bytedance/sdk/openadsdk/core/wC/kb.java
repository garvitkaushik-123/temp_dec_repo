package com.bytedance.sdk.openadsdk.core.wC;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.CacheDirFactory;
import com.bytedance.sdk.openadsdk.api.banner.PAGBannerAd;
import com.bytedance.sdk.openadsdk.api.banner.PAGBannerAdLoadListener;
import com.bytedance.sdk.openadsdk.api.banner.PAGBannerSize;
import com.bytedance.sdk.openadsdk.core.CMM;
import com.bytedance.sdk.openadsdk.core.model.ujq;
import com.bytedance.sdk.openadsdk.utils.cyF;
import com.bytedance.sdk.openadsdk.utils.eU;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class kb {
    private final Context Os;
    private PAGBannerAdLoadListener aGH;
    private AdSlot eli;
    private com.bytedance.sdk.openadsdk.core.model.ev wC;
    private final AtomicBoolean ui = new AtomicBoolean(false);
    private int MGA = 5;
    private final eU kb = eU.Os();
    private final com.bytedance.sdk.openadsdk.core.CMM DbA = com.bytedance.sdk.openadsdk.core.dV.Os();

    private kb(Context context) {
        if (context != null) {
            this.Os = context.getApplicationContext();
        } else {
            this.Os = com.bytedance.sdk.openadsdk.core.dV.eli();
        }
    }

    public static kb eli(Context context) {
        return new kb(context);
    }

    public void eli(AdSlot adSlot, int i, com.bytedance.sdk.openadsdk.common.MGA mga) {
        this.kb.ui();
        if (this.ui.get()) {
            return;
        }
        this.MGA = i;
        this.ui.set(true);
        this.eli = adSlot;
        if (mga instanceof PAGBannerAdLoadListener) {
            this.aGH = (PAGBannerAdLoadListener) mga;
        }
        eli(adSlot);
    }

    private void eli(final AdSlot adSlot) {
        if (adSlot == null) {
            return;
        }
        ujq ujqVar = new ujq();
        ujqVar.FC = 2;
        if (com.bytedance.sdk.openadsdk.utils.DbA.eli()) {
            this.DbA.eli(adSlot, ujqVar, this.MGA, (com.bytedance.sdk.openadsdk.core.Xb) new com.bytedance.sdk.openadsdk.core.bf() { // from class: com.bytedance.sdk.openadsdk.core.wC.kb.1
                @Override // com.bytedance.sdk.openadsdk.core.bf, com.bytedance.sdk.openadsdk.core.CMM.eli
                public void eli(int i, String str) {
                    kb.this.eli(i, str);
                }

                @Override // com.bytedance.sdk.openadsdk.core.bf, com.bytedance.sdk.openadsdk.core.CMM.eli
                public void eli(com.bytedance.sdk.openadsdk.core.model.eli eliVar, com.bytedance.sdk.openadsdk.core.model.Os os) {
                    kb.this.eli(eliVar, os, adSlot);
                }
            });
        } else {
            this.DbA.eli(adSlot, ujqVar, this.MGA, new CMM.eli() { // from class: com.bytedance.sdk.openadsdk.core.wC.kb.2
                @Override // com.bytedance.sdk.openadsdk.core.CMM.eli
                public void eli(int i, String str) {
                    kb.this.eli(i, str);
                }

                @Override // com.bytedance.sdk.openadsdk.core.CMM.eli
                public void eli(com.bytedance.sdk.openadsdk.core.model.eli eliVar, com.bytedance.sdk.openadsdk.core.model.Os os) {
                    kb.this.eli(eliVar, os, adSlot);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eli(com.bytedance.sdk.openadsdk.core.model.eli eliVar, com.bytedance.sdk.openadsdk.core.model.Os os, AdSlot adSlot) {
        if (eliVar.aGH() != null && !eliVar.aGH().isEmpty()) {
            com.bytedance.sdk.openadsdk.core.model.ev du = eliVar.du();
            this.wC = du;
            eli(du, adSlot);
            if (com.bytedance.sdk.component.utils.Dfc.aGH()) {
                Log.e("ExpressAdLoadManager", "onAdLoad: net work response duration = " + this.kb.aGH() + "run in  " + Thread.currentThread().getName());
            }
            if (this.ui.getAndSet(false)) {
                cyF.eli(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.wC.kb.3
                    @Override // java.lang.Runnable
                    public void run() {
                        long elapsedRealtime = SystemClock.elapsedRealtime();
                        if (kb.this.wC != null) {
                            kb kbVar = kb.this;
                            kbVar.eli(kbVar.wC, elapsedRealtime);
                        }
                    }
                });
                return;
            }
            return;
        }
        eli(-3, com.bytedance.sdk.openadsdk.core.wC.eli(-3));
        os.eli(-3);
        os.Os(8);
        com.bytedance.sdk.openadsdk.core.model.Os.eli(os);
    }

    private void eli(com.bytedance.sdk.openadsdk.core.model.ev evVar, AdSlot adSlot) {
        for (com.bytedance.sdk.openadsdk.core.model.ev evVar2 : evVar.ro()) {
            if (com.bytedance.sdk.openadsdk.core.model.ev.ui(evVar2) && evVar2.nY() != null && evVar2.nY().du() != null) {
                if (com.bytedance.sdk.openadsdk.core.dV.aGH().aGH(String.valueOf(evVar2.RTg())) && com.bytedance.sdk.openadsdk.core.dV.aGH().WfR()) {
                    com.bytedance.sdk.openadsdk.core.nlS.eli.DbA eli = com.bytedance.sdk.openadsdk.core.model.ev.eli(CacheDirFactory.getICacheDir(evVar2.Sz()).Os(), evVar2);
                    eli.eli("material_meta", evVar2);
                    eli.eli("ad_slot", adSlot);
                    com.bytedance.sdk.openadsdk.core.nlS.ui.eli.eli(eli, null);
                }
            }
        }
    }

    private PAGBannerAd eli(com.bytedance.sdk.openadsdk.core.model.ev evVar) {
        int i;
        int i2;
        PAGBannerSize dbH = evVar.dbH();
        float min = Math.min(this.eli.getExpressViewAcceptedHeight(), 250.0f);
        if (dbH != null) {
            i = dbH.getWidth();
            i2 = dbH.getHeight();
        } else {
            i = 0;
            i2 = 0;
        }
        float expressViewAcceptedWidth = i > 0 ? i : this.eli.getExpressViewAcceptedWidth();
        if (i2 > 0) {
            min = i2;
        }
        this.eli.setExpressViewAccepted(expressViewAcceptedWidth, min);
        return new com.bytedance.sdk.openadsdk.core.Os.kb(this.Os, evVar, this.eli);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eli(com.bytedance.sdk.openadsdk.core.model.ev evVar, long j) {
        if (this.aGH != null) {
            PAGBannerAd eli = eli(evVar);
            long elapsedRealtime = SystemClock.elapsedRealtime();
            long aGH = this.kb.aGH();
            if (!TextUtils.isEmpty(this.eli.getBidAdm())) {
                com.bytedance.sdk.openadsdk.Dfc.Os.eli(evVar, aGH);
            }
            this.aGH.onAdLoaded(eli);
            eli(evVar, aGH, j, elapsedRealtime);
        }
    }

    private void eli(com.bytedance.sdk.openadsdk.core.model.ev evVar, final long j, final long j2, final long j3) {
        try {
            if (!com.bytedance.sdk.openadsdk.core.dV.aGH().tGZ() || !com.bytedance.sdk.openadsdk.bf.eli.aGH() || this.MGA != 1 || evVar == null || evVar.ro() == null || evVar.ro().isEmpty() || evVar.Os().eli() == null) {
                return;
            }
            final JSONObject eli = evVar.Os().eli();
            com.bytedance.sdk.openadsdk.aGH.Os.eli(System.currentTimeMillis(), evVar, eli.optString("tag", ""), "load_ad_time", new com.bytedance.sdk.openadsdk.Dfc.Os.eli() { // from class: com.bytedance.sdk.openadsdk.core.wC.kb.4
                @Override // com.bytedance.sdk.openadsdk.Dfc.Os.eli
                public JSONObject eli() {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        long optLong = eli.optLong("callback_start", 0L);
                        long j4 = j2;
                        long j5 = j4 - optLong;
                        long j6 = j3 - j4;
                        long optLong2 = eli.optLong("duration", 0L);
                        JSONObject optJSONObject = eli.optJSONObject("extra_data");
                        if (optJSONObject == null) {
                            optJSONObject = new JSONObject();
                        }
                        optJSONObject.put("thread_dispatch_duration", j5);
                        optJSONObject.put("build_banner_ad_duration", j6);
                        optJSONObject.put("ad_load_duration_full", j);
                        jSONObject.put("duration", optLong2);
                        jSONObject.put("ad_extra_data", optJSONObject.toString());
                        if (com.bytedance.sdk.component.utils.Dfc.aGH()) {
                            new StringBuilder("reportAdLoadTime: result = ").append(jSONObject);
                        }
                    } catch (Throwable unused) {
                    }
                    return jSONObject;
                }
            });
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eli(int i, String str) {
        PAGBannerAdLoadListener pAGBannerAdLoadListener;
        if (!this.ui.getAndSet(false) || (pAGBannerAdLoadListener = this.aGH) == null) {
            return;
        }
        pAGBannerAdLoadListener.onError(i, str);
    }
}
