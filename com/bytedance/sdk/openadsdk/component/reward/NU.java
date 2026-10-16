package com.bytedance.sdk.openadsdk.component.reward;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;
import com.bytedance.sdk.component.utils.nGm;
import com.bytedance.sdk.component.utils.ujq;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.CacheDirFactory;
import com.bytedance.sdk.openadsdk.api.reward.PAGRewardedAd;
import com.bytedance.sdk.openadsdk.api.reward.PAGRewardedAdLoadListener;
import com.bytedance.sdk.openadsdk.core.CMM;
import com.bytedance.sdk.openadsdk.core.Xb;
import com.bytedance.sdk.openadsdk.core.bf;
import com.bytedance.sdk.openadsdk.core.dV;
import com.bytedance.sdk.openadsdk.core.model.KM;
import com.bytedance.sdk.openadsdk.core.model.Vy;
import com.bytedance.sdk.openadsdk.core.model.ev;
import com.bytedance.sdk.openadsdk.core.nlS.Os.eli;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class NU {
    private static volatile NU eli;
    private final Context DbA;
    private com.bytedance.sdk.component.wC.wC ui;
    private final AtomicBoolean Os = new AtomicBoolean(false);
    private final List<DbA> aGH = Collections.synchronizedList(new ArrayList());
    private final ujq.eli MGA = new ujq.eli() { // from class: com.bytedance.sdk.openadsdk.component.reward.NU.2
        @Override // com.bytedance.sdk.component.utils.ujq.eli
        public void eli(Context context, Intent intent, boolean z, int i) {
            if (z) {
                if (NU.this.ui == null) {
                    NU.this.ui = new com.bytedance.sdk.openadsdk.component.reward.DbA("net connect task", NU.this.aGH);
                }
                com.bytedance.sdk.component.utils.FC.eli().post(NU.this.ui);
            }
        }
    };

    public static NU eli(Context context) {
        if (eli == null) {
            synchronized (NU.class) {
                if (eli == null) {
                    eli = new NU(context);
                }
            }
        }
        return eli;
    }

    private NU(Context context) {
        this.DbA = context == null ? dV.eli() : context.getApplicationContext();
        DbA();
    }

    public void eli(AdSlot adSlot) {
        if (adSlot == null || TextUtils.isEmpty(adSlot.getCodeId()) || !TextUtils.isEmpty(adSlot.getBidAdm())) {
            return;
        }
        if (com.bytedance.sdk.openadsdk.utils.DbA.eli()) {
            DbA(adSlot);
        } else {
            Os(adSlot);
        }
    }

    private void DbA(final AdSlot adSlot) {
        com.bytedance.sdk.openadsdk.core.model.ujq ujqVar = new com.bytedance.sdk.openadsdk.core.model.ujq();
        ujqVar.DbA = 2;
        if (dV.aGH().du(adSlot.getCodeId()) || adSlot.getExpressViewAcceptedWidth() > 0.0f || adSlot.isExpressAd()) {
            ujqVar.FC = 2;
        }
        dV.Os().eli(adSlot, ujqVar, 7, (Xb) new bf() { // from class: com.bytedance.sdk.openadsdk.component.reward.NU.1
            boolean eli = false;

            @Override // com.bytedance.sdk.openadsdk.core.bf, com.bytedance.sdk.openadsdk.core.CMM.eli
            public void eli(int i, String str) {
            }

            @Override // com.bytedance.sdk.openadsdk.core.bf, com.bytedance.sdk.openadsdk.core.Xb
            public String eli() {
                return nlS.eli(NU.this.DbA).eli(adSlot.getCodeId(), false);
            }

            @Override // com.bytedance.sdk.openadsdk.core.bf, com.bytedance.sdk.openadsdk.core.Xb
            public boolean eli(com.bytedance.sdk.openadsdk.core.model.eli eliVar) {
                boolean eli2 = nlS.eli(NU.this.DbA).eli(eliVar);
                this.eli = eli2;
                return eli2;
            }

            @Override // com.bytedance.sdk.openadsdk.core.bf, com.bytedance.sdk.openadsdk.core.CMM.eli
            public void eli(com.bytedance.sdk.openadsdk.core.model.eli eliVar, com.bytedance.sdk.openadsdk.core.model.Os os) {
                if (this.eli || eliVar.aGH() == null || eliVar.aGH().isEmpty()) {
                    return;
                }
                NU.this.eli(eliVar, new Dfc(NU.this.DbA, eliVar, adSlot), adSlot, true, (PAGRewardedAdLoadListener) null);
            }
        });
    }

    private void Os(final AdSlot adSlot) {
        if (nlS.eli(this.DbA).DbA(adSlot.getCodeId(), false) != null) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.model.ujq ujqVar = new com.bytedance.sdk.openadsdk.core.model.ujq();
        ujqVar.DbA = 2;
        if (dV.aGH().du(adSlot.getCodeId()) || adSlot.getExpressViewAcceptedWidth() > 0.0f || adSlot.isExpressAd()) {
            ujqVar.FC = 2;
        }
        dV.Os().eli(adSlot, ujqVar, 7, new CMM.eli() { // from class: com.bytedance.sdk.openadsdk.component.reward.NU.3
            @Override // com.bytedance.sdk.openadsdk.core.CMM.eli
            public void eli(int i, String str) {
            }

            @Override // com.bytedance.sdk.openadsdk.core.CMM.eli
            public void eli(com.bytedance.sdk.openadsdk.core.model.eli eliVar, com.bytedance.sdk.openadsdk.core.model.Os os) {
                if (eliVar.aGH() == null || eliVar.aGH().isEmpty()) {
                    return;
                }
                NU.this.eli(eliVar, new Dfc(NU.this.DbA, eliVar, adSlot), adSlot, true, (PAGRewardedAdLoadListener) null);
            }
        });
    }

    public void eli(String str, ev evVar) {
        nlS.eli(this.DbA).eli(str, evVar);
    }

    public void eli() {
        try {
            nlS.eli(this.DbA).eli();
        } catch (Throwable unused) {
        }
    }

    public void eli(AdSlot adSlot, PAGRewardedAdLoadListener pAGRewardedAdLoadListener) {
        if (com.bytedance.sdk.openadsdk.utils.DbA.eli()) {
            DbA(adSlot, pAGRewardedAdLoadListener);
        } else {
            Os(adSlot, pAGRewardedAdLoadListener);
        }
    }

    private void DbA(final AdSlot adSlot, final PAGRewardedAdLoadListener pAGRewardedAdLoadListener) {
        if (com.bytedance.sdk.component.utils.Dfc.aGH()) {
            com.bykv.vk.openvk.eli.eli.eli.kb.DbA.eli(adSlot.getBidAdm());
        }
        final long currentTimeMillis = System.currentTimeMillis();
        com.bytedance.sdk.openadsdk.core.model.ujq ujqVar = new com.bytedance.sdk.openadsdk.core.model.ujq();
        ujqVar.DbA = 1;
        if (dV.aGH().du(adSlot.getCodeId()) || adSlot.getExpressViewAcceptedWidth() > 0.0f || adSlot.isExpressAd()) {
            ujqVar.FC = 2;
        }
        dV.Os().eli(adSlot, ujqVar, 7, (Xb) new bf() { // from class: com.bytedance.sdk.openadsdk.component.reward.NU.4
            boolean eli = false;

            @Override // com.bytedance.sdk.openadsdk.core.bf, com.bytedance.sdk.openadsdk.core.CMM.eli
            public void eli(int i, String str) {
                PAGRewardedAdLoadListener pAGRewardedAdLoadListener2 = pAGRewardedAdLoadListener;
                if (pAGRewardedAdLoadListener2 != null) {
                    pAGRewardedAdLoadListener2.onError(i, str);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.bf, com.bytedance.sdk.openadsdk.core.CMM.eli
            public void eli(com.bytedance.sdk.openadsdk.core.model.eli eliVar, com.bytedance.sdk.openadsdk.core.model.Os os) {
                com.bytedance.sdk.openadsdk.core.model.eli eliVar2;
                if (eliVar.aGH() != null && !eliVar.aGH().isEmpty()) {
                    Dfc dfc = new Dfc(NU.this.DbA, eliVar, adSlot);
                    if (!TextUtils.isEmpty(adSlot.getBidAdm())) {
                        com.bytedance.sdk.openadsdk.Xb.eli.aGH.eli().eli(eliVar.aGH().isEmpty() ? null : eliVar.aGH().get(0));
                        com.bytedance.sdk.openadsdk.Dfc.Os.eli(eliVar.MGA(), System.currentTimeMillis() - currentTimeMillis);
                    }
                    if (pAGRewardedAdLoadListener == null || dV.aGH().dV() != 0) {
                        eliVar2 = eliVar;
                    } else {
                        NU.this.eli(adSlot, eliVar, pAGRewardedAdLoadListener, dfc.eli(), this.eli);
                        eliVar2 = eliVar;
                    }
                    NU.this.eli(eliVar2, dfc, adSlot, false, pAGRewardedAdLoadListener);
                    return;
                }
                PAGRewardedAdLoadListener pAGRewardedAdLoadListener2 = pAGRewardedAdLoadListener;
                if (pAGRewardedAdLoadListener2 != null) {
                    pAGRewardedAdLoadListener2.onError(-3, com.bytedance.sdk.openadsdk.core.wC.eli(-3));
                    os.eli(-3);
                    os.Os(6);
                    com.bytedance.sdk.openadsdk.core.model.Os.eli(os);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.bf, com.bytedance.sdk.openadsdk.core.Xb
            public String eli() {
                if (!TextUtils.isEmpty(adSlot.getBidAdm())) {
                    return null;
                }
                String eli2 = nlS.eli(NU.this.DbA).eli(adSlot.getCodeId(), true);
                if (TextUtils.isEmpty(eli2)) {
                    return null;
                }
                return eli2;
            }

            @Override // com.bytedance.sdk.openadsdk.core.bf, com.bytedance.sdk.openadsdk.core.Xb
            public boolean eli(com.bytedance.sdk.openadsdk.core.model.eli eliVar) {
                boolean eli2 = nlS.eli(NU.this.DbA).eli(eliVar);
                this.eli = eli2;
                return eli2;
            }
        });
    }

    private void Os(AdSlot adSlot, PAGRewardedAdLoadListener pAGRewardedAdLoadListener) {
        com.bytedance.sdk.openadsdk.core.model.eli DbA2;
        if (TextUtils.isEmpty(adSlot.getBidAdm()) && (DbA2 = nlS.eli(this.DbA).DbA(adSlot.getCodeId(), true)) != null && DbA2.ui()) {
            eli(DbA2, adSlot, pAGRewardedAdLoadListener);
        } else {
            aGH(adSlot, pAGRewardedAdLoadListener);
        }
    }

    private void eli(com.bytedance.sdk.openadsdk.core.model.eli eliVar, AdSlot adSlot, PAGRewardedAdLoadListener pAGRewardedAdLoadListener) {
        com.bytedance.sdk.openadsdk.core.model.eli eliVar2;
        NU nu;
        com.bytedance.sdk.openadsdk.core.model.eli eliVar3;
        AdSlot adSlot2;
        PAGRewardedAdLoadListener pAGRewardedAdLoadListener2;
        ev MGA = eliVar.MGA();
        for (ev evVar : eliVar.aGH()) {
            if (evVar.XU() == null) {
                evVar.eli(adSlot);
            }
        }
        Dfc dfc = new Dfc(this.DbA, eliVar, adSlot);
        if (!KM.Os(MGA)) {
            dfc.DbA();
        }
        if (pAGRewardedAdLoadListener != null) {
            com.bytedance.sdk.openadsdk.core.du.Os.aGH.eli(eliVar);
            if (dV.aGH().dV() == 0) {
                nu = this;
                eliVar3 = eliVar;
                adSlot2 = adSlot;
                pAGRewardedAdLoadListener2 = pAGRewardedAdLoadListener;
                nu.eli(adSlot2, eliVar3, pAGRewardedAdLoadListener2, (PAGRewardedAd) dfc.eli(), true);
            } else {
                nu = this;
                eliVar3 = eliVar;
                adSlot2 = adSlot;
                pAGRewardedAdLoadListener2 = pAGRewardedAdLoadListener;
            }
            PAGRewardedAdLoadListener pAGRewardedAdLoadListener3 = pAGRewardedAdLoadListener2;
            AdSlot adSlot3 = adSlot2;
            com.bytedance.sdk.openadsdk.core.model.eli eliVar4 = eliVar3;
            eliVar2 = eliVar4;
            Os os = new Os(new eli(nu.DbA, adSlot3, eliVar4, pAGRewardedAdLoadListener3, true), eliVar2);
            for (int i = 0; i < eliVar2.aGH().size(); i++) {
                eli(eliVar2.aGH().get(i), adSlot3, os, dfc);
                if (eliVar2.aAs()) {
                    break;
                }
            }
        } else {
            eliVar2 = eliVar;
        }
        for (final int i2 = 0; i2 < eliVar2.aGH().size(); i2++) {
            com.bytedance.sdk.openadsdk.core.nlS.Os.eli.eli().eli(eliVar2.aGH().get(i2), new eli.InterfaceC0195eli() { // from class: com.bytedance.sdk.openadsdk.component.reward.NU.5
                @Override // com.bytedance.sdk.openadsdk.core.nlS.Os.eli.InterfaceC0195eli
                public void eli(boolean z) {
                    com.bytedance.sdk.component.utils.Xb.eli("RewardVideoLoadManager", "onCachedResponse: i=" + i2 + ", isSuccess=" + z);
                }
            });
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:4:0x000c, code lost:
    
        if (com.bytedance.sdk.openadsdk.core.dV.aGH().dV() == 1) goto L8;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void eli(ev evVar, AdSlot adSlot, final Os os, final Dfc dfc) {
        boolean z;
        boolean z2 = false;
        if (os != null) {
            z = true;
        }
        z = false;
        if (KM.Os(evVar)) {
            z2 = z;
        } else {
            com.bytedance.sdk.openadsdk.core.nlS.eli.DbA eli2 = ev.eli(CacheDirFactory.getICacheDir(evVar.Sz()).eli(), evVar);
            eli2.eli("material_meta", evVar);
            eli2.eli("ad_slot", adSlot);
            com.bytedance.sdk.openadsdk.core.nlS.ui.eli.eli(eli2, new com.bykv.vk.openvk.eli.eli.eli.ui.DbA() { // from class: com.bytedance.sdk.openadsdk.component.reward.NU.6
                @Override // com.bykv.vk.openvk.eli.eli.eli.ui.eli.InterfaceC0111eli
                public void eli(com.bykv.vk.openvk.eli.eli.eli.Os.Os os2, int i) {
                    Log.d("RewardVideoLoadManager", "onVideoPreloadSuccess: ");
                    if (os == null || dV.aGH().dV() != 1) {
                        return;
                    }
                    os.onAdLoaded(dfc.eli());
                }

                @Override // com.bykv.vk.openvk.eli.eli.eli.ui.eli.InterfaceC0111eli
                public void eli(com.bykv.vk.openvk.eli.eli.eli.Os.Os os2, int i, String str) {
                    if (os == null || dV.aGH().dV() != 1) {
                        return;
                    }
                    os.onError(i, str);
                }
            });
        }
        if (z2) {
            os.onAdLoaded(dfc.eli());
        }
    }

    private void aGH(final AdSlot adSlot, final PAGRewardedAdLoadListener pAGRewardedAdLoadListener) {
        if (com.bytedance.sdk.component.utils.Dfc.aGH()) {
            com.bykv.vk.openvk.eli.eli.eli.kb.DbA.eli(adSlot.getBidAdm());
        }
        final long currentTimeMillis = System.currentTimeMillis();
        com.bytedance.sdk.openadsdk.core.model.ujq ujqVar = new com.bytedance.sdk.openadsdk.core.model.ujq();
        ujqVar.DbA = 1;
        if (dV.aGH().du(adSlot.getCodeId()) || adSlot.getExpressViewAcceptedWidth() > 0.0f || adSlot.isExpressAd()) {
            ujqVar.FC = 2;
        }
        dV.Os().eli(adSlot, ujqVar, 7, new CMM.eli() { // from class: com.bytedance.sdk.openadsdk.component.reward.NU.7
            @Override // com.bytedance.sdk.openadsdk.core.CMM.eli
            public void eli(int i, String str) {
                PAGRewardedAdLoadListener pAGRewardedAdLoadListener2 = pAGRewardedAdLoadListener;
                if (pAGRewardedAdLoadListener2 != null) {
                    pAGRewardedAdLoadListener2.onError(i, str);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.CMM.eli
            public void eli(com.bytedance.sdk.openadsdk.core.model.eli eliVar, com.bytedance.sdk.openadsdk.core.model.Os os) {
                com.bytedance.sdk.openadsdk.core.model.eli eliVar2;
                if (eliVar.aGH() != null && !eliVar.aGH().isEmpty()) {
                    Dfc dfc = new Dfc(NU.this.DbA, eliVar, adSlot);
                    if (!TextUtils.isEmpty(adSlot.getBidAdm())) {
                        com.bytedance.sdk.openadsdk.Xb.eli.aGH.eli().eli(eliVar.aGH().isEmpty() ? null : eliVar.aGH().get(0));
                        com.bytedance.sdk.openadsdk.Dfc.Os.eli(eliVar.MGA(), System.currentTimeMillis() - currentTimeMillis);
                    }
                    if (pAGRewardedAdLoadListener == null || dV.aGH().dV() != 0) {
                        eliVar2 = eliVar;
                    } else {
                        NU.this.eli(adSlot, eliVar, pAGRewardedAdLoadListener, (PAGRewardedAd) dfc.eli(), false);
                        eliVar2 = eliVar;
                    }
                    NU.this.eli(eliVar2, dfc, adSlot, false, pAGRewardedAdLoadListener);
                    return;
                }
                PAGRewardedAdLoadListener pAGRewardedAdLoadListener2 = pAGRewardedAdLoadListener;
                if (pAGRewardedAdLoadListener2 != null) {
                    pAGRewardedAdLoadListener2.onError(-3, com.bytedance.sdk.openadsdk.core.wC.eli(-3));
                    os.eli(-3);
                    os.Os(6);
                    com.bytedance.sdk.openadsdk.core.model.Os.eli(os);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eli(com.bytedance.sdk.openadsdk.core.model.eli eliVar, Dfc dfc, AdSlot adSlot, boolean z, PAGRewardedAdLoadListener pAGRewardedAdLoadListener) {
        if (!z) {
            com.bytedance.sdk.openadsdk.NU.eli.eli().eli(eliVar.MGA());
        }
        AdSlot adSlot2 = adSlot;
        Os os = new Os(new eli(this.DbA, adSlot2, eliVar, pAGRewardedAdLoadListener, false), eliVar);
        eli(eliVar);
        int i = 0;
        while (i < eliVar.aGH().size()) {
            ev evVar = eliVar.aGH().get(i);
            int mm = evVar.mm();
            if (i == 0 && mm == 43) {
                evVar.nY().MGA(0);
            }
            Dfc dfc2 = dfc;
            boolean z2 = z;
            AdSlot adSlot3 = adSlot2;
            eli(eliVar, evVar, dfc2, adSlot3, z2, os);
            adSlot2 = adSlot3;
            if (eliVar.aAs() && mm != 43) {
                return;
            }
            i++;
            dfc = dfc2;
            z = z2;
        }
    }

    private void eli(com.bytedance.sdk.openadsdk.core.model.eli eliVar) {
        Vy nlS = eliVar.nlS();
        int i = eliVar.aAs() ? 10 : 1;
        if (nlS != null) {
            i = nlS.aqO();
        }
        for (final int i2 = 0; i2 < eliVar.aGH().size(); i2++) {
            ev evVar = eliVar.aGH().get(i2);
            if (i2 >= i) {
                return;
            }
            com.bytedance.sdk.openadsdk.core.nlS.Os.eli.eli().eli(evVar, new eli.InterfaceC0195eli() { // from class: com.bytedance.sdk.openadsdk.component.reward.NU.8
                @Override // com.bytedance.sdk.openadsdk.core.nlS.Os.eli.InterfaceC0195eli
                public void eli(boolean z) {
                    com.bytedance.sdk.component.utils.Xb.eli("RewardVideoLoadManager", "onCachedResponse: i=" + i2 + ", isSuccess=" + z);
                }
            });
        }
    }

    private void eli(final com.bytedance.sdk.openadsdk.core.model.eli eliVar, ev evVar, Dfc dfc, final AdSlot adSlot, final boolean z, Os os) {
        final Dfc dfc2;
        final Os os2;
        if (z && !KM.Os(evVar) && dV.aGH().gG(adSlot.getCodeId()).aGH == 1 && !nGm.aGH(this.DbA)) {
            eli(new DbA(evVar, adSlot, eliVar));
            return;
        }
        boolean z2 = false;
        boolean z3 = os != null && dV.aGH().dV() == 1;
        if (KM.Os(evVar)) {
            dfc2 = dfc;
            os2 = os;
            if (z) {
                nlS.eli(this.DbA).eli(adSlot, eliVar);
            }
        } else {
            if (evVar.nY() != null) {
                com.bytedance.sdk.openadsdk.core.nlS.eli.DbA eli2 = ev.eli(CacheDirFactory.getICacheDir(evVar.Sz()).eli(), evVar);
                eli2.eli("material_meta", evVar);
                eli2.eli("ad_slot", adSlot);
                dfc2 = dfc;
                os2 = os;
                com.bytedance.sdk.openadsdk.core.nlS.ui.eli.eli(eli2, new com.bykv.vk.openvk.eli.eli.eli.ui.DbA() { // from class: com.bytedance.sdk.openadsdk.component.reward.NU.9
                    @Override // com.bykv.vk.openvk.eli.eli.eli.ui.eli.InterfaceC0111eli
                    public void eli(com.bykv.vk.openvk.eli.eli.eli.Os.Os os3, int i) {
                        dfc2.DbA();
                        if (z) {
                            nlS.eli(NU.this.DbA).eli(adSlot, eliVar);
                        } else {
                            if (os2 == null || dV.aGH().dV() != 1) {
                                return;
                            }
                            os2.onAdLoaded(dfc2.eli());
                        }
                    }

                    @Override // com.bykv.vk.openvk.eli.eli.eli.ui.eli.InterfaceC0111eli
                    public void eli(com.bykv.vk.openvk.eli.eli.eli.Os.Os os3, int i, String str) {
                        if (os2 == null || dV.aGH().dV() != 1) {
                            return;
                        }
                        os2.onError(i, str);
                    }
                });
            } else {
                dfc2 = dfc;
                os2 = os;
                z2 = z3;
            }
            z3 = z2;
        }
        if (z3) {
            os2.onAdLoaded(dfc2.eli());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eli(final AdSlot adSlot, final com.bytedance.sdk.openadsdk.core.model.eli eliVar, PAGRewardedAdLoadListener pAGRewardedAdLoadListener, PAGRewardedAd pAGRewardedAd, final boolean z) {
        com.bytedance.sdk.openadsdk.core.nn.DbA().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.component.reward.NU.10
            @Override // java.lang.Runnable
            public void run() {
                int DbA2 = ui.DbA();
                if (!z) {
                    if (DbA2 == 2) {
                        nlS.eli(NU.this.DbA).eli(adSlot, eliVar);
                        NU.this.aGH(adSlot);
                        return;
                    }
                    return;
                }
                if (DbA2 == 2) {
                    NU.this.aGH(adSlot);
                } else if (DbA2 == 1) {
                    nlS.eli(NU.this.DbA).eli(adSlot.getCodeId(), (ev) null);
                }
            }
        });
        if (pAGRewardedAdLoadListener != null) {
            pAGRewardedAdLoadListener.onAdLoaded(pAGRewardedAd);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aGH(AdSlot adSlot) {
        if (ui.DbA() != 2) {
            return;
        }
        nlS.eli(this.DbA).eli(adSlot.getCodeId());
    }

    private void eli(DbA dbA) {
        if (dbA == null) {
            return;
        }
        if (this.aGH.size() > 0) {
            this.aGH.remove(0);
        }
        this.aGH.add(dbA);
    }

    private void DbA() {
        if (this.Os.get()) {
            return;
        }
        this.Os.set(true);
        ujq.eli(this.MGA, this.DbA);
    }

    private void Os() {
        if (this.Os.get()) {
            this.Os.set(false);
            try {
                ujq.eli(this.MGA);
            } catch (Exception unused) {
            }
        }
    }

    protected void finalize() throws Throwable {
        super.finalize();
        if (this.ui != null) {
            try {
                com.bytedance.sdk.component.utils.FC.eli().removeCallbacks(this.ui);
            } catch (Exception unused) {
            }
            this.ui = null;
        }
        Os();
    }

    public static class DbA extends com.bytedance.sdk.component.wC.wC {
        final AdSlot DbA;
        final com.bytedance.sdk.openadsdk.core.model.eli Os;
        final ev eli;

        DbA(ev evVar, AdSlot adSlot, com.bytedance.sdk.openadsdk.core.model.eli eliVar) {
            super("Reward Task");
            this.eli = evVar;
            this.DbA = adSlot;
            this.Os = eliVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            ev evVar = this.eli;
            if (evVar == null || evVar.nY() == null) {
                return;
            }
            com.bytedance.sdk.openadsdk.core.nlS.eli.DbA eli = ev.eli(CacheDirFactory.getICacheDir(this.eli.Sz()).eli(), this.eli);
            eli.eli("material_meta", this.eli);
            eli.eli("ad_slot", this.DbA);
            com.bytedance.sdk.openadsdk.core.nlS.ui.eli.eli(eli, new com.bykv.vk.openvk.eli.eli.eli.ui.DbA() { // from class: com.bytedance.sdk.openadsdk.component.reward.NU.DbA.1
                @Override // com.bykv.vk.openvk.eli.eli.eli.ui.eli.InterfaceC0111eli
                public void eli(com.bykv.vk.openvk.eli.eli.eli.Os.Os os, int i, String str) {
                }

                @Override // com.bykv.vk.openvk.eli.eli.eli.ui.eli.InterfaceC0111eli
                public void eli(com.bykv.vk.openvk.eli.eli.eli.Os.Os os, int i) {
                    nlS.eli(dV.eli()).eli(DbA.this.DbA, DbA.this.Os);
                }
            });
        }
    }

    private static class eli implements PAGRewardedAdLoadListener {
        private final AdSlot DbA;
        private final com.bytedance.sdk.openadsdk.core.model.eli Os;
        private final PAGRewardedAdLoadListener aGH;
        private final Context eli;
        private final boolean ui;

        public eli(Context context, AdSlot adSlot, com.bytedance.sdk.openadsdk.core.model.eli eliVar, PAGRewardedAdLoadListener pAGRewardedAdLoadListener, boolean z) {
            this.eli = context;
            this.DbA = adSlot;
            this.Os = eliVar;
            this.aGH = pAGRewardedAdLoadListener;
            this.ui = z;
        }

        @Override // com.bytedance.sdk.openadsdk.api.PAGLoadListener, com.bytedance.sdk.openadsdk.common.MGA
        public void onError(int i, String str) {
            PAGRewardedAdLoadListener pAGRewardedAdLoadListener = this.aGH;
            if (pAGRewardedAdLoadListener != null) {
                pAGRewardedAdLoadListener.onError(i, str);
            }
        }

        @Override // com.bytedance.sdk.openadsdk.api.PAGLoadListener
        /* renamed from: eli, reason: merged with bridge method [inline-methods] */
        public void onAdLoaded(PAGRewardedAd pAGRewardedAd) {
            NU.eli(this.eli).eli(this.DbA, this.Os, this.aGH, pAGRewardedAd, this.ui);
        }
    }

    private static class Os implements PAGRewardedAdLoadListener {
        private final AtomicBoolean DbA;
        private final AtomicInteger Os;
        private final com.bytedance.sdk.openadsdk.core.model.eli aGH;
        private final PAGRewardedAdLoadListener eli;

        private Os(PAGRewardedAdLoadListener pAGRewardedAdLoadListener, com.bytedance.sdk.openadsdk.core.model.eli eliVar) {
            this.DbA = new AtomicBoolean(false);
            this.eli = pAGRewardedAdLoadListener;
            this.aGH = eliVar;
            this.Os = new AtomicInteger(eli());
        }

        private int eli() {
            if (!this.aGH.ui()) {
                return 0;
            }
            int i = 0;
            for (int i2 = 0; i2 < this.aGH.aGH().size(); i2++) {
                ev evVar = this.aGH.aGH().get(i2);
                if (evVar != null && !KM.Os(evVar) && evVar.nY() != null) {
                    i++;
                }
            }
            return i;
        }

        @Override // com.bytedance.sdk.openadsdk.api.PAGLoadListener, com.bytedance.sdk.openadsdk.common.MGA
        public void onError(int i, String str) {
            if (this.Os.decrementAndGet() > 0 || this.eli == null || !this.DbA.compareAndSet(false, true)) {
                return;
            }
            this.eli.onError(i, str);
            com.bytedance.sdk.openadsdk.Dfc.Os.eli("choose_ad_load_error", false, new com.bytedance.sdk.openadsdk.Dfc.DbA() { // from class: com.bytedance.sdk.openadsdk.component.reward.NU.Os.1
                @Override // com.bytedance.sdk.openadsdk.Dfc.DbA
                public com.bytedance.sdk.openadsdk.Dfc.eli.Os getLogStats() throws Exception {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("req_id", Os.this.aGH.DbA());
                    return com.bytedance.sdk.openadsdk.Dfc.eli.aGH.DbA().eli("choose_ad_load_error").DbA(jSONObject.toString());
                }
            });
        }

        @Override // com.bytedance.sdk.openadsdk.api.PAGLoadListener
        /* renamed from: eli, reason: merged with bridge method [inline-methods] */
        public void onAdLoaded(PAGRewardedAd pAGRewardedAd) {
            this.Os.decrementAndGet();
            if (this.eli == null || !this.DbA.compareAndSet(false, true)) {
                return;
            }
            this.eli.onAdLoaded(pAGRewardedAd);
        }
    }
}
