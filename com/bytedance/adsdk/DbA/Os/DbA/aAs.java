package com.bytedance.adsdk.DbA.Os.DbA;

import android.graphics.PointF;

/* loaded from: classes3.dex */
public class aAs implements Os {
    private final eli DbA;
    private final com.bytedance.adsdk.DbA.Os.eli.DbA FC;
    private final com.bytedance.adsdk.DbA.Os.eli.DbA MGA;
    private final com.bytedance.adsdk.DbA.Os.eli.DbA Os;
    private final boolean aAs;
    private final com.bytedance.adsdk.DbA.Os.eli.NU<PointF, PointF> aGH;
    private final boolean du;
    private final String eli;
    private final com.bytedance.adsdk.DbA.Os.eli.DbA kb;
    private final com.bytedance.adsdk.DbA.Os.eli.DbA ui;
    private final com.bytedance.adsdk.DbA.Os.eli.DbA wC;

    public enum eli {
        STAR(1),
        POLYGON(2);

        private final int Os;

        eli(int i) {
            this.Os = i;
        }

        public static eli eli(int i) {
            for (eli eliVar : values()) {
                if (eliVar.Os == i) {
                    return eliVar;
                }
            }
            return null;
        }
    }

    public aAs(String str, eli eliVar, com.bytedance.adsdk.DbA.Os.eli.DbA dbA, com.bytedance.adsdk.DbA.Os.eli.NU<PointF, PointF> nu, com.bytedance.adsdk.DbA.Os.eli.DbA dbA2, com.bytedance.adsdk.DbA.Os.eli.DbA dbA3, com.bytedance.adsdk.DbA.Os.eli.DbA dbA4, com.bytedance.adsdk.DbA.Os.eli.DbA dbA5, com.bytedance.adsdk.DbA.Os.eli.DbA dbA6, boolean z, boolean z2) {
        this.eli = str;
        this.DbA = eliVar;
        this.Os = dbA;
        this.aGH = nu;
        this.ui = dbA2;
        this.MGA = dbA3;
        this.kb = dbA4;
        this.wC = dbA5;
        this.FC = dbA6;
        this.aAs = z;
        this.du = z2;
    }

    public String eli() {
        return this.eli;
    }

    public eli DbA() {
        return this.DbA;
    }

    public com.bytedance.adsdk.DbA.Os.eli.DbA Os() {
        return this.Os;
    }

    public com.bytedance.adsdk.DbA.Os.eli.NU<PointF, PointF> aGH() {
        return this.aGH;
    }

    public com.bytedance.adsdk.DbA.Os.eli.DbA ui() {
        return this.ui;
    }

    public com.bytedance.adsdk.DbA.Os.eli.DbA MGA() {
        return this.MGA;
    }

    public com.bytedance.adsdk.DbA.Os.eli.DbA kb() {
        return this.kb;
    }

    public com.bytedance.adsdk.DbA.Os.eli.DbA wC() {
        return this.wC;
    }

    public com.bytedance.adsdk.DbA.Os.eli.DbA FC() {
        return this.FC;
    }

    public boolean aAs() {
        return this.aAs;
    }

    public boolean du() {
        return this.du;
    }

    @Override // com.bytedance.adsdk.DbA.Os.DbA.Os
    public com.bytedance.adsdk.DbA.eli.eli.Os eli(com.bytedance.adsdk.DbA.FC fc, com.bytedance.adsdk.DbA.kb kbVar, com.bytedance.adsdk.DbA.Os.Os.eli eliVar) {
        return new com.bytedance.adsdk.DbA.eli.eli.nn(fc, eliVar, this);
    }
}
