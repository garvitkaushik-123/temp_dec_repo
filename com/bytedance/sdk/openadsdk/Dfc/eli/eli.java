package com.bytedance.sdk.openadsdk.Dfc.eli;

import java.math.BigDecimal;
import java.math.RoundingMode;

/* loaded from: classes3.dex */
public class eli {
    int DbA;
    String Dfc;
    float FC;
    int MGA;
    float NU;
    float Os;
    int aAs;
    float aGH;
    float aqO;
    int dV;
    float du;
    String eli;
    float kb;
    float nlS;
    int nn;
    float ui;
    float wC;
    int nGm = -1;
    String QX = "";

    public int eli() {
        return this.nGm;
    }

    public void eli(int i) {
        this.nGm = i;
    }

    public String DbA() {
        return this.QX;
    }

    public void eli(String str) {
        this.QX = str;
    }

    public String Os() {
        return this.eli;
    }

    public void DbA(String str) {
        this.eli = str;
    }

    public int aGH() {
        return this.DbA;
    }

    public void DbA(int i) {
        this.DbA = i;
    }

    public float ui() {
        return this.Os;
    }

    public void eli(float f) {
        this.Os = f;
    }

    public float MGA() {
        return this.aGH;
    }

    public void DbA(float f) {
        this.aGH = f;
    }

    public float kb() {
        return this.ui;
    }

    public void Os(float f) {
        this.ui = f;
    }

    public int wC() {
        return this.MGA;
    }

    public void Os(int i) {
        this.MGA = i;
    }

    public float FC() {
        return this.kb;
    }

    public void aGH(float f) {
        this.kb = f;
    }

    public float aAs() {
        return this.wC;
    }

    public void ui(float f) {
        this.wC = f;
    }

    public float du() {
        return this.FC;
    }

    public void MGA(float f) {
        this.FC = f;
    }

    public int nlS() {
        return this.aAs;
    }

    public void aGH(int i) {
        this.aAs = i;
    }

    public float NU() {
        return this.du;
    }

    public void kb(float f) {
        this.du = f;
    }

    public float nn() {
        return this.nlS;
    }

    public void wC(float f) {
        this.nlS = f;
    }

    public BigDecimal Dfc() {
        return new BigDecimal(this.NU).setScale(3, RoundingMode.HALF_UP);
    }

    public void FC(float f) {
        this.NU = f;
    }

    public int aqO() {
        return this.nn;
    }

    public void ui(int i) {
        this.nn = i;
    }

    public String dV() {
        return this.Dfc;
    }

    public void Os(String str) {
        this.Dfc = str;
    }

    public float nGm() {
        return this.aqO;
    }

    public void aAs(float f) {
        this.aqO = f;
    }

    public int QX() {
        return this.dV;
    }

    public void MGA(int i) {
        this.dV = i;
    }

    /* renamed from: com.bytedance.sdk.openadsdk.Dfc.eli.eli$eli, reason: collision with other inner class name */
    public static class C0156eli {
        eli eli = new eli();

        public C0156eli eli(String str) {
            this.eli.DbA(str);
            return this;
        }

        public C0156eli eli(int i) {
            this.eli.DbA(i);
            return this;
        }

        public C0156eli eli(float f) {
            this.eli.eli(f);
            return this;
        }

        public C0156eli DbA(float f) {
            this.eli.DbA(f);
            return this;
        }

        public C0156eli Os(float f) {
            this.eli.Os(f);
            return this;
        }

        public C0156eli aGH(float f) {
            this.eli.aGH(f);
            return this;
        }

        public C0156eli ui(float f) {
            this.eli.ui(f);
            return this;
        }

        public C0156eli MGA(float f) {
            this.eli.MGA(f);
            return this;
        }

        public C0156eli kb(float f) {
            this.eli.kb(f);
            return this;
        }

        public C0156eli wC(float f) {
            this.eli.wC(f);
            return this;
        }

        public C0156eli FC(float f) {
            this.eli.FC(f);
            return this;
        }

        public C0156eli DbA(int i) {
            this.eli.ui(i);
            return this;
        }

        public C0156eli DbA(String str) {
            this.eli.Os(str);
            return this;
        }

        public C0156eli aAs(float f) {
            this.eli.aAs(f);
            return this;
        }

        public C0156eli Os(int i) {
            this.eli.MGA(i);
            return this;
        }

        public eli eli() {
            return this.eli;
        }
    }
}
