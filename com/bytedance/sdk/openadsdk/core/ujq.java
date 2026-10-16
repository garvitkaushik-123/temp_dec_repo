package com.bytedance.sdk.openadsdk.core;

import android.text.TextUtils;
import com.google.firebase.sessions.settings.RemoteSettings;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes3.dex */
public class ujq {
    public static ConcurrentHashMap<Integer, ujq> eli = new ConcurrentHashMap<>();
    private String MGA;
    private int aGH;
    private int ui;
    private String DbA = "";
    private String Os = "";

    public String eli() {
        return this.MGA;
    }

    public String DbA() {
        return this.DbA;
    }

    public String Os() {
        return this.Os;
    }

    public int aGH() {
        return this.aGH;
    }

    public void eli(int i) {
        this.aGH = i;
    }

    public int ui() {
        return this.ui;
    }

    public void DbA(int i) {
        this.ui = i;
    }

    private void MGA() {
        this.DbA = "";
        this.Os = "";
        this.aGH = 0;
        this.ui = 0;
    }

    public void eli(com.bytedance.sdk.openadsdk.core.model.ev evVar) {
        if (evVar != null) {
            String fO = evVar.fO();
            if (!TextUtils.isEmpty(fO)) {
                this.MGA = fO;
            }
            String dM = evVar.dM();
            if (TextUtils.isEmpty(dM) && evVar.Kv()) {
                dM = evVar.io().FC();
            }
            if (!TextUtils.isEmpty(dM)) {
                String[] split = dM.split(RemoteSettings.FORWARD_SLASH_STRING);
                if (split.length >= 3) {
                    this.DbA = split[2];
                }
            }
            if (evVar.pu() == null || TextUtils.isEmpty(evVar.pu().Os())) {
                return;
            }
            this.Os = evVar.pu().Os();
        }
    }

    public static void DbA(com.bytedance.sdk.openadsdk.core.model.ev evVar) {
        if (evVar == null || TextUtils.isEmpty(evVar.eu())) {
            return;
        }
        Integer valueOf = Integer.valueOf(evVar.RTg());
        if (valueOf.intValue() == 0) {
            return;
        }
        if (eli == null) {
            eli = new ConcurrentHashMap<>();
        }
        ujq ujqVar = eli.containsKey(valueOf) ? eli.get(valueOf) : null;
        if (ujqVar == null) {
            ujqVar = new ujq();
        }
        String fO = evVar.fO();
        if (TextUtils.isEmpty(fO) || !fO.equals(ujqVar.eli())) {
            ujqVar.MGA();
            ujqVar.eli(evVar);
            eli.put(valueOf, ujqVar);
        }
    }

    public static void Os(int i) {
        ujq ujqVar;
        if (i == 0) {
            return;
        }
        if (eli == null) {
            eli = new ConcurrentHashMap<>();
        }
        if (!eli.containsKey(Integer.valueOf(i)) || (ujqVar = eli.get(Integer.valueOf(i))) == null) {
            return;
        }
        ujqVar.DbA(1);
    }

    public static void Os(com.bytedance.sdk.openadsdk.core.model.ev evVar) {
        ujq ujqVar;
        if (evVar == null) {
            return;
        }
        Integer valueOf = Integer.valueOf(evVar.RTg());
        if (valueOf.intValue() == 0) {
            return;
        }
        if (eli == null) {
            eli = new ConcurrentHashMap<>();
        }
        if (!eli.containsKey(valueOf) || (ujqVar = eli.get(valueOf)) == null) {
            return;
        }
        ujqVar.eli(1);
    }
}
