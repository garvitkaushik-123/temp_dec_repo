package com.bytedance.adsdk.DbA.eli.eli;

import android.graphics.Path;
import android.graphics.PointF;
import com.bytedance.adsdk.DbA.Os.DbA.QX;
import com.bytedance.adsdk.DbA.eli.DbA.eli;
import java.util.List;

/* loaded from: classes3.dex */
public class MGA implements eli.InterfaceC0115eli, NU, du {
    private final String DbA;
    private final com.bytedance.adsdk.DbA.Os.DbA.DbA MGA;
    private final com.bytedance.adsdk.DbA.FC Os;
    private final com.bytedance.adsdk.DbA.eli.DbA.eli<?, PointF> aGH;
    private final Path eli = new Path();
    private final DbA kb = new DbA();
    private final com.bytedance.adsdk.DbA.eli.DbA.eli<?, PointF> ui;
    private boolean wC;

    public MGA(com.bytedance.adsdk.DbA.FC fc, com.bytedance.adsdk.DbA.Os.Os.eli eliVar, com.bytedance.adsdk.DbA.Os.DbA.DbA dbA) {
        this.DbA = dbA.eli();
        this.Os = fc;
        com.bytedance.adsdk.DbA.eli.DbA.eli<PointF, PointF> eli = dbA.Os().eli();
        this.aGH = eli;
        com.bytedance.adsdk.DbA.eli.DbA.eli<PointF, PointF> eli2 = dbA.DbA().eli();
        this.ui = eli2;
        this.MGA = dbA;
        eliVar.eli(eli);
        eliVar.eli(eli2);
        eli.eli(this);
        eli2.eli(this);
    }

    @Override // com.bytedance.adsdk.DbA.eli.DbA.eli.InterfaceC0115eli
    public void eli() {
        DbA();
    }

    private void DbA() {
        this.wC = false;
        this.Os.invalidateSelf();
    }

    @Override // com.bytedance.adsdk.DbA.eli.eli.Os
    public void eli(List<Os> list, List<Os> list2) {
        for (int i = 0; i < list.size(); i++) {
            Os os = list.get(i);
            if (os instanceof bf) {
                bf bfVar = (bf) os;
                if (bfVar.DbA() == QX.eli.SIMULTANEOUSLY) {
                    this.kb.eli(bfVar);
                    bfVar.eli(this);
                }
            }
        }
    }

    @Override // com.bytedance.adsdk.DbA.eli.eli.NU
    public Path aGH() {
        if (this.wC) {
            return this.eli;
        }
        this.eli.reset();
        if (this.MGA.ui()) {
            this.wC = true;
            return this.eli;
        }
        PointF kb = this.aGH.kb();
        float f = kb.x / 2.0f;
        float f2 = kb.y / 2.0f;
        float f3 = f * 0.55228f;
        float f4 = 0.55228f * f2;
        this.eli.reset();
        if (this.MGA.aGH()) {
            float f5 = -f2;
            this.eli.moveTo(0.0f, f5);
            float f6 = 0.0f - f3;
            float f7 = -f;
            float f8 = 0.0f - f4;
            this.eli.cubicTo(f6, f5, f7, f8, f7, 0.0f);
            float f9 = f4 + 0.0f;
            this.eli.cubicTo(f7, f9, f6, f2, 0.0f, f2);
            float f10 = f3 + 0.0f;
            this.eli.cubicTo(f10, f2, f, f9, f, 0.0f);
            this.eli.cubicTo(f, f8, f10, f5, 0.0f, f5);
        } else {
            float f11 = -f2;
            this.eli.moveTo(0.0f, f11);
            float f12 = f3 + 0.0f;
            float f13 = 0.0f - f4;
            this.eli.cubicTo(f12, f11, f, f13, f, 0.0f);
            float f14 = f4 + 0.0f;
            this.eli.cubicTo(f, f14, f12, f2, 0.0f, f2);
            float f15 = 0.0f - f3;
            float f16 = -f;
            this.eli.cubicTo(f15, f2, f16, f14, f16, 0.0f);
            this.eli.cubicTo(f16, f13, f15, f11, 0.0f, f11);
        }
        PointF kb2 = this.ui.kb();
        this.eli.offset(kb2.x, kb2.y);
        this.eli.close();
        this.kb.eli(this.eli);
        this.wC = true;
        return this.eli;
    }
}
