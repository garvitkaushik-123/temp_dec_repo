package com.bytedance.adsdk.DbA.eli.eli;

import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RectF;
import com.bytedance.adsdk.DbA.Os.DbA.QX;
import com.bytedance.adsdk.DbA.eli.DbA.eli;
import java.util.List;

/* loaded from: classes3.dex */
public class Dfc implements eli.InterfaceC0115eli, NU, du {
    private final com.bytedance.adsdk.DbA.eli.DbA.eli<?, PointF> MGA;
    private final String Os;
    private final boolean aGH;
    private boolean du;
    private final com.bytedance.adsdk.DbA.eli.DbA.eli<?, PointF> kb;
    private final com.bytedance.adsdk.DbA.FC ui;
    private final com.bytedance.adsdk.DbA.eli.DbA.eli<?, Float> wC;
    private final Path eli = new Path();
    private final RectF DbA = new RectF();
    private final DbA FC = new DbA();
    private com.bytedance.adsdk.DbA.eli.DbA.eli<Float, Float> aAs = null;

    public Dfc(com.bytedance.adsdk.DbA.FC fc, com.bytedance.adsdk.DbA.Os.Os.eli eliVar, com.bytedance.adsdk.DbA.Os.DbA.du duVar) {
        this.Os = duVar.eli();
        this.aGH = duVar.ui();
        this.ui = fc;
        com.bytedance.adsdk.DbA.eli.DbA.eli<PointF, PointF> eli = duVar.aGH().eli();
        this.MGA = eli;
        com.bytedance.adsdk.DbA.eli.DbA.eli<PointF, PointF> eli2 = duVar.Os().eli();
        this.kb = eli2;
        com.bytedance.adsdk.DbA.eli.DbA.eli<Float, Float> eli3 = duVar.DbA().eli();
        this.wC = eli3;
        eliVar.eli(eli);
        eliVar.eli(eli2);
        eliVar.eli(eli3);
        eli.eli(this);
        eli2.eli(this);
        eli3.eli(this);
    }

    @Override // com.bytedance.adsdk.DbA.eli.DbA.eli.InterfaceC0115eli
    public void eli() {
        DbA();
    }

    private void DbA() {
        this.du = false;
        this.ui.invalidateSelf();
    }

    @Override // com.bytedance.adsdk.DbA.eli.eli.Os
    public void eli(List<Os> list, List<Os> list2) {
        for (int i = 0; i < list.size(); i++) {
            Os os = list.get(i);
            if (os instanceof bf) {
                bf bfVar = (bf) os;
                if (bfVar.DbA() == QX.eli.SIMULTANEOUSLY) {
                    this.FC.eli(bfVar);
                    bfVar.eli(this);
                }
            }
            if (os instanceof dV) {
                this.aAs = ((dV) os).DbA();
            }
        }
    }

    @Override // com.bytedance.adsdk.DbA.eli.eli.NU
    public Path aGH() {
        com.bytedance.adsdk.DbA.eli.DbA.eli<Float, Float> eliVar;
        if (this.du) {
            return this.eli;
        }
        this.eli.reset();
        if (this.aGH) {
            this.du = true;
            return this.eli;
        }
        PointF kb = this.kb.kb();
        float f = kb.x / 2.0f;
        float f2 = kb.y / 2.0f;
        com.bytedance.adsdk.DbA.eli.DbA.eli<?, Float> eliVar2 = this.wC;
        float FC = eliVar2 == null ? 0.0f : ((com.bytedance.adsdk.DbA.eli.DbA.aGH) eliVar2).FC();
        if (FC == 0.0f && (eliVar = this.aAs) != null) {
            FC = Math.min(eliVar.kb().floatValue(), Math.min(f, f2));
        }
        float min = Math.min(f, f2);
        if (FC > min) {
            FC = min;
        }
        PointF kb2 = this.MGA.kb();
        this.eli.moveTo(kb2.x + f, (kb2.y - f2) + FC);
        this.eli.lineTo(kb2.x + f, (kb2.y + f2) - FC);
        if (FC > 0.0f) {
            float f3 = FC * 2.0f;
            this.DbA.set((kb2.x + f) - f3, (kb2.y + f2) - f3, kb2.x + f, kb2.y + f2);
            this.eli.arcTo(this.DbA, 0.0f, 90.0f, false);
        }
        this.eli.lineTo((kb2.x - f) + FC, kb2.y + f2);
        if (FC > 0.0f) {
            float f4 = FC * 2.0f;
            this.DbA.set(kb2.x - f, (kb2.y + f2) - f4, (kb2.x - f) + f4, kb2.y + f2);
            this.eli.arcTo(this.DbA, 90.0f, 90.0f, false);
        }
        this.eli.lineTo(kb2.x - f, (kb2.y - f2) + FC);
        if (FC > 0.0f) {
            float f5 = FC * 2.0f;
            this.DbA.set(kb2.x - f, kb2.y - f2, (kb2.x - f) + f5, (kb2.y - f2) + f5);
            this.eli.arcTo(this.DbA, 180.0f, 90.0f, false);
        }
        this.eli.lineTo((kb2.x + f) - FC, kb2.y - f2);
        if (FC > 0.0f) {
            float f6 = FC * 2.0f;
            this.DbA.set((kb2.x + f) - f6, kb2.y - f2, kb2.x + f, (kb2.y - f2) + f6);
            this.eli.arcTo(this.DbA, 270.0f, 90.0f, false);
        }
        this.eli.close();
        this.FC.eli(this.eli);
        this.du = true;
        return this.eli;
    }
}
