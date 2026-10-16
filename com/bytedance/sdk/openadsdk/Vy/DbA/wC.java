package com.bytedance.sdk.openadsdk.Vy.DbA;

import android.view.View;
import com.bytedance.sdk.openadsdk.Vy.DbA.ui;
import com.bytedance.sdk.openadsdk.core.model.ev;

/* loaded from: classes3.dex */
public class wC extends DbA {
    private int aGH;

    @Override // com.bytedance.sdk.openadsdk.Vy.DbA.DbA
    public int MGA() {
        return 200;
    }

    public wC(Integer num, View view, ev evVar, ui.eli eliVar) {
        super(num, view, evVar, 2000, eliVar);
        this.aGH = 0;
    }

    @Override // com.bytedance.sdk.openadsdk.Vy.DbA.DbA
    protected boolean Os() {
        return MGA.eli(this.eli.get(), this.DbA.bBQ()) && this.aGH == 1;
    }

    @Override // com.bytedance.sdk.openadsdk.Vy.DbA.DbA
    protected void aGH() {
        super.aGH();
    }

    @Override // com.bytedance.sdk.openadsdk.Vy.DbA.DbA
    public void eli() {
        if (this.aGH != 1) {
            return;
        }
        super.eli();
    }

    @Override // com.bytedance.sdk.openadsdk.Vy.DbA.DbA
    protected void DbA(int i) {
        if (FC()) {
            return;
        }
        if (i == 6 || i == 5) {
            this.aGH = 0;
            wC();
        }
        if (i == 3 || i == 2) {
            this.aGH = 2;
            wC();
        }
        if (this.aGH == 1 || i != 0) {
            return;
        }
        this.aGH = 1;
        eli();
    }

    @Override // com.bytedance.sdk.openadsdk.Vy.DbA.DbA
    public boolean nlS() {
        int i = this.aGH;
        boolean z = i == 2 || i == 0;
        if (z) {
            this.Os.set(false);
        }
        return !z || super.nlS();
    }
}
