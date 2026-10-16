package com.bytedance.adsdk.ugeno;

import android.content.Context;
import com.bytedance.adsdk.ugeno.aGH.aAs;
import com.bytedance.adsdk.ugeno.aGH.wC;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public class ui {
    private static volatile ui eli;
    private List<com.bytedance.adsdk.ugeno.core.DbA> DbA;
    private com.bytedance.adsdk.ugeno.core.DbA.aGH MGA;
    private com.bytedance.adsdk.ugeno.core.Os Os;
    private eli aGH;
    private com.bytedance.adsdk.ugeno.core.eli.eli kb;
    private com.bytedance.adsdk.ugeno.Os.eli ui;

    public static ui eli() {
        if (eli == null) {
            synchronized (ui.class) {
                if (eli == null) {
                    eli = new ui();
                }
            }
        }
        return eli;
    }

    private ui() {
    }

    public void eli(Context context, com.bytedance.adsdk.ugeno.core.Os os, eli eliVar) {
        this.Os = os;
        this.aGH = eliVar;
        MGA();
    }

    public eli DbA() {
        return this.aGH;
    }

    private void MGA() {
        ArrayList arrayList = new ArrayList();
        this.DbA = arrayList;
        com.bytedance.adsdk.ugeno.core.Os os = this.Os;
        if (os != null) {
            arrayList.addAll(os.eli());
        }
        com.bytedance.adsdk.ugeno.core.aGH.eli(this.DbA);
    }

    public void eli(com.bytedance.adsdk.ugeno.Os.eli eliVar) {
        this.ui = eliVar;
    }

    public com.bytedance.adsdk.ugeno.Os.eli Os() {
        return this.ui;
    }

    public void eli(wC wCVar) {
        ArrayList arrayList = new ArrayList(new com.bytedance.adsdk.ugeno.aGH.eli().eli());
        if (wCVar != null) {
            arrayList.addAll(wCVar.eli());
        }
        aAs.eli(arrayList);
    }

    public void eli(com.bytedance.adsdk.ugeno.aGH.Os os) {
        ArrayList arrayList = new ArrayList(new com.bytedance.adsdk.ugeno.aGH.ui().eli());
        if (os != null) {
            arrayList.addAll(os.eli());
        }
        com.bytedance.adsdk.ugeno.aGH.aGH.eli(arrayList);
    }

    public com.bytedance.adsdk.ugeno.core.DbA.aGH aGH() {
        return this.MGA;
    }

    public com.bytedance.adsdk.ugeno.core.eli.eli ui() {
        return this.kb;
    }
}
