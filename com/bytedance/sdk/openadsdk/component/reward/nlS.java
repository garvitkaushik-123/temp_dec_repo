package com.bytedance.sdk.openadsdk.component.reward;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.common.eli;
import com.bytedance.sdk.openadsdk.core.dV;
import com.bytedance.sdk.openadsdk.core.model.KM;
import com.bytedance.sdk.openadsdk.core.model.ev;
import java.io.File;
import java.io.FileFilter;
import java.util.Iterator;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class nlS {
    private static volatile nlS eli;
    private final Context DbA;
    private final eli.C0169eli Os;

    public void eli(String str, ev evVar) {
        if (com.bytedance.sdk.openadsdk.utils.DbA.eli()) {
            com.bytedance.sdk.openadsdk.common.eli.eli("sp_reward_video_new").eli(str, evVar);
            return;
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        String Os = this.Os.Os(str);
        String fO = evVar != null ? evVar.fO() : "";
        if (TextUtils.isEmpty(Os) || TextUtils.isEmpty(fO) || Os.equals(fO)) {
            this.Os.wC(str);
        }
    }

    public void eli() {
        File[] listFiles;
        String str;
        File[] listFiles2;
        if (com.bytedance.sdk.openadsdk.utils.DbA.eli()) {
            com.bytedance.sdk.openadsdk.common.eli.eli("sp_reward_video_new").eli();
            return;
        }
        try {
            boolean kb = com.bytedance.sdk.openadsdk.core.FC.kb("sp_reward_video");
            if (kb) {
                str = "files";
            } else {
                str = "shared_prefs";
            }
            File file = new File(this.DbA.getDataDir(), str);
            if (file.exists() && file.isDirectory() && (listFiles2 = file.listFiles(new FileFilter() { // from class: com.bytedance.sdk.openadsdk.component.reward.nlS.1
                @Override // java.io.FileFilter
                public boolean accept(File file2) {
                    if (file2 != null) {
                        return file2.getName().contains("sp_reward_video");
                    }
                    return false;
                }
            })) != null) {
                for (File file2 : listFiles2) {
                    if (kb) {
                        try {
                            com.bytedance.sdk.component.utils.kb.Os(file2);
                        } catch (Throwable unused) {
                        }
                    } else {
                        this.DbA.deleteSharedPreferences(file2.getName().replace(".xml", ""));
                    }
                }
            }
        } catch (Throwable unused2) {
        }
        try {
            File cacheDir = this.DbA.getCacheDir();
            if (cacheDir == null || !cacheDir.exists() || !cacheDir.isDirectory() || (listFiles = cacheDir.listFiles(new FileFilter() { // from class: com.bytedance.sdk.openadsdk.component.reward.nlS.2
                @Override // java.io.FileFilter
                public boolean accept(File file3) {
                    if (file3 != null) {
                        return file3.getName().contains("reward_video_cache");
                    }
                    return false;
                }
            })) == null) {
                return;
            }
            for (File file3 : listFiles) {
                try {
                    com.bytedance.sdk.component.utils.kb.Os(file3);
                } catch (Throwable unused3) {
                }
            }
        } catch (Throwable unused4) {
        }
    }

    public void eli(AdSlot adSlot, com.bytedance.sdk.openadsdk.core.model.eli eliVar) {
        ev MGA;
        if (eliVar == null || eliVar.MGA() == null || !eliVar.MGA().JF()) {
            if (com.bytedance.sdk.openadsdk.utils.DbA.eli()) {
                com.bytedance.sdk.openadsdk.common.eli.eli("sp_reward_video_new").eli(adSlot, eliVar);
                return;
            }
            if (eliVar == null || eliVar.wC() || adSlot == null || !TextUtils.isEmpty(adSlot.getBidAdm()) || (MGA = eliVar.MGA()) == null || MGA.tmf() == 2) {
                return;
            }
            String DbA = eliVar.DbA();
            synchronized (eliVar) {
                if (!eliVar.wC()) {
                    try {
                        this.Os.eli(adSlot, eliVar.NU().toString(), DbA);
                    } catch (Throwable unused) {
                        eliVar.FC();
                    }
                }
            }
        }
    }

    public static nlS eli(Context context) {
        if (eli == null) {
            synchronized (nlS.class) {
                if (eli == null) {
                    eli = new nlS(context);
                }
            }
        }
        return eli;
    }

    private nlS(Context context) {
        this.DbA = context == null ? dV.eli() : context.getApplicationContext();
        this.Os = new eli.C0169eli("sp_reward_video");
    }

    public String eli(String str, boolean z) {
        com.bytedance.sdk.openadsdk.common.eli eli2 = com.bytedance.sdk.openadsdk.common.eli.eli("sp_reward_video_new");
        String eli3 = eli2.eli(str, 10500000L);
        if (z && !TextUtils.isEmpty(eli3) && ui.DbA() == 2 && eli2.aGH(str)) {
            return null;
        }
        return eli3;
    }

    public boolean eli(com.bytedance.sdk.openadsdk.core.model.eli eliVar) {
        return com.bytedance.sdk.openadsdk.common.eli.eli("sp_reward_video_new").eli(eliVar, true);
    }

    public com.bytedance.sdk.openadsdk.core.model.eli DbA(String str, boolean z) {
        com.bytedance.sdk.openadsdk.core.model.eli eliVar;
        long aGH = this.Os.aGH(str);
        boolean ui = this.Os.ui(str);
        boolean kb = this.Os.kb(str);
        int DbA = ui.DbA();
        if (System.currentTimeMillis() - aGH < 10500000 && !ui && (!z || DbA != 2 || !kb)) {
            try {
                String DbA2 = this.Os.DbA(str);
                if (!TextUtils.isEmpty(DbA2)) {
                    JSONObject jSONObject = new JSONObject(DbA2);
                    if (jSONObject.has("cypher")) {
                        jSONObject = dV.Os().eli(jSONObject);
                    }
                    if (jSONObject.has("creatives")) {
                        eliVar = com.bytedance.sdk.openadsdk.core.model.eli.DbA(jSONObject);
                    } else {
                        ev eli2 = com.bytedance.sdk.openadsdk.core.DbA.eli(jSONObject);
                        com.bytedance.sdk.openadsdk.core.model.eli eliVar2 = new com.bytedance.sdk.openadsdk.core.model.eli();
                        eliVar2.eli(eli2);
                        eliVar = eliVar2;
                    }
                    if (eliVar != null && eliVar.ui()) {
                        Iterator<ev> it = eliVar.aGH().iterator();
                        while (it.hasNext()) {
                            if (!eli(it.next())) {
                                it.remove();
                            }
                        }
                        if (eliVar.ui() && eliVar.MGA() != null) {
                            if (eliVar.MGA().XU() != null) {
                                return eliVar;
                            }
                        }
                    }
                }
            } catch (Exception unused) {
            }
        }
        return null;
    }

    private boolean eli(ev evVar) {
        if (evVar != null) {
            return KM.Os(evVar) || evVar.nY() != null;
        }
        return false;
    }

    public void eli(String str) {
        if (com.bytedance.sdk.openadsdk.utils.DbA.eli()) {
            com.bytedance.sdk.openadsdk.common.eli.eli("sp_reward_video_new").Os(str);
        } else {
            this.Os.MGA(str);
        }
    }
}
