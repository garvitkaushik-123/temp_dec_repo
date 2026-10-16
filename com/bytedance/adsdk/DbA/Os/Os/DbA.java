package com.bytedance.adsdk.DbA.Os.Os;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.LongSparseArray;
import com.bytedance.adsdk.DbA.Os.Os.ui;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes3.dex */
public class DbA extends eli {
    private final RectF FC;
    private final RectF aAs;
    private final Paint du;
    private com.bytedance.adsdk.DbA.eli.DbA.eli<Float, Float> kb;
    private boolean nlS;
    private final List<eli> wC;

    public DbA(com.bytedance.adsdk.DbA.FC fc, ui uiVar, List<ui> list, com.bytedance.adsdk.DbA.kb kbVar, Context context) {
        super(fc, uiVar);
        int i;
        eli eliVar;
        ui.DbA nlS;
        int i2;
        this.wC = new ArrayList();
        this.FC = new RectF();
        this.aAs = new RectF();
        this.du = new Paint();
        this.nlS = true;
        com.bytedance.adsdk.DbA.Os.eli.DbA bf = uiVar.bf();
        if (bf != null) {
            com.bytedance.adsdk.DbA.eli.DbA.eli<Float, Float> eli = bf.eli();
            this.kb = eli;
            eli(eli);
            this.kb.eli(this);
        } else {
            this.kb = null;
        }
        LongSparseArray longSparseArray = new LongSparseArray(kbVar.NU().size());
        int size = list.size() - 1;
        eli eliVar2 = null;
        while (true) {
            if (size < 0) {
                break;
            }
            ui uiVar2 = list.get(size);
            eli eli2 = eli.eli(this, uiVar2, fc, kbVar, context);
            if (eli2 != null) {
                longSparseArray.put(eli2.DbA().ui(), eli2);
                if (eliVar2 != null) {
                    eliVar2.eli(eli2);
                    eliVar2 = null;
                } else {
                    this.wC.add(0, eli2);
                    if (uiVar2 != null && (nlS = uiVar2.nlS()) != null && ((i2 = AnonymousClass1.eli[nlS.ordinal()]) == 1 || i2 == 2)) {
                        eliVar2 = eli2;
                    }
                }
            }
            size--;
        }
        for (i = 0; i < longSparseArray.size(); i++) {
            eli eliVar3 = (eli) longSparseArray.get(longSparseArray.keyAt(i));
            if (eliVar3 != null && (eliVar = (eli) longSparseArray.get(eliVar3.DbA().NU())) != null) {
                eliVar3.DbA(eliVar);
            }
        }
    }

    /* renamed from: com.bytedance.adsdk.DbA.Os.Os.DbA$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] eli;

        static {
            int[] iArr = new int[ui.DbA.values().length];
            eli = iArr;
            try {
                iArr[ui.DbA.ADD.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                eli[ui.DbA.INVERT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public void DbA(boolean z) {
        this.nlS = z;
    }

    @Override // com.bytedance.adsdk.DbA.Os.Os.eli
    public void eli(boolean z) {
        super.eli(z);
        Iterator<eli> it = this.wC.iterator();
        while (it.hasNext()) {
            it.next().eli(z);
        }
    }

    @Override // com.bytedance.adsdk.DbA.Os.Os.eli
    public void DbA(Canvas canvas, Matrix matrix, int i) {
        super.DbA(canvas, matrix, i);
        com.bytedance.adsdk.DbA.ui.eli("CompositionLayer#draw");
        this.aAs.set(0.0f, 0.0f, this.Os.wC(), this.Os.FC());
        matrix.mapRect(this.aAs);
        boolean z = this.DbA.FC() && this.wC.size() > 1 && i != 255;
        if (z) {
            this.du.setAlpha(i);
            com.bytedance.adsdk.DbA.MGA.MGA.eli(canvas, this.aAs, this.du);
        } else {
            canvas.save();
        }
        if (z) {
            i = 255;
        }
        for (int size = this.wC.size() - 1; size >= 0; size--) {
            if (((this.nlS || !"__container".equals(this.Os.MGA())) && !this.aAs.isEmpty()) ? canvas.clipRect(this.aAs) : true) {
                this.wC.get(size).eli(canvas, matrix, i);
            }
        }
        canvas.restore();
        com.bytedance.adsdk.DbA.ui.DbA("CompositionLayer#draw");
    }

    @Override // com.bytedance.adsdk.DbA.Os.Os.eli, com.bytedance.adsdk.DbA.eli.eli.ui
    public void eli(RectF rectF, Matrix matrix, boolean z) {
        super.eli(rectF, matrix, z);
        for (int size = this.wC.size() - 1; size >= 0; size--) {
            this.FC.set(0.0f, 0.0f, 0.0f, 0.0f);
            this.wC.get(size).eli(this.FC, this.eli, true);
            rectF.union(this.FC);
        }
    }

    public List<eli> nlS() {
        return this.wC;
    }

    @Override // com.bytedance.adsdk.DbA.Os.Os.eli
    public void eli(float f) {
        super.eli(f);
        if (this.kb != null) {
            f = ((this.kb.kb().floatValue() * this.Os.eli().nlS()) - this.Os.eli().MGA()) / (this.DbA.ujq().dV() + 0.01f);
        }
        if (this.kb == null) {
            f -= this.Os.Os();
        }
        if (this.Os.DbA() != 0.0f && !"__container".equals(this.Os.MGA())) {
            f /= this.Os.DbA();
        }
        for (int size = this.wC.size() - 1; size >= 0; size--) {
            this.wC.get(size).eli(f);
        }
    }
}
