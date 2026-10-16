package com.bytedance.sdk.component.adexpress.dynamic.animation.eli;

import android.view.View;
import android.view.ViewGroup;

/* loaded from: classes3.dex */
public class Os {
    private static volatile Os eli;

    private Os() {
    }

    public static Os eli() {
        if (eli == null) {
            synchronized (Os.class) {
                if (eli == null) {
                    eli = new Os();
                }
            }
        }
        return eli;
    }

    public aGH eli(View view, com.bytedance.sdk.component.adexpress.dynamic.aGH.eli eliVar) {
        if (eliVar == null) {
            return null;
        }
        if (view.getParent() != null) {
            ((ViewGroup) view.getParent()).setClipChildren(false);
        }
        if (view.getParent().getParent() != null) {
            ((ViewGroup) view.getParent().getParent()).setClipChildren(false);
        }
        if ("scale".equals(eliVar.FC())) {
            return new du(view, eliVar);
        }
        if ("translate".equals(eliVar.FC())) {
            return new Dfc(view, eliVar);
        }
        if ("ripple".equals(eliVar.FC())) {
            return new wC(view, eliVar);
        }
        if ("marquee".equals(eliVar.FC())) {
            return new kb(view, eliVar);
        }
        if ("waggle".equals(eliVar.FC())) {
            return new aqO(view, eliVar);
        }
        if ("shine".equals(eliVar.FC())) {
            return new nlS(view, eliVar);
        }
        if ("swing".equals(eliVar.FC())) {
            return new nn(view, eliVar);
        }
        if ("fade".equals(eliVar.FC())) {
            return new eli(view, eliVar);
        }
        if ("rubIn".equals(eliVar.FC())) {
            return new aAs(view, eliVar);
        }
        if ("rotate".equals(eliVar.FC())) {
            return new FC(view, eliVar);
        }
        if ("cutIn".equals(eliVar.FC())) {
            return new MGA(view, eliVar);
        }
        if ("stretch".equals(eliVar.FC())) {
            return new NU(view, eliVar);
        }
        if ("bounce".equals(eliVar.FC())) {
            return new ui(view, eliVar);
        }
        return null;
    }
}
