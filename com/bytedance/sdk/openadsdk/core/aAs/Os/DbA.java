package com.bytedance.sdk.openadsdk.core.aAs.Os;

import android.content.Context;
import android.view.View;
import com.bytedance.sdk.openadsdk.core.model.dV;
import com.bytedance.sdk.openadsdk.core.model.ev;
import com.bytedance.sdk.openadsdk.core.qj;
import com.bytedance.sdk.openadsdk.core.wC.Dfc;

/* loaded from: classes3.dex */
public class DbA {
    private Context DbA;
    private ev Os;
    private com.bytedance.sdk.openadsdk.core.aAs.Os.eli aGH;
    private Os eli;

    public DbA(Context context, ev evVar) {
        this.DbA = context;
        this.Os = evVar;
    }

    public void eli(Dfc dfc) {
        Os eli2 = eli.eli(this.DbA, this.Os);
        this.eli = eli2;
        if (eli2 != null) {
            eli2.eli();
            this.eli.eli(dfc);
        }
    }

    public void eli(com.bytedance.sdk.openadsdk.core.aAs.Os.eli eliVar) {
        this.aGH = eliVar;
        Os os = this.eli;
        if (os != null) {
            os.eli(eliVar);
        }
    }

    public void eli(int i) {
        qj ui;
        Os os = this.eli;
        if (!(os instanceof aGH) || (ui = ((aGH) os).ui()) == null || ui.eli() == null) {
            return;
        }
        ui.eli().eli(i);
    }

    public void eli() {
        Os os = this.eli;
        if (os != null) {
            os.DbA();
        }
    }

    public View DbA() {
        Os os = this.eli;
        if (os != null) {
            return os.aGH();
        }
        return null;
    }

    public void Os() {
        Os os = this.eli;
        if (os != null) {
            os.Os();
        }
    }

    public static class eli {
        public static Os eli(Context context, ev evVar) {
            if (dV.eli(evVar)) {
                return new aGH(context, evVar);
            }
            return null;
        }
    }
}
