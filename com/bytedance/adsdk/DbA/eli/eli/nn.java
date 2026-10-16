package com.bytedance.adsdk.DbA.eli.eli;

import android.graphics.Path;
import android.graphics.PointF;
import com.bytedance.adsdk.DbA.Os.DbA.QX;
import com.bytedance.adsdk.DbA.Os.DbA.aAs;
import com.bytedance.adsdk.DbA.eli.DbA.eli;
import java.util.List;

/* loaded from: classes3.dex */
public class nn implements eli.InterfaceC0115eli, NU, du {
    private final String DbA;
    private boolean Dfc;
    private final com.bytedance.adsdk.DbA.eli.DbA.eli<?, Float> FC;
    private final boolean MGA;
    private final com.bytedance.adsdk.DbA.eli.DbA.eli<?, Float> NU;
    private final com.bytedance.adsdk.DbA.FC Os;
    private final com.bytedance.adsdk.DbA.eli.DbA.eli<?, Float> aAs;
    private final aAs.eli aGH;
    private final com.bytedance.adsdk.DbA.eli.DbA.eli<?, Float> du;
    private final com.bytedance.adsdk.DbA.eli.DbA.eli<?, Float> kb;
    private final com.bytedance.adsdk.DbA.eli.DbA.eli<?, Float> nlS;
    private final boolean ui;
    private final com.bytedance.adsdk.DbA.eli.DbA.eli<?, PointF> wC;
    private final Path eli = new Path();
    private final DbA nn = new DbA();

    public nn(com.bytedance.adsdk.DbA.FC fc, com.bytedance.adsdk.DbA.Os.Os.eli eliVar, com.bytedance.adsdk.DbA.Os.DbA.aAs aas) {
        this.Os = fc;
        this.DbA = aas.eli();
        aAs.eli DbA = aas.DbA();
        this.aGH = DbA;
        this.ui = aas.aAs();
        this.MGA = aas.du();
        com.bytedance.adsdk.DbA.eli.DbA.eli<Float, Float> eli = aas.Os().eli();
        this.kb = eli;
        com.bytedance.adsdk.DbA.eli.DbA.eli<PointF, PointF> eli2 = aas.aGH().eli();
        this.wC = eli2;
        com.bytedance.adsdk.DbA.eli.DbA.eli<Float, Float> eli3 = aas.ui().eli();
        this.FC = eli3;
        com.bytedance.adsdk.DbA.eli.DbA.eli<Float, Float> eli4 = aas.kb().eli();
        this.du = eli4;
        com.bytedance.adsdk.DbA.eli.DbA.eli<Float, Float> eli5 = aas.FC().eli();
        this.NU = eli5;
        if (DbA == aAs.eli.STAR) {
            this.aAs = aas.MGA().eli();
            this.nlS = aas.wC().eli();
        } else {
            this.aAs = null;
            this.nlS = null;
        }
        eliVar.eli(eli);
        eliVar.eli(eli2);
        eliVar.eli(eli3);
        eliVar.eli(eli4);
        eliVar.eli(eli5);
        if (DbA == aAs.eli.STAR) {
            eliVar.eli(this.aAs);
            eliVar.eli(this.nlS);
        }
        eli.eli(this);
        eli2.eli(this);
        eli3.eli(this);
        eli4.eli(this);
        eli5.eli(this);
        if (DbA == aAs.eli.STAR) {
            this.aAs.eli(this);
            this.nlS.eli(this);
        }
    }

    @Override // com.bytedance.adsdk.DbA.eli.DbA.eli.InterfaceC0115eli
    public void eli() {
        DbA();
    }

    private void DbA() {
        this.Dfc = false;
        this.Os.invalidateSelf();
    }

    @Override // com.bytedance.adsdk.DbA.eli.eli.Os
    public void eli(List<Os> list, List<Os> list2) {
        for (int i = 0; i < list.size(); i++) {
            Os os = list.get(i);
            if (os instanceof bf) {
                bf bfVar = (bf) os;
                if (bfVar.DbA() == QX.eli.SIMULTANEOUSLY) {
                    this.nn.eli(bfVar);
                    bfVar.eli(this);
                }
            }
        }
    }

    @Override // com.bytedance.adsdk.DbA.eli.eli.NU
    public Path aGH() {
        if (this.Dfc) {
            return this.eli;
        }
        this.eli.reset();
        if (this.ui) {
            this.Dfc = true;
            return this.eli;
        }
        int i = AnonymousClass1.eli[this.aGH.ordinal()];
        if (i == 1) {
            Os();
        } else if (i == 2) {
            ui();
        }
        this.eli.close();
        this.nn.eli(this.eli);
        this.Dfc = true;
        return this.eli;
    }

    /* renamed from: com.bytedance.adsdk.DbA.eli.eli.nn$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] eli;

        static {
            int[] iArr = new int[aAs.eli.values().length];
            eli = iArr;
            try {
                iArr[aAs.eli.STAR.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                eli[aAs.eli.POLYGON.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    private void Os() {
        float f;
        float f2;
        int i;
        float cos;
        float sin;
        float f3;
        float f4;
        double d;
        float f5;
        int i2;
        float f6;
        double d2;
        float f7;
        float f8;
        double d3;
        float f9;
        float f10;
        float floatValue = this.kb.kb().floatValue();
        double radians = Math.toRadians((this.FC == null ? 0.0d : r2.kb().floatValue()) - 90.0d);
        double d4 = floatValue;
        float f11 = (float) (6.283185307179586d / d4);
        if (this.MGA) {
            f11 *= -1.0f;
        }
        float f12 = f11 / 2.0f;
        float f13 = floatValue - ((int) floatValue);
        int i3 = (f13 > 0.0f ? 1 : (f13 == 0.0f ? 0 : -1));
        if (i3 != 0) {
            radians += (1.0f - f13) * f12;
        }
        float floatValue2 = this.du.kb().floatValue();
        float floatValue3 = this.aAs.kb().floatValue();
        com.bytedance.adsdk.DbA.eli.DbA.eli<?, Float> eliVar = this.nlS;
        float floatValue4 = eliVar != null ? eliVar.kb().floatValue() / 100.0f : 0.0f;
        com.bytedance.adsdk.DbA.eli.DbA.eli<?, Float> eliVar2 = this.NU;
        float floatValue5 = eliVar2 != null ? eliVar2.kb().floatValue() / 100.0f : 0.0f;
        if (i3 != 0) {
            f5 = ((floatValue2 - floatValue3) * f13) + floatValue3;
            f2 = 0.0f;
            i = i3;
            double d5 = f5;
            f = 2.0f;
            float cos2 = (float) (d5 * Math.cos(radians));
            sin = (float) (d5 * Math.sin(radians));
            this.eli.moveTo(cos2, sin);
            d = radians + ((f11 * f13) / 2.0f);
            f3 = f13;
            cos = cos2;
            f4 = f12;
        } else {
            f = 2.0f;
            f2 = 0.0f;
            i = i3;
            double d6 = floatValue2;
            cos = (float) (Math.cos(radians) * d6);
            sin = (float) (d6 * Math.sin(radians));
            this.eli.moveTo(cos, sin);
            f3 = f13;
            f4 = f12;
            d = radians + f4;
            f5 = 0.0f;
        }
        double ceil = Math.ceil(d4) * 2.0d;
        int i4 = 0;
        boolean z = false;
        double d7 = d;
        float f14 = sin;
        float f15 = cos;
        double d8 = d7;
        while (true) {
            double d9 = i4;
            if (d9 < ceil) {
                float f16 = z ? floatValue2 : floatValue3;
                if (f5 == f2 || d9 != ceil - 2.0d) {
                    i2 = i4;
                    f6 = f4;
                } else {
                    i2 = i4;
                    f6 = (f11 * f3) / f;
                }
                if (f5 == f2 || d9 != ceil - 1.0d) {
                    d2 = d9;
                    f7 = f16;
                } else {
                    d2 = d9;
                    f7 = f5;
                }
                double d10 = f7;
                float cos3 = (float) (d10 * Math.cos(d8));
                float f17 = f11;
                float sin2 = (float) (d10 * Math.sin(d8));
                if (floatValue4 == f2 && floatValue5 == f2) {
                    this.eli.lineTo(cos3, sin2);
                    f10 = cos3;
                    f9 = sin2;
                    f8 = f4;
                    d3 = d8;
                } else {
                    f8 = f4;
                    d3 = d8;
                    double atan2 = (float) (Math.atan2(f14, f15) - 1.5707963267948966d);
                    float cos4 = (float) Math.cos(atan2);
                    float sin3 = (float) Math.sin(atan2);
                    float f18 = f15;
                    float f19 = f14;
                    f9 = sin2;
                    double atan22 = (float) (Math.atan2(sin2, cos3) - 1.5707963267948966d);
                    float cos5 = (float) Math.cos(atan22);
                    float sin4 = (float) Math.sin(atan22);
                    float f20 = z ? floatValue4 : floatValue5;
                    float f21 = z ? floatValue5 : floatValue4;
                    float f22 = (z ? floatValue3 : floatValue2) * f20 * 0.47829f;
                    float f23 = cos4 * f22;
                    float f24 = f22 * sin3;
                    float f25 = (z ? floatValue2 : floatValue3) * f21 * 0.47829f;
                    float f26 = cos5 * f25;
                    float f27 = f25 * sin4;
                    if (i != 0) {
                        if (i2 == 0) {
                            f23 *= f3;
                            f24 *= f3;
                        } else if (d2 == ceil - 1.0d) {
                            f26 *= f3;
                            f27 *= f3;
                        }
                    }
                    f10 = cos3;
                    this.eli.cubicTo(f18 - f23, f19 - f24, cos3 + f26, f9 + f27, f10, f9);
                }
                d8 = d3 + f6;
                z = !z;
                i4 = i2 + 1;
                f4 = f8;
                f15 = f10;
                f14 = f9;
                f11 = f17;
            } else {
                PointF kb = this.wC.kb();
                this.eli.offset(kb.x, kb.y);
                this.eli.close();
                return;
            }
        }
    }

    private void ui() {
        double d;
        int floor = (int) Math.floor(this.kb.kb().floatValue());
        double radians = Math.toRadians((this.FC == null ? 0.0d : r2.kb().floatValue()) - 90.0d);
        double d2 = floor;
        float floatValue = this.NU.kb().floatValue() / 100.0f;
        float floatValue2 = this.du.kb().floatValue();
        double d3 = floatValue2;
        float cos = (float) (Math.cos(radians) * d3);
        float sin = (float) (Math.sin(radians) * d3);
        this.eli.moveTo(cos, sin);
        double d4 = (float) (6.283185307179586d / d2);
        double d5 = radians + d4;
        double ceil = Math.ceil(d2);
        int i = 0;
        while (i < ceil) {
            float cos2 = (float) (Math.cos(d5) * d3);
            int i2 = i;
            double d6 = d5;
            float sin2 = (float) (d3 * Math.sin(d5));
            if (floatValue != 0.0f) {
                d = ceil;
                double atan2 = (float) (Math.atan2(sin, cos) - 1.5707963267948966d);
                float cos3 = (float) Math.cos(atan2);
                float sin3 = (float) Math.sin(atan2);
                double atan22 = (float) (Math.atan2(sin2, cos2) - 1.5707963267948966d);
                float f = floatValue2 * floatValue * 0.25f;
                this.eli.cubicTo(cos - (f * cos3), sin - (f * sin3), cos2 + (((float) Math.cos(atan22)) * f), sin2 + (f * ((float) Math.sin(atan22))), cos2, sin2);
                cos = cos2;
                sin = sin2;
            } else {
                sin = sin2;
                d = ceil;
                cos = cos2;
                this.eli.lineTo(cos, sin);
            }
            d5 = d6 + d4;
            i = i2 + 1;
            ceil = d;
        }
        PointF kb = this.wC.kb();
        this.eli.offset(kb.x, kb.y);
        this.eli.close();
    }
}
