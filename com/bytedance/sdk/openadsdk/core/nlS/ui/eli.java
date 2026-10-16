package com.bytedance.sdk.openadsdk.core.nlS.ui;

import android.os.SystemClock;
import android.text.TextUtils;
import com.bykv.vk.openvk.eli.eli.eli.Os.Os;
import com.bykv.vk.openvk.eli.eli.eli.ui.eli;
import com.bytedance.sdk.component.DbA.eli.kb;
import com.bytedance.sdk.component.wC.wC;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.aGH.ui.DbA.FC;
import com.bytedance.sdk.openadsdk.aGH.ui.DbA.aAs;
import com.bytedance.sdk.openadsdk.aGH.ui.DbA.du;
import com.bytedance.sdk.openadsdk.aGH.ui.DbA.nlS;
import com.bytedance.sdk.openadsdk.core.dV;
import com.bytedance.sdk.openadsdk.core.model.ev;
import com.bytedance.sdk.openadsdk.utils.cyF;
import com.bytedance.sdk.openadsdk.utils.dZ;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class eli {
    public static final com.bykv.vk.openvk.eli.eli.eli.ui.eli eli = new com.bykv.vk.openvk.eli.eli.DbA.eli.DbA.eli();

    private static boolean eli(Os os) {
        return true;
    }

    public static void eli(final Os os, final eli.InterfaceC0111eli interfaceC0111eli) {
        ev evVar;
        AdSlot adSlot;
        if ((os.MGA() > 0 || os.NU()) && os.nGm() != -2) {
            if (os.nGm() != 1) {
                os.ui(6000);
                os.MGA(6000);
                os.kb(6000);
                boolean z = os.ui("material_meta") != null && (os.ui("material_meta") instanceof ev);
                boolean z2 = os.ui("ad_slot") != null && (os.ui("ad_slot") instanceof AdSlot);
                if (z && z2) {
                    ev evVar2 = (ev) os.ui("material_meta");
                    AdSlot adSlot2 = (AdSlot) os.ui("ad_slot");
                    DbA(os, evVar2, adSlot2);
                    evVar = evVar2;
                    adSlot = adSlot2;
                } else {
                    evVar = null;
                    adSlot = null;
                }
                final long elapsedRealtime = SystemClock.elapsedRealtime();
                final AdSlot adSlot3 = adSlot;
                final ev evVar3 = evVar;
                final eli.InterfaceC0111eli interfaceC0111eli2 = new eli.InterfaceC0111eli() { // from class: com.bytedance.sdk.openadsdk.core.nlS.ui.eli.1
                    @Override // com.bykv.vk.openvk.eli.eli.eli.ui.eli.InterfaceC0111eli
                    public void eli(Os os2, int i) {
                        eli.InterfaceC0111eli interfaceC0111eli3 = eli.InterfaceC0111eli.this;
                        if (interfaceC0111eli3 != null) {
                            interfaceC0111eli3.eli(os2, i);
                        }
                        if (evVar3 == null || adSlot3 == null) {
                            return;
                        }
                        eli.DbA(os, evVar3, adSlot3, SystemClock.elapsedRealtime() - elapsedRealtime);
                    }

                    @Override // com.bykv.vk.openvk.eli.eli.eli.ui.eli.InterfaceC0111eli
                    public void eli(Os os2, int i, String str) {
                        eli.InterfaceC0111eli interfaceC0111eli3 = eli.InterfaceC0111eli.this;
                        if (interfaceC0111eli3 != null) {
                            interfaceC0111eli3.eli(os2, i, str);
                        }
                        if (evVar3 == null || adSlot3 == null) {
                            return;
                        }
                        eli.DbA(os, evVar3, adSlot3, SystemClock.elapsedRealtime() - elapsedRealtime, i, str);
                    }

                    @Override // com.bykv.vk.openvk.eli.eli.eli.ui.eli.InterfaceC0111eli
                    public void DbA(Os os2, int i) {
                        AdSlot adSlot4;
                        eli.InterfaceC0111eli interfaceC0111eli3 = eli.InterfaceC0111eli.this;
                        if (interfaceC0111eli3 != null) {
                            interfaceC0111eli3.eli(os2, i);
                        }
                        ev evVar4 = evVar3;
                        if (evVar4 != null && (adSlot4 = adSlot3) != null) {
                            eli.Os(os, evVar4, adSlot4);
                        }
                        new Object[]{"cancel: ", os.dV()};
                    }
                };
                if (!eli(os.aqO())) {
                    if (interfaceC0111eli != null) {
                        interfaceC0111eli.eli(os, 404, "unexpected url: " + os.aqO());
                    }
                    DbA(os, evVar3, adSlot3, SystemClock.elapsedRealtime() - elapsedRealtime, -1, "video url is invalid");
                    return;
                } else {
                    wC wCVar = new wC("VideoPreload") { // from class: com.bytedance.sdk.openadsdk.core.nlS.ui.eli.2
                        @Override // java.lang.Runnable
                        public void run() {
                            try {
                                eli.eli.eli(dV.eli(), os, interfaceC0111eli2);
                            } catch (Throwable th) {
                                th.getMessage();
                            }
                        }
                    };
                    if (cyF.MGA()) {
                        cyF.DbA(wCVar);
                        return;
                    } else {
                        wCVar.run();
                        return;
                    }
                }
            }
        }
        if (interfaceC0111eli != null) {
            interfaceC0111eli.eli(os, 100);
        }
    }

    private static void DbA(Os os, ev evVar, AdSlot adSlot) {
        if (eli(os)) {
            com.bytedance.sdk.openadsdk.Dfc.Os.eli("load_video_start", new com.bytedance.sdk.openadsdk.aGH.ui.DbA.eli(evVar, dZ.Os(adSlot.getDurationSlotType()), com.bytedance.sdk.openadsdk.aGH.ui.eli.eli.eli(evVar, (String) null, -1, os), new du(os.aqO(), os.NU() ? os.nlS() : os.MGA())));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void DbA(Os os, ev evVar, AdSlot adSlot, long j, int i, String str) {
        if (eli(os)) {
            String Os = dZ.Os(adSlot.getDurationSlotType());
            JSONObject eli2 = com.bytedance.sdk.openadsdk.aGH.ui.eli.eli.eli(evVar, (String) null, -1, os);
            aAs aas = new aAs();
            aas.eli(os.aqO());
            aas.eli(os.MGA());
            aas.DbA(j);
            aas.eli(i);
            if (TextUtils.isEmpty(str)) {
                str = "";
            }
            aas.DbA(str);
            aas.Os("");
            com.bytedance.sdk.openadsdk.aGH.ui.eli.eli.eli((com.bytedance.sdk.openadsdk.aGH.ui.DbA.eli<aAs>) new com.bytedance.sdk.openadsdk.aGH.ui.DbA.eli(evVar, Os, eli2, aas));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void DbA(Os os, ev evVar, AdSlot adSlot, long j) {
        if (eli(os)) {
            String Os = dZ.Os(adSlot.getDurationSlotType());
            JSONObject eli2 = com.bytedance.sdk.openadsdk.aGH.ui.eli.eli.eli(evVar, (String) null, -1, os);
            nlS nls = new nlS();
            nls.eli(os.aqO());
            nls.eli(os.MGA());
            nls.DbA(j);
            if (os.CMM() == 1) {
                nls.Os(1L);
            } else {
                nls.Os(0L);
            }
            com.bytedance.sdk.openadsdk.Dfc.Os.eli("load_video_success", new com.bytedance.sdk.openadsdk.aGH.ui.DbA.eli(evVar, Os, eli2, nls));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void Os(Os os, ev evVar, AdSlot adSlot) {
        if (eli(os)) {
            com.bytedance.sdk.openadsdk.aGH.ui.eli.eli.DbA((com.bytedance.sdk.openadsdk.aGH.ui.DbA.eli<FC>) new com.bytedance.sdk.openadsdk.aGH.ui.DbA.eli(evVar, dZ.Os(adSlot.getDurationSlotType()), com.bytedance.sdk.openadsdk.aGH.ui.eli.eli.eli(evVar, (String) null, -1, os), new FC(os.aqO(), os.MGA())));
        }
    }

    public static boolean eli(String str) {
        String str2;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (str.regionMatches(true, 0, "ws:", 0, 3)) {
            str2 = "http:" + str.substring(3);
        } else {
            str2 = str.regionMatches(true, 0, "wss:", 0, 4) ? "https:" + str.substring(4) : str;
        }
        return kb.Os(str2) != null;
    }
}
