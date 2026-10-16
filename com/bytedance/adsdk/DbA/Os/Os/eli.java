package com.bytedance.adsdk.DbA.Os.Os;

import android.content.Context;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import com.bytedance.adsdk.DbA.Os.DbA.nn;
import com.bytedance.adsdk.DbA.Os.DbA.wC;
import com.bytedance.adsdk.DbA.Os.Os.ui;
import com.bytedance.adsdk.DbA.eli.DbA.aqO;
import com.bytedance.adsdk.DbA.eli.DbA.eli;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes3.dex */
public abstract class eli implements eli.InterfaceC0115eli, com.bytedance.adsdk.DbA.eli.eli.ui {
    private com.bytedance.adsdk.DbA.eli.DbA.aGH CMM;
    final com.bytedance.adsdk.DbA.FC DbA;
    private final RectF Dfc;
    private final Matrix GB;
    private boolean KM;
    BlurMaskFilter MGA;
    private final Paint NU;
    final ui Os;
    private final RectF QX;
    private boolean Ue;
    private Paint VM;
    private eli Vy;
    private final String Xb;
    final aqO aGH;
    private final RectF aqO;
    private com.bytedance.adsdk.DbA.eli.DbA.wC bf;
    private final RectF dV;
    final Matrix eli;
    private eli ev;
    private List<eli> gG;
    private final RectF nGm;
    private final Paint nn;
    private float oWW;
    float ui;
    private final List<com.bytedance.adsdk.DbA.eli.DbA.eli<?, ?>> ujq;
    private final Path kb = new Path();
    private final Matrix wC = new Matrix();
    private final Matrix FC = new Matrix();
    private final Paint aAs = new com.bytedance.adsdk.DbA.eli.eli(1);
    private final Paint du = new com.bytedance.adsdk.DbA.eli.eli(1, PorterDuff.Mode.DST_IN);
    private final Paint nlS = new com.bytedance.adsdk.DbA.eli.eli(1, PorterDuff.Mode.DST_OUT);

    @Override // com.bytedance.adsdk.DbA.eli.eli.Os
    public void eli(List<com.bytedance.adsdk.DbA.eli.eli.Os> list, List<com.bytedance.adsdk.DbA.eli.eli.Os> list2) {
    }

    static eli eli(DbA dbA, ui uiVar, com.bytedance.adsdk.DbA.FC fc, com.bytedance.adsdk.DbA.kb kbVar, Context context) {
        switch (AnonymousClass2.eli[uiVar.du().ordinal()]) {
            case 1:
                return new kb(fc, uiVar, dbA, kbVar);
            case 2:
                return new DbA(fc, uiVar, kbVar.DbA(uiVar.kb()), kbVar, context);
            case 3:
                return new wC(fc, uiVar);
            case 4:
                if (eli(fc, uiVar, "text:")) {
                    return new Os(fc, uiVar, context);
                }
                if (eli(fc, uiVar, "videoview:")) {
                    return new aAs(fc, uiVar, context);
                }
                return new aGH(fc, uiVar);
            case 5:
                return new MGA(fc, uiVar);
            case 6:
                return new FC(fc, uiVar);
            default:
                new StringBuilder("Unknown layer type ").append(uiVar.du());
                return null;
        }
    }

    private static boolean eli(com.bytedance.adsdk.DbA.FC fc, ui uiVar, String str) {
        com.bytedance.adsdk.DbA.aAs MGA;
        if (fc == null || uiVar == null || str == null || (MGA = fc.MGA(uiVar.kb())) == null) {
            return false;
        }
        return str.equals(MGA.aAs());
    }

    eli(com.bytedance.adsdk.DbA.FC fc, ui uiVar) {
        com.bytedance.adsdk.DbA.eli.eli eliVar = new com.bytedance.adsdk.DbA.eli.eli(1);
        this.NU = eliVar;
        this.nn = new com.bytedance.adsdk.DbA.eli.eli(PorterDuff.Mode.CLEAR);
        this.Dfc = new RectF();
        this.aqO = new RectF();
        this.dV = new RectF();
        this.nGm = new RectF();
        this.QX = new RectF();
        this.eli = new Matrix();
        this.ujq = new ArrayList();
        this.Ue = true;
        this.ui = 0.0f;
        this.GB = new Matrix();
        this.oWW = 1.0f;
        this.DbA = fc;
        this.Os = uiVar;
        this.Xb = uiVar.MGA() + "#draw";
        if (uiVar.nlS() == ui.DbA.INVERT) {
            eliVar.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        } else {
            eliVar.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
        }
        aqO aAs = uiVar.Dfc().aAs();
        this.aGH = aAs;
        aAs.eli((eli.InterfaceC0115eli) this);
        if (uiVar.aAs() != null && !uiVar.aAs().isEmpty()) {
            com.bytedance.adsdk.DbA.eli.DbA.wC wCVar = new com.bytedance.adsdk.DbA.eli.DbA.wC(uiVar.aAs());
            this.bf = wCVar;
            Iterator<com.bytedance.adsdk.DbA.eli.DbA.eli<nn, Path>> it = wCVar.DbA().iterator();
            while (it.hasNext()) {
                it.next().eli(this);
            }
            for (com.bytedance.adsdk.DbA.eli.DbA.eli<Integer, Integer> eliVar2 : this.bf.Os()) {
                eli(eliVar2);
                eliVar2.eli(this);
            }
        }
        nlS();
    }

    void eli(boolean z) {
        if (z && this.VM == null) {
            this.VM = new com.bytedance.adsdk.DbA.eli.eli();
        }
        this.KM = z;
    }

    @Override // com.bytedance.adsdk.DbA.eli.DbA.eli.InterfaceC0115eli
    public void eli() {
        NU();
    }

    ui DbA() {
        return this.Os;
    }

    void eli(eli eliVar) {
        this.ev = eliVar;
    }

    boolean Os() {
        return this.ev != null;
    }

    void DbA(eli eliVar) {
        this.Vy = eliVar;
    }

    private void nlS() {
        if (!this.Os.aGH().isEmpty()) {
            com.bytedance.adsdk.DbA.eli.DbA.aGH agh = new com.bytedance.adsdk.DbA.eli.DbA.aGH(this.Os.aGH());
            this.CMM = agh;
            agh.eli();
            this.CMM.eli(new eli.InterfaceC0115eli() { // from class: com.bytedance.adsdk.DbA.Os.Os.eli.1
                @Override // com.bytedance.adsdk.DbA.eli.DbA.eli.InterfaceC0115eli
                public void eli() {
                    eli eliVar = eli.this;
                    eliVar.DbA(eliVar.CMM.FC() == 1.0f);
                }
            });
            DbA(this.CMM.kb().floatValue() == 1.0f);
            eli(this.CMM);
            return;
        }
        DbA(true);
    }

    private void NU() {
        this.DbA.invalidateSelf();
    }

    public void eli(com.bytedance.adsdk.DbA.eli.DbA.eli<?, ?> eliVar) {
        if (eliVar == null) {
            return;
        }
        this.ujq.add(eliVar);
    }

    public Matrix aGH() {
        return this.GB;
    }

    public String ui() {
        ui uiVar = this.Os;
        if (uiVar != null) {
            return uiVar.kb();
        }
        return null;
    }

    public void eli(RectF rectF, Matrix matrix, boolean z) {
        this.Dfc.set(0.0f, 0.0f, 0.0f, 0.0f);
        Dfc();
        this.eli.set(matrix);
        if (z) {
            List<eli> list = this.gG;
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    this.eli.preConcat(this.gG.get(size).aGH.aGH());
                }
            } else {
                eli eliVar = this.Vy;
                if (eliVar != null) {
                    this.eli.preConcat(eliVar.aGH.aGH());
                }
            }
        }
        this.eli.preConcat(this.aGH.aGH());
    }

    @Override // com.bytedance.adsdk.DbA.eli.eli.ui
    public void eli(Canvas canvas, Matrix matrix, int i) {
        Paint paint;
        Integer kb;
        com.bytedance.adsdk.DbA.ui.eli(this.Xb);
        if (!this.Ue || this.Os.CMM()) {
            com.bytedance.adsdk.DbA.ui.DbA(this.Xb);
            return;
        }
        Dfc();
        com.bytedance.adsdk.DbA.ui.eli("Layer#parentMatrix");
        this.GB.set(matrix);
        this.wC.reset();
        this.wC.set(matrix);
        for (int size = this.gG.size() - 1; size >= 0; size--) {
            this.wC.preConcat(this.gG.get(size).aGH.aGH());
        }
        com.bytedance.adsdk.DbA.ui.DbA("Layer#parentMatrix");
        com.bytedance.adsdk.DbA.eli.DbA.eli<?, Integer> eli = this.aGH.eli();
        int intValue = (int) ((((i / 255.0f) * ((eli == null || (kb = eli.kb()) == null) ? 100 : kb.intValue())) / 100.0f) * 255.0f);
        if (!Os() && !kb()) {
            this.wC.preConcat(this.aGH.aGH());
            com.bytedance.adsdk.DbA.ui.eli("Layer#drawLayer");
            DbA(canvas, this.wC, intValue);
            com.bytedance.adsdk.DbA.ui.DbA("Layer#drawLayer");
            Os(com.bytedance.adsdk.DbA.ui.DbA(this.Xb));
            return;
        }
        com.bytedance.adsdk.DbA.ui.eli("Layer#computeBounds");
        eli(this.Dfc, this.wC, false);
        DbA(this.Dfc, matrix);
        this.wC.preConcat(this.aGH.aGH());
        eli(this.Dfc, this.wC);
        this.aqO.set(0.0f, 0.0f, canvas.getWidth(), canvas.getHeight());
        canvas.getMatrix(this.FC);
        if (!this.FC.isIdentity()) {
            Matrix matrix2 = this.FC;
            matrix2.invert(matrix2);
            this.FC.mapRect(this.aqO);
        }
        if (!this.Dfc.intersect(this.aqO)) {
            this.Dfc.set(0.0f, 0.0f, 0.0f, 0.0f);
        }
        com.bytedance.adsdk.DbA.ui.DbA("Layer#computeBounds");
        if (this.Dfc.width() >= 1.0f && this.Dfc.height() >= 1.0f) {
            com.bytedance.adsdk.DbA.ui.eli("Layer#saveLayer");
            this.aAs.setAlpha(255);
            com.bytedance.adsdk.DbA.MGA.MGA.eli(canvas, this.Dfc, this.aAs);
            com.bytedance.adsdk.DbA.ui.DbA("Layer#saveLayer");
            eli(canvas);
            com.bytedance.adsdk.DbA.ui.eli("Layer#drawLayer");
            DbA(canvas, this.wC, intValue);
            com.bytedance.adsdk.DbA.ui.DbA("Layer#drawLayer");
            if (kb()) {
                eli(canvas, this.wC);
            }
            if (Os()) {
                com.bytedance.adsdk.DbA.ui.eli("Layer#drawMatte");
                com.bytedance.adsdk.DbA.ui.eli("Layer#saveLayer");
                com.bytedance.adsdk.DbA.MGA.MGA.eli(canvas, this.Dfc, this.NU, 19);
                com.bytedance.adsdk.DbA.ui.DbA("Layer#saveLayer");
                eli(canvas);
                this.ev.eli(canvas, matrix, intValue);
                com.bytedance.adsdk.DbA.ui.eli("Layer#restoreLayer");
                canvas.restore();
                com.bytedance.adsdk.DbA.ui.DbA("Layer#restoreLayer");
                com.bytedance.adsdk.DbA.ui.DbA("Layer#drawMatte");
            }
            com.bytedance.adsdk.DbA.ui.eli("Layer#restoreLayer");
            canvas.restore();
            com.bytedance.adsdk.DbA.ui.DbA("Layer#restoreLayer");
        }
        if (this.KM && (paint = this.VM) != null) {
            paint.setStyle(Paint.Style.STROKE);
            this.VM.setColor(-251901);
            this.VM.setStrokeWidth(4.0f);
            canvas.drawRect(this.Dfc, this.VM);
            this.VM.setStyle(Paint.Style.FILL);
            this.VM.setColor(1357638635);
            canvas.drawRect(this.Dfc, this.VM);
        }
        Os(com.bytedance.adsdk.DbA.ui.DbA(this.Xb));
    }

    private void Os(float f) {
        this.DbA.ujq().Os().eli(this.Os.MGA(), f);
    }

    private void eli(Canvas canvas) {
        com.bytedance.adsdk.DbA.ui.eli("Layer#clearLayer");
        canvas.drawRect(this.Dfc.left - 1.0f, this.Dfc.top - 1.0f, this.Dfc.right + 1.0f, this.Dfc.bottom + 1.0f, this.nn);
        com.bytedance.adsdk.DbA.ui.DbA("Layer#clearLayer");
    }

    private void eli(RectF rectF, Matrix matrix) {
        this.dV.set(0.0f, 0.0f, 0.0f, 0.0f);
        if (kb()) {
            int size = this.bf.eli().size();
            for (int i = 0; i < size; i++) {
                com.bytedance.adsdk.DbA.Os.DbA.wC wCVar = this.bf.eli().get(i);
                Path kb = this.bf.DbA().get(i).kb();
                if (kb != null) {
                    this.kb.set(kb);
                    this.kb.transform(matrix);
                    int i2 = AnonymousClass2.DbA[wCVar.eli().ordinal()];
                    if (i2 == 1 || i2 == 2) {
                        return;
                    }
                    if ((i2 == 3 || i2 == 4) && wCVar.aGH()) {
                        return;
                    }
                    this.kb.computeBounds(this.QX, false);
                    if (i == 0) {
                        this.dV.set(this.QX);
                    } else {
                        RectF rectF2 = this.dV;
                        rectF2.set(Math.min(rectF2.left, this.QX.left), Math.min(this.dV.top, this.QX.top), Math.max(this.dV.right, this.QX.right), Math.max(this.dV.bottom, this.QX.bottom));
                    }
                }
            }
            if (rectF.intersect(this.dV)) {
                return;
            }
            rectF.set(0.0f, 0.0f, 0.0f, 0.0f);
        }
    }

    /* renamed from: com.bytedance.adsdk.DbA.Os.Os.eli$2, reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] DbA;
        static final /* synthetic */ int[] eli;

        static {
            int[] iArr = new int[wC.eli.values().length];
            DbA = iArr;
            try {
                iArr[wC.eli.MASK_MODE_NONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                DbA[wC.eli.MASK_MODE_SUBTRACT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                DbA[wC.eli.MASK_MODE_INTERSECT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                DbA[wC.eli.MASK_MODE_ADD.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            int[] iArr2 = new int[ui.eli.values().length];
            eli = iArr2;
            try {
                iArr2[ui.eli.SHAPE.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                eli[ui.eli.PRE_COMP.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                eli[ui.eli.SOLID.ordinal()] = 3;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                eli[ui.eli.IMAGE.ordinal()] = 4;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                eli[ui.eli.NULL.ordinal()] = 5;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                eli[ui.eli.TEXT.ordinal()] = 6;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                eli[ui.eli.UNKNOWN.ordinal()] = 7;
            } catch (NoSuchFieldError unused11) {
            }
        }
    }

    private void DbA(RectF rectF, Matrix matrix) {
        if (Os() && this.Os.nlS() != ui.DbA.INVERT) {
            this.nGm.set(0.0f, 0.0f, 0.0f, 0.0f);
            this.ev.eli(this.nGm, matrix, true);
            if (rectF.intersect(this.nGm)) {
                return;
            }
            rectF.set(0.0f, 0.0f, 0.0f, 0.0f);
        }
    }

    public float MGA() {
        return this.oWW;
    }

    protected void eli(int i) {
        this.oWW = ((this.aGH.eli() != null ? this.aGH.eli().kb().intValue() : 100) / 100.0f) * (i / 255.0f);
    }

    public void DbA(Canvas canvas, Matrix matrix, int i) {
        eli(i);
    }

    private void eli(Canvas canvas, Matrix matrix) {
        com.bytedance.adsdk.DbA.ui.eli("Layer#saveLayer");
        com.bytedance.adsdk.DbA.MGA.MGA.eli(canvas, this.Dfc, this.du, 19);
        com.bytedance.adsdk.DbA.ui.DbA("Layer#saveLayer");
        for (int i = 0; i < this.bf.eli().size(); i++) {
            com.bytedance.adsdk.DbA.Os.DbA.wC wCVar = this.bf.eli().get(i);
            com.bytedance.adsdk.DbA.eli.DbA.eli<nn, Path> eliVar = this.bf.DbA().get(i);
            com.bytedance.adsdk.DbA.eli.DbA.eli<Integer, Integer> eliVar2 = this.bf.Os().get(i);
            int i2 = AnonymousClass2.DbA[wCVar.eli().ordinal()];
            if (i2 != 1) {
                if (i2 == 2) {
                    if (i == 0) {
                        this.aAs.setColor(-16777216);
                        this.aAs.setAlpha(255);
                        canvas.drawRect(this.Dfc, this.aAs);
                    }
                    if (wCVar.aGH()) {
                        Os(canvas, matrix, eliVar, eliVar2);
                    } else {
                        eli(canvas, matrix, eliVar);
                    }
                } else if (i2 != 3) {
                    if (i2 == 4) {
                        if (wCVar.aGH()) {
                            DbA(canvas, matrix, eliVar, eliVar2);
                        } else {
                            eli(canvas, matrix, eliVar, eliVar2);
                        }
                    }
                } else if (wCVar.aGH()) {
                    ui(canvas, matrix, eliVar, eliVar2);
                } else {
                    aGH(canvas, matrix, eliVar, eliVar2);
                }
            } else if (nn()) {
                this.aAs.setAlpha(255);
                canvas.drawRect(this.Dfc, this.aAs);
            }
        }
        com.bytedance.adsdk.DbA.ui.eli("Layer#restoreLayer");
        canvas.restore();
        com.bytedance.adsdk.DbA.ui.DbA("Layer#restoreLayer");
    }

    private boolean nn() {
        if (this.bf.DbA().isEmpty()) {
            return false;
        }
        for (int i = 0; i < this.bf.eli().size(); i++) {
            if (this.bf.eli().get(i).eli() != wC.eli.MASK_MODE_NONE) {
                return false;
            }
        }
        return true;
    }

    private void eli(Canvas canvas, Matrix matrix, com.bytedance.adsdk.DbA.eli.DbA.eli<nn, Path> eliVar, com.bytedance.adsdk.DbA.eli.DbA.eli<Integer, Integer> eliVar2) {
        this.kb.set(eliVar.kb());
        this.kb.transform(matrix);
        this.aAs.setAlpha((int) (eliVar2.kb().intValue() * 2.55f));
        canvas.drawPath(this.kb, this.aAs);
    }

    private void DbA(Canvas canvas, Matrix matrix, com.bytedance.adsdk.DbA.eli.DbA.eli<nn, Path> eliVar, com.bytedance.adsdk.DbA.eli.DbA.eli<Integer, Integer> eliVar2) {
        com.bytedance.adsdk.DbA.MGA.MGA.eli(canvas, this.Dfc, this.aAs);
        canvas.drawRect(this.Dfc, this.aAs);
        this.kb.set(eliVar.kb());
        this.kb.transform(matrix);
        this.aAs.setAlpha((int) (eliVar2.kb().intValue() * 2.55f));
        canvas.drawPath(this.kb, this.nlS);
        canvas.restore();
    }

    private void eli(Canvas canvas, Matrix matrix, com.bytedance.adsdk.DbA.eli.DbA.eli<nn, Path> eliVar) {
        this.kb.set(eliVar.kb());
        this.kb.transform(matrix);
        canvas.drawPath(this.kb, this.nlS);
    }

    private void Os(Canvas canvas, Matrix matrix, com.bytedance.adsdk.DbA.eli.DbA.eli<nn, Path> eliVar, com.bytedance.adsdk.DbA.eli.DbA.eli<Integer, Integer> eliVar2) {
        com.bytedance.adsdk.DbA.MGA.MGA.eli(canvas, this.Dfc, this.nlS);
        canvas.drawRect(this.Dfc, this.aAs);
        this.nlS.setAlpha((int) (eliVar2.kb().intValue() * 2.55f));
        this.kb.set(eliVar.kb());
        this.kb.transform(matrix);
        canvas.drawPath(this.kb, this.nlS);
        canvas.restore();
    }

    private void aGH(Canvas canvas, Matrix matrix, com.bytedance.adsdk.DbA.eli.DbA.eli<nn, Path> eliVar, com.bytedance.adsdk.DbA.eli.DbA.eli<Integer, Integer> eliVar2) {
        com.bytedance.adsdk.DbA.MGA.MGA.eli(canvas, this.Dfc, this.du);
        this.kb.set(eliVar.kb());
        this.kb.transform(matrix);
        this.aAs.setAlpha((int) (eliVar2.kb().intValue() * 2.55f));
        canvas.drawPath(this.kb, this.aAs);
        canvas.restore();
    }

    private void ui(Canvas canvas, Matrix matrix, com.bytedance.adsdk.DbA.eli.DbA.eli<nn, Path> eliVar, com.bytedance.adsdk.DbA.eli.DbA.eli<Integer, Integer> eliVar2) {
        com.bytedance.adsdk.DbA.MGA.MGA.eli(canvas, this.Dfc, this.du);
        canvas.drawRect(this.Dfc, this.aAs);
        this.nlS.setAlpha((int) (eliVar2.kb().intValue() * 2.55f));
        this.kb.set(eliVar.kb());
        this.kb.transform(matrix);
        canvas.drawPath(this.kb, this.nlS);
        canvas.restore();
    }

    boolean kb() {
        com.bytedance.adsdk.DbA.eli.DbA.wC wCVar = this.bf;
        return (wCVar == null || wCVar.DbA().isEmpty()) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void DbA(boolean z) {
        if (z != this.Ue) {
            this.Ue = z;
            NU();
        }
    }

    public boolean wC() {
        return this.Ue;
    }

    void eli(float f) {
        this.aGH.eli(f);
        if (this.bf != null) {
            for (int i = 0; i < this.bf.DbA().size(); i++) {
                this.bf.DbA().get(i).eli(f);
            }
        }
        com.bytedance.adsdk.DbA.eli.DbA.aGH agh = this.CMM;
        if (agh != null) {
            agh.eli(f);
        }
        eli eliVar = this.ev;
        if (eliVar != null) {
            eliVar.eli(f);
        }
        for (int i2 = 0; i2 < this.ujq.size(); i2++) {
            this.ujq.get(i2).eli(f);
        }
    }

    private void Dfc() {
        if (this.gG != null) {
            return;
        }
        if (this.Vy == null) {
            this.gG = Collections.emptyList();
            return;
        }
        this.gG = new ArrayList();
        for (eli eliVar = this.Vy; eliVar != null; eliVar = eliVar.Vy) {
            this.gG.add(eliVar);
        }
    }

    public String FC() {
        return this.Os.MGA();
    }

    public com.bytedance.adsdk.DbA.Os.DbA.eli aAs() {
        return this.Os.ev();
    }

    public BlurMaskFilter DbA(float f) {
        if (this.ui == f) {
            return this.MGA;
        }
        BlurMaskFilter blurMaskFilter = new BlurMaskFilter(f / 2.0f, BlurMaskFilter.Blur.NORMAL);
        this.MGA = blurMaskFilter;
        this.ui = f;
        return blurMaskFilter;
    }

    public com.bytedance.adsdk.DbA.ui.aAs du() {
        return this.Os.Vy();
    }
}
