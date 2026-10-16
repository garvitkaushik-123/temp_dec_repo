package com.bytedance.adsdk.DbA.eli.eli;

import com.bytedance.adsdk.DbA.Os.DbA.QX;
import com.bytedance.adsdk.DbA.eli.DbA.eli;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public class bf implements eli.InterfaceC0115eli, Os {
    private final boolean DbA;
    private final com.bytedance.adsdk.DbA.eli.DbA.eli<?, Float> MGA;
    private final List<eli.InterfaceC0115eli> Os = new ArrayList();
    private final QX.eli aGH;
    private final String eli;
    private final com.bytedance.adsdk.DbA.eli.DbA.eli<?, Float> kb;
    private final com.bytedance.adsdk.DbA.eli.DbA.eli<?, Float> ui;

    @Override // com.bytedance.adsdk.DbA.eli.eli.Os
    public void eli(List<Os> list, List<Os> list2) {
    }

    public bf(com.bytedance.adsdk.DbA.Os.Os.eli eliVar, com.bytedance.adsdk.DbA.Os.DbA.QX qx) {
        this.eli = qx.eli();
        this.DbA = qx.MGA();
        this.aGH = qx.DbA();
        com.bytedance.adsdk.DbA.eli.DbA.eli<Float, Float> eli = qx.aGH().eli();
        this.ui = eli;
        com.bytedance.adsdk.DbA.eli.DbA.eli<Float, Float> eli2 = qx.Os().eli();
        this.MGA = eli2;
        com.bytedance.adsdk.DbA.eli.DbA.eli<Float, Float> eli3 = qx.ui().eli();
        this.kb = eli3;
        eliVar.eli(eli);
        eliVar.eli(eli2);
        eliVar.eli(eli3);
        eli.eli(this);
        eli2.eli(this);
        eli3.eli(this);
    }

    @Override // com.bytedance.adsdk.DbA.eli.DbA.eli.InterfaceC0115eli
    public void eli() {
        for (int i = 0; i < this.Os.size(); i++) {
            this.Os.get(i).eli();
        }
    }

    void eli(eli.InterfaceC0115eli interfaceC0115eli) {
        this.Os.add(interfaceC0115eli);
    }

    QX.eli DbA() {
        return this.aGH;
    }

    public com.bytedance.adsdk.DbA.eli.DbA.eli<?, Float> Os() {
        return this.ui;
    }

    public com.bytedance.adsdk.DbA.eli.DbA.eli<?, Float> aGH() {
        return this.MGA;
    }

    public com.bytedance.adsdk.DbA.eli.DbA.eli<?, Float> ui() {
        return this.kb;
    }

    public boolean MGA() {
        return this.DbA;
    }
}
