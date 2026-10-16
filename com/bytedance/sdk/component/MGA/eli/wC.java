package com.bytedance.sdk.component.MGA.eli;

import android.content.Context;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes3.dex */
public class wC {
    private static wC NU;
    private static volatile com.bytedance.sdk.component.MGA.eli.ui.eli aAs;
    private volatile com.bytedance.sdk.component.MGA.eli.aGH.DbA.eli DbA;
    private long Dfc;
    private volatile ui FC;
    private volatile com.bytedance.sdk.component.MGA.eli.aGH.DbA.eli MGA;
    private volatile com.bytedance.sdk.component.MGA.eli.aGH.DbA.eli Os;
    private volatile com.bytedance.sdk.component.MGA.eli.aGH.DbA.eli aGH;
    private volatile com.bytedance.sdk.component.MGA.eli.DbA.Os du;
    private volatile Context eli;
    private volatile com.bytedance.sdk.component.MGA.eli.eli.ui kb;
    private volatile Map<Integer, com.bytedance.sdk.component.MGA.eli.DbA.Os> nlS;
    private final AtomicBoolean nn = new AtomicBoolean(false);
    private volatile com.bytedance.sdk.component.MGA.eli.aGH.DbA.eli ui;
    private volatile boolean wC;

    public boolean eli() {
        return this.nn.get();
    }

    public void eli(boolean z) {
        this.nn.set(z);
    }

    public boolean DbA() {
        return this.wC;
    }

    public void DbA(boolean z) {
        this.wC = z;
    }

    public Map<Integer, com.bytedance.sdk.component.MGA.eli.DbA.Os> Os() {
        return this.nlS;
    }

    public com.bytedance.sdk.component.MGA.eli.eli.ui aGH() {
        return this.kb;
    }

    public static com.bytedance.sdk.component.MGA.eli.ui.eli ui() {
        if (aAs == null) {
            synchronized (wC.class) {
                if (aAs == null) {
                    aAs = new com.bytedance.sdk.component.MGA.eli.ui.DbA();
                }
            }
        }
        return aAs;
    }

    public void eli(com.bytedance.sdk.component.MGA.eli.eli.ui uiVar) {
        this.kb = uiVar;
    }

    public Context MGA() {
        return this.eli;
    }

    public void eli(Context context) {
        this.eli = context;
    }

    private wC() {
    }

    public static synchronized wC kb() {
        wC wCVar;
        synchronized (wC.class) {
            if (NU == null) {
                NU = new wC();
            }
            wCVar = NU;
        }
        return wCVar;
    }

    public void eli(com.bytedance.sdk.component.MGA.eli.DbA.Os os) {
        this.du = os;
    }

    public com.bytedance.sdk.component.MGA.eli.DbA.Os wC() {
        return this.du;
    }

    public void FC() {
        com.bytedance.sdk.component.MGA.eli.DbA.aGH.eli.DbA();
    }

    public com.bytedance.sdk.component.MGA.eli.aGH.DbA.eli aAs() {
        return this.MGA;
    }

    public void eli(com.bytedance.sdk.component.MGA.eli.aGH.DbA.eli eliVar) {
        this.MGA = eliVar;
    }

    public void du() {
        com.bytedance.sdk.component.MGA.eli.DbA.aGH.eli.Os();
    }

    public void eli(com.bytedance.sdk.component.MGA.eli.aGH.eli eliVar) {
        if (eliVar == null) {
            return;
        }
        eliVar.eli(System.currentTimeMillis());
        com.bytedance.sdk.component.MGA.eli.DbA.aGH.eli.eli(eliVar, eliVar.aGH());
    }

    public void eli(String str, boolean z) {
        com.bytedance.sdk.component.MGA.eli.MGA.eli.eli().eli(str, z);
    }

    public void eli(String str, List<String> list, boolean z, Map<String, String> map, int i, String str2) {
        com.bytedance.sdk.component.MGA.eli.MGA.eli.eli().eli(str, list, z, map, i, str2);
    }

    public void DbA(com.bytedance.sdk.component.MGA.eli.aGH.DbA.eli eliVar) {
        this.DbA = eliVar;
    }

    public com.bytedance.sdk.component.MGA.eli.aGH.DbA.eli nlS() {
        return this.DbA;
    }

    public void Os(com.bytedance.sdk.component.MGA.eli.aGH.DbA.eli eliVar) {
        this.Os = eliVar;
    }

    public com.bytedance.sdk.component.MGA.eli.aGH.DbA.eli NU() {
        return this.Os;
    }

    public void aGH(com.bytedance.sdk.component.MGA.eli.aGH.DbA.eli eliVar) {
        this.aGH = eliVar;
    }

    public com.bytedance.sdk.component.MGA.eli.aGH.DbA.eli nn() {
        return this.aGH;
    }

    public com.bytedance.sdk.component.MGA.eli.aGH.DbA.eli Dfc() {
        return this.ui;
    }

    public void ui(com.bytedance.sdk.component.MGA.eli.aGH.DbA.eli eliVar) {
        this.ui = eliVar;
    }

    public void eli(ui uiVar) {
        this.FC = uiVar;
    }

    public ui aqO() {
        return this.FC;
    }

    public void eli(long j) {
        this.Dfc = j;
    }

    public long dV() {
        return this.Dfc * 86400000;
    }
}
