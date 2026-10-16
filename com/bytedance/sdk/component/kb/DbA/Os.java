package com.bytedance.sdk.component.kb.DbA;

import android.text.TextUtils;
import com.bytedance.sdk.component.DbA.eli.du;
import com.bytedance.sdk.component.DbA.eli.nlS;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/* loaded from: classes3.dex */
public abstract class Os {
    int MGA;
    protected du Os;
    String ui;
    protected String aGH = null;
    protected final Map<String, String> kb = new HashMap();
    protected String wC = null;
    protected boolean FC = false;

    public void eli(String str) {
        this.ui = str;
    }

    public void eli(int i) {
        this.MGA = i;
    }

    public Os(du duVar) {
        this.Os = duVar;
        try {
            Os(UUID.randomUUID().toString());
        } catch (Throwable th) {
            th.getMessage();
        }
    }

    public void DbA(String str) {
        this.wC = str;
    }

    public void DbA(String str, String str2) {
        this.kb.put(str, str2);
    }

    public void aGH(Map<String, String> map) {
        if (map != null) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                this.kb.put(entry.getKey(), entry.getValue());
            }
        }
    }

    public void Os(String str) {
        this.aGH = str;
    }

    public String Os() {
        return this.aGH;
    }

    public void DbA() {
        du duVar;
        if (this.aGH == null || (duVar = this.Os) == null) {
            return;
        }
        com.bytedance.sdk.component.DbA.eli.aGH eli = duVar.eli();
        synchronized (eli) {
            for (com.bytedance.sdk.component.DbA.eli.DbA dbA : eli.Os()) {
                if (this.aGH.equals(dbA.eli().eli())) {
                    dbA.Os();
                }
            }
            for (com.bytedance.sdk.component.DbA.eli.DbA dbA2 : eli.aGH()) {
                if (this.aGH.equals(dbA2.eli().eli())) {
                    dbA2.Os();
                }
            }
        }
    }

    protected void eli(nlS.eli eliVar) {
        if (eliVar != null && this.kb.size() > 0) {
            for (Map.Entry<String, String> entry : this.kb.entrySet()) {
                String key = entry.getKey();
                if (!TextUtils.isEmpty(key)) {
                    String value = entry.getValue();
                    if (value == null) {
                        value = "";
                    }
                    eliVar.DbA(key, value);
                }
            }
        }
    }

    public String aGH() {
        return this.wC;
    }
}
