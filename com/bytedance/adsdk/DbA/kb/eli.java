package com.bytedance.adsdk.DbA.kb;

import android.graphics.PointF;
import android.view.animation.Interpolator;
import com.bytedance.adsdk.DbA.kb;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* loaded from: classes3.dex */
public class eli<T> {
    public T DbA;
    private float Dfc;
    public PointF FC;
    public final float MGA;
    private int NU;
    public final Interpolator Os;
    private final kb aAs;
    public final Interpolator aGH;
    private float aqO;
    private float du;
    public final T eli;
    public Float kb;
    private float nlS;
    private int nn;
    public final Interpolator ui;
    public PointF wC;

    public eli(kb kbVar, T t, T t2, Interpolator interpolator, float f, Float f2) {
        this.du = -3987645.8f;
        this.nlS = -3987645.8f;
        this.NU = 784923401;
        this.nn = 784923401;
        this.Dfc = Float.MIN_VALUE;
        this.aqO = Float.MIN_VALUE;
        this.wC = null;
        this.FC = null;
        this.aAs = kbVar;
        this.eli = t;
        this.DbA = t2;
        this.Os = interpolator;
        this.aGH = null;
        this.ui = null;
        this.MGA = f;
        this.kb = f2;
    }

    public eli(kb kbVar, T t, T t2, Interpolator interpolator, Interpolator interpolator2, float f, Float f2) {
        this.du = -3987645.8f;
        this.nlS = -3987645.8f;
        this.NU = 784923401;
        this.nn = 784923401;
        this.Dfc = Float.MIN_VALUE;
        this.aqO = Float.MIN_VALUE;
        this.wC = null;
        this.FC = null;
        this.aAs = kbVar;
        this.eli = t;
        this.DbA = t2;
        this.Os = null;
        this.aGH = interpolator;
        this.ui = interpolator2;
        this.MGA = f;
        this.kb = f2;
    }

    protected eli(kb kbVar, T t, T t2, Interpolator interpolator, Interpolator interpolator2, Interpolator interpolator3, float f, Float f2) {
        this.du = -3987645.8f;
        this.nlS = -3987645.8f;
        this.NU = 784923401;
        this.nn = 784923401;
        this.Dfc = Float.MIN_VALUE;
        this.aqO = Float.MIN_VALUE;
        this.wC = null;
        this.FC = null;
        this.aAs = kbVar;
        this.eli = t;
        this.DbA = t2;
        this.Os = interpolator;
        this.aGH = interpolator2;
        this.ui = interpolator3;
        this.MGA = f;
        this.kb = f2;
    }

    public eli(T t) {
        this.du = -3987645.8f;
        this.nlS = -3987645.8f;
        this.NU = 784923401;
        this.nn = 784923401;
        this.Dfc = Float.MIN_VALUE;
        this.aqO = Float.MIN_VALUE;
        this.wC = null;
        this.FC = null;
        this.aAs = null;
        this.eli = t;
        this.DbA = t;
        this.Os = null;
        this.aGH = null;
        this.ui = null;
        this.MGA = Float.MIN_VALUE;
        this.kb = Float.valueOf(Float.MAX_VALUE);
    }

    private eli(T t, T t2) {
        this.du = -3987645.8f;
        this.nlS = -3987645.8f;
        this.NU = 784923401;
        this.nn = 784923401;
        this.Dfc = Float.MIN_VALUE;
        this.aqO = Float.MIN_VALUE;
        this.wC = null;
        this.FC = null;
        this.aAs = null;
        this.eli = t;
        this.DbA = t2;
        this.Os = null;
        this.aGH = null;
        this.ui = null;
        this.MGA = Float.MIN_VALUE;
        this.kb = Float.valueOf(Float.MAX_VALUE);
    }

    public eli<T> eli(T t, T t2) {
        return new eli<>(t, t2);
    }

    public float Os() {
        kb kbVar = this.aAs;
        if (kbVar == null) {
            return 0.0f;
        }
        if (this.Dfc == Float.MIN_VALUE) {
            this.Dfc = (this.MGA - kbVar.MGA()) / this.aAs.dV();
        }
        return this.Dfc;
    }

    public float aGH() {
        if (this.aAs == null) {
            return 1.0f;
        }
        if (this.aqO == Float.MIN_VALUE) {
            if (this.kb == null) {
                this.aqO = 1.0f;
            } else {
                this.aqO = Os() + ((this.kb.floatValue() - this.MGA) / this.aAs.dV());
            }
        }
        return this.aqO;
    }

    public boolean ui() {
        return this.Os == null && this.aGH == null && this.ui == null;
    }

    public boolean eli(float f) {
        return f >= Os() && f < aGH();
    }

    public float MGA() {
        if (this.du == -3987645.8f) {
            this.du = ((Float) this.eli).floatValue();
        }
        return this.du;
    }

    public float kb() {
        if (this.nlS == -3987645.8f) {
            this.nlS = ((Float) this.DbA).floatValue();
        }
        return this.nlS;
    }

    public int wC() {
        if (this.NU == 784923401) {
            this.NU = ((Integer) this.eli).intValue();
        }
        return this.NU;
    }

    public int FC() {
        if (this.nn == 784923401) {
            this.nn = ((Integer) this.DbA).intValue();
        }
        return this.nn;
    }

    public String toString() {
        return "Keyframe{startValue=" + this.eli + ", endValue=" + this.DbA + ", startFrame=" + this.MGA + ", endFrame=" + this.kb + ", interpolator=" + this.Os + AbstractJsonLexerKt.END_OBJ;
    }
}
