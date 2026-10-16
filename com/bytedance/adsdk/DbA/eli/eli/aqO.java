package com.bytedance.adsdk.DbA.eli.eli;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.RectF;
import com.bytedance.adsdk.DbA.eli.DbA.eli;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;

/* loaded from: classes3.dex */
public class aqO implements eli.InterfaceC0115eli, NU, aAs, du, ui {
    private final com.bytedance.adsdk.DbA.eli.DbA.aqO FC;
    private final boolean MGA;
    private final com.bytedance.adsdk.DbA.FC Os;
    private aGH aAs;
    private final com.bytedance.adsdk.DbA.Os.Os.eli aGH;
    private final com.bytedance.adsdk.DbA.eli.DbA.eli<Float, Float> kb;
    private final String ui;
    private final com.bytedance.adsdk.DbA.eli.DbA.eli<Float, Float> wC;
    private final Matrix eli = new Matrix();
    private final Path DbA = new Path();

    public aqO(com.bytedance.adsdk.DbA.FC fc, com.bytedance.adsdk.DbA.Os.Os.eli eliVar, com.bytedance.adsdk.DbA.Os.DbA.nlS nls) {
        this.Os = fc;
        this.aGH = eliVar;
        this.ui = nls.eli();
        this.MGA = nls.ui();
        com.bytedance.adsdk.DbA.eli.DbA.eli<Float, Float> eli = nls.DbA().eli();
        this.kb = eli;
        eliVar.eli(eli);
        eli.eli(this);
        com.bytedance.adsdk.DbA.eli.DbA.eli<Float, Float> eli2 = nls.Os().eli();
        this.wC = eli2;
        eliVar.eli(eli2);
        eli2.eli(this);
        com.bytedance.adsdk.DbA.eli.DbA.aqO aAs = nls.aGH().aAs();
        this.FC = aAs;
        aAs.eli(eliVar);
        aAs.eli(this);
    }

    @Override // com.bytedance.adsdk.DbA.eli.eli.aAs
    public void eli(ListIterator<Os> listIterator) {
        if (this.aAs != null) {
            return;
        }
        while (listIterator.hasPrevious() && listIterator.previous() != this) {
        }
        ArrayList arrayList = new ArrayList();
        while (listIterator.hasPrevious()) {
            arrayList.add(listIterator.previous());
            listIterator.remove();
        }
        Collections.reverse(arrayList);
        this.aAs = new aGH(this.Os, this.aGH, "Repeater", this.MGA, arrayList, null);
    }

    @Override // com.bytedance.adsdk.DbA.eli.eli.Os
    public void eli(List<Os> list, List<Os> list2) {
        this.aAs.eli(list, list2);
    }

    @Override // com.bytedance.adsdk.DbA.eli.eli.NU
    public Path aGH() {
        Path aGH = this.aAs.aGH();
        this.DbA.reset();
        float floatValue = this.kb.kb().floatValue();
        float floatValue2 = this.wC.kb().floatValue();
        for (int i = ((int) floatValue) - 1; i >= 0; i--) {
            this.eli.set(this.FC.DbA(i + floatValue2));
            this.DbA.addPath(aGH, this.eli);
        }
        return this.DbA;
    }

    @Override // com.bytedance.adsdk.DbA.eli.eli.ui
    public void eli(Canvas canvas, Matrix matrix, int i) {
        float floatValue = this.kb.kb().floatValue();
        float floatValue2 = this.wC.kb().floatValue();
        float floatValue3 = this.FC.DbA().kb().floatValue() / 100.0f;
        float floatValue4 = this.FC.Os().kb().floatValue() / 100.0f;
        for (int i2 = ((int) floatValue) - 1; i2 >= 0; i2--) {
            this.eli.set(matrix);
            float f = i2;
            this.eli.preConcat(this.FC.DbA(f + floatValue2));
            this.aAs.eli(canvas, this.eli, (int) (i * com.bytedance.adsdk.DbA.MGA.ui.eli(floatValue3, floatValue4, f / floatValue)));
        }
    }

    @Override // com.bytedance.adsdk.DbA.eli.eli.ui
    public void eli(RectF rectF, Matrix matrix, boolean z) {
        this.aAs.eli(rectF, matrix, z);
    }

    @Override // com.bytedance.adsdk.DbA.eli.DbA.eli.InterfaceC0115eli
    public void eli() {
        this.Os.invalidateSelf();
    }
}
