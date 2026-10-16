package com.bytedance.sdk.openadsdk.component.reward;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.bytedance.sdk.component.utils.nGm;
import com.bytedance.sdk.component.utils.ujq;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.CacheDirFactory;
import com.bytedance.sdk.openadsdk.api.interstitial.PAGInterstitialAd;
import com.bytedance.sdk.openadsdk.api.interstitial.PAGInterstitialAdLoadListener;
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
public class ui {
    private static volatile ui eli;
    private final Context DbA;
    private com.bytedance.sdk.component.wC.wC ui;
    private final AtomicBoolean Os = new AtomicBoolean(false);
    private final List<Os> aGH = Collections.synchronizedList(new ArrayList());
    private final ujq.eli MGA = new ujq.eli() { // from class: com.bytedance.sdk.openadsdk.component.reward.ui.2
        @Override // com.bytedance.sdk.component.utils.ujq.eli
        public void eli(Context context, Intent intent, boolean z, int i) {
            if (z) {
                if (ui.this.ui == null) {
                    ui.this.ui = new com.bytedance.sdk.openadsdk.component.reward.DbA("fsv net connect task", ui.this.aGH);
                }
                com.bytedance.sdk.component.utils.FC.eli().post(ui.this.ui);
            }
        }
    };

    public static ui eli(Context context) {
        if (eli == null) {
            synchronized (ui.class) {
                if (eli == null) {
                    eli = new ui(context);
                }
            }
        }
        return eli;
    }

    private ui(Context context) {
        this.DbA = context == null ? dV.eli() : context.getApplicationContext();
        Os();
    }

    public void eli() {
        try {
            aGH.eli(this.DbA).eli();
        } catch (Throwable unused) {
        }
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
        ujqVar.Os = 2;
        if (dV.aGH().du(adSlot.getCodeId()) || adSlot.getExpressViewAcceptedWidth() > 0.0f || adSlot.isExpressAd()) {
            ujqVar.FC = 2;
        }
        dV.Os().eli(adSlot, ujqVar, 8, (Xb) new bf() { // from class: com.bytedance.sdk.openadsdk.component.reward.ui.1
            boolean eli = false;

            @Override // com.bytedance.sdk.openadsdk.core.bf, com.bytedance.sdk.openadsdk.core.CMM.eli
            public void eli(int i, String str) {
            }

            @Override // com.bytedance.sdk.openadsdk.core.bf, com.bytedance.sdk.openadsdk.core.Xb
            public String eli() {
                return aGH.eli(ui.this.DbA).eli(adSlot.getCodeId(), false);
            }

            @Override // com.bytedance.sdk.openadsdk.core.bf, com.bytedance.sdk.openadsdk.core.Xb
            public boolean eli(com.bytedance.sdk.openadsdk.core.model.eli eliVar) {
                boolean eli2 = aGH.eli(ui.this.DbA).eli(eliVar);
                this.eli = eli2;
                return eli2;
            }

            @Override // com.bytedance.sdk.openadsdk.core.bf, com.bytedance.sdk.openadsdk.core.CMM.eli
            public void eli(com.bytedance.sdk.openadsdk.core.model.eli eliVar, com.bytedance.sdk.openadsdk.core.model.Os os) {
                if (this.eli || eliVar.aGH() == null || eliVar.aGH().isEmpty()) {
                    return;
                }
                ui.this.eli(eliVar, new nn(ui.this.DbA, eliVar), adSlot, true, (PAGInterstitialAdLoadListener) null);
            }
        });
    }

    private void Os(final AdSlot adSlot) {
        if (aGH.eli(this.DbA).DbA(adSlot.getCodeId(), false) != null) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.model.ujq ujqVar = new com.bytedance.sdk.openadsdk.core.model.ujq();
        ujqVar.Os = 2;
        if (dV.aGH().du(adSlot.getCodeId()) || adSlot.getExpressViewAcceptedWidth() > 0.0f || adSlot.isExpressAd()) {
            ujqVar.FC = 2;
        }
        dV.Os().eli(adSlot, ujqVar, 8, new CMM.eli() { // from class: com.bytedance.sdk.openadsdk.component.reward.ui.3
            @Override // com.bytedance.sdk.openadsdk.core.CMM.eli
            public void eli(int i, String str) {
            }

            @Override // com.bytedance.sdk.openadsdk.core.CMM.eli
            public void eli(com.bytedance.sdk.openadsdk.core.model.eli eliVar, com.bytedance.sdk.openadsdk.core.model.Os os) {
                if (eliVar.aGH() == null || eliVar.aGH().isEmpty()) {
                    return;
                }
                ui.this.eli(eliVar, new nn(ui.this.DbA, eliVar), adSlot, true, (PAGInterstitialAdLoadListener) null);
            }
        });
    }

    public void eli(AdSlot adSlot, PAGInterstitialAdLoadListener pAGInterstitialAdLoadListener) {
        if (com.bytedance.sdk.openadsdk.utils.DbA.eli()) {
            DbA(adSlot, pAGInterstitialAdLoadListener);
        } else {
            Os(adSlot, pAGInterstitialAdLoadListener);
        }
    }

    private void DbA(final AdSlot adSlot, final PAGInterstitialAdLoadListener pAGInterstitialAdLoadListener) {
        final long currentTimeMillis = System.currentTimeMillis();
        com.bytedance.sdk.openadsdk.core.model.ujq ujqVar = new com.bytedance.sdk.openadsdk.core.model.ujq();
        ujqVar.Os = 1;
        if (dV.aGH().du(adSlot.getCodeId()) || adSlot.getExpressViewAcceptedWidth() > 0.0f || adSlot.isExpressAd()) {
            ujqVar.FC = 2;
        }
        dV.Os().eli(adSlot, ujqVar, 8, (Xb) new bf() { // from class: com.bytedance.sdk.openadsdk.component.reward.ui.4
            boolean eli = false;

            @Override // com.bytedance.sdk.openadsdk.core.bf, com.bytedance.sdk.openadsdk.core.CMM.eli
            public void eli(int i, String str) {
                PAGInterstitialAdLoadListener pAGInterstitialAdLoadListener2 = pAGInterstitialAdLoadListener;
                if (pAGInterstitialAdLoadListener2 != null) {
                    pAGInterstitialAdLoadListener2.onError(i, str);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.bf, com.bytedance.sdk.openadsdk.core.CMM.eli
            public void eli(com.bytedance.sdk.openadsdk.core.model.eli eliVar, com.bytedance.sdk.openadsdk.core.model.Os os) {
                com.bytedance.sdk.openadsdk.core.model.eli eliVar2;
                if (eliVar.aGH() != null && !eliVar.aGH().isEmpty()) {
                    nn nnVar = new nn(ui.this.DbA, eliVar);
                    if (!TextUtils.isEmpty(adSlot.getBidAdm())) {
                        com.bytedance.sdk.openadsdk.Xb.eli.aGH.eli().eli(eliVar.aGH().isEmpty() ? null : eliVar.aGH().get(0));
                        com.bytedance.sdk.openadsdk.Dfc.Os.eli(eliVar.MGA(), System.currentTimeMillis() - currentTimeMillis);
                    }
                    if (pAGInterstitialAdLoadListener == null || dV.aGH().dV() != 0) {
                        eliVar2 = eliVar;
                    } else {
                        ui.this.eli(adSlot, eliVar, pAGInterstitialAdLoadListener, nnVar.eli(), this.eli);
                        eliVar2 = eliVar;
                    }
                    ui.this.eli(eliVar2, nnVar, adSlot, false, pAGInterstitialAdLoadListener);
                    return;
                }
                PAGInterstitialAdLoadListener pAGInterstitialAdLoadListener2 = pAGInterstitialAdLoadListener;
                if (pAGInterstitialAdLoadListener2 != null) {
                    pAGInterstitialAdLoadListener2.onError(-3, com.bytedance.sdk.openadsdk.core.wC.eli(-3));
                    os.eli(-3);
                    os.Os(5);
                    com.bytedance.sdk.openadsdk.core.model.Os.eli(os);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.bf, com.bytedance.sdk.openadsdk.core.Xb
            public String eli() {
                if (!TextUtils.isEmpty(adSlot.getBidAdm())) {
                    return null;
                }
                String eli2 = aGH.eli(ui.this.DbA).eli(adSlot.getCodeId(), true);
                if (TextUtils.isEmpty(eli2)) {
                    return null;
                }
                return eli2;
            }

            @Override // com.bytedance.sdk.openadsdk.core.bf, com.bytedance.sdk.openadsdk.core.Xb
            public boolean eli(com.bytedance.sdk.openadsdk.core.model.eli eliVar) {
                boolean eli2 = aGH.eli(ui.this.DbA).eli(eliVar);
                this.eli = eli2;
                return eli2;
            }
        });
    }

    private void Os(AdSlot adSlot, PAGInterstitialAdLoadListener pAGInterstitialAdLoadListener) {
        com.bytedance.sdk.openadsdk.core.model.eli DbA2;
        if (TextUtils.isEmpty(adSlot.getBidAdm()) && (DbA2 = aGH.eli(this.DbA).DbA(adSlot.getCodeId(), true)) != null && DbA2.ui()) {
            eli(adSlot, DbA2, pAGInterstitialAdLoadListener);
        } else {
            aGH(adSlot, pAGInterstitialAdLoadListener);
        }
    }

    private void eli(AdSlot adSlot, com.bytedance.sdk.openadsdk.core.model.eli eliVar, PAGInterstitialAdLoadListener pAGInterstitialAdLoadListener) {
        com.bytedance.sdk.openadsdk.core.model.eli eliVar2;
        ui uiVar;
        AdSlot adSlot2;
        com.bytedance.sdk.openadsdk.core.model.eli eliVar3;
        PAGInterstitialAdLoadListener pAGInterstitialAdLoadListener2;
        ev MGA = eliVar.MGA();
        for (ev evVar : eliVar.aGH()) {
            if (evVar.XU() == null) {
                evVar.eli(adSlot);
            }
        }
        nn nnVar = new nn(this.DbA, eliVar);
        if (!KM.Os(MGA)) {
            nnVar.DbA();
        }
        if (pAGInterstitialAdLoadListener != null) {
            com.bytedance.sdk.openadsdk.core.du.Os.aGH.eli(eliVar);
            if (dV.aGH().dV() == 0) {
                uiVar = this;
                adSlot2 = adSlot;
                eliVar3 = eliVar;
                pAGInterstitialAdLoadListener2 = pAGInterstitialAdLoadListener;
                uiVar.eli(adSlot2, eliVar3, pAGInterstitialAdLoadListener2, (PAGInterstitialAd) nnVar.eli(), true);
            } else {
                uiVar = this;
                adSlot2 = adSlot;
                eliVar3 = eliVar;
                pAGInterstitialAdLoadListener2 = pAGInterstitialAdLoadListener;
            }
            PAGInterstitialAdLoadListener pAGInterstitialAdLoadListener3 = pAGInterstitialAdLoadListener2;
            AdSlot adSlot3 = adSlot2;
            com.bytedance.sdk.openadsdk.core.model.eli eliVar4 = eliVar3;
            eliVar2 = eliVar4;
            DbA dbA = new DbA(new eli(uiVar.DbA, adSlot3, eliVar4, pAGInterstitialAdLoadListener3, true), eliVar2);
            for (int i = 0; i < eliVar2.aGH().size(); i++) {
                eli(eliVar2.aGH().get(i), adSlot3, dbA, nnVar);
                if (eliVar2.aAs()) {
                    break;
                }
            }
        } else {
            eliVar2 = eliVar;
        }
        for (int i2 = 0; i2 < eliVar2.aGH().size(); i2++) {
            com.bytedance.sdk.openadsdk.core.nlS.Os.eli.eli().eli(eliVar2.aGH().get(i2), new eli.InterfaceC0195eli() { // from class: com.bytedance.sdk.openadsdk.component.reward.ui.5
                @Override // com.bytedance.sdk.openadsdk.core.nlS.Os.eli.InterfaceC0195eli
                public void eli(boolean z) {
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eli(final AdSlot adSlot, final com.bytedance.sdk.openadsdk.core.model.eli eliVar, PAGInterstitialAdLoadListener pAGInterstitialAdLoadListener, PAGInterstitialAd pAGInterstitialAd, final boolean z) {
        com.bytedance.sdk.openadsdk.core.nn.DbA().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.component.reward.ui.6
            @Override // java.lang.Runnable
            public void run() {
                int DbA2 = ui.DbA();
                if (!z) {
                    if (DbA2 == 2) {
                        aGH.eli(ui.this.DbA).eli(adSlot, eliVar);
                        ui.this.aGH(adSlot);
                        return;
                    }
                    return;
                }
                if (DbA2 == 2) {
                    ui.this.aGH(adSlot);
                } else if (DbA2 == 1) {
                    aGH.eli(ui.this.DbA).eli(adSlot.getCodeId(), (ev) null);
                }
            }
        });
        if (pAGInterstitialAdLoadListener != null) {
            pAGInterstitialAdLoadListener.onAdLoaded(pAGInterstitialAd);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:4:0x000c, code lost:
    
        if (com.bytedance.sdk.openadsdk.core.dV.aGH().dV() == 1) goto L8;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void eli(ev evVar, AdSlot adSlot, final DbA dbA, final nn nnVar) {
        boolean z;
        boolean z2 = false;
        if (dbA != null) {
            z = true;
        }
        z = false;
        if (KM.Os(evVar) || !ev.ui(evVar)) {
            z2 = z;
        } else {
            com.bytedance.sdk.openadsdk.core.nlS.eli.DbA eli2 = ev.eli(CacheDirFactory.getICacheDir(evVar.Sz()).eli(), evVar);
            eli2.eli("material_meta", evVar);
            eli2.eli("ad_slot", adSlot);
            com.bytedance.sdk.openadsdk.core.nlS.ui.eli.eli(eli2, new com.bykv.vk.openvk.eli.eli.eli.ui.DbA() { // from class: com.bytedance.sdk.openadsdk.component.reward.ui.7
                @Override // com.bykv.vk.openvk.eli.eli.eli.ui.eli.InterfaceC0111eli
                public void eli(com.bykv.vk.openvk.eli.eli.eli.Os.Os os, int i) {
                    if (dbA == null || dV.aGH().dV() != 1) {
                        return;
                    }
                    dbA.onAdLoaded(nnVar.eli());
                }

                @Override // com.bykv.vk.openvk.eli.eli.eli.ui.eli.InterfaceC0111eli
                public void eli(com.bykv.vk.openvk.eli.eli.eli.Os.Os os, int i, String str) {
                    if (dbA == null || dV.aGH().dV() != 1) {
                        return;
                    }
                    dbA.onError(i, str);
                }
            });
        }
        if (z2) {
            dbA.onAdLoaded(nnVar.eli());
        }
    }

    private void aGH(final AdSlot adSlot, final PAGInterstitialAdLoadListener pAGInterstitialAdLoadListener) {
        final long currentTimeMillis = System.currentTimeMillis();
        com.bytedance.sdk.openadsdk.core.model.ujq ujqVar = new com.bytedance.sdk.openadsdk.core.model.ujq();
        ujqVar.Os = 1;
        if (dV.aGH().du(adSlot.getCodeId()) || adSlot.getExpressViewAcceptedWidth() > 0.0f || adSlot.isExpressAd()) {
            ujqVar.FC = 2;
        }
        dV.Os().eli(adSlot, ujqVar, 8, new CMM.eli() { // from class: com.bytedance.sdk.openadsdk.component.reward.ui.8
            @Override // com.bytedance.sdk.openadsdk.core.CMM.eli
            public void eli(int i, String str) {
                PAGInterstitialAdLoadListener pAGInterstitialAdLoadListener2 = pAGInterstitialAdLoadListener;
                if (pAGInterstitialAdLoadListener2 != null) {
                    pAGInterstitialAdLoadListener2.onError(i, str);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.CMM.eli
            public void eli(com.bytedance.sdk.openadsdk.core.model.eli eliVar, com.bytedance.sdk.openadsdk.core.model.Os os) {
                com.bytedance.sdk.openadsdk.core.model.eli eliVar2;
                if (eliVar.aGH() != null && !eliVar.aGH().isEmpty()) {
                    nn nnVar = new nn(ui.this.DbA, eliVar);
                    if (!TextUtils.isEmpty(adSlot.getBidAdm())) {
                        com.bytedance.sdk.openadsdk.Xb.eli.aGH.eli().eli(eliVar.aGH().isEmpty() ? null : eliVar.aGH().get(0));
                        com.bytedance.sdk.openadsdk.Dfc.Os.eli(eliVar.MGA(), System.currentTimeMillis() - currentTimeMillis);
                    }
                    if (pAGInterstitialAdLoadListener == null || dV.aGH().dV() != 0) {
                        eliVar2 = eliVar;
                    } else {
                        ui.this.eli(adSlot, eliVar, pAGInterstitialAdLoadListener, (PAGInterstitialAd) nnVar.eli(), false);
                        eliVar2 = eliVar;
                    }
                    ui.this.eli(eliVar2, nnVar, adSlot, false, pAGInterstitialAdLoadListener);
                    return;
                }
                PAGInterstitialAdLoadListener pAGInterstitialAdLoadListener2 = pAGInterstitialAdLoadListener;
                if (pAGInterstitialAdLoadListener2 != null) {
                    pAGInterstitialAdLoadListener2.onError(-3, com.bytedance.sdk.openadsdk.core.wC.eli(-3));
                    os.eli(-3);
                    os.Os(5);
                    com.bytedance.sdk.openadsdk.core.model.Os.eli(os);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eli(com.bytedance.sdk.openadsdk.core.model.eli eliVar, nn nnVar, AdSlot adSlot, boolean z, PAGInterstitialAdLoadListener pAGInterstitialAdLoadListener) {
        if (!z) {
            com.bytedance.sdk.openadsdk.NU.eli.eli().eli(eliVar.MGA());
        }
        AdSlot adSlot2 = adSlot;
        DbA dbA = new DbA(new eli(this.DbA, adSlot2, eliVar, pAGInterstitialAdLoadListener, false), eliVar);
        eli(eliVar);
        int i = 0;
        while (i < eliVar.aGH().size()) {
            ev evVar = eliVar.aGH().get(i);
            int mm = evVar.mm();
            if (i == 0 && mm == 43) {
                evVar.nY().MGA(0);
            }
            nn nnVar2 = nnVar;
            boolean z2 = z;
            AdSlot adSlot3 = adSlot2;
            eli(eliVar, evVar, nnVar2, adSlot3, z2, dbA);
            adSlot2 = adSlot3;
            if (eliVar.aAs() && evVar.mm() != 43) {
                return;
            }
            i++;
            nnVar = nnVar2;
            z = z2;
        }
    }

    private void eli(com.bytedance.sdk.openadsdk.core.model.eli eliVar) {
        Vy nlS = eliVar.nlS();
        int i = eliVar.aAs() ? 10 : 1;
        if (nlS != null) {
            i = nlS.aqO();
        }
        for (final int i2 = 0; i2 < eliVar.aGH().size() && i2 < i; i2++) {
            com.bytedance.sdk.openadsdk.core.nlS.Os.eli.eli().eli(eliVar.aGH().get(i2), new eli.InterfaceC0195eli() { // from class: com.bytedance.sdk.openadsdk.component.reward.ui.9
                @Override // com.bytedance.sdk.openadsdk.core.nlS.Os.eli.InterfaceC0195eli
                public void eli(boolean z) {
                    com.bytedance.sdk.component.utils.Xb.eli("ScreenVideoLoadM", "onCachedResponse: i=" + i2 + ", isSuccess=" + z);
                }
            });
        }
    }

    private void eli(final com.bytedance.sdk.openadsdk.core.model.eli eliVar, ev evVar, nn nnVar, final AdSlot adSlot, final boolean z, DbA dbA) {
        final nn nnVar2;
        final DbA dbA2;
        if (z && !KM.Os(evVar) && ev.ui(evVar) && dV.aGH().gG(adSlot.getCodeId()).aGH == 1 && !nGm.aGH(this.DbA)) {
            eli(new Os(evVar, adSlot, eliVar));
            return;
        }
        boolean z2 = false;
        boolean z3 = dbA != null && dV.aGH().dV() == 1;
        if (KM.Os(evVar)) {
            nnVar2 = nnVar;
            dbA2 = dbA;
            if (z) {
                aGH.eli(this.DbA).eli(adSlot, eliVar);
            }
        } else if (ev.ui(evVar)) {
            if (evVar.nY() != null) {
                com.bytedance.sdk.openadsdk.core.nlS.eli.DbA eli2 = ev.eli(CacheDirFactory.getICacheDir(evVar.Sz()).eli(), evVar);
                eli2.eli("material_meta", evVar);
                eli2.eli("ad_slot", adSlot);
                nnVar2 = nnVar;
                dbA2 = dbA;
                com.bytedance.sdk.openadsdk.core.nlS.ui.eli.eli(eli2, new com.bykv.vk.openvk.eli.eli.eli.ui.DbA() { // from class: com.bytedance.sdk.openadsdk.component.reward.ui.10
                    @Override // com.bykv.vk.openvk.eli.eli.eli.ui.eli.InterfaceC0111eli
                    public void eli(com.bykv.vk.openvk.eli.eli.eli.Os.Os os, int i) {
                        nnVar2.DbA();
                        if (z) {
                            aGH.eli(ui.this.DbA).eli(adSlot, eliVar);
                        } else {
                            if (dbA2 == null || dV.aGH().dV() != 1) {
                                return;
                            }
                            dbA2.onAdLoaded(nnVar2.eli());
                        }
                    }

                    @Override // com.bykv.vk.openvk.eli.eli.eli.ui.eli.InterfaceC0111eli
                    public void eli(com.bykv.vk.openvk.eli.eli.eli.Os.Os os, int i, String str) {
                        if (dbA2 == null || dV.aGH().dV() != 1) {
                            return;
                        }
                        dbA2.onError(i, str);
                    }
                });
            } else {
                nnVar2 = nnVar;
                dbA2 = dbA;
                z2 = z3;
            }
            z3 = z2;
        } else {
            nnVar2 = nnVar;
            dbA2 = dbA;
            if (z) {
                aGH.eli(this.DbA).eli(adSlot, eliVar);
            }
        }
        if (z3) {
            dbA2.onAdLoaded(nnVar2.eli());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aGH(AdSlot adSlot) {
        if (DbA() != 2) {
            return;
        }
        aGH.eli(this.DbA).eli(adSlot.getCodeId());
    }

    private void eli(Os os) {
        if (os == null) {
            return;
        }
        if (this.aGH.size() > 0) {
            this.aGH.remove(0);
        }
        this.aGH.add(os);
    }

    private void Os() {
        if (this.Os.get()) {
            return;
        }
        this.Os.set(true);
        ujq.eli(this.MGA, this.DbA);
    }

    private void aGH() {
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
        aGH();
    }

    private static class Os extends com.bytedance.sdk.component.wC.wC {
        final AdSlot DbA;
        final com.bytedance.sdk.openadsdk.core.model.eli Os;
        final ev eli;

        Os(ev evVar, AdSlot adSlot, com.bytedance.sdk.openadsdk.core.model.eli eliVar) {
            super("Fullscreen Task");
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
            com.bytedance.sdk.openadsdk.core.nlS.ui.eli.eli(eli, new com.bykv.vk.openvk.eli.eli.eli.ui.DbA() { // from class: com.bytedance.sdk.openadsdk.component.reward.ui.Os.1
                @Override // com.bykv.vk.openvk.eli.eli.eli.ui.eli.InterfaceC0111eli
                public void eli(com.bykv.vk.openvk.eli.eli.eli.Os.Os os, int i, String str) {
                }

                @Override // com.bykv.vk.openvk.eli.eli.eli.ui.eli.InterfaceC0111eli
                public void eli(com.bykv.vk.openvk.eli.eli.eli.Os.Os os, int i) {
                    aGH.eli(dV.eli()).eli(Os.this.DbA, Os.this.Os);
                }
            });
        }
    }

    private static class eli implements PAGInterstitialAdLoadListener {
        private final AdSlot DbA;
        private final com.bytedance.sdk.openadsdk.core.model.eli Os;
        private final PAGInterstitialAdLoadListener aGH;
        private final Context eli;
        private final boolean ui;

        public eli(Context context, AdSlot adSlot, com.bytedance.sdk.openadsdk.core.model.eli eliVar, PAGInterstitialAdLoadListener pAGInterstitialAdLoadListener, boolean z) {
            this.eli = context;
            this.DbA = adSlot;
            this.Os = eliVar;
            this.aGH = pAGInterstitialAdLoadListener;
            this.ui = z;
        }

        @Override // com.bytedance.sdk.openadsdk.api.PAGLoadListener, com.bytedance.sdk.openadsdk.common.MGA
        public void onError(int i, String str) {
            PAGInterstitialAdLoadListener pAGInterstitialAdLoadListener = this.aGH;
            if (pAGInterstitialAdLoadListener != null) {
                pAGInterstitialAdLoadListener.onError(i, str);
            }
        }

        @Override // com.bytedance.sdk.openadsdk.api.PAGLoadListener
        /* renamed from: eli, reason: merged with bridge method [inline-methods] */
        public void onAdLoaded(PAGInterstitialAd pAGInterstitialAd) {
            ui.eli(this.eli).eli(this.DbA, this.Os, this.aGH, pAGInterstitialAd, this.ui);
        }
    }

    private static class DbA implements PAGInterstitialAdLoadListener {
        private final AtomicBoolean DbA;
        private final AtomicInteger Os;
        private final com.bytedance.sdk.openadsdk.core.model.eli aGH;
        private final PAGInterstitialAdLoadListener eli;

        private DbA(PAGInterstitialAdLoadListener pAGInterstitialAdLoadListener, com.bytedance.sdk.openadsdk.core.model.eli eliVar) {
            this.DbA = new AtomicBoolean(false);
            this.eli = pAGInterstitialAdLoadListener;
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
            if (this.Os.decrementAndGet() > 0 || !this.DbA.compareAndSet(false, true)) {
                return;
            }
            this.eli.onError(i, str);
            com.bytedance.sdk.openadsdk.Dfc.Os.eli("choose_ad_load_error", false, new com.bytedance.sdk.openadsdk.Dfc.DbA() { // from class: com.bytedance.sdk.openadsdk.component.reward.ui.DbA.1
                @Override // com.bytedance.sdk.openadsdk.Dfc.DbA
                public com.bytedance.sdk.openadsdk.Dfc.eli.Os getLogStats() throws Exception {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("req_id", DbA.this.aGH.DbA());
                    return com.bytedance.sdk.openadsdk.Dfc.eli.aGH.DbA().eli("choose_ad_load_error").DbA(jSONObject.toString());
                }
            });
        }

        @Override // com.bytedance.sdk.openadsdk.api.PAGLoadListener
        /* renamed from: eli, reason: merged with bridge method [inline-methods] */
        public void onAdLoaded(PAGInterstitialAd pAGInterstitialAd) {
            this.Os.decrementAndGet();
            if (this.eli == null || !this.DbA.compareAndSet(false, true)) {
                return;
            }
            this.eli.onAdLoaded(pAGInterstitialAd);
        }
    }

    public void eli(String str, ev evVar) {
        aGH.eli(this.DbA).eli(str, evVar);
    }

    public static int DbA() {
        return com.bytedance.sdk.openadsdk.bf.eli.eli("ivrv_load_ad_cache_strategy", 0);
    }
}
