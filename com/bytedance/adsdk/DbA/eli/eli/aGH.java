package com.bytedance.adsdk.DbA.eli.eli;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import com.bytedance.adsdk.DbA.eli.DbA.eli;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public class aGH implements eli.InterfaceC0115eli, NU, ui {
    private final RectF DbA;
    private final com.bytedance.adsdk.DbA.FC FC;
    private final String MGA;
    private final Matrix Os;
    private List<NU> aAs;
    private final Path aGH;
    private com.bytedance.adsdk.DbA.eli.DbA.aqO du;
    private final Paint eli;
    private final boolean kb;
    private final RectF ui;
    private final List<Os> wC;

    private static List<Os> eli(com.bytedance.adsdk.DbA.FC fc, com.bytedance.adsdk.DbA.kb kbVar, com.bytedance.adsdk.DbA.Os.Os.eli eliVar, List<com.bytedance.adsdk.DbA.Os.DbA.Os> list) {
        ArrayList arrayList = new ArrayList(list.size());
        for (int i = 0; i < list.size(); i++) {
            Os eli = list.get(i).eli(fc, kbVar, eliVar);
            if (eli != null) {
                arrayList.add(eli);
            }
        }
        return arrayList;
    }

    static com.bytedance.adsdk.DbA.Os.eli.nlS eli(List<com.bytedance.adsdk.DbA.Os.DbA.Os> list) {
        for (int i = 0; i < list.size(); i++) {
            com.bytedance.adsdk.DbA.Os.DbA.Os os = list.get(i);
            if (os instanceof com.bytedance.adsdk.DbA.Os.eli.nlS) {
                return (com.bytedance.adsdk.DbA.Os.eli.nlS) os;
            }
        }
        return null;
    }

    public aGH(com.bytedance.adsdk.DbA.FC fc, com.bytedance.adsdk.DbA.Os.Os.eli eliVar, com.bytedance.adsdk.DbA.Os.DbA.aqO aqo, com.bytedance.adsdk.DbA.kb kbVar) {
        this(fc, eliVar, aqo.eli(), aqo.Os(), eli(fc, kbVar, eliVar, aqo.DbA()), eli(aqo.DbA()));
    }

    aGH(com.bytedance.adsdk.DbA.FC fc, com.bytedance.adsdk.DbA.Os.Os.eli eliVar, String str, boolean z, List<Os> list, com.bytedance.adsdk.DbA.Os.eli.nlS nls) {
        this.eli = new com.bytedance.adsdk.DbA.eli.eli();
        this.DbA = new RectF();
        this.Os = new Matrix();
        this.aGH = new Path();
        this.ui = new RectF();
        this.MGA = str;
        this.FC = fc;
        this.kb = z;
        this.wC = list;
        if (nls != null) {
            com.bytedance.adsdk.DbA.eli.DbA.aqO aAs = nls.aAs();
            this.du = aAs;
            aAs.eli(eliVar);
            this.du.eli(this);
        }
        ArrayList arrayList = new ArrayList();
        for (int size = list.size() - 1; size >= 0; size--) {
            Os os = list.get(size);
            if (os instanceof aAs) {
                arrayList.add((aAs) os);
            }
        }
        for (int size2 = arrayList.size() - 1; size2 >= 0; size2--) {
            ((aAs) arrayList.get(size2)).eli(list.listIterator(list.size()));
        }
    }

    @Override // com.bytedance.adsdk.DbA.eli.DbA.eli.InterfaceC0115eli
    public void eli() {
        this.FC.invalidateSelf();
    }

    @Override // com.bytedance.adsdk.DbA.eli.eli.Os
    public void eli(List<Os> list, List<Os> list2) {
        ArrayList arrayList = new ArrayList(list.size() + this.wC.size());
        arrayList.addAll(list);
        for (int size = this.wC.size() - 1; size >= 0; size--) {
            Os os = this.wC.get(size);
            os.eli(arrayList, this.wC.subList(0, size));
            arrayList.add(os);
        }
    }

    List<NU> DbA() {
        if (this.aAs == null) {
            this.aAs = new ArrayList();
            for (int i = 0; i < this.wC.size(); i++) {
                Os os = this.wC.get(i);
                if (os instanceof NU) {
                    this.aAs.add((NU) os);
                }
            }
        }
        return this.aAs;
    }

    Matrix Os() {
        com.bytedance.adsdk.DbA.eli.DbA.aqO aqo = this.du;
        if (aqo != null) {
            return aqo.aGH();
        }
        this.Os.reset();
        return this.Os;
    }

    @Override // com.bytedance.adsdk.DbA.eli.eli.NU
    public Path aGH() {
        this.Os.reset();
        com.bytedance.adsdk.DbA.eli.DbA.aqO aqo = this.du;
        if (aqo != null) {
            this.Os.set(aqo.aGH());
        }
        this.aGH.reset();
        if (this.kb) {
            return this.aGH;
        }
        for (int size = this.wC.size() - 1; size >= 0; size--) {
            Os os = this.wC.get(size);
            if (os instanceof NU) {
                this.aGH.addPath(((NU) os).aGH(), this.Os);
            }
        }
        return this.aGH;
    }

    @Override // com.bytedance.adsdk.DbA.eli.eli.ui
    public void eli(Canvas canvas, Matrix matrix, int i) {
        if (this.kb) {
            return;
        }
        this.Os.set(matrix);
        com.bytedance.adsdk.DbA.eli.DbA.aqO aqo = this.du;
        if (aqo != null) {
            this.Os.preConcat(aqo.aGH());
            i = (int) (((((this.du.eli() == null ? 100 : this.du.eli().kb().intValue()) / 100.0f) * i) / 255.0f) * 255.0f);
        }
        boolean z = this.FC.FC() && ui() && i != 255;
        if (z) {
            this.DbA.set(0.0f, 0.0f, 0.0f, 0.0f);
            eli(this.DbA, this.Os, true);
            this.eli.setAlpha(i);
            com.bytedance.adsdk.DbA.MGA.MGA.eli(canvas, this.DbA, this.eli);
        }
        if (z) {
            i = 255;
        }
        for (int size = this.wC.size() - 1; size >= 0; size--) {
            Os os = this.wC.get(size);
            if (os instanceof ui) {
                ((ui) os).eli(canvas, this.Os, i);
            }
        }
        if (z) {
            canvas.restore();
        }
    }

    private boolean ui() {
        int i = 0;
        for (int i2 = 0; i2 < this.wC.size(); i2++) {
            if ((this.wC.get(i2) instanceof ui) && (i = i + 1) >= 2) {
                return true;
            }
        }
        return false;
    }

    @Override // com.bytedance.adsdk.DbA.eli.eli.ui
    public void eli(RectF rectF, Matrix matrix, boolean z) {
        this.Os.set(matrix);
        com.bytedance.adsdk.DbA.eli.DbA.aqO aqo = this.du;
        if (aqo != null) {
            this.Os.preConcat(aqo.aGH());
        }
        this.ui.set(0.0f, 0.0f, 0.0f, 0.0f);
        for (int size = this.wC.size() - 1; size >= 0; size--) {
            Os os = this.wC.get(size);
            if (os instanceof ui) {
                ((ui) os).eli(this.ui, this.Os, z);
                rectF.union(this.ui);
            }
        }
    }
}
