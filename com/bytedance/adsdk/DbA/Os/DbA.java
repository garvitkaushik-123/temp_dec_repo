package com.bytedance.adsdk.DbA.Os;

import android.graphics.PointF;

/* loaded from: classes3.dex */
public class DbA {
    public String DbA;
    public int FC;
    public float MGA;
    public PointF NU;
    public float Os;
    public float aAs;
    public eli aGH;
    public boolean du;
    public String eli;
    public float kb;
    public PointF nlS;
    public int ui;
    public int wC;

    public enum eli {
        LEFT_ALIGN,
        RIGHT_ALIGN,
        CENTER
    }

    public DbA(String str, String str2, float f, eli eliVar, int i, float f2, float f3, int i2, int i3, float f4, boolean z, PointF pointF, PointF pointF2) {
        eli(str, str2, f, eliVar, i, f2, f3, i2, i3, f4, z, pointF, pointF2);
    }

    public DbA() {
    }

    public void eli(String str, String str2, float f, eli eliVar, int i, float f2, float f3, int i2, int i3, float f4, boolean z, PointF pointF, PointF pointF2) {
        this.eli = str;
        this.DbA = str2;
        this.Os = f;
        this.aGH = eliVar;
        this.ui = i;
        this.MGA = f2;
        this.kb = f3;
        this.wC = i2;
        this.FC = i3;
        this.aAs = f4;
        this.du = z;
        this.nlS = pointF;
        this.NU = pointF2;
    }

    public int hashCode() {
        int hashCode = (((((int) ((((this.eli.hashCode() * 31) + this.DbA.hashCode()) * 31) + this.Os)) * 31) + this.aGH.ordinal()) * 31) + this.ui;
        long floatToRawIntBits = Float.floatToRawIntBits(this.MGA);
        return (((hashCode * 31) + ((int) (floatToRawIntBits ^ (floatToRawIntBits >>> 32)))) * 31) + this.wC;
    }
}
