package com.bytedance.sdk.openadsdk.component.DbA;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.CacheDirFactory;
import com.bytedance.sdk.openadsdk.api.nativeAd.PAGNativeAd;
import com.bytedance.sdk.openadsdk.api.nativeAd.PAGNativeAdLoadListener;
import com.bytedance.sdk.openadsdk.common.MGA;
import com.bytedance.sdk.openadsdk.core.CMM;
import com.bytedance.sdk.openadsdk.core.Xb;
import com.bytedance.sdk.openadsdk.core.bf;
import com.bytedance.sdk.openadsdk.core.dV;
import com.bytedance.sdk.openadsdk.core.model.Os;
import com.bytedance.sdk.openadsdk.core.model.ev;
import com.bytedance.sdk.openadsdk.core.model.ujq;
import com.bytedance.sdk.openadsdk.core.wC;
import com.bytedance.sdk.openadsdk.oem.IPMiBroadcastReceiver;
import com.bytedance.sdk.openadsdk.utils.DbA;
import com.bytedance.sdk.openadsdk.utils.eU;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public class eli {
    private static volatile eli eli;
    private final CMM DbA = dV.Os();

    public static eli eli() {
        if (eli == null) {
            synchronized (eli.class) {
                if (eli == null) {
                    eli = new eli();
                }
            }
        }
        return eli;
    }

    private eli() {
    }

    public void eli(final Context context, final AdSlot adSlot, final MGA mga) {
        final eU DbA = eU.DbA();
        if (DbA.eli()) {
            this.DbA.eli(adSlot, new ujq(), 5, (Xb) new bf() { // from class: com.bytedance.sdk.openadsdk.component.DbA.eli.1
                @Override // com.bytedance.sdk.openadsdk.core.bf, com.bytedance.sdk.openadsdk.core.CMM.eli
                public void eli(int i, String str) {
                    mga.onError(i, str);
                }

                @Override // com.bytedance.sdk.openadsdk.core.bf, com.bytedance.sdk.openadsdk.core.CMM.eli
                public void eli(com.bytedance.sdk.openadsdk.core.model.eli eliVar, Os os) {
                    eli.this.eli(eliVar, os, context, adSlot, mga, DbA);
                }
            });
        } else {
            this.DbA.eli(adSlot, new ujq(), 5, new CMM.eli() { // from class: com.bytedance.sdk.openadsdk.component.DbA.eli.2
                @Override // com.bytedance.sdk.openadsdk.core.CMM.eli
                public void eli(int i, String str) {
                    mga.onError(i, str);
                }

                @Override // com.bytedance.sdk.openadsdk.core.CMM.eli
                public void eli(com.bytedance.sdk.openadsdk.core.model.eli eliVar, Os os) {
                    eli.this.eli(eliVar, os, context, adSlot, mga, DbA);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eli(com.bytedance.sdk.openadsdk.core.model.eli eliVar, Os os, Context context, AdSlot adSlot, MGA mga, eU eUVar) {
        if (eliVar.aGH() != null && !eliVar.aGH().isEmpty()) {
            List<ev> aGH = eliVar.aGH();
            ArrayList arrayList = new ArrayList(aGH.size());
            for (ev evVar : aGH) {
                if (ev.ui(evVar) || (evVar != null && evVar.qnB())) {
                    PAGNativeAd eli2 = eli(context, evVar, adSlot);
                    if (mga instanceof PAGNativeAdLoadListener) {
                        arrayList.add(eli2);
                    }
                }
                if (ev.ui(evVar) && evVar.nY() != null && evVar.nY().du() != null) {
                    if (dV.aGH().aGH(String.valueOf(evVar.RTg())) && dV.aGH().WfR()) {
                        if (evVar.nY() != null) {
                            evVar.nY().MGA(1);
                        }
                        if (evVar.Ww() != null) {
                            evVar.Ww().MGA(1);
                        }
                        com.bytedance.sdk.openadsdk.core.nlS.eli.DbA eli3 = ev.eli(CacheDirFactory.getICacheDir(evVar.Sz()).Os(), evVar);
                        eli3.eli("material_meta", evVar);
                        eli3.eli("ad_slot", adSlot);
                        com.bytedance.sdk.openadsdk.core.nlS.ui.eli.eli(eli3, null);
                    }
                    IPMiBroadcastReceiver.eli(context, evVar);
                }
            }
            boolean z = mga instanceof PAGNativeAdLoadListener;
            if (z && !arrayList.isEmpty()) {
                if (adSlot != null && !TextUtils.isEmpty(adSlot.getBidAdm())) {
                    com.bytedance.sdk.openadsdk.Dfc.Os.eli(aGH.get(0), eUVar.aGH());
                }
                if (z) {
                    ((PAGNativeAdLoadListener) mga).onAdLoaded(arrayList.get(0));
                }
                if (os.ui() == null || os.ui().isEmpty()) {
                    return;
                }
                os.Os(4);
                Os.eli(os);
                return;
            }
            mga.onError(-4, wC.eli(-4));
            os.eli(-4);
            os.Os(4);
            Os.eli(os);
            return;
        }
        mga.onError(-3, wC.eli(-3));
        os.eli(-3);
        os.Os(4);
        Os.eli(os);
    }

    private PAGNativeAd eli(Context context, ev evVar, AdSlot adSlot) {
        if (evVar.BDs() == 2) {
            if (evVar.nY() != null) {
                return new com.bytedance.sdk.openadsdk.eli.DbA.eli.DbA(context, evVar, adSlot);
            }
            return new com.bytedance.sdk.openadsdk.eli.DbA.eli.Os(context, evVar, adSlot);
        }
        return new com.bytedance.sdk.openadsdk.eli.DbA.DbA(context, evVar, 5, adSlot);
    }
}
