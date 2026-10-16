package com.bytedance.sdk.openadsdk.core.eli;

import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.BuildConfig;
import com.bytedance.sdk.openadsdk.core.CMM;
import com.bytedance.sdk.openadsdk.dV.Os;
import com.bytedance.sdk.openadsdk.dV.aGH;
import com.bytedance.sdk.openadsdk.utils.cyF;
import com.bytedance.sdk.openadsdk.utils.dZ;
import com.vungle.ads.internal.Constants;

/* loaded from: classes3.dex */
public class eli implements CMM.eli {
    private final AdSlot DbA;
    private final boolean Os;
    private final CMM.eli eli;

    public eli(CMM.eli eliVar, AdSlot adSlot, boolean z) {
        this.eli = eliVar;
        this.DbA = adSlot;
        this.Os = z;
    }

    @Override // com.bytedance.sdk.openadsdk.core.CMM.eli
    public void eli(final int i, final String str) {
        AdSlot adSlot;
        if (this.eli != null) {
            if (cyF.MGA() || ((adSlot = this.DbA) != null && adSlot.getDurationSlotType() != 5 && com.bytedance.sdk.openadsdk.bf.eli.eli("getads_callback_async", 0) == 1)) {
                this.eli.eli(i, str);
            } else {
                cyF.eli(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.eli.eli.1
                    @Override // java.lang.Runnable
                    public void run() {
                        eli.this.eli.eli(i, str);
                    }
                });
            }
            if (!this.Os || this.DbA == null) {
                return;
            }
            Os.Os(new aGH() { // from class: com.bytedance.sdk.openadsdk.core.eli.eli.2
                @Override // com.bytedance.sdk.openadsdk.dV.aGH
                public com.bytedance.sdk.openadsdk.dV.DbA.eli generatorModel() {
                    com.bytedance.sdk.openadsdk.dV.DbA.eli eliVar = new com.bytedance.sdk.openadsdk.dV.DbA.eli();
                    eliVar.DbA(Constants.LOAD_AD);
                    eliVar.Os(eli.this.DbA.getCodeId());
                    eliVar.aGH(dZ.Os(eli.this.DbA.getDurationSlotType()));
                    eliVar.eli(BuildConfig.VERSION_NAME);
                    eliVar.kb(dZ.eli(eli.this.DbA).toString());
                    return eliVar;
                }
            });
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.CMM.eli
    public void eli(final com.bytedance.sdk.openadsdk.core.model.eli eliVar, final com.bytedance.sdk.openadsdk.core.model.Os os) {
        AdSlot adSlot;
        if (this.eli != null) {
            if (cyF.MGA() || ((adSlot = this.DbA) != null && adSlot.getDurationSlotType() != 5 && com.bytedance.sdk.openadsdk.bf.eli.eli("getads_callback_async", 0) == 1)) {
                this.eli.eli(eliVar, os);
            } else {
                cyF.eli(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.eli.eli.3
                    @Override // java.lang.Runnable
                    public void run() {
                        eli.this.eli.eli(eliVar, os);
                    }
                });
            }
            if (!this.Os || this.DbA == null) {
                return;
            }
            Os.DbA(new aGH() { // from class: com.bytedance.sdk.openadsdk.core.eli.eli.4
                @Override // com.bytedance.sdk.openadsdk.dV.aGH
                public com.bytedance.sdk.openadsdk.dV.DbA.eli generatorModel() {
                    com.bytedance.sdk.openadsdk.dV.DbA.eli eliVar2 = new com.bytedance.sdk.openadsdk.dV.DbA.eli();
                    eliVar2.DbA(Constants.LOAD_AD);
                    eliVar2.Os(eli.this.DbA.getCodeId());
                    eliVar2.aGH(dZ.Os(eli.this.DbA.getDurationSlotType()));
                    eliVar2.eli(BuildConfig.VERSION_NAME);
                    eliVar2.kb(dZ.eli(eli.this.DbA).toString());
                    return eliVar2;
                }
            });
        }
    }
}
