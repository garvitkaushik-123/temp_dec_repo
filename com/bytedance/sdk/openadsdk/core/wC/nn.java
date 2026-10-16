package com.bytedance.sdk.openadsdk.core.wC;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.CacheDirFactory;
import com.bytedance.sdk.openadsdk.core.model.oWW;
import com.bytedance.sdk.openadsdk.utils.cyF;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import org.json.JSONArray;

/* loaded from: classes3.dex */
public class nn {
    public static void eli(final com.bytedance.sdk.openadsdk.core.model.ev evVar) {
        cyF.DbA(new com.bytedance.sdk.component.wC.wC("preloadStaticRes") { // from class: com.bytedance.sdk.openadsdk.core.wC.nn.1
            @Override // java.lang.Runnable
            public void run() {
                oWW hg;
                oWW.eli MGA;
                com.bytedance.sdk.openadsdk.core.model.ev evVar2 = evVar;
                if (evVar2 == null || (hg = evVar2.hg()) == null || (MGA = hg.MGA()) == null) {
                    return;
                }
                String GMY = com.bytedance.sdk.openadsdk.core.settings.NU.nY().GMY();
                nn.eli(evVar, MGA.eli(), GMY);
                nn.Os(MGA.DbA(), GMY);
                nn.aGH(MGA.Os(), GMY);
            }
        });
    }

    public static void eli(com.bytedance.sdk.openadsdk.core.model.ev evVar, JSONArray jSONArray, String str) {
        if (jSONArray == null || jSONArray.length() <= 0) {
            return;
        }
        for (int i = 0; i < jSONArray.length(); i++) {
            String optString = jSONArray.optString(i);
            if (!TextUtils.isEmpty(optString)) {
                String eli = com.bytedance.sdk.openadsdk.core.aAs.Os.eli(optString, str);
                String eli2 = com.bytedance.sdk.component.utils.ui.eli(eli);
                InputStream eli3 = com.bytedance.sdk.openadsdk.FC.aGH.eli(eli, eli2);
                if (eli3 != null) {
                    try {
                        eli3.close();
                    } catch (IOException unused) {
                    }
                } else {
                    com.bytedance.sdk.openadsdk.FC.aGH.eli(eli).Os(1).eli(eli2).eli(new com.bytedance.sdk.openadsdk.FC.DbA(evVar, eli, new com.bytedance.sdk.component.ui.aqO() { // from class: com.bytedance.sdk.openadsdk.core.wC.nn.2
                        @Override // com.bytedance.sdk.component.ui.aqO
                        public void eli(int i2, String str2, Throwable th) {
                        }

                        @Override // com.bytedance.sdk.component.ui.aqO
                        public void eli(com.bytedance.sdk.component.ui.du duVar) {
                            duVar.eli();
                        }
                    }), 4);
                }
            }
        }
    }

    public static boolean DbA(com.bytedance.sdk.openadsdk.core.model.ev evVar) {
        oWW hg;
        return (evVar == null || (hg = evVar.hg()) == null || hg.MGA() == null) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void Os(JSONArray jSONArray, String str) {
        if (jSONArray == null || jSONArray.length() <= 0) {
            return;
        }
        for (int i = 0; i < jSONArray.length(); i++) {
            String optString = jSONArray.optString(i);
            if (!TextUtils.isEmpty(optString)) {
                String eli = com.bytedance.sdk.openadsdk.core.aAs.Os.eli(optString, str);
                File eli2 = eli(eli);
                if (eli2 != null && eli2.exists() && eli2.length() > 0) {
                    return;
                } else {
                    Os(eli);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void aGH(JSONArray jSONArray, String str) {
        if (jSONArray == null || jSONArray.length() <= 0) {
            return;
        }
        for (int i = 0; i < jSONArray.length(); i++) {
            String optString = jSONArray.optString(i);
            if (!TextUtils.isEmpty(optString)) {
                String eli = com.bytedance.sdk.openadsdk.core.aAs.Os.eli(optString, str);
                File eli2 = eli(eli);
                if (eli2 != null && eli2.exists() && eli2.length() > 0) {
                    return;
                } else {
                    Os(eli);
                }
            }
        }
    }

    private static void Os(String str) {
        File eli = eli(str);
        if (eli == null) {
            return;
        }
        File file = new File(eli + ".tmp");
        com.bytedance.sdk.component.kb.DbA.eli aGH = com.bytedance.sdk.openadsdk.nGm.DbA.DbA().Os().aGH();
        aGH.eli(8);
        aGH.eli("preloadStaticRes");
        aGH.DbA(str);
        aGH.eli(eli.getParent(), eli.getName());
        com.bytedance.sdk.component.kb.DbA eli2 = aGH.eli();
        if (eli2 != null && eli2.MGA() && eli2.ui() != null && eli2.ui().exists()) {
            com.bytedance.sdk.component.utils.Xb.eli("ExpressStaticResPreload", "downloadFile: success url=".concat(String.valueOf(str)));
            return;
        }
        if (eli.exists()) {
            try {
                eli.delete();
            } catch (Throwable th) {
                com.bytedance.sdk.component.utils.Xb.Os("ExpressStaticResPreload", th.getMessage());
            }
        }
        if (file.exists()) {
            try {
                file.delete();
            } catch (Throwable th2) {
                com.bytedance.sdk.component.utils.Xb.Os("ExpressStaticResPreload", th2.getMessage());
            }
        }
    }

    public static File eli(String str) {
        String str2;
        String eli = com.bytedance.sdk.component.utils.ui.eli(str);
        if (eli == null) {
            return null;
        }
        String name = new File(CacheDirFactory.getRootDir()).getName();
        if (com.bytedance.sdk.openadsdk.multipro.DbA.Os()) {
            str2 = name + "/express_static_res/";
        } else {
            str2 = name + "/express_static_res/";
        }
        new Object[]{"cachePath is:", str2, ", fileName is:", eli};
        return com.bytedance.sdk.component.utils.kb.eli(com.bytedance.sdk.openadsdk.core.dV.eli(), com.bytedance.sdk.openadsdk.multipro.DbA.Os(), str2, eli);
    }

    public static InputStream DbA(String str) {
        File eli = eli(str);
        if (eli == null || !eli.exists() || eli.length() <= 0) {
            return null;
        }
        try {
            return new FileInputStream(eli);
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.Xb.Os("ExpressStaticResPreload", th.getMessage());
            return null;
        }
    }
}
