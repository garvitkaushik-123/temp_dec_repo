package com.bytedance.sdk.component.eli;

import android.content.Context;
import android.text.TextUtils;
import android.webkit.WebView;
import com.bytedance.sdk.component.eli.du;
import java.util.LinkedHashSet;
import java.util.Set;

/* loaded from: classes3.dex */
public class aAs {
    eli DbA;
    boolean Dfc;
    NU FC;
    boolean MGA;
    nn aAs;
    wC aGH;
    du.eli aqO;
    WebView eli;
    boolean kb;
    boolean nn;
    Context ui;
    boolean wC;
    String Os = "IESJSBridge";
    String du = "host";
    final Set<String> nlS = new LinkedHashSet();
    final Set<String> NU = new LinkedHashSet();

    aAs(WebView webView) {
        this.eli = webView;
    }

    aAs() {
    }

    public aAs eli(eli eliVar) {
        this.DbA = eliVar;
        return this;
    }

    public aAs eli(String str) {
        this.Os = str;
        return this;
    }

    public aAs eli(nlS nls) {
        this.aGH = wC.eli(nls);
        return this;
    }

    public aAs eli(boolean z) {
        this.MGA = z;
        return this;
    }

    public aAs DbA(boolean z) {
        this.kb = z;
        return this;
    }

    public aAs eli() {
        this.Dfc = true;
        return this;
    }

    public dV DbA() {
        Os();
        return new dV(this);
    }

    private void Os() {
        if ((this.eli == null && !this.nn && this.DbA == null) || ((TextUtils.isEmpty(this.Os) && this.eli != null) || this.aGH == null)) {
            throw new IllegalArgumentException("Requested arguments aren't set properly when building JsBridge.");
        }
    }
}
