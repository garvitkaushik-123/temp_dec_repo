package com.bytedance.sdk.openadsdk.core;

import android.content.Context;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Pair;
import android.view.WindowManager;
import com.bytedance.sdk.component.embedapplog.PangleEncryptConstant;
import com.bytedance.sdk.component.embedapplog.PangleEncryptManager;
import com.bytedance.sdk.component.pglcrypt.PglCryptUtils;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.ApmHelper;
import com.bytedance.sdk.openadsdk.BuildConfig;
import com.bytedance.sdk.openadsdk.FilterWord;
import com.bytedance.sdk.openadsdk.core.CMM;
import com.bytedance.sdk.openadsdk.utils.DeviceUtils;
import com.bytedance.sdk.openadsdk.utils.SSo;
import com.bytedance.sdk.openadsdk.utils.dZ;
import com.bytedance.sdk.openadsdk.utils.eU;
import com.google.common.net.HttpHeaders;
import com.inmobi.sdk.InMobiSdk;
import com.ironsource.C3040d4;
import com.ironsource.C3114ha;
import com.ironsource.C3288s;
import com.ironsource.D5;
import com.ironsource.N6;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.pgl.ssdk.ces.out.DungeonFlag;
import io.adn.sdk.internal.domain.constants.AnalyticsConstants;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.zip.GZIPOutputStream;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class ev implements CMM<com.bytedance.sdk.openadsdk.aGH.eli> {
    private final Context eli;

    ev(Context context) {
        this.eli = context;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(18:0|1|2|3|(13:8|9|(1:(1:14))(2:35|(1:(1:40))(2:41|(1:46)))|15|16|(1:19)|21|(1:24)|25|(1:27)|28|(1:30)|32)|47|9|(0)(0)|15|16|(1:19)|21|(1:24)|25|(0)|28|(0)|32) */
    /* JADX WARN: Removed duplicated region for block: B:11:0x0027  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0115 A[Catch: all -> 0x0147, TryCatch #0 {all -> 0x0147, blocks: (B:3:0x000b, B:5:0x0012, B:8:0x001b, B:12:0x0029, B:14:0x002d, B:21:0x0079, B:24:0x00f6, B:25:0x0106, B:27:0x0115, B:28:0x0122, B:30:0x013e, B:38:0x0039, B:40:0x003d, B:44:0x0048, B:46:0x004c, B:47:0x001e), top: B:2:0x000b }] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x013e A[Catch: all -> 0x0147, TRY_LEAVE, TryCatch #0 {all -> 0x0147, blocks: (B:3:0x000b, B:5:0x0012, B:8:0x001b, B:12:0x0029, B:14:0x002d, B:21:0x0079, B:24:0x00f6, B:25:0x0106, B:27:0x0115, B:28:0x0122, B:30:0x013e, B:38:0x0039, B:40:0x003d, B:44:0x0048, B:46:0x004c, B:47:0x001e), top: B:2:0x000b }] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0033  */
    @DungeonFlag
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private JSONObject eli(AdSlot adSlot, com.bytedance.sdk.openadsdk.core.model.ujq ujqVar, int i) {
        JSONObject jSONObject;
        String ui;
        long currentTimeMillis;
        String str;
        String FC;
        String nGm;
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject = new JSONObject();
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.Xb.Os("body data exception", th);
        }
        if (ujqVar != null && !TextUtils.isEmpty(ujqVar.eli)) {
            ui = ujqVar.eli;
            if (i != 7) {
                if (ujqVar != null && ujqVar.DbA > 0) {
                    jSONObject.put("req_type", ujqVar.DbA);
                }
            } else if (i == 8) {
                if (ujqVar != null && ujqVar.Os > 0) {
                    jSONObject.put("req_type", ujqVar.Os);
                }
            } else if (i == 3 && ujqVar != null && ujqVar.aGH > 0) {
                jSONObject.put("req_type", ujqVar.aGH);
            }
            FC = dV.aGH().FC();
            nGm = dV.aGH().nGm();
            if (FC != null && nGm != null) {
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("version", FC);
                jSONObject3.put("param", nGm);
                jSONObject.put("abtest", jSONObject3);
            }
            jSONObject.put("request_id", ui);
            dZ.eli(jSONObject);
            jSONObject.put("ad_sdk_version", BuildConfig.VERSION_NAME);
            jSONObject.put("js_render_ver", com.bytedance.sdk.openadsdk.core.wC.nlS.DbA());
            jSONObject.put("js_render_v3_ver", com.bytedance.sdk.openadsdk.core.wC.nlS.Os());
            jSONObject.put("source_type", MBridgeConstans.DYNAMIC_VIEW_WX_APP);
            jSONObject.put(MBridgeConstans.DYNAMIC_VIEW_WX_APP, Os());
            Object eli2 = DeviceUtils.eli(this.eli, true);
            new Object[]{"device info:", eli2};
            jSONObject.put(C3040d4.h.G, eli2);
            jSONObject.put(AnalyticsConstants.SOURCE_USER_TYPE, eli(adSlot));
            jSONObject.put(N6.d0, dZ.aGH());
            jSONObject.put("channel", C3040d4.h.Z);
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(eli(adSlot, i, ujqVar));
            jSONObject.put("adslots", jSONArray);
            eli(jSONObject, ujqVar);
            currentTimeMillis = System.currentTimeMillis() / 1000;
            jSONObject.put("ts", currentTimeMillis);
            str = "";
            if (adSlot.getCodeId() != null && ui != null) {
                str = String.valueOf(currentTimeMillis).concat(adSlot.getCodeId()).concat(ui);
            }
            jSONObject.put("req_sign", com.bytedance.sdk.component.utils.ui.eli(str));
            if (com.bytedance.sdk.openadsdk.core.FC.Os.ui() != 0) {
                jSONObject.put("pglx", String.valueOf(com.bytedance.sdk.openadsdk.core.FC.Os.ui()));
            }
            jSONObject.put("adx_id", FC.DbA().Vy());
            com.bytedance.sdk.openadsdk.MGA.DbA.eli().eli(jSONObject);
            jSONObject2 = eli(PangleEncryptConstant.CryptDataScene.GET_ADS, jSONObject);
            if (jSONObject2 != null) {
                jSONObject2.put("ad_sdk_version", BuildConfig.VERSION_NAME);
                jSONObject2.put("oversea_version_type", 1);
            }
            return jSONObject2;
        }
        ui = dZ.ui();
        if (i != 7) {
        }
        FC = dV.aGH().FC();
        nGm = dV.aGH().nGm();
        if (FC != null) {
            JSONObject jSONObject32 = new JSONObject();
            jSONObject32.put("version", FC);
            jSONObject32.put("param", nGm);
            jSONObject.put("abtest", jSONObject32);
        }
        jSONObject.put("request_id", ui);
        dZ.eli(jSONObject);
        jSONObject.put("ad_sdk_version", BuildConfig.VERSION_NAME);
        jSONObject.put("js_render_ver", com.bytedance.sdk.openadsdk.core.wC.nlS.DbA());
        jSONObject.put("js_render_v3_ver", com.bytedance.sdk.openadsdk.core.wC.nlS.Os());
        jSONObject.put("source_type", MBridgeConstans.DYNAMIC_VIEW_WX_APP);
        jSONObject.put(MBridgeConstans.DYNAMIC_VIEW_WX_APP, Os());
        Object eli22 = DeviceUtils.eli(this.eli, true);
        new Object[]{"device info:", eli22};
        jSONObject.put(C3040d4.h.G, eli22);
        jSONObject.put(AnalyticsConstants.SOURCE_USER_TYPE, eli(adSlot));
        jSONObject.put(N6.d0, dZ.aGH());
        jSONObject.put("channel", C3040d4.h.Z);
        JSONArray jSONArray2 = new JSONArray();
        jSONArray2.put(eli(adSlot, i, ujqVar));
        jSONObject.put("adslots", jSONArray2);
        eli(jSONObject, ujqVar);
        currentTimeMillis = System.currentTimeMillis() / 1000;
        jSONObject.put("ts", currentTimeMillis);
        str = "";
        if (adSlot.getCodeId() != null) {
            str = String.valueOf(currentTimeMillis).concat(adSlot.getCodeId()).concat(ui);
        }
        jSONObject.put("req_sign", com.bytedance.sdk.component.utils.ui.eli(str));
        if (com.bytedance.sdk.openadsdk.core.FC.Os.ui() != 0) {
        }
        jSONObject.put("adx_id", FC.DbA().Vy());
        com.bytedance.sdk.openadsdk.MGA.DbA.eli().eli(jSONObject);
        jSONObject2 = eli(PangleEncryptConstant.CryptDataScene.GET_ADS, jSONObject);
        if (jSONObject2 != null) {
        }
        return jSONObject2;
    }

    private void eli(JSONObject jSONObject, com.bytedance.sdk.openadsdk.core.model.ujq ujqVar) {
        if (ujqVar == null || ujqVar.ui == null) {
            return;
        }
        try {
            jSONObject.put("source_temai_product_ids", ujqVar.ui);
        } catch (Exception unused) {
        }
    }

    private boolean aGH(String str) {
        if (com.bytedance.sdk.openadsdk.core.kb.DbA.eli()) {
            return true;
        }
        if (!com.bytedance.sdk.openadsdk.core.kb.DbA.eli(str)) {
            return false;
        }
        String DbA2 = com.bytedance.sdk.openadsdk.core.kb.DbA.DbA();
        if (!TextUtils.isEmpty(DbA2)) {
            com.bytedance.sdk.openadsdk.aGH.Os.eli(DbA2, System.currentTimeMillis());
        }
        return true;
    }

    @Override // com.bytedance.sdk.openadsdk.core.CMM
    public void eli(AdSlot adSlot, com.bytedance.sdk.openadsdk.core.model.ujq ujqVar, int i, Xb xb) {
        if (ujqVar.MGA || !TextUtils.isEmpty(adSlot.getBidAdm())) {
            eli(adSlot, ujqVar, i, (CMM.eli) xb);
            return;
        }
        if (!eli(ujqVar) && xb != null) {
            String eli2 = xb.eli();
            if (!TextUtils.isEmpty(eli2)) {
                ujqVar.nlS = eli2;
                ujqVar.NU = xb;
            }
        }
        eli(adSlot, ujqVar, i, (CMM.eli) xb);
    }

    private boolean eli(com.bytedance.sdk.openadsdk.core.model.ujq ujqVar) {
        if (ujqVar != null) {
            return ujqVar.DbA == 2 || ujqVar.Os == 2 || ujqVar.aGH == 2;
        }
        return false;
    }

    @Override // com.bytedance.sdk.openadsdk.core.CMM
    public void eli(final AdSlot adSlot, final com.bytedance.sdk.openadsdk.core.model.ujq ujqVar, final int i, CMM.eli eliVar) {
        if (ujqVar != null && (ujqVar.DbA == 2 || ujqVar.Os == 2 || ujqVar.aGH == 2)) {
            adSlot.setPreload(true);
        }
        final com.bytedance.sdk.openadsdk.core.eli.eli eliVar2 = new com.bytedance.sdk.openadsdk.core.eli.eli(eliVar, adSlot, (adSlot.isPreload() || ujqVar == null || ujqVar.MGA) ? false : true);
        if (Looper.myLooper() == Looper.getMainLooper()) {
            nn.DbA().post(new com.bytedance.sdk.component.wC.wC("getAd") { // from class: com.bytedance.sdk.openadsdk.core.ev.1
                @Override // java.lang.Runnable
                public void run() {
                    ev.this.DbA(adSlot, ujqVar, i, eliVar2);
                }
            });
        } else {
            DbA(adSlot, ujqVar, i, eliVar2);
        }
        if (com.bytedance.sdk.openadsdk.bf.eli.Os()) {
            nn.kb();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void DbA(final AdSlot adSlot, final com.bytedance.sdk.openadsdk.core.model.ujq ujqVar, final int i, final CMM.eli eliVar) {
        com.bytedance.sdk.openadsdk.core.model.eli eliVar2;
        if (!dV.aGH().vb()) {
            eliVar.eli(40060, wC.eli(40060));
            return;
        }
        boolean Os = com.bytedance.sdk.openadsdk.bf.eli.Os();
        if (!Os) {
            nn.MGA();
        }
        final com.bytedance.sdk.openadsdk.core.model.Os os = new com.bytedance.sdk.openadsdk.core.model.Os();
        os.eli(adSlot);
        if (!com.bytedance.sdk.openadsdk.core.settings.FC.eli()) {
            if (eliVar != null) {
                eliVar.eli(1000, "Ad request is temporarily paused, Please contact your AM");
                os.eli(1000);
                com.bytedance.sdk.openadsdk.core.model.Os.eli(os);
                return;
            }
            return;
        }
        if (!dV.aGH().dZ()) {
            if (eliVar != null) {
                eliVar.eli(-16, wC.eli(-16));
                os.eli(1001);
                com.bytedance.sdk.openadsdk.core.model.Os.eli(os);
                return;
            }
            return;
        }
        if (eliVar == null) {
            return;
        }
        if (aGH(adSlot.getCodeId())) {
            eliVar.eli(-8, wC.eli(-8));
            return;
        }
        if (!TextUtils.isEmpty(adSlot.getBidAdm()) && !ujqVar.MGA) {
            os.DbA(2);
            os.eli(adSlot.getBidAdm());
            if (com.bytedance.sdk.component.utils.Dfc.aGH()) {
                com.bykv.vk.openvk.eli.eli.eli.kb.DbA.eli(adSlot.getBidAdm());
            }
            if (dV.aGH().Za() && GB.eli().aGH() == 1) {
                dZ.eli("Pangle_Debug_Mode", adSlot.getBidAdm(), this.eli);
            }
            try {
                JSONObject eli2 = eli(new JSONObject(adSlot.getBidAdm()));
                if (eli2 == null) {
                    os.Os(12);
                    eli(eliVar, os);
                    return;
                }
                eli eli3 = eli.eli(eli2, adSlot, ujqVar);
                os.eli(eli3.aAs);
                nlS.eli(eli3.FC);
                if (eli3.aGH != 20000) {
                    eliVar.eli(eli3.aGH, eli3.ui);
                    os.eli(eli3.aGH);
                    os.Os(9);
                    com.bytedance.sdk.openadsdk.core.model.Os.eli(os);
                    return;
                }
                if (eli3.wC == null) {
                    os.Os(13);
                    eli(eliVar, os);
                    return;
                }
                if (eli3.wC.aGH() != null && !eli3.wC.aGH().isEmpty()) {
                    com.bytedance.sdk.openadsdk.Dfc.Os.eli(eli3.wC.aGH().get(0));
                }
                eli(eli3.wC);
                if (eli(eli3.wC, eliVar)) {
                    return;
                }
                com.bytedance.sdk.openadsdk.core.du.Os.aGH.eli(eli3.wC);
                eliVar.eli(eli3.wC, os);
                Map<String, com.bytedance.sdk.openadsdk.core.model.ev> eli4 = com.bytedance.sdk.openadsdk.core.model.eli.eli(eli3.wC);
                if (eli4 != null) {
                    com.bytedance.sdk.openadsdk.kb.DbA.eli().eli(eli4);
                }
                DbA(eli3.wC);
                com.bytedance.sdk.openadsdk.core.aGH.eli.eli().eli(eli3.wC);
                return;
            } catch (Throwable th) {
                com.bytedance.sdk.component.utils.Xb.eli("NetApiImpl", "get ad error: ", th);
                os.Os(14);
                os.DbA(th.getMessage());
                eli(eliVar, os);
                return;
            }
        }
        if (ujqVar != null && !TextUtils.isEmpty(ujqVar.nlS)) {
            try {
                JSONObject eli5 = eli(new JSONObject(ujqVar.nlS));
                if (eli5 != null) {
                    eli eli6 = eli.eli(eli5, adSlot, ujqVar);
                    if (ujqVar.NU != null && (eliVar2 = eli6.wC) != null && ujqVar.NU.eli(eliVar2)) {
                        com.bytedance.sdk.openadsdk.core.du.Os.aGH.eli(eliVar2);
                        eliVar.eli(eliVar2, os);
                        return;
                    }
                }
            } catch (Throwable unused) {
            }
        }
        JSONObject eli7 = eli(adSlot, ujqVar, i);
        if (eli7 == null) {
            eliVar.eli(-9, wC.eli(-9));
            os.eli(-9);
            com.bytedance.sdk.openadsdk.core.model.Os.eli(os);
            return;
        }
        if (dV.aGH().Za() && GB.eli().aGH() == 1) {
            dZ.eli("Pangle_Debug_Mode", eli7.toString(), this.eli);
        }
        String eli8 = dZ.eli("/api/ad/union/sdk/get_ads/", true, false);
        final com.bytedance.sdk.component.kb.DbA.aGH DbA2 = com.bytedance.sdk.openadsdk.nGm.DbA.DbA().Os().DbA();
        try {
            DbA2.DbA(com.bytedance.sdk.openadsdk.wC.aGH.eli(DbA2, eli8));
        } catch (Exception unused2) {
        }
        DbA2.eli(eli7.toString(), dV.aGH().Dfc());
        Map<String, String> eli9 = com.bytedance.sdk.openadsdk.core.FC.Os.eli(eli8, eli7.toString());
        if (eli9 != null && eli9.size() > 0) {
            for (String str : eli9.keySet()) {
                try {
                    DbA2.DbA(str, eli9.get(str));
                } catch (Exception e) {
                    com.bytedance.sdk.component.utils.Xb.Os("NetApiImpl", e.getMessage());
                }
            }
        }
        try {
            DbA2.DbA("User-Agent", dZ.aGH());
            eli(DbA2, eli7);
        } catch (Exception unused3) {
        }
        final eU DbA3 = eU.DbA();
        final Map<String, Object> requestExtraMap = adSlot.getRequestExtraMap();
        boolean z = FC.DbA().dV() && requestExtraMap != null;
        if (z) {
            requestExtraMap.put("pgad_start", DbA3);
        }
        DbA2.eli(10);
        DbA2.eli("get_ad");
        com.bytedance.sdk.openadsdk.dV.Os.eli(new com.bytedance.sdk.openadsdk.dV.aGH() { // from class: com.bytedance.sdk.openadsdk.core.ev.8
            @Override // com.bytedance.sdk.openadsdk.dV.aGH
            public com.bytedance.sdk.openadsdk.dV.DbA.eli generatorModel() {
                com.bytedance.sdk.openadsdk.dV.DbA.eli eliVar3 = new com.bytedance.sdk.openadsdk.dV.DbA.eli();
                eliVar3.DbA("get_ad");
                eliVar3.Os(adSlot.getCodeId());
                eliVar3.aGH(dZ.Os(adSlot.getDurationSlotType()));
                return eliVar3;
            }
        });
        if (com.bytedance.sdk.component.utils.Dfc.aGH()) {
            Thread.currentThread().getName();
        }
        if (!Os) {
            final boolean z2 = z;
            DbA2.eli(new com.bytedance.sdk.component.kb.eli.DbA() { // from class: com.bytedance.sdk.openadsdk.core.ev.9
                @Override // com.bytedance.sdk.component.kb.eli.eli
                public void eli(com.bytedance.sdk.component.kb.DbA.Os os2, com.bytedance.sdk.component.kb.DbA dbA) {
                    ev.this.eli(os2, dbA, z2, (Map<String, Object>) requestExtraMap, DbA3, adSlot, os, eliVar, ujqVar, i);
                }

                @Override // com.bytedance.sdk.component.kb.eli.DbA
                public void eli(com.bytedance.sdk.component.kb.DbA.Os os2, IOException iOException, com.bytedance.sdk.component.kb.DbA dbA) {
                    ev.this.eli(DbA2, iOException, dbA, adSlot, z2, (Map<String, Object>) requestExtraMap, eliVar, os);
                    if (os2 != null) {
                        com.bytedance.sdk.openadsdk.utils.bf.eli(os2.aGH());
                    }
                }
            });
        } else {
            Map<String, Object> map = requestExtraMap;
            try {
                com.bytedance.sdk.component.kb.DbA eli10 = DbA2.eli();
                com.bytedance.sdk.component.kb.DbA dbA = eli10 == null ? new com.bytedance.sdk.component.kb.DbA(false, 5001, "response is null, content type is not support!!", null, "REQUEST_BODY_NULL", 1L, 1L) : eli10;
                if (dbA.MGA()) {
                    boolean z3 = z;
                    try {
                        eli(DbA2, dbA, z3, map, DbA3, adSlot, os, eliVar, ujqVar, i);
                    } catch (Throwable th2) {
                        th = th2;
                        z = z3;
                        map = map;
                        os = os;
                        eli(DbA2, new IOException(th.getMessage()), new com.bytedance.sdk.component.kb.DbA(false, 5002, "execute method throw exception", null, "REQUEST_BODY_EXCEPTION", 1L, 1L), adSlot, z, map, eliVar, os);
                        com.bytedance.sdk.openadsdk.QX.eli.DbA.eli.eli().eli(false);
                    }
                } else {
                    eli(DbA2, new IOException(dbA.DbA()), dbA, adSlot, z, map, eliVar, os);
                    if (DbA2 != null) {
                        com.bytedance.sdk.openadsdk.utils.bf.eli(DbA2.aGH());
                    }
                }
            } catch (Throwable th3) {
                th = th3;
            }
        }
        com.bytedance.sdk.openadsdk.QX.eli.DbA.eli.eli().eli(false);
    }

    private void eli(com.bytedance.sdk.openadsdk.core.model.eli eliVar) {
        com.bytedance.sdk.openadsdk.core.model.ev MGA;
        if (eliVar == null || (MGA = eliVar.MGA()) == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.settings.NU.VM(MGA.Daf());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eli(com.bytedance.sdk.component.kb.DbA.aGH agh, IOException iOException, com.bytedance.sdk.component.kb.DbA dbA, final AdSlot adSlot, boolean z, Map<String, Object> map, CMM.eli eliVar, com.bytedance.sdk.openadsdk.core.model.Os os) {
        String str;
        int i;
        com.bytedance.sdk.openadsdk.dV.Os.Os(new com.bytedance.sdk.openadsdk.dV.aGH() { // from class: com.bytedance.sdk.openadsdk.core.ev.10
            @Override // com.bytedance.sdk.openadsdk.dV.aGH
            public com.bytedance.sdk.openadsdk.dV.DbA.eli generatorModel() {
                com.bytedance.sdk.openadsdk.dV.DbA.eli eliVar2 = new com.bytedance.sdk.openadsdk.dV.DbA.eli();
                eliVar2.DbA("get_ad");
                eliVar2.Os(adSlot.getCodeId());
                eliVar2.aGH(dZ.Os(adSlot.getDurationSlotType()));
                eliVar2.eli(BuildConfig.VERSION_NAME);
                return eliVar2;
            }
        });
        if (dbA != null) {
            str = dbA.DbA();
        } else if (iOException == null) {
            str = "";
        } else {
            str = iOException.getMessage();
        }
        eU DbA2 = eU.DbA();
        if (z) {
            map.put("pgad_end", Long.valueOf(DbA2.eli));
        }
        if (dV.aGH().Za() && GB.eli().aGH() == 1) {
            dZ.eli("Pangle_Debug_Mode", iOException != null ? iOException.getMessage() : null, this.eli);
        }
        if (dbA != null) {
            i = dbA.eli();
        } else {
            i = (iOException == null || !(iOException instanceof SocketTimeoutException)) ? 601 : 602;
        }
        if (eliVar != null) {
            eliVar.eli(i, str);
        }
        new Object[]{"onFailure: ", Integer.valueOf(i)};
        os.eli(i);
        os.Os(10);
        os.DbA(str);
        com.bytedance.sdk.openadsdk.core.model.Os.eli(os);
        com.bytedance.sdk.openadsdk.aGH.eli.MGA.Os.incrementAndGet();
        com.bytedance.sdk.openadsdk.aGH.eli.MGA.eli.incrementAndGet();
        com.bytedance.sdk.openadsdk.aGH.eli.MGA.kb.incrementAndGet();
        com.bytedance.sdk.openadsdk.aGH.eli.MGA.ui();
        com.bytedance.sdk.openadsdk.aGH.eli.MGA.eli(i, str);
        com.bytedance.sdk.openadsdk.aGH.eli.MGA.Os();
        com.bytedance.sdk.openadsdk.Dfc.eli.ui.eli("get_ad", agh.aGH(), i, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:53:0x01cc A[Catch: all -> 0x0218, TryCatch #2 {all -> 0x0218, blocks: (B:9:0x0031, B:11:0x004c, B:13:0x0056, B:14:0x0061, B:16:0x0067, B:19:0x0078, B:21:0x008c, B:23:0x009b, B:25:0x00a2, B:26:0x00b3, B:28:0x00ac, B:29:0x00c4, B:31:0x00c8, B:33:0x00d9, B:37:0x00e3, B:39:0x00ee, B:41:0x00f2, B:42:0x00f9, B:91:0x0140, B:94:0x0144, B:96:0x014a, B:78:0x0155, B:80:0x0162, B:81:0x0173, B:82:0x016b, B:51:0x01b3, B:53:0x01cc, B:54:0x01d3, B:56:0x01db, B:59:0x01e9, B:60:0x0208, B:61:0x020d), top: B:8:0x0031 }] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x01e9 A[Catch: all -> 0x0218, TryCatch #2 {all -> 0x0218, blocks: (B:9:0x0031, B:11:0x004c, B:13:0x0056, B:14:0x0061, B:16:0x0067, B:19:0x0078, B:21:0x008c, B:23:0x009b, B:25:0x00a2, B:26:0x00b3, B:28:0x00ac, B:29:0x00c4, B:31:0x00c8, B:33:0x00d9, B:37:0x00e3, B:39:0x00ee, B:41:0x00f2, B:42:0x00f9, B:91:0x0140, B:94:0x0144, B:96:0x014a, B:78:0x0155, B:80:0x0162, B:81:0x0173, B:82:0x016b, B:51:0x01b3, B:53:0x01cc, B:54:0x01d3, B:56:0x01db, B:59:0x01e9, B:60:0x0208, B:61:0x020d), top: B:8:0x0031 }] */
    /* JADX WARN: Removed duplicated region for block: B:68:0x010d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void eli(com.bytedance.sdk.component.kb.DbA.Os os, com.bytedance.sdk.component.kb.DbA dbA, boolean z, Map<String, Object> map, eU eUVar, final AdSlot adSlot, com.bytedance.sdk.openadsdk.core.model.Os os2, CMM.eli eliVar, com.bytedance.sdk.openadsdk.core.model.ujq ujqVar, int i) {
        int i2;
        Object[] objArr;
        eU eUVar2;
        Map<String, com.bytedance.sdk.openadsdk.core.model.ev> eli2;
        com.bytedance.sdk.openadsdk.core.model.Os os3 = os2;
        CMM.eli eliVar2 = eliVar;
        if (z) {
            map.put("pgad_end", eUVar);
        }
        if (dbA == null) {
            return;
        }
        if (dbA.MGA()) {
            com.bytedance.sdk.openadsdk.dV.Os.DbA(new com.bytedance.sdk.openadsdk.dV.aGH() { // from class: com.bytedance.sdk.openadsdk.core.ev.11
                @Override // com.bytedance.sdk.openadsdk.dV.aGH
                public com.bytedance.sdk.openadsdk.dV.DbA.eli generatorModel() {
                    com.bytedance.sdk.openadsdk.dV.DbA.eli eliVar3 = new com.bytedance.sdk.openadsdk.dV.DbA.eli();
                    eliVar3.DbA("get_ad");
                    eliVar3.Os(adSlot.getCodeId());
                    eliVar3.aGH(dZ.Os(adSlot.getDurationSlotType()));
                    eliVar3.eli(BuildConfig.VERSION_NAME);
                    return eliVar3;
                }
            });
            com.bytedance.sdk.openadsdk.aGH.eli.MGA.DbA.incrementAndGet();
            com.bytedance.sdk.openadsdk.aGH.eli.MGA.eli.incrementAndGet();
            try {
                eU DbA2 = eU.DbA();
                String aGH = dbA.aGH();
                os3.eli(aGH);
                JSONObject jSONObject = new JSONObject(aGH);
                if (dV.aGH().Za() && GB.eli().aGH() == 1) {
                    dZ.eli("Pangle_Debug_Mode", jSONObject.toString(), this.eli);
                }
                JSONObject eli3 = eli(jSONObject);
                if (eli3 == null) {
                    os3.Os(12);
                    eli(eliVar2, os3);
                    com.bytedance.sdk.openadsdk.aGH.eli.MGA.MGA.incrementAndGet();
                    com.bytedance.sdk.openadsdk.aGH.eli.MGA.Os();
                    return;
                }
                eli eli4 = eli.eli(eli3, adSlot, ujqVar);
                os3.eli(eli4.aAs);
                nlS.eli(eli4.FC);
                if (eli4.aGH != 20000) {
                    os3.eli(eli4.aGH);
                    if (!dV.aGH().Ue() && eli4.aGH == 40029) {
                        eliVar2.eli(-100, wC.eli(-100));
                    } else {
                        eliVar2.eli(eli4.aGH, eli4.ui);
                    }
                    os3.Os(9);
                    com.bytedance.sdk.openadsdk.core.model.Os.eli(os3);
                    com.bytedance.sdk.openadsdk.aGH.eli.MGA.MGA.incrementAndGet();
                    com.bytedance.sdk.openadsdk.aGH.eli.MGA.Os();
                    return;
                }
                if (eli4.wC == null) {
                    os3.Os(13);
                    eli(eliVar2, os3);
                    com.bytedance.sdk.openadsdk.aGH.eli.MGA.ui.incrementAndGet();
                    com.bytedance.sdk.openadsdk.aGH.eli.MGA.Os();
                    return;
                }
                if (eli(eli4.wC, eliVar2)) {
                    return;
                }
                eli4.wC.Os(aGH);
                eU DbA3 = eU.DbA();
                if (ujqVar != null && ujqVar.du != null) {
                    ujqVar.du.eli(eUVar, DbA2, eli4.eli, DbA3);
                }
                if (com.bytedance.sdk.openadsdk.bf.eli.aGH()) {
                    i2 = i;
                    if (i2 == 1) {
                        objArr = true;
                        if (objArr != false) {
                            try {
                                if (eli4.wC.aGH() != null && !eli4.wC.aGH().isEmpty()) {
                                    com.bytedance.sdk.openadsdk.core.model.ev evVar = eli4.wC.aGH().get(0);
                                    String Os = dZ.Os(i2);
                                    JSONObject jSONObject2 = new JSONObject();
                                    JSONObject jSONObject3 = new JSONObject();
                                    long j = 0;
                                    if (ujqVar != null) {
                                        try {
                                            eUVar2 = DbA2;
                                            try {
                                                if (ujqVar.aAs.eli > 0) {
                                                    j = DbA3.eli(ujqVar.aAs);
                                                }
                                            } catch (Exception unused) {
                                                DbA2 = eUVar2;
                                            }
                                        } catch (Exception unused2) {
                                        }
                                    } else {
                                        eUVar2 = DbA2;
                                    }
                                    if (evVar != null) {
                                        boolean qWy = evVar.qWy();
                                        jSONObject3.put("is_new_engine", qWy ? 1 : 0);
                                        jSONObject3.put("webview_cache_size", qWy ? com.bytedance.sdk.component.adexpress.ui.ui.eli().aGH() : com.bytedance.sdk.component.adexpress.ui.ui.eli().Os());
                                    }
                                    DbA2 = eUVar2;
                                    long j2 = j;
                                    eli(dbA.kb(), ujqVar, eUVar, DbA2, eli4.eli, DbA3, evVar, Os, jSONObject3, true);
                                    jSONObject2.put("duration", j2);
                                    jSONObject2.put("extra_data", jSONObject3);
                                    jSONObject2.put("tag", Os);
                                    jSONObject2.put("callback_start", DbA3.eli());
                                    eli4.wC.eli(jSONObject2);
                                }
                            } catch (Throwable th) {
                                th = th;
                                os3 = os2;
                                eliVar2 = eliVar;
                                com.bytedance.sdk.component.utils.Xb.eli("NetApiImpl", "get ad error: ", th);
                                os3.DbA(th.getMessage());
                                os3.Os(14);
                                eli(eliVar2, os3);
                                com.bytedance.sdk.openadsdk.aGH.eli.MGA.ui.incrementAndGet();
                                com.bytedance.sdk.openadsdk.aGH.eli.MGA.Os();
                                com.bytedance.sdk.openadsdk.Dfc.eli.ui.eli("get_ad", os.aGH(), -9, th.getMessage());
                                ApmHelper.reportCustomError("", "parse_error", th);
                                return;
                            }
                        }
                        com.bytedance.sdk.openadsdk.core.du.Os.aGH.eli(eli4.wC);
                        eliVar.eli(eli4.wC, os2);
                        DbA(eli4.wC);
                        com.bytedance.sdk.openadsdk.core.aGH.eli.eli().eli(eli4.wC);
                        eli2 = com.bytedance.sdk.openadsdk.core.model.eli.eli(eli4.wC);
                        if (eli2 != null) {
                            com.bytedance.sdk.openadsdk.kb.DbA.eli().eli(eli2);
                        }
                        if (eli4.wC.aGH() != null && !eli4.wC.aGH().isEmpty()) {
                            if (objArr == false) {
                                eli(dbA.kb(), ujqVar, eUVar, DbA2, eli4.eli, DbA3, eli4.wC.aGH().get(0), dZ.Os(i));
                            }
                            com.bytedance.sdk.openadsdk.aGH.eli.MGA.aGH.incrementAndGet();
                        }
                        com.bytedance.sdk.openadsdk.aGH.eli.MGA.Os();
                    }
                } else {
                    i2 = i;
                }
                objArr = false;
                if (objArr != false) {
                }
                com.bytedance.sdk.openadsdk.core.du.Os.aGH.eli(eli4.wC);
                eliVar.eli(eli4.wC, os2);
                DbA(eli4.wC);
                com.bytedance.sdk.openadsdk.core.aGH.eli.eli().eli(eli4.wC);
                eli2 = com.bytedance.sdk.openadsdk.core.model.eli.eli(eli4.wC);
                if (eli2 != null) {
                }
                if (eli4.wC.aGH() != null) {
                    if (objArr == false) {
                    }
                    com.bytedance.sdk.openadsdk.aGH.eli.MGA.aGH.incrementAndGet();
                }
                com.bytedance.sdk.openadsdk.aGH.eli.MGA.Os();
            } catch (Throwable th2) {
                th = th2;
            }
        } else {
            com.bytedance.sdk.openadsdk.dV.Os.Os(new com.bytedance.sdk.openadsdk.dV.aGH() { // from class: com.bytedance.sdk.openadsdk.core.ev.12
                @Override // com.bytedance.sdk.openadsdk.dV.aGH
                public com.bytedance.sdk.openadsdk.dV.DbA.eli generatorModel() {
                    com.bytedance.sdk.openadsdk.dV.DbA.eli eliVar3 = new com.bytedance.sdk.openadsdk.dV.DbA.eli();
                    eliVar3.DbA("get_ad");
                    eliVar3.Os(adSlot.getCodeId());
                    eliVar3.aGH(dZ.Os(adSlot.getDurationSlotType()));
                    eliVar3.eli(BuildConfig.VERSION_NAME);
                    return eliVar3;
                }
            });
            int eli5 = dbA.eli();
            String DbA4 = dbA.DbA();
            eliVar2.eli(eli5, DbA4);
            os3.eli(eli5);
            os3.Os(11);
            os3.DbA(DbA4);
            com.bytedance.sdk.openadsdk.core.model.Os.eli(os3);
            com.bytedance.sdk.openadsdk.aGH.eli.MGA.wC.incrementAndGet();
            com.bytedance.sdk.openadsdk.aGH.eli.MGA.Os.incrementAndGet();
            com.bytedance.sdk.openadsdk.aGH.eli.MGA.eli.incrementAndGet();
            com.bytedance.sdk.openadsdk.aGH.eli.MGA.ui();
            com.bytedance.sdk.openadsdk.aGH.eli.MGA.eli(eli5, DbA4);
            com.bytedance.sdk.openadsdk.aGH.eli.MGA.Os();
            com.bytedance.sdk.openadsdk.Dfc.eli.ui.eli("get_ad", os.aGH(), eli5, DbA4);
        }
    }

    private boolean eli(com.bytedance.sdk.openadsdk.core.model.eli eliVar, CMM.eli eliVar2) {
        if (eliVar == null) {
            eliVar2.eli(40053, wC.eli(40053));
            return true;
        }
        List<com.bytedance.sdk.openadsdk.core.model.ev> aGH = eliVar.aGH();
        if (aGH.isEmpty()) {
            return false;
        }
        for (final com.bytedance.sdk.openadsdk.core.model.ev evVar : aGH) {
            if (TextUtils.isEmpty(evVar.EM().DbA()) || TextUtils.isEmpty(evVar.EM().Os())) {
                eliVar2.eli(40053, wC.eli(40053));
                com.bytedance.sdk.openadsdk.aGH.Os.eli(System.currentTimeMillis(), evVar, dZ.eli(evVar), "material_error", new com.bytedance.sdk.openadsdk.Dfc.Os.eli() { // from class: com.bytedance.sdk.openadsdk.core.ev.13
                    @Override // com.bytedance.sdk.openadsdk.Dfc.Os.eli
                    public JSONObject eli() {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            JSONObject jSONObject2 = new JSONObject();
                            JSONObject jSONObject3 = new JSONObject();
                            jSONObject3.put("ad_label", evVar.EM().MGA());
                            jSONObject2.put("pag_json_data", jSONObject3.toString());
                            jSONObject.putOpt("ad_extra_data", jSONObject2.toString());
                            return jSONObject;
                        } catch (Exception e) {
                            e.getMessage();
                            return jSONObject;
                        }
                    }
                });
                return true;
            }
        }
        return false;
    }

    private void DbA(com.bytedance.sdk.openadsdk.core.model.eli eliVar) {
        List<com.bytedance.sdk.openadsdk.core.model.ev> aGH = eliVar.aGH();
        if (aGH == null || aGH.size() == 0) {
            return;
        }
        for (int i = 0; i < aGH.size(); i++) {
            com.bytedance.sdk.openadsdk.core.model.ev evVar = aGH.get(i);
            if (evVar != null && evVar.tGZ() == null) {
                eli("", 0, 0, evVar.SjY(), evVar);
                eli("", 0, 0, evVar.TiA(), evVar);
                List<com.bytedance.sdk.openadsdk.core.model.nGm> an = evVar.an();
                if (an != null && an.size() > 0) {
                    for (int i2 = 0; i2 < an.size(); i2++) {
                        eli(evVar, an.get(i2));
                    }
                }
                if (evVar.nY() != null) {
                    eli(evVar.nY().aAs(), evVar.nY().Os(), evVar.nY().DbA(), (com.bytedance.sdk.openadsdk.core.model.nGm) null, evVar);
                }
            }
        }
    }

    private void eli(String str, int i, int i2, com.bytedance.sdk.openadsdk.core.model.nGm ngm, com.bytedance.sdk.openadsdk.core.model.ev evVar) {
        if (!TextUtils.isEmpty(str)) {
            com.bytedance.sdk.openadsdk.FC.aGH.eli(str).eli(i).DbA(i2).ui(SSo.ui(dV.eli())).aGH(SSo.Os(dV.eli())).Os(1).eli(new com.bytedance.sdk.openadsdk.FC.DbA(evVar, str, null), 4);
        } else {
            if (ngm == null) {
                return;
            }
            com.bytedance.sdk.openadsdk.FC.aGH.eli(ngm).Os(1).eli(new com.bytedance.sdk.openadsdk.FC.DbA(evVar, ngm.eli(), null), 4);
        }
    }

    private void eli(com.bytedance.sdk.openadsdk.core.model.ev evVar, com.bytedance.sdk.openadsdk.core.model.nGm ngm) {
        if (ngm == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.FC.aGH.eli(ngm).Os(1).eli(new com.bytedance.sdk.openadsdk.FC.DbA(evVar, ngm.eli(), new com.bytedance.sdk.component.ui.aqO() { // from class: com.bytedance.sdk.openadsdk.core.ev.14
            @Override // com.bytedance.sdk.component.ui.aqO
            public void eli(int i, String str, Throwable th) {
            }

            @Override // com.bytedance.sdk.component.ui.aqO
            public void eli(com.bytedance.sdk.component.ui.du duVar) {
            }
        }), 4);
    }

    private void eli(com.bytedance.sdk.component.DbA.eli.aAs aas, com.bytedance.sdk.openadsdk.core.model.ujq ujqVar, eU eUVar, eU eUVar2, int i, eU eUVar3, com.bytedance.sdk.openadsdk.core.model.ev evVar, String str) {
        eU eUVar4;
        if (dV.aGH().tGZ()) {
            JSONObject jSONObject = new JSONObject();
            long j = 0;
            if (ujqVar != null) {
                try {
                    if (ujqVar.aAs.eli > 0) {
                        eUVar4 = eUVar3;
                        j = eUVar4.eli(ujqVar.aAs);
                        eli(aas, ujqVar, eUVar, eUVar2, i, eUVar4, evVar, str, jSONObject, false);
                        com.bytedance.sdk.openadsdk.aGH.Os.eli(evVar, str, "load_ad_time", j, jSONObject);
                    }
                } catch (Exception unused) {
                    return;
                }
            }
            eUVar4 = eUVar3;
            eli(aas, ujqVar, eUVar, eUVar2, i, eUVar4, evVar, str, jSONObject, false);
            com.bytedance.sdk.openadsdk.aGH.Os.eli(evVar, str, "load_ad_time", j, jSONObject);
        }
    }

    private static void eli(com.bytedance.sdk.component.DbA.eli.aAs aas, com.bytedance.sdk.openadsdk.core.model.ujq ujqVar, eU eUVar, eU eUVar2, int i, eU eUVar3, com.bytedance.sdk.openadsdk.core.model.ev evVar, String str, JSONObject jSONObject, boolean z) throws JSONException {
        if (ujqVar != null && ujqVar.aAs.eli > 0) {
            jSONObject.put("client_start_time", eUVar.eli(ujqVar.aAs));
        }
        jSONObject.put("network_time", eUVar2.eli(eUVar));
        jSONObject.put("sever_time", i);
        jSONObject.put("client_end_time", eUVar3.eli(eUVar2));
        if (str.equals("open_ad")) {
            jSONObject.put("is_icon_only", evVar.gG() ? 1 : 0);
        }
        if (evVar != null) {
            jSONObject.put("render_control_type", evVar.BDs());
        }
        jSONObject.put("webview_cache_size", com.bytedance.sdk.component.adexpress.ui.ui.eli().Os());
        jSONObject.put("sync_barrier_open", z ? 1 : 0);
        if (aas.DbA > 0) {
            jSONObject.put("enqueue_2_run_ts", aas.Os - aas.DbA);
            jSONObject.put("run_2_connect_end_ts", aas.ui - aas.DbA);
            jSONObject.put("connect_end_2_response_end_ts", aas.MGA - aas.ui);
            jSONObject.put("response_end_2_callback_end_ts", SystemClock.elapsedRealtime() - aas.MGA);
        }
    }

    private boolean Os(JSONObject jSONObject) {
        return jSONObject != null && jSONObject.length() > 0;
    }

    @Override // com.bytedance.sdk.openadsdk.core.CMM
    @DungeonFlag
    public com.bytedance.sdk.openadsdk.aGH.ui eli(JSONObject jSONObject, String str, boolean z) {
        try {
            long currentTimeMillis = System.currentTimeMillis();
            byte[] bArr = null;
            if (!com.bytedance.sdk.openadsdk.core.settings.FC.eli()) {
                return null;
            }
            com.bytedance.sdk.component.kb.DbA.aGH DbA2 = com.bytedance.sdk.openadsdk.nGm.DbA.DbA().Os().DbA();
            DbA2.DbA(str);
            if (com.bytedance.sdk.openadsdk.core.settings.NU.nY().gHb()) {
                DbA2.DbA("_disable_retry", "1");
            }
            boolean z2 = true;
            if (z) {
                boolean eli2 = com.bytedance.sdk.openadsdk.core.settings.NU.nY().eli(PangleEncryptConstant.CryptDataScene.APP_LOG);
                byte[] ui = ui(jSONObject.toString());
                if (eli2) {
                    Pair<Integer, byte[]> encryptType4WithoutBase64 = PangleEncryptManager.encryptType4WithoutBase64(ui);
                    if (encryptType4WithoutBase64 != null && encryptType4WithoutBase64.second != null && ((byte[]) encryptType4WithoutBase64.second).length > 0) {
                        bArr = (byte[]) encryptType4WithoutBase64.second;
                        gG.DbA(true);
                    } else {
                        int intValue = encryptType4WithoutBase64 != null ? ((Integer) encryptType4WithoutBase64.first).intValue() : 0;
                        gG.DbA(false);
                        gG.eli(1, PangleEncryptConstant.CryptDataScene.APP_LOG, intValue);
                    }
                }
                if (bArr != null) {
                    DbA2.DbA(HttpHeaders.CONTENT_ENCODING, "union_sdk_encode");
                    DbA2.DbA("x-pgli18n", "4");
                    DbA2.eli("application/octet-stream;tt-data=a", bArr);
                } else {
                    bArr = PangleEncryptManager.encryptV3(ui);
                    if (bArr != null) {
                        eli(DbA(), DbA2);
                        DbA2.eli("application/octet-stream;tt-data=a", bArr);
                    }
                }
            }
            if (bArr == null) {
                try {
                    JSONObject eli3 = com.bytedance.sdk.component.utils.eli.eli(jSONObject);
                    if (!Os(eli3)) {
                        eli3 = jSONObject;
                    }
                    eli(aGH(eli3), DbA2);
                    DbA2.eli(eli3.toString(), dV.aGH().Dfc());
                } catch (OutOfMemoryError e) {
                    com.bytedance.sdk.component.utils.Xb.Os("NetApiImpl", e.toString());
                    return new com.bytedance.sdk.openadsdk.aGH.ui(false, -2, "encrypt_error", false);
                }
            }
            com.bytedance.sdk.component.kb.DbA eli4 = DbA2.eli();
            boolean ui2 = (eli4 == null || !eli4.MGA() || TextUtils.isEmpty(eli4.aGH())) ? false : ui(new JSONObject(eli4.aGH()));
            String str2 = "error unknown";
            int eli5 = eli4 != null ? eli4.eli() : 0;
            if (!ui2 && eli5 == 200) {
                str2 = "server say not success";
            } else {
                if (eli4 != null && eli4.DbA() != null) {
                    str2 = eli4.DbA();
                }
                z2 = false;
            }
            if (eli4 == null) {
                com.bytedance.sdk.openadsdk.Dfc.eli.ui.eli("applog", str, -1, "response is null");
            } else if (!eli4.MGA()) {
                com.bytedance.sdk.openadsdk.Dfc.eli.ui.eli("applog", str, eli5, eli4.DbA());
            }
            eli(jSONObject, z);
            com.bytedance.sdk.openadsdk.aGH.eli.eli.eli(com.bytedance.sdk.openadsdk.aGH.eli.eli.eli, ui2, eli5, System.currentTimeMillis() - currentTimeMillis);
            return new com.bytedance.sdk.openadsdk.aGH.ui(ui2, eli5, str2, z2);
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.Xb.eli("NetApiImpl", "uploadEvent error", th);
            return new com.bytedance.sdk.openadsdk.aGH.ui(false, 509, "service_busy", false);
        }
    }

    private void eli(Map<String, String> map, com.bytedance.sdk.component.kb.DbA.aGH agh) {
        if (map != null) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                try {
                    agh.DbA(entry.getKey(), entry.getValue());
                } catch (Exception e) {
                    com.bytedance.sdk.component.utils.Xb.Os("NetApiImpl", "ADD header exceptopn", e.getMessage());
                }
            }
        }
        try {
            agh.DbA("User-Agent", dZ.aGH());
        } catch (Exception e2) {
            com.bytedance.sdk.component.utils.Xb.Os("NetApiImpl", "ADD header exceptopn", e2.getMessage());
        }
    }

    private void eli(JSONObject jSONObject, boolean z) {
        if (FC.DbA().nGm()) {
            try {
                jSONObject.getJSONObject("header").put(C3114ha.b, "4562");
            } catch (Exception e) {
                com.bytedance.sdk.component.utils.Xb.Os("NetApiImpl", "reportETEvent error", e.getMessage());
            }
            com.bytedance.sdk.component.kb.DbA.aGH DbA2 = com.bytedance.sdk.openadsdk.nGm.DbA.DbA().Os().DbA();
            DbA2.DbA(dZ.bf());
            byte[] bArr = null;
            if (z) {
                boolean eli2 = com.bytedance.sdk.openadsdk.core.settings.NU.nY().eli(PangleEncryptConstant.CryptDataScene.APP_LOG);
                byte[] ui = ui(jSONObject.toString());
                if (eli2) {
                    Pair<Integer, byte[]> encryptType4WithoutBase64 = PangleEncryptManager.encryptType4WithoutBase64(ui);
                    if (encryptType4WithoutBase64 != null && encryptType4WithoutBase64.second != null && ((byte[]) encryptType4WithoutBase64.second).length > 0) {
                        byte[] bArr2 = (byte[]) encryptType4WithoutBase64.second;
                        gG.DbA(true);
                        bArr = bArr2;
                    } else {
                        int intValue = encryptType4WithoutBase64 != null ? ((Integer) encryptType4WithoutBase64.first).intValue() : 0;
                        gG.DbA(false);
                        gG.eli(1, PangleEncryptConstant.CryptDataScene.APP_LOG, intValue);
                    }
                }
                if (bArr != null) {
                    DbA2.DbA(HttpHeaders.CONTENT_ENCODING, "union_sdk_encode");
                    DbA2.DbA("x-pgli18n", "4");
                    DbA2.eli("application/octet-stream;tt-data=a", bArr);
                } else {
                    bArr = PangleEncryptManager.encryptV3(ui);
                    if (bArr != null) {
                        eli(DbA(), DbA2);
                        DbA2.eli("application/octet-stream;tt-data=a", bArr);
                    }
                }
            }
            if (bArr == null) {
                JSONObject eli3 = com.bytedance.sdk.component.utils.eli.eli(jSONObject);
                if (Os(eli3)) {
                    jSONObject = eli3;
                }
                eli(aGH(jSONObject), DbA2);
                DbA2.eli(jSONObject.toString(), dV.aGH().Dfc());
            }
            DbA2.eli(7);
            DbA2.eli("et_applog");
            DbA2.eli(new com.bytedance.sdk.component.kb.eli.eli() { // from class: com.bytedance.sdk.openadsdk.core.ev.15
                @Override // com.bytedance.sdk.component.kb.eli.eli
                public void eli(com.bytedance.sdk.component.kb.DbA.Os os, com.bytedance.sdk.component.kb.DbA dbA) {
                    if (dbA == null || !dbA.MGA()) {
                        return;
                    }
                    new Object[]{"onResponse: ", dbA.aGH()};
                }

                @Override // com.bytedance.sdk.component.kb.eli.eli
                public void eli(com.bytedance.sdk.component.kb.DbA.Os os, IOException iOException) {
                    new Object[]{"onFailure: ", iOException.getMessage()};
                }
            });
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.CMM
    public void eli(String str, List<FilterWord> list, JSONObject jSONObject, String str2, String str3) {
        JSONObject DbA2;
        if (com.bytedance.sdk.openadsdk.core.settings.FC.eli() && (DbA2 = DbA(str, list, jSONObject, str2, str3)) != null) {
            com.bytedance.sdk.component.kb.DbA.aGH DbA3 = com.bytedance.sdk.openadsdk.nGm.DbA.DbA().Os().DbA();
            final String aGH = dZ.aGH("/api/ad/union/dislike_event/");
            JSONObject eli2 = eli(PangleEncryptConstant.CryptDataScene.DISLIKE, DbA2);
            String jSONObject2 = eli2 != null ? eli2.toString() : null;
            eli(DbA3, eli2);
            DbA3.DbA(aGH);
            DbA3.aGH(jSONObject2);
            DbA3.eli(7);
            DbA3.eli("dislike");
            com.bytedance.sdk.openadsdk.dV.Os.eli(new com.bytedance.sdk.openadsdk.dV.aGH() { // from class: com.bytedance.sdk.openadsdk.core.ev.2
                @Override // com.bytedance.sdk.openadsdk.dV.aGH
                public com.bytedance.sdk.openadsdk.dV.DbA.eli generatorModel() {
                    com.bytedance.sdk.openadsdk.dV.DbA.eli eliVar = new com.bytedance.sdk.openadsdk.dV.DbA.eli();
                    eliVar.DbA("dislike");
                    return eliVar;
                }
            });
            DbA3.eli(new com.bytedance.sdk.component.kb.eli.eli() { // from class: com.bytedance.sdk.openadsdk.core.ev.3
                @Override // com.bytedance.sdk.component.kb.eli.eli
                public void eli(com.bytedance.sdk.component.kb.DbA.Os os, com.bytedance.sdk.component.kb.DbA dbA) {
                    if (dbA == null) {
                        com.bytedance.sdk.openadsdk.Dfc.eli.ui.eli("dislike", aGH, -1, "response is null");
                        com.bytedance.sdk.openadsdk.dV.Os.Os(new com.bytedance.sdk.openadsdk.dV.aGH() { // from class: com.bytedance.sdk.openadsdk.core.ev.3.3
                            @Override // com.bytedance.sdk.openadsdk.dV.aGH
                            public com.bytedance.sdk.openadsdk.dV.DbA.eli generatorModel() {
                                com.bytedance.sdk.openadsdk.dV.DbA.eli eliVar = new com.bytedance.sdk.openadsdk.dV.DbA.eli();
                                eliVar.DbA("dislike");
                                return eliVar;
                            }
                        });
                    } else if (dbA.MGA()) {
                        com.bytedance.sdk.openadsdk.dV.Os.DbA(new com.bytedance.sdk.openadsdk.dV.aGH() { // from class: com.bytedance.sdk.openadsdk.core.ev.3.1
                            @Override // com.bytedance.sdk.openadsdk.dV.aGH
                            public com.bytedance.sdk.openadsdk.dV.DbA.eli generatorModel() {
                                com.bytedance.sdk.openadsdk.dV.DbA.eli eliVar = new com.bytedance.sdk.openadsdk.dV.DbA.eli();
                                eliVar.DbA("dislike");
                                return eliVar;
                            }
                        });
                    } else {
                        com.bytedance.sdk.openadsdk.dV.Os.Os(new com.bytedance.sdk.openadsdk.dV.aGH() { // from class: com.bytedance.sdk.openadsdk.core.ev.3.2
                            @Override // com.bytedance.sdk.openadsdk.dV.aGH
                            public com.bytedance.sdk.openadsdk.dV.DbA.eli generatorModel() {
                                com.bytedance.sdk.openadsdk.dV.DbA.eli eliVar = new com.bytedance.sdk.openadsdk.dV.DbA.eli();
                                eliVar.DbA("dislike");
                                return eliVar;
                            }
                        });
                        com.bytedance.sdk.openadsdk.Dfc.eli.ui.eli("dislike", aGH, dbA.eli(), dbA.DbA());
                    }
                }

                @Override // com.bytedance.sdk.component.kb.eli.eli
                public void eli(com.bytedance.sdk.component.kb.DbA.Os os, IOException iOException) {
                    com.bytedance.sdk.openadsdk.Dfc.eli.ui.eli("dislike", aGH, -1, iOException != null ? iOException.getMessage() : "null");
                    if (os != null) {
                        com.bytedance.sdk.openadsdk.utils.bf.eli(os.aGH());
                    }
                    com.bytedance.sdk.openadsdk.dV.Os.Os(new com.bytedance.sdk.openadsdk.dV.aGH() { // from class: com.bytedance.sdk.openadsdk.core.ev.3.4
                        @Override // com.bytedance.sdk.openadsdk.dV.aGH
                        public com.bytedance.sdk.openadsdk.dV.DbA.eli generatorModel() {
                            com.bytedance.sdk.openadsdk.dV.DbA.eli eliVar = new com.bytedance.sdk.openadsdk.dV.DbA.eli();
                            eliVar.DbA("dislike");
                            return eliVar;
                        }
                    });
                }
            });
            try {
                String optString = new JSONObject(str).optString("cid", "");
                if (TextUtils.isEmpty(optString)) {
                    return;
                }
                com.bytedance.sdk.openadsdk.MGA.DbA.eli().eli("dislike", optString, (String) null, (String) null);
            } catch (JSONException e) {
                com.bytedance.sdk.component.utils.Xb.Os(e.getMessage(), new Object[0]);
            }
        }
    }

    private static JSONObject eli(PangleEncryptConstant.CryptDataScene cryptDataScene, JSONObject jSONObject) {
        if (com.bytedance.sdk.openadsdk.core.settings.NU.nY().eli(cryptDataScene)) {
            JSONObject encryptType4 = PangleEncryptManager.encryptType4(jSONObject, new Vy(cryptDataScene));
            gG.eli(encryptType4);
            return encryptType4;
        }
        return com.bytedance.sdk.component.utils.eli.eli(jSONObject);
    }

    @DungeonFlag
    private JSONObject DbA(String str, List<FilterWord> list, JSONObject jSONObject, String str2, String str3) {
        JSONObject jSONObject2 = new JSONObject();
        try {
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("timestamp", System.currentTimeMillis());
            jSONObject3.put("ad_sdk_version", BuildConfig.VERSION_NAME);
            JSONObject jSONObject4 = new JSONObject(str);
            jSONObject4.put("gaid", com.bytedance.sdk.openadsdk.QX.eli.DbA.eli.eli().DbA());
            jSONObject3.put("extra", jSONObject4.toString());
            jSONObject3.put("filter_words", eli(list));
            jSONObject3.put("dislike_source", str3);
            if (com.bytedance.sdk.openadsdk.core.settings.NU.nY().jh() && jSONObject != null && !TextUtils.isEmpty(str2)) {
                jSONObject3.put("creative_info", com.bytedance.sdk.component.utils.eli.eli(jSONObject).toString());
                jSONObject3.put("feedback_type", 1);
                jSONObject3.put("user_description", str2);
            }
            new Object[]{"dislike_source is：", str3};
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(jSONObject3);
            jSONObject2.put("actions", jSONArray);
        } catch (Exception unused) {
        }
        return jSONObject2;
    }

    private JSONArray eli(List<FilterWord> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        JSONArray jSONArray = new JSONArray();
        Iterator<FilterWord> it = list.iterator();
        while (it.hasNext()) {
            jSONArray.put(it.next().getId());
        }
        return jSONArray;
    }

    private Map<String, String> aGH(JSONObject jSONObject) {
        HashMap hashMap = new HashMap();
        hashMap.put("Content-Type", "application/json; charset=utf-8");
        if (Os(jSONObject)) {
            hashMap.put(HttpHeaders.CONTENT_ENCODING, "union_sdk_encode");
        }
        return hashMap;
    }

    private Map<String, String> DbA() {
        HashMap hashMap = new HashMap();
        hashMap.put("Content-Type", "application/octet-stream;tt-data=a");
        return hashMap;
    }

    private boolean ui(JSONObject jSONObject) {
        if (jSONObject == null) {
            return false;
        }
        try {
            return jSONObject.optString(PglCryptUtils.KEY_MESSAGE).equalsIgnoreCase("success");
        } catch (Throwable unused) {
            return false;
        }
    }

    private void eli(CMM.eli eliVar, com.bytedance.sdk.openadsdk.core.model.Os os) {
        eliVar.eli(-1, wC.eli(-1));
        os.eli(-1);
        com.bytedance.sdk.openadsdk.core.model.Os.eli(os);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eli(CMM.DbA dbA) {
        dbA.eli(-1, wC.eli(-1));
    }

    @DungeonFlag
    private JSONObject Os() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("appid", FC.DbA().aGH());
            jSONObject.put("name", FC.DbA().wC());
            MGA(jSONObject);
            Context eli2 = dV.eli();
            String str = "";
            if (eli2 != null) {
                try {
                    str = eli2.getPackageResourcePath();
                } catch (Throwable th) {
                    com.bytedance.sdk.component.utils.Xb.Os("NetApiImpl", "failed to get the application installation package path. error: " + th.getMessage());
                }
            }
            jSONObject.put("package_install_path", str);
            int i = 0;
            jSONObject.put("is_paid_app", false);
            jSONObject.put("apk_sign", com.bytedance.sdk.openadsdk.common.DbA.kb());
            jSONObject.put("app_running_time", (System.currentTimeMillis() - nn.eli()) / 1000);
            jSONObject.put("fmwname", DeviceUtils.aAs());
            jSONObject.put("is_init", nn.ui() ? 1 : 0);
            if (eli2 != null) {
                int rotation = ((WindowManager) eli2.getSystemService("window")).getDefaultDisplay().getRotation();
                if (rotation == 0) {
                    i = 1;
                } else if (rotation == 1) {
                    i = 3;
                } else if (rotation == 2) {
                    i = 2;
                } else if (rotation == 3) {
                    i = 4;
                }
                jSONObject.put("orientation_support", new JSONArray().put(i));
            }
        } catch (JSONException unused) {
        }
        return jSONObject;
    }

    public static JSONObject eli(AdSlot adSlot) {
        ujq ujqVar;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("personalized_ad", dV.aGH().SSo());
            jSONObject.put("lmt", DeviceUtils.Os());
            jSONObject.put(InMobiSdk.IM_GDPR_CONSENT_GDPR_APPLIES, FC.DbA().aAs());
            jSONObject.put("pa_consent", FC.DbA().du());
            jSONObject.put("is_gdpr_user", dV.aGH().cyF());
            if (adSlot != null && ujq.eli.containsKey(Integer.valueOf(adSlot.getCodeId())) && (ujqVar = ujq.eli.get(Integer.valueOf(adSlot.getCodeId()))) != null) {
                jSONObject.put("lastadomain", ujqVar.DbA());
                jSONObject.put("lastbundle", ujqVar.Os());
                jSONObject.put("lastclick", ujqVar.aGH());
                jSONObject.put("lastskip", ujqVar.ui());
            }
            eli(jSONObject, "data", DbA(adSlot));
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    private static String DbA(AdSlot adSlot) {
        String NU = FC.DbA().NU();
        if (adSlot == null) {
            if (TextUtils.isEmpty(NU)) {
                return "";
            }
        } else {
            String userData = adSlot.getUserData();
            if (TextUtils.isEmpty(NU)) {
                return userData;
            }
            if (!TextUtils.isEmpty(userData)) {
                HashSet hashSet = new HashSet();
                try {
                    JSONArray jSONArray = new JSONArray(userData);
                    int length = jSONArray.length();
                    for (int i = 0; i < length; i++) {
                        JSONObject jSONObject = jSONArray.getJSONObject(i);
                        if (jSONObject != null) {
                            hashSet.add(jSONObject.optString("name", null));
                        }
                    }
                    try {
                        JSONArray jSONArray2 = new JSONArray(NU);
                        int length2 = jSONArray2.length();
                        for (int i2 = 0; i2 < length2; i2++) {
                            JSONObject jSONObject2 = jSONArray2.getJSONObject(i2);
                            if (jSONObject2 != null && !hashSet.contains(jSONObject2.optString("name", null))) {
                                jSONArray.put(jSONObject2);
                            }
                        }
                        return jSONArray.toString();
                    } catch (Throwable unused) {
                        return userData;
                    }
                } catch (Throwable unused2) {
                }
            }
        }
        return NU;
    }

    private static void eli(JSONObject jSONObject, String str, String str2) throws JSONException {
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        jSONObject.put(str, str2);
    }

    @DungeonFlag
    private void MGA(JSONObject jSONObject) {
        try {
            jSONObject.put("package_name", dZ.MGA());
            jSONObject.put("version_code", dZ.kb());
            jSONObject.put("version", dZ.wC());
        } catch (Exception unused) {
        }
    }

    private JSONObject eli(AdSlot adSlot, int i, com.bytedance.sdk.openadsdk.core.model.ujq ujqVar) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("id", adSlot.getCodeId());
            jSONObject.put("adtype", i);
            if (!TextUtils.isEmpty(adSlot.getAdId()) || !TextUtils.isEmpty(adSlot.getCreativeId()) || !TextUtils.isEmpty(adSlot.getExt())) {
                JSONObject jSONObject2 = new JSONObject();
                if (!TextUtils.isEmpty(adSlot.getAdId())) {
                    jSONObject2.put("ad_id", adSlot.getAdId());
                }
                if (!TextUtils.isEmpty(adSlot.getCreativeId())) {
                    jSONObject2.put(CampaignEx.JSON_KEY_CREATIVE_ID, adSlot.getCreativeId());
                }
                if (adSlot.getExt() != null) {
                    jSONObject2.put("ext", adSlot.getExt());
                }
                jSONObject.put("preview_ads", jSONObject2);
            }
            if (ujqVar != null) {
                jSONObject.put("render_method", ujqVar.FC);
                if (ujqVar.FC == 1) {
                    eli(jSONObject, "accepted_size", adSlot.getImgAcceptedWidth(), adSlot.getImgAcceptedHeight());
                } else if (ujqVar.FC == 2) {
                    eli(jSONObject, "accepted_size", adSlot.getExpressViewAcceptedWidth(), adSlot.getExpressViewAcceptedHeight());
                }
            } else {
                jSONObject.put("render_method", 1);
                eli(jSONObject, "accepted_size", adSlot.getImgAcceptedWidth(), adSlot.getImgAcceptedHeight());
            }
            jSONObject.put("ptpl_ids", DbA(adSlot.getCodeId()));
            jSONObject.put("ugen_ptpl_ids", Os(adSlot.getCodeId()));
            jSONObject.put("ptpl_ids_v3", Os(adSlot.getCodeId() + "_v3"));
            jSONObject.put("pos", AdSlot.getPosition(i));
            jSONObject.put("is_support_dpl", adSlot.isSupportDeepLink());
            if (i == 1 || i == 5) {
                jSONObject.put("is_origin_ad", true);
            }
            if (ujqVar != null && ujqVar.kb != null) {
                jSONObject.put("session_params", ujqVar.kb);
            }
            if (ujqVar != null && ujqVar.wC != null) {
                jSONObject.put("common_params", ujqVar.wC);
            }
            int adCount = adSlot.getAdCount();
            if (adCount <= 0) {
                adCount = 1;
            }
            if (adCount > 3) {
                adCount = 3;
            }
            if (i == 7 || i == 8) {
                adCount = 1;
            }
            if (ujqVar != null && ujqVar.ui != null) {
                adCount = adSlot.getAdCount();
            }
            jSONObject.put("ad_count", adCount);
            if (i == 1) {
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("is_rotate_banner", adSlot.getIsRotateBanner());
                jSONObject3.put("rotate_time", adSlot.getRotateTime());
                jSONObject3.put("rotate_order", adSlot.getRotateOrder());
                jSONObject3.put("type", adSlot.getBannerType());
                jSONObject.put("banner", jSONObject3);
            }
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    private void eli(JSONObject jSONObject, String str, int i, int i2) {
        if (i <= 0 || i2 <= 0) {
            return;
        }
        JSONObject jSONObject2 = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        try {
            jSONObject2.put("width", i);
            jSONObject2.put("height", i2);
            jSONArray.put(jSONObject2);
            jSONObject.put(str, jSONArray);
        } catch (Exception unused) {
        }
    }

    private void eli(JSONObject jSONObject, String str, float f, float f2) {
        if (f < 0.0f || f2 < 0.0f) {
            return;
        }
        JSONObject jSONObject2 = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        try {
            jSONObject2.put("width", (int) f);
            jSONObject2.put("height", (int) f2);
            jSONArray.put(jSONObject2);
            jSONObject.put(str, jSONArray);
        } catch (Exception unused) {
        }
    }

    public static class eli {
        final long DbA;
        final String FC;
        final int MGA;
        final long Os;
        final ArrayList<Integer> aAs;
        final int aGH;
        final int eli;
        final String kb;
        final String ui;
        public final com.bytedance.sdk.openadsdk.core.model.eli wC;

        private eli(String str, int i, int i2, String str2, int i3, String str3, com.bytedance.sdk.openadsdk.core.model.eli eliVar, long j, long j2, ArrayList<Integer> arrayList) {
            this.eli = i;
            this.aGH = i2;
            this.ui = str2;
            this.kb = str3;
            this.wC = eliVar;
            this.FC = str;
            this.MGA = i3;
            this.DbA = j;
            this.Os = j2;
            this.aAs = arrayList;
        }

        public static eli eli(JSONObject jSONObject, AdSlot adSlot, com.bytedance.sdk.openadsdk.core.model.ujq ujqVar) {
            String optString = jSONObject.optString("did");
            int optInt = jSONObject.optInt("processing_time_ms");
            long optLong = jSONObject.optLong("s_receive_ts");
            long optLong2 = jSONObject.optLong("s_send_ts");
            int optInt2 = jSONObject.optInt("status_code");
            String optString2 = jSONObject.optString(CampaignEx.JSON_KEY_DESC);
            String optString3 = jSONObject.optString("request_id");
            int optInt3 = jSONObject.optInt("reason");
            Pair<com.bytedance.sdk.openadsdk.core.model.eli, ArrayList<Integer>> eli = com.bytedance.sdk.openadsdk.core.DbA.eli(jSONObject, adSlot, ujqVar);
            if (eli == null) {
                return new eli(optString, optInt, optInt2, optString2, optInt3, optString3, null, optLong, optLong2, null);
            }
            return new eli(optString, optInt, optInt2, optString2, optInt3, optString3, (com.bytedance.sdk.openadsdk.core.model.eli) eli.first, optLong, optLong2, (ArrayList) eli.second);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.CMM
    public void eli(JSONObject jSONObject, final CMM.DbA dbA) {
        if (!com.bytedance.sdk.openadsdk.core.settings.FC.eli()) {
            if (dbA != null) {
                dbA.eli(1000, "Ad request is temporarily paused, Please contact your AM");
            }
        } else {
            if (jSONObject == null || dbA == null) {
                return;
            }
            JSONObject eli2 = eli(PangleEncryptConstant.CryptDataScene.REWARD_VERIFY, jSONObject);
            com.bytedance.sdk.component.kb.DbA.aGH DbA2 = com.bytedance.sdk.openadsdk.nGm.DbA.DbA().Os().DbA();
            try {
                DbA2.DbA(com.bytedance.sdk.openadsdk.wC.aGH.eli(DbA2, dZ.aGH("/api/ad/union/sdk/reward_video/reward/")));
            } catch (Exception e) {
                com.bytedance.sdk.component.utils.Xb.Os("NetApiImpl", e.getMessage());
            }
            eli(DbA2, eli2);
            DbA2.aGH(eli2 != null ? eli2.toString() : "");
            DbA2.eli(10);
            DbA2.eli(C3288s.j);
            com.bytedance.sdk.openadsdk.dV.Os.eli(new com.bytedance.sdk.openadsdk.dV.aGH() { // from class: com.bytedance.sdk.openadsdk.core.ev.4
                @Override // com.bytedance.sdk.openadsdk.dV.aGH
                public com.bytedance.sdk.openadsdk.dV.DbA.eli generatorModel() {
                    com.bytedance.sdk.openadsdk.dV.DbA.eli eliVar = new com.bytedance.sdk.openadsdk.dV.DbA.eli();
                    eliVar.DbA(C3288s.j);
                    return eliVar;
                }
            });
            DbA2.eli(new com.bytedance.sdk.component.kb.eli.eli() { // from class: com.bytedance.sdk.openadsdk.core.ev.5
                @Override // com.bytedance.sdk.component.kb.eli.eli
                public void eli(com.bytedance.sdk.component.kb.DbA.Os os, com.bytedance.sdk.component.kb.DbA dbA2) {
                    DbA eli3;
                    if (dbA2 != null) {
                        if (dbA2.MGA() && !TextUtils.isEmpty(dbA2.aGH())) {
                            try {
                                JSONObject jSONObject2 = new JSONObject(dbA2.aGH());
                                String DbA3 = ev.DbA(jSONObject2.optInt("cypher", -1), jSONObject2.optString(PglCryptUtils.KEY_MESSAGE));
                                if (!TextUtils.isEmpty(DbA3)) {
                                    try {
                                        jSONObject2 = new JSONObject(DbA3);
                                    } catch (Throwable unused) {
                                    }
                                }
                                eli3 = DbA.eli(jSONObject2);
                            } catch (JSONException e2) {
                                com.bytedance.sdk.component.utils.Xb.Os("NetApiImpl", e2.getMessage());
                                ev.this.eli(dbA);
                            }
                            if (eli3.eli != 20000) {
                                dbA.eli(eli3.eli, wC.eli(eli3.eli));
                                return;
                            } else if (eli3.Os == null) {
                                ev.this.eli(dbA);
                                return;
                            } else {
                                dbA.eli(eli3);
                                com.bytedance.sdk.openadsdk.dV.Os.DbA(new com.bytedance.sdk.openadsdk.dV.aGH() { // from class: com.bytedance.sdk.openadsdk.core.ev.5.1
                                    @Override // com.bytedance.sdk.openadsdk.dV.aGH
                                    public com.bytedance.sdk.openadsdk.dV.DbA.eli generatorModel() {
                                        com.bytedance.sdk.openadsdk.dV.DbA.eli eliVar = new com.bytedance.sdk.openadsdk.dV.DbA.eli();
                                        eliVar.DbA(C3288s.j);
                                        return eliVar;
                                    }
                                });
                                return;
                            }
                        }
                        String eli4 = wC.eli(-2);
                        int eli5 = dbA2.eli();
                        if (!dbA2.MGA() && !TextUtils.isEmpty(dbA2.DbA())) {
                            eli4 = dbA2.DbA();
                        }
                        dbA.eli(eli5, eli4);
                        com.bytedance.sdk.openadsdk.dV.Os.Os(new com.bytedance.sdk.openadsdk.dV.aGH() { // from class: com.bytedance.sdk.openadsdk.core.ev.5.2
                            @Override // com.bytedance.sdk.openadsdk.dV.aGH
                            public com.bytedance.sdk.openadsdk.dV.DbA.eli generatorModel() {
                                com.bytedance.sdk.openadsdk.dV.DbA.eli eliVar = new com.bytedance.sdk.openadsdk.dV.DbA.eli();
                                eliVar.DbA(C3288s.j);
                                return eliVar;
                            }
                        });
                        if (dbA2.MGA()) {
                            return;
                        }
                        com.bytedance.sdk.openadsdk.Dfc.eli.ui.eli(C3288s.j, os.aGH(), eli5, eli4);
                        return;
                    }
                    com.bytedance.sdk.openadsdk.dV.Os.Os(new com.bytedance.sdk.openadsdk.dV.aGH() { // from class: com.bytedance.sdk.openadsdk.core.ev.5.3
                        @Override // com.bytedance.sdk.openadsdk.dV.aGH
                        public com.bytedance.sdk.openadsdk.dV.DbA.eli generatorModel() {
                            com.bytedance.sdk.openadsdk.dV.DbA.eli eliVar = new com.bytedance.sdk.openadsdk.dV.DbA.eli();
                            eliVar.DbA(C3288s.j);
                            return eliVar;
                        }
                    });
                    com.bytedance.sdk.openadsdk.Dfc.eli.ui.eli(C3288s.j, os.aGH(), -1, "response is null");
                    ev.this.eli(dbA);
                }

                @Override // com.bytedance.sdk.component.kb.eli.eli
                public void eli(com.bytedance.sdk.component.kb.DbA.Os os, IOException iOException) {
                    String str;
                    if (iOException == null) {
                        str = "";
                    } else {
                        str = iOException.getMessage();
                    }
                    dbA.eli(-2, str);
                    if (os != null) {
                        String aGH = os.aGH();
                        com.bytedance.sdk.openadsdk.utils.bf.eli(aGH);
                        com.bytedance.sdk.openadsdk.Dfc.eli.ui.eli(C3288s.j, aGH, -1, str);
                    }
                    com.bytedance.sdk.openadsdk.dV.Os.Os(new com.bytedance.sdk.openadsdk.dV.aGH() { // from class: com.bytedance.sdk.openadsdk.core.ev.5.4
                        @Override // com.bytedance.sdk.openadsdk.dV.aGH
                        public com.bytedance.sdk.openadsdk.dV.DbA.eli generatorModel() {
                            com.bytedance.sdk.openadsdk.dV.DbA.eli eliVar = new com.bytedance.sdk.openadsdk.dV.DbA.eli();
                            eliVar.DbA(C3288s.j);
                            return eliVar;
                        }
                    });
                }
            });
        }
    }

    public static class DbA {
        public final boolean DbA;
        public final com.bytedance.sdk.openadsdk.core.model.qj Os;
        public final int eli;

        private DbA(int i, boolean z, com.bytedance.sdk.openadsdk.core.model.qj qjVar) {
            this.eli = i;
            this.DbA = z;
            this.Os = qjVar;
        }

        public static DbA eli(JSONObject jSONObject) {
            if (jSONObject == null) {
                return null;
            }
            int optInt = jSONObject.optInt("code");
            boolean optBoolean = jSONObject.optBoolean("verify");
            JSONObject optJSONObject = jSONObject.optJSONObject("data");
            com.bytedance.sdk.openadsdk.core.model.qj qjVar = new com.bytedance.sdk.openadsdk.core.model.qj();
            if (optJSONObject != null) {
                try {
                    qjVar.eli(optJSONObject.optInt("reason"));
                    qjVar.DbA(optJSONObject.optInt("corp_type"));
                    qjVar.Os(optJSONObject.optInt("reward_amount"));
                    qjVar.eli(optJSONObject.optString("reward_name"));
                } catch (Throwable th) {
                    com.bytedance.sdk.component.utils.Xb.Os("NetApiImpl", th.getMessage());
                }
            }
            return new DbA(optInt, optBoolean, qjVar);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.CMM
    public JSONObject eli(JSONObject jSONObject) {
        if (jSONObject == null) {
            return jSONObject;
        }
        try {
            int optInt = jSONObject.optInt("cypher", -1);
            String optString = jSONObject.optString(PglCryptUtils.KEY_MESSAGE);
            String optString2 = jSONObject.optString("auction_price", "");
            String DbA2 = DbA(optInt, optString);
            if (TextUtils.isEmpty(DbA2)) {
                return jSONObject;
            }
            JSONObject jSONObject2 = new JSONObject(DbA2);
            try {
                jSONObject2.put("auction_price", optString2);
                return jSONObject2;
            } catch (Throwable unused) {
                return jSONObject2;
            }
        } catch (Throwable unused2) {
            return jSONObject;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String DbA(int i, String str) {
        if (i == 3) {
            return com.bytedance.sdk.component.utils.eli.Os(str);
        }
        if (i == 4) {
            Pair<Integer, String> decryptType4 = PangleEncryptManager.decryptType4(str);
            if (decryptType4 != null && decryptType4.second != null) {
                String str2 = (String) decryptType4.second;
                gG.eli(true);
                return str2;
            }
            gG.eli(false);
            gG.eli(2, PangleEncryptConstant.CryptDataScene.GET_ADS, decryptType4 != null ? ((Integer) decryptType4.first).intValue() : 0);
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.sdk.openadsdk.core.CMM
    public com.bytedance.sdk.openadsdk.aGH.ui DbA(JSONObject jSONObject) {
        int i;
        boolean z;
        boolean z2;
        boolean z3;
        String str = "error unknown";
        long currentTimeMillis = System.currentTimeMillis();
        if (!com.bytedance.sdk.openadsdk.core.settings.FC.eli() || !dV.aGH().vb() || jSONObject == null || jSONObject.length() <= 0) {
            return null;
        }
        com.bytedance.sdk.component.kb.DbA.aGH DbA2 = com.bytedance.sdk.openadsdk.nGm.DbA.DbA().Os().DbA();
        int i2 = 0;
        try {
            JSONObject eli2 = eli(PangleEncryptConstant.CryptDataScene.STATS_LOG, jSONObject);
            DbA2.eli(eli2.toString(), dV.aGH().Dfc());
            DbA2.DbA(dZ.aGH("/api/ad/union/sdk/stats/batch/"));
            eli(DbA2, eli2);
            DbA2.DbA("User-Agent", dZ.aGH());
            if (com.bytedance.sdk.openadsdk.core.settings.NU.nY().Mc()) {
                DbA2.DbA("_disable_retry", "1");
            }
            com.bytedance.sdk.component.kb.DbA eli3 = DbA2.eli();
            try {
            } catch (Throwable unused) {
                i = 0;
                z = false;
            }
            if (eli3 == null) {
                return new com.bytedance.sdk.openadsdk.aGH.ui(false, 0, "error unknown", false);
            }
            if (!eli3.MGA() || TextUtils.isEmpty(eli3.aGH())) {
                z3 = false;
                z = false;
            } else {
                JSONObject jSONObject2 = new JSONObject(eli3.aGH());
                int optInt = jSONObject2.optInt("code", -1);
                str = jSONObject2.optString("data", "");
                z = true;
                boolean z4 = optInt == 20000;
                z3 = z4;
                if (optInt != 60005) {
                    z = false;
                    z3 = z4;
                }
            }
            try {
                i2 = eli3.eli();
                z2 = z3;
                if (!eli3.MGA()) {
                    str = eli3.DbA();
                    com.bytedance.sdk.openadsdk.utils.bf.eli(DbA2.aGH());
                    z2 = z3;
                }
            } catch (Throwable unused2) {
                i = i2;
                i2 = z3 ? 1 : 0;
                z2 = i2;
                i2 = i;
                com.bytedance.sdk.openadsdk.aGH.eli.eli.eli(com.bytedance.sdk.openadsdk.aGH.eli.eli.DbA, z2, i2, System.currentTimeMillis() - currentTimeMillis);
                return new com.bytedance.sdk.openadsdk.aGH.ui(z2, i2, str, z);
            }
            com.bytedance.sdk.openadsdk.aGH.eli.eli.eli(com.bytedance.sdk.openadsdk.aGH.eli.eli.DbA, z2, i2, System.currentTimeMillis() - currentTimeMillis);
            return new com.bytedance.sdk.openadsdk.aGH.ui(z2, i2, str, z);
        } catch (Throwable unused3) {
            com.bytedance.sdk.openadsdk.aGH.eli.eli.eli(com.bytedance.sdk.openadsdk.aGH.eli.eli.DbA, false, 0, System.currentTimeMillis() - currentTimeMillis);
            return new com.bytedance.sdk.openadsdk.aGH.ui(false, 0, "error unknown", false);
        }
    }

    private void eli(com.bytedance.sdk.component.kb.DbA.aGH agh, JSONObject jSONObject) {
        try {
            if (Os(jSONObject) && jSONObject.optInt("cypher") == 4) {
                agh.DbA("x-pgli18n", "4");
                agh.DbA("Content-Type", "application/json; charset=utf-8");
            }
        } catch (Exception unused) {
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.CMM
    public com.bytedance.sdk.component.adexpress.eli.Os.eli eli() {
        com.bytedance.sdk.component.adexpress.eli.Os.eli eliVar = null;
        if (!com.bytedance.sdk.openadsdk.core.settings.FC.eli()) {
            return null;
        }
        long currentTimeMillis = (System.currentTimeMillis() / 1000) - com.bytedance.sdk.openadsdk.multipro.aGH.aGH.eli("tpl_fetch_model", "date", 0L);
        String nro = dV.aGH().nro();
        String DbA2 = com.bytedance.sdk.openadsdk.multipro.aGH.aGH.DbA("tpl_fetch_model", "last_url", "");
        if (currentTimeMillis <= dV.aGH().gG() && currentTimeMillis >= 0 && TextUtils.equals(nro, DbA2)) {
            String DbA3 = com.bytedance.sdk.openadsdk.multipro.aGH.aGH.DbA("tpl_fetch_model", N6.B, "");
            try {
                if (!TextUtils.isEmpty(DbA3)) {
                    return com.bytedance.sdk.component.adexpress.eli.Os.eli.ui(DbA3);
                }
            } catch (Exception unused) {
            }
        }
        try {
            com.bytedance.sdk.component.kb.DbA.DbA Os = com.bytedance.sdk.openadsdk.nGm.DbA.DbA().Os().Os();
            String eli2 = com.bytedance.sdk.openadsdk.wC.aGH.eli(Os, nro);
            Os.DbA(eli2);
            com.bytedance.sdk.component.kb.DbA eli3 = Os.eli();
            if (eli3 == null || !eli3.MGA()) {
                return null;
            }
            JSONObject jSONObject = new JSONObject(eli3.aGH());
            jSONObject.put("template_fetch_url", eli2);
            eliVar = com.bytedance.sdk.component.adexpress.eli.Os.eli.eli(jSONObject);
            com.bytedance.sdk.openadsdk.multipro.aGH.aGH.eli("tpl_fetch_model", "date", Long.valueOf(System.currentTimeMillis() / 1000));
            com.bytedance.sdk.openadsdk.multipro.aGH.aGH.eli("tpl_fetch_model", N6.B, jSONObject.toString());
            com.bytedance.sdk.openadsdk.multipro.aGH.aGH.eli("tpl_fetch_model", "last_url", nro);
            return eliVar;
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.Xb.Os("NetApiImpl", th.getMessage());
            return eliVar;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.CMM
    public void eli(String str) {
        com.bytedance.sdk.component.kb.DbA.DbA Os = com.bytedance.sdk.openadsdk.nGm.DbA.DbA().Os().Os();
        Os.DbA(str);
        Os.eli("upload_bidding");
        Os.eli(7);
        Os.eli(new com.bytedance.sdk.component.kb.eli.eli() { // from class: com.bytedance.sdk.openadsdk.core.ev.6
            @Override // com.bytedance.sdk.component.kb.eli.eli
            public void eli(com.bytedance.sdk.component.kb.DbA.Os os, IOException iOException) {
            }

            @Override // com.bytedance.sdk.component.kb.eli.eli
            public void eli(com.bytedance.sdk.component.kb.DbA.Os os, com.bytedance.sdk.component.kb.DbA dbA) {
                dbA.aGH();
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.core.CMM
    public void eli(JSONObject jSONObject, String str) {
        com.bytedance.sdk.component.kb.DbA.aGH DbA2 = com.bytedance.sdk.openadsdk.nGm.DbA.DbA().Os().DbA();
        DbA2.DbA(str);
        Pair<String, String> generateRequestHeader = ApmHelper.generateRequestHeader();
        DbA2.DbA("cypher", (String) generateRequestHeader.first);
        DbA2.DbA("transfer-param", (String) generateRequestHeader.second);
        DbA2.DbA("x-pangle-target-idc", dV.aGH().Bnk());
        DbA2.eli(jSONObject);
        DbA2.eli(5);
        DbA2.eli("apm_pv");
        DbA2.eli(new com.bytedance.sdk.component.kb.eli.eli() { // from class: com.bytedance.sdk.openadsdk.core.ev.7
            @Override // com.bytedance.sdk.component.kb.eli.eli
            public void eli(com.bytedance.sdk.component.kb.DbA.Os os, IOException iOException) {
            }

            @Override // com.bytedance.sdk.component.kb.eli.eli
            public void eli(com.bytedance.sdk.component.kb.DbA.Os os, com.bytedance.sdk.component.kb.DbA dbA) {
                dbA.aGH();
            }
        });
    }

    public static JSONArray DbA(String str) {
        try {
            Set<String> DbA2 = com.bytedance.sdk.component.adexpress.eli.DbA.DbA.DbA(str);
            if (DbA2 != null && DbA2.size() != 0) {
                JSONArray jSONArray = new JSONArray();
                Iterator<String> it = DbA2.iterator();
                while (it.hasNext()) {
                    com.bytedance.sdk.component.adexpress.eli.Os.DbA eli2 = com.bytedance.sdk.component.adexpress.eli.DbA.DbA.eli(it.next());
                    if (eli2 != null) {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("id", eli2.DbA());
                        jSONObject.put("md5", eli2.Os());
                        jSONArray.put(jSONObject);
                    }
                }
                return jSONArray;
            }
            return null;
        } catch (Exception e) {
            com.bytedance.sdk.component.utils.Xb.eli("NetApiImpl", "getParentTplIds: ", e);
            return null;
        }
    }

    public static JSONArray Os(String str) {
        try {
            Set<com.bytedance.sdk.openadsdk.core.aAs.eli.eli> eli2 = com.bytedance.sdk.openadsdk.core.aAs.eli.DbA.eli().eli(str);
            if (eli2 != null && eli2.size() != 0) {
                JSONArray jSONArray = new JSONArray();
                for (com.bytedance.sdk.openadsdk.core.aAs.eli.eli eliVar : eli2) {
                    if (eliVar != null && !TextUtils.isEmpty(eliVar.ui())) {
                        JSONObject jSONObject = new JSONObject();
                        String[] split = eliVar.eli().split("_");
                        if (split.length == 2) {
                            jSONObject.put("id", split[1]);
                            jSONObject.put("md5", eliVar.DbA());
                            jSONArray.put(jSONObject);
                        }
                    }
                }
                return jSONArray;
            }
            return null;
        } catch (Exception e) {
            com.bytedance.sdk.component.utils.Xb.eli("NetApiImpl", "getUgenParentTplIds: ", e);
            return null;
        }
    }

    private byte[] ui(String str) {
        ByteArrayOutputStream byteArrayOutputStream;
        GZIPOutputStream gZIPOutputStream;
        GZIPOutputStream gZIPOutputStream2 = null;
        if (str == null || str.length() == 0) {
            return null;
        }
        byte[] bArr = new byte[0];
        try {
            try {
                byteArrayOutputStream = new ByteArrayOutputStream();
                try {
                    try {
                        gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
                    } catch (IOException e) {
                        e = e;
                    }
                } catch (Throwable th) {
                    th = th;
                }
            } catch (IOException e2) {
                com.bytedance.sdk.component.utils.Xb.Os("NetApiImpl", e2.toString());
            }
            try {
                gZIPOutputStream.write(str.getBytes(D5.N));
                try {
                    gZIPOutputStream.close();
                } catch (IOException e3) {
                    com.bytedance.sdk.component.utils.Xb.Os("NetApiImpl", e3.toString());
                }
                bArr = byteArrayOutputStream.toByteArray();
                byteArrayOutputStream.close();
            } catch (IOException e4) {
                e = e4;
                gZIPOutputStream2 = gZIPOutputStream;
                com.bytedance.sdk.component.utils.Xb.Os("NetApiImpl", e.toString());
                if (gZIPOutputStream2 != null) {
                    try {
                        gZIPOutputStream2.close();
                    } catch (IOException e5) {
                        com.bytedance.sdk.component.utils.Xb.Os("NetApiImpl", e5.toString());
                    }
                }
                if (byteArrayOutputStream != null) {
                    bArr = byteArrayOutputStream.toByteArray();
                    byteArrayOutputStream.close();
                }
                return bArr;
            } catch (Throwable th2) {
                th = th2;
                gZIPOutputStream2 = gZIPOutputStream;
                if (gZIPOutputStream2 != null) {
                    try {
                        gZIPOutputStream2.close();
                    } catch (IOException e6) {
                        com.bytedance.sdk.component.utils.Xb.Os("NetApiImpl", e6.toString());
                    }
                }
                if (byteArrayOutputStream != null) {
                    byteArrayOutputStream.toByteArray();
                    try {
                        byteArrayOutputStream.close();
                        throw th;
                    } catch (IOException e7) {
                        com.bytedance.sdk.component.utils.Xb.Os("NetApiImpl", e7.toString());
                        throw th;
                    }
                }
                throw th;
            }
        } catch (IOException e8) {
            e = e8;
            byteArrayOutputStream = null;
        } catch (Throwable th3) {
            th = th3;
            byteArrayOutputStream = null;
        }
        return bArr;
    }
}
