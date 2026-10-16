package com.bytedance.sdk.openadsdk.core;

import android.content.Intent;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes3.dex */
public class Ue {
    private static Ue eli;
    private com.bytedance.sdk.openadsdk.eli.aGH.DbA MGA;
    private com.bytedance.sdk.openadsdk.eli.ui.eli aGH;
    private com.bytedance.sdk.openadsdk.eli.Os.DbA ui;
    private int DbA = 0;
    private Map<Integer, com.bytedance.sdk.openadsdk.core.model.eli> Os = new ConcurrentHashMap();
    private final Map<String, eli> kb = new HashMap();

    public interface eli {
        void eli();
    }

    private Ue() {
    }

    public static Ue eli() {
        if (eli == null) {
            eli = new Ue();
        }
        return eli;
    }

    public com.bytedance.sdk.openadsdk.core.model.ev eli(int i) {
        com.bytedance.sdk.openadsdk.core.model.eli remove = this.Os.remove(Integer.valueOf(i));
        if (remove != null) {
            return remove.Dfc();
        }
        return null;
    }

    public int eli(com.bytedance.sdk.openadsdk.core.model.ev evVar) {
        com.bytedance.sdk.openadsdk.core.model.eli eliVar = new com.bytedance.sdk.openadsdk.core.model.eli();
        eliVar.DbA(evVar);
        return eli(eliVar);
    }

    public com.bytedance.sdk.openadsdk.eli.ui.eli DbA() {
        return this.aGH;
    }

    public com.bytedance.sdk.openadsdk.eli.Os.DbA Os() {
        return this.ui;
    }

    public com.bytedance.sdk.openadsdk.eli.aGH.DbA aGH() {
        return this.MGA;
    }

    public void eli(com.bytedance.sdk.openadsdk.eli.Os.DbA dbA) {
        this.ui = dbA;
    }

    public void eli(com.bytedance.sdk.openadsdk.eli.ui.eli eliVar) {
        this.aGH = eliVar;
    }

    public void eli(com.bytedance.sdk.openadsdk.eli.aGH.DbA dbA) {
        this.MGA = dbA;
    }

    public void ui() {
        this.aGH = null;
        this.ui = null;
        this.MGA = null;
    }

    public int eli(com.bytedance.sdk.openadsdk.core.model.eli eliVar) {
        int i = this.DbA + 1;
        this.DbA = i;
        this.Os.put(Integer.valueOf(i), eliVar);
        return this.DbA;
    }

    public com.bytedance.sdk.openadsdk.core.model.eli DbA(int i) {
        return this.Os.remove(Integer.valueOf(i));
    }

    public void Os(int i) {
        this.Os.remove(Integer.valueOf(i));
    }

    public static int eli(Intent intent) {
        if (intent != null) {
            return intent.getIntExtra("meta_index", -1);
        }
        return -1;
    }

    public void eli(com.bytedance.sdk.openadsdk.core.model.ev evVar, eli eliVar) {
        if (evVar == null || eliVar == null) {
            return;
        }
        String aGH = aGH(evVar);
        if (TextUtils.isEmpty(aGH)) {
            return;
        }
        this.kb.put(aGH, eliVar);
    }

    private static String aGH(com.bytedance.sdk.openadsdk.core.model.ev evVar) {
        if (evVar == null) {
            return null;
        }
        String fO = evVar.fO();
        return TextUtils.isEmpty(fO) ? String.valueOf(evVar.hashCode()) : fO;
    }

    public void DbA(com.bytedance.sdk.openadsdk.core.model.ev evVar) {
        eli eliVar;
        if (evVar == null) {
            return;
        }
        String aGH = aGH(evVar);
        if (TextUtils.isEmpty(aGH) || (eliVar = this.kb.get(aGH)) == null) {
            return;
        }
        eliVar.eli();
    }

    public void Os(com.bytedance.sdk.openadsdk.core.model.ev evVar) {
        String aGH = aGH(evVar);
        if (TextUtils.isEmpty(aGH)) {
            return;
        }
        this.kb.remove(aGH);
    }
}
