package com.bytedance.adsdk.ugeno.ui;

import android.view.View;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public class Os {
    int Dfc;
    int FC;
    int MGA;
    int NU;
    float aAs;
    int aqO;
    boolean dV;
    float du;
    int kb;
    boolean nGm;
    int nlS;
    int ui;
    int wC;
    int eli = Integer.MAX_VALUE;
    int DbA = Integer.MAX_VALUE;
    int Os = Integer.MIN_VALUE;
    int aGH = Integer.MIN_VALUE;
    List<Integer> nn = new ArrayList();

    Os() {
    }

    public int eli() {
        return this.kb;
    }

    public int DbA() {
        return this.wC - this.FC;
    }

    void eli(View view, int i, int i2, int i3, int i4) {
        DbA dbA = (DbA) view.getLayoutParams();
        this.eli = Math.min(this.eli, (view.getLeft() - dbA.NU()) - i);
        this.DbA = Math.min(this.DbA, (view.getTop() - dbA.nn()) - i2);
        this.Os = Math.max(this.Os, view.getRight() + dbA.Dfc() + i3);
        this.aGH = Math.max(this.aGH, view.getBottom() + dbA.aqO() + i4);
    }
}
