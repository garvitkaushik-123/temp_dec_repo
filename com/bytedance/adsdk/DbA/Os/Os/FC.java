package com.bytedance.adsdk.DbA.Os.Os;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.util.LongSparseArray;
import com.bytedance.adsdk.DbA.Os.DbA;
import com.bytedance.adsdk.DbA.Os.DbA.aqO;
import com.bytedance.adsdk.DbA.Os.eli.du;
import com.bytedance.adsdk.DbA.Xb;
import com.bytedance.adsdk.DbA.eli.DbA.Dfc;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes3.dex */
public class FC extends com.bytedance.adsdk.DbA.Os.Os.eli {
    private com.bytedance.adsdk.DbA.eli.DbA.eli<Float, Float> CMM;
    private final Dfc Dfc;
    private final Matrix FC;
    private final LongSparseArray<String> NU;
    private com.bytedance.adsdk.DbA.eli.DbA.eli<Integer, Integer> QX;
    private com.bytedance.adsdk.DbA.eli.DbA.eli<Typeface, Typeface> Ue;
    private com.bytedance.adsdk.DbA.eli.DbA.eli<Float, Float> Vy;
    private com.bytedance.adsdk.DbA.eli.DbA.eli<Integer, Integer> Xb;
    private final Paint aAs;
    private final com.bytedance.adsdk.DbA.FC aqO;
    private com.bytedance.adsdk.DbA.eli.DbA.eli<Integer, Integer> bf;
    private final com.bytedance.adsdk.DbA.kb dV;
    private final Paint du;
    private com.bytedance.adsdk.DbA.eli.DbA.eli<Float, Float> ev;
    private com.bytedance.adsdk.DbA.eli.DbA.eli<Float, Float> gG;
    private final StringBuilder kb;
    private com.bytedance.adsdk.DbA.eli.DbA.eli<Integer, Integer> nGm;
    private final Map<com.bytedance.adsdk.DbA.Os.aGH, List<com.bytedance.adsdk.DbA.eli.eli.aGH>> nlS;
    private final List<eli> nn;
    private com.bytedance.adsdk.DbA.eli.DbA.eli<Float, Float> ujq;
    private final RectF wC;

    FC(com.bytedance.adsdk.DbA.FC fc, ui uiVar) {
        super(fc, uiVar);
        this.kb = new StringBuilder(2);
        this.wC = new RectF();
        this.FC = new Matrix();
        int i = 1;
        this.aAs = new Paint(i) { // from class: com.bytedance.adsdk.DbA.Os.Os.FC.1
            {
                setStyle(Paint.Style.FILL);
            }
        };
        this.du = new Paint(i) { // from class: com.bytedance.adsdk.DbA.Os.Os.FC.2
            {
                setStyle(Paint.Style.STROKE);
            }
        };
        this.nlS = new HashMap();
        this.NU = new LongSparseArray<>();
        this.nn = new ArrayList();
        this.aqO = fc;
        this.dV = uiVar.eli();
        Dfc eli2 = uiVar.QX().eli();
        this.Dfc = eli2;
        eli2.eli(this);
        eli(eli2);
        du Xb = uiVar.Xb();
        if (Xb != null && Xb.eli != null) {
            com.bytedance.adsdk.DbA.eli.DbA.eli<Integer, Integer> eli3 = Xb.eli.eli();
            this.nGm = eli3;
            eli3.eli(this);
            eli(this.nGm);
        }
        if (Xb != null && Xb.DbA != null) {
            com.bytedance.adsdk.DbA.eli.DbA.eli<Integer, Integer> eli4 = Xb.DbA.eli();
            this.Xb = eli4;
            eli4.eli(this);
            eli(this.Xb);
        }
        if (Xb != null && Xb.Os != null) {
            com.bytedance.adsdk.DbA.eli.DbA.eli<Float, Float> eli5 = Xb.Os.eli();
            this.CMM = eli5;
            eli5.eli(this);
            eli(this.CMM);
        }
        if (Xb == null || Xb.aGH == null) {
            return;
        }
        com.bytedance.adsdk.DbA.eli.DbA.eli<Float, Float> eli6 = Xb.aGH.eli();
        this.Vy = eli6;
        eli6.eli(this);
        eli(this.Vy);
    }

    @Override // com.bytedance.adsdk.DbA.Os.Os.eli, com.bytedance.adsdk.DbA.eli.eli.ui
    public void eli(RectF rectF, Matrix matrix, boolean z) {
        super.eli(rectF, matrix, z);
        rectF.set(0.0f, 0.0f, this.dV.aGH().width(), this.dV.aGH().height());
    }

    @Override // com.bytedance.adsdk.DbA.Os.Os.eli
    public void DbA(Canvas canvas, Matrix matrix, int i) {
        super.DbA(canvas, matrix, i);
        com.bytedance.adsdk.DbA.Os.DbA kb = this.Dfc.kb();
        com.bytedance.adsdk.DbA.Os.Os os = this.dV.Dfc().get(kb.DbA);
        if (os == null) {
            return;
        }
        canvas.save();
        canvas.concat(matrix);
        eli(kb, matrix);
        if (this.aqO.gG()) {
            eli(kb, matrix, os, canvas);
        } else {
            eli(kb, os, canvas);
        }
        canvas.restore();
    }

    private void eli(com.bytedance.adsdk.DbA.Os.DbA dbA, Matrix matrix) {
        com.bytedance.adsdk.DbA.eli.DbA.eli<Integer, Integer> eliVar = this.QX;
        if (eliVar != null) {
            this.aAs.setColor(eliVar.kb().intValue());
        } else {
            com.bytedance.adsdk.DbA.eli.DbA.eli<Integer, Integer> eliVar2 = this.nGm;
            if (eliVar2 != null) {
                this.aAs.setColor(eliVar2.kb().intValue());
            } else {
                this.aAs.setColor(dbA.wC);
            }
        }
        com.bytedance.adsdk.DbA.eli.DbA.eli<Integer, Integer> eliVar3 = this.bf;
        if (eliVar3 != null) {
            this.du.setColor(eliVar3.kb().intValue());
        } else {
            com.bytedance.adsdk.DbA.eli.DbA.eli<Integer, Integer> eliVar4 = this.Xb;
            if (eliVar4 != null) {
                this.du.setColor(eliVar4.kb().intValue());
            } else {
                this.du.setColor(dbA.FC);
            }
        }
        int intValue = ((this.aGH.eli() == null ? 100 : this.aGH.eli().kb().intValue()) * 255) / 100;
        this.aAs.setAlpha(intValue);
        this.du.setAlpha(intValue);
        com.bytedance.adsdk.DbA.eli.DbA.eli<Float, Float> eliVar5 = this.ev;
        if (eliVar5 != null) {
            this.du.setStrokeWidth(eliVar5.kb().floatValue());
            return;
        }
        com.bytedance.adsdk.DbA.eli.DbA.eli<Float, Float> eliVar6 = this.CMM;
        if (eliVar6 != null) {
            this.du.setStrokeWidth(eliVar6.kb().floatValue());
        } else {
            this.du.setStrokeWidth(dbA.aAs * com.bytedance.adsdk.DbA.MGA.MGA.eli());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0053  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void eli(com.bytedance.adsdk.DbA.Os.DbA dbA, Matrix matrix, com.bytedance.adsdk.DbA.Os.Os os, Canvas canvas) {
        float f;
        float floatValue;
        int i;
        FC fc = this;
        com.bytedance.adsdk.DbA.Os.DbA dbA2 = dbA;
        com.bytedance.adsdk.DbA.eli.DbA.eli<Float, Float> eliVar = fc.ujq;
        if (eliVar != null) {
            f = eliVar.kb().floatValue();
        } else {
            f = dbA2.Os;
        }
        float f2 = f / 100.0f;
        float eli2 = com.bytedance.adsdk.DbA.MGA.MGA.eli(matrix);
        List<String> eli3 = fc.eli(dbA2.eli);
        int size = eli3.size();
        float f3 = dbA2.ui / 10.0f;
        com.bytedance.adsdk.DbA.eli.DbA.eli<Float, Float> eliVar2 = fc.gG;
        if (eliVar2 != null) {
            floatValue = eliVar2.kb().floatValue();
        } else {
            com.bytedance.adsdk.DbA.eli.DbA.eli<Float, Float> eliVar3 = fc.Vy;
            if (eliVar3 != null) {
                floatValue = eliVar3.kb().floatValue();
            }
            float f4 = f3;
            int i2 = -1;
            i = 0;
            while (i < size) {
                List<eli> eli4 = fc.eli(eli3.get(i), dbA2.NU == null ? 0.0f : dbA2.NU.x, os, f2, f4, true);
                int i3 = 0;
                while (i3 < eli4.size()) {
                    eli eliVar4 = eli4.get(i3);
                    i2++;
                    canvas.save();
                    fc.eli(canvas, dbA2, i2, eliVar4.DbA);
                    float f5 = f2;
                    com.bytedance.adsdk.DbA.Os.DbA dbA3 = dbA2;
                    float f6 = f4;
                    fc.eli(eliVar4.eli, dbA3, os, canvas, eli2, f5, f6);
                    f2 = f5;
                    canvas.restore();
                    i3++;
                    fc = this;
                    f4 = f6;
                    dbA2 = dbA;
                }
                i++;
                fc = this;
                f4 = f4;
                dbA2 = dbA;
            }
        }
        f3 += floatValue;
        float f42 = f3;
        int i22 = -1;
        i = 0;
        while (i < size) {
        }
    }

    private void eli(String str, com.bytedance.adsdk.DbA.Os.DbA dbA, com.bytedance.adsdk.DbA.Os.Os os, Canvas canvas, float f, float f2, float f3) {
        for (int i = 0; i < str.length(); i++) {
            com.bytedance.adsdk.DbA.Os.aGH agh = this.dV.nn().get(com.bytedance.adsdk.DbA.Os.aGH.eli(str.charAt(i), os.eli(), os.Os()));
            if (agh != null) {
                eli(agh, f2, dbA, canvas);
                canvas.translate((((float) agh.DbA()) * f2 * com.bytedance.adsdk.DbA.MGA.MGA.eli()) + f3, 0.0f);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x008e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void eli(com.bytedance.adsdk.DbA.Os.DbA dbA, com.bytedance.adsdk.DbA.Os.Os os, Canvas canvas) {
        float f;
        float floatValue;
        int size;
        int i;
        Typeface eli2 = eli(os);
        if (eli2 != null) {
            String str = dbA.eli;
            Xb Vy = this.aqO.Vy();
            if (Vy != null) {
                str = Vy.DbA(FC(), str);
            }
            this.aAs.setTypeface(eli2);
            com.bytedance.adsdk.DbA.eli.DbA.eli<Float, Float> eliVar = this.ujq;
            if (eliVar != null) {
                f = eliVar.kb().floatValue();
            } else {
                f = dbA.Os;
            }
            this.aAs.setTextSize(com.bytedance.adsdk.DbA.MGA.MGA.eli() * f);
            this.du.setTypeface(this.aAs.getTypeface());
            this.du.setTextSize(this.aAs.getTextSize());
            float f2 = dbA.ui / 10.0f;
            com.bytedance.adsdk.DbA.eli.DbA.eli<Float, Float> eliVar2 = this.gG;
            if (eliVar2 != null) {
                floatValue = eliVar2.kb().floatValue();
            } else {
                com.bytedance.adsdk.DbA.eli.DbA.eli<Float, Float> eliVar3 = this.Vy;
                if (eliVar3 != null) {
                    floatValue = eliVar3.kb().floatValue();
                }
                float eli3 = ((f2 * com.bytedance.adsdk.DbA.MGA.MGA.eli()) * f) / 100.0f;
                List<String> eli4 = eli(str);
                size = eli4.size();
                i = 0;
                int i2 = -1;
                while (i < size) {
                    com.bytedance.adsdk.DbA.Os.Os os2 = os;
                    List<eli> eli5 = eli(eli4.get(i), dbA.NU == null ? 0.0f : dbA.NU.x, os2, 0.0f, eli3, false);
                    for (int i3 = 0; i3 < eli5.size(); i3++) {
                        eli eliVar4 = eli5.get(i3);
                        i2++;
                        canvas.save();
                        eli(canvas, dbA, i2, eliVar4.DbA);
                        eli(eliVar4.eli, dbA, canvas, eli3);
                        canvas.restore();
                    }
                    i++;
                    os = os2;
                }
            }
            f2 += floatValue;
            float eli32 = ((f2 * com.bytedance.adsdk.DbA.MGA.MGA.eli()) * f) / 100.0f;
            List<String> eli42 = eli(str);
            size = eli42.size();
            i = 0;
            int i22 = -1;
            while (i < size) {
            }
        }
    }

    private void eli(Canvas canvas, com.bytedance.adsdk.DbA.Os.DbA dbA, int i, float f) {
        PointF pointF = dbA.nlS;
        PointF pointF2 = dbA.NU;
        float eli2 = com.bytedance.adsdk.DbA.MGA.MGA.eli();
        float f2 = (i * dbA.MGA * eli2) + (pointF == null ? 0.0f : (dbA.MGA * 0.6f * eli2) + pointF.y);
        float f3 = pointF == null ? 0.0f : pointF.x;
        float f4 = pointF2 != null ? pointF2.x : 0.0f;
        int i2 = AnonymousClass3.eli[dbA.aGH.ordinal()];
        if (i2 == 1) {
            canvas.translate(f3, f2);
        } else if (i2 == 2) {
            canvas.translate((f3 + f4) - f, f2);
        } else {
            if (i2 != 3) {
                return;
            }
            canvas.translate((f3 + (f4 / 2.0f)) - (f / 2.0f), f2);
        }
    }

    /* renamed from: com.bytedance.adsdk.DbA.Os.Os.FC$3, reason: invalid class name */
    static /* synthetic */ class AnonymousClass3 {
        static final /* synthetic */ int[] eli;

        static {
            int[] iArr = new int[DbA.eli.values().length];
            eli = iArr;
            try {
                iArr[DbA.eli.LEFT_ALIGN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                eli[DbA.eli.RIGHT_ALIGN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                eli[DbA.eli.CENTER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    private Typeface eli(com.bytedance.adsdk.DbA.Os.Os os) {
        Typeface kb;
        com.bytedance.adsdk.DbA.eli.DbA.eli<Typeface, Typeface> eliVar = this.Ue;
        if (eliVar != null && (kb = eliVar.kb()) != null) {
            return kb;
        }
        Typeface eli2 = this.aqO.eli(os);
        return eli2 != null ? eli2 : os.aGH();
    }

    private List<String> eli(String str) {
        return Arrays.asList(str.replaceAll("\r\n", "\r").replaceAll("\u0003", "\r").replaceAll("\n", "\r").split("\r"));
    }

    private void eli(String str, com.bytedance.adsdk.DbA.Os.DbA dbA, Canvas canvas, float f) {
        int i = 0;
        while (i < str.length()) {
            String eli2 = eli(str, i);
            i += eli2.length();
            eli(eli2, dbA, canvas);
            canvas.translate(this.aAs.measureText(eli2) + f, 0.0f);
        }
    }

    private List<eli> eli(String str, float f, com.bytedance.adsdk.DbA.Os.Os os, float f2, float f3, boolean z) {
        float measureText;
        int i = 0;
        int i2 = 0;
        boolean z2 = false;
        int i3 = 0;
        float f4 = 0.0f;
        float f5 = 0.0f;
        float f6 = 0.0f;
        for (int i4 = 0; i4 < str.length(); i4++) {
            char charAt = str.charAt(i4);
            if (z) {
                com.bytedance.adsdk.DbA.Os.aGH agh = this.dV.nn().get(com.bytedance.adsdk.DbA.Os.aGH.eli(charAt, os.eli(), os.Os()));
                if (agh != null) {
                    measureText = ((float) agh.DbA()) * f2 * com.bytedance.adsdk.DbA.MGA.MGA.eli();
                }
            } else {
                measureText = this.aAs.measureText(str.substring(i4, i4 + 1));
            }
            float f7 = measureText + f3;
            if (charAt == ' ') {
                z2 = true;
                f6 = f7;
            } else if (z2) {
                z2 = false;
                i3 = i4;
                f5 = f7;
            } else {
                f5 += f7;
            }
            f4 += f7;
            if (f > 0.0f && f4 >= f && charAt != ' ') {
                i++;
                eli DbA = DbA(i);
                if (i3 == i2) {
                    DbA.eli(str.substring(i2, i4).trim(), (f4 - f7) - ((r9.length() - r7.length()) * f6));
                    i2 = i4;
                    i3 = i2;
                    f4 = f7;
                    f5 = f4;
                } else {
                    DbA.eli(str.substring(i2, i3 - 1).trim(), ((f4 - f5) - ((r7.length() - r13.length()) * f6)) - f6);
                    f4 = f5;
                    i2 = i3;
                }
            }
        }
        if (f4 > 0.0f) {
            i++;
            DbA(i).eli(str.substring(i2), f4);
        }
        return this.nn.subList(0, i);
    }

    private eli DbA(int i) {
        for (int size = this.nn.size(); size < i; size++) {
            this.nn.add(new eli());
        }
        return this.nn.get(i - 1);
    }

    private void eli(com.bytedance.adsdk.DbA.Os.aGH agh, float f, com.bytedance.adsdk.DbA.Os.DbA dbA, Canvas canvas) {
        List<com.bytedance.adsdk.DbA.eli.eli.aGH> eli2 = eli(agh);
        for (int i = 0; i < eli2.size(); i++) {
            Path aGH = eli2.get(i).aGH();
            aGH.computeBounds(this.wC, false);
            this.FC.reset();
            this.FC.preTranslate(0.0f, (-dbA.kb) * com.bytedance.adsdk.DbA.MGA.MGA.eli());
            this.FC.preScale(f, f);
            aGH.transform(this.FC);
            if (dbA.du) {
                eli(aGH, this.aAs, canvas);
                eli(aGH, this.du, canvas);
            } else {
                eli(aGH, this.du, canvas);
                eli(aGH, this.aAs, canvas);
            }
        }
    }

    private void eli(Path path, Paint paint, Canvas canvas) {
        if (paint.getColor() == 0) {
            return;
        }
        if (paint.getStyle() == Paint.Style.STROKE && paint.getStrokeWidth() == 0.0f) {
            return;
        }
        canvas.drawPath(path, paint);
    }

    private void eli(String str, com.bytedance.adsdk.DbA.Os.DbA dbA, Canvas canvas) {
        if (dbA.du) {
            eli(str, this.aAs, canvas);
            eli(str, this.du, canvas);
        } else {
            eli(str, this.du, canvas);
            eli(str, this.aAs, canvas);
        }
    }

    private void eli(String str, Paint paint, Canvas canvas) {
        if (paint.getColor() == 0) {
            return;
        }
        if (paint.getStyle() == Paint.Style.STROKE && paint.getStrokeWidth() == 0.0f) {
            return;
        }
        canvas.drawText(str, 0, str.length(), 0.0f, 0.0f, paint);
    }

    private List<com.bytedance.adsdk.DbA.eli.eli.aGH> eli(com.bytedance.adsdk.DbA.Os.aGH agh) {
        if (this.nlS.containsKey(agh)) {
            return this.nlS.get(agh);
        }
        List<aqO> eli2 = agh.eli();
        int size = eli2.size();
        ArrayList arrayList = new ArrayList(size);
        for (int i = 0; i < size; i++) {
            arrayList.add(new com.bytedance.adsdk.DbA.eli.eli.aGH(this.aqO, this, eli2.get(i), this.dV));
        }
        this.nlS.put(agh, arrayList);
        return arrayList;
    }

    private String eli(String str, int i) {
        int codePointAt = str.codePointAt(i);
        int charCount = Character.charCount(codePointAt) + i;
        while (charCount < str.length()) {
            int codePointAt2 = str.codePointAt(charCount);
            if (!Os(codePointAt2)) {
                break;
            }
            charCount += Character.charCount(codePointAt2);
            codePointAt = (codePointAt * 31) + codePointAt2;
        }
        long j = codePointAt;
        if (this.NU.indexOfKey(j) >= 0) {
            return this.NU.get(j);
        }
        this.kb.setLength(0);
        while (i < charCount) {
            int codePointAt3 = str.codePointAt(i);
            this.kb.appendCodePoint(codePointAt3);
            i += Character.charCount(codePointAt3);
        }
        String sb = this.kb.toString();
        this.NU.put(j, sb);
        return sb;
    }

    private boolean Os(int i) {
        return Character.getType(i) == 16 || Character.getType(i) == 27 || Character.getType(i) == 6 || Character.getType(i) == 28 || Character.getType(i) == 8 || Character.getType(i) == 19;
    }

    private static class eli {
        private float DbA;
        private String eli;

        private eli() {
            this.eli = "";
            this.DbA = 0.0f;
        }

        void eli(String str, float f) {
            this.eli = str;
            this.DbA = f;
        }
    }
}
