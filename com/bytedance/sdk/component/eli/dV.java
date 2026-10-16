package com.bytedance.sdk.component.eli;

import android.webkit.WebView;
import com.bytedance.sdk.component.eli.aGH;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes3.dex */
public class dV {
    static CMM eli;
    private final eli DbA;
    private volatile boolean MGA;
    private final WebView Os;
    private final aAs aGH;
    private final List<nn> ui;

    public static aAs eli(WebView webView) {
        return new aAs(webView);
    }

    public dV eli(String str, ui<?, ?> uiVar) {
        return eli(str, (String) null, uiVar);
    }

    public dV eli(String str, String str2, ui<?, ?> uiVar) {
        DbA();
        this.DbA.kb.eli(str, uiVar);
        return this;
    }

    public dV eli(String str, aGH.DbA dbA) {
        return eli(str, (String) null, dbA);
    }

    public dV eli(String str, String str2, aGH.DbA dbA) {
        DbA();
        this.DbA.kb.eli(str, dbA);
        return this;
    }

    public void eli() {
        if (this.MGA) {
            return;
        }
        this.DbA.DbA();
        this.MGA = true;
        Iterator<nn> it = this.ui.iterator();
        while (it.hasNext()) {
            it.next();
        }
    }

    dV(aAs aas) {
        ArrayList arrayList = new ArrayList();
        this.ui = arrayList;
        this.MGA = false;
        this.aGH = aas;
        if (aas.wC && eli != null) {
            throw null;
        }
        if (aas.eli != null) {
            if (aas.DbA == null) {
                this.DbA = new gG();
            } else {
                this.DbA = aas.DbA;
            }
        } else {
            this.DbA = aas.DbA;
        }
        this.DbA.eli(aas, (bf) null);
        this.Os = aas.eli;
        arrayList.add(aas.aAs);
        Vy.eli(aas.kb);
    }

    private void DbA() {
        if (this.MGA) {
            FC.eli(new IllegalStateException("JsBridge2 is already released!!!"));
        }
    }
}
