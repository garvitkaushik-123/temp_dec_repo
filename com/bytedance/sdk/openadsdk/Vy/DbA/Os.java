package com.bytedance.sdk.openadsdk.Vy.DbA;

import android.view.View;
import com.bytedance.sdk.openadsdk.Vy.DbA.ui;
import com.bytedance.sdk.openadsdk.core.model.ev;

/* loaded from: classes3.dex */
public class Os extends DbA {
    private int aGH;

    @Override // com.bytedance.sdk.openadsdk.Vy.DbA.DbA
    protected void DbA(int i) {
    }

    public Os(Integer num, View view, ev evVar, ui.eli eliVar) {
        super(num, view, evVar, 1000, eliVar);
        this.aGH = -1;
        DbA(view);
    }

    @Override // com.bytedance.sdk.openadsdk.Vy.DbA.DbA
    protected boolean Os() {
        if (this.eli == null || this.eli.get() == null) {
            return false;
        }
        View view = this.eli.get();
        if (this.aGH == -1) {
            DbA(view);
        }
        return MGA.eli(view, this.aGH == 1, this.DbA.bBQ());
    }

    private void DbA(View view) {
        if (view != null) {
            int width = view.getWidth();
            int height = view.getHeight();
            if (width <= 0 || height <= 0) {
                return;
            }
            this.aGH = width * height >= 242500 ? 1 : 0;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.Vy.DbA.DbA
    protected void aGH() {
        super.aGH();
    }

    @Override // com.bytedance.sdk.openadsdk.Vy.DbA.DbA
    public int MGA() {
        return (this.DbA != null && this.DbA.dZ() && this.DbA.cK() == 1) ? 1000 : 100;
    }
}
