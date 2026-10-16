package com.bytedance.sdk.openadsdk.core.FC;

import android.text.TextUtils;
import android.view.MotionEvent;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes3.dex */
public class DbA {
    private static com.bytedance.sdk.openadsdk.core.FC.eli eli;
    private String DbA;

    private DbA() {
        this.DbA = null;
        eli = new com.bytedance.sdk.openadsdk.core.FC.eli();
    }

    public void eli(String str) {
        com.bytedance.sdk.openadsdk.core.FC.eli eliVar;
        if (TextUtils.isEmpty(str) || (eliVar = eli) == null) {
            return;
        }
        eliVar.eli(str);
    }

    public void DbA(String str) {
        com.bytedance.sdk.openadsdk.core.FC.eli eliVar;
        if (TextUtils.isEmpty(str) || (eliVar = eli) == null) {
            return;
        }
        eliVar.DbA(str);
    }

    public void eli(Map<String, Object> map) {
        com.bytedance.sdk.openadsdk.core.FC.eli eliVar = eli;
        if (eliVar != null) {
            eliVar.eli(map);
        }
    }

    public void eli() {
        com.bytedance.sdk.openadsdk.core.FC.eli eliVar = eli;
        if (eliVar != null) {
            eliVar.Os();
        }
    }

    public static DbA DbA() {
        return eli.eli;
    }

    public void eli(String str, Map<String, Object> map) {
        com.bytedance.sdk.openadsdk.core.FC.eli eliVar = eli;
        if (eliVar != null) {
            eliVar.eli(str, map);
        }
    }

    public boolean Os() {
        com.bytedance.sdk.openadsdk.core.FC.eli eliVar = eli;
        if (eliVar == null) {
            return false;
        }
        return eliVar.DbA();
    }

    public String aGH() {
        String aGH;
        com.bytedance.sdk.openadsdk.core.FC.eli eliVar = eli;
        return (eliVar == null || (aGH = eliVar.aGH()) == null) ? "" : aGH;
    }

    public Map<String, String> eli(String str, byte[] bArr) {
        com.bytedance.sdk.openadsdk.core.FC.eli eliVar = eli;
        if (eliVar != null) {
            return eliVar.eli(str, bArr);
        }
        return new HashMap();
    }

    public String ui() {
        com.bytedance.sdk.openadsdk.core.FC.eli eliVar = eli;
        if (eliVar != null) {
            return eliVar.ui();
        }
        return "";
    }

    public long MGA() {
        com.bytedance.sdk.openadsdk.core.FC.eli eliVar = eli;
        if (eliVar != null) {
            return eliVar.MGA();
        }
        return 0L;
    }

    public int kb() {
        com.bytedance.sdk.openadsdk.core.FC.eli eliVar = eli;
        if (eliVar != null) {
            return eliVar.kb();
        }
        return 1;
    }

    public void eli(MotionEvent motionEvent) {
        com.bytedance.sdk.openadsdk.core.FC.eli eliVar = eli;
        if (eliVar != null) {
            eliVar.eli(motionEvent);
        }
    }

    private static class eli {
        private static final DbA eli = new DbA();
    }
}
