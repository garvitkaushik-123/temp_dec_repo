package com.bytedance.adsdk.DbA.eli.eli;

import android.graphics.Path;
import com.bytedance.adsdk.DbA.Os.DbA.QX;
import com.bytedance.adsdk.DbA.eli.DbA.eli;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public class nGm implements eli.InterfaceC0115eli, NU {
    private final String DbA;
    private boolean MGA;
    private final boolean Os;
    private final com.bytedance.adsdk.DbA.FC aGH;
    private final Path eli = new Path();
    private final DbA kb = new DbA();
    private final com.bytedance.adsdk.DbA.eli.DbA.NU ui;

    public nGm(com.bytedance.adsdk.DbA.FC fc, com.bytedance.adsdk.DbA.Os.Os.eli eliVar, com.bytedance.adsdk.DbA.Os.DbA.dV dVVar) {
        this.DbA = dVVar.eli();
        this.Os = dVVar.Os();
        this.aGH = fc;
        com.bytedance.adsdk.DbA.eli.DbA.NU eli = dVVar.DbA().eli();
        this.ui = eli;
        eliVar.eli(eli);
        eli.eli(this);
    }

    @Override // com.bytedance.adsdk.DbA.eli.DbA.eli.InterfaceC0115eli
    public void eli() {
        DbA();
    }

    private void DbA() {
        this.MGA = false;
        this.aGH.invalidateSelf();
    }

    @Override // com.bytedance.adsdk.DbA.eli.eli.Os
    public void eli(List<Os> list, List<Os> list2) {
        ArrayList arrayList = null;
        for (int i = 0; i < list.size(); i++) {
            Os os = list.get(i);
            if (os instanceof bf) {
                bf bfVar = (bf) os;
                if (bfVar.DbA() == QX.eli.SIMULTANEOUSLY) {
                    this.kb.eli(bfVar);
                    bfVar.eli(this);
                }
            }
            if (os instanceof QX) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add((QX) os);
            }
        }
        this.ui.eli((List<QX>) arrayList);
    }

    @Override // com.bytedance.adsdk.DbA.eli.eli.NU
    public Path aGH() {
        if (this.MGA) {
            return this.eli;
        }
        this.eli.reset();
        if (this.Os) {
            this.MGA = true;
            return this.eli;
        }
        Path kb = this.ui.kb();
        if (kb == null) {
            return this.eli;
        }
        this.eli.set(kb);
        this.eli.setFillType(Path.FillType.EVEN_ODD);
        this.kb.eli(this.eli);
        this.MGA = true;
        return this.eli;
    }
}
