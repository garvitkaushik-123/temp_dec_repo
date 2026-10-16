package com.bytedance.sdk.openadsdk.aGH.eli;

import com.bytedance.sdk.openadsdk.core.dV;
import com.bytedance.sdk.openadsdk.utils.cyF;
import com.bytedance.sdk.openadsdk.utils.gG;

/* loaded from: classes3.dex */
class nlS implements com.bytedance.sdk.openadsdk.Dfc.Os.DbA {
    public static final nlS eli = new nlS();

    private nlS() {
    }

    @Override // com.bytedance.sdk.openadsdk.Dfc.Os.DbA
    public void eli(com.bytedance.sdk.openadsdk.Dfc.DbA dbA) {
        eli(dbA, false);
    }

    @Override // com.bytedance.sdk.openadsdk.Dfc.Os.DbA
    public void eli(final com.bytedance.sdk.openadsdk.Dfc.DbA dbA, final boolean z) {
        eli(new com.bytedance.sdk.component.wC.wC("uploadLogEvent") { // from class: com.bytedance.sdk.openadsdk.aGH.eli.nlS.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    com.bytedance.sdk.openadsdk.Dfc.eli.Os logStats = dbA.getLogStats();
                    if (logStats == null) {
                        return;
                    }
                    com.bytedance.sdk.component.MGA.eli.aGH.eli.eli eliVar = new com.bytedance.sdk.component.MGA.eli.aGH.eli.eli(gG.eli(), logStats.eli());
                    eliVar.Os((byte) 0);
                    eliVar.DbA(z ? (byte) 2 : (byte) 3);
                    eliVar.eli((byte) 1);
                    if (com.bytedance.sdk.component.MGA.eli.DbA.DbA()) {
                        aGH.eli(dV.eli(), com.bytedance.sdk.openadsdk.multipro.DbA.Os());
                    }
                    com.bytedance.sdk.component.MGA.eli.DbA.eli(eliVar);
                } catch (Throwable unused) {
                }
            }
        });
    }

    private void eli(com.bytedance.sdk.component.wC.wC wCVar) {
        if (wCVar == null) {
            return;
        }
        if (!cyF.kb()) {
            cyF.DbA(wCVar, 5);
        } else {
            wCVar.run();
        }
    }
}
